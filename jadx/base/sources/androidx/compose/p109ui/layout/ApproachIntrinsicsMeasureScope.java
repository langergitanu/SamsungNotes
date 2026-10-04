package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001c0\u001f2\u0019\u0010!\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0\"¢\u0006\u0002\b%H\u0016J\u0017\u0010(\u001a\u00020\u001c*\u00020)H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0017\u0010(\u001a\u00020\u001c*\u00020,H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020)*\u00020,H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u0010/\u001a\u00020)*\u00020\bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001a\u0010/\u001a\u00020)*\u00020\u001cH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00104J\u0017\u00105\u001a\u000206*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\b*\u00020)H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b;\u00103J\u0017\u0010:\u001a\u00020\b*\u00020,H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b<\u00101J\r\u0010=\u001a\u00020>*\u00020?H\u0097\u0001J\u0017\u0010@\u001a\u000207*\u000206H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bA\u00109J\u0017\u0010B\u001a\u00020,*\u00020)H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001a\u0010B\u001a\u00020,*\u00020\bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010DJ\u001a\u0010B\u001a\u00020,*\u00020\u001cH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u0014\u0010\u0007\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013X\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017X\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m13886d2 = {"Landroidx/compose/ui/layout/ApproachIntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;", "intrinsicMeasureScope", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/ui/layout/ApproachIntrinsicMeasureScope;Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Layout.kt\nandroidx/compose/ui/layout/ApproachIntrinsicsMeasureScope\n+ 2 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadDelegateKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,427:1\n341#2:428\n342#2:434\n345#2:436\n42#3,5:429\n48#3:435\n*S KotlinDebug\n*F\n+ 1 Layout.kt\nandroidx/compose/ui/layout/ApproachIntrinsicsMeasureScope\n*L\n410#1:428\n410#1:434\n410#1:436\n410#1:429,5\n410#1:435\n*E\n"})
public final class ApproachIntrinsicsMeasureScope implements ApproachMeasureScope, ApproachIntrinsicMeasureScope {
    public static final int $stable = 0;
    private final /* synthetic */ ApproachIntrinsicMeasureScope $$delegate_0;

    @NotNull
    private final LayoutDirection layoutDirection;

    public ApproachIntrinsicsMeasureScope(@NotNull ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, @NotNull LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
        this.$$delegate_0 = approachIntrinsicMeasureScope;
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p109ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.p109ui.layout.ApproachIntrinsicMeasureScope
    /* JADX INFO: renamed from: getLookaheadConstraints-msEJaDk */
    public long mo19829getLookaheadConstraintsmsEJaDk() {
        return this.$$delegate_0.mo19829getLookaheadConstraintsmsEJaDk();
    }

    @Override // androidx.compose.p109ui.layout.ApproachIntrinsicMeasureScope
    /* JADX INFO: renamed from: getLookaheadSize-YbymL2g */
    public long mo19830getLookaheadSizeYbymL2g() {
        return this.$$delegate_0.mo19830getLookaheadSizeYbymL2g();
    }

    @Override // androidx.compose.p109ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return this.$$delegate_0.isLookingAhead();
    }

    @Override // androidx.compose.p109ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(int width, int height, @NotNull final Map<AlignmentLine, Integer> alignmentLines, @Nullable final Function1<? super RulerScope, Unit> rulers, @NotNull Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        boolean z = false;
        final int iCoerceAtLeast = RangesKt.coerceAtLeast(width, 0);
        final int iCoerceAtLeast2 = RangesKt.coerceAtLeast(height, 0);
        if ((iCoerceAtLeast & (-16777216)) == 0 && ((-16777216) & iCoerceAtLeast2) == 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + iCoerceAtLeast + " x " + iCoerceAtLeast2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.layout.ApproachIntrinsicsMeasureScope.layout.1
            @Override // androidx.compose.p109ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            /* JADX INFO: renamed from: getHeight, reason: from getter */
            public int getF1178$h() {
                return iCoerceAtLeast2;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @Nullable
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            /* JADX INFO: renamed from: getWidth, reason: from getter */
            public int getF1179$w() {
                return iCoerceAtLeast;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public void placeChildren() {
            }
        };
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo15539roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo15539roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo15540roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo15540roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo15541toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo15541toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15542toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo15542toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo15544toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo15544toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo15545toPxR2X_6o(long j) {
        return this.$$delegate_0.mo15545toPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo15546toPx0680j_4(float f) {
        return this.$$delegate_0.mo15546toPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo15547toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo15547toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo15548toSp0xMU5do(float f) {
        return this.$$delegate_0.mo15548toSp0xMU5do(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15549toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo15549toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15543toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo15543toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15550toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo15550toSpkPz2Gy4(i);
    }
}
