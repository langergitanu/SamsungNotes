package com.samsung.android.support.senl.p148nt.composer.main.popupnote.presenter.menu.option;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.util.PopupNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/presenter/menu/option/PopupNoteOptionMenuBackPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuBackPresenter;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "dialogPresenterManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogPresenterManager;", "menuManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogPresenterManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/MenuPresenterContract$IMenuManager;)V", "startMainActivity", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "isUsingMultiMainList", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupNoteOptionMenuBackPresenter extends OptionMenuBackPresenter {
    public PopupNoteOptionMenuBackPresenter(@Nullable ControllerManager controllerManager, @Nullable ComposerViewPresenter composerViewPresenter, @Nullable ComposerModel composerModel, @Nullable DialogPresenterManager dialogPresenterManager, @Nullable MenuPresenterContract.IMenuManager iMenuManager) {
        super(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager, iMenuManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter
    public void startMainActivity(@NotNull Activity activity, @NotNull Intent intent, boolean isUsingMultiMainList) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!DeviceUtils.INSTANCE.isPopupNoteSupported(activity) || !WindowManagerCompat.INSTANCE.getInstance().isFreeFormWindow(activity)) {
            super.startMainActivity(activity, intent, isUsingMultiMainList);
            return;
        }
        intent.setFlags(403177472);
        MultiTaskManager companion = MultiTaskManager.INSTANCE.getInstance();
        Bundle bundle = PopupNoteUtils.INSTANCE.getActivityOptions(activity).toBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
        companion.startActivity(activity, intent, bundle);
    }
}
