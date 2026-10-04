package com.samsung.android.sdk.smp.task;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.taskhandler.STaskHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ThreadController {
    private static final String TAG = "ThreadController";
    private static Handler mHandler;
    private static HandlerThread mHandlerThread;
    private static int mStartId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MessageHandler extends Handler {
        private final WeakReference<Context> mContext;

        public MessageHandler(Looper looper, Context context) {
            super(looper);
            this.mContext = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context = this.mContext.get();
            if (context != null) {
                STaskHandler.handle(context.getApplicationContext(), STask.fromBundle(message.getData()));
            }
            ThreadController.stopSelf(message.arg1);
        }
    }

    public static synchronized void execute(Context context, STask sTask) {
        try {
            if (context == null || sTask == null) {
                SmpLog.m6494e(TAG, "cannot execute task. invalid params");
                return;
            }
            if (mHandlerThread == null) {
                SmpLog.m6492d(TAG, "onStart");
                HandlerThread handlerThread = new HandlerThread("SmpCtrThread", 10);
                mHandlerThread = handlerThread;
                handlerThread.start();
                mHandler = new MessageHandler(mHandlerThread.getLooper(), context.getApplicationContext());
            }
            mStartId++;
            Message messageObtainMessage = mHandler.obtainMessage();
            messageObtainMessage.arg1 = mStartId;
            messageObtainMessage.setData(sTask.toBundle(context));
            mHandler.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void stopSelf(int i) {
        if (i == mStartId) {
            mHandlerThread.quit();
            mHandlerThread = null;
            mHandler = null;
            mStartId = 0;
            SmpLog.m6492d(TAG, "onStop");
        }
    }
}
