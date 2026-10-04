package androidx.compose.foundation.contextmenu;

import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntOffsetKt;
import androidx.compose.p109ui.unit.IntRect;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.p109ui.window.PopupPositionProvider;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "localPosition", "Landroidx/compose/ui/unit/IntOffset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ContextMenuPopupPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final long localPosition;

    public /* synthetic */ ContextMenuPopupPositionProvider(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    @Override // androidx.compose.p109ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo15518calculatePositionllwVHH4(@NotNull IntRect anchorBounds, long windowSize, @NotNull LayoutDirection layoutDirection, long popupContentSize) {
        return IntOffsetKt.IntOffset(ContextMenuPopupPositionProvider_androidKt.alignPopupAxis(IntOffset.m21096getXimpl(this.localPosition) + anchorBounds.getLeft(), IntSize.m21138getWidthimpl(popupContentSize), IntSize.m21138getWidthimpl(windowSize), layoutDirection == LayoutDirection.Ltr), ContextMenuPopupPositionProvider_androidKt.alignPopupAxis$default(IntOffset.m21097getYimpl(this.localPosition) + anchorBounds.getTop(), IntSize.m21137getHeightimpl(popupContentSize), IntSize.m21137getHeightimpl(windowSize), false, 8, null));
    }

    private ContextMenuPopupPositionProvider(long j) {
        this.localPosition = j;
    }
}
