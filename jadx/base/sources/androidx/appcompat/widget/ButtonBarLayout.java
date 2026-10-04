package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private final int mButtonBarBottomMargin;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastWidthSize = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, C0419R.styleable.ButtonBarLayout, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.mAllowStacking = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.mAllowStacking);
        }
        this.mButtonBarBottomMargin = (int) getResources().getDimension(C0419R.dimen.sesl_dialog_button_bar_margin_bottom);
    }

    private void applyButtonMargin() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Button) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams.width = -1;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (i < childCount - 1) {
                        marginLayoutParams.setMargins(0, 0, 0, this.mButtonBarBottomMargin);
                    }
                    childAt.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void clearButtonMargin() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Button) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.width = -2;
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (i < childCount - 1) {
                        marginLayoutParams.setMargins(0, 0, 0, 0);
                    }
                    childAt.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private int getNextVisibleChildIndex(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0 && (getChildAt(i) instanceof Button)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    private void setDividerInvisible(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (!(getChildAt(i) instanceof Button)) {
                getChildAt(i).setVisibility(8);
            }
            i++;
        }
    }

    private void setDividerVisible(int i) {
        int i2;
        int childCount = getChildCount();
        while (i < childCount) {
            if (!(getChildAt(i) instanceof Button) && (i2 = i + 1) < childCount && (getChildAt(i2) instanceof Button) && getChildAt(i2).getVisibility() == 0) {
                getChildAt(i).setVisibility(0);
            }
            i++;
        }
    }

    private void setStacked(boolean z) {
        if (this.mStacked != z) {
            if (!z || this.mAllowStacking) {
                this.mStacked = z;
                setOrientation(z ? 1 : 0);
                setGravity(z ? 8388613 : 80);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int measuredHeight = 0;
        if (this.mAllowStacking) {
            if (size > this.mLastWidthSize && isStacked()) {
                setStacked(false);
                setDividerVisible(getNextVisibleChildIndex(0));
            }
            this.mLastWidthSize = size;
        }
        if (isStacked() || View.MeasureSpec.getMode(i) != 1073741824) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.mAllowStacking && !isStacked()) {
            boolean z2 = (getMeasuredWidthAndState() & (-16777216)) == 16777216;
            if (z2) {
                setStacked(true);
                setDividerInvisible(0);
                setGravity(17);
                z = true;
            }
            if (z2) {
                applyButtonMargin();
            } else {
                clearButtonMargin();
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int nextVisibleChildIndex = getNextVisibleChildIndex(0);
        if (nextVisibleChildIndex >= 0) {
            View childAt = getChildAt(nextVisibleChildIndex);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (isStacked()) {
                int nextVisibleChildIndex2 = getNextVisibleChildIndex(nextVisibleChildIndex + 1);
                if (nextVisibleChildIndex2 >= 0) {
                    measuredHeight = getChildAt(nextVisibleChildIndex2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight;
                }
            } else {
                measuredHeight += getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != measuredHeight) {
            setMinimumHeight(measuredHeight);
            if (i2 == 0 || z) {
                super.onMeasure(i, i2);
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.mAllowStacking != z) {
            this.mAllowStacking = z;
            if (!z && isStacked()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
