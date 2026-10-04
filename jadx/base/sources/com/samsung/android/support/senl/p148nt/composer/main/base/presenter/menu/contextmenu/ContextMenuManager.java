package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.MenuItemOnMenuItemClickListenerC8924a;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuManager implements ContextMenuContract {
    private static final String TAG = Logger.createTag("ContextMenuManager");
    private Activity mActivity;
    private final ComponentFactory mComponentFactory;
    protected Map<Integer, ContextMenuItem> mContextMenuItemMap;
    private DynamicTemplateController mDynamicTemplateController;
    private boolean mIsBodyTextMenuEnabled = true;
    private boolean mIsRecognitionMenuEnabled = true;
    protected ComposerViewPresenter mPresenter;
    private QuickSaveTimerController mQuickSaveTimerController;
    private TaskController mTaskController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory {
        ContextMenuCoreTranslate createContextMenuCoreTranslate(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager);

        ContextMenuPhotoEditor createContextMenuPhotoEditor(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager);

        ContextMenuSaveToGallery createContextMenuSaveToGallery(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager);

        ContextMenuShare createContextMenuShare(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull TaskController taskController);

        ContextMenuSupportedActivities createContextMenuSupportedActivities(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager);
    }

    public ContextMenuManager(@NonNull ComponentFactory componentFactory) {
        this.mComponentFactory = componentFactory;
    }

    private void addCloseMenu(Menu menu) {
        int i;
        if (this.mActivity == null || DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mActivity) || (i = ContextMenuConstants.CONTEXT_MENU_ID_CLOSE) <= 0) {
            return;
        }
        menu.add(0, i, 0, this.mActivity.getResources().getString(C9086R.string.composer_string_close));
    }

    private void addContextMenu(Menu menu, boolean z) {
        boolean zHasObjectLock = hasObjectLock();
        for (ContextMenuItem contextMenuItem : this.mContextMenuItemMap.values()) {
            if (!zHasObjectLock || !contextMenuItem.isLockRelated()) {
                if (z || !contextMenuItem.isForOnlyActionMode()) {
                    if (z || contextMenuItem.canShow()) {
                        contextMenuItem.addMenu(menu);
                    }
                }
            }
        }
    }

    @Nullable
    private ContextMenuItem getContextMenuItem(int i) {
        return this.mContextMenuItemMap.get(Integer.valueOf(i));
    }

    private boolean hasObjectLock() {
        List<SpenObjectBase> selectedObjectList = this.mPresenter.getObjectManager().getSelectedObjectList();
        if (selectedObjectList == null || selectedObjectList.isEmpty()) {
            Logger.m11003i(TAG, "hasObjectLock# getSelectedObjectList is empty");
            return false;
        }
        Iterator<SpenObjectBase> it = selectedObjectList.iterator();
        while (it.hasNext()) {
            if (it.next().getLockState()) {
                return true;
            }
        }
        return false;
    }

    private void initBodyTextMenu(ComposerViewPresenter composerViewPresenter) {
        if (this.mIsBodyTextMenuEnabled) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ANCHOR_TO_TEXT.getId()), new ContextMenuAnchorToText(composerViewPresenter, this.mTaskController));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REMOVE_ANCHOR_TO_TEXT.getId()), new ContextMenuRemoveAnchorToText(composerViewPresenter, this.mTaskController));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_WRAP.getId()), new ContextMenuTextWrap(composerViewPresenter));
        }
    }

    private void initCalculateModeMenu(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter, AiMenuManager aiMenuManager) {
        if (FeatureUtils.isSolveMathSupported()) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_MATH.getId()), new ContextMenuConvertToMath(composerViewPresenter, hwToolbarPresenter, this.mTaskController));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CALCULATE_MODE_OFF.getId()), new ContextMenuCalculatedModeOff(composerViewPresenter, hwToolbarPresenter, aiMenuManager));
        }
    }

    private void initCloseContextMenuId() {
        try {
            if (ContextMenuConstants.CONTEXT_MENU_ID_CLOSE != -1) {
                return;
            }
            ContextMenuConstants.CONTEXT_MENU_ID_CLOSE = Resources.getSystem().getIdentifier("floatingToolbarClose", "id", TelemetryEventStrings.C6439Os.OS_NAME);
        } catch (Exception e) {
            Logger.m11001e(TAG, "Resources floatingToolbarClose  ", e);
        }
    }

    private void initDynamicTemplateMenu(ComposerViewPresenter composerViewPresenter) {
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REPLACE_IMAGE_BY_IMAGE_PICKER.getId()), new ContextMenuReplaceImageByImagePicker(composerViewPresenter, this.mDynamicTemplateController));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REPLACE_IMAGE_BY_DRAWING_TOOLKIT.ordinal()), new ContextMenuReplaceImageByDrawingToolkit(composerViewPresenter, this.mDynamicTemplateController));
    }

    private void initFitToPageWidthMenu(ComposerViewPresenter composerViewPresenter) {
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIT_TO_PAGE_WIDTH.getId()), new ContextMenuFitToPageWidth(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_RESIZE_TO_DEFAULT.getId()), new ContextMenuResizeToDefault(composerViewPresenter));
    }

    private void initRecognitionRelatedMenu(ComposerViewPresenter composerViewPresenter, HwToolbarPresenter hwToolbarPresenter) {
        if (this.mIsRecognitionMenuEnabled && RecognitionUtil.isSupported(this.mActivity)) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_TEXT.getId()), new ContextMenuConvertToText(composerViewPresenter, hwToolbarPresenter));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_RECOGNITION.getId()), new ContextMenuTextRecognition(composerViewPresenter, hwToolbarPresenter));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_ALIGNMENT.getId()), new ContextMenuAlignment(composerViewPresenter, hwToolbarPresenter));
        }
    }

    private void initSpenSDKMenu() {
    }

    private boolean isShowContextMenu(int i) {
        return i == ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createContextMenu$0(MenuItem menuItem) {
        Logger.m10999d(TAG, "onMenuItemClick# " + menuItem);
        executeMenuItem(menuItem, false);
        return true;
    }

    private void updateDeleteOnlyState(Menu menu) {
        ContextMenuItem contextMenuItem;
        if (this.mPresenter.getComposerModel().getModeManager().isDeleteOnlyMode()) {
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE_AS_PLAIN_TEXT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ADD_TEXT_BOX.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_BRING_TO_FRONT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_SEND_TO_BACK.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_CHANGE_STYLE.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_RENAME.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CROP.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_LASSO_CROP.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_DRAWING.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PHOTO_EDITOR.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_WEB_CLIP.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SCAN_TEXT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_HBD_TRANSLATE.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_LOCK.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ANCHOR_TO_TEXT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REMOVE_ANCHOR_TO_TEXT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_WRAP.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_TEXT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_MATH.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_HANDWRITING.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_RECOGNITION.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_ALIGNMENT.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIT_TO_PAGE_WIDTH.getId());
            menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_RESIZE_TO_DEFAULT.getId());
            menu.removeItem(ContextMenuConstants.getWritingToolkitId());
            if (menu.findItem(16908353) == null || (contextMenuItem = this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_IMAGE_STYLE_CHANGER.getId()))) == null || !contextMenuItem.canShow()) {
                return;
            }
            menu.removeItem(16908353);
        }
    }

    private void updateDynamicTemplateState(Menu menu) {
        Iterator<SpenObjectBase> it = this.mPresenter.getObjectManager().getSelectedObjectList().iterator();
        while (it.hasNext()) {
            if (DynamicTemplateUtil.isDynamicTemplateObject(it.next())) {
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ANCHOR_TO_TEXT.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_REMOVE_ANCHOR_TO_TEXT.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_LOCK.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_TEXT_WRAP.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_FIT_TO_PAGE_WIDTH.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_BRING_TO_FRONT.ordinal());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_SEND_TO_BACK.getId());
                menu.removeItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD.getId());
                return;
            }
        }
    }

    public boolean canMakeContextMenu() {
        AiDrawingState aiDrawingState = this.mPresenter.getComposerModel().getAiDrawingState();
        if (AiDrawingUtil.isIgnoreContextState(aiDrawingState)) {
            Logger.m11003i(TAG, "canMakeContextMenu, aiDrawingState: " + aiDrawingState);
            return false;
        }
        if (ObjectTypeUtil.hasMathType(this.mPresenter.getObjectManager().getSelectedObjectList())) {
            Logger.m11003i(TAG, "canMakeContextMenu, hasMathType:");
            return false;
        }
        if (!this.mPresenter.getObjectManager().getSelectedObjectManager().isSelectedTable() || this.mPresenter.getObjectManager().getSelectedObjectManager().isFocusedTable()) {
            return true;
        }
        Logger.m11003i(TAG, "canMakeContextMenu, has Table");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract
    public boolean canShowContextMenu(Menu menu) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (menu.getItem(i).isEnabled()) {
                return true;
            }
        }
        return false;
    }

    public void checkIfShowContextMenu(Menu menu) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            if (item.isEnabled() && item.getItemId() != ContextMenuConstants.CONTEXT_MENU_ID_CLOSE) {
                return;
            }
        }
        menu.removeItem(ContextMenuConstants.CONTEXT_MENU_ID_CLOSE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract
    public boolean createContextMenu(Menu menu, boolean z) {
        if (!canMakeContextMenu()) {
            return true;
        }
        this.mPresenter.getComposerModel().setMenuDirty("ContextMenu");
        if (z) {
            addCloseMenu(menu);
        }
        addContextMenu(menu, z);
        if (!z) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                if (item.isEnabled()) {
                    item.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC8924a(this, 2));
                }
            }
        }
        checkIfShowContextMenu(menu);
        QuickSaveTimerController quickSaveTimerController = this.mQuickSaveTimerController;
        if (quickSaveTimerController != null) {
            quickSaveTimerController.reset("createContextMenu");
        }
        updateDeleteOnlyState(menu);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract
    public void executeMenuItem(MenuItem menuItem, boolean z) {
        ContextMenuItem contextMenuItem;
        String str = TAG;
        Logger.m11003i(str, "SpenContextMenuListener$executeMenuItem# " + menuItem.getItemId());
        if (this.mPresenter.isLockedScreen()) {
            Logger.m11003i(str, "SpenContextMenuListener$executeMenuItem# Progress is running. So it is returned.");
            return;
        }
        int itemId = menuItem.getItemId();
        if (itemId != ContextMenuConstants.CONTEXT_MENU_ID_CLOSE) {
            if (itemId == 100) {
                itemId = 16908353;
            }
            ContextMenuItem contextMenuItem2 = getContextMenuItem(itemId);
            if (itemId == ContextMenuConstants.getWritingToolkitId() && (contextMenuItem = getContextMenuItem(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_IMAGE_STYLE_CHANGER.getId())) != null && contextMenuItem.canShow()) {
                contextMenuItem2 = contextMenuItem;
            }
            if (contextMenuItem2 == null || !contextMenuItem2.canShow()) {
                Logger.m11000e(str, "SpenContextMenuListener$executeMenuItem# The canShow conditions were changed. So it is returned.");
                return;
            } else {
                if (itemId == ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD.getId()) {
                    ((ContextMenuClipboard) contextMenuItem2).setClearSkip(z);
                }
                contextMenuItem2.executeMenu(menuItem);
            }
        }
        this.mPresenter.setContextMenu(isShowContextMenu(menuItem.getItemId()));
    }

    public ContextMenuItem getContextMenu(int i) {
        return this.mContextMenuItemMap.get(Integer.valueOf(i));
    }

    public void init(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, HwToolbarPresenter hwToolbarPresenter, DialogPresenterManager dialogPresenterManager, QuickSaveTimerController quickSaveTimerController, VoiceRecordMenuPresenter voiceRecordMenuPresenter, AiMenuManager aiMenuManager, DynamicTemplateController dynamicTemplateController, StickyMemoManager stickyMemoManager) {
        this.mPresenter = composerViewPresenter;
        this.mActivity = composerViewPresenter.getActivity();
        this.mQuickSaveTimerController = quickSaveTimerController;
        this.mTaskController = controllerManager.getTaskController();
        this.mDynamicTemplateController = dynamicTemplateController;
        int semPlatformVersionInt = DeviceInfo.getSemPlatformVersionInt(0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.mContextMenuItemMap = linkedHashMap;
        linkedHashMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CUT.getId()), new ContextMenuCut(composerViewPresenter, this.mTaskController, this.mDynamicTemplateController));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_COPY.getId()), new ContextMenuCopy(composerViewPresenter, this.mTaskController));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId()), new ContextMenuPaste(composerViewPresenter, controllerManager, aiMenuManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE_AS_PLAIN_TEXT.getId()), new ContextMenuPasteAsPlainText(composerViewPresenter, controllerManager, aiMenuManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_DELETE.getId()), new ContextMenuDelete(composerViewPresenter, this.mTaskController, this.mDynamicTemplateController));
        if (semPlatformVersionInt < 150100) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_DICTIONARY.getId()), new ContextMenuDictionary(composerViewPresenter));
        }
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CLIPBOARD.getId()), new ContextMenuClipboard(composerViewPresenter, controllerManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_ADD_TEXT_BOX.getId()), new ContextMenuAddTextBox(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SELECT_ALL.getId()), new ContextMenuSelectAll(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SHARE.getId()), this.mComponentFactory.createContextMenuShare(composerViewPresenter, this.mTaskController));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_BRING_TO_FRONT.getId()), new ContextMenuBringToFront(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_SEND_TO_BACK.getId()), new ContextMenuSendToBack(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SAVE_TO_GALLERY.getId()), this.mComponentFactory.createContextMenuSaveToGallery(composerViewPresenter, controllerManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_CHANGE_STYLE.getId()), new ContextMenuChangeStyle(composerViewPresenter, hwToolbarPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_RENAME.getId()), new ContextMenuRename(composerViewPresenter, dialogPresenterManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CROP.getId()), new ContextMenuCrop(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_LASSO_CROP.getId()), new ContextMenuLassoCrop(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_DRAWING.getId()), new ContextMenuDrawing(composerViewPresenter, controllerManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PLAY.getId()), new ContextMenuPlay(composerViewPresenter, dialogPresenterManager, controllerManager.getVoiceRecordingController(), voiceRecordMenuPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PHOTO_EDITOR.getId()), this.mComponentFactory.createContextMenuPhotoEditor(composerViewPresenter, controllerManager));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_WEB_CLIP.getId()), new ContextMenuWebClip(composerViewPresenter, this.mTaskController));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_OBJECT_LOCK.getId()), new ContextMenuObjectLock(composerViewPresenter));
        this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_STICKY_MEMO.getId()), new ContextMenuStickyMemo(stickyMemoManager, composerViewPresenter));
        if (semPlatformVersionInt < 150100 && semPlatformVersionInt > 130100) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_SCAN_TEXT.getId()), new ContextMenuScanText(composerViewPresenter));
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_HBD_TRANSLATE.getId()), new ContextMenuHBDTranslate(composerViewPresenter));
        }
        if (semPlatformVersionInt >= 150100) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CORE_TRANSLATE.getId()), this.mComponentFactory.createContextMenuCoreTranslate(composerViewPresenter, controllerManager));
        }
        initBodyTextMenu(composerViewPresenter);
        initFitToPageWidthMenu(composerViewPresenter);
        initRecognitionRelatedMenu(composerViewPresenter, hwToolbarPresenter);
        initCalculateModeMenu(composerViewPresenter, hwToolbarPresenter, aiMenuManager);
        initDynamicTemplateMenu(composerViewPresenter);
        initSpenSDKMenu();
        if (!this.mPresenter.getComposerModel().getMdeManager().getMdeInfo().isMde() && ContextMenuWritingToolkit.isSupportedAIVersion()) {
            if (ContextMenuWritingToolkit.isSupported(composerViewPresenter.getActivity())) {
                this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.getWritingToolkitId()), new ContextMenuWritingToolkit(composerViewPresenter));
            }
            if (ContextMenuImageStyleChanger.isSupported(composerViewPresenter.getActivity())) {
                this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_IMAGE_STYLE_CHANGER.getId()), new ContextMenuImageStyleChanger(composerViewPresenter, controllerManager));
            }
        }
        this.mContextMenuItemMap.put(16908353, new ContextMenuSmartSelection(composerViewPresenter));
        this.mContextMenuItemMap.put(200, this.mComponentFactory.createContextMenuSupportedActivities(composerViewPresenter, controllerManager));
        if (FeatureInfo.isSupportHyperLinkEdit()) {
            this.mContextMenuItemMap.put(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CONVERT_TO_TEXT_LINK.getId()), new ContextMenuConvertToTextLink(composerViewPresenter));
        }
        initCloseContextMenuId();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == ComposerRequestCode.ImageEditor.getId()) {
            ContextMenuPhotoEditor contextMenuPhotoEditor = (ContextMenuPhotoEditor) this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PHOTO_EDITOR.getId()));
            if (contextMenuPhotoEditor != null) {
                contextMenuPhotoEditor.onActivityResult(i2, intent);
            }
            return true;
        }
        if (i == ComposerRequestCode.ProcessText.getId() || i == ComposerRequestCode.SettingContextMenu.getId()) {
            ContextMenuSupportedActivities contextMenuSupportedActivities = (ContextMenuSupportedActivities) this.mContextMenuItemMap.get(200);
            if (contextMenuSupportedActivities != null) {
                contextMenuSupportedActivities.onActivityResult(i, i2, intent);
            }
            return true;
        }
        if (i == ComposerRequestCode.CoreTranslator.getId()) {
            ContextMenuCoreTranslate contextMenuCoreTranslate = (ContextMenuCoreTranslate) this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CORE_TRANSLATE.getId()));
            if (contextMenuCoreTranslate != null) {
                contextMenuCoreTranslate.onActivityResult(i2, intent);
            }
            return true;
        }
        if (i == ComposerRequestCode.WritingToolkit.getId()) {
            ContextMenuWritingToolkit contextMenuWritingToolkit = (ContextMenuWritingToolkit) this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.getWritingToolkitId()));
            if (contextMenuWritingToolkit != null) {
                contextMenuWritingToolkit.onActivityResult(i2, intent);
            }
            return true;
        }
        if (i != ComposerRequestCode.ImageStyleChanger.getId()) {
            return false;
        }
        ContextMenuImageStyleChanger contextMenuImageStyleChanger = (ContextMenuImageStyleChanger) this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_IMAGE_STYLE_CHANGER.getId()));
        if (contextMenuImageStyleChanger != null) {
            contextMenuImageStyleChanger.onActivityResult(i2, intent);
        }
        return true;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        Iterator<ContextMenuItem> it = this.mContextMenuItemMap.values().iterator();
        while (it.hasNext()) {
            it.next().onAttachView(activity);
        }
    }

    public void onDetachView() {
        this.mActivity = null;
        Iterator<ContextMenuItem> it = this.mContextMenuItemMap.values().iterator();
        while (it.hasNext()) {
            it.next().onDetachView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuContract
    public boolean onPerformContextMenuAction(int i) {
        int id;
        switch (i) {
            case R.id.cut:
                id = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CUT.getId();
                break;
            case R.id.copy:
                id = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_COPY.getId();
                break;
            case R.id.paste:
                id = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PASTE.getId();
                break;
            default:
                id = ContextMenuConstants.CONTEXT_MENU_ID_CLOSE;
                break;
        }
        Logger.m11003i(TAG, "onPerformContextMenuAction# " + id);
        ContextMenuItem contextMenu = getContextMenu(id);
        if (contextMenu == null || !contextMenu.canShow()) {
            return false;
        }
        contextMenu.executeMenu();
        return true;
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 110 && i != 107 && i != 126 && i != 666 && i != 136) {
            return false;
        }
        if (!PermissionHelper.verifyRequestResult(this.mActivity, iArr, strArr)) {
            Logger.m11003i(TAG, "onRequestPermissionsResult# permission is not granted.");
            return true;
        }
        if (i != 666) {
            this.mTaskController.executePendingTask();
            return true;
        }
        ContextMenuWritingToolkit contextMenuWritingToolkit = (ContextMenuWritingToolkit) this.mContextMenuItemMap.get(Integer.valueOf(ContextMenuConstants.getWritingToolkitId()));
        if (contextMenuWritingToolkit == null) {
            return true;
        }
        contextMenuWritingToolkit.executeMenu();
        return true;
    }

    public void setBodyTextMenuEnabled(boolean z) {
        this.mIsBodyTextMenuEnabled = z;
    }

    public void setRecognitionMenuEnabled(boolean z) {
        this.mIsRecognitionMenuEnabled = z;
    }
}
