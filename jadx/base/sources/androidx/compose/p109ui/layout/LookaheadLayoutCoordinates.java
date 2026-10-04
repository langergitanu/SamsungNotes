package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.internal.InlineClassHelperKt;
import androidx.compose.p109ui.node.LookaheadDelegate;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0096\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\nH\u0016J\"\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001a\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001a\u00103\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00102J\u001a\u00105\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b6\u00102J\u001a\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u00102J\"\u0010:\u001a\u00020;2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010@\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\bE\u00102R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, m13886d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "getLookaheadOffset-F1C5BW0", "()J", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLookaheadLayoutCoordinates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LookaheadLayoutCoordinates.kt\nandroidx/compose/ui/layout/LookaheadLayoutCoordinates\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/internal/InlineClassHelperKt\n+ 4 IntOffset.kt\nandroidx/compose/ui/unit/IntOffsetKt\n*L\n1#1,187:1\n1#2:188\n42#3,7:189\n42#3,7:196\n176#4:203\n176#4:204\n*S KotlinDebug\n*F\n+ 1 LookaheadLayoutCoordinates.kt\nandroidx/compose/ui/layout/LookaheadLayoutCoordinates\n*L\n44#1:189,7\n51#1:196,7\n113#1:203\n129#1:204\n*E\n"})
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public static final int $stable = 0;

    @NotNull
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(@NotNull LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    private final long m19882getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        LayoutCoordinates coordinates = rootLookaheadDelegate.getCoordinates();
        Offset.Companion companion = Offset.INSTANCE;
        return Offset.m18288minusMKHz9U(mo19864localPositionOfR5De75A(coordinates, companion.m18300getZeroF1C5BW0()), getCoordinator().mo19864localPositionOfR5De75A(rootLookaheadDelegate.getCoordinator(), companion.m18300getZeroF1C5BW0()));
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    public int get(@NotNull AlignmentLine alignmentLine) {
        return this.lookaheadDelegate.get(alignmentLine);
    }

    @NotNull
    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    public boolean getIntroducesMotionFrameOfReference() {
        return this.lookaheadDelegate.getIsPlacedUnderMotionFrameOfReference();
    }

    @NotNull
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    @Nullable
    public LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy = getCoordinator().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    @Nullable
    public LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalStateException(NodeCoordinator.ExpectAttachedLayoutCoordinates);
        }
        NodeCoordinator wrappedBy = getCoordinator().getLayoutNode().getOuterCoordinator$ui_release().getWrappedBy();
        if (wrappedBy == null || (lookaheadDelegate = wrappedBy.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.getCoordinates();
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo19863getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo19864localPositionOfR5De75A(@NotNull LayoutCoordinates sourceCoordinates, long relativeToSource) {
        return mo19865localPositionOfS_NoaFU(sourceCoordinates, relativeToSource, true);
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public long mo19865localPositionOfS_NoaFU(@NotNull LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        if (!(sourceCoordinates instanceof LookaheadLayoutCoordinates)) {
            LookaheadDelegate rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
            return Offset.m18289plusMKHz9U(mo19865localPositionOfS_NoaFU(rootLookaheadDelegate.getLookaheadLayoutCoordinates(), relativeToSource, includeMotionFrameOfReference), rootLookaheadDelegate.getCoordinator().getCoordinates().mo19865localPositionOfS_NoaFU(sourceCoordinates, Offset.INSTANCE.m18300getZeroF1C5BW0(), includeMotionFrameOfReference));
        }
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinates) sourceCoordinates).lookaheadDelegate;
        lookaheadDelegate.getCoordinator().onCoordinatesUsed$ui_release();
        LookaheadDelegate lookaheadDelegate2 = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            long jM21099minusqkQi6aY = IntOffset.m21099minusqkQi6aY(IntOffset.m21100plusqkQi6aY(lookaheadDelegate.m20040positionIniSbpLlY$ui_release(lookaheadDelegate2, !includeMotionFrameOfReference), IntOffsetKt.m21112roundk4lQ0M(relativeToSource)), this.lookaheadDelegate.m20040positionIniSbpLlY$ui_release(lookaheadDelegate2, !includeMotionFrameOfReference));
            return OffsetKt.Offset(IntOffset.m21096getXimpl(jM21099minusqkQi6aY), IntOffset.m21097getYimpl(jM21099minusqkQi6aY));
        }
        LookaheadDelegate rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
        long jM21100plusqkQi6aY = IntOffset.m21100plusqkQi6aY(IntOffset.m21100plusqkQi6aY(lookaheadDelegate.m20040positionIniSbpLlY$ui_release(rootLookaheadDelegate2, !includeMotionFrameOfReference), rootLookaheadDelegate2.getPosition()), IntOffsetKt.m21112roundk4lQ0M(relativeToSource));
        LookaheadDelegate rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        long jM21099minusqkQi6aY2 = IntOffset.m21099minusqkQi6aY(jM21100plusqkQi6aY, IntOffset.m21100plusqkQi6aY(this.lookaheadDelegate.m20040positionIniSbpLlY$ui_release(rootLookaheadDelegate3, !includeMotionFrameOfReference), rootLookaheadDelegate3.getPosition()));
        long jOffset = OffsetKt.Offset(IntOffset.m21096getXimpl(jM21099minusqkQi6aY2), IntOffset.m21097getYimpl(jM21099minusqkQi6aY2));
        NodeCoordinator wrappedBy = rootLookaheadDelegate3.getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy);
        NodeCoordinator wrappedBy2 = rootLookaheadDelegate2.getCoordinator().getWrappedBy();
        Intrinsics.checkNotNull(wrappedBy2);
        return wrappedBy.mo19865localPositionOfS_NoaFU(wrappedBy2, jOffset, includeMotionFrameOfReference);
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo19866localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().mo19866localToRootMKHz9U(Offset.m18289plusMKHz9U(relativeToLocal, m19882getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo19867localToScreenMKHz9U(long relativeToLocal) {
        return getCoordinator().mo19867localToScreenMKHz9U(Offset.m18289plusMKHz9U(relativeToLocal, m19882getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo19868localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().mo19868localToWindowMKHz9U(Offset.m18289plusMKHz9U(relativeToLocal, m19882getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo19869screenToLocalMKHz9U(long relativeToScreen) {
        return Offset.m18289plusMKHz9U(getCoordinator().mo19869screenToLocalMKHz9U(relativeToScreen), m19882getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo19870transformFromEL8BTi8(@NotNull LayoutCoordinates sourceCoordinates, @NotNull float[] matrix) {
        getCoordinator().mo19870transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public void mo19871transformToScreen58bKbWc(@NotNull float[] matrix) {
        getCoordinator().mo19871transformToScreen58bKbWc(matrix);
    }

    @Override // androidx.compose.p109ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo19872windowToLocalMKHz9U(long relativeToWindow) {
        return Offset.m18289plusMKHz9U(getCoordinator().mo19872windowToLocalMKHz9U(relativeToWindow), m19882getLookaheadOffsetF1C5BW0());
    }
}
