package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.node.NodeCoordinator;
import androidx.compose.p109ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b\u001a\u000f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\b¨\u0006\f"}, m13886d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "positionOnScreen", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLayoutCoordinates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutCoordinates.kt\nandroidx/compose/ui/layout/LayoutCoordinatesKt\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n*L\n1#1,293:1\n71#2,16:294\n71#2,16:310\n71#2,16:326\n71#2,16:342\n49#2:358\n60#2:359\n49#2:360\n60#2:361\n*S KotlinDebug\n*F\n+ 1 LayoutCoordinates.kt\nandroidx/compose/ui/layout/LayoutCoordinatesKt\n*L\n223#1:294,16\n224#1:310,16\n225#1:326,16\n226#1:342,16\n242#1:358\n243#1:359\n250#1:360\n251#1:361\n*E\n"})
public final class LayoutCoordinatesKt {
    @NotNull
    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m21138getWidthimpl(layoutCoordinates.mo19863getSizeYbymL2g()), IntSize.m21137getHeightimpl(layoutCoordinates.mo19863getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    @NotNull
    public static final Rect boundsInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    @NotNull
    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fM21138getWidthimpl = IntSize.m21138getWidthimpl(layoutCoordinatesFindRootCoordinates.mo19863getSizeYbymL2g());
        float fM21137getHeightimpl = IntSize.m21137getHeightimpl(layoutCoordinatesFindRootCoordinates.mo19863getSizeYbymL2g());
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float left = rectBoundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM21138getWidthimpl) {
            left = fM21138getWidthimpl;
        }
        float top = rectBoundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM21137getHeightimpl) {
            top = fM21137getHeightimpl;
        }
        float right = rectBoundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM21138getWidthimpl) {
            fM21138getWidthimpl = right;
        }
        float bottom = rectBoundsInRoot.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM21137getHeightimpl) {
            fM21137getHeightimpl = f;
        }
        if (left == fM21138getWidthimpl || top == fM21137getHeightimpl) {
            return Rect.INSTANCE.getZero();
        }
        long jMo19868localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo19868localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo19868localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo19868localToWindowMKHz9U(OffsetKt.Offset(fM21138getWidthimpl, top));
        long jMo19868localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo19868localToWindowMKHz9U(OffsetKt.Offset(fM21138getWidthimpl, fM21137getHeightimpl));
        long jMo19868localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo19868localToWindowMKHz9U(OffsetKt.Offset(left, fM21137getHeightimpl));
        float fM18284getXimpl = Offset.m18284getXimpl(jMo19868localToWindowMKHz9U);
        float fM18284getXimpl2 = Offset.m18284getXimpl(jMo19868localToWindowMKHz9U2);
        float fM18284getXimpl3 = Offset.m18284getXimpl(jMo19868localToWindowMKHz9U4);
        float fM18284getXimpl4 = Offset.m18284getXimpl(jMo19868localToWindowMKHz9U3);
        float fMin = Math.min(fM18284getXimpl, Math.min(fM18284getXimpl2, Math.min(fM18284getXimpl3, fM18284getXimpl4)));
        float fMax = Math.max(fM18284getXimpl, Math.max(fM18284getXimpl2, Math.max(fM18284getXimpl3, fM18284getXimpl4)));
        float fM18285getYimpl = Offset.m18285getYimpl(jMo19868localToWindowMKHz9U);
        float fM18285getYimpl2 = Offset.m18285getYimpl(jMo19868localToWindowMKHz9U2);
        float fM18285getYimpl3 = Offset.m18285getYimpl(jMo19868localToWindowMKHz9U4);
        float fM18285getYimpl4 = Offset.m18285getYimpl(jMo19868localToWindowMKHz9U3);
        return new Rect(fMin, Math.min(fM18285getYimpl, Math.min(fM18285getYimpl2, Math.min(fM18285getYimpl3, fM18285getYimpl4))), fMax, Math.max(fM18285getYimpl, Math.max(fM18285getYimpl2, Math.max(fM18285getYimpl3, fM18285getYimpl4))));
    }

    @NotNull
    public static final LayoutCoordinates findRootCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy = nodeCoordinator.getWrappedBy();
        }
    }

    public static final long positionInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo19864localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m18300getZeroF1C5BW0()) : Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo19866localToRootMKHz9U(Offset.INSTANCE.m18300getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo19868localToWindowMKHz9U(Offset.INSTANCE.m18300getZeroF1C5BW0());
    }

    public static final long positionOnScreen(@NotNull LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo19867localToScreenMKHz9U(Offset.INSTANCE.m18300getZeroF1C5BW0());
    }
}
