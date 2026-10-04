package com.samsung.android.support.senl.p148nt.composer.main.simple.view;

import android.view.ViewGroup;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PagePanInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ScrollZoomManager;
import com.samsung.android.support.senl.p148nt.composer.main.compare.presenter.CompareViewerContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ScrollZoomManagerAdapter {
    private static final String TAG = Logger.createTag("ScrollZoomManagerAdapter", SimpleComposerConstant.TAG_PREFIX);
    private CompareViewerContract.IPresenter mCompareMainPresenter;
    private final ComposerViewState mComposerViewState;
    private final ScrollZoomManager mScrollZoomManager;
    private SimpleComposerViewPresenter mSimpleComposerViewPresenter;
    private String mTag;
    private SpenComposer mView;

    public ScrollZoomManagerAdapter(ComposerViewState composerViewState) {
        this.mComposerViewState = composerViewState;
        this.mScrollZoomManager = new ScrollZoomManager(composerViewState);
    }

    public void init(final SpenComposer spenComposer, SpenWNote spenWNote, SimpleComposerViewPresenter simpleComposerViewPresenter) {
        this.mView = spenComposer;
        this.mSimpleComposerViewPresenter = simpleComposerViewPresenter;
        this.mScrollZoomManager.onChangedPageLayout();
        this.mScrollZoomManager.init(spenComposer, spenWNote, new ScrollZoomManager.IComposerPresenter() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.ScrollZoomManagerAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public ComposerModel getComposerModel() {
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public boolean isCtrlPressedLast() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public boolean isScrollingEnabled() {
                if (ScrollZoomManagerAdapter.this.mView != null) {
                    return !ScrollZoomManagerAdapter.this.mView.getGestureController().isOnFingerScrollAndScaleLocked();
                }
                return true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IComposerPresenter
            public void onScroll(PagePanInfo pagePanInfo, float f, int i) {
                if (ScrollZoomManagerAdapter.this.mCompareMainPresenter != null && ScrollZoomManagerAdapter.this.mTag != null) {
                    ScrollZoomManagerAdapter.this.mCompareMainPresenter.onScrollChanged(pagePanInfo.getContentPanY(), ScrollZoomManagerAdapter.this.mTag);
                }
                ScrollZoomManagerAdapter.this.mSimpleComposerViewPresenter.getSCVScrollZoomController().onScroll(pagePanInfo, f);
            }
        }, new ScrollZoomManager.IListenerManager() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.ScrollZoomManagerAdapter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void addNoteZoomScrollerListener(final SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
                spenComposer.getNoteZoomScroller().setNoteZoomScrollerListener(new SpenNoteZoomScrollerListener() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.ScrollZoomManagerAdapter.2.2
                    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
                    public void onScrollLockChanged(boolean z) {
                        spenNoteZoomScrollerListener.onScrollLockChanged(z);
                    }

                    @Override // com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScrollerListener
                    public void onZoomLockChanged(boolean z) {
                        spenNoteZoomScrollerListener.onScrollLockChanged(z);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void addZoomListener(final SpenZoomListenerImpl.ZoomListener zoomListener) {
                spenComposer.getNoteZoomScroller().setZoomListener(new SpenZoomListener() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.ScrollZoomManagerAdapter.2.1
                    @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener
                    public void onZoom(float f, float f4, float f5, float f6, float f7) {
                        zoomListener.onZoom(f, f4, f5, f6, f7);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IListenerManager
            public void removeNoteZoomScrollerListener(SpenNoteZoomScrollerListener spenNoteZoomScrollerListener) {
                spenComposer.getNoteZoomScroller().setNoteZoomScrollerListener(null);
            }
        }, new ScrollZoomManager.IGotoTopPresenter() { // from class: com.samsung.android.support.senl.nt.composer.main.simple.view.ScrollZoomManagerAdapter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ScrollZoomManager.IGotoTopPresenter
            public boolean canUpdate() {
                return true;
            }
        });
        this.mComposerViewState.updatePageCount(spenWNote.getPageCount());
        this.mScrollZoomManager.setOnGenericMotionListener(this.mView.getContext());
    }

    public void onAttachedView(ViewGroup viewGroup) {
        this.mScrollZoomManager.onAttachedView(viewGroup);
    }

    public void release() {
        this.mView.getNoteZoomScroller().setZoomListener(null);
        this.mScrollZoomManager.release();
    }

    public void setCompareMainPresenter(CompareViewerContract.IPresenter iPresenter, String str) {
        this.mCompareMainPresenter = iPresenter;
        this.mTag = str;
    }
}
