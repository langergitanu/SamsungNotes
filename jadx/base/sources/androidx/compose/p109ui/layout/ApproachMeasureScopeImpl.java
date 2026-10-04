package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.layout.Placeable;
import androidx.compose.p109ui.node.LayoutModifierNodeCoordinator;
import androidx.compose.p109ui.node.LayoutNode;
import androidx.compose.p109ui.node.LookaheadDelegate;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.unit.Constraints;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ`\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/022\u0019\u00104\u001a\u0015\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207\u0018\u000105¢\u0006\u0002\b82\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020705¢\u0006\u0002\b8H\u0016JH\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020/022\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020705¢\u0006\u0002\b8H\u0096\u0001J\u0017\u0010:\u001a\u00020/*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0017\u0010:\u001a\u00020/*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020;*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010A\u001a\u00020;*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010A\u001a\u00020;*\u00020/H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010FJ\u0017\u0010G\u001a\u00020H*\u00020IH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\f\u0010L\u001a\u00020(*\u00020(H\u0016J\u0017\u0010M\u001a\u00020\u0016*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010EJ\u0017\u0010M\u001a\u00020\u0016*\u00020>H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010CJ\r\u0010P\u001a\u00020Q*\u00020RH\u0097\u0001J\u0017\u0010S\u001a\u00020I*\u00020HH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010KJ\u0017\u0010U\u001a\u00020>*\u00020;H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001a\u0010U\u001a\u00020>*\u00020/H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\fR\u0012\u0010\u001c\u001a\u00020\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0018\u0010'\u001a\u00020(*\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, m13886d2 = {"Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "coordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "approachNode", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "approachMeasureRequired", "", "getApproachMeasureRequired$ui_release", "()Z", "setApproachMeasureRequired$ui_release", "(Z)V", "getApproachNode", "()Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "setApproachNode", "(Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", "getCoordinator", "()Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", DBSchema.DocumentThumbnail.LAYOUT, "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toLookaheadCoordinates", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nApproachMeasureScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApproachMeasureScope.kt\nandroidx/compose/ui/layout/ApproachMeasureScopeImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LookaheadDelegate.kt\nandroidx/compose/ui/node/LookaheadDelegateKt\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n*L\n1#1,120:1\n1#2:121\n341#3:122\n342#3:128\n345#3:130\n42#4,5:123\n48#4:129\n*S KotlinDebug\n*F\n+ 1 ApproachMeasureScope.kt\nandroidx/compose/ui/layout/ApproachMeasureScopeImpl\n*L\n102#1:122\n102#1:128\n102#1:130\n102#1:123,5\n102#1:129\n*E\n"})
public final class ApproachMeasureScopeImpl implements ApproachMeasureScope, MeasureScope, LookaheadScope {
    public static final int $stable = 0;
    private boolean approachMeasureRequired;

    @NotNull
    private ApproachLayoutModifierNode approachNode;

    @NotNull
    private final LayoutModifierNodeCoordinator coordinator;

    public ApproachMeasureScopeImpl(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, @NotNull ApproachLayoutModifierNode approachLayoutModifierNode) {
        this.coordinator = layoutModifierNodeCoordinator;
        this.approachNode = approachLayoutModifierNode;
    }

    /* JADX INFO: renamed from: getApproachMeasureRequired$ui_release, reason: from getter */
    public final boolean getApproachMeasureRequired() {
        return this.approachMeasureRequired;
    }

    @NotNull
    public final ApproachLayoutModifierNode getApproachNode() {
        return this.approachNode;
    }

    @NotNull
    public final LayoutModifierNodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    @Override // androidx.compose.p109ui.unit.Density
    public float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.p109ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @Override // androidx.compose.p109ui.layout.ApproachIntrinsicMeasureScope
    /* JADX INFO: renamed from: getLookaheadConstraints-msEJaDk */
    public long mo19829getLookaheadConstraintsmsEJaDk() {
        Constraints lookaheadConstraints = this.coordinator.getLookaheadConstraints();
        if (lookaheadConstraints != null) {
            return lookaheadConstraints.getValue();
        }
        throw new IllegalArgumentException("Error: Lookahead constraints requested before lookahead measure.");
    }

    @Override // androidx.compose.p109ui.layout.LookaheadScope
    @NotNull
    public LayoutCoordinates getLookaheadScopeCoordinates(@NotNull Placeable.PlacementScope placementScope) {
        NodeCoordinator innerCoordinator$ui_release;
        LayoutNode lookaheadRoot = this.coordinator.getLayoutNode().getLookaheadRoot();
        if (lookaheadRoot == null) {
            throw new IllegalArgumentException("Error: Requesting LookaheadScopeCoordinates is not permitted from outside of a LookaheadScope.");
        }
        if (!lookaheadRoot.getIsVirtualLookaheadRoot()) {
            return lookaheadRoot.getOuterCoordinator$ui_release();
        }
        LayoutNode parent$ui_release = lookaheadRoot.getParent$ui_release();
        return (parent$ui_release == null || (innerCoordinator$ui_release = parent$ui_release.getInnerCoordinator$ui_release()) == null) ? lookaheadRoot.getChildren$ui_release().get(0).getOuterCoordinator$ui_release() : innerCoordinator$ui_release;
    }

    @Override // androidx.compose.p109ui.layout.ApproachIntrinsicMeasureScope
    /* JADX INFO: renamed from: getLookaheadSize-YbymL2g */
    public long mo19830getLookaheadSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.coordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        MeasureResult measureResult$ui_release = lookaheadDelegate.getMeasureResult$ui_release();
        return IntSizeKt.IntSize(measureResult$ui_release.getWidth(), measureResult$ui_release.getHeight());
    }

    @Override // androidx.compose.p109ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.p109ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(int width, int height, @NotNull Map<AlignmentLine, Integer> alignmentLines, @NotNull Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return this.coordinator.layout(width, height, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo15539roundToPxR2X_6o(long j) {
        return this.coordinator.mo15539roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo15540roundToPx0680j_4(float f) {
        return this.coordinator.mo15540roundToPx0680j_4(f);
    }

    public final void setApproachMeasureRequired$ui_release(boolean z) {
        this.approachMeasureRequired = z;
    }

    public final void setApproachNode(@NotNull ApproachLayoutModifierNode approachLayoutModifierNode) {
        this.approachNode = approachLayoutModifierNode;
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo15541toDpGaN1DYA(long j) {
        return this.coordinator.mo15541toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15542toDpu2uoSUM(float f) {
        return this.coordinator.mo15542toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo15544toDpSizekrfVVM(long j) {
        return this.coordinator.mo15544toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p109ui.layout.LookaheadScope
    @NotNull
    public LayoutCoordinates toLookaheadCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates;
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            return layoutCoordinates;
        }
        if (layoutCoordinates instanceof NodeCoordinator) {
            LookaheadDelegate lookaheadDelegate = ((NodeCoordinator) layoutCoordinates).getLookaheadDelegate();
            return (lookaheadDelegate == null || (lookaheadLayoutCoordinates = lookaheadDelegate.getLookaheadLayoutCoordinates()) == null) ? layoutCoordinates : lookaheadLayoutCoordinates;
        }
        throw new IllegalArgumentException("Unsupported LayoutCoordinates: " + layoutCoordinates);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo15545toPxR2X_6o(long j) {
        return this.coordinator.mo15545toPxR2X_6o(j);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo15546toPx0680j_4(float f) {
        return this.coordinator.mo15546toPx0680j_4(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        return this.coordinator.toRect(dpRect);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo15547toSizeXkaWNTQ(long j) {
        return this.coordinator.mo15547toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p109ui.unit.FontScaling
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo15548toSp0xMU5do(float f) {
        return this.coordinator.mo15548toSp0xMU5do(f);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15549toSpkPz2Gy4(float f) {
        return this.coordinator.mo15549toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p109ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(int width, int height, @NotNull Map<AlignmentLine, Integer> alignmentLines, @Nullable Function1<? super RulerScope, Unit> rulers, @NotNull Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(width, height, alignmentLines, rulers, placementBlock, this) { // from class: androidx.compose.ui.layout.ApproachMeasureScopeImpl.layout.1
            final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;

            @NotNull
            private final Map<AlignmentLine, Integer> alignmentLines;
            private final int height;

            @Nullable
            private final Function1<RulerScope, Unit> rulers;
            final /* synthetic */ ApproachMeasureScopeImpl this$0;
            private final int width;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$placementBlock = placementBlock;
                this.this$0 = this;
                this.width = width;
                this.height = height;
                this.alignmentLines = alignmentLines;
                this.rulers = rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            @Nullable
            public Function1<RulerScope, Unit> getRulers() {
                return this.rulers;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.p109ui.layout.MeasureResult
            public void placeChildren() {
                this.$placementBlock.invoke(this.this$0.getCoordinator().getPlacementScope());
            }

            public static /* synthetic */ void getAlignmentLines$annotations() {
            }
        };
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo15543toDpu2uoSUM(int i) {
        return this.coordinator.mo15543toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p109ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo15550toSpkPz2Gy4(int i) {
        return this.coordinator.mo15550toSpkPz2Gy4(i);
    }
}
