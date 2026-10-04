package androidx.compose.p109ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.ui.input.nestedscroll.NestedScrollNode", m14021f = "NestedScrollNode.kt", m14022i = {0, 0, 0, 1}, m14023l = {104, 105}, m14024m = "onPostFling-RZ2iAVY", m14025n = {"this", "consumed", "available", "selfConsumed"}, m14026s = {"L$0", "J$0", "J$1", "J$0"})
public final class NestedScrollNode$onPostFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedScrollNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollNode$onPostFling$1(NestedScrollNode nestedScrollNode, Continuation<? super NestedScrollNode$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = nestedScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo15655onPostFlingRZ2iAVY(0L, 0L, this);
    }
}
