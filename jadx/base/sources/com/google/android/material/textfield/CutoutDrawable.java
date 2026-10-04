package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    CutoutDrawableState drawableState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImplApi14 extends CutoutDrawable {
        private Paint cutoutPaint;
        private int savedLayer;

        public ImplApi14(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        private Paint getCutoutPaint() {
            if (this.cutoutPaint == null) {
                Paint paint = new Paint(1);
                this.cutoutPaint = paint;
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.cutoutPaint.setColor(-1);
                this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
            return this.cutoutPaint;
        }

        private void postDraw(@NonNull Canvas canvas) {
            if (useHardwareLayer(getCallback())) {
                return;
            }
            canvas.restoreToCount(this.savedLayer);
        }

        private void preDraw(@NonNull Canvas canvas) {
            Drawable.Callback callback = getCallback();
            if (!useHardwareLayer(callback)) {
                saveCanvasLayer(canvas);
                return;
            }
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        }

        private void saveCanvasLayer(@NonNull Canvas canvas) {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }

        private boolean useHardwareLayer(Drawable.Callback callback) {
            return callback instanceof View;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            preDraw(canvas);
            super.draw(canvas);
            postDraw(canvas);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(@NonNull Canvas canvas) {
            super.drawStrokeShape(canvas);
            canvas.drawRect(((CutoutDrawable) this).drawableState.cutoutBounds, getCutoutPaint());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @TargetApi(18)
    public static class ImplApi18 extends CutoutDrawable {
        public ImplApi18(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(@NonNull Canvas canvas) {
            if (((CutoutDrawable) this).drawableState.cutoutBounds.isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(((CutoutDrawable) this).drawableState.cutoutBounds);
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    public static CutoutDrawable create(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel == null) {
            shapeAppearanceModel = new ShapeAppearanceModel();
        }
        return create(new CutoutDrawableState(shapeAppearanceModel, new RectF()));
    }

    public boolean hasCutout() {
        return !this.drawableState.cutoutBounds.isEmpty();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState);
        return this;
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f, float f4, float f5, float f6) {
        if (f == this.drawableState.cutoutBounds.left && f4 == this.drawableState.cutoutBounds.top && f5 == this.drawableState.cutoutBounds.right && f6 == this.drawableState.cutoutBounds.bottom) {
            return;
        }
        this.drawableState.cutoutBounds.set(f, f4, f5, f6);
        invalidateSelf();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {

        @NonNull
        private final RectF cutoutBounds;

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            CutoutDrawable cutoutDrawableCreate = CutoutDrawable.create(this);
            cutoutDrawableCreate.invalidateSelf();
            return cutoutDrawableCreate;
        }

        private CutoutDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
            super(shapeAppearanceModel, null);
            this.cutoutBounds = rectF;
        }

        private CutoutDrawableState(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.cutoutBounds = cutoutDrawableState.cutoutBounds;
        }
    }

    private CutoutDrawable(@NonNull CutoutDrawableState cutoutDrawableState) {
        super(cutoutDrawableState);
        this.drawableState = cutoutDrawableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CutoutDrawable create(@NonNull CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    public void setCutout(@NonNull RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
