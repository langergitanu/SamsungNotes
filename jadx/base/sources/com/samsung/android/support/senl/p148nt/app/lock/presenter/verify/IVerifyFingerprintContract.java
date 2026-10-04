package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import android.content.Context;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseBiometricContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract;", "", "IPresenter", "IView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IVerifyFingerprintContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract$IPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseBiometricContract$IPresenter;", "authenticate", "", "context", "Landroid/content/Context;", "cancelAuthenticate", "onResume", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter extends IBaseBiometricContract.IPresenter {
        void authenticate(@Nullable Context context);

        void cancelAuthenticate();

        void onResume(@Nullable Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyFingerprintContract$IView;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseBiometricContract$IView;", "setGuideText", "", "text", "", "resId", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView extends IBaseBiometricContract.IView {
        void setGuideText(@StringRes int resId);

        void setGuideText(@Nullable CharSequence text);
    }
}
