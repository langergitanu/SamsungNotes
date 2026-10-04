package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.adjust;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.OverScroller;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.IContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.TEAdjustPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEAdjustView extends ImageView implements IAdjustContract.IView {
    private static final float CONVERT_TO_ALPHA = 2.55f;
    private static final float CONVERT_TO_PROGRESS_OPACITY = 0.9f;
    private static final int MIN_OPACITY = 10;
    private static final String TAG = CTLogger.createTag("TEAdjustView");
    private static final long ZOOM_ACTION_DELAY = 50;
    private TEAdjustPresenter mAdjustPresenter;
    private GestureDetector mGestureDetector;
    private boolean mIsInitialized;
    private IContract.IView mParentView;
    private ScaleGestureDetector mScaleDetector;
    private float pageHeight;
    private float pageWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public /* synthetic */ GestureListener(TEAdjustView tEAdjustView, int i) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
            if (TEAdjustView.this.mAdjustPresenter == null) {
                return false;
            }
            TEAdjustView.this.mAdjustPresenter.onFling(f, f4);
            return false;
        }

        private GestureListener() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public /* synthetic */ ScaleListener(TEAdjustView tEAdjustView, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScaleEnd$0() {
            if (TEAdjustView.this.mAdjustPresenter == null || !TEAdjustView.this.mAdjustPresenter.isActionState(1)) {
                return;
            }
            TEAdjustView.this.mAdjustPresenter.setActionState(0);
            TEAdjustView.this.mAdjustPresenter.updateImageView();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TEAdjustView.this.mAdjustPresenter.scaleByGesture(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TEAdjustView.this.mAdjustPresenter.setActionState(1);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TEAdjustView.this.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.adjust.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7184a.lambda$onScaleEnd$0();
                }
            }, 50L);
        }

        private ScaleListener() {
        }
    }

    public TEAdjustView(Context context) {
        super(context);
        this.pageWidth = 210.0f;
        this.pageHeight = 297.0f;
        this.mIsInitialized = false;
    }

    private Size caculateMargins(int i, int i2) {
        Size initialMargins = getInitialMargins();
        float fMin = Math.min((i - (initialMargins.getWidth() * 2)) / this.pageWidth, (i2 - (initialMargins.getHeight() * 2)) / this.pageHeight);
        int i4 = (int) ((i - (this.pageWidth * fMin)) / 2.0f);
        int i5 = (int) ((i2 - (this.pageHeight * fMin)) / 2.0f);
        Logger.m11003i(TAG, "caculateMargins(), horizMargin : " + i4 + ", vertMargin : " + i5);
        return new Size(i4, i5);
    }

    private Size getInitialMargins() {
        int dimensionPixelOffset;
        boolean zIsMultiWindowMode = this.mParentView.isMultiWindowMode();
        int dimensionPixelOffset2 = 0;
        boolean z = getResources().getConfiguration().orientation == 1;
        boolean zIsTabletModel = DeviceUtils.isTabletModel();
        if (!z) {
            int dimensionPixelOffset3 = zIsTabletModel ? getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_tablet_land_crop_vert_margin) : getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_land_crop_vert_margin);
            if (zIsMultiWindowMode) {
                dimensionPixelOffset = dimensionPixelOffset3;
                dimensionPixelOffset2 = dimensionPixelOffset;
            } else {
                dimensionPixelOffset = dimensionPixelOffset3;
            }
        } else if (zIsTabletModel) {
            if (zIsMultiWindowMode) {
                dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_tablet_port_popup_window_crop_vert_margin);
                dimensionPixelOffset = dimensionPixelOffset2;
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_tablet_port_crop_vert_margin);
            }
        } else if (zIsMultiWindowMode) {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_port_popup_window_crop_vert_margin);
            dimensionPixelOffset = dimensionPixelOffset2;
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(C9086R.dimen.template_editor_port_crop_vert_margin);
        }
        Logger.m11003i(TAG, "getInitialMargins, horiz/vert = " + dimensionPixelOffset2 + "/" + dimensionPixelOffset);
        return new Size(dimensionPixelOffset2, dimensionPixelOffset);
    }

    public boolean isEditable() {
        TEAdjustPresenter tEAdjustPresenter = this.mAdjustPresenter;
        return tEAdjustPresenter != null && tEAdjustPresenter.isEditable();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        TEAdjustPresenter tEAdjustPresenter;
        if (this.mIsInitialized && (tEAdjustPresenter = this.mAdjustPresenter) != null && tEAdjustPresenter.isEditable()) {
            super.onDraw(canvas);
            this.mAdjustPresenter.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        TEAdjustPresenter tEAdjustPresenter = this.mAdjustPresenter;
        if (tEAdjustPresenter == null || !tEAdjustPresenter.updateViewSize(i, i2)) {
            return;
        }
        if (this.mIsInitialized) {
            this.mAdjustPresenter.storeEditState();
        }
        Size sizeCaculateMargins = caculateMargins(i, i2);
        this.mAdjustPresenter.initialize(sizeCaculateMargins.getWidth(), sizeCaculateMargins.getHeight(), this.mIsInitialized);
        this.mIsInitialized = true;
        AbstractC14516b.m15114b(i, i2, "onSizeChanged, width : ", ", height : ", TAG);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mAdjustPresenter == null) {
            return false;
        }
        this.mScaleDetector.onTouchEvent(motionEvent);
        if (!this.mAdjustPresenter.isActionState(1)) {
            this.mGestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mAdjustPresenter.onActionDown(motionEvent.getX(), motionEvent.getY());
            } else if (action == 1) {
                this.mAdjustPresenter.onActionUp();
            } else if (action != 2) {
                if (action == 3) {
                }
            } else if (this.mAdjustPresenter.isActionState(2)) {
                this.mAdjustPresenter.onActionMove(motionEvent.getX(), motionEvent.getY());
            } else {
                this.mAdjustPresenter.onActionDown(motionEvent.getX(), motionEvent.getY());
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract.IView
    public void release() {
        Logger.m11003i(TAG, "release()");
        super.setImageBitmap(null);
        this.mScaleDetector = null;
        this.mGestureDetector = null;
        this.mAdjustPresenter = null;
        this.mParentView = null;
    }

    @Override // android.widget.ImageView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract.IView
    public void setImageBitmap(Bitmap bitmap) {
        Drawable drawable;
        super.setImageBitmap(bitmap);
        if (this.mAdjustPresenter == null || (drawable = getDrawable()) == null) {
            return;
        }
        this.mAdjustPresenter.setDrawableSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    @Override // android.widget.ImageView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract.IView
    public void setImageMatrix(Matrix matrix) {
        if (matrix != null) {
            super.setImageMatrix(matrix);
        }
        invalidate();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract.IView
    public void setOpacity(int i) {
        getDrawable().setAlpha((int) AbstractC0622a.m1152B(i, 0.9f, 10.0f, CONVERT_TO_ALPHA));
    }

    public void setPresenter(TEAdjustPresenter tEAdjustPresenter, IContract.IView iView) {
        this.mAdjustPresenter = tEAdjustPresenter;
        if (tEAdjustPresenter.getPageWidth() != 0) {
            this.pageWidth = this.mAdjustPresenter.getPageWidth();
            this.pageHeight = this.mAdjustPresenter.getPageHeight();
        }
        this.mAdjustPresenter.attachView(this, new ResourceInjector(getResources()), new OverScroller(getContext()));
        int i = 0;
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener(this, i));
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener(this, i));
        this.mParentView = iView;
    }

    public TEAdjustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pageWidth = 210.0f;
        this.pageHeight = 297.0f;
        this.mIsInitialized = false;
    }

    public TEAdjustView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageWidth = 210.0f;
        this.pageHeight = 297.0f;
        this.mIsInitialized = false;
    }
}
