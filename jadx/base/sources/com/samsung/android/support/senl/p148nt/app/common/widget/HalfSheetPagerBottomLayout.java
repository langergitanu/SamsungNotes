package com.samsung.android.support.senl.p148nt.app.common.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HalfSheetPagerBottomLayout extends PagerBottomLayout {
    public HalfSheetPagerBottomLayout(Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.widget.PagerBottomLayout
    public void inflateView(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.half_sheet_pager_indicator_layout, (ViewGroup) this, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.widget.PagerBottomLayout
    public void updateIndicator() {
        float paddingRight;
        float paddingLeft;
        float paddingLeft2;
        float paddingRight2;
        int tabCount = this.mIndicator.getTabCount();
        this.mIndicator.setMinimumWidth(getResources().getDimensionPixelSize(C8003R.dimen.pager_indicator_size) * tabCount);
        Rect rect = new Rect();
        this.mIndicator.getGlobalVisibleRect(rect);
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        if (this.mBackButton.getVisibility() == 0) {
            Rect rect2 = new Rect();
            this.mBackButton.getGlobalVisibleRect(rect2);
            if (zIsRTLMode) {
                paddingLeft2 = this.mIndicator.getPaddingRight() + rect.right;
            } else {
                paddingLeft2 = rect.left - this.mIndicator.getPaddingLeft();
            }
            if (zIsRTLMode) {
                paddingRight2 = rect2.left - this.mBackButton.getPaddingLeft();
            } else {
                paddingRight2 = this.mBackButton.getPaddingRight() + rect2.right;
            }
            if ((!zIsRTLMode && paddingLeft2 <= paddingRight2) || (zIsRTLMode && paddingLeft2 >= paddingRight2)) {
                this.mIndicator.setVisibility(4);
                return;
            }
        }
        if (this.mNextButton.getVisibility() == 0) {
            Rect rect3 = new Rect();
            this.mNextButton.getGlobalVisibleRect(rect3);
            if (zIsRTLMode) {
                paddingRight = rect.left - this.mIndicator.getPaddingLeft();
            } else {
                paddingRight = this.mIndicator.getPaddingRight() + rect.right;
            }
            if (zIsRTLMode) {
                paddingLeft = this.mNextButton.getPaddingRight() + rect3.right;
            } else {
                paddingLeft = rect3.left - this.mNextButton.getPaddingLeft();
            }
            if ((!zIsRTLMode && paddingLeft <= paddingRight) || (zIsRTLMode && paddingLeft >= paddingRight)) {
                this.mIndicator.setVisibility(4);
                return;
            }
        }
        if (tabCount <= 1) {
            this.mIndicator.setVisibility(4);
        } else {
            this.mIndicator.setVisibility(0);
        }
    }

    public HalfSheetPagerBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HalfSheetPagerBottomLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public HalfSheetPagerBottomLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
