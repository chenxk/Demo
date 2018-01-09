package com.demo.test.util;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 *
 * @author bob.bop
 * @date 2015/12/19
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = "CrashHandler";

    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static CrashHandler INSTANCE = new CrashHandler();
    //程序的Context对象
    private Context mContext;

    /**
     * 保证只有一个CrashHandler实例
     */
    private CrashHandler() {
    }

    /**
     * 获取CrashHandler实例 ,单例模式
     */

    public static CrashHandler getInstance() {
        return INSTANCE;
    }


    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e("Exception", "Exception:" + Log.getStackTraceString(ex));
        if (!handleException(ex) && mDefaultHandler != null) {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e("Exception", "Exception:" + Log.getStackTraceString(e));
            }
            /*Intent intent = new Intent(mContext.getApplicationContext(), HomeActivity.class);
            PendingIntent restartIntent = PendingIntent.getActivity(
                    mContext.getApplicationContext(), 0, intent,
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            AlarmManager mgr = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100,
                    restartIntent); // 1秒钟后重启应用
            //退出程序
            MyActivityManager.getInstance().exit();
            android.os.Process.killProcess(android.os.Process.myPid());*/
            System.exit(1);
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        //使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "程序异常，即将退出", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
        return true;
    }

}
