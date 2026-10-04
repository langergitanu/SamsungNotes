package com.google.android.material.oneui.floatingactioncontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.core.widget.SeslScrollable;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\f\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0014J0\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\bH\u0014J\u0015\u0010%\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000fH\u0007R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customGoToTopOffset", "", "Ljava/lang/Integer;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "useOffsetAvailRect", "", "applyScrollableViewOptions", "", "calculateGoToTopOffset", "visibility", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBottomBar", "Landroid/view/View;", "onAppBarOffsetChanged", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onVisibilityChanged", "changedView", "setCustomGoToTopOffset", TypedValues.Cycle.S_WAVE_OFFSET, "(Ljava/lang/Integer;)V", "testUseRecyclerViewAvailRectControl", "use", "FloatingBottomBarBehavior", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class FloatingBottomLayout extends FloatingGroupLayout {

    @Nullable
    private Integer customGoToTopOffset;
    private boolean useOffsetAvailRect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout$FloatingBottomBarBehavior;", "T", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingBottomLayout;", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingGroupLayout$FloatingActionBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class FloatingBottomBarBehavior<T extends FloatingBottomLayout> extends FloatingGroupLayout.FloatingActionBehavior<T> {
        public /* synthetic */ FloatingBottomBarBehavior(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i & 2) != 0 ? null : attributeSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatingBottomBarBehavior(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    public /* synthetic */ FloatingBottomLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final int calculateGoToTopOffset(int visibility) {
        SeslScrollable floatingScrollable = getFloatingScrollableManager$material_release().getView();
        int iSeslGetGoToTopDefaultBottomPadding = floatingScrollable != null ? floatingScrollable.seslGetGoToTopDefaultBottomPadding() : 0;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_bottom_layout_top_bottom_padding_for_go_to_top);
        Integer num = this.customGoToTopOffset;
        Integer numValueOf = num != null ? Integer.valueOf(num.intValue() - iSeslGetGoToTopDefaultBottomPadding) : null;
        int measuredHeight = (dimensionPixelSize * 2) + (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - iSeslGetGoToTopDefaultBottomPadding);
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        if (visibility == 0) {
            return measuredHeight;
        }
        return 0;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void applyScrollableViewOptions() {
        super.applyScrollableViewOptions();
        getFloatingScrollableManager$material_release().setBottomBarAnimOffset(calculateGoToTopOffset(getVisibility()));
        if (getFloatingScrollableManager$material_release().getView() != null) {
            getFloatingScrollableManager$material_release().applyAvailBound(-1, getMeasuredHeight(), -1);
            getFloatingScrollableManager$material_release().setFloatingBottomLayoutHeight(getVisibility() == 0 ? (getHeight() - getPaddingBottom()) + getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_bottom_layout_top_bottom_padding_for_go_to_top) : 0);
        }
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<?> getBehavior() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FloatingBottomBarBehavior(context, getAttrs());
    }

    @NotNull
    public final View getBottomBar() {
        View childAt = getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        return childAt;
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return "FloatingBottomLayout";
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout
    public void onAppBarOffsetChanged(@NotNull AppBarLayout appBarLayout, int verticalOffset) {
        Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
        super.onAppBarOffsetChanged(appBarLayout, verticalOffset);
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getFloatingScrollableManager$material_release().applyAvailBound(-1, 0, -1);
        getFloatingScrollableManager$material_release().setFloatingBottomLayoutHeight(0);
        super.onDetachedFromWindow();
    }

    @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingGroupLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        applyScrollableViewOptions();
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (Intrinsics.areEqual(changedView, this)) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(C4548R.dimen.sesl_floating_bottom_layout_top_bottom_padding_for_go_to_top);
            getFloatingScrollableManager$material_release().setBottomBarAnimOffset(calculateGoToTopOffset(visibility));
            getFloatingScrollableManager$material_release().setFloatingBottomLayoutHeight(visibility == 0 ? (getHeight() - getPaddingBottom()) + dimensionPixelSize : 0);
        }
    }

    public final void setCustomGoToTopOffset(@Nullable Integer offset) {
        this.customGoToTopOffset = offset;
        getFloatingScrollableManager$material_release().setBottomBarAnimOffset(calculateGoToTopOffset(getVisibility()));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final void testUseRecyclerViewAvailRectControl(boolean use) {
        LogTagHelperKt.warn(this, "Changed control recyclerview avail rect option " + use);
        this.useOffsetAvailRect = use;
        if (use) {
            applyScrollableViewOptions();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.useOffsetAvailRect = true;
    }
}
