package com.samsung.android.support.senl.p148nt.app.lock.view.base;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.app.converter.DialogInterfaceOnCancelListenerC8050a;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseBiometricContract;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsBaseBiometricView extends AbsBaseView implements IBaseBiometricContract.IView {
    private static final int BIOMETRIC_LOCKOUT_DEFAULT_SECONDS = 30;
    private static final int DELAY_WAIT_TO_CHECK_BIOMETRIC_UI_CLOSED = 200;
    private static final int MESSAGE_WAIT_TO_CHECK_BIOMETRIC_UI_CLOSED = 1;
    private static final String TAG = LockLogger.createTag("AbsBaseBiometricView");
    private MessageHandler mHandler;
    private boolean mIsAutoCloseCase;
    private boolean mIsChangingToPasswordUI;
    private boolean mIsLockOutCase;
    private boolean mIsLockOutPermanentCase;
    private boolean mIsWaitingPromptUI;
    private PASSWORDTYPE mPasswordType;
    protected AlertDialog mRetryDialog;
    private AlertDialog mTimerDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MessageHandler extends Handler {
        public /* synthetic */ MessageHandler(AbsBaseBiometricView absBaseBiometricView, int i) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            LockLogger.m7356d(AbsBaseBiometricView.TAG, "handleMessage# " + message.what);
            if (message.what == 1 && AbsBaseBiometricView.this.mIsLockOutCase) {
                AbsBaseBiometricView.this.showTimerDialogAfterLockOut();
            }
        }

        private MessageHandler() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum PASSWORDTYPE {
        OLD,
        COMMON
    }

    public AbsBaseBiometricView() {
        this.mPasswordType = PASSWORDTYPE.COMMON;
        this.mHandler = new MessageHandler(this, 0);
    }

    private void closeTimerDialog() {
        AlertDialog alertDialog = this.mTimerDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.mTimerDialog.setOnDismissListener(null);
        this.mTimerDialog.dismiss();
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

    private void onAuthenticationLockedOutUnderP() {
        if (isOldBiometricBlocked()) {
            showTimerDialog((int) (getSavedOldBiometricBlockingTime() / 1000));
        }
        LockPrefUtils.setOldBiometricMethodFailCount(getContext(), 0);
    }

    private void setBiometricBlockedTime(int i) {
        LockLogger.m7356d(TAG, "setBiometricBlockedTime : " + i);
        long jElapsedRealtime = (((long) i) * 1000) + SystemClock.elapsedRealtime();
        if (getContext() != null) {
            LockPrefUtils.setBlockEndTimeBiometric(getContext(), jElapsedRealtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTimerDialogAfterLockOut() {
        LockLogger.m7356d(TAG, "ShowTimerDialogAfterLockOut");
        this.mIsLockOutCase = false;
        showTimerDialog(getRemainBlockTime());
    }

    public abstract void authenticate();

    public abstract void cancelAuthenticate();

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void changeToPasswordVerification(int i) {
        LockLogger.m7356d(TAG, "changeToPasswordVerification context:" + getContext());
        this.mIsChangingToPasswordUI = true;
        cancelAuthenticate();
        this.mIsAutoCloseCase = false;
        if (getContext() == null) {
            finishCancel();
        } else if (this.mPasswordType == PASSWORDTYPE.OLD) {
            changeViewTo(8, i);
        } else {
            changeViewTo(2, i);
        }
        NotesSamsungAnalytics.insertLog("322", "3211");
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public int getRemainBlockTime() {
        long blockEndTimeBiometric = LockPrefUtils.getBlockEndTimeBiometric(getContext());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str = TAG;
        StringBuilder sb = new StringBuilder("getRemainBlockTime : ");
        float f = (blockEndTimeBiometric - jElapsedRealtime) / 1000.0f;
        sb.append(f);
        LockLogger.m7356d(str, sb.toString());
        if (blockEndTimeBiometric < jElapsedRealtime) {
            return 0;
        }
        int i = (int) (f + 0.5f);
        if (i <= 30) {
            return i;
        }
        setBiometricBlockedTime(0);
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public long getSavedOldBiometricBlockingTime() {
        long oldBiometricMethodBlockEndTime = LockPrefUtils.getOldBiometricMethodBlockEndTime(getContext());
        long jElapsedRealtime = oldBiometricMethodBlockEndTime - SystemClock.elapsedRealtime();
        if (oldBiometricMethodBlockEndTime == Long.MAX_VALUE || jElapsedRealtime <= 30000) {
            return jElapsedRealtime;
        }
        LockPrefUtils.setOldBiometricMethodBlockEndTime(getContext(), 0L);
        return 0L;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public boolean isBiometricBlocked() {
        return getRemainBlockTime() > 0;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public boolean isChangingToPasswordUI() {
        return this.mIsChangingToPasswordUI;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public boolean isOldBiometricBlocked() {
        return getSavedOldBiometricBlockingTime() > 0;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public boolean isOldBiometricBlockedPermanent() {
        return LockPrefUtils.getOldBiometricMethodBlockEndTime(getContext()) == Long.MAX_VALUE;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public boolean isPasswordBlocked() {
        return getSavedPasswordBlockingTime() > 0;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void onAuthenticationLockOutPermanent(CharSequence charSequence) {
        LockLogger.m7356d(TAG, "onAuthenticationLockOutPermanent");
        if (getContext() == null) {
            return;
        }
        if (!this.mIsWaitingPromptUI) {
            this.mIsLockOutPermanentCase = true;
        } else {
            ToastHandler.show(getContext(), charSequence.toString(), 1, false);
            changeToPasswordVerification(1);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void onAuthenticationLockedOut() {
        LockLogger.m7356d(TAG, "onAuthenticationLockedOut");
        if (getContext() == null) {
            return;
        }
        this.mIsWaitingPromptUI = false;
        if (Build.VERSION.SDK_INT < 28) {
            onAuthenticationLockedOutUnderP();
        } else if (isBiometricBlocked()) {
            showTimerDialog(getRemainBlockTime());
        } else {
            setBiometricBlockedTime(30);
            this.mIsLockOutCase = true;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void onAuthenticationSuccess() {
        LockLogger.m7356d(TAG, "onAuthenticationSuccess");
        if (getContext() == null) {
            return;
        }
        setBiometricBlockedTime(0);
        finishSuccess();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean zIsSubDisplay = DisplayDeviceTypeCompat.INSTANCE.getInstance().isSubDisplay(configuration);
        LockLogger.m7356d(TAG, "onConfigurationChanged, isSubScreen : " + zIsSubDisplay);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        cancelAuthenticate();
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            messageHandler.removeMessages(1);
            this.mHandler = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void onOldBiometricAuthenticationFailed() {
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
        }
        LockPrefUtils.setOldBiometricMethodFailCount(getContext(), oldBiometricMethodFailCount);
        LockLogger.m7356d(TAG, "old biometric fail count : " + oldBiometricMethodFailCount);
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

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView, com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IView
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        String str = TAG;
        LockLogger.m7356d(str, "onWindowFocusChanged : " + z);
        if (!z) {
            if (this.mIsWaitingPromptUI) {
                LockLogger.m7356d(str, "lose focus with showing up the prompt");
                closeTimerDialog();
                this.mIsWaitingPromptUI = false;
                return;
            }
            return;
        }
        if (this.mIsAutoCloseCase) {
            LockLogger.m7356d(str, "get focus with disappearance of the prompt caused by Timeout");
            this.mIsAutoCloseCase = false;
            finishCancel();
        }
        if (this.mIsLockOutCase) {
            LockLogger.m7356d(str, "get focus with disappearance of the prompt caused by Lockout");
            showTimerDialogAfterLockOut();
        } else {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, 200L);
        }
        if (this.mIsLockOutPermanentCase) {
            LockLogger.m7356d(str, "get focus with disappearance of the prompt caused by LockoutPermanent");
            this.mIsLockOutPermanentCase = false;
            changeToPasswordVerification(1);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void setIsAutoCloseCase(boolean z) {
        LockLogger.m7356d(TAG, "setIsAutoCloseCase : " + z);
        this.mIsAutoCloseCase = z;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void setIsWaitingPromptUI(boolean z) {
        LockLogger.m7356d(TAG, "setIsWaitingPromptUI : " + z);
        this.mIsWaitingPromptUI = z;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseBiometricContract.IView
    public void showTimerDialog(int i) {
        LockLogger.m7356d(TAG, "showTimerDialog : " + i + "seconds");
        AlertDialog alertDialog = this.mTimerDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (i <= 0) {
                new Handler(getContext().getMainLooper()).postDelayed(new RunnableC7599e(this, 17), 1000L);
                return;
            }
            AlertDialog alertDialogShowTimerDialog = LockDialogUtils.showTimerDialog(getContext(), new DialogInterfaceOnClickListenerC0161a(this, 4), i);
            this.mTimerDialog = alertDialogShowTimerDialog;
            alertDialogShowTimerDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC8050a(this, 1));
            this.mTimerDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 3));
        }
    }

    public AbsBaseBiometricView(PASSWORDTYPE passwordtype) {
        this.mPasswordType = PASSWORDTYPE.COMMON;
        this.mHandler = new MessageHandler(this, 0);
        this.mPasswordType = passwordtype;
    }
}
