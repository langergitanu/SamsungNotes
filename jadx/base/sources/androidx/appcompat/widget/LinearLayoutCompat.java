package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;
import p001A.AbstractC0000a;
import p074R1.AbstractC0229a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.mGravityId = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                public String apply(int i) {
                    return i != 0 ? i != 1 ? String.valueOf(i) : "vertical" : "horizontal";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.mDividerId = propertyMapper.mapObject("divider", C0419R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", C0419R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", C0419R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", C0419R.attr.showDividers, new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // java.util.function.IntFunction
                public Set<String> apply(int i) {
                    HashSet hashSet = new HashSet();
                    if (i == 0) {
                        hashSet.add("none");
                    }
                    if (i == 1) {
                        hashSet.add("beginning");
                    }
                    if (i == 2) {
                        hashSet.add("middle");
                    }
                    if (i == 4) {
                        hashSet.add("end");
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw AbstractC0229a.m512l();
            }
            propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
            propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
            propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void forceUniformHeight(int i, int i2) {
        int i4;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i5 = 0;
        while (i5 < i) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i6 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    i4 = i2;
                    measureChildWithMargins(virtualChildAt, i4, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i6;
                } else {
                    i4 = i2;
                }
            }
            i5++;
            i2 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void forceUniformWidth(int i, int i2) {
        int i4;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i5 = 0;
        while (i5 < i) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i6 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    i4 = i2;
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i4, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i6;
                } else {
                    i4 = i2;
                }
            }
            i5++;
            i2 = i4;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i4, int i5) {
        view.layout(i, i2, i4 + i, i5 + i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int iM7d = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                iM7d = AbstractC0000a.m7d(((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom(), this.mTotalLength, 2, iM7d);
            } else if (i == 80) {
                iM7d = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return iM7d + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal(int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        char c;
        int i8;
        int i9;
        int childrenSkipCount;
        int i10;
        int i11;
        int iM7d;
        int measuredHeight;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i12 = i5 - i2;
        int paddingBottom = i12 - getPaddingBottom();
        int paddingBottom2 = (i12 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.mGravity;
        int i14 = i13 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i13, getLayoutDirection());
        int i15 = 2;
        char c2 = 1;
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i) - this.mTotalLength : AbstractC0000a.m7d(i4 - i, this.mTotalLength, 2, getPaddingLeft());
        if (zIsLayoutRtl) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int i16 = 0;
        while (i16 < virtualChildCount) {
            int i17 = (i7 * i16) + i6;
            int i18 = i16;
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt == null) {
                paddingLeft = measureNullChild(i17) + paddingLeft;
                childrenSkipCount = i18;
                i8 = paddingBottom;
                i9 = virtualChildCount;
                c = c2;
            } else {
                c = c2;
                int i19 = i15;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight2 = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i20 = paddingLeft;
                    if (z) {
                        i8 = paddingBottom;
                        int baseline = ((LinearLayout.LayoutParams) layoutParams).height != -1 ? virtualChildAt.getBaseline() : -1;
                        i10 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i10 < 0) {
                            i10 = i14;
                        }
                        i11 = i10 & 112;
                        i9 = virtualChildCount;
                        if (i11 == 16) {
                            if (i11 == 48) {
                                iM7d = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                                if (baseline != -1) {
                                    iM7d = (iArr[c] - baseline) + iM7d;
                                }
                            } else if (i11 != 80) {
                                iM7d = paddingTop;
                            } else {
                                iM7d = (i8 - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[i19] - (virtualChildAt.getMeasuredHeight() - baseline);
                                }
                            }
                            int i21 = (hasDividerBeforeChildAt(i17) ? i20 + this.mDividerWidth : i20) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i21, iM7d, measuredWidth, measuredHeight2);
                            paddingLeft = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i21;
                            childrenSkipCount = getChildrenSkipCount(virtualChildAt, i17) + i18;
                        } else {
                            iM7d = AbstractC0000a.m7d(paddingBottom2, measuredHeight2, i19, paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                        iM7d -= measuredHeight;
                        int i212 = (hasDividerBeforeChildAt(i17) ? i20 + this.mDividerWidth : i20) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i212, iM7d, measuredWidth, measuredHeight2);
                        paddingLeft = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i212;
                        childrenSkipCount = getChildrenSkipCount(virtualChildAt, i17) + i18;
                    } else {
                        i8 = paddingBottom;
                    }
                    i10 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i10 < 0) {
                    }
                    i11 = i10 & 112;
                    i9 = virtualChildCount;
                    if (i11 == 16) {
                    }
                    iM7d -= measuredHeight;
                    int i2122 = (hasDividerBeforeChildAt(i17) ? i20 + this.mDividerWidth : i20) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i2122, iM7d, measuredWidth, measuredHeight2);
                    paddingLeft = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i2122;
                    childrenSkipCount = getChildrenSkipCount(virtualChildAt, i17) + i18;
                } else {
                    i8 = paddingBottom;
                    i9 = virtualChildCount;
                    childrenSkipCount = i18;
                }
            }
            i16 = childrenSkipCount + 1;
            c2 = c;
            paddingBottom = i8;
            virtualChildCount = i9;
            i15 = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i, int i2, int i4, int i5) {
        int iM7d;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i4 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i2) - this.mTotalLength : AbstractC0000a.m7d(i5 - i2, this.mTotalLength, 2, getPaddingTop());
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int nextLocationOffset = paddingTop;
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                paddingTop = measureNullChild(childrenSkipCount) + nextLocationOffset;
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i12 < 0) {
                        i12 = i11;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i12, getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        iM7d = AbstractC0000a.m7d(paddingRight2, measuredWidth, 2, paddingLeft) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (absoluteGravity != 5) {
                        i7 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        if (hasDividerBeforeChildAt(childrenSkipCount)) {
                            nextLocationOffset += this.mDividerHeight;
                        }
                        int i13 = ((LinearLayout.LayoutParams) layoutParams).topMargin + nextLocationOffset;
                        setChildFrame(virtualChildAt, i7, getLocationOffset(virtualChildAt) + i13, measuredWidth, measuredHeight);
                        nextLocationOffset = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i13;
                        childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    } else {
                        iM7d = paddingRight - measuredWidth;
                        i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i7 = iM7d - i6;
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    }
                    int i132 = ((LinearLayout.LayoutParams) layoutParams).topMargin + nextLocationOffset;
                    setChildFrame(virtualChildAt, i7, getLocationOffset(virtualChildAt) + i132, measuredWidth, measuredHeight);
                    nextLocationOffset = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i132;
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                }
                paddingTop = nextLocationOffset;
            }
            childrenSkipCount++;
        }
    }

    public void measureChildBeforeLayout(View view, int i, int i2, int i4, int i5, int i6) {
        measureChildWithMargins(view, i2, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0463  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i, int i2) {
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int iMax;
        int i10;
        int i11;
        int baseline;
        int i12;
        int i13;
        float f4;
        int i14;
        byte b;
        int i15;
        boolean z;
        int i16;
        int i17;
        int i18;
        int[] iArr;
        int i19;
        int i20;
        boolean z2;
        int[] iArr2;
        View view;
        boolean z3;
        boolean z4;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr3 = this.mMaxAscent;
        int[] iArr4 = this.mMaxDescent;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        iArr4[3] = -1;
        iArr4[2] = -1;
        iArr4[1] = -1;
        iArr4[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i21 = 1073741824;
        boolean z7 = mode == 1073741824;
        boolean z8 = z6;
        int childrenSkipCount = 0;
        int i22 = 0;
        int iMax2 = 0;
        boolean z9 = false;
        int iCombineMeasuredStates = 0;
        boolean z10 = false;
        boolean z11 = true;
        float f5 = 0.0f;
        int iMax3 = 0;
        int iMax4 = 0;
        while (true) {
            i4 = i22;
            if (childrenSkipCount >= virtualChildCount) {
                break;
            }
            boolean z12 = z5;
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount) + this.mTotalLength;
            } else if (virtualChildAt.getVisibility() == 8) {
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f6 = ((LinearLayout.LayoutParams) layoutParams).weight;
                float f7 = f5 + f6;
                if (mode == i21 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f6 > 0.0f) {
                    if (z7) {
                        this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                    } else {
                        int i23 = this.mTotalLength;
                        this.mTotalLength = Math.max(i23, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i23 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z12) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i17 = virtualChildCount;
                        i18 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                    } else {
                        i17 = virtualChildCount;
                        i18 = mode;
                        iArr = iArr3;
                        iArr2 = iArr4;
                        z9 = true;
                    }
                    i19 = i4;
                    i20 = 1073741824;
                    z2 = z8;
                    view = virtualChildAt;
                } else {
                    if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f6 <= 0.0f) {
                        b = -2;
                        i15 = Integer.MIN_VALUE;
                    } else {
                        b = -2;
                        ((LinearLayout.LayoutParams) layoutParams).width = -2;
                        i15 = 0;
                    }
                    if (f7 == 0.0f) {
                        z = z8;
                        i16 = this.mTotalLength;
                    } else {
                        z = z8;
                        i16 = 0;
                    }
                    i17 = virtualChildCount;
                    i18 = mode;
                    iArr = iArr3;
                    i19 = i4;
                    i20 = 1073741824;
                    z2 = z;
                    iArr2 = iArr4;
                    int i24 = i15;
                    measureChildBeforeLayout(virtualChildAt, childrenSkipCount, i, i16, i2, 0);
                    view = virtualChildAt;
                    if (i24 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) layoutParams).width = i24;
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    if (z7) {
                        this.mTotalLength = getNextLocationOffset(view) + ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                    } else {
                        int i25 = this.mTotalLength;
                        this.mTotalLength = Math.max(i25, getNextLocationOffset(view) + i25 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z2) {
                        iMax2 = Math.max(measuredWidth, iMax2);
                    }
                }
                if (mode2 == i20 || ((LinearLayout.LayoutParams) layoutParams).height != -1) {
                    z3 = false;
                } else {
                    z3 = true;
                    z10 = true;
                }
                int i26 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int measuredHeight = view.getMeasuredHeight() + i26;
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                if (!z12 || (baseline2 = view.getBaseline()) == -1) {
                    z4 = z3;
                } else {
                    int i27 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i27 < 0) {
                        i27 = this.mGravity;
                    }
                    int i28 = (((i27 & 112) >> 4) & (-2)) >> 1;
                    z4 = z3;
                    iArr[i28] = Math.max(iArr[i28], baseline2);
                    iArr2[i28] = Math.max(iArr2[i28], measuredHeight - baseline2);
                }
                int iMax5 = Math.max(i19, measuredHeight);
                z11 = z11 && ((LinearLayout.LayoutParams) layoutParams).height == -1;
                if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                    if (!z4) {
                        i26 = measuredHeight;
                    }
                    iMax4 = Math.max(iMax4, i26);
                } else {
                    if (!z4) {
                        i26 = measuredHeight;
                    }
                    iMax3 = Math.max(iMax3, i26);
                }
                childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                i22 = iMax5;
                f5 = f7;
                childrenSkipCount++;
                z8 = z2;
                iArr4 = iArr2;
                z5 = z12;
                mode = i18;
                iArr3 = iArr;
                virtualChildCount = i17;
                i21 = 1073741824;
            }
            i17 = virtualChildCount;
            i18 = mode;
            iArr = iArr3;
            iArr2 = iArr4;
            i22 = i4;
            z2 = z8;
            childrenSkipCount++;
            z8 = z2;
            iArr4 = iArr2;
            z5 = z12;
            mode = i18;
            iArr3 = iArr;
            virtualChildCount = i17;
            i21 = 1073741824;
        }
        boolean z13 = z5;
        int i29 = virtualChildCount;
        int i30 = mode;
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        int i31 = iCombineMeasuredStates;
        boolean z14 = z8;
        if (this.mTotalLength > 0) {
            i5 = i29;
            if (hasDividerBeforeChildAt(i5)) {
                this.mTotalLength += this.mDividerWidth;
            }
        } else {
            i5 = i29;
        }
        int i32 = iArr5[1];
        int iMax6 = (i32 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) ? i4 : Math.max(i4, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i32, iArr5[2]))));
        if (z14) {
            i6 = i30;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount2 = 0;
                while (childrenSkipCount2 < i5) {
                    View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
                    } else if (virtualChildAt2.getVisibility() == 8) {
                        childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                        if (z7) {
                            f4 = f5;
                            this.mTotalLength = getNextLocationOffset(virtualChildAt2) + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mTotalLength;
                            i14 = iMax6;
                            childrenSkipCount2++;
                            f5 = f4;
                            iMax6 = i14;
                        } else {
                            f4 = f5;
                            int i33 = this.mTotalLength;
                            i14 = iMax6;
                            this.mTotalLength = Math.max(i33, getNextLocationOffset(virtualChildAt2) + i33 + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                            childrenSkipCount2++;
                            f5 = f4;
                            iMax6 = i14;
                        }
                    }
                    f4 = f5;
                    i14 = iMax6;
                    childrenSkipCount2++;
                    f5 = f4;
                    iMax6 = i14;
                }
            }
            f = f5;
        } else {
            f = f5;
            i6 = i30;
        }
        int iMax7 = iMax6;
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, 0);
        int i34 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z9 || (i34 != 0 && f > 0.0f)) {
            float f8 = this.mWeightSum;
            if (f8 > 0.0f) {
                f = f8;
            }
            iArr5[3] = -1;
            iArr5[2] = -1;
            iArr5[1] = -1;
            iArr5[0] = -1;
            iArr6[3] = -1;
            iArr6[2] = -1;
            iArr6[1] = -1;
            iArr6[0] = -1;
            this.mTotalLength = 0;
            int iCombineMeasuredStates2 = i31;
            int iMax8 = -1;
            int i35 = 0;
            while (i35 < i5) {
                View virtualChildAt3 = getVirtualChildAt(i35);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i10 = iResolveSizeAndState;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f9 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f9 > 0.0f) {
                        int i36 = (int) ((i34 * f9) / f);
                        f -= f9;
                        i34 -= i36;
                        i10 = iResolveSizeAndState;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i13 = 1073741824;
                            if (i6 == 1073741824) {
                                if (i36 <= 0) {
                                    i36 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i36, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                        } else {
                            i13 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i36;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i13), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & (-16777216));
                    } else {
                        i10 = iResolveSizeAndState;
                    }
                    if (z7) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mTotalLength;
                    } else {
                        int i37 = this.mTotalLength;
                        this.mTotalLength = Math.max(i37, getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + i37 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                    }
                    boolean z15 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i38 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i38;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z15) {
                        i38 = measuredHeight2;
                    }
                    int iMax9 = Math.max(iMax3, i38);
                    if (z11) {
                        i11 = -1;
                        boolean z16 = ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                        if (z13 && (baseline = virtualChildAt3.getBaseline()) != i11) {
                            i12 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i12 < 0) {
                                i12 = this.mGravity;
                            }
                            int i39 = (((i12 & 112) >> 4) & (-2)) >> 1;
                            iArr5[i39] = Math.max(iArr5[i39], baseline);
                            iArr6[i39] = Math.max(iArr6[i39], measuredHeight2 - baseline);
                        }
                        iMax3 = iMax9;
                        z11 = z16;
                    } else {
                        i11 = -1;
                    }
                    if (z13) {
                        i12 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i12 < 0) {
                        }
                        int i392 = (((i12 & 112) >> 4) & (-2)) >> 1;
                        iArr5[i392] = Math.max(iArr5[i392], baseline);
                        iArr6[i392] = Math.max(iArr6[i392], measuredHeight2 - baseline);
                    }
                    iMax3 = iMax9;
                    z11 = z16;
                }
                i35++;
                iResolveSizeAndState = i10;
            }
            i7 = iResolveSizeAndState;
            i8 = -16777216;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            int i40 = iArr5[1];
            iMax7 = (i40 == -1 && iArr5[0] == -1 && iArr5[2] == -1 && iArr5[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr6[3], Math.max(iArr6[0], Math.max(iArr6[1], iArr6[2]))) + Math.max(iArr5[3], Math.max(iArr5[0], Math.max(i40, iArr5[2]))));
            i9 = iCombineMeasuredStates2;
            iMax = iMax3;
        } else {
            iMax = Math.max(iMax3, iMax4);
            if (z14 && i6 != 1073741824) {
                for (int i41 = 0; i41 < i5; i41++) {
                    View virtualChildAt4 = getVirtualChildAt(i41);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i7 = iResolveSizeAndState;
            i9 = i31;
            i8 = -16777216;
        }
        if (z11 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(i7 | (i9 & i8), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax, getSuggestedMinimumHeight()), i2, i9 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    public int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i, int i2) {
        int i4;
        int iMax;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View view;
        boolean z;
        int iMax2;
        boolean z2;
        int iMax3;
        int i16;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i17 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        int childrenSkipCount = 0;
        int i18 = 0;
        int iMax4 = 0;
        int i19 = 0;
        int i20 = 0;
        int iMax5 = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f = 0.0f;
        boolean z6 = true;
        while (true) {
            int i21 = 8;
            if (childrenSkipCount >= virtualChildCount) {
                float f4 = f;
                int i22 = i18;
                int i23 = virtualChildCount;
                int i24 = mode2;
                boolean z7 = z3;
                int i25 = iMax4;
                int iMax6 = i19;
                int iCombineMeasuredStates = i20;
                if (this.mTotalLength > 0) {
                    i4 = i23;
                    if (hasDividerBeforeChildAt(i4)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i4 = i23;
                }
                int i26 = i24;
                if (z7 && (i26 == Integer.MIN_VALUE || i26 == 0)) {
                    this.mTotalLength = 0;
                    int childrenSkipCount2 = 0;
                    while (childrenSkipCount2 < i4) {
                        View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
                        if (virtualChildAt == null) {
                            this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
                        } else if (virtualChildAt.getVisibility() == i21) {
                            childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i27 = this.mTotalLength;
                            this.mTotalLength = Math.max(i27, getNextLocationOffset(virtualChildAt) + i27 + i25 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        }
                        childrenSkipCount2++;
                        i21 = 8;
                    }
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                this.mTotalLength = paddingBottom;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, 0);
                int i28 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
                if (z4 || (i28 != 0 && f4 > 0.0f)) {
                    float f5 = this.mWeightSum;
                    if (f5 <= 0.0f) {
                        f5 = f4;
                    }
                    this.mTotalLength = 0;
                    float f6 = f5;
                    int i29 = i28;
                    int i30 = 0;
                    while (i30 < i4) {
                        View virtualChildAt2 = getVirtualChildAt(i30);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i5 = i26;
                            i6 = i30;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f7 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f7 > 0.0f) {
                                i6 = i30;
                                int i31 = (int) ((i29 * f7) / f6);
                                f6 -= f7;
                                i29 -= i31;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i8 = 1073741824;
                                    if (i26 == 1073741824) {
                                        i5 = i26;
                                        virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i31 > 0 ? i31 : 0, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & (-256));
                                } else {
                                    i8 = 1073741824;
                                }
                                i5 = i26;
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i31;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & (-256));
                            } else {
                                i5 = i26;
                                i6 = i30;
                            }
                            int i32 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i32;
                            iMax6 = Math.max(iMax6, measuredWidth);
                            if (mode != 1073741824) {
                                i7 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                                    measuredWidth = i32;
                                }
                            } else {
                                i7 = -1;
                            }
                            int iMax7 = Math.max(iMax5, measuredWidth);
                            boolean z8 = z6 && ((LinearLayout.LayoutParams) layoutParams2).width == i7;
                            int i33 = this.mTotalLength;
                            this.mTotalLength = Math.max(i33, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i33 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                            iMax5 = iMax7;
                            z6 = z8;
                        }
                        i30 = i6 + 1;
                        i26 = i5;
                    }
                    this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                    iMax = iMax5;
                } else {
                    iMax = Math.max(iMax5, i22);
                    if (z7 && i26 != 1073741824) {
                        for (int i34 = 0; i34 < i4; i34++) {
                            View virtualChildAt3 = getVirtualChildAt(i34);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i25, 1073741824));
                            }
                        }
                    }
                }
                if (!z6 && mode != 1073741824) {
                    iMax6 = iMax;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax6, getSuggestedMinimumWidth()), i, iCombineMeasuredStates), iResolveSizeAndState);
                if (z5) {
                    forceUniformWidth(i4, i2);
                    return;
                }
                return;
            }
            float f8 = f;
            View virtualChildAt4 = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt4 == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount) + this.mTotalLength;
            } else if (virtualChildAt4.getVisibility() == 8) {
                childrenSkipCount += getChildrenSkipCount(virtualChildAt4, childrenSkipCount);
            } else {
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                float f9 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                float f10 = f8 + f9;
                if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f9 > 0.0f) {
                    int i35 = this.mTotalLength;
                    this.mTotalLength = Math.max(i35, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i35 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                    iMax2 = i18;
                    i12 = virtualChildCount;
                    i13 = mode2;
                    z4 = true;
                    view = virtualChildAt4;
                    i15 = i19;
                    i14 = i20;
                    z = z3;
                } else {
                    if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || f9 <= 0.0f) {
                        i9 = Integer.MIN_VALUE;
                    } else {
                        ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                        i9 = 0;
                    }
                    if (f10 == 0.0f) {
                        int i36 = i20;
                        i11 = this.mTotalLength;
                        i10 = i36;
                    } else {
                        i10 = i20;
                        i11 = 0;
                    }
                    int i37 = iMax4;
                    i12 = virtualChildCount;
                    i13 = mode2;
                    i14 = i10;
                    i15 = i19;
                    view = virtualChildAt4;
                    z = z3;
                    iMax2 = i18;
                    measureChildBeforeLayout(view, childrenSkipCount, i, 0, i2, i11);
                    if (i9 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) layoutParams3).height = i9;
                    }
                    int measuredHeight2 = view.getMeasuredHeight();
                    int i38 = this.mTotalLength;
                    this.mTotalLength = Math.max(i38, getNextLocationOffset(view) + i38 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                    iMax4 = z ? Math.max(measuredHeight2, i37) : i37;
                }
                if (i17 >= 0 && i17 == childrenSkipCount + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (childrenSkipCount < i17 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z5 = true;
                }
                int i39 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                int measuredWidth2 = view.getMeasuredWidth() + i39;
                iMax3 = Math.max(i15, measuredWidth2);
                int i40 = iMax4;
                int iCombineMeasuredStates2 = View.combineMeasuredStates(i14, view.getMeasuredState());
                if (z6) {
                    i16 = iCombineMeasuredStates2;
                    z6 = ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((LinearLayout.LayoutParams) layoutParams3).weight <= 0.0f) {
                        if (!z2) {
                            i39 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i39);
                    } else {
                        if (!z2) {
                            i39 = measuredWidth2;
                        }
                        iMax5 = Math.max(iMax5, i39);
                    }
                    childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                    f = f10;
                    iMax4 = i40;
                    i20 = i16;
                    childrenSkipCount++;
                    i19 = iMax3;
                    i18 = iMax2;
                    z3 = z;
                    mode2 = i13;
                    virtualChildCount = i12;
                } else {
                    i16 = iCombineMeasuredStates2;
                }
                if (((LinearLayout.LayoutParams) layoutParams3).weight <= 0.0f) {
                }
                childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                f = f10;
                iMax4 = i40;
                i20 = i16;
                childrenSkipCount++;
                i19 = iMax3;
                i18 = iMax2;
                z3 = z;
                mode2 = i13;
                virtualChildCount = i12;
            }
            iMax2 = i18;
            i12 = virtualChildCount;
            i13 = mode2;
            z = z3;
            f = f8;
            iMax3 = i19;
            childrenSkipCount++;
            i19 = iMax3;
            i18 = iMax2;
            z3 = z;
            mode2 = i13;
            virtualChildCount = i12;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i4, i5);
        } else {
            layoutHorizontal(i, i2, i4, i5);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(@GravityInt int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i4 = this.mGravity;
        if ((8388615 & i4) != i2) {
            this.mGravity = i2 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i4 = this.mGravity;
        if ((i4 & 112) != i2) {
            this.mGravity = i2 | (i4 & LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_TABULAR);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C0419R.styleable.LinearLayoutCompat, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i4 = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(C0419R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
