package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.dex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DoPFileTransmitReceiver extends BroadcastReceiver {
    static final String ACTION_FILE_TRANSMIT_CANCELED = "com.sec.android.app.dexonpc.file_transmit_canceled";
    static final String ACTION_FILE_TRANSMIT_COMPLETED = "com.sec.android.app.dexonpc.file_transmit_completed";
    static final String ACTION_FILE_TRANSMIT_FAILED = "com.sec.android.app.dexonpc.file_transmit_failed";
    static final String ACTION_FILE_TRANSMIT_FINISHED = "com.sec.android.app.dexonpc.file_transmit_finished";
    private static final String TAG = Logger.createTag("DoPFileTransmitReceiver");
    private Callback mCallback;
    private int mEventId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onTransitCanceled(Context context, Intent intent);

        void onTransitCompleted(Context context, Intent intent);

        void onTransitFailed(Context context, Intent intent);

        void onTransitFinished(Context context, Intent intent);
    }

    public DoPFileTransmitReceiver(int i, Callback callback) {
        this.mEventId = i;
        this.mCallback = callback;
    }

    public IntentFilter getIntentFilterForDoPFileTransmitReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_FILE_TRANSMIT_COMPLETED);
        intentFilter.addAction(ACTION_FILE_TRANSMIT_FAILED);
        intentFilter.addAction(ACTION_FILE_TRANSMIT_FINISHED);
        intentFilter.addAction(ACTION_FILE_TRANSMIT_CANCELED);
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("id", -1);
        if (this.mEventId != intExtra) {
            Logger.m11000e(TAG, "mEventId=" + this.mEventId + "  id=" + intExtra);
            return;
        }
        if (ACTION_FILE_TRANSMIT_COMPLETED.equalsIgnoreCase(intent.getAction())) {
            this.mCallback.onTransitCompleted(context, intent);
            return;
        }
        if (ACTION_FILE_TRANSMIT_FAILED.equalsIgnoreCase(intent.getAction())) {
            this.mCallback.onTransitFailed(context, intent);
        } else if (ACTION_FILE_TRANSMIT_FINISHED.equalsIgnoreCase(intent.getAction())) {
            this.mCallback.onTransitFinished(context, intent);
        } else if (ACTION_FILE_TRANSMIT_CANCELED.equalsIgnoreCase(intent.getAction())) {
            this.mCallback.onTransitCanceled(context, intent);
        }
    }
}
