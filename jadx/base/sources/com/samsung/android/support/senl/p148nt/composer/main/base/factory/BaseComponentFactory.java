package com.samsung.android.support.senl.p148nt.composer.main.base.factory;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarPhoneItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarTabletItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSelectionController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ContextMenuListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.PageActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenNotePdfActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenObjectSelectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.TextStateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.config.BaseConfig;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.keyguard.BaseKeyguardPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCoreTranslate;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuShare;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuSupportedActivities;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.AttachMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuSharePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.CustomSaveStrategy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ModeObserver;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.ToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarAiAssist;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarCustomToolbarSetting;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuAi;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseComponentFactory implements RtToolbarMenu.ComponentFactory, BaseComposerPresenter.ComponentFactory, ComposerViewPresenter.ComponentFactory, BaseSubManager.ComponentFactory, MenuPresenterManager.ComponentFactory, OptionMenuPresenter.ComponentFactory, ComposerControllerManager.ComponentFactory, HwToolbarOrderManager.ComponentFactory, ListenerManager.ComponentFactory, AiMenuManager.ComponentFactory, SettingInfoManager.ComponentFactory, OptionMenuAddPresenter.ComponentFactory, ToolbarManager.ComponentFactory, DialogPresenterManager.ComponentFactory, ContextMenuManager.ComponentFactory {
    private Config mConfig = createConfig();

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public ActionListenerImpl createActionListener(@NonNull ListenerImplContract.IView iView, @NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull ContextMenuListenerImpl contextMenuListenerImpl) {
        return new ActionListenerImpl(iView, iPresenter, controllerManager, contextMenuListenerImpl);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.AiMenuManager.ComponentFactory
    @NonNull
    public AiCoverMenuViewPresenter createAiCoverMenuViewPresenter() {
        return new AiCoverMenuViewPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public AiMenuManager createAiMenuManager() {
        return new AiMenuManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public AttachMenuPresenter createAttachMenuPresenter() {
        return new AttachMenuPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerModeController createComposerModeController() {
        return new ComposerModeController();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerModel createComposerModel(@NonNull Activity activity) {
        return new ComposerModel(activity, getConfig());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.ComposerControllerManager.ComponentFactory
    @NonNull
    public ComposerSelectionController createComposerSelectionController() {
        return new ComposerSelectionController();
    }

    @NonNull
    public ComposerView createComposerView(FragmentActivity fragmentActivity) {
        return new ComposerView(fragmentActivity, getConfig());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ComposerViewPresenter createComposerViewPresenter(@NonNull KeyguardPresenter keyguardPresenter) {
        return new ComposerViewPresenter(this, keyguardPresenter);
    }

    @NonNull
    public Config createConfig() {
        return new BaseConfig();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    public ContextMenuCoreTranslate createContextMenuCoreTranslate(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager) {
        return new ContextMenuCoreTranslate(composerViewPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public ContextMenuManager createContextMenuManager() {
        return new ContextMenuManager(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    public ContextMenuPhotoEditor createContextMenuPhotoEditor(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager) {
        return new ContextMenuPhotoEditor(composerViewPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    public ContextMenuSaveToGallery createContextMenuSaveToGallery(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager) {
        return new ContextMenuSaveToGallery(composerViewPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    public ContextMenuShare createContextMenuShare(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull TaskController taskController) {
        return new ContextMenuShare(composerViewPresenter, taskController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager.ComponentFactory
    public ContextMenuSupportedActivities createContextMenuSupportedActivities(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager) {
        return new ContextMenuSupportedActivities(composerViewPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public ControlObjectListenerImpl createControlObjectListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController) {
        return new ControlObjectListenerImpl(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NonNull
    public CustomSaveStrategy createCustomSaveStrategy() {
        return new CustomSaveStrategy();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NonNull
    public DialogContract.IDialogCreator createDialogCreator() {
        return new DialogCreator();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public DialogPresenterManager createDialogPresenterManager() {
        return new DialogPresenterManager(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarOrderManager.ComponentFactory
    @NonNull
    public HwToolbarItem createHwToolbarAiAssist(View view, HwToolbarItemContract hwToolbarItemContract) {
        return new HwToolbarAiAssist(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarOrderManager.ComponentFactory
    @NonNull
    public HwToolbarItem createHwToolbarCustomToolbarSetting(View view, HwToolbarItemContract hwToolbarItemContract) {
        return new HwToolbarCustomToolbarSetting(view, hwToolbarItemContract);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public HwToolbarPresenter createHwToolbarPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull KeyguardPresenter keyguardPresenter) {
        return new HwToolbarPresenter(iMenuManager, composerViewPresenter, controllerManager, dialogPresenterManager, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public KeyguardPresenter createKeyguardPresenter() {
        return new BaseKeyguardPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.BaseComposerPresenter.ComponentFactory
    @NonNull
    public MenuAttachManager createMenuAttachManager(BaseSubManager baseSubManager) {
        return new MenuAttachManager(baseSubManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public MenuPresenterManager createMenuPresenterManager(@NonNull MenuPresenterContract.IMenuParent iMenuParent) {
        return new MenuPresenterManager(iMenuParent, this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.BaseSubManager.ComponentFactory
    @NonNull
    public ModeObserver createModeObserver() {
        return new ModeObserver();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.ComponentFactory
    @NonNull
    public ObjectManager createObjectManager() {
        return new ObjectManager(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenObjectSelectListenerImpl createObjectSelectListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull SoftInputManager softInputManager, @NonNull TextStateHandler textStateHandler) {
        return new SpenObjectSelectListenerImpl(iPresenter, softInputManager, textStateHandler);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public OnDragListenerImpl createOnDragListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager) {
        return new OnDragListenerImpl(iPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.ComponentFactory
    @NonNull
    public OptionMenuBackPresenter createOptionMenuBackPresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull MenuPresenterContract.IMenuManager iMenuManager) {
        return new OptionMenuBackPresenter(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager, iMenuManager);
    }

    @NonNull
    public OptionMenu createOptionMenuCreator(OptionMenu optionMenu, FragmentActivity fragmentActivity, @NonNull OptionMenuPresenter optionMenuPresenter) {
        return new OptionMenuCreator().createOptionMenu(optionMenu, fragmentActivity, optionMenuPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager.ComponentFactory
    @NonNull
    public OptionMenuPresenter createOptionMenuPresenter() {
        return new OptionMenuPresenter(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public PageActionListenerImpl createPageActionListenerImpl(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ProgressController progressController) {
        return new PageActionListenerImpl(iPresenter, progressController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter.ComponentFactory
    @NonNull
    public OptionMenuPdfPresenter createPdfPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull ControllerManager controllerManager) {
        return new OptionMenuPdfPresenter(iMenuManager, composerViewPresenter, composerModel, controllerManager.getTaskController(), controllerManager.getQuickSaveTimer());
    }

    @NonNull
    public BaseComposerPresenter createPresenter() {
        return new BaseComposerPresenter(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogPresenterManager.ComponentFactory
    public SaveNoteConfirmDialogPresenter createSaveNoteConfirmDialogPresenter(@NonNull DialogContract.IParent iParent, @NonNull DialogContract.IDialogCreator iDialogCreator, @NonNull ComposerModel composerModel, @NonNull PageManager pageManager) {
        return new SaveNoteConfirmDialogPresenter(iParent, iDialogCreator, composerModel, pageManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager.ComponentFactory
    @NonNull
    public SettingToolbarItemData createSettingToolbarPhoneItemData() {
        return new SettingToolbarPhoneItemData();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager.ComponentFactory
    @NonNull
    public SettingToolbarItemData createSettingToolbarTabletItemData() {
        return new SettingToolbarTabletItemData();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuPresenter.ComponentFactory
    @NonNull
    public OptionMenuSharePresenter createSharePresenter(@NonNull ControllerManager controllerManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull DialogPresenterManager dialogPresenterManager) {
        return new OptionMenuSharePresenter(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenConvertToTextListenerImpl createSpenConvertToTextListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull TaskController taskController, @NonNull ProgressController progressController, @NonNull SoftInputManager softInputManager) {
        return new SpenConvertToTextListenerImpl(iPresenter, taskController, progressController, softInputManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenNotePdfActionListenerImpl createSpenNotePdfActionListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController) {
        return new SpenNotePdfActionListenerImpl(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerManager.ComponentFactory
    @NonNull
    public SpenTextManagerActionListenerImpl createSpenTextManagerActionListener(@NonNull ListenerImplContract.IPresenter iPresenter, @NonNull ControllerManager controllerManager, @NonNull DragAndDropController dragAndDropController) {
        return new SpenTextManagerActionListenerImpl(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.common.ModelManager.ComponentFactory
    @NonNull
    public TextManager createTextManager() {
        return new TextManager();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ControllerManager.ComponentFactory
    @NonNull
    public QuickSaveTimerController creteQuickSaveTimerController() {
        return new QuickSaveTimerController();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory
    @NonNull
    public Config getConfig() {
        return this.mConfig;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu.ComponentFactory
    @NonNull
    public Class<? extends RtMenuAi> getRichTextAiMenu() {
        return RtMenuAi.class;
    }

    public void updateConfig(@NonNull Config config) {
        this.mConfig = config;
    }
}
