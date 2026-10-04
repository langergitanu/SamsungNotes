package com.samsung.android.app.sdk.deepsky.textextraction.translate.engine;

import android.graphics.Bitmap;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.TranslationRequest;
import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1$deferredResults$1$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u00030\u0001*\u00020\u0006H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlin/Result;", "Lcom/samsung/android/vexfwk/sdk/imagetranslator/VexFwkImageTranslator$TranslationResult;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.engine.VexImageTranslationEngine$doConcurrentImageTranslation$1$deferredResults$1$1", m14021f = "VexImageTranslationEngine.kt", m14022i = {}, m14023l = {140, 145}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C7103xecfe7e55 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends Result<? extends VexFwkImageTranslator.TranslationResult>>>, Object> {
    final /* synthetic */ TranslationRequest $request;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VexImageTranslationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7103xecfe7e55(VexImageTranslationEngine vexImageTranslationEngine, TranslationRequest translationRequest, Continuation<? super C7103xecfe7e55> continuation) {
        super(2, continuation);
        this.this$0 = vexImageTranslationEngine;
        this.$request = translationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C7103xecfe7e55(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Integer, ? extends Result<? extends VexFwkImageTranslator.TranslationResult>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Integer, ? extends Result<? extends VexFwkImageTranslator.TranslationResult>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        VexFwkImageTranslator vexFwkImageTranslator;
        TranslationRequest translationRequest;
        VexImageTranslationEngine vexImageTranslationEngine;
        Throwable th;
        VexImageTranslationEngine vexImageTranslationEngine2;
        AutoCloseable autoCloseable;
        Object value;
        Integer num;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Semaphore semaphore = this.this$0.translationSemaphore;
                    this.label = 1;
                    if (semaphore.acquire(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    num = (Integer) this.L$2;
                    vexImageTranslationEngine2 = (VexImageTranslationEngine) this.L$1;
                    autoCloseable = (AutoCloseable) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        value = ((Result) obj).getValue();
                        Pair pair = new Pair(num, Result.m22214boximpl(value));
                        vexImageTranslationEngine2.translationSemaphore.release();
                        AutoCloseableKt.closeFinally(autoCloseable, null);
                        return pair;
                    } catch (Throwable th2) {
                        th = th2;
                        vexImageTranslationEngine2.translationSemaphore.release();
                        throw th;
                    }
                }
                ResultKt.throwOnFailure(obj);
                Integer numBoxInt = Boxing.boxInt(translationRequest.getRequestId());
                Bitmap image = translationRequest.getImage();
                OcrResult ocrResult = translationRequest.getOcrResult();
                this.L$0 = vexFwkImageTranslator;
                this.L$1 = vexImageTranslationEngine;
                this.L$2 = numBoxInt;
                this.label = 2;
                Object objM22151translateImageBWLJW6A = vexImageTranslationEngine.m22151translateImageBWLJW6A(vexFwkImageTranslator, image, ocrResult, this);
                if (objM22151translateImageBWLJW6A != coroutine_suspended) {
                    autoCloseable = vexFwkImageTranslator;
                    value = objM22151translateImageBWLJW6A;
                    vexImageTranslationEngine2 = vexImageTranslationEngine;
                    num = numBoxInt;
                    Pair pair2 = new Pair(num, Result.m22214boximpl(value));
                    vexImageTranslationEngine2.translationSemaphore.release();
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    return pair2;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                vexImageTranslationEngine2 = vexImageTranslationEngine;
                vexImageTranslationEngine2.translationSemaphore.release();
                throw th;
            }
            vexFwkImageTranslator = new VexFwkImageTranslator();
            translationRequest = this.$request;
            vexImageTranslationEngine = this.this$0;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                AutoCloseableKt.closeFinally(2, th4);
                throw th5;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<Integer, ? extends Result<? extends VexFwkImageTranslator.TranslationResult>>> continuation) {
        return ((C7103xecfe7e55) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
