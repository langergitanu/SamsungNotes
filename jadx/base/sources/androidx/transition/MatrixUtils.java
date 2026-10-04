package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f, float f4, float f5) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f4, float f5, float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f, float f4, float f5) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f4, float f5, float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f4, float f5, float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f4, float f5, float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f, float f4) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f, float f4) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f, float f4) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
