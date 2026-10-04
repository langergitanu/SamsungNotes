package com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslationTokenInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u001c\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\u001e\u001a\u00020\u000fH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator;", "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/BaseOcrExtractor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mImageOverlayHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper;", "translatorState", "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$TranslatorState;", "mBitmap", "Landroid/graphics/Bitmap;", "setSourceLanguage", "", "sourceLanguage", "", "setTargetLanguage", "targetLanguage", "release", "executeImageOverlay", "bitmap", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$ResultListener;", "doImageOverlay", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "finish", "overlaidBitmap", "getTranslatorState", "setTranslatorState", "getTag", "TranslatorState", "ResultListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTranslator.kt\ncom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,137:1\n1#2:138\n*E\n"})
public final class ImageTranslator extends BaseOcrExtractor {

    @NotNull
    private static final String TAG = "ImageTranslator";

    @Nullable
    private Bitmap mBitmap;

    @Nullable
    private ImageOverlayHelper mImageOverlayHelper;

    @NotNull
    private TranslatorState translatorState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$ResultListener;", "", "onResult", "", "bitmap", "Landroid/graphics/Bitmap;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ResultListener {
        void onResult(@Nullable Bitmap bitmap);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/ImageTranslator$TranslatorState;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "PROCESSING", "COMPLETE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TranslatorState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TranslatorState[] $VALUES;
        public static final TranslatorState NONE = new TranslatorState(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final TranslatorState PROCESSING = new TranslatorState("PROCESSING", 1);
        public static final TranslatorState COMPLETE = new TranslatorState("COMPLETE", 2);

        private static final /* synthetic */ TranslatorState[] $values() {
            return new TranslatorState[]{NONE, PROCESSING, COMPLETE};
        }

        static {
            TranslatorState[] translatorStateArr$values = $values();
            $VALUES = translatorStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(translatorStateArr$values);
        }

        private TranslatorState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TranslatorState> getEntries() {
            return $ENTRIES;
        }

        public static TranslatorState valueOf(String str) {
            return (TranslatorState) Enum.valueOf(TranslatorState.class, str);
        }

        public static TranslatorState[] values() {
            return (TranslatorState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageTranslator(@Nullable Context context) {
        TextExtraction textExtraction;
        super(context);
        Intrinsics.checkNotNull(context);
        this.translatorState = TranslatorState.NONE;
        Logger.m8697d(TAG, "init");
        Context mContext = getMContext();
        ImageOverlayHelper imageOverlayHelper = null;
        if (mContext != null && (textExtraction = getTextExtraction()) != null) {
            imageOverlayHelper = textExtraction.getImageOverlayHelper(mContext);
        }
        this.mImageOverlayHelper = imageOverlayHelper;
        if (imageOverlayHelper != null) {
            imageOverlayHelper.setNeedToDownloadLangPack(false);
        }
    }

    private final void doImageOverlay(final ResultListener listener, OcrResult ocrResult) {
        if (this.mImageOverlayHelper == null) {
            Logger.m8698e(TAG, "doImageOverlay# ImageOverlayHelper is null");
            finish(listener, null);
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled()) {
                ImageOverlayHelper imageOverlayHelper = this.mImageOverlayHelper;
                if (imageOverlayHelper != null) {
                    TranslationTokenInfo translationTokenInfo = getTranslationTokenInfo();
                    Intrinsics.checkNotNull(translationTokenInfo);
                    Bitmap bitmap2 = this.mBitmap;
                    Intrinsics.checkNotNull(bitmap2);
                    imageOverlayHelper.init(translationTokenInfo, bitmap2, ocrResult);
                }
                ImageOverlayHelper imageOverlayHelper2 = this.mImageOverlayHelper;
                Boolean boolValueOf = imageOverlayHelper2 != null ? Boolean.valueOf(imageOverlayHelper2.isAvailable(ocrResult)) : null;
                Logger.m8697d(TAG, "doImageOverlay# available : " + boolValueOf);
                if (Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
                    finish(listener, null);
                    return;
                }
                ImageOverlayHelper imageOverlayHelper3 = this.mImageOverlayHelper;
                if (imageOverlayHelper3 != null) {
                    imageOverlayHelper3.doImageOverlay(new ImageOverlayHelper.ImageOverlayResultCallback() { // from class: com.samsung.android.support.senl.nt.base.common.ai.extractor.ImageTranslator.doImageOverlay.1
                        @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper.ImageOverlayResultCallback
                        public void onFail(int resultCode) {
                            Logger.m8698e(ImageTranslator.TAG, "doImageOverlay# onFail, " + resultCode);
                            ImageTranslator.this.finish(listener, null);
                        }

                        @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper.ImageOverlayResultCallback
                        public void onSuccess(Bitmap overlaidBitmap) {
                            Intrinsics.checkNotNullParameter(overlaidBitmap, "overlaidBitmap");
                            Logger.m8702i(ImageTranslator.TAG, "doImageOverlay# onSuccess");
                            ImageTranslator.this.finish(listener, overlaidBitmap);
                        }
                    });
                    return;
                }
                return;
            }
        }
        Logger.m8698e(TAG, "doImageOverlay# bitmap is null or recycled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish(ResultListener listener, Bitmap overlaidBitmap) {
        setTranslatorState(TranslatorState.COMPLETE);
        listener.onResult(overlaidBitmap);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final void executeImageOverlay(@Nullable Bitmap bitmap, @NotNull ResultListener listener) throws Throwable {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mBitmap = bitmap;
        if (getTextExtraction() == null) {
            Logger.m8698e(TAG, "executeImageOverlay# TextExtraction is null");
            finish(listener, null);
            return;
        }
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 == null) {
            Logger.m8698e(TAG, "executeImageOverlay# Bitmap is null");
            finish(listener, null);
            return;
        }
        Intrinsics.checkNotNull(bitmap2);
        OcrResult ocrResultExtractText = extractText(bitmap2);
        if (ocrResultExtractText != null) {
            doImageOverlay(listener, ocrResultExtractText);
        } else {
            finish(listener, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.BaseOcrExtractor
    @NotNull
    public String getTag() {
        return TAG;
    }

    @NotNull
    public final TranslatorState getTranslatorState() {
        return this.translatorState;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.BaseOcrExtractor
    public void release() {
        Logger.m8697d(TAG, "release");
        setTranslatorState(TranslatorState.NONE);
        setTextExtraction(null);
        this.mImageOverlayHelper = null;
        setTranslationTokenInfo(null);
        setMContext(null);
        this.mBitmap = null;
    }

    public final void setSourceLanguage(@Nullable String sourceLanguage) {
        AbstractC4539a.m3188B("setSourceLanguage# : ", sourceLanguage, TAG);
        ImageOverlayHelper imageOverlayHelper = this.mImageOverlayHelper;
        if (imageOverlayHelper == null || imageOverlayHelper == null) {
            return;
        }
        imageOverlayHelper.setSourceLanguage(sourceLanguage);
    }

    public final void setTargetLanguage(@Nullable String targetLanguage) {
        AbstractC4539a.m3188B("setTargetLanguage# targetLanguage : ", targetLanguage == null ? null : targetLanguage, TAG);
        ImageOverlayHelper imageOverlayHelper = this.mImageOverlayHelper;
        if (imageOverlayHelper == null || targetLanguage == null || imageOverlayHelper == null) {
            return;
        }
        imageOverlayHelper.setTargetLanguage(targetLanguage);
    }

    public final void setTranslatorState(@Nullable TranslatorState translatorState) {
        Logger.m8697d(TAG, "setTranslatorState# state : " + translatorState);
        if (translatorState != null) {
            this.translatorState = translatorState;
        }
    }
}
