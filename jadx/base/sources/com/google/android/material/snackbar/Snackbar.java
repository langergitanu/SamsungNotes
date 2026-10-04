package com.google.android.material.snackbar;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.oneui.common.internal.util.MaxFontScaleRatio;
import androidx.appcompat.oneui.common.internal.util.TextViewHelperKt;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.reflect.widget.SeslTextViewReflector;
import com.google.android.material.C4548R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int SESL_SNACKBAR_TYPE_DEFAULT = -1;
    public static final int SESL_SNACKBAR_TYPE_SUGGESTION = 0;
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR;
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS;
    private static boolean mIsCoordinatorLayoutParent;

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;
    private int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface SeslSnackBarBlurMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface SeslSnackBarType {
    }

    static {
        int i = C4548R.attr.snackbarButtonStyle;
        SNACKBAR_BUTTON_STYLE_ATTR = new int[]{i};
        SNACKBAR_CONTENT_STYLE_ATTRS = new int[]{i, C4548R.attr.snackbarTextViewStyle};
        mIsCoordinatorLayoutParent = false;
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.mType = -1;
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        mIsCoordinatorLayoutParent = true;
        return (ViewGroup) view;
    }

    private Button getActionView() {
        return getContentLayout().getActionView();
    }

    private SnackbarContentLayout getContentLayout() {
        return (SnackbarContentLayout) this.view.getChildAt(0);
    }

    private TextView getMessageView() {
        return getContentLayout().getMessageView();
    }

    @Deprecated
    public static boolean hasSnackbarButtonStyleAttr(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean hasSnackbarContentStyleAttrs(@NonNull Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    private boolean isShowButtonBackgroundEnabled() {
        ContentResolver contentResolver = getContext().getContentResolver();
        return contentResolver != null && Settings.System.getInt(contentResolver, "show_button_background", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAction$0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        dispatchDismiss(1);
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i) {
        return makeInternal(null, view, charSequence, i, -1, false, 2);
    }

    @NonNull
    private static Snackbar makeInternal(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2, boolean z, Integer num) {
        mIsCoordinatorLayoutParent = false;
        ViewGroup viewGroupFindSuitableParent = findSuitableParent(view);
        if (viewGroupFindSuitableParent == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupFindSuitableParent.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(i2 == 0 ? C4548R.layout.sesl_layout_snackbar_suggest_include : hasSnackbarContentStyleAttrs(context) ? C4548R.layout.mtrl_layout_snackbar_include : C4548R.layout.design_layout_snackbar_include, viewGroupFindSuitableParent, false);
        snackbarContentLayout.setIsCoordinatorLayoutParent(mIsCoordinatorLayoutParent);
        Snackbar snackbar = new Snackbar(context, viewGroupFindSuitableParent, snackbarContentLayout, snackbarContentLayout);
        snackbar.setType(i2);
        snackbar.setText(charSequence);
        snackbar.setDuration(i);
        snackbarContentLayout.seslApplyBlurInfo(z, num);
        if (i2 == 0) {
            snackbar.view.setAnimationMode(2);
            snackbarContentLayout.seslSetType(0);
        }
        return snackbar;
    }

    @NonNull
    public static Snackbar seslMake(@NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2) {
        return makeInternal(null, view, charSequence, i, i2, false, 2);
    }

    private Snackbar setType(@SeslSnackBarType int i) {
        this.mType = i;
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int duration = super.getDuration();
        if (duration != -2) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.accessibilityManager.getRecommendedTimeoutMillis(duration, (this.hasAction ? 4 : 0) | 3);
            }
            if (!this.hasAction || !this.accessibilityManager.isTouchExplorationEnabled()) {
                return duration;
            }
        }
        return -2;
    }

    public void invalidateSnackbarForBlur() {
        if (getContentLayout() == null || !isShown() || !getContentLayout().isBlurApplied() || getContentLayout().isWindowBlurApplied()) {
            return;
        }
        getContentLayout().invalidateSnackbarContentLayout();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setAction(@StringRes int i, View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i), onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTint(@ColorInt int i) {
        return setBackgroundTintList(ColorStateList.valueOf(i));
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    @Deprecated
    public Snackbar setCallback(@Nullable Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setMaxInlineActionWidth(@Dimension int i) {
        getContentLayout().setMaxInlineActionWidth(i);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setText(@NonNull CharSequence charSequence) {
        getMessageView().setText(charSequence);
        TextViewHelperKt.checkMaxFontScale(getMessageView(), this.mType == 0 ? C4548R.dimen.sesl_design_snackbar_suggest_text_size : C4548R.dimen.design_snackbar_text_size, MaxFontScaleRatio.LARGE);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextColor(ColorStateList colorStateList) {
        getMessageView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextMaxLines(int i) {
        getMessageView().setMaxLines(i);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
            setBackgroundColor(R.color.transparent);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
                if (childAt.getLayoutParams().height == -2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    if (childAt.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setBackgroundColor(R.color.transparent);
        }
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setAction(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button actionView = getActionView();
        getContentLayout().setBackground(this.view.getResources().getDrawable(this.mType == 0 ? C4548R.drawable.sesl_snackbar_suggest_action_frame_mtrl : C4548R.drawable.sem_snackbar_action_frame_mtrl));
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
            return this;
        }
        this.hasAction = true;
        if (this.mType != 0) {
            actionView.setVisibility(0);
        }
        actionView.setText(charSequence);
        actionView.setOnClickListener(new ViewOnClickListenerC0219a(this, onClickListener, 4));
        TextViewHelperKt.checkMaxFontScale(getMessageView(), this.mType == 0 ? C4548R.dimen.sesl_design_snackbar_suggest_action_text_size : C4548R.dimen.sesl_design_snackbar_action_text_size, MaxFontScaleRatio.LARGE);
        SeslTextViewReflector.semSetButtonShapeEnabled(actionView, isShowButtonBackgroundEnabled());
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setActionTextColor(@ColorInt int i) {
        getActionView().setTextColor(i);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setTextColor(@ColorInt int i) {
        getMessageView().setTextColor(i);
        return this;
    }

    @NonNull
    public static Snackbar make(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i) {
        return makeInternal(context, view, charSequence, i, -1, false, 2);
    }

    @NonNull
    public static Snackbar seslMake(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2) {
        return makeInternal(context, view, charSequence, i, i2, false, 2);
    }

    @NonNull
    @Deprecated(since = "Use seslMake instead")
    public static Snackbar make(@NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2) {
        return seslMake(view, charSequence, i, i2);
    }

    @NonNull
    public static Snackbar seslMake(@NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2, boolean z) {
        return makeInternal(null, view, charSequence, i, i2, z, 2);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar setText(@StringRes int i) {
        return setText(getContext().getText(i));
    }

    @NonNull
    @Deprecated(since = "Use seslMake instead")
    public static Snackbar make(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2) {
        return seslMake(context, view, charSequence, i, i2);
    }

    @NonNull
    public static Snackbar make(@NonNull View view, @StringRes int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }

    @NonNull
    public static Snackbar seslMake(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2, boolean z) {
        return makeInternal(context, view, charSequence, i, i2, z, 2);
    }

    @NonNull
    public static Snackbar seslMake(@NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2, @SeslSnackBarBlurMode Integer num) {
        return makeInternal(null, view, charSequence, i, i2, false, num);
    }

    @NonNull
    public static Snackbar seslMake(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i, @SeslSnackBarType int i2, Integer num) {
        return makeInternal(context, view, charSequence, i, i2, false, num);
    }
}
