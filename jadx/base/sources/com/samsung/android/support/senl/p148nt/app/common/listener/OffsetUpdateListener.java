package com.samsung.android.support.senl.p148nt.app.common.listener;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
    static final float ALPHA_RANGE_FACTOR = 0.18f;
    static final float ALPHA_START_FACTOR = 0.1303f;
    static final float NOT_ASSIGN = -1.0f;
    View mAdditionalView;
    View mChangeableView;
    final Context mContext;
    TextView mTextView;
    View mVerticalView;
    int mBaseOffset = 0;
    private boolean mIsKeepLayout = false;
    float mAlphaStart = -1.0f;
    float mAlphaRange = -1.0f;
    int mAppbarHeight = 0;

    public OffsetUpdateListener(Context context) {
        this.mContext = context;
    }

    private void defineAlphaValues(int i) {
        if (this.mAlphaStart == -1.0f) {
            this.mAlphaStart = i * 0.1303f;
            this.mAppbarHeight = i;
        }
        if (this.mAlphaRange == -1.0f) {
            this.mAlphaRange = i * 0.18f;
            this.mAppbarHeight = i;
        }
        if (this.mAppbarHeight != i) {
            float f = i;
            this.mAlphaStart = 0.1303f * f;
            this.mAlphaRange = f * 0.18f;
            this.mAppbarHeight = i;
        }
    }

    private void updateAdditionalViewAlpha(AppBarLayout appBarLayout, int i) {
        View view = this.mAdditionalView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (appBarLayout.getTotalScrollRange() <= 1) {
            this.mAdditionalView.setAlpha(1.0f);
            return;
        }
        double d = 255.0f - ((i - this.mAlphaStart) * (100.0f / this.mAlphaRange));
        if (d < 0.0d || d > 255.0d) {
            if (d < 0.0d) {
                this.mAdditionalView.setAlpha((float) 1.0d);
                return;
            } else {
                this.mAdditionalView.setAlpha(0.0f);
                return;
            }
        }
        double d2 = 255.0d - (d * 2.0d);
        if (d2 < 0.0d || d2 > 255.0d) {
            return;
        }
        this.mAdditionalView.setAlpha((float) (d2 / 255.0d));
    }

    private void updateChangeableHeight(final AppBarLayout appBarLayout) {
        if (this.mChangeableView == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.common.listener.OffsetUpdateListener.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                appBarLayout.getLocalVisibleRect(rect);
                appBarLayout.getWindowVisibleDisplayFrame(rect2);
                int iHeight = rect2.height() - rect.height();
                ViewGroup.LayoutParams layoutParams = OffsetUpdateListener.this.mChangeableView.getLayoutParams();
                if (layoutParams.height == iHeight) {
                    return;
                }
                layoutParams.height = iHeight;
                OffsetUpdateListener.this.mChangeableView.setLayoutParams(layoutParams);
            }
        };
        if (this.mChangeableView.isInLayout()) {
            this.mChangeableView.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void updateExtendedToolbarAlpha(AppBarLayout appBarLayout, int i) {
        TextView textView = this.mTextView;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        int currentTextColor = this.mTextView.getCurrentTextColor();
        if (appBarLayout.getTotalScrollRange() <= 1) {
            this.mTextView.setTextColor(ColorUtils.setAlphaComponent(currentTextColor, 255));
            return;
        }
        double d = 255.0f - ((i - this.mAlphaStart) * (100.0f / this.mAlphaRange));
        if (d < 0.0d || d > 255.0d) {
            if (d < 0.0d) {
                this.mTextView.setTextColor(ColorUtils.setAlphaComponent(currentTextColor, (int) 255.0d));
                return;
            } else {
                this.mTextView.setTextColor(ColorUtils.setAlphaComponent(currentTextColor, 0));
                return;
            }
        }
        double d2 = 255.0d - (d * 2.0d);
        if (d2 < 0.0d || d2 > 255.0d) {
            return;
        }
        this.mTextView.setTextColor(ColorUtils.setAlphaComponent(currentTextColor, (int) d2));
    }

    private void updateVerticalViewTranslation(AppBarLayout appBarLayout, int i, int i2) {
        Rect rect = new Rect();
        appBarLayout.getWindowVisibleDisplayFrame(rect);
        int inputMethodWindowVisibleHeight = InputMethodCompat.getInstance().getInputMethodWindowVisibleHeight(this.mContext);
        View view = this.mVerticalView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (this.mIsKeepLayout) {
            this.mVerticalView.setTranslationY((Math.abs(i) - i2) + this.mBaseOffset);
            return;
        }
        if (i == 0 && i2 == 0) {
            this.mVerticalView.setTranslationY(0.0f);
        } else if (WindowManagerCompat.getInstance().isFreeFormWindow((Activity) this.mContext) || (rect.height() * 2) / 3 < i2 + inputMethodWindowVisibleHeight) {
            this.mVerticalView.setTranslationY(this.mBaseOffset);
        } else {
            this.mVerticalView.setTranslationY((((Math.abs(i) - i2) - inputMethodWindowVisibleHeight) + this.mBaseOffset) / 2.0f);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        defineAlphaValues(appBarLayout.getHeight());
        appBarLayout.getWindowVisibleDisplayFrame(new Rect());
        int iAbs = Math.abs(appBarLayout.getTop());
        updateVerticalViewTranslation(appBarLayout, i, appBarLayout.getTotalScrollRange());
        updateExtendedToolbarAlpha(appBarLayout, iAbs);
        updateAdditionalViewAlpha(appBarLayout, iAbs);
        updateChangeableHeight(appBarLayout);
    }

    public void setTextView(TextView textView) {
        this.mTextView = textView;
    }

    public void setVerticalView(View view) {
        this.mVerticalView = view;
        this.mBaseOffset = WidgetInsetUtils.getCanUseWindowInsets() ? -WidgetInsetUtils.getTopBottomInsets() : 0;
    }

    public OffsetUpdateListener(Context context, TextView textView) {
        this.mContext = context;
        this.mTextView = textView;
    }
}
