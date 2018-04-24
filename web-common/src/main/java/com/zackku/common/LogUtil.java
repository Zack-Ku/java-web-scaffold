package com.zackku.common;

import org.slf4j.Logger;

/**
 * @author Zack
 * @date 2018/4/23
 */
public class LogUtil {
    public static final String COMMON = "common";

    /**
     * @param logger    package 对应的logger
     * @param eventName 每一类业务定义的类型,需要开发自己维护,用于数据聚合
     * @param format    自定义的输出格式
     * @param msg       自定义的输出内容
     */
    public static void warn(Logger logger, String eventName, String format, Object... msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(appendFormatAndEventName(format, eventName), getMsg(msg));
        }
    }

    /**
     * @param logger    package 对应的logger
     * @param eventName 每一类业务定义的类型,需要开发自己维护,用于数据聚合
     * @param format    自定义的输出格式
     * @param msg       自定义的输出内容
     */
    public static void info(Logger logger, String eventName, String format, Object... msg) {
        if (logger.isInfoEnabled()) {
            logger.info(appendFormatAndEventName(format, eventName), getMsg(msg));
        }
    }

    /**
     * @param logger    package 对应的logger
     * @param eventName 每一类业务定义的类型,需要开发自己维护,用于数据聚合
     * @param format    自定义的输出格式
     * @param msg       自定义的输出内容
     */
    public static void error(Logger logger, String eventName, String format, Object... msg) {
        if (logger.isErrorEnabled()) {
            logger.error(appendFormatAndEventName(format, eventName), getMsg(msg));
        }
    }

    public static void debug(Logger logger, String eventName, String format, Object... msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(appendFormatAndEventName(format, eventName), getMsg(msg));
        }
    }

    //TODO 暂时不使用json={}的结构输出额外信息
    public static String appendFormatAndEventName(String format, String eventName) {
        return "[" + eventName + "] msg=" + format;
    }

    public static Object[] getMsg(Object[] msg) {
        /* 处理特殊的null值不认为是object... */
        if (msg == null) {
            return new Object[]{null};
        } else {
            return msg;
        }
    }
}
