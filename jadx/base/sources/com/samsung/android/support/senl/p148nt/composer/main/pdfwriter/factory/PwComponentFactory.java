package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.factory;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSelectionController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ContextMenuListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenObjectSelectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.TextStateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.composer.PwObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.menu.toolbar.p163hw.setting.data.PwSettingToolbarPhoneItemData;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.menu.toolbar.p163hw.setting.data.PwSettingToolbarTabletItemData;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.PwFragmentPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.PwComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.controller.PwComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.controller.PwComposerSelectionController;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener.PwActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener.PwControlObjectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener.PwOnDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener.PwSpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener.PwSpenObjectSelectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.config.PwConfig;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwDialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.PwMenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.toolbar.hwtoolbar.PwHwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.PwDialogCreator;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.menu.option.PwOptionMenuCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwComponentFactory extends BaseComponentFactory {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public ActionListenerImpl createActionListener(@NonNull ListenerImplContract.IView iView, @NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull ContextMenuListenerImpl contextMenuListenerImpl) {
        return new PwActionListenerImpl(iView, iPresenter, controllerManager, contextMenuListenerImpl);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerModeController createComposerModeController() {
        return new PwComposerModeController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerModel createComposerModel(@NonNull Activity activity) {
        return new PwComposerModel(activity, getConfig());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerSelectionController createComposerSelectionController() {
        return new PwComposerSelectionController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerViewPresenter createComposerViewPresenter(@NonNull KeyguardPresenter keyguardPresenter) {
        return new PwComposerViewPresenter(this, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public Config createConfig() {
        return new PwConfig();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public ControlObjectListenerImpl createControlObjectListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController) {
        return new PwControlObjectListenerImpl(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NonNull
    public DialogContract.IDialogCreator createDialogCreator() {
        return new PwDialogCreator();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public DialogPresenterManager createDialogPresenterManager() {
        return new PwDialogPresenterManager(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public HwToolbarPresenter createHwToolbarPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull KeyguardPresenter keyguardPresenter) {
        return new PwHwToolbarPresenter(iMenuManager, composerViewPresenter, controllerManager, dialogPresenterManager, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public MenuPresenterManager createMenuPresenterManager(@NonNull MenuPresenterContract.IMenuParent iMenuParent) {
        return new PwMenuPresenterManager(iMenuParent, this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.ComponentFactory
    @NonNull
    public ObjectManager createObjectManager() {
        return new PwObjectManager(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenObjectSelectListenerImpl createObjectSelectListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull SoftInputManager softInputManager, @NonNull TextStateHandler textStateHandler) {
        return new PwSpenObjectSelectListenerImpl(iPresenter, softInputManager, textStateHandler);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public OnDragListenerImpl createOnDragListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager) {
        return new PwOnDragListenerImpl(iPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.ComponentFactory
    @NonNull
    public OptionMenuBackPresenter createOptionMenuBackPresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull MenuPresenterContract.IMenuManager iMenuManager) {
        return new PwOptionMenuBackPresenter(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager, iMenuManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public OptionMenu createOptionMenuCreator(OptionMenu optionMenu, FragmentActivity fragmentActivity, @NonNull OptionMenuPresenter optionMenuPresenter) {
        return new PwOptionMenuCreator().createOptionMenu(optionMenu, fragmentActivity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public OptionMenuPresenter createOptionMenuPresenter() {
        return new PwOptionMenuPresenter(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter.ComponentFactory
    @NonNull
    public OptionMenuPdfPresenter createPdfPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull ControllerManager controllerManager) {
        return new PwOptionMenuPdfPresenter(iMenuManager, composerViewPresenter, composerModel, controllerManager.getTaskController(), controllerManager.getQuickSaveTimer());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory
    @NonNull
    public BaseComposerPresenter createPresenter() {
        return new PwFragmentPresenter(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogPresenterManager.ComponentFactory
    public SaveNoteConfirmDialogPresenter createSaveNoteConfirmDialogPresenter(@NonNull DialogContract.IParent iParent, @NonNull DialogContract.IDialogCreator iDialogCreator, @NonNull ComposerModel composerModel, @NonNull PageManager pageManager) {
        return new PwDialogPresenterManager.PwSaveNoteConfirmDialogPresenter(iParent, iDialogCreator, composerModel, pageManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager.ComponentFactory
    @NonNull
    public SettingToolbarItemData createSettingToolbarPhoneItemData() {
        return new PwSettingToolbarPhoneItemData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager.ComponentFactory
    @NonNull
    public SettingToolbarItemData createSettingToolbarTabletItemData() {
        return new PwSettingToolbarTabletItemData();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.ComponentFactory
    @NonNull
    public OptionMenuSharePresenter createSharePresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager) {
        return new PwOptionMenuSharePresenter(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory, com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenConvertToTextListenerImpl createSpenConvertToTextListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull TaskController taskController, @NonNull ProgressController progressController, @NonNull SoftInputManager softInputManager) {
        return new PwSpenConvertToTextListenerImpl(iPresenter, taskController, progressController, softInputManager);
    }
}
