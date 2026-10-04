package com.samsung.android.support.senl.p148nt.app.lock.view.base;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.converter.DialogInterfaceOnCancelListenerC8050a;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsBaseOldBiometricView extends AbsBaseView {
    private static final int BIOMETRIC_LOCKOUT_DEFAULT_SECONDS = 30;
    private static final String TAG = LockLogger.createTag("AbsBaseOldBiometricView");
    private boolean mIsChangingToPasswordVerification;
    private final PASSWORDTYPE mPasswordType = PASSWORDTYPE.COMMON;
    protected AlertDialog mRetryDialog;
    private AlertDialog mTimerDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PASSWORDTYPE {
        OLD,
        COMMON
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTimerDialog$0(DialogInterface dialogInterface, int i) {
        finishCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTimerDialog$1(DialogInterface dialogInterface) {
        finishCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTimerDialog$2(DialogInterface dialogInterface) {
        if (this.mIsFinishing) {
            return;
        }
        authenticate();
    }

    public abstract void authenticate();

    public abstract void cancelAuthenticate();

    public void changeToPasswordVerification(int i) {
        LockLogger.m7356d(TAG, "changeToPasswordVerification context:" + getContext());
        this.mIsChangingToPasswordVerification = true;
        cancelAuthenticate();
        if (getContext() == null) {
            finishCancel();
        } else if (this.mPasswordType == PASSWORDTYPE.OLD) {
            changeViewTo(8, i);
        } else {
            changeViewTo(2, i);
        }
    }

    public boolean getIsChangingToPasswordUI() {
        return this.mIsChangingToPasswordVerification;
    }

    public long getSavedOldBiometricBlockingTime() {
        long oldBiometricMethodBlockEndTime = LockPrefUtils.getOldBiometricMethodBlockEndTime(getContext());
        long jElapsedRealtime = oldBiometricMethodBlockEndTime - SystemClock.elapsedRealtime();
        if (oldBiometricMethodBlockEndTime == Long.MAX_VALUE || jElapsedRealtime <= 30000) {
            return jElapsedRealtime;
        }
        LockPrefUtils.setOldBiometricMethodBlockEndTime(getContext(), 0L);
        return 0L;
    }

    public boolean isOldBiometricBlocked() {
        return getSavedOldBiometricBlockingTime() > 0;
    }

    public boolean isOldBiometricBlockedPermanent() {
        return LockPrefUtils.getOldBiometricMethodBlockEndTime(getContext()) == Long.MAX_VALUE;
    }

    public boolean isPasswordBlocked() {
        return getSavedPasswordBlockingTime() > 0;
    }

    public void onBioAuthenticationFailed(@NonNull Runnable runnable) {
        if (getContext() == null) {
            return;
        }
        int oldBiometricMethodFailCount = LockPrefUtils.getOldBiometricMethodFailCount(getContext()) + 1;
        if (oldBiometricMethodFailCount % 50 == 0) {
            LockLogger.m7356d(TAG, "old biometric blocked permanent");
            LockPrefUtils.setOldBiometricMethodBlockEndTime(getContext(), Long.MAX_VALUE);
            changeToPasswordVerification(1);
        } else if (oldBiometricMethodFailCount % 5 == 0) {
            LockLogger.m7356d(TAG, "old biometric blocked temporary");
            LockPrefUtils.setOldBiometricMethodBlockEndTime(getContext(), SystemClock.elapsedRealtime() + 30000);
            showTimerDialog(30);
            cancelAuthenticate();
        } else {
            runnable.run();
        }
        LockPrefUtils.setOldBiometricMethodFailCount(getContext(), oldBiometricMethodFailCount);
        LockLogger.m7356d(TAG, "onBioAuthenticationFailed fail count : " + oldBiometricMethodFailCount);
    }

    public void onBioAuthenticationLockOutPermanent(CharSequence charSequence) {
    }

    public void onBioAuthenticationLockedOut() {
        if (isOldBiometricBlocked()) {
            showTimerDialog((int) (getSavedOldBiometricBlockingTime() / 1000));
        }
        LockPrefUtils.setOldBiometricMethodFailCount(getContext(), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AlertDialog alertDialog = this.mTimerDialog;
        if (alertDialog != null) {
            alertDialog.setOnDismissListener(null);
            this.mTimerDialog.dismiss();
            this.mTimerDialog = null;
        }
        AlertDialog alertDialog2 = this.mRetryDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.mRetryDialog = null;
        }
    }

    public void showTimerDialog(int i) {
        LockLogger.m7356d(TAG, "showTimerDialog : " + i + "seconds");
        AlertDialog alertDialog = this.mTimerDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (i <= 0) {
                new Handler(getContext().getMainLooper()).postDelayed(new RunnableC7599e(this, 18), 1000L);
                return;
            }
            AlertDialog alertDialogShowTimerDialog = LockDialogUtils.showTimerDialog(getContext(), new DialogInterfaceOnClickListenerC0161a(this, 5), i);
            this.mTimerDialog = alertDialogShowTimerDialog;
            alertDialogShowTimerDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC8050a(this, 2));
            this.mTimerDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 4));
        }
    }
}
