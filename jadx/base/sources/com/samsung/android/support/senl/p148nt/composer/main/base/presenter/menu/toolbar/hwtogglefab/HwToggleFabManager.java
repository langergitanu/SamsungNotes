package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtogglefab/HwToggleFabManager;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager$OnSipListener;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtogglefab/HwToggleFabContract$IView;", "<init>", "()V", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "toolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/ToolbarPresenter;", "softInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "init", "", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "onAttachView", "onDetachView", "needToUpdateToolbarVisibility", "", "updateVisibility", "setFabVisibility", "visible", "onShow", "onHide", "isTextMode", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HwToggleFabManager implements SoftInputManager.OnSipListener, HwToggleFabContract.IView {
    private Activity activity;
    private ComposerModel composerModel;
    private SoftInputManager softInputManager;
    private ToolbarPresenter toolbarPresenter;
    private View view;

    private final boolean isTextMode() {
        ComposerModel composerModel = this.composerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        return composerModel.getModeManager().getMode().equals(Mode.Text);
    }

    private final boolean needToUpdateToolbarVisibility() {
        ComposerModel composerModel = this.composerModel;
        Activity activity = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        if (!composerModel.getModeManager().isEditMode()) {
            return false;
        }
        ComposerModel composerModel2 = this.composerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel2 = null;
        }
        if (composerModel2.getComposerState().isFullScreenMode()) {
            return false;
        }
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity2 = null;
        }
        if (ResourceUtils.isTabletLayout(activity2)) {
            return false;
        }
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity3 = null;
        }
        if (activity3.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        WindowManagerCompat companion2 = companion.getInstance();
        Activity activity4 = this.activity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity4 = null;
        }
        if (companion2.getMultiWindowMode(activity4) == 0) {
            return true;
        }
        WindowManagerCompat companion3 = companion.getInstance();
        Activity activity5 = this.activity;
        if (activity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            activity5 = null;
        }
        if (2 != companion3.getMultiWindowMode(activity5)) {
            return false;
        }
        Activity activity6 = this.activity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
        } else {
            activity = activity6;
        }
        return ResourceUtils.isPhoneLayout(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachView$lambda$0(HwToggleFabManager hwToggleFabManager, View view) {
        ToolbarPresenter toolbarPresenter = hwToggleFabManager.toolbarPresenter;
        if (toolbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarPresenter");
            toolbarPresenter = null;
        }
        toolbarPresenter.onClickHwToggleFab();
        hwToggleFabManager.setFabVisibility(false);
    }

    private final void setFabVisibility(boolean visible) {
        View view = this.view;
        if (view == null) {
            return;
        }
        ToolbarPresenter toolbarPresenter = null;
        if (visible) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
                view = null;
            }
            view.setVisibility(0);
            ToolbarPresenter toolbarPresenter2 = this.toolbarPresenter;
            if (toolbarPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarPresenter");
            } else {
                toolbarPresenter = toolbarPresenter2;
            }
            toolbarPresenter.hide(false);
            return;
        }
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view = null;
        }
        view.setVisibility(8);
        ToolbarPresenter toolbarPresenter3 = this.toolbarPresenter;
        if (toolbarPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarPresenter");
        } else {
            toolbarPresenter = toolbarPresenter3;
        }
        toolbarPresenter.show(false);
    }

    public final void init(@NotNull ToolbarPresenter toolbarPresenter, @NotNull ControllerManager controllerManager, @NotNull ComposerModel composerModel) {
        Intrinsics.checkNotNullParameter(toolbarPresenter, "toolbarPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        this.softInputManager = softInputManager;
        this.toolbarPresenter = toolbarPresenter;
        this.composerModel = composerModel;
        if (softInputManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softInputManager");
            softInputManager = null;
        }
        softInputManager.addOnSipListener(this);
    }

    public final void onAttachView(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        View viewFindViewById = activity.findViewById(C9086R.id.hw_toggle_fab_container);
        this.view = viewFindViewById;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            viewFindViewById = null;
        }
        viewFindViewById.findViewById(C9086R.id.hw_toggle_fab).setOnClickListener(new ViewOnClickListenerC8556a(this, 29));
    }

    public final void onDetachView() {
        setFabVisibility(false);
        SoftInputManager softInputManager = this.softInputManager;
        if (softInputManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softInputManager");
            softInputManager = null;
        }
        softInputManager.removeOnSipListener(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
        if (needToUpdateToolbarVisibility() && isTextMode()) {
            setFabVisibility(false);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        if (needToUpdateToolbarVisibility() && isTextMode()) {
            setFabVisibility(true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabContract.IView
    public void updateVisibility() {
        SoftInputManager softInputManager = this.softInputManager;
        View view = null;
        if (softInputManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("softInputManager");
            softInputManager = null;
        }
        if (!softInputManager.isInputMethodShown()) {
            View view2 = this.view;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            } else {
                view = view2;
            }
            if (view.getVisibility() != 8) {
                setFabVisibility(false);
                return;
            }
            return;
        }
        View view3 = this.view;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            view = view3;
        }
        if (view.getVisibility() == 8) {
            if (needToUpdateToolbarVisibility()) {
                setFabVisibility(true);
            }
        } else {
            if (needToUpdateToolbarVisibility()) {
                return;
            }
            setFabVisibility(false);
        }
    }
}
