package com.google.android.material.oneui.floatingactioncontainer.manager.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.common.internal.MaterialLogTag;
import com.google.android.material.oneui.floatingactioncontainer.manager.SeslScrollableListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingNestedScrollViewAdapter;", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingScrollableAdapter;", "Lcom/google/android/material/oneui/common/internal/MaterialLogTag;", "view", "Landroidx/core/widget/NestedScrollView;", "(Landroidx/core/widget/NestedScrollView;)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "onScrollChangeListener", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "scrollableListener", "", "Lcom/google/android/material/oneui/floatingactioncontainer/manager/SeslScrollableListener;", "getScrollableListener", "()Ljava/util/List;", "getView", "()Landroidx/core/widget/NestedScrollView;", "addSeslScrollableListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dispose", "getFloatingScrollable", "isInScreen", "", "availHeight", "", "appbarOffset", "appbarRange", "removeSeslScrollableListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatingNestedScrollViewAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingNestedScrollViewAdapter.kt\ncom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingNestedScrollViewAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,129:1\n1855#2,2:130\n*S KotlinDebug\n*F\n+ 1 FloatingNestedScrollViewAdapter.kt\ncom/google/android/material/oneui/floatingactioncontainer/manager/adapter/FloatingNestedScrollViewAdapter\n*L\n37#1:130,2\n*E\n"})
public final class FloatingNestedScrollViewAdapter implements FloatingScrollableAdapter, MaterialLogTag {

    @NotNull
    private final NestedScrollView.OnScrollChangeListener onScrollChangeListener;

    @NotNull
    private final List<SeslScrollableListener> scrollableListener;

    @NotNull
    private final NestedScrollView view;

    public FloatingNestedScrollViewAdapter(@NotNull NestedScrollView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.scrollableListener = new ArrayList();
        NestedScrollView.OnScrollChangeListener onScrollChangeListener = new NestedScrollView.OnScrollChangeListener() { // from class: com.google.android.material.oneui.floatingactioncontainer.manager.adapter.a
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i4, int i5) {
                FloatingNestedScrollViewAdapter.onScrollChangeListener$lambda$1(this.f2325a, nestedScrollView, i, i2, i4, i5);
            }
        };
        this.onScrollChangeListener = onScrollChangeListener;
        LogTagHelperKt.debug(this, "init " + this + ", view=" + view);
        view.addOnScrollChangeListener(onScrollChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScrollChangeListener$lambda$1(FloatingNestedScrollViewAdapter this$0, NestedScrollView v, int i, int i2, int i4, int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        int i6 = i2 - i5;
        Iterator<T> it = this$0.scrollableListener.iterator();
        while (it.hasNext()) {
            ((SeslScrollableListener) it.next()).onScrolled(v, 0, i6);
        }
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
        this.view.removeOnScrollChangeListener(this.onScrollChangeListener);
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "FloatingNestedScrollViewAdapter";
    }

    @NotNull
    public final List<SeslScrollableListener> getScrollableListener() {
        return this.scrollableListener;
    }

    @NotNull
    public final NestedScrollView getView() {
        return this.view;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public boolean isInScreen(int availHeight, int appbarOffset, int appbarRange) {
        if (this.view.getChildCount() == 0) {
            return true;
        }
        View childAt = this.view.getChildAt(0);
        if (!(childAt instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) childAt;
        if (viewGroup.getChildCount() < 2) {
            return false;
        }
        int childCount = viewGroup.getChildCount() - 1;
        View childAt2 = null;
        View childAt3 = null;
        while (true) {
            if (-1 >= childCount) {
                childCount = 0;
                break;
            }
            childAt3 = viewGroup.getChildAt(childCount);
            if (childAt3 != null && childAt3.getVisibility() == 0) {
                break;
            }
            childCount--;
        }
        if (childAt3 == null) {
            return false;
        }
        if (isEmptyView(childAt3)) {
            for (int i = childCount - 1; -1 < i; i--) {
                childAt2 = viewGroup.getChildAt(i);
                if (childAt2 != null && childAt2.getVisibility() == 0) {
                    break;
                }
            }
            childAt3 = childAt2;
        }
        if (childAt3 == null) {
            return false;
        }
        if (childAt3.getBottom() <= viewGroup.getTop() + viewGroup.getHeight()) {
            Rect rectSeslGetAvailableBounds = this.view.seslGetAvailableBounds();
            if (viewGroup.getTop() + childAt3.getBottom() <= (rectSeslGetAvailableBounds != null ? rectSeslGetAvailableBounds.bottom : 0) + appbarRange) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    public void removeSeslScrollableListener(@NotNull SeslScrollableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.scrollableListener.remove(listener);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.manager.adapter.FloatingScrollableAdapter
    @NotNull
    /* JADX INFO: renamed from: getFloatingScrollable, reason: from getter */
    public NestedScrollView getView() {
        return this.view;
    }
}
