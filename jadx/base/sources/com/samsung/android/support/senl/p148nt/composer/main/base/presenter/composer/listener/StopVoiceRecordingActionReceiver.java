package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/StopVoiceRecordingActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StopVoiceRecordingActionReceiver extends BroadcastReceiver {

    @NotNull
    public static final String ACTION_POWEROFF = "android.intent.action.QUICKBOOT_POWEROFF";

    @NotNull
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";

    @NotNull
    public static final String ACTION_VOICENOTE_SAVE = "com.sec.android.app.voicenote.rec_save";

    @NotNull
    public static final String ACTION_VOICERECORDER_SAVE = "com.sec.android.app.voicerecorder.rec_save";

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = Logger.createTag("StopVoiceRecordingActionReceiver");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (TextUtils.isEmpty(intent.getAction())) {
            Logger.m10999d(TAG, "onReceive# intent is null or action is empty");
            return;
        }
        String str = TAG;
        Logger.m10999d(str, "onReceive - " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -958858976:
                    if (!action.equals(ACTION_VOICERECORDER_SAVE)) {
                        return;
                    }
                    break;
                case -363757972:
                    if (!action.equals(ACTION_VOICENOTE_SAVE)) {
                        return;
                    }
                    break;
                case 422449615:
                    if (!action.equals(ACTION_POWEROFF)) {
                        return;
                    }
                    break;
                case 1947666138:
                    if (!action.equals(ACTION_SHUTDOWN)) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            if (VoiceManager.isRecordingActivated()) {
                Logger.m10999d(str, "onReceive stop recording");
                VoiceManager.stopRecording();
            }
        }
    }
}
