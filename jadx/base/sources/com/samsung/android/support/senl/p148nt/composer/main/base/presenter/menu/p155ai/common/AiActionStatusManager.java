package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.app.Activity;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiActionStatusManager {
    private static final int SETTINGS = 3;
    private static ContentObserver mContentObserver;
    public static final HashMap<Integer, AiActionStatus> mActionStatus = new HashMap<>();
    public static Activity mLastUsedActivity = null;
    private static int mSettingsCode = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SettingsPrenventOnlineProcessingListener {
        void onChange();
    }

    private static void excuteAiActionStatus(Activity activity, AiActionStatus aiActionStatus) {
        mActionStatus.put(Integer.valueOf(activity.hashCode()), aiActionStatus);
        mLastUsedActivity = activity;
        if (aiActionStatus.isAiActionStatusEnabled()) {
            aiActionStatus.execute(activity);
        } else {
            aiActionStatus.requestAiActionStatusEnabled(activity);
        }
    }

    public static void executeActionByOndevice(Activity activity, Runnable runnable, Runnable runnable2) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, runnable2, AiActionStatus.DIALOG_TYPE.ON_DEVICE));
    }

    public static void executeActionByServer(Activity activity, Runnable runnable) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable));
    }

    public static void executeActionWithSettings(Activity activity, Runnable runnable, Runnable runnable2) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, runnable2, AiActionStatus.LOGIN_PAGE.SETTINGS));
    }

    public static void executeAudioEraserAction(Activity activity, Runnable runnable) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, AiActionStatus.DIALOG_TYPE.AUDIO_ERASER));
    }

    public static void executeDrawingAction(Activity activity, Runnable runnable) {
        executeActionByServer(activity, runnable, AiActionStatus.DIALOG_TYPE.AI_DRAWING_NOTICE);
    }

    public static void executeRetryAction(Runnable runnable) {
        AiActionStatus aiActionStatus = new AiActionStatus(runnable);
        Activity activity = mLastUsedActivity;
        if (activity != null) {
            mActionStatus.put(Integer.valueOf(activity.hashCode()), aiActionStatus);
        }
        aiActionStatus.executeRetryAction(mLastUsedActivity);
    }

    public static void executeSummaryAction(Activity activity, Runnable runnable) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, AiActionStatus.isSummaryOnDeviceFeatureEnable() ? AiActionStatus.DIALOG_TYPE.ON_DEVICE : AiActionStatus.DIALOG_TYPE.SERVER));
    }

    public static boolean isAiActionStatusEnabledWithSettings() {
        return new AiActionStatus().isAiSettingsButtonEnabled();
    }

    public static boolean isNoticedServerAiFeature() {
        return new AiActionStatus().isNoticedServerAiFeature();
    }

    public static void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        AiActionStatus aiActionStatus;
        if (activity == null || (aiActionStatus = mActionStatus.get(Integer.valueOf(activity.hashCode()))) == null) {
            return;
        }
        aiActionStatus.onActivityResult(activity, i, i2, intent);
    }

    public static void registerSettingsListener(Activity activity, final SettingsPrenventOnlineProcessingListener settingsPrenventOnlineProcessingListener) {
        if (activity == null) {
            return;
        }
        HashMap<Integer, AiActionStatus> map = mActionStatus;
        if (map.containsKey(3)) {
            return;
        }
        mSettingsCode = activity.hashCode();
        map.put(3, new AiActionStatus(AiActionStatus.DIALOG_TYPE.SERVER));
        mContentObserver = new ContentObserver(new Handler()) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatusManager.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                SettingsPrenventOnlineProcessingListener settingsPrenventOnlineProcessingListener2 = settingsPrenventOnlineProcessingListener;
                if (settingsPrenventOnlineProcessingListener2 != null) {
                    settingsPrenventOnlineProcessingListener2.onChange();
                }
            }
        };
        BaseUtils.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(AiActionStatus.SETTINGS_PREVENT_ONLINE_PROCESSING), false, mContentObserver);
    }

    public static void releaseActionStatus(Activity activity) {
        HashMap<Integer, AiActionStatus> map;
        AiActionStatus aiActionStatus;
        mLastUsedActivity = null;
        if (activity == null || (aiActionStatus = (map = mActionStatus).get(Integer.valueOf(activity.hashCode()))) == null) {
            return;
        }
        map.remove(Integer.valueOf(activity.hashCode()));
        aiActionStatus.releaseActivity();
    }

    public static void toggleSummaryFeature(Activity activity, Runnable runnable, Runnable runnable2, boolean z) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, runnable2, z ? AiActionStatus.DIALOG_TYPE.ON_DEVICE : AiActionStatus.DIALOG_TYPE.SUMMARY_SETTING));
    }

    public static void unregisterSettingsListener(Activity activity) {
        if (activity != null && mSettingsCode == activity.hashCode()) {
            HashMap<Integer, AiActionStatus> map = mActionStatus;
            if (map.containsKey(3)) {
                BaseUtils.getApplicationContext().getContentResolver().unregisterContentObserver(mContentObserver);
                map.remove(3);
                mContentObserver = null;
                mSettingsCode = 0;
            }
        }
    }

    public static void executeActionByOndevice(Activity activity, Runnable runnable) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, AiActionStatus.DIALOG_TYPE.ON_DEVICE));
    }

    public static void executeActionByServer(Activity activity, Runnable runnable, Runnable runnable2) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, runnable2));
    }

    private static void executeActionByServer(Activity activity, Runnable runnable, AiActionStatus.DIALOG_TYPE dialog_type) {
        excuteAiActionStatus(activity, new AiActionStatus(runnable, dialog_type));
    }
}
