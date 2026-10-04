package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.zoom;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.zoom.TEZoomModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TEZoomPresenter {
    private TEZoomModel mModel;
    private TEZoomModel.TEZoomObserver mObserver;
    private IZoomMenuView mView;

    public TEZoomPresenter(TEZoomModel tEZoomModel) {
        TEZoomModel.TEZoomObserver tEZoomObserver = new TEZoomModel.TEZoomObserver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.adjust.zoom.TEZoomPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.template.editor.adjust.zoom.TEZoomModel.TEZoomObserver
            public void onScaleChanged() {
                if (TEZoomPresenter.this.mView != null) {
                    TEZoomPresenter.this.mView.update(Float.compare(TEZoomPresenter.this.mModel.getCurrentScale(), TEZoomPresenter.this.mModel.getMaxScale()) < 0, Float.compare(TEZoomPresenter.this.mModel.getCurrentScale(), TEZoomPresenter.this.mModel.getMinScale()) > 0);
                }
            }
        };
        this.mObserver = tEZoomObserver;
        this.mModel = tEZoomModel;
        tEZoomModel.addObserver(tEZoomObserver);
    }

    public void attachView(IZoomMenuView iZoomMenuView) {
        this.mView = iZoomMenuView;
    }

    public void close() {
        this.mView = null;
        this.mModel.removeObserver(this.mObserver);
        this.mModel = null;
    }

    public void scrollZoom(boolean z) {
        if (z) {
            zoomIn();
        } else {
            zoomOut();
        }
    }

    public void zoomIn() {
        this.mModel.multiplyScale(1.3f);
    }

    public void zoomOut() {
        this.mModel.multiplyScale(0.7f);
    }
}
