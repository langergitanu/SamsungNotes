package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CheckableRelativeLayout extends RelativeLayout implements Checkable {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private boolean mChecked;
    private boolean mIsCheckable;

    public CheckableRelativeLayout(Context context) {
        super(context);
        this.mChecked = false;
        this.mIsCheckable = false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArr = CHECKED_STATE_SET;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.mIsCheckable) {
            accessibilityEvent.setChecked(this.mChecked);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(this.mIsCheckable);
        if (this.mIsCheckable) {
            accessibilityNodeInfo.setChecked(this.mChecked);
        }
    }

    public void setCheckable(boolean z) {
        this.mIsCheckable = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked == z) {
            return;
        }
        this.mChecked = z;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChecked = false;
        this.mIsCheckable = false;
    }

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChecked = false;
        this.mIsCheckable = false;
    }

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChecked = false;
        this.mIsCheckable = false;
    }
}
