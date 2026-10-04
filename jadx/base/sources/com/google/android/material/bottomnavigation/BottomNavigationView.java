package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.oneui.common.BlurSupportable;
import androidx.appcompat.oneui.common.internal.policy.BlurInfoState;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.view.SeslTouchTargetDelegate;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.C4548R;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.strategy.StrategyFactory;
import com.google.android.material.navigation.strategy.ViewTypeStrategy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class BottomNavigationView extends NavigationBarView implements BlurSupportable {
    static final int MAX_ITEM_COUNT = 5;
    private Drawable mBackgroundDrawable;
    private SemBlurInfoState mBlurInfo;
    private int mBlurMode;
    boolean mIsFloatingStyle;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListenerForTD;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private void addCompatibilityTopDivider(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, C4548R.color.sesl_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_shadow_height)));
        addView(view);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.2
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                relativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + relativePadding.bottom;
                boolean z = ViewCompat.getLayoutDirection(view) == 1;
                int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
                int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
                relativePadding.start += z ? systemWindowInsetRight : systemWindowInsetLeft;
                int i = relativePadding.end;
                if (!z) {
                    systemWindowInsetLeft = systemWindowInsetRight;
                }
                relativePadding.end = i + systemWindowInsetLeft;
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    @NonNull
    @RequiresApi(35)
    private SemBlurInfoState generateBlurInfo(@NonNull Context context) {
        float dimension = context.getResources().getDimension(C4548R.dimen.sesl_bottom_navigation_icon_only_mode_background_radius);
        SemBlurInfoStateBuilder semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder = BlurInfoState.INSTANCE.generateFloatingComponentBlurInfoStateBuilder(context, this.mBlurMode);
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable != null) {
            semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.nonBlurBackground(drawable);
        }
        return semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.cornerRadius(dimension).build();
    }

    private int makeMinHeightSpec(int i) {
        return View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight(), 1073741824);
    }

    private void seslRemoveListenerForTouchDelegate() {
        if (this.mOnGlobalLayoutListenerForTD != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListenerForTD);
            this.mOnGlobalLayoutListenerForTD = null;
        }
    }

    private void seslSetTouchDelegateForBottomBar() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver == null || this.mOnGlobalLayoutListenerForTD != null) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                final BottomNavigationView bottomNavigationView = BottomNavigationView.this;
                if (bottomNavigationView != null) {
                    bottomNavigationView.post(new Runnable() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View childAt;
                            SeslTouchTargetDelegate seslTouchTargetDelegate = new SeslTouchTargetDelegate(bottomNavigationView);
                            int childCount = bottomNavigationView.getChildCount();
                            boolean z = false;
                            int i = 0;
                            while (true) {
                                if (i >= childCount) {
                                    childAt = null;
                                    break;
                                }
                                childAt = bottomNavigationView.getChildAt(i);
                                if (childAt instanceof BottomNavigationMenuView) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (childAt != null && childAt.getVisibility() == 0) {
                                ViewGroup viewGroup = (ViewGroup) childAt;
                                int childCount2 = viewGroup.getChildCount();
                                int i2 = 0;
                                boolean z2 = false;
                                while (i2 < childCount2) {
                                    View childAt2 = viewGroup.getChildAt(i2);
                                    if (childAt2.getVisibility() == 0) {
                                        int measuredHeight = childAt2.getMeasuredHeight() / 2;
                                        seslTouchTargetDelegate.addTouchDelegate(childAt2, SeslTouchTargetDelegate.ExtraInsets.m1781of(i2 == 0 ? measuredHeight : 0, measuredHeight, i2 == childCount2 + (-1) ? measuredHeight : 0, measuredHeight));
                                        z2 = true;
                                    }
                                    i2++;
                                }
                                z = z2;
                            }
                            if (z) {
                                bottomNavigationView.setTouchDelegate(seslTouchTargetDelegate);
                            }
                        }
                    });
                }
            }
        };
        this.mOnGlobalLayoutListenerForTD = onGlobalLayoutListener;
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStrategy(int i) {
        ViewTypeStrategy viewTypeStrategyCreateStrategy = StrategyFactory.INSTANCE.createStrategy(i, this.mIsFloatingStyle);
        viewTypeStrategyCreateStrategy.applyNavigationBarStyle(this);
        MenuView menuView = getMenuView();
        if (menuView instanceof BottomNavigationMenuView) {
            ((BottomNavigationMenuView) menuView).setStrategy(viewTypeStrategyCreateStrategy);
            if (viewTypeStrategyCreateStrategy.getIsFloatingStyle()) {
                setClipToPadding(false);
                setClipChildren(false);
            }
        }
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean applyBlurInfo(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 35) {
            return false;
        }
        clearBlurInfo(context);
        SemBlurInfoState semBlurInfoStateGenerateBlurInfo = generateBlurInfo(context);
        if (semBlurInfoStateGenerateBlurInfo.applyBlurInfo(this)) {
            this.mBlurInfo = semBlurInfoStateGenerateBlurInfo;
            return true;
        }
        this.mBlurInfo = null;
        return false;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void clearBlurInfo(@NonNull Context context) {
        SemBlurInfoState semBlurInfoState = this.mBlurInfo;
        if (semBlurInfoState != null) {
            semBlurInfoState.clearBlurInfo(this);
            this.mBlurInfo = null;
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean isBlurApplied() {
        return this.mBlurInfo != null;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, makeMinHeightSpec(i2));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            seslSetTouchDelegateForBottomBar();
        } else {
            seslRemoveListenerForTouchDelegate();
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void seslSetGroupDividerEnabled(boolean z) {
        super.seslSetGroupDividerEnabled(z);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.mBackgroundDrawable = drawable;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void setBlurMode(int i) {
        this.mBlurMode = i;
        applyBlurInfo(getContext());
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.isItemHorizontalTranslationEnabled() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, C4548R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mBlurMode = 2;
        Context context2 = getContext();
        TintTypedArray tintTypedArrayObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, C4548R.styleable.BottomNavigationView, i, i2, new int[0]);
        setItemHorizontalTranslationEnabled(tintTypedArrayObtainTintedStyledAttributes.getBoolean(C4548R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        if (tintTypedArrayObtainTintedStyledAttributes.getBoolean(C4548R.styleable.BottomNavigationView_compatShadowEnabled, true) && shouldDrawCompatibilityTopDivider()) {
            addCompatibilityTopDivider(context2);
        }
        boolean z = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C4548R.styleable.BottomNavigationView_seslMenuViewWrapContent, false);
        boolean z2 = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C4548R.styleable.BottomNavigationView_seslBottomBarApplyBlur, false);
        if (z2) {
            applyBlurInfo(context2);
        }
        this.mIsFloatingStyle = z;
        if (z && z2 && !ContextHelperKt.isDefaultTheme(context2)) {
            setBackground(context2.getDrawable(C4548R.drawable.sesl_bottom_navigation_floating_background_for_theme));
        }
        MenuView menuView = getMenuView();
        if (menuView instanceof BottomNavigationMenuView) {
            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) menuView;
            bottomNavigationMenuView.isWrapContent = z;
            if (this.mIsFloatingStyle && !ContextHelperKt.isDefaultTheme(context2)) {
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(getResources().getColor(C4548R.color.sesl_bottom_navigation_floating_icon_text_for_theme));
                bottomNavigationMenuView.setIconTintList(colorStateListValueOf);
                setItemTextColor(colorStateListValueOf);
            }
            bottomNavigationMenuView.setViewTypeChangeListener(new BottomNavigationMenuView.ViewTypeChangeListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.1
                @Override // com.google.android.material.bottomnavigation.BottomNavigationMenuView.ViewTypeChangeListener
                public void onViewTypeChanged(int i4) {
                    BottomNavigationView.this.updateStrategy(i4);
                }
            });
            updateStrategy(bottomNavigationMenuView.getViewType());
        }
        tintTypedArrayObtainTintedStyledAttributes.recycle();
    }
}
