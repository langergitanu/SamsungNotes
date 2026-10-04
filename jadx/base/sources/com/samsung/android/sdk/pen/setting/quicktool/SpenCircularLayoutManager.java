package com.samsung.android.sdk.pen.setting.quicktool;

import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001e\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0014\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0003J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "radius", "", "<init>", "(I)V", "mScrollDirection", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil$ScrollDirection;", "mRadius", "mTotalItemCount", "mTotalItemVisible", "mAnglePerPixel", "", "mAngleStep", "mScrollAngleOffset", "mFirstItemAngleOffset", "mFirstVisibleItemPos", "mDividerIdxSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "close", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "canScrollHorizontally", "", "scrollHorizontallyBy", "dx", "setDialItems", "items", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "setScrollDirection", "direction", "getScrollDistance", "distance", "isLeftToRight", "setFirstVisibleItemPosition", "visibleItemPos", "needLayoutChildren", "updateScrollAngleOffset", "angle", "updateFirstVisibleItem", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCircularLayoutManager extends RecyclerView.LayoutManager {
    private static final int MAX_ITEMS_VISIBLE = 12;

    @NotNull
    private static final String TAG = "SpenCircularLayoutManager";
    private double mAnglePerPixel;
    private double mAngleStep;

    @Nullable
    private HashSet<Integer> mDividerIdxSet;
    private double mFirstItemAngleOffset;
    private int mFirstVisibleItemPos;
    private int mRadius;
    private double mScrollAngleOffset;

    @NotNull
    private SpenSettingQTUtil.ScrollDirection mScrollDirection = SpenSettingQTUtil.ScrollDirection.DIR_NONE;
    private int mTotalItemCount;
    private int mTotalItemVisible;

    public SpenCircularLayoutManager(int i) {
        this.mRadius = i;
        this.mAnglePerPixel = 360.0d / (((double) i) * 6.283185307179586d);
    }

    private final boolean needLayoutChildren(int dx) {
        SpenSettingQTUtil.ScrollDirection scrollDirection;
        if (dx == 0 || (scrollDirection = this.mScrollDirection) == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
            return false;
        }
        if (scrollDirection != SpenSettingQTUtil.ScrollDirection.DIR_COUNTER_CLOCK_WISE || dx >= 0) {
            return scrollDirection != SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE || dx <= 0;
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
        if (d >= d2) {
            int i2 = (int) (d / d2);
            this.mFirstItemAngleOffset = d % d2;
            this.mFirstVisibleItemPos = (this.mFirstVisibleItemPos + i2) % i;
            this.mScrollAngleOffset -= d2 * ((double) i2);
            return;
        }
        if (d <= (-d2)) {
            int i4 = (int) (d / d2);
            this.mFirstItemAngleOffset = d % d2;
            int i5 = (this.mFirstVisibleItemPos + i4) % i;
            this.mFirstVisibleItemPos = i5;
            if (i5 < 0) {
                this.mFirstVisibleItemPos = i + i5;
            }
            this.mScrollAngleOffset -= d2 * ((double) i4);
        }
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
    @Nullable
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
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
        SpenCircularLayoutManager spenCircularLayoutManager = this;
        Intrinsics.checkNotNullParameter(state, "state");
        if (spenCircularLayoutManager.mTotalItemCount == 0 || recycler == null || state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        int i = 2;
        int width = spenCircularLayoutManager.getWidth() / 2;
        int height = spenCircularLayoutManager.getHeight() / 2;
        int i2 = spenCircularLayoutManager.mTotalItemVisible;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i2) {
            int i6 = (spenCircularLayoutManager.mFirstVisibleItemPos + i5) % spenCircularLayoutManager.mTotalItemCount;
            View viewForPosition = recycler.getViewForPosition(i6);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            spenCircularLayoutManager.addView(viewForPosition);
            spenCircularLayoutManager.measureChildWithMargins(viewForPosition, i4, i4);
            int decoratedMeasuredWidth = spenCircularLayoutManager.getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = spenCircularLayoutManager.getDecoratedMeasuredHeight(viewForPosition);
            int i7 = i5;
            double radians = Math.toRadians((((double) (1 - i5)) * spenCircularLayoutManager.mAngleStep) + spenCircularLayoutManager.mScrollAngleOffset);
            double d = i;
            int iM2210a = (int) (AbstractC2821a.m2210a(radians, spenCircularLayoutManager.mRadius, width) - (((double) decoratedMeasuredWidth) / d));
            int i8 = width;
            int iM5b = (int) (AbstractC0000a.m5b(radians, spenCircularLayoutManager.mRadius, height) - (((double) decoratedMeasuredHeight) / d));
            HashSet<Integer> hashSet = spenCircularLayoutManager.mDividerIdxSet;
            if (hashSet != null && hashSet.contains(Integer.valueOf(i6))) {
                viewForPosition.setRotation((float) Math.toDegrees(radians));
            }
            spenCircularLayoutManager.layoutDecorated(viewForPosition, iM2210a, iM5b, iM2210a + decoratedMeasuredWidth, iM5b + decoratedMeasuredHeight);
            i5 = i7 + 1;
            i = 2;
            i4 = 0;
            spenCircularLayoutManager = this;
            width = i8;
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

    public final void setDialItems(@NotNull List<SpenSettingQTColorDialLayout.ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int size = items.size();
        this.mTotalItemCount = size;
        AbstractC2322a.m1631u(size, "setTotalItemCount totalItemCount=", TAG);
        if (this.mTotalItemCount <= 0) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Iterator<T> it = items.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (((SpenSettingQTColorDialLayout.ColorDialItem) it.next()).getType() == SpenSettingQTColorDialLayout.DialItemType.DIVIDER) {
                hashSet.add(Integer.valueOf(i));
            }
            i = i2;
        }
        if (!hashSet.isEmpty()) {
            this.mDividerIdxSet = hashSet;
        }
        int iMin = (int) Math.min(this.mTotalItemCount, 12.0d);
        this.mTotalItemVisible = iMin;
        this.mAngleStep = 360.0d / ((double) iMin);
        this.mFirstVisibleItemPos = this.mTotalItemCount - 1;
    }

    public final void setFirstVisibleItemPosition(int visibleItemPos) {
        AbstractC2322a.m1631u(visibleItemPos, "setFirstVisibleItemPosition visibleItemPos= ", TAG);
        if (visibleItemPos == 0) {
            visibleItemPos = this.mTotalItemCount;
        }
        this.mFirstVisibleItemPos = visibleItemPos - 1;
        this.mScrollAngleOffset = 0.0d;
        requestLayout();
    }

    public final void setScrollDirection(@NotNull SpenSettingQTUtil.ScrollDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.mScrollDirection = direction;
    }
}
