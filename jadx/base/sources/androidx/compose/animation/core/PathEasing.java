package androidx.compose.animation.core;

import androidx.compose.p109ui.graphics.BezierKt;
import androidx.compose.p109ui.graphics.IntervalTree;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathIterator;
import androidx.compose.p109ui.graphics.PathSegment;
import androidx.compose.runtime.Immutable;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/compose/animation/core/PathEasing;", "Landroidx/compose/animation/core/Easing;", "path", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "intervals", "Landroidx/compose/ui/graphics/IntervalTree;", "Landroidx/compose/ui/graphics/PathSegment;", "initializeEasing", "", "transform", "", "fraction", "animation-core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPathEasing.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathEasing.kt\nandroidx/compose/animation/core/PathEasing\n+ 2 Preconditions.kt\nandroidx/compose/animation/core/PreconditionsKt\n+ 3 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n+ 4 PackingHelpers.jvm.kt\nandroidx/collection/internal/PackingHelpers_jvmKt\n*L\n1#1,120:1\n66#2,8:121\n54#2,7:129\n33#2,7:136\n33#2,7:146\n48#3:143\n54#3:145\n22#4:144\n*S KotlinDebug\n*F\n+ 1 PathEasing.kt\nandroidx/compose/animation/core/PathEasing\n*L\n72#1:121,8\n77#1:129,7\n101#1:136,7\n113#1:146,7\n108#1:143\n108#1:145\n108#1:144\n*E\n"})
public final class PathEasing implements Easing {
    public static final int $stable = 0;
    private IntervalTree<PathSegment> intervals;

    @NotNull
    private final Path path;

    public PathEasing(@NotNull Path path) {
        this.path = path;
    }

    private final void initializeEasing() {
        float[] fArr = new float[5];
        IntervalTree<PathSegment> intervalTree = new IntervalTree<>();
        PathIterator it = this.path.iterator(PathIterator.ConicEvaluation.AsQuadratics, 2.0E-4f);
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PathSegment next = it.next();
            if (!(next.getType() != PathSegment.Type.Close)) {
                PreconditionsKt.throwIllegalArgumentException("The path cannot contain a close() command.");
            }
            if (next.getType() != PathSegment.Type.Move && next.getType() != PathSegment.Type.Done) {
                long jComputeHorizontalBounds$default = BezierKt.computeHorizontalBounds$default(next, fArr, 0, 4, null);
                intervalTree.addInterval(Float.intBitsToFloat((int) (jComputeHorizontalBounds$default >> 32)), Float.intBitsToFloat((int) (jComputeHorizontalBounds$default & 4294967295L)), next);
            }
        }
        if (!(intervalTree.contains(0.0f) && intervalTree.contains(1.0f))) {
            PreconditionsKt.throwIllegalArgumentException("The easing path must start at 0.0f and end at 1.0f.");
        }
        this.intervals = intervalTree;
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        if (fraction <= 0.0f) {
            return 0.0f;
        }
        if (fraction >= 1.0f) {
            return 1.0f;
        }
        if (this.intervals == null) {
            initializeEasing();
        }
        IntervalTree<PathSegment> intervalTree = this.intervals;
        if (intervalTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intervals");
            intervalTree = null;
        }
        Object data = IntervalTree.findFirstOverlap$default(intervalTree, fraction, 0.0f, 2, null).getData();
        if (data == null) {
            PreconditionsKt.throwIllegalStateExceptionForNullCheck("The easing path is invalid. Make sure it is continuous on the x axis.");
            throw new KotlinNothingValueException();
        }
        PathSegment pathSegment = (PathSegment) data;
        float fFindFirstRoot = BezierKt.findFirstRoot(pathSegment, fraction);
        if (Float.isNaN(fFindFirstRoot)) {
            PreconditionsKt.throwIllegalStateException("The easing path is invalid. Make sure it does not contain NaN/Infinity values.");
        }
        return BezierKt.evaluateY(pathSegment, fFindFirstRoot);
    }
}
