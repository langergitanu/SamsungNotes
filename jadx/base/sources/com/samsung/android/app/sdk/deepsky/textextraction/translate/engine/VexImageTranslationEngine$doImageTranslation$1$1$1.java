package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageTranslateListener;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doImageTranslation$1$1$1", m14021f = "VexImageTranslationEngine.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class VexImageTranslationEngine$doImageTranslation$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageTranslateListener $listener;
    final /* synthetic */ Result<VexFwkImageTranslator.TranslationResult> $translationResult;
    final /* synthetic */ VexFwkImageTranslator $translator;
    int label;
    final /* synthetic */ VexImageTranslationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VexImageTranslationEngine$doImageTranslation$1$1$1(Result<? extends VexFwkImageTranslator.TranslationResult> result, VexImageTranslationEngine vexImageTranslationEngine, VexFwkImageTranslator vexFwkImageTranslator, ImageTranslateListener imageTranslateListener, Continuation<? super VexImageTranslationEngine$doImageTranslation$1$1$1> continuation) {
        super(2, continuation);
        this.$translationResult = result;
        this.this$0 = vexImageTranslationEngine;
        this.$translator = vexFwkImageTranslator;
        this.$listener = imageTranslateListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VexImageTranslationEngine$doImageTranslation$1$1$1(this.$translationResult, this.this$0, this.$translator, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Result<VexFwkImageTranslator.TranslationResult> result = this.$translationResult;
        if (result != null) {
            Object value = result.getValue();
            VexImageTranslationEngine vexImageTranslationEngine = this.this$0;
            VexFwkImageTranslator vexFwkImageTranslator = this.$translator;
            ImageTranslateListener imageTranslateListener = this.$listener;
            if (Result.m22222isSuccessimpl(value)) {
                VexFwkImageTranslator.TranslationResult result2 = (VexFwkImageTranslator.TranslationResult) value;
                LibLogger.m5432i("VexImageTranslationEngine", "imageTranslateTask done successfully");
                Intrinsics.checkNotNullExpressionValue(result2, "result");
                vexImageTranslationEngine.onImageTranslationComplete(vexFwkImageTranslator, result2, imageTranslateListener);
            }
            ImageTranslateListener imageTranslateListener2 = this.$listener;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(value);
            if (thM22218exceptionOrNullimpl != null) {
                LibLogger.m5431e("VexImageTranslationEngine", "image translation failed", thM22218exceptionOrNullimpl);
                imageTranslateListener2.onImageTranslateFail(new ImageTranslationResult.Error.RendererFail(0, 1, null));
            }
            Result.m22214boximpl(value);
        } else {
            final ImageTranslateListener imageTranslateListener3 = this.$listener;
            new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doImageTranslation$1$1$1.3
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
                    LibLogger.m5430e("VexImageTranslationEngine", "translationResult is null");
                    imageTranslateListener3.onImageTranslateFail(new ImageTranslationResult.Error.Unknown(0, 1, null));
                }
            };
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VexImageTranslationEngine$doImageTranslation$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
