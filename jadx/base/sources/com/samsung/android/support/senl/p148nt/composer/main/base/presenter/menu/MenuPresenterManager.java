package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.AppInfo;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.LiveSharingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.hashtag.HashTagPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.BaseInAppPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp.InAppCollaborationPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.AttachMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.AiMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.quicknote.QuickNotePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.shortcut.ShortCutManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.DynamicTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MenuPresenterManager implements MenuPresenterContract.IMenuManager {
    private static final String TAG = Logger.createTag("MenuPresenterManager");
    private Activity mActivity;
    private final AiMenuManager mAiMenuManager;
    private AttachMenuPresenter mAttachMenuPresenter;
    private final ComponentFactory mComponentFactory;
    protected ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    protected ContextMenuManager mContextMenuManager;
    private ControllerManager mControllerManager;
    private DwToolbarPresenter mDwToolbarPresenter;
    private HashTagPresenter mHashTagPresenter;
    private HwToggleFabManager mHwToggleFabManager;
    private HwToolbarPresenter mHwToolbarPresenter;
    private final KeyguardPresenter mKeyguardPresenter;
    private CompListPresenter mListMenuPresenter;
    protected OptionMenuPresenter mOptionMenuPresenter;
    private final MenuPresenterContract.IMenuParent mParent;
    private QuickToolPresenter mQuickToolPresenter;
    private RtToolbarPresenter mRtToolbarPresenter;
    private SearchModePresenter mSearchModePresenter;
    private final ShortCutManager mShortCutManager;
    private StickyMemoManager mStickyMemoManager;
    private TableAndCellPresenter mTableAndCellPresenter;
    private TitleEditorPresenter mTitleEditorPresenter;
    private TlToolbarPresenter mTlToolbarPresenter;
    private ToolbarPresenter mToolbarPresenter;
    private VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;
    private final ActionManager mActionManager = new ActionManager();
    private boolean mInitialized = false;
    private int mSaveFailureCount = 0;
    private final QuickNotePresenter mQuickNotePresenter = new QuickNotePresenter();
    private final BaseInAppPresenter mInAppCollaborationPresenter = createInAppCollaborationPresenter();
    private final DynamicTemplatePresenter mDynamicTemplatePresenter = new DynamicTemplatePresenter();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.MenuPresenterManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C92611 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$util$ComposerRequestCode */
        static final /* synthetic */ int[] f6794x1afc3a65;

        static {
            int[] iArr = new int[ComposerRequestCode.values().length];
            f6794x1afc3a65 = iArr;
            try {
                iArr[ComposerRequestCode.AudioAddByMyFiles.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.AudioADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.ConvertSpeechToText.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.TextAddByMyFiles.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.TextADD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.PDFChooser.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.BrushDrawing.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.LockDocument.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.ChangeNoteStyle.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.Export.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.DocumentScan.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.InAppCollaborationFTU.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.StartCoedit.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.LeaveCoedit.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.AddPDFText.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.AddImageText.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.AddCameraImageText.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.ImageEditor.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.CoreTranslator.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.WritingToolkit.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.ImageStyleChanger.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.SettingContextMenu.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.HashTag.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.AddPageTemplate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.CoverEditor.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.DownloadLanguage.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.DrawingToolkit.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.SearchVoiceSTT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.SearchVoiceSTTSvi.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.SearchVoice.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f6794x1afc3a65[ComposerRequestCode.SearchVoiceSvi.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends AiMenuManager.ComponentFactory, ConfigurationFactory {
        @NonNull
        AiMenuManager createAiMenuManager();

        @NonNull
        AttachMenuPresenter createAttachMenuPresenter();

        @NonNull
        ContextMenuManager createContextMenuManager();

        @NonNull
        HwToolbarPresenter createHwToolbarPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull KeyguardPresenter keyguardPresenter);

        @NonNull
        KeyguardPresenter createKeyguardPresenter();

        @NonNull
        OptionMenuPresenter createOptionMenuPresenter();
    }

    public MenuPresenterManager(@NonNull MenuPresenterContract.IMenuParent iMenuParent, @NonNull ComponentFactory componentFactory) {
        this.mParent = iMenuParent;
        this.mComponentFactory = componentFactory;
        this.mOptionMenuPresenter = componentFactory.createOptionMenuPresenter();
        this.mContextMenuManager = componentFactory.createContextMenuManager();
        this.mShortCutManager = new ShortCutManager(componentFactory.getConfig().isShortCutEnabled());
        this.mKeyguardPresenter = componentFactory.createKeyguardPresenter();
        this.mAiMenuManager = componentFactory.createAiMenuManager();
    }

    private boolean canAddOnUnhandledKeyEventListener() {
        return Build.VERSION.SDK_INT >= 28 && this.mShortCutManager.getOnUnhandledKeyEventListener(false) != null;
    }

    private BaseInAppPresenter createInAppCollaborationPresenter() {
        return (this.mComponentFactory.getConfig().isInAppCollaborationEnabled() && ContinuityServiceManager.isSupportedInAppCollaborationAsServer()) ? new InAppCollaborationPresenter() : new BaseInAppPresenter();
    }

    private void createMenuPresenters(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager, ActionManager actionManager) {
        if (this.mVoiceRecordMenuPresenter != null) {
            Logger.m10999d(TAG, "createMenuPresenters# objects are already created");
            return;
        }
        this.mVoiceRecordMenuPresenter = new VoiceRecordMenuPresenter(this.mComponentFactory.getConfig().isVoiceRecordingEnabled());
        this.mTitleEditorPresenter = new TitleEditorPresenter(this.mComponentFactory.getConfig());
        this.mAttachMenuPresenter = this.mComponentFactory.createAttachMenuPresenter();
        this.mListMenuPresenter = new CompListPresenter(this, this.mComposerViewPresenter, this.mOptionMenuPresenter, this.mControllerManager, dialogPresenterManager);
        this.mHashTagPresenter = new HashTagPresenter();
        this.mToolbarPresenter = new ToolbarPresenter(composerViewPresenter, controllerManager, dialogPresenterManager);
        this.mRtToolbarPresenter = new RtToolbarPresenter(composerViewPresenter, controllerManager, dialogPresenterManager, actionManager, this.mKeyguardPresenter);
        this.mHwToolbarPresenter = this.mComponentFactory.createHwToolbarPresenter(this, composerViewPresenter, controllerManager, dialogPresenterManager, this.mKeyguardPresenter);
        this.mDwToolbarPresenter = new DwToolbarPresenter(composerViewPresenter, controllerManager, dialogPresenterManager);
        this.mSearchModePresenter = new SearchModePresenter();
        this.mStickyMemoManager = new StickyMemoManager(this.mComponentFactory.getConfig().isStickyMemoEnabled());
        this.mHwToggleFabManager = new HwToggleFabManager();
        this.mQuickToolPresenter = new QuickToolPresenter(composerViewPresenter, this.mHwToolbarPresenter, this.mStickyMemoManager);
        this.mTlToolbarPresenter = new TlToolbarPresenter(composerViewPresenter, controllerManager, dialogPresenterManager);
        this.mTableAndCellPresenter = new TableAndCellPresenter(composerViewPresenter, this.mContextMenuManager);
    }

    private boolean isInsufficientStorageExceptionOnPdfReader(Throwable th) {
        ComposerModel composerModel = this.mComposerModel;
        return composerModel != null && composerModel.isPDFReader() && (th instanceof IOException) && th.toString().contains("errno(11)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSyncConflictInvalidVersionType$1() {
        finish("executeSyncConflictInvalidVersionType");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSyncConflictInvalidVersionType$2() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(AppUpdateConstants.PRODUCT_DETAIL + this.mActivity.getPackageName() + "/?source=SamsungNotes&fsOrigin=stubUpdateCheck&fsUpdateType=self"));
        intent.addFlags(335544352);
        if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
            try {
                this.mActivity.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Logger.m11000e(TAG, "goToGalaxyAppStore# " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSyncConflictInvalidVersionType$3() {
        Logger.m10999d(TAG, "showVersionUpdateDialog#");
        this.mComposerViewPresenter.getDialogPresenterManager().showVersionUpdateDialog(new RunnableC9262a(this, 0), new RunnableC9262a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEvent$0(View view) {
        boolean zIsLaserPenMode = this.mComposerModel.getComposerState().isLaserPenMode();
        boolean z = !zIsLaserPenMode;
        this.mComposerModel.getComposerState().setLaserPenMode(z);
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().setEnableLaserPen(z);
        if (zIsLaserPenMode) {
            this.mHwToolbarPresenter.getWritingToolManager().setToolTypeAction(2, 1);
        }
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().hideSettingView(32768);
        invalidateOptionsMenu();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mComposerModel.isTabletLayout()), HWToolbarSAConstants.EVENT_HW_LASER_APPBAR_ON_OFF, !zIsLaserPenMode ? "a" : "b");
        this.mOptionMenuPresenter.talkbackSelectedButton(z, C9086R.string.hw_toolbar_item_laser_pen);
    }

    private void saveAsNewNoteWithTranslation() {
        this.mOptionMenuPresenter.saveAsNewNoteWithTranslation(null);
    }

    private void setDisableTextOnlyMode() {
        this.mOptionMenuPresenter.setDisableTextOnlyModeToHandwriting();
    }

    private void updateToolbarByInAppCollaborationMode(Mode mode) {
        Mode mode2 = Mode.Text;
        if (mode == mode2 || mode == Mode.Writing) {
            getHwToolbarPresenter().getMRemoteHwSettingPresenter().updateTextMode(mode == mode2);
        }
        if (mode == mode2) {
            getRtToolbarPresenter().show();
        } else {
            getRtToolbarPresenter().hideAll();
        }
        getHwToolbarPresenter().hideSettingPenMini();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void attachBottomView() {
        this.mOptionMenuPresenter.attachBottomView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void changeNoteType() {
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter == null || compListPresenter.getPageListPresenter() == null) {
            return;
        }
        this.mListMenuPresenter.getPageListPresenter().initView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void clearRecommendedCover() {
        this.mAiMenuManager.clearRecommendedCover();
    }

    public void closeToolbar() {
        ToolbarPresenter toolbarPresenter = this.mToolbarPresenter;
        if (toolbarPresenter != null) {
            toolbarPresenter.close();
        }
    }

    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return this.mAiMenuManager.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void doAiSuggestionForTranslation() {
        if (this.mOptionMenuPresenter.isTranslationOverlayActivated()) {
            Logger.m11000e(TAG, "doAiSuggestionForTranslation# isTranslationOverlayActivated = true");
        } else {
            this.mAiMenuManager.doAiSuggestionForTranslationDelay();
        }
    }

    public void executeSyncConflictInvalidVersionType() {
        Activity activity = this.mActivity;
        if (activity == null) {
            Logger.m11000e(TAG, "executeSyncConflictInvalidVersionType# mActivity is null");
        } else {
            activity.runOnUiThread(new RunnableC9262a(this, 2));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean finish(String str) {
        return this.mParent.finish(str);
    }

    public AiMenuManager getAiMenuManager() {
        return this.mAiMenuManager;
    }

    public ContextMenuManager getContextMenuManager() {
        return this.mContextMenuManager;
    }

    public DwToolbarPresenter getDwToolbarPresenter() {
        return this.mDwToolbarPresenter;
    }

    public DynamicTemplatePresenter getDynamicTemplatePresenter() {
        return this.mDynamicTemplatePresenter;
    }

    public HwToggleFabManager getHwToggleFabManager() {
        return this.mHwToggleFabManager;
    }

    public HwToolbarPresenter getHwToolbarPresenter() {
        return this.mHwToolbarPresenter;
    }

    public BaseInAppPresenter getInAppCollaborationPresenter() {
        return this.mInAppCollaborationPresenter;
    }

    public KeyguardPresenter getKeyguardPresenter() {
        return this.mKeyguardPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public Pair<Integer, Integer> getLaserPenData() {
        return new Pair<>(Integer.valueOf(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getLaserPenData().getLaserPenInfo().color), Integer.valueOf(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getLaserPenData().getLaserPenInfo().colorOption));
    }

    public CompListPresenter getListPresenter() {
        return this.mListMenuPresenter;
    }

    public OptionMenuPresenter getOptionMenuPresenter() {
        return this.mOptionMenuPresenter;
    }

    public QuickNotePresenter getQuickNotePresenter() {
        return this.mQuickNotePresenter;
    }

    public QuickToolPresenter getQuickToolPresenter() {
        return this.mQuickToolPresenter;
    }

    public RtToolbarPresenter getRtToolbarPresenter() {
        return this.mRtToolbarPresenter;
    }

    public SearchModePresenter getSearchModePresenter() {
        return this.mSearchModePresenter;
    }

    public ShortCutManager getShortCutManager() {
        return this.mShortCutManager;
    }

    public TableAndCellPresenter getTableAndCellMenuPresenter() {
        return this.mTableAndCellPresenter;
    }

    @Nullable
    public TitleEditorPresenter getTitleEditorPresenter() {
        return this.mTitleEditorPresenter;
    }

    public TlToolbarPresenter getTlToolbarPresenter() {
        return this.mTlToolbarPresenter;
    }

    public ToolbarPresenter getToolbarPresenter() {
        return this.mToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public View getToolbarView() {
        ToolbarPresenter toolbarPresenter = this.mToolbarPresenter;
        if (toolbarPresenter == null) {
            return null;
        }
        return toolbarPresenter.getToolbarView();
    }

    public VoiceRecordMenuPresenter getVoiceRecordMenuPresenter() {
        return this.mVoiceRecordMenuPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void hideAndInvalidateOptionsMenu() {
        this.mOptionMenuPresenter.hideOptionMenu();
        this.mOptionMenuPresenter.invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void hideBottomMenu() {
        this.mOptionMenuPresenter.hideBottomMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void hideOverlayTranslation() {
        this.mAiMenuManager.getAiContextMenuPresenter().releaseTranslateWithOverlay(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void hideStickyMemo(@Nullable String str) {
        hideStickyMemo(str, false);
    }

    public void hideToolbar(boolean z) {
        ToolbarPresenter toolbarPresenter = this.mToolbarPresenter;
        if (toolbarPresenter != null) {
            toolbarPresenter.hide(z);
        }
    }

    public void init(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, ComposerModel composerModel, PageManager pageManager, DialogPresenterManager dialogPresenterManager, LiveSharingContract liveSharingContract) {
        Logger.m10999d(TAG, "init#");
        this.mControllerManager = controllerManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mActionManager.init(composerViewPresenter, controllerManager, this);
        createMenuPresenters(composerViewPresenter, controllerManager, dialogPresenterManager, this.mActionManager);
        this.mAiMenuManager.init(this.mVoiceRecordMenuPresenter, composerViewPresenter, controllerManager, this.mTitleEditorPresenter, dialogPresenterManager, this, this.mHwToolbarPresenter, this.mKeyguardPresenter, this.mComponentFactory);
        this.mHwToolbarPresenter.setAiMenuManager(this.mAiMenuManager);
        this.mTitleEditorPresenter.init(this, this.mToolbarPresenter, composerViewPresenter, this.mHashTagPresenter, controllerManager, composerModel, liveSharingContract, this.mAiMenuManager, this.mKeyguardPresenter);
        this.mStickyMemoManager.init(this.mComposerViewPresenter, controllerManager, this.mHwToolbarPresenter, this.mRtToolbarPresenter, this.mToolbarPresenter, this.mActionManager);
        this.mVoiceRecordMenuPresenter.init(this, composerModel, composerViewPresenter, controllerManager, dialogPresenterManager);
        this.mOptionMenuPresenter.init(this, composerViewPresenter, controllerManager, composerModel, dialogPresenterManager, this.mVoiceRecordMenuPresenter, this.mActionManager, this.mAiMenuManager, this.mHwToolbarPresenter, this.mStickyMemoManager, this.mKeyguardPresenter, this.mDynamicTemplatePresenter.getMDynamicTemplateLoader());
        this.mDynamicTemplatePresenter.init(composerModel, controllerManager, this.mComposerViewPresenter, getOptionMenuPresenter().getOptionMenuAddPresenter(), this.mAttachMenuPresenter);
        this.mContextMenuManager.init(composerViewPresenter, controllerManager, this.mHwToolbarPresenter, dialogPresenterManager, controllerManager.getQuickSaveTimer(), this.mVoiceRecordMenuPresenter, this.mAiMenuManager, this.mDynamicTemplatePresenter.getMDynamicTemplateController(), this.mStickyMemoManager);
        this.mAttachMenuPresenter.init(controllerManager, pageManager, composerViewPresenter, composerModel);
        this.mHashTagPresenter.init(composerModel, controllerManager.getHashTagController(), dialogPresenterManager, composerViewPresenter);
        this.mListMenuPresenter.init(pageManager, composerModel);
        this.mShortCutManager.init(this.mContextMenuManager, controllerManager, this.mComposerViewPresenter, this.mHwToolbarPresenter, this.mRtToolbarPresenter, this.mListMenuPresenter, this.mOptionMenuPresenter, this.mActionManager);
        this.mSearchModePresenter.init(this, this.mComposerViewPresenter, this.mControllerManager, composerModel, this.mVoiceRecordMenuPresenter);
        this.mQuickNotePresenter.init(dialogPresenterManager, controllerManager, composerModel, this.mComposerViewPresenter);
        this.mInAppCollaborationPresenter.init(this.mComposerViewPresenter, this.mOptionMenuPresenter, this.mHwToolbarPresenter, this.mRtToolbarPresenter, this.mToolbarPresenter, controllerManager, this.mQuickToolPresenter);
        this.mRtToolbarPresenter.setAiMenuManager(this.mAiMenuManager);
        this.mKeyguardPresenter.init(this.mComposerModel.getComposerSaveModel());
        this.mHwToggleFabManager.init(this.mToolbarPresenter, controllerManager, composerModel);
        this.mInitialized = true;
    }

    public void initFirstCase() {
        HwToolbarPresenter hwToolbarPresenter = this.mHwToolbarPresenter;
        if (hwToolbarPresenter != null) {
            hwToolbarPresenter.initFirstCase();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void invalidateOptionsMenu() {
        this.mOptionMenuPresenter.invalidateOptionsMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean isClickedPageList() {
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        return compListPresenter != null && compListPresenter.isClicked();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean isEnabledInAppCollaboration() {
        return getInAppCollaborationPresenter().isEnabledInAppCollaboration();
    }

    public boolean isLockVerified() {
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null) {
            return optionMenuPresenter.isLockVerified();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean isPageListShowing() {
        return this.mListMenuPresenter.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean isRestrictedInAppCollaboration() {
        return getInAppCollaborationPresenter().isRestrictedInAppCollaboration();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean isToolbarShowing() {
        return this.mToolbarPresenter.isToolbarShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void notifyChangedIsOverlayTranslating(boolean z) {
        Logger.m11000e(TAG, "notifyChangedIsOverlayTranslating# isTranslating = " + z);
        this.mHwToolbarPresenter.updateEnableUndoRedoMenu();
        this.mRtToolbarPresenter.updateEnableUndoRedoMenu();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == 52) {
            return false;
        }
        if (i == 53) {
            ContentPickerUtils.requestMyFilesAppToPickPath(ComposerRequestCode.Export.getId(), this.mActivity);
            return true;
        }
        if (this.mDynamicTemplatePresenter.onActivityResult(i, i2, intent) || this.mAttachMenuPresenter.onActivityResult(i, i2, intent) || this.mOptionMenuPresenter.onLockActivityResult(i, i2, intent)) {
            return true;
        }
        switch (C92611.f6794x1afc3a65[ComposerRequestCode.get(i).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return this.mOptionMenuPresenter.onActivityResult(i, i2, intent);
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return this.mContextMenuManager.onActivityResult(i, i2, intent);
            case 23:
                return this.mControllerManager.getHashTagController().onActivityResult(i2, intent);
            case 24:
                return this.mListMenuPresenter.onActivityResult(i, i2, intent);
            case 25:
                return this.mAiMenuManager.getAiCoverMenuViewPresenter().onActivityResult(i, i2, intent);
            case 26:
            case 27:
            case 28:
            case 29:
                return this.mAiMenuManager.onActivityResult(i, i2, intent);
            case 30:
            case 31:
                return this.mSearchModePresenter.onActivityResult(i, i2, intent);
            default:
                return false;
        }
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        Logger.m10999d(TAG, "onAttachView#");
        RtToolbarPresenter rtToolbarPresenter = this.mRtToolbarPresenter;
        if (rtToolbarPresenter != null) {
            rtToolbarPresenter.onAttachView();
            this.mAttachMenuPresenter.onAttachView(activity, fragment);
            this.mListMenuPresenter.onAttachView(activity);
            this.mDwToolbarPresenter.onAttachView();
        }
        this.mComposerViewPresenter.getListenerManager().setContextMenuManager(this.mContextMenuManager);
        this.mComposerViewPresenter.getListenerManager().setShortcutManager(this.mShortCutManager);
        this.mComposerViewPresenter.setHwToolbarPresenter(this.mHwToolbarPresenter);
        this.mComposerViewPresenter.setInAppPresenter(this.mInAppCollaborationPresenter);
        this.mComposerViewPresenter.setTlToolbarPresenter(this.mTlToolbarPresenter);
        this.mComposerViewPresenter.setTableAndCellPresenter(this.mTableAndCellPresenter);
        RtToolbarPresenter rtToolbarPresenter2 = this.mRtToolbarPresenter;
        if (rtToolbarPresenter2 != null) {
            this.mComposerViewPresenter.setRtTableAndCellStylePresenter(rtToolbarPresenter2.getRtTableAndCellStylePresenter());
        }
        this.mOptionMenuPresenter.onAttachView(activity, fragment);
        this.mContextMenuManager.onAttachView(activity);
        this.mTitleEditorPresenter.onAttachView(activity);
        this.mVoiceRecordMenuPresenter.onAttachView(activity, fragment);
        this.mInAppCollaborationPresenter.onAttachView(activity);
        this.mQuickNotePresenter.onAttachView();
        this.mAiMenuManager.onAttachView(fragment);
        this.mStickyMemoManager.onAttachView();
        this.mHwToggleFabManager.onAttachView(activity);
        this.mDynamicTemplatePresenter.onAttachView(activity, fragment);
        this.mActivity = activity;
        if (!canAddOnUnhandledKeyEventListener() || fragment.getView() == null) {
            return;
        }
        fragment.getView().addOnUnhandledKeyEventListener(this.mShortCutManager.getOnUnhandledKeyEventListener(false));
    }

    public boolean onBackPressed() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter;
        if (!this.mInitialized) {
            return false;
        }
        if (ResourceUtils.isTabletLayout(this.mActivity) && this.mAiMenuManager.isShowingResultView() && (voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter) != null && voiceRecordMenuPresenter.onBackPressed()) {
            Logger.m10999d(TAG, "mVoiceRecordMenuPresenter# onBackPressed split layout");
            return true;
        }
        if (this.mAiMenuManager.onBackPressed()) {
            Logger.m10999d(TAG, "mAiMenuManager# onBackPressed");
            return true;
        }
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null && searchModePresenter.onBackPressed()) {
            Logger.m10999d(TAG, "mSearchModePresenter# onBackPressed");
            return true;
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter2 != null && voiceRecordMenuPresenter2.onBackPressed()) {
            Logger.m10999d(TAG, "mVoiceRecordMenuPresenter# onBackPressed");
            return true;
        }
        HwToolbarPresenter hwToolbarPresenter = this.mHwToolbarPresenter;
        if (hwToolbarPresenter != null && hwToolbarPresenter.onBackPressed()) {
            Logger.m10999d(TAG, "mHwToolbarPresenter# onBackPressed");
            return true;
        }
        BaseInAppPresenter baseInAppPresenter = this.mInAppCollaborationPresenter;
        if (baseInAppPresenter != null && baseInAppPresenter.onBackPressed()) {
            Logger.m10999d(TAG, "mInAppCollaborationPresenter# onBackPressed");
            return true;
        }
        StickyMemoManager stickyMemoManager = this.mStickyMemoManager;
        if (stickyMemoManager == null || !stickyMemoManager.onBackPressed()) {
            OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
            return optionMenuPresenter != null && optionMenuPresenter.onBackPressed();
        }
        Logger.m10999d(TAG, "mStickyMemoManager# onBackPressed");
        return true;
    }

    public boolean onBackPressedBeforeComposerView() {
        if (this.mInitialized) {
            return this.mAiMenuManager.onBackPressedBeforeComposerView();
        }
        return false;
    }

    public void onChangeLayoutBefore() {
        this.mQuickNotePresenter.onChangeLayoutBefore();
        this.mAiMenuManager.onChangeLayoutBefore();
        StickyMemoManager stickyMemoManager = this.mStickyMemoManager;
        if (stickyMemoManager != null) {
            stickyMemoManager.onLayoutChangeBefore();
        }
    }

    public void onChangeMode(@NonNull Mode mode) {
        Logger.m10999d(TAG, "onChangeMode# mode " + mode);
        if (mode == Mode.ReadOnly) {
            this.mOptionMenuPresenter.showBottomMenu();
        }
    }

    public void onDestroy(boolean z, Activity activity) {
        TitleEditorPresenter titleEditorPresenter = this.mTitleEditorPresenter;
        if (titleEditorPresenter != null) {
            titleEditorPresenter.onDestroy();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.onDestroy(true, z, activity);
        }
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null) {
            compListPresenter.onDestroy();
        }
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null) {
            searchModePresenter.onDestroy();
        }
        this.mQuickNotePresenter.onDestroy();
        this.mAiMenuManager.onDestroy();
        StickyMemoManager stickyMemoManager = this.mStickyMemoManager;
        if (stickyMemoManager != null) {
            stickyMemoManager.onDestroyView();
        }
    }

    public void onDetachView(View view) {
        Logger.m10999d(TAG, "onDetachView#");
        RtToolbarPresenter rtToolbarPresenter = this.mRtToolbarPresenter;
        if (rtToolbarPresenter != null) {
            rtToolbarPresenter.onDetachView();
            this.mHwToolbarPresenter.onDetachView();
            this.mDwToolbarPresenter.onDetachView();
            this.mAttachMenuPresenter.onDetachView();
        }
        ToolbarPresenter toolbarPresenter = this.mToolbarPresenter;
        if (toolbarPresenter != null) {
            toolbarPresenter.release();
        }
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null) {
            compListPresenter.onDetachView();
        }
        HashTagPresenter hashTagPresenter = this.mHashTagPresenter;
        if (hashTagPresenter != null) {
            hashTagPresenter.onDetachView();
        }
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null) {
            searchModePresenter.onDetachView();
        }
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null) {
            optionMenuPresenter.onDetachView();
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.onDetachView();
        }
        BaseInAppPresenter baseInAppPresenter = this.mInAppCollaborationPresenter;
        if (baseInAppPresenter != null) {
            baseInAppPresenter.onDetachView();
        }
        if (canAddOnUnhandledKeyEventListener()) {
            if (view != null) {
                view.removeOnUnhandledKeyEventListener(this.mShortCutManager.getOnUnhandledKeyEventListener(true));
            } else {
                this.mShortCutManager.getOnUnhandledKeyEventListener(true);
            }
        }
        this.mQuickNotePresenter.onDetachView();
        this.mAiMenuManager.onDetachView(new boolean[0]);
        StickyMemoManager stickyMemoManager = this.mStickyMemoManager;
        if (stickyMemoManager != null) {
            stickyMemoManager.onDetachView();
        }
        HwToggleFabManager hwToggleFabManager = this.mHwToggleFabManager;
        if (hwToggleFabManager != null) {
            hwToggleFabManager.onDetachView();
        }
        this.mDynamicTemplatePresenter.release();
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onEvent(int i) {
        HwToolbarPresenter hwToolbarPresenter;
        if (i == 3 || i == 4) {
            this.mAiMenuManager.hideResultView();
            this.mControllerManager.getSoftInputManager().hide((View) null);
            this.mListMenuPresenter.onClicked();
            return;
        }
        if (i == 2) {
            this.mControllerManager.getSoftInputManager().hide((View) null);
            this.mAttachMenuPresenter.show(this.mControllerManager.getSoftInputManager().isInputMethodShown() ? 300 : 0, AppInfo.APP_GALLERY);
            return;
        }
        if (i == 1) {
            this.mControllerManager.getSoftInputManager().hide((View) null);
            this.mAttachMenuPresenter.show(this.mControllerManager.getSoftInputManager().isInputMethodShown() ? 300 : 0, AppInfo.APP_CAMERA);
            return;
        }
        if (i == 5) {
            if (this.mListMenuPresenter.isShowing()) {
                this.mListMenuPresenter.hide(true);
                return;
            }
            return;
        }
        if (i == 6) {
            if (isToolbarShowing()) {
                this.mToolbarPresenter.hide(false);
                return;
            } else {
                this.mToolbarPresenter.show(false);
                return;
            }
        }
        if (i == 7 || i == 8) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
            if (voiceRecordMenuPresenter != null) {
                voiceRecordMenuPresenter.moveProgress(i == 7);
                return;
            }
            return;
        }
        if (i == 9) {
            VoiceRecordMenuPresenter voiceRecordMenuPresenter2 = this.mVoiceRecordMenuPresenter;
            if (voiceRecordMenuPresenter2 != null) {
                voiceRecordMenuPresenter2.togglePlayAudioAndVoice();
                return;
            }
            return;
        }
        if (i == 10) {
            if (!this.mComposerModel.getModeManager().isEditMode() || (hwToolbarPresenter = this.mHwToolbarPresenter) == null) {
                return;
            }
            hwToolbarPresenter.toggleZoomLock();
            return;
        }
        if (i == 11) {
            if (this.mComposerModel.isTabletLayout()) {
                HwToolbarPresenter hwToolbarPresenter2 = this.mHwToolbarPresenter;
                if (hwToolbarPresenter2 != null) {
                    hwToolbarPresenter2.executeAiAssist();
                    return;
                }
                return;
            }
            RtToolbarPresenter rtToolbarPresenter = this.mRtToolbarPresenter;
            if (rtToolbarPresenter != null) {
                rtToolbarPresenter.executeAiAssist();
                return;
            }
            return;
        }
        if (i == 12) {
            if (NotificationUtils.checkedNotificationPermissions(this.mActivity, 134)) {
                saveAsNewNoteWithTranslation();
            }
        } else if (i != 13) {
            if (i == 14) {
                this.mTitleEditorPresenter.show();
            }
        } else {
            if (this.mHwToolbarPresenter == null) {
                return;
            }
            if (this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
                this.mHwToolbarPresenter.showSettingPopupOfLaserPen(this.mComposerModel.getComposerState().isLaserPenMode(), new ViewOnClickListenerC8556a(this, 12));
            } else if (this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
                this.mHwToolbarPresenter.setSelectedLaserPenButton();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onHideMenu(MenuPresenterContract.CMenu cMenu) {
        if (cMenu == MenuPresenterContract.CMenu.AI_MENU_RESULT) {
            if (!this.mComposerModel.isTabletLayout()) {
                this.mToolbarPresenter.setEnableToolTip(false);
            }
            if (!this.mAiMenuManager.getHwToolbarPresenter().isShowing() || this.mAiMenuManager.getHwToolbarPresenter().getMToolbarMenuView() == null) {
                return;
            }
            this.mAiMenuManager.getHwToolbarPresenter().getMToolbarMenuView().updatePolicy(1048576, false);
        }
    }

    public void onPause() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.onPause();
        }
        BaseInAppPresenter baseInAppPresenter = this.mInAppCollaborationPresenter;
        if (baseInAppPresenter != null) {
            baseInAppPresenter.onPause();
        }
    }

    public void onReadyReload() {
        this.mListMenuPresenter.hide(true);
        this.mTitleEditorPresenter.hide(false);
        this.mAiMenuManager.onReadyReload();
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.mOptionMenuPresenter.onRequestPermissionsResult(i, strArr, iArr) || this.mContextMenuManager.onRequestPermissionsResult(i, strArr, iArr) || this.mVoiceRecordMenuPresenter.onRequestPermissionsResult(i) || this.mDynamicTemplatePresenter.onRequestPermissionsResult(i, strArr, iArr) || this.mAttachMenuPresenter.onRequestPermissionsResult(i, strArr, iArr) || this.mQuickNotePresenter.onRequestPermissionsResult(i, strArr, iArr)) {
            return true;
        }
        if (i != 134) {
            return false;
        }
        if (PermissionHelper.verifyRequestResult(this.mActivity, iArr, strArr)) {
            saveAsNewNoteWithTranslation();
        } else {
            Logger.m10999d(TAG, "onRequestPermissionsResult# PERMISSION_REQUEST_FOR_TRANSLATION_NOTIFICATION not verified");
        }
        return true;
    }

    public void onResume() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.onResume();
        }
        BaseInAppPresenter baseInAppPresenter = this.mInAppCollaborationPresenter;
        if (baseInAppPresenter != null) {
            baseInAppPresenter.onResume();
        }
        this.mQuickNotePresenter.onResume();
        this.mAiMenuManager.onResume();
        this.mKeyguardPresenter.updateStatus(this.mActivity);
    }

    public void onSaveCompleted() {
        this.mSaveFailureCount = 0;
    }

    public void onSaveFailed(Throwable th, String str) {
        if (th instanceof SpenBoundFileNotFoundException) {
            AbstractC8014b.m7198D("onSaveFailed# + SpenBoundFileNotFoundException uuid = ", str, TAG);
        } else {
            ToastHandler.show(this.mActivity, C9086R.string.composer_save_failed, 0);
            if (isInsufficientStorageExceptionOnPdfReader(th)) {
                this.mSaveFailureCount++;
                String str2 = TAG;
                Logger.m11002f(str2, "#onSaveFailed, count:" + this.mSaveFailureCount + ", freeStorage: " + String.format(Locale.getDefault(), "%.2f", Double.valueOf(StorageUtils.getAvailableInternalMemorySize() / 1.073741824E9d)) + Constants.GIGABYTE);
                if (this.mSaveFailureCount <= 3) {
                    return;
                }
            }
        }
        finish("onSaveFailed");
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m10999d(TAG, "onSaveInstanceState#");
        HwToolbarPresenter hwToolbarPresenter = this.mHwToolbarPresenter;
        if (hwToolbarPresenter != null) {
            hwToolbarPresenter.onSaveInstanceState(bundle);
        }
        RtToolbarPresenter rtToolbarPresenter = this.mRtToolbarPresenter;
        if (rtToolbarPresenter != null) {
            rtToolbarPresenter.onSaveInstanceState(bundle);
        }
        DwToolbarPresenter dwToolbarPresenter = this.mDwToolbarPresenter;
        if (dwToolbarPresenter != null) {
            dwToolbarPresenter.onSaveInstanceState(bundle);
        }
        TlToolbarPresenter tlToolbarPresenter = this.mTlToolbarPresenter;
        if (tlToolbarPresenter != null) {
            tlToolbarPresenter.onSaveInstanceState(bundle);
        }
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null) {
            searchModePresenter.onSaveInstanceState(bundle);
        }
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null) {
            compListPresenter.onSaveInstanceState(bundle);
        }
        TitleEditorPresenter titleEditorPresenter = this.mTitleEditorPresenter;
        if (titleEditorPresenter != null) {
            titleEditorPresenter.onSaveInstanceState();
        }
        AttachMenuPresenter attachMenuPresenter = this.mAttachMenuPresenter;
        if (attachMenuPresenter != null) {
            attachMenuPresenter.onSaveInstanceState(bundle);
        }
        this.mQuickNotePresenter.onSaveInstanceState(bundle);
        BaseInAppPresenter baseInAppPresenter = this.mInAppCollaborationPresenter;
        if (baseInAppPresenter != null) {
            baseInAppPresenter.onSaveInstanceState(bundle);
        }
        QuickToolPresenter quickToolPresenter = this.mQuickToolPresenter;
        if (quickToolPresenter != null) {
            quickToolPresenter.onSaveState();
        }
        this.mAiMenuManager.onSaveInstanceState(bundle);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onSearchDone(String str) {
        this.mVoiceRecordMenuPresenter.onSearchDone(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onShowMenu(MenuPresenterContract.CMenu cMenu) {
        if (cMenu == MenuPresenterContract.CMenu.AI_MENU_RESULT) {
            this.mListMenuPresenter.hide(true);
            if (!this.mComposerModel.isTabletLayout()) {
                this.mToolbarPresenter.setEnableToolTip(true);
            }
            this.mQuickNotePresenter.hideQuickNoteDialog("AI_MENU_RESULT", null, false);
            if (this.mAiMenuManager.getHwToolbarPresenter().getMToolbarMenuView() != null) {
                this.mAiMenuManager.getHwToolbarPresenter().getMToolbarMenuView().updatePolicy(1048576, true);
                return;
            }
            return;
        }
        if (cMenu == MenuPresenterContract.CMenu.AI_MENU_FOR_PDF_VIEWER) {
            this.mAiMenuManager.hideContextMenu(true);
            this.mAiMenuManager.showSelectionContextMenu(2, this.mActivity.findViewById(C9086R.id.appbar_layout));
        } else if (cMenu == MenuPresenterContract.CMenu.AI_MENU_FOR_PDF_VIEWER_OVERLAY) {
            this.mAiMenuManager.hideResultView();
            this.mAiMenuManager.executeTranslateWithOverlay(true, null);
        }
    }

    public void onStart(Activity activity) {
        this.mQuickNotePresenter.onStart();
        this.mOptionMenuPresenter.onStart(activity);
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null) {
            compListPresenter.getPageListPresenter().restoreUIResource();
        }
    }

    public void onStop() {
        this.mQuickNotePresenter.onStop();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onTranslationStateUpdated(int i) {
        this.mOptionMenuPresenter.onTranslationStateUpdated(i);
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null) {
            compListPresenter.getPageListPresenter().updateSearchButtonVisibility(i == 1);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void onTriggerMenu(MenuPresenterContract.CMenu cMenu) {
        if (cMenu == MenuPresenterContract.CMenu.AI_DRAWING_TRIGGER) {
            this.mListMenuPresenter.hide(true);
            this.mQuickNotePresenter.hideQuickNoteDialog("AI_DRAWING_POPUP", null, false);
        }
    }

    public boolean onWindowFocusChanged(boolean z) {
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null && searchModePresenter.onWindowFocusChanged(z)) {
            return true;
        }
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null && compListPresenter.onWindowFocusChanged(z)) {
            return true;
        }
        TitleEditorPresenter titleEditorPresenter = this.mTitleEditorPresenter;
        return titleEditorPresenter != null && titleEditorPresenter.onWindowFocusChanged(z);
    }

    public void onWindowModeChanged(int i) {
        this.mQuickNotePresenter.onWindowModeChanged(i);
        this.mInAppCollaborationPresenter.onWindowModeChanged(i);
    }

    public void resetLockVerified() {
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null) {
            optionMenuPresenter.resetLockVerified();
        }
    }

    public void restoreState(Bundle bundle, boolean z) {
        String str = TAG;
        Logger.m10999d(str, "restoreState#");
        HwToolbarPresenter hwToolbarPresenter = this.mHwToolbarPresenter;
        if (hwToolbarPresenter != null) {
            hwToolbarPresenter.restoreViewState(bundle);
        }
        RtToolbarPresenter rtToolbarPresenter = this.mRtToolbarPresenter;
        if (rtToolbarPresenter != null) {
            rtToolbarPresenter.restoreState(bundle);
        }
        DwToolbarPresenter dwToolbarPresenter = this.mDwToolbarPresenter;
        if (dwToolbarPresenter != null) {
            dwToolbarPresenter.restoreState(bundle);
        }
        TlToolbarPresenter tlToolbarPresenter = this.mTlToolbarPresenter;
        if (tlToolbarPresenter != null) {
            tlToolbarPresenter.restoreState(bundle);
        }
        SearchModePresenter searchModePresenter = this.mSearchModePresenter;
        if (searchModePresenter != null) {
            searchModePresenter.restoreState(bundle);
        }
        CompListPresenter compListPresenter = this.mListMenuPresenter;
        if (compListPresenter != null && !z) {
            compListPresenter.restoreState(this.mActivity, bundle);
        }
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.restore();
        }
        AttachMenuPresenter attachMenuPresenter = this.mAttachMenuPresenter;
        if (attachMenuPresenter != null) {
            attachMenuPresenter.restoreState(bundle);
        }
        QuickToolPresenter quickToolPresenter = this.mQuickToolPresenter;
        if (quickToolPresenter != null) {
            quickToolPresenter.restoreState(bundle);
        }
        this.mQuickNotePresenter.restoreState(bundle);
        this.mAiMenuManager.restoreState(bundle);
        Logger.m10999d(str, "restoreState# end");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void showOverlayTranslation() {
        this.mAiMenuManager.executeTranslateWithOverlay(false, null);
    }

    public void showToolbar(boolean z) {
        if (this.mToolbarPresenter == null || !this.mComposerModel.getModeManager().isEditMode()) {
            return;
        }
        this.mToolbarPresenter.show(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public void stopVoice() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            voiceRecordMenuPresenter.stopPlaying();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.common.MenuPresenterContract.IMenuManager
    public boolean toggleVoicePanel() {
        VoiceRecordMenuPresenter voiceRecordMenuPresenter = this.mVoiceRecordMenuPresenter;
        if (voiceRecordMenuPresenter != null) {
            return voiceRecordMenuPresenter.toggleExpendVoicePanel();
        }
        return false;
    }

    public void updateDeleteOnlyState(boolean z) {
        if (!z) {
            getHwToolbarPresenter().updateDeleteOnlyState(false);
        } else if (this.mComposerModel.getModeManager().isMode(Mode.Writing) || this.mComposerModel.isTabletLayout()) {
            getHwToolbarPresenter().updateDeleteOnlyState(true);
        }
    }

    public void updateMoveOnlyState(boolean z) {
        getHwToolbarPresenter().updateMoveOnlyState(z);
    }

    public void updateToolbarByMode(boolean z) {
        Mode mode = this.mComposerModel.getModeManager().getMode();
        if (this.mComposerModel.getComposerState().isInAppCollaborationMode()) {
            updateToolbarByInAppCollaborationMode(mode);
            return;
        }
        if (mode == Mode.Writing) {
            showToolbar(z);
            if (this.mComposerModel.isTabletLayout()) {
                getHwToolbarPresenter().show();
                getHwToolbarPresenter().showSettingPenMini();
            } else {
                getHwToolbarPresenter().show();
            }
            getRtToolbarPresenter().hideAll();
            if (this.mComposerModel.getModeManager().getPrevMode() == Mode.Text) {
                setDisableTextOnlyMode();
                return;
            }
            return;
        }
        if (mode != Mode.Text) {
            hideToolbar(z);
            closeToolbar();
            getRtToolbarPresenter().hide();
            if (this.mComposerModel.isTabletLayout()) {
                getHwToolbarPresenter().hideSettingPenMini();
                return;
            }
            return;
        }
        showToolbar(z);
        if (DeviceInfo.isVSTModel()) {
            getHwToolbarPresenter().hide();
        } else {
            getHwToolbarPresenter().show();
            getHwToolbarPresenter().hideSettingPenMini();
        }
        if (getRtToolbarPresenter().shouldAlwaysShowInTextMode() || this.mControllerManager.getSoftInputManager().isSipShowing()) {
            getRtToolbarPresenter().show();
        }
    }

    public boolean verifyScreenLock() {
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter != null) {
            return optionMenuPresenter.verifyScreenLock();
        }
        return false;
    }

    public void hideStickyMemo(@Nullable String str, boolean z) {
        this.mStickyMemoManager.hideMemo(false, str, z);
    }
}
