package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter;

import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmQuickSaveControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoQuickSaveControl;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "quickSaveTimerController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/QuickSaveTimerController;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/QuickSaveTimerController;)V", "lock", "", "message", "", "unlock", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoQuickSaveControl extends SmQuickSaveControl {

    @NotNull
    private final QuickSaveTimerController quickSaveTimerController;

    public StickyMemoQuickSaveControl(@NotNull QuickSaveTimerController quickSaveTimerController) {
        Intrinsics.checkNotNullParameter(quickSaveTimerController, "quickSaveTimerController");
        this.quickSaveTimerController = quickSaveTimerController;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmQuickSaveControl
    public void lock(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.quickSaveTimerController.lock(message);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmQuickSaveControl
    public void unlock(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.quickSaveTimerController.unLock(message);
    }
}
