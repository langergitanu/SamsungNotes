package androidx.glance.appwidget.multiprocess;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {53}, m14024m = "runComposition-0E7RQCE", m14025n = {}, m14026s = {})
public final class CoroutineSession$runComposition$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineSession$runComposition$1(CoroutineSession coroutineSession, Continuation<? super CoroutineSession$runComposition$1> continuation) {
        super(continuation);
        this.this$0 = coroutineSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM21353runComposition0E7RQCE = this.this$0.m21353runComposition0E7RQCE(null, null, this);
        return objM21353runComposition0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM21353runComposition0E7RQCE : Result.m22214boximpl(objM21353runComposition0E7RQCE);
    }
}
