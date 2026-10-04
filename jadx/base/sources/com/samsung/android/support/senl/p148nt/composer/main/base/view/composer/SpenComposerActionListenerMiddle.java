package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.composer.listener.SpenComposerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class SpenComposerActionListenerMiddle extends SpenComposerActionListener {
    private final AnimationViewManager mAnimationViewManager;
    private SpenComposerActionListener mSpenComposerActionListenerImpl;

    public SpenComposerActionListenerMiddle(AnimationViewManager animationViewManager) {
        this.mAnimationViewManager = animationViewManager;
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onActionLinkClicked(String str, int i) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onActionLinkClicked(str, i);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onComposerClicked(MotionEvent motionEvent) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onComposerClicked(motionEvent);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onEditModeChanged(int i) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onEditModeChanged(i);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onInitLayoutFinished() {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onInitLayoutFinished();
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onLayout(z, i, i2, i4, i5);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public boolean onPerformContextMenuAction(int i) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        return spenComposerActionListener != null ? spenComposerActionListener.onPerformContextMenuAction(i) : super.onPerformContextMenuAction(i);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onPullGestureAnimationUpdated(float f, float f4, float f5, boolean z) {
        AnimationViewManager animationViewManager = this.mAnimationViewManager;
        if (animationViewManager != null) {
            animationViewManager.onChanged(f, f4, f5, z);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onSearchingText(int i, SearchData searchData) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onSearchingText(i, searchData);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onSmoothScrollEnd() {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onSmoothScrollEnd();
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onStickyMemoClicked(@NonNull SpenCustomObject spenCustomObject) {
        SpenComposerActionListener spenComposerActionListener = this.mSpenComposerActionListenerImpl;
        if (spenComposerActionListener != null) {
            spenComposerActionListener.onStickyMemoClicked(spenCustomObject);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onStickyMemoMovedByUser(@NonNull SpenCustomObject spenCustomObject) {
        ComposerSA.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, StickyMemoSAConstants.EVENT_MOVE_STICKY_NOTE, "1");
    }

    public void setListenerImpl(SpenComposerActionListener spenComposerActionListener) {
        this.mSpenComposerActionListenerImpl = spenComposerActionListener;
    }
}
