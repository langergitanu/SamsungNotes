package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TextTranslator;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.util.SingleThreadCoroutineSwitcher;
import com.samsung.android.imagetranslation.LttEngineClient;
import com.samsung.android.imagetranslation.LttEngineListener;
import com.samsung.android.imagetranslation.data.RenderParam;
import com.samsung.android.imagetranslation.data.Session;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J.\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/LttV5ImageTranslationEngine;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/engine/LttImageTranslationEngine;", "context", "Landroid/content/Context;", "textTranslator", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TextTranslator;)V", "inPaintedBitmap", "Landroid/graphics/Bitmap;", "init", "", "bitmap", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "initLttEngineClient", "lttEngineClient", "Lcom/samsung/android/imagetranslation/LttEngineClient;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageTranslateListener;", "inPaintCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "renderCountDownLatch", "renderTranslatedImage", "translatedTextList", "", "", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LttV5ImageTranslationEngine extends LttImageTranslationEngine {

    @NotNull
    private static final String TAG = "LttV5ImageTranslationEngine";

    @Nullable
    private Bitmap inPaintedBitmap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LttV5ImageTranslationEngine(@NotNull Context context, @NotNull TextTranslator textTranslator) {
        super(context, textTranslator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textTranslator, "textTranslator");
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine, com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.ImageTranslationEngine
    public void init(@NotNull Bitmap bitmap, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        super.init(bitmap, ocrResult);
        this.inPaintedBitmap = null;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine
    public void initLttEngineClient(@NotNull final LttEngineClient lttEngineClient, @NotNull final ImageTranslateListener listener, @NotNull final CountDownLatch inPaintCountDownLatch, @NotNull final CountDownLatch renderCountDownLatch) {
        Intrinsics.checkNotNullParameter(lttEngineClient, "lttEngineClient");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(inPaintCountDownLatch, "inPaintCountDownLatch");
        Intrinsics.checkNotNullParameter(renderCountDownLatch, "renderCountDownLatch");
        LibLogger.m5432i(TAG, "initialize LttEngineClient version 5.x");
        lttEngineClient.initialize(new Session(getContext(), new LttEngineListener() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttV5ImageTranslationEngine.initLttEngineClient.1
            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onFailure(int requestId, final int errorCode) {
                SingleThreadCoroutineSwitcher.Chain<Unit> chainNewChain = SingleThreadCoroutineSwitcher.INSTANCE.newChain();
                final LttEngineClient lttEngineClient2 = lttEngineClient;
                final ImageTranslateListener imageTranslateListener = listener;
                final CountDownLatch countDownLatch = inPaintCountDownLatch;
                final CountDownLatch countDownLatch2 = renderCountDownLatch;
                final LttV5ImageTranslationEngine lttV5ImageTranslationEngine = LttV5ImageTranslationEngine.this;
                SingleThreadCoroutineSwitcher.Chain.start$default(chainNewChain.onMain(new Function1<Unit, Object>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttV5ImageTranslationEngine$initLttEngineClient$1$onFailure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Object invoke(@NotNull Unit it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        int i = errorCode;
                        if (i == -400) {
                            LibLogger.m5430e("LttV5ImageTranslationEngine", "LttEngineClient - ERROR_HARD_ERROR");
                            lttEngineClient2.release();
                            imageTranslateListener.onImageTranslateFail(new ImageTranslationResult.Error.RendererFail(0, 1, null));
                            countDownLatch.countDown();
                            countDownLatch2.countDown();
                            return Unit.INSTANCE;
                        }
                        if (i == -300) {
                            return Integer.valueOf(LibLogger.m5433w("LttV5ImageTranslationEngine", "LttEngineClient - ERROR_RENDERER_SOFT_ERROR"));
                        }
                        if (i == -200) {
                            LibLogger.m5433w("LttV5ImageTranslationEngine", "LttEngineClient - ERROR_INPAINTER_SOFT_ERROR");
                            lttV5ImageTranslationEngine.inPaintedBitmap = null;
                            countDownLatch.countDown();
                            return Unit.INSTANCE;
                        }
                        LibLogger.m5430e("LttV5ImageTranslationEngine", "LttEngineClient - ERROR_UNKNOWN_ERROR");
                        lttEngineClient2.release();
                        imageTranslateListener.onImageTranslateFail(new ImageTranslationResult.Error.RendererFail(0, 1, null));
                        countDownLatch.countDown();
                        countDownLatch2.countDown();
                        return Unit.INSTANCE;
                    }
                }), null, null, 3, null);
            }

            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onInPaintingSuccess(int requestId, @Nullable InpainterResult result) {
                LibLogger.m5432i(LttV5ImageTranslationEngine.TAG, "InPainting Success from LTT");
                LttV5ImageTranslationEngine.this.inPaintedBitmap = result != null ? result.getInpaintedBitmap() : null;
                inPaintCountDownLatch.countDown();
            }

            @Override // com.samsung.android.imagetranslation.LttEngineListener
            public void onRenderSuccess(int requestId, @Nullable final Bitmap result) {
                SingleThreadCoroutineSwitcher.Chain<Unit> chainNewChain = SingleThreadCoroutineSwitcher.INSTANCE.newChain();
                final LttEngineClient lttEngineClient2 = lttEngineClient;
                final LttV5ImageTranslationEngine lttV5ImageTranslationEngine = LttV5ImageTranslationEngine.this;
                final ImageTranslateListener imageTranslateListener = listener;
                final CountDownLatch countDownLatch = renderCountDownLatch;
                SingleThreadCoroutineSwitcher.Chain.start$default(chainNewChain.onMain(new Function1<Unit, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttV5ImageTranslationEngine$initLttEngineClient$1$onRenderSuccess$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                        invoke2(unit);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Unit it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        lttEngineClient2.release();
                        lttV5ImageTranslationEngine.setRenderedBitmap(result);
                        LibLogger.m5432i("LttV5ImageTranslationEngine", "Render Success from LTT");
                        imageTranslateListener.onImageTranslateSuccess();
                        countDownLatch.countDown();
                    }
                }), null, null, 3, null);
            }
        }));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.LttImageTranslationEngine
    public void renderTranslatedImage(@NotNull LttEngineClient lttEngineClient, @NotNull List<String> translatedTextList, @NotNull ImageTranslateListener listener, @NotNull CountDownLatch renderCountDownLatch) {
        Intrinsics.checkNotNullParameter(lttEngineClient, "lttEngineClient");
        Intrinsics.checkNotNullParameter(translatedTextList, "translatedTextList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(renderCountDownLatch, "renderCountDownLatch");
        RenderParam renderParam = new RenderParam();
        renderParam.setInputBitmap(getOriginalBitmap());
        renderParam.setInPaintedBitmap(this.inPaintedBitmap);
        renderParam.setDestLanguage(getTextTranslator().getTargetLanguage());
        renderParam.setLttOcrResult(getLttOcrResult());
        renderParam.setTrlResult(translatedTextList);
        Unit unit = Unit.INSTANCE;
        lttEngineClient.renderImage(0, renderParam);
    }
}
