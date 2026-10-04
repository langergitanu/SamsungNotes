package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.provider.Settings;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.oneui.common.BlurSupportable;
import androidx.appcompat.oneui.common.internal.policy.BlurInfoState;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceColorRes;
import androidx.appcompat.oneui.common.internal.resource.ThemeResourceDrawableRes;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.appcompat.oneui.common.internal.util.ContextHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.util.Pair;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.reflect.widget.SeslHorizontalScrollViewReflector;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.C4548R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView implements BlurSupportable {
    private static final int ANIMATION_DURATION = 300;
    private static final int ANIM_HIDE_DURATION = 400;
    private static final float ANIM_RIPPLE_MINOR_SCALE = 0.95f;
    private static final int ANIM_SHOW_DURATION = 350;
    private static final int BADGE_N_TEXT_SIZE = 11;
    private static final int BADGE_TYPE_DOT = 2;
    private static final int BADGE_TYPE_N = 1;
    private static final int BADGE_TYPE_UNKNOWN = -1;

    @Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final int DEPTH_TYPE_CUSTOM = 3;
    private static final int DEPTH_TYPE_MAIN = 1;
    private static final int DEPTH_TYPE_SUB = 2;

    @Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    private static final int FONT_WEIGHT_REGULAR = 400;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_FADE = 2;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int SELECTED_INDICATOR_HEIGHT_DEFAULT = -1;

    @Dimension(unit = 0)
    private static final int SESL_DEFAULT_HEIGHT_WITH_TEXT = 56;

    @Dimension(unit = 0)
    private static final int SESL_DEFAULT_HEIGHT_WITH_TEXT_ICON = 56;
    public static final int SESL_MODE_FIXED_AUTO = 11;
    public static final int SESL_MODE_MAIN = 13;
    public static final int SESL_MODE_WEIGHT_AUTO = 12;

    @Dimension(unit = 0)
    private static final int SESL_SUB_DEPTH_DEFAULT_HEIGHT = 56;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @Nullable
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private final int defaultTabTextAppearance;
    int indicatorPosition;
    boolean inlineLabel;
    private ColorDrawable mBackgroundColorDrawable;
    private Drawable mBackgroundDrawable;
    private int mBadgeColor;
    private int mBadgeTextColor;
    private SemBlurInfoState mBlurInfo;
    private int mBlurMode;
    private Typeface mBoldTypeface;
    private ContentResolver mContentResolver;
    private int mCurrentTouchSlop;
    private final int mDefaultTouchSlop;
    private int mDepthStyle;
    private int mFirstTabGravity;
    private int mIconTextGap;
    private boolean mIsChangedGravityByLocal;
    private boolean mIsOverScreen;
    private boolean mIsScaledTextSizeType;
    private int mMainTabSelectedSideMargin;
    private int mMainTabSeparatorMargin;
    private int mMaxTouchSlop;
    private Typeface mNormalTypeface;
    private int mOverScreenMaxWidth;
    private int mRequestedTabWidth;
    private int mSubTabIndicator2ndHeight;
    private int mSubTabIndicatorHeight;
    private int mSubTabSelectedIndicatorColor;
    int mSubTabSubTextAppearance;
    ColorStateList mSubTabSubTextColors;
    int mSubTabTextSize;
    private int mTabMinSideSpace;
    private int mTabSelectedIndicatorColor;

    @ViewDebug.ExportedProperty(category = "tablayout")
    int mode;
    private TabLayoutOnPageChangeListener pageChangeListener;

    @Nullable
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @Nullable
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;

    @Nullable
    private Tab selectedTab;
    private int selectedTabTextAppearance;
    float selectedTabTextSize;
    private boolean setupViewPagerImplicitly;

    @NonNull
    final SlidingTabIndicator slidingTabIndicator;
    int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabIndicatorHeight;
    private TabIndicatorInterpolator tabIndicatorInterpolator;
    private final TimeInterpolator tabIndicatorTimeInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;

    @NonNull
    Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    private final int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;

    @Nullable
    ViewPager viewPager;
    private int viewPagerScrollState;
    private static final int DEF_STYLE_RES = C4548R.style.Widget_Design_TabLayout;
    private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        public AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        public void setAutoRefresh(boolean z) {
            this.autoRefresh = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface LabelVisibility {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.scrollState);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i4 = this.scrollState;
                boolean z2 = true;
                if (i4 != 2 || this.previousScrollState == 1) {
                    z = true;
                } else {
                    z = true;
                    z2 = false;
                }
                if (i4 == 2 && this.previousScrollState == 0) {
                    z = false;
                }
                tabLayout.setScrollPosition(i, f, z2, z, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class TabView extends LinearLayout {

        @Nullable
        private View badgeAnchorView;

        @Nullable
        private BadgeDrawable badgeDrawable;

        @Nullable
        private Drawable baseBackgroundDrawable;

        @Nullable
        private ImageView customIconView;

        @Nullable
        private TextView customTextView;

        @Nullable
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private CharSequence mCustomRoleDescription;
        private TextView mDotBadgeView;
        private int mIconSize;
        private SeslAbsIndicatorView mIndicatorView;
        private boolean mIsCallPerformClick;
        private View mMainTabTouchBackground;
        private TextView mNBadgeView;
        private TextView mSubTextView;
        private ConstraintLayout mTabParentView;
        View.OnKeyListener mTabViewKeyListener;
        private Tab tab;
        private TextView textView;

        public TabView(@NonNull Context context) {
            super(context);
            this.defaultMaxLines = 2;
            this.mCustomRoleDescription = null;
            this.mTabViewKeyListener = new View.OnKeyListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return false;
                }
            };
            updateBackgroundDrawable(context);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            setOnKeyListener(this.mTabViewKeyListener);
            if (TabLayout.this.mDepthStyle == 1) {
                ViewCompat.setPaddingRelative(this, 0, TabLayout.this.tabPaddingTop, 0, TabLayout.this.tabPaddingBottom);
            }
            this.mIconSize = getResources().getDimensionPixelOffset(C4548R.dimen.sesl_tab_icon_size);
        }

        private void addOnLayoutChangeListener(@Nullable final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (view.getVisibility() == 0) {
                        TabView.this.tryUpdateBadgeDrawableBounds(view);
                    }
                }
            });
        }

        private float approximateLineWidth(@NonNull Layout layout, int i, float f) {
            return (f / layout.getPaint().getTextSize()) * layout.getLineWidth(i);
        }

        private void clipViewToPaddingForBadge(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @NonNull
        private FrameLayout createPreApi18BadgeAnchorRoot() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(@NonNull Canvas canvas) {
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @Nullable
        private FrameLayout getCustomParentForBadge(@NonNull View view) {
            if ((view == this.iconView || view == this.textView) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        private void inflateAndAddDefaultIconView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot, 0);
                viewGroup = frameLayoutCreatePreApi18BadgeAnchorRoot;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_layout_tab_icon, viewGroup, false);
            this.iconView = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void inflateAndAddDefaultSubTextView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot);
                viewGroup = frameLayoutCreatePreApi18BadgeAnchorRoot;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_layout_tab_sub_text, viewGroup, false);
            this.textView = textView;
            viewGroup.addView(textView);
        }

        private void inflateAndAddDefaultTextView() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                FrameLayout frameLayoutCreatePreApi18BadgeAnchorRoot = createPreApi18BadgeAnchorRoot();
                addView(frameLayoutCreatePreApi18BadgeAnchorRoot);
                viewGroup = frameLayoutCreatePreApi18BadgeAnchorRoot;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_layout_tab_text, viewGroup, false);
            this.textView = textView;
            viewGroup.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        @RequiresApi(api = 17)
        private void seslUpdateTextAndIcon(@Nullable TextView textView, @Nullable TextView textView2, @Nullable ImageView imageView) {
            updateTextAndIcon(textView, imageView, true);
            if (textView2 != null) {
                Tab tab = this.tab;
                CharSequence charSequenceSeslGetSubText = tab != null ? tab.seslGetSubText() : null;
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
                boolean zIsEmpty = TextUtils.isEmpty(charSequenceSeslGetSubText);
                layoutParams.topToTop = !zIsEmpty ? -1 : 0;
                layoutParams.bottomToBottom = !zIsEmpty ? -1 : 0;
                layoutParams.bottomToTop = zIsEmpty ? -1 : C4548R.id.center_anchor;
                textView2.setText(zIsEmpty ? null : charSequenceSeslGetSubText);
                if (zIsEmpty) {
                    textView2.setVisibility(8);
                    return;
                }
                if (this.tab.labelVisibilityMode == 1) {
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                setVisibility(0);
            }
        }

        private boolean startTabTouchAnimation(MotionEvent motionEvent) {
            SeslAbsIndicatorView seslAbsIndicatorView;
            if (motionEvent == null || this.tab.getCustomView() != null) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (action == 0) {
                this.mIsCallPerformClick = false;
                if (this.tab.position != TabLayout.this.getSelectedTabPosition()) {
                    setSelected(true);
                    SeslAbsIndicatorView seslAbsIndicatorView2 = this.mIndicatorView;
                    if (seslAbsIndicatorView2 != null) {
                        seslAbsIndicatorView2.setPressed();
                    }
                    TabLayout tabLayout = TabLayout.this;
                    Tab tabAt = tabLayout.getTabAt(tabLayout.getSelectedTabPosition());
                    if (tabAt != null) {
                        tabAt.view.setSelected(false);
                        SeslAbsIndicatorView seslAbsIndicatorView3 = tabAt.view.mIndicatorView;
                        if (seslAbsIndicatorView3 != null) {
                            seslAbsIndicatorView3.setHide();
                        }
                    }
                } else if (this.tab.position == TabLayout.this.getSelectedTabPosition() && (seslAbsIndicatorView = this.mIndicatorView) != null) {
                    seslAbsIndicatorView.setPressed();
                }
            } else if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        TabLayout.this.seslActionCancel(this);
                    }
                } else if (TabLayout.this.isViewOutOfBounds(this, (int) rawX, (int) rawY)) {
                    TabLayout.this.seslActionCancel(this);
                }
            } else if (!TabLayout.this.isViewOutOfBounds(this, (int) rawX, (int) rawY)) {
                SeslAbsIndicatorView seslAbsIndicatorView4 = this.mIndicatorView;
                if (seslAbsIndicatorView4 != null) {
                    seslAbsIndicatorView4.setReleased();
                    this.mIndicatorView.onTouchEvent(motionEvent);
                }
                performClick();
                this.mIsCallPerformClick = true;
            }
            return super.onTouchEvent(motionEvent);
        }

        private void tryAttachBadgeToAnchor(@Nullable View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            Tab tab;
            Tab tab2;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                    View view = this.badgeAnchorView;
                    ImageView imageView = this.iconView;
                    if (view == imageView) {
                        tryUpdateBadgeDrawableBounds(imageView);
                        return;
                    } else {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                }
                if (this.textView == null || (tab = this.tab) == null || tab.getTabLabelVisibility() != 1) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                View view2 = this.badgeAnchorView;
                TextView textView = this.textView;
                if (view2 == textView) {
                    tryUpdateBadgeDrawableBounds(textView);
                } else {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@NonNull View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateBackgroundDrawable(Context context) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.tabBackgroundResId == 0 || tabLayout.mDepthStyle == 2) {
                this.baseBackgroundDrawable = null;
                return;
            }
            Drawable drawable = AppCompatResources.getDrawable(context, TabLayout.this.tabBackgroundResId);
            this.baseBackgroundDrawable = drawable;
            if (drawable != null && drawable.isStateful()) {
                this.baseBackgroundDrawable.setState(getDrawableState());
            }
            ViewCompat.setBackground(this, this.baseBackgroundDrawable);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView, boolean z) {
            Tab tab = this.tab;
            Drawable drawableMutate = (tab == null || tab.getIcon() == null) ? null : DrawableCompat.wrap(this.tab.getIcon()).mutate();
            if (drawableMutate != null) {
                TabLayout tabLayout = TabLayout.this;
                ColorStateList colorStateList = tabLayout.tabIconTint;
                if (colorStateList == null) {
                    DrawableCompat.setTintList(drawableMutate, tabLayout.tabTextColors);
                } else {
                    DrawableCompat.setTintList(drawableMutate, colorStateList);
                }
                PorterDuff.Mode mode = TabLayout.this.tabIconTintMode;
                if (mode != null) {
                    DrawableCompat.setTintMode(drawableMutate, mode);
                }
            }
            Tab tab2 = this.tab;
            CharSequence text = tab2 != null ? tab2.getText() : null;
            boolean z2 = false;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(text);
            if (textView != null) {
                if (!zIsEmpty) {
                    boolean z3 = this.tab.labelVisibilityMode == 1;
                    if (zIsEmpty) {
                        text = null;
                    }
                    textView.setText(text);
                    textView.setVisibility(z3 ? 0 : 8);
                    if (!zIsEmpty) {
                        setVisibility(0);
                    }
                    z2 = z3;
                }
            }
            if (z && imageView != null) {
                if (z2 && imageView.getVisibility() == 0) {
                    if (TabLayout.this.mIconTextGap != -1) {
                        int unused = TabLayout.this.mIconTextGap;
                    } else {
                        ViewUtils.dpToPx(getContext(), 8);
                    }
                }
            }
            Tab tab3 = this.tab;
            TooltipCompat.setTooltipText(this, zIsEmpty ? tab3 != null ? tab3.contentDesc : null : null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
        }

        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        @Nullable
        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.mIconSize = getResources().getDimensionPixelOffset(C4548R.dimen.sesl_tab_icon_size);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(-TabLayout.this.mMainTabSelectedSideMargin, 0, TabLayout.this.mMainTabSelectedSideMargin + getMeasuredWidth(), getMeasuredHeight());
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfoCompatWrap.setContentDescription(this.badgeDrawable.getContentDescription());
            }
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatWrap.setClickable(false);
                accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            CharSequence string = this.mCustomRoleDescription;
            if (string == null) {
                string = getResources().getString(C4548R.string.item_view_role_description);
            }
            accessibilityNodeInfoCompatWrap.setRoleDescription(string);
            TextView textView = this.mDotBadgeView;
            if (textView != null && textView.getVisibility() == 0 && this.mDotBadgeView.getContentDescription() != null) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + SQLKeyword.COMMA + ((Object) this.mDotBadgeView.getContentDescription()));
                return;
            }
            TextView textView2 = this.mNBadgeView;
            if (textView2 == null || textView2.getVisibility() != 0 || this.mNBadgeView.getContentDescription() == null) {
                return;
            }
            accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + SQLKeyword.COMMA + ((Object) this.mNBadgeView.getContentDescription()));
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i4, int i5) {
            TextView textView;
            super.onLayout(z, i, i2, i4, i5);
            View view = this.mMainTabTouchBackground;
            if (view != null && view.getAnimation() != null && this.mMainTabTouchBackground.getAnimation().hasEnded()) {
                this.mMainTabTouchBackground.setAlpha(0.0f);
            }
            if (this.iconView == null || this.tab.icon == null || (textView = this.textView) == null || this.mIndicatorView == null || this.mTabParentView == null) {
                return;
            }
            int measuredWidth = textView.getMeasuredWidth() + this.mIconSize;
            if (TabLayout.this.mIconTextGap != -1) {
                measuredWidth += TabLayout.this.mIconTextGap;
            }
            int iAbs = Math.abs((getWidth() - measuredWidth) / 2);
            if (!ViewUtils.isLayoutRtl(this)) {
                if (this.iconView.getLeft() == this.mTabParentView.getLeft()) {
                    this.textView.offsetLeftAndRight(iAbs);
                    this.iconView.offsetLeftAndRight(iAbs);
                    this.mIndicatorView.offsetLeftAndRight(iAbs);
                    return;
                }
                return;
            }
            int i6 = -iAbs;
            if (this.iconView.getRight() == this.mTabParentView.getRight()) {
                this.textView.offsetLeftAndRight(i6);
                this.iconView.offsetLeftAndRight(i6);
                this.mIndicatorView.offsetLeftAndRight(i6);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            TextView textView;
            Layout layout;
            TextView textView2;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            TabLayout tabLayout = TabLayout.this;
            int i4 = tabLayout.mode;
            if (i4 == 11 || i4 == 12) {
                if (mode == 0) {
                    i = View.MeasureSpec.makeMeasureSpec(tabLayout.tabMaxWidth, 0);
                } else if (mode == 1073741824) {
                    i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                }
            } else if (tabLayout.mRequestedTabWidth != -1) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.mRequestedTabWidth, 1073741824);
            } else if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            TextView textView3 = this.textView;
            if (textView3 != null && this.customView == null) {
                TabLayout tabLayout2 = TabLayout.this;
                float f = tabLayout2.tabTextSize;
                tabLayout2.checkMaxFontScale(textView3, (int) f);
                if (TabLayout.this.mDepthStyle == 2 && (textView2 = this.mSubTextView) != null) {
                    TabLayout tabLayout3 = TabLayout.this;
                    tabLayout3.checkMaxFontScale(textView2, tabLayout3.mSubTabTextSize);
                }
                int i5 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView4 = this.textView;
                    if (textView4 != null && textView4.getLineCount() > 1) {
                        f = TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    f = TabLayout.this.mSubTabTextSize;
                    i5 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.textView);
                if ((f != textSize || (maxLines >= 0 && i5 != maxLines)) && (TabLayout.this.mode != 1 || f <= textSize || lineCount != 1 || ((layout = this.textView.getLayout()) != null && approximateLineWidth(layout, 0, f) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                    this.textView.setTextSize(0, f);
                    TabLayout.this.checkMaxFontScale(this.textView, (int) f);
                    if (TabLayout.this.mDepthStyle == 2 && (textView = this.mSubTextView) != null) {
                        TabLayout tabLayout4 = TabLayout.this;
                        tabLayout4.checkMaxFontScale(textView, tabLayout4.mSubTabTextSize);
                    }
                    this.textView.setMaxLines(i5);
                    super.onMeasure(i, i2);
                }
            }
            if (this.customTextView != null || this.mTabParentView == null || this.textView == null || this.tab == null) {
                return;
            }
            TabLayout tabLayout5 = TabLayout.this;
            if (tabLayout5.mode == 0 && tabLayout5.mDepthStyle == 2) {
                if (tabMaxWidth > 0) {
                    this.textView.measure(tabMaxWidth, 0);
                } else {
                    this.textView.measure(0, 0);
                }
                int measuredWidth = this.textView.getMeasuredWidth();
                ViewGroup.LayoutParams layoutParams = this.mTabParentView.getLayoutParams();
                layoutParams.width = (getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_tablayout_subtab_side_space) * 2) + measuredWidth;
                this.mTabParentView.setLayoutParams(layoutParams);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, Integer.MIN_VALUE), i2);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return (!isEnabled() || TabLayout.this.isScrollingEnabled()) ? super.onTouchEvent(motionEvent) : this.tab.getCustomView() != null ? super.onTouchEvent(motionEvent) : startTabTouchAnimation(motionEvent);
        }

        @Override // android.view.View
        public boolean performClick() {
            if (this.mIsCallPerformClick) {
                this.mIsCallPerformClick = false;
                return true;
            }
            boolean zPerformClick = super.performClick();
            if (this.tab == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        public void seslSetRoleDescription(@Nullable CharSequence charSequence) {
            this.mCustomRoleDescription = charSequence;
        }

        @Override // android.view.View
        public void setEnabled(boolean z) {
            super.setEnabled(z);
            View view = this.mMainTabTouchBackground;
            if (view != null) {
                view.setVisibility(z ? 0 : 8);
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isEnabled()) {
                isSelected();
                super.setSelected(z);
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setSelected(z);
                    this.textView.setTypeface(isSelected() ? TabLayout.this.mBoldTypeface : TabLayout.this.mNormalTypeface);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setSelected(z);
                }
                View view = this.customView;
                if (view != null) {
                    view.setSelected(z);
                }
                SeslAbsIndicatorView seslAbsIndicatorView = this.mIndicatorView;
                if (seslAbsIndicatorView != null) {
                    seslAbsIndicatorView.setSelected(z);
                    Tab tab = this.tab;
                    if (!TextUtils.isEmpty(tab != null ? tab.seslGetSubText() : null)) {
                        ViewCompat.setBackground(this.mIndicatorView, ContextCompat.getDrawable(getContext(), SeslMisc.isLightTheme(getContext()) ? C4548R.drawable.sesl_tablayout_subtab_subtext_indicator_background_light : C4548R.drawable.sesl_tablayout_subtab_subtext_indicator_background_dark));
                    }
                }
                TextView textView2 = this.mSubTextView;
                if (textView2 != null) {
                    textView2.setSelected(z);
                }
            }
        }

        public void setShowButtonShape(int i, ColorStateList colorStateList) {
            Drawable drawable = getResources().getDrawable(C4548R.drawable.sesl_bottom_nav_show_button_shapes_background);
            if (Build.VERSION.SDK_INT < 28) {
                ViewCompat.setBackground(this, drawable);
                return;
            }
            TextView textView = this.textView;
            if (textView != null) {
                textView.setTextColor(i);
                this.textView.setBackground(drawable);
                this.textView.setBackgroundTintList(colorStateList);
            }
            TextView textView2 = this.mSubTextView;
            if (textView2 != null) {
                textView2.setTextColor(i);
                this.mSubTextView.setBackground(drawable);
                this.mSubTextView.setBackgroundTintList(colorStateList);
            }
        }

        public void setTab(@Nullable Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        public final void update() {
            updateTab();
            Tab tab = this.tab;
            setSelected(tab != null && tab.isSelected());
        }

        public final void updateOrientation() {
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            TextView textView = this.customTextView;
            if (textView == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView, true);
            } else {
                updateTextAndIcon(textView, this.customIconView, false);
            }
        }

        @RequiresApi(api = 17)
        public final void updateTab() {
            ConstraintLayout constraintLayout;
            ViewParent parent;
            Tab tab = this.tab;
            View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                ViewParent parent2 = customView.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(customView);
                    }
                    View view = this.customView;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.customView);
                    }
                    addView(customView);
                }
                this.customView = customView;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                TextView textView2 = this.mSubTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                TextView textView3 = (TextView) customView.findViewById(R.id.text1);
                this.customTextView = textView3;
                if (textView3 != null) {
                    this.defaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                this.customIconView = (ImageView) customView.findViewById(R.id.icon);
            } else {
                View view2 = this.customView;
                if (view2 != null) {
                    removeView(view2);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            boolean z = false;
            if (this.customView != null || this.tab == null) {
                TextView textView4 = this.customTextView;
                if (textView4 != null || this.customIconView != null) {
                    updateTextAndIcon(textView4, this.customIconView, false);
                }
            } else {
                if (this.mTabParentView == null) {
                    if (TabLayout.this.mDepthStyle == 2) {
                        this.mTabParentView = (ConstraintLayout) LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_tabs_sub_tab_layout, (ViewGroup) this, false);
                    } else {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_tabs_main_tab_layout, (ViewGroup) this, false);
                        this.mTabParentView = constraintLayout2;
                        View viewFindViewById = constraintLayout2.findViewById(C4548R.id.main_tab_touch_background);
                        this.mMainTabTouchBackground = viewFindViewById;
                        if (viewFindViewById != null && this.tab.icon == null) {
                            ViewCompat.setBackground(this.mMainTabTouchBackground, ContextCompat.getDrawable(getContext(), SeslMisc.isLightTheme(getContext()) ? C4548R.drawable.sesl_tablayout_maintab_touch_background_light : C4548R.drawable.sesl_tablayout_maintab_touch_background_dark));
                            this.mMainTabTouchBackground.setAlpha(0.0f);
                        }
                    }
                }
                if (this.mIndicatorView == null) {
                    this.mIndicatorView = (SeslAbsIndicatorView) this.mTabParentView.findViewById(C4548R.id.indicator);
                }
                if (TabLayout.this.mDepthStyle != 2) {
                    SeslAbsIndicatorView seslAbsIndicatorView = this.mIndicatorView;
                    if (seslAbsIndicatorView != null) {
                        seslAbsIndicatorView.setSelectedIndicatorColor(TabLayout.this.mTabSelectedIndicatorColor);
                    }
                } else if (this.mIndicatorView != null && TabLayout.this.mSubTabSelectedIndicatorColor != -1) {
                    this.mIndicatorView.setSelectedIndicatorColor(TabLayout.this.mSubTabSelectedIndicatorColor);
                }
                if (this.textView == null) {
                    this.textView = (TextView) this.mTabParentView.findViewById(C4548R.id.title);
                }
                this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
                TextViewCompat.setTextAppearance(this.textView, TabLayout.this.defaultTabTextAppearance);
                if (!isSelected() || TabLayout.this.selectedTabTextAppearance == -1) {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(this.textView, TabLayout.this.selectedTabTextAppearance);
                }
                if (isSelected()) {
                    this.textView.setTypeface(TabLayout.this.mBoldTypeface);
                } else {
                    this.textView.setTypeface(TabLayout.this.mNormalTypeface);
                }
                TabLayout tabLayout = TabLayout.this;
                tabLayout.checkMaxFontScale(this.textView, (int) tabLayout.tabTextSize);
                this.textView.setTextColor(TabLayout.this.tabTextColors);
                if (TabLayout.this.mDepthStyle == 2) {
                    if (this.mSubTextView == null) {
                        this.mSubTextView = (TextView) this.mTabParentView.findViewById(C4548R.id.sub_title);
                    }
                    TextView textView5 = this.mSubTextView;
                    if (textView5 != null) {
                        TextViewCompat.setTextAppearance(textView5, TabLayout.this.mSubTabSubTextAppearance);
                        this.mSubTextView.setTextColor(TabLayout.this.mSubTabSubTextColors);
                    }
                    TextView textView6 = this.mSubTextView;
                    if (textView6 != null) {
                        TabLayout tabLayout2 = TabLayout.this;
                        tabLayout2.checkMaxFontScale(textView6, tabLayout2.mSubTabTextSize);
                    }
                }
                if (this.iconView == null && (constraintLayout = this.mTabParentView) != null) {
                    this.iconView = (ImageView) constraintLayout.findViewById(C4548R.id.icon);
                }
                seslUpdateTextAndIcon(this.textView, this.mSubTextView, this.iconView);
                int i = -2;
                if (TabLayout.this.mDepthStyle == 2) {
                    i = TabLayout.this.mode == 0 ? -2 : -1;
                    int i2 = !TextUtils.isEmpty(tab != null ? tab.seslGetSubText() : null) ? TabLayout.this.mSubTabIndicator2ndHeight : TabLayout.this.mSubTabIndicatorHeight;
                    ConstraintLayout constraintLayout3 = this.mTabParentView;
                    if (constraintLayout3 != null && constraintLayout3.getHeight() != i2) {
                        z = true;
                    }
                    i = i;
                    i = i2;
                }
                ConstraintLayout constraintLayout4 = this.mTabParentView;
                if (constraintLayout4 != null && constraintLayout4.getParent() == null) {
                    addView(this.mTabParentView, i, i);
                } else if (z) {
                    removeView(this.mTabParentView);
                    addView(this.mTabParentView, i, i);
                }
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            }
            if (tab == null || TextUtils.isEmpty(tab.contentDesc)) {
                return;
            }
            setContentDescription(tab.contentDesc);
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        Tab tabNewTab = newTab();
        CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            tabNewTab.setText(charSequence);
        }
        Drawable drawable = tabItem.icon;
        if (drawable != null) {
            tabNewTab.setIcon(drawable);
        }
        int i = tabItem.customLayout;
        if (i != 0) {
            tabNewTab.setCustomView(i);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            tabNewTab.setContentDescription(tabItem.getContentDescription());
        }
        CharSequence charSequence2 = tabItem.mSubText;
        if (charSequence2 != null) {
            tabNewTab.seslSetSubText(charSequence2);
        }
        addTab(tabNewTab);
    }

    private void addTabView(@NonNull Tab tab) {
        TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
        if (this.mode == 13) {
            updateTabViews(true);
        }
        tabView.post(new RunnableC4199v(this, tabView, 3));
    }

    private void addViewInternal(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        addTabFromItemView((TabItem) view);
    }

    private void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.slidingTabIndicator.childrenNeedLayout()) {
            setScrollPosition(i, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iCalculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
        if (scrollX != iCalculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, iCalculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.animateIndicatorToPosition(i, this.tabIndicatorAnimationDuration);
    }

    private void applyGravityForModeScrollable(int i) {
        if (i == 0) {
            Log.w(LOG_TAG, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i == 1) {
            this.slidingTabIndicator.setGravity(1);
            return;
        } else if (i != 2) {
            return;
        }
        this.slidingTabIndicator.setGravity(8388611);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyModeAndGravity() {
        if (this.mode == 13) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(C4548R.dimen.sesl_tablayout_maintab_inner_padding);
            ViewCompat.setPaddingRelative(this.slidingTabIndicator, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        } else {
            ViewCompat.setPaddingRelative(this.slidingTabIndicator, 0, 0, 0, 0);
        }
        int i = this.mode;
        if (i == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i == 1 || i == 2) {
            if (this.tabGravity == 2) {
                Log.w(LOG_TAG, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.slidingTabIndicator.setGravity(1);
        } else {
            switch (i) {
            }
        }
        updateTabViews(true);
    }

    private void applyThemeResource() {
        if (this.mode != 13) {
            return;
        }
        this.tabTextColors = ColorStateList.valueOf(ResourcesCompat.getColor(getResources(), new ThemeResourceColorRes(C4548R.color.sesl_tablayout_text_color_default_selector_for_theme, C4548R.color.sesl_tablayout_text_color_default_selector_dark_for_theme).getResource(getContext()).intValue(), getContext().getTheme()));
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), ResourcesCompat.getColor(getResources(), new ThemeResourceColorRes(C4548R.color.sesl_tablayout_text_color_selected_for_theme, C4548R.color.sesl_tablayout_text_color_selected_dark_for_theme).getResource(getContext()).intValue(), getContext().getTheme()));
        this.tabBackgroundResId = new ThemeResourceDrawableRes(C4548R.drawable.sesl_tabview_maintab_ripple_background_for_theme, C4548R.drawable.sesl_tabview_maintab_ripple_background_dark_for_theme).getResource(getContext()).intValue();
    }

    private int calculateScrollXForTab(int i, float f) {
        View childAt;
        int i2 = this.mode;
        if ((i2 != 0 && i2 != 2 && i2 != 11 && i2 != 12) || (childAt = this.slidingTabIndicator.getChildAt(i)) == null) {
            return 0;
        }
        int i4 = i + 1;
        View childAt2 = i4 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMaxFontScale(TextView textView, int i) {
        float f = getResources().getConfiguration().fontScale;
        if (textView == null || !this.mIsScaledTextSizeType || f <= 1.3f) {
            return;
        }
        textView.setTextSize(0, (i / f) * 1.3f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOverScreen() {
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= ((int) ((getContext().getResources().getDisplayMetrics().densityDpi / 160.0f) * getResources().getInteger(C4548R.integer.sesl_tablayout_over_screen_width_dp)))) {
            this.mIsOverScreen = false;
        } else {
            this.mIsOverScreen = true;
            this.mOverScreenMaxWidth = (int) (getResources().getFloat(C4548R.dimen.sesl_tablayout_over_screen_max_width_rate) * measuredWidth);
        }
    }

    private void configureTab(@NonNull Tab tab, int i) {
        tab.setPosition(i);
        this.tabs.add(i, tab);
        int size = this.tabs.size();
        int i2 = -1;
        for (int i4 = i + 1; i4 < size; i4++) {
            if (this.tabs.get(i4).getPosition() == this.indicatorPosition) {
                i2 = i4;
            }
            this.tabs.get(i4).setPosition(i4);
        }
        this.indicatorPosition = i2;
    }

    private void createAddBadge(int i, TabView tabView) {
        int iIntValue;
        int iIntValue2;
        int paddingRight;
        int iIntValue3;
        int iIntValue4;
        if (tabView == null || tabView.mTabParentView == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        Resources resources = getResources();
        TextView textView2 = tabView.textView;
        boolean z = textView2 != null && textView2.getVisibility() == 0;
        if (i == 2) {
            if (tabView.mDotBadgeView != null) {
                return;
            }
            textView.setVisibility(8);
            ViewCompat.setBackground(textView, resources.getDrawable(C4548R.drawable.sesl_dot_badge));
            textView.setId(C4548R.id.sesl_badge_dot);
            int dimensionPixelSize = resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_badge_dot_size);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            if (tabView.iconView == null || tabView.iconView.getVisibility() != 0) {
                int i2 = C4548R.id.title;
                layoutParams.topToTop = i2;
                layoutParams.startToEnd = i2;
                paddingRight = textView2 != null ? textView2.getPaddingRight() : 0;
                Pair<Integer, Integer> badgeOffset = getBadgeOffset(false);
                iIntValue3 = badgeOffset.first.intValue();
                iIntValue4 = badgeOffset.second.intValue();
            } else {
                int i4 = C4548R.id.icon;
                layoutParams.topToTop = i4;
                layoutParams.startToEnd = i4;
                Pair<Integer, Integer> badgeOffsetHasIcon = getBadgeOffsetHasIcon(false, z);
                iIntValue3 = badgeOffsetHasIcon.first.intValue();
                iIntValue4 = badgeOffsetHasIcon.second.intValue();
                paddingRight = 0;
            }
            layoutParams.setMargins(iIntValue3 - paddingRight, iIntValue4, 0, 0);
            tabView.mTabParentView.addView(textView, layoutParams);
            tabView.mDotBadgeView = textView;
            return;
        }
        if (tabView.mNBadgeView != null) {
            return;
        }
        textView.setVisibility(8);
        textView.setMinWidth(resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_badge_number_min_width));
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_badge_number_text_size);
        textView.setTextSize(0, dimensionPixelSize2);
        seslCheckMaxFontScale(textView, dimensionPixelSize2);
        textView.setGravity(17);
        textView.setTextColor(resources.getColor(C4548R.color.sesl_badge_text_color));
        ViewCompat.setBackground(textView, resources.getDrawable(C4548R.drawable.sesl_tab_n_badge));
        textView.setId(C4548R.id.sesl_badge_n);
        textView.setMaxLines(1);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_badge_number_height));
        if (tabView.iconView == null || tabView.iconView.getVisibility() != 0) {
            int i5 = C4548R.id.title;
            layoutParams2.topToTop = i5;
            layoutParams2.startToEnd = i5;
            Pair<Integer, Integer> badgeOffset2 = getBadgeOffset(false);
            iIntValue = badgeOffset2.first.intValue();
            iIntValue2 = badgeOffset2.second.intValue();
        } else {
            int i6 = C4548R.id.icon;
            layoutParams2.topToTop = i6;
            layoutParams2.startToEnd = i6;
            Pair<Integer, Integer> badgeOffsetHasIcon2 = getBadgeOffsetHasIcon(false, z);
            iIntValue = badgeOffsetHasIcon2.first.intValue();
            iIntValue2 = badgeOffsetHasIcon2.second.intValue();
        }
        layoutParams2.setMargins(iIntValue, iIntValue2, 0, 0);
        tabView.mTabParentView.addView(textView, layoutParams2);
        tabView.mNBadgeView = textView;
    }

    @NonNull
    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    @NonNull
    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams, false, false);
        return layoutParams;
    }

    @NonNull
    private TabView createTabView(@NonNull Tab tab) {
        Pools.Pool<TabView> pool = this.tabViewPool;
        TabView tabViewAcquire = pool != null ? pool.acquire() : null;
        if (tabViewAcquire == null) {
            tabViewAcquire = new TabView(getContext());
        }
        if (tabViewAcquire.mMainTabTouchBackground != null) {
            tabViewAcquire.mMainTabTouchBackground.setAlpha(0.0f);
        }
        if (tabViewAcquire.mTabParentView != null) {
            tabViewAcquire.mTabParentView.removeView(tabViewAcquire.mDotBadgeView);
            tabViewAcquire.mTabParentView.removeView(tabViewAcquire.mNBadgeView);
            tabViewAcquire.mDotBadgeView = null;
            tabViewAcquire.mNBadgeView = null;
        }
        tabViewAcquire.setTab(tab);
        tabViewAcquire.setFocusable(true);
        tabViewAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.contentDesc)) {
            tabViewAcquire.setContentDescription(tab.text);
            return tabViewAcquire;
        }
        tabViewAcquire.setContentDescription(tab.contentDesc);
        return tabViewAcquire;
    }

    private void dispatchTabReselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@NonNull Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    @NonNull
    @RequiresApi(35)
    private SemBlurInfoState generateBlurInfo(@NonNull Context context) {
        float dimension = context.getResources().getDimension(C4548R.dimen.sesl_tablayout_item_radius);
        SemBlurInfoStateBuilder semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder = BlurInfoState.INSTANCE.generateFloatingComponentBlurInfoStateBuilder(context, this.mBlurMode);
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable != null) {
            semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.nonBlurBackground(drawable);
        }
        return semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.cornerRadius(dimension).build();
    }

    private Pair<Integer, Integer> getBadgeOffset(boolean z) {
        return new Pair<>(Integer.valueOf(getResources().getDimensionPixelSize(z ? C4548R.dimen.sesl_tablayout_tab_n_badge_offset : C4548R.dimen.sesl_tablayout_subtab_dot_badge_offset_x)), Integer.valueOf(getResources().getDimensionPixelSize(z ? C4548R.dimen.sesl_tablayout_tab_n_badge_offset : C4548R.dimen.sesl_tablayout_subtab_dot_badge_offset_y)));
    }

    private Pair<Integer, Integer> getBadgeOffsetHasIcon(boolean z, boolean z2) {
        int i;
        int i2;
        if (z) {
            if (this.mDepthStyle == 1) {
                i = z2 ? C4548R.dimen.sesl_tablayout_maintab_n_badge_with_icon_offset_x_icon_label : C4548R.dimen.sesl_tablayout_tab_n_badge_offset;
                i2 = z2 ? C4548R.dimen.sesl_tablayout_maintab_n_badge_with_icon_offset_y_icon_label : C4548R.dimen.sesl_tablayout_tab_n_badge_offset;
            } else {
                i = C4548R.dimen.sesl_tablayout_tab_n_badge_offset;
                i2 = i;
            }
        } else if (this.mDepthStyle == 1) {
            i = z2 ? C4548R.dimen.sesl_tablayout_maintab_dot_badge_with_icon_offset_x_icon_label : C4548R.dimen.sesl_tablayout_subtab_dot_badge_with_icon_offset;
            i2 = z2 ? C4548R.dimen.sesl_tablayout_maintab_dot_badge_with_icon_offset_y_icon_label : C4548R.dimen.sesl_tablayout_subtab_dot_badge_with_icon_offset;
        } else {
            i = C4548R.dimen.sesl_tablayout_subtab_dot_badge_offset_x;
            i2 = C4548R.dimen.sesl_tablayout_subtab_dot_badge_offset_y;
        }
        return new Pair<>(Integer.valueOf(getResources().getDimensionPixelSize(i)), Integer.valueOf(getResources().getDimensionPixelSize(i2)));
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            Tab tab = this.tabs.get(i);
            if (tab != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText())) {
                return 56;
            }
        }
        return 56;
    }

    private int getSelectedTabTextColor() {
        ColorStateList colorStateList = this.tabTextColors;
        if (colorStateList != null) {
            return colorStateList.getColorForState(new int[]{R.attr.state_selected, R.attr.state_enabled}, colorStateList.getDefaultColor());
        }
        return -1;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isScrollingEnabled() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private boolean isShowButtonShapesEnabled() {
        return this.mDepthStyle == 1 && Settings.System.getInt(this.mContentResolver, "show_button_background", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewOutOfBounds(View view, int i, int i2) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getDrawingRect(rect);
        view.getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        return !rect.contains(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTabView$0(TabView tabView) {
        tabView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), C0419R.animator.sesl_recoil_button_selector));
        tabView.getStateListAnimator().jumpToCurrentState();
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.slidingTabIndicator.getChildAt(i);
        this.slidingTabIndicator.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seslActionCancel(TabView tabView) {
        SeslAbsIndicatorView seslAbsIndicatorView = tabView.mIndicatorView;
        tabView.setSelected(false);
        if (seslAbsIndicatorView != null && !seslAbsIndicatorView.isSelected()) {
            seslAbsIndicatorView.setHide();
        }
        Tab tabAt = getTabAt(getSelectedTabPosition());
        if (tabAt != null) {
            tabAt.view.setSelected(true);
            if (tabAt.view.mIndicatorView != null) {
                tabAt.view.mIndicatorView.setShow();
            }
        }
        if (this.mDepthStyle == 1 || seslAbsIndicatorView == null || !seslAbsIndicatorView.isSelected()) {
            return;
        }
        seslAbsIndicatorView.setReleased();
    }

    private void seslCheckMaxFontScale(TextView textView, int i) {
        float f = getResources().getConfiguration().fontScale;
        if (f > 1.2f) {
            textView.setTextSize(0, (i / f) * 1.2f);
        }
    }

    private int seslGetSelectedTabSubTextColor() {
        ColorStateList colorStateList = this.mSubTabSubTextColors;
        if (colorStateList != null) {
            return colorStateList.getColorForState(new int[]{R.attr.state_selected, R.attr.state_enabled}, colorStateList.getDefaultColor());
        }
        return -1;
    }

    private void setSelectedTabView(int i, boolean z) {
        SeslAbsIndicatorView seslAbsIndicatorView;
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.slidingTabIndicator.getChildAt(i2);
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                } else {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).updateTab();
                    }
                }
                i2++;
            }
            for (int i4 = 0; i4 < getTabCount(); i4++) {
                Tab tab = this.tabs.get(i4);
                if (tab != null && (seslAbsIndicatorView = tab.view.mIndicatorView) != null) {
                    if (i4 != i) {
                        seslAbsIndicatorView.setHide();
                    } else if (!z) {
                        seslAbsIndicatorView.setReleased();
                    } else if (seslAbsIndicatorView.getAlpha() != 1.0f) {
                        seslAbsIndicatorView.setShow();
                    }
                }
            }
        }
    }

    private void setShowButtonShape(@NonNull TabView tabView) {
        ColorStateList tabTextColors = getTabTextColors();
        if (isShowButtonShapesEnabled()) {
            if (Build.VERSION.SDK_INT <= 26) {
                tabView.setShowButtonShape(0, tabTextColors);
                return;
            }
            ColorDrawable colorDrawable = this.mBackgroundColorDrawable;
            int color = colorDrawable != null ? colorDrawable.getColor() : 0;
            if (color == 0) {
                color = getResources().getColor(SeslMisc.isLightTheme(getContext()) ? C4548R.color.sesl_bottom_navigation_background_light : C4548R.color.sesl_bottom_navigation_background_dark, null);
            }
            tabView.setShowButtonShape(color, tabTextColors);
        }
    }

    private void startTextColorChangeAnimation(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(i);
            if (isShowButtonShapesEnabled()) {
                updateTabViews();
            }
        }
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            this.tabs.get(i).updateView();
        }
    }

    private void updateBadgePosition(@NonNull TabView tabView) {
        TextView textView;
        byte b;
        int paddingRight;
        int iIntValue;
        int iIntValue2;
        View view = tabView.textView;
        ImageView imageView = tabView.iconView;
        if (tabView.getWidth() > 0) {
            if (tabView.mNBadgeView != null && tabView.mNBadgeView.getVisibility() == 0) {
                textView = tabView.mNBadgeView;
                b = 1;
            } else if (tabView.mDotBadgeView == null || tabView.mDotBadgeView.getVisibility() != 0) {
                textView = null;
                b = -1;
            } else {
                textView = tabView.mDotBadgeView;
                b = 2;
            }
            if (textView == null || textView.getVisibility() != 0) {
                return;
            }
            textView.measure(0, 0);
            int measuredWidth = b == 1 ? textView.getMeasuredWidth() : getResources().getDimensionPixelSize(C4548R.dimen.sesl_tab_badge_dot_size);
            boolean z = b == 1;
            if (imageView == null || imageView.getVisibility() != 0) {
                paddingRight = view != null ? view.getPaddingRight() : 0;
                Pair<Integer, Integer> badgeOffset = getBadgeOffset(z);
                iIntValue = badgeOffset.first.intValue();
                iIntValue2 = badgeOffset.second.intValue();
            } else {
                Pair<Integer, Integer> badgeOffsetHasIcon = getBadgeOffsetHasIcon(z, view != null && view.getVisibility() == 0);
                iIntValue = badgeOffsetHasIcon.first.intValue();
                iIntValue2 = badgeOffsetHasIcon.second.intValue();
                view = imageView;
                paddingRight = 0;
            }
            if (view == null) {
                return;
            }
            int width = tabView.getWidth();
            int i = iIntValue - paddingRight;
            if (view.getRight() + iIntValue + measuredWidth > width) {
                i = -((view.getRight() + measuredWidth) - width);
            }
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
            int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            if (layoutParams.getMarginStart() == i && i2 == measuredWidth && ((ViewGroup.MarginLayoutParams) layoutParams).topMargin == iIntValue2) {
                return;
            }
            tabView.setClipChildren(false);
            layoutParams.setMargins(i, iIntValue2, layoutParams.getMarginEnd(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            ((ViewGroup.MarginLayoutParams) layoutParams).width = measuredWidth;
            textView.setLayoutParams(layoutParams);
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams, boolean z, boolean z2) {
        if (this.mode != 13) {
            updateTabViewLayoutParams(layoutParams);
            return;
        }
        int i = this.mMainTabSelectedSideMargin;
        int i2 = (z || z2) ? i : this.mMainTabSeparatorMargin - i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i2);
        if (this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean applyBlurInfo(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 35) {
            return false;
        }
        clearBlurInfo(context);
        SemBlurInfoState semBlurInfoStateGenerateBlurInfo = generateBlurInfo(context);
        if (this.mDepthStyle == 1 && this.mode == 13 && semBlurInfoStateGenerateBlurInfo.applyBlurInfo(this)) {
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
        }
        this.mBlurInfo = null;
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab tabAcquire = tabPool.acquire();
        return tabAcquire == null ? new Tab() : tabAcquire;
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @Nullable
    public Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean isBlurApplied() {
        return this.mBlurInfo != null;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @NonNull
    public Tab newTab() {
        Tab tabCreateTabFromPool = createTabFromPool();
        tabCreateTabFromPool.parent = this;
        tabCreateTabFromPool.view = createTabView(tabCreateTabFromPool);
        if (tabCreateTabFromPool.f2396id != -1) {
            tabCreateTabFromPool.view.setId(tabCreateTabFromPool.f2396id);
        }
        return tabCreateTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        TabView tabView;
        super.onAttachedToWindow();
        for (int i = 0; i < getTabCount(); i++) {
            Tab tabAt = getTabAt(i);
            if (tabAt != null && (tabView = tabAt.view) != null) {
                if (tabView.mMainTabTouchBackground != null) {
                    tabAt.view.mMainTabTouchBackground.setAlpha(0.0f);
                }
                if (tabAt.view.mIndicatorView != null) {
                    if (getSelectedTabPosition() == i) {
                        tabAt.view.mIndicatorView.setShow();
                    } else {
                        tabAt.view.mIndicatorView.setHide();
                    }
                }
            }
        }
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        TabView tabView;
        super.onConfigurationChanged(configuration);
        for (int i = 0; i < getTabCount(); i++) {
            Tab tabAt = getTabAt(i);
            if (tabAt != null && (tabView = tabAt.view) != null && tabView.mMainTabTouchBackground != null) {
                tabAt.view.mMainTabTouchBackground.setAlpha(0.0f);
            }
        }
        updateTabViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return isScrollingEnabled() && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        updateTabViews();
        if (z) {
            this.mMaxTouchSlop = Math.max(this.mMaxTouchSlop, i4 - i);
        }
        int i6 = (this.mode == 1 || !(canScrollHorizontally(1) || canScrollHorizontally(-1))) ? this.mMaxTouchSlop : this.mDefaultTouchSlop;
        if (this.mCurrentTouchSlop != i6) {
            SeslHorizontalScrollViewReflector.setTouchSlop(this, i6);
            this.mCurrentTouchSlop = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int iRound = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int iDpToPx = this.requestedTabMaxWidth;
            if (iDpToPx <= 0) {
                iDpToPx = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = iDpToPx;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i4 = this.mode;
            if (i4 == 0) {
                if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.mode == 13 ? View.MeasureSpec.getSize(i) : getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    switch (i4) {
                    }
                }
            } else if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
            }
            checkOverScreen();
            if (!this.mIsOverScreen || getChildAt(0).getMeasuredWidth() >= getMeasuredWidth()) {
                setPaddingRelative(0, 0, 0, 0);
            } else {
                setPaddingRelative((getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || isScrollingEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        TabView tabView;
        super.onVisibilityChanged(view, i);
        for (int i2 = 0; i2 < getTabCount(); i2++) {
            Tab tabAt = getTabAt(i2);
            if (tabAt != null && (tabView = tabAt.view) != null && tabView.mMainTabTouchBackground != null) {
                tabAt.view.mMainTabTouchBackground.setAlpha(0.0f);
            }
        }
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem), true, true);
        }
    }

    public boolean releaseFromTabPool(Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@NonNull Tab tab) {
        if (tab.parent != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        Tab tab = this.selectedTab;
        int position = tab != null ? tab.getPosition() : 0;
        removeTabViewAt(i);
        Tab tabRemove = this.tabs.remove(i);
        if (tabRemove != null) {
            tabRemove.reset();
            releaseFromTabPool(tabRemove);
        }
        int size = this.tabs.size();
        int i2 = -1;
        for (int i4 = i; i4 < size; i4++) {
            if (this.tabs.get(i4).getPosition() == this.indicatorPosition) {
                i2 = i4;
            }
            this.tabs.get(i4).setPosition(i4);
        }
        this.indicatorPosition = i2;
        if (position == i) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(Math.max(0, i - 1)));
        }
    }

    public void selectTab(@Nullable Tab tab) {
        selectTab(tab, true);
    }

    public ColorStateList seslGetTabSubTextColors() {
        return this.mSubTabSubTextColors;
    }

    public void seslSetBadgeColor(int i) {
        this.mBadgeColor = i;
    }

    public void seslSetBadgeTextColor(int i) {
        this.mBadgeTextColor = i;
    }

    public void seslSetIconTextGap(int i) {
        this.mIconTextGap = i;
        updateAllTabs();
    }

    public void seslSetSubTabIndicatorHeight(int i) {
        this.mSubTabIndicatorHeight = i;
    }

    public void seslSetSubTabSelectedIndicatorColor(int i) {
        this.mSubTabSelectedIndicatorColor = i;
        setSelectedTabIndicatorColor(i);
    }

    public void seslSetSubTabStyle() {
        if (this.mDepthStyle == 1) {
            this.mDepthStyle = 2;
            this.tabTextColors = getResources().getColorStateList(SeslMisc.isLightTheme(getContext()) ? C4548R.color.sesl_tablayout_subtab_text_color_light : C4548R.color.sesl_tablayout_subtab_text_color_dark);
            if (!this.tabs.isEmpty()) {
                int selectedTabPosition = getSelectedTabPosition();
                ArrayList arrayList = new ArrayList(this.tabs.size());
                for (int i = 0; i < this.tabs.size(); i++) {
                    Tab tabNewTab = newTab();
                    tabNewTab.text = this.tabs.get(i).text;
                    tabNewTab.icon = this.tabs.get(i).icon;
                    tabNewTab.customView = this.tabs.get(i).customView;
                    tabNewTab.subText = this.tabs.get(i).subText;
                    if (i == selectedTabPosition) {
                        tabNewTab.select();
                    }
                    tabNewTab.view.update();
                    arrayList.add(tabNewTab);
                }
                removeAllTabs();
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    addTab((Tab) arrayList.get(i2), i2 == selectedTabPosition);
                    if (this.tabs.get(i2) != null) {
                        this.tabs.get(i2).view.update();
                    }
                    i2++;
                }
                arrayList.clear();
            }
            applyBlurInfo(getContext());
        }
    }

    public void seslSetTabSubTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mSubTabSubTextColors != colorStateList) {
            this.mSubTabSubTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void seslSetTabTextColor(ColorStateList colorStateList, boolean z) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            if (z) {
                updateAllTabs();
                return;
            }
            if (this.tabs != null) {
                for (int i = 0; i < this.tabs.size(); i++) {
                    TabView tabView = this.tabs.get(i).view;
                    if (tabView != null && tabView.textView != null) {
                        tabView.textView.setTextColor(this.tabTextColors);
                    }
                }
            }
        }
    }

    public void seslSetTabWidth(int i) {
        this.mRequestedTabWidth = i;
    }

    public void seslShowBadge(int i, boolean z, String str) {
        seslShowBadge(i, z, str, null);
    }

    public void seslShowDotBadge(int i, boolean z) {
        seslShowDotBadge(i, z, null);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.mBackgroundDrawable = getBackground();
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void setBlurMode(int i) {
        this.mBlurMode = i;
        applyBlurInfo(getContext());
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@BoolRes int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        this.tabSelectedIndicator = drawableMutate;
        DrawableUtils.setTint(drawableMutate, this.tabSelectedIndicatorColor);
        int intrinsicHeight = this.tabIndicatorHeight;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        int i2;
        updateTabViews(false);
        this.mTabSelectedIndicatorColor = i;
        Iterator<Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            SeslAbsIndicatorView seslAbsIndicatorView = it.next().view.mIndicatorView;
            if (seslAbsIndicatorView != null) {
                if (this.mDepthStyle != 2 || (i2 = this.mSubTabSelectedIndicatorColor) == -1) {
                    seslAbsIndicatorView.setSelectedIndicatorColor(i);
                } else {
                    seslAbsIndicatorView.setSelectedIndicatorColor(i2);
                }
                seslAbsIndicatorView.invalidate();
            }
        }
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.tabIndicatorHeight = i;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i);
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@ColorRes int i) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.tabIndicatorAnimationMode = i;
        if (i == 0) {
            this.tabIndicatorInterpolator = new TabIndicatorInterpolator();
        } else if (i == 1) {
            this.tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(AbstractC2322a.m1615e(i, " is not a valid TabIndicatorAnimationMode"));
            }
            this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        this.slidingTabIndicator.jumpIndicatorToSelectedPosition();
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
            updateTabViews();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void updateTabViews(boolean z) {
        int childCount = this.slidingTabIndicator.getChildCount();
        int i = 0;
        while (i < this.slidingTabIndicator.getChildCount()) {
            View childAt = this.slidingTabIndicator.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams(), childCount == 1, i == childCount + (-1));
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
        updateTabViews();
    }

    public void updateViewPagerScrollState(int i) {
        this.viewPagerScrollState = i;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C4548R.attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.selectedListeners.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void addTab(@NonNull Tab tab, int i) {
        addTab(tab, i, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void selectTab(@Nullable Tab tab, boolean z) {
        selectTab(tab, z, true);
    }

    public void seslShowBadge(int i, boolean z, String str, String str2) {
        if (this.mDepthStyle == 2 || this.tabs.get(i) == null || this.tabs.get(i).view == null) {
            return;
        }
        TabView tabView = this.tabs.get(i).view;
        if (tabView.mNBadgeView == null) {
            createAddBadge(1, tabView);
        }
        if (tabView.mNBadgeView != null) {
            TextView textView = tabView.mNBadgeView;
            textView.setText(str);
            if (!z) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            if (this.mBadgeColor != -1) {
                DrawableCompat.setTint(textView.getBackground(), this.mBadgeColor);
            }
            int i2 = this.mBadgeTextColor;
            if (i2 != -1) {
                textView.setTextColor(i2);
            }
            if (str2 != null) {
                textView.setContentDescription(str2);
            }
            updateTabViews();
            textView.requestLayout();
        }
    }

    public void seslShowDotBadge(int i, boolean z, String str) {
        if (this.tabs.get(i) != null) {
            TabView tabView = this.tabs.get(i).view;
            if (tabView.mDotBadgeView == null) {
                createAddBadge(2, tabView);
            }
            if (tabView.mDotBadgeView != null) {
                TextView textView = tabView.mDotBadgeView;
                if (!z) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                if (this.mBadgeColor != -1) {
                    DrawableCompat.setTint(textView.getBackground(), this.mBadgeColor);
                }
                if (str != null) {
                    textView.setContentDescription(str);
                }
                updateTabViews();
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        setScrollPosition(i, f, z, z2, true);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @Nullable
        private CharSequence contentDesc;

        @Nullable
        private View customView;

        @Nullable
        private Drawable icon;

        @Nullable
        public TabLayout parent;
        private CharSequence subText;

        @Nullable
        private Object tag;

        @Nullable
        private CharSequence text;

        @NonNull
        public TabView view;
        private int position = -1;

        @LabelVisibility
        private int labelVisibilityMode = 1;

        /* JADX INFO: renamed from: id */
        private int f2396id = -1;

        @Nullable
        public BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @Nullable
        public CharSequence getContentDescription() {
            TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View getCustomView() {
            return this.customView;
        }

        @Nullable
        public Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.f2396id;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @Nullable
        public Object getTag() {
            return this.tag;
        }

        @Nullable
        public CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.position;
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.f2396id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
            this.subText = null;
        }

        public void select() {
            TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.selectTab(this);
        }

        @Nullable
        public CharSequence seslGetSubText() {
            return this.subText;
        }

        public TextView seslGetSubTextView() {
            TabView tabView;
            if (this.customView != null || (tabView = this.view) == null) {
                return null;
            }
            return tabView.mSubTextView;
        }

        public TextView seslGetTextView() {
            TabView tabView;
            if (this.customView != null || (tabView = this.view) == null) {
                return null;
            }
            return tabView.textView;
        }

        public Tab seslSetSubText(@Nullable CharSequence charSequence) {
            this.subText = charSequence;
            updateView();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setContentDescription(@StringRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setCustomView(@Nullable View view) {
            if (this.view.textView != null) {
                this.view.removeAllViews();
            }
            this.customView = view;
            updateView();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setIcon(@Nullable Drawable drawable) {
            this.icon = drawable;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setId(int i) {
            this.f2396id = i;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setTabLabelVisibility(@LabelVisibility int i) {
            this.labelVisibilityMode = i;
            TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setText(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.contentDesc) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public void updateView() {
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setContentDescription(@Nullable CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setCustomView(@LayoutRes int i) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(i, (ViewGroup) this.view, false));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setText(@StringRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab setIcon(@DrawableRes int i) {
            TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(AppCompatResources.getDrawable(tabLayout.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.mBlurMode = 2;
        this.indicatorPosition = -1;
        this.tabs = new ArrayList<>();
        this.selectedTabTextAppearance = -1;
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.tabIndicatorHeight = -1;
        this.selectedListeners = new ArrayList<>();
        this.tabViewPool = new Pools.SimplePool(12);
        this.mIsScaledTextSizeType = false;
        this.mIconTextGap = -1;
        this.mRequestedTabWidth = -1;
        this.mIsOverScreen = false;
        this.mOverScreenMaxWidth = -1;
        this.mBadgeColor = -1;
        this.mBadgeTextColor = -1;
        this.mSubTabSelectedIndicatorColor = -1;
        this.mSubTabIndicatorHeight = 1;
        this.mSubTabIndicator2ndHeight = 1;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C4548R.styleable.TabLayout, i, SeslMisc.isLightTheme(context2) ? C4548R.style.Widget_Design_TabLayout_Light : C4548R.style.Widget_Design_TabLayout);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.TabLayout_seslTabApplyBlur, false);
        int i4 = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_seslTabStyle, 1);
        this.mDepthStyle = i4;
        if (z && i4 == 1 && !ContextHelperKt.isDefaultTheme(context2)) {
            setBackground(context2.getDrawable(new ThemeResourceDrawableRes(C4548R.drawable.sesl_tablayout_maintab_background_for_theme, C4548R.drawable.sesl_tablayout_maintab_background_dark_for_theme).getResource(context2).intValue()));
        }
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(getBackground());
        if (colorStateListOrNull != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(colorStateListOrNull);
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, C4548R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayObtainStyledAttributes.getColor(C4548R.styleable.TabLayout_tabIndicatorColor, 0));
        slidingTabIndicator.setSelectedIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabIndicatorHeight, -1));
        this.mTabSelectedIndicatorColor = typedArrayObtainStyledAttributes.getColor(C4548R.styleable.TabLayout_tabIndicatorColor, 0);
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.tabPaddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        if (ThemeEnforcement.isMaterial3Theme(context2)) {
            this.defaultTabTextAppearance = C4548R.attr.textAppearanceTitleSmall;
        } else {
            this.defaultTabTextAppearance = C4548R.attr.textAppearanceButton;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.TabLayout_tabTextAppearance, C4548R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, C0419R.styleable.TextAppearance);
        this.tabTextSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(C0419R.styleable.TextAppearance_android_textSize, 0);
        this.mIsScaledTextSizeType = typedArrayObtainStyledAttributes2.getText(C0419R.styleable.TextAppearance_android_textSize).toString().contains("sp");
        this.tabTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes2, C0419R.styleable.TextAppearance_android_textColor);
        Resources resources = getResources();
        this.mMaxTouchSlop = resources.getDisplayMetrics().widthPixels;
        int scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.mDefaultTouchSlop = scaledTouchSlop;
        this.mCurrentTouchSlop = scaledTouchSlop;
        if (Build.VERSION.SDK_INT >= 34) {
            Typeface typefaceCreate = Typeface.create("sec", 0);
            this.mBoldTypeface = Typeface.create(typefaceCreate, 600, false);
            this.mNormalTypeface = Typeface.create(typefaceCreate, 400, false);
        } else {
            String string = resources.getString(C0419R.string.sesl_font_family_regular);
            this.mBoldTypeface = Typeface.create(string, 1);
            this.mNormalTypeface = Typeface.create(string, 0);
        }
        this.mSubTabIndicatorHeight = resources.getDimensionPixelSize(C4548R.dimen.sesl_tablayout_subtab_indicator_height);
        this.mSubTabIndicator2ndHeight = resources.getDimensionPixelSize(C4548R.dimen.sesl_tablayout_subtab_indicator_2nd_height);
        this.mTabMinSideSpace = resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_min_side_space);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.TabLayout_seslTabSubTextAppearance, C4548R.style.TextAppearance_Design_Tab_SubText);
        this.mSubTabSubTextAppearance = resourceId2;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(resourceId2, C0419R.styleable.TextAppearance);
        try {
            this.mSubTabSubTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes3, C0419R.styleable.TextAppearance_android_textColor);
            this.mSubTabTextSize = typedArrayObtainStyledAttributes3.getDimensionPixelSize(C0419R.styleable.TextAppearance_android_textSize, 0);
            typedArrayObtainStyledAttributes2.recycle();
            typedArrayObtainStyledAttributes3.recycle();
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.TabLayout_seslTabSubTextColor)) {
                this.mSubTabSubTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.TabLayout_seslTabSubTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.TabLayout_seslTabSelectedSubTextColor)) {
                this.mSubTabSubTextColors = createColorStateList(this.mSubTabSubTextColors.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(C4548R.styleable.TabLayout_seslTabSelectedSubTextColor, 0));
            }
            this.mMainTabSeparatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_seslTabSeparatorMargin, 0);
            this.mMainTabSelectedSideMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_seslTabSelectedSideMargin, 0);
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.TabLayout_tabSelectedTextAppearance)) {
                this.selectedTabTextAppearance = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.TabLayout_tabSelectedTextAppearance, resourceId);
            }
            int i5 = this.selectedTabTextAppearance;
            if (i5 != -1) {
                typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(i5, C0419R.styleable.TextAppearance);
                try {
                    this.selectedTabTextSize = typedArrayObtainStyledAttributes3.getDimensionPixelSize(C0419R.styleable.TextAppearance_android_textSize, (int) this.tabTextSize);
                    ColorStateList colorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes3, C0419R.styleable.TextAppearance_android_textColor);
                    if (colorStateList != null) {
                        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), colorStateList.getColorForState(new int[]{R.attr.state_selected}, colorStateList.getDefaultColor()));
                    }
                } finally {
                    typedArrayObtainStyledAttributes3.recycle();
                }
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.TabLayout_tabTextColor)) {
                this.tabTextColors = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.TabLayout_tabSelectedTextColor)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), typedArrayObtainStyledAttributes.getColor(C4548R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.tabIconTint = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = ViewUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, C4548R.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.tabIndicatorTimeInterpolator = MotionUtils.resolveThemeInterpolator(context2, C4548R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.requestedTabMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(C4548R.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(C4548R.styleable.TabLayout_tabContentStart, 0);
            this.mode = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabMode, 1);
            int i6 = typedArrayObtainStyledAttributes.getInt(C4548R.styleable.TabLayout_tabGravity, 0);
            this.tabGravity = i6;
            this.mFirstTabGravity = i6;
            this.inlineLabel = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayObtainStyledAttributes.recycle();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(C4548R.dimen.sesl_tab_scrollable_min_width);
            applyModeAndGravity();
            if (!ContextHelperKt.isDefaultTheme(context2)) {
                applyThemeResource();
            }
            Drawable background = getBackground();
            this.mContentResolver = context2.getContentResolver();
            if (background instanceof ColorDrawable) {
                this.mBackgroundColorDrawable = (ColorDrawable) background;
            }
            if (this.mDepthStyle == 2) {
                Resources resources2 = getResources();
                if (SeslMisc.isLightTheme(getContext())) {
                    i2 = C4548R.color.sesl_tablayout_subtab_text_color_light;
                } else {
                    i2 = C4548R.color.sesl_tablayout_subtab_text_color_dark;
                }
                this.tabTextColors = resources2.getColorStateList(i2);
            }
            if (z) {
                applyBlurInfo(context2);
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void selectTab(Tab tab, boolean z, boolean z2) {
        ViewPager viewPager;
        if (tab != null && !tab.view.isEnabled() && (viewPager = this.viewPager) != null) {
            viewPager.setCurrentItem(getSelectedTabPosition());
            return;
        }
        Tab tab2 = this.selectedTab;
        if (tab2 == tab) {
            if (tab2 != null) {
                dispatchTabReselected(tab);
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position, z2);
            }
        }
        this.selectedTab = tab;
        if (tab2 != null && tab2.parent != null) {
            dispatchTabUnselected(tab2);
        }
        if (tab != null) {
            dispatchTabSelected(tab);
        }
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z);
            viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    public void addTab(@NonNull Tab tab, boolean z) {
        addTab(tab, this.tabs.size(), z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setScrollPosition(int i, float f, boolean z, boolean z2, boolean z3) {
        int iRound = Math.round(i + f);
        if (iRound < 0 || iRound >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i, f);
        }
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        int iCalculateScrollXForTab = calculateScrollXForTab(i, f);
        int scrollX = getScrollX();
        boolean z4 = (i < getSelectedTabPosition() && iCalculateScrollXForTab >= scrollX) || (i > getSelectedTabPosition() && iCalculateScrollXForTab <= scrollX) || i == getSelectedTabPosition();
        if (ViewCompat.getLayoutDirection(this) == 1) {
            z4 = (i < getSelectedTabPosition() && iCalculateScrollXForTab <= scrollX) || (i > getSelectedTabPosition() && iCalculateScrollXForTab >= scrollX) || i == getSelectedTabPosition();
        }
        if (z4 || this.viewPagerScrollState == 1 || z3) {
            if (i < 0) {
                iCalculateScrollXForTab = 0;
            }
            scrollTo(iCalculateScrollXForTab, 0);
        }
        if (z) {
            setSelectedTabView(iRound, true);
        }
    }

    public void addTab(@NonNull Tab tab, int i, boolean z) {
        if (tab.parent == this) {
            configureTab(tab, i);
            addTabView(tab);
            if (z) {
                tab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void seslSetTabSubTextColors(int i, int i2) {
        seslSetTabSubTextColors(createColorStateList(i, i2));
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setSelectedTabIndicator(@DrawableRes int i) {
        if (i != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    private void updateTabViews() {
        if (this.tabs.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.tabs.size(); i++) {
            TabView tabView = this.tabs.get(i).view;
            updateBadgePosition(tabView);
            setShowButtonShape(tabView);
        }
    }

    private void updateTabViewLayoutParams(@NonNull LinearLayout.LayoutParams layoutParams) {
        int i = this.mode;
        if (i == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else if (i != 11 && i != 12) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SlidingTabIndicator extends LinearLayout {
        ValueAnimator indicatorAnimator;
        private int layoutDirection;

        public SlidingTabIndicator(Context context) {
            super(context);
            this.layoutDirection = -1;
            setWillNotDraw(false);
            setClipToPadding(false);
            setClipChildren(false);
        }

        private int getItemMinWidth(boolean z, int i) {
            return getResources().getDimensionPixelSize(z ? i != 1 ? i != 2 ? C4548R.dimen.sesl_tablayout_maintab_floating_icon_text_min_width_count_over_3 : C4548R.dimen.sesl_tablayout_maintab_floating_icon_text_min_width_count_2 : C4548R.dimen.sesl_tablayout_maintab_floating_icon_text_min_width_count_1 : i != 1 ? i != 2 ? C4548R.dimen.sesl_tablayout_maintab_floating_icon_only_min_width_count_over_3 : C4548R.dimen.sesl_tablayout_maintab_floating_icon_only_min_width_count_2 : C4548R.dimen.sesl_tablayout_maintab_floating_icon_only_min_width_count_1);
        }

        private void jumpIndicatorToPosition(int i) {
            if (TabLayout.this.viewPagerScrollState == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i);
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
                TabLayout.this.indicatorPosition = i;
            }
        }

        private void tweenIndicatorPosition(View view, View view2, float f) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            } else {
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.tabIndicatorInterpolator;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.updateIndicatorForOffset(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i4, int i5) {
            super.onLayout(z, i, i2, i4, i5);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToIndicatorPosition();
            } else {
                updateOrRecreateIndicatorAnimation(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Tab tab;
            int i4 = 0;
            boolean z = true;
            if (TabLayout.this.mode == 13) {
                int childCount = getChildCount();
                int size = View.MeasureSpec.getSize(i);
                boolean z2 = false;
                int i5 = 0;
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt.getVisibility() == 0) {
                        i5++;
                        if ((childAt instanceof TabView) && (tab = ((TabView) childAt).tab) != null && tab.getIcon() != null && !TextUtils.isEmpty(tab.getText()) && tab.getTabLabelVisibility() == 1) {
                            z2 = true;
                        }
                    }
                }
                int itemMinWidth = getItemMinWidth(z2, i5);
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt2 = getChildAt(i7);
                    if (childAt2.getVisibility() == 0) {
                        childAt2.setMinimumWidth(itemMinWidth);
                        if (childAt2 instanceof TabView) {
                            ((TabView) childAt2).textView.setTypeface(TabLayout.this.mBoldTypeface);
                        }
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i2);
                    }
                }
                int iMax = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt3 = getChildAt(i8);
                    if (childAt3.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt3.getMeasuredWidth());
                        if (childAt3 instanceof TabView) {
                            TabView tabView = (TabView) childAt3;
                            tabView.textView.setTypeface(tabView.isSelected() ? TabLayout.this.mBoldTypeface : TabLayout.this.mNormalTypeface);
                        }
                    }
                }
                if (iMax == 0) {
                    super.onMeasure(i, i2);
                    return;
                }
                int i9 = iMax * childCount;
                int iMin = Math.min(size, getResources().getDimensionPixelSize(C4548R.dimen.sesl_tablayout_maintab_container_max_width));
                if (i9 <= ((iMin - ((TabLayout.this.mMainTabSelectedSideMargin * 2) + ((childCount - 1) * TabLayout.this.mMainTabSeparatorMargin))) - getPaddingLeft()) - getPaddingRight()) {
                    while (i4 < childCount) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                        }
                        i4++;
                    }
                    TabLayout tabLayout = TabLayout.this;
                    if (tabLayout.tabGravity == 0 && tabLayout.mFirstTabGravity == 1) {
                        TabLayout.this.tabGravity = 1;
                    }
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.tabGravity = 0;
                    tabLayout2.updateTabViews(false);
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, TabLayout.this.tabGravity != 0 ? Integer.MIN_VALUE : 1073741824), i2);
                return;
            }
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout3 = TabLayout.this;
            int i10 = tabLayout3.mode;
            if (i10 == 11 || i10 == 12) {
                tabLayout3.checkOverScreen();
                int size2 = TabLayout.this.mIsOverScreen ? TabLayout.this.mOverScreenMaxWidth : View.MeasureSpec.getSize(i);
                int childCount2 = getChildCount();
                int[] iArr = new int[childCount2];
                int i11 = 0;
                for (int i12 = 0; i12 < childCount2; i12++) {
                    View childAt4 = getChildAt(i12);
                    if (childAt4.getVisibility() == 0) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, 0), i2);
                        int measuredWidth = (TabLayout.this.mTabMinSideSpace * 2) + childAt4.getMeasuredWidth();
                        iArr[i12] = measuredWidth;
                        i11 += measuredWidth;
                    }
                }
                int i13 = size2 / childCount2;
                if (i11 > size2) {
                    while (i4 < childCount2) {
                        ((LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams()).width = iArr[i4];
                        i4++;
                    }
                } else {
                    if (TabLayout.this.mode == 11) {
                        int i14 = 0;
                        while (true) {
                            if (i14 >= childCount2) {
                                z = false;
                                break;
                            } else if (iArr[i14] > i13) {
                                break;
                            } else {
                                i14++;
                            }
                        }
                    }
                    if (z) {
                        int i15 = (size2 - i11) / childCount2;
                        while (i4 < childCount2) {
                            ((LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams()).width = iArr[i4] + i15;
                            i4++;
                        }
                    } else {
                        while (i4 < childCount2) {
                            ((LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams()).width = i13;
                            i4++;
                        }
                    }
                }
                if (i11 > size2) {
                    size2 = i11;
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), i2);
                return;
            }
            if (tabLayout3.tabGravity == 1 || i10 == 2 || tabLayout3.mFirstTabGravity == 1) {
                int childCount3 = getChildCount();
                TabLayout tabLayout4 = TabLayout.this;
                if (tabLayout4.tabGravity == 0 && tabLayout4.mFirstTabGravity == 1) {
                    for (int i16 = 0; i16 < childCount3; i16++) {
                        View childAt5 = getChildAt(i16);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt5.getLayoutParams();
                        layoutParams2.width = -2;
                        layoutParams2.weight = 0.0f;
                        childAt5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), i2);
                    }
                }
                int iMax2 = 0;
                for (int i17 = 0; i17 < childCount3; i17++) {
                    View childAt6 = getChildAt(i17);
                    if (childAt6.getVisibility() == 0) {
                        iMax2 = Math.max(iMax2, childAt6.getMeasuredWidth());
                    }
                }
                if (iMax2 <= 0) {
                    return;
                }
                if (iMax2 * childCount3 <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z3 = false;
                    while (i4 < childCount3) {
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams3.width != iMax2 || layoutParams3.weight != 0.0f) {
                            layoutParams3.width = iMax2;
                            layoutParams3.weight = 0.0f;
                            z3 = true;
                        }
                        i4++;
                    }
                    TabLayout tabLayout5 = TabLayout.this;
                    if (tabLayout5.tabGravity == 0 && tabLayout5.mFirstTabGravity == 1) {
                        TabLayout.this.tabGravity = 1;
                    }
                    z = z3;
                } else {
                    TabLayout tabLayout6 = TabLayout.this;
                    tabLayout6.tabGravity = 0;
                    tabLayout6.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }

        public void setIndicatorPositionFromTabPosition(int i, float f) {
            TabLayout.this.indicatorPosition = Math.round(i + f);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            tweenIndicatorPosition(getChildAt(i), getChildAt(i + 1), f);
        }

        public void setSelectedIndicatorHeight(int i) {
            Rect bounds = TabLayout.this.tabSelectedIndicator.getBounds();
            TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        private void jumpIndicatorToIndicatorPosition() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jumpIndicatorToSelectedPosition() {
        }

        public void animateIndicatorToPosition(int i, int i2) {
        }

        private void updateOrRecreateIndicatorAnimation(boolean z, int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab tab) {
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
    }
}
