package com.samsung.android.support.senl.p148nt.app.lock.presenter.password;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract;", "", "IPresenter", "IView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBasePasswordContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IPresenter;", "setPasswordToBeCompared", "", "hash", "", "salt", "setOldPasswordVerificationMode", "enable", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter extends IBaseContract.IPresenter {
        void setOldPasswordVerificationMode(boolean enable);

        void setPasswordToBeCompared(@Nullable String hash, @Nullable String salt);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IView;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IView;", "showProgress", "", "hideProgress", "ignoreInputEvent", MarketingConstants.LINK_TYPE_IGNORE, "", "loginSamsungAccount", "requestCode", "", "encryptedPasswordHash", "", "getEncryptedPasswordHash", "()Ljava/lang/String;", "encryptedPasswordSalt", "getEncryptedPasswordSalt", "isUseBiometricChecked", "()Z", "setBiometricsEnabled", "resetOldBiometricBlockingEndTime", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView extends IBaseContract.IView {
        @Nullable
        String getEncryptedPasswordHash();

        @Nullable
        String getEncryptedPasswordSalt();

        void hideProgress();

        void ignoreInputEvent(boolean ignore);

        boolean isUseBiometricChecked();

        void loginSamsungAccount(int requestCode);

        void resetOldBiometricBlockingEndTime();

        void setBiometricsEnabled();

        void showProgress();
    }
}
