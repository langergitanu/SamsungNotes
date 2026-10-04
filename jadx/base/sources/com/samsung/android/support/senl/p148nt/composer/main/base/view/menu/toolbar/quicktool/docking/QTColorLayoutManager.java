package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.view.View;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorRecycleView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J&\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0014\u0010#\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\bJ\u0016\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020 J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020 2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u00100\u001a\u00020\rH\u0002J\u0006\u00102\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "radius", "", "<init>", "(F)V", "mStartAngle", "mScrollDirection", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView$ScrollDirection;", "mTotalItemCount", "", "mTotalItemVisible", "mAnglePerPixel", "", "mAngleStep", "mScrollAngleOffset", "mFirstItemAngleOffset", "mFirstVisibleItemPos", "mDividerIdxSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "close", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "canScrollHorizontally", "", "scrollHorizontallyBy", "dx", "setDialItems", "items", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "setScrollDirection", "direction", "getScrollDistance", "distance", "isLeftToRight", "setFirstVisibleItemPosition", "visibleItemPos", "needLayoutChildren", "updateScrollAngleOffset", "angle", "updateFirstVisibleItem", "getFirstVisiblePosition", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTColorLayoutManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTColorLayoutManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorLayoutManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,211:1\n1878#2,3:212\n*S KotlinDebug\n*F\n+ 1 QTColorLayoutManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorLayoutManager\n*L\n93#1:212,3\n*E\n"})
public final class QTColorLayoutManager extends RecyclerView.LayoutManager {
    private static final int MAX_ITEMS_VISIBLE = 24;

    @NotNull
    private static final String TAG = "QTColorLayoutManager";
    private final double mAnglePerPixel;
    private double mAngleStep;

    @Nullable
    private HashSet<Integer> mDividerIdxSet;
    private double mFirstItemAngleOffset;
    private int mFirstVisibleItemPos;
    private double mScrollAngleOffset;
    private int mTotalItemCount;
    private int mTotalItemVisible;
    private final float radius;
    private final float mStartAngle = 300.0f;

    @NotNull
    private QTColorRecycleView.ScrollDirection mScrollDirection = QTColorRecycleView.ScrollDirection.DIR_NONE;

    public QTColorLayoutManager(float f) {
        this.radius = f;
        this.mAnglePerPixel = 360.0d / (((double) f) * 6.283185307179586d);
    }

    private final boolean needLayoutChildren(int dx) {
        QTColorRecycleView.ScrollDirection scrollDirection;
        if (dx == 0 || (scrollDirection = this.mScrollDirection) == QTColorRecycleView.ScrollDirection.DIR_NONE) {
            return false;
        }
        if (scrollDirection != QTColorRecycleView.ScrollDirection.DIR_RIGHT_TO_LEFT || dx >= 0) {
            return scrollDirection != QTColorRecycleView.ScrollDirection.DIR_LEFT_TO_RIGHT || dx <= 0;
        }
        return false;
    }

    private final void updateFirstVisibleItem(double angle) {
        int i = this.mTotalItemCount;
        if (i == 0) {
            return;
        }
        double d = this.mFirstItemAngleOffset + angle;
        this.mFirstItemAngleOffset = d;
        double d2 = this.mAngleStep;
        if (d < d2) {
            if (d <= (-d2)) {
                int i2 = (int) (d / d2);
                this.mFirstItemAngleOffset = d % d2;
                this.mFirstVisibleItemPos = (this.mFirstVisibleItemPos - i2) % i;
                this.mScrollAngleOffset -= d2 * ((double) i2);
                return;
            }
            return;
        }
        int i4 = (int) (d / d2);
        this.mFirstItemAngleOffset = d % d2;
        int i5 = (this.mFirstVisibleItemPos - i4) % i;
        this.mFirstVisibleItemPos = i5;
        if (i5 < 0) {
            this.mFirstVisibleItemPos = i5 + i;
        }
        this.mScrollAngleOffset -= d2 * ((double) i4);
    }

    private final void updateScrollAngleOffset(double angle) {
        double d = this.mScrollAngleOffset + angle;
        this.mScrollAngleOffset = d;
        if (d < 0.0d) {
            this.mScrollAngleOffset = d + 360.0d;
        } else {
            this.mScrollAngleOffset = d % 360.0d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    public final void close() {
        this.mDividerIdxSet = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* JADX INFO: renamed from: getFirstVisiblePosition, reason: from getter */
    public final int getMFirstVisibleItemPos() {
        return this.mFirstVisibleItemPos;
    }

    public final int getScrollDistance(double distance, boolean isLeftToRight) {
        double d;
        int i = 0;
        double d2 = 0.0d;
        if (isLeftToRight) {
            double d3 = this.mScrollAngleOffset - (distance * this.mAnglePerPixel);
            double d4 = PopOverActivityWrapper.DEFAULT_WIDTH;
            int i2 = (int) (d3 / d4);
            if (i2 < 0) {
                i2 *= -1;
            }
            while (d3 < 0.0d) {
                d3 += 360.0d;
            }
            int i4 = this.mTotalItemVisible;
            while (true) {
                if (i >= i4) {
                    break;
                }
                double d5 = this.mAngleStep;
                d2 = ((double) i) * d5;
                if (d2 > d3) {
                    d2 -= d5;
                    break;
                }
                if (d2 == d3) {
                    break;
                }
                i++;
            }
            double d6 = this.mScrollAngleOffset;
            d = d6 > d2 ? (((double) (i2 * PopOverActivityWrapper.DEFAULT_WIDTH)) + d6) - d2 : (d4 - d2) + ((double) (i2 * PopOverActivityWrapper.DEFAULT_WIDTH)) + d6;
        } else {
            double d7 = (distance * this.mAnglePerPixel) + this.mScrollAngleOffset;
            double d8 = PopOverActivityWrapper.DEFAULT_WIDTH;
            int i5 = (int) (d7 / d8);
            double d9 = d7 % d8;
            int i6 = this.mTotalItemVisible;
            while (i < i6) {
                d2 = ((double) i) * this.mAngleStep;
                if (d2 >= d9) {
                    break;
                }
                i++;
            }
            d = (((double) (i5 * PopOverActivityWrapper.DEFAULT_WIDTH)) + (d2 >= d9 ? 360.0d + d2 : 360.0d)) - this.mScrollAngleOffset;
        }
        return (int) (d / this.mAnglePerPixel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@Nullable RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        QTColorLayoutManager qTColorLayoutManager = this;
        RecyclerView.Recycler recycler2 = recycler;
        Intrinsics.checkNotNullParameter(state, "state");
        if (qTColorLayoutManager.mTotalItemCount == 0 || recycler2 == null || state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        float width = qTColorLayoutManager.getWidth() * 0.5f;
        float height = qTColorLayoutManager.getHeight() * 0.5f;
        int i = qTColorLayoutManager.mTotalItemVisible;
        int i2 = 0;
        int i4 = 0;
        while (i4 < i) {
            int i5 = (qTColorLayoutManager.mFirstVisibleItemPos + i4) % qTColorLayoutManager.mTotalItemCount;
            View viewForPosition = recycler2.getViewForPosition(i5);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            qTColorLayoutManager.addView(viewForPosition);
            qTColorLayoutManager.measureChildWithMargins(viewForPosition, i2, i2);
            int decoratedMeasuredWidth = qTColorLayoutManager.getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = qTColorLayoutManager.getDecoratedMeasuredHeight(viewForPosition);
            double d = (((double) (i4 - 5)) * qTColorLayoutManager.mAngleStep) + qTColorLayoutManager.mScrollAngleOffset;
            double radians = Math.toRadians(d);
            int i6 = i4;
            double d2 = 2;
            int iM2210a = (int) (AbstractC2821a.m2210a(radians, qTColorLayoutManager.radius, width) - (((double) decoratedMeasuredWidth) / d2));
            int iM5b = (int) (AbstractC0000a.m5b(radians, qTColorLayoutManager.radius, height) - (((double) decoratedMeasuredHeight) / d2));
            HashSet<Integer> hashSet = qTColorLayoutManager.mDividerIdxSet;
            if (hashSet != null && hashSet.contains(Integer.valueOf(i5))) {
                viewForPosition.setRotation((float) d);
            }
            qTColorLayoutManager.layoutDecorated(viewForPosition, iM2210a, iM5b, iM2210a + decoratedMeasuredWidth, decoratedMeasuredHeight + iM5b);
            i4 = i6 + 1;
            i2 = 0;
            qTColorLayoutManager = this;
            recycler2 = recycler;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int dx, @Nullable RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!needLayoutChildren(dx)) {
            return super.scrollHorizontallyBy(dx, recycler, state);
        }
        double d = ((double) dx) * this.mAnglePerPixel;
        updateScrollAngleOffset(d);
        updateFirstVisibleItem(d);
        onLayoutChildren(recycler, state);
        return dx;
    }

    public final void setDialItems(@NotNull List<SettingQTColorDialLayout.ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int size = items.size();
        this.mTotalItemCount = size;
        AbstractC8014b.m7217s(size, "setTotalItemCount totalItemCount=", TAG);
        if (this.mTotalItemCount <= 0) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        for (Object obj : items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((SettingQTColorDialLayout.ColorDialItem) obj).getType() == SettingQTColorDialLayout.DialItemType.DIVIDER) {
                hashSet.add(Integer.valueOf(i));
            }
            i = i2;
        }
        this.mDividerIdxSet = hashSet;
        this.mTotalItemVisible = Math.min(this.mTotalItemCount, 24);
        this.mAngleStep = 15.0d;
    }

    public final void setFirstVisibleItemPosition(int visibleItemPos) {
        Logger.m11003i(TAG, "setFirstVisibleItemPosition visibleItemPos= " + visibleItemPos);
        int i = this.mTotalItemCount;
        this.mFirstVisibleItemPos = ((visibleItemPos + (-1)) + i) % i;
        this.mScrollAngleOffset = 0.0d;
        this.mFirstItemAngleOffset = 0.0d;
        requestLayout();
    }

    public final void setScrollDirection(@NotNull QTColorRecycleView.ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.mScrollDirection = direction;
    }
}
