package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionInformation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionPrint;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.OptionMenuPageSetting;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OptionMenu implements OptionMenuContract.IOptionMenu, OptionMenuContract.IOptionMenuMorePopup, IMenuInflater.OverflowMenu {
    public static final int TYPE_EDIT = 1;
    public static final int TYPE_MDE = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_NOT_EDITABLE = 4;
    public static final int TYPE_VIEW = 2;
    protected Activity mActivity;
    private final Handler mHandler;
    private boolean mIsChangedDisableCoeditBadge = false;
    private OptionBottomMenu mOptionBottomMenu;
    protected OptionMenuBehavior mOptionMenuBehavior;
    protected OptionMenuExport mOptionMenuExport;
    private OptionMenuInApp mOptionMenuInApp;
    protected OptionMenuMorePopup mOptionMenuMorePopup;
    protected OptionMenuNotesAssist mOptionMenuNotesAssist;
    protected OptionMenuPageSetting mOptionMenuPageSetting;
    protected OptionMenuShare mOptionMenuShare;
    protected OptionMenuPresenter mPresenter;
    private final Runnable mRunnableInvalidateOptionsMenu;
    protected int mType;

    public OptionMenu(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter;
        optionMenuPresenter.setOptionMenu(this);
        this.mOptionMenuNotesAssist = new OptionMenuNotesAssist(this.mPresenter);
        this.mOptionMenuMorePopup = new OptionMenuMorePopup(activity, this.mPresenter, this);
        this.mOptionMenuShare = new OptionMenuShare(optionMenuPresenter.getOptionMenuSharePresenter());
        this.mOptionMenuExport = new OptionMenuExport();
        this.mOptionMenuPageSetting = new OptionMenuPageSetting(activity, optionMenuPresenter);
        this.mHandler = new Handler();
        this.mRunnableInvalidateOptionsMenu = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenu.1
            @Override // java.lang.Runnable
            public void run() {
                if (CommonUtil.isNotAvailableActivity(OptionMenu.this.mActivity)) {
                    return;
                }
                OptionMenu.this.mActivity.invalidateOptionsMenu();
            }
        };
    }

    private boolean canShowTextOnlyModeMenu() {
        if (FeatureInfo.isTextOnlyEnabledFeature() && DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(this.mActivity) == DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB) {
            return this.mPresenter.isStartWithTextOnly();
        }
        return false;
    }

    private int findMenuItemInOverFlowMenus(List<MenuItem> list, int i) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    private boolean isDisableCoeditBadgeInPreference() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void attachBottomMenu() {
        FeatureInfo.isAiFeatureEnabled();
    }

    public void disableCoeditBadge() {
        Logger.m11003i(getTag(), "disableCoeditBadge#");
        if (this.mPresenter.isEnabledToStartCoedit() && !isDisableCoeditBadgeInPreference()) {
            SharedPreferencesCompat.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_COEDIT_OPTION_MENU_BADGE_DISABLE, true);
            this.mIsChangedDisableCoeditBadge = true;
        }
    }

    public void disableInformation(OptionMenuParam optionMenuParam) {
        if (ActionInformation.isFeatureEnabled()) {
            return;
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_information));
    }

    public void disableMenuInRollingMode(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSingleMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_sort_pages));
        }
    }

    public void disablePinToHomeWidget(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isSupportedPinToHome(this.mActivity)) {
            return;
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_pin_to_home));
    }

    public void disablePrint(OptionMenuParam optionMenuParam) {
        if (ActionPrint.isSupported(this.mActivity)) {
            return;
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_print));
    }

    public void disableSendToReminder(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isAvailableReminder(this.mActivity)) {
            return;
        }
        this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_send_to_reminder));
    }

    public abstract String getTag();

    public int getType() {
        return this.mType;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void hideBottomMenu() {
        OptionBottomMenu optionBottomMenu = this.mOptionBottomMenu;
        if (optionBottomMenu == null) {
            return;
        }
        optionBottomMenu.hide(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void hideOptionMenu() {
        this.mOptionMenuShare.hidePopupMenu();
        this.mOptionMenuExport.hidePopupMenu();
        this.mOptionMenuPageSetting.hidePopup();
        this.mOptionMenuMorePopup.hidePopup();
        OptionMenuNotesAssist optionMenuNotesAssist = this.mOptionMenuNotesAssist;
        if (optionMenuNotesAssist != null) {
            optionMenuNotesAssist.hidePopup();
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.IMenuInflater.OverflowMenu
    public void hideOverflowMenu() {
        this.mOptionMenuShare.hidePopupMenu();
        this.mOptionMenuExport.hidePopupMenu();
        this.mOptionMenuPageSetting.hidePopup();
        this.mOptionMenuMorePopup.hidePopup();
        this.mOptionMenuNotesAssist.hidePopup();
    }

    public void invalidateDelayOptionsMenu() {
        this.mHandler.removeCallbacks(this.mRunnableInvalidateOptionsMenu);
        this.mHandler.post(this.mRunnableInvalidateOptionsMenu);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void invalidateOptionsMenu() {
        this.mRunnableInvalidateOptionsMenu.run();
    }

    public boolean isDisableCoeditBadge() {
        if (this.mPresenter.isEnabledToStartCoedit()) {
            return isDisableCoeditBadgeInPreference();
        }
        return false;
    }

    public boolean isNotValidEvent(int i) {
        if (i == 16908332 || i == C9086R.id.action_tablet_sort_pages || i == C9086R.id.action_read_mode || i == C9086R.id.action_text_only_mode || i == C9086R.id.action_laser_pen) {
            return false;
        }
        return isNotValidEvent();
    }

    public boolean isTranslationOverlayActivated() {
        return this.mPresenter.isTranslationOverlayActivated();
    }

    public void onConfigurationChanged(Configuration configuration) {
        hideOptionMenu();
    }

    public void onCreateOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        Logger.m11003i(getTag(), "onCreateOptionsMenu");
        if (optionMenuParam.getTarget() instanceof Menu) {
            this.mOptionMenuBehavior = new OptionMenuBehaviorAppbar();
        } else {
            this.mOptionMenuBehavior = new OptionMenuBehaviorView();
        }
    }

    public boolean onExportMenu() {
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenuMorePopup
    public boolean onOptionsItemSelected(@NonNull OptionMenuParam optionMenuParam, int i) {
        return false;
    }

    public void onPrepareOptionsMenu(@NonNull OptionMenuParam optionMenuParam) {
        Logger.m11003i(getTag(), "onPrepareOptionsMenu");
    }

    public void onWindowFocusChanged() {
    }

    public void release() {
        this.mOptionMenuShare.hidePopupMenu();
        this.mOptionMenuExport.hidePopupMenu();
        this.mOptionMenuPageSetting.hidePopup();
        this.mOptionMenuMorePopup.hidePopup();
        OptionMenuNotesAssist optionMenuNotesAssist = this.mOptionMenuNotesAssist;
        if (optionMenuNotesAssist != null) {
            optionMenuNotesAssist.hidePopup();
            this.mOptionMenuNotesAssist = null;
        }
        this.mHandler.removeCallbacks(this.mRunnableInvalidateOptionsMenu);
        OptionMenuInApp optionMenuInApp = this.mOptionMenuInApp;
        if (optionMenuInApp != null) {
            optionMenuInApp.release();
        }
    }

    public boolean removeOverFlowMenuItem(List<MenuItem> list, int i) {
        int iFindMenuItemInOverFlowMenus = findMenuItemInOverFlowMenus(list, i);
        if (iFindMenuItemInOverFlowMenus < 0) {
            return false;
        }
        list.remove(iFindMenuItemInOverFlowMenus);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public boolean replaceInAppOptionMenu(boolean z) {
        OptionMenuInApp optionMenuInApp = this.mOptionMenuInApp;
        if (optionMenuInApp == null) {
            return false;
        }
        return optionMenuInApp.replaceMenuToProgress(z);
    }

    public void setSALogOfSaveToDeviceInMde() {
        if (this.mPresenter.getComposerViewPresenter().getComposerModel().getMdeInfo().isMde()) {
            boolean zIsCreator = this.mPresenter.getComposerViewPresenter().getComposerModel().getMdeInfo().isCreator();
            if (!zIsCreator && this.mPresenter.isCoeditNote()) {
                zIsCreator = this.mPresenter.getComposerViewPresenter().getComposerModel().getMdeInfo().isLeader();
            }
            ComposerSA.insertLog(zIsCreator ? ComposerSAConstants.SCREEN_COEDIT_MASTER : ComposerSAConstants.SCREEN_COEDIT_MEMBER, ComposerSAConstants.EVENT_OPTION_MENU_SAVE_TO_DEVICE);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void showBottomMenu() {
        OptionBottomMenu optionBottomMenu = this.mOptionBottomMenu;
        if (optionBottomMenu == null) {
            return;
        }
        optionBottomMenu.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void showNoteStyle() {
        this.mPresenter.onClickChangeTemplate();
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.view.toolbar.IMenuInflater.OverflowMenu
    public void showOverflowMenu(@NonNull List<? extends MenuItem> list) {
        updateOverFlowMenus(list);
        this.mPresenter.getComposerViewPresenter().getSoftInputManager().hide(false);
        this.mPresenter.getComposerViewPresenter().hideAiSuggestionView();
        this.mOptionMenuMorePopup.showPopup(list);
        disableCoeditBadge();
        if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_MORE_OPTION);
        } else {
            ComposerSA.insertLog(ComposerSA.getScreenID(this.mPresenter.isEditMode(), false, ResourceUtils.isTabletLayout(this.mActivity)), ComposerSAConstants.EVENT_TABLET_MORE_OPTION);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuContract.IOptionMenu
    public void showSaveAsPopup() {
        onExportMenu();
    }

    public void updateCoeditBadge() {
        if (this.mIsChangedDisableCoeditBadge) {
            invalidateOptionsMenu();
        }
    }

    public void updateDeleteMenu(@NonNull List<? extends MenuItem> list) {
        for (MenuItem menuItem : list) {
            if (menuItem.isVisible() && menuItem.getItemId() == C9086R.id.action_delete) {
                menuItem.setEnabled(this.mPresenter.canDelete());
                return;
            }
        }
    }

    public void updateFavoriteMenu(OptionMenuParam optionMenuParam) {
        int i;
        Drawable drawable;
        if (this.mPresenter.isFavorite()) {
            i = C9086R.string.composer_remove_from_favorite;
            drawable = AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_favorite_on);
        } else {
            i = C9086R.string.composer_add_to_favorite;
            drawable = AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_favorite_off);
        }
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_add_favorite), i);
        this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_add_favorite), drawable);
    }

    public void updateFullScreenMenu(@NonNull OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isInAppCollaborationMode()) {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_full_screen_mode));
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_tablet_full_screen_mode));
        } else if (ResourceUtils.isTabletLayout(this.mActivity)) {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_full_screen_mode));
        } else {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_tablet_full_screen_mode));
        }
    }

    public void updateHashTagMenu(OptionMenuParam optionMenuParam) {
        int i = C9086R.id.action_add_edit_hash_tag;
        if (FeatureInfo.isHashTagFeatureEnabled()) {
            this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(i), this.mPresenter.hasHashTag() ? C9086R.string.tag_editor_edit_tags : C9086R.string.tag_editor_title);
        } else {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(i));
        }
    }

    public void updateInAppCollaborationMenu(final OptionMenuParam optionMenuParam) {
        if (this.mPresenter.needToRemoveInAppCollaborationMenu()) {
            Logger.m10999d(getTag(), "updateInAppCollaborationMenu# remove menu");
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_start_in_app_collaboration));
        } else {
            boolean zNeedToShowInAppCollaborationMenu = this.mPresenter.needToShowInAppCollaborationMenu();
            if (this.mOptionMenuInApp == null) {
                this.mOptionMenuInApp = new OptionMenuInApp(this.mActivity, zNeedToShowInAppCollaborationMenu);
            }
            this.mOptionMenuInApp.updateMenuView(optionMenuParam, zNeedToShowInAppCollaborationMenu, this.mPresenter.getBackgroundColor(), new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenu.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OptionMenu.this.onOptionsItemSelected(optionMenuParam, C9086R.id.action_start_in_app_collaboration);
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_READY, ComposerSAConstants.EVENT_IN_APP_COLLABORATION_START);
                }
            });
        }
    }

    public void updateLock(OptionMenuParam optionMenuParam) {
        int i;
        Drawable drawable;
        if (!this.mPresenter.isSupportedLockMenu()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_lock));
            return;
        }
        if (this.mPresenter.isLockNote()) {
            i = C9086R.string.action_more_unlock;
            drawable = AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_lock);
        } else {
            i = C9086R.string.action_more_lock;
            drawable = AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_unlock);
        }
        this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_lock), i);
        this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_lock), drawable);
    }

    public void updateNotesAssistAndReadingModeMenu(OptionMenuParam optionMenuParam) {
        if (FeatureInfo.isAiFeatureEnabled() && this.mPresenter.isPDFReader()) {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_read_mode));
        } else {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_notes_assist));
        }
        if (this.mPresenter.isPDFReader()) {
            return;
        }
        this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_turn_on_off_input_form));
    }

    public void updateOverFlowMenus(List<MenuItem> list) {
        updateShareAndSaveASMenu(list);
        updateDeleteMenu(list);
    }

    public void updatePageListMenu(OptionMenuParam optionMenuParam) {
        if (ResourceUtils.isTabletLayout(this.mActivity)) {
            int i = C9086R.id.action_tablet_sort_pages;
            boolean zIsClickedPageList = this.mPresenter.isClickedPageList();
            this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(i), zIsClickedPageList ? AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_page_sorter_selected) : AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_page_sorter_unselected));
            if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
                this.mOptionMenuBehavior.setContentDescription(optionMenuParam.setChildResId(i), zIsClickedPageList ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected));
            }
        }
    }

    public void updateSaveToDevice(OptionMenuParam optionMenuParam) {
        if (this.mPresenter.isMde() && this.mPresenter.hasWritePermission()) {
            this.mOptionMenuBehavior.showMenu(optionMenuParam.setChildResId(C9086R.id.action_save_to_device));
        }
    }

    public void updateShareAndSaveASMenu(@NonNull List<? extends MenuItem> list) {
        for (MenuItem menuItem : list) {
            if (menuItem.isVisible() && (menuItem.getItemId() == C9086R.id.action_share || menuItem.getItemId() == C9086R.id.action_export)) {
                menuItem.setEnabled(!this.mPresenter.getComposerViewPresenter().getComposerModel().isEmpty());
            }
        }
    }

    public void updateSortPageMenu(OptionMenuParam optionMenuParam) {
        if (!ResourceUtils.isTabletLayout(this.mActivity) || this.mPresenter.isSingleMode()) {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_tablet_sort_pages));
        } else {
            this.mOptionMenuBehavior.removeMenu(optionMenuParam.setChildResId(C9086R.id.action_sort_pages));
        }
    }

    public void updateStartCoeditNote(OptionMenuParam optionMenuParam) {
        if (!this.mPresenter.isEnabledToStartCoedit()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_coedit_share_with_collaborators));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_coedit_add_to_shared_notebook));
        } else if (!isDisableCoeditBadge()) {
            this.mOptionMenuBehavior.setBadgeText(optionMenuParam.setChildResId(C9086R.id.action_coedit_share_with_collaborators));
            this.mOptionMenuBehavior.setBadgeText(optionMenuParam.setChildResId(C9086R.id.action_coedit_add_to_shared_notebook));
        } else if (this.mPresenter.isMde()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_coedit_share_with_collaborators));
            this.mOptionMenuBehavior.setTitle(optionMenuParam.setChildResId(C9086R.id.action_coedit_add_to_shared_notebook), C9086R.string.coedit_copy_to_new_shared_notebook);
        }
        if (this.mPresenter.isCoeditNote()) {
            this.mOptionMenuBehavior.showMenu(optionMenuParam.setChildResId(C9086R.id.action_coedit_internal_snap_refresh));
        }
    }

    public void updateTextOnlyMode(OptionMenuParam optionMenuParam) {
        boolean zCanShowTextOnlyModeMenu = canShowTextOnlyModeMenu();
        this.mPresenter.setCanUseTextOnlyMode(zCanShowTextOnlyModeMenu);
        if (!zCanShowTextOnlyModeMenu) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_text_only_mode));
            return;
        }
        this.mOptionMenuBehavior.setIcon(optionMenuParam.setChildResId(C9086R.id.action_text_only_mode), this.mPresenter.isEnableTextOnlyMode() ? AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_text_only_mode_on) : AppCompatResources.getDrawable(this.mActivity, C9086R.drawable.comp_appbar_ic_text_only_mode_off));
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mActivity)) {
            this.mOptionMenuBehavior.setContentDescription(optionMenuParam.setChildResId(C9086R.id.action_text_only_mode), AbstractC0000a.m12i(this.mActivity.getResources(), C9086R.string.composer_reading_mode, AbstractC0541b.m781w(this.mPresenter.isEnableTextOnlyMode() ? this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) : this.mActivity.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected), SQLKeyword.COMMA)));
        }
        if (this.mPresenter.isEnableTextOnlyMode()) {
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_sort_pages));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_change_note_style));
            this.mOptionMenuBehavior.hideMenu(optionMenuParam.setChildResId(C9086R.id.action_page_setting));
        }
    }

    private boolean isNotValidEvent() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
        UserInputSkipper.Tag tag2 = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag, tag2)) {
            return true;
        }
        UserInputSkipper.setHoldingEventTime(700L, tag);
        UserInputSkipper.setHoldingEventTime(700L, tag2);
        return false;
    }
}
