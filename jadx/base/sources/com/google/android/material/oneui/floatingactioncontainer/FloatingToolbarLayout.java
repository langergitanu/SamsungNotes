package com.google.android.material.oneui.floatingactioncontainer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.SeslScrollable;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.carousel.RunnableC4617a;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.oneui.floatingactioncontainer.FloatingAware;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\u001c\b\u0017\u0018\u0000 h2\u00020\u0001:\u0005hijklB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,J$\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020(H\u0014J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\n\u00106\u001a\u0004\u0018\u00010\rH\u0002J\f\u00107\u001a\u0006\u0012\u0002\b\u000308H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010/2\u0006\u0010:\u001a\u00020;H\u0002J\u000f\u0010<\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u0018\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020/2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010A\u001a\u00020\nH\u0016J\u0018\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0007H\u0016J\u0010\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020HH\u0014J0\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0014J\u0018\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0014J\u000e\u0010R\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010S\u001a\u00020(2\u0006\u0010+\u001a\u00020,J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010W\u001a\u00020(2\u0006\u0010U\u001a\u00020VH\u0002J\u0010\u0010X\u001a\u00020(2\u0006\u0010U\u001a\u00020VH\u0002J\u0012\u0010Y\u001a\u00020(2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020(H\u0016J\u0010\u0010]\u001a\u00020(2\u0006\u0010^\u001a\u00020DH\u0002J\b\u0010_\u001a\u00020(H\u0002J\b\u0010`\u001a\u00020(H\u0002J\u001f\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020\n2\b\b\u0002\u0010c\u001a\u00020\nH\u0000¢\u0006\u0002\bdJ\u001f\u0010e\u001a\u00020(2\u0006\u0010^\u001a\u00020D2\b\b\u0002\u0010f\u001a\u00020\nH\u0000¢\u0006\u0002\bgR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionForAfterAddShowBackground", "", "actionForAfterAddUseTransition", "actionModeBar", "Landroidx/appcompat/widget/ActionBarContextView;", "appBarVisibleHeight", "defaultRecyclerViewHoverTopPadding", "firstEnableToolbarItemBackgroundTransition", "firstShowFloatingToolbarItemBackground", "floatingAwarePositions", "", "forcedTopFadingEdge", "isActionMode", "isFirstLayout", "logTag", "", "getLogTag", "()Ljava/lang/String;", "titleAlphaAnimProperty", "com/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$titleAlphaAnimProperty$1", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$titleAlphaAnimProperty$1;", "titleAlphaValueAnimator", "Landroid/animation/ObjectAnimator;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "toolbarChildCount", "toolbarChildrenPosition", "toolbarTitleViCustomViewIds", "viewStubCompat", "Landroidx/appcompat/widget/ViewStubCompat;", "addCustomViewIdsForTitleVi", "", "viewId", "addHideToolbarItemBackground", "type", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "addView", "child", "Landroid/view/View;", "index", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "applyScrollableViewOptions", "checkActionMode", "ensureViewStub", "getActionModeBarView", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getScrollingView", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "getToolbar", "getToolbar$material_release", "getToolbarChildPosition", "isStateToHideCondition", "floatingScrollableView", "needInvalidateBlurViews", "onAppBarOffsetChanged", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeCustomViewIdsForTitleVi", "removeHideToolbarItemBackground", "setAlphaForTitleViCustomView", "alpha", "", "setAlphaForToolbar", "setAlphaForToolbarTitleViGroup", "setFloatingAware", "floatingAware", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware;", "setPaddingForElevation", "setTitleAlphaByCollapsingToolbarLayoutPolicy", "appbarLayout", "startProjectionViewItemAnimationIfAwareChanged", "startProjectionViewItemAnimationIfToolbarChanged", "startTitleAlphaAnimation", Constants.IntentExtraValue.SHOW, "immediately", "startTitleAlphaAnimation$material_release", "updateTitleAlphaForCurrentOffset", DBSchema.DocumentThumbnail.LAYOUT, "updateTitleAlphaForCurrentOffset$material_release", "Companion", "DefaultFloatingAware", "FloatingToolbarAware", "FloatingToolbarBehavior", "ItemBackgroundType", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingToolbarLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingToolbarLayout.kt\ncom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,873:1\n1#2:874\n*E\n"})
public class FloatingToolbarLayout extends FloatingTopLayout {
    private static final boolean DEBUG = true;
    private static final boolean DEBUG_ANIMATION = true;
    private static final int MAX_CHILD_POSITION_CHECKING_SIZE = 3;

    @NotNull
    private static final String TAG = "FloatingTbLayout";
    private static final long TITLE_ALPHA_ANIM_HIDE_DURATION = 100;
    private static final long TITLE_ALPHA_ANIM_SHOW_DURATION = 150;
    private boolean actionForAfterAddShowBackground;
    private boolean actionForAfterAddUseTransition;

    @Nullable
    private ActionBarContextView actionModeBar;
    private int appBarVisibleHeight;
    private int defaultRecyclerViewHoverTopPadding;
    private boolean firstEnableToolbarItemBackgroundTransition;
    private boolean firstShowFloatingToolbarItemBackground;

    @NotNull
    private List<Integer> floatingAwarePositions;
    private int forcedTopFadingEdge;
    private boolean isActionMode;
    private boolean isFirstLayout;

    @NotNull
    private final FloatingToolbarLayout$titleAlphaAnimProperty$1 titleAlphaAnimProperty;

    @NotNull
    private ObjectAnimator titleAlphaValueAnimator;

    @Nullable
    private Toolbar toolbar;
    private int toolbarChildCount;

    @NotNull
    private List<Integer> toolbarChildrenPosition;

    @NotNull
    private final List<Integer> toolbarTitleViCustomViewIds;

    @Nullable
    private ViewStubCompat viewStubCompat;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "Use [DefaultToolbarFloatingAware] instead", replaceWith = @ReplaceWith(expression = "FloatingToolbarAware", imports = {}))
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$DefaultFloatingAware;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$FloatingToolbarAware;", "floatingToolbarLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class DefaultFloatingAware extends FloatingToolbarAware {

        @NotNull
        private final FloatingToolbarLayout floatingToolbarLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultFloatingAware(@NotNull FloatingToolbarLayout floatingToolbarLayout) {
            super(floatingToolbarLayout);
            Intrinsics.checkNotNullParameter(floatingToolbarLayout, "floatingToolbarLayout");
            this.floatingToolbarLayout = floatingToolbarLayout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$FloatingToolbarAware;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$FloatingGroupAware;", "floatingToolbarLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "floatingComponentHeight", "", "menuEndPaddingInset", "menuEndTextPaddingInset", "menuMoreIconEndPaddingInset", "menuMoreIconStartPaddingInset", "menuStartPaddingInset", "menuStartTextPaddingInset", "navUpStartPadding", "getCurrentCustomView", "Landroid/view/View;", "getCurrentMenuView", "getCurrentNavView", "getReferenceView", "type", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingAware$PositionType;", "getReferenceViewInset", "Landroid/graphics/Rect;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class FloatingToolbarAware extends FloatingGroupLayout.FloatingGroupAware {
        private final Context context;
        private final int floatingComponentHeight;

        @NotNull
        private final FloatingToolbarLayout floatingToolbarLayout;
        private final int menuEndPaddingInset;
        private final int menuEndTextPaddingInset;
        private final int menuMoreIconEndPaddingInset;
        private final int menuMoreIconStartPaddingInset;
        private final int menuStartPaddingInset;
        private final int menuStartTextPaddingInset;
        private final int navUpStartPadding;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FloatingAware.PositionType.values().length];
                try {
                    iArr[FloatingAware.PositionType.START_FIRST.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FloatingAware.PositionType.START_SECOND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FloatingAware.PositionType.END_FIRST.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public FloatingToolbarAware(@NotNull FloatingToolbarLayout floatingToolbarLayout) {
            super(null, 1, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(floatingToolbarLayout, "floatingToolbarLayout");
            this.floatingToolbarLayout = floatingToolbarLayout;
            Context context = floatingToolbarLayout.getContext();
            this.context = context;
            this.menuStartPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_menu_start_padding_inset);
            this.menuStartTextPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_text_menu_start_padding_inset);
            this.menuEndPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_menu_end_padding_inset);
            this.menuEndTextPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_text_menu_end_padding_inset);
            this.menuMoreIconStartPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_menu_more_icon_start_padding_inset);
            this.menuMoreIconEndPaddingInset = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_menu_more_icon_end_padding_inset);
            this.navUpStartPadding = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_navup_start_padding);
            this.floatingComponentHeight = context.getResources().getDimensionPixelSize(C4548R.dimen.sesl_projection_bg_toolbar_component_height);
        }

        private final View getCurrentCustomView() {
            FloatingToolbarLayout floatingToolbarLayout = this.floatingToolbarLayout;
            if (floatingToolbarLayout.isActionMode) {
                ActionBarContextView actionModeBarView = floatingToolbarLayout.getActionModeBarView();
                if (actionModeBarView != null) {
                    return actionModeBarView.seslGetCustomView();
                }
                return null;
            }
            Toolbar toolbar$material_release = floatingToolbarLayout.getToolbar$material_release();
            if (toolbar$material_release != null) {
                return toolbar$material_release.seslGetCustomView();
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final View getCurrentMenuView() {
            ActionMenuView actionMenuViewSeslGetMenuView;
            FloatingToolbarLayout floatingToolbarLayout = this.floatingToolbarLayout;
            if (floatingToolbarLayout.isActionMode) {
                ActionBarContextView actionModeBarView = floatingToolbarLayout.getActionModeBarView();
                actionMenuViewSeslGetMenuView = actionModeBarView != null ? actionModeBarView.seslGetMenuView() : null;
            } else {
                Toolbar toolbar$material_release = floatingToolbarLayout.getToolbar$material_release();
                if (toolbar$material_release != null) {
                    actionMenuViewSeslGetMenuView = toolbar$material_release.seslGetMenuView();
                }
            }
            if (actionMenuViewSeslGetMenuView == null || actionMenuViewSeslGetMenuView.getChildCount() == 0) {
                return null;
            }
            return actionMenuViewSeslGetMenuView;
        }

        private final View getCurrentNavView() {
            FloatingToolbarLayout floatingToolbarLayout = this.floatingToolbarLayout;
            if (!floatingToolbarLayout.isActionMode) {
                Toolbar toolbar$material_release = floatingToolbarLayout.getToolbar$material_release();
                View navButtonView = toolbar$material_release != null ? toolbar$material_release.getNavButtonView() : null;
                if (navButtonView == null || navButtonView.getParent() == null) {
                    return null;
                }
                return navButtonView;
            }
            ActionBarContextView actionModeBarView = floatingToolbarLayout.getActionModeBarView();
            View viewSeslGetCloseButton = actionModeBarView != null ? actionModeBarView.seslGetCloseButton() : null;
            if (viewSeslGetCloseButton == null || viewSeslGetCloseButton.getVisibility() != 0 || viewSeslGetCloseButton.getParent() == null) {
                return null;
            }
            return viewSeslGetCloseButton;
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout.FloatingGroupAware, com.google.android.material.oneui.floatingactioncontainer.FloatingAware
        @Nullable
        public View getReferenceView(@NotNull FloatingAware.PositionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            View currentNavView = getCurrentNavView();
            View currentCustomView = getCurrentCustomView();
            View currentMenuView = getCurrentMenuView();
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return currentMenuView;
                }
                if (currentNavView == null || currentCustomView == null) {
                    return null;
                }
            } else if (currentNavView != null) {
                return currentNavView;
            }
            return currentCustomView;
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
        @NotNull
        public Rect getReferenceViewInset(@NotNull FloatingAware.PositionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                View currentNavView = getCurrentNavView();
                if (currentNavView == null) {
                    return new Rect();
                }
                int height = (currentNavView.getHeight() - this.floatingComponentHeight) / 2;
                return new Rect(this.navUpStartPadding, height, 0, height);
            }
            if (i == 2) {
                return new Rect();
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            View currentMenuView = getCurrentMenuView();
            Rect rect = null;
            ActionMenuView actionMenuView = currentMenuView instanceof ActionMenuView ? (ActionMenuView) currentMenuView : null;
            if (actionMenuView != null) {
                if (actionMenuView.getChildCount() > 0) {
                    View childAt = actionMenuView.getChildAt(0);
                    ActionMenuItemView actionMenuItemView = childAt instanceof ActionMenuItemView ? (ActionMenuItemView) childAt : null;
                    View childAt2 = actionMenuView.getChildAt(actionMenuView.getChildCount() - 1);
                    ActionMenuItemView actionMenuItemView2 = childAt2 instanceof ActionMenuItemView ? (ActionMenuItemView) childAt2 : null;
                    boolean zSeslIsTextButtonVisible = actionMenuItemView != null ? actionMenuItemView.seslIsTextButtonVisible() : false;
                    boolean zSeslIsTextButtonVisible2 = actionMenuItemView2 != null ? actionMenuItemView2.seslIsTextButtonVisible() : false;
                    int height2 = (actionMenuView.getHeight() - this.floatingComponentHeight) / 2;
                    rect = new Rect((actionMenuView.getChildCount() == 1 && actionMenuView.seslIsShowOverflowButton()) ? this.menuMoreIconStartPaddingInset : zSeslIsTextButtonVisible ? this.menuStartTextPaddingInset : this.menuStartPaddingInset, height2, actionMenuView.seslIsShowOverflowButton() ? this.menuMoreIconEndPaddingInset : zSeslIsTextButtonVisible2 ? this.menuEndTextPaddingInset : this.menuEndPaddingInset, height2);
                }
                if (rect != null) {
                    return rect;
                }
            }
            return new Rect();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0015J=\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u001dJ%\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001fJ\u001d\u0010 \u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010!¨\u0006\""}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$FloatingToolbarBehavior;", "T", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout$FloatingTopBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onAppBarStateChanged", "", "oldState", "", "newState", "child", "(IILcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;)V", "onLayoutChild", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "layoutDirection", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;I)Z", "onStartNestedScroll", "coordinatorLayout", "directTargetChild", "Landroid/view/View;", "target", "axes", "type", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;Landroid/view/View;Landroid/view/View;II)Z", "startTitleAnimationForAppBarStateChanged", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;II)V", "updateStateToHideCondition", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class FloatingToolbarBehavior<T extends FloatingToolbarLayout> extends FloatingTopLayout.FloatingTopBehavior<T> {
        public /* synthetic */ FloatingToolbarBehavior(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        private final void startTitleAnimationForAppBarStateChanged(T child, int oldState, int newState) {
            if (newState == 4) {
                child.startTitleAlphaAnimation$material_release(false, true);
                return;
            }
            if ((newState & 4) != 0) {
                if ((oldState & 2) != 0) {
                    FloatingToolbarLayout.startTitleAlphaAnimation$material_release$default(child, false, false, 2, null);
                }
            } else if (newState == 2) {
                FloatingToolbarLayout.startTitleAlphaAnimation$material_release$default(child, true, false, 2, null);
            }
        }

        private final void updateStateToHideCondition(CoordinatorLayout parent, T child) {
            List<View> dependencies = parent.getDependencies(child);
            Intrinsics.checkNotNullExpressionValue(dependencies, "parent.getDependencies(child)");
            AppBarLayout appBarLayout$material_release = child.getAppBarLayout$material_release(dependencies);
            if (appBarLayout$material_release != null) {
                View recyclerView = child.getRecyclerView();
                if (recyclerView == null) {
                    recyclerView = child.getNestedScrollView();
                }
                if (!appBarLayout$material_release.useFloatingToolbar() || recyclerView == null) {
                    return;
                }
                if (child.isStateToHideCondition(recyclerView, parent)) {
                    appBarLayout$material_release.seslInternalSetAllowStateToHide(true);
                } else {
                    appBarLayout$material_release.seslInternalSetAllowStateToHide(false);
                    LogTagHelperKt.info(this, "Force disable floating appbar because of it is no scrollable");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatingToolbarBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout.FloatingTopBehavior
        public void onAppBarStateChanged(int oldState, int newState, @NotNull T child) {
            Intrinsics.checkNotNullParameter(child, "child");
            super.onAppBarStateChanged(oldState, newState, child);
            startTitleAnimationForAppBarStateChanged(child, oldState, newState);
            Toolbar toolbar$material_release = child.getToolbar$material_release();
            if (toolbar$material_release != null) {
                toolbar$material_release.seslSetEatingTouchOnly((newState & 4) == 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull T child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
            Intrinsics.checkNotNullParameter(target, "target");
            updateStateToHideCondition(coordinatorLayout, child);
            return false;
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout.FloatingTopBehavior
        public boolean onLayoutChild(@NotNull CoordinatorLayout parent, @NotNull T child, int layoutDirection) {
            AppBarLayout appBarLayout$material_release;
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            if (getIsFirstLayoutChild() && (appBarLayout$material_release = child.getAppBarLayout$material_release()) != null) {
                child.updateTitleAlphaForCurrentOffset$material_release(appBarLayout$material_release, true);
            }
            updateStateToHideCondition(parent, child);
            return super.onLayoutChild(parent, child, layoutDirection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout$ItemBackgroundType;", "", "(Ljava/lang/String;I)V", "START_FIRST", "START_SECOND", "END_FIRST", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @Deprecated(message = "Use FloatingAware type")
    public enum ItemBackgroundType {
        START_FIRST,
        START_SECOND,
        END_FIRST
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingToolbarLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void checkActionMode() {
        ActionBarContextView actionBarContextView = this.actionModeBar;
        boolean z = false;
        if (actionBarContextView != null && actionBarContextView.getVisibility() == 0) {
            z = true;
        }
        this.isActionMode = z;
    }

    private final void ensureViewStub() {
        ViewStubCompat viewStubCompat = this.viewStubCompat;
        if (viewStubCompat != null) {
            Intrinsics.checkNotNull(viewStubCompat);
            viewStubCompat.bringToFront();
            ViewStubCompat viewStubCompat2 = this.viewStubCompat;
            Intrinsics.checkNotNull(viewStubCompat2);
            viewStubCompat2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActionBarContextView getActionModeBarView() {
        return (ActionBarContextView) findViewById(C4548R.id.action_mode_bar);
    }

    private final View getScrollingView(CoordinatorLayout coordinatorLayout) {
        for (View view : ViewGroupKt.getChildren(coordinatorLayout)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            if (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior) {
                return view;
            }
        }
        return null;
    }

    private final List<Integer> getToolbarChildPosition() {
        View referenceView = getFloatingAware$material_release().getReferenceView(FloatingAware.PositionType.START_FIRST);
        View referenceView2 = getFloatingAware$material_release().getReferenceView(FloatingAware.PositionType.START_SECOND);
        View referenceView3 = getFloatingAware$material_release().getReferenceView(FloatingAware.PositionType.END_FIRST);
        List<Integer> listMutableListOf = CollectionsKt.mutableListOf(-1, -1, -1, -1, -1, -1);
        listMutableListOf.set(0, Integer.valueOf(referenceView != null ? referenceView.getLeft() : -1));
        listMutableListOf.set(1, Integer.valueOf(referenceView != null ? referenceView.getRight() : -1));
        listMutableListOf.set(2, Integer.valueOf(referenceView2 != null ? referenceView2.getLeft() : -1));
        listMutableListOf.set(3, Integer.valueOf(referenceView2 != null ? referenceView2.getRight() : -1));
        listMutableListOf.set(4, Integer.valueOf(referenceView3 != null ? referenceView3.getLeft() : -1));
        listMutableListOf.set(5, Integer.valueOf(referenceView3 != null ? referenceView3.getRight() : -1));
        return listMutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStateToHideCondition(View floatingScrollableView, CoordinatorLayout coordinatorLayout) {
        int iMax;
        int top;
        int measuredHeight;
        if (!Intrinsics.areEqual(getFloatingScrollableManager$material_release().getView(), floatingScrollableView)) {
            LogTagHelperKt.warn(this, "isStateToHideCondition floatingScrollableView is not synced (" + floatingScrollableView + ") != (" + getFloatingScrollableManager$material_release().getView() + PropertyUtils.MAPPED_DELIM2);
        }
        if (floatingScrollableView.canScrollVertically(-1)) {
            return true;
        }
        AppBarLayout appBarLayout$material_release = getAppBarLayout$material_release();
        if (appBarLayout$material_release != null) {
            top = appBarLayout$material_release.getTop() + appBarLayout$material_release.getHeight();
            iMax = Math.max(top - ((int) appBarLayout$material_release.seslGetCollapsedHeight()), 0);
        } else {
            iMax = 0;
            top = 0;
        }
        SeslScrollable floatingScrollable = getFloatingScrollableManager$material_release().getView();
        if (floatingScrollable != null && !getFloatingScrollableManager$material_release().isValidCondition(floatingScrollable) && getAppBarLayout$material_release() != null) {
            AppBarLayout appBarLayout$material_release2 = getAppBarLayout$material_release();
            if (appBarLayout$material_release2 != null) {
                measuredHeight = (appBarLayout$material_release2.seslGetAppBarState().getState() & 4) != 0 ? appBarLayout$material_release2.getMeasuredHeight() : 0;
                this.appBarVisibleHeight = appBarLayout$material_release2.getTop() + appBarLayout$material_release2.getHeight();
            } else {
                measuredHeight = 0;
            }
            StringBuilder sbM778t = AbstractC0541b.m778t(measuredHeight, "Update avail rect because avail bottom is zero. update top=", ", bottom=");
            sbM778t.append(this.appBarVisibleHeight);
            LogTagHelperKt.info(this, sbM778t.toString());
            getFloatingScrollableManager$material_release().applyAvailBound(measuredHeight, -1, this.appBarVisibleHeight);
        }
        return !getFloatingScrollableManager$material_release().isInScreen(coordinatorLayout.getHeight(), top, iMax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayout$lambda$5$lambda$4(ActionBarContextView this_apply, FloatingToolbarLayout this$0) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = this_apply.getVisibility() == 0;
        if (z != this$0.isActionMode) {
            FloatingGroupLayout.SeslProjectionView.startProjectionViewItemAnimation$default(this$0.getProjectionView(), false, 1, null);
            this$0.isActionMode = z;
            if (z) {
                Iterator<Integer> it = this$0.toolbarTitleViCustomViewIds.iterator();
                while (it.hasNext()) {
                    View viewFindViewById = this_apply.findViewById(it.next().intValue());
                    if (viewFindViewById != null) {
                        viewFindViewById.post(new RunnableC4617a(this$0, 3));
                    }
                }
            }
        }
        Toolbar toolbar$material_release = this$0.getToolbar$material_release();
        if (toolbar$material_release != null) {
            toolbar$material_release.setVisibility(this$0.isActionMode ? 4 : 0);
            CoordinatorLayout.Behavior<?> behavior = this$0.getBehavior();
            Intrinsics.checkNotNull(behavior, "null cannot be cast to non-null type com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout.FloatingToolbarBehavior<*>");
            AppBarLayout appbarLayout = ((FloatingToolbarBehavior) behavior).getAppbarLayout();
            if (appbarLayout != null) {
                this$0.updateTitleAlphaForCurrentOffset$material_release(appbarLayout, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLayout$lambda$5$lambda$4$lambda$1(FloatingToolbarLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppBarLayout appBarLayout$material_release = this$0.getAppBarLayout$material_release();
        if (appBarLayout$material_release != null) {
            this$0.updateTitleAlphaForCurrentOffset$material_release(appBarLayout$material_release, true);
        }
    }

    private final void setAlphaForTitleViCustomView(float alpha) {
        Iterator<Integer> it = this.toolbarTitleViCustomViewIds.iterator();
        while (it.hasNext()) {
            View viewFindViewById = findViewById(it.next().intValue());
            if (viewFindViewById != null) {
                viewFindViewById.setAlpha(alpha);
            }
        }
    }

    private final void setAlphaForToolbar(float alpha) {
        Toolbar toolbar$material_release = getToolbar$material_release();
        if (toolbar$material_release != null) {
            toolbar$material_release.seslSetTitleAlpha(alpha);
            Drawable background = toolbar$material_release.getBackground();
            if (background != null) {
                background.mutate().setAlpha((int) (255 * alpha));
                toolbar$material_release.seslSetSubtitleAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAlphaForToolbarTitleViGroup(float alpha) {
        setAlphaForToolbar(alpha);
        setAlphaForTitleViCustomView(alpha);
    }

    private final void setTitleAlphaByCollapsingToolbarLayoutPolicy(AppBarLayout appbarLayout) {
        float height;
        float fSeslGetCollapsedHeight = appbarLayout.useCollapsedHeight() ? appbarLayout.seslGetCollapsedHeight() : getResources().getDimensionPixelSize(C0419R.dimen.sesl_action_bar_height_with_padding);
        float height2 = appbarLayout.getHeight() * 0.143f;
        int iAbs = Math.abs(appbarLayout.getTop());
        if (appbarLayout.getBottom() > ((int) fSeslGetCollapsedHeight) && !appbarLayout.seslIsCollapsed()) {
            height = (iAbs - (appbarLayout.getHeight() * 0.35f)) * (150 / height2);
            if (height < 0.0f) {
                height = 0.0f;
            } else if (height > 255.0f) {
            }
            setAlphaForToolbarTitleViGroup(height / 255.0f);
        }
        Toolbar toolbar$material_release = getToolbar$material_release();
        if (toolbar$material_release != null) {
            toolbar$material_release.setTitleAccessibilityEnabled(true);
        }
        height = 255.0f;
        setAlphaForToolbarTitleViGroup(height / 255.0f);
    }

    private final void startProjectionViewItemAnimationIfAwareChanged() {
        List<Integer> toolbarChildPosition = getToolbarChildPosition();
        if (Intrinsics.areEqual(toolbarChildPosition, this.floatingAwarePositions)) {
            return;
        }
        getProjectionView().startProjectionViewItemAnimation(true);
        this.floatingAwarePositions = toolbarChildPosition;
    }

    private final void startProjectionViewItemAnimationIfToolbarChanged() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            if (this.toolbarChildCount != toolbar.getChildCount()) {
                getProjectionView().startProjectionViewItemAnimation(true);
                this.toolbarChildCount = toolbar.getChildCount();
                return;
            }
            List<Integer> listMutableListOf = CollectionsKt.mutableListOf(-1, -1, -1, -1, -1, -1);
            int iMin = Math.min(3, toolbar.getChildCount());
            for (int i = 0; i < iMin; i++) {
                View childAt = toolbar.getChildAt(i);
                int i2 = i * 2;
                listMutableListOf.set(i2, Integer.valueOf(childAt.getLeft()));
                listMutableListOf.set(i2 + 1, Integer.valueOf(childAt.getRight()));
            }
            if (Intrinsics.areEqual(this.toolbarChildrenPosition, listMutableListOf)) {
                return;
            }
            getProjectionView().startProjectionViewItemAnimation(true);
            this.toolbarChildrenPosition = listMutableListOf;
        }
    }

    public static /* synthetic */ void startTitleAlphaAnimation$material_release$default(FloatingToolbarLayout floatingToolbarLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTitleAlphaAnimation");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        floatingToolbarLayout.startTitleAlphaAnimation$material_release(z, z2);
    }

    public static /* synthetic */ void updateTitleAlphaForCurrentOffset$material_release$default(FloatingToolbarLayout floatingToolbarLayout, AppBarLayout appBarLayout, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTitleAlphaForCurrentOffset");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        floatingToolbarLayout.updateTitleAlphaForCurrentOffset$material_release(appBarLayout, z);
    }

    public final void addCustomViewIdsForTitleVi(int viewId) {
        this.toolbarTitleViCustomViewIds.add(Integer.valueOf(viewId));
        AppBarLayout appBarLayout$material_release = getAppBarLayout$material_release();
        if (appBarLayout$material_release != null) {
            if (appBarLayout$material_release.seslGetCurrentAppBarState() == 4) {
                setAlphaForToolbarTitleViGroup(0.0f);
            } else {
                updateTitleAlphaForCurrentOffset$material_release(appBarLayout$material_release, false);
            }
        }
    }

    public final void addHideToolbarItemBackground(@NotNull FloatingAware.PositionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        LogTagHelperKt.info(this, "Force hide projection view " + type);
        getProjectionView().addHideBackgroundType(type);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        if (!(child instanceof Toolbar)) {
            super.addView(child, index, params);
            return;
        }
        final Toolbar toolbar = (Toolbar) child;
        this.toolbar = toolbar;
        if (this.actionForAfterAddUseTransition) {
            FloatingTopLayout.enableToolbarItemBackgroundTransition$default(this, this.firstEnableToolbarItemBackgroundTransition, false, 2, null);
        }
        if (this.actionForAfterAddShowBackground) {
            FloatingGroupLayout.showFloatingItemBackground$default(this, this.firstShowFloatingToolbarItemBackground, false, 2, null);
        }
        toolbar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout$addView$1$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                toolbar.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        super.addView(child, index, params);
        setFloatingAware(null);
        getProjectionView().startProjectionViewAlphaAnimation(0.0f, true);
        addFloatingBackgroundAnimatorListener(new Animator.AnimatorListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout.addView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Toolbar toolbar$material_release = FloatingToolbarLayout.this.getToolbar$material_release();
                if (toolbar$material_release != null) {
                    toolbar$material_release.seslSetEatingHover(!(FloatingToolbarLayout.this.getAlpha() == 1.0f));
                }
                ActionBarContextView actionModeBarView = FloatingToolbarLayout.this.getActionModeBarView();
                if (actionModeBarView != null) {
                    actionModeBarView.seslSetEatingTouchOnly(!(FloatingToolbarLayout.this.getAlpha() == 1.0f));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void applyScrollableViewOptions() {
        super.applyScrollableViewOptions();
        getFloatingScrollableManager$material_release().forceTopFadingEdgeClamped(this.forcedTopFadingEdge);
        getFloatingScrollableManager$material_release().applyAvailBound(-1, -1, this.appBarVisibleHeight);
        if (getWithAppBarLayout()) {
            return;
        }
        getFloatingScrollableManager$material_release().setFloatingToolbarLayoutHeight(getMeasuredHeight());
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FloatingToolbarBehavior(context, getAttrs());
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "FloatingToolbarLayout";
    }

    @Nullable
    public final Toolbar getToolbar$material_release() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            Intrinsics.checkNotNull(toolbar, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
            return toolbar;
        }
        for (View view : ViewGroupKt.getChildren(this)) {
            if (view instanceof Toolbar) {
                Toolbar toolbar2 = (Toolbar) view;
                this.toolbar = toolbar2;
                return toolbar2;
            }
        }
        LogTagHelperKt.warn(this, "FloatingToolbar layout Not have a Toolbar");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int iMin = Math.min(stackTrace.length, 7);
        for (int i = 0; i < iMin; i++) {
            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
            String string = stackTrace[i].toString();
            Intrinsics.checkNotNullExpressionValue(string, "stackTrace.elementAt(index).toString()");
            LogTagHelperKt.warn(this, string);
        }
        return null;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout, com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public boolean needInvalidateBlurViews() {
        return (getAlpha() == 0.0f || getProjectionView().getAlpha() == 0.0f) ? false : true;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void onAppBarOffsetChanged(@NotNull AppBarLayout appBarLayout, int verticalOffset) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        this.appBarVisibleHeight = appBarLayout.getHeight() + verticalOffset;
        int iSeslGetCollapsedHeight = (int) appBarLayout.seslGetCollapsedHeight();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iSeslGetCollapsedHeight - this.appBarVisibleHeight, 0);
        int iSeslGetProportionExtraHeight = appBarLayout.seslGetProportionExtraHeight();
        getFloatingScrollableManager$material_release().setScrollBarTopOffset(iSeslGetCollapsedHeight, iCoerceAtLeast);
        this.forcedTopFadingEdge = RangesKt.coerceAtLeast(iCoerceAtLeast - iSeslGetProportionExtraHeight, 0);
        getFloatingScrollableManager$material_release().forceTopFadingEdgeClamped(this.forcedTopFadingEdge);
        getFloatingScrollableManager$material_release().applyAvailBound((appBarLayout.seslGetAppBarState().getState() & 4) != 0 ? getMeasuredHeight() : 0, -1, this.appBarVisibleHeight);
        if (appBarLayout.useFloatingToolbar()) {
            getFloatingScrollableManager$material_release().setFadingEdgeBottomOffset(appBarLayout.getTop() + appBarLayout.getHeight());
            if (iSeslGetCollapsedHeight - this.appBarVisibleHeight >= 0) {
                getFloatingScrollableManager$material_release().setFloatingToolbarLayoutHeight(iCoerceAtLeast);
            }
        } else {
            getFloatingScrollableManager$material_release().setFadingEdgeBottomOffset((int) ((appBarLayout.getTop() + appBarLayout.getHeight()) - appBarLayout.seslGetCollapsedHeight()));
        }
        getFloatingScrollableManager$material_release().invalidateScrollableView();
        getFloatingScrollableManager$material_release().setAppBarOffset(appBarLayout.getTop() + appBarLayout.getMeasuredHeight());
        super.onAppBarOffsetChanged(appBarLayout, verticalOffset);
        updateTitleAlphaForCurrentOffset$material_release(appBarLayout, false);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        ensureViewStub();
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Toolbar toolbar$material_release = getToolbar$material_release();
        if (toolbar$material_release != null) {
            if (this.isFirstLayout) {
                checkDependenceToAppBar();
                getProjectionView().startProjectionViewItemAnimation(false);
                applyScrollableViewOptions();
                this.isFirstLayout = false;
                this.toolbarChildCount = toolbar$material_release.getChildCount();
                int iMin = Math.min(3, toolbar$material_release.getChildCount());
                for (int i = 0; i < iMin; i++) {
                    View childAt = toolbar$material_release.getChildAt(i);
                    int i2 = i * 2;
                    this.toolbarChildrenPosition.set(i2, Integer.valueOf(childAt.getLeft()));
                    this.toolbarChildrenPosition.set(i2 + 1, Integer.valueOf(childAt.getRight()));
                }
            }
            if (!getWithAppBarLayout()) {
                getProjectionView().startProjectionViewItemAnimation(false);
            }
            if (this.actionModeBar == null) {
                final ActionBarContextView actionBarContextView = (ActionBarContextView) findViewById(C4548R.id.action_mode_bar);
                this.actionModeBar = actionBarContextView;
                if (actionBarContextView != null) {
                    actionBarContextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.e
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            FloatingToolbarLayout.onLayout$lambda$5$lambda$4(actionBarContextView, this);
                        }
                    });
                }
            }
        } else {
            getProjectionView().startProjectionViewItemAnimation(false);
        }
        Toolbar toolbar$material_release2 = getToolbar$material_release();
        if (toolbar$material_release2 != null) {
            toolbar$material_release2.seslSetEatingHover(!(getAlpha() == 1.0f));
        }
        ActionBarContextView actionModeBarView = getActionModeBarView();
        if (actionModeBarView != null) {
            actionModeBarView.seslSetEatingTouchOnly(true ^ (getAlpha() == 1.0f));
        }
        super.onLayout(changed, left, top, right, bottom);
        if (toolbar$material_release != null) {
            startProjectionViewItemAnimationIfToolbarChanged();
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureViewStub();
        Toolbar toolbar$material_release = getToolbar$material_release();
        if (toolbar$material_release == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        measureChild(toolbar$material_release, widthMeasureSpec, heightMeasureSpec);
        ActionBarContextView actionModeBarView = getActionModeBarView();
        if (actionModeBarView != null) {
            actionModeBarView.measure(widthMeasureSpec, heightMeasureSpec);
        }
        setMeasuredDimension(getPaddingEnd() + getPaddingStart() + toolbar$material_release.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + toolbar$material_release.getMeasuredHeight());
        getProjectionView().measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        AppBarLayout appBarLayout$material_release = getAppBarLayout$material_release();
        if (appBarLayout$material_release != null) {
            for (View view : ViewGroupKt.getChildren(appBarLayout$material_release)) {
                if (view instanceof CollapsingToolbarLayout) {
                    ((CollapsingToolbarLayout) view).setMinimumHeight(toolbar$material_release.getMeasuredHeight());
                    return;
                }
            }
        }
    }

    public final void removeCustomViewIdsForTitleVi(int viewId) {
        this.toolbarTitleViCustomViewIds.remove(Integer.valueOf(viewId));
    }

    public final void removeHideToolbarItemBackground(@NotNull FloatingAware.PositionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        LogTagHelperKt.info(this, "Force hide projection view " + type);
        getProjectionView().removeHideBackgroundType(type);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void setFloatingAware(@Nullable FloatingAware floatingAware) {
        checkActionMode();
        if (floatingAware == null) {
            LogTagHelperKt.info(this, "Use default FloatingToolbarAware FloatingAware");
        } else {
            LogTagHelperKt.info(this, "Use custom CustomAware(Toolbar) FloatingAware");
        }
        if (floatingAware == null) {
            floatingAware = new FloatingToolbarAware(this);
        }
        super.setFloatingAware(floatingAware);
    }

    public final void startTitleAlphaAnimation$material_release(boolean show, boolean immediately) {
        float f = show ? 1.0f : 0.0f;
        if (this.toolbar != null) {
            if (this.titleAlphaValueAnimator.isRunning() || immediately) {
                this.titleAlphaValueAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.toolbar, this.titleAlphaAnimProperty, f);
            Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(toolbar, titleAlphaAnimProperty, end)");
            this.titleAlphaValueAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(immediately ? 0L : show ? 150L : 100L);
            objectAnimatorOfFloat.start();
        }
    }

    public final void updateTitleAlphaForCurrentOffset$material_release(@NotNull AppBarLayout appbarLayout, boolean layout) {
        AppBarLayout appBarLayout$material_release;
        Intrinsics.checkNotNullParameter(appbarLayout, "appbarLayout");
        if (appbarLayout.getBottom() >= appbarLayout.seslGetCollapsedHeight()) {
            if (this.titleAlphaValueAnimator.isRunning()) {
                this.titleAlphaValueAnimator.cancel();
            }
            setTitleAlphaByCollapsingToolbarLayoutPolicy(appbarLayout);
        } else if (layout) {
            setAlphaForToolbarTitleViGroup(0.0f);
            if (getAppBarLayout$material_release() == null || (appBarLayout$material_release = getAppBarLayout$material_release()) == null || appBarLayout$material_release.seslGetCurrentAppBarState() != 2) {
                return;
            }
            setAlphaForToolbarTitleViGroup(1.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatingToolbarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FloatingToolbarLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout$titleAlphaAnimProperty$1] */
    @JvmOverloads
    public FloatingToolbarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.toolbarTitleViCustomViewIds = new ArrayList();
        this.defaultRecyclerViewHoverTopPadding = -1;
        this.isFirstLayout = true;
        this.floatingAwarePositions = CollectionsKt.mutableListOf(-1, -1, -1, -1, -1, -1);
        this.toolbarChildrenPosition = CollectionsKt.mutableListOf(-1, -1, -1, -1, -1, -1);
        this.titleAlphaValueAnimator = new ObjectAnimator();
        this.titleAlphaAnimProperty = new FloatProperty<Toolbar>() { // from class: com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout$titleAlphaAnimProperty$1
            {
                super("titleAlphaAnimProperty");
            }

            @Override // android.util.Property
            public Float get(Toolbar toolbar) {
                Intrinsics.checkNotNullParameter(toolbar, "toolbar");
                return Float.valueOf(toolbar.getTitleTextView() == null ? 0.0f : toolbar.getTitleTextView().getAlpha());
            }

            @Override // android.util.FloatProperty
            public void setValue(Toolbar toolbar, float value) {
                Intrinsics.checkNotNullParameter(toolbar, "toolbar");
                this.this$0.setAlphaForToolbarTitleViGroup(value);
            }
        };
        LayoutInflater.from(context).inflate(C4548R.layout.sesl_floating_appbar_action_mode_view_stub, (ViewGroup) this, true);
        this.viewStubCompat = (ViewStubCompat) findViewById(C4548R.id.action_mode_bar_stub);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, C4548R.styleable.FloatingToolbarLayout, i, 0, new int[0]);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(\n…tyleAttr, 0\n            )");
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.FloatingToolbarLayout_seslEnableToolbarItemTransition)) {
            this.actionForAfterAddUseTransition = true;
            this.firstEnableToolbarItemBackgroundTransition = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.FloatingToolbarLayout_seslEnableToolbarItemTransition, false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(C4548R.styleable.FloatingToolbarLayout_seslShowToolbarItemBackground)) {
            this.actionForAfterAddShowBackground = true;
            this.firstShowFloatingToolbarItemBackground = typedArrayObtainStyledAttributes.getBoolean(C4548R.styleable.FloatingToolbarLayout_seslShowToolbarItemBackground, false);
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void setPaddingForElevation() {
    }
}
