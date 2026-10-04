package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;

    @Nullable
    int[] mIndexToFlexLine;

    @Nullable
    long[] mMeasureSpecCache;

    @Nullable
    private long[] mMeasuredSizeCache;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("Order{order=");
            sb.append(this.order);
            sb.append(", index=");
            return AbstractC0000a.m13j(sb, this.index, '}');
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Order order) {
            int i = this.order;
            int i2 = order.order;
            return i != i2 ? i - i2 : this.index - order.index;
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    private void addFlexLine(List<FlexLine> list, FlexLine flexLine, int i, int i2) {
        flexLine.mSumCrossSizeBefore = i2;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = i;
        list.add(flexLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void checkSizeConstraints(View view, int i) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else {
            if (measuredWidth <= flexItem.getMaxWidth()) {
                z = false;
                if (measuredHeight >= flexItem.getMinHeight()) {
                    measuredHeight = flexItem.getMinHeight();
                } else if (measuredHeight > flexItem.getMaxHeight()) {
                    measuredHeight = flexItem.getMaxHeight();
                } else {
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                updateMeasureCache(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.mFlexContainer.updateViewCache(i, view);
                return;
            }
            measuredWidth = flexItem.getMaxWidth();
        }
        z = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (z2) {
        }
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> list, int i, int i2) {
        int i4 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = i4;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i5));
            if (i5 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Order> createOrders(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.mFlexContainer.getFlexItemAt(i2).getLayoutParams();
            Order order = new Order();
            order.order = flexItem.getOrder();
            order.index = i2;
            arrayList.add(order);
        }
        return arrayList;
    }

    private void ensureChildrenFrozen(int i) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void expandFlexItems(int i, int i2, FlexLine flexLine, int i4, int i5, boolean z) {
        int i6;
        float f;
        float f4;
        int iMax;
        double d;
        double d2;
        float f5 = flexLine.mTotalFlexGrow;
        float f6 = 0.0f;
        if (f5 <= 0.0f || i4 < (i6 = flexLine.mMainSize)) {
            return;
        }
        float f7 = (i4 - i6) / f5;
        flexLine.mMainSize = i5 + flexLine.mDividerLengthInMainSize;
        if (!z) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        float f8 = 0.0f;
        while (i7 < flexLine.mItemCount) {
            int i9 = flexLine.mFirstIndex + i7;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i9);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f = f6;
                f4 = f7;
                z2 = z2;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f = f6;
                if (flexDirection == 0 || flexDirection == 1) {
                    f4 = f7;
                    boolean z3 = z2;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i9]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i9]);
                    }
                    if (this.mChildrenFrozen[i9] || flexItem.getFlexGrow() <= f) {
                        z2 = z3;
                    } else {
                        float flexGrow = (flexItem.getFlexGrow() * f4) + measuredWidth;
                        if (i7 == flexLine.mItemCount - 1) {
                            flexGrow += f8;
                            f8 = f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.mChildrenFrozen[i9] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            float f9 = (flexGrow - iRound) + f8;
                            double d3 = f9;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else {
                                if (d3 < -1.0d) {
                                    iRound--;
                                    d = d3 + 1.0d;
                                }
                                f8 = f9;
                                z2 = z3;
                            }
                            f9 = (float) d;
                            f8 = f9;
                            z2 = z3;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i2, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i9, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i9, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + flexLine.mMainSize;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i9]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    f4 = f7;
                    boolean z4 = z2;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i9]);
                    }
                    if (this.mChildrenFrozen[i9] || flexItem.getFlexGrow() <= f) {
                        z2 = z4;
                    } else {
                        float flexGrow2 = (flexItem.getFlexGrow() * f4) + measuredHeight3;
                        if (i7 == flexLine.mItemCount - 1) {
                            flexGrow2 += f8;
                            f8 = f;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.mChildrenFrozen[i9] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            float f10 = (flexGrow2 - iRound2) + f8;
                            double d4 = f10;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else {
                                if (d4 < -1.0d) {
                                    iRound2--;
                                    d2 = d4 + 1.0d;
                                }
                                f8 = f10;
                                z2 = z4;
                            }
                            f10 = (float) d2;
                            f8 = f10;
                            z2 = z4;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i9, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i9, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + flexLine.mMainSize;
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i8 = iMax;
            }
            i7++;
            f7 = f4;
            f6 = f;
        }
        if (!z2 || i6 == flexLine.mMainSize) {
            return;
        }
        expandFlexItems(i, i2, flexLine, i4, i5, true);
    }

    private int getChildHeightMeasureSpecInternal(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        return size > flexItem.getMaxHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    private int getChildWidthMeasureSpecInternal(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        return size > flexItem.getMaxWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int getPaddingEndCross(boolean z) {
        return z ? this.mFlexContainer.getPaddingBottom() : this.mFlexContainer.getPaddingEnd();
    }

    private int getPaddingEndMain(boolean z) {
        return z ? this.mFlexContainer.getPaddingEnd() : this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean z) {
        return z ? this.mFlexContainer.getPaddingTop() : this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingStartMain(boolean z) {
        return z ? this.mFlexContainer.getPaddingStart() : this.mFlexContainer.getPaddingTop();
    }

    private int getViewMeasuredSizeCross(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int getViewMeasuredSizeMain(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean isLastFlexItem(int i, int i2, FlexLine flexLine) {
        return i == i2 - 1 && flexLine.getItemCountNotGone() != 0;
    }

    private boolean isWrapRequired(View view, int i, int i2, int i4, int i5, FlexItem flexItem, int i6, int i7, int i8) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= i8 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, i6, i7);
        if (decorationLengthMainAxis > 0) {
            i5 += decorationLengthMainAxis;
        }
        return i2 < i4 + i5;
    }

    private void shrinkFlexItems(int i, int i2, FlexLine flexLine, int i4, int i5, boolean z) {
        float f;
        float f4;
        int iMax;
        int minWidth;
        int i6 = flexLine.mMainSize;
        float f5 = flexLine.mTotalFlexShrink;
        float f6 = 0.0f;
        if (f5 <= 0.0f || i4 > i6) {
            return;
        }
        float f7 = (i6 - i4) / f5;
        flexLine.mMainSize = i5 + flexLine.mDividerLengthInMainSize;
        if (!z) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        float f8 = 0.0f;
        while (i7 < flexLine.mItemCount) {
            int i9 = flexLine.mFirstIndex + i7;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i9);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f = f6;
                f4 = f7;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f = f6;
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i9]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    f4 = f7;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i9]);
                    }
                    if (!this.mChildrenFrozen[i9] && flexItem.getFlexShrink() > f) {
                        float flexShrink = measuredWidth - (f4 * flexItem.getFlexShrink());
                        if (i7 == flexLine.mItemCount - 1) {
                            flexShrink += f8;
                            f8 = f;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            minWidth = flexItem.getMinWidth();
                            this.mChildrenFrozen[i9] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            float f9 = (flexShrink - iRound) + f8;
                            double d = f9;
                            if (d > 1.0d) {
                                minWidth = iRound + 1;
                                f9 -= 1.0f;
                            } else if (d < -1.0d) {
                                minWidth = iRound - 1;
                                f9 += 1.0f;
                            } else {
                                minWidth = iRound;
                            }
                            f8 = f9;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i2, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(minWidth, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i9, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i9, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + flexLine.mMainSize;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i9]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i9]);
                    }
                    if (!this.mChildrenFrozen[i9] && flexItem.getFlexShrink() > f) {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f7);
                        if (i7 == flexLine.mItemCount - 1) {
                            flexShrink2 += f8;
                            f8 = f;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.mChildrenFrozen[i9] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            float f10 = (flexShrink2 - iRound2) + f8;
                            double d2 = f10;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f10 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f10 += 1.0f;
                            }
                            f8 = f10;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i9, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i9, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + flexLine.mMainSize;
                    f4 = f7;
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i8 = iMax;
            }
            i7++;
            f7 = f4;
            f6 = f;
        }
        if (!z2 || i6 == flexLine.mMainSize) {
            return;
        }
        shrinkFlexItems(i, i2, flexLine, i4, i5, true);
    }

    private int[] sortOrdersIntoReorderedIndices(int i, List<Order> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (Order order : list) {
            int i4 = order.index;
            iArr[i2] = i4;
            sparseIntArray.append(i4, order.order);
            i2++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? extractHigherInt(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        updateMeasureCache(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(i2, view);
    }

    private void stretchViewVertically(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? extractLowerInt(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        updateMeasureCache(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(i2, view);
    }

    private void updateMeasureCache(int i, int i2, int i4, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[i] = makeCombinedLong(i2, i4);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[i] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void calculateFlexLines(FlexLinesResult flexLinesResult, int i, int i2, int i4, int i5, int i6, @Nullable List<FlexLine> list) {
        int i7;
        FlexLinesResult flexLinesResult2;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int childWidthMeasureSpec;
        int i13;
        int i14;
        int i15;
        FlexLine flexLine;
        int i16;
        int i17;
        boolean z2;
        int i18;
        int i19;
        int i20 = i;
        boolean zIsMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i20);
        int size = View.MeasureSpec.getSize(i20);
        List<FlexLine> arrayList = list == null ? new ArrayList() : list;
        flexLinesResult.mFlexLines = arrayList;
        boolean z3 = i6 == -1;
        int paddingStartMain = getPaddingStartMain(zIsMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(zIsMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(zIsMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(zIsMainAxisDirectionHorizontal);
        FlexLine flexLine2 = new FlexLine();
        int i21 = i5;
        flexLine2.mFirstIndex = i21;
        int i22 = paddingStartMain + paddingEndMain;
        flexLine2.mMainSize = i22;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        boolean z4 = z3;
        FlexLine flexLine3 = flexLine2;
        int i23 = Integer.MIN_VALUE;
        int i24 = 0;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        while (true) {
            if (i21 >= flexItemCount) {
                i7 = iCombineMeasuredStates;
                flexLinesResult2 = flexLinesResult;
                break;
            }
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt != null) {
                z = true;
                i8 = i22;
                if (reorderedFlexItemAt.getVisibility() != 8) {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i26 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine3.mIndicesAlignSelfStretch.add(Integer.valueOf(i21));
                    }
                    int flexItemSizeMain = getFlexItemSizeMain(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        flexItemSizeMain = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        i10 = mode;
                        childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(i20, i8 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                        i9 = size;
                        i11 = i24;
                        int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i2, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i24, getFlexItemSizeCross(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        updateMeasureCache(i21, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i12 = 0;
                    } else {
                        i9 = size;
                        i10 = mode;
                        i11 = i24;
                        i12 = 0;
                        int childWidthMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i2, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i11, getFlexItemSizeCross(flexItem, false));
                        int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i20, i8 + getFlexItemMarginStartMain(flexItem, false) + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        updateMeasureCache(i21, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        childWidthMeasureSpec = childHeightMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(i21, reorderedFlexItemAt);
                    checkSizeConstraints(reorderedFlexItemAt, i21);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i27 = i12;
                    i13 = i21;
                    int i28 = childWidthMeasureSpec;
                    FlexLine flexLine4 = flexLine3;
                    int i29 = i25;
                    i14 = i8;
                    i15 = i11;
                    boolean z5 = zIsMainAxisDirectionHorizontal;
                    size = i9;
                    if (isWrapRequired(reorderedFlexItemAt, i10, size, flexLine3.mMainSize, getViewMeasuredSizeMain(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, zIsMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i13, i29, arrayList.size())) {
                        if (flexLine4.getItemCountNotGone() > 0) {
                            addFlexLine(arrayList, flexLine4, i13 > 0 ? i13 - 1 : i27, i15);
                            i19 = i15 + flexLine4.mCrossSize;
                        } else {
                            i19 = i15;
                        }
                        if (z5) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer = this.mFlexContainer;
                                reorderedFlexItemAt.measure(i28, flexContainer.getChildHeightMeasureSpec(i2, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i19, flexItem.getHeight()));
                                checkSizeConstraints(reorderedFlexItemAt, i13);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer2 = this.mFlexContainer;
                            reorderedFlexItemAt.measure(flexContainer2.getChildWidthMeasureSpec(i2, flexContainer2.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i19, flexItem.getWidth()), i28);
                            checkSizeConstraints(reorderedFlexItemAt, i13);
                        }
                        FlexLine flexLine5 = new FlexLine();
                        flexLine5.mItemCount = 1;
                        flexLine5.mMainSize = i14;
                        flexLine5.mFirstIndex = i13;
                        i15 = i19;
                        i16 = i27;
                        flexLine = flexLine5;
                        i17 = Integer.MIN_VALUE;
                    } else {
                        flexLine = flexLine4;
                        flexLine.mItemCount++;
                        i16 = i29 + 1;
                        i17 = i23;
                    }
                    flexLine.mAnyItemsHaveFlexGrow = (flexLine.mAnyItemsHaveFlexGrow ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? 1 : i27);
                    flexLine.mAnyItemsHaveFlexShrink = (flexLine.mAnyItemsHaveFlexShrink ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? 1 : i27);
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i13] = arrayList.size();
                    }
                    z2 = z5;
                    flexLine.mMainSize = getViewMeasuredSizeMain(reorderedFlexItemAt, z2) + getFlexItemMarginStartMain(flexItem, z2) + getFlexItemMarginEndMain(flexItem, z2) + flexLine.mMainSize;
                    flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(reorderedFlexItemAt, i13, i16, flexLine);
                    int iMax = Math.max(i17, getViewMeasuredSizeCross(reorderedFlexItemAt, z2) + getFlexItemMarginStartCross(flexItem, z2) + getFlexItemMarginEndCross(flexItem, z2) + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                    if (z2) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, reorderedFlexItemAt.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, (reorderedFlexItemAt.getMeasuredHeight() - reorderedFlexItemAt.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i18 = i26;
                    if (isLastFlexItem(i13, i18, flexLine)) {
                        addFlexLine(arrayList, flexLine, i13, i15);
                        i15 += flexLine.mCrossSize;
                    }
                    if (i6 != -1 && arrayList.size() > 0) {
                        if (((FlexLine) AbstractC0000a.m10g(arrayList, 1)).mLastIndex >= i6 && i13 >= i6 && !z4) {
                            i15 = -flexLine.getCrossSize();
                            z4 = true;
                        }
                    }
                    if (i15 > i4 && z4) {
                        flexLinesResult2 = flexLinesResult;
                        i7 = iCombineMeasuredStates;
                        break;
                    }
                    i23 = iMax;
                    i25 = i16;
                    int i30 = i13 + 1;
                    zIsMainAxisDirectionHorizontal = z2;
                    flexLine3 = flexLine;
                    i22 = i14;
                    i24 = i15;
                    i20 = i;
                    flexItemCount = i18;
                    i21 = i30;
                    mode = i10;
                } else {
                    flexLine3.mGoneItemCount++;
                    flexLine3.mItemCount++;
                    if (isLastFlexItem(i21, flexItemCount, flexLine3)) {
                        addFlexLine(arrayList, flexLine3, i21, i24);
                    }
                }
            } else {
                if (isLastFlexItem(i21, flexItemCount, flexLine3)) {
                    addFlexLine(arrayList, flexLine3, i21, i24);
                }
                i8 = i22;
                z = true;
            }
            i13 = i21;
            i10 = mode;
            i18 = flexItemCount;
            i15 = i24;
            z2 = zIsMainAxisDirectionHorizontal;
            i14 = i8;
            flexLine = flexLine3;
            int i302 = i13 + 1;
            zIsMainAxisDirectionHorizontal = z2;
            flexLine3 = flexLine;
            i22 = i14;
            i24 = i15;
            i20 = i;
            flexItemCount = i18;
            i21 = i302;
            mode = i10;
        }
        flexLinesResult2.mChildState = i7;
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i, int i2) {
        calculateFlexLines(flexLinesResult, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i, int i2, int i4, int i5, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i, i2, i4, 0, i5, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i, int i2) {
        calculateFlexLines(flexLinesResult, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateVerticalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i, int i2, int i4, int i5, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i2, i, i4, 0, i5, list);
    }

    public void clearFlexLines(List<FlexLine> list, int i) {
        int i2 = this.mIndexToFlexLine[i];
        if (i2 == -1) {
            i2 = 0;
        }
        if (list.size() > i2) {
            list.subList(i2, list.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] createReorderedIndices(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> listCreateOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            order.order = 1;
        } else {
            order.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= this.mFlexContainer.getFlexItemCount()) {
            order.index = flexItemCount;
        } else {
            order.index = i;
            while (i < flexItemCount) {
                listCreateOrders.get(i).index++;
                i++;
            }
        }
        listCreateOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, listCreateOrders, sparseIntArray);
    }

    public void determineCrossSize(int i, int i2, int i4) {
        int mode;
        int size;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(flexDirection, "Invalid flex direction: "));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + i4;
            int i5 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = size - i4;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    int i6 = size - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.mCrossSize = i6;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i5 < size4) {
                        arrayList.add(flexLinesInternal.get(i5));
                        if (i5 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i5 == flexLinesInternal.size() - 2) {
                                flexLine2.mCrossSize = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                flexLine2.mCrossSize = Math.round(size3);
                            }
                            int i7 = flexLine2.mCrossSize;
                            float f4 = (size3 - i7) + f;
                            if (f4 > 1.0f) {
                                flexLine2.mCrossSize = i7 + 1;
                                f4 -= 1.0f;
                            } else if (f4 < -1.0f) {
                                flexLine2.mCrossSize = i7 - 1;
                                f4 += 1.0f;
                            }
                            f = f4;
                            arrayList.add(flexLine2);
                        }
                        i5++;
                    }
                    this.mFlexContainer.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.mCrossSize = size5;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.mFlexContainer.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f5 = 0.0f;
                    while (i5 < size7) {
                        FlexLine flexLine5 = flexLinesInternal.get(i5);
                        float f6 = flexLine5.mCrossSize + size6;
                        if (i5 == flexLinesInternal.size() - 1) {
                            f6 += f5;
                            f5 = 0.0f;
                        }
                        int iRound = Math.round(f6);
                        float f7 = (f6 - iRound) + f5;
                        if (f7 > 1.0f) {
                            iRound++;
                            f7 -= 1.0f;
                        } else if (f7 < -1.0f) {
                            iRound--;
                            f7 += 1.0f;
                        }
                        f5 = f7;
                        flexLine5.mCrossSize = iRound;
                        i5++;
                    }
                }
            }
        }
    }

    public void determineMainSize(int i, int i2) {
        determineMainSize(i, i2, 0);
    }

    public void ensureIndexToFlexLine(int i) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, i));
        }
    }

    public void ensureMeasureSpecCache(int i) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, i));
        }
    }

    public void ensureMeasuredSizeCache(int i) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, i));
        }
    }

    public int extractHigherInt(long j) {
        return (int) (j >> 32);
    }

    public int extractLowerInt(long j) {
        return (int) j;
    }

    public boolean isOrderChangedFromLastMeasurement(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int i, int i2, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i7 = i2 + i6;
                    view.layout(i, (i7 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i4, i7 - flexItem.getMarginBottom());
                    return;
                } else {
                    view.layout(i, view.getMeasuredHeight() + (i2 - i6) + flexItem.getMarginTop(), i4, view.getMeasuredHeight() + (i5 - i6) + flexItem.getMarginTop());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i6 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i8 = i2 + measuredHeight;
                    view.layout(i, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                } else {
                    int i9 = i2 - measuredHeight;
                    view.layout(i, i9, i4, view.getMeasuredHeight() + i9);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i, i2 + iMax, i4, i5 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (flexLine.mMaxBaseline - view.getMeasuredHeight()), flexItem.getMarginBottom());
                    view.layout(i, i2 - iMax2, i4, i5 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(i, i2 + flexItem.getMarginTop(), i4, i5 + flexItem.getMarginTop());
        } else {
            view.layout(i, i2 - flexItem.getMarginBottom(), i4, i5 - flexItem.getMarginBottom());
        }
    }

    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean z, int i, int i2, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i4 + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i5);
                    return;
                }
                view.layout(view.getMeasuredWidth() + (i - i6) + flexItem.getMarginLeft(), i2, view.getMeasuredWidth() + (i4 - i6) + flexItem.getMarginLeft(), i5);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int marginStart = ((MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + (i6 - view.getMeasuredWidth())) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - marginStart, i2, i4 - marginStart, i5);
                    return;
                } else {
                    view.layout(i + marginStart, i2, i4 + marginStart, i5);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i - flexItem.getMarginRight(), i2, i4 - flexItem.getMarginRight(), i5);
        } else {
            view.layout(i + flexItem.getMarginLeft(), i2, i4 + flexItem.getMarginLeft(), i5);
        }
    }

    @VisibleForTesting
    public long makeCombinedLong(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    public void stretchViews() {
        stretchViews(0);
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i, int i2, int i4, int i5, @Nullable List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i, i2, i4, i5, -1, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i, int i2, int i4, int i5, @Nullable List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i2, i, i4, i5, -1, list);
    }

    public void determineMainSize(int i, int i2, int i4) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i5;
        int i6;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (i4 >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int flexDirection2 = this.mFlexContainer.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.mFlexContainer.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mFlexContainer.getPaddingLeft();
            paddingRight = this.mFlexContainer.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(flexDirection, "Invalid flex direction: "));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.mFlexContainer.getLargestMainSize();
            }
            paddingLeft = this.mFlexContainer.getPaddingTop();
            paddingRight = this.mFlexContainer.getPaddingBottom();
        }
        int i7 = paddingLeft + paddingRight;
        int i8 = size;
        int[] iArr = this.mIndexToFlexLine;
        int i9 = iArr != null ? iArr[i4] : 0;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i9 < size2) {
            FlexLine flexLine = flexLinesInternal.get(i9);
            int i10 = flexLine.mMainSize;
            if (i10 >= i8 || !flexLine.mAnyItemsHaveFlexGrow) {
                i5 = i;
                i6 = i2;
                if (i10 > i8 && flexLine.mAnyItemsHaveFlexShrink) {
                    shrinkFlexItems(i5, i6, flexLine, i8, i7, false);
                }
            } else {
                i5 = i;
                i6 = i2;
                expandFlexItems(i5, i6, flexLine, i8, i7, false);
            }
            i9++;
            i = i5;
            i2 = i6;
        }
    }

    public void stretchViews(int i) {
        View reorderedFlexItemAt;
        if (i >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (this.mFlexContainer.getAlignItems() != 4) {
            for (FlexLine flexLine : this.mFlexContainer.getFlexLinesInternal()) {
                for (Integer num : flexLine.mIndicesAlignSelfStretch) {
                    View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        stretchViewVertically(reorderedFlexItemAt2, flexLine.mCrossSize, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(AbstractC0000a.m11h(flexDirection, "Invalid flex direction: "));
                        }
                        stretchViewHorizontally(reorderedFlexItemAt2, flexLine.mCrossSize, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.mIndexToFlexLine;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            FlexLine flexLine2 = flexLinesInternal.get(i2);
            int i4 = flexLine2.mItemCount;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = flexLine2.mFirstIndex + i5;
                if (i5 < this.mFlexContainer.getFlexItemCount() && (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i6)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            stretchViewVertically(reorderedFlexItemAt, flexLine2.mCrossSize, i6);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(AbstractC0000a.m11h(flexDirection, "Invalid flex direction: "));
                            }
                            stretchViewHorizontally(reorderedFlexItemAt, flexLine2.mCrossSize, i6);
                        }
                    }
                }
            }
        }
    }

    public int[] createReorderedIndices(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), sparseIntArray);
    }
}
