package com.google.android.material.navigation;

import android.R;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0419R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SeslMenuItem;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.C4548R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.navigation.strategy.ViewTypeStrategy;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(api = 21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    static final int BADGE_TYPE_DOT = 1;
    static final int BADGE_TYPE_N = 2;
    static final int BADGE_TYPE_OVERFLOW = 0;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;
    private static final String TAG = "NavigationBarMenuView";

    @NonNull
    private final SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    @VisibleForTesting
    NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;

    @Dimension
    private int itemIconSize;

    @Nullable
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pools.Pool<NavigationBarItemView> itemPool;

    @Nullable
    private ColorStateList itemRippleColor;
    private int itemStateListAnimatorId;

    @StyleRes
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private ContentResolver mContentResolver;
    MenuBuilder mDummyMenu;
    private boolean mExclusiveCheckable;
    private boolean mHasGroupDivider;
    private boolean mHasOverflowMenu;
    private InternalBtnInfo mInvisibleBtns;
    protected boolean mIsFloatingStyle;
    protected int mMaxItemCount;
    NavigationBarItemView mOverflowButton;
    private MenuBuilder mOverflowMenu;
    private ColorDrawable mSBBTextColorDrawable;
    private MenuBuilder.Callback mSelectedCallback;

    @StyleRes
    private int mSeslLabelTextAppearance;
    protected ViewTypeStrategy mStrategy;
    protected boolean mUseItemPool;
    private int mViewType;
    private int mViewVisibleItemCount;
    private InternalBtnInfo mVisibleBtns;
    private int mVisibleItemCount;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;

    @NonNull
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @Nullable
    private final TransitionSet set;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InternalBtnInfo {
        int cnt = 0;
        int[] originPos;

        public InternalBtnInfo(int i) {
            this.originPos = new int[i];
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.onTouchListeners = new SparseArray<>(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemStateListAnimatorId = 0;
        this.mViewType = 1;
        this.mVisibleBtns = null;
        this.mInvisibleBtns = null;
        this.mOverflowButton = null;
        this.mHasOverflowMenu = false;
        this.mOverflowMenu = null;
        this.mVisibleItemCount = 0;
        this.mViewVisibleItemCount = 0;
        this.mMaxItemCount = 0;
        this.mUseItemPool = true;
        this.mExclusiveCheckable = true;
        this.mIsFloatingStyle = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.set = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.set = autoTransition;
            autoTransition.setOrdering(0);
            autoTransition.setDuration(0L);
            autoTransition.addTransition(new TextScale());
        }
        this.onClickListener = new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                if (NavigationBarMenuView.this.menu.performItemAction(itemData, NavigationBarMenuView.this.presenter, 0)) {
                    return;
                }
                if (NavigationBarMenuView.this.mExclusiveCheckable) {
                    itemData.setChecked(true);
                } else {
                    itemData.setChecked(!itemData.isChecked());
                }
            }
        };
        this.mContentResolver = context.getContentResolver();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private void buildInternalMenu(boolean z, int i) {
        if (this.buttons == null) {
            return;
        }
        if (i < 0 || i > this.menu.size() || !(this.menu.getItem(i) instanceof MenuItemImpl)) {
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "position is out of index (pos=", "/size=");
            sbM778t.append(this.menu.size());
            sbM778t.append(") or not instance of MenuItemImpl");
            Log.e(str, sbM778t.toString());
            return;
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.menu.getItem(i);
        NavigationBarItemView navigationBarItemViewBuildMenu = buildMenu(menuItemImpl, z);
        this.buttons[this.mVisibleItemCount] = navigationBarItemViewBuildMenu;
        navigationBarItemViewBuildMenu.setVisibility(this.menu.getItem(i).isVisible() ? 0 : 8);
        navigationBarItemViewBuildMenu.setOnClickListener(this.onClickListener);
        if (this.selectedItemId != 0 && this.menu.getItem(i).getItemId() == this.selectedItemId) {
            this.selectedItemPosition = this.mVisibleItemCount;
        }
        String badgeText = menuItemImpl.getBadgeText();
        if (badgeText != null) {
            seslAddBadge(badgeText, menuItemImpl.getItemId());
        } else {
            seslRemoveBadge(menuItemImpl.getItemId());
        }
        setBadgeIfNeeded(navigationBarItemViewBuildMenu);
        if (navigationBarItemViewBuildMenu.getParent() instanceof ViewGroup) {
            ((ViewGroup) navigationBarItemViewBuildMenu.getParent()).removeView(navigationBarItemViewBuildMenu);
        }
        addView(navigationBarItemViewBuildMenu);
        this.mVisibleItemCount++;
        if (navigationBarItemViewBuildMenu.getVisibility() == 0) {
            this.mViewVisibleItemCount++;
        }
    }

    private NavigationBarItemView buildMenu(@NonNull MenuItemImpl menuItemImpl, boolean z) {
        NavigationBarItemView newItem = getNewItem(menuItemImpl);
        newItem.setIconTintList(this.itemIconTint);
        newItem.setIconSize(this.itemIconSize);
        newItem.setTextColor(this.itemTextColorDefault);
        newItem.seslSetLabelTextAppearance(this.mSeslLabelTextAppearance);
        newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
        newItem.setTextColor(this.itemTextColorFromUser);
        Drawable drawable = this.itemBackground;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.itemBackgroundRes);
        }
        ViewTypeStrategy viewTypeStrategy = this.mStrategy;
        if (viewTypeStrategy != null) {
            newItem.setSelectedSidePadding(viewTypeStrategy.getSelectedSidePadding(getResources()));
        }
        inflateStateListAnimator(newItem);
        newItem.setShifting(z);
        newItem.setLabelVisibilityMode(this.labelVisibilityMode);
        newItem.initialize(menuItemImpl, 0);
        newItem.setItemPosition(this.mVisibleItemCount);
        return newItem;
    }

    @Nullable
    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    private NavigationBarItemView ensureOverflowButton(boolean z) {
        this.mHasOverflowMenu = true;
        this.mDummyMenu = new MenuBuilder(getContext());
        new MenuInflater(getContext()).inflate(C4548R.menu.nv_dummy_overflow_menu_icon, this.mDummyMenu);
        if (this.mDummyMenu.size() <= 0 || !(this.mDummyMenu.getItem(0) instanceof MenuItemImpl)) {
            return null;
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.mDummyMenu.getItem(0);
        if (getViewType() == 1) {
            menuItemImpl.setTooltipText((CharSequence) null);
        } else {
            menuItemImpl.setTooltipText((CharSequence) getResources().getString(C0419R.string.sesl_more_item_label));
        }
        NavigationBarItemView navigationBarItemViewBuildMenu = buildMenu(menuItemImpl, z);
        inflateStateListAnimator(navigationBarItemViewBuildMenu);
        navigationBarItemViewBuildMenu.setBadgeType(0);
        navigationBarItemViewBuildMenu.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarMenuView.this.mOverflowMenu.setCallback(NavigationBarMenuView.this.mSelectedCallback);
                NavigationBarMenuView.this.presenter.showOverflowMenu(NavigationBarMenuView.this.mOverflowMenu);
            }
        });
        navigationBarItemViewBuildMenu.setContentDescription(getResources().getString(C0419R.string.sesl_action_menu_overflow_description));
        if (getViewType() == 3) {
            initOverflowSpan(navigationBarItemViewBuildMenu);
        }
        if (navigationBarItemViewBuildMenu.getParent() instanceof ViewGroup) {
            ((ViewGroup) navigationBarItemViewBuildMenu.getParent()).removeView(navigationBarItemViewBuildMenu);
        }
        addView(navigationBarItemViewBuildMenu);
        return navigationBarItemViewBuildMenu;
    }

    private NavigationBarItemView getNewItem(@NonNull final MenuItemImpl menuItemImpl) {
        NavigationBarItemView navigationBarItemViewAcquire = this.itemPool.acquire();
        if (navigationBarItemViewAcquire != null) {
            return navigationBarItemViewAcquire;
        }
        final int viewType = getViewType();
        return new NavigationBarItemView(getContext(), viewType) { // from class: com.google.android.material.navigation.NavigationBarMenuView.2
            @Override // com.google.android.material.navigation.NavigationBarItemView
            public int getItemLayoutResId() {
                if (menuItemImpl.getSeslNaviMenuItemType() == 1) {
                    return C4548R.layout.sesl_bottom_navigation_item_checkbox;
                }
                int i = viewType;
                return i != 1 ? i != 2 ? i != 3 ? C4548R.layout.sesl_bottom_navigation_item : C4548R.layout.sesl_bottom_navigation_item_text : C4548R.layout.sesl_bottom_navigation_item_icon_only : C4548R.layout.sesl_bottom_navigation_item;
            }

            @Override // com.google.android.material.navigation.NavigationBarItemView, androidx.appcompat.view.menu.MenuView.ItemView
            public void initialize(@NonNull MenuItemImpl menuItemImpl2, int i) {
                super.initialize(menuItemImpl2, i);
                menuItemImpl2.setExclusiveCheckable(NavigationBarMenuView.this.mExclusiveCheckable);
            }
        };
    }

    private void inflateStateListAnimator(NavigationBarItemView navigationBarItemView) {
        if (this.itemStateListAnimatorId != 0) {
            navigationBarItemView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), this.itemStateListAnimatorId));
        }
    }

    private void initOverflowSpan(NavigationBarItemView navigationBarItemView) {
        Drawable drawable = getContext().getDrawable(C0419R.drawable.sesl_ic_menu_overflow_dark);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        ImageSpan imageSpan = new ImageSpan(drawable);
        drawable.setState(new int[]{R.attr.state_enabled, -16842910});
        drawable.setTintList(this.itemTextColorFromUser);
        drawable.setBounds(0, 0, getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size), getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size));
        spannableStringBuilder.setSpan(imageSpan, 0, 1, 18);
        navigationBarItemView.setLabelImageSpan(spannableStringBuilder);
    }

    private boolean isNumericValue(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private boolean isShowButtonShapesEnabled() {
        return Settings.System.getInt(this.mContentResolver, "show_button_background", 0) == 1;
    }

    private boolean isValidId(int i) {
        return i != -1;
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.menu.size(); i++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int iKeyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.badgeDrawables.delete(iKeyAt);
            }
        }
    }

    private void seslCheckMaxFontScale(TextView textView, int i) {
        float f = getResources().getConfiguration().fontScale;
        if (f > 1.2f) {
            textView.setTextSize(0, (i / f) * 1.2f);
        }
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void setOverflowSpanColor(int i, boolean z) {
        SpannableStringBuilder labelImageSpan;
        NavigationBarItemView navigationBarItemView = this.mOverflowButton;
        if (navigationBarItemView == null || (labelImageSpan = navigationBarItemView.getLabelImageSpan()) == null) {
            return;
        }
        Drawable drawable = getContext().getDrawable(C0419R.drawable.sesl_ic_menu_overflow_dark);
        ImageSpan[] imageSpanArr = (ImageSpan[]) labelImageSpan.getSpans(0, labelImageSpan.length(), ImageSpan.class);
        if (imageSpanArr != null) {
            for (ImageSpan imageSpan : imageSpanArr) {
                labelImageSpan.removeSpan(imageSpan);
            }
        }
        ImageSpan imageSpan2 = new ImageSpan(drawable);
        drawable.setState(new int[]{R.attr.state_enabled, -16842910});
        if (z) {
            drawable.setTintList(this.itemTextColorFromUser);
        } else {
            drawable.setTint(i);
        }
        drawable.setBounds(0, 0, getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size), getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size));
        labelImageSpan.setSpan(imageSpan2, 0, 1, 18);
        this.mOverflowButton.setLabelImageSpan(labelImageSpan);
    }

    private void setShowButtonShape(NavigationBarItemView navigationBarItemView) {
        MenuItemImpl itemData;
        if (navigationBarItemView == null) {
            return;
        }
        ColorStateList itemTextColor = getItemTextColor();
        if (isShowButtonShapesEnabled()) {
            if (Build.VERSION.SDK_INT <= 26) {
                navigationBarItemView.setShowButtonShape(0, itemTextColor);
                return;
            }
            ColorDrawable colorDrawable = this.mSBBTextColorDrawable;
            int color = colorDrawable != null ? colorDrawable.getColor() : 0;
            if (color == 0) {
                color = getResources().getColor(SeslMisc.isLightTheme(getContext()) ? C4548R.color.sesl_bottom_navigation_background_light : C4548R.color.sesl_bottom_navigation_background_dark, null);
            }
            navigationBarItemView.setShowButtonShape(color, itemTextColor);
            if (this.mOverflowButton == null || (itemData = navigationBarItemView.getItemData()) == null || this.mDummyMenu == null || itemData.getItemId() != this.mDummyMenu.getItem(0).getItemId()) {
                return;
            }
            setOverflowSpanColor(color, false);
        }
    }

    private void updateBadge(NavigationBarItemView navigationBarItemView) {
        TextView textView;
        int measuredWidth;
        int measuredHeight;
        int measuredWidth2;
        int width;
        if (navigationBarItemView == null || (textView = (TextView) navigationBarItemView.findViewById(C4548R.id.notifications_badge)) == null) {
            return;
        }
        Resources resources = getResources();
        seslCheckMaxFontScale(textView, resources.getDimensionPixelSize(C4548R.dimen.sesl_navigation_bar_num_badge_size));
        int badgeType = navigationBarItemView.getBadgeType();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C4548R.dimen.sesl_bottom_navigation_dot_badge_size);
        int dimensionPixelSize = this.mVisibleItemCount == this.mMaxItemCount ? resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_mode_min_padding_horizontal) : resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_mode_padding_horizontal);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_N_badge_top_margin);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_N_badge_start_margin);
        TextView label = navigationBarItemView.getLabel();
        int width2 = label == null ? 1 : label.getWidth();
        int height = label == null ? 1 : label.getHeight();
        if (badgeType == 1 || badgeType == 0) {
            ViewCompat.setBackground(textView, resources.getDrawable(C4548R.drawable.sesl_dot_badge));
            measuredWidth = dimensionPixelOffset;
            measuredHeight = measuredWidth;
        } else {
            ViewCompat.setBackground(textView, resources.getDrawable(C4548R.drawable.sesl_tab_n_badge));
            textView.measure(0, 0);
            measuredWidth = textView.getMeasuredWidth();
            measuredHeight = textView.getMeasuredHeight();
        }
        if (getViewType() == 3) {
            if (badgeType == 1) {
                measuredWidth2 = (textView.getMeasuredWidth() + width2) / 2;
                dimensionPixelOffset = (navigationBarItemView.getHeight() - height) / 2;
            } else if (badgeType == 0) {
                measuredWidth2 = ((width2 - textView.getMeasuredWidth()) - dimensionPixelSize3) / 2;
                dimensionPixelOffset = ((navigationBarItemView.getHeight() - height) / 2) - dimensionPixelSize2;
            } else {
                measuredWidth2 = (textView.getMeasuredWidth() + width2) / 2;
                dimensionPixelOffset = ((navigationBarItemView.getHeight() - height) / 2) - dimensionPixelSize2;
                if ((textView.getMeasuredWidth() / 2) + (navigationBarItemView.getWidth() / 2) + measuredWidth2 > navigationBarItemView.getWidth()) {
                    width = (navigationBarItemView.getWidth() - ((textView.getMeasuredWidth() / 2) + ((navigationBarItemView.getWidth() / 2) + measuredWidth2))) + measuredWidth2;
                }
            }
            width = measuredWidth2;
        } else if (badgeType == 1) {
            width = getItemIconSize() / 2;
        } else {
            width = (textView.getMeasuredWidth() / 2) - dimensionPixelSize;
            dimensionPixelOffset /= 2;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.leftMargin;
        if (i == measuredWidth && i2 == width) {
            return;
        }
        layoutParams.width = measuredWidth;
        layoutParams.height = measuredHeight;
        layoutParams.topMargin = dimensionPixelOffset;
        layoutParams.setMarginStart(width);
        textView.setLayoutParams(layoutParams);
    }

    private void validateMenuItemId(int i) {
        if (!isValidId(i)) {
            throw new IllegalArgumentException(AbstractC2322a.m1615e(i, " is not a valid view id"));
        }
    }

    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [boolean, int] */
    @SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        int i;
        removeAllViews();
        TransitionManager.beginDelayedTransition(this, this.set);
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        int i2 = 0;
        if (navigationBarItemViewArr != null && this.mUseItemPool) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    seslRemoveBadge(navigationBarItemView.getId());
                    this.itemPool.release(navigationBarItemView);
                    navigationBarItemView.clear();
                }
            }
        }
        if (this.mOverflowButton != null) {
            seslRemoveBadge(C4548R.id.bottom_overflow);
        }
        int size = this.menu.size();
        if (size == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            this.mVisibleItemCount = 0;
            this.mOverflowButton = null;
            this.mOverflowMenu = null;
            this.mVisibleBtns = null;
            this.mInvisibleBtns = null;
            return;
        }
        removeUnusedBadges();
        boolean zIsShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        this.buttons = new NavigationBarItemView[this.menu.size()];
        this.mVisibleBtns = new InternalBtnInfo(size);
        this.mInvisibleBtns = new InternalBtnInfo(size);
        this.mOverflowMenu = new MenuBuilder(getContext());
        this.mVisibleBtns.cnt = 0;
        this.mInvisibleBtns.cnt = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i6).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            if (((MenuItemImpl) this.menu.getItem(i6)).requiresOverflow()) {
                InternalBtnInfo internalBtnInfo = this.mInvisibleBtns;
                int[] iArr = internalBtnInfo.originPos;
                int i7 = internalBtnInfo.cnt;
                internalBtnInfo.cnt = i7 + 1;
                iArr[i7] = i6;
                if (!this.menu.getItem(i6).isVisible()) {
                    i4++;
                }
            } else {
                InternalBtnInfo internalBtnInfo2 = this.mVisibleBtns;
                int[] iArr2 = internalBtnInfo2.originPos;
                int i8 = internalBtnInfo2.cnt;
                internalBtnInfo2.cnt = i8 + 1;
                iArr2[i8] = i6;
                if (this.menu.getItem(i6).isVisible()) {
                    i5++;
                }
            }
        }
        ?? r02 = this.mInvisibleBtns.cnt - i4 > 0 ? 1 : 0;
        this.mHasOverflowMenu = r02;
        int i9 = i5 + r02;
        int i10 = this.mMaxItemCount;
        if (i9 > i10) {
            int i11 = i9 - (i10 - 1);
            if (r02 != 0) {
                i11--;
            }
            for (int i12 = this.mVisibleBtns.cnt - 1; i12 >= 0; i12--) {
                if (this.menu.getItem(this.mVisibleBtns.originPos[i12]).isVisible()) {
                    InternalBtnInfo internalBtnInfo3 = this.mInvisibleBtns;
                    int[] iArr3 = internalBtnInfo3.originPos;
                    int i13 = internalBtnInfo3.cnt;
                    internalBtnInfo3.cnt = i13 + 1;
                    InternalBtnInfo internalBtnInfo4 = this.mVisibleBtns;
                    iArr3[i13] = internalBtnInfo4.originPos[i12];
                    internalBtnInfo4.cnt--;
                    i11--;
                    if (i11 == 0) {
                        break;
                    }
                } else {
                    InternalBtnInfo internalBtnInfo5 = this.mInvisibleBtns;
                    int[] iArr4 = internalBtnInfo5.originPos;
                    int i14 = internalBtnInfo5.cnt;
                    internalBtnInfo5.cnt = i14 + 1;
                    InternalBtnInfo internalBtnInfo6 = this.mVisibleBtns;
                    iArr4[i14] = internalBtnInfo6.originPos[i12];
                    internalBtnInfo6.cnt--;
                }
            }
        }
        this.mVisibleItemCount = 0;
        this.mViewVisibleItemCount = 0;
        int i15 = 0;
        while (true) {
            InternalBtnInfo internalBtnInfo7 = this.mVisibleBtns;
            if (i15 >= internalBtnInfo7.cnt) {
                break;
            }
            buildInternalMenu(zIsShifting, internalBtnInfo7.originPos[i15]);
            i15++;
        }
        if (this.mInvisibleBtns.cnt > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                InternalBtnInfo internalBtnInfo8 = this.mInvisibleBtns;
                i = internalBtnInfo8.cnt;
                if (i16 >= i) {
                    break;
                }
                MenuItemImpl menuItemImpl = (MenuItemImpl) this.menu.getItem(internalBtnInfo8.originPos[i16]);
                if (menuItemImpl != null) {
                    this.mOverflowMenu.add(menuItemImpl.getGroupId(), menuItemImpl.getItemId(), menuItemImpl.getOrder(), menuItemImpl.getTitle() == null ? menuItemImpl.getContentDescription() : menuItemImpl.getTitle()).setVisible(menuItemImpl.isVisible()).setEnabled(menuItemImpl.isEnabled());
                    this.mOverflowMenu.setGroupDividerEnabled(this.mHasGroupDivider);
                    menuItemImpl.setBadgeText(menuItemImpl.getBadgeText());
                    if (!menuItemImpl.isVisible()) {
                        i17++;
                    }
                }
                i16++;
            }
            if (i - i17 > 0) {
                NavigationBarItemView navigationBarItemViewEnsureOverflowButton = ensureOverflowButton(zIsShifting);
                this.mOverflowButton = navigationBarItemViewEnsureOverflowButton;
                this.buttons[this.mVisibleBtns.cnt] = navigationBarItemViewEnsureOverflowButton;
                this.mVisibleItemCount++;
                this.mViewVisibleItemCount++;
                navigationBarItemViewEnsureOverflowButton.setVisibility(0);
            }
        }
        if (this.mViewVisibleItemCount > this.mMaxItemCount) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("Maximum number of visible items supported by BottomNavigationView is ");
            sb.append(this.mMaxItemCount);
            sb.append(". Current visible count is ");
            AbstractC0000a.m26w(sb, str, this.mViewVisibleItemCount);
            int i18 = this.mMaxItemCount;
            this.mVisibleItemCount = i18;
            this.mViewVisibleItemCount = i18;
        }
        while (true) {
            NavigationBarItemView[] navigationBarItemViewArr2 = this.buttons;
            if (i2 >= navigationBarItemViewArr2.length) {
                int iMin = Math.min(this.mMaxItemCount - 1, this.selectedItemPosition);
                this.selectedItemPosition = iMin;
                this.menu.getItem(iMin).setChecked(true);
                return;
            }
            setShowButtonShape(navigationBarItemViewArr2[i2]);
            i2++;
        }
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0419R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    @NonNull
    public abstract NavigationBarItemView createNavigationBarItemView(@NonNull Context context);

    @Nullable
    public NavigationBarItemView findItemView(int i) {
        validateMenuItemId(i);
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView == null) {
                return null;
            }
            if (navigationBarItemView.getId() == i) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorDrawable getBackgroundColorDrawable() {
        return this.mSBBTextColorDrawable;
    }

    @Nullable
    public BadgeDrawable getBadge(int i) {
        return this.badgeDrawables.get(i);
    }

    @NonNull
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.itemBackground : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    @Px
    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @Nullable
    public MenuBuilder getMenu() {
        return this.menu;
    }

    public BadgeDrawable getOrCreateBadge(int i) {
        validateMenuItemId(i);
        BadgeDrawable badgeDrawableCreate = this.badgeDrawables.get(i);
        if (badgeDrawableCreate == null) {
            badgeDrawableCreate = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i, badgeDrawableCreate);
        }
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i);
        if (navigationBarItemViewFindItemView != null) {
            navigationBarItemViewFindItemView.setBadge(badgeDrawableCreate);
        }
        return badgeDrawableCreate;
    }

    public MenuBuilder getOverflowMenu() {
        return this.mOverflowMenu;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getViewType() {
        return this.mViewType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getViewVisibleItemCount() {
        return this.mViewVisibleItemCount;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getVisibleItemCount() {
        return this.mVisibleItemCount;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasOverflowButton() {
        return this.mHasOverflowMenu;
    }

    public void hideOverflowMenu() {
        NavigationBarPresenter navigationBarPresenter;
        if (hasOverflowButton() && (navigationBarPresenter = this.presenter) != null && navigationBarPresenter.isOverflowMenuShowing()) {
            this.presenter.hideOverflowMenu();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    public boolean isShifting(int i, int i2) {
        return i == 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getViewType() != 3) {
            setItemIconSize(getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size));
            NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
            if (navigationBarItemViewArr != null) {
                for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                    if (navigationBarItemView == null) {
                        break;
                    }
                    navigationBarItemView.updateLabelGroupTopMargin(getResources().getDimensionPixelSize(C4548R.dimen.sesl_bottom_navigation_icon_size));
                }
            }
        }
        hideOverflowMenu();
    }

    public void removeBadge(int i) {
        validateMenuItemId(i);
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i);
        if (navigationBarItemViewFindItemView != null) {
            navigationBarItemViewFindItemView.removeBadge();
        }
        this.badgeDrawables.put(i, null);
    }

    public void restoreBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        BadgeDrawable badgeDrawable;
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            if (this.badgeDrawables.indexOfKey(iKeyAt) < 0) {
                this.badgeDrawables.append(iKeyAt, sparseArray.get(iKeyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null && (badgeDrawable = this.badgeDrawables.get(navigationBarItemView.getId())) != null) {
                    navigationBarItemView.setBadge(badgeDrawable);
                }
            }
        }
    }

    public void seslAddBadge(String str, int i) {
        TextView textView;
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i);
        if (navigationBarItemViewFindItemView != null) {
            View viewFindViewById = navigationBarItemViewFindItemView.findViewById(C4548R.id.notifications_badge_container);
            if (viewFindViewById != null) {
                textView = (TextView) viewFindViewById.findViewById(C4548R.id.notifications_badge);
            } else {
                View viewInflate = LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_navigation_bar_badge_layout, (ViewGroup) this, false);
                TextView textView2 = (TextView) viewInflate.findViewById(C4548R.id.notifications_badge);
                navigationBarItemViewFindItemView.addView(viewInflate);
                textView = textView2;
            }
            if (!isNumericValue(str) || Integer.parseInt(str) <= 999) {
                navigationBarItemViewFindItemView.setBadgeNumberless(false);
            } else {
                navigationBarItemViewFindItemView.setBadgeNumberless(true);
                str = "999+";
            }
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(str);
        }
        updateBadge(navigationBarItemViewFindItemView);
    }

    @StyleRes
    public int seslGetLabelTextAppearance() {
        return this.mSeslLabelTextAppearance;
    }

    public void seslRemoveBadge(int i) {
        View viewFindViewById;
        NavigationBarItemView navigationBarItemViewFindItemView = findItemView(i);
        if (navigationBarItemViewFindItemView == null || (viewFindViewById = navigationBarItemViewFindItemView.findViewById(C4548R.id.notifications_badge_container)) == null) {
            return;
        }
        navigationBarItemViewFindItemView.removeView(viewFindViewById);
    }

    public void seslSetLabelTextAppearance(@StyleRes int i) {
        this.mSeslLabelTextAppearance = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setTextAppearanceInactive(i);
            ColorStateList colorStateList2 = this.itemTextColorFromUser;
            if (colorStateList2 != null) {
                this.mOverflowButton.setTextColor(colorStateList2);
            }
        }
    }

    public void setActiveIndicatorLabelPadding(@Px int i) {
        this.itemActiveIndicatorLabelPadding = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setBackgroundColorDrawable(ColorDrawable colorDrawable) {
        this.mSBBTextColorDrawable = colorDrawable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExclusiveCheckable(boolean z) {
        this.mExclusiveCheckable = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mHasGroupDivider = z;
        MenuBuilder menuBuilder = this.mOverflowMenu;
        if (menuBuilder != null) {
            menuBuilder.setGroupDividerEnabled(z);
        } else {
            updateMenuView();
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setIconTintList(colorStateList);
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.itemActiveIndicatorEnabled = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i) {
        this.itemActiveIndicatorHeight = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i) {
        this.itemActiveIndicatorMarginHorizontal = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.itemActiveIndicatorResizeable = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.itemActiveIndicatorShapeAppearance = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i) {
        this.itemActiveIndicatorWidth = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setItemBackground(drawable);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setItemBackground(drawable);
        }
    }

    public void setItemBackgroundRes(int i) {
        this.itemBackgroundRes = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setItemBackground(i);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setItemBackground(i);
        }
    }

    public void setItemIconSize(@Dimension int i) {
        this.itemIconSize = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setIconSize(i);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setIconSize(i);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i);
        } else {
            this.onTouchListeners.put(i, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    return;
                }
                if (navigationBarItemView.getItemData().getItemId() == i) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(@Px int i) {
        this.itemPaddingBottom = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i);
            }
        }
    }

    public void setItemPaddingTop(@Px int i) {
        this.itemPaddingTop = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemStateListAnimator(int i) {
        this.itemStateListAnimatorId = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                inflateStateListAnimator(navigationBarItemView);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            inflateStateListAnimator(navigationBarItemView2);
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i) {
        this.itemTextAppearanceActive = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 == null || this.itemTextColorFromUser == null) {
            return;
        }
        navigationBarItemView2.setTextAppearanceActive(i);
        this.mOverflowButton.setTextColor(this.itemTextColorFromUser);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.itemTextAppearanceActiveBoldEnabled = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z);
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i) {
        this.itemTextAppearanceInactive = i;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setTextAppearanceInactive(i);
            ColorStateList colorStateList2 = this.itemTextColorFromUser;
            if (colorStateList2 != null) {
                this.mOverflowButton.setTextColor(colorStateList2);
            }
        }
    }

    @RequiresApi(api = 21)
    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    break;
                }
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
        NavigationBarItemView navigationBarItemView2 = this.mOverflowButton;
        if (navigationBarItemView2 != null) {
            navigationBarItemView2.setTextColor(colorStateList);
            setOverflowSpanColor(0, true);
        }
        if (isShowButtonShapesEnabled()) {
            this.presenter.updateMenuView(true);
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.labelVisibilityMode = i;
    }

    public void setMaxItemCount(int i) {
        this.mMaxItemCount = i;
    }

    public void setOverflowSelectedCallback(MenuBuilder.Callback callback) {
        this.mSelectedCallback = callback;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    public void setViewType(int i) {
        this.mViewType = i;
    }

    public void showOverflowMenu() {
        NavigationBarPresenter navigationBarPresenter;
        if (!hasOverflowButton() || (navigationBarPresenter = this.presenter) == null) {
            return;
        }
        navigationBarPresenter.showOverflowMenu(this.mOverflowMenu);
    }

    public void tryRestoreSelectedItemId(int i) {
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.menu.getItem(i2);
            if (i == item.getItemId()) {
                this.selectedItemId = i;
                this.selectedItemPosition = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateBadgeIfNeeded() {
        NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView == null) {
                    return;
                }
                updateBadge(navigationBarItemView);
            }
        }
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder;
        TransitionSet transitionSet;
        MenuBuilder menuBuilder2 = this.menu;
        if (menuBuilder2 == null || this.buttons == null || this.mVisibleBtns == null || this.mInvisibleBtns == null) {
            return;
        }
        int size = menuBuilder2.size();
        hideOverflowMenu();
        if (size != this.mVisibleBtns.cnt + this.mInvisibleBtns.cnt) {
            buildMenuView();
            return;
        }
        int i = this.selectedItemId;
        int i2 = 0;
        while (true) {
            InternalBtnInfo internalBtnInfo = this.mVisibleBtns;
            if (i2 >= internalBtnInfo.cnt) {
                break;
            }
            MenuItem item = this.menu.getItem(internalBtnInfo.originPos[i2]);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i2;
            }
            if (item instanceof SeslMenuItem) {
                SeslMenuItem seslMenuItem = (SeslMenuItem) item;
                seslRemoveBadge(item.getItemId());
                if (seslMenuItem.getBadgeText() != null) {
                    seslAddBadge(seslMenuItem.getBadgeText(), item.getItemId());
                }
            }
            i2++;
        }
        if (i != this.selectedItemId && (transitionSet = this.set) != null) {
            TransitionManager.beginDelayedTransition(this, transitionSet);
        }
        boolean zIsShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i4 = 0; i4 < this.mVisibleBtns.cnt; i4++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i4].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i4].setShifting(zIsShifting);
            this.buttons[i4].initialize((MenuItemImpl) this.menu.getItem(this.mVisibleBtns.originPos[i4]), 0);
            this.presenter.setUpdateSuspended(false);
        }
        int i5 = 0;
        boolean z = false;
        while (true) {
            InternalBtnInfo internalBtnInfo2 = this.mInvisibleBtns;
            if (i5 >= internalBtnInfo2.cnt) {
                break;
            }
            MenuItem item2 = this.menu.getItem(internalBtnInfo2.originPos[i5]);
            if ((item2 instanceof SeslMenuItem) && (menuBuilder = this.mOverflowMenu) != null) {
                SeslMenuItem seslMenuItem2 = (SeslMenuItem) item2;
                MenuItem menuItemFindItem = menuBuilder.findItem(item2.getItemId());
                if (menuItemFindItem instanceof SeslMenuItem) {
                    menuItemFindItem.setTitle(item2.getTitle());
                    ((SeslMenuItem) menuItemFindItem).setBadgeText(seslMenuItem2.getBadgeText());
                }
                z |= seslMenuItem2.getBadgeText() != null;
            }
            i5++;
        }
        if (z) {
            seslAddBadge("", C4548R.id.bottom_overflow);
        } else {
            seslRemoveBadge(C4548R.id.bottom_overflow);
        }
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemViewAcquire = this.itemPool.acquire();
        return navigationBarItemViewAcquire == null ? createNavigationBarItemView(getContext()) : navigationBarItemViewAcquire;
    }
}
