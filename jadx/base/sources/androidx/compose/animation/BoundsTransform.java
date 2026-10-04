package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p109ui.geometry.Rect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalSharedTransitionApi
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/animation/BoundsTransform;", "", "transform", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/geometry/Rect;", "initialBounds", "targetBounds", "animation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface BoundsTransform {
    @NotNull
    FiniteAnimationSpec<Rect> transform(@NotNull Rect initialBounds, @NotNull Rect targetBounds);
}
