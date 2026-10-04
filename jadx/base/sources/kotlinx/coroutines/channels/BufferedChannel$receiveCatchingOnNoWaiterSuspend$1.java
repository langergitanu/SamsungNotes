package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.channels.BufferedChannel", m14021f = "BufferedChannel.kt", m14022i = {0, 0, 0, 0}, m14023l = {3117}, m14024m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m14025n = {"this", "segment", "index", "r"}, m14026s = {"L$0", "L$1", "I$0", "J$0"})
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m23710receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m23719boximpl(objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
