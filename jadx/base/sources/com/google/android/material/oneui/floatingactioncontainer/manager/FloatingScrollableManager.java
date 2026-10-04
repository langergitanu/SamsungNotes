package com.google.android.material.oneui.floatingactioncontainer.manager;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.SeslScrollable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.common.internal.MaterialLogTag;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingNestedScrollViewAdapter;
import com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingRecyclerviewAdapter;
import com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0001\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0096\u0001J\u001e\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020%J\t\u0010-\u001a\u00020%H\u0096\u0001J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0006J\u000b\u00100\u001a\u0004\u0018\u000101H\u0096\u0001J\b\u00102\u001a\u0004\u0018\u000103J\u0006\u00104\u001a\u00020%J\u0011\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u000203H\u0096\u0001J#\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00109\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010:\u001a\u00020\u00162\u0006\u00106\u001a\u000201H\u0096\u0001J\u0011\u0010;\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0096\u0001J\u0018\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0002J\u000e\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0006J\u000e\u0010C\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0006J\u000e\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u000201J\u000e\u0010F\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0006J\u0016\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\b\u0010I\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006L"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager;", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "floatingSupportableAdapter", "(Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;)V", "appbarOffset", "", "availRectBottom", "availRectBottomOffset", "availRectTop", "bottomBarAnimOffset", "bottomLayoutHeight", "collapsedAppbarHeight", "getFloatingSupportableAdapter", "()Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "setFloatingSupportableAdapter", "floatingToolbarLayoutHeight", "logTag", "", "getLogTag", "()Ljava/lang/String;", "manageFadingEdgeBottomOffset", "", "getManageFadingEdgeBottomOffset", "()Z", "setManageFadingEdgeBottomOffset", "(Z)V", "manageGoToTopOffset", "getManageGoToTopOffset", "setManageGoToTopOffset", "value", "windowInsetBottom", "getWindowInsetBottom", "()I", "setWindowInsetBottom", "(I)V", "addSeslScrollableListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/material/oneui/floatingactioncontainer/manager/SeslScrollableListener;", "applyAvailBound", "topSize", "bottomSize", "bottomOffset", "applyLastAvailBoundToFloatingScrollable", "dispose", "forceTopFadingEdgeClamped", "height", "getFloatingScrollable", "Landroidx/core/widget/SeslScrollable;", "getFloatingScrollableView", "Landroid/view/View;", "invalidateScrollableView", "isEmptyView", "view", "isInScreen", "availHeight", "appbarRange", "isValidCondition", "removeSeslScrollableListener", "saveLastAvailRectInfo", "top", "bottom", "setAppBarOffset", TypedValues.Cycle.S_WAVE_OFFSET, "setBottomBarAnimOffset", "setFadingEdgeBottomOffset", "setFloatingBottomLayoutHeight", "setFloatingScrollableView", "floatingScrollableView", "setFloatingToolbarLayoutHeight", "setScrollBarTopOffset", "collapsedHeight", "updateGoToTopOffset", "updateScrollBarBottomOffset", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FloatingScrollableManager implements FloatingScrollableAdapter, MaterialLogTag {

    @Nullable
    private static Rect lastAvailBounds;
    private final /* synthetic */ FloatingScrollableAdapter $$delegate_0;
    private int appbarOffset;
    private int availRectBottom;
    private int availRectBottomOffset;
    private int availRectTop;
    private int bottomBarAnimOffset;
    private int bottomLayoutHeight;
    private int collapsedAppbarHeight;

    @NotNull
    private FloatingScrollableAdapter floatingSupportableAdapter;
    private int floatingToolbarLayoutHeight;
    private boolean manageFadingEdgeBottomOffset;
    private boolean manageGoToTopOffset;
    private int windowInsetBottom;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final WeakHashMap<SeslScrollable, FloatingScrollableManager> instanceCollection = new WeakHashMap<>();

    @NotNull
    private static final WeakHashMap<FloatingGroupLayout, SeslScrollable> clientLayout = new WeakHashMap<>();

    @NotNull
    private static final FloatingScrollableManager instance = new FloatingScrollableManager(new FloatingScrollableAdapter() { // from class: com.google.android.material.oneui.floatingactioncontainer.manager.FloatingScrollableManager$Companion$instance$1
        @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
        public void addSeslScrollableListener(SeslScrollableListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
        public void removeSeslScrollableListener(SeslScrollableListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
        public void dispose() {
        }
    });

    @NotNull
    private static final Object lock = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager$Companion;", "", "()V", "clientLayout", "Ljava/util/WeakHashMap;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "Landroidx/core/widget/SeslScrollable;", "instance", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager;", "instanceCollection", "lastAvailBounds", "Landroid/graphics/Rect;", "lock", "clearAllInstances", "", "clearInstance", "floatingLayout", "scrollableView", "getInstance", "scrollableAdapter", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nFloatingScrollableManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingScrollableManager.kt\ncom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,270:1\n361#2,7:271\n*S KotlinDebug\n*F\n+ 1 FloatingScrollableManager.kt\ncom/google/android/material/oneui/floatingactioncontainer/manager/FloatingScrollableManager$Companion\n*L\n61#1:271,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FloatingScrollableManager getInstance$default(Companion companion, FloatingGroupLayout floatingGroupLayout, SeslScrollable seslScrollable, FloatingScrollableAdapter floatingScrollableAdapter, int i, Object obj) {
            if ((i & 4) != 0) {
                floatingScrollableAdapter = null;
            }
            return companion.getInstance(floatingGroupLayout, seslScrollable, floatingScrollableAdapter);
        }

        public final void clearAllInstances() {
            synchronized (FloatingScrollableManager.lock) {
                FloatingScrollableManager.instanceCollection.clear();
                FloatingScrollableManager.clientLayout.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void clearInstance(@NotNull FloatingGroupLayout floatingLayout, @Nullable SeslScrollable scrollableView) {
            FloatingScrollableManager floatingScrollableManager;
            Intrinsics.checkNotNullParameter(floatingLayout, "floatingLayout");
            synchronized (FloatingScrollableManager.lock) {
                try {
                    FloatingScrollableManager.clientLayout.remove(floatingLayout);
                    if (!FloatingScrollableManager.clientLayout.containsValue(scrollableView) && (floatingScrollableManager = (FloatingScrollableManager) FloatingScrollableManager.instanceCollection.remove(scrollableView)) != null) {
                        floatingScrollableManager.dispose();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @NotNull
        public final FloatingScrollableManager getInstance(@NotNull FloatingGroupLayout floatingLayout, @Nullable SeslScrollable scrollableView, @Nullable FloatingScrollableAdapter scrollableAdapter) {
            FloatingScrollableManager floatingScrollableManager;
            Intrinsics.checkNotNullParameter(floatingLayout, "floatingLayout");
            if (scrollableView == null) {
                return FloatingScrollableManager.instance;
            }
            synchronized (FloatingScrollableManager.lock) {
                try {
                    FloatingScrollableManager.clientLayout.put(floatingLayout, scrollableView);
                    WeakHashMap weakHashMap = FloatingScrollableManager.instanceCollection;
                    Object floatingScrollableManager2 = weakHashMap.get(scrollableView);
                    if (floatingScrollableManager2 == null) {
                        if (scrollableView instanceof RecyclerView) {
                            scrollableAdapter = new FloatingRecyclerviewAdapter((RecyclerView) scrollableView);
                        } else if (scrollableView instanceof NestedScrollView) {
                            scrollableAdapter = new FloatingNestedScrollViewAdapter((NestedScrollView) scrollableView);
                        }
                        floatingScrollableManager2 = scrollableAdapter != null ? new FloatingScrollableManager(scrollableAdapter, null) : FloatingScrollableManager.instance;
                        weakHashMap.put(scrollableView, floatingScrollableManager2);
                    }
                    floatingScrollableManager = (FloatingScrollableManager) floatingScrollableManager2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNullExpressionValue(floatingScrollableManager, "synchronized(lock) {\n   …          }\n            }");
            return floatingScrollableManager;
        }

        private Companion() {
        }

        @NotNull
        public final FloatingScrollableManager getInstance(@NotNull FloatingGroupLayout floatingLayout, @Nullable FloatingScrollableAdapter scrollableAdapter) {
            Intrinsics.checkNotNullParameter(floatingLayout, "floatingLayout");
            if ((scrollableAdapter != null ? scrollableAdapter.getView() : null) == null) {
                Log.w("FloatingScrollManager", "getInstance fail. using default (adapter scrollable is null), scrollableAdapter=" + scrollableAdapter);
                return FloatingScrollableManager.instance;
            }
            return getInstance(floatingLayout, scrollableAdapter.getView(), scrollableAdapter);
        }
    }

    public /* synthetic */ FloatingScrollableManager(FloatingScrollableAdapter floatingScrollableAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(floatingScrollableAdapter);
    }

    private final void saveLastAvailRectInfo(int top, int bottom) {
        lastAvailBounds = new Rect(0, top, 0, bottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateGoToTopOffset() {
        if (!this.manageGoToTopOffset) {
            LogTagHelperKt.debug(this, "updateGoToTopOffset off");
            return;
        }
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != 0) {
            floatingScrollable.seslSetGoToTopBottomPadding(floatingScrollable.seslGetGoToTopDefaultBottomPadding() + this.appbarOffset + this.bottomBarAnimOffset + this.windowInsetBottom);
            View view = floatingScrollable instanceof View ? (View) floatingScrollable : null;
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    private final void updateScrollBarBottomOffset() {
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != null) {
            floatingScrollable.seslSetScrollBarBottomOffset(this.collapsedAppbarHeight + this.bottomLayoutHeight + this.windowInsetBottom);
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void addSeslScrollableListener(@NotNull SeslScrollableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.addSeslScrollableListener(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void applyAvailBound(int topSize, int bottomSize, int bottomOffset) {
        if (topSize == -1) {
            topSize = this.availRectTop;
        }
        this.availRectTop = topSize;
        if (bottomSize == -1) {
            bottomSize = this.availRectBottom;
        }
        this.availRectBottom = bottomSize;
        if (bottomOffset == -1) {
            bottomOffset = this.availRectBottomOffset;
        }
        this.availRectBottomOffset = bottomOffset;
        int i = this.windowInsetBottom + bottomSize + bottomOffset;
        FloatingScrollableAdapter floatingScrollableAdapter = this.floatingSupportableAdapter;
        FloatingRecyclerviewAdapter floatingRecyclerviewAdapter = floatingScrollableAdapter instanceof FloatingRecyclerviewAdapter ? (FloatingRecyclerviewAdapter) floatingScrollableAdapter : null;
        if (floatingRecyclerviewAdapter != null) {
            this.availRectTop = topSize;
            floatingRecyclerviewAdapter.setAvailRectBottom(bottomSize);
        }
        saveLastAvailRectInfo(this.availRectTop, i);
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != 0) {
            View view = floatingScrollable instanceof View ? (View) floatingScrollable : null;
            if (view != null) {
                floatingScrollable.seslSetAvailableBounds(new Rect(0, this.availRectTop, view.getMeasuredWidth(), view.getMeasuredHeight() - i));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void applyLastAvailBoundToFloatingScrollable() {
        SeslScrollable floatingScrollable;
        Rect rect = lastAvailBounds;
        if (rect == null || (floatingScrollable = getView()) == 0) {
            return;
        }
        View view = floatingScrollable instanceof View ? (View) floatingScrollable : null;
        if (view != null) {
            floatingScrollable.seslSetAvailableBounds(new Rect(0, rect.top, view.getMeasuredWidth(), view.getMeasuredHeight() - rect.bottom));
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void dispose() {
        this.$$delegate_0.dispose();
    }

    public final void forceTopFadingEdgeClamped(int height) {
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != null) {
            floatingScrollable.seslForceTopFadingEdgeClamped(height);
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    @Nullable
    /* JADX INFO: renamed from: getFloatingScrollable */
    public SeslScrollable getView() {
        return this.$$delegate_0.getView();
    }

    @Nullable
    public final View getFloatingScrollableView() {
        Object floatingScrollable = getView();
        if (floatingScrollable instanceof View) {
            return (View) floatingScrollable;
        }
        return null;
    }

    @NotNull
    public final FloatingScrollableAdapter getFloatingSupportableAdapter() {
        return this.floatingSupportableAdapter;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "FloatingScrollableManager";
    }

    public final boolean getManageFadingEdgeBottomOffset() {
        return this.manageFadingEdgeBottomOffset;
    }

    public final boolean getManageGoToTopOffset() {
        return this.manageGoToTopOffset;
    }

    public final int getWindowInsetBottom() {
        return this.windowInsetBottom;
    }

    public final void invalidateScrollableView() {
        View floatingScrollableView = getFloatingScrollableView();
        if (floatingScrollableView != null) {
            floatingScrollableView.invalidate();
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public boolean isEmptyView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.$$delegate_0.isEmptyView(view);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public boolean isInScreen(int availHeight, int appbarOffset, int appbarRange) {
        return this.$$delegate_0.isInScreen(availHeight, appbarOffset, appbarRange);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public boolean isValidCondition(@NotNull SeslScrollable view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.$$delegate_0.isValidCondition(view);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void removeSeslScrollableListener(@NotNull SeslScrollableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.$$delegate_0.removeSeslScrollableListener(listener);
    }

    public final void setAppBarOffset(int offset) {
        this.appbarOffset = offset;
        updateGoToTopOffset();
    }

    public final void setBottomBarAnimOffset(int offset) {
        this.bottomBarAnimOffset = offset;
        updateGoToTopOffset();
    }

    public final void setFadingEdgeBottomOffset(int offset) {
        SeslScrollable floatingScrollable;
        if (!this.manageFadingEdgeBottomOffset || (floatingScrollable = getView()) == null) {
            return;
        }
        floatingScrollable.seslSetBottomScrollOffset(offset);
    }

    public final void setFloatingBottomLayoutHeight(int height) {
        if (height == -1) {
            height = this.bottomLayoutHeight;
        }
        this.bottomLayoutHeight = height;
        int i = height + this.windowInsetBottom;
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != null) {
            floatingScrollable.seslSetHoverBottomPadding(i);
            floatingScrollable.seslSetFloatingBottomLayoutHeight(this.bottomLayoutHeight);
        }
        updateScrollBarBottomOffset();
    }

    public final void setFloatingScrollableView(@NotNull SeslScrollable floatingScrollableView) throws Exception {
        Intrinsics.checkNotNullParameter(floatingScrollableView, "floatingScrollableView");
        LogTagHelperKt.debug(this, "setFloatingScrollableView floatingScrollableView=" + floatingScrollableView.hashCode());
        if (Intrinsics.areEqual(this.floatingSupportableAdapter.getView(), floatingScrollableView)) {
            return;
        }
        FloatingScrollableAdapter floatingRecyclerviewAdapter = floatingScrollableView instanceof RecyclerView ? new FloatingRecyclerviewAdapter((RecyclerView) floatingScrollableView) : floatingScrollableView instanceof NestedScrollView ? new FloatingNestedScrollViewAdapter((NestedScrollView) floatingScrollableView) : null;
        if (floatingRecyclerviewAdapter == null) {
            throw new Exception("setFloatingScrollableView type error " + floatingScrollableView);
        }
        LogTagHelperKt.debug(this, "setFloatingScrollableView change Adapter=" + floatingRecyclerviewAdapter);
        this.floatingSupportableAdapter = floatingRecyclerviewAdapter;
    }

    public final void setFloatingSupportableAdapter(@NotNull FloatingScrollableAdapter floatingScrollableAdapter) {
        Intrinsics.checkNotNullParameter(floatingScrollableAdapter, "<set-?>");
        this.floatingSupportableAdapter = floatingScrollableAdapter;
    }

    public final void setFloatingToolbarLayoutHeight(int height) {
        int iMax = Math.max(0, height);
        if (this.floatingToolbarLayoutHeight == iMax) {
            return;
        }
        this.floatingToolbarLayoutHeight = iMax;
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != null) {
            floatingScrollable.seslSetHoverTopPadding(this.floatingToolbarLayoutHeight);
        }
    }

    public final void setManageFadingEdgeBottomOffset(boolean z) {
        this.manageFadingEdgeBottomOffset = z;
    }

    public final void setManageGoToTopOffset(boolean z) {
        this.manageGoToTopOffset = z;
    }

    public final void setScrollBarTopOffset(int collapsedHeight, int offset) {
        this.collapsedAppbarHeight = collapsedHeight;
        SeslScrollable floatingScrollable = getView();
        if (floatingScrollable != null) {
            floatingScrollable.seslSetScrollBarTopOffset(offset);
        }
        updateScrollBarBottomOffset();
    }

    public final void setWindowInsetBottom(int i) {
        this.windowInsetBottom = i;
        setFloatingBottomLayoutHeight(-1);
        updateGoToTopOffset();
        FloatingScrollableAdapter floatingScrollableAdapter = this.floatingSupportableAdapter;
        FloatingRecyclerviewAdapter floatingRecyclerviewAdapter = floatingScrollableAdapter instanceof FloatingRecyclerviewAdapter ? (FloatingRecyclerviewAdapter) floatingScrollableAdapter : null;
        if (floatingRecyclerviewAdapter != null) {
            floatingRecyclerviewAdapter.setWindowInsetBottom(this.windowInsetBottom);
        }
    }

    private FloatingScrollableManager(FloatingScrollableAdapter floatingScrollableAdapter) {
        this.floatingSupportableAdapter = floatingScrollableAdapter;
        this.$$delegate_0 = floatingScrollableAdapter;
        this.manageGoToTopOffset = true;
        this.manageFadingEdgeBottomOffset = true;
    }
}
