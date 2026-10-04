package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002 !B.\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0000¢\u0006\u0002\b\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "NestedPrefetchScopeImpl", "PrefetchHandle", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;

    @Nullable
    private final Function1<NestedPrefetchScope, Unit> onNestedPrefetch;

    @Nullable
    private PrefetchHandleProvider prefetchHandleProvider;

    @NotNull
    private final PrefetchMetrics prefetchMetrics;

    @Nullable
    private final PrefetchScheduler prefetchScheduler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;)V", "_requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "requests", "", "getRequests", "()Ljava/util/List;", "schedulePrefetch", "", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrefetch-0kLqBqw", "(IJ)V", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public final class NestedPrefetchScopeImpl implements NestedPrefetchScope {

        @NotNull
        private final List<PrefetchRequest> _requests = new ArrayList();

        public NestedPrefetchScopeImpl() {
        }

        @NotNull
        public final List<PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrefetch(int index) {
            mo16027schedulePrefetch0kLqBqw(index, LazyLayoutPrefetchStateKt.ZeroConstraints);
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        public void mo16027schedulePrefetch0kLqBqw(int index, long constraints) {
            PrefetchHandleProvider prefetchHandleProvider = LazyLayoutPrefetchState.this.getPrefetchHandleProvider();
            if (prefetchHandleProvider == null) {
                return;
            }
            this._requests.add(prefetchHandleProvider.m16038createNestedPrefetchRequestVKLhPVY(index, constraints, LazyLayoutPrefetchState.this.prefetchMetrics));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "markAsUrgent", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutPrefetchState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1<NestedPrefetchScope, Unit> function1 = this.onNestedPrefetch;
        if (function1 == null) {
            return CollectionsKt.emptyList();
        }
        NestedPrefetchScopeImpl nestedPrefetchScopeImpl = new NestedPrefetchScopeImpl();
        function1.invoke(nestedPrefetchScopeImpl);
        return nestedPrefetchScopeImpl.getRequests();
    }

    @Nullable
    /* JADX INFO: renamed from: getPrefetchHandleProvider$foundation_release, reason: from getter */
    public final PrefetchHandleProvider getPrefetchHandleProvider() {
        return this.prefetchHandleProvider;
    }

    @Nullable
    /* JADX INFO: renamed from: getPrefetchScheduler$foundation_release, reason: from getter */
    public final PrefetchScheduler getPrefetchScheduler() {
        return this.prefetchScheduler;
    }

    @NotNull
    public final PrefetchHandle schedulePrefetch(int index) {
        return m16026schedulePrefetch0kLqBqw(index, LazyLayoutPrefetchStateKt.ZeroConstraints);
    }

    @NotNull
    /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m16026schedulePrefetch0kLqBqw(int index, long constraints) {
        PrefetchHandle prefetchHandleM16039schedulePrefetchVKLhPVY;
        PrefetchHandleProvider prefetchHandleProvider = this.prefetchHandleProvider;
        return (prefetchHandleProvider == null || (prefetchHandleM16039schedulePrefetchVKLhPVY = prefetchHandleProvider.m16039schedulePrefetchVKLhPVY(index, constraints, this.prefetchMetrics)) == null) ? DummyHandle.INSTANCE : prefetchHandleM16039schedulePrefetchVKLhPVY;
    }

    public final void setPrefetchHandleProvider$foundation_release(@Nullable PrefetchHandleProvider prefetchHandleProvider) {
        this.prefetchHandleProvider = prefetchHandleProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutPrefetchState(@Nullable PrefetchScheduler prefetchScheduler, @Nullable Function1<? super NestedPrefetchScope, Unit> function1) {
        this.prefetchScheduler = prefetchScheduler;
        this.onNestedPrefetch = function1;
        this.prefetchMetrics = new PrefetchMetrics();
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : prefetchScheduler, (i & 2) != 0 ? null : function1);
    }
}
