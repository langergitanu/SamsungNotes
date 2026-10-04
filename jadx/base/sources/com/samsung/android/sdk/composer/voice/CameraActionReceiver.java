package com.samsung.android.sdk.composer.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/CameraActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CameraActionReceiver extends BroadcastReceiver {

    @NotNull
    private static final String TAG = "CameraActionReceiver";

    @NotNull
    private static final String VN_REC_SAVE = "com.sec.android.app.voicenote.rec_save";

    @NotNull
    private static final String VR_REC_SAVE = "com.sec.android.app.voicerecorder.rec_save";

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(@Nullable Context context, @Nullable Intent intent) {
        try {
            Log.d(TAG, "onReceive");
            if (intent != null) {
                String action = intent.getAction();
                if (StringsKt.m14169y(action, "com.sec.android.app.voicerecorder.rec_save") || StringsKt.m14169y(action, "com.sec.android.app.voicenote.rec_save")) {
                    if (VoiceManager.isRecordingActivated()) {
                        Log.d(TAG, "onReceive stop recording");
                        VoiceManager.stopRecording();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
