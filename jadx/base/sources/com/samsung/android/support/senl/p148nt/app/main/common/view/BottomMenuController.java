package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingAware;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 D2\u00020\u0001:\u0003BCDB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\"\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0012\u0010#\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\rJ\u001e\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\rH\u0003J\b\u0010-\u001a\u00020\u001bH\u0002J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\u000e\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u0011J\b\u00102\u001a\u0004\u0018\u000103J\u000e\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u0011J\u0010\u00106\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u000108J\u0018\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0018\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010>J\b\u0010?\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010@\u001a\u00020AR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController;", "", "fragment", "Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/common/view/AbsFragment;Landroidx/recyclerview/widget/RecyclerView;)V", "mBottomNaviView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "mFloatingBottomLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "mBottomProgressCircleId", "", "mMainBlockView", "Landroid/widget/FrameLayout;", "mIsHidingBottomLayout", "", "mNaviViewAnimator", "Landroid/animation/ObjectAnimator;", "iconMenuCount", "getIconMenuCount", "()I", "setIconMenuCount", "(I)V", "getFloatingBottomVisibility", "setFloatingBottomVisibilityForSearch", "", "isVisible", "inflateBottomNavigationMenu", "resId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/material/navigation/NavigationBarView$OnItemSelectedListener;", "bottomNaviType", "Lcom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController$BottomNaviType;", "inflateBottomNavigationView", "setProgressCircleId", "viewById", "showDragAndDropImage", "imageView", "Landroid/view/View;", ImageConst.ImageUpscaleConst.KEY_IMAGE_SIZE, "checkProgressCircle", "showBottomProgressCircle", "bottomProgressCircleId", "showProgressCircle", "showProgressDim", "dismissProgressCircle", "showBottomNavigation", Constants.IntentExtraValue.SHOW, "getBottomNavigationMenu", "Landroid/view/Menu;", "enableScrollTransitionOfFloating", "enable", "addBlurForTabLayout", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "playInOutAnimation", "visibility", "floatingBottomLayout", "playItemChangeAnimation", "isFadeIn", "Lcom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController$AnimationEndListener;", "getFloatingBottomLayout", "getTag", "", "BottomNaviType", "AnimationEndListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBottomMenuController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BottomMenuController.kt\ncom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 4 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,363:1\n47#2:364\n29#2:365\n28#3:366\n45#4:367\n*S KotlinDebug\n*F\n+ 1 BottomMenuController.kt\ncom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController\n*L\n178#1:364\n180#1:365\n223#1:366\n244#1:367\n*E\n"})
public final class BottomMenuController {
    private static final long FLOATING_BOTTOM_OUT_ANIMATION_DELAY = 150;

    @NotNull
    private static final String TAG = "BottomMenuController";

    @NotNull
    private final AbsFragment fragment;
    private int iconMenuCount;

    @Nullable
    private BottomNavigationView mBottomNaviView;
    private int mBottomProgressCircleId;

    @Nullable
    private FloatingBottomLayout mFloatingBottomLayout;
    private boolean mIsHidingBottomLayout;

    @Nullable
    private FrameLayout mMainBlockView;

    @Nullable
    private ObjectAnimator mNaviViewAnimator;

    @NotNull
    private final RecyclerView recyclerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController$AnimationEndListener;", "", "onAnimationEnd", "", "isCancel", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationEndListener {
        void onAnimationEnd(boolean isCancel);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/view/BottomMenuController$BottomNaviType;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "IconOnly", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT_ONLY, "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BottomNaviType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BottomNaviType[] $VALUES;
        public static final BottomNaviType Normal = new BottomNaviType("Normal", 0);
        public static final BottomNaviType IconOnly = new BottomNaviType("IconOnly", 1);
        public static final BottomNaviType TextOnly = new BottomNaviType(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT_ONLY, 2);

        private static final /* synthetic */ BottomNaviType[] $values() {
            return new BottomNaviType[]{Normal, IconOnly, TextOnly};
        }

        static {
            BottomNaviType[] bottomNaviTypeArr$values = $values();
            $VALUES = bottomNaviTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(bottomNaviTypeArr$values);
        }

        private BottomNaviType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<BottomNaviType> getEntries() {
            return $ENTRIES;
        }

        public static BottomNaviType valueOf(String str) {
            return (BottomNaviType) Enum.valueOf(BottomNaviType.class, str);
        }

        public static BottomNaviType[] values() {
            return (BottomNaviType[]) $VALUES.clone();
        }
    }

    public BottomMenuController(@NotNull AbsFragment fragment, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.fragment = fragment;
        this.recyclerView = recyclerView;
        if (this.mFloatingBottomLayout == null) {
            FragmentActivity activity = fragment.getActivity();
            if (CommonUtil.isNotAvailableActivity(activity)) {
                return;
            }
            Intrinsics.checkNotNull(activity);
            this.mFloatingBottomLayout = (FloatingBottomLayout) activity.findViewById(C8003R.id.floating_bottom_layout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addBlurForTabLayout$lambda$1$lambda$0(FloatingBottomLayout floatingBottomLayout, TabLayout tabLayout) {
        floatingBottomLayout.addBlurInvalidateTargetViews(CollectionsKt.listOf(tabLayout));
        floatingBottomLayout.invalidateBlurTargetView();
    }

    private final void dismissProgressCircle() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (this.mMainBlockView == null) {
            this.mMainBlockView = (FrameLayout) activity.findViewById(C8003R.id.main_view_block);
        }
        FrameLayout frameLayout = this.mMainBlockView;
        if (frameLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.removeAllViews();
        FrameLayout frameLayout2 = this.mMainBlockView;
        Intrinsics.checkNotNull(frameLayout2);
        frameLayout2.setVisibility(8);
        FrameLayout frameLayout3 = this.mMainBlockView;
        Intrinsics.checkNotNull(frameLayout3);
        ViewParent parent = frameLayout3.getParent().getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup.getForeground() != null) {
            viewGroup.setForeground(null);
            ViewParent parent2 = viewGroup.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            int childCount = ((ViewGroup) parent2).getChildCount() - 1;
            ViewParent parent3 = viewGroup.getParent();
            Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent3).removeViewAt(childCount);
        }
    }

    private final void inflateBottomNavigationView(NavigationBarView.OnItemSelectedListener listener) {
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        if (bottomNavigationView != null && listener != null) {
            Intrinsics.checkNotNull(bottomNavigationView);
            bottomNavigationView.setOnItemSelectedListener(listener);
            return;
        }
        MainLogger.m7258i(getTag(), "inflateBottomNavigationView()");
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) ViewModeUtils.getInflatedView(this.fragment.getActivity(), C8003R.id.bottom_navigation, C8003R.id.inflate_bottom_navigation);
        this.mBottomNaviView = bottomNavigationView2;
        if (bottomNavigationView2 == null) {
            return;
        }
        Intrinsics.checkNotNull(bottomNavigationView2);
        BottomNavigationView bottomNavigationView3 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView3);
        bottomNavigationView2.setItemIconTintList(ColorStateList.valueOf(bottomNavigationView3.getResources().getColor(C8003R.color.menu_ic_color, null)));
        if (DeviceInfo.isVSTModel()) {
            BottomNavigationView bottomNavigationView4 = this.mBottomNaviView;
            Intrinsics.checkNotNull(bottomNavigationView4);
            BottomNavigationView bottomNavigationView5 = this.mBottomNaviView;
            Intrinsics.checkNotNull(bottomNavigationView5);
            bottomNavigationView4.setBackgroundColor(bottomNavigationView5.getContext().getColor(C8003R.color.notes_navigation_bar_color_vst));
        }
        if (listener != null) {
            BottomNavigationView bottomNavigationView6 = this.mBottomNaviView;
            Intrinsics.checkNotNull(bottomNavigationView6);
            bottomNavigationView6.setOnItemSelectedListener(listener);
        }
    }

    private final void playInOutAnimation(int visibility, FloatingBottomLayout floatingBottomLayout) {
        AbstractC8014b.m7200b(floatingBottomLayout.getVisibility(), visibility, "before : ", ", after : ", TAG);
        if (visibility == floatingBottomLayout.getVisibility()) {
            return;
        }
        boolean z = visibility == 0;
        floatingBottomLayout.setAlpha(z ? 0.0f : 1.0f);
        if (z) {
            floatingBottomLayout.setVisibility(0);
            floatingBottomLayout.setLayoutVisibility(true, true, true);
            return;
        }
        Context context = this.fragment.getContext();
        if (context == null || this.mIsHidingBottomLayout) {
            floatingBottomLayout.setLayoutVisibility(false, false, true);
            this.mIsHidingBottomLayout = false;
            return;
        }
        this.mIsHidingBottomLayout = true;
        floatingBottomLayout.setLayoutVisibility(false, true, true);
        Looper mainLooper = context.getMainLooper();
        if (mainLooper != null) {
            new Handler(mainLooper).postDelayed(new RunnableC4199v(floatingBottomLayout, this, 24), 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playInOutAnimation$lambda$3$lambda$2(FloatingBottomLayout floatingBottomLayout, BottomMenuController bottomMenuController) {
        floatingBottomLayout.setVisibility(8);
        bottomMenuController.mIsHidingBottomLayout = false;
    }

    @SuppressLint({"UseKtx"})
    private final void showBottomProgressCircle(int bottomProgressCircleId) {
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView);
        if (bottomNavigationView.getVisibility() != 0) {
            return;
        }
        BottomProgressCircleManager bottomProgressCircleManager = BottomProgressCircleManager.getInstance();
        BottomNavigationView bottomNavigationView2 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView2);
        bottomProgressCircleManager.show((NavigationBarItemView) bottomNavigationView2.findViewById(bottomProgressCircleId));
        BottomNavigationView bottomNavigationView3 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView3);
        View viewFindViewById = bottomNavigationView3.findViewById(C8003R.id.bottom_overflow);
        if (viewFindViewById != null && viewFindViewById.getVisibility() == 0) {
            viewFindViewById.setEnabled(bottomProgressCircleId == 0);
        }
        BottomNavigationView bottomNavigationView4 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView4);
        Menu menu = bottomNavigationView4.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            BottomNavigationView bottomNavigationView5 = this.mBottomNaviView;
            Intrinsics.checkNotNull(bottomNavigationView5);
            Menu menu2 = bottomNavigationView5.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu2, "getMenu(...)");
            MenuItem item = menu2.getItem(i);
            if (item.isVisible() && item.getItemId() != bottomProgressCircleId) {
                item.setEnabled(bottomProgressCircleId == 0);
            }
        }
    }

    private final void showProgressCircle() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (this.mMainBlockView == null) {
            this.mMainBlockView = (FrameLayout) activity.findViewById(C8003R.id.main_view_block);
        }
        FrameLayout frameLayout = this.mMainBlockView;
        if (frameLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        if (frameLayout.findViewById(C8003R.id.progress_bar) == null) {
            PostLaunchManager.INSTANCE.getInstance().removeLogic(this.fragment.getPostLaunchToken(), 103);
            FrameLayout frameLayout2 = this.mMainBlockView;
            Intrinsics.checkNotNull(frameLayout2);
            LayoutInflater.from(frameLayout2.getContext()).inflate(C8003R.layout.notes_progress_circle, (ViewGroup) this.mMainBlockView, true);
        }
        FrameLayout frameLayout3 = this.mMainBlockView;
        Intrinsics.checkNotNull(frameLayout3);
        frameLayout3.setVisibility(0);
    }

    private final void showProgressDim(View imageView, int imageSize) {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity == null) {
            return;
        }
        if (this.mMainBlockView == null) {
            this.mMainBlockView = (FrameLayout) activity.findViewById(C8003R.id.main_view_block);
        }
        FrameLayout frameLayout = this.mMainBlockView;
        if (frameLayout == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        ViewParent parent = frameLayout.getParent().getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.setForeground(new ColorDrawable(imageView.getResources().getColor(C8003R.color.note_drag_n_drop_dim_background, null)));
        ViewParent parent2 = viewGroup.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent2).addView(imageView, imageSize, imageSize);
    }

    public final void addBlurForTabLayout(@Nullable TabLayout tabLayout) {
        FloatingBottomLayout floatingBottomLayout = this.mFloatingBottomLayout;
        if (floatingBottomLayout == null || tabLayout == null) {
            return;
        }
        tabLayout.post(new RunnableC4199v(floatingBottomLayout, tabLayout, 23));
    }

    public final void checkProgressCircle() {
        if (this.mBottomNaviView == null) {
            return;
        }
        AbstractC8014b.m7201c(this.mBottomProgressCircleId, "checkProgressCircle# BottomProgressCircleId : ", getTag());
        int i = this.mBottomProgressCircleId;
        if (i == 100) {
            showProgressCircle();
            return;
        }
        if (i == 200) {
            MainLogger.m7258i(getTag(), "Drag and Drop Status#");
        } else if (i != 0) {
            showBottomProgressCircle(i);
        } else {
            dismissProgressCircle();
            BottomProgressCircleManager.getInstance().dismiss();
        }
    }

    public final void enableScrollTransitionOfFloating(boolean enable) {
        FloatingBottomLayout floatingBottomLayout = this.mFloatingBottomLayout;
        if (floatingBottomLayout != null) {
            floatingBottomLayout.enableScrollTransition(enable, true);
        }
    }

    @Nullable
    public final Menu getBottomNavigationMenu() {
        if (this.mBottomNaviView == null) {
            inflateBottomNavigationView(null);
        }
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        if (bottomNavigationView == null) {
            return null;
        }
        Intrinsics.checkNotNull(bottomNavigationView);
        return bottomNavigationView.getMenu();
    }

    @Nullable
    /* JADX INFO: renamed from: getFloatingBottomLayout, reason: from getter */
    public final FloatingBottomLayout getMFloatingBottomLayout() {
        return this.mFloatingBottomLayout;
    }

    public final int getFloatingBottomVisibility() {
        FloatingBottomLayout floatingBottomLayout = this.mFloatingBottomLayout;
        if (floatingBottomLayout != null) {
            return floatingBottomLayout.getVisibility();
        }
        return 8;
    }

    public final int getIconMenuCount() {
        return this.iconMenuCount;
    }

    @NotNull
    public final String getTag() {
        return TAG;
    }

    public final void inflateBottomNavigationMenu(int resId, @Nullable NavigationBarView.OnItemSelectedListener listener) {
        inflateBottomNavigationMenu(resId, BottomNaviType.Normal, listener);
    }

    public final void playItemChangeAnimation(boolean isFadeIn, @Nullable final AnimationEndListener listener) {
        float f = isFadeIn ? 0.0f : 1.0f;
        final float f4 = isFadeIn ? 1.0f : 0.0f;
        ObjectAnimator objectAnimator = this.mNaviViewAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        if (bottomNavigationView != null) {
            bottomNavigationView.setAlpha(f);
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mBottomNaviView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, f, f4));
        this.mNaviViewAnimator = objectAnimatorOfPropertyValuesHolder;
        if (isFadeIn && objectAnimatorOfPropertyValuesHolder != null) {
            objectAnimatorOfPropertyValuesHolder.setStartDelay(50L);
        }
        ObjectAnimator objectAnimator2 = this.mNaviViewAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.setDuration(isFadeIn ? 150L : 100L);
        }
        ObjectAnimator objectAnimator3 = this.mNaviViewAnimator;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.BottomMenuController.playItemChangeAnimation.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BottomNavigationView bottomNavigationView2 = BottomMenuController.this.mBottomNaviView;
                    if (bottomNavigationView2 != null) {
                        bottomNavigationView2.setAlpha(1.0f);
                    }
                    AnimationEndListener animationEndListener = listener;
                    if (animationEndListener != null) {
                        animationEndListener.onAnimationEnd(true);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    BottomNavigationView bottomNavigationView2 = BottomMenuController.this.mBottomNaviView;
                    if (bottomNavigationView2 != null) {
                        bottomNavigationView2.setAlpha(f4);
                    }
                    AnimationEndListener animationEndListener = listener;
                    if (animationEndListener != null) {
                        animationEndListener.onAnimationEnd(false);
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
        ObjectAnimator objectAnimator4 = this.mNaviViewAnimator;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
    }

    public final void setFloatingBottomVisibilityForSearch(final boolean isVisible) {
        AbstractC8014b.m7210l("setFloatingBottomVisibilityForSearch# ", TAG, isVisible);
        int i = isVisible ? 0 : 8;
        FloatingBottomLayout floatingBottomLayout = this.mFloatingBottomLayout;
        if (floatingBottomLayout != null) {
            floatingBottomLayout.setFloatingAware(new FloatingAware() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.BottomMenuController.setFloatingBottomVisibilityForSearch.1
                @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
                public View getReferenceView(FloatingAware.PositionType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (isVisible || type != FloatingAware.PositionType.START_FIRST) {
                        return null;
                    }
                    return this.mBottomNaviView;
                }
            });
        }
        FloatingBottomLayout floatingBottomLayout2 = this.mFloatingBottomLayout;
        if (floatingBottomLayout2 != null) {
            floatingBottomLayout2.setLayoutVisibility(isVisible, false, true);
        }
        FloatingBottomLayout floatingBottomLayout3 = this.mFloatingBottomLayout;
        if (floatingBottomLayout3 != null) {
            floatingBottomLayout3.setVisibility(i);
        }
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(8 - i);
        }
    }

    public final void setIconMenuCount(int i) {
        this.iconMenuCount = i;
    }

    public final void setProgressCircleId(int viewById) {
        this.mBottomProgressCircleId = viewById;
    }

    public final void showBottomNavigation(boolean show) {
        FloatingBottomLayout floatingBottomLayout;
        if (show) {
            inflateBottomNavigationView(null);
        } else {
            BottomProgressCircleManager.getInstance().dismiss();
        }
        if (this.mBottomNaviView == null || (floatingBottomLayout = this.mFloatingBottomLayout) == null) {
            return;
        }
        int i = show ? 0 : 8;
        Intrinsics.checkNotNull(floatingBottomLayout);
        playInOutAnimation(i, floatingBottomLayout);
    }

    public final void showDragAndDropImage(int viewById, @NotNull View imageView, int imageSize) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.mBottomProgressCircleId = viewById;
        showProgressDim(imageView, imageSize);
    }

    public final void inflateBottomNavigationMenu(int resId, @Nullable BottomNaviType bottomNaviType, @Nullable NavigationBarView.OnItemSelectedListener listener) {
        inflateBottomNavigationView(listener);
        BottomNavigationView bottomNavigationView = this.mBottomNaviView;
        if (bottomNavigationView == null) {
            return;
        }
        if (bottomNaviType == BottomNaviType.IconOnly) {
            Intrinsics.checkNotNull(bottomNavigationView);
            bottomNavigationView.seslSetViewType(2);
        } else if (bottomNaviType == BottomNaviType.TextOnly) {
            Intrinsics.checkNotNull(bottomNavigationView);
            bottomNavigationView.seslSetViewType(3);
        } else {
            Intrinsics.checkNotNull(bottomNavigationView);
            bottomNavigationView.seslSetViewType(1);
        }
        BottomNavigationView bottomNavigationView2 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView2);
        bottomNavigationView2.getMenu().clear();
        BottomNavigationView bottomNavigationView3 = this.mBottomNaviView;
        Intrinsics.checkNotNull(bottomNavigationView3);
        bottomNavigationView3.inflateMenu(resId);
    }
}
