package com.samsung.android.sdk.cover;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.samsung.android.cover.ICoverStateListenerCallback;
import com.samsung.android.sdk.cover.ScoverManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class CoverStateListenerDelegate extends ICoverStateListenerCallback.Stub {
    private static final int MSG_LISTEN_COVER_ATTACH_STATE_CHANGE = 1;
    private static final int MSG_LISTEN_COVER_SWITCH_STATE_CHANGE = 0;
    public static final int TYPE_COVER_STATE_LISTENER = 2;
    private ListenerDelegateHandler mHandler;
    private final ScoverManager.CoverStateListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerDelegateHandler extends Handler {
        private final WeakReference<ScoverManager.CoverStateListener> mListenerRef;

        public ListenerDelegateHandler(Looper looper, ScoverManager.CoverStateListener coverStateListener) {
            super(looper);
            this.mListenerRef = new WeakReference<>(coverStateListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScoverManager.CoverStateListener coverStateListener = this.mListenerRef.get();
            if (coverStateListener != null) {
                int i = message.what;
                if (i == 0) {
                    coverStateListener.onCoverSwitchStateChanged(message.arg1 == 1);
                } else {
                    if (i != 1) {
                        return;
                    }
                    coverStateListener.onCoverAttachStateChanged(message.arg1 == 1);
                }
            }
        }
    }

    public CoverStateListenerDelegate(ScoverManager.CoverStateListener coverStateListener, Handler handler, Context context) {
        this.mListener = coverStateListener;
        this.mHandler = new ListenerDelegateHandler(handler == null ? context.getMainLooper() : handler.getLooper(), coverStateListener);
    }

    public ScoverManager.CoverStateListener getListener() {
        return this.mListener;
    }

    public String getListenerInfo() {
        return this.mListener.toString();
    }

    public void onCoverAttachStateChanged(boolean z) {
        Message.obtain(this.mHandler, 1, z ? 1 : 0, 0).sendToTarget();
    }

    public void onCoverSwitchStateChanged(boolean z) {
        Message.obtain(this.mHandler, 0, z ? 1 : 0, 0).sendToTarget();
    }
}
