package com.samsung.android.sdk.composer.view.accessibility;

import android.content.Context;
import android.media.AudioAttributes;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eJ\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/accessibility/AccessibilityTtsUtil;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SearchConstants.TargetContents.TAG, "", "mContext", "mTts", "Landroid/speech/tts/TextToSpeech;", "mIsInitialized", "", "mSpeakOnInit", "", "tts", "getTts", "()Landroid/speech/tts/TextToSpeech;", "isTalkBackEnabled", "()Z", "onInit", "", "arg0", "", "close", "speak", "text", "speakWithVibrator", "sendAccessibilityEvent", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AccessibilityTtsUtil implements TextToSpeech.OnInitListener {

    @NotNull
    private final String TAG = "AccessibilityTtsUtil";

    @Nullable
    private Context mContext;
    private boolean mIsInitialized;

    @Nullable
    private CharSequence mSpeakOnInit;

    @Nullable
    private TextToSpeech mTts;

    public AccessibilityTtsUtil(@Nullable Context context) {
        this.mContext = context;
    }

    private final TextToSpeech getTts() {
        if (this.mTts == null && this.mContext != null) {
            TextToSpeech textToSpeech = new TextToSpeech(this.mContext, this);
            this.mTts = textToSpeech;
            Intrinsics.checkNotNull(this.mContext);
            textToSpeech.setPitch(Settings.Secure.getInt(r1.getContentResolver(), "tts_default_pitch", 100) / 100.0f);
            textToSpeech.setAudioAttributes(new AudioAttributes.Builder().setUsage(11).setContentType(1).build());
        }
        return this.mTts;
    }

    private final void sendAccessibilityEvent(CharSequence text) {
        if (text != null) {
            Context context = this.mContext;
            AccessibilityManager accessibilityManager = (AccessibilityManager) (context != null ? context.getSystemService("accessibility") : null);
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
            accessibilityEventObtain.getText().clear();
            accessibilityEventObtain.getText().add(text);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public final void close() {
        this.mContext = null;
    }

    public final boolean isTalkBackEnabled() {
        return false;
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int arg0) {
        Log.d(this.TAG, "onInit");
        this.mIsInitialized = true;
        CharSequence charSequence = this.mSpeakOnInit;
        if (charSequence != null) {
            speak(charSequence);
            this.mSpeakOnInit = null;
        }
    }

    public final boolean speak(@Nullable CharSequence text) {
        TextToSpeech tts = getTts();
        if (tts == null || !isTalkBackEnabled()) {
            return false;
        }
        Log.d(this.TAG, "speak " + ((Object) text));
        if (this.mIsInitialized) {
            tts.speak(text, 0, null, null);
            sendAccessibilityEvent(text);
            return true;
        }
        Log.d(this.TAG, "textToSpeak not initialized ");
        this.mSpeakOnInit = text;
        return true;
    }

    public final boolean speakWithVibrator(@NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return speak(text);
    }
}
