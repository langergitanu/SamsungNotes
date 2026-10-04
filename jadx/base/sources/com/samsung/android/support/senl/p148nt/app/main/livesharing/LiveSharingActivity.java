package com.samsung.android.support.senl.p148nt.app.main.livesharing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.updater.CoeditUpdater;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditPickerInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnectorImpl;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportResult;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;
import com.samsung.android.support.senl.p148nt.livesharing.LiveSharingData;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import java.util.List;
import p001A.AbstractC0000a;
import p012C1.CallableC0046b;
import p075S.AbstractC0256h;
import p079T.C0283a;
import p207n1.C13540g;
import p207n1.C13541h;
import p258y.AbstractC14516b;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LiveSharingActivity extends AbsAppCompatActivity implements MeetingStatusListener {
    private static final int MSG_DISCONNECT = 1;
    private static final int REQUEST_CHECK_READY_TO_SHARED_SERVICE = 899;
    private static final int REQUEST_OPEN_NOTES_BY_LINK = 900;
    private static final int REQUEST_SELECT_NOTE = 901;
    private static final int REQUEST_SES_FORCE_UPDATE = 898;
    private static final String TAG = "LS$LiveSharingActivity";
    private static final int WAIT_FOR_NOTE_LINK_TIMEOUT = 10000;
    private AddonSessionHandler mAddonSessionHandler;
    private String mGroupId;
    private boolean mIsHost;
    private MeetingStatus mLastMeetingStatus;
    private CoeditPickerInfo mPickerInfo;
    private String mSelectedUuid;
    private CoeditSessionConnector mSessionConnector;
    private String mSpaceId;
    private ILiveSharingClient.StateChangeListener mStateChangeListener = new ILiveSharingClient.StateChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.1
        @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.StateChangeListener
        public void onStateChanged(LiveSharingData liveSharingData) {
            LiveSharingManager.getInstance().removeCoDoingDelegate(LiveSharingActivity.this.mStateChangeListener);
            String noteLink = liveSharingData.getNoteLink();
            AbstractC8014b.m7209k("StateChangeListener# onStateChanged noteLink : ", noteLink, LiveSharingActivity.TAG);
            LiveSharingActivity.this.mHandler.removeMessages(1);
            if (TextUtils.isEmpty(noteLink)) {
                LiveSharingActivity.this.mHandler.sendEmptyMessage(1);
                return;
            }
            if (!GcsGroupNetworkUtils.checkCoeditNetworkConnection(LiveSharingActivity.this, GcsConstants.RequestType.Create, true)) {
                LiveSharingActivity.this.mHandler.sendEmptyMessage(1);
                return;
            }
            LiveSharingActivity.this.hideProgress();
            LiveSharingManager.getInstance().setInvitationLinkOpenRequested(true);
            Intent intentForGroupInvitationLink = new OpenSessionApi().getIntentForGroupInvitationLink(LiveSharingActivity.this.getApplicationContext(), noteLink, true);
            intentForGroupInvitationLink.setPackage("com.samsung.android.mobileservice");
            LiveSharingActivity.this.startActivityForResult(intentForGroupInvitationLink, 900);
            LiveSharingManager.getInstance().setInvitationLink(noteLink);
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.2
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                LiveSharingActivity.this.showToast("MSG_DISCONNECT");
                LiveSharingActivity.this.disconnectMeeting();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void connectCoeditSession() {
        if (this.mSessionConnector == null) {
            initCoeditSession();
        }
        MainLogger.m7258i(TAG, "connectCoeditSession");
        CoeditUpdater.getInstance().releaseUpdatePeriod();
        if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            MainLogger.m7258i(TAG, "connectCoeditSession# return - wifi only");
            runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    ToastHandler.show(LiveSharingActivity.this.getApplicationContext(), C8003R.string.co_edit_connect_to_wifi_or_allow_mobile_data, 0);
                    LiveSharingActivity.this.disconnectMeeting();
                }
            });
        } else {
            ((C13540g) C13541h.m14287e().f9588a).m14285a();
            this.mSessionConnector.connect();
        }
    }

    private void connectMeeting() {
        MainLogger.m7254d(TAG, "connectMeeting# isHost: " + this.mIsHost);
        showProgress();
        this.mAddonSessionHandler = new AddonSessionHandler() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.3
            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onCollaborationStartingStateUpdate(@NonNull CollaborationStartingState collaborationStartingState) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "AddonSessionHandler# onCollaborationStartingStateUpdate : " + collaborationStartingState.mainStageUrl());
            }

            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onParticipantPrivilegeChanged(@NonNull List<AddonSessionHandler.Privilege> list, @NonNull List<AddonSessionHandler.Privilege> list2) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "AddonSessionHandler# onParticipantPrivilegeChanged");
            }

            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onSessionEnded(@NonNull AddonSessionHandler.EndReason endReason) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "AddonSessionHandler# onMeetingEnded " + endReason.name());
                LiveSharingActivity.this.disconnectMeeting();
            }
        };
        ILiveSharingClient.ErrorState errorStateConnectMeeting = LiveSharingManager.getInstance().connectMeeting(getApplicationContext(), new ILiveSharingClient.Callback<AddonMeetingInfo>() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.4
            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onFailure(@NonNull Throwable th) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "connectMeeting# onFailure");
                LiveSharingActivity.this.finish("connectMeeting# onFailure");
            }

            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onSuccess(AddonMeetingInfo addonMeetingInfo) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "connectMeeting#onSuccess# AddonMeetingInfo status : " + addonMeetingInfo.meetingStatus().name());
                if (addonMeetingInfo.meetingStatus() == AddonMeetingInfo.MeetingStatus.CONNECTED) {
                    LiveSharingActivity.this.connectCoeditSession();
                }
            }
        }, this.mAddonSessionHandler, this.mStateChangeListener);
        if (errorStateConnectMeeting != ILiveSharingClient.ErrorState.NONE) {
            showToast("connectMeeting fail");
            finish("connectMeeting# " + errorStateConnectMeeting.name());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCoeditNote() {
        MainLogger.m7254d(TAG, "createCoeditNote#");
        CoeditPickerInfo resultCallback = new CoeditPickerInfo.CreateStandalone("Group://Standalone " + getString(C8003R.string.co_edit_note_auto_title, AbstractC0256h.m542b(), LocaleUtils.getTitleTime(System.currentTimeMillis()))).setResultCallback(new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.7
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onFail() {
                MainLogger.m7254d(LiveSharingActivity.TAG, "createCoeditNote#onFail");
                LiveSharingActivity.this.disconnectMeeting();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
            public void onSuccess(String str, String str2, boolean z) {
                AbstractC8014b.m7210l("createCoeditNote#onSuccess isStandalone : ", LiveSharingActivity.TAG, z);
                LiveSharingActivity.this.mGroupId = str;
                LiveSharingActivity.this.mSpaceId = str2;
                if (LiveSharingActivity.this.mIsHost) {
                    ILiveSharingClient.ErrorState errorStateSendNoteLink = LiveSharingActivity.this.sendNoteLink();
                    if (errorStateSendNoteLink == ILiveSharingClient.ErrorState.NONE) {
                        LiveSharingManager.getInstance().setInvitationLink(LiveSharingActivity.this.mPickerInfo.getInvitationLink().getUrl());
                        LiveSharingManager.getInstance().removeCoDoingDelegate(LiveSharingActivity.this.mStateChangeListener);
                        if (TextUtils.isEmpty(LiveSharingActivity.this.mSelectedUuid)) {
                            LiveSharingActivity.this.startComposer();
                            return;
                        } else {
                            LiveSharingActivity.this.importNoteToSpace();
                            return;
                        }
                    }
                    MainLogger.m7258i(LiveSharingActivity.TAG, "createCoeditNote#onSuccess, sendSharingData fail : " + errorStateSendNoteLink);
                }
                LiveSharingActivity.this.mHandler.sendEmptyMessageDelayed(1, 10000L);
            }
        });
        this.mPickerInfo = resultCallback;
        this.mSessionConnector.requestSpaceCreateWithLink(resultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectMeeting() {
        MainLogger.m7258i(TAG, "disconnectMeeting");
        LiveSharingManager.getInstance().disconnectMeeting(new ILiveSharingClient.Callback<Void>() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.8
            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onFailure(@NonNull Throwable th) {
                LiveSharingActivity.this.finish("disconnectMeeting# onFailure");
            }

            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onSuccess(Void r2) {
                LiveSharingActivity.this.finish("disconnectMeeting# onSuccess");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(String str) {
        MainLogger.m7254d(TAG, "finish# " + str);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgress() {
        View viewFindViewById = findViewById(C8003R.id.progress_circle);
        if (viewFindViewById != null) {
            MainLogger.m7254d(TAG, "hideProgress");
            viewFindViewById.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void importErrorHandler() {
        new Handler(Looper.getMainLooper()).post(new RunnableC8327a(this, 1));
        disconnectMeeting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void importNoteToSpace() {
        MainLogger.m7258i(TAG, "importNoteToSpace# SelectedUuid : " + this.mSelectedUuid + ", SpaceId : " + this.mSpaceId);
        DataRepositoryScheduler.callable(new CallableC0046b(this, 3)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observe(new OnCompletionListener<ImportResult>() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.9
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                MainLogger.m7258i(LiveSharingActivity.TAG, "importNoteToSpace#onFail, e: " + exc.getMessage());
                LiveSharingActivity.this.importErrorHandler();
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable ImportResult importResult) {
                if (importResult == null || importResult.ret != 200) {
                    MainLogger.m7258i(LiveSharingActivity.TAG, "importNoteToSpace#onComplete failed");
                    LiveSharingActivity.this.importErrorHandler();
                    return;
                }
                MainLogger.m7258i(LiveSharingActivity.TAG, "importNoteToSpace#onComplete success ret : " + importResult.ret + ", newUuid : " + importResult.newUuid + ", newPath : " + importResult.newPath);
                MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(LiveSharingActivity.this.getApplicationContext()).createMainListDocumentDataRepository().get(importResult.newUuid);
                if (mainListDocumentData == null) {
                    MainLogger.m7258i(LiveSharingActivity.TAG, "importNoteToSpace#onComplete failed - mainListDocumentData is null");
                    LiveSharingActivity.this.importErrorHandler();
                } else if (UserManagerCompat.getInstance().isDigitalLegacyMode(LiveSharingActivity.this.getApplicationContext())) {
                    MainLogger.m7258i(LiveSharingActivity.TAG, "importNoteToSpace#onComplete failed - isDigitalLegacyMode");
                    LiveSharingActivity.this.importErrorHandler();
                } else {
                    LiveSharingActivity.this.onNoteSelected(new MainEntryParam.Builder().setDocumentData(mainListDocumentData).setGuid(C13541h.m14287e().m14294h()).setModeIndex(12).setToolType(1).build());
                    LiveSharingActivity.this.finish("importNoteToSpace# onNoteSelected");
                }
            }
        }).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).execute();
    }

    private void initCoeditSession() {
        this.mSessionConnector = new CoeditSessionConnectorImpl(getApplicationContext(), TAG, new CoeditSessionConnector.ActivityContract() { // from class: com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingActivity.6
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void finishActivity() {
                LiveSharingActivity.this.disconnectMeeting();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public FragmentActivity getActivity() {
                return LiveSharingActivity.this;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void launchActivity(Intent intent, NotesActivityResultCallback notesActivityResultCallback) {
                try {
                    Intent intentForForceUpdate = AbstractC14517a.m15159s().getIntentForForceUpdate();
                    if (intentForForceUpdate != null && intentForForceUpdate.getAction().equals(intent.getAction())) {
                        LiveSharingActivity.this.startActivityForResult(intent, LiveSharingActivity.REQUEST_SES_FORCE_UPDATE);
                        return;
                    }
                } catch (Exception e) {
                    AbstractC14516b.m15115c(e, new StringBuilder("launchActivity# "), LiveSharingActivity.TAG);
                }
                LiveSharingActivity.this.startActivityForResult(intent, LiveSharingActivity.REQUEST_CHECK_READY_TO_SHARED_SERVICE);
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void onSessionConnected(boolean z) {
                AbstractC6670b.m4739D("onSessionConnected# isNetworkAvailable: ", LiveSharingActivity.TAG, z);
                if (!z) {
                    LiveSharingActivity.this.disconnectMeeting();
                    return;
                }
                if (LiveSharingActivity.this.mIsHost) {
                    LiveSharingActivity.this.createCoeditNote();
                } else if (LiveSharingActivity.this.mLastMeetingStatus.status() != MeetingStatus.Status.ADDON_SESSION) {
                    MainLogger.m7254d(LiveSharingActivity.TAG, "onSessionConnected# Guest, last meetingStatus : " + LiveSharingActivity.this.mLastMeetingStatus.status());
                    LiveSharingActivity.this.disconnectMeeting();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$importErrorHandler$1() {
        ToastHandler.show(getApplicationContext(), getResources().getQuantityString(C8003R.plurals.plurals_import_to_coedit_fail, 1, 1), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ImportResult lambda$importNoteToSpace$0() {
        return CoeditNoteUpDownloader.getInstance().importNoteToCoedit(getApplicationContext(), this.mSelectedUuid, this.mSpaceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToast$2() {
        ToastHandler.show(getApplicationContext(), getString(this.mIsHost ? C8003R.string.live_sharing_fail_open : C8003R.string.live_sharing_fail_join), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ILiveSharingClient.ErrorState sendNoteLink() {
        LiveSharingData liveSharingData = new LiveSharingData();
        liveSharingData.setNoteLink(this.mPickerInfo.getInvitationLink().getUrl());
        return LiveSharingManager.getInstance().sendSharingData(liveSharingData);
    }

    private void setCoeditInfo(MainEntryParam mainEntryParam, Intent intent) {
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mainEntryParam.getSpaceId());
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mainEntryParam.getGroupId());
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mainEntryParam.getMdeOwnerId());
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        String mdeOwnerId = mainEntryParam.getMdeOwnerId();
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, AbstractC14517a.m15116A(mdeOwnerId, C0283a.m561c()) ? 1 : 2);
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, DocumentServiceConstants.LockGuid.FROM_SHARED_NOTES_GUID);
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
    }

    private void showProgress() {
        View viewFindViewById = findViewById(C8003R.id.progress_circle);
        if (viewFindViewById != null) {
            MainLogger.m7254d(TAG, "showProgress");
            viewFindViewById.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(String str) {
        AbstractC0000a.m25v("showToast# ", str, TAG);
        this.mHandler.post(new RunnableC8327a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startComposer() {
        onNewCoeditNote(this.mGroupId, this.mSpaceId, null, 1);
        finish("startComposer");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        AbstractC8014b.m7200b(i, i2, "onActivityResult# requestCode: ", ", resultCode: ", TAG);
        if (i == REQUEST_CHECK_READY_TO_SHARED_SERVICE) {
            if (i2 == -1) {
                connectCoeditSession();
                return;
            } else {
                disconnectMeeting();
                return;
            }
        }
        if (i == REQUEST_SES_FORCE_UPDATE) {
            disconnectMeeting();
            return;
        }
        if (i != 900) {
            if (i == 901) {
                if (i2 != -1) {
                    finish("onActivityResult# REQUEST_SELECT_NOTE cancel");
                    return;
                } else {
                    this.mSelectedUuid = intent == null ? "" : intent.getStringExtra("sdoc_uuid");
                    connectMeeting();
                    return;
                }
            }
            return;
        }
        LiveSharingManager.getInstance().setInvitationLinkOpenRequested(false);
        if (i2 == -1) {
            Intent intent2 = new Intent(getApplicationContext(), NoteListAccessHandler.getNoteListClass());
            intent2.setAction(NotesConstants.ACTION_OPEN_CO_EDIT_BY_MEET_URL);
            intent2.setFlags(603979776);
            if (intent != null) {
                intent2.putExtras(intent);
            }
            MultiTaskManager.getInstance().startActivityOfSameTask(this, intent2);
        } else {
            showToast("REQUEST_OPEN_NOTES_BY_LINK fail");
            disconnectMeeting();
        }
        finish("onActivityResult# REQUEST_OPEN_NOTES_BY_LINK");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        MainLogger.m7258i(TAG, "onBackPressed# block back key");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.handoff_activity);
        Intent intent = getIntent();
        if (intent == null) {
            finish("onCreate# intent is null");
            return;
        }
        this.mIsHost = intent.getBooleanExtra("I_AM_HOST", false);
        if (!intent.getBooleanExtra(LiveSharingManager.EXTRA_IS_SELECT_NOTE_MENU, false)) {
            LiveSharingManager.getInstance().registerMeetingStatusListener(this, this);
            connectMeeting();
        } else {
            Intent intent2 = new Intent(getApplicationContext(), NoteListAccessHandler.getNotePickerClass());
            intent2.setAction(NotesConstants.ACTION_PICK_NOTES_FROM_MEETING);
            startActivityForResult(intent2, 901);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MainLogger.m7254d(TAG, "onDestroy");
        LiveSharingManager.getInstance().unregisterMeetingStatusListener(this);
        if (this.mAddonSessionHandler != null) {
            LiveSharingManager.getInstance().unregisterAddonSessionHandler(this.mAddonSessionHandler);
        }
        LiveSharingManager.getInstance().removeCoDoingDelegate(this.mStateChangeListener);
        CoeditSessionConnector coeditSessionConnector = this.mSessionConnector;
        if (coeditSessionConnector != null && coeditSessionConnector.isConnected()) {
            this.mSessionConnector.disconnect();
        }
        this.mAddonSessionHandler = null;
        this.mStateChangeListener = null;
    }

    @Override // com.google.android.meet.addons.MeetingStatusListener
    public void onMeetingStatusChange(@NonNull MeetingStatus meetingStatus) {
        MainLogger.m7254d(TAG, "onMeetingStatusChange# meetingStatus : " + meetingStatus.status() + ", last meetingStatus : " + this.mLastMeetingStatus);
        if (meetingStatus.status() == MeetingStatus.Status.NO_MEETING) {
            disconnectMeeting();
            return;
        }
        this.mLastMeetingStatus = meetingStatus;
        if (this.mIsHost || meetingStatus.status() != MeetingStatus.Status.MEETING) {
            return;
        }
        MainLogger.m7254d(TAG, "onMeetingStatusChange# Guest, MEETING");
        disconnectMeeting();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNewCoeditNote(String str, String str2, String str3, int i) {
        StringBuilder sbM16m = AbstractC0000a.m16m("onNewCoeditNote - groupId : ", str, ", spaceId : ", str2, ", toolType : ");
        sbM16m.append(i);
        MainLogger.m7258i(TAG, sbM16m.toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String strNewUUID = UUIDUtils.newUUID(getApplicationContext(), true);
        LiveSharingManager.getInstance().setCoEditNoteUuid(strNewUUID);
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.setAction(ComposerConstants.ACTION_NEW_MEMO);
        intent.putExtra("sdoc_uuid", strNewUUID);
        intent.putExtra("new_doc", true);
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, str2);
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, str);
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, C0283a.m561c());
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, 1);
        intent.putExtra("tool_type", i);
        intent.putExtra(ComposerConstants.ARG_PAGE_TYPE, SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
        intent.putExtra("category_id", FolderConstants.Coedit.UUID);
        startActivity(intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity
    public void onNoteSelected(MainEntryParam mainEntryParam) {
        String uuid = mainEntryParam.getUuid();
        LiveSharingManager.getInstance().setCoEditNoteUuid(uuid);
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ComposerActivity.class);
        intent.putExtra("sdoc_uuid", uuid);
        intent.putExtra("doc_path", mainEntryParam.getFilePath());
        intent.putExtra("tool_type", mainEntryParam.getToolType());
        intent.putExtra("category_id", mainEntryParam.getFolderUuid());
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
        if (mainEntryParam.getHighLightText() != null) {
            intent.putExtra("highlighttext", mainEntryParam.getHighLightText());
        }
        intent.putExtra(ComposerConstants.ARG_LOCK_TYPE, mainEntryParam.getLockType());
        intent.putExtra("mode", mainEntryParam.getModeIndex());
        if (ComposerManager.getInstance().hasComposerInSameTask(this, uuid)) {
            intent.setFlags(131072);
        }
        setCoeditInfo(mainEntryParam, intent);
        startActivity(intent);
    }
}
