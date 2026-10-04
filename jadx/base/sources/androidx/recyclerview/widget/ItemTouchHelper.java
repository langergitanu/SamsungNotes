package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.C3728R;
import androidx.recyclerview.widget.RecyclerView;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final int CALLEDBY_ONDRAW = 2;
    private static final int CALLEDBY_ONDRAWOVER = 1;
    private static final int CALLEDBY_SELECT = 3;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";

    /* JADX INFO: renamed from: UP */
    public static final int f1649UP = 1;

    @NonNull
    Callback mCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    RecyclerView mRecyclerView;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;
    final List<View> mPendingCleanup = new ArrayList();
    private final float[] mTmpPosition = new float[2];
    RecyclerView.ViewHolder mSelected = null;
    int mActivePointerId = -1;
    private int mActionState = 0;

    @VisibleForTesting
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    final Runnable mScrollRunnable = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.mSelected == null || !itemTouchHelper.scrollIfNecessary()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.mSelected;
            if (viewHolder != null) {
                itemTouchHelper2.moveIfNecessary(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
            itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
        }
    };
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int iFindPointerIndex;
            RecoverAnimation recoverAnimationFindAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                AbstractC2821a.m2206A(new StringBuilder("onInterceptTouchEvent: #1 set mInitialTouchX = "), ItemTouchHelper.TAG, ItemTouchHelper.this.mInitialTouchX);
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                if (ItemTouchHelper.this.mUsePagingTouchSlopForStylus) {
                    if (motionEvent.isFromSource(InputDeviceCompat.SOURCE_STYLUS)) {
                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.mSlop = itemTouchHelper.mPagingTouchSlop;
                    } else {
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.mSlop = itemTouchHelper2.mTouchSlop;
                    }
                }
                ItemTouchHelper.this.obtainVelocityTracker();
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                if (itemTouchHelper3.mSelected == null && (recoverAnimationFindAnimation = itemTouchHelper3.findAnimation(motionEvent)) != null) {
                    StringBuilder sb = new StringBuilder("onInterceptTouchEvent: #2 mInitialTouchX = ");
                    sb.append(ItemTouchHelper.this.mInitialTouchX);
                    sb.append(" animation.mX = ");
                    AbstractC2821a.m2206A(sb, ItemTouchHelper.TAG, recoverAnimationFindAnimation.f1650mX);
                    ItemTouchHelper.this.mInitialTouchX -= recoverAnimationFindAnimation.f1650mX;
                    AbstractC2821a.m2206A(new StringBuilder("onInterceptTouchEvent: #2 set mInitialTouchX = "), ItemTouchHelper.TAG, ItemTouchHelper.this.mInitialTouchX);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.mInitialTouchY -= recoverAnimationFindAnimation.f1651mY;
                    itemTouchHelper4.endRecoverAnimation(recoverAnimationFindAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(recoverAnimationFindAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                        itemTouchHelper5.mCallback.clearView(itemTouchHelper5.mRecyclerView, recoverAnimationFindAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(recoverAnimationFindAnimation.mViewHolder, recoverAnimationFindAnimation.mActionState);
                    ItemTouchHelper itemTouchHelper6 = ItemTouchHelper.this;
                    itemTouchHelper6.updateDxDy(motionEvent, itemTouchHelper6.mSelectedFlags, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper7 = ItemTouchHelper.this;
                itemTouchHelper7.mActivePointerId = -1;
                itemTouchHelper7.select(null, 0);
            } else {
                int i = ItemTouchHelper.this.mActivePointerId;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.mSelected != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
            if (iFindPointerIndex >= 0) {
                ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (motionEvent.getButtonState() == 32) {
                        ItemTouchHelper.this.select(null, 0);
                        ItemTouchHelper.this.mActivePointerId = -1;
                        return;
                    } else {
                        if (iFindPointerIndex >= 0) {
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            itemTouchHelper2.updateDxDy(motionEvent, itemTouchHelper2.mSelectedFlags, iFindPointerIndex);
                            ItemTouchHelper.this.moveIfNecessary(viewHolder);
                            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                            itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
                            ItemTouchHelper.this.mScrollRunnable.run();
                            ItemTouchHelper.this.mRecyclerView.invalidate();
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    if (pointerId == itemTouchHelper4.mActivePointerId) {
                        itemTouchHelper4.mActivePointerId = motionEvent.getPointerId(actionIndex != 0 ? 0 : 1);
                        ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                        itemTouchHelper5.updateDxDy(motionEvent, itemTouchHelper5.mSelectedFlags, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            ItemTouchHelper.this.select(null, 0);
            ItemTouchHelper.this.mActivePointerId = -1;
        }
    };
    private int mTouchSlop = 0;
    private int mPagingTouchSlop = 0;
    private boolean mUsePagingTouchSlopForStylus = false;
    private String mStartDraggingText = null;
    private String mMoveDraggingText = null;
    private String mEndDraggingText = null;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.ItemTouchHelper$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C37535 implements RecyclerView.ChildDrawingOrderCallback {
        public C37535() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
        public int onGetChildDrawingOrder(int i, int i2) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            View view = itemTouchHelper.mOverdrawChild;
            if (view != null) {
                int iIndexOfChild = itemTouchHelper.mOverdrawChildPosition;
                if (iIndexOfChild == -1) {
                    iIndexOfChild = itemTouchHelper.mRecyclerView.indexOfChild(view);
                    ItemTouchHelper.this.mOverdrawChildPosition = iIndexOfChild;
                }
                if (i2 == i - 1) {
                    return iIndexOfChild;
                }
                if (i2 >= iIndexOfChild) {
                    return i2 + 1;
                }
            }
            return i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress = true;

        public ItemTouchHelperGestureListener() {
        }

        public void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewFindChildView;
            RecyclerView.ViewHolder childViewHolder;
            if (!this.mShouldReactToLongPress || (viewFindChildView = ItemTouchHelper.this.findChildView(motionEvent)) == null || (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(viewFindChildView)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (!itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
                childViewHolder.itemView.announceForAccessibility(ItemTouchHelper.this.mRecyclerView.getContext().getString(C3728R.string.dragndroplist_item_cannot_be_dragged, Integer.valueOf(childViewHolder.getLayoutPosition() + 1)));
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            int i = ItemTouchHelper.this.mActivePointerId;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y2 = motionEvent.getY(iFindPointerIndex);
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                itemTouchHelper2.mInitialTouchX = x;
                itemTouchHelper2.mInitialTouchY = y2;
                itemTouchHelper2.mDy = 0.0f;
                itemTouchHelper2.mDx = 0.0f;
                if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.select(childViewHolder, 2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.mCallback = callback;
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.mDx > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i4 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i4 & i) != 0 && i2 == i4 && fAbs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && fAbs > Math.abs(yVelocity)) {
                return i4;
            }
        }
        float swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getWidth();
        if ((i & i2) == 0 || Math.abs(this.mDx) <= swipeThreshold) {
            return 0;
        }
        return i2;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.mDy > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i4 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i4 & i) != 0 && i4 == i2 && fAbs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && fAbs > Math.abs(xVelocity)) {
                return i4;
            }
        }
        float swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getHeight();
        if ((i & i2) == 0 || Math.abs(this.mDy) <= swipeThreshold) {
            return 0;
        }
        return i2;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(0);
            recoverAnimation.cancel();
            this.mCallback.clearView(this.mRecyclerView, recoverAnimation.mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        List<RecyclerView.ViewHolder> list = this.mSwapTargets;
        if (list == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            list.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getMBoundingBoxMargin();
        int iRound = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int iRound2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = viewHolder.itemView.getWidth() + iRound + i;
        int height = viewHolder.itemView.getHeight() + iRound2 + i;
        int i2 = (iRound + width) / 2;
        int i4 = (iRound2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        Rect rect = new Rect(0, 0, this.mRecyclerView.getWidth(), this.mRecyclerView.getHeight());
        Rect rect2 = new Rect(iRound, iRound2, width, height);
        boolean z = true;
        if ((layoutManager instanceof LinearLayoutManager) && layoutManager.canScrollVertically()) {
            if (iRound < 0) {
                rect2.right -= iRound;
                rect2.left = 0;
                z = false;
            }
            if (width > this.mRecyclerView.getWidth()) {
                rect2.left -= width - this.mRecyclerView.getWidth();
                rect2.right = this.mRecyclerView.getWidth();
                z = false;
            }
            if (iRound2 < 0) {
                rect2.bottom -= iRound2;
                rect2.top = 0;
                z = false;
            }
            if (height > this.mRecyclerView.getHeight()) {
                rect2.top -= height - this.mRecyclerView.getHeight();
                rect2.bottom = this.mRecyclerView.getHeight();
                z = false;
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null && childAt != viewHolder.itemView) {
                Rect rect3 = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (Rect.intersects(rect2, rect3) && (z || rect.contains(rect3))) {
                    RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                    if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                        int iAbs = Math.abs(i2 - ((childAt.getRight() + childAt.getLeft()) / 2));
                        int iAbs2 = Math.abs(i4 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i6 = (iAbs2 * iAbs2) + (iAbs * iAbs);
                        int size = this.mSwapTargets.size();
                        int i7 = 0;
                        for (int i8 = 0; i8 < size && i6 > this.mDistances.get(i8).intValue(); i8++) {
                            i7++;
                        }
                        this.mSwapTargets.add(i7, childViewHolder);
                        this.mDistances.add(i7, Integer.valueOf(i6));
                    }
                }
            }
        }
        return this.mSwapTargets;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View viewFindChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i = this.mActivePointerId;
        if (i == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.mInitialTouchX;
        float y2 = motionEvent.getY(iFindPointerIndex) - this.mInitialTouchY;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y2);
        int i2 = this.mSlop;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.canScrollVertically()) && (viewFindChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(viewFindChildView);
        }
        return null;
    }

    private void getSelectedDxDy(float[] fArr, int i) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "getSelectedDxDy: #1 calledBy = ", " outPosition[0] = ");
            sbM778t.append(fArr[0]);
            sbM778t.append(", mSelectedStartX = ");
            sbM778t.append(this.mSelectedStartX);
            sbM778t.append(", mDx = ");
            sbM778t.append(this.mDx);
            sbM778t.append(", mSelected.itemView.getLeft() = ");
            sbM778t.append(this.mSelected.itemView.getLeft());
            Log.i(TAG, sbM778t.toString());
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
            StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "getSelectedDxDy: #2 calledBy = ", " outPosition[0] = ");
            sbM778t2.append(this.mSelected.itemView.getTranslationX());
            Log.i(TAG, sbM778t2.toString());
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f, float f4, float f5, float f6) {
        return f >= f5 && f <= f5 + ((float) view.getWidth()) && f4 >= f6 && f4 <= f6 + ((float) view.getHeight());
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mRecyclerView.getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mPagingTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if (this.mGestureDetector != null) {
            this.mGestureDetector = null;
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int iConvertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (iConvertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int iCheckHorizontalSwipe = checkHorizontalSwipe(viewHolder, iConvertToAbsoluteDirection);
            if (iCheckHorizontalSwipe > 0) {
                return (i & iCheckHorizontalSwipe) == 0 ? Callback.convertToRelativeDirection(iCheckHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : iCheckHorizontalSwipe;
            }
            int iCheckVerticalSwipe = checkVerticalSwipe(viewHolder, iConvertToAbsoluteDirection);
            if (iCheckVerticalSwipe > 0) {
                return iCheckVerticalSwipe;
            }
        } else {
            int iCheckVerticalSwipe2 = checkVerticalSwipe(viewHolder, iConvertToAbsoluteDirection);
            if (iCheckVerticalSwipe2 > 0) {
                return iCheckVerticalSwipe2;
            }
            int iCheckHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, iConvertToAbsoluteDirection);
            if (iCheckHorizontalSwipe2 > 0) {
                return (i & iCheckHorizontalSwipe2) == 0 ? Callback.convertToRelativeDirection(iCheckHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView)) : iCheckHorizontalSwipe2;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(C3728R.dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = resources.getDimension(C3728R.dimen.item_touch_helper_swipe_escape_max_velocity);
            setupCallbacks();
        }
    }

    public void checkSelectForSwipe(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder viewHolderFindSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (viewHolderFindSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolderFindSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y2 = motionEvent.getY(i2);
        float f = x - this.mInitialTouchX;
        float f4 = y2 - this.mInitialTouchY;
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f4);
        int i4 = this.mSlop;
        if (fAbs >= i4 || fAbs2 >= i4) {
            if (fAbs > fAbs2) {
                if (f < 0.0f && (absoluteMovementFlags & 4) == 0) {
                    return;
                }
                if (f > 0.0f && (absoluteMovementFlags & 8) == 0) {
                    return;
                }
            } else {
                if (f4 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                }
                if (f4 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                    return;
                }
            }
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            select(viewHolderFindSwipedView, 1);
        }
    }

    public void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View viewFindChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == viewFindChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    public View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x, y2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y2, recoverAnimation.f1650mX, recoverAnimation.f1651mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    public boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!this.mRecoverAnimations.get(i).mEnded) {
                return true;
            }
        }
        return false;
    }

    public void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i = (int) (this.mSelectedStartX + this.mDx);
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> listFindSwapTargets = findSwapTargets(viewHolder);
                if (listFindSwapTargets.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder viewHolderChooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, listFindSwapTargets, i, i2);
                if (viewHolderChooseDropTarget == null) {
                    this.mSwapTargets.clear();
                    this.mDistances.clear();
                    return;
                }
                int absoluteAdapterPosition = viewHolderChooseDropTarget.getAbsoluteAdapterPosition();
                int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
                if (this.mCallback.onMove(this.mRecyclerView, viewHolder, viewHolderChooseDropTarget)) {
                    this.mCallback.onMoved(this.mRecyclerView, viewHolder, absoluteAdapterPosition2, viewHolderChooseDropTarget, absoluteAdapterPosition, i, i2);
                    viewHolder.itemView.performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(41));
                    String str = this.mMoveDraggingText;
                    if (str == null || str.isEmpty()) {
                        this.mSelected.itemView.announceForAccessibility(this.mRecyclerView.getContext().getString(C3728R.string.dragndroplist_drag_move, Integer.valueOf(absoluteAdapterPosition + 1)));
                    } else {
                        this.mSelected.itemView.announceForAccessibility(this.mMoveDraggingText);
                    }
                }
            }
        }
    }

    public void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f4;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition, 2);
            float[] fArr = this.mTmpPosition;
            float f5 = fArr[0];
            f4 = fArr[1];
            f = f5;
        } else {
            f = 0.0f;
            f4 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        float f;
        float f4;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition, 1);
            float[] fArr = this.mTmpPosition;
            float f5 = fArr[0];
            f4 = fArr[1];
            f = f5;
        } else {
            f = 0.0f;
            f4 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f, f4);
    }

    public void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.mRecyclerView;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation2 = recoverAnimation;
                    if (!recoverAnimation2.mOverridden && recoverAnimation2.mViewHolder.getAbsoluteAdapterPosition() != -1) {
                        StringBuilder sb = new StringBuilder("postDispatchSwipe$run: mRecyclerView = ");
                        sb.append(ItemTouchHelper.this.mRecyclerView);
                        sb.append(", isAttachedToWindow = ");
                        sb.append(ItemTouchHelper.this.mRecyclerView.isAttachedToWindow());
                        sb.append(", !anim.mOverridden = ");
                        sb.append(!recoverAnimation.mOverridden);
                        sb.append(", anim.mViewHolder.getAdapterPosition() = ");
                        sb.append(recoverAnimation.mViewHolder.getAdapterPosition());
                        Log.i(ItemTouchHelper.TAG, sb.toString());
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                        if ((itemAnimator != null && itemAnimator.isRunning(null)) || ItemTouchHelper.this.hasRunningRecoverAnim()) {
                            ItemTouchHelper.this.mRecyclerView.post(this);
                            return;
                        }
                        StringBuilder sb2 = new StringBuilder("postDispatchSwipe$run: mCallback.onSwiped anim.mViewHolder = ");
                        sb2.append(recoverAnimation.mViewHolder);
                        sb2.append(", anim.mViewHolder.itemView = ");
                        sb2.append(recoverAnimation.mViewHolder.itemView);
                        sb2.append(" swipeDir=");
                        AbstractC0000a.m26w(sb2, ItemTouchHelper.TAG, i);
                        ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                        ItemTouchHelper.this.endRecoverAnimation(recoverAnimation.mViewHolder, false);
                        return;
                    }
                }
                Log.i(ItemTouchHelper.TAG, "Failed to call mCallback.onSwiped()!, call seslOnSwipeFailed, flag = 0x" + Integer.toHexString(recoverAnimation.mViewHolder.getFlags()));
                ItemTouchHelper.this.mCallback.seslOnSwipeFailed(recoverAnimation.mViewHolder, i);
                ItemTouchHelper.this.endRecoverAnimation(recoverAnimation.mViewHolder, false);
            }
        });
    }

    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean scrollIfNecessary() {
        int iInterpolateOutOfBoundsScroll;
        int iInterpolateOutOfBoundsScroll2;
        if (this.mSelected == null) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.mDragScrollStartTimeInMs;
        long j2 = j == Long.MIN_VALUE ? 0L : jCurrentTimeMillis - j;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mTmpRect == null) {
            this.mTmpRect = new Rect();
        }
        layoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
        if (layoutManager.canScrollHorizontally()) {
            int i = (int) (this.mSelectedStartX + this.mDx);
            int paddingLeft = (i - this.mTmpRect.left) - this.mRecyclerView.getPaddingLeft();
            float f = this.mDx;
            iInterpolateOutOfBoundsScroll = ((f >= 0.0f || paddingLeft >= 0) && (f <= 0.0f || (paddingLeft = ((this.mSelected.itemView.getWidth() + i) + this.mTmpRect.right) - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight())) <= 0)) ? 0 : paddingLeft;
        }
        if (layoutManager.canScrollVertically()) {
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            iInterpolateOutOfBoundsScroll2 = (i2 - this.mTmpRect.top) - this.mRecyclerView.getPaddingTop();
            float f4 = this.mDy;
            if (f4 >= 0.0f || iInterpolateOutOfBoundsScroll2 >= 0) {
                if (f4 > 0.0f) {
                    iInterpolateOutOfBoundsScroll2 = ((this.mSelected.itemView.getHeight() + i2) + this.mTmpRect.bottom) - ((this.mRecyclerView.getHeight() - this.mRecyclerView.seslGetBottomScrollOffset()) - this.mRecyclerView.getPaddingBottom());
                    if (iInterpolateOutOfBoundsScroll2 <= 0) {
                        iInterpolateOutOfBoundsScroll2 = 0;
                    }
                }
            }
        }
        if (iInterpolateOutOfBoundsScroll != 0) {
            iInterpolateOutOfBoundsScroll = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), iInterpolateOutOfBoundsScroll, this.mRecyclerView.getWidth(), j2);
        }
        int i4 = iInterpolateOutOfBoundsScroll;
        if (iInterpolateOutOfBoundsScroll2 != 0) {
            iInterpolateOutOfBoundsScroll2 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), iInterpolateOutOfBoundsScroll2, this.mRecyclerView.getHeight(), j2);
        }
        if (i4 == 0 && iInterpolateOutOfBoundsScroll2 == 0) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
        }
        if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            this.mDragScrollStartTimeInMs = jCurrentTimeMillis;
        }
        this.mRecyclerView.scrollBy(i4, iInterpolateOutOfBoundsScroll2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void select(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
        boolean z;
        int i2;
        float fSignum;
        float fSignum2;
        if (viewHolder == this.mSelected && i == this.mActionState) {
            return;
        }
        this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
        int i4 = this.mActionState;
        endRecoverAnimation(viewHolder, true);
        this.mActionState = i;
        if (i == 2) {
            if (viewHolder == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.mOverdrawChild = viewHolder.itemView;
            addChildDrawingOrderCallback();
        }
        int i5 = (1 << ((i * 8) + 8)) - 1;
        final RecyclerView.ViewHolder viewHolder2 = this.mSelected;
        boolean z2 = false;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                final int iSwipeIfNecessary = i4 == 2 ? 0 : swipeIfNecessary(viewHolder2);
                releaseVelocityTracker();
                int i6 = 4;
                if (iSwipeIfNecessary == 1 || iSwipeIfNecessary == 2) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
                } else if (iSwipeIfNecessary == 4 || iSwipeIfNecessary == 8 || iSwipeIfNecessary == 16 || iSwipeIfNecessary == 32) {
                    fSignum2 = 0.0f;
                    fSignum = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
                } else {
                    fSignum = 0.0f;
                    fSignum2 = 0.0f;
                }
                if (i4 == 2) {
                    String str = this.mEndDraggingText;
                    if (str == null || str.isEmpty()) {
                        this.mSelected.itemView.announceForAccessibility(this.mRecyclerView.getContext().getString(C3728R.string.dragndroplist_drag_release, Integer.valueOf(this.mSelected.getLayoutPosition() + 1)));
                    } else {
                        this.mSelected.itemView.announceForAccessibility(this.mEndDraggingText);
                    }
                    i6 = 8;
                } else if (iSwipeIfNecessary > 0) {
                    i6 = 2;
                }
                getSelectedDxDy(this.mTmpPosition, 3);
                float[] fArr = this.mTmpPosition;
                float f = fArr[0];
                float f4 = fArr[1];
                z = true;
                i2 = 0;
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, i6, i4, f, f4, fSignum, fSignum2) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                    @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        Log.i(ItemTouchHelper.TAG, "select: *** Start RecoverAnimation$onAnimationEnd ***");
                        if (this.mOverridden) {
                            Log.i(ItemTouchHelper.TAG, "select: *** End RecoverAnimation$onAnimationEnd *** return #1");
                            return;
                        }
                        AbstractC0000a.m26w(new StringBuilder("select$onAnimationEnd: swipeDir = "), ItemTouchHelper.TAG, iSwipeIfNecessary);
                        if (iSwipeIfNecessary <= 0) {
                            Log.i(ItemTouchHelper.TAG, "select$onAnimationEnd: #2 call mCallback.clearView(mRecyclerView = " + ItemTouchHelper.this.mRecyclerView + ", prevSelected = " + viewHolder2 + ")");
                            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                            itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, viewHolder2);
                        } else if (viewHolder2.itemView.isAttachedToWindow()) {
                            ItemTouchHelper.this.mPendingCleanup.add(viewHolder2.itemView);
                            this.mIsPendingCleanup = true;
                            if (iSwipeIfNecessary > 0) {
                                Log.i(ItemTouchHelper.TAG, "select$onAnimationEnd: postDispatchSwipe #4");
                                ItemTouchHelper.this.postDispatchSwipe(this, iSwipeIfNecessary);
                            } else {
                                Log.i(ItemTouchHelper.TAG, "select$onAnimationEnd: swipeDir <= 0 #5 do nothing");
                            }
                        } else {
                            Log.i(ItemTouchHelper.TAG, "select$onAnimationEnd: #3 call mCallback.clearView(mRecyclerView = " + ItemTouchHelper.this.mRecyclerView + ", prevSelected = " + viewHolder2 + ")");
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            itemTouchHelper2.mCallback.clearView(itemTouchHelper2.mRecyclerView, viewHolder2);
                        }
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        View view = itemTouchHelper3.mOverdrawChild;
                        View view2 = viewHolder2.itemView;
                        if (view == view2) {
                            itemTouchHelper3.removeChildDrawingOrderCallbackIfNecessary(view2);
                        }
                        Log.i(ItemTouchHelper.TAG, "select: *** End RecoverAnimation$onAnimationEnd *** #6");
                    }
                };
                long animationDuration = this.mCallback.getAnimationDuration(this.mRecyclerView, i6, fSignum - f, fSignum2 - f4);
                Log.i(TAG, "select: setDuration = " + animationDuration);
                recoverAnimation.setDuration(animationDuration);
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                z2 = true;
            } else {
                z = true;
                i2 = 0;
                removeChildDrawingOrderCallbackIfNecessary(viewHolder2.itemView);
                this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                z2 = false;
            }
            this.mSelected = null;
        } else {
            z = true;
            i2 = 0;
        }
        if (viewHolder != null) {
            this.mSelectedFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, viewHolder) & i5) >> (this.mActionState * 8);
            this.mSelectedStartX = viewHolder.itemView.getLeft();
            this.mSelectedStartY = viewHolder.itemView.getTop();
            this.mSelected = viewHolder;
        }
        ViewParent parent = this.mRecyclerView.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.mSelected != null ? z : i2);
        }
        if (!z2) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        int i7 = this.mActionState;
        if (i7 == 0) {
            this.mCallback.onSelectedChanged(viewHolder2, i7);
        } else {
            this.mCallback.onSelectedChanged(this.mSelected, i7);
        }
        if (i == 2) {
            this.mSelected.itemView.performHapticFeedback(i2);
            String str2 = this.mStartDraggingText;
            if (str2 == null || str2.isEmpty()) {
                this.mSelected.itemView.announceForAccessibility(this.mRecyclerView.getContext().getString(C3728R.string.dragndroplist_drag_start, Integer.valueOf(this.mSelected.getLayoutPosition() + 1)));
            } else {
                this.mSelected.itemView.announceForAccessibility(this.mStartDraggingText);
            }
        }
        this.mRecyclerView.invalidate();
    }

    public boolean seslIsPagingTouchSlopForStylusEnabled() {
        return this.mUsePagingTouchSlopForStylus;
    }

    public void seslSetPagingTouchSlopForStylus(boolean z) {
        this.mUsePagingTouchSlopForStylus = z;
    }

    public void setEndDraggingText(String str) {
        this.mEndDraggingText = str;
    }

    public void setMoveDraggingText(String str) {
        this.mMoveDraggingText = str;
    }

    public void setStartDraggingText(String str) {
        this.mStartDraggingText = str;
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but dragging is not enabled");
            viewHolder.itemView.announceForAccessibility(this.mRecyclerView.getContext().getString(C3728R.string.dragndroplist_item_cannot_be_dragged, Integer.valueOf(viewHolder.getLayoutPosition() + 1)));
        } else {
            if (viewHolder.itemView.getParent() != this.mRecyclerView) {
                Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
                return;
            }
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        select(viewHolder, 1);
    }

    public void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y2 = motionEvent.getY(i2);
        this.mDx = x - this.mInitialTouchX;
        StringBuilder sb = new StringBuilder("updateDxDy: mDx = ");
        AbstractC11014a.m12337v(sb, this.mDx, " = (x = ", x, " - mInitialTouchX = ");
        AbstractC2821a.m2234y(sb, this.mInitialTouchX, ")", TAG);
        this.mDy = y2 - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
            AbstractC2821a.m2206A(new StringBuilder("updateDxDy: direction LEFT mDx = "), TAG, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
            AbstractC2821a.m2206A(new StringBuilder("updateDxDy: direction RIGHT mDx = "), TAG, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    private void addChildDrawingOrderCallback() {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f4 = f - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i4;
            int i5 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i5 == 0) {
                return i;
            }
            int i6 = i & (~i5);
            if (i2 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= (-789517) & i7;
                i4 = (i7 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i6 | i4;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(C3728R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i, int i2) {
            int iAbs;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int iAbs4;
            int width = viewHolder.itemView.getWidth() + i;
            int height = viewHolder.itemView.getHeight() + i2;
            int left2 = i - viewHolder.itemView.getLeft();
            int top = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i5);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - width) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (iAbs4 = Math.abs(right)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = iAbs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (iAbs3 = Math.abs(left)) > i4) {
                    viewHolder2 = viewHolder3;
                    i4 = iAbs3;
                }
                if (top < 0) {
                    int bottom = (viewHolder3.itemView.getBottom() + viewHolder3.itemView.getTop()) / 2;
                    int bottom2 = (viewHolder.itemView.getBottom() + viewHolder.itemView.getTop()) / 2;
                    int i6 = bottom - i2;
                    if (i6 > 0 && bottom < bottom2 && (iAbs2 = Math.abs(i6)) > i4) {
                        viewHolder2 = viewHolder3;
                        i4 = iAbs2;
                    }
                }
                if (top > 0) {
                    int bottom3 = (viewHolder3.itemView.getBottom() + viewHolder3.itemView.getTop()) / 2;
                    int bottom4 = (viewHolder.itemView.getBottom() + viewHolder.itemView.getTop()) / 2;
                    int i7 = bottom3 - height;
                    if (i7 < 0 && bottom3 > bottom4 && (iAbs = Math.abs(i7)) > i4) {
                        viewHolder2 = viewHolder3;
                        i4 = iAbs;
                    }
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i4;
            int i5 = i & RELATIVE_DIR_FLAGS;
            if (i5 == 0) {
                return i;
            }
            int i6 = i & (~i5);
            if (i2 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= (-3158065) & i7;
                i4 = (i7 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i6 | i4;
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i, float f, float f4) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        /* JADX INFO: renamed from: getBoundingBoxMargin */
        public int getMBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i, int i2, int i4, long j) {
            int interpolation = (int) (sDragScrollInterpolator.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f) * ((int) (sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2)) * getMaxDragScroll(recyclerView))));
            return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f, float f4, int i, boolean z) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f, f4, i, z);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder viewHolder, float f, float f4, int i, boolean z) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f4, i, z);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f4) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                int iSave = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f1650mX, recoverAnimation.f1651mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f4, i, true);
                canvas.restoreToCount(iSave2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f4) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f1650mX, recoverAnimation.f1651mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f4, i, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                RecoverAnimation recoverAnimation2 = list.get(i4);
                boolean z2 = recoverAnimation2.mEnded;
                if (z2 && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i4);
                } else if (!z2) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull RecyclerView.ViewHolder viewHolder2, int i2, int i4, int i5) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i4, i5);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public void seslOnSwipeFailed(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class RecoverAnimation implements Animator.AnimatorListener {
        private final PathInterpolator PATH_INTERPOLATOR;
        final int mActionState;
        final int mAnimationType;
        private float mFraction;
        boolean mIsPendingCleanup;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;

        @VisibleForTesting
        final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;

        /* JADX INFO: renamed from: mX */
        float f1650mX;

        /* JADX INFO: renamed from: mY */
        float f1651mY;
        boolean mOverridden = false;
        boolean mEnded = false;

        public RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f4, float f5, float f6) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
            this.PATH_INTERPOLATOR = pathInterpolator;
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f4;
            this.mTargetX = f5;
            this.mTargetY = f6;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(pathInterpolator);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            valueAnimatorOfFloat.setTarget(viewHolder.itemView);
            valueAnimatorOfFloat.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float f = this.mStartDx;
            float f4 = this.mTargetX;
            if (f == f4) {
                this.f1650mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.f1650mX = AbstractC0000a.m29z(f4, f, this.mFraction, f);
            }
            float f5 = this.mStartDy;
            float f6 = this.mTargetY;
            if (f5 == f6) {
                this.f1651mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.f1651mY = AbstractC0000a.m29z(f6, f5, this.mFraction, f5);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }
}
