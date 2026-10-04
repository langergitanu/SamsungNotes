package com.samsung.android.sdk.composer;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.sdk.composer.SpenTextWritingView$createLowQualityBitmap$1$1$1", m14021f = "SpenTextWritingView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SpenTextWritingView$createLowQualityBitmap$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ SpenTextWritingView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenTextWritingView$createLowQualityBitmap$1$1$1(SpenTextWritingView spenTextWritingView, Bitmap bitmap, Continuation<? super SpenTextWritingView$createLowQualityBitmap$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = spenTextWritingView;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpenTextWritingView$createLowQualityBitmap$1$1$1(this.this$0, this.$bitmap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.this$0.mIsLazyUpdateStarted) {
            this.this$0.mLowQualityCacheBitmap = this.$bitmap;
            SpenTextWritingView spenTextWritingView = this.this$0;
            spenTextWritingView.Native_startLazyViewUpdate(spenTextWritingView.getMNativeHandle(), true);
            this.this$0.invalidate();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpenTextWritingView$createLowQualityBitmap$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
