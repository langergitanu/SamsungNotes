package com.samsung.android.sdk.cover;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.samsung.android.cover.INfcLedCoverTouchListenerCallback;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class LegacyLedSystemEventListenerDelegate extends INfcLedCoverTouchListenerCallback.Stub {
    private static final int MSG_SYSTEM_COVER_EVENT = 0;
    private static final String SYSTEM_EVENT_LED_OFF_COMMAND = "led_off_command";
    private static final String TAG = "LegacyLedSystemEventListenerDelegate";
    private ListenerDelegateHandler mHandler;
    private Object mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerDelegateHandler extends Handler {
        private final Object mListener;

        public ListenerDelegateHandler(Looper looper, Object obj) {
            super(looper);
            this.mListener = obj;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Method method;
            Object obj = this.mListener;
            if (obj == null || message.what != 0) {
                return;
            }
            int[] iArr = (int[]) message.obj;
            try {
                method = obj.getClass().getMethod("onSystemCoverEvent", Integer.TYPE, Bundle.class);
            } catch (NoSuchMethodException e) {
                Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error getting onSystemCoverEvent method", e);
                method = null;
            } catch (SecurityException e2) {
                Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error getting onSystemCoverEvent method", e2);
                method = null;
            }
            if (method != null) {
                if (iArr != null) {
                    try {
                        if (iArr.length < 1) {
                            Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error: system event args empty: " + iArr);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putInt(LegacyLedSystemEventListenerDelegate.SYSTEM_EVENT_LED_OFF_COMMAND, iArr[0]);
                            method.invoke(this.mListener, Integer.valueOf(message.arg1), bundle);
                        }
                    } catch (IllegalAccessException e3) {
                        Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error invoking " + method.getName(), e3);
                    } catch (IllegalArgumentException e5) {
                        Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error invoking " + method.getName(), e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error invoking " + method.getName(), e6);
                    }
                } else {
                    Log.e(LegacyLedSystemEventListenerDelegate.TAG, "Error: system event args empty: " + iArr);
                }
            }
        }
    }

    public LegacyLedSystemEventListenerDelegate(Object obj, Handler handler, Context context) {
        this.mListener = obj;
        this.mHandler = new ListenerDelegateHandler(handler == null ? context.getMainLooper() : handler.getLooper(), this.mListener);
    }

    public Object getListener() {
        return this.mListener;
    }

    public void onCoverTouchAccept() {
    }

    public void onCoverTouchReject() {
    }

    public void onSystemCoverEvent(int i, int[] iArr) {
        Message messageObtainMessage = this.mHandler.obtainMessage(0);
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = iArr;
        messageObtainMessage.sendToTarget();
    }
}
