package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.view.View;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.composer.listener.SpenDialogActionListener;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.composer.listener.SpenPageLayoutListener;
import com.samsung.android.sdk.composer.listener.SpenStrokeShapeListener;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ContextMenuListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectSpanListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.PageActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenAnalyticsListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenNoteDeltaZoomAdapterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenSTTListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenToastActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ThumbnailChangeListenerImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ListenerManager implements ListenerImplContract.IViewListenerManager {
    private final AnimationViewManager mAnimationViewManager;
    protected SpenComposer mView;

    public ListenerManager(SpenComposer spenComposer, AnimationViewManager animationViewManager) {
        this.mAnimationViewManager = animationViewManager;
        this.mView = spenComposer;
    }

    public void release() {
        setSoftInputListener(null);
        setCursorChangedListener(null);
        setPageActionListener(null);
        setThumbnailChangedListener(null);
        setContextMenuListener(null);
        setActionListener(null);
        setPreTouchListener(null);
        setZoomListener(null);
        setDialogActionListener(null);
        setObjectSelectListener(null);
        setSpenTextManagerActionListener(null);
        setControlObjectListener(null);
        setObjectSpanControlObjectListener(null);
        setSpenConvertToTextListener(null);
        setSpenAnalyticsListener(null);
        setSpenAlignmentListener(null);
        setSpenSTTListener(null);
        setOnDragListener(null);
        setOnFocusChangeListener(null);
        setOnKeyListener(null);
        setNoteZoomScrollerListener(null);
        setSpenGestureControllerListener(null);
        setPageLayoutListener(null);
        setStrokeShapeListener(null);
        setTextEventListener(null);
        this.mView = null;
        this.mAnimationViewManager.release();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setActionListener(ActionListenerImpl actionListenerImpl) {
        if (this.mView != null) {
            SpenComposerActionListenerMiddle spenComposerActionListenerMiddle = new SpenComposerActionListenerMiddle(this.mAnimationViewManager);
            spenComposerActionListenerMiddle.setListenerImpl(actionListenerImpl);
            this.mView.getListenerManager().setComposerActionListener(spenComposerActionListenerMiddle);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setContextMenuDelegateListener(SpenContextMenuDelegateListener spenContextMenuDelegateListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setContextMenuDelegateListener(spenContextMenuDelegateListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setContextMenuListener(ContextMenuListenerImpl contextMenuListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setContextMenuListener(contextMenuListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setControlObjectListener(ControlObjectListenerImpl controlObjectListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getControlObjectManager().setObjectListener(controlObjectListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setCursorChangedListener(CursorChangedListenerImpl cursorChangedListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getTextManager().setCursorChangedListener(cursorChangedListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setDialogActionListener(SpenDialogActionListener spenDialogActionListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setDialogActionListener(spenDialogActionListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setNoteWritingToastListener(SpenToastActionListenerImpl spenToastActionListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteWritingViewManager().setToastActionListener(spenToastActionListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setNoteZoomScrollerListener(SpenNoteDeltaZoomAdapterImpl spenNoteDeltaZoomAdapterImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteZoomScroller().setNoteZoomScrollerListener(spenNoteDeltaZoomAdapterImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setObjectSelectListener(SpenObjectSelectListener spenObjectSelectListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setObjectSelectListener(spenObjectSelectListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setObjectSpanControlObjectListener(ControlObjectSpanListenerImpl controlObjectSpanListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getTextManager().setControlObjectListener(controlObjectSpanListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setOnDragListener(OnDragListenerImpl onDragListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.setOnDragListener(onDragListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.setOnKeyListener(onKeyListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setPageActionListener(PageActionListenerImpl pageActionListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setPageActionListener(pageActionListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setPageLayoutListener(SpenPageLayoutListener spenPageLayoutListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setPageLayoutListener(spenPageLayoutListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setPreTouchListener(SpenPreTouchListenerImpl spenPreTouchListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setPreTouchListener(spenPreTouchListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSoftInputListener(SoftInputListenerImpl softInputListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getTextManager().setSoftInputListener(softInputListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenAlignmentListener(SpenAlignmentListenerImpl spenAlignmentListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getAlignmentManager().setListener(spenAlignmentListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenAnalyticsListener(SpenAnalyticsListenerImpl spenAnalyticsListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setLoggingListener(spenAnalyticsListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenConvertToTextListener(SpenConvertToTextListenerImpl spenConvertToTextListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getConvertToTextManager().setRecognitionListener(spenConvertToTextListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenGestureControllerListener(SpenGestureControllerImpl spenGestureControllerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getGestureController().setListener(spenGestureControllerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenSTTListener(SpenSTTListenerImpl spenSTTListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getSTTManager().setListener(spenSTTListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenSelectionChangeListener(SpenSelectionChangeListener spenSelectionChangeListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteWritingViewManager().setSelectionChangeListener(spenSelectionChangeListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setSpenTextManagerActionListener(SpenTextManagerActionListenerImpl spenTextManagerActionListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getTextManager().setActionListener(spenTextManagerActionListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setStrokeShapeListener(SpenStrokeShapeListener spenStrokeShapeListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setStrokeShapeListener(spenStrokeShapeListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setTextEventListener(SpenTextLimitListener spenTextLimitListener) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getTextManager().setTextLimitListener(spenTextLimitListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setThumbnailChangedListener(ThumbnailChangeListenerImpl thumbnailChangeListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getListenerManager().setThumbnailChangeListener(thumbnailChangeListenerImpl);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ListenerImplContract.IViewListenerManager
    public void setZoomListener(SpenZoomListenerImpl spenZoomListenerImpl) {
        SpenComposer spenComposer = this.mView;
        if (spenComposer != null) {
            spenComposer.getNoteZoomScroller().setZoomListener(spenZoomListenerImpl);
        }
    }
}
