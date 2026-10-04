package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ClipDescription;
import android.graphics.PointF;
import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageDragListenerImpl implements View.OnDragListener {
    private static final int MOVE_ANIM_DURATION = 400;
    private static final int NO_INDEX = -1;
    private static final int SCROLL_AREA_ONE = 100;
    private static final int SCROLL_AREA_TWO = 50;
    private static final String TAG = Logger.createTag("PageDragListenerImpl");
    private AnimationItemInfo[] mAniInfo;
    private IPageDragOutAnimator mPageDragOutAnimator;
    private String mPageId;
    private final IPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private int mScrollBottomAreaOne;
    private int mScrollBottomAreaTwo;
    private String mTargetPageId;
    private CountDownTimer mTimer;
    private final PointF mTargetItemPosition = new PointF();
    private int mIndex = -1;
    private boolean mIsMoved = false;
    private boolean mIsEnable = false;
    private final PageListTopMenuDragListenerImpl mPageListTopMenuDragListener = new PageListTopMenuDragListenerImpl();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnimationItemInfo {
        AnimatorSet animatorSet;
        boolean isMoveAnimating = false;
        boolean isMoved = false;
        boolean isReturnAnimating = false;
        float distX = 0.0f;
        float distY = 0.0f;
        int movedIndex = 0;

        public float getDistX() {
            return this.distX;
        }

        public float getDistY() {
            return this.distY;
        }

        public int getMovedIndex() {
            return this.movedIndex;
        }

        public boolean isMoved() {
            return this.isMoved;
        }

        public void setDist(float f, float f4) {
            this.distX = f;
            this.distY = f4;
        }

        @NonNull
        public String toString() {
            return this.isMoveAnimating + " " + this.isReturnAnimating + " " + this.isMoved;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPageDragOutAnimator {
        void prepareDragOutAnimation(RecyclerView recyclerView, PointF pointF);

        void release();

        void startDragOutAnimation(PointF pointF, AnimatorListenerAdapter animatorListenerAdapter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPageItemView {
        int getIndex();

        String getPageId();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void move(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PageListTopMenuDragListenerImpl implements View.OnDragListener {
        private final String TAG = Logger.createTag("PageListTopMenuDragListenerImpl");
        private RecyclerView mRecyclerView;

        public PageListTopMenuDragListenerImpl() {
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            int action = dragEvent.getAction();
            if (action == 1) {
                Logger.m10999d(this.TAG, "onDrag# start");
                return PageDragListenerImpl.this.isPageDragEvent(dragEvent);
            }
            if (action != 2) {
                return false;
            }
            if (this.mRecyclerView.canScrollVertically(-1)) {
                Logger.m10999d(this.TAG, "onDrag# " + (dragEvent.getY() + view.getHeight()));
                if (PageDragListenerImpl.this.onDragLocation(this.mRecyclerView, dragEvent.getX(), dragEvent.getY() + view.getHeight())) {
                    this.mRecyclerView.scrollBy(0, r7.getScrollY() - 50);
                }
            }
            return true;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            this.mRecyclerView = recyclerView;
        }
    }

    public PageDragListenerImpl(IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    private void autoScroll(RecyclerView recyclerView, float f) {
        if (this.mScrollBottomAreaOne < f) {
            if (this.mScrollBottomAreaTwo < f) {
                recyclerView.scrollBy(0, recyclerView.getScrollY() + 50);
                return;
            } else {
                recyclerView.scrollBy(0, recyclerView.getScrollY() + 25);
                return;
            }
        }
        if (100.0f > f) {
            if (50.0f > f) {
                recyclerView.scrollBy(0, recyclerView.getScrollY() - 50);
            } else {
                recyclerView.scrollBy(0, recyclerView.getScrollY() - 25);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimations() {
        AnimationItemInfo[] animationItemInfoArr = this.mAniInfo;
        if (animationItemInfoArr != null) {
            for (AnimationItemInfo animationItemInfo : animationItemInfoArr) {
                AnimatorSet animatorSet = animationItemInfo.animatorSet;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppAniInfo(int i, boolean z) {
        if (z) {
            this.mAniInfo[i].isMoveAnimating = false;
        } else {
            this.mAniInfo[i].isReturnAnimating = false;
        }
        this.mAniInfo[i].animatorSet = null;
    }

    private void dragAnimToNextIndex(RecyclerView recyclerView, int i) {
        AnimationItemInfo[] animationItemInfoArr = this.mAniInfo;
        if (animationItemInfoArr[i].isMoved) {
            int i2 = i + 1;
            if (i2 >= animationItemInfoArr.length || !animationItemInfoArr[i2].isMoved) {
                return;
            }
            while (i2 < this.mAniInfo.length) {
                returnAnimation(recyclerView, i2);
                i2++;
            }
            return;
        }
        int i4 = this.mIndex;
        while (true) {
            i4++;
            if (i4 > i) {
                break;
            } else {
                moveAnimation(recyclerView, i4);
            }
        }
        for (int i5 = this.mIndex - 1; i5 >= 0; i5--) {
            returnAnimation(recyclerView, i5);
        }
    }

    private void dragAnimToPrevIndex(RecyclerView recyclerView, int i) {
        int i2;
        AnimationItemInfo[] animationItemInfoArr = this.mAniInfo;
        if (animationItemInfoArr[i].isMoved) {
            int i4 = i - 1;
            if (i4 < 0 || !animationItemInfoArr[i4].isMoved) {
                return;
            }
            for (int iFindFirstVisibleItemPosition = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= i4; iFindFirstVisibleItemPosition++) {
                returnAnimation(recyclerView, iFindFirstVisibleItemPosition);
            }
            return;
        }
        while (true) {
            i2 = this.mIndex;
            if (i >= i2) {
                break;
            }
            moveAnimation(recyclerView, i);
            i++;
        }
        while (true) {
            i2++;
            if (i2 >= this.mAniInfo.length) {
                return;
            } else {
                returnAnimation(recyclerView, i2);
            }
        }
    }

    private void dragAnimToSameIndex(RecyclerView recyclerView, float f, float f4) {
        KeyEvent.Callback callbackFindChildViewUnder = recyclerView.findChildViewUnder(f, f4);
        if (callbackFindChildViewUnder != null) {
            int index = ((IPageItemView) callbackFindChildViewUnder).getIndex();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            if (index > this.mIndex) {
                for (int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition(); iFindLastVisibleItemPosition >= index; iFindLastVisibleItemPosition--) {
                    returnAnimation(recyclerView, iFindLastVisibleItemPosition);
                }
                return;
            }
            for (int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= index; iFindFirstVisibleItemPosition++) {
                returnAnimation(recyclerView, iFindFirstVisibleItemPosition);
            }
        }
    }

    private View findChildViewUnder(RecyclerView recyclerView, float f, float f4) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int itemCount = recyclerView.getAdapter().getItemCount() - 1;
        int childCount = layoutManager.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return null;
            }
            View childAt = layoutManager.getChildAt(childCount);
            if (childAt != null && f >= childAt.getLeft() && f <= childAt.getRight() && f4 >= childAt.getTop() && f4 <= childAt.getBottom()) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition < itemCount) {
                    return childAt;
                }
                AbstractC8014b.m7216r(childAdapterPosition, itemCount, "findChildViewUnder#, cannot drag to PlusPage, position/lastPosition = ", "/", TAG);
                return null;
            }
        }
    }

    private boolean initData(RecyclerView recyclerView) {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer == null) {
            return false;
        }
        countDownTimer.cancel();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int spanCount = gridLayoutManager.getSpanCount();
        int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        String str = TAG;
        AbstractC0000a.m3D(iFindFirstVisibleItemPosition, "initData# ", str);
        if (iFindFirstVisibleItemPosition < 0) {
            ViewCompat.cancelDragAndDrop(recyclerView);
            release("invalid position");
            return false;
        }
        int bottom = recyclerView.getBottom() - recyclerView.getTop();
        this.mScrollBottomAreaTwo = bottom - 50;
        this.mScrollBottomAreaOne = bottom - 100;
        View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition + 1);
        View viewFindViewByPosition3 = gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition + spanCount);
        if (viewFindViewByPosition != null && viewFindViewByPosition2 != null) {
            initMoveDistance(viewFindViewByPosition2.getLeft() - viewFindViewByPosition.getLeft(), viewFindViewByPosition3 == null ? 0 : viewFindViewByPosition3.getTop() - viewFindViewByPosition.getTop(), recyclerView.getAdapter().getItemCount(), spanCount);
            return this.mAniInfo != null;
        }
        Logger.m10999d(str, "initData#, first : " + viewFindViewByPosition + " / second : " + viewFindViewByPosition2);
        ViewCompat.cancelDragAndDrop(recyclerView);
        release("fail to find view");
        return false;
    }

    private void initMoveDistance(int i, int i2, int i4, int i5) {
        int i6;
        this.mAniInfo = new AnimationItemInfo[i4];
        int i7 = i5 - 1;
        int i8 = 0;
        while (true) {
            i6 = this.mIndex;
            if (i8 >= i6) {
                break;
            }
            this.mAniInfo[i8] = new AnimationItemInfo();
            if (i8 % i5 == i7) {
                this.mAniInfo[i8].setDist(i7 * (-1) * i, i2);
            } else {
                this.mAniInfo[i8].setDist(i, 0.0f);
            }
            this.mAniInfo[i8].movedIndex = i8 + 2;
            i8++;
        }
        this.mAniInfo[i6] = new AnimationItemInfo();
        int i9 = this.mIndex;
        while (true) {
            i9++;
            if (i9 >= i4) {
                AbstractC8014b.m7221w(AbstractC0622a.m1173s(i5, i, "initData# span ", " distance: ", " "), TAG, i2);
                return;
            } else {
                this.mAniInfo[i9] = new AnimationItemInfo();
                if (i9 % i5 > 0) {
                    this.mAniInfo[i9].setDist(i * (-1), 0.0f);
                } else {
                    this.mAniInfo[i9].setDist(i7 * i, i2 * (-1));
                }
                this.mAniInfo[i9].movedIndex = i9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPageDragEvent(DragEvent dragEvent) {
        CharSequence label;
        ClipDescription clipDescription = dragEvent.getClipDescription();
        return (clipDescription == null || (label = clipDescription.getLabel()) == null || !label.equals("Page_Thumbnail")) ? false : true;
    }

    private AnimatorSet makeAnimatorSet(final int i, final boolean z, Animator... animatorArr) {
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorArr);
        animatorSet.setDuration(400L).setInterpolator(new SineInOut70());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PageDragListenerImpl.this.clearAppAniInfo(i, z);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PageDragListenerImpl.this.mAniInfo == null) {
                    return;
                }
                PageDragListenerImpl.this.clearAppAniInfo(i, z);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PageDragListenerImpl.this.mAniInfo[i].animatorSet = animatorSet;
            }
        });
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void moveAnimation(RecyclerView recyclerView, int i) {
        final RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        String str = TAG;
        Logger.m10999d(str, "moveAnimation# " + i + " holder# " + viewHolderFindViewHolderForAdapterPosition + " info# " + this.mAniInfo[i]);
        if (viewHolderFindViewHolderForAdapterPosition == 0) {
            AnimationItemInfo animationItemInfo = this.mAniInfo[i];
            animationItemInfo.isReturnAnimating = false;
            animationItemInfo.isMoveAnimating = false;
            animationItemInfo.isMoved = true;
            return;
        }
        AnimationItemInfo animationItemInfo2 = this.mAniInfo[i];
        if (animationItemInfo2.isMoveAnimating) {
            Logger.m10999d(str, "moveAnimation# animating");
            return;
        }
        if (animationItemInfo2.isMoved) {
            Logger.m10999d(str, "moveAnimation# already");
            return;
        }
        if (animationItemInfo2.isReturnAnimating) {
            AbstractC0000a.m3D(i, "returnAnimation# animating ", str);
            this.mAniInfo[i].animatorSet.cancel();
            this.mAniInfo[i].animatorSet = null;
        }
        this.mAniInfo[i].isMoveAnimating = true;
        AbstractC0000a.m3D(i, "moveAnimation# ", str);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.mAniInfo[i].distX);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                viewHolderFindViewHolderForAdapterPosition.itemView.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, this.mAniInfo[i].distY);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                viewHolderFindViewHolderForAdapterPosition.itemView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        makeAnimatorSet(i, true, valueAnimatorOfFloat, valueAnimatorOfFloat2).start();
        AnimationItemInfo animationItemInfo3 = this.mAniInfo[i];
        animationItemInfo3.isMoved = true;
        setHolderPageIndex((PageListContract.IPageHolder) viewHolderFindViewHolderForAdapterPosition, animationItemInfo3.movedIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onDragLocation(RecyclerView recyclerView, float f, float f4) {
        if (this.mAniInfo == null) {
            Logger.m11000e(TAG, "onDrag# mAniInfo is null");
            return false;
        }
        KeyEvent.Callback callbackFindChildViewUnder = findChildViewUnder(recyclerView, f, f4);
        if (callbackFindChildViewUnder == null) {
            Logger.m10999d(TAG, "onDrag# target view is null");
            autoScroll(recyclerView, f4);
            return false;
        }
        int index = ((IPageItemView) callbackFindChildViewUnder).getIndex();
        if (index == this.mAniInfo.length - 1) {
            autoScroll(recyclerView, f4);
            return false;
        }
        int i = this.mIndex;
        if (index > i) {
            dragAnimToNextIndex(recyclerView, index);
        } else if (index < i) {
            dragAnimToPrevIndex(recyclerView, index);
        } else {
            dragAnimToSameIndex(recyclerView, f, f4);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(String str) {
        AbstractC8014b.m7196B("release# ", str, TAG);
        if (!this.mIsMoved) {
            cancelAnimations();
            String str2 = this.mPageId;
            if (str2 != null) {
                this.mPresenter.move(str2, str2);
            }
        }
        IPageDragOutAnimator iPageDragOutAnimator = this.mPageDragOutAnimator;
        if (iPageDragOutAnimator != null) {
            iPageDragOutAnimator.release();
            this.mPageDragOutAnimator = null;
        }
        this.mTargetItemPosition.set(0.0f, 0.0f);
        this.mIsMoved = false;
        this.mAniInfo = null;
        this.mPageId = null;
        this.mTargetPageId = null;
        this.mIndex = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void returnAnimation(RecyclerView recyclerView, int i) {
        final RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition == 0) {
            AnimationItemInfo animationItemInfo = this.mAniInfo[i];
            animationItemInfo.isReturnAnimating = false;
            animationItemInfo.isMoveAnimating = false;
            animationItemInfo.isMoved = false;
            return;
        }
        AnimationItemInfo animationItemInfo2 = this.mAniInfo[i];
        if (animationItemInfo2.isReturnAnimating) {
            AbstractC0000a.m3D(i, "returnAnimation# returning ", TAG);
            return;
        }
        if (!animationItemInfo2.isMoved) {
            Logger.m10999d(TAG, "returnAnimation# already");
            return;
        }
        if (animationItemInfo2.isMoveAnimating) {
            AbstractC0000a.m3D(i, "returnAnimation# animating ", TAG);
            this.mAniInfo[i].animatorSet.cancel();
            this.mAniInfo[i].animatorSet = null;
        }
        this.mAniInfo[i].isReturnAnimating = true;
        AbstractC0000a.m3D(i, "returnAnimation# ", TAG);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(viewHolderFindViewHolderForAdapterPosition.itemView.getTranslationX(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                viewHolderFindViewHolderForAdapterPosition.itemView.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(viewHolderFindViewHolderForAdapterPosition.itemView.getTranslationY(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                viewHolderFindViewHolderForAdapterPosition.itemView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        makeAnimatorSet(i, false, valueAnimatorOfFloat, valueAnimatorOfFloat2).start();
        setHolderPageIndex((PageListContract.IPageHolder) viewHolderFindViewHolderForAdapterPosition, i + 1);
        this.mAniInfo[i].isMoved = false;
    }

    private void setHolderPageIndex(PageListContract.IPageHolder iPageHolder, int i) {
        iPageHolder.setPageIndexText(i);
    }

    public void cancelDragAndDrop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            ViewCompat.cancelDragAndDrop(recyclerView);
        }
    }

    public AnimationItemInfo[] getAnimationInfo() {
        return this.mAniInfo;
    }

    public int getDragIndex() {
        return this.mIndex;
    }

    public PageListTopMenuDragListenerImpl getPageListTopMenuDragListener() {
        return this.mPageListTopMenuDragListener;
    }

    public boolean hasDragInfo() {
        return this.mIndex != -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        IPageItemView iPageItemView;
        int index;
        if (!(view instanceof RecyclerView)) {
            return false;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        this.mRecyclerView = recyclerView;
        if (!this.mIsEnable) {
            Logger.m11000e(TAG, "onDrag# mIsEnable is false");
            return false;
        }
        int action = dragEvent.getAction();
        if (action == 1) {
            Logger.m10999d(TAG, "onDrag# start");
            this.mIsMoved = false;
            boolean zInitData = isPageDragEvent(dragEvent) ? initData(recyclerView) : false;
            VoiceAssistantTTS.getInstance().sendTalkBackMessage(view.getContext().getResources().getString(C9086R.string.base_drag_start_at, Integer.valueOf(this.mIndex + 1)));
            return zInitData;
        }
        if (action == 2) {
            Logger.m10999d(TAG, "onDrag# " + dragEvent.getX() + " " + dragEvent.getY());
            if (onDragLocation(recyclerView, dragEvent.getX(), dragEvent.getY())) {
                autoScroll(recyclerView, dragEvent.getY());
            }
            return true;
        }
        if (action == 3) {
            String str = TAG;
            Logger.m10999d(str, "onDrag#drop");
            View viewFindChildViewUnder = findChildViewUnder(recyclerView, dragEvent.getX(), dragEvent.getY());
            if (viewFindChildViewUnder != 0 && (index = (iPageItemView = (IPageItemView) viewFindChildViewUnder).getIndex()) != this.mIndex) {
                this.mIsMoved = true;
                this.mTargetPageId = iPageItemView.getPageId();
                Logger.m10999d(str, "onDrag#drop, move - from/to = " + this.mIndex + "/" + index);
                int[] iArr = new int[2];
                viewFindChildViewUnder.getLocationInWindow(iArr);
                this.mTargetItemPosition.x = ((float) iArr[0]) - viewFindChildViewUnder.getTranslationX();
                this.mTargetItemPosition.y = ((float) iArr[1]) - viewFindChildViewUnder.getTranslationY();
                this.mPageDragOutAnimator.prepareDragOutAnimation(recyclerView, new PointF(dragEvent.getX(), dragEvent.getY()));
                return true;
            }
        } else {
            if (action == 4) {
                AbstractC8014b.m7215q(new StringBuilder("onDrag#ended, isMoved : "), this.mIsMoved, TAG);
                if (this.mIsMoved) {
                    this.mPageDragOutAnimator.startDragOutAnimation(this.mTargetItemPosition, new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PageDragListenerImpl.this.cancelAnimations();
                            PageDragListenerImpl.this.mPresenter.move(PageDragListenerImpl.this.mPageId, PageDragListenerImpl.this.mTargetPageId);
                            PageDragListenerImpl.this.release("DragOut ani");
                        }
                    });
                } else {
                    release("DragEnd");
                }
                return true;
            }
            if (action == 6) {
                Logger.m10999d(TAG, "onDrag#exited");
                return true;
            }
        }
        return false;
    }

    public void setDragInfo(String str, int i, IPageDragOutAnimator iPageDragOutAnimator) {
        this.mPageId = str;
        this.mIndex = i;
        this.mPageDragOutAnimator = iPageDragOutAnimator;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mTimer = new CountDownTimer(500L, 1000L) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                PageDragListenerImpl.this.release("timer");
                PageDragListenerImpl.this.mTimer = null;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void setEnable(boolean z) {
        if (this.mIsEnable && !z) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.cancelDragAndDrop(recyclerView);
            }
            release("setEnable");
        }
        this.mIsEnable = z;
    }
}
