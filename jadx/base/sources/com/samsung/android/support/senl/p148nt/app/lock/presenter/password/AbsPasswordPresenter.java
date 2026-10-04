package com.samsung.android.support.senl.p148nt.app.lock.presenter.password;

import com.samsung.android.support.senl.p148nt.app.lock.model.password.PasswordModel;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.AbsBasePresenter;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.password.IBasePasswordContract;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/AbsPasswordPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/AbsBasePresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IPresenter;", "view", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IView;)V", "mPasswordModel", "Lcom/samsung/android/support/senl/nt/app/lock/model/password/PasswordModel;", "setPasswordToBeCompared", "", "hash", "", "salt", "setOldPasswordVerificationMode", "enable", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPasswordPresenter extends AbsBasePresenter implements IBasePasswordContract.IPresenter {

    @JvmField
    @NotNull
    protected final PasswordModel mPasswordModel;

    public AbsPasswordPresenter(@Nullable IBasePasswordContract.IView iView) {
        super(iView);
        this.mPasswordModel = new PasswordModel();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IPresenter
    public void setOldPasswordVerificationMode(boolean enable) {
        this.mPasswordModel.setIsOldPasswordVerification(enable);
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.password.IBasePasswordContract.IPresenter
    public void setPasswordToBeCompared(@Nullable String hash, @Nullable String salt) {
        this.mPasswordModel.setEncryptedHashAndSalt(hash, salt);
    }
}
