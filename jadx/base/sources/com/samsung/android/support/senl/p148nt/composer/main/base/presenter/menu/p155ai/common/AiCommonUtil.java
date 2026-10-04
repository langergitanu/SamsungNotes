package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatusManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCommonUtil {
    private static final boolean DEBUG = false;

    public static void executeActionByOndevice(Activity activity, Runnable runnable, Runnable runnable2) {
        AiActionStatusManager.executeActionByOndevice(activity, runnable, runnable2);
    }

    public static void executeActionByServer(Activity activity, Runnable runnable) {
        AiActionStatusManager.executeActionByServer(activity, runnable);
    }

    public static void executeActionWithSettings(Activity activity, Runnable runnable, Runnable runnable2) {
        AiActionStatusManager.executeActionWithSettings(activity, runnable, runnable2);
    }

    public static void executeAudioEraserAction(Activity activity, Runnable runnable) {
        AiActionStatusManager.executeAudioEraserAction(activity, runnable);
    }

    public static void executeDrawingAction(Activity activity, Runnable runnable) {
        AiActionStatusManager.executeDrawingAction(activity, runnable);
    }

    public static void executeRetryAction(Runnable runnable) {
        AiActionStatusManager.executeRetryAction(runnable);
    }

    public static void executeSummaryAction(Activity activity, Runnable runnable) {
        AiActionStatusManager.executeSummaryAction(activity, runnable);
    }

    public static int getTextMeasuredHeight(SpenWNote spenWNote) {
        return AiViewUtils.getTextMeasuredHeight(spenWNote);
    }

    public static boolean isAiActionStatusEnabledWithSettings() {
        return AiActionStatusManager.isAiActionStatusEnabledWithSettings();
    }

    public static boolean isNoticedServerAiFeature() {
        return AiActionStatusManager.isNoticedServerAiFeature();
    }

    public static void onActivityResult(Activity activity, int i, int i2, @Nullable Intent intent) {
        AiActionStatusManager.onActivityResult(activity, i, i2, intent);
    }

    public static void registerSettingsListener(Activity activity, AiActionStatusManager.SettingsPrenventOnlineProcessingListener settingsPrenventOnlineProcessingListener) {
        AiActionStatusManager.registerSettingsListener(activity, settingsPrenventOnlineProcessingListener);
    }

    public static void releaseActionStatus(Activity activity) {
        AiActionStatusManager.releaseActionStatus(activity);
    }

    public static void showCustomToast(Context context, String str) {
        AiViewUtils.showCustomToast(context, str);
    }

    public static void toggleSummaryFeature(Activity activity, final boolean z, final Runnable runnable, Runnable runnable2) {
        AiActionStatusManager.toggleSummaryFeature(activity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiCommonUtil.1
            @Override // java.lang.Runnable
            public void run() {
                AiActionStatus.setSummaryOnDeviceFeatureEnable(z);
                runnable.run();
            }
        }, runnable2, z);
    }

    public static void unregisterSettingsListener(Activity activity) {
        AiActionStatusManager.unregisterSettingsListener(activity);
    }

    public static void executeActionByOndevice(Activity activity, Runnable runnable) {
        AiActionStatusManager.executeActionByOndevice(activity, runnable);
    }

    public static void executeActionByServer(Activity activity, Runnable runnable, Runnable runnable2) {
        AiActionStatusManager.executeActionByServer(activity, runnable, runnable2);
    }
}
