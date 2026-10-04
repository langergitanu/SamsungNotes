package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.app.sdk.deepsky.textextraction.translate.ConcurrentImageTranslator$initSession$1$1$onFailure$1", m14021f = "ConcurrentImageTranslator.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class ConcurrentImageTranslator$initSession$1$1$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $requestId;
    int label;
    final /* synthetic */ ConcurrentImageTranslator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcurrentImageTranslator$initSession$1$1$onFailure$1(ConcurrentImageTranslator concurrentImageTranslator, int i, Continuation<? super ConcurrentImageTranslator$initSession$1$1$onFailure$1> continuation) {
        super(2, continuation);
        this.this$0 = concurrentImageTranslator;
        this.$requestId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConcurrentImageTranslator$initSession$1$1$onFailure$1(this.this$0, this.$requestId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List listTranslateAll = this.this$0.translateAll(this.$requestId);
        if (listTranslateAll.isEmpty()) {
            this.this$0.sendResult(new ImageTranslationStatus.Failure(this.$requestId, new ImageTranslationResult.Error.EmptyBlockList(0, 1, null)));
            return Unit.INSTANCE;
        }
        this.this$0.renderImage(this.$requestId, null, listTranslateAll);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ConcurrentImageTranslator$initSession$1$1$onFailure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
