package com.cola.sakura.common.util;


/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */

public class IdGenerator {
    //开始时间戳（不能修改，会影响唯一性)
    //2020-7-1
    private static final long twepoch = 1293570344482L;
    //机器id所占位数（5）
    private static final long workerIdBits = 5L;
    //数据标识id所占位数（5）
    private static final long dataCenterIdBits = 5L;
    //支持的最大机器id（31）
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    //支持的最大数据标识Id（31）
    private static final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    //序列Id所占位数（12）
    private static final long sequenceBits = 12L;
    //机器Id左移12位
    private static final long workerIdShift = sequenceBits;
    //数据标识Id左移17（12 + 5）位
    private static final long dataCenterIdShift = sequenceBits + workerIdBits;
    //时间戳左移22(12 + 5 + 5)位
    private static final long timestampShift = sequenceBits + workerIdBits + dataCenterIdBits;
    //生成序列的掩码（0b111111111111=0xfff=4095）
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);
    //工作机器Id（0-31）
    private static long workerId = 0L;
    //数据标识Id（0-31）
    private static long dataCenterId = 0L;
    //毫秒内的序列（0-4095）
    private static long sequence = 0L;
    //上次生成Id的时间戳
    private static long lastTimestamp = -1L;
    //初始化参数
    private static IdGenerator idGenerator;

    static {
        idGenerator = new IdGenerator();
    }

    /**
     * @desc 返回long类型id
     * @param
     * @return long
     */
    public static synchronized long getLongId() {
        return IdGenerator.getNextId();
    }
    /**
     * @desc 返回String类型id
     * @param
     * @return java.lang.String
     */
    public static synchronized String getStringId() {
        return String.valueOf(IdGenerator.getNextId());
    }

    private IdGenerator() {
        IdGenerator.workerId = workerId & maxWorkerId;
        IdGenerator.dataCenterId = dataCenterId & maxDataCenterId;
    }

    /**
     * @desc 生成id
     * @param
     * @return long
     */
    public static synchronized long getNextId() {
        long timestamp = timeGen();
        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则生成毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0L) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampShift) | (dataCenterId << dataCenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    /**
     * @desc 阻塞到下一个毫秒，直至获得新的时间戳
     * @param lastTimestamp
     * @return long
     */
    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * @desc 获取系统时间戳
     * @param
     * @return long
     */
    private static long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(getLongId());
        }

    }
}

