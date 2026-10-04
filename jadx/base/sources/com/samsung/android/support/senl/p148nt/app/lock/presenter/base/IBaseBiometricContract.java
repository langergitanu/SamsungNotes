package com.samsung.android.support.senl.p148nt.app.lock.presenter.base;

import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseBiometricContract;", "", "IPresenter", "IView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBaseBiometricContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseBiometricContract$IPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IPresenter;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter extends IBaseContract.IPresenter {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\nH&J\b\u0010\u001e\u001a\u00020\u0003H&R\u0012\u0010\u0012\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0012\u0010\u0015\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0012\u0010\u0016\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseBiometricContract$IView;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IView;", "setIsAutoCloseCase", "", "isAuthenticating", "", "setIsWaitingPromptUI", "isWaiting", "changeToPasswordVerification", "additionalInfo", "", "onAuthenticationSuccess", "onAuthenticationLockedOut", "onAuthenticationLockOutPermanent", "errMsg", "", "showTimerDialog", "remainSeconds", "isPasswordBlocked", "()Z", "isBiometricBlocked", "isOldBiometricBlocked", "isOldBiometricBlockedPermanent", "remainBlockTime", "getRemainBlockTime", "()I", "savedOldBiometricBlockingTime", "", "getSavedOldBiometricBlockingTime", "()J", "onOldBiometricAuthenticationFailed", "isChangingToPasswordUI", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView extends IBaseContract.IView {
        void changeToPasswordVerification(int additionalInfo);

        int getRemainBlockTime();

        long getSavedOldBiometricBlockingTime();

        boolean isBiometricBlocked();

        boolean isChangingToPasswordUI();

        boolean isOldBiometricBlocked();

        boolean isOldBiometricBlockedPermanent();

        boolean isPasswordBlocked();

        void onAuthenticationLockOutPermanent(@Nullable CharSequence errMsg);

        void onAuthenticationLockedOut();

        void onAuthenticationSuccess();

        void onOldBiometricAuthenticationFailed();

        void setIsAutoCloseCase(boolean isAuthenticating);

        void setIsWaitingPromptUI(boolean isWaiting);

        void showTimerDialog(int remainSeconds);
    }
}
