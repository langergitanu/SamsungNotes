package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.C7873a;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut90;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.C8575c;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util.CaptionBarHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u0000 \u0087\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0087\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0014J\b\u00100\u001a\u00020.H\u0014J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\fH\u0002J\u0006\u00106\u001a\u00020.J\b\u00107\u001a\u00020.H\u0002J\b\u00108\u001a\u00020.H\u0002J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J$\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010C\u001a\u00020.2\u0006\u0010?\u001a\u00020\fH\u0002J\b\u0010D\u001a\u00020.H\u0002J\u0012\u0010E\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010F\u001a\u00020.J\u0006\u0010G\u001a\u00020.J\u0018\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\fH\u0016J\u0010\u0010K\u001a\u00020.2\u0006\u0010I\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020.H\u0002J\u001a\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010T\u001a\u00020.H\u0002J\b\u0010U\u001a\u00020.H\u0002J\b\u0010V\u001a\u00020.H\u0002J\u0010\u0010W\u001a\u00020.2\u0006\u0010X\u001a\u00020(H\u0016J\u0010\u0010Y\u001a\u00020.2\u0006\u0010X\u001a\u00020(H\u0016J\b\u0010Z\u001a\u00020.H\u0002J\b\u0010[\u001a\u00020.H\u0002J\b\u0010\\\u001a\u00020.H\u0002J\b\u0010]\u001a\u00020.H\u0002J\b\u0010c\u001a\u00020(H\u0016J\b\u0010d\u001a\u00020.H\u0002J\u001a\u0010e\u001a\u00020.2\b\u0010f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010g\u001a\u00020\fH\u0002J\u0006\u0010h\u001a\u00020.J\b\u0010m\u001a\u00020(H\u0003J\u001a\u0010n\u001a\u00020.2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010p\u001a\u00020(H\u0016J\u001a\u0010q\u001a\u00020.2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010p\u001a\u00020(H\u0016J\u0012\u0010r\u001a\u00020.2\b\u0010s\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010t\u001a\u00020.2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010u\u001a\u00020\fH\u0002J\u0010\u0010v\u001a\u00020.2\u0006\u0010u\u001a\u00020\fH\u0002J\u0012\u0010w\u001a\u00020.2\b\u0010o\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010x\u001a\u00020.2\b\u0010o\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010y\u001a\u0004\u0018\u00010&2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u00020\fH\u0002J\b\u0010|\u001a\u00020.H\u0002J\u001a\u0010}\u001a\u00020.2\b\u0010I\u001a\u0004\u0018\u00010\u000f2\u0006\u00105\u001a\u00020\fH\u0002J\u0010\u0010~\u001a\u00020.2\b\u0010\u007f\u001a\u0004\u0018\u00010\u000fJ\u0007\u0010\u0080\u0001\u001a\u00020.J\u0011\u0010\u0081\u0001\u001a\u00020.2\u0006\u0010u\u001a\u00020\fH\u0016J\u0011\u0010\u0082\u0001\u001a\u00020.2\u0006\u0010u\u001a\u00020\fH\u0016J\u0013\u0010\u0083\u0001\u001a\u00020.2\b\u0010s\u001a\u0004\u0018\u00010\"H\u0016J\u0013\u0010\u0084\u0001\u001a\u00020.2\b\u0010s\u001a\u0004\u0018\u00010\u001eH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020.2\u0006\u0010X\u001a\u00020(H\u0016J\t\u0010\u0086\u0001\u001a\u00020.H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u0010\u001a6\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u00120\u0011j\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010L\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010=R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010i\u001a\u00020j8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l¨\u0006\u0088\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/CustomToolbar;", "Landroidx/appcompat/widget/Toolbar;", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar;", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/IMenuInflater;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mNavigationView", "Landroid/view/View;", "mCustomViewMap", "Ljava/util/LinkedHashMap;", "Landroid/util/Pair;", "Lkotlin/collections/LinkedHashMap;", "mTitleView", "mOverflowMenuButton", "mPopupNoteView", "mTitleBottomView", "mActionView", "Landroidx/appcompat/widget/ActionMenuView;", "mBadgeView", "mTitleLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "mToolbarHeightChangedListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$ToolbarHeightChangedListener;", "mAnimationListener", "Landroid/animation/AnimatorListenerAdapter;", "mVisibilityChangedListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$VisibilityChangedListener;", "mOverflowMenuCallback", "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/IMenuInflater$OverflowMenu;", "mHeightAnimator", "Landroid/animation/ValueAnimator;", "mIsShowing", "", "mIsNaviUpEnabled", "mIsPreventFurtherUpdate", "mRunnableOverflowMenuClickListener", "Ljava/lang/Runnable;", "initialize", "", "onAttachedToWindow", "onDetachedFromWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setHeight", "height", "postUpdateToolbarLayout", "updateToolbarLayout", "updatePopupNoteView", "setTitleBottomView", "titleBottomView", "defaultToolbarHeight", "getDefaultToolbarHeight", "()I", "inflateMenu", "resId", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "overflowMenuCallback", "initInflateMenu", "initActionMenuView", "setOverflowMenuCallback", "release", "enableAdjustableMenu", "addCustomView", "view", "horizontalGravity", "removeCustomView", "customViewWidth", "getCustomViewWidth", "releaseCustomView", "setTitle", "title", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/winset/view/toolbar/ICustomToolbar$TitleCallback;", "initTitleView", "initTitleBottomView", "releaseTitle", "setDisplayHomeAsUpEnabled", "enabled", "setNaviUpEnabled", "updateNaviUpViewVisibility", "initNavigationView", "releaseNavigationView", "applyOverflowMenuClickListener", "overflowMenus", "", "Landroid/view/MenuItem;", "getOverflowMenus", "()Ljava/util/List;", "showOverflowMenu", "updateChildViews", "updateChild", "child", "gravity", "updateOverflowBtnBadge", "badgeLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getBadgeLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "hasBadge", "showToolbar", "contentView", "animate", "hideToolbar", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setToolbarVisibility", "visibility", "setPopupNoteVisibility", "showAnimate", "hideAnimate", "setupHeightAnimator", "defaultHeight", "targetHeight", "initHeightAnimator", "setHeightUpdateListener", "setPopupNoteView", "popupNoteView", "initToolbar", "setVisibility", "setVisibilityAsResult", "setVisibilityChangedListener", "setToolbarHeightChangedListener", "setEnabled", "updateMenuItemEnabledState", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CustomToolbar extends Toolbar implements ICustomToolbar, IMenuInflater {
    private static final int ANIMATION_LONG_DURATION = 200;
    private static final int ANIMATION_SHORT_DURATION = 100;
    private static final float MAX_ALPHA = 1.0f;
    private static final float MIN_ALPHA = 0.0f;

    @NotNull
    private static final String TAG = "CustomToolbar";

    @Nullable
    private ActionMenuView mActionView;

    @Nullable
    private AnimatorListenerAdapter mAnimationListener;

    @Nullable
    private View mBadgeView;

    @NotNull
    private final LinkedHashMap<Integer, Pair<View, Integer>> mCustomViewMap;

    @Nullable
    private ValueAnimator mHeightAnimator;
    private boolean mIsNaviUpEnabled;
    private boolean mIsPreventFurtherUpdate;
    private boolean mIsShowing;

    @Nullable
    private View mNavigationView;

    @Nullable
    private View mOverflowMenuButton;

    @Nullable
    private IMenuInflater.OverflowMenu mOverflowMenuCallback;

    @Nullable
    private View mPopupNoteView;

    @NotNull
    private final Runnable mRunnableOverflowMenuClickListener;

    @Nullable
    private View mTitleBottomView;

    @Nullable
    private View.OnLayoutChangeListener mTitleLayoutListener;

    @Nullable
    private View mTitleView;

    @Nullable
    private ICustomToolbar.ToolbarHeightChangedListener mToolbarHeightChangedListener;

    @Nullable
    private ICustomToolbar.VisibilityChangedListener mVisibilityChangedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCustomViewMap = new LinkedHashMap<>();
        this.mIsShowing = true;
        this.mIsNaviUpEnabled = true;
        this.mRunnableOverflowMenuClickListener = new RunnableC8995c(this, 1);
    }

    private final void applyOverflowMenuClickListener() {
        ActionMenuView actionMenuView = this.mActionView;
        if (actionMenuView == null) {
            return;
        }
        View viewFindViewById = actionMenuView != null ? actionMenuView.findViewById(C8875R.id.action_more) : null;
        this.mOverflowMenuButton = viewFindViewById;
        if (viewFindViewById == null) {
            post(this.mRunnableOverflowMenuClickListener);
        } else if (viewFindViewById == null || !viewFindViewById.hasOnClickListeners()) {
            this.mRunnableOverflowMenuClickListener.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableAdjustableMenu$lambda$3(CustomToolbar customToolbar, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        Logger.m8697d(TAG, "mTitle, onLayoutChange " + i4 + " / " + i8);
        if (i4 != i8) {
            customToolbar.applyOverflowMenuClickListener();
        }
    }

    private final FrameLayout.LayoutParams getBadgeLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388659;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C8875R.dimen.badge_start_margin);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C8875R.dimen.badge_top_margin);
        layoutParams.setMarginStart(dimensionPixelSize);
        layoutParams.topMargin = dimensionPixelSize2;
        return layoutParams;
    }

    private final int getDefaultToolbarHeight() {
        ICustomToolbar.ToolbarHeightChangedListener toolbarHeightChangedListener = this.mToolbarHeightChangedListener;
        if (toolbarHeightChangedListener == null) {
            return getResources().getDimensionPixelSize(C8875R.dimen.fragment_toolbar_height);
        }
        Integer numValueOf = Integer.valueOf(toolbarHeightChangedListener.getDefaultToolbarHeight());
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MenuItem> getOverflowMenus() {
        Menu menu = getMenu();
        int size = menu.size();
        Logger.m8697d(TAG, "menu size : " + size);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            int itemId = item.getItemId();
            if (item.isVisible()) {
                ActionMenuView actionMenuView = this.mActionView;
                if ((actionMenuView != null ? actionMenuView.findViewById(itemId) : null) == null) {
                    Intrinsics.checkNotNull(item);
                    arrayList.add(item);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"RestrictedApi"})
    private final boolean hasBadge() {
        Menu menu = getMenu();
        if (menu == null || !(menu instanceof MenuBuilder)) {
            Logger.m8698e(TAG, "hasBadge# menu is null");
            return false;
        }
        ArrayList<MenuItemImpl> visibleItems = ((MenuBuilder) menu).getVisibleItems();
        Intrinsics.checkNotNullExpressionValue(visibleItems, "getVisibleItems(...)");
        Iterator<MenuItemImpl> it = visibleItems.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next().getBadgeText())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideAnimate(View contentView) {
        final int defaultToolbarHeight = getDefaultToolbarHeight();
        ValueAnimator valueAnimator = setupHeightAnimator(contentView, defaultToolbarHeight, 0);
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new PathInterpolator(0.9f, 0.0f, 0.83f, 0.83f));
        }
        if (valueAnimator != null) {
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.base.winset.view.toolbar.CustomToolbar.hideAnimate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    CustomToolbar.this.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = CustomToolbar.this.getLayoutParams();
                    layoutParams.height = defaultToolbarHeight;
                    CustomToolbar.this.setLayoutParams(layoutParams);
                }
            });
        }
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private final void initActionMenuView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                ActionMenuView actionMenuView = (ActionMenuView) childAt;
                this.mActionView = actionMenuView;
                Logger.m8697d(TAG, "inflated menu : " + actionMenuView + " @" + i + " / " + childCount);
                return;
            }
        }
    }

    private final void initHeightAnimator() {
        if (this.mHeightAnimator == null) {
            return;
        }
        Logger.m8697d(TAG, "initHeightAnimator# ");
        ValueAnimator valueAnimator = this.mHeightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mHeightAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mHeightAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
        }
        this.mHeightAnimator = null;
    }

    private final void initInflateMenu(int resId) {
        Logger.m8697d(TAG, "initInflateMenu# " + hashCode());
        getMenu().clear();
        super.inflateMenu(resId);
        initActionMenuView();
        updateChildViews();
        updateMenuItemEnabledState();
    }

    private final void initNavigationView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof AppCompatImageButton) {
                this.mNavigationView = childAt;
                updateNaviUpViewVisibility();
                return;
            }
        }
    }

    private final void initTitleBottomView() {
        View view;
        if (this.mTitleView == null || (view = this.mTitleBottomView) == null || !(view instanceof TextView)) {
            return;
        }
        setSubtitleTextAppearance(getContext(), C8875R.style.CustomToolbarSubTitle);
        View view2 = this.mTitleBottomView;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.TextView");
        setSubtitle(((TextView) view2).getText());
    }

    private final void initTitleView() {
        if (this.mTitleView != null) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof AppCompatTextView) {
                this.mTitleView = childAt;
                return;
            }
        }
    }

    private final void initialize() {
        Logger.m8697d(TAG, "initialize# " + hashCode());
        addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC8993a(this, 1));
        updateToolbarLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$1(CustomToolbar customToolbar, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        ICustomToolbar.VisibilityChangedListener visibilityChangedListener = customToolbar.mVisibilityChangedListener;
        if (visibilityChangedListener != null && visibilityChangedListener != null && visibilityChangedListener.isRecording()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Context context = customToolbar.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (i4 - i <= (displayMetrics.densityDpi / 160) * customToolbar.getResources().getDimensionPixelSize(C8875R.dimen.toolbar_max_width_to_hide_menu)) {
                Menu menu = customToolbar.getMenu();
                int size = menu.size();
                for (int i10 = 0; i10 < size; i10++) {
                    menu.getItem(i10).setShowAsAction(0);
                }
            }
        }
        customToolbar.updatePopupNoteView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnableOverflowMenuClickListener$lambda$0(final CustomToolbar customToolbar) {
        if (customToolbar.mOverflowMenuButton == null) {
            ActionMenuView actionMenuView = customToolbar.mActionView;
            customToolbar.mOverflowMenuButton = actionMenuView != null ? actionMenuView.findViewById(C8875R.id.action_more) : null;
        }
        View view = customToolbar.mOverflowMenuButton;
        if (view == null || customToolbar.mOverflowMenuCallback == null || view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.toolbar.CustomToolbar$mRunnableOverflowMenuClickListener$1$1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                IMenuInflater.OverflowMenu overflowMenu;
                Intrinsics.checkNotNullParameter(v, "v");
                if (this.this$0.mOverflowMenuCallback == null) {
                    return;
                }
                Logger.m8702i("CustomToolbar", "onMoreMenuClick");
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(200L, tag);
                    List<? extends MenuItem> overflowMenus = this.this$0.getOverflowMenus();
                    if (overflowMenus.isEmpty() || (overflowMenu = this.this$0.mOverflowMenuCallback) == null) {
                        return;
                    }
                    overflowMenu.showOverflowMenu(overflowMenus);
                }
            }
        });
    }

    private final void releaseCustomView() {
        if (this.mCustomViewMap.isEmpty()) {
            return;
        }
        for (Pair<View, Integer> pair : this.mCustomViewMap.values()) {
            Intrinsics.checkNotNullExpressionValue(pair, "next(...)");
            removeView((View) pair.first);
        }
        this.mCustomViewMap.clear();
    }

    private final void releaseNavigationView() {
        this.mNavigationView = null;
    }

    private final void releaseTitle() {
        View view = this.mTitleView;
        if (view == null) {
            return;
        }
        if (view != null) {
            view.removeOnLayoutChangeListener(this.mTitleLayoutListener);
        }
        this.mTitleLayoutListener = null;
    }

    private final void setHeight(int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height == height) {
            return;
        }
        AbstractC4539a.m3203m(height, "setHeight ", TAG);
        layoutParams.height = height;
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
    }

    private final void setHeightUpdateListener(View view, int height) {
        if (view == null) {
            return;
        }
        view.animate().setUpdateListener(new C8575c(view, height, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHeightUpdateListener$lambda$10(View view, int i, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (view.getAlpha() * i);
        view.setLayoutParams(layoutParams);
    }

    private final void setOverflowMenuCallback(IMenuInflater.OverflowMenu overflowMenuCallback) {
        if (overflowMenuCallback == null) {
            return;
        }
        Logger.m8697d(TAG, "setOverflowMenuCallback# ");
        this.mOverflowMenuCallback = overflowMenuCallback;
    }

    private final void setPopupNoteVisibility(final int visibility) {
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator viewPropertyAnimatorWithStartAction;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator interpolator2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        View view = this.mPopupNoteView;
        if (view == null) {
            return;
        }
        if (visibility == 0) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
            if (viewPropertyAnimatorAnimate == null || (duration2 = viewPropertyAnimatorAnimate.setDuration(100L)) == null || (interpolator2 = duration2.setInterpolator(new SineInOut90())) == null || (viewPropertyAnimatorAlpha2 = interpolator2.alpha(1.0f)) == null) {
                return;
            }
            final int i = 1;
            ViewPropertyAnimator viewPropertyAnimatorWithStartAction2 = viewPropertyAnimatorAlpha2.withStartAction(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.toolbar.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CustomToolbar f6517b;

                {
                    this.f6517b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            CustomToolbar.setPopupNoteVisibility$lambda$8(this.f6517b, visibility);
                            break;
                        default:
                            CustomToolbar.setPopupNoteVisibility$lambda$4(this.f6517b, visibility);
                            break;
                    }
                }
            });
            if (viewPropertyAnimatorWithStartAction2 == null || (viewPropertyAnimatorWithEndAction = viewPropertyAnimatorWithStartAction2.withEndAction(new RunnableC8995c(this, 3))) == null) {
                return;
            }
            viewPropertyAnimatorWithEndAction.start();
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view.animate();
        if (viewPropertyAnimatorAnimate2 == null || (duration = viewPropertyAnimatorAnimate2.setDuration(100L)) == null || (interpolator = duration.setInterpolator(new SineInOut90())) == null || (viewPropertyAnimatorAlpha = interpolator.alpha(0.0f)) == null || (viewPropertyAnimatorWithStartAction = viewPropertyAnimatorAlpha.withStartAction(new RunnableC8995c(this, 4))) == null) {
            return;
        }
        final int i2 = 0;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction2 = viewPropertyAnimatorWithStartAction.withEndAction(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.winset.view.toolbar.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ CustomToolbar f6517b;

            {
                this.f6517b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        CustomToolbar.setPopupNoteVisibility$lambda$8(this.f6517b, visibility);
                        break;
                    default:
                        CustomToolbar.setPopupNoteVisibility$lambda$4(this.f6517b, visibility);
                        break;
                }
            }
        });
        if (viewPropertyAnimatorWithEndAction2 != null) {
            viewPropertyAnimatorWithEndAction2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPopupNoteVisibility$lambda$4(CustomToolbar customToolbar, int i) {
        View view = customToolbar.mPopupNoteView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPopupNoteVisibility$lambda$6(CustomToolbar customToolbar) {
        customToolbar.post(new RunnableC8995c(customToolbar, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPopupNoteVisibility$lambda$8(CustomToolbar customToolbar, int i) {
        View view = customToolbar.mPopupNoteView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private final void setToolbarVisibility(View contentView, int visibility) {
        if (this.mPopupNoteView == null) {
            AbstractC4539a.m3203m(visibility, "setToolbarVisibility# null ", TAG);
            if (visibility == 0) {
                IMenuInflater.OverflowMenu overflowMenu = this.mOverflowMenuCallback;
                if (overflowMenu != null) {
                    overflowMenu.hideOverflowMenu();
                }
                showAnimate(contentView);
            } else {
                hideAnimate(contentView);
            }
        } else {
            AbstractC4539a.m3203m(visibility, "setToolbarVisibility# ", TAG);
            setPopupNoteVisibility(visibility);
        }
        setHeightUpdateListener(this.mPopupNoteView, getResources().getDimensionPixelSize(C8875R.dimen.popup_note_actionbar_height));
    }

    private final ValueAnimator setupHeightAnimator(View contentView, int defaultHeight, int targetHeight) {
        initHeightAnimator();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getHeight(), targetHeight);
        this.mHeightAnimator = valueAnimatorOfInt;
        if (valueAnimatorOfInt != null) {
            valueAnimatorOfInt.setDuration(200L);
        }
        ValueAnimator valueAnimator = this.mHeightAnimator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new C7873a(this, defaultHeight, contentView, 1));
        }
        AnimatorListenerAdapter animatorListenerAdapter = this.mAnimationListener;
        if (animatorListenerAdapter != null) {
            ValueAnimator valueAnimator2 = this.mHeightAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.addListener(animatorListenerAdapter);
            }
            this.mAnimationListener = null;
        }
        return this.mHeightAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHeightAnimator$lambda$9(CustomToolbar customToolbar, int i, View view, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue();
        customToolbar.setTranslationY((iIntValue - i) >> 1);
        if (view != null) {
            view.setPadding(0, i - iIntValue, 0, 0);
        }
        ViewGroup.LayoutParams layoutParams = customToolbar.getLayoutParams();
        layoutParams.height = iIntValue;
        customToolbar.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAnimate(View contentView) {
        int defaultToolbarHeight = getDefaultToolbarHeight();
        ValueAnimator valueAnimator = setupHeightAnimator(contentView, defaultToolbarHeight, defaultToolbarHeight);
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        }
        if (valueAnimator != null) {
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.base.winset.view.toolbar.CustomToolbar.showAnimate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationStart(animation);
                    CustomToolbar.this.setVisibility(0);
                }
            });
        }
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private final void updateChild(View child, int gravity) {
        if (child == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar.LayoutParams");
        ((Toolbar.LayoutParams) layoutParams).gravity = gravity;
    }

    private final void updateChildViews() {
        AbstractC4539a.m3203m(hashCode(), "updateChildViews# ", TAG);
        updateChild(this.mNavigationView, 8388627);
        updateChild(this.mActionView, 8388629);
        for (Pair<View, Integer> pair : this.mCustomViewMap.values()) {
            Intrinsics.checkNotNullExpressionValue(pair, "next(...)");
            Pair<View, Integer> pair2 = pair;
            View view = (View) pair2.first;
            Object second = pair2.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            updateChild(view, ((Number) second).intValue() | 16);
        }
    }

    private final void updateMenuItemEnabledState() {
        boolean zIsEnabled = isEnabled();
        Logger.m8703w(TAG, "updateMenuItemEnabledState, enabled: " + zIsEnabled + " ,hashCode: " + hashCode());
        int size = getMenu().size();
        for (int i = 0; i < size; i++) {
            getMenu().getItem(i).setEnabled(zIsEnabled);
        }
        View viewFindViewById = findViewById(C8875R.id.action_more);
        if (viewFindViewById != null) {
            viewFindViewById.setEnabled(zIsEnabled);
        }
    }

    private final void updateNaviUpViewVisibility() {
        int i = this.mIsNaviUpEnabled ? 0 : 4;
        View view = this.mTitleView;
        if (view != null) {
            view.setVisibility(i);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof AppCompatImageButton) {
                ((AppCompatImageButton) childAt).setVisibility(i);
                return;
            }
        }
    }

    private final void updatePopupNoteView() {
        View view = this.mPopupNoteView;
        if (view == null) {
            return;
        }
        if (view != null) {
            view.setVisibility(this.mIsShowing ? 0 : 8);
        }
        View view2 = this.mPopupNoteView;
        if (view2 != null) {
            view2.setAlpha(this.mIsShowing ? 1.0f : 0.0f);
        }
        View view3 = this.mPopupNoteView;
        ViewGroup.LayoutParams layoutParams = view3 != null ? view3.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = getResources().getDimensionPixelSize(C8875R.dimen.popup_note_actionbar_height);
        }
        View view4 = this.mPopupNoteView;
        if (view4 != null) {
            view4.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToolbarLayout() {
        AbstractC4539a.m3203m(hashCode(), "updateToolbarLayout# ", TAG);
        updatePopupNoteView();
        if (this.mIsPreventFurtherUpdate) {
            this.mIsPreventFurtherUpdate = false;
        } else {
            setVisibility(this.mIsShowing ? 0 : 8);
        }
        updateChildViews();
        applyOverflowMenuClickListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void addCustomView(@NotNull View view, int horizontalGravity) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        int id = view.getId();
        if (this.mCustomViewMap.containsKey(Integer.valueOf(id))) {
            Pair<View, Integer> pair = this.mCustomViewMap.get(Integer.valueOf(id));
            removeView(pair != null ? (View) pair.first : null);
        }
        this.mCustomViewMap.put(Integer.valueOf(id), new Pair<>(view, Integer.valueOf(horizontalGravity)));
        Toolbar.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.gravity = horizontalGravity | 16;
        addView(view, layoutParamsGenerateDefaultLayoutParams);
    }

    public final void enableAdjustableMenu() {
        if (this.mTitleView == null) {
            return;
        }
        Logger.m8697d(TAG, "enableAdjustableMenu# ");
        ViewOnLayoutChangeListenerC8993a viewOnLayoutChangeListenerC8993a = new ViewOnLayoutChangeListenerC8993a(this, 0);
        this.mTitleLayoutListener = viewOnLayoutChangeListenerC8993a;
        View view = this.mTitleView;
        if (view != null) {
            view.addOnLayoutChangeListener(viewOnLayoutChangeListenerC8993a);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public int getCustomViewWidth() {
        int measuredWidth = 0;
        for (Pair<View, Integer> pair : this.mCustomViewMap.values()) {
            Intrinsics.checkNotNullExpressionValue(pair, "next(...)");
            measuredWidth += ((View) pair.first).getMeasuredWidth();
        }
        return measuredWidth;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void hideToolbar(@Nullable View contentView, boolean animate) {
        Logger.m8697d(TAG, "hideToolbar# " + animate);
        this.mIsShowing = false;
        if (animate) {
            setToolbarVisibility(contentView, 8);
            return;
        }
        View view = this.mPopupNoteView;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater
    public void inflateMenu(int resId, @Nullable Menu menu) {
        initInflateMenu(resId);
        removeCallbacks(this.mRunnableOverflowMenuClickListener);
    }

    public final void initToolbar() {
        initialize();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setHeight(this.mIsShowing ? getDefaultToolbarHeight() : 0);
        CaptionBarHelper captionBarHelper = CaptionBarHelper.INSTANCE;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
        captionBarHelper.init(rootView);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        setHeight(this.mIsShowing ? getDefaultToolbarHeight() : 0);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CaptionBarHelper captionBarHelper = CaptionBarHelper.INSTANCE;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
        captionBarHelper.release(rootView);
    }

    public final void postUpdateToolbarLayout() {
        Logger.m8697d(TAG, "postUpdateToolbarLayout");
        post(new RunnableC8995c(this, 0));
    }

    public final void release() {
        releaseTitle();
        releaseNavigationView();
        releaseCustomView();
        this.mOverflowMenuCallback = null;
        this.mVisibilityChangedListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void removeCustomView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (this.mCustomViewMap.containsKey(Integer.valueOf(id))) {
            removeView(view);
            this.mCustomViewMap.remove(Integer.valueOf(id));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setAnimationListener(@Nullable AnimatorListenerAdapter listener) {
        this.mAnimationListener = listener;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setDisplayHomeAsUpEnabled(boolean enabled) {
        if (enabled) {
            initNavigationView();
        } else {
            releaseNavigationView();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        updateMenuItemEnabledState();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setNaviUpEnabled(boolean enabled) {
        Logger.m8697d(TAG, "setNaviUpEnabled# " + enabled);
        if (this.mIsNaviUpEnabled == enabled) {
            return;
        }
        this.mIsNaviUpEnabled = enabled;
        updateNaviUpViewVisibility();
    }

    public final void setPopupNoteView(@Nullable View popupNoteView) {
        this.mPopupNoteView = popupNoteView;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setTitle(@NotNull CharSequence title, @Nullable ICustomToolbar.TitleCallback callback) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (!TextUtils.isEmpty(title) && !Intrinsics.areEqual(title, getTitle())) {
            setTitle(title);
        }
        if (callback != null) {
            callback.updateDone();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setTitleBottomView(@Nullable View titleBottomView) {
        this.mTitleBottomView = titleBottomView;
        initTitleBottomView();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setToolbarHeightChangedListener(@Nullable ICustomToolbar.ToolbarHeightChangedListener listener) {
        this.mToolbarHeightChangedListener = listener;
    }

    @Override // android.view.View, com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        ICustomToolbar.VisibilityChangedListener visibilityChangedListener = this.mVisibilityChangedListener;
        if (visibilityChangedListener != null) {
            visibilityChangedListener.onVisibilityChanged(visibility, this.mIsShowing);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setVisibilityAsResult(int visibility) {
        AbstractC4539a.m3203m(visibility, "setVisibilityAsResult# ", TAG);
        this.mIsPreventFurtherUpdate = true;
        setVisibility(visibility);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void setVisibilityChangedListener(@Nullable ICustomToolbar.VisibilityChangedListener listener) {
        this.mVisibilityChangedListener = listener;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean showOverflowMenu() {
        View view = this.mOverflowMenuButton;
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar
    public void showToolbar(@Nullable View contentView, boolean animate) {
        Logger.m8697d(TAG, "showToolbar# ");
        this.mIsShowing = true;
        if (animate) {
            setToolbarVisibility(contentView, 0);
            return;
        }
        if (getLayoutParams().height == 0) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            getLayoutParams().height = (int) typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        View view = this.mPopupNoteView;
        if (view != null) {
            view.setVisibility(0);
        }
        setVisibility(0);
    }

    public final void updateOverflowBtnBadge() {
        if (this.mOverflowMenuButton == null) {
            return;
        }
        if (this.mBadgeView == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8875R.layout.toolbar_badge_view, (ViewGroup) null);
            this.mBadgeView = viewInflate;
            if (viewInflate != null) {
                viewInflate.setLayoutParams(getBadgeLayoutParams());
            }
            View view = this.mOverflowMenuButton;
            ViewParent parent = view != null ? view.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(this.mBadgeView);
        }
        View view2 = this.mBadgeView;
        if (view2 != null) {
            view2.setVisibility(hasBadge() ? 0 : 8);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater
    public void inflateMenu(int resId, @Nullable Menu menu, @Nullable IMenuInflater.OverflowMenu overflowMenuCallback) {
        initInflateMenu(resId);
        setOverflowMenuCallback(overflowMenuCallback);
        applyOverflowMenuClickListener();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(@NotNull CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "title");
        super.setTitle(title);
        initTitleView();
        initTitleBottomView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCustomViewMap = new LinkedHashMap<>();
        this.mIsShowing = true;
        this.mIsNaviUpEnabled = true;
        this.mRunnableOverflowMenuClickListener = new RunnableC8995c(this, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCustomViewMap = new LinkedHashMap<>();
        this.mIsShowing = true;
        this.mIsNaviUpEnabled = true;
        this.mRunnableOverflowMenuClickListener = new RunnableC8995c(this, 1);
    }
}
