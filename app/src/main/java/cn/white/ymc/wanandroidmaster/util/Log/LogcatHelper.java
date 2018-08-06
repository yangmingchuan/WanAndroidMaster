package cn.white.ymc.wanandroidmaster.util.Log;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * log 信息保存本地工具类
 * 2018年7月19日 15:25:32
 */

public class LogcatHelper {
    private static LogcatHelper INSTANCE = null;
    private static String PATH_LOGCAT;
    private LogDumper mLogDumper = null;
    private int mPId;

    /**
     *
     * 初始化目录
     *
     * */
    public void init(Context context) {
        // 优先保存到SD卡中
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            PATH_LOGCAT = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + File.separator + "AWanAndroid-log";
        } else {// 如果SD卡不存在，就保存到本应用的目录下
            PATH_LOGCAT = context.getFilesDir().getAbsolutePath()
                    + File.separator + "AWanAndroid-log";
        }
        File file = new File(PATH_LOGCAT);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static LogcatHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LogcatHelper.class){
                if(INSTANCE == null){
                    INSTANCE = new LogcatHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    private LogcatHelper(Context context) {
        init(context);
        mPId = android.os.Process.myPid();
    }

    public void start() {
        if (mLogDumper == null){
            mLogDumper = new LogDumper(String.valueOf(mPId), PATH_LOGCAT);
        }
        mLogDumper.start();
    }

    public void stop() {
        if (mLogDumper != null) {
            mLogDumper.stopLogs();
            mLogDumper = null;
        }
    }

    private class LogDumper extends Thread {

        private Process logcatProc;
        private BufferedReader mReader = null;
        private boolean mRunning = true;
        String cmds = null;
        private String mPID;
        private FileOutputStream out = null;

        LogDumper(String pid, String dir) {
            mPID = pid;
            try {
                out = new FileOutputStream(new File(dir, "DS-"+ MyDate.getFileName() + ".log"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            /**
             * 日志等级：*:v , *:d , *:w , *:e , *:f , *:s
             * 显示当前程序的 E 等级的日志.
             * */
            // cmds = "logcat *:e *:w | grep \"(" + mPID + ")\"";
            // cmds = "logcat  | grep \"(" + mPID + ")\"";//打印所有日志信息
             cmds = "logcat -s TAG";//打印标签过滤信息
//            cmds = "logcat *:e | grep \"(" + mPID + ")\"";
        }

        void stopLogs() {
            mRunning = false;
        }

        @Override
        public void run() {
            try {
                logcatProc = Runtime.getRuntime().exec(cmds);
                mReader = new BufferedReader(new InputStreamReader(
                        logcatProc.getInputStream()), 1024);
                String line = null;
                while (mRunning && (line = mReader.readLine()) != null) {
                    if (!mRunning) {
                        break;
                    }
                    if (line.length() == 0) {
                        continue;
                    }
                    if (out != null && line.contains(mPID)) {
                        out.write((MyDate.getDateEN() + "  " + line + "\n")
                                .getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TAG",e.getMessage());
            } finally {
                if (logcatProc != null) {
                    logcatProc.destroy();
                    logcatProc = null;
                }
                if (mReader != null) {
                    try {
                        mReader.close();
                        mReader = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out = null;
                }

            }

        }

    }
}
