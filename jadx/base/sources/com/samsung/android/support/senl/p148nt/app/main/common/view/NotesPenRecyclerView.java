package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnDragAndDropListener;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnMouseDragListener;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnShiftMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerViewModel;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesPenRecyclerView extends PenRecyclerView {
    private static int LONG_PRESS_RANGE_THRESHOLD = 0;
    private static final String TAG = "NotesPenRecyclerView";
    private int mHeightPixels;
    private boolean mIsCtrlKeyPressed;
    private boolean mIsDraggingMultiSelectionByMouse;
    private boolean mIsDraggingViewByMouse;
    private boolean mIsNeedChecked;
    private boolean mIsNote;
    private boolean mIsShiftKeyPressed;
    private boolean mIsTabletLayout;
    private String mLastClickedUuid;
    private View mMouseDragView;
    private OnDragAndDropListener mOnDragAndDropListener;
    private OnMouseDragListener mOnMouseDragListener;
    private OnShiftMultiSelectionListener mOnShiftMultiSelectionListener;
    private float mRawX;
    private float mRawY;
    private int mStartPosition;
    private float mStartX;
    private float mStartY;

    public NotesPenRecyclerView(Context context) {
        super(context);
        this.mHeightPixels = 0;
        this.mIsTabletLayout = false;
        this.mIsNeedChecked = false;
        this.mStartPosition = -1;
        this.mLastClickedUuid = null;
        init(context);
    }

    private void init(Context context) {
        seslSetGoToTopEnabled(true);
        this.mIsTabletLayout = NotesUtils.isTabletLayout(context);
        this.mHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        LONG_PRESS_RANGE_THRESHOLD = (int) (getResources().getDisplayMetrics().density * 30.0f);
    }

    private boolean isFirstItemNotCompletelyDisplaying(int i) {
        if (getAdapter().getItemCount() == 0) {
            return true;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        Objects.requireNonNull(layoutManager);
        for (int i2 : ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(null)) {
            if (i2 == i) {
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition true : ");
                return false;
            }
        }
        return true;
    }

    private boolean isLastItemNotCompletelyDisplaying(int i) {
        if (getAdapter().getItemCount() == 0) {
            return true;
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        Objects.requireNonNull(layoutManager);
        for (int i2 : ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(null)) {
            if (i2 == i) {
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition true : ");
                return false;
            }
        }
        return true;
    }

    private boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean isMouseRightEvent(MotionEvent motionEvent) {
        return (motionEvent.getButtonState() & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchKeyEvent$0() {
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        childAt.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollToTop$1() {
        smoothScrollToPosition(0);
    }

    private void startDragMultiSelectionByMouse() {
        this.mIsDraggingMultiSelectionByMouse = true;
        super.seslSetCtrlkeyPressed(true);
        startDragMouseMultiSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView, com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView
    public BasePenRecyclerViewModel createViewModel() {
        PenRecyclerViewModel penRecyclerViewModel = new PenRecyclerViewModel(this);
        ((PenRecyclerView) this).mViewModel = penRecyclerViewModel;
        return penRecyclerViewModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 92) {
                scrollBy(0, -getHeight());
                View childAt = getChildAt(0);
                if (childAt != null) {
                    childAt.requestFocus();
                    return true;
                }
            } else if (keyCode == 93) {
                scrollBy(0, getHeight());
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 != null) {
                    childAt2.requestFocus();
                    return true;
                }
            } else {
                if (keyCode == 122) {
                    scrollToPosition(0, true);
                    post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.NotesPenRecyclerView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View childAt3 = NotesPenRecyclerView.this.getChildAt(0);
                            if (childAt3 == null) {
                                return;
                            }
                            childAt3.requestFocus();
                        }
                    });
                    return true;
                }
                if (keyCode == 123) {
                    scrollToPosition(getAdapter().getItemCount() - 1, true);
                    post(new RunnableC8239e(this, 0));
                    return true;
                }
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        OnShiftMultiSelectionListener onShiftMultiSelectionListener;
        this.mRawX = motionEvent.getRawX();
        this.mRawY = motionEvent.getRawY();
        if (motionEvent.getAction() == 0) {
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            if (!isMouseEvent(motionEvent) || isMouseRightEvent(motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.mStartPosition = -1;
            this.mIsDraggingViewByMouse = false;
            this.mIsDraggingMultiSelectionByMouse = false;
            this.mIsNote = true;
            View viewFindChildViewUnder = findChildViewUnder(this.mStartX, this.mStartY);
            if (viewFindChildViewUnder == null) {
                viewFindChildViewUnder = seslFindNearChildViewUnder(this.mStartX, this.mStartY);
                if (viewFindChildViewUnder == null) {
                    startDragMultiSelectionByMouse();
                    return super.dispatchTouchEvent(motionEvent);
                }
                z = true;
            } else {
                z = false;
            }
            CommonHolder commonHolder = (CommonHolder) findViewHolderForAdapterPosition(getChildAdapterPosition(viewFindChildViewUnder));
            if (commonHolder == null) {
                MainLogger.m7259w(TAG, "Ignore touch event if holder is null. It can be caused by item removed or reordered.");
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.mOnMouseDragListener == null || commonHolder.getMHolderType() > 2048) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (commonHolder.getMHolderType() != 2048) {
                int childAdapterPosition = z ? getChildAdapterPosition(viewFindChildViewUnder) / this.mOnMouseDragListener.getSubFoldersSpan() : getChildAdapterPosition(viewFindChildViewUnder);
                this.mStartPosition = childAdapterPosition;
                this.mStartPosition = (this.mOnMouseDragListener.getSubFoldersSpan() * childAdapterPosition) + ((int) ((motionEvent.getX() / getWidth()) * this.mOnMouseDragListener.getSubFoldersSpan()));
                this.mIsNote = false;
            } else {
                if (z) {
                    startDragMultiSelectionByMouse();
                    return super.dispatchTouchEvent(motionEvent);
                }
                this.mStartPosition = getChildAdapterPosition(viewFindChildViewUnder);
            }
            if (!this.mOnMouseDragListener.isDragAndDropEnabledPosition(this.mStartPosition, this.mIsNote)) {
                startDragMultiSelectionByMouse();
            } else if (!this.mIsCtrlKeyPressed && !this.mIsShiftKeyPressed) {
                this.mMouseDragView = viewFindChildViewUnder;
            } else if (this.mIsShiftKeyPressed && (onShiftMultiSelectionListener = this.mOnShiftMultiSelectionListener) != null) {
                onShiftMultiSelectionListener.onSelcted(this.mLastClickedUuid, this.mStartPosition, this.mIsNote);
                return true;
            }
        } else if (motionEvent.getAction() == 2) {
            if (isMouseEvent(motionEvent) && !this.mIsDraggingMultiSelectionByMouse && this.mMouseDragView != null && this.mStartPosition != -1 && this.mOnMouseDragListener != null && ((Math.abs(this.mStartX - motionEvent.getX()) > LONG_PRESS_RANGE_THRESHOLD || Math.abs(this.mStartY - motionEvent.getX()) > LONG_PRESS_RANGE_THRESHOLD) && !this.mIsDraggingViewByMouse)) {
                this.mIsDraggingViewByMouse = true;
                this.mOnMouseDragListener.startDragAndDrop(this.mStartPosition, this.mIsNote);
            }
            OnDragAndDropListener onDragAndDropListener = this.mOnDragAndDropListener;
            if (onDragAndDropListener != null) {
                onDragAndDropListener.onMoveImage(motionEvent.getX() - this.mStartX, motionEvent.getY() - this.mStartY);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.mMouseDragView = null;
            OnDragAndDropListener onDragAndDropListener2 = this.mOnDragAndDropListener;
            if (onDragAndDropListener2 != null) {
                onDragAndDropListener2.onReleaseListener();
            }
            if (!this.mIsCtrlKeyPressed) {
                this.mIsDraggingMultiSelectionByMouse = false;
                super.seslSetCtrlkeyPressed(false);
            }
            this.mIsDraggingViewByMouse = false;
            this.mStartPosition = -1;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void executeRunnable(Runnable runnable, int i) {
        postDelayed(runnable, i);
    }

    public int getDragAndDropScrollPosition(int i, int i2, int i4) {
        MainLogger.m7258i(TAG, "getDragAndDropScrollPosition position : " + i2);
        if (getAdapter() != null && getAdapter().getItemCount() != 0) {
            if (NotesUtils.isGridLayout(this.mLayoutMode)) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                Objects.requireNonNull(gridLayoutManager);
                int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                AbstractC8014b.m7201c(iFindFirstVisibleItemPosition, "getDragAndDropScrollPosition firstVisibleItem : ", TAG);
                if (i == 2048) {
                    int i5 = i2 - i4;
                    if (i5 <= iFindFirstVisibleItemPosition) {
                        return Math.max(i5, 0);
                    }
                } else {
                    int i6 = i2 - 1;
                    if (i6 <= iFindFirstVisibleItemPosition) {
                        return Math.max(i6, 0);
                    }
                }
            } else if (NotesUtils.isStaggeredGridLayout(this.mLayoutMode)) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                Objects.requireNonNull(layoutManager);
                int firstVisibleItem = getFirstVisibleItem(((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null));
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition firstVisibleItem : " + firstVisibleItem);
                int i7 = i2 - (i4 + (-1));
                if (i7 <= firstVisibleItem) {
                    return Math.max(i7 - 1, 0);
                }
                if (i2 - i4 == firstVisibleItem && isFirstItemNotCompletelyDisplaying(firstVisibleItem)) {
                    return Math.max(firstVisibleItem - 1, 0);
                }
            } else if (NotesUtils.isLinearLayout(this.mLayoutMode)) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
                Objects.requireNonNull(linearLayoutManager);
                int iFindFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition firstVisibleItem : " + iFindFirstVisibleItemPosition2);
                if (i2 - 1 <= iFindFirstVisibleItemPosition2) {
                    return Math.max(i2 - 2, 0);
                }
            }
            if (NotesUtils.isGridLayout(this.mLayoutMode)) {
                GridLayoutManager gridLayoutManager2 = (GridLayoutManager) getLayoutManager();
                Objects.requireNonNull(gridLayoutManager2);
                int iFindLastVisibleItemPosition = gridLayoutManager2.findLastVisibleItemPosition();
                AbstractC8014b.m7201c(iFindLastVisibleItemPosition, "getDragAndDropScrollPosition lastVisibleItem : ", TAG);
                if (i == 2048) {
                    int i8 = i2 + i4;
                    if (i8 >= iFindLastVisibleItemPosition) {
                        return Math.min(i8, getAdapter().getItemCount());
                    }
                } else {
                    int i9 = i2 + 1;
                    if (i9 >= iFindLastVisibleItemPosition) {
                        return Math.min(i9, getAdapter().getItemCount());
                    }
                }
            } else if (NotesUtils.isStaggeredGridLayout(this.mLayoutMode)) {
                RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
                Objects.requireNonNull(layoutManager2);
                int lastVisibleItem = getLastVisibleItem(((StaggeredGridLayoutManager) layoutManager2).findLastVisibleItemPositions(null));
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition lastVisibleItem : " + lastVisibleItem);
                int i10 = i4 + (-1) + i2;
                if (i10 >= lastVisibleItem) {
                    return Math.min(i10 + 1, getAdapter().getItemCount());
                }
                int i11 = i2 + i4;
                if (i11 == lastVisibleItem && isLastItemNotCompletelyDisplaying(i11)) {
                    return Math.min(i11 + 1, getAdapter().getItemCount());
                }
            } else if (NotesUtils.isLinearLayout(this.mLayoutMode)) {
                LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) getLayoutManager();
                Objects.requireNonNull(linearLayoutManager2);
                int iFindLastVisibleItemPosition2 = linearLayoutManager2.findLastVisibleItemPosition();
                MainLogger.m7258i(TAG, "getDragAndDropScrollPosition lastVisibleItem : " + iFindLastVisibleItemPosition2);
                if (i2 + 1 >= iFindLastVisibleItemPosition2) {
                    return Math.min(i2 + 2, getAdapter().getItemCount());
                }
            }
        }
        return -1;
    }

    public int getFirstVisibleItem(int[] iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 == 0 || iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public int getLastVisibleItem(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 == 0 || iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public float getRawX() {
        return this.mRawX;
    }

    public float getRawY() {
        return this.mRawY;
    }

    public float getStartX() {
        return this.mStartX;
    }

    public boolean isLastItemNotDisplaying(int i) {
        if (NotesUtils.isStaggeredGridLayout(this.mLayoutMode)) {
            if (getAdapter().getItemCount() != 0) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                Objects.requireNonNull(layoutManager);
                int lastVisibleItem = getLastVisibleItem(((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null));
                if (lastVisibleItem != -1 && lastVisibleItem < i) {
                    return true;
                }
            }
            return false;
        }
        if (NotesUtils.isGridLayout(this.mLayoutMode) && getAdapter().getItemCount() != 0) {
            RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
            Objects.requireNonNull(layoutManager2);
            int iFindLastVisibleItemPosition = ((GridLayoutManager) layoutManager2).findLastVisibleItemPosition();
            if (iFindLastVisibleItemPosition != -1 && iFindLastVisibleItemPosition < i) {
                return true;
            }
        }
        return false;
    }

    public boolean isNeedChecked() {
        return this.mIsNeedChecked;
    }

    public boolean isVisibleHolder(NotesPenRecyclerView notesPenRecyclerView, int i) {
        if (NotesUtils.isGridLayout(notesPenRecyclerView.getLayoutMode())) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) notesPenRecyclerView.getLayoutManager();
            if (gridLayoutManager != null) {
                return i >= gridLayoutManager.findFirstVisibleItemPosition() && i <= gridLayoutManager.findLastVisibleItemPosition();
            }
        } else if (NotesUtils.isStaggeredGridLayout(notesPenRecyclerView.getLayoutMode())) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) notesPenRecyclerView.getLayoutManager();
            if (staggeredGridLayoutManager != null) {
                int[] iArrFindFirstCompletelyVisibleItemPositions = staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null);
                int[] iArrFindLastCompletelyVisibleItemPositions = staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null);
                for (int i2 : iArrFindFirstCompletelyVisibleItemPositions) {
                    for (int i4 : iArrFindLastCompletelyVisibleItemPositions) {
                        if (i >= i2 && i <= i4) {
                            return true;
                        }
                    }
                }
            }
        } else {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) notesPenRecyclerView.getLayoutManager();
            if (linearLayoutManager != null) {
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (i >= iFindFirstVisibleItemPosition && i <= iFindLastVisibleItemPosition) {
                    return true;
                }
            }
        }
        return false;
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

    public void removeOnDragAndDropListener() {
        this.mOnDragAndDropListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView
    public void removeOnLongPressMultiSelectionListener() {
        super.removeOnLongPressMultiSelectionListener();
        seslSetLongPressMultiSelectionListener(null);
    }

    public void scrollToPosition(int i, boolean z) {
        stopScroll();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        if (!z) {
            layoutManager.scrollToPosition(i);
            return;
        }
        if (NotesUtils.isLinearLayout(getLayoutMode())) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        } else if (NotesUtils.isStaggeredGridLayout(getLayoutMode())) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        } else {
            scrollToPosition(0);
        }
    }

    public boolean scrollToTop() {
        int spanCount;
        if (computeVerticalScrollOffset() <= 0) {
            return false;
        }
        stopScroll();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
            return true;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        Objects.requireNonNull(linearLayoutManager);
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int childCount = getChildCount();
        if (childCount > 0 && childCount < iFindFirstVisibleItemPosition) {
            if ((layoutManager instanceof GridLayoutManager) && childCount < (spanCount = ((GridLayoutManager) layoutManager).getSpanCount())) {
                childCount = spanCount;
            }
            linearLayoutManager.scrollToPositionWithOffset(childCount, 0);
        }
        post(new RunnableC8239e(this, 1));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void seslSetCtrlkeyPressed(boolean z) {
        this.mIsCtrlKeyPressed = z;
        super.seslSetCtrlkeyPressed(z);
    }

    public void setLastClickedUuid(String str) {
        this.mLastClickedUuid = str;
    }

    public void setOnDragAndDropListener(OnDragAndDropListener onDragAndDropListener) {
        this.mOnDragAndDropListener = onDragAndDropListener;
    }

    public void setOnMouseDragListener(OnMouseDragListener onMouseDragListener) {
        this.mOnMouseDragListener = onMouseDragListener;
    }

    public void setOnShiftMultiSelectionListener(OnShiftMultiSelectionListener onShiftMultiSelectionListener) {
        this.mOnShiftMultiSelectionListener = onShiftMultiSelectionListener;
    }

    public void setShiftKeyPressed(boolean z) {
        this.mIsShiftKeyPressed = z;
    }

    public void smoothScrollToPosition(int i, View view, DragEvent dragEvent) {
        if (i == -1) {
            return;
        }
        if (this.mIsTabletLayout) {
            int i2 = NotesUtils.getTouchPositionFromDragEvent(view, dragEvent).y;
            double d = i2;
            int i4 = this.mHeightPixels;
            if (d >= ((double) i4) * 0.2d && i2 <= ((double) i4) * 0.8d) {
                AbstractC8014b.m7201c(i, "smoothScrollToPosition fail ", TAG);
                return;
            }
            smoothScrollToPositionForDragAndDrop(i);
        } else {
            smoothScrollToPositionForDragAndDrop(i);
        }
        AbstractC8014b.m7201c(i, "smoothScrollToPosition success ", TAG);
    }

    public void smoothScrollToPositionForDragAndDrop(int i) {
        AbstractC8014b.m7201c(i, "smoothScrollToPositionForDragAndDrop position : ", TAG);
        super.smoothScrollToPosition(i);
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(getContext()) { // from class: com.samsung.android.support.senl.nt.app.main.common.view.NotesPenRecyclerView.2
            private static final float SPEED = 300.0f;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 300.0f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        getLayoutManager().startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView
    public void startLongPressMultiSelection() {
        this.mIsNeedChecked = true;
        setLongPressed(true);
        seslStartLongPressMultiSelection();
    }

    public NotesPenRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHeightPixels = 0;
        this.mIsTabletLayout = false;
        this.mIsNeedChecked = false;
        this.mStartPosition = -1;
        this.mLastClickedUuid = null;
        init(context);
    }

    public NotesPenRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeightPixels = 0;
        this.mIsTabletLayout = false;
        this.mIsNeedChecked = false;
        this.mStartPosition = -1;
        this.mLastClickedUuid = null;
        init(context);
    }
}
