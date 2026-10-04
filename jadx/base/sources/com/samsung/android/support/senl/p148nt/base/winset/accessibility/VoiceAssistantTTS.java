package com.samsung.android.support.senl.p148nt.base.winset.accessibility;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/accessibility/VoiceAssistantTTS;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "<init>", "()V", "message", "", "say", "", "context", "Landroid/content/Context;", "onInit", "status", "", "speakOut", "stop", "sendTalkBackMessage", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceAssistantTTS implements TextToSpeech.OnInitListener {

    @NotNull
    private static final String TAG = "VoiceAssistantTTS";

    @Nullable
    private static TextToSpeech tts;

    @Nullable
    private String message;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final VoiceAssistantTTS instance = new VoiceAssistantTTS();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/accessibility/VoiceAssistantTTS$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "tts", "Landroid/speech/tts/TextToSpeech;", "instance", "Lcom/samsung/android/support/senl/nt/base/winset/accessibility/VoiceAssistantTTS;", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/winset/accessibility/VoiceAssistantTTS;", "isVoiceAssistantEnabled", "", "context", "Landroid/content/Context;", "isOldVoiceAssistantEnabled", "isTalkBackUsed", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVoiceAssistantTTS.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAssistantTTS.kt\ncom/samsung/android/support/senl/nt/base/winset/accessibility/VoiceAssistantTTS$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private final boolean isOldVoiceAssistantEnabled(Context context) {
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            boolean z = false;
            if (string != null && (StringsKt.m14162r(string, "com.samsung.android.app.talkback.TalkBackService") || StringsKt.m14162r(string, "com.google.android.marvin.talkback.TalkBackService"))) {
                z = true;
            }
            if (string == null) {
                string = "null";
            }
            Logger.m8697d(VoiceAssistantTTS.TAG, "talkBackEnabled = " + z + ", accessibilityService = " + string);
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTalkBackUsed() {
            return DeviceInfo.isSemDevice() && Build.VERSION.SDK_INT >= 30;
        }

        @NotNull
        public final VoiceAssistantTTS getInstance() {
            return VoiceAssistantTTS.instance;
        }

        @JvmStatic
        public final boolean isVoiceAssistantEnabled(@Nullable Context context) {
            Object systemService;
            if (!isTalkBackUsed()) {
                return context != null && VoiceAssistantTTS.INSTANCE.isOldVoiceAssistantEnabled(context);
            }
            if (context != null) {
                try {
                    systemService = context.getSystemService("accessibility");
                } catch (Exception e) {
                    AbstractC4539a.m3214x("exception. ", e.getMessage(), VoiceAssistantTTS.TAG);
                    return context != null && VoiceAssistantTTS.INSTANCE.isOldVoiceAssistantEnabled(context);
                }
            } else {
                systemService = null;
            }
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
            AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
            Object objInvoke = accessibilityManager.getClass().getMethod("semIsScreenReaderEnabled", null).invoke(accessibilityManager, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        }

        private Companion() {
        }
    }

    @NotNull
    public static final VoiceAssistantTTS getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final boolean isVoiceAssistantEnabled(@Nullable Context context) {
        return INSTANCE.isVoiceAssistantEnabled(context);
    }

    private final void speakOut() {
        AbstractC4539a.m3188B("Text to speech, message = ", this.message, TAG);
        TextToSpeech textToSpeech = tts;
        if (textToSpeech != null) {
            textToSpeech.speak(this.message, 0, null);
        }
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int status) {
        Logger.m8697d(TAG, "onInit()");
        if (status == 0) {
            Logger.m8697d(TAG, "onInit(), success");
            speakOut();
        }
    }

    public final void say(@NotNull Context context, @Nullable String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (INSTANCE.isVoiceAssistantEnabled(context)) {
            if (tts == null) {
                tts = new TextToSpeech(context, this);
                Logger.m8697d(TAG, "construct tts");
            }
            this.message = message;
            speakOut();
        }
    }

    public final void sendTalkBackMessage(@Nullable String message) {
        try {
            Context applicationContext = BaseUtils.getApplicationContext();
            Companion companion = INSTANCE;
            if (companion.isTalkBackUsed() && companion.isVoiceAssistantEnabled(applicationContext)) {
                Object systemService = applicationContext != null ? applicationContext.getSystemService("accessibility") : null;
                AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
                accessibilityEventObtain.setClassName(applicationContext != null ? applicationContext.getClass().getName() : null);
                accessibilityEventObtain.setPackageName(applicationContext != null ? applicationContext.getPackageName() : null);
                accessibilityEventObtain.setEnabled(true);
                accessibilityEventObtain.setBeforeText("");
                accessibilityEventObtain.getText().add(message);
                if (accessibilityManager != null) {
                    accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
                }
            }
        } catch (Exception e) {
            Logger.m8698e(TAG, "sendTalkBackMessage# " + e);
        }
    }

    public final void stop() {
        Logger.m8697d(TAG, "stop()");
        TextToSpeech textToSpeech = tts;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
        }
        TextToSpeech textToSpeech2 = tts;
        if (textToSpeech2 != null) {
            textToSpeech2.stop();
        }
        tts = null;
        Logger.m8697d(TAG, "stop(), end");
    }
}
