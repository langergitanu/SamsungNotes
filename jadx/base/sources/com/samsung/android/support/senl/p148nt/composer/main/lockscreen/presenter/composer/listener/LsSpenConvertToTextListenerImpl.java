package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.composer.listener;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p014C3.RunnableC0054a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/presenter/composer/listener/LsSpenConvertToTextListenerImpl;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenConvertToTextListenerImpl;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;", "taskController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/TaskController;", "progressController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;", "softInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/TaskController;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;)V", "onCopySelected", "", "charSequence", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsSpenConvertToTextListenerImpl extends SpenConvertToTextListenerImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LsSpenConvertToTextListenerImpl(@NotNull ListenerImplContract.IPresenter presenter, @NotNull TaskController taskController, @NotNull ProgressController progressController, @NotNull SoftInputManager softInputManager) {
        super(presenter, taskController, progressController, softInputManager);
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(taskController, "taskController");
        Intrinsics.checkNotNullParameter(progressController, "progressController");
        Intrinsics.checkNotNullParameter(softInputManager, "softInputManager");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl, com.samsung.android.sdk.pen.recoguifeature.converttotext.SpenConvertToTextListener
    public void onCopySelected(@Nullable CharSequence charSequence) {
        this.mPresenter.getWritingToolManager().getKeyguardPresenter().dismissKeyguard(this.mPresenter.getActivity(), new RunnableC0054a(this, charSequence, 0));
    }
}
