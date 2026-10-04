package androidx.compose.p109ui.graphics;

import android.graphics.Path;
import androidx.compose.p109ui.graphics.PathIterator;
import androidx.compose.p109ui.graphics.PathSegment;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.graphics.path.PathIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0002J\u0018\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/ui/graphics/AndroidPathIterator;", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "implementation", "Landroidx/graphics/path/PathIterator;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "segmentPoints", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment;", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", TypedValues.Cycle.S_WAVE_OFFSET, "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidPathIterator.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPathIterator.android.kt\nandroidx/compose/ui/graphics/AndroidPathIterator\n+ 2 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath_androidKt\n*L\n1#1,86:1\n38#2,5:87\n*S KotlinDebug\n*F\n+ 1 AndroidPathIterator.android.kt\nandroidx/compose/ui/graphics/AndroidPathIterator\n*L\n37#1:87,5\n*E\n"})
final class AndroidPathIterator implements PathIterator {

    @NotNull
    private final PathIterator.ConicEvaluation conicEvaluation;

    @NotNull
    private final androidx.graphics.path.PathIterator implementation;

    @NotNull
    private final Path path;

    @NotNull
    private final float[] segmentPoints = new float[8];
    private final float tolerance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PathIterator.ConicEvaluation.values().length];
            try {
                iArr[PathIterator.ConicEvaluation.AsConic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathIterator.ConicEvaluation.AsQuadratics.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PathSegment.Type.values().length];
            try {
                iArr2[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PathSegment.Type.Conic.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PathSegment.Type.Cubic.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AndroidPathIterator(@NotNull Path path, @NotNull PathIterator.ConicEvaluation conicEvaluation, float f) {
        PathIterator.ConicEvaluation conicEvaluation2;
        this.path = path;
        this.conicEvaluation = conicEvaluation;
        this.tolerance = f;
        Path path2 = getPath();
        if (!(path2 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path internalPath = ((AndroidPath) path2).getInternalPath();
        int i = WhenMappings.$EnumSwitchMapping$0[getConicEvaluation().ordinal()];
        if (i == 1) {
            conicEvaluation2 = PathIterator.ConicEvaluation.AsConic;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            conicEvaluation2 = PathIterator.ConicEvaluation.AsQuadratics;
        }
        this.implementation = new androidx.graphics.path.PathIterator(internalPath, conicEvaluation2, getTolerance());
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator
    public int calculateSize(boolean includeConvertedConics) {
        return this.implementation.calculateSize(includeConvertedConics);
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator
    @NotNull
    public PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator
    @NotNull
    public Path getPath() {
        return this.path;
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator
    public float getTolerance() {
        return this.tolerance;
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator, java.util.Iterator
    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // androidx.compose.p109ui.graphics.PathIterator
    @NotNull
    public PathSegment.Type next(@NotNull float[] outPoints, int offset) {
        return AndroidPathIterator_androidKt.toPathSegmentType(this.implementation.next(outPoints, offset));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    @Override // java.util.Iterator
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PathSegment next() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3 = this.segmentPoints;
        PathSegment.Type pathSegmentType = AndroidPathIterator_androidKt.toPathSegmentType(this.implementation.next(fArr3, 0));
        if (pathSegmentType == PathSegment.Type.Done) {
            return PathSegmentKt.getDoneSegment();
        }
        if (pathSegmentType == PathSegment.Type.Close) {
            return PathSegmentKt.getCloseSegment();
        }
        int i = WhenMappings.$EnumSwitchMapping$1[pathSegmentType.ordinal()];
        if (i == 1) {
            fArr = new float[]{fArr3[0], fArr3[1]};
        } else if (i == 2) {
            fArr = new float[]{fArr3[0], fArr3[1], fArr3[2], fArr3[3]};
        } else if (i == 3 || i == 4) {
            fArr = new float[]{fArr3[0], fArr3[1], fArr3[2], fArr3[3], fArr3[4], fArr3[5]};
        } else {
            if (i != 5) {
                fArr2 = new float[0];
                return new PathSegment(pathSegmentType, fArr2, pathSegmentType != PathSegment.Type.Conic ? fArr3[6] : 0.0f);
            }
            fArr = new float[]{fArr3[0], fArr3[1], fArr3[2], fArr3[3], fArr3[4], fArr3[5], fArr3[6], fArr3[7]};
        }
        fArr2 = fArr;
        return new PathSegment(pathSegmentType, fArr2, pathSegmentType != PathSegment.Type.Conic ? fArr3[6] : 0.0f);
    }
}
