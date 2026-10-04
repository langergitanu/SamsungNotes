package com.samsung.android.support.senl.p148nt.app.main.coedit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditPickerInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnectorImpl;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import p075S.AbstractC0256h;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditLaunchSocialPickerActivity extends AbsAppCompatActivity {
    private static final String TAG = "CoeditLaunchSocialPickerActivity";
    private int mAnchorType;
    private int mCaller;
    private CoeditPickerInfo mCoeditCreateInfo;
    private final CoeditSessionConnector.CoeditCreateResult mCoeditCreateResult = new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.CoeditLaunchSocialPickerActivity.1
        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
        public void onFail() {
            MainCoeditLogger.m7250d(CoeditLaunchSocialPickerActivity.TAG, "CoeditCreateResult# onFail#");
            CoeditLaunchSocialPickerActivity.this.finish();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
        public void onSuccess(String str, String str2, boolean z) {
            MainCoeditLogger.m7250d(CoeditLaunchSocialPickerActivity.TAG, "CoeditCreateResult# onSuccess#");
            CoeditLaunchSocialPickerActivity.this.finishActivityWithResult(str, str2);
        }
    };
    private CoeditSessionConnector mSessionConnector;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivityWithResult(String str, String str2) {
        MainCoeditLogger.m7250d(TAG, "finishActivityWithResult# groupId: " + str + ", spaceId: " + str2);
        Intent intent = new Intent();
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, str);
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, str2);
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, C0283a.m561c());
        if (this.mCoeditCreateInfo.getInvitationLink() != null) {
            intent.putExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL, this.mCoeditCreateInfo.getInvitationLink().getUrl());
        }
        setResult(-1, intent);
        finish();
    }

    private boolean isProgressVisible() {
        View viewFindViewById = findViewById(C8003R.id.progress_circle);
        return viewFindViewById != null && viewFindViewById.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSocialPicker() {
        if (this.mSessionConnector.isStorageFull()) {
            ToastHandler.show(getApplicationContext(), getString(C8003R.string.co_edit_cannot_create_shared_note_storage_full), 1, false);
            finish();
            return;
        }
        MainCoeditLogger.m7250d(TAG, "launchSocialPicker#");
        CoeditPickerInfo activityFinishedListener = new CoeditPickerInfo.CreateStandalone("Group://Standalone " + getString(C8003R.string.co_edit_note_auto_title, AbstractC0256h.m542b(), LocaleUtils.getTitleTime(System.currentTimeMillis()))).setResultCallback(this.mCoeditCreateResult).setActivityFinishedListener(new CoeditPickerInfo.ActivityFinishedListener() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.CoeditLaunchSocialPickerActivity.3
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditPickerInfo.ActivityFinishedListener
            public void onActivityFinished(boolean z) {
                CoeditLaunchSocialPickerActivity.this.showrProgress();
                if (CoeditLaunchSocialPickerActivity.this.mCaller == 0) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT, z ? NotesSAConstants.EVENT_COEDIT_LIST_INVITE_BY_SHARE_LINK : NotesSAConstants.EVENT_COEDIT_LIST_INVITE_BY_CONTACTS);
                } else {
                    CommonSamsungAnalytics.insertLog(CoeditLaunchSocialPickerActivity.this.mCaller == 1 ? "301" : "401", z ? NotesSAConstants.EVENT_COEDIT_COMPOSER_INVITE_BY_SHARE_LINK : NotesSAConstants.EVENT_COEDIT_COMPOSER_INVITE_BY_CONTACTS);
                }
            }
        });
        this.mCoeditCreateInfo = activityFinishedListener;
        this.mSessionConnector.launchSocialPicker(activityFinishedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showrProgress() {
        runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.CoeditLaunchSocialPickerActivity.4
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById = CoeditLaunchSocialPickerActivity.this.findViewById(C8003R.id.progress_circle);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isProgressVisible()) {
            MainCoeditLogger.m7250d(TAG, "onBackPressed# blocked. progress is visible");
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.handoff_activity);
        if (bundle != null) {
            this.mAnchorType = bundle.getInt(PopOverActivityWrapper.KEY_ANCHOR_TYPE, 101);
            this.mCaller = bundle.getInt("view_mode", 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.mAnchorType = intent.getIntExtra(PopOverActivityWrapper.KEY_ANCHOR_TYPE, 100);
                this.mCaller = intent.getIntExtra("view_mode", 0);
            }
        }
        CoeditSessionConnectorImpl coeditSessionConnectorImpl = new CoeditSessionConnectorImpl(getApplicationContext(), TAG, new CoeditSessionConnector.ActivityContract() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.CoeditLaunchSocialPickerActivity.2
            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void finishActivity() {
                CoeditLaunchSocialPickerActivity.this.finish();
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public FragmentActivity getActivity() {
                return CoeditLaunchSocialPickerActivity.this;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void launchActivity(Intent intent2, NotesActivityResultCallback notesActivityResultCallback) {
                if (CoeditLaunchSocialPickerActivity.this.mAnchorType == 100) {
                    CoeditLaunchSocialPickerActivity.this.launchActivity(intent2, notesActivityResultCallback);
                } else {
                    CoeditLaunchSocialPickerActivity coeditLaunchSocialPickerActivity = CoeditLaunchSocialPickerActivity.this;
                    coeditLaunchSocialPickerActivity.launchPopOverActivity(intent2, coeditLaunchSocialPickerActivity.mAnchorType, notesActivityResultCallback);
                }
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.ActivityContract
            public void onSessionConnected(boolean z) {
                if (CoeditLaunchSocialPickerActivity.this.isFinishing() || CoeditLaunchSocialPickerActivity.this.isDestroyed()) {
                    return;
                }
                if (z) {
                    CoeditLaunchSocialPickerActivity.this.launchSocialPicker();
                } else {
                    CoeditLaunchSocialPickerActivity.this.finish();
                }
            }
        });
        this.mSessionConnector = coeditSessionConnectorImpl;
        if (coeditSessionConnectorImpl.isLatestNotesVersion()) {
            this.mSessionConnector.connect();
        } else {
            MainCoeditLogger.m7253i(TAG, "onCreate# isLatestNotesVersion false");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mSessionConnector.disconnect();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PopOverActivityWrapper.KEY_ANCHOR_TYPE, this.mAnchorType);
        bundle.putInt("view_mode", this.mCaller);
    }
}
