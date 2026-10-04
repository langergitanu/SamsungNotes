package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackManager;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0016\u0010\u001b\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020 H\u0016J\u0012\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0016\u0010*\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001dH\u0017J\u0010\u0010,\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelperImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "imageTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslator;", "langPackManager", "Lcom/samsung/android/app/sdk/deepsky/textextraction/languagepack/LangPackManager;", "cancelConcurrentTask", "", "cancelCurrentTask", "doConcurrentImageOverlay", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ConcurrentImageOverlayResultCallback;", "doImageOverlay", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ImageOverlayResultCallback;", "getOverlaidBitmap", "Landroid/graphics/Bitmap;", "init", "bitmap", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "tokenInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "initConcurrent", "translationRequestList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "isAvailable", "", "isProcessing", "isProcessingConcurrent", "setCheckImageMinimumSizeOnTranslation", "enabled", "setNeedToDownloadLangPack", "value", "setSourceLanguage", "language", "", "setSourceLanguageList", "languageList", "setTargetLanguage", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ImageOverlayHelperImpl implements ImageOverlayHelper {

    @NotNull
    private static final String TAG = "ImageOverlayHelper";

    @NotNull
    private final Context context;

    @NotNull
    private final ImageTranslator imageTranslator;

    @NotNull
    private final LangPackManager langPackManager;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelperImpl$doImageOverlay$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelperImpl$doImageOverlay$1", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "onImageTranslateFail", "", "error", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "onImageTranslateSuccess", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class C70811 implements ImageTranslateListener {
        final /* synthetic */ ImageOverlayHelper.ImageOverlayResultCallback $callback;

        public C70811(ImageOverlayHelper.ImageOverlayResultCallback imageOverlayResultCallback) {
            this.$callback = imageOverlayResultCallback;
        }

        @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener
        public void onImageTranslateFail(@NotNull ImageTranslationResult.Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            LibLogger.m5433w(ImageOverlayHelperImpl.TAG, "doImageOverlay failed: " + error);
            this.$callback.onFail(error.getCode());
        }

        @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener
        public void onImageTranslateSuccess() {
            Bitmap renderedBitmap = ImageOverlayHelperImpl.this.imageTranslator.getRenderedBitmap();
            if (renderedBitmap == null) {
                new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelperImpl$doImageOverlay$1$onImageTranslateSuccess$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        this.this$0.onImageTranslateFail(new ImageTranslationResult.Error.Unknown(0, 1, null));
                    }
                };
                return;
            }
            ImageOverlayHelper.ImageOverlayResultCallback imageOverlayResultCallback = this.$callback;
            LibLogger.m5432i(ImageOverlayHelperImpl.TAG, "doImageOverlay success: " + LogUtil.INSTANCE.logString(renderedBitmap));
            imageOverlayResultCallback.onSuccess(renderedBitmap);
            Unit unit = Unit.INSTANCE;
        }
    }

    public ImageOverlayHelperImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        LangPackManager langPackManager = new LangPackManager(context);
        this.langPackManager = langPackManager;
        this.imageTranslator = new ImageTranslator(context, langPackManager);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void cancelConcurrentTask() {
        this.imageTranslator.cancelConcurrent();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void cancelCurrentTask() {
        this.imageTranslator.cancel();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void doConcurrentImageOverlay(@NotNull final ImageOverlayHelper.ConcurrentImageOverlayResultCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LibLogger.m5432i(TAG, "doConcurrentImageOverlay called");
        this.imageTranslator.doConcurrentImageTranslate(new ConcurrentImageTranslateListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelperImpl.doConcurrentImageOverlay.1
            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslateListener
            public void onImageTranslateFail(int requestId, @NotNull ImageTranslationResult.Error error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LibLogger.m5432i(ImageOverlayHelperImpl.TAG, "doConcurrentImageOverlay failed: id(" + requestId + "), " + error);
                callback.onFail(requestId, error.getCode());
            }

            @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslateListener
            public void onImageTranslateSuccess(int requestId, @NotNull Bitmap result) {
                Intrinsics.checkNotNullParameter(result, "result");
                LibLogger.m5432i(ImageOverlayHelperImpl.TAG, "doConcurrentImageOverlay success: id(" + requestId + "), " + LogUtil.INSTANCE.logString(result));
                callback.onSuccess(requestId, result);
            }
        });
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void doImageOverlay(@NotNull ImageOverlayHelper.ImageOverlayResultCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LibLogger.m5432i(TAG, "doImageOverlay called");
        this.imageTranslator.doImageTranslate(new C70811(callback));
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    @Nullable
    public Bitmap getOverlaidBitmap() {
        Bitmap renderedBitmap = this.imageTranslator.getRenderedBitmap();
        LibLogger.m5432i(TAG, "getOverlaidBitmap " + (renderedBitmap != null ? LogUtil.INSTANCE.logString(renderedBitmap) : null));
        return renderedBitmap;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    @Deprecated(message = "TranslationTokenInfo is no longer needed in image translation", replaceWith = @ReplaceWith(expression = "init(bitmap, ocrResult)", imports = {}))
    public void init(@NotNull TranslationTokenInfo tokenInfo, @NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(tokenInfo, "tokenInfo");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        init(bitmap, ocrResult);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void initConcurrent(@NotNull List<TranslationRequest> translationRequestList) {
        Intrinsics.checkNotNullParameter(translationRequestList, "translationRequestList");
        LibLogger.m5432i(TAG, "initConcurrent with " + translationRequestList.size() + " requests");
        this.imageTranslator.initConcurrent(translationRequestList);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public boolean isAvailable(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        try {
            return this.imageTranslator.isTranslationAvailable(ocrResult);
        } catch (InterruptedException e) {
            LibLogger.m5433w(TAG, "isAvailable causes interrupted exception : " + e);
            return false;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public boolean isProcessing() {
        return this.imageTranslator.isProcessing();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public boolean isProcessingConcurrent() {
        return this.imageTranslator.isProcessingConcurrent();
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void setCheckImageMinimumSizeOnTranslation(boolean enabled) {
        LibLogger.m5432i(TAG, "setCheckImageMinimumSizeOnTranslation " + enabled);
        this.imageTranslator.setCheckImageMinimumSize(enabled);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void setNeedToDownloadLangPack(boolean value) {
        this.imageTranslator.setNeedToDownloadLangPack(value);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void setSourceLanguage(@Nullable String language) {
        ImageTranslator imageTranslator = this.imageTranslator;
        if (language == null) {
            language = LangPackConfigConstants.LANGUAGE_CODE_AUTO;
        }
        imageTranslator.setSourceLanguage(language);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    @Deprecated(message = "Use setSourceLanguage instead", replaceWith = @ReplaceWith(expression = "setSourceLanguage(language)", imports = {}))
    public void setSourceLanguageList(@NotNull List<String> languageList) {
        Intrinsics.checkNotNullParameter(languageList, "languageList");
        this.imageTranslator.setSupportedSourceLangList(languageList);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void setTargetLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.imageTranslator.setTargetLanguage(language);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        LibLogger.m5432i(TAG, AbstractC1974b.m1319l("init with ", ocrResult.getBlockInfoList().size(), LogUtil.INSTANCE.logString(bitmap), SQLKeyword.COMMA, " blocks"));
        this.imageTranslator.init(bitmap, ocrResult);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper
    public boolean isAvailable(@NotNull OcrResult ocrResult, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        try {
            return this.imageTranslator.isTranslationAvailable(ocrResult, bitmap);
        } catch (InterruptedException e) {
            LibLogger.m5433w(TAG, "isAvailable causes interrupted exception : " + e);
            return false;
        }
    }
}
