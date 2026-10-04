package com.samsung.android.support.senl.p148nt.composer.main.lockscreen.factory;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCoreTranslate;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuShare;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSupportedActivities;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAi;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.composer.listener.LsSpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.config.LockScreenConfig;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.keyguard.LsKeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.contextmenu.LsContextMenuCoreTranslate;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.contextmenu.LsContextMenuPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.contextmenu.LsContextMenuSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.contextmenu.LsContextMenuShare;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.contextmenu.LsContextMenuSupportedActivities;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.presenter.menu.p161ai.cover.LsAiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.option.LsOptionMenuEditMode;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.toolbar.p162hw.item.LsHwToolbarAiAssist;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.toolbar.p162hw.item.LsHwToolbarCustomToolbarSetting;
import com.samsung.android.support.senl.p148nt.composer.main.lockscreen.view.menu.toolbar.richtext.item.LsRtMenuAi;
import com.samsung.android.support.senl.p148nt.composer.main.popupnote.factory.PopupNoteComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u0010H\u0016J$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u00100\u001a\u0002012\u0006\u0010\u001d\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/lockscreen/factory/LsComponentFactory;", "Lcom/samsung/android/support/senl/nt/composer/main/popupnote/factory/PopupNoteComponentFactory;", "<init>", "()V", "createConfig", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/config/Config;", "createHwToolbarAiAssist", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItem;", "inflatedView", "Landroid/view/View;", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemContract;", "createHwToolbarCustomToolbarSetting", "createAiCoverMenuViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/cover/AiCoverMenuViewPresenter;", "getRichTextAiMenu", "Ljava/lang/Class;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/richtext/item/RtMenuAi;", "createOptionMenuCreator", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/option/OptionMenu;", "optionMenu", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "optionMenuPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/option/OptionMenuPresenter;", "createKeyguardPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/common/presenter/keyguard/KeyguardPresenter;", "createSpenConvertToTextListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenConvertToTextListenerImpl;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;", "taskController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/TaskController;", "progressController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ProgressController;", "softInputManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager;", "createContextMenuShare", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuShare;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "createContextMenuSaveToGallery", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuSaveToGallery;", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "createContextMenuPhotoEditor", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuPhotoEditor;", "createContextMenuSupportedActivities", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuSupportedActivities;", "createContextMenuCoreTranslate", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/contextmenu/ContextMenuCoreTranslate;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LsComponentFactory extends PopupNoteComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager.ComponentFactory
    @NotNull
    public AiCoverMenuViewPresenter createAiCoverMenuViewPresenter() {
        return new LsAiCoverMenuViewPresenter();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.popupnote.factory.PopupNoteComponentFactory, com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public Config createConfig() {
        return new LockScreenConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    @NotNull
    public ContextMenuCoreTranslate createContextMenuCoreTranslate(@NotNull ComposerViewPresenter presenter, @NotNull ControllerManager controllerManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        return new LsContextMenuCoreTranslate(presenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    @NotNull
    public ContextMenuPhotoEditor createContextMenuPhotoEditor(@NotNull ComposerViewPresenter presenter, @NotNull ControllerManager taskController) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(taskController, "taskController");
        return new LsContextMenuPhotoEditor(presenter, taskController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    @NotNull
    public ContextMenuSaveToGallery createContextMenuSaveToGallery(@NotNull ComposerViewPresenter presenter, @NotNull ControllerManager controllerManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        return new LsContextMenuSaveToGallery(presenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    @NotNull
    public ContextMenuShare createContextMenuShare(@NotNull ComposerViewPresenter presenter, @NotNull TaskController taskController) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(taskController, "taskController");
        return new LsContextMenuShare(presenter, taskController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    @NotNull
    public ContextMenuSupportedActivities createContextMenuSupportedActivities(@NotNull ComposerViewPresenter presenter, @NotNull ControllerManager controllerManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        return new LsContextMenuSupportedActivities(presenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarOrderManager.ComponentFactory
    @NotNull
    public HwToolbarItem createHwToolbarAiAssist(@NotNull View inflatedView, @NotNull HwToolbarItemContract contract) {
        Intrinsics.checkNotNullParameter(inflatedView, "inflatedView");
        Intrinsics.checkNotNullParameter(contract, "contract");
        return new LsHwToolbarAiAssist(inflatedView, contract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarOrderManager.ComponentFactory
    @NotNull
    public HwToolbarItem createHwToolbarCustomToolbarSetting(@NotNull View inflatedView, @NotNull HwToolbarItemContract contract) {
        Intrinsics.checkNotNullParameter(inflatedView, "inflatedView");
        Intrinsics.checkNotNullParameter(contract, "contract");
        return new LsHwToolbarCustomToolbarSetting(inflatedView, contract);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NotNull
    public KeyguardPresenter createKeyguardPresenter() {
        return new LsKeyguardPresenter();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NotNull
    public OptionMenu createOptionMenuCreator(@Nullable OptionMenu optionMenu, @Nullable FragmentActivity activity, @NotNull OptionMenuPresenter optionMenuPresenter) {
        Intrinsics.checkNotNullParameter(optionMenuPresenter, "optionMenuPresenter");
        return new LsOptionMenuEditMode(activity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NotNull
    public SpenConvertToTextListenerImpl createSpenConvertToTextListener(@NotNull ListenerImplContract.IPresenter presenter, @NotNull TaskController taskController, @NotNull ProgressController progressController, @NotNull SoftInputManager softInputManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(taskController, "taskController");
        Intrinsics.checkNotNullParameter(progressController, "progressController");
        Intrinsics.checkNotNullParameter(softInputManager, "softInputManager");
        return new LsSpenConvertToTextListenerImpl(presenter, taskController, progressController, softInputManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.ComponentFactory
    @NotNull
    public Class<? extends RtMenuAi> getRichTextAiMenu() {
        return LsRtMenuAi.class;
    }
}
