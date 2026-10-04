package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.OverScroller;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.TEAdjustModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.crop.IResourceInjector;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.state.ActionStateModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.zoom.TEZoomModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.IAdjustContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.action.ActionPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.action.FlingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEAdjustPresenter implements ActionPresenter {
    private static final String TAG = CTLogger.createTag("TEAdjustPresenter");
    private FlingPresenter mFlingPresenter;
    private TEAdjustModel mModel;
    private final TEZoomModel.TEZoomObserver mObserver;
    private final PointF mPivot;
    private final ActionStateModel mStateModel;
    protected IAdjustContract.IView mView;
    private final TEZoomModel mZoomModel;

    public TEAdjustPresenter(TEAdjustModel tEAdjustModel) {
        ActionStateModel actionStateModel = new ActionStateModel();
        this.mStateModel = actionStateModel;
        this.mPivot = new PointF();
        TEZoomModel.TEZoomObserver tEZoomObserver = new TEZoomModel.TEZoomObserver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.TEAdjustPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.template.editor.adjust.zoom.TEZoomModel.TEZoomObserver
            public void onScaleChanged() {
                if (TEAdjustPresenter.this.mStateModel.isState(1)) {
                    TEAdjustPresenter.this.mModel.scaleImage(TEAdjustPresenter.this.mPivot.x, TEAdjustPresenter.this.mPivot.y);
                } else {
                    TEAdjustPresenter.this.mModel.scaleImage();
                }
                TEAdjustPresenter.this.updateImageView();
            }
        };
        this.mObserver = tEZoomObserver;
        this.mModel = tEAdjustModel;
        tEAdjustModel.addOpacityListener(new C9884a(this, 0));
        this.mFlingPresenter = new FlingPresenter(this.mModel.getFlingAction(), actionStateModel, this);
        TEZoomModel zoomModel = this.mModel.getZoomModel();
        this.mZoomModel = zoomModel;
        zoomModel.addObserver(tEZoomObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        IAdjustContract.IView iView = this.mView;
        if (iView != null) {
            iView.setOpacity(this.mModel.getOpacity());
        }
    }

    public void apply() {
        Logger.m11003i(TAG, "onApply()");
        Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            this.mModel.applyImage(drawable);
        }
    }

    public void attachView(IAdjustContract.IView iView, IResourceInjector iResourceInjector, OverScroller overScroller) {
        this.mView = iView;
        iView.setImageBitmap(this.mModel.getImage());
        this.mModel.initResource(iResourceInjector);
        this.mFlingPresenter.setOverScroller(overScroller);
    }

    public void close() {
        IAdjustContract.IView iView = this.mView;
        if (iView != null) {
            iView.release();
            this.mView = null;
        }
        this.mFlingPresenter.close();
        this.mFlingPresenter = null;
        this.mModel = null;
        this.mZoomModel.removeObserver(this.mObserver);
    }

    public void draw(Canvas canvas) {
        this.mModel.draw(canvas, !isActionState(0));
    }

    public String getNewPath() {
        return this.mModel.getNewPath();
    }

    public int getOpacity() {
        return this.mModel.getOpacity();
    }

    public int getPageHeight() {
        return this.mModel.getPageHeight();
    }

    public int getPageWidth() {
        return this.mModel.getPageWidth();
    }

    public String getResultPath() {
        return this.mModel.getResultPath();
    }

    public String getTemplateName() {
        return this.mModel.getTemplateName();
    }

    public void initialize(int i, int i2, boolean z) {
        this.mModel.initialize(i, i2, z);
        updateImageView();
    }

    public boolean isActionState(int i) {
        return this.mStateModel.isState(i);
    }

    public boolean isEditable() {
        return !this.mModel.getCropRect().isEmpty();
    }

    public void onActionDown(float f, float f4) {
        this.mFlingPresenter.cancelFling();
        setActionState(2);
        this.mModel.getPanningAction().onActionDown(f, f4);
        updateImageView();
    }

    public void onActionMove(float f, float f4) {
        this.mModel.getPanningAction().onActionMove(f, f4);
        updateImageView();
    }

    public void onActionUp() {
        if (!isActionState(3)) {
            setActionState(0);
        }
        updateImageView();
    }

    public void onFling(float f, float f4) {
        this.mFlingPresenter.onFling(f, f4);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.action.ActionPresenter
    public void postOnAnimation(Runnable runnable) {
        this.mView.postOnAnimation(runnable);
    }

    public void scaleByGesture(float f, float f4, float f5) {
        this.mPivot.set(f4, f5);
        this.mZoomModel.multiplyScale(f);
    }

    public void setActionState(int i) {
        this.mStateModel.setState(i);
    }

    public void setDrawableSize(int i, int i2) {
        this.mModel.setDrawableSize(i, i2);
    }

    public void setTemplateName(String str) {
        this.mModel.setTemplateName(str);
    }

    public void storeEditState() {
        this.mModel.storeEditState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.action.ActionPresenter
    public void updateImageView() {
        IAdjustContract.IView iView = this.mView;
        if (iView != null) {
            iView.setImageMatrix(this.mModel.getMatrix());
        }
    }

    public void updateOpacity(int i) {
        this.mModel.setOpacity(i);
    }

    public boolean updateViewSize(int i, int i2) {
        return this.mModel.updateViewSize(i, i2);
    }
}
