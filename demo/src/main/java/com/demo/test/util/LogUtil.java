package com.demo.test.util;

import android.util.Log;

import com.demo.test.utildata.ConstantsData;


/**
 * log日志打印工具类
 *
 * @author Administrator
 */
public class LogUtil {


    /**
     * 类名
     */
    private static String className;

    /**
     * 方法名
     */
    private static String methodName;

    /**
     * 行数
     */
    private static int lineNumber;

    private LogUtil() {
    }

    public static boolean isDebuggable() {
        return ConstantsData.DEBUG;
    }

    private static String createLog(String log) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);

        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {

        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message));
    }

    public static void i(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.i(className, createLog(message));
    }

    public static void d(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.d(className, createLog(message));
    }

    public static void v(String message) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className, createLog(message));
    }

    public static void w(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.w(className, createLog(message));
    }

    public static void wtf(String message) {
        if (!isDebuggable())
            return;

        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message));
    }

    public static void e(String message, Throwable tr) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className, createLog(message), tr);
    }

    public static void wtf(String message, Throwable tr) {
        if (!isDebuggable())
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.wtf(className, createLog(message), tr);
    }

    /******************** 一般调试 *********************/
    public static void v(String tag, String msg) {
        if (!isDebuggable() || msg == null)
            return;
        Log.v(tag, msg);

    }

    public static void d(String tag, String msg) {
        if (!isDebuggable() || msg == null)
            return;
        Log.d(tag, msg);

    }

    public static void i(String tag, String msg) {
        if (!isDebuggable() || msg == null)
            return;
        int index = 0; // 当前位置
        int max = 3800;// 需要截取的最大长度,别用4000
        String sub;    // 进行截取操作的string
        while (index < msg.length()) {
            if (msg.length() < max) { // 如果长度比最大长度小
                max = msg.length();   // 最大长度设为length,全部截取完成.
                sub = msg.substring(index, max);
            } else {
                sub = msg.substring(index, max);
            }
            Log.i(tag, sub);         // 进行输出
            index = max;
            max += 3800;
        }
//		Log.i(tag, msg);

    }

    public static void w(String tag, String msg) {
        if (!isDebuggable() || msg == null)
            return;
        Log.w(tag, msg);

    }

    public static void e(String tag, String msg) {
        if (!isDebuggable() || msg == null)
            return;
        Log.e(tag, msg);

    }

    public static void e(String tag, String msg, Throwable tr) {
        if (!isDebuggable() || msg == null)
            return;
        Log.e(tag, msg, tr);
    }

    public static void wtf(String tag, String msg, Throwable tr) {
        if (!isDebuggable() || msg == null)
            Log.wtf(tag, msg, tr);
    }
    /******************** end *********************/

}
