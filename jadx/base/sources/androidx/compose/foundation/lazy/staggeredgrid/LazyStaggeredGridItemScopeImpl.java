package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemElement;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScopeImpl;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "()V", "animateItem", "Landroidx/compose/ui/Modifier;", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "fadeOutSpec", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyStaggeredGridItemScopeImpl implements LazyStaggeredGridItemScope {
    public static final int $stable = 0;

    @NotNull
    public static final LazyStaggeredGridItemScopeImpl INSTANCE = new LazyStaggeredGridItemScopeImpl();

    private LazyStaggeredGridItemScopeImpl() {
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
    @NotNull
    public Modifier animateItem(@NotNull Modifier modifier, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec, @Nullable FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, @Nullable FiniteAnimationSpec<Float> finiteAnimationSpec3) {
        return (finiteAnimationSpec == null && finiteAnimationSpec2 == null && finiteAnimationSpec3 == null) ? modifier : modifier.then(new LazyLayoutAnimateItemElement(finiteAnimationSpec, finiteAnimationSpec2, finiteAnimationSpec3));
    }
}
