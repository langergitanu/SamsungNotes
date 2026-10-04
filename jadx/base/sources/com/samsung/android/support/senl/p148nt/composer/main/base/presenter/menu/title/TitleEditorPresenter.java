package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSipController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverMenuViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.DateTimeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.RTLUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleEditorPresenter implements NotesDocEntityManager.OnTitleDataChangedListener, TextManager.OnTitleUpdateListener, NoteManager.ObserverBackgroundColor, MdeInfo.Observer, HashTagController.HashTagActionListener, LiveSharingContract.Listener {
    private static final String TAG = Logger.createTag("TitleEditorPresenter");
    private Activity mActivity;
    private AiMenuManager mAiMenuManager;
    private ComposerSipController mCompSipController;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private final Config mConfig;
    private HashTagContract.Presenter mHashTagPresenter;
    private KeyguardPresenter mKeyguardPresenter;
    private LiveSharingContract mLiveSharingContract;
    private MenuPresenterContract.IMenuManager mMenuManager;
    private SoftInputManager mSoftInputManager;
    private TextManager mTextManager;
    private String mTitle;
    private TitleCoeditMemberListPresenter mTitleCoeditMemberListPresenter;
    private ToolbarPresenter mToolbarPresenter;
    private IView mView;
    private String mModifiedTime = "";
    private String mCreatedTime = "";
    private String mCreatedDate = "";
    private String mCreator = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void animateTagCue();

        String getTitle();

        EditText getTitleView();

        boolean hide(boolean z);

        void hideNoteCover();

        boolean isShowing();

        void onCompleteCover();

        void setBackgroundColor(int i, boolean z, boolean z2);

        void show();

        void showConfirmCover(boolean z);

        void showCreatingCover();

        void updateCoeditMemberInfo();

        void updateCreatedTime(String str);

        void updateCreator();

        void updateEditableState(boolean z);

        void updateFavorite(boolean z);

        void updateFolderInfo(String str, int i, int i2);

        void updateLastModifiedTime(String str);

        void updateNoteCover();

        void updateNoteCoverConfirm(int i);

        void updateTitle();
    }

    public TitleEditorPresenter(@NonNull Config config) {
        this.mConfig = config;
    }

    private void initAiMenu() {
        this.mAiMenuManager.getAiCoverMenuViewPresenter().setCoverEditorListener(new AiCoverMenuViewPresenter.CoverEditorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.CoverEditorListener
            public void onCompleteCover() {
                Logger.m10999d(TitleEditorPresenter.TAG, "onCompleteCover#");
                TitleEditorPresenter.this.mView.onCompleteCover();
                TitleEditorPresenter.this.mView.showConfirmCover(false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.CoverEditorListener
            public void onCreateCover() {
                Logger.m10999d(TitleEditorPresenter.TAG, "onCreateCover#");
                TitleEditorPresenter.this.mView.showCreatingCover();
                TitleEditorPresenter.this.mView.showConfirmCover(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.CoverEditorListener
            public void onHideCover() {
                Logger.m10999d(TitleEditorPresenter.TAG, "onHideCover#");
                TitleEditorPresenter.this.mView.hideNoteCover();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.CoverEditorListener
            public void onUpdateCover() {
                Logger.m10999d(TitleEditorPresenter.TAG, "onUpdateCover#");
                TitleEditorPresenter.this.mView.updateNoteCover();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverMenuViewPresenter.CoverEditorListener
            public void updateNoteCoverConfirm(int i) {
                AbstractC0000a.m3D(i, "updateNoteCoverConfirm# visibility : ", TitleEditorPresenter.TAG);
                TitleEditorPresenter.this.mView.updateNoteCoverConfirm(i);
            }
        });
    }

    private void initTimeData() {
        long lastModifiedTime = this.mComposerModel.getNotesDocEntityManager().getLastModifiedTime();
        long createdTime = this.mComposerModel.getNotesDocEntityManager().getCreatedTime();
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(lastModifiedTime, "initTime# getModifiedTime(", ") : getCreatedTime(");
        sbM1323p.append(createdTime);
        sbM1323p.append(")");
        Logger.m10999d(str, sbM1323p.toString());
        setModifiedTime(lastModifiedTime);
        if (createdTime > 0 || lastModifiedTime <= 0) {
            lastModifiedTime = createdTime;
        }
        setCreatedTime(lastModifiedTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLiveSharingDisconnected$0() {
        this.mView.updateCoeditMemberInfo();
    }

    private void setCreatedTime(long j) {
        this.mCreatedTime = DateTimeUtil.convertFormattedDateTime(this.mActivity, j, false, true);
        this.mCreatedDate = DateTimeUtil.convertFormattedMMDD(this.mActivity, j);
    }

    private void setModifiedTime(long j) {
        this.mModifiedTime = DateTimeUtil.convertFormattedDateTime(this.mActivity, j, true, true);
    }

    private void setOnSipListener(boolean z) {
        IView iView;
        SoftInputManager softInputManager = this.mSoftInputManager;
        if (softInputManager == null || (iView = this.mView) == null) {
            return;
        }
        if (z) {
            softInputManager.addOnSipListener((SoftInputManager.OnSipListener) iView);
        } else {
            softInputManager.removeOnSipListener((SoftInputManager.OnSipListener) iView);
        }
    }

    private void setOnTitleDataChangedListener(NotesDocEntityManager.OnTitleDataChangedListener onTitleDataChangedListener) {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return;
        }
        composerModel.getNotesDocEntityManager().setOnTitleDataChangedListener(onTitleDataChangedListener);
    }

    public boolean checkNoServerPermission() {
        return this.mComposerModel.getModeManager().isComposerViewMode() && !this.mComposerModel.getCoeditAdapter().takeServerWritePermission();
    }

    public AiCoverMenuViewPresenter getAiCoverMenuViewPresenter() {
        return getAiMenuManager().getAiCoverMenuViewPresenter();
    }

    public AiMenuManager getAiMenuManager() {
        return this.mAiMenuManager;
    }

    public int[] getBackgroundThemeColorTable() {
        return this.mComposerViewPresenter.getBackgroundThemeColorTable();
    }

    public ComposerModel getComposerModel() {
        return this.mComposerModel;
    }

    public ComposerViewPresenter getComposerViewPresenter() {
        return this.mComposerViewPresenter;
    }

    public String getCoverSummary() {
        return getDocState().getCoverDataSource().getSummary();
    }

    public String getCreatedDate() {
        return this.mCreatedDate;
    }

    public String getCreatedTime() {
        if (TextUtils.isEmpty(this.mCreatedTime)) {
            return null;
        }
        return RTLUtil.supportRTL(this.mActivity.getResources().getString(C9086R.string.composer_title_created, this.mCreatedTime));
    }

    public String getCreator() {
        return this.mCreator;
    }

    public String getCreatorText() {
        if (TextUtils.isEmpty(this.mCreator)) {
            return null;
        }
        return RTLUtil.supportRTL(this.mActivity.getResources().getString(C9086R.string.composer_title_mde_creator, this.mCreator));
    }

    public String getDocPath() {
        return this.mComposerModel.getDocInfo().getDocPath();
    }

    public NotesDocument<SpenWordDocument> getDocState() {
        return this.mComposerModel.getDocState();
    }

    public String getDocUuid() {
        return this.mComposerModel.getDocInfo().getUuid();
    }

    public String getEditorViewTitle() {
        return this.mView.getTitle();
    }

    public int getFolderColor() {
        return this.mComposerModel.getNotesDocEntityManager().getFolderColor(ContextCompat.getColor(this.mActivity, C9086R.color.new_folder_color_default_high_contrast));
    }

    public int getFolderIcon() {
        return getFolderIcon(this.mComposerModel.getNotesDocEntityManager().getFolderUuid());
    }

    public String getFolderName() {
        return getFolderName(this.mComposerModel.getNotesDocEntityManager().getFolderUuid());
    }

    public String getFolderUuid() {
        return this.mComposerModel.getNotesDocEntityManager().getFolderUuid();
    }

    public HashTagContract.Presenter getHashTagPresenter() {
        return this.mHashTagPresenter;
    }

    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    public long getLastModified() {
        return this.mComposerModel.getNotesDocEntityManager().getLastModifiedTime();
    }

    public String getLastModifiedTime() {
        long lastModifiedTime = this.mComposerModel.getNotesDocEntityManager().getLastModifiedTime();
        if (lastModifiedTime > 0) {
            return DateTimeUtil.convertFormattedDateTime(this.mActivity, lastModifiedTime, true, false);
        }
        long createdTime = this.mComposerModel.getNotesDocEntityManager().getCreatedTime();
        return createdTime > 0 ? DateTimeUtil.convertFormattedDateTime(this.mActivity, createdTime, true, false) : DateTimeUtil.convertFormattedDateTime(this.mActivity, System.currentTimeMillis(), true, false);
    }

    public String getModifiedTime() {
        if (TextUtils.isEmpty(this.mModifiedTime)) {
            return null;
        }
        return RTLUtil.supportRTL(this.mActivity.getResources().getString(C9086R.string.composer_title_last_modified, this.mModifiedTime));
    }

    public SoftInputManager getSoftInputManager() {
        return this.mSoftInputManager;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public TitleCoeditMemberListPresenter getTitleCoeditMemberListPresenter() {
        return this.mTitleCoeditMemberListPresenter;
    }

    public boolean hasWritePermission() {
        return this.mComposerModel.getMdeInfo().hasWritePermission();
    }

    public void hide() {
        this.mView.hide(true);
    }

    public void hideSoftInput(View view) {
        this.mSoftInputManager.hide(view);
    }

    public void init(MenuPresenterContract.IMenuManager iMenuManager, ToolbarPresenter toolbarPresenter, ComposerViewPresenter composerViewPresenter, HashTagContract.Presenter presenter, ControllerManager controllerManager, ComposerModel composerModel, LiveSharingContract liveSharingContract, AiMenuManager aiMenuManager, @NonNull KeyguardPresenter keyguardPresenter) {
        this.mMenuManager = iMenuManager;
        this.mToolbarPresenter = toolbarPresenter;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mCompSipController = composerViewPresenter.getComposerControllerManager().getCompSipController();
        TextManager textManager = composerViewPresenter.getTextManager();
        this.mTextManager = textManager;
        textManager.setTitleUpdateListener(this);
        this.mTitle = this.mTextManager.getTitle();
        this.mHashTagPresenter = presenter;
        controllerManager.getHashTagController().setActionListener(this);
        this.mComposerModel = composerModel;
        setOnTitleDataChangedListener(this);
        this.mComposerViewPresenter.getNoteManager().addBackgroundColorObserver(this);
        this.mComposerModel.getMdeInfo().addObserver(this);
        this.mTitleCoeditMemberListPresenter = new TitleCoeditMemberListPresenter(this.mComposerModel);
        this.mLiveSharingContract = liveSharingContract;
        liveSharingContract.setListener(this);
        this.mAiMenuManager = aiMenuManager;
        this.mKeyguardPresenter = keyguardPresenter;
        initAiMenu();
    }

    public boolean initTimeDataOnShow() {
        if (!this.mComposerModel.getModeManager().isMode(Mode.View) || !TextUtils.isEmpty(this.mCreatedTime)) {
            return false;
        }
        initTimeData();
        return true;
    }

    public boolean isBackgroundDarkTheme() {
        return this.mComposerViewPresenter.isBackgroundDarkTheme();
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    public boolean isEditMode() {
        return this.mComposerModel.getModeManager().isEditMode();
    }

    public boolean isEditable() {
        return this.mConfig.isTitleEditable() && this.mComposerModel.isEditable() && !this.mComposerModel.isSimpleMode();
    }

    public boolean isFavorite() {
        return this.mComposerModel.getNotesDocEntityManager().isFavoriteNote();
    }

    public boolean isInputMethodShown() {
        return this.mSoftInputManager.isInputMethodShown();
    }

    public boolean isMde() {
        return this.mComposerModel.getMdeInfo().isMde();
    }

    public boolean isMeetNote() {
        return this.mLiveSharingContract.isLiveSharingNote();
    }

    public boolean isMovableFolder() {
        if (PredefinedCategory.RECYCLE_BIN.getUuid().equals(getFolderUuid())) {
            return false;
        }
        return (PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(getFolderUuid()) && this.mComposerModel.getMdeInfo().getAccountType() == 0) ? false : true;
    }

    public boolean isNaviUpEnabled() {
        return this.mConfig.isNaviUpEnabled() || getKeyguardPresenter().isInitialLockDismissed();
    }

    public boolean isOverlapping() {
        return this.mMenuManager.isClickedPageList() && !this.mComposerModel.isTabletLayout();
    }

    public boolean isStandAlone() {
        return this.mComposerModel.getMdeInfo().isStandAlone();
    }

    public boolean isTabletLayout() {
        return this.mComposerModel.isTabletLayout();
    }

    public boolean isTitleTextEmpty() {
        return ((SpenWordDocument) this.mComposerModel.getDocState().getDoc()).getTitleText().isEmpty();
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
        setOnTitleDataChangedListener(this);
        if (!this.mComposerModel.getDocState().isNew()) {
            initTimeData();
        }
        this.mCreator = this.mComposerModel.getMdeInfo().getCreatorName();
        this.mTitleCoeditMemberListPresenter.onAttachView(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        setBackgroundColor(i, z, z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onChangedCreatedTime(long j) {
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            setCreatedTime(j);
            this.mView.updateCreatedTime(getCreatedTime());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onChangedFavorite(boolean z) {
        AbstractC8014b.m7224z("onChangedFavorite : ", TAG, z);
        this.mView.updateFavorite(z);
        this.mMenuManager.invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onChangedFolder(String str) {
        Logger.m11003i(TAG, "onChangedFolder# " + hashCode());
        this.mView.updateFolderInfo(getFolderName(str), getFolderColor(), getFolderIcon());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onChangedLastModifiedTime(long j) {
        setModifiedTime(j);
        this.mView.updateLastModifiedTime(getModifiedTime());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onChangedLockState(int i) {
        AbstractC8014b.m7217s(i, "onChangedLockState : ", TAG);
        this.mMenuManager.hideAndInvalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.TextManager.OnTitleUpdateListener
    public void onChangedTitle(String str) {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            return;
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("onChangedTitle#length = ");
        sb.append(str != null ? str.length() : 0);
        Logger.m11003i(str2, sb.toString());
        setTitle(str);
        this.mView.updateTitle();
        Logger.addFileLog(str2, "TitleChange", 0);
    }

    public void onCoeditDeviceListChanged(List<CoeditDeviceInfo> list) {
        this.mTitleCoeditMemberListPresenter.updateCoeditWriterInfo(list);
        IView iView = this.mView;
        if (iView != null) {
            iView.updateCoeditMemberInfo();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
    public void onCoeditMemberListChanged(List<CoeditResolverContract.MemberInfo> list) {
        this.mTitleCoeditMemberListPresenter.updateCoeditMemberList();
        IView iView = this.mView;
        if (iView != null) {
            iView.updateCoeditMemberInfo();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
    public void onCreatorNameChanged(String str) {
        AbstractC8014b.m7213o(new StringBuilder("onCreatorNameChanged# "), DeviceInfo.isEngMode() ? str : "", TAG);
        this.mCreator = str;
        IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                TitleEditorPresenter.this.mView.updateCreator();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnTitleDataChangedListener
    public void onDeletedFolder() {
        Logger.addFileLog(TAG, "onDeletedFolder", 0);
        Activity activity = this.mActivity;
        ToastHandler.show(activity, activity.getString(C9086R.string.composer_sync_delete_note), 1);
        this.mMenuManager.finish("onDeletedFolder");
    }

    public void onDestroy() {
        if (isCoeditNote()) {
            ComposerSA.insertLog(this.mComposerModel.getModeManager().isEditModeWithReadOnly() ? "683" : "682", ComposerSAConstants.EVENT_COEDIT_MEMBER_COUNT_DOING, this.mComposerModel.getMdeManager().getMaximumCountOnCoedit());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagController.HashTagActionListener
    public void onHashTagAdded() {
        IView iView = this.mView;
        if (iView != null) {
            iView.animateTagCue();
        }
    }

    public void onHide(View view) {
        if (this.mActivity == null) {
            return;
        }
        ModeManager modeManager = this.mComposerModel.getModeManager();
        Mode mode = Mode.Text;
        if (modeManager.isMode(mode)) {
            if (!this.mComposerViewPresenter.getObjectManager().isFocusedTextBox()) {
                this.mSoftInputManager.hide(view);
            }
            this.mComposerViewPresenter.getTextManager().setCursorBlink(true);
        } else {
            this.mSoftInputManager.hide(view);
        }
        if (this.mComposerModel.getModeManager().isMode(Mode.Writing) || this.mComposerModel.getModeManager().isMode(mode)) {
            this.mToolbarPresenter.show(false);
        }
        if (isCoeditNote()) {
            RequestToSyncManager.INSTANCE.requestCoeditTitleUpdate(this.mComposerModel.getMdeInfo().getSpaceId(), getDocUuid(), this.mTitle);
        }
        this.mComposerViewPresenter.requestFocus();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
    public void onLeaderChanged() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.LiveSharingContract.Listener
    @AnyThread
    public void onLiveSharingDisconnected() {
        Logger.m11003i(TAG, "onLiveSharingDisconnected#");
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC9767a(this, 2));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
    public void onPermissionChanged(MdeInfo mdeInfo) {
        IView iView = this.mView;
        if (iView != null) {
            iView.updateEditableState(mdeInfo.hasWritePermission());
        }
    }

    public void onSaveInstanceState() {
        IView iView = this.mView;
        if (iView == null) {
            return;
        }
        if (!iView.getTitle().equals(this.mTitle)) {
            this.mTitle = getTitle();
        }
        this.mTextManager.setTitle(this.mTitle);
    }

    public void onShow() {
        this.mToolbarPresenter.hide(false);
        if (this.mComposerModel.getModeManager().isMode(Mode.Text)) {
            this.mComposerViewPresenter.getTextManager().setCursorBlink(false);
        }
        if (this.mComposerViewPresenter.getObjectManager().isSelectedBodyText()) {
            this.mComposerViewPresenter.setContextMenu(false);
            this.mComposerViewPresenter.getTextManager().clearSelection();
        } else if (this.mComposerViewPresenter.getObjectManager().getSelectedObjectManager().isSelectedObject()) {
            this.mComposerViewPresenter.getObjectManager().clearSelectObject(true);
        }
    }

    public boolean onWindowFocusChanged(boolean z) {
        IView iView = this.mView;
        if (iView != null && iView.isShowing()) {
            if (!z) {
                this.mCompSipController.updateClipboardFilter(true, "TitleEditorPresenter#onWindowFocusChanged");
                return true;
            }
            if (this.mView.getTitleView() != null && this.mComposerViewPresenter.getView() != null) {
                if (!this.mView.getTitleView().hasFocus() && this.mView.getTitleView().isFocusable()) {
                    this.mSoftInputManager.hide((View) null);
                }
                if (this.mComposerViewPresenter.getView().hasFocus() && (this.mComposerModel.getModeManager().isMode(Mode.Text) || this.mComposerModel.getModeManager().isMode(Mode.ReadOnly))) {
                    this.mComposerViewPresenter.getTextManager().setCursorBlink(false);
                }
                if (Build.VERSION.SDK_INT > 33) {
                    this.mCompSipController.setSIPInputModeHidden(this.mActivity, false, WindowManagerCompat.getInstance().getMultiWindowMode(this.mView.getTitleView().getResources().getConfiguration()));
                }
                return true;
            }
            Logger.m10999d(TAG, "onWindowFocusChanged# child views are null ");
        }
        return false;
    }

    public void release() {
        this.mActivity = null;
        setOnTitleDataChangedListener(null);
        setOnSipListener(false);
    }

    public void setBackgroundColor() {
        setBackgroundColor(this.mComposerViewPresenter.getBackgroundColor(), this.mComposerViewPresenter.isBackgroundColorInverted(), this.mComposerViewPresenter.hasBackgroundImage());
    }

    public void setFavorite(boolean z) {
        this.mComposerModel.getNotesDocEntityManager().setNoteFavorite(z);
    }

    public void setFocusToComposer() {
        if (this.mComposerModel.getModeManager().isMode(Mode.Text) && this.mComposerViewPresenter.getObjectManager().isFocusedTextBox() && this.mSoftInputManager.isInputMethodShown()) {
            this.mComposerViewPresenter.getView().requestFocus();
        }
    }

    public void setFolderUuid(String str) {
        this.mComposerModel.getNotesDocEntityManager().setFolderUuid(str);
    }

    public void setTitle(String str) {
        setTitle(str, false);
    }

    public void setView(IView iView) {
        this.mView = iView;
        setOnSipListener(iView != null);
    }

    public void show() {
        if (!isEditable() || isOverlapping()) {
            return;
        }
        this.mView.show();
    }

    public void showCoeditMemberManage() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
        if (!UserInputSkipper.isValidEvent(tag)) {
            Logger.m11004w(TAG, "showCoeditMemberManage# skip UserInputSkipper");
            return;
        }
        UserInputSkipper.setHoldingEventTime(tag);
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (companion.getInstance().getCoeditResolver() == null) {
            Logger.m11004w(TAG, "showCoeditMemberManage# resolver is null");
            return;
        }
        String str = TAG;
        Logger.m11003i(str, "showCoeditMemberManage#");
        Intent coeditMemberManageIntent = companion.getInstance().getCoeditResolver().getCoeditMemberManageIntent(this.mComposerModel.getMdeInfo().getGroupId(), getTitle(), false);
        if (coeditMemberManageIntent == null) {
            Logger.m11000e(str, "showCoeditMemberManage# intent is null");
        } else {
            PopOverActivityWrapper.startActivity(this.mActivity, coeditMemberManageIntent, 0);
        }
    }

    public void showSoftInput(View view) {
        this.mSoftInputManager.show(view);
    }

    public void hide(boolean z) {
        this.mView.hide(z);
    }

    public void setTitle(String str, boolean z) {
        this.mTitle = str;
        if (str != null && str.contains(System.lineSeparator())) {
            this.mTitle = this.mTitle.replaceAll(System.lineSeparator(), " ");
        }
        if (z) {
            this.mTextManager.setTitle(this.mTitle);
            getDocState().getCoverDataSource().setTitle(this.mTitle);
        }
    }

    private String getFolderName(String str) {
        if (PredefinedCategory.SCREEN_OFF_MEMO.getUuid().equals(str)) {
            return this.mActivity.getResources().getString(C9086R.string.composer_title_screen_off_memo);
        }
        if (PredefinedCategory.MATH_NOTES.getUuid().equals(str)) {
            return this.mActivity.getResources().getString(C9086R.string.string_math_notes);
        }
        if (PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(str)) {
            return this.mActivity.getResources().getString(C9086R.string.composer_title_shared_notebooks);
        }
        if (PredefinedCategory.UNCATEGORIZED.getUuid().equals(str)) {
            return this.mActivity.getResources().getString(C9086R.string.settings_my_folders);
        }
        if (PredefinedCategory.COEDIT_NOTES.getUuid().equals(str)) {
            if (isStandAlone()) {
                return "";
            }
            return this.mComposerModel.getMdeInfo().getSpaceName();
        }
        return RTLUtil.supportRTL(this.mComposerModel.getNotesDocEntityManager().getFolderName(this.mActivity.getResources().getString(C9086R.string.settings_my_folders)));
    }

    public int getFolderIcon(String str) {
        if (PredefinedCategory.COEDIT_NOTES.getUuid().equals(str)) {
            if (isStandAlone()) {
                return 0;
            }
            return C9086R.drawable.comp_title_coedit_shared_notebook;
        }
        return C9086R.drawable.comp_title_ic_folder;
    }

    public void setBackgroundColor(int i, boolean z, boolean z2) {
        this.mView.setBackgroundColor(i, z, z2);
        BackgroundColorUtil.setStatusBar(this.mActivity, i, z, z2);
        BackgroundColorUtil.setNavigationBar(this.mActivity, i, z, z2);
        BackgroundColorUtil.setCutoutColor(this.mActivity, i, z, z2);
    }
}
