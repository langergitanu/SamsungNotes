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
class NfcLedCoverTouchListenerDelegate extends INfcLedCoverTouchListenerCallback.Stub {
    private static final int MSG_LISTEN_COVER_TOUCH_ACCEPT = 0;
    private static final int MSG_LISTEN_COVER_TOUCH_REJECT = 1;
    private static final int MSG_LISTEN_COVER_TOUCH_REJECT_TAP_LEFT = 2;
    private static final int MSG_LISTEN_COVER_TOUCH_REJECT_TAP_MID = 3;
    private static final int MSG_LISTEN_COVER_TOUCH_REJECT_TAP_RIGHT = 4;
    private ListenerDelegateHandler mHandler;
    private ScoverManager.NfcLedCoverTouchListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerDelegateHandler extends Handler {
        private final WeakReference<ScoverManager.NfcLedCoverTouchListener> mListenerRef;

        public ListenerDelegateHandler(Looper looper, ScoverManager.NfcLedCoverTouchListener nfcLedCoverTouchListener) {
            super(looper);
            this.mListenerRef = new WeakReference<>(nfcLedCoverTouchListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScoverManager.NfcLedCoverTouchListener nfcLedCoverTouchListener = this.mListenerRef.get();
            if (nfcLedCoverTouchListener != null) {
                int i = message.what;
                if (i == 0) {
                    nfcLedCoverTouchListener.onCoverTouchAccept();
                    return;
                }
                if (i == 1) {
                    nfcLedCoverTouchListener.onCoverTouchReject();
                    return;
                }
                if (i == 2) {
                    nfcLedCoverTouchListener.onCoverTapLeft();
                } else if (i == 3) {
                    nfcLedCoverTouchListener.onCoverTapMid();
                } else {
                    if (i != 4) {
                        return;
                    }
                    nfcLedCoverTouchListener.onCoverTapRight();
                }
            }
        }
    }

    public NfcLedCoverTouchListenerDelegate(ScoverManager.NfcLedCoverTouchListener nfcLedCoverTouchListener, Handler handler, Context context) {
        this.mListener = nfcLedCoverTouchListener;
        this.mHandler = new ListenerDelegateHandler(handler == null ? context.getMainLooper() : handler.getLooper(), this.mListener);
    }

    public Object getListener() {
        return this.mListener;
    }

    public void onCoverTapLeft() {
        this.mHandler.obtainMessage(2).sendToTarget();
    }

    public void onCoverTapMid() {
        this.mHandler.obtainMessage(3).sendToTarget();
    }

    public void onCoverTapRight() {
        this.mHandler.obtainMessage(4).sendToTarget();
    }

    public void onCoverTouchAccept() {
        this.mHandler.obtainMessage(0).sendToTarget();
    }

    public void onCoverTouchReject() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void onSystemCoverEvent(int i, Bundle bundle) {
    }
}
