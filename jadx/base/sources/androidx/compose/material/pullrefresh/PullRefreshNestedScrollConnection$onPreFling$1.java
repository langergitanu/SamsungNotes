package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection", m14021f = "PullRefresh.kt", m14022i = {}, m14023l = {108}, m14024m = "onPreFling-QWom1Mo", m14025n = {}, m14026s = {})
public final class PullRefreshNestedScrollConnection$onPreFling$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullRefreshNestedScrollConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshNestedScrollConnection$onPreFling$1(PullRefreshNestedScrollConnection pullRefreshNestedScrollConnection, Continuation<? super PullRefreshNestedScrollConnection$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = pullRefreshNestedScrollConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo15929onPreFlingQWom1Mo(0L, this);
    }
}
