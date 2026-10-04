package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.password.IBasePasswordContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract;", "", "IPresenter", "IView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IVerifyPasswordContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract$IPresenter;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IPresenter;", "verifyPassword", "", "context", "Landroid/content/Context;", "password", "", "failCount", "", "getFailCount", "()I", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter extends IBasePasswordContract.IPresenter {
        int getFailCount();

        boolean verifyPassword(@Nullable Context context, @Nullable String password);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&R\u0012\u0010\u000b\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/presenter/verify/IVerifyPasswordContract$IView;", "Lcom/samsung/android/support/senl/nt/app/lock/presenter/password/IBasePasswordContract$IView;", "setGuideWrongPasswordText", "", "onBlockingTimerStarted", "blockingTime", "", "onBlockingTimerEnded", "onBlockingTimeChanged", "time", "", "savedFailCount", "getSavedFailCount", "()I", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView extends IBasePasswordContract.IView {
        int getSavedFailCount();

        void onBlockingTimeChanged(int time);

        void onBlockingTimerEnded();

        void onBlockingTimerStarted(long blockingTime);

        void setGuideWrongPasswordText();
    }
}
