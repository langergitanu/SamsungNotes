package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.EdpManager;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.TipCardUtil;
import com.samsung.android.support.senl.p148nt.app.importer.ImportProcessor;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.task.PdfImportTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.TipCardAdapter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.TipCardPager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ConvertTaskFactoryListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ImportPDFTaskListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.ImportSDocTaskListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardCheckConvertedNotes;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardConvertNotes;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardEdpKeyError;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardEdpNotSupported;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardEdpNotSupportedRecommendUpdate;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardExternalStorageNotGranted;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardFailToSyncPSM;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardImportNoteFromAccount;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardImportPdf;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardImportSamsungNotes;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardMeet;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardMicrosoftAccountLogin;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardMicrosoftAccountLoginAgain;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardSyncProgressFail;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.view.TipCardView;
import com.samsung.android.support.senl.p148nt.app.settings.SettingsActivity;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import com.samsung.android.support.senl.p148nt.base.common.util.AppInfoUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import p025F0.AbstractC0089d;
import p026F1.C0099c;
import p038I1.C0136l;
import p038I1.C0137m;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p052M.C0171a;
import p086V.C0322h;
import p186h1.C12028i;
import p192j1.C12936a;
import p207n1.C13540g;
import p207n1.C13541h;
import p244u1.C14477a;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TipCardHelper {
    private static final String TAG = "TipCardHelper";
    private final SharedPreferences.OnSharedPreferenceChangeListener mAccountImportTipCardPreferenceListener;
    private DataTask mCheckConvertedNoteDataTask;
    private final TipCardView.Contract mContract;
    private ConvertTaskFactoryListener mConvertTaskFactoryListener;
    private final DocumentMap mDocumentMap;
    private final IPresenter mIPresenter;
    private ImportPDFTaskListener mImportPDFTaskListener;
    private ImportSDocTaskListener mImportSDocTaskListener;
    private TabLayout mIndicator;
    private final SharedPreferences.OnSharedPreferenceChangeListener mMicrosoftAccountLoginTipCardPreferenceListener;
    private final ViewPager.OnPageChangeListener mPageChangeListener;
    private SettingsMicrosoft mSettingsMicrosoft;
    private final StateInfo mStateInfo;
    private final TipCardAdapter mTipCardAdapter;
    private final TipCardTaskListener mTipCardTaskListener;
    private TipCardPager mViewPager;
    private final ViewParams mViewParams;
    private int mTipCardPage = -1;
    private int mTipCardCount = 0;
    private final TipCardListener mSyncTipCardProgressListener = new TipCardListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.1
        @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener
        public void onCreate(TipCard tipCard) {
            MainLogger.m7258i(TipCardHelper.TAG, "mSyncTipCardProgressListener# onCreate()");
            if (TipCardUtil.isValidTipCardOnMode(tipCard.getType(), TipCardHelper.this.mViewParams.getModeIndex(), TipCardHelper.this.mStateInfo.getFolderUuid())) {
                if (tipCard.getType() == 1) {
                    TipCardHelper.this.removeTipCard(tipCard.getType());
                }
                TipCardHelper.this.addTipCard(tipCard);
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener
        public void onEnd(TipCard tipCard) {
            MainLogger.m7258i(TipCardHelper.TAG, "mSyncTipCardProgressListener# onEnd()");
            TipCardHelper.this.removeTipCard(tipCard.getType());
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener
        public void onUpdate(TipCard tipCard) {
            MainLogger.m7258i(TipCardHelper.TAG, "mSyncTipCardProgressListener# onUpdate()");
            TipCardHelper.this.updateProgress(tipCard);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void handleTipCardItemCountChange();

        void joinMeetingWithTipCard(LiveSharingManager.Caller caller, boolean z, LiveSharingManager.TipCardCallback tipCardCallback);

        void removeTipCard();

        void requestConvertAllOldNotes();

        void showAppUpdateDialog(String str);

        void showSamsungAccountLoginForMsSyncDialog();

        void showTipCard();

        void startConvertNotes(List<String> list);

        void updateTipCardLayout();
    }

    public TipCardHelper(ViewParams viewParams, DocumentMap documentMap, StateInfo stateInfo, IPresenter iPresenter) {
        TipCardView.Contract contract = new TipCardView.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.2
            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardAppUpdate() {
                EdpManager.getInstance().setUpdateNotify(true);
                UpdateManager.getInstance().goToGalaxyAppStore();
                TipCardHelper.this.removeTipCard(30);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardCancel(int i) {
                if (i == 1) {
                    TipCardHelper.this.showImportCancelDialog(i);
                    return;
                }
                if (i == 21) {
                    TipCardHelper.this.cancelConvertOldNote();
                } else if (i == 24) {
                    TipCardHelper.this.cancelImportNote();
                } else if (i == 26) {
                    TipCardHelper.this.cancelImportPdf();
                } else if (i == 29) {
                    EdpManager.getInstance().setUnsupportNotify(true);
                } else if (i == 30) {
                    EdpManager.getInstance().setUpdateNotify(true);
                } else if (i == 31) {
                    EdpManager.getInstance().setNotifyTipcardEdpKeyError(true);
                }
                TipCardHelper.this.removeTipCard(i);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardCheckConvertedNotes() {
                TipCardHelper.this.removeTipCard(36);
                TipCardHelper.this.mViewParams.getNotesView().onOldCategorySelected("old_converted_notes");
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardClose(int i) {
                AbstractC8014b.m7201c(i, "onTipCardClose# ", TipCardHelper.TAG);
                if (i == 18) {
                    TipCardUtil.setAccountImportTipCardDisabled();
                    return;
                }
                if (i == 23) {
                    TipCardUtil.setMicrosoftFeedLoginTipcardDisabled();
                    return;
                }
                if (i == 27) {
                    AbstractC0089d.m230b(false);
                } else if (i == 25) {
                    TipCardUtil.setExternalStorageTipCardEnabled(false);
                } else if (i == 29) {
                    EdpManager.getInstance().setUnsupportNotify(true);
                } else if (i == 30) {
                    EdpManager.getInstance().setUpdateNotify(true);
                } else if (i == 31) {
                    EdpManager.getInstance().setNotifyTipcardEdpKeyError(true);
                } else if (i == 6 || i == 11) {
                    C0137m.m280d().m286g(i);
                } else if (i == 36) {
                    TipCardUtil.countUpConvertTryCount("close_check_converted_notes_tipcard");
                } else if (i == 37) {
                    TipCardHelper.this.mStateInfo.setTipCardSyncOffAvailable(false);
                }
                TipCardHelper.this.removeTipCard(i);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardImportAccount() {
                TipCardHelper.this.removeTipCard(18);
                TipCardUtil.setAccountImportTipCardDisabled();
                TipCardHelper.this.showSettingForSyncWithSamsungCloud();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardManageCloudStorage() {
                TipCardHelper.this.removeTipCard(12);
                TipCardHelper.this.showSCloudStorage();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardMdeTryAgain() {
                if (TipCardHelper.this.requestGCSSyncFromTipCard()) {
                    TipCardHelper.this.removeTipCard(13);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardMeetEntering(boolean z) {
                TipCardHelper.this.enterMeeting(z);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardMeetNewNote(boolean z) {
                TipCardHelper.this.createMeeting(z);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardOpenSettingsMicrosoftLogin() {
                TipCardHelper.this.showMSLoginPage();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardOpenSettingsMicrosoftLoginAgain() {
                TipCardHelper.this.removeTipCard(27);
                TipCardHelper.this.showMSLoginPageRetry();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardPermissionNotGranted(int i) {
                if (i == 11) {
                    TipCardHelper.this.removeTipCard(11);
                    TipCardHelper.this.showAppInfoSetting();
                } else if (i == 25) {
                    TipCardHelper.this.removeTipCard(25);
                    TipCardHelper.this.requestExternalStoragePermission();
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardRetry(int i) {
                AbstractC8014b.m7201c(i, "onTipCardRetry type ", TipCardHelper.TAG);
                TipCardHelper.this.removeTipCard(i);
                TipCardHelper.this.reTryImporting();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardSyncWithSamsungCloud(int i) {
                TipCardHelper.this.removeTipCard(i);
                if (i == 37) {
                    TipCardHelper.this.mStateInfo.setTipCardSyncOffAvailable(false);
                }
                TipCardHelper.this.showSettingForSyncWithSamsungCloud();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipCardTryAgain(int i) {
                boolean zRequestSyncByTipCard = TipCardHelper.this.requestSyncByTipCard(i);
                MainLogger.m7258i(TipCardHelper.TAG, "onTipCardTryAgain, type: " + i + ", result: " + zRequestSyncByTipCard);
                if (zRequestSyncByTipCard) {
                    TipCardHelper.this.removeTipCard(i);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.Contract
            public void onTipcardEnterCode() {
                EdpManager.getInstance().setNotifyTipcardEdpKeyError(true);
                ToastHandler.show(BaseUtils.getApplicationContext(), BaseUtils.getApplicationContext().getResources().getString(DeviceUtils.isTabletModel() ? C8003R.string.settings_sync_accounts_summary_tablet_edp_notice : C8003R.string.settings_sync_accounts_summary_phone_edp_notice), 0, false);
                TipCardHelper.this.removeTipCard(31);
            }
        };
        this.mContract = contract;
        this.mPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.3
            float pageOffset = 0.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                float f4 = this.pageOffset;
                if ((f4 < 0.5f && 0.5f < f) || (f < 0.5f && 0.5f < f4)) {
                    TipCardHelper.this.mIndicator.invalidate();
                }
                this.pageOffset = f;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (TipCardHelper.this.mTipCardPage == i) {
                    return;
                }
                MainLogger.m7258i(TipCardHelper.TAG, "onPageSelected# TipCardPage: " + TipCardHelper.this.mTipCardPage + " -> " + i);
                TipCardHelper.this.mTipCardPage = i;
                int childHeight = TipCardHelper.this.mViewPager.getChildHeight(i);
                if (childHeight < 0) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = TipCardHelper.this.mViewPager.getLayoutParams();
                layoutParams.height = childHeight;
                TipCardHelper.this.mViewPager.setLayoutParams(layoutParams);
            }
        };
        this.mTipCardTaskListener = new TipCardTaskListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.4
            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
            public void addTipCard(TipCard tipCard) {
                TipCardHelper.this.addTipCard(tipCard);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
            public void filteredInvalidateOptionsMenu() {
                TipCardHelper.this.mViewParams.getAbsFragment().filteredInvalidateOptionsMenu();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
            public boolean onUnsupportedVersionError() {
                TipCardHelper.this.mIPresenter.showAppUpdateDialog(AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_IMPORT);
                return true;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
            public void removeTipCard(int i) {
                TipCardHelper.this.removeTipCard(i);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.listener.TipCardTaskListener
            public void updateProgress(TipCard tipCard) {
                TipCardHelper.this.updateProgress(tipCard);
            }
        };
        this.mAccountImportTipCardPreferenceListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.5
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                if (!TipCardUtil.ENABLED_ACCOUNT_IMPORT_TIP_CARD.equals(str) || TipCardUtil.isAccountImportTipCardEnabled()) {
                    return;
                }
                AbstractC8014b.m7209k("onSharedPreferenceChanged# key : ", str, TipCardHelper.TAG);
                TipCardHelper.this.removeTipCard(18);
                SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).unregisterOnSharedPreferenceChangeListener(TipCardHelper.this.mAccountImportTipCardPreferenceListener);
            }
        };
        this.mMicrosoftAccountLoginTipCardPreferenceListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.6
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                if (TipCardUtil.KEY_MICROSOFT_FEED_LOGIN_TIPCARD_CANCELED.equals(str) || TipCardUtil.isMicrosoftLoginTipcardCanceled()) {
                    AbstractC8014b.m7209k("onSharedPreferenceChanged# key : ", str, TipCardHelper.TAG);
                    TipCardHelper.this.removeTipCard(23);
                    SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).unregisterOnSharedPreferenceChangeListener(TipCardHelper.this.mMicrosoftAccountLoginTipCardPreferenceListener);
                }
            }
        };
        this.mViewParams = viewParams;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        this.mIPresenter = iPresenter;
        TipCardAdapter tipCardAdapter = new TipCardAdapter();
        this.mTipCardAdapter = tipCardAdapter;
        tipCardAdapter.setTipCardViewContract(contract);
    }

    private boolean addMicrosoftLoginErrorTipCard() {
        if (!C0145c.m323h("GRAPH_PREFERENCE", "key_is_request_login", false) || isContainedTipCard(27)) {
            return false;
        }
        addTipCard(new TipCardMicrosoftAccountLoginAgain());
        return true;
    }

    private void addMicrosoftLoginMainTipCard() {
        if (TipCardUtil.isMicrosoftLoginTipcardCanceled()) {
            return;
        }
        initSettingsMicrosoft();
        if (this.mSettingsMicrosoft.isSignIn()) {
            removeTipCard(23);
        } else {
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).registerOnSharedPreferenceChangeListener(this.mMicrosoftAccountLoginTipCardPreferenceListener);
            addTipCard(new TipCardMicrosoftAccountLogin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTipCard(TipCard tipCard) {
        if (this.mTipCardAdapter != null && TipCardUtil.isValidTipCardOnMode(tipCard.getType(), this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid())) {
            this.mTipCardAdapter.addTipCard(tipCard, new TipCardAdapter.AddTipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.13
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.TipCardAdapter.AddTipCardCallback
                public void onSuccess(int i) {
                    TipCardHelper.this.notifyDataSetChanged();
                    if (TipCardHelper.this.mViewPager != null) {
                        TipCardHelper.this.mViewPager.setCurrentItem(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelConvertOldNote() {
        if (this.mViewParams.getModeIndex() == 22) {
            this.mViewParams.getNotesView().getMode().onBackKeyDown();
        }
        setConvertAll(false);
        ConvertTaskFactoryListener convertTaskFactoryListener = this.mConvertTaskFactoryListener;
        if (convertTaskFactoryListener != null) {
            convertTaskFactoryListener.setOnCancelled();
        }
        ConvertTaskManager.getInstance().cancel(2, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelImportNote() {
        ImportSDocTaskListener importSDocTaskListener = this.mImportSDocTaskListener;
        if (importSDocTaskListener != null) {
            importSDocTaskListener.setOnCancelled();
        }
        ImportProcessor.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelImportPdf() {
        ImportPDFTaskListener importPDFTaskListener = this.mImportPDFTaskListener;
        if (importPDFTaskListener != null) {
            importPDFTaskListener.setOnCancelled();
        }
        if (CommonUtil.isNotAvailableActivity(this.mViewParams.getAbsFragment().getActivity())) {
            return;
        }
        WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(PdfImportTask.TAG);
        if (runningTask instanceof PdfImportTask) {
            ((PdfImportTask) runningTask).cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMeeting(boolean z) {
        AbstractC6670b.m4739D("createMeeting, isHost : ", TAG, z);
        this.mIPresenter.joinMeetingWithTipCard(LiveSharingManager.Caller.TIP_CARD_NEW, z, new LiveSharingManager.TipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.10
            @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
            public void dismiss() {
                TipCardHelper.this.removeMeetTipCard();
            }

            @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
            public void show(int i) {
                TipCardHelper.this.setMeetTipCard(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterMeeting(boolean z) {
        AbstractC6670b.m4739D("enterMeeting, isHost : ", TAG, z);
        this.mIPresenter.joinMeetingWithTipCard(z ? LiveSharingManager.Caller.TIP_CARD_EXIST : LiveSharingManager.Caller.TIP_CARD_JOIN, z, new LiveSharingManager.TipCardCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.9
            @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
            public void dismiss() {
                TipCardHelper.this.removeMeetTipCard();
            }

            @Override // com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager.TipCardCallback
            public void show(int i) {
                TipCardHelper.this.setMeetTipCard(i);
            }
        });
    }

    private ConvertTaskFactoryListener getConvertTaskFactoryListener() {
        TipCardProgress tipCardProgress = getTipCardProgress(21, TipCardUtil.getTotalConvertTaskProgress(), TipCardUtil.getFinishedConvertTaskProgress(), TipCardUtil.getFailedConvertTaskProgress());
        if (tipCardProgress == null) {
            return null;
        }
        ConvertTaskFactoryListener convertTaskFactoryListener = new ConvertTaskFactoryListener(this.mViewParams.getAbsFragment().getActivity(), tipCardProgress, this.mTipCardTaskListener);
        this.mConvertTaskFactoryListener = convertTaskFactoryListener;
        return convertTaskFactoryListener;
    }

    @Nullable
    private ImportPDFTaskListener getImportPDFTaskListener() {
        TipCardProgress tipCardProgress = getTipCardProgress(26, TipCardUtil.getTotalImportPDFTaskProgress(), TipCardUtil.getFinishedImportPDFTaskProgress(), TipCardUtil.getFailedImportPDFTaskProgress());
        if (tipCardProgress == null) {
            return null;
        }
        ImportPDFTaskListener importPDFTaskListener = new ImportPDFTaskListener(this.mViewParams.getAbsFragment().getActivity(), tipCardProgress, this.mTipCardTaskListener);
        this.mImportPDFTaskListener = importPDFTaskListener;
        return importPDFTaskListener;
    }

    private ImportSDocTaskListener getImportSDocTaskListener() {
        TipCardProgress tipCardProgress = getTipCardProgress(24, TipCardUtil.getTotalImportSamsungNoteTaskProgress(), TipCardUtil.getFinishedImportSamsungNoteTaskProgress(), TipCardUtil.getFailedImportSamsungNoteTaskProgress());
        if (tipCardProgress == null) {
            return null;
        }
        ImportSDocTaskListener importSDocTaskListener = new ImportSDocTaskListener(this.mViewParams.getAbsFragment().getActivity(), tipCardProgress, this.mTipCardTaskListener);
        this.mImportSDocTaskListener = importSDocTaskListener;
        return importSDocTaskListener;
    }

    private int getTipCardCount() {
        TipCardAdapter tipCardAdapter = this.mTipCardAdapter;
        if (tipCardAdapter == null) {
            return 0;
        }
        return tipCardAdapter.getCount();
    }

    private TipCardProgress getTipCardProgress(int i, int i2, int i4, int i5) {
        TipCardProgress tipCardImportPdf;
        if (21 == i) {
            tipCardImportPdf = new TipCardConvertNotes();
        } else if (24 == i) {
            tipCardImportPdf = new TipCardImportSamsungNotes();
        } else {
            if (26 != i) {
                AbstractC8014b.m7201c(i, "unexpected tipCard type: ", TAG);
                return null;
            }
            tipCardImportPdf = new TipCardImportPdf();
        }
        MainLogger.m7254d(TAG, "getTipCardProgress# total : " + i2 + ", finish : " + i4);
        tipCardImportPdf.setProgressInfo(i2, i4, i5);
        if (isContainedTipCard(tipCardImportPdf.getType())) {
            if (i2 == i4) {
                removeTipCard(tipCardImportPdf.getType());
                return tipCardImportPdf;
            }
        } else if (i2 != i4 && i2 > 0) {
            addTipCard(tipCardImportPdf);
        }
        return tipCardImportPdf;
    }

    private void initSettingsMicrosoft() {
        if (this.mSettingsMicrosoft == null) {
            this.mSettingsMicrosoft = new SettingsMicrosoft(new WeakReference(this.mViewParams.getAbsFragment().getActivity()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isContainedTipCard(int i) {
        TipCardAdapter tipCardAdapter = this.mTipCardAdapter;
        if (tipCardAdapter == null) {
            return false;
        }
        return tipCardAdapter.isContainedTipCard(i);
    }

    private boolean isConvertTaskRunning(String str) {
        if (!ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null)) {
            return false;
        }
        MainLogger.m7258i(TAG, "addConvertNoteTipCard, caller: " + str + ", ignore, already running task now");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addCheckConvertedNotesTipCard$0(boolean[] zArr) {
        zArr[0] = TipCardUtil.isNeedCheckConvertedNotes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        int count = this.mTipCardAdapter.getCount();
        int i = this.mTipCardCount;
        this.mTipCardCount = count;
        AbstractC8014b.m7200b(i, count, "notifyDataSetChanged, prevTipCardCount : ", ", curTipCardCount : ", TAG);
        if (i == count) {
            this.mIPresenter.updateTipCardLayout();
            return;
        }
        if (count == 0) {
            this.mIPresenter.removeTipCard();
        } else if (i != 0 || i >= count) {
            this.mIPresenter.handleTipCardItemCountChange();
        } else {
            this.mIPresenter.showTipCard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reTryImporting() {
        C14497a.m15078a().m15080c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMeetTipCard() {
        removeTipCard(28);
        LiveSharingManager.getInstance().setTipCardType(LiveSharingManager.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTipCard(int i) {
        if (isContainedTipCard(i)) {
            removeTipCard(Collections.singletonList(Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestExternalStoragePermission() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        TipCardUtil.setExternalStorageTipCardEnabled(false);
        PermissionHelper.requestPermissions(activity, 101, PermissionCompat.getStoragePermissions(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestGCSSyncFromTipCard() {
        Context context = this.mViewParams.getContext();
        if (context == null) {
            return false;
        }
        MainLogger.m7258i(TAG, "requestGCSSyncFromTipCard ");
        if (!C0145c.m334s(context)) {
            ToastHandler.show(context, context.getResources().getString(C8003R.string.gcs_network_error_try_again), 0, false);
            return false;
        }
        C0137m.m280d().m286g(13);
        C0171a c0171aM429a = C0171a.m429a();
        String spaceId = this.mStateInfo.getSpaceId();
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        c0171aM429a.getClass();
        c0171aM429a.f545c = new WeakReference(activity);
        if (C0145c.m333r(activity.getApplicationContext())) {
            c0171aM429a.m434f();
            return true;
        }
        c0171aM429a.m433e(spaceId, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestSyncByTipCard(int i) {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncByTipCard()");
        int iUpdateCurrentType = C0322h.m670a().f815a.updateCurrentType(C0322h.m670a().f815a.getAppContext(), 1);
        if (iUpdateCurrentType == 0 || iUpdateCurrentType == 1) {
            Debugger.m8615i("SyncManager", "requestSyncByManual()");
            c14477aM15065b.f10283a.m5100j(new C0099c(64));
        } else {
            C0322h.m670a().f822h.show(C0322h.m670a().f815a.getAppContext(), 1);
            if (iUpdateCurrentType != 3) {
                return false;
            }
        }
        C0137m.m280d().m286g(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAppInfoSetting() {
        Context context = this.mViewParams.getContext();
        if (context != null) {
            AppInfoUtil.showDetailsSettings(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImportCancelDialog(final int i) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mViewParams.getContext());
        alertDialogBuilderForAppCompat.setTitle(C8003R.string.sync_tipcard_cancel_importing_dialog_title);
        alertDialogBuilderForAppCompat.setMessage(C8003R.string.sync_tipcard_cancel_importing_dialog_message);
        alertDialogBuilderForAppCompat.setPositiveButton(C8003R.string.f6004OK, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CommonSamsungAnalytics.insertLog("713", "7132");
                C14497a c14497aM15078a = C14497a.m15078a();
                c14497aM15078a.getClass();
                C0158a.m407a().getClass();
                if (C0158a.m411g()) {
                    c14497aM15078a.f10310a.m4894a(new C12028i(), true);
                } else {
                    Debugger.m8615i("ImportManager", "onCancelImportDialogFinish : not supported!)");
                }
                C0137m.m280d().m286g(1);
                TipCardHelper.this.removeTipCard(i);
                dialogInterface.dismiss();
            }
        }).setNegativeButton(C8003R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                CommonSamsungAnalytics.insertLog("713", "7131");
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMSLoginPage() {
        TipCardUtil.setMicrosoftFeedLoginTipcardDisabled();
        openSettingsMicrosoftLogin();
        SharedPreferences sharedPreferences = this.mViewParams.getContext().getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        if ((sharedPreferences != null ? sharedPreferences.getInt("PREF_VALUE_TYPE", 0) : 0) == 2) {
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_FEED_TIPS_GET_STARTED);
        }
        CommonSamsungAnalytics.insertLog("101", SettingsSAConstants.EVENT_TIPCARD_MS_SYNC_SIGN_IN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMSLoginPageRetry() {
        if (!C0158a.m407a().m417k()) {
            openSettingsMicrosoftLogin();
            return;
        }
        initSettingsMicrosoft();
        MainLogger.m7258i(TAG, "onTipCardOpenSettingsMicrosoftLoginAgain# start");
        this.mSettingsMicrosoft.executeSignInAfterAuthInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSCloudStorage() {
        C0137m.m280d().m286g(12);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.samsung.android.scloud", "com.samsung.android.scloud.app.ui.SCloudActivity"));
        intent.putExtra("baseFragment", "cloud_usage_status");
        try {
            this.mViewParams.getAbsFragment().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            MainLogger.m7255e(TAG, "showSCloudStorage,failed-ActivityNotFoundException : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSettingForSyncWithSamsungCloud() {
        MainLogger.m7258i(TAG, "showSettingForSyncWithSamsungCloud ");
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (activity == null) {
            MainLogger.m7259w(TAG, "showSettingForSyncWithSamsungCloud ignore, activity is invalid ");
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) SettingsActivity.class);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
        intent.putExtra(SettingsConstants.EXTRA_FRAGMENT_ARG_KEY, SettingsConstants.SETTINGS_SAMSUNG_CLOUD_SYNC);
        PopOverActivityWrapper.startActivity(activity, intent, 4);
    }

    private void startMsLoginActivity() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) SettingsActivity.class);
        intent.setAction(Constants.ACTION_START_MS_SETTINGS);
        intent.putExtra(SettingsConstants.KEY_CALLEE, SettingsConstants.CALLEE_MAINLIST);
        PopOverActivityWrapper.startActivity(activity, intent, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(@NonNull TipCard tipCard) {
        TipCardAdapter tipCardAdapter = this.mTipCardAdapter;
        if (tipCardAdapter == null) {
            return;
        }
        tipCardAdapter.updateProgress(tipCard);
    }

    public void addCheckConvertedNotesTipCard() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        DataTask dataTask = this.mCheckConvertedNoteDataTask;
        if (dataTask == null) {
            this.mCheckConvertedNoteDataTask = new DataTask(activity);
        } else {
            dataTask.cancel();
        }
        final boolean[] zArr = {false};
        this.mCheckConvertedNoteDataTask.run(new RunnableC8551a(zArr, 0));
        this.mCheckConvertedNoteDataTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.8
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(WorkerTask.Result result) {
                boolean zIsContainedTipCard = TipCardHelper.this.isContainedTipCard(36);
                if (TipCardHelper.this.mViewParams.getModeIndex() == 1 && zArr[0] && !zIsContainedTipCard) {
                    TipCardHelper.this.addTipCard(new TipCardCheckConvertedNotes());
                } else {
                    if (zArr[0] || !zIsContainedTipCard) {
                        return;
                    }
                    TipCardHelper.this.removeTipCard(36);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NotNull WorkerTask<?> workerTask) {
            }
        });
    }

    public void addConvertNoteTipCard(ArrayList<MainListDocumentData> arrayList, IConvertTaskCallback iConvertTaskCallback) {
        if (isConvertTaskRunning("addConvertNoteTipCard")) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (MainListDocumentData mainListDocumentData : arrayList) {
            if (mainListDocumentData != null) {
                String filePath = mainListDocumentData.getFilePath();
                sb.append(filePath);
                sb.append(' ');
                arrayList2.add(new ConvertInfo(filePath, 2).setUuid(mainListDocumentData.getUuid()).setIsImported(false).setGroupId(4));
            }
        }
        TipCardProgress tipCardProgress = getTipCardProgress(21, arrayList2.size(), 0, 0);
        if (tipCardProgress == null) {
            setConvertAll(false);
            return;
        }
        TipCardUtil.setConvertTaskProgress(tipCardProgress.getMTotal(), tipCardProgress.getMFinished(), tipCardProgress.getFailed());
        MainLogger.m7258i(TAG, "addConvertNoteTipCard getFilePathList# [ " + MainLogger.getEncode(sb.toString()) + " ]\n");
        ConvertTaskManager.connect(this.mViewParams.getContext());
        this.mConvertTaskFactoryListener = new ConvertTaskFactoryListener(this.mViewParams.getAbsFragment().getActivity(), tipCardProgress, this.mTipCardTaskListener);
        ConvertTaskGroup convertTaskGroup = new ConvertTaskGroup(this.mViewParams.getContext(), arrayList2, 2, 4, this.mConvertTaskFactoryListener);
        convertTaskGroup.setOpenAfterConverted(iConvertTaskCallback);
        ConvertTaskManager.getInstance().put(convertTaskGroup);
    }

    public void addEdpNotifyTipCard() {
        TipCard tipCardEdpKeyError;
        if (!EdpManager.getInstance().hasTipcard()) {
            removeTipCard(29);
            removeTipCard(30);
            removeTipCard(31);
            return;
        }
        if (EdpManager.getInstance().hasUpdateTipcard()) {
            tipCardEdpKeyError = new TipCardEdpNotSupportedRecommendUpdate();
        } else if (EdpManager.getInstance().hasUnsupportTipcard()) {
            tipCardEdpKeyError = new TipCardEdpNotSupported();
        } else if (!EdpManager.getInstance().hasKeyErrorTipcard()) {
            return;
        } else {
            tipCardEdpKeyError = new TipCardEdpKeyError();
        }
        if (TipCardUtil.isSyncTipCardCanShow(tipCardEdpKeyError.getType(), this.mViewParams.getModeIndex(), this.mStateInfo.getFolderUuid())) {
            addTipCard(tipCardEdpKeyError);
        } else {
            removeTipCard(tipCardEdpKeyError.getType());
        }
    }

    public void addExternalStoragePermissionGranted() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (activity == null) {
            return;
        }
        if (!CommonUtil.isNeedPermissionGrantedForSSM(activity.getApplicationContext()) || SystemPropertiesCompat.INSTANCE.getInstance().isNationalDisasterNet()) {
            MainLogger.m7254d(TAG, "addExternalStoragePermissionGranted# do not need permission granted");
            return;
        }
        if (PermissionHelper.isPermissionGranted(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (TipCardUtil.isExternalStorageTipCardEnabled() && !TipCardHelper.this.isContainedTipCard(25)) {
                    TipCardHelper.this.addTipCard(new TipCardExternalStorageNotGranted());
                }
            }
        }, PermissionCompat.getStoragePermissions(4))) {
            TipCardUtil.setExternalStorageTipCardEnabled(false);
            removeTipCard(25);
        }
    }

    public void addImportDownloadingTipCard() {
        if (!C0145c.m334s(this.mViewParams.getContext()) || isContainedTipCard(1)) {
            return;
        }
        MainLogger.m7258i(TAG, "add Dummy ImportDownloading TipCard");
        addTipCard(new C0136l());
    }

    public void addImportNoteFromAccountTipCardIfNeeds() {
        if (!TipCardUtil.isAccountImportTipCardNeeds(this.mDocumentMap.getNoteDataCount(), this.mViewParams.getModeIndex(), this.mStateInfo.getFolderUuid())) {
            TipCardUtil.setAccountImportTipCardDisabled();
            removeTipCard(18);
        } else {
            MainLogger.m7258i(TAG, "addImportNoteFromAccountTipCardIfNeeds");
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).registerOnSharedPreferenceChangeListener(this.mAccountImportTipCardPreferenceListener);
            addTipCard(new TipCardImportNoteFromAccount());
        }
    }

    public void addImportSamsungNoteTipCard() {
        TipCardUtil.setImportSamsungNoteTaskProgress(ImportProcessor.getImportDocumentsSize(), 0, 0);
        ImportProcessor.execute();
        ImportProcessor.registerListener(getImportSDocTaskListener());
    }

    public void addMicrosoftAccountLoginTipCard() {
        C12936a.m13839c().getClass();
        if (!C12936a.m13842g() || !NotesUtils.isMsSyncSupported() || DeviceUtils.isDemoDevice(this.mViewParams.getContext()) || addMicrosoftLoginErrorTipCard()) {
            return;
        }
        addMicrosoftLoginMainTipCard();
    }

    public void addSyncFailPSMTipCard() {
        C14477a.m15065b().getClass();
        boolean z = C14477a.m15066c() == 126;
        AbstractC8014b.m7210l("addSyncFailPSMTipCard# syncFail : ", TAG, z);
        if (!z) {
            removeTipCard(32);
        } else {
            if (isContainedTipCard(32)) {
                return;
            }
            TipCardFailToSyncPSM tipCardFailToSyncPSM = new TipCardFailToSyncPSM();
            if (TipCardUtil.isSyncTipCardCanShow(tipCardFailToSyncPSM.getType(), this.mViewParams.getModeIndex(), this.mStateInfo.getFolderUuid())) {
                addTipCard(tipCardFailToSyncPSM);
            }
        }
    }

    public void addSyncProgressFailTipCard(int i) {
        MainLogger.m7258i(TAG, "addSyncProgressFailTipCard");
        if (isContainedTipCard(i)) {
            return;
        }
        if (i != 37 || this.mStateInfo.getTipCardSyncOffAvailable()) {
            addTipCard(new TipCardSyncProgressFail(i));
        }
    }

    public void clearTipCard(boolean z) {
        this.mTipCardAdapter.clearTipCard(z, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.15
            @Override // java.lang.Runnable
            public void run() {
                TipCardHelper.this.notifyDataSetChanged();
            }
        });
    }

    public int getTipCardHolderCount() {
        TipCardAdapter tipCardAdapter = this.mTipCardAdapter;
        if (tipCardAdapter != null) {
            return tipCardAdapter.getCount() > 0 ? 1 : 0;
        }
        MainLogger.m7259w(TAG, "getTipCardHolderCount# mTipCardAdapter is null. return 0.");
        return 0;
    }

    public void loadConvertProgressingTipCard() {
        if (ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null)) {
            MainLogger.m7258i(TAG, "loadConvertProgressingTipCard# ConvertingOldNoteTask exist, restart convert task");
            ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, getConvertTaskFactoryListener());
        } else if (TipCardUtil.isConvertAll()) {
            MainLogger.m7258i(TAG, "loadConvertProgressingTipCard# ConvertingOldNoteTask do not exist but start convert all");
            this.mIPresenter.startConvertNotes(null);
        } else {
            MainLogger.m7258i(TAG, "loadConvertProgressingTipCard# ConvertingOldNoteTask do not exist, clear preference ");
            TipCardUtil.clearConvertTaskProgress();
            removeTipCard(21);
        }
    }

    public void loadImportPDFProgressingTipCard() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(PdfImportTask.TAG);
        if (runningTask instanceof PdfImportTask) {
            MainLogger.m7254d(TAG, "loadImportPDFProgressingTipCard# task is existing");
            ((PdfImportTask) runningTask).registerContract(activity.hashCode(), getImportPDFTaskListener());
        } else {
            MainLogger.m7259w(TAG, "loadImportPDFProgressingTipCard# task is not existing");
            TipCardUtil.clearImportPDFTaskProgress();
            removeTipCard(26);
        }
    }

    public void loadImportSamsungNoteProgressingTipCard() {
        boolean zRegisterListener = ImportProcessor.registerListener(null);
        AbstractC6670b.m4739D("loadImportSamsungNoteProgressingTipCard# isImportSamsungNoteTaskExist: ", TAG, zRegisterListener);
        if (zRegisterListener) {
            ImportProcessor.registerListener(getImportSDocTaskListener());
        } else {
            TipCardUtil.clearImportSamsungNoteTaskProgress();
            removeTipCard(24);
        }
    }

    public void loadSyncTipCard(int i) {
        if (this.mViewParams.getContext() != null) {
            if (TipCardUtil.isAvailableTipCard(i, this.mStateInfo.getFolderUuid()) || TipCardUtil.isAvailableMdeTipCard(i)) {
                MainLogger.m7258i(TAG, "loadSyncTipCard");
                if (SyncState.isWiFiNetworkFailed()) {
                    SyncState.setWiFiNetworkFailed(false);
                    MainLogger.m7259w(TAG, "loadSyncTipCard : cannot_sync_in_wifi_only");
                }
                ArrayList<TipCard> arrayList = C0137m.m280d().f391a;
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(C0137m.m280d().m285e());
                for (TipCard tipCard : arrayList) {
                    if (copyOnWriteArrayList.contains(Integer.valueOf(tipCard.getType()))) {
                        copyOnWriteArrayList.remove(Integer.valueOf(tipCard.getType()));
                    }
                }
                removeTipCard(copyOnWriteArrayList);
                for (TipCard tipCard2 : arrayList) {
                    if (tipCard2 != null) {
                        if (TipCardUtil.isSyncTipCardCanShow(tipCard2.getType(), i, this.mStateInfo.getFolderUuid())) {
                            addTipCard(tipCard2);
                        } else {
                            removeTipCard(tipCard2.getType());
                        }
                    }
                }
            }
        }
    }

    public void onBindViewHolder(CommonHolderInfo commonHolderInfo) {
        MainLogger.m7258i(TAG, "onBindViewHolder# ");
        View rootCardView = commonHolderInfo.getRootCardView();
        this.mIndicator = (TabLayout) rootCardView.findViewById(C8003R.id.tipcard_indicator);
        TipCardPager tipCardPager = (TipCardPager) rootCardView.findViewById(C8003R.id.tipcard_viewpager);
        this.mViewPager = tipCardPager;
        if (tipCardPager.getAdapter() == null) {
            this.mViewPager.setAdapter(this.mTipCardAdapter);
        }
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        this.mIndicator.setupWithViewPager(this.mViewPager, false);
        this.mViewPager.setCurrentItem(this.mTipCardPage);
        int tipCardCount = getTipCardCount();
        rootCardView.setVisibility(tipCardCount > 0 ? 0 : 8);
        this.mIndicator.setVisibility(tipCardCount <= 1 ? 8 : 0);
    }

    public void onStartPdfImportTask(@NonNull PdfImportTask pdfImportTask) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        MainLogger.m7258i(TAG, "onStartPdfImportTask# ");
        if (pdfImportTask.getHashCode() == activity.hashCode()) {
            TipCardUtil.setImportPDFTaskProgress(pdfImportTask.getPdfUriCount(), 0, 0);
        }
        pdfImportTask.registerContract(activity.hashCode(), getImportPDFTaskListener());
    }

    public void openSettingsMicrosoftLogin() {
        if (((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            startMsLoginActivity();
        } else {
            this.mIPresenter.showSamsungAccountLoginForMsSyncDialog();
        }
    }

    public void release() {
        removeSyncTipCardProgressListener();
        SettingsMicrosoft settingsMicrosoft = this.mSettingsMicrosoft;
        if (settingsMicrosoft != null) {
            settingsMicrosoft.release();
        }
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).unregisterOnSharedPreferenceChangeListener(this.mAccountImportTipCardPreferenceListener);
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).unregisterOnSharedPreferenceChangeListener(this.mMicrosoftAccountLoginTipCardPreferenceListener);
    }

    public void removeSyncProgressFailTipCard(int i) {
        MainLogger.m7258i(TAG, "removeSyncProgressFailTipCard");
        removeTipCard(i);
    }

    public void removeSyncTipCardProgressListener() {
        C0137m c0137mM280d = C0137m.m280d();
        TipCardListener tipCardListener = this.mSyncTipCardProgressListener;
        c0137mM280d.getClass();
        if (tipCardListener == null) {
            Debugger.m8615i("TipCardManager", "removeTipCardListener : listener is null");
            return;
        }
        ArrayList arrayList = C0137m.f389c;
        synchronized (arrayList) {
            arrayList.remove(tipCardListener);
            Debugger.m8607d("TipCardManager", "Removed TipCard listener - size : " + arrayList.size());
        }
    }

    public void setConvertAll(boolean z) {
        TipCardUtil.setConvertAll(z);
    }

    public void setImportStorageTipCard() {
        if (isContainedTipCard(4) && AbstractC0155m.m401p()) {
            PostLaunchManager.getInstance().executeBaseLogics();
            C14497a.m15078a().m15080c();
        }
    }

    public void setMeetTipCard(int i) {
        AbstractC8014b.m7201c(i, "setMeetTipCard# Show type : ", TAG);
        if (isContainedTipCard(28) && i == LiveSharingManager.getInstance().getMTipCardType()) {
            MainLogger.m7254d(TAG, "setMeetTipCard# already has tipcard");
            return;
        }
        removeTipCard(28);
        if (!LiveSharingManager.getInstance().getNotNow()) {
            MainLogger.m7254d(TAG, "setMeetTipCard# Meet popup not canceled");
            return;
        }
        if (i == LiveSharingManager.TIPCARD_HOST) {
            addTipCard(new TipCardMeet(true));
            LiveSharingManager.getInstance().setTipCardType(LiveSharingManager.TIPCARD_HOST);
            CommonSamsungAnalytics.insertLog("101", "7677");
        } else {
            if (i != LiveSharingManager.TIPCARD_GUEST) {
                LiveSharingManager.getInstance().setTipCardType(LiveSharingManager.NONE);
                return;
            }
            addTipCard(new TipCardMeet(false));
            LiveSharingManager.getInstance().setTipCardType(LiveSharingManager.TIPCARD_GUEST);
            CommonSamsungAnalytics.insertLog("101", "7678");
        }
    }

    public void setSyncTipCardProgressListener() {
        C0137m c0137mM280d = C0137m.m280d();
        TipCardListener tipCardListener = this.mSyncTipCardProgressListener;
        c0137mM280d.getClass();
        if (tipCardListener == null) {
            Debugger.m8615i("TipCardManager", "addTipCardListener : listener is null");
            return;
        }
        ArrayList arrayList = C0137m.f389c;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((TipCardListener) it.next()).equals(tipCardListener)) {
                        return;
                    }
                }
                ArrayList arrayList2 = C0137m.f389c;
                arrayList2.add(tipCardListener);
                Debugger.m8607d("TipCardManager", "Added TipCard listener - size : " + arrayList2.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void removeTipCard(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (isContainedTipCard(it.next().intValue())) {
                TipCardAdapter tipCardAdapter = this.mTipCardAdapter;
                if (tipCardAdapter == null) {
                    return;
                }
                tipCardAdapter.removeTipCard(list, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.TipCardHelper.14
                    @Override // java.lang.Runnable
                    public void run() {
                        TipCardHelper.this.notifyDataSetChanged();
                    }
                });
                return;
            }
        }
    }
}
