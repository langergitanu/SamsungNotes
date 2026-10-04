package com.samsung.android.sdk.cover;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.samsung.android.cover.CoverState;
import com.samsung.android.cover.ICoverManagerCallback;
import com.samsung.android.sdk.cover.ScoverManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class CoverListenerDelegate extends ICoverManagerCallback.Stub {
    private static final String TAG = "ScoverManager";
    static final int hasAttachFieldVersion = 16842752;
    static final int hasModelFieldVersion = 16908288;
    static final int hasVisibleRectVersion = 17563648;
    private ListenerDelegateHandler mHandler;
    private final ScoverManager.StateListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListenerDelegateHandler extends Handler {
        private final WeakReference<ScoverManager.StateListener> mListenerRef;

        public ListenerDelegateHandler(Looper looper, ScoverManager.StateListener stateListener) {
            super(looper);
            this.mListenerRef = new WeakReference<>(stateListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ScoverManager.StateListener stateListener = this.mListenerRef.get();
            if (stateListener != null) {
                CoverState coverState = (CoverState) message.obj;
                if (coverState == null) {
                    Log.e(CoverListenerDelegate.TAG, "coverState : null");
                    return;
                }
                ScoverState scoverState = ScoverManager.isSupportableVersion(16908288) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached, coverState.model) : ScoverManager.isSupportableVersion(16842752) ? new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel, coverState.attached) : new ScoverState(coverState.switchState, coverState.type, coverState.color, coverState.widthPixel, coverState.heightPixel);
                if (ScoverManager.isSupportableVersion(17563648)) {
                    scoverState.setVisibleRect(coverState.getVisibleRect());
                }
                stateListener.onCoverStateChanged(scoverState);
            }
        }
    }

    public CoverListenerDelegate(ScoverManager.StateListener stateListener, Handler handler, Context context) {
        this.mListener = stateListener;
        this.mHandler = new ListenerDelegateHandler(handler == null ? context.getMainLooper() : handler.getLooper(), stateListener);
    }

    public void coverCallback(CoverState coverState) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = coverState;
        this.mHandler.sendMessage(messageObtain);
    }

    public ScoverManager.StateListener getListener() {
        return this.mListener;
    }

    public String getListenerInfo() {
        return this.mListener.toString();
    }
}
