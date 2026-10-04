package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RtMenuUndoRedo extends RtMenuItem {
    protected static final float DISABLED_ALPHA = 0.4f;
    protected static final float ENABLED_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("RtMenuUndoRedo");
    protected boolean mIsLongPressed;
    protected boolean mOnDoingRedoUndo;

    public RtMenuUndoRedo(View view) {
        super(view);
        this.mOnDoingRedoUndo = false;
        this.mIsLongPressed = false;
        this.mView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                Logger.m10999d(RtMenuUndoRedo.TAG, "onLongClick()");
                if (RtMenuUndoRedo.this.mPresenter.isDockingMode() || !RtMenuUndoRedo.this.isUndoRedoable()) {
                    return false;
                }
                RtMenuUndoRedo rtMenuUndoRedo = RtMenuUndoRedo.this;
                rtMenuUndoRedo.mOnDoingRedoUndo = true;
                rtMenuUndoRedo.mIsLongPressed = true;
                rtMenuUndoRedo.onUndoRedo();
                return false;
            }
        });
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    RtMenuUndoRedo.this.mIsLongPressed = false;
                }
                return false;
            }
        });
    }

    public abstract boolean isUndoRedoable();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        Logger.m10999d(TAG, "onClicked()");
        onUndoRedo();
    }

    public void onLongClicked() {
        onUndoRedo();
    }

    public void onObjectChanged() {
        Logger.m10999d(TAG, "onObjectChanged()");
        boolean z = this.mIsLongPressed;
        this.mOnDoingRedoUndo = z;
        if (z) {
            RtToolbarPresenter rtToolbarPresenter = this.mPresenter;
            if (rtToolbarPresenter == null || !rtToolbarPresenter.isTaskRunningInUndoRedoPresenter()) {
                onLongClicked();
                return;
            }
            View view = this.mView;
            if (view != null) {
                view.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RtMenuUndoRedo.this.onObjectChanged();
                    }
                });
            }
        }
    }

    public abstract void onUndoRedo();

    public void updateUndoRedoMenu(boolean z) {
        if (this.mView.getVisibility() != 0) {
            return;
        }
        if ((this.mIsLongPressed || this.mView.isSelected()) && !z) {
            this.mIsLongPressed = false;
            this.mView.setPressed(false);
        }
        this.mView.setEnabled(z);
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mView;
        viewCompat.setTooltipText(view, z ? (String) view.getContentDescription() : "");
        this.mView.setAlpha(z ? 1.0f : 0.4f);
        AbstractC8014b.m7220v("updateUndoRedoMenu() undoRedoable : ", TAG, z);
    }
}
