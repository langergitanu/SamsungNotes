package com.samsung.android.support.senl.p148nt.app.main.common.view.pinchzoom;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ScaleHelper {
    static final float MAX_SCALE = 2.0f;
    static final float MIN_SCALE = 1.0f;
    private final IPresenter mPresenter;
    private Scale mScale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DownScale implements Scale {
        private float mScale = 1.0f;

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public float getScale() {
            return 1.0f - this.mScale;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public int getType() {
            return 1;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public void updateScale(float f) {
            float f4 = this.mScale * f;
            this.mScale = f4;
            if (f4 > 1.0f) {
                this.mScale = 1.0f;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void onScaleChanged(Scale scale);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Scale {
        public static final int TYPE_SCALE_DOWN = 1;
        public static final int TYPE_SCALE_UP = 0;

        float getScale();

        int getType();

        void updateScale(float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UpScale implements Scale {
        private float mScale = 1.0f;

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public float getScale() {
            return this.mScale - 1.0f;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public int getType() {
            return 0;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.view.pinchzoom.ScaleHelper.Scale
        public void updateScale(float f) {
            float f4 = this.mScale * f;
            this.mScale = f4;
            if (f4 > 2.0f) {
                this.mScale = 2.0f;
            }
            if (this.mScale < 1.0f) {
                this.mScale = 1.0f;
            }
        }
    }

    public ScaleHelper(IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    private Scale getScale(float f) {
        return f > 1.0f ? new UpScale() : f < 1.0f ? new DownScale() : this.mScale;
    }

    public void onScale(float f) {
        Scale scale = this.mScale;
        if (scale == null) {
            this.mScale = getScale(f);
        } else {
            scale.updateScale(f);
            this.mPresenter.onScaleChanged(this.mScale);
        }
    }

    public void reset() {
        this.mScale = null;
    }
}
