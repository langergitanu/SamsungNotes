package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoProgressControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "progressController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;)V", "getProgressController", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;", "init", "", "rootView", "Landroid/view/View;", "showProgress", "delay", "", "hideProgress", "isShowing", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoProgressControl extends SmProgressControl {

    @NotNull
    private final ProgressController progressController;

    public StickyMemoProgressControl(@NotNull ProgressController progressController) {
        Intrinsics.checkNotNullParameter(progressController, "progressController");
        this.progressController = progressController;
    }

    @NotNull
    public final ProgressController getProgressController() {
        return this.progressController;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl
    public void hideProgress() {
        this.progressController.hideProgress(0, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl
    public void init(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl
    public boolean isShowing() {
        return this.progressController.isShowingProgressCircle();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmProgressControl
    public void showProgress(long delay) {
        this.progressController.showProgress(0, 0);
    }
}
