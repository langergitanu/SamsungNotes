package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LanguageUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrResultConverter;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationData;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.app.sdk.deepsky.textextraction.util.Rune;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import com.samsung.android.imagetranslation.LttEngineClient;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b \u0018\u0000 22\u00020\u0001:\u00012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0004J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0011H\u0002J(\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010(\u001a\u00020)H\u0016J.\u0010*\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0#2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\b\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\b\u0010/\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u000fH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/LttImageTranslationEngine;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/ImageTranslationEngine;", "context", "Landroid/content/Context;", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;)V", "getContext", "()Landroid/content/Context;", "imageTranslationDataList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationData;", "targetBlockInfoList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "cancelConcurrent", "", "createLttEngineClient", "Lcom/samsung/android/imagetranslation/LttEngineClient;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "inPaintCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "renderCountDownLatch", "doConcurrentImageTranslation", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ConcurrentImageTranslateListener;", "doImageTranslation", "getLttOcrResult", "Lcom/samsung/android/imagetranslation/data/LttOcrResult;", "init", "bitmap", "Landroid/graphics/Bitmap;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "initConcurrent", "translationRequestList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "initImageTranslationData", "lttEngineClient", "initLttEngineClient", "isProcessingConcurrent", "", "renderTranslatedImage", "translatedTextList", "", "trimInvalidSourceLanguage", "trimOnDeviceTranslationUnavailable", "trimSameSourceAndTargetLanguage", "trimSkippingCases", "trimUnsupportedSourceLanguage", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLttImageTranslationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LttImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/LttImageTranslationEngine\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,262:1\n3433#2,7:263\n766#2:270\n857#2,2:271\n766#2:273\n857#2,2:274\n766#2:276\n857#2,2:277\n766#2:279\n857#2,2:280\n*S KotlinDebug\n*F\n+ 1 LttImageTranslationEngine.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/LttImageTranslationEngine\n*L\n131#1:263,7\n165#1:270\n165#1:271,2\n180#1:273\n180#1:274,2\n195#1:276\n195#1:277,2\n212#1:279\n212#1:280,2\n*E\n"})
public abstract class LttImageTranslationEngine extends ImageTranslationEngine {

    @NotNull
    private static final String TAG = "LttImageTranslationEngine";

    @NotNull
    private final Context context;

    @NotNull
    private List<ImageTranslationData> imageTranslationDataList;

    @NotNull
    private List<OcrResult.BlockInfo> targetBlockInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LttImageTranslationEngine(@NotNull Context context, @NotNull TextTranslator textTranslator) {
        super(textTranslator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
        this.context = context;
        this.imageTranslationDataList = new ArrayList();
        this.targetBlockInfoList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LttEngineClient createLttEngineClient(ImageTranslateListener listener, CountDownLatch inPaintCountDownLatch, CountDownLatch renderCountDownLatch) {
        LttEngineClient lttEngineClient = LttEngineClient.createInstance();
        Intrinsics.checkNotNullExpressionValue(lttEngineClient, "lttEngineClient");
        initImageTranslationData(lttEngineClient);
        initLttEngineClient(lttEngineClient, listener, inPaintCountDownLatch, renderCountDownLatch);
        Intrinsics.checkNotNullExpressionValue(lttEngineClient, "createInstance().also { …h\n            )\n        }");
        return lttEngineClient;
    }

    private final void initImageTranslationData(LttEngineClient lttEngineClient) {
        List<OcrResult.BlockInfo> arrayList;
        List<OcrResult.BlockInfo> blockInfoList;
        this.imageTranslationDataList = new ArrayList();
        OcrResult ocrResult = getOcrResult();
        if (ocrResult == null || (blockInfoList = ocrResult.getBlockInfoList()) == null || (arrayList = CollectionsKt.toMutableList((Collection) blockInfoList)) == null) {
            arrayList = new ArrayList<>();
        }
        this.targetBlockInfoList = arrayList;
        List<String> resultsWithLineBreak = lttEngineClient.getResultsWithLineBreak(this.context, getLttOcrResult());
        Intrinsics.checkNotNullExpressionValue(resultsWithLineBreak, "lttEngineClient.getResul…ntext, getLttOcrResult())");
        List<OcrResult.BlockInfo> list = this.targetBlockInfoList;
        Iterator<T> it = list.iterator();
        List<String> list2 = resultsWithLineBreak;
        Iterator<T> it2 = list2.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.m13952k(list), CollectionsKt.m13952k(list2)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList2.add(Boolean.valueOf(this.imageTranslationDataList.add(new ImageTranslationData(((OcrResult.BlockInfo) it.next()).getPoly(), (String) it2.next(), "", "", ""))));
        }
    }

    private final void trimInvalidSourceLanguage() {
        int size = this.imageTranslationDataList.size();
        List listZip = CollectionsKt.zip(this.targetBlockInfoList, this.imageTranslationDataList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZip) {
            if (LanguageUtil.INSTANCE.isNormalLanguage(((ImageTranslationData) ((Pair) obj).getSecond()).getSourceLang())) {
                arrayList.add(obj);
            }
        }
        Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
        this.targetBlockInfoList = CollectionsKt.toMutableList((Collection) pairUnzip.getFirst());
        List<ImageTranslationData> mutableList = CollectionsKt.toMutableList((Collection) pairUnzip.getSecond());
        this.imageTranslationDataList = mutableList;
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - mutableList.size(), this.imageTranslationDataList.size(), "trimInvalidSourceLanguage: ", " results trimmed, ", " left"));
    }

    private final void trimOnDeviceTranslationUnavailable() {
        int size = this.imageTranslationDataList.size();
        if (isAutoTranslationMode()) {
            List listZip = CollectionsKt.zip(this.targetBlockInfoList, this.imageTranslationDataList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listZip) {
                ImageTranslationData imageTranslationData = (ImageTranslationData) ((Pair) obj).getSecond();
                if (getTextTranslator().isOnDeviceTranslationAvailable(imageTranslationData.getSourceLang(), imageTranslationData.getTargetLang())) {
                    arrayList.add(obj);
                }
            }
            Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
            this.targetBlockInfoList = CollectionsKt.toMutableList((Collection) pairUnzip.getFirst());
            this.imageTranslationDataList = CollectionsKt.toMutableList((Collection) pairUnzip.getSecond());
        }
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - this.imageTranslationDataList.size(), this.imageTranslationDataList.size(), "trimOnDeviceTranslationUnavailable: ", " results trimmed, ", " left"));
    }

    private final void trimSameSourceAndTargetLanguage() {
        int size = this.imageTranslationDataList.size();
        if (isAutoTranslationMode()) {
            List listZip = CollectionsKt.zip(this.targetBlockInfoList, this.imageTranslationDataList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listZip) {
                ImageTranslationData imageTranslationData = (ImageTranslationData) ((Pair) obj).getSecond();
                if (!Intrinsics.areEqual(imageTranslationData.getSourceLang(), imageTranslationData.getTargetLang())) {
                    arrayList.add(obj);
                }
            }
            Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
            this.targetBlockInfoList = CollectionsKt.toMutableList((Collection) pairUnzip.getFirst());
            this.imageTranslationDataList = CollectionsKt.toMutableList((Collection) pairUnzip.getSecond());
        }
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - this.imageTranslationDataList.size(), this.imageTranslationDataList.size(), "trimSameSourceAndTargetLanguage: ", " results trimmed, ", " left"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimSkippingCases() {
        trimSameSourceAndTargetLanguage();
        trimInvalidSourceLanguage();
        trimUnsupportedSourceLanguage();
        trimOnDeviceTranslationUnavailable();
    }

    private final void trimUnsupportedSourceLanguage() {
        int size = this.imageTranslationDataList.size();
        if (!getSupportedSourceLangList().isEmpty()) {
            List listZip = CollectionsKt.zip(this.targetBlockInfoList, this.imageTranslationDataList);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listZip) {
                if (getSupportedSourceLangList().contains(((ImageTranslationData) ((Pair) obj).getSecond()).getSourceLang())) {
                    arrayList.add(obj);
                }
            }
            Pair pairUnzip = CollectionsKt__IterablesKt.unzip(arrayList);
            this.targetBlockInfoList = CollectionsKt.toMutableList((Collection) pairUnzip.getFirst());
            this.imageTranslationDataList = CollectionsKt.toMutableList((Collection) pairUnzip.getSecond());
        }
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(size - this.imageTranslationDataList.size(), this.imageTranslationDataList.size(), "trimUnsupportedSourceLanguage: ", " results trimmed, ", " left"));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void cancelConcurrent() {
        LibLogger.m5430e(TAG, "cancelConcurrent is not supported for LTT engine");
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void doConcurrentImageTranslation(@NotNull ConcurrentImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LibLogger.m5430e(TAG, "doConcurrentImageTranslation is not supported for LTT engine");
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void doImageTranslation(@NotNull final ImageTranslateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isProcessing()) {
            LibLogger.m5433w(TAG, "The previous translate job wasn't complete");
        } else if (getRenderedBitmap() == null) {
            setImageTranslateTask(SingleThreadCoroutineSwitcher.INSTANCE.newChain().onBackground(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine.doImageTranslation.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) throws InterruptedException {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Unit it) throws InterruptedException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LttImageTranslationEngine.this.setLastTranslatedText("");
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    CountDownLatch countDownLatch2 = new CountDownLatch(1);
                    LttEngineClient lttEngineClientCreateLttEngineClient = LttImageTranslationEngine.this.createLttEngineClient(listener, countDownLatch, countDownLatch2);
                    LttImageTranslationEngine.this.getTextTranslator().initSourceLangInfo(LttImageTranslationEngine.this.imageTranslationDataList);
                    if (LttImageTranslationEngine.this.isLangPackDownloadNeeded()) {
                        LibLogger.m5433w(LttImageTranslationEngine.TAG, "Lang pack download needed");
                        TextTranslator.showLangPackDownloadDialog$default(LttImageTranslationEngine.this.getTextTranslator(), null, 1, null);
                        SingleThreadCoroutineSwitcher.Chain<Unit> chainNewChain = SingleThreadCoroutineSwitcher.INSTANCE.newChain();
                        final ImageTranslateListener imageTranslateListener = listener;
                        SingleThreadCoroutineSwitcher.Chain.start$default(chainNewChain.onMain(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine.doImageTranslation.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                                invoke2(unit);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull Unit it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                imageTranslateListener.onImageTranslateFail(new ImageTranslationResult.Error.RequestLanguagePackDownload(0, 1, null));
                            }
                        }), null, null, 3, null);
                        lttEngineClientCreateLttEngineClient.release();
                        return;
                    }
                    LibLogger.m5432i(LttImageTranslationEngine.TAG, "LangPack Done, Translate starts");
                    LttImageTranslationEngine.this.trimSkippingCases();
                    if (LttImageTranslationEngine.this.targetBlockInfoList.isEmpty()) {
                        SingleThreadCoroutineSwitcher.Chain<Unit> chainNewChain2 = SingleThreadCoroutineSwitcher.INSTANCE.newChain();
                        final ImageTranslateListener imageTranslateListener2 = listener;
                        SingleThreadCoroutineSwitcher.Chain.start$default(chainNewChain2.onMain(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine.doImageTranslation.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                                invoke2(unit);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull Unit it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                LibLogger.m5433w(LttImageTranslationEngine.TAG, "targetBlockInfoList empty after trimming");
                                imageTranslateListener2.onImageTranslateFail(new ImageTranslationResult.Error.EmptyBlockList(0, 1, null));
                            }
                        }), null, null, 3, null);
                        lttEngineClientCreateLttEngineClient.release();
                        return;
                    }
                    if (Rune.INSTANCE.isSupportImageInPainting()) {
                        LibLogger.m5432i(LttImageTranslationEngine.TAG, "LttEngineClient - starts image in-painting");
                        lttEngineClientCreateLttEngineClient.inPaintImage(0, new InpainterParam(0, LttImageTranslationEngine.this.getOriginalBitmap(), LttImageTranslationEngine.this.getLttOcrResult()));
                    }
                    TextTranslator.translateAll$default(LttImageTranslationEngine.this.getTextTranslator(), 0, LttImageTranslationEngine.this.imageTranslationDataList, false, 5, null);
                    List list = LttImageTranslationEngine.this.imageTranslationDataList;
                    ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((ImageTranslationData) it2.next()).getTargetText());
                    }
                    List<String> list2 = CollectionsKt.toList(arrayList);
                    LttImageTranslationEngine.this.setLastTranslatedText(CollectionsKt.m13955n(list2, "\n", null, null, null, 62));
                    if (Rune.INSTANCE.isSupportImageInPainting()) {
                        LibLogger.m5432i(LttImageTranslationEngine.TAG, "Waits for finishing inPainting");
                        countDownLatch.await();
                    }
                    LibLogger.m5432i(LttImageTranslationEngine.TAG, "Translate Done, Overlay starts");
                    LttImageTranslationEngine.this.renderTranslatedImage(lttEngineClientCreateLttEngineClient, list2, listener, countDownLatch2);
                    countDownLatch2.await();
                }
            }).start(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine.doImageTranslation.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Unit unit) {
                    LibLogger.m5432i(LttImageTranslationEngine.TAG, "imageTranslateTask done successfully");
                }
            }, new Function1<Throwable, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine.doImageTranslation.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LibLogger.m5431e(LttImageTranslationEngine.TAG, "image translation failed", it);
                    listener.onImageTranslateFail(new ImageTranslationResult.Error.Unknown(0, 1, null));
                }
            }));
        } else {
            LibLogger.m5433w(TAG, "The same rendered bitmap exists");
            listener.onImageTranslateSuccess();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final LttOcrResult getLttOcrResult() {
        String languageTags;
        OcrResultConverter ocrResultConverter = OcrResultConverter.INSTANCE;
        List<OcrResult.BlockInfo> list = this.targetBlockInfoList;
        ArrayList arrayList = new ArrayList();
        OcrResult ocrResult = getOcrResult();
        if (ocrResult == null || (languageTags = ocrResult.getLanguageTags()) == null) {
            languageTags = "";
        }
        return ocrResultConverter.toLttOcrResult(new OcrResult(list, arrayList, languageTags));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        super.init(bitmap, ocrResult);
        this.targetBlockInfoList = CollectionsKt.toMutableList((Collection) ocrResult.getBlockInfoList());
        this.imageTranslationDataList = new ArrayList();
        setRenderedBitmap(null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void initConcurrent(@NotNull List<TranslationRequest> translationRequestList) {
        Intrinsics.checkNotNullParameter(translationRequestList, "translationRequestList");
        LibLogger.m5430e(TAG, "initConcurrent is not supported for LTT engine");
    }

    public abstract void initLttEngineClient(@NotNull LttEngineClient lttEngineClient, @NotNull ImageTranslateListener listener, @NotNull CountDownLatch inPaintCountDownLatch, @NotNull CountDownLatch renderCountDownLatch);

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public boolean isProcessingConcurrent() {
        LibLogger.m5430e(TAG, "isProcessingConcurrent is not supported for LTT engine");
        return false;
    }

    public abstract void renderTranslatedImage(@NotNull LttEngineClient lttEngineClient, @NotNull List<String> translatedTextList, @NotNull ImageTranslateListener listener, @NotNull CountDownLatch renderCountDownLatch);
}
