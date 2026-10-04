package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut90;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageReorderAnimator implements PageDragListenerImpl.IPageDragOutAnimator {
    private static final int PAGE_REORDER_ANIM_DURATION = 200;
    private static final String POS_X_PROPERTY_NAME = "positionX";
    private static final String POS_Y_PROPERTY_NAME = "positionY";
    private static final float SCALE_FACTOR = 1.2f;
    private static final String SCALE_PROPERTY_NAME = "scale";
    private static final String TAG = Logger.createTag("PageReorderAnimator");
    private ViewGroup mAnimRootView;
    private ImageView mAnimationView;
    private boolean mNoAnimationFlag;
    private int mThumbnailDeltaX;
    private int mThumbnailDeltaY;
    private int mThumbnailParentHeight;
    private int mThumbnailParentWidth;
    private final Point mRootLocation = new Point();
    private final PointF mPositionFactor = new PointF();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageDragShadowBuilder extends View.DragShadowBuilder {
        private final PointF mPositionFactor;
        private float mScaleFactor;

        public PageDragShadowBuilder(View view, PointF pointF, boolean z) {
            super(view);
            this.mScaleFactor = 1.2f;
            this.mPositionFactor = pointF;
            if (z) {
                this.mScaleFactor = 1.0f;
            }
        }

        @Override // android.view.View.DragShadowBuilder
        public void onDrawShadow(Canvas canvas) {
            float f = this.mScaleFactor;
            canvas.scale(f, f);
            getView().draw(canvas);
        }

        @Override // android.view.View.DragShadowBuilder
        public void onProvideShadowMetrics(Point point, Point point2) {
            point.set((int) (getView().getWidth() * this.mScaleFactor), (int) (getView().getHeight() * this.mScaleFactor));
            float f = point.x;
            PointF pointF = this.mPositionFactor;
            point2.set((int) (f * pointF.x), (int) (point.y * pointF.y));
        }
    }

    public PageReorderAnimator(PageHolder pageHolder, ViewGroup viewGroup) {
        this.mAnimRootView = viewGroup;
        initAnimationView(pageHolder);
    }

    private void calculateThumbnailDeltaXY(ImageView imageView, View view) {
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        this.mThumbnailDeltaX = iArr[0] - iArr2[0];
        this.mThumbnailDeltaY = iArr[1] - iArr2[1];
    }

    private Bitmap createNewBitmapDrawable(View view, Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            intrinsicWidth = view.getWidth();
            intrinsicHeight = view.getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void initAnimationView(PageHolder pageHolder) {
        ImageView thumbnailView = pageHolder.getThumbnailView();
        setThumbnailParentSize(thumbnailView);
        calculateThumbnailDeltaXY(thumbnailView, pageHolder.itemView);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(thumbnailView.getWidth(), thumbnailView.getHeight());
        ImageView imageView = new ImageView(thumbnailView.getContext());
        this.mAnimationView = imageView;
        imageView.setImageBitmap(createNewBitmapDrawable(pageHolder.itemView, thumbnailView.getDrawable()));
        this.mAnimationView.setScaleType(thumbnailView.getScaleType());
        this.mAnimationView.setLayoutParams(layoutParams);
    }

    private void setThumbnailParentSize(ImageView imageView) {
        View view = (View) imageView.getParent();
        this.mThumbnailParentWidth = view.getWidth();
        this.mThumbnailParentHeight = view.getHeight();
    }

    public void prepareDragInAnimation(View view, PointF pointF) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Point point = new Point(iArr[0], iArr[1]);
        String str = TAG;
        Logger.m11003i(str, "prepareDragInAnimation#, target thumbnail location = " + point);
        this.mAnimRootView.getLocationInWindow(iArr);
        this.mRootLocation.set(iArr[0], iArr[1]);
        Logger.m11003i(str, "prepareDragInAnimation#, rootview location : " + this.mRootLocation.toString());
        this.mAnimationView.setX((float) (point.x - this.mRootLocation.x));
        this.mAnimationView.setY((float) (point.y - this.mRootLocation.y));
        Logger.m11003i(str, "prepareDragInAnimation#, animation view location : " + this.mAnimationView.getX() + "/" + this.mAnimationView.getY());
        this.mAnimationView.setPivotX(pointF.x);
        this.mAnimationView.setPivotY(pointF.y);
        this.mAnimRootView.addView(this.mAnimationView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPageDragOutAnimator
    public void prepareDragOutAnimation(RecyclerView recyclerView, PointF pointF) {
        String str = TAG;
        Logger.m11003i(str, "prepareDragOutAnimation#, lastTouchPos : " + pointF.toString());
        int[] iArr = new int[2];
        recyclerView.getLocationInWindow(iArr);
        Point point = new Point(iArr[0], iArr[1]);
        Logger.m11003i(str, "prepareDragOutAnimation#, recyclerView position : " + point);
        float f = point.x - this.mRootLocation.x;
        float f4 = pointF.x;
        float f5 = this.mThumbnailParentWidth;
        PointF pointF2 = this.mPositionFactor;
        float f6 = (f4 - (f5 * pointF2.x)) + f;
        float f7 = (pointF.y - (this.mThumbnailParentHeight * pointF2.y)) + (point.y - r2.y);
        Logger.m11003i(str, "prepareDragOutAnimation#, shadowPosition : " + f6 + " / " + f7);
        this.mAnimationView.setX(f6);
        this.mAnimationView.setY(f7);
        this.mAnimRootView.addView(this.mAnimationView);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPageDragOutAnimator
    public void release() {
        this.mAnimationView.setImageBitmap(null);
        this.mAnimationView = null;
        this.mAnimRootView = null;
    }

    public void startDrag(View view, PointF pointF, int i) {
        View view2;
        this.mPositionFactor.set(pointF);
        ClipData clipDataNewPlainText = ClipData.newPlainText("Page_Thumbnail", String.valueOf(i));
        try {
            view2 = view;
            try {
                ViewCompat.getInstance().startDragAndDrop(view2, clipDataNewPlainText, new PageDragShadowBuilder(this.mAnimationView, this.mPositionFactor, this.mNoAnimationFlag), null, 0);
            } catch (IllegalStateException e) {
                e = e;
                IllegalStateException illegalStateException = e;
                Logger.m11000e(TAG, "startDrag# " + illegalStateException.getMessage());
                ViewCompat.getInstance().startDragAndDrop(view2, clipDataNewPlainText, new View.DragShadowBuilder(view2.findViewById(C9086R.id.pages_item_thumbnail)), null, 0);
            }
        } catch (IllegalStateException e2) {
            e = e2;
            view2 = view;
        }
    }

    public void startDragInAnimation(View view, PointF pointF, final IListener iListener) {
        this.mNoAnimationFlag = false;
        prepareDragInAnimation(view, pointF);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new SineInOut90());
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                iListener.onAnimationEnd();
                if (PageReorderAnimator.this.mAnimRootView == null) {
                    return;
                }
                PageReorderAnimator.this.mAnimRootView.removeView(PageReorderAnimator.this.mAnimationView);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                iListener.onAnimationStart();
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (PageReorderAnimator.this.mAnimationView == null) {
                    return;
                }
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PageReorderAnimator.this.mAnimationView.setScaleX(fFloatValue);
                PageReorderAnimator.this.mAnimationView.setScaleY(fFloatValue);
            }
        });
        valueAnimatorOfFloat.start();
    }

    public void startDragInNoAnimation(View view, PointF pointF) {
        this.mNoAnimationFlag = true;
        if (this.mAnimRootView != null) {
            prepareDragInAnimation(view, pointF);
            this.mAnimRootView.removeView(this.mAnimationView);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPageDragOutAnimator
    public void startDragOutAnimation(PointF pointF, final AnimatorListenerAdapter animatorListenerAdapter) {
        String str = TAG;
        Logger.m11003i(str, "startDragOutAnimation#, mThumbnailDeltaX/Y : " + this.mThumbnailDeltaX + " / " + this.mThumbnailDeltaY);
        PointF pointF2 = new PointF(pointF.x + ((float) this.mThumbnailDeltaX), pointF.y + ((float) this.mThumbnailDeltaY));
        StringBuilder sb = new StringBuilder("startDragOutAnimation#, thumbnailPosition : ");
        sb.append(pointF2);
        Logger.m11003i(str, sb.toString());
        PointF pointF3 = new PointF(this.mAnimationView.getX(), this.mAnimationView.getY());
        float f = pointF2.x;
        Point point = this.mRootLocation;
        PointF pointF4 = new PointF(f - point.x, pointF2.y - point.y);
        Logger.m11003i(str, "startDragOutAnimation#, endPos : " + pointF4);
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("scale", this.mNoAnimationFlag ? 1.0f : 1.2f, 1.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat(POS_X_PROPERTY_NAME, pointF3.x, pointF4.x);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat(POS_Y_PROPERTY_NAME, pointF3.y, pointF4.y);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3);
        valueAnimator.setDuration(200L);
        valueAnimator.setInterpolator(new SineInOut90());
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PageReorderAnimator.this.mAnimRootView != null) {
                    PageReorderAnimator.this.mAnimRootView.removeView(PageReorderAnimator.this.mAnimationView);
                }
                animatorListenerAdapter.onAnimationEnd(null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                animatorListenerAdapter.onAnimationStart(null);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageReorderAnimator.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (PageReorderAnimator.this.mAnimationView == null) {
                    return;
                }
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue("scale")).floatValue();
                float fFloatValue2 = ((Float) valueAnimator2.getAnimatedValue(PageReorderAnimator.POS_X_PROPERTY_NAME)).floatValue();
                float fFloatValue3 = ((Float) valueAnimator2.getAnimatedValue(PageReorderAnimator.POS_Y_PROPERTY_NAME)).floatValue();
                PageReorderAnimator.this.mAnimationView.setScaleX(fFloatValue);
                PageReorderAnimator.this.mAnimationView.setScaleY(fFloatValue);
                PageReorderAnimator.this.mAnimationView.setX(fFloatValue2);
                PageReorderAnimator.this.mAnimationView.setY(fFloatValue3);
            }
        });
        valueAnimator.start();
    }
}
