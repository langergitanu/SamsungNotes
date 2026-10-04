package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.mde.OptionMenuLeave;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuEditMode extends OptionMenu {
    private static final String TAG = Logger.createTag("OptionMenuEditMode");
    private OptionMenuAdd mOptionMenuAdd;
    private OptionMenuDelete mOptionMenuDelete;
    private OptionMenuLeave mOptionMenuLeave;
    private OptionMenuSmartTip mOptionMenuSmartTip;
    private OptionMenuSolveMathSmartTip mOptionMenuSolveMathSmartTip;

    public OptionMenuEditMode(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        this.mType = 1;
        if (this.mPresenter.getSolveMathPresenter().isSupportState()) {
            this.mOptionMenuSolveMathSmartTip = new OptionMenuSolveMathSmartTip(activity);
        }
        if (ComposerSpenUtils.isSpenSupportChangeable()) {
            this.mOptionMenuSmartTip = new OptionMenuSmartTip(activity, this, optionMenuPresenter);
        }
    }

    private void disableDelete(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.hasDeletePermission()) {
            return;
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_delete));
    }

    private boolean doOptionsItemSelectedForViewModeMenu(int i) {
        if (i == C9086R.id.action_print) {
            ComposerSA.insertLog("411", ComposerSAConstants.EVENT_VIEW_PRINT);
            if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
                return true;
            }
            if (isTranslationOverlayActivated()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(2);
                return true;
            }
            if (this.mPresenter.isEmptyOnNewNote()) {
                ToastHandler.show(this.mActivity, C9086R.string.save_as_file_empty_content, 0);
                return true;
            }
            this.mPresenter.saveAndExecute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode.2
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuEditMode.this.mPresenter.onClickPrintBtn();
                }
            }, C9086R.string.save_to_print);
            return true;
        }
        if (i == C9086R.id.action_lock) {
            ComposerSA.insertLog("411", ComposerSAConstants.EVENT_VIEW_LOCK, this.mPresenter.isLockNote() ? "0" : "1");
            this.mPresenter.saveAndExecute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode.3
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuEditMode.this.mPresenter.onClickLockUnlock();
                }
            }, C9086R.string.save_to_lock);
            return true;
        }
        if (i == C9086R.id.action_search || i == C9086R.id.action_appbar_search) {
            this.mPresenter.onClickSearchBtn();
            ComposerSA.insertLog("411", ComposerSAConstants.EVENT_VIEW_SEARCH);
            return true;
        }
        if (i == C9086R.id.action_pin_to_home) {
            ComposerSA.insertLog("411", ComposerSAConstants.EVENT_VIEW_PINTOHOME);
            this.mPresenter.saveAndExecute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode.4
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuEditMode.this.mPresenter.onClickPinToHome();
                }
            }, C9086R.string.save_to_add_to_home_screen);
            return true;
        }
        if (i == C9086R.id.action_send_to_reminder) {
            ComposerSA.insertLog("411", ComposerSAConstants.EVENT_VIEW_ADDTOREMINDER);
            this.mPresenter.saveAndExecute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode.5
                @Override // java.lang.Runnable
                public void run() {
                    OptionMenuEditMode.this.mPresenter.onClickSendToReminder();
                }
            }, C9086R.string.save_to_add_to_reminder);
            return true;
        }
        if (i == C9086R.id.action_information) {
            this.mPresenter.onClickNoteInformation();
            return true;
        }
        if (i != C9086R.id.action_save_to_device) {
            return false;
        }
        this.mPresenter.onClickSaveToDeviceBtn(C9086R.string.composer_save_to_device_success);
        setSALogOfSaveToDeviceInMde();
        return true;
    }

    private void executePreCondition(int i) {
        this.mPresenter.setMenuDirty();
        if (i != C9086R.id.action_turn_on_off_finger_drawing && i != C9086R.id.action_full_screen_mode && i != C9086R.id.action_tablet_full_screen_mode && i != C9086R.id.action_start_in_app_collaboration && i != C9086R.id.action_notes_assist) {
            this.mPresenter.completeComposing();
        }
        if (i != 16908332) {
            this.mPresenter.releaseAiDrawingPopup(TAG);
            this.mPresenter.getSolveMathPresenter().onHideContextMenu();
        }
        this.mPresenter.getComposerViewPresenter().hideAiSuggestionView();
    }

    @StringRes
    private int getFingerDrawingTitle() {
        return this.mPresenter.isSpenOnlyMode() ? C9086R.string.composer_turn_on_finger_drawing : C9086R.string.composer_turn_off_finger_drawing;
    }

    private int getShowToolbarMenuTitle() {
        return this.mPresenter.isToolbarShowing() ? C9086R.string.composer_opt_hide_toolbar : C9086R.string.composer_opt_show_toolbar;
    }

    private boolean onDelete() {
        int i = (this.mPresenter.isMde() || FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel()) ? 2 : 1;
        if (this.mOptionMenuDelete == null) {
            this.mOptionMenuDelete = new OptionMenuDelete(this.mActivity, this.mPresenter);
        }
        this.mPresenter.clearSelectionForEachMode();
        this.mOptionMenuDelete.showDeleteConfirmDialog(i);
        return true;
    }

    private boolean onNavigateUp() {
        this.mPresenter.onClickNaviUpBtn();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, ResourceUtils.isTabletLayout(this.mActivity)), ComposerSAConstants.EVENT_EDIT_UP_BUTTON);
        return true;
    }

    private boolean onShareMenu() {
        this.mPresenter.clearSelectionForEachMode();
        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return true;
        }
        if (isTranslationOverlayActivated()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(1);
            return true;
        }
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_SHARE);
        } else if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_SHARE);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SHARE);
        }
        this.mOptionMenuShare.showPopupMenu(this.mActivity, this.mPresenter.getOptionMenuSharePresenter());
        return true;
    }

    private boolean onToggleToolbarVisibility(OptionMenuParam optionMenuParam) {
        this.mPresenter.onToggleToolbarVisibility();
        this.mOptionMenuBehavior.setTitle(optionMenuParam, getShowToolbarMenuTitle());
        return true;
    }

    private boolean onVstShareMenu(@NonNull OptionMenuParam optionMenuParam) {
        this.mPresenter.clearSelectionForEachMode();
        this.mPresenter.hideAiContextMenu();
        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return true;
        }
        if (isTranslationOverlayActivated()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(1);
            return true;
        }
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_SHARE);
        } else if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_EDIT_SHARE);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SHARE);
        }
        return true;
    }

    private void updateCalculateModeMenu(List<MenuItem> list) {
        for (MenuItem menuItem : list) {
            if (menuItem.getItemId() == C9086R.id.action_turn_on_off_calculate_mode) {
                menuItem.setVisible(this.mPresenter.getSolveMathPresenter().isSupportState());
                menuItem.setTitle(this.mPresenter.getSolveMathPresenter().isEnabled() ? C9086R.string.composer_turn_off_calculate_mode : C9086R.string.composer_turn_on_calculate_mode);
            }
        }
    }

    private void updateChangeNoteStyle(OptionMenuParam optionMenuParam) {
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_change_note_style), C9086R.string.composer_change_note_style);
    }

    private void updateDeleteOnlyState(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isDeleteOnly()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_finger_drawing));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_auto_change_mode));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_change_note_style));
        }
    }

    private void updateFingerDrawing(OptionMenuParam optionMenuParam) {
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_finger_drawing), getFingerDrawingTitle());
    }

    private void updateFingerDrawingMenu(@NonNull OptionMenuParam optionMenuParam) {
        if (ComposerSpenUtils.canUseSpen(this.mActivity)) {
            this.mOptionMenuBehavior.showMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_finger_drawing));
            updateFingerDrawing(optionMenuParam);
        } else {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_finger_drawing));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_auto_change_mode));
            this.mPresenter.getOptionMenuFingerDrawingPresenter().blockSmartTip();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateInputFormMenu(List<MenuItem> list) {
        boolean zHasInputField;
        ComposerViewPresenter composerViewPresenter = this.mPresenter.getComposerViewPresenter();
        if (composerViewPresenter.getComposerModel().isPDFReader()) {
            if (!this.mPresenter.isInputFormMode()) {
                DocPageInfo docPageInfo = composerViewPresenter.getPageManager().getDocPageInfo();
                int currentPageIndex = composerViewPresenter.getCurrentPageIndex();
                if (composerViewPresenter.getPdfManager().hasInputField(currentPageIndex)) {
                    zHasInputField = false;
                } else {
                    zHasInputField = true;
                    if (docPageInfo.getPageLayoutColumn() == 2) {
                        zHasInputField = true ^ composerViewPresenter.getPdfManager().hasInputField(currentPageIndex + 1);
                    }
                }
            }
            if (zHasInputField && removeOverFlowMenuItem(list, C9086R.id.action_turn_on_off_input_form)) {
                Logger.m10999d(getTag(), "updateInputFormMenu# remove input fields");
            }
        }
    }

    private void updateInputFormMode(OptionMenuParam optionMenuParam) {
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_input_form), this.mPresenter.isInputFormMode() ? C9086R.string.composer_hide_input_fields : C9086R.string.composer_show_input_fields);
    }

    private void updateLeave(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isLeaveEnabled()) {
            this.mOptionMenuBehavior.showMenu(optionMenuParam.setChildResId(C9086R.id.action_leave));
        }
    }

    private void updateReadMode(OptionMenuParam optionMenuParam) {
        boolean zIsReadOnlyMode = this.mPresenter.isReadOnlyMode();
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_read_mode), zIsReadOnlyMode ? C9086R.string.composer_reading_mode_turn_off : C9086R.string.composer_reading_mode_turn_on);
        this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_read_mode), AppCompatResources.getDrawable(this.mActivity, zIsReadOnlyMode ? C9086R.drawable.comp_appbar_ic_reading_mode_on : C9086R.drawable.comp_appbar_ic_reading_mode_off));
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
            this.mOptionMenuBehavior.setContentDescription(optionMenuParam.setChildResId(C9086R.id.action_read_mode), zIsReadOnlyMode ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected));
        }
    }

    private void updateSearchMenu(OptionMenuParam optionMenuParam) {
        if (DeviceInfo.isVSTModel()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_search));
        } else {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_appbar_search));
        }
    }

    private void updateShowToolbarMenu(OptionMenuParam optionMenuParam) {
        optionMenuParam.setChildResId(C9086R.id.action_show_toolbar);
        if (this.mPresenter.isInAppCollaborationMode()) {
            this.mOptionMenuBehavior.setTitle(optionMenuParam, getShowToolbarMenuTitle());
        } else {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam);
        }
    }

    private void updateViewModeOptionMenu(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSupportedViewMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_search));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_to));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_print));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_lock));
        }
    }

    @NonNull
    public OptionMenuAdd createOptionMenuAdd() {
        return new OptionMenuAdd(this.mActivity, this.mPresenter);
    }

    @MenuRes
    public int getMenuRes() {
        return this.mPresenter.isSimpleMode() ? C9086R.menu.composer_simple_view_menu : C9086R.menu.composer_edit_menu;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.base.winset.view.toolbar.IMenuInflater.OverflowMenu
    public void hideOverflowMenu() {
        OptionMenuAdd optionMenuAdd = this.mOptionMenuAdd;
        if (optionMenuAdd != null) {
            optionMenuAdd.hideAddMenuPopup();
        }
        OptionMenuSmartTip optionMenuSmartTip = this.mOptionMenuSmartTip;
        if (optionMenuSmartTip != null) {
            optionMenuSmartTip.hideSmartTip();
        }
        OptionMenuSolveMathSmartTip optionMenuSolveMathSmartTip = this.mOptionMenuSolveMathSmartTip;
        if (optionMenuSolveMathSmartTip != null) {
            optionMenuSolveMathSmartTip.hideSmartTip();
        }
        super.hideOverflowMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public boolean isNotValidEvent(int i) {
        if (this.mPresenter.isSettingPopupTouchOutside()) {
            return true;
        }
        return super.isNotValidEvent(i);
    }

    public boolean onAddMenu() {
        this.mPresenter.hideAiContextMenu();
        this.mPresenter.getComposerViewPresenter().getSoftInputManager().hide(false);
        if (this.mOptionMenuAdd == null) {
            this.mOptionMenuAdd = createOptionMenuAdd();
        }
        this.mOptionMenuAdd.showAddMenuPopup();
        if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_INSERT);
        } else {
            ComposerSA.insertLog(ComposerSA.getScreenID(true, false, ResourceUtils.isTabletLayout(this.mActivity)), ComposerSAConstants.EVENT_EDIT_INSERT);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OptionMenuAdd optionMenuAdd = this.mOptionMenuAdd;
        if (optionMenuAdd != null) {
            optionMenuAdd.hideAddMenuPopup();
        }
        OptionMenuSmartTip optionMenuSmartTip = this.mOptionMenuSmartTip;
        if (optionMenuSmartTip != null) {
            optionMenuSmartTip.onConfigurationChanged();
        }
        OptionMenuSolveMathSmartTip optionMenuSolveMathSmartTip = this.mOptionMenuSolveMathSmartTip;
        if (optionMenuSolveMathSmartTip != null) {
            optionMenuSolveMathSmartTip.onConfigurationChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onCreateOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onCreateOptionsMenu(optionMenuParam);
        if (optionMenuParam.getMenuInflater() == null) {
            Logger.m11000e(getTag(), "onCreateOptionsMenu# getMenuInflater is null");
            return;
        }
        optionMenuParam.getMenuInflater().inflateMenu(getMenuRes(), (Menu) optionMenuParam.getTarget(), this);
        updateSortPageMenu(optionMenuParam);
        updateSaveMenu(optionMenuParam);
        updateNotesAssistAndReadingModeMenu(optionMenuParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public boolean onExportMenu() {
        if (!ContentPickerUtils.canExportFileMenu(this.mActivity)) {
            return false;
        }
        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return true;
        }
        if (isTranslationOverlayActivated()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(0);
            return true;
        }
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_SAVE_AS);
        } else if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_SAVE_AS);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SAVE_AS);
        }
        this.mPresenter.clearSelectionForEachMode();
        this.mOptionMenuExport.showPopupMenu(this.mActivity, this.mPresenter.getOptionMenuSharePresenter());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i) {
        Logger.m11003i(getTag(), "onOptionsItemSelected# " + ((Object) this.mOptionMenuBehavior.getTitle(optionMenuParam)));
        if (this.mPresenter.isRunningProgress()) {
            Logger.m11003i(getTag(), "isRunningProgress true ");
            return false;
        }
        if (isNotValidEvent(i)) {
            Logger.m11003i(getTag(), "isValidEvent false");
            return false;
        }
        executePreCondition(i);
        if (i == 16908332) {
            zOnToggleToolbarVisibility = onNavigateUp();
        } else if (i == C9086R.id.action_add) {
            zOnToggleToolbarVisibility = onAddMenu();
        } else {
            if (i == C9086R.id.action_notes_assist) {
                this.mOptionMenuNotesAssist.showPopup(this.mActivity);
            } else if (i == C9086R.id.action_turn_on_off_input_form) {
                zOnToggleToolbarVisibility = this.mPresenter.onClickInputFormBtn();
            } else if (i == C9086R.id.action_start_in_app_collaboration) {
                this.mPresenter.onClickInAppCollaboration();
            } else if (i != C9086R.id.action_read_mode) {
                int i2 = C9086R.id.action_tablet_sort_pages;
                if (i == i2 || i == C9086R.id.action_sort_pages) {
                    this.mPresenter.insertSALogClickPageListBtn(i == i2, true);
                    this.mPresenter.onClickPageListBtn();
                } else if (i == C9086R.id.action_share) {
                    zOnToggleToolbarVisibility = onShareMenu();
                } else if (i == C9086R.id.action_export) {
                    zOnToggleToolbarVisibility = onExportMenu();
                } else if (i == C9086R.id.action_delete) {
                    zOnToggleToolbarVisibility = onDelete();
                } else {
                    if (i == C9086R.id.action_change_note_style) {
                        this.mPresenter.onClickChangeTemplate();
                        if (this.mPresenter.isInAppCollaborationMode()) {
                            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_PAGE_TEMPLATE);
                        } else if (this.mPresenter.isCoeditNote()) {
                            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_NOTE_STYLE);
                        } else {
                            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_NOTE_STYLE);
                        }
                    } else if (i == C9086R.id.action_page_setting) {
                        this.mPresenter.onClickPageSetting();
                        showPageSetting();
                        if (this.mPresenter.isInAppCollaborationMode()) {
                            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_PAGE_SETTINGS);
                        } else if (this.mPresenter.isCoeditNote()) {
                            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_PAGE_SETTINGS);
                        } else if (this.mPresenter.isSingleMode()) {
                            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_INFINITE_PAGE_SETTINGS);
                        } else {
                            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_PAGE_SETTINGS);
                        }
                    } else if (i == C9086R.id.action_add_favorite) {
                        this.mPresenter.onClickFavoriteBtn();
                        if (this.mPresenter.isInAppCollaborationMode()) {
                            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_EDIT_ADD_REMOVE_FAVORITES);
                        } else {
                            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_ADD_REMOVE_FAVORITES);
                        }
                    } else if (i == C9086R.id.action_add_edit_hash_tag) {
                        this.mPresenter.onClickHashTagBtn();
                    } else if (i == C9086R.id.action_turn_on_off_finger_drawing) {
                        this.mPresenter.onClickFingerDrawing();
                        this.mOptionMenuBehavior.setTitle(optionMenuParam, getFingerDrawingTitle());
                    } else if (i == C9086R.id.action_turn_on_off_calculate_mode) {
                        this.mPresenter.onClickCalculatedMode();
                    } else if (i == C9086R.id.action_save) {
                        this.mPresenter.onClickSave();
                    } else if (i == C9086R.id.action_full_screen_mode || i == C9086R.id.action_tablet_full_screen_mode) {
                        this.mPresenter.onFullScreenModeOn();
                        if (this.mPresenter.isPDFReader()) {
                            ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_FULL_SCREEN);
                        } else {
                            ComposerSA.insertLog(this.mPresenter.isCoeditNote() ? "683" : "401", ComposerSAConstants.EVENT_EDIT_FULL_SCREEN);
                        }
                    } else if (i == C9086R.id.action_show_toolbar) {
                        zOnToggleToolbarVisibility = onToggleToolbarVisibility(optionMenuParam);
                        ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_SHOW_HIDE_TOOLBAR);
                    } else if (i == C9086R.id.action_leave) {
                        if (this.mOptionMenuLeave == null) {
                            this.mOptionMenuLeave = new OptionMenuLeave(this.mActivity, this.mPresenter);
                        }
                        this.mOptionMenuLeave.showLeaveConfirmDialog();
                    } else if (i == C9086R.id.action_coedit_share_with_collaborators) {
                        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
                            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
                        } else if (isTranslationOverlayActivated()) {
                            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(3);
                        } else {
                            this.mPresenter.onClickCoeditShareWithCollaborators();
                            updateCoeditBadge();
                        }
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_COEDIT_INVITE_COLLABORATORS);
                    } else if (i == C9086R.id.action_coedit_add_to_shared_notebook) {
                        if (this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote()) {
                            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
                        } else if (isTranslationOverlayActivated()) {
                            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(3);
                        } else {
                            this.mPresenter.onClickCoeditAddToSharedNotebook();
                            updateCoeditBadge();
                        }
                        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_COEDIT_ADD_TO_SHARED_NOTEBOOK);
                    } else if (i == C9086R.id.action_coedit_internal_snap_refresh) {
                        this.mPresenter.onClickCoeditInternalSnapRefresh();
                    } else if (i == C9086R.id.action_text_only_mode) {
                        this.mPresenter.onClickTextOnlyModeBtn();
                    } else if (i == C9086R.id.action_convert_to_note) {
                        this.mPresenter.onClickConvertToNoteBtn();
                        ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_ADD_TO_NOTE, "a");
                    } else if (i == C9086R.id.action_laser_pen) {
                        this.mPresenter.onClickLaserPen();
                    }
                }
            } else {
                if (this.mPresenter.isAiDrawingActivated() && !this.mPresenter.isReadOnlyMode()) {
                    this.mPresenter.getComposerViewPresenter().getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuEditMode.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OptionMenuEditMode.this.mPresenter.onClickReadModeBtn();
                            OptionMenuEditMode.this.invalidateOptionsMenu();
                        }
                    });
                    return true;
                }
                this.mPresenter.onClickReadModeBtn();
                invalidateOptionsMenu();
            }
            zOnToggleToolbarVisibility = true;
        }
        if (doOptionsItemSelectedForViewModeMenu(i)) {
            return true;
        }
        return zOnToggleToolbarVisibility;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onPrepareOptionsMenu(optionMenuParam);
        this.mOptionMenuShare.setShareMenu(this.mOptionMenuBehavior, optionMenuParam, this.mPresenter.isLockNote());
        this.mOptionMenuExport.setExportMenu(this.mOptionMenuBehavior, this.mActivity, optionMenuParam, this.mPresenter.isLockNote());
        updateReadMode(optionMenuParam);
        updateInputFormMode(optionMenuParam);
        updateFullScreenMenu(optionMenuParam);
        updateHashTagMenu(optionMenuParam);
        updateFingerDrawingMenu(optionMenuParam);
        disableMenuInRollingMode(optionMenuParam);
        updateFavoriteMenu(optionMenuParam);
        updatePageListMenu(optionMenuParam);
        updatePageSetting(optionMenuParam);
        updateChangeNoteStyle(optionMenuParam);
        updateShowToolbarMenu(optionMenuParam);
        updateInAppCollaborationMenu(optionMenuParam);
        updateLeave(optionMenuParam);
        disableDelete(optionMenuParam);
        updateStartCoeditNote(optionMenuParam);
        updateDeleteOnlyState(optionMenuParam);
        updateTextOnlyMode(optionMenuParam);
        updateViewModeOptionMenu(optionMenuParam);
        updateLock(optionMenuParam);
        disableSendToReminder(optionMenuParam);
        disablePinToHomeWidget(optionMenuParam);
        disablePrint(optionMenuParam);
        disableInformation(optionMenuParam);
        if (!this.mPresenter.isSupportedViewMode()) {
            updateSaveToDevice(optionMenuParam);
        }
        if (this.mPresenter.isMde()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_favorite));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_lock));
        }
        updateLaserPenMenu(optionMenuParam);
        updateSearchMenu(optionMenuParam);
        if (DeviceInfo.isVSTModel()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_to));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_finger_drawing));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onWindowFocusChanged() {
        OptionMenuSmartTip optionMenuSmartTip = this.mOptionMenuSmartTip;
        if (optionMenuSmartTip != null) {
            optionMenuSmartTip.onWindowFocusChanged();
        }
        OptionMenuSolveMathSmartTip optionMenuSolveMathSmartTip = this.mOptionMenuSolveMathSmartTip;
        if (optionMenuSolveMathSmartTip != null) {
            optionMenuSolveMathSmartTip.onWindowFocusChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void release() {
        OptionMenuAdd optionMenuAdd = this.mOptionMenuAdd;
        if (optionMenuAdd != null) {
            optionMenuAdd.hideAddMenuPopup();
            this.mOptionMenuAdd = null;
        }
        OptionMenuSmartTip optionMenuSmartTip = this.mOptionMenuSmartTip;
        if (optionMenuSmartTip != null) {
            optionMenuSmartTip.hideSmartTip();
        }
        OptionMenuSolveMathSmartTip optionMenuSolveMathSmartTip = this.mOptionMenuSolveMathSmartTip;
        if (optionMenuSolveMathSmartTip != null) {
            optionMenuSolveMathSmartTip.hideSmartTip();
        }
        super.release();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu, com.samsung.android.support.senl.nt.base.winset.view.toolbar.IMenuInflater.OverflowMenu
    public void showOverflowMenu(@NonNull List<? extends MenuItem> list) {
        if (this.mPresenter.isSettingPopupTouchOutside()) {
            return;
        }
        super.showOverflowMenu(list);
        this.mPresenter.hideAiContextMenu();
    }

    public void showPageSetting() {
        this.mOptionMenuPageSetting.show(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void updateHashTagMenu(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isMde()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_add_edit_hash_tag));
        } else {
            super.updateHashTagMenu(optionMenuParam);
        }
    }

    public void updateLaserPenMenu(OptionMenuParam optionMenuParam) {
        Drawable drawable;
        if (!this.mPresenter.getComposerViewPresenter().canUseLaserPenMode() || !this.mPresenter.isReadOnlyMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_laser_pen));
            return;
        }
        Drawable drawable2 = ResourcesCompat.getDrawable(this.mActivity.getResources(), C9086R.drawable.comp_appbar_selected_drawable, null);
        if (drawable2 == null) {
            return;
        }
        Drawable drawable3 = ResourcesCompat.getDrawable(this.mActivity.getResources(), C9086R.drawable.comp_hw_toolbar_ic_laser_pen, null);
        if (this.mPresenter.isLaserPenEnabled()) {
            this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_laser_pen), C9086R.string.hw_laser_pen_off);
        } else {
            drawable2.setAlpha(0);
            this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_laser_pen), C9086R.string.hw_laser_pen_on);
        }
        Pair<Integer, Integer> laserPenData = this.mPresenter.getLaserPenData();
        if (((Integer) laserPenData.second).intValue() != 0) {
            drawable = ResourcesCompat.getDrawable(this.mActivity.getResources(), C9086R.drawable.comp_hw_toolbar_ic_laser_pen_color_rainbow, null);
        } else {
            drawable = ResourcesCompat.getDrawable(this.mActivity.getResources(), C9086R.drawable.comp_hw_toolbar_ic_laser_pen_color, null);
            if (drawable != null) {
                SpenColorThemeUtil spenColorThemeUtil = new SpenColorThemeUtil(this.mActivity);
                spenColorThemeUtil.setColorTheme(this.mPresenter.getComposerViewPresenter().isComposerViewDarkTheme() ? 1 : 0);
                drawable.setColorFilter(spenColorThemeUtil.getColor(((Integer) laserPenData.first).intValue()), PorterDuff.Mode.SRC_ATOP);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable2, drawable, drawable3});
        int dimension = (int) this.mActivity.getResources().getDimension(C9086R.dimen.comp_title_folder_icon_size);
        int intrinsicWidth = (drawable2.getIntrinsicWidth() - dimension) / 2;
        int intrinsicHeight = (drawable2.getIntrinsicHeight() - dimension) / 2;
        layerDrawable.setLayerInset(1, intrinsicWidth, intrinsicHeight, intrinsicWidth, intrinsicHeight);
        layerDrawable.setLayerInset(2, intrinsicWidth, intrinsicHeight, intrinsicWidth, intrinsicHeight);
        this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_laser_pen), layerDrawable);
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
            this.mOptionMenuBehavior.setContentDescription(optionMenuParam.setChildResId(C9086R.id.action_laser_pen), this.mPresenter.isLaserPenEnabled() ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void updateOverFlowMenus(List<MenuItem> list) {
        super.updateOverFlowMenus(list);
        updateInputFormMenu(list);
        updateCalculateModeMenu(list);
    }

    public void updatePageSetting(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSingleMode()) {
            this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_page_setting), C9086R.string.background_color);
            this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_page_setting), AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_bg_color));
        }
    }

    public void updateSaveMenu(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isAutoSaveOptionEnabled()) {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_save));
        }
    }
}
