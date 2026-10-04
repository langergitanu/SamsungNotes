package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.C4548R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.strategy.ViewTypeStrategy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    boolean isWrapContent;
    private boolean itemHorizontalTranslationEnabled;
    private float mWidthPercent;
    ViewTypeChangeListener onViewTypeChangeListener;
    private final List<Integer> tempChildWidths;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewTypeChangeListener {
        void onViewTypeChanged(int i);
    }

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        TypedValue typedValue = new TypedValue();
        resources.getValue(C4548R.dimen.sesl_bottom_navigation_width_proportion, typedValue, true);
        this.mWidthPercent = typedValue.getFloat();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = (int) (getResources().getDisplayMetrics().widthPixels * this.mWidthPercent);
        this.activeItemMinWidth = resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_active_item_min_width);
        this.mUseItemPool = false;
    }

    private int getLargestItemWidth() {
        int iMax = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
        }
        return iMax;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i;
        int i7 = i5 - i2;
        ViewTypeStrategy viewTypeStrategy = this.mStrategy;
        int itemSeparatorMargin = viewTypeStrategy != null ? viewTypeStrategy.getItemSeparatorMargin(getResources(), getViewVisibleItemCount() == 5) : 0;
        int measuredWidth = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i6 - measuredWidth;
                    childAt.layout((i9 - childAt.getMeasuredWidth()) + itemSeparatorMargin, 0, i9 - itemSeparatorMargin, i7);
                } else {
                    childAt.layout(measuredWidth + itemSeparatorMargin, 0, (childAt.getMeasuredWidth() + measuredWidth) - itemSeparatorMargin, i7);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        updateBadgeIfNeeded();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i4;
        int itemMinWidth;
        boolean z;
        int largestItemWidth;
        int i5;
        int iMax;
        int i6;
        if (View.MeasureSpec.getSize(i) / getResources().getDisplayMetrics().density < 590.0f) {
            this.mWidthPercent = 1.0f;
        } else {
            this.mWidthPercent = 0.75f;
        }
        this.activeItemMaxWidth = (int) (getResources().getDisplayMetrics().widthPixels * this.mWidthPercent);
        int size = (int) (View.MeasureSpec.getSize(i) * this.mWidthPercent);
        getMenu();
        getVisibleItemCount();
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8).getVisibility() == 0) {
                i7++;
            }
        }
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int size2 = View.MeasureSpec.getSize(i2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        if (isShifting(getLabelVisibilityMode(), childCount) && isItemHorizontalTranslationEnabled()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax2 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, childAt.getMeasuredWidth());
            }
            int i9 = childCount - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.inactiveItemMinWidth * i9), Math.min(iMax2, this.activeItemMaxWidth));
            int i10 = size - iMin;
            int iMin2 = Math.min(i10 / (i9 == 0 ? 1 : i9), this.inactiveItemMaxWidth);
            int i11 = i10 - (i9 * iMin2);
            int i12 = 0;
            while (i12 < childCount) {
                if (getChildAt(i12).getVisibility() != 8) {
                    i6 = i12 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i11 > 0) {
                        i6++;
                        i11--;
                    }
                } else {
                    i6 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i6));
                i12++;
            }
        } else {
            int iMin3 = size / (i7 == 0 ? 1 : i7);
            if (i7 != 2) {
                iMin3 = Math.min(iMin3, this.activeItemMaxWidth);
            }
            int i13 = size - (iMin3 * i7);
            for (int i14 = 0; i14 < childCount; i14++) {
                if (getChildAt(i14).getVisibility() == 8) {
                    i4 = 0;
                } else if (i13 > 0) {
                    i4 = iMin3 + 1;
                    i13--;
                } else {
                    i4 = iMin3;
                }
                this.tempChildWidths.add(Integer.valueOf(i4));
            }
        }
        if (this.isWrapContent) {
            ViewTypeStrategy viewTypeStrategy = this.mStrategy;
            itemMinWidth = viewTypeStrategy == null ? 0 : viewTypeStrategy.getItemMinWidth(getResources(), i7);
            if (getParent() instanceof BottomNavigationView) {
                BottomNavigationView bottomNavigationView = (BottomNavigationView) getParent();
                z = i7 == bottomNavigationView.getMaxItemCount();
                ViewTypeStrategy viewTypeStrategy2 = this.mStrategy;
                if (viewTypeStrategy2 != null) {
                    viewTypeStrategy2.updateNavigationBarPadding(bottomNavigationView);
                }
            } else {
                z = false;
            }
        } else {
            itemMinWidth = 0;
            z = false;
        }
        int measuredWidth = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2 != null && childAt2.getVisibility() != 8) {
                if (this.isWrapContent) {
                    childAt2.setMinimumWidth(itemMinWidth);
                }
                ViewTypeStrategy viewTypeStrategy3 = this.mStrategy;
                if (viewTypeStrategy3 != null) {
                    int itemSeparatorPadding = viewTypeStrategy3.getItemSeparatorPadding(getResources(), z);
                    childAt2.setPadding(itemSeparatorPadding, childAt2.getPaddingTop(), itemSeparatorPadding, childAt2.getPaddingBottom());
                }
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i15).intValue(), this.isWrapContent ? Integer.MIN_VALUE : 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        if (this.isWrapContent && (largestItemWidth = getLargestItemWidth()) != 0) {
            int i16 = largestItemWidth * i7;
            int iMin4 = (Math.min(getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_floating_max_width), size) - getPaddingLeft()) - getPaddingRight();
            boolean z2 = i16 <= iMin4;
            boolean z3 = false;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                if (childAt3 != null && childAt3.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt3.getLayoutParams();
                    if (z2) {
                        i5 = i7;
                        iMax = largestItemWidth;
                    } else {
                        i5 = i7 - 1;
                        iMax = iMin4 / Math.max(i7, 0);
                    }
                    if (layoutParams.width != iMax) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(iMax, 1073741824), iMakeMeasureSpec);
                        z3 = true;
                    }
                    iMin4 -= iMax;
                    i7 = i5;
                }
            }
            if (z3) {
                int measuredWidth2 = 0;
                for (int i18 = 0; i18 < childCount; i18++) {
                    View childAt4 = getChildAt(i18);
                    if (childAt4 != null && childAt4.getVisibility() != 8) {
                        measuredWidth2 = childAt4.getMeasuredWidth() + measuredWidth2;
                    }
                }
                measuredWidth = measuredWidth2;
            }
        }
        setMeasuredDimension(measuredWidth, size2);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.itemHorizontalTranslationEnabled = z;
    }

    public void setStrategy(ViewTypeStrategy viewTypeStrategy) {
        this.mStrategy = viewTypeStrategy;
        this.mIsFloatingStyle = viewTypeStrategy.getIsFloatingStyle();
        int selectedSidePadding = this.mStrategy.getSelectedSidePadding(getResources());
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof NavigationBarItemView) {
                ((NavigationBarItemView) childAt).setSelectedSidePadding(selectedSidePadding);
            }
        }
        if (this.mIsFloatingStyle) {
            setClipToPadding(false);
            setClipChildren(false);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    public void setViewType(int i) {
        super.setViewType(i);
        ViewTypeChangeListener viewTypeChangeListener = this.onViewTypeChangeListener;
        if (viewTypeChangeListener != null) {
            viewTypeChangeListener.onViewTypeChanged(i);
        }
    }

    public void setViewTypeChangeListener(ViewTypeChangeListener viewTypeChangeListener) {
        this.onViewTypeChangeListener = viewTypeChangeListener;
    }
}
