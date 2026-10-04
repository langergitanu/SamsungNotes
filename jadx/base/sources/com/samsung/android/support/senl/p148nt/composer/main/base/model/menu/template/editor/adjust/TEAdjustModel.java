package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Size;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.ActionModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.FlingAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.PanningAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.CropRectPainter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.CropResultBuilder;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.zoom.TEZoomModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image.TEImageModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEAdjustModel implements ActionModel {
    private static final String TAG = CTLogger.createTag("TEAdjustModel");
    private TEImageModel mImageModel;
    private boolean mIsStored;
    private CropRectPainter mPainter;
    private TEZoomModel mZoomModel = new TEZoomModel();
    private FlingAction mFlingAction = new FlingAction(this);
    private PanningAction mPanningAction = new PanningAction(this);
    private final List<OpacityChangedListener> mOpacityListeners = new ArrayList();
    private Size mViewSize = new Size(0, 0);
    private Size mDrawableSize = new Size(0, 0);
    private int mOpacity = 100;
    private int mStoredOpacity = -1;
    private float mStoredDeltaScale = 0.0f;
    private float mStoredTransXRatio = 0.0f;
    private float mStoredTransYRatio = 0.0f;
    private final RectF mCropRect = new RectF();
    private RectF mImageRect = new RectF();
    private final Matrix mMatrix = new Matrix();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OpacityChangedListener {
        void notifyOpacityChanged();
    }

    public TEAdjustModel(TEImageModel tEImageModel) {
        this.mImageModel = tEImageModel;
    }

    private CropResultBuilder createResultBuilder() {
        return new CropResultBuilder().setCenter(getCenterX(), getCenterY()).setMatrix(this.mMatrix).setImageRect(this.mImageRect).setCropRect(this.mCropRect);
    }

    private float getCenterX() {
        return this.mViewSize.getWidth() * 0.5f;
    }

    private float getCenterY() {
        return this.mViewSize.getHeight() * 0.5f;
    }

    private Bitmap getCroppedImage(Drawable drawable) {
        try {
            return createResultBuilder().build(drawable);
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getCroppedImage, e : "), TAG);
            return null;
        }
    }

    private float getDeltaScale() {
        float[] fArr = new float[9];
        this.mMatrix.getValues(fArr);
        return this.mZoomModel.getCurrentScale() / fArr[0];
    }

    private float getInitialScale() {
        return Math.max(this.mCropRect.width() / this.mDrawableSize.getWidth(), this.mCropRect.height() / this.mDrawableSize.getHeight());
    }

    private void initCropRect(int i, int i2) {
        float f = i;
        float f4 = i2;
        float width = this.mViewSize.getWidth() - i;
        float height = this.mViewSize.getHeight() - i2;
        if (f > width) {
            width = 0.0f;
            f = 0.0f;
        }
        if (f4 > height) {
            height = 0.0f;
            f4 = 0.0f;
        }
        this.mCropRect.set(f, f4, width, height);
    }

    private void onMatrixChanged() {
        updateImageRect();
    }

    private void postScale(float f, float f4, float f5, float f6) {
        this.mMatrix.postScale(f, f4, f5, f6);
        onMatrixChanged();
    }

    private void restoreEditState() {
        AbstractC8014b.m7222x(new StringBuilder("restoreEditState, mIsStored = "), this.mIsStored, TAG);
        if (this.mIsStored) {
            TEZoomModel tEZoomModel = this.mZoomModel;
            tEZoomModel.setCurrentScale(tEZoomModel.getMinScale() * this.mStoredDeltaScale);
            setOpacity(this.mStoredOpacity);
            float fWidth = this.mCropRect.width() * this.mStoredTransXRatio;
            float fHeight = this.mCropRect.height() * this.mStoredTransYRatio;
            RectF rectF = this.mCropRect;
            float f = rectF.left - fWidth;
            float f4 = rectF.top - fHeight;
            RectF rectF2 = this.mImageRect;
            postTranslate(f - rectF2.left, f4 - rectF2.top);
            this.mIsStored = false;
        }
    }

    private void translateImageToCropBoundaries() {
        float f = Float.compare(this.mImageRect.right, this.mCropRect.right) < 0 ? this.mCropRect.right - this.mImageRect.right : 0.0f;
        if (Float.compare(this.mImageRect.left, this.mCropRect.left) > 0) {
            f = this.mCropRect.left - this.mImageRect.left;
        }
        float f4 = Float.compare(this.mImageRect.bottom, this.mCropRect.bottom) < 0 ? this.mCropRect.bottom - this.mImageRect.bottom : 0.0f;
        if (Float.compare(this.mImageRect.top, this.mCropRect.top) > 0) {
            f4 = this.mCropRect.top - this.mImageRect.top;
        }
        if (Float.compare(f, 0.0f) == 0 && Float.compare(f4, 0.0f) == 0) {
            return;
        }
        postTranslate(f, f4);
    }

    private void translateInitialImage() {
        postTranslate((this.mViewSize.getWidth() - this.mDrawableSize.getWidth()) * 0.5f, (this.mViewSize.getHeight() - this.mDrawableSize.getHeight()) * 0.5f);
    }

    private void updateImageRect() {
        RectF rectF = new RectF(0.0f, 0.0f, this.mDrawableSize.getWidth(), this.mDrawableSize.getHeight());
        this.mImageRect = rectF;
        this.mMatrix.mapRect(rectF);
    }

    public void addOpacityListener(OpacityChangedListener opacityChangedListener) {
        this.mOpacityListeners.add(opacityChangedListener);
    }

    public void applyImage(Drawable drawable) {
        Bitmap croppedImage = getCroppedImage(drawable);
        if (croppedImage == null) {
            return;
        }
        this.mImageModel.applyImage(croppedImage);
    }

    public float calculateDeltaScale() {
        return this.mZoomModel.getCurrentScale() / this.mZoomModel.getMinScale();
    }

    public float calculateImageXTransRatio() {
        if (this.mCropRect.isEmpty()) {
            return 0.0f;
        }
        RectF rectF = this.mCropRect;
        return (rectF.left - this.mImageRect.left) / rectF.width();
    }

    public float calculateImageYTransRatio() {
        if (this.mCropRect.isEmpty()) {
            return 0.0f;
        }
        RectF rectF = this.mCropRect;
        return (rectF.top - this.mImageRect.top) / rectF.height();
    }

    public void close() {
        this.mOpacityListeners.clear();
        this.mFlingAction = null;
        this.mPanningAction = null;
        this.mImageModel = null;
        this.mZoomModel = null;
    }

    public void draw(Canvas canvas, boolean z) {
        this.mPainter.drawBorders(canvas, this.mCropRect);
        this.mPainter.drawTrimArea(canvas, this.mCropRect, this.mImageRect, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.ActionModel
    public RectF getCropRect() {
        return this.mCropRect;
    }

    public FlingAction getFlingAction() {
        return this.mFlingAction;
    }

    public Bitmap getImage() {
        return this.mImageModel.getBitmap();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.ActionModel
    public RectF getImageRect() {
        return this.mImageRect;
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public String getNewPath() {
        return this.mImageModel.getNewPath();
    }

    public int getOpacity() {
        return this.mOpacity;
    }

    public int getPageHeight() {
        return this.mImageModel.getPageHeight();
    }

    public int getPageWidth() {
        return this.mImageModel.getPageWidth();
    }

    public PanningAction getPanningAction() {
        return this.mPanningAction;
    }

    public String getResultPath() {
        return this.mImageModel.getResultPath();
    }

    public String getTemplateName() {
        return this.mImageModel.getTemplateName();
    }

    public TEZoomModel getZoomModel() {
        return this.mZoomModel;
    }

    public void initResource(IResourceInjector iResourceInjector) {
        this.mPainter = new CropRectPainter(iResourceInjector);
    }

    public void initialize(int i, int i2, boolean z) {
        initCropRect(i, i2);
        if (z) {
            translateImageToCropBoundaries();
        } else {
            translateInitialImage();
        }
        this.mZoomModel.setScales(getInitialScale());
        restoreEditState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.ActionModel
    public void postTranslate(float f, float f4) {
        this.mMatrix.postTranslate(f, f4);
        onMatrixChanged();
    }

    public void scaleImage() {
        scaleImage(this.mImageRect.centerX(), this.mImageRect.centerY());
    }

    public void setDrawableSize(int i, int i2) {
        this.mDrawableSize = new Size(i, i2);
    }

    public void setOpacity(int i) {
        if (this.mOpacity != i) {
            this.mOpacity = i;
            Iterator<OpacityChangedListener> it = this.mOpacityListeners.iterator();
            while (it.hasNext()) {
                it.next().notifyOpacityChanged();
            }
        }
    }

    public void setTemplateName(String str) {
        this.mImageModel.setTemplateName(str);
    }

    public void storeEditState() {
        storeEditState(calculateDeltaScale(), this.mOpacity, calculateImageXTransRatio(), calculateImageYTransRatio());
    }

    public boolean updateViewSize(int i, int i2) {
        if (this.mViewSize.getWidth() == i && this.mViewSize.getHeight() == i2) {
            return false;
        }
        this.mViewSize = new Size(i, i2);
        return true;
    }

    public void scaleImage(float f, float f4) {
        float deltaScale = getDeltaScale();
        postScale(deltaScale, deltaScale, f, f4);
        translateImageToCropBoundaries();
    }

    public void storeEditState(float f, int i, float f4, float f5) {
        this.mStoredDeltaScale = f;
        this.mStoredOpacity = i;
        this.mStoredTransXRatio = f4;
        this.mStoredTransYRatio = f5;
        this.mIsStored = true;
        String str = TAG;
        StringBuilder sb = new StringBuilder("storeEditState, deltaScale/opacity = ");
        sb.append(this.mStoredDeltaScale);
        sb.append("/");
        AbstractC8014b.m7195A(sb, str, this.mStoredOpacity);
    }
}
