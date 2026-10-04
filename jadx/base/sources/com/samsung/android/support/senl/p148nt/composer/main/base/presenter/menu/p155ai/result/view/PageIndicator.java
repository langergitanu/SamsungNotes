package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageIndicator {
    boolean mDisabled = true;
    private ViewGroup mIndicator;
    private View mIndicatorContainer;
    OnIconClickListener mOnIconClickListener;
    ViewPager2 mViewPager2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnIconClickListener {
        void onClickListener(int i);
    }

    private int getItemCount() {
        if (this.mViewPager2.getAdapter() == null) {
            return 0;
        }
        return this.mViewPager2.getAdapter().getItemCount();
    }

    public void initIndicator(View view, ViewPager2 viewPager2, boolean z) {
        this.mViewPager2 = viewPager2;
        this.mIndicatorContainer = view.findViewById(C9086R.id.ai_menu_result_viewpage_indicator_container);
        this.mIndicator = (ViewGroup) view.findViewById(C9086R.id.ai_menu_result_viewpage_indicator);
        this.mDisabled = z;
        int i = z ? 8 : 0;
        this.mIndicatorContainer.setVisibility(i);
        this.mIndicator.setVisibility(i);
        if (this.mIndicator.getVisibility() == 0) {
            updateIndicator();
        }
    }

    public void requestLayout() {
        this.mIndicator.requestLayout();
    }

    public void setOnIconClickListener(OnIconClickListener onIconClickListener) {
        this.mOnIconClickListener = onIconClickListener;
    }

    public void updateIndicator() {
        ViewGroup viewGroup = this.mIndicator;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int itemCount = getItemCount() - childCount;
        final int i = 0;
        if (itemCount < 0) {
            int iAbs = Math.abs(itemCount);
            for (int i2 = 0; i2 < iAbs; i2++) {
                this.mIndicator.removeViewAt(r4.getChildCount() - 1);
            }
        } else {
            int i4 = C9086R.layout.ai_result_indicator_dot;
            for (int i5 = 0; i5 < itemCount; i5++) {
                LayoutInflater.from(this.mIndicator.getContext()).inflate(i4, this.mIndicator);
            }
        }
        while (i < this.mIndicator.getChildCount()) {
            this.mIndicator.getChildAt(i).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.PageIndicator.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnIconClickListener onIconClickListener = PageIndicator.this.mOnIconClickListener;
                    if (onIconClickListener != null) {
                        onIconClickListener.onClickListener(i);
                    }
                }
            });
            int i6 = i + 1;
            this.mIndicator.getChildAt(i).setContentDescription(this.mIndicator.getResources().getString(C9086R.string.composer_list_page_info, Integer.valueOf(i6), Integer.valueOf(childCount)));
            i = i6;
        }
    }

    public void updateIndicator(int i) {
        View view = this.mIndicatorContainer;
        if (view == null) {
            return;
        }
        if (this.mDisabled) {
            view.setVisibility(8);
            return;
        }
        if (this.mIndicator.getVisibility() == 8 && i == 0) {
            return;
        }
        this.mIndicatorContainer.setVisibility(0);
        this.mIndicator.setVisibility(0);
        updateIndicator();
        int childCount = this.mIndicator.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            this.mIndicator.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }
}
