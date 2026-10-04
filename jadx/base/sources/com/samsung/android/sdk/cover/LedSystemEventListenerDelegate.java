package com.samsung.android.sdk.cover;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.cover.INfcLedCoverTouchListenerCallback;
import com.samsung.android.sdk.cover.ScoverManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class LedSystemEventListenerDelegate extends INfcLedCoverTouchListenerCallback.Stub {
    private static final int MSG_SYSTEM_COVER_EVENT = 0;
    private ListenerDelegateHandler mHandler;
    private ScoverManager.LedSystemEventListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerDelegateHandler extends Handler {
        private final WeakReference<ScoverManager.LedSystemEventListener> mListenerRef;

        public ListenerDelegateHandler(Looper looper, ScoverManager.LedSystemEventListener ledSystemEventListener) {
            super(looper);
            this.mListenerRef = new WeakReference<>(ledSystemEventListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScoverManager.LedSystemEventListener ledSystemEventListener = this.mListenerRef.get();
            if (ledSystemEventListener == null || message.what != 0) {
                return;
            }
            ledSystemEventListener.onSystemCoverEvent(message.arg1, (Bundle) message.obj);
        }
    }

    public LedSystemEventListenerDelegate(ScoverManager.LedSystemEventListener ledSystemEventListener, Handler handler, Context context) {
        this.mListener = ledSystemEventListener;
        this.mHandler = new ListenerDelegateHandler(handler == null ? context.getMainLooper() : handler.getLooper(), this.mListener);
    }

    public Object getListener() {
        return this.mListener;
    }

    public void onCoverTapLeft() {
    }

    public void onCoverTapMid() {
    }

    public void onCoverTapRight() {
    }

    public void onCoverTouchAccept() {
    }

    public void onCoverTouchReject() {
    }

    public void onSystemCoverEvent(int i, Bundle bundle) {
        Message messageObtainMessage = this.mHandler.obtainMessage(0);
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = bundle;
        messageObtainMessage.sendToTarget();
    }
}
