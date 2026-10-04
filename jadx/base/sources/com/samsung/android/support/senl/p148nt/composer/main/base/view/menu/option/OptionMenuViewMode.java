package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.layout.BaseComposerActivityLayout;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuViewMode extends OptionMenu implements OptionMenuContract.IOptionMenuViewMode {
    private static final String TAG = Logger.createTag("OptionMenuViewMode");
    OptionMenuDelete mOptionMenuDelete;
    private final BaseComposerActivityLayout mTopContainer;

    public OptionMenuViewMode(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        super(activity, optionMenuPresenter);
        this.mType = 2;
        this.mTopContainer = (BaseComposerActivityLayout) activity.findViewById(C9086R.id.composer_fragment_container);
    }

    private boolean doOptionsItemSelectedForBasic(int i) {
        if (i == 16908332) {
            this.mPresenter.onClickNaviUpBtn();
            return true;
        }
        if (i == C9086R.id.action_edit) {
            this.mPresenter.onClickEditBtn(getToolType());
            return true;
        }
        if (i == C9086R.id.action_search) {
            if (this.mPresenter.isPDFReader()) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_SEARCH);
            } else {
                ComposerSA.insertLog(this.mPresenter.isCoeditNote() ? "682" : "301", ComposerSAConstants.EVENT_VIEW_SEARCH);
            }
            this.mPresenter.onClickSearchBtn();
            return true;
        }
        if (i == C9086R.id.action_delete) {
            if (this.mOptionMenuDelete == null) {
                this.mOptionMenuDelete = new OptionMenuDelete(this.mActivity, this.mPresenter);
            }
            this.mPresenter.clearSelectionForEachMode();
            this.mOptionMenuDelete.showDeleteConfirmDialog(FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel() ? 2 : 1);
            return true;
        }
        if (i == C9086R.id.action_lock) {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_LOCK, this.mPresenter.isLockNote() ? "0" : "1");
            this.mPresenter.onClickLockUnlock();
            return true;
        }
        if (i == C9086R.id.action_save_to_device) {
            this.mPresenter.onClickSaveToDeviceBtn(C9086R.string.composer_save_to_device_success);
            setSALogOfSaveToDeviceInMde();
            return true;
        }
        if (i == C9086R.id.action_add_favorite) {
            this.mPresenter.onClickFavoriteBtn();
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_ADD_REMOVE_FAVORITES);
            return true;
        }
        if (i == C9086R.id.action_full_screen_mode || i == C9086R.id.action_tablet_full_screen_mode) {
            this.mPresenter.onFullScreenModeOn();
            if (this.mPresenter.isPDFReader()) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT, ComposerSAConstants.EVENT_PDF_VIEWER_FULL_SCREEN);
                return true;
            }
            ComposerSA.insertLog(this.mPresenter.isCoeditNote() ? "682" : "301", ComposerSAConstants.EVENT_EDIT_FULL_SCREEN);
            return true;
        }
        if (i == C9086R.id.action_notes_assist) {
            this.mOptionMenuNotesAssist.showPopup(this.mActivity);
            return true;
        }
        if (i == C9086R.id.action_close) {
            this.mPresenter.onClickNaviUpBtn();
        }
        return false;
    }

    private boolean doOptionsItemSelectedForPage(int i) {
        int i2 = C9086R.id.action_tablet_sort_pages;
        if (i == i2 || i == C9086R.id.action_sort_pages) {
            this.mPresenter.insertSALogClickPageListBtn(i == i2, false);
            this.mPresenter.onClickPageListBtn();
            return true;
        }
        if (i != C9086R.id.action_page_setting) {
            return false;
        }
        this.mPresenter.onClickPageSetting();
        this.mOptionMenuPageSetting.show(true);
        if (this.mPresenter.isSingleMode()) {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_EDIT_INFINITE_PAGE_SETTINGS);
            return true;
        }
        ComposerSA.insertLog("301", ComposerSAConstants.EVENT_EDIT_PAGE_SETTINGS);
        return true;
    }

    private boolean doOptionsItemSelectedToShare(int i) {
        if (i == C9086R.id.action_share) {
            if (this.mPresenter.isPDFReader()) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_SHARE);
            } else {
                ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_SHARE);
            }
            this.mPresenter.clearSelectionForEachMode();
            if (isTranslatedPDFNote()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            } else if (isTranslationOverlayActivated()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(1);
            } else {
                this.mOptionMenuShare.showPopupMenu(this.mActivity, this.mPresenter.getOptionMenuSharePresenter());
            }
            return true;
        }
        if (i == C9086R.id.action_export) {
            return onExportMenu();
        }
        if (i == C9086R.id.action_print) {
            if (this.mPresenter.isPDFReader()) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_PRINT);
            } else if (this.mPresenter.isCoeditNote()) {
                ComposerSA.insertLog("682", ComposerSAConstants.EVENT_VIEW_PRINT);
            } else {
                ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_PRINT);
            }
            if (isTranslatedPDFNote()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            } else if (isTranslationOverlayActivated()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(2);
            } else {
                this.mPresenter.onClickPrintBtn();
            }
            return true;
        }
        if (i == C9086R.id.action_add_edit_hash_tag) {
            this.mPresenter.onClickHashTagBtn();
            return true;
        }
        if (i == C9086R.id.action_pin_to_home) {
            this.mPresenter.onClickPinToHome();
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_PINTOHOME);
            return true;
        }
        if (i == C9086R.id.action_send_to_reminder) {
            this.mPresenter.onClickSendToReminder();
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_ADDTOREMINDER);
            return true;
        }
        if (i == C9086R.id.action_coedit_share_with_collaborators) {
            if (isTranslatedPDFNote()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            } else {
                this.mPresenter.onClickCoeditShareWithCollaborators();
                updateCoeditBadge();
            }
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_COEDIT_INVITE_COLLABORATORS);
            return true;
        }
        if (i == C9086R.id.action_coedit_add_to_shared_notebook) {
            if (isTranslatedPDFNote()) {
                this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            } else {
                this.mPresenter.onClickCoeditAddToSharedNotebook();
                updateCoeditBadge();
            }
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_COEDIT_ADD_TO_SHARED_NOTEBOOK);
            return true;
        }
        if (i == C9086R.id.action_coedit_internal_snap_refresh) {
            this.mPresenter.onClickCoeditInternalSnapRefresh();
            return true;
        }
        if (i == C9086R.id.action_text_only_mode) {
            this.mPresenter.onClickTextOnlyModeBtn();
            return true;
        }
        if (i == C9086R.id.action_convert_to_note) {
            this.mPresenter.onClickConvertToNoteBtn();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_ADD_TO_NOTE, "a");
            return true;
        }
        if (i != C9086R.id.action_information) {
            return false;
        }
        this.mPresenter.onClickNoteInformation();
        return true;
    }

    private void executePreCondition() {
        this.mPresenter.getComposerViewPresenter().hideAiSuggestionView();
    }

    private boolean isTranslatedPDFNote() {
        return this.mPresenter.getComposerViewPresenter().getComposerModel().isTranslatedPDFNote();
    }

    private void updatePageSetting(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSingleMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_page_setting));
        }
    }

    public boolean doOptionsItemSelectedForOther(int i) {
        return false;
    }

    @MenuRes
    public int getMenuRes() {
        return this.mPresenter.isSimpleMode() ? C9086R.menu.composer_simple_view_menu : C9086R.menu.composer_view_menu;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public String getTag() {
        return TAG;
    }

    public int getToolType() {
        BaseComposerActivityLayout baseComposerActivityLayout = this.mTopContainer;
        if (baseComposerActivityLayout != null) {
            return baseComposerActivityLayout.getLastTouchEventToolType();
        }
        return 1;
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
        updateNotesAssistAndReadingModeMenu(optionMenuParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public boolean onExportMenu() {
        if (!ContentPickerUtils.canExportFileMenu(this.mActivity)) {
            return false;
        }
        ComposerSA.insertLog(this.mPresenter.isCoeditNote() ? "682" : "301", ComposerSAConstants.EVENT_VIEW_SAVE_AS);
        this.mPresenter.clearSelectionForEachMode();
        if (isTranslatedPDFNote()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTranslatedPDFBlockingDialog();
            return true;
        }
        if (isTranslationOverlayActivated()) {
            this.mPresenter.getComposerViewPresenter().getDialogPresenterManager().showTurnOffTranslationDialog(0);
            return true;
        }
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
        executePreCondition();
        if (doOptionsItemSelectedForBasic(i) || doOptionsItemSelectedToShare(i) || doOptionsItemSelectedForPage(i)) {
            return true;
        }
        return doOptionsItemSelectedForOther(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        super.onPrepareOptionsMenu(optionMenuParam);
        this.mOptionMenuShare.setShareMenu(this.mOptionMenuBehavior, optionMenuParam, this.mPresenter.isLockNote());
        this.mOptionMenuExport.setExportMenu(this.mOptionMenuBehavior, this.mActivity, optionMenuParam, this.mPresenter.isLockNote());
        updateLock(optionMenuParam);
        updateHashTagMenu(optionMenuParam);
        updateFavoriteMenu(optionMenuParam);
        updatePageListMenu(optionMenuParam);
        updatePageSetting(optionMenuParam);
        disableMenuInRollingMode(optionMenuParam);
        disableSendToReminder(optionMenuParam);
        disablePinToHomeWidget(optionMenuParam);
        disablePrint(optionMenuParam);
        disableInformation(optionMenuParam);
        updateStartCoeditNote(optionMenuParam);
        updateFullScreenMenu(optionMenuParam);
        updateTextOnlyMode(optionMenuParam);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu
    public void updateOverFlowMenus(List<MenuItem> list) {
        super.updateOverFlowMenus(list);
    }
}
