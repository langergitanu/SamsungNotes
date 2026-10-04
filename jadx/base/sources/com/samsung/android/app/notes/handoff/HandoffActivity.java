package com.samsung.android.app.notes.handoff;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HandoffActivity extends AppCompatActivity {
    private static final String KEY_NOTE_META_DATA = "KEY_NOTE_META_DATA";
    private static final String TAG = "HandoffActivity";
    private final HandoffLaunchManager mHandoffLaunchManager = new HandoffLaunchManager(new WeakReference(this), true, null);
    private HandoffContentObserverImpl mHandoffContentObserver = new HandoffContentObserverImpl(this, 0);
    private final Runnable mTimerStartAction = new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.1
        @Override // java.lang.Runnable
        public void run() {
            HandoffActivity.this.runOnUiThread(new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    HandoffActivity.this.findViewById(C8003R.id.progress_circle).setVisibility(0);
                }
            });
        }
    };
    private final Runnable mTimerFailAction = new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.2
        @Override // java.lang.Runnable
        public void run() {
            HandoffActivity.this.runOnUiThread(new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    MainLogger.m7255e(HandoffActivity.TAG, "can not receive data from HandoffContentObserver in 30000ms");
                    HandoffActivity.this.mHandoffLaunchManager.handleMain(null);
                }
            });
        }
    };
    private final Runnable mTimerCancelAction = new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.3
        @Override // java.lang.Runnable
        public void run() {
            HandoffActivity.this.runOnUiThread(new Runnable() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.3.1
                @Override // java.lang.Runnable
                public void run() {
                    HandoffActivity.this.findViewById(C8003R.id.progress_circle).setVisibility(8);
                }
            });
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HandoffContentObserverImpl extends HandoffContentObserver {
        private long mLastExecutedHandoffAction;
        private boolean mNeedToHandoff;

        public /* synthetic */ HandoffContentObserverImpl(HandoffActivity handoffActivity, int i) {
            this();
        }

        public void handleReceivedData(String str) {
            HandoffActivity.this.mHandoffLaunchManager.handleHandoffData(str, null);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver
        public void onAppEventChanged() {
            super.onAppEventChanged();
            HandoffUtils.getInstance().updateHandoffInfo(new HandoffUtils.UpdateHandoffInfoCallback() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.HandoffContentObserverImpl.1
                @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.UpdateHandoffInfoCallback
                public void onUpdateFinished(boolean z, @NotNull String str, @NotNull String str2, long j) {
                    if (z) {
                        return;
                    }
                    HandoffActivity.this.mHandoffLaunchManager.handleMain(null);
                }
            });
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffContentObserver
        public void onDataReceived() {
            super.onDataReceived();
            final long lastModifiedHandoffActionTime = HandoffUtils.getInstance().getLastModifiedHandoffActionTime();
            if (!this.mNeedToHandoff || this.mLastExecutedHandoffAction == lastModifiedHandoffActionTime) {
                return;
            }
            this.mNeedToHandoff = false;
            HandoffUtils.getInstance().loadHandoffData(new HandoffUtils.CallBack() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.HandoffContentObserverImpl.2
                @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.CallBack
                public void onResult(@Nullable Bundle bundle) {
                    if (bundle == null) {
                        Logger.m7100d(HandoffActivity.TAG, "HandoffContentObserverImpl, onDataReceived, loadHandoffDataResult# result == null");
                        return;
                    }
                    String string = bundle.getString(HandoffConstant.KEY_HANDOFF_DATA);
                    if (string == null) {
                        Logger.m7101e(HandoffActivity.TAG, "HandoffContentObserverImpl, onDataReceived, loadHandoffDataResult# handoffData == null");
                        return;
                    }
                    HandoffContentObserverImpl.this.mLastExecutedHandoffAction = lastModifiedHandoffActionTime;
                    HandoffContentObserverImpl.this.handleReceivedData(string);
                    HandoffUtils.getInstance().disableHandoff();
                }
            });
        }

        public void setNeedToHandoff(boolean z) {
            this.mNeedToHandoff = z;
        }

        private HandoffContentObserverImpl() {
            this.mNeedToHandoff = false;
            this.mLastExecutedHandoffAction = 0L;
        }
    }

    private void updateAndSyncHandoff(Intent intent) {
        HandoffUtils.getInstance().updateHandoffInfo(new HandoffUtils.UpdateHandoffInfoCallback() { // from class: com.samsung.android.app.notes.handoff.HandoffActivity.4
            @Override // com.samsung.android.support.senl.nt.base.common.mcf.handoff.HandoffUtils.UpdateHandoffInfoCallback
            public void onUpdateFinished(boolean z, @NonNull String str, @NonNull String str2, long j) {
                MainLogger.m7258i(HandoffActivity.TAG, "onUpdateFinished# result: " + z + ", senderName: " + str + ", deviceType: " + str2 + ", lastModificationTime: " + j);
            }
        });
        if (intent == null || !intent.getBooleanExtra(HandoffConstant.KEY_IS_HANDOFF_LAUNCH, false)) {
            return;
        }
        this.mHandoffContentObserver.setNeedToHandoff(true);
        HandoffUtils.getInstance().requestSyncHandoffData();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mHandoffLaunchManager.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.handoff_activity);
        if (!HandoffUtils.getInstance().isHandoffSupported()) {
            Logger.m7101e(TAG, "onCreate# handoff is not supported");
            if (SettingsCompat.getInstance().isUPSM(this)) {
                ToastHelper.show((Context) this, C8003R.string.handoff_can_not_use_in_power_saving_mode, 0, false);
            }
            if (HandoffUtils.getInstance().isHandoffFixedStateEnabled()) {
                this.mHandoffLaunchManager.handleMain(null);
                return;
            } else {
                finish();
                return;
            }
        }
        MainLogger.m7258i(TAG, "onCreate# ");
        HandoffUtils.getInstance().registerContentObserver(this.mHandoffContentObserver);
        if (bundle != null && bundle.getString(KEY_NOTE_META_DATA) != null) {
            Logger.m7100d(TAG, "onCreate# restore waiting sync");
            this.mHandoffContentObserver.handleReceivedData(bundle.getString(KEY_NOTE_META_DATA));
            return;
        }
        updateAndSyncHandoff(getIntent());
        this.mHandoffLaunchManager.setTimerStartAction(this.mTimerStartAction);
        this.mHandoffLaunchManager.setTimerFailAction(this.mTimerFailAction);
        this.mHandoffLaunchManager.setTimerEndAction(this.mTimerCancelAction);
        this.mHandoffLaunchManager.createTimer();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MainLogger.m7258i(TAG, "onDestroy# ");
        HandoffUtils.getInstance().unregisterContentObserver(this.mHandoffContentObserver);
        this.mHandoffContentObserver = null;
        this.mHandoffLaunchManager.cancelTimer();
        this.mHandoffLaunchManager.hideSyncDialog();
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mHandoffLaunchManager.createTimer();
        this.mHandoffLaunchManager.hideSyncDialog();
        setIntent(intent);
        updateAndSyncHandoff(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mHandoffLaunchManager.onRequestPermissionsResult(i);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        JSONObject newNoteMetaData = this.mHandoffLaunchManager.getNewNoteMetaData();
        if (newNoteMetaData != null) {
            bundle.putString(KEY_NOTE_META_DATA, newNoteMetaData.toString());
        }
        super.onSaveInstanceState(bundle);
    }
}
