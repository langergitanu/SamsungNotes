package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p109ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "mainAxisItemSpacing", "getMainAxisItemSpacing", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface LazyListLayoutInfo {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int getAfterContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.getAfterContentPadding();
        }

        @Deprecated
        public static int getBeforeContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.getBeforeContentPadding();
        }

        @Deprecated
        public static int getMainAxisItemSpacing(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.getMainAxisItemSpacing();
        }

        @Deprecated
        @NotNull
        public static Orientation getOrientation(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.getOrientation();
        }

        @Deprecated
        public static boolean getReverseLayout(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.getReverseLayout();
        }

        @Deprecated
        /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
        public static long m15960getViewportSizeYbymL2g(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
            return LazyListLayoutInfo.super.mo15959getViewportSizeYbymL2g();
        }
    }

    default int getAfterContentPadding() {
        return 0;
    }

    default int getBeforeContentPadding() {
        return 0;
    }

    default int getMainAxisItemSpacing() {
        return 0;
    }

    @NotNull
    default Orientation getOrientation() {
        return Orientation.Vertical;
    }

    default boolean getReverseLayout() {
        return false;
    }

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    default long mo15959getViewportSizeYbymL2g() {
        return IntSize.INSTANCE.m21143getZeroYbymL2g();
    }

    int getViewportStartOffset();

    @NotNull
    List<LazyListItemInfo> getVisibleItemsInfo();
}
