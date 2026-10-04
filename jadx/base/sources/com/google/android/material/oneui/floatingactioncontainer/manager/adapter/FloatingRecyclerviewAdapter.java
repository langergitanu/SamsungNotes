package com.google.android.material.oneui.floatingactioncontainer.manager.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.common.internal.MaterialLogTag;
import com.google.android.material.oneui.floatingactioncontainer.manager.SeslScrollableListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0011\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J \u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000b¨\u0006("}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingRecyclerviewAdapter;", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "availRectBottom", "", "getAvailRectBottom", "()I", "setAvailRectBottom", "(I)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "onRecyclerViewScrollListener", "com/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingRecyclerviewAdapter$onRecyclerViewScrollListener$1", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingRecyclerviewAdapter$onRecyclerViewScrollListener$1;", "scrollableListener", "", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/SeslScrollableListener;", "getScrollableListener", "()Ljava/util/List;", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "windowInsetBottom", "getWindowInsetBottom", "setWindowInsetBottom", "addSeslScrollableListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dispose", "getFloatingScrollable", "isInScreen", "", "availHeight", "appbarOffset", "appbarRange", "removeSeslScrollableListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FloatingRecyclerviewAdapter implements FloatingScrollableAdapter, MaterialLogTag {
    private int availRectBottom;

    @NotNull
    private final FloatingRecyclerviewAdapter$onRecyclerViewScrollListener$1 onRecyclerViewScrollListener;

    @NotNull
    private final List<SeslScrollableListener> scrollableListener;

    @NotNull
    private final RecyclerView view;
    private int windowInsetBottom;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingRecyclerviewAdapter$onRecyclerViewScrollListener$1] */
    public FloatingRecyclerviewAdapter(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.scrollableListener = new ArrayList();
        ?? r02 = new RecyclerView.OnScrollListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingRecyclerviewAdapter$onRecyclerViewScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                Iterator<T> it = this.this$0.getScrollableListener().iterator();
                while (it.hasNext()) {
                    ((SeslScrollableListener) it.next()).onScrolled(recyclerView, dx, dy);
                }
            }
        };
        this.onRecyclerViewScrollListener = r02;
        LogTagHelperKt.debug(this, "init " + this + ", view=" + view);
        view.addOnScrollListener(r02);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void addSeslScrollableListener(@NotNull SeslScrollableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.scrollableListener.add(listener);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void dispose() {
        LogTagHelperKt.debug(this, "dispose " + this);
        this.scrollableListener.clear();
        this.view.removeOnScrollListener(this.onRecyclerViewScrollListener);
    }

    public final int getAvailRectBottom() {
        return this.availRectBottom;
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "FloatingRecyclerviewAdapter";
    }

    @NotNull
    public final List<SeslScrollableListener> getScrollableListener() {
        return this.scrollableListener;
    }

    @NotNull
    public final RecyclerView getView() {
        return this.view;
    }

    public final int getWindowInsetBottom() {
        return this.windowInsetBottom;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public boolean isInScreen(int availHeight, int appbarOffset, int appbarRange) {
        int childCount = this.view.getChildCount();
        if (childCount <= 0) {
            return true;
        }
        if (this.view.getHeight() < availHeight) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = this.view.getLayoutManager();
        View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(childCount - 1) : null;
        if (viewFindViewByPosition == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager2 = this.view.getLayoutManager();
        boolean zIsViewPartiallyVisible = layoutManager2 != null ? layoutManager2.isViewPartiallyVisible(viewFindViewByPosition, true, true) : false;
        RecyclerView.LayoutManager layoutManager3 = this.view.getLayoutManager();
        boolean z = (layoutManager3 != null ? layoutManager3.getHeight() : -1) == 0;
        Rect rectSeslGetAvailableBounds = this.view.seslGetAvailableBounds();
        int i = rectSeslGetAvailableBounds != null ? rectSeslGetAvailableBounds.bottom : 0;
        if (isEmptyView(viewFindViewByPosition)) {
            if ((zIsViewPartiallyVisible || z) && viewFindViewByPosition.getTop() <= i + appbarRange) {
                return true;
            }
        } else if ((zIsViewPartiallyVisible || z) && viewFindViewByPosition.getBottom() <= i + appbarRange) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void removeSeslScrollableListener(@NotNull SeslScrollableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.scrollableListener.remove(listener);
    }

    public final void setAvailRectBottom(int i) {
        this.availRectBottom = i;
    }

    public final void setWindowInsetBottom(int i) {
        this.windowInsetBottom = i;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    @NotNull
    /* JADX INFO: renamed from: getFloatingScrollable, reason: from getter */
    public RecyclerView getView() {
        return this.view;
    }
}
