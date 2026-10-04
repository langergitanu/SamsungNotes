package com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0014J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010&\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0010J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0010H\u0016J\r\u00102\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u00103R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/IBasePenRecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewModel", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/BasePenRecyclerViewModel;", "mIsScrollEnabled", "", "mIsHoverEnabled", "init", "", "createViewModel", "startDragMouseMultiSelection", "cancelDragMouseMultiSelection", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEventInternal", "getBOutOfChildren", "isMultiSelectingText", "()Z", "onScrollStateChanged", "state", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "setOnPenMultiSelectionListener", "l", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/OnPenMultiSelectionListener;", "setOnMouseMultiSelectionListener", "Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/OnMouseMultiSelectionListener;", "enableScroll", "isScrollEnabled", "enableHover", "enabled", "onInterceptTouchEvent", "onInterceptHoverEvent", "getGapStrategy", "setGapStrategy", "gapStrategy", "seslSetPenSelectionEnabled", "isPenMultiSelectionEnabled", "()Ljava/lang/Boolean;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BasePenRecyclerView extends RecyclerView implements IBasePenRecyclerView {

    @NotNull
    private static final String TAG = "BaseRecyclerView";
    private boolean mIsHoverEnabled;
    private boolean mIsScrollEnabled;

    @Nullable
    private BasePenRecyclerViewModel mViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePenRecyclerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsScrollEnabled = true;
        this.mIsHoverEnabled = true;
        init();
    }

    private final boolean dispatchTouchEventInternal(MotionEvent ev) {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.processTouchEvent(getContext(), ev, getBOutOfChildren(ev));
        }
        return super.dispatchTouchEvent(ev);
    }

    private final void init() {
        this.mViewModel = createViewModel();
        setFocusableInTouchMode(false);
    }

    public final void cancelDragMouseMultiSelection() {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.cancelDragMouseMultiSelection();
        }
    }

    @Nullable
    public BasePenRecyclerViewModel createViewModel() {
        return new BasePenRecyclerViewModel(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            int keyCode = event.getKeyCode();
            if (keyCode == 92) {
                scrollBy(0, -getHeight());
                View childAt = getChildAt(0);
                if (childAt != null) {
                    childAt.requestFocus();
                }
                return true;
            }
            if (keyCode == 93) {
                scrollBy(0, getHeight());
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 != null) {
                    childAt2.requestFocus();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return dispatchTouchEventInternal(ev);
    }

    public final void enableHover(boolean enabled) {
        this.mIsHoverEnabled = enabled;
    }

    public final void enableScroll(boolean isScrollEnabled) {
        this.mIsScrollEnabled = isScrollEnabled;
    }

    public final boolean getBOutOfChildren(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int y2 = getChildCount() > 0 ? (int) getChildAt(0).getY() : 0;
        if (y2 == 0) {
            y2 = 0;
        }
        return ev.getY() <= ((float) y2);
    }

    public int getGapStrategy() {
        return 0;
    }

    public final boolean isMultiSelectingText() {
        return MultiSelection.INSTANCE.getIsMultiSelectingText();
    }

    @Nullable
    public final Boolean isPenMultiSelectionEnabled() {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            return Boolean.valueOf(basePenRecyclerViewModel.getMIsPenMultiSelectionEnabled());
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mIsHoverEnabled) {
            return super.onInterceptHoverEvent(event);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.mIsScrollEnabled) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == 0) {
            this.mIsHoverEnabled = true;
        } else if (state == 1) {
            this.mIsHoverEnabled = false;
        } else {
            if (state != 2) {
                return;
            }
            this.mIsHoverEnabled = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void seslSetPenSelectionEnabled(boolean enabled) {
        super.seslSetPenSelectionEnabled(enabled);
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.setPenMultiSelectionEnabled(enabled);
        }
    }

    public void setGapStrategy(int gapStrategy) {
    }

    public final void setOnMouseMultiSelectionListener(@Nullable OnMouseMultiSelectionListener l) {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.setOnMouseMultiSelectionListener(l);
        }
    }

    public final void setOnPenMultiSelectionListener(@Nullable OnPenMultiSelectionListener l) {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.setOnPenMultiSelectionListener(l);
        }
    }

    public final void startDragMouseMultiSelection() {
        BasePenRecyclerViewModel basePenRecyclerViewModel = this.mViewModel;
        if (basePenRecyclerViewModel != null) {
            basePenRecyclerViewModel.startDragMouseMultiSelection();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePenRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsScrollEnabled = true;
        this.mIsHoverEnabled = true;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePenRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsScrollEnabled = true;
        this.mIsHoverEnabled = true;
        init();
    }
}
