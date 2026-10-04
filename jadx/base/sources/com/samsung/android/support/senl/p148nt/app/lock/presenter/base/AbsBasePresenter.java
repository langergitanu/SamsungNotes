package com.samsung.android.support.senl.p148nt.app.lock.presenter.base;

import com.samsung.android.support.senl.p148nt.app.lock.presenter.base.IBaseContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/AbsBasePresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IPresenter;", "mView", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/lock/presenter/base/IBaseContract$IView;)V", "finishSuccess", "", "finishCancel", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBasePresenter implements IBaseContract.IPresenter {

    @Nullable
    private final IBaseContract.IView mView;

    public AbsBasePresenter(@Nullable IBaseContract.IView iView) {
        this.mView = iView;
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IPresenter
    public void finishCancel() {
        IBaseContract.IView iView = this.mView;
        if (iView != null) {
            iView.finishCancel();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.base.IBaseContract.IPresenter
    public void finishSuccess() {
        IBaseContract.IView iView = this.mView;
        if (iView != null) {
            iView.finishSuccess();
        }
    }
}
