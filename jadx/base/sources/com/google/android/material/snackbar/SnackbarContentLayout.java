package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.Outline;
import android.os.Build;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.SemBlurCompat;
import androidx.core.view.SeslTouchTargetDelegate;
import androidx.core.view.ViewCompat;
import androidx.reflect.feature.SeslFloatingFeatureReflector;
import androidx.reflect.view.inputmethod.SeslInputMethodManagerReflector;
import com.google.android.material.C4548R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int mAvailableWidth;
    private Integer mBlurMode;
    private InputMethodManager mImm;
    private boolean mIsBlurApplied;
    private boolean mIsCoordinatorLayoutParent;
    private boolean mIsSuggestMultiLine;
    private SnackbarContentLayout mSnackBarContentLayout;
    private int mType;
    private int mWidthWithAction;
    private WindowManager mWindowManager;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean applySnackBarBlur(Integer num) {
        if (Build.VERSION.SDK_INT >= 36 && !"FALSE".equalsIgnoreCase(SeslFloatingFeatureReflector.getString("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG", "FALSE")) && this.mSnackBarContentLayout != null) {
            if (SemBlurCompat.setBlurEffectPreset((View) this.mSnackBarContentLayout, num.intValue(), new SemBlurCompat.CurveParameter(300, 0.5f, -15.0f, 0.0f, 255.0f, 33.8f, 153.7f), num.intValue() == 0 ? 0 : null, num.intValue() == 0 ? Float.valueOf(getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_suggest_background_radius)) : null, (Integer) 1)) {
                clipSnackBarContentLayout();
                this.mSnackBarContentLayout.setBackgroundTintList(ColorStateList.valueOf(0));
                this.mSnackBarContentLayout.invalidate();
                return true;
            }
        }
        return false;
    }

    private void clipSnackBarContentLayout() {
        final float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_suggest_background_radius);
        this.mSnackBarContentLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.snackbar.SnackbarContentLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, SnackbarContentLayout.this.mSnackBarContentLayout.getMeasuredWidth(), SnackbarContentLayout.this.mSnackBarContentLayout.getMeasuredHeight(), dimensionPixelSize);
            }
        });
        this.mSnackBarContentLayout.setClipToOutline(true);
    }

    private int seslGetNavibarHeight() {
        if (Build.VERSION.SDK_INT < 30) {
            return getResources().getDimensionPixelOffset(C4548R.dimen.sesl_design_snackbar_layout_sip_padding_bottom);
        }
        try {
            Insets insets = this.mWindowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.navigationBars());
            return insets.bottom == 0 ? getResources().getDimensionPixelOffset(C4548R.dimen.sesl_design_snackbar_layout_sip_padding_bottom) : insets.bottom;
        } catch (Exception unused) {
            return getResources().getDimensionPixelOffset(C4548R.dimen.sesl_design_snackbar_layout_sip_padding_bottom);
        }
    }

    private void seslSetTouchDelegateForSnackBar() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.snackbar.SnackbarContentLayout.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    SnackbarContentLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (SnackbarContentLayout.this.mSnackBarContentLayout == null || SnackbarContentLayout.this.actionView == null || SnackbarContentLayout.this.actionView.getVisibility() != 0) {
                        return;
                    }
                    SnackbarContentLayout.this.mSnackBarContentLayout.post(new Runnable() { // from class: com.google.android.material.snackbar.SnackbarContentLayout.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SeslTouchTargetDelegate seslTouchTargetDelegate = new SeslTouchTargetDelegate(SnackbarContentLayout.this.mSnackBarContentLayout);
                            int measuredHeight = SnackbarContentLayout.this.actionView.getMeasuredHeight() / 2;
                            seslTouchTargetDelegate.addTouchDelegate(SnackbarContentLayout.this.actionView, SeslTouchTargetDelegate.ExtraInsets.m1781of(measuredHeight, measuredHeight, measuredHeight, measuredHeight));
                            SnackbarContentLayout.this.mSnackBarContentLayout.setTouchDelegate(seslTouchTargetDelegate);
                        }
                    });
                }
            });
        }
    }

    private boolean seslUpdateLayoutMarginsForLandscape(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSnackBarContentLayout.getLayoutParams();
        if (SeslInputMethodManagerReflector.isInputMethodShown(this.mImm)) {
            marginLayoutParams.bottomMargin = seslGetNavibarHeight();
        } else {
            marginLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(C4548R.dimen.sesl_design_snackbar_layout_padding_bottom);
        }
        ViewParent parent = this.mSnackBarContentLayout.getParent();
        if (this.mIsCoordinatorLayoutParent && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int measuredWidth = viewGroup.getMeasuredWidth();
            int paddingLeft = viewGroup.getPaddingLeft();
            int iMin = ((measuredWidth - Math.min(this.mWidthWithAction, i)) - paddingLeft) - viewGroup.getPaddingRight();
            if (iMin > 0) {
                int i2 = iMin / 2;
                marginLayoutParams.rightMargin = i2;
                marginLayoutParams.leftMargin = i2;
            } else {
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.leftMargin = 0;
            }
        }
        this.mSnackBarContentLayout.setLayoutParams(marginLayoutParams);
        return true;
    }

    private boolean seslUpdateLayoutMarginsForPortrait(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSnackBarContentLayout.getLayoutParams();
        ViewParent parent = this.mSnackBarContentLayout.getParent();
        if (!this.mIsCoordinatorLayoutParent || !(parent instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int measuredWidth = viewGroup.getMeasuredWidth();
        int paddingLeft = viewGroup.getPaddingLeft();
        int iMin = ((measuredWidth - Math.min(this.mWidthWithAction, i)) - paddingLeft) - viewGroup.getPaddingRight();
        if (iMin > 0) {
            int i2 = iMin / 2;
            marginLayoutParams.rightMargin = i2;
            marginLayoutParams.leftMargin = i2;
        } else {
            marginLayoutParams.rightMargin = 0;
            marginLayoutParams.leftMargin = 0;
        }
        this.mSnackBarContentLayout.setLayoutParams(marginLayoutParams);
        return true;
    }

    private static void updateTopBottomPadding(@NonNull View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i4) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.messageView.getPaddingTop() == i2 && this.messageView.getPaddingBottom() == i4) {
            return z;
        }
        updateTopBottomPadding(this.messageView, i2, i4);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i2) {
        this.messageView.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.messageView.animate().alpha(1.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i2) {
        this.messageView.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.messageView.animate().alpha(0.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    public void invalidateSnackbarContentLayout() {
        SnackbarContentLayout snackbarContentLayout = this.mSnackBarContentLayout;
        if (snackbarContentLayout != null) {
            snackbarContentLayout.invalidate();
        }
    }

    public boolean isBlurApplied() {
        return this.mIsBlurApplied;
    }

    public boolean isWindowBlurApplied() {
        return this.mIsBlurApplied && this.mBlurMode.intValue() == 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Resources resources = getContext().getResources();
        int fraction = (int) resources.getFraction(C4548R.dimen.sesl_config_prefSnackWidth, resources.getDisplayMetrics().widthPixels, resources.getDisplayMetrics().widthPixels);
        this.mWidthWithAction = fraction;
        this.maxWidth = fraction;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(C4548R.id.snackbar_text);
        this.actionView = (Button) findViewById(C4548R.id.snackbar_action);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        if (this.actionView.getVisibility() == 0 && (this.mType != 0 || this.mIsSuggestMultiLine)) {
            int size = View.MeasureSpec.getSize(i);
            this.mAvailableWidth = size;
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size, this.mWidthWithAction), 1073741824);
            super.onMeasure(i, i2);
        } else if (getMeasuredWidth() == 0) {
            i = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            super.onMeasure(i, i2);
        } else if (this.maxWidth > 0) {
            int measuredWidth2 = getMeasuredWidth();
            int i4 = this.maxWidth;
            if (measuredWidth2 > i4) {
                i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                super.onMeasure(i, i2);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4548R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C4548R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.messageView.getLayout();
        boolean z2 = layout != null && layout.getLineCount() > 1;
        if (z2) {
            this.mIsSuggestMultiLine = true;
        }
        SnackbarContentLayout snackbarContentLayout = this.mSnackBarContentLayout;
        if (snackbarContentLayout != null) {
            float measuredWidth3 = this.actionView.getMeasuredWidth() + this.messageView.getMeasuredWidth() + this.mSnackBarContentLayout.getPaddingRight() + snackbarContentLayout.getPaddingLeft();
            if (this.maxInlineActionWidth == -1 && this.actionView.getVisibility() == 0) {
                if (measuredWidth3 > this.mWidthWithAction || z2 || this.mIsSuggestMultiLine) {
                    this.mSnackBarContentLayout.setOrientation(1);
                    this.messageView.setPadding(getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_text_padding_left), getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_text_padding_top), getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_text_padding_right), getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_text_padding_bottom));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.actionView.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_action_margin_bottom));
                    layoutParams.setMarginEnd(getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_action_margin_end));
                    this.actionView.setLayoutParams(layoutParams);
                } else {
                    this.mSnackBarContentLayout.setOrientation(0);
                    this.actionView.setPadding(getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_action_padding_left), 0, getResources().getDimensionPixelSize(C4548R.dimen.sesl_design_snackbar_action_padding_right), 0);
                }
                z = true;
            } else {
                z = false;
            }
            int rotation = this.mWindowManager.getDefaultDisplay().getRotation();
            zSeslUpdateLayoutMarginsForPortrait = ((this.mImm == null || !(rotation == 1 || rotation == 3)) ? seslUpdateLayoutMarginsForPortrait((int) measuredWidth3) : seslUpdateLayoutMarginsForLandscape((int) measuredWidth3)) | z;
        } else if (!z2 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                zSeslUpdateLayoutMarginsForPortrait = true;
            }
        } else if (updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
        }
        if (zSeslUpdateLayoutMarginsForPortrait) {
            super.onMeasure(i, i2);
            if (this.mSnackBarContentLayout == null || this.mType != 0) {
                return;
            }
            clipSnackBarContentLayout();
        }
    }

    public boolean seslApplyBlurInfo(boolean z, Integer num) {
        this.mIsBlurApplied = !z;
        this.mBlurMode = num;
        if (z) {
            return false;
        }
        return applySnackBarBlur(num);
    }

    public void seslSetType(int i) {
        this.mType = i;
    }

    public void setIsCoordinatorLayoutParent(boolean z) {
        this.mIsCoordinatorLayoutParent = z;
    }

    public void setMaxInlineActionWidth(int i) {
        this.maxInlineActionWidth = i;
    }

    public void updateActionTextColorAlphaIfNeeded(float f) {
        if (f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, C4548R.attr.colorSurface), this.actionView.getCurrentTextColor(), f));
        }
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCoordinatorLayoutParent = false;
        this.mBlurMode = 2;
        this.mIsBlurApplied = true;
        this.mIsSuggestMultiLine = false;
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, C4548R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4548R.styleable.SnackbarLayout);
        this.maxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
        Resources resources = context.getResources();
        int fraction = (int) resources.getFraction(C4548R.dimen.sesl_config_prefSnackWidth, resources.getDisplayMetrics().widthPixels, resources.getDisplayMetrics().widthPixels);
        this.mWidthWithAction = fraction;
        this.maxWidth = fraction;
        this.mSnackBarContentLayout = (SnackbarContentLayout) findViewById(C4548R.id.snackbar_content_layout);
        this.mImm = (InputMethodManager) context.getSystemService(InputMethodManager.class);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        seslSetTouchDelegateForSnackBar();
    }
}
