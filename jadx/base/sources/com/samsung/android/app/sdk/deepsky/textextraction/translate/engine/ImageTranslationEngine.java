package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.graphics.Bitmap;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000 M2\u00020\u0001:\u0001MB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00104\u001a\u000205J\b\u00106\u001a\u000205H&J\u0010\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H&J\u0010\u0010:\u001a\u0002052\u0006\u00108\u001a\u00020;H&J\u0006\u0010<\u001a\u00020\bJ\u0006\u0010=\u001a\u00020\u0007J\u0018\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0016\u0010@\u001a\u0002052\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0-H&J\b\u0010C\u001a\u00020\u0010H\u0004J\b\u0010D\u001a\u00020\u0010H\u0004J\u0006\u0010E\u001a\u00020\u0010J\b\u0010F\u001a\u00020\u0010H&J\u000e\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u001dJ\u0018\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010#J\u0006\u0010I\u001a\u000205J\u000e\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u0002052\u0006\u0010K\u001a\u00020\u0007R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0014\u001a\u0004\u0018\u00010#@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010)\u001a\u0004\u0018\u00010#2\b\u0010\u0014\u001a\u0004\u0018\u00010#@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine;", "", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;)V", "detectedLangCountMap", "", "", "", "imageTranslateTask", "Lkotlinx/coroutines/Job;", "getImageTranslateTask", "()Lkotlinx/coroutines/Job;", "setImageTranslateTask", "(Lkotlinx/coroutines/Job;)V", "isCheckImageMinimumSize", "", "()Z", "setCheckImageMinimumSize", "(Z)V", "<set-?>", "lastTranslatedText", "getLastTranslatedText", "()Ljava/lang/String;", "setLastTranslatedText", "(Ljava/lang/String;)V", "needToDownloadLangPack", "getNeedToDownloadLangPack", "setNeedToDownloadLangPack", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ocrResult", "getOcrResult", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "setOcrResult", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;)V", "Landroid/graphics/Bitmap;", "originalBitmap", "getOriginalBitmap", "()Landroid/graphics/Bitmap;", "setOriginalBitmap", "(Landroid/graphics/Bitmap;)V", "renderedBitmap", "getRenderedBitmap", "setRenderedBitmap", "supportedSourceLangList", "", "getSupportedSourceLangList", "()Ljava/util/List;", "setSupportedSourceLangList", "(Ljava/util/List;)V", "getTextTranslator", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "cancel", "", "cancelConcurrent", "doConcurrentImageTranslation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslateListener;", "doImageTranslation", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "getDetectedLanguageNumber", "getMostDetectedLanguage", "init", "bitmap", "initConcurrent", "translationRequestList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "isAutoTranslationMode", "isLangPackDownloadNeeded", "isProcessing", "isProcessingConcurrent", "isTranslationAvailable", "result", "removeCache", "setSourceLanguage", "language", "setTargetLanguage", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageTranslationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
public abstract class ImageTranslationEngine {
    private static final int MINIMUM_IMAGE_SIZE_FOR_TRANSLATION = 350;

    @NotNull
    private static final String TAG = "ImageTranslationEngine";

    @NotNull
    private Map<String, Integer> detectedLangCountMap;

    @Nullable
    private Job imageTranslateTask;
    private boolean isCheckImageMinimumSize;

    @NotNull
    private String lastTranslatedText;
    private boolean needToDownloadLangPack;

    @Nullable
    private OcrResult ocrResult;

    @Nullable
    private Bitmap originalBitmap;

    @Nullable
    private Bitmap renderedBitmap;

    @NotNull
    private List<String> supportedSourceLangList;

    @NotNull
    private final TextTranslator textTranslator;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine$init$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine$init$1", m14021f = "ImageTranslationEngine.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C70941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ OcrResult $ocrResult;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine$init$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine$init$1$1", m14021f = "ImageTranslationEngine.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ OcrResult $ocrResult;
            int label;
            final /* synthetic */ ImageTranslationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ImageTranslationEngine imageTranslationEngine, OcrResult ocrResult, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = imageTranslationEngine;
                this.$ocrResult = ocrResult;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$ocrResult, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ImageTranslationEngine imageTranslationEngine = this.this$0;
                imageTranslationEngine.detectedLangCountMap = imageTranslationEngine.getTextTranslator().getDetectedLanguageAndCount(this.$ocrResult);
                LibLogger.m5432i(ImageTranslationEngine.TAG, "detectedLangCountMap: " + this.this$0.detectedLangCountMap);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70941(OcrResult ocrResult, Continuation<? super C70941> continuation) {
            super(2, continuation);
            this.$ocrResult = ocrResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ImageTranslationEngine.this.new C70941(this.$ocrResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(ImageTranslationEngine.this, this.$ocrResult, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
            return ((C70941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ImageTranslationEngine(@NotNull TextTranslator textTranslator) {
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        this.textTranslator = textTranslator;
        this.needToDownloadLangPack = true;
        this.isCheckImageMinimumSize = true;
        this.supportedSourceLangList = CollectionsKt.emptyList();
        this.lastTranslatedText = "";
        this.detectedLangCountMap = MapsKt.emptyMap();
    }

    public final void cancel() {
        Object obj = this.imageTranslateTask;
        if (obj == null) {
            obj = "null";
        }
        LibLogger.m5432i(TAG, "cancel imageTranslateTask if any: " + obj);
        Job job = this.imageTranslateTask;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        removeCache();
    }

    public abstract void cancelConcurrent();

    public abstract void doConcurrentImageTranslation(@NotNull ConcurrentImageTranslateListener listener);

    public abstract void doImageTranslation(@NotNull ImageTranslateListener listener);

    public final int getDetectedLanguageNumber() {
        return this.detectedLangCountMap.size();
    }

    @Nullable
    public final Job getImageTranslateTask() {
        return this.imageTranslateTask;
    }

    @NotNull
    public final String getLastTranslatedText() {
        return this.lastTranslatedText;
    }

    @NotNull
    public final String getMostDetectedLanguage() {
        Object obj;
        String str;
        Iterator<T> it = this.detectedLangCountMap.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next2 = it.next();
                    int iIntValue2 = ((Number) ((Map.Entry) next2).getValue()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        return (entry == null || (str = (String) entry.getKey()) == null) ? "" : str;
    }

    public final boolean getNeedToDownloadLangPack() {
        return this.needToDownloadLangPack;
    }

    @Nullable
    public final OcrResult getOcrResult() {
        return this.ocrResult;
    }

    @Nullable
    public final Bitmap getOriginalBitmap() {
        return this.originalBitmap;
    }

    @Nullable
    public final Bitmap getRenderedBitmap() {
        return this.renderedBitmap;
    }

    @NotNull
    public final List<String> getSupportedSourceLangList() {
        return this.supportedSourceLangList;
    }

    @NotNull
    public final TextTranslator getTextTranslator() {
        return this.textTranslator;
    }

    public void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        LibLogger.m5432i(TAG, AbstractC1974b.m1319l("initialize engine with ", ocrResult.getBlockInfoList().size(), LogUtil.INSTANCE.logString(bitmap), SQLKeyword.COMMA, " blocks"));
        this.originalBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.ocrResult = ocrResult;
        BuildersKt__BuildersKt.runBlocking$default(null, new C70941(ocrResult, null), 1, null);
    }

    public abstract void initConcurrent(@NotNull List<TranslationRequest> translationRequestList);

    public final boolean isAutoTranslationMode() {
        return Intrinsics.areEqual(this.textTranslator.getSourceLanguage(), LangPackConfigConstants.LANGUAGE_CODE_AUTO);
    }

    /* JADX INFO: renamed from: isCheckImageMinimumSize, reason: from getter */
    public final boolean getIsCheckImageMinimumSize() {
        return this.isCheckImageMinimumSize;
    }

    public final boolean isLangPackDownloadNeeded() {
        return this.needToDownloadLangPack && this.textTranslator.isLangPackDownloadNeeded();
    }

    public final boolean isProcessing() {
        if (this.imageTranslateTask != null) {
            return !r0.isCompleted();
        }
        return false;
    }

    public abstract boolean isProcessingConcurrent();

    public final boolean isTranslationAvailable(@NotNull OcrResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return isTranslationAvailable(result, this.originalBitmap);
    }

    public final void removeCache() {
        this.renderedBitmap = null;
    }

    public final void setCheckImageMinimumSize(boolean z) {
        this.isCheckImageMinimumSize = z;
    }

    public final void setImageTranslateTask(@Nullable Job job) {
        this.imageTranslateTask = job;
    }

    public final void setLastTranslatedText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lastTranslatedText = str;
    }

    public final void setNeedToDownloadLangPack(boolean z) {
        this.needToDownloadLangPack = z;
    }

    public final void setOcrResult(@Nullable OcrResult ocrResult) {
        this.ocrResult = ocrResult;
    }

    public final void setOriginalBitmap(@Nullable Bitmap bitmap) {
        this.originalBitmap = bitmap;
    }

    public final void setRenderedBitmap(@Nullable Bitmap bitmap) {
        this.renderedBitmap = bitmap;
    }

    public final void setSourceLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.textTranslator.setSourceLanguage(language);
    }

    public final void setSupportedSourceLangList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.supportedSourceLangList = list;
    }

    public final void setTargetLanguage(@NotNull String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        this.textTranslator.setTargetLanguage(language);
    }

    public final boolean isTranslationAvailable(@NotNull OcrResult result, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!Rune.INSTANCE.isSupportTranslation()) {
            LibLogger.m5433w(TAG, "[Available] Not support native AI feature");
            return false;
        }
        if (result.getBlockInfoList().isEmpty()) {
            LibLogger.m5433w(TAG, "[Available] OcrResult empty");
            return false;
        }
        if (bitmap != null) {
            int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (this.isCheckImageMinimumSize && iMin < MINIMUM_IMAGE_SIZE_FOR_TRANSLATION) {
                LibLogger.m5433w(TAG, "[Available] Image size too small");
                return false;
            }
        }
        if (this.textTranslator.isTranslationNeeded(result)) {
            return true;
        }
        LibLogger.m5432i(TAG, "[Available] Translation not needed");
        return false;
    }
}
