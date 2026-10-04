package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.IBasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageItemView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListRecyclerView extends BasePenRecyclerView {
    private static final int LONG_PRESS_RANGE_THRESHOLD = 50;
    private boolean mIsCtrlKeyPressed;
    private boolean mIsDraggingMultiSelectionByMouse;
    private boolean mIsShiftKeyPressed;
    private View mMouseDragView;
    private PageListRecyclerViewModel mPageListRecyclerViewModel;
    private float mStartX;
    private float mStartY;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageListRecyclerViewModel extends BasePenRecyclerViewModel {
        public PageListRecyclerViewModel(IBasePenRecyclerView iBasePenRecyclerView) {
            super(iBasePenRecyclerView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getCustomViewRect(View view) {
            return new Rect(getCustomViewLeft(view), view.getTop(), getCustomViewRight(view), getCustomViewBottom(view));
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel
        public int getCustomViewBottom(@NonNull View view) {
            if (!(view instanceof ViewGroup)) {
                return super.getCustomViewRight(view);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            return viewGroup.findViewById(C9086R.id.pages_item_thumbnail_container_cover).getBottom() + view.getTop();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel
        public int getCustomViewLeft(@NonNull View view) {
            if (!(view instanceof ViewGroup)) {
                return super.getCustomViewLeft(view);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            return viewGroup.getChildAt(0).getLeft() + view.getLeft();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel
        public int getCustomViewRight(@NonNull View view) {
            if (!(view instanceof ViewGroup)) {
                return super.getCustomViewRight(view);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            return viewGroup.getChildAt(0).getRight() + view.getLeft();
        }
    }

    public PageListRecyclerView(Context context) {
        super(context);
    }

    private boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean isMouseRightEvent(MotionEvent motionEvent) {
        return (motionEvent.getButtonState() & 2) != 0;
    }

    private boolean isOverThumbnail(ViewGroup viewGroup, int i, int i2) {
        return this.mPageListRecyclerViewModel.getCustomViewRect(viewGroup).contains(i, i2);
    }

    private void startDragMultiSelectionByMouse() {
        this.mIsDraggingMultiSelectionByMouse = true;
        super.seslSetCtrlkeyPressed(true);
        startDragMouseMultiSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView
    public BasePenRecyclerViewModel createViewModel() {
        PageListRecyclerViewModel pageListRecyclerViewModel = new PageListRecyclerViewModel(this);
        this.mPageListRecyclerViewModel = pageListRecyclerViewModel;
        return pageListRecyclerViewModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && isMouseEvent(motionEvent)) {
            if (!isMouseRightEvent(motionEvent)) {
                this.mStartX = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.mStartY = y2;
                View viewFindChildViewUnder = findChildViewUnder(this.mStartX, y2);
                if (viewFindChildViewUnder == null || !isOverThumbnail((ViewGroup) viewFindChildViewUnder, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    startDragMultiSelectionByMouse();
                } else if (!this.mIsCtrlKeyPressed && !this.mIsShiftKeyPressed) {
                    this.mMouseDragView = viewFindChildViewUnder;
                }
            }
        } else if (motionEvent.getAction() == 2 && isMouseEvent(motionEvent)) {
            if (!this.mIsDraggingMultiSelectionByMouse && this.mMouseDragView != null && (Math.abs(this.mStartX - motionEvent.getX()) > 50.0f || Math.abs(this.mStartY - motionEvent.getX()) > 50.0f)) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(((PageItemView) this.mMouseDragView).getIndex());
                if (viewHolderFindViewHolderForAdapterPosition instanceof PageHolder) {
                    PageHolder pageHolder = (PageHolder) viewHolderFindViewHolderForAdapterPosition;
                    if (pageHolder.canDrag()) {
                        pageHolder.readyDrag();
                        pageHolder.startDrag();
                    }
                }
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mMouseDragView = null;
            if (!this.mIsCtrlKeyPressed) {
                this.mIsDraggingMultiSelectionByMouse = false;
                super.seslSetCtrlkeyPressed(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !isMouseEvent(motionEvent) || !isMouseRightEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        showContextMenu(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void seslSetCtrlkeyPressed(boolean z) {
        this.mIsCtrlKeyPressed = z;
        super.seslSetCtrlkeyPressed(z);
    }

    public void setShiftKeyPressed(boolean z) {
        this.mIsShiftKeyPressed = z;
    }

    public PageListRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PageListRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
