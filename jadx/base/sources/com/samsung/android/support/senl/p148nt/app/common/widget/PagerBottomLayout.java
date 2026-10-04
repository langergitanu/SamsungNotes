package com.samsung.android.support.senl.p148nt.app.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PagerBottomLayout extends LinearLayout implements View.OnClickListener {
    protected View mBackButton;
    private int mDefaultPageButtonBackgroundColor;
    private int mDefaultPageButtonRes;
    private int mDefaultPageButtonTextColor;
    protected TabLayout mIndicator;
    private int mLastPageButtonBackgroundColor;
    private int mLastPageButtonRes;
    private int mLastPageButtonTextColor;
    protected Button mNextButton;
    private View.OnClickListener mOnClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onClick(View view);
    }

    public PagerBottomLayout(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        inflateView(context);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C8003R.styleable.PagerBottomLayoutAttribute, i, i2);
        try {
            this.mLastPageButtonRes = typedArrayObtainStyledAttributes.getResourceId(C8003R.styleable.PagerBottomLayoutAttribute_lastPageButtonText, C8003R.string.pager_start);
            this.mDefaultPageButtonRes = typedArrayObtainStyledAttributes.getResourceId(C8003R.styleable.PagerBottomLayoutAttribute_defaultPageButtonText, C8003R.string.pager_next);
            this.mLastPageButtonTextColor = typedArrayObtainStyledAttributes.getColor(C8003R.styleable.PagerBottomLayoutAttribute_lastPageButtonTextColor, getResources().getColor(C8003R.color.pager_start_button_text_color, null));
            this.mDefaultPageButtonTextColor = typedArrayObtainStyledAttributes.getColor(C8003R.styleable.PagerBottomLayoutAttribute_defaultPageButtonTextColor, getResources().getColor(C8003R.color.pager_default_button_text_color, null));
            this.mLastPageButtonBackgroundColor = typedArrayObtainStyledAttributes.getColor(C8003R.styleable.PagerBottomLayoutAttribute_lastPageButtonBackgroundColor, getResources().getColor(C8003R.color.pager_start_button_background_color, null));
            this.mDefaultPageButtonBackgroundColor = typedArrayObtainStyledAttributes.getColor(C8003R.styleable.PagerBottomLayoutAttribute_defaultPageButtonBackgroundColor, getResources().getColor(C8003R.color.pager_default_button_background_color, null));
            typedArrayObtainStyledAttributes.recycle();
            this.mBackButton = findViewById(C8003R.id.pager_back_button);
            this.mNextButton = (Button) findViewById(C8003R.id.pager_next_button);
            this.mIndicator = (TabLayout) findViewById(C8003R.id.pager_indicator);
            this.mBackButton.setOnClickListener(this);
            this.mNextButton.setOnClickListener(this);
            this.mBackButton.setRotation(LocaleUtils.isRTLMode() ? 180.0f : 0.0f);
            updateLayout(true, false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void inflateView(Context context) {
        LayoutInflater.from(context).inflate(C8003R.layout.pager_indicator_layout, (ViewGroup) this, true);
    }

    public void invalidateIndicator() {
        TabLayout tabLayout = this.mIndicator;
        if (tabLayout == null) {
            return;
        }
        tabLayout.invalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            updateIndicator();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        View view = this.mBackButton;
        if (view != null) {
            view.setRotation(LocaleUtils.isRTLMode() ? 180.0f : 0.0f);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z) {
        TabLayout tabLayout = this.mIndicator;
        if (tabLayout == null) {
            return;
        }
        tabLayout.setupWithViewPager(viewPager, z);
    }

    public void updateIndicator() {
        int tabCount = this.mIndicator.getTabCount();
        this.mIndicator.setMinimumWidth(getResources().getDimensionPixelSize(C8003R.dimen.pager_indicator_size) * tabCount);
        this.mIndicator.getGlobalVisibleRect(new Rect());
        if (tabCount <= 1) {
            this.mIndicator.setVisibility(4);
        } else {
            this.mIndicator.setVisibility(0);
        }
    }

    public void updateLayout(boolean z, boolean z2) {
        this.mBackButton.setVisibility(z ? 4 : 0);
        if (z2) {
            this.mNextButton.setText(this.mLastPageButtonRes);
            this.mNextButton.setTextColor(this.mLastPageButtonTextColor);
            this.mNextButton.getBackground().setColorFilter(new PorterDuffColorFilter(this.mLastPageButtonBackgroundColor, PorterDuff.Mode.SRC_IN));
        } else {
            this.mNextButton.setText(this.mDefaultPageButtonRes);
            this.mNextButton.setTextColor(this.mDefaultPageButtonTextColor);
            this.mNextButton.getBackground().setColorFilter(new PorterDuffColorFilter(this.mDefaultPageButtonBackgroundColor, PorterDuff.Mode.SRC_IN));
        }
        CharUtils.applyTextSizeUntilLargeSize(getContext(), this.mNextButton, ResourceUtils.convertPixelToSp(getContext(), getResources().getDimension(C8003R.dimen.ftu_ai_composer_pager_bottom_layout_start)));
        updateIndicator();
    }

    public PagerBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public PagerBottomLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    public PagerBottomLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }
}
