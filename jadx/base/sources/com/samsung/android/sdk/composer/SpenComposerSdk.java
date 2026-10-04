package com.samsung.android.sdk.composer;

import android.content.Context;
import com.samsung.android.sdk.composer.video.VideoManager;
import com.samsung.android.sdk.composer.voice.AudioFocus;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.text.SpenFontManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/SpenComposerSdk;", "", "<init>", "()V", "initialize", "", "context", "Landroid/content/Context;", "setCustomFallbackFont", "language", "", "buffer", "", "loadLibrary", "", "libraryName", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerSdk {

    @NotNull
    public static final SpenComposerSdk INSTANCE = new SpenComposerSdk();

    private SpenComposerSdk() {
    }

    private final boolean loadLibrary(String libraryName) {
        try {
            System.loadLibrary(libraryName);
            return true;
        } catch (Error e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void initialize(@Nullable Context context) {
        VoiceManager.setContext(context);
        AudioFocus.setContext(context);
        VideoManager.initialize();
        loadLibrary("SPenComposer");
    }

    public final void setCustomFallbackFont(@Nullable String language, @Nullable byte[] buffer) {
        SpenFontManager.setCustomFallbackFont(language, buffer);
    }
}
