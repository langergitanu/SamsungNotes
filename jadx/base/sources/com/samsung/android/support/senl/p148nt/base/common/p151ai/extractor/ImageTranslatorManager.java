package com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.ImageTranslator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR(\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslatorManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "imageTranslator", "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator;", "isSupported", "", "()Z", "setSourceLanguage", "", "sourceLanguage", "", "setTargetLanguage", "targetLanguage", "release", "executeImageOverlay", "bitmap", "Landroid/graphics/Bitmap;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$ResultListener;", "translatorState", "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$TranslatorState;", "getTranslatorState", "()Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$TranslatorState;", "setTranslatorState", "(Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$TranslatorState;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageTranslatorManager {

    @NotNull
    private ImageTranslator imageTranslator;

    public ImageTranslatorManager(@Nullable Context context) {
        this.imageTranslator = new ImageTranslator(context);
    }

    public final void executeImageOverlay(@Nullable Bitmap bitmap, @NotNull ImageTranslator.ResultListener listener) throws Throwable {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.imageTranslator.executeImageOverlay(bitmap, listener);
    }

    @Nullable
    public final ImageTranslator.TranslatorState getTranslatorState() {
        return this.imageTranslator.getTranslatorState();
    }

    public final boolean isSupported() {
        return this.imageTranslator.isSupportedOCR();
    }

    public final void release() {
        this.imageTranslator.release();
    }

    public final void setSourceLanguage(@Nullable String sourceLanguage) {
        this.imageTranslator.setSourceLanguage(sourceLanguage);
    }

    public final void setTargetLanguage(@Nullable String targetLanguage) {
        this.imageTranslator.setTargetLanguage(targetLanguage);
    }

    public final void setTranslatorState(@Nullable ImageTranslator.TranslatorState translatorState) {
        this.imageTranslator.setTranslatorState(translatorState);
    }
}
