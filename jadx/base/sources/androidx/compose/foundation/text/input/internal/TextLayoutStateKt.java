package androidx.compose.foundation.text.input.internal;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromDecorationToTextLayout", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", TypedValues.Cycle.S_WAVE_OFFSET, "fromDecorationToTextLayout-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromTextLayoutToCore", "fromTextLayoutToCore-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextLayoutState.kt\nandroidx/compose/foundation/text/input/internal/TextLayoutStateKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,252:1\n1#2:253\n*E\n"})
public final class TextLayoutStateKt {
    /* JADX INFO: renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m16389coerceIn3MmeM6k(long j, @NotNull Rect rect) {
        return OffsetKt.Offset(Offset.m18284getXimpl(j) < rect.getLeft() ? rect.getLeft() : Offset.m18284getXimpl(j) > rect.getRight() ? rect.getRight() : Offset.m18284getXimpl(j), Offset.m18285getYimpl(j) < rect.getTop() ? rect.getTop() : Offset.m18285getYimpl(j) > rect.getBottom() ? rect.getBottom() : Offset.m18285getYimpl(j));
    }

    /* JADX INFO: renamed from: fromDecorationToTextLayout-Uv8p0NA, reason: not valid java name */
    public static final long m16390fromDecorationToTextLayoutUv8p0NA(@NotNull TextLayoutState textLayoutState, long j) {
        Offset offsetM18273boximpl;
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
            if (decoratorNodeCoordinates != null) {
                offsetM18273boximpl = Offset.m18273boximpl((textLayoutNodeCoordinates.isAttached() && decoratorNodeCoordinates.isAttached()) ? textLayoutNodeCoordinates.mo19864localPositionOfR5De75A(decoratorNodeCoordinates, j) : j);
            } else {
                offsetM18273boximpl = null;
            }
            if (offsetM18273boximpl != null) {
                return offsetM18273boximpl.getPackedValue();
            }
        }
        return j;
    }

    /* JADX INFO: renamed from: fromTextLayoutToCore-Uv8p0NA, reason: not valid java name */
    public static final long m16391fromTextLayoutToCoreUv8p0NA(@NotNull TextLayoutState textLayoutState, long j) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            Offset offsetM18273boximpl = null;
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                LayoutCoordinates coreNodeCoordinates = textLayoutState.getCoreNodeCoordinates();
                if (coreNodeCoordinates != null) {
                    if (!coreNodeCoordinates.isAttached()) {
                        coreNodeCoordinates = null;
                    }
                    if (coreNodeCoordinates != null) {
                        offsetM18273boximpl = Offset.m18273boximpl(coreNodeCoordinates.mo19864localPositionOfR5De75A(textLayoutNodeCoordinates, j));
                    }
                }
                if (offsetM18273boximpl != null) {
                    return offsetM18273boximpl.getPackedValue();
                }
            }
        }
        return j;
    }

    /* JADX INFO: renamed from: fromWindowToDecoration-Uv8p0NA, reason: not valid java name */
    public static final long m16392fromWindowToDecorationUv8p0NA(@NotNull TextLayoutState textLayoutState, long j) {
        LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
        return (decoratorNodeCoordinates == null || !decoratorNodeCoordinates.isAttached()) ? j : decoratorNodeCoordinates.mo19872windowToLocalMKHz9U(j);
    }
}
