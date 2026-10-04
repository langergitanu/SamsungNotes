package com.samsung.android.sdk.pass.support;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.IBinder;
import com.samsung.android.fingerprint.FingerprintIdentifyDialog;
import com.samsung.android.fingerprint.FingerprintManager;
import com.samsung.android.fingerprint.IFingerprintClient;

/* JADX INFO: loaded from: classes7.dex */
public interface IFingerprintManagerProxy {
    boolean cancel(IBinder iBinder);

    int getEnrolledFingers();

    String getFingerprintId(int i);

    AnimationDrawable getImageQualityAnimation(int i, Context context);

    String getIndexName(int i);

    int getSensorPosition();

    int getSensorType();

    int getVersion();

    boolean hasPendingCommand();

    int identify(IBinder iBinder, String str);

    int identifyWithDialog(Context context, IFingerprintClient iFingerprintClient, Bundle bundle);

    boolean isEnrolling();

    boolean isSensorReady();

    boolean isSupportBackupPassword();

    boolean isSupportFingerprintIds();

    void notifyAppActivityState(int i, Bundle bundle);

    boolean notifyEnrollEnd();

    IBinder registerClient(IFingerprintClient iFingerprintClient, Bundle bundle);

    Dialog showIdentifyDialog(Context context, FingerprintIdentifyDialog.FingerprintListener fingerprintListener, String str, boolean z);

    boolean startEnrollActivity(Context context, FingerprintManager.EnrollFinishListener enrollFinishListener, String str);

    boolean unregisterClient(IBinder iBinder);

    boolean verifyPassword(String str);
}
