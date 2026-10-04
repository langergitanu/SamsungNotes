package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.AttachMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.object.DynamicTemplateObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\tJ)\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020'¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/DynamicTemplatePresenter;", "", "<init>", "()V", "templateObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/object/DynamicTemplateObjectManager;", "mDynamicTemplateLoader", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DynamicTemplateLoader;", "mDynamicTemplateController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/DynamicTemplateController;", "isInitialized", "", "init", "", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "optionMenuAddPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuAddPresenter;", "attachMenuPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/AttachMenuPresenter;", "release", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "getDynamicTemplateLoader", "getDynamicTemplateController", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplatePresenter {
    private static final String TAG = Logger.createDynamicTemplateLog("Presenter");
    private boolean isInitialized;
    private DynamicTemplateObjectManager templateObjectManager;

    @NotNull
    private final DynamicTemplateLoader mDynamicTemplateLoader = new DynamicTemplateLoader();

    @NotNull
    private final DynamicTemplateController mDynamicTemplateController = new DynamicTemplateController();

    @NotNull
    /* JADX INFO: renamed from: getDynamicTemplateController, reason: from getter */
    public final DynamicTemplateController getMDynamicTemplateController() {
        return this.mDynamicTemplateController;
    }

    @NotNull
    /* JADX INFO: renamed from: getDynamicTemplateLoader, reason: from getter */
    public final DynamicTemplateLoader getMDynamicTemplateLoader() {
        return this.mDynamicTemplateLoader;
    }

    public final void init(@NotNull ComposerModel composerModel, @NotNull ControllerManager controllerManager, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull OptionMenuAddPresenter optionMenuAddPresenter, @NotNull AttachMenuPresenter attachMenuPresenter) {
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(optionMenuAddPresenter, "optionMenuAddPresenter");
        Intrinsics.checkNotNullParameter(attachMenuPresenter, "attachMenuPresenter");
        Logger.m10999d(TAG, "init");
        DynamicTemplateObjectManager dynamicTemplateObjectManager = new DynamicTemplateObjectManager(composerModel, composerViewPresenter, optionMenuAddPresenter);
        this.templateObjectManager = dynamicTemplateObjectManager;
        this.mDynamicTemplateLoader.init(dynamicTemplateObjectManager, composerModel, controllerManager, composerViewPresenter);
        DynamicTemplateController dynamicTemplateController = this.mDynamicTemplateController;
        DynamicTemplateObjectManager dynamicTemplateObjectManager2 = this.templateObjectManager;
        if (dynamicTemplateObjectManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateObjectManager");
            dynamicTemplateObjectManager2 = null;
        }
        dynamicTemplateController.init(dynamicTemplateObjectManager2, controllerManager, composerViewPresenter, optionMenuAddPresenter, attachMenuPresenter);
        this.isInitialized = true;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        return this.mDynamicTemplateController.onActivityResult(requestCode, resultCode, data);
    }

    public final void onAttachView(@NotNull Activity activity, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mDynamicTemplateController.onAttachView(activity, fragment);
    }

    public final boolean onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        return this.mDynamicTemplateController.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public final void release() {
        AbstractC8014b.m7220v("release, isInitialized: ", TAG, this.isInitialized);
        if (this.isInitialized) {
            this.mDynamicTemplateLoader.release();
            this.mDynamicTemplateController.release();
        }
    }
}
