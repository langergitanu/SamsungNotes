package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.reflect.p112os.SeslBuildReflector;
import com.google.android.material.C4548R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.model.AppBarModel;
import com.google.android.material.appbar.model.view.AppBarView;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 23)
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = C4548R.style.Widget_Design_CollapsingToolbar;
    private static final float EPSILON = 1.0E-5f;
    private static final float LAND_HEIGHT_PERCENT = 0.3f;
    private static final float MAX_FONT_SCALE = 1.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected static final String TAG = "Sesl_CTL";
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    @NonNull
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;

    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;

    @Nullable
    WindowInsetsCompat lastInsets;
    private View mCustomSubTitleView;
    private float mDefaultHeight;
    private int mExtendSubTitleAppearance;
    private int mExtendTitleAppearance;

    @Nullable
    private TextView mExtendedSubTitle;
    private TextView mExtendedTitle;
    private boolean mFadeToolbarTitle;
    private float mHeightProportion;
    private boolean mIsCollapsingToolbarTitleCustom;
    private boolean mIsCustomAccessibility;
    private StackViewGroup mStackViewGroup;
    private boolean mSubTitleEnabled;
    HashMap<AppBarModel, AppBarView> mSuggestViewHashMap;
    private boolean mSupportActionModeOverLay;
    private boolean mTitleEnabled;
    private LinearLayout mTitleLayout;
    private LinearLayout mTitleLayoutParent;
    private ViewStubCompat mViewStubCompat;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private final TimeInterpolator scrimAnimationFadeInInterpolator;
    private final TimeInterpolator scrimAnimationFadeOutInterpolator;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;

    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;

    @Nullable
    private ViewGroup toolbar;

    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
            CollapsingToolbarLayout.this.updateDefaultHeight();
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x016f  */
        /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.currentOffset = i;
            FrameLayout rootView = collapsingToolbarLayout.mStackViewGroup.getRootView();
            rootView.setTranslationY((-CollapsingToolbarLayout.this.currentOffset) / 3.0f);
            WindowInsetsCompat windowInsetsCompat = CollapsingToolbarLayout.this.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                if (CollapsingToolbarLayout.this.toolbar != null && (childAt instanceof ActionBarContextView) && !CollapsingToolbarLayout.this.mIsCustomAccessibility) {
                    if (((ActionBarContextView) childAt).getIsActionModeAccessibilityOn()) {
                        CollapsingToolbarLayout.this.toolbar.setImportantForAccessibility(4);
                    } else {
                        CollapsingToolbarLayout.this.toolbar.setImportantForAccessibility(1);
                    }
                }
                int i4 = layoutParams.collapseMode;
                if (i4 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i4 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round((-i) * layoutParams.parallaxMult));
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.statusBarScrim != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            if (!CollapsingToolbarLayout.this.mTitleEnabled) {
                if (CollapsingToolbarLayout.this.collapsingTitleEnabled) {
                    CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction(Math.abs(i) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
                    return;
                }
                return;
            }
            appBarLayout.getWindowVisibleDisplayFrame(new Rect());
            float height = CollapsingToolbarLayout.this.getHeight() * 0.143f;
            float fAbs = Math.abs(appBarLayout.getTop());
            float f = 0.0f;
            float f4 = 255.0f - ((fAbs - 0.0f) * (100.0f / height));
            if (f4 < 0.0f) {
                f4 = 0.0f;
            } else if (f4 > 255.0f || (i == 0 && f4 < 255.0f)) {
                f4 = 255.0f;
            }
            float f5 = f4 / 255.0f;
            boolean z = appBarLayout.getBottom() <= ((int) CollapsingToolbarLayout.this.mDefaultHeight) || appBarLayout.seslIsCollapsed();
            rootView.setAlpha(z ? 0.0f : f5);
            if (!(CollapsingToolbarLayout.this.toolbar instanceof Toolbar)) {
                return;
            }
            Toolbar toolbar = (Toolbar) CollapsingToolbarLayout.this.toolbar;
            if (f5 == 1.0f) {
                toolbar.setTitleAccessibilityEnabled(false);
            } else if (f5 == 0.0f) {
                toolbar.setTitleAccessibilityEnabled(true);
            }
            if (!z) {
                float height2 = (fAbs - (CollapsingToolbarLayout.this.getHeight() * 0.35f)) * (150.0f / height);
                if (height2 >= 0.0f) {
                    if (height2 <= 255.0f) {
                        f = height2;
                    }
                }
                int i5 = (int) f;
                float f6 = f / 255.0f;
                if (CollapsingToolbarLayout.this.mFadeToolbarTitle) {
                    toolbar.seslSetTitleAlpha(f6);
                    Drawable background = toolbar.getBackground();
                    if (background != null) {
                        background.mutate().setAlpha(i5);
                    }
                }
                if (TextUtils.isEmpty(toolbar.getSubtitle())) {
                    toolbar.seslSetSubtitleAlpha(f6);
                    return;
                }
                return;
            }
            toolbar.setTitleAccessibilityEnabled(true);
            f = 255.0f;
            int i52 = (int) f;
            float f62 = f / 255.0f;
            if (CollapsingToolbarLayout.this.mFadeToolbarTitle) {
            }
            if (TextUtils.isEmpty(toolbar.getSubtitle())) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void animateScrim(int i) {
        ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.scrimAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(i > this.scrimAlpha ? this.scrimAnimationFadeInInterpolator : this.scrimAnimationFadeOutInterpolator);
            this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(this.scrimAlpha, i);
        this.scrimAnimator.start();
    }

    private TextUtils.TruncateAt convertEllipsizeToTruncateAt(int i) {
        return i != 0 ? i != 1 ? i != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout appBarLayout) {
        if (isTitleCollapseFadeMode()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void ensureToolbar() {
        if (this.refreshToolbar) {
            ViewGroup viewGroup = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i = this.toolbarId;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.toolbar = viewGroup2;
                if (viewGroup2 != null) {
                    this.toolbarDirectChild = findDirectChild(viewGroup2);
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i2);
                    if (isToolbar(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i2++;
                }
                this.toolbar = viewGroup;
                ViewStubCompat viewStubCompat = this.mViewStubCompat;
                if (viewStubCompat != null) {
                    viewStubCompat.bringToFront();
                    this.mViewStubCompat.invalidate();
                }
            }
            updateDummyView();
            this.refreshToolbar = false;
        }
    }

    @NonNull
    private View findDirectChild(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListOrNull = MaterialColors.getColorStateListOrNull(getContext(), C4548R.attr.colorSurfaceContainer);
        if (colorStateListOrNull != null) {
            return colorStateListOrNull.getDefaultColor();
        }
        return this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(C4548R.dimen.design_appbar_elevation));
    }

    private static int getHeightWithMargins(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getStatusbarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
        if (identifier > 0) {
            return getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    private static CharSequence getToolbarTitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(C4548R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(C4548R.id.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private TextView initSubTitle() {
        TextView textView = (TextView) findViewById(C4548R.id.collapsing_appbar_extended_subtitle);
        textView.setTextAppearance(getContext(), this.mExtendSubTitleAppearance);
        return textView;
    }

    private TextView initTitle(@NonNull Context context) {
        TextView textView = (TextView) findViewById(C4548R.id.collapsing_appbar_extended_title);
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setHyphenationFrequency(1);
        }
        textView.setTextAppearance(context, this.mExtendTitleAppearance);
        textView.setVisibility(0);
        return textView;
    }

    private void initTitleLayout(@NonNull Context context, CharSequence charSequence) {
        int statusbarHeight;
        StackViewGroup stackViewGroup = new StackViewGroup(new FrameLayout(context));
        this.mStackViewGroup = stackViewGroup;
        FrameLayout rootView = stackViewGroup.getRootView();
        addView(rootView);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C4548R.layout.sesl_app_bar, (ViewGroup) rootView, false);
        this.mStackViewGroup.push(viewGroup);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(C4548R.id.collapsing_appbar_title_layout_parent);
        this.mTitleLayoutParent = linearLayout;
        if (linearLayout != null && (statusbarHeight = getStatusbarHeight()) > 0) {
            setBottomPadding(this.mTitleLayoutParent, statusbarHeight);
        }
        this.mTitleLayout = (LinearLayout) findViewById(C4548R.id.collapsing_appbar_title_layout);
        if (this.mTitleEnabled) {
            this.mExtendedTitle = initTitle(context);
        }
        if (this.mSubTitleEnabled) {
            seslSetSubtitle(charSequence);
        }
    }

    private boolean isTitleCollapseFadeMode() {
        return this.titleCollapseMode == 1;
    }

    private static boolean isToolbar(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.toolbarDirectChild;
        return (view2 == null || view2 == this) ? view == this.toolbar : view == view2;
    }

    private void setBottomPadding(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    private void updateCollapsedBounds(boolean z) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.toolbarDirectChild;
        if (view == null) {
            view = this.toolbar;
        }
        int maxOffsetForPinChild = getMaxOffsetForPinChild(view);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        } else {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        Rect rect = this.tmpRect;
        int i = rect.left + (z ? titleMarginEnd : titleMarginStart);
        int i2 = rect.top + maxOffsetForPinChild + titleMarginTop;
        int i4 = rect.right;
        if (!z) {
            titleMarginStart = titleMarginEnd;
        }
        collapsingTextHelper.setCollapsedBounds(i, i2, i4 - titleMarginStart, (rect.bottom + maxOffsetForPinChild) - titleMarginBottom);
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, int i, int i2) {
        updateContentScrimBounds(drawable, this.toolbar, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultHeight() {
        if (!(getParent() instanceof AppBarLayout)) {
            this.mDefaultHeight = getResources().getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding);
            return;
        }
        AppBarLayout appBarLayout = (AppBarLayout) getParent();
        if (appBarLayout.useCollapsedHeight()) {
            this.mDefaultHeight = appBarLayout.seslGetCollapsedHeight();
        } else {
            this.mDefaultHeight = getResources().getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding);
        }
    }

    private void updateDummyView() {
        View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.dummyView);
            }
        }
        if (!this.collapsingTitleEnabled || this.toolbar == null) {
            return;
        }
        if (this.dummyView == null) {
            this.dummyView = new View(getContext());
        }
        if (this.dummyView.getParent() == null) {
            this.toolbar.addView(this.dummyView, -1, -1);
        }
    }

    private void updateTextBounds(int i, int i2, int i4, int i5, boolean z) {
        View view;
        if (!this.collapsingTitleEnabled || (view = this.dummyView) == null) {
            return;
        }
        boolean z2 = ViewCompat.isAttachedToWindow(view) && this.dummyView.getVisibility() == 0;
        this.drawCollapsingTitle = z2;
        if (z2 || z) {
            boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
            updateCollapsedBounds(z3);
            this.collapsingTextHelper.setExpandedBounds(z3 ? this.expandedMarginEnd : this.expandedMarginStart, this.tmpRect.top + this.expandedMarginTop, (i4 - i) - (z3 ? this.expandedMarginStart : this.expandedMarginEnd), (i5 - i2) - this.expandedMarginBottom);
            this.collapsingTextHelper.recalculate(z);
        }
    }

    private void updateTitleFromToolbarIfNeeded() {
        if (this.toolbar != null && this.collapsingTitleEnabled && TextUtils.isEmpty(this.collapsingTextHelper.getText())) {
            setTitle(getToolbarTitle(this.toolbar));
        }
    }

    private void updateTitleLayout() {
        Resources resources = getResources();
        this.mHeightProportion = SeslAppBarHelper.INSTANCE.getAppBarProPortion(getContext());
        if (this.mTitleEnabled) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.mExtendTitleAppearance, C0419R.styleable.TextAppearance);
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(C0419R.styleable.TextAppearance_android_textSize);
            if (typedValuePeekValue == null) {
                Log.i(TAG, "ExtendTitleAppearance value is null");
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            float fComplexToFloat = TypedValue.complexToFloat(typedValuePeekValue.data);
            float fMin = Math.min(resources.getConfiguration().fontScale, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            StringBuilder sb = new StringBuilder("updateTitleLayout : context : ");
            sb.append(getContext());
            sb.append(", textSize : ");
            sb.append(fComplexToFloat);
            sb.append(", fontScale : ");
            sb.append(fMin);
            sb.append(", mSubTitleEnabled : ");
            AbstractC0000a.m27x(sb, this.mSubTitleEnabled, TAG);
            if (this.mSubTitleEnabled) {
                this.mExtendedTitle.setTextSize(0, resources.getDimensionPixelSize(C4548R.dimen.sesl_appbar_extended_title_text_size_with_subtitle));
                TextView textView = this.mExtendedSubTitle;
                if (textView != null) {
                    textView.setTextSize(0, resources.getDimensionPixelSize(C4548R.dimen.sesl_appbar_extended_subtitle_text_size));
                }
            } else {
                this.mExtendedTitle.setTextSize(1, fComplexToFloat * fMin);
            }
            if (Math.abs(this.mHeightProportion - 0.3f) >= EPSILON || !this.mSubTitleEnabled) {
                this.mExtendedTitle.setSingleLine(false);
                this.mExtendedTitle.setMaxLines(2);
            } else {
                this.mExtendedTitle.setSingleLine(true);
                this.mExtendedTitle.setMaxLines(1);
            }
            int maxLines = this.mExtendedTitle.getMaxLines();
            if (SeslBuildReflector.SeslVersionReflector.getField_SEM_PLATFORM_INT() >= 120000) {
                if (maxLines > 1) {
                    try {
                        int statusbarHeight = getStatusbarHeight();
                        if (this.mSubTitleEnabled && statusbarHeight > 0) {
                            statusbarHeight += getResources().getDimensionPixelSize(C0419R.dimen.sesl_action_bar_top_padding);
                        }
                        setBottomPadding(this.mTitleLayoutParent, statusbarHeight);
                    } catch (Exception e) {
                        Log.e(TAG, Log.getStackTraceString(e));
                    }
                } else {
                    this.mExtendedTitle.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    TextViewCompat.setAutoSizeTextTypeWithDefaults(this.mExtendedTitle, 0);
                    this.mExtendedTitle.setTextSize(0, resources.getDimensionPixelSize(C4548R.dimen.sesl_appbar_extended_title_text_size_with_subtitle));
                }
            }
        }
        Iterator<AppBarView> it = this.mSuggestViewHashMap.values().iterator();
        while (it.hasNext()) {
            it.next().updateResource(getContext());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        super.addView(view, layoutParams);
        if (!this.mTitleEnabled || (layoutParams2 = (LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        boolean zSeslIsTitleCustom = layoutParams2.seslIsTitleCustom();
        this.mIsCollapsingToolbarTitleCustom = zSeslIsTitleCustom;
        if (zSeslIsTitleCustom) {
            TextView textView = this.mExtendedTitle;
            if (textView != null && textView.getParent() == this.mTitleLayout) {
                this.mExtendedTitle.setVisibility(8);
            }
            TextView textView2 = this.mExtendedSubTitle;
            if (textView2 != null && textView2.getParent() == this.mTitleLayout) {
                this.mExtendedSubTitle.setVisibility(8);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mTitleLayout.addView(view, layoutParams);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            if (this.toolbar == null || this.contentScrim == null || this.scrimAlpha <= 0 || !isTitleCollapseFadeMode() || this.collapsingTextHelper.getExpansionFraction() >= this.collapsingTextHelper.getFadeModeThresholdFraction()) {
                this.collapsingTextHelper.draw(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
                this.collapsingTextHelper.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.statusBarScrim == null || this.scrimAlpha <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), systemWindowInsetTop - this.currentOffset);
            this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
            this.statusBarScrim.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
            z = false;
        } else {
            updateContentScrimBounds(this.contentScrim, view, getWidth(), getHeight());
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.getCollapsedTextGravity();
        }
        return 0;
    }

    public float getCollapsedTitleTextSize() {
        return this.collapsingTextHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTitleEnabled ? this.collapsingTextHelper.getCollapsedTypeface() : Typeface.DEFAULT;
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        if (this.mTitleEnabled) {
            return this.mExtendedTitle.getGravity();
        }
        if (this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.getExpandedTextGravity();
        }
        return 0;
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public float getExpandedTitleTextSize() {
        return this.collapsingTextHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.mTitleEnabled ? this.mExtendedTitle.getTypeface() : this.collapsingTitleEnabled ? this.collapsingTextHelper.getExpandedTypeface() : Typeface.DEFAULT;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.scrimVisibleHeightTrigger;
        if (i >= 0) {
            return i + this.topInsetApplied + this.extraMultilineHeight;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public CharSequence getSubTitle() {
        TextView textView;
        TextView textView2 = this.mExtendedSubTitle;
        if (textView2 == null || textView2.getVisibility() != 0 || (textView = this.mExtendedSubTitle) == null) {
            return null;
        }
        return textView.getText();
    }

    @Nullable
    public CharSequence getTitle() {
        return this.collapsingTitleEnabled ? this.collapsingTextHelper.getText() : this.mExtendedTitle.getText();
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.getPositionInterpolator();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.collapsingTextHelper.getTitleTextEllipsize();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.mTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            disableLiftOnScrollIfNeeded(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.onOffsetChangedListener);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
        }
        this.mHeightProportion = SeslAppBarHelper.INSTANCE.getAppBarProPortion(getContext());
        updateDefaultHeight();
        updateTitleLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            getViewOffsetHelper(getChildAt(i7)).onViewLayout();
        }
        updateTextBounds(i, i2, i4, i5, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            getViewOffsetHelper(getChildAt(i8)).applyOffsets();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        ensureToolbar();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && systemWindowInsetTop > 0) {
            this.topInsetApplied = systemWindowInsetTop;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.extraMultilineHeightEnabled && this.collapsingTitleEnabled && this.collapsingTextHelper.getMaxLines() > 1) {
            updateTitleFromToolbarIfNeeded();
            collapsingToolbarLayout = this;
            collapsingToolbarLayout.updateTextBounds(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int expandedLineCount = collapsingToolbarLayout.collapsingTextHelper.getExpandedLineCount();
            if (expandedLineCount > 1) {
                collapsingToolbarLayout.extraMultilineHeight = (expandedLineCount - 1) * Math.round(collapsingToolbarLayout.collapsingTextHelper.getExpandedTextFullHeight());
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + collapsingToolbarLayout.extraMultilineHeight, 1073741824));
            }
        } else {
            collapsingToolbarLayout = this;
        }
        ViewGroup viewGroup = collapsingToolbarLayout.toolbar;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.toolbarDirectChild;
            if (view == null || view == collapsingToolbarLayout) {
                setMinimumHeight(getHeightWithMargins(viewGroup));
            } else {
                setMinimumHeight(getHeightWithMargins(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            updateContentScrimBounds(drawable, i, i2);
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void seslEnableFadeToolbarTitle(boolean z) {
        this.mFadeToolbarTitle = z;
    }

    public View seslGetCustomSubtitle() {
        return this.mCustomSubTitleView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int seslGetMinimumHeightWithoutMargin() {
        int i;
        View view = this.toolbar;
        if (view == null) {
            i = 0;
        } else {
            View view2 = this.toolbarDirectChild;
            if (view2 != null && view2 != this) {
                view = view2;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
        }
        return ViewCompat.getMinimumHeight(this) - i;
    }

    public boolean seslIsCustomAccessibility() {
        return this.mIsCustomAccessibility;
    }

    public void seslSetCustomSubtitle(View view) {
        if (view != null) {
            this.mSubTitleEnabled = true;
            this.mCustomSubTitleView = view;
            if (this.mTitleEnabled) {
                this.mTitleLayout.addView(view);
            }
        } else {
            this.mSubTitleEnabled = false;
            View view2 = this.mCustomSubTitleView;
            if (view2 != null) {
                ((ViewGroup) view2.getParent()).removeView(this.mCustomSubTitleView);
                this.mCustomSubTitleView = null;
            }
        }
        updateTitleLayout();
        requestLayout();
    }

    public void seslSetCustomTitleView(View view, LayoutParams layoutParams) {
        boolean zSeslIsTitleCustom = layoutParams.seslIsTitleCustom();
        this.mIsCollapsingToolbarTitleCustom = zSeslIsTitleCustom;
        if (!zSeslIsTitleCustom) {
            super.addView(view, layoutParams);
            return;
        }
        TextView textView = this.mExtendedTitle;
        if (textView != null && textView.getParent() == this.mTitleLayout) {
            this.mExtendedTitle.setVisibility(8);
        }
        TextView textView2 = this.mExtendedSubTitle;
        if (textView2 != null && textView2.getParent() == this.mTitleLayout) {
            this.mExtendedSubTitle.setVisibility(8);
        }
        this.mTitleLayout.addView(view, layoutParams);
    }

    public void seslSetSubtitle(@StringRes int i) {
        seslSetSubtitle(getContext().getText(i));
    }

    public void seslSetSuggestView(@Nullable AppBarModel appBarModel) {
        Iterator<AppBarModel> it = this.mSuggestViewHashMap.keySet().iterator();
        while (it.hasNext()) {
            this.mStackViewGroup.remove(this.mSuggestViewHashMap.get(it.next()));
        }
        this.mSuggestViewHashMap.clear();
        if (appBarModel != null) {
            AppBarView appBarViewCreate = appBarModel.create();
            this.mSuggestViewHashMap.put(appBarModel, appBarViewCreate);
            this.mStackViewGroup.push(appBarViewCreate);
        }
        if (getParent() instanceof AppBarLayout) {
            ((AppBarLayout) getParent()).seslSetSuggestion(!this.mSuggestViewHashMap.isEmpty());
        }
    }

    public void seslSetUseCustomAccessibility(boolean z) {
        this.mIsCustomAccessibility = z;
    }

    public void setCollapsedTitleGravity(int i) {
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setCollapsedTextGravity(i);
        }
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setCollapsedTextAppearance(i);
        }
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextSize(float f) {
        this.collapsingTextHelper.setCollapsedTextSize(f);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setCollapsedTypeface(typeface);
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.contentScrim = drawableMutate;
            if (drawableMutate != null) {
                drawableMutate.setBounds(0, 0, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        if (this.mTitleEnabled) {
            this.mExtendedTitle.setGravity(i);
        } else if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setExpandedTextGravity(i);
        }
    }

    public void setExpandedTitleMargin(int i, int i2, int i4, int i5) {
        this.expandedMarginStart = i;
        this.expandedMarginTop = i2;
        this.expandedMarginEnd = i4;
        this.expandedMarginBottom = i5;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.expandedMarginBottom = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.expandedMarginEnd = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.expandedMarginStart = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.expandedMarginTop = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        if (this.mTitleEnabled) {
            this.mExtendedTitle.setTextAppearance(getContext(), i);
        } else if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setExpandedTextAppearance(i);
        }
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        if (this.mTitleEnabled) {
            this.mExtendedTitle.setTextColor(colorStateList);
        } else if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setExpandedTextColor(colorStateList);
        }
    }

    public void setExpandedTitleTextSize(float f) {
        this.collapsingTextHelper.setExpandedTextSize(f);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        if (this.mTitleEnabled) {
            this.mExtendedTitle.setTypeface(typeface);
        } else if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setExpandedTypeface(typeface);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z) {
        this.extraMultilineHeightEnabled = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.forceApplySystemWindowInsetTop = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i) {
        this.collapsingTextHelper.setHyphenationFrequency(i);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f) {
        this.collapsingTextHelper.setLineSpacingAdd(f);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f) {
        this.collapsingTextHelper.setLineSpacingMultiplier(f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i) {
        this.collapsingTextHelper.setMaxLines(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(z);
    }

    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.scrimAlpha) {
            if (this.contentScrim != null && (viewGroup = this.toolbar) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.scrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        this.scrimAnimationDuration = j;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        if (this.scrimVisibleHeightTrigger != i) {
            this.scrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.collapsingTextHelper.setStaticLayoutBuilderConfigurer(staticLayoutBuilderConfigurer);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.statusBarScrim = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(this));
                this.statusBarScrim.setVisible(getVisibility() == 0, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setText(charSequence);
            updateContentDescriptionFromTitle();
        } else {
            TextView textView = this.mExtendedTitle;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
        updateTitleLayout();
    }

    public void setTitleCollapseMode(int i) {
        this.titleCollapseMode = i;
        boolean zIsTitleCollapseFadeMode = isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(zIsTitleCollapseFadeMode);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            disableLiftOnScrollIfNeeded((AppBarLayout) parent);
        }
        if (zIsTitleCollapseFadeMode && this.contentScrim == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.collapsingTextHelper.setTitleTextEllipsize(truncateAt);
    }

    public void setTitleEnabled(boolean z) {
        TextView textView;
        if (!z) {
            this.mTitleEnabled = false;
            this.collapsingTitleEnabled = false;
        } else if (this.mExtendedTitle != null) {
            this.mTitleEnabled = true;
        } else {
            this.mTitleEnabled = false;
        }
        if (!z && !this.mTitleEnabled && (textView = this.mExtendedTitle) != null) {
            textView.setVisibility(4);
        }
        if (z && this.collapsingTitleEnabled) {
            updateDummyView();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.collapsingTextHelper.setPositionInterpolator(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarScrim;
        if (drawable != null && drawable.isVisible() != z) {
            this.statusBarScrim.setVisible(z, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.contentScrim.setVisible(z, false);
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim == null && this.statusBarScrim == null) {
            return;
        }
        setScrimsShown(getHeight() + this.currentOffset < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.collapsingToolbarLayoutStyle);
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, @Nullable View view, int i, int i2) {
        if (isTitleCollapseFadeMode() && view != null && this.collapsingTitleEnabled) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    public void seslSetSubtitle(CharSequence charSequence) {
        if (!this.mTitleEnabled || TextUtils.isEmpty(charSequence)) {
            this.mSubTitleEnabled = false;
            TextView textView = this.mExtendedSubTitle;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            this.mSubTitleEnabled = true;
            if (this.mExtendedSubTitle == null) {
                this.mExtendedSubTitle = initSubTitle();
            }
            this.mExtendedSubTitle.setText(charSequence);
            this.mExtendedSubTitle.setVisibility(0);
            TextView textView2 = this.mExtendedTitle;
            if (textView2 != null) {
                textView2.setTextSize(0, getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_appbar_extended_title_text_size_with_subtitle));
            }
        }
        updateTitleLayout();
        requestLayout();
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        if (this.collapsingTitleEnabled) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.scrimsAreShown != z) {
            if (z2) {
                animateScrim(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.scrimsAreShown = z;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        this.scrimVisibleHeightTrigger = -1;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        this.mIsCustomAccessibility = false;
        this.mSuggestViewHashMap = new HashMap<>();
        this.mCustomSubTitleView = null;
        this.mFadeToolbarTitle = true;
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C4548R.styleable.CollapsingToolbarLayout, i, i2, new int[0]);
        this.collapsingTitleEnabled = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_titleEnabled, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_extendedTitleEnabled, true);
        this.mTitleEnabled = z;
        boolean z2 = this.collapsingTitleEnabled;
        if (z2 == z && z2) {
            this.collapsingTitleEnabled = false;
        }
        this.mSupportActionModeOverLay = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_supportActionModeOverLay, true);
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        if (this.collapsingTitleEnabled) {
            collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(false);
            collapsingTextHelper.setExpandedTextGravity(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
            collapsingTextHelper.setCollapsedTextGravity(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
            this.expandedMarginBottom = dimensionPixelSize;
            this.expandedMarginEnd = dimensionPixelSize;
            this.expandedMarginTop = dimensionPixelSize;
            this.expandedMarginStart = dimensionPixelSize;
        }
        this.elevationOverlayProvider = new ElevationOverlayProvider(context2);
        this.mExtendTitleAppearance = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_extendedTitleTextAppearance, 0);
        this.mExtendSubTitleAppearance = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_extendedSubtitleTextAppearance, 0);
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.mExtendTitleAppearance = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0);
        }
        CharSequence text = typedArrayObtainStyledAttributes.getText(C4548R.styleable.CollapsingToolbarLayout_subtitle);
        this.mSubTitleEnabled = this.mTitleEnabled && !TextUtils.isEmpty(text);
        initTitleLayout(context2, text);
        updateDefaultHeight();
        updateTitleLayout();
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        setTitle(typedArrayObtainStyledAttributes.getText(C4548R.styleable.CollapsingToolbarLayout_title));
        if (this.collapsingTitleEnabled) {
            collapsingTextHelper.setExpandedTextAppearance(C4548R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
            collapsingTextHelper.setCollapsedTextAppearance(C0419R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
                collapsingTextHelper.setExpandedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
                collapsingTextHelper.setCollapsedTextAppearance(typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_titleTextEllipsize)) {
                setTitleEllipsize(convertEllipsizeToTruncateAt(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_titleTextEllipsize, -1)));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextColor)) {
                collapsingTextHelper.setExpandedTextColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.CollapsingToolbarLayout_expandedTitleTextColor));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor)) {
                collapsingTextHelper.setCollapsedTextColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor));
            }
        }
        this.scrimVisibleHeightTrigger = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_maxLines)) {
            collapsingTextHelper.setMaxLines(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.CollapsingToolbarLayout_titlePositionInterpolator)) {
            collapsingTextHelper.setPositionInterpolator(android.view.animation.AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_titlePositionInterpolator, 0)));
        }
        this.scrimAnimationDuration = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        this.scrimAnimationFadeInInterpolator = MotionUtils.resolveThemeInterpolator(context2, C4548R.attr.motionEasingStandardInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        this.scrimAnimationFadeOutInterpolator = MotionUtils.resolveThemeInterpolator(context2, C4548R.attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(C4548R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(C4548R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.toolbarId = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.forceApplySystemWindowInsetTop = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(C0419R.styleable.AppCompatTheme);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(C0419R.styleable.AppCompatTheme_windowActionModeOverlay, false);
        if (this.mSupportActionModeOverLay && !z3) {
            LayoutInflater.from(context2).inflate(C4548R.layout.sesl_material_action_mode_view_stub, (ViewGroup) this, true);
            this.mViewStubCompat = (ViewStubCompat) findViewById(C4548R.id.action_mode_bar_stub);
        }
        typedArrayObtainStyledAttributes2.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        private boolean isTitleCustom;
        float parallaxMult;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4548R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(typedArrayObtainStyledAttributes.getFloat(C4548R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            this.isTitleCustom = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.CollapsingToolbarLayout_Layout_isCustomTitle, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public boolean seslIsTitleCustom() {
            return this.isTitleCustom;
        }

        public void seslSetIsTitleCustom(Boolean bool) {
            this.isTitleCustom = bool.booleanValue();
        }

        public void setCollapseMode(int i) {
            this.collapseMode = i;
        }

        public void setParallaxMultiplier(float f) {
            this.parallaxMult = f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int i, int i2, int i4) {
            super(i, i2, i4);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((FrameLayout.LayoutParams) layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            this.collapseMode = layoutParams.collapseMode;
            this.parallaxMult = layoutParams.parallaxMult;
        }
    }
}
