package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
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
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i6 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    i4 = i2;
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i4, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i6;
                } else {
                    i4 = i2;
                }
            }
            i5++;
            i2 = i4;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i4, int i5) {
        view.layout(i, i2, i4 + i, i5 + i2);
    }

    private boolean tryOnMeasure(int i, int i2) {
        int iCombineMeasuredStates;
        int iResolveMinimumHeight;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0419R.id.topPanel) {
                    view = childAt;
                } else if (id == C0419R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != C0419R.id.contentPanel && id != C0419R.id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i, 0);
            paddingBottom += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            iResolveMinimumHeight = resolveMinimumHeight(view2);
            measuredHeight = view2.getMeasuredHeight() - iResolveMinimumHeight;
            paddingBottom += iResolveMinimumHeight;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iResolveMinimumHeight = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i5 = size - paddingBottom;
        if (view2 != null) {
            int i6 = paddingBottom - iResolveMinimumHeight;
            int iMin = Math.min(i5, measuredHeight);
            if (iMin > 0) {
                i5 -= iMin;
                iResolveMinimumHeight += iMin;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(iResolveMinimumHeight, 1073741824));
            paddingBottom = i6 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i5 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i5, mode));
            paddingBottom = (paddingBottom - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + iMax, i, iCombineMeasuredStates), View.resolveSizeAndState(paddingBottom, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        int iM7d;
        int i6;
        int i7;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = alertDialogLayout.getPaddingLeft();
        int i8 = i4 - i;
        int paddingRight = i8 - alertDialogLayout.getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - alertDialogLayout.getPaddingRight();
        int measuredHeight = alertDialogLayout.getMeasuredHeight();
        int childCount = alertDialogLayout.getChildCount();
        int gravity = alertDialogLayout.getGravity();
        int i9 = gravity & 112;
        int i10 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i9 != 16 ? i9 != 80 ? alertDialogLayout.getPaddingTop() : ((alertDialogLayout.getPaddingTop() + i5) - i2) - measuredHeight : (((i5 - i2) - measuredHeight) / 2) + alertDialogLayout.getPaddingTop();
        Drawable dividerDrawable = alertDialogLayout.getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i11 = 0;
        while (i11 < childCount) {
            int i12 = paddingTop;
            View childAt = alertDialogLayout.getChildAt(i11);
            if (childAt == null || childAt.getVisibility() == 8) {
                paddingTop = i12;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i13 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i13 < 0) {
                    i13 = i10;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i13, alertDialogLayout.getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    iM7d = AbstractC0000a.m7d(paddingRight2, measuredWidth, 2, paddingLeft) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i7 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    if (alertDialogLayout.hasDividerBeforeChildAt(i11)) {
                        i12 += intrinsicHeight;
                    }
                    int i14 = i12 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    alertDialogLayout.setChildFrame(childAt, i7, i14, measuredWidth, measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i14;
                } else {
                    iM7d = paddingRight - measuredWidth;
                    i6 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i7 = iM7d - i6;
                if (alertDialogLayout.hasDividerBeforeChildAt(i11)) {
                }
                int i142 = i12 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                alertDialogLayout.setChildFrame(childAt, i7, i142, measuredWidth, measuredHeight2);
                paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i142;
            }
            i11++;
            alertDialogLayout = this;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (tryOnMeasure(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
