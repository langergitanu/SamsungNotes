package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.graphics.Bitmap;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002$%J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u000bH&J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0017H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0017H&J\u0014\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0016\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0014H'J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper;", "", "cancelConcurrentTask", "", "cancelCurrentTask", "doConcurrentImageOverlay", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ConcurrentImageOverlayResultCallback;", "doImageOverlay", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ImageOverlayResultCallback;", "getOverlaidBitmap", "Landroid/graphics/Bitmap;", "init", "bitmap", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "tokenInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "initConcurrent", "translationRequestList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "isAvailable", "", "isProcessing", "isProcessingConcurrent", "setCheckImageMinimumSizeOnTranslation", "enabled", "setNeedToDownloadLangPack", "value", "setSourceLanguage", "language", "", "setSourceLanguageList", "languageList", "setTargetLanguage", "ConcurrentImageOverlayResultCallback", "ImageOverlayResultCallback", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ImageOverlayHelper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ConcurrentImageOverlayResultCallback;", "", "onFail", "", "requestId", "", "resultCode", "onSuccess", "overlaidBitmap", "Landroid/graphics/Bitmap;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ConcurrentImageOverlayResultCallback {
        void onFail(int requestId, int resultCode);

        void onSuccess(int requestId, @NotNull Bitmap overlaidBitmap);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setSourceLanguage$default(ImageOverlayHelper imageOverlayHelper, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSourceLanguage");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            imageOverlayHelper.setSourceLanguage(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper$ImageOverlayResultCallback;", "", "onFail", "", "resultCode", "", "onSuccess", "overlaidBitmap", "Landroid/graphics/Bitmap;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ImageOverlayResultCallback {
        void onFail(int resultCode);

        void onSuccess(@NotNull Bitmap overlaidBitmap);
    }

    void cancelConcurrentTask();

    void cancelCurrentTask();

    void doConcurrentImageOverlay(@NotNull ConcurrentImageOverlayResultCallback callback);

    void doImageOverlay(@NotNull ImageOverlayResultCallback callback);

    @Nullable
    Bitmap getOverlaidBitmap();

    void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult);

    @Deprecated(message = "TranslationTokenInfo is no longer needed in image translation")
    void init(@NotNull TranslationTokenInfo tokenInfo, @NotNull Bitmap bitmap, @NotNull OcrResult ocrResult);

    void initConcurrent(@NotNull List<TranslationRequest> translationRequestList);

    boolean isAvailable(@NotNull OcrResult ocrResult);

    boolean isAvailable(@NotNull OcrResult ocrResult, @NotNull Bitmap bitmap);

    boolean isProcessing();

    boolean isProcessingConcurrent();

    void setCheckImageMinimumSizeOnTranslation(boolean enabled);

    void setNeedToDownloadLangPack(boolean value);

    void setSourceLanguage(@Nullable String language);

    @Deprecated(message = "Use setSourceLanguage instead", replaceWith = @ReplaceWith(expression = "setSourceLanguage(language)", imports = {}))
    void setSourceLanguageList(@NotNull List<String> languageList);

    void setTargetLanguage(@NotNull String language);
}
