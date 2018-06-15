package com.dragonball.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 汪先森 on 2017/11/18.
 */
public final class LogUtils {
    /**
     * 错误输入日志
     */
    private static final Logger log = LoggerFactory.getLogger(LogUtils.class);

    /**
     * 记录一直 info信息 日志调用
     */
    public static void logInfo(String message) {
        StringBuilder s = new StringBuilder();
        s.append((message));
        log.info(s.toString());
    }

    /**
     * 记录一直 info信息 日志调用
     */
    public static void logInfo(String messageFormat, String message) {
        log.info(messageFormat, message);
    }

    /**
     * Info 级的 异常 日志调用
     */
    public static void logInfo(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.info(s.toString(), e);
    }

    /**
     * Warn 级的 日志调用
     */
    public static void logWarn(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);

        log.warn(s.toString());
    }

    /**
     * Warn 级的 异常 日志调用
     */
    public static void logWarn(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.warn(s.toString(), e);
    }

    /**
     * Debug 级的日志调用
     */
    public static void logDebug(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);
        log.debug(s.toString());
    }

    /**
     * Debug 级的 异常 日志调用
     */
    public static void logDebug(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.debug(s.toString(), e);
    }

    /**
     * Error 级的日志调用
     */
    public static void logError(String message) {
        StringBuilder s = new StringBuilder();
        s.append(message);
        log.error(s.toString());
    }

    /**
     * Error 级的 异常 日志调用
     */
    public static void logError(String message, Throwable e) {
        StringBuilder s = new StringBuilder();
        s.append("exception : -->>");
        s.append((message));
        log.error(s.toString(), e);
    }


    public static boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }
}
