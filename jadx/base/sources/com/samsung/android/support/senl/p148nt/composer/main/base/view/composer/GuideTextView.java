package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenCustomObject;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GuideTextView extends TextView {
    private static final String COMPOSER_KEY_BODY_GUIDE_SHOWN = "pref_key_body_guide_tip";
    private static final String TAG = Logger.createTag("GuideTextView");
    private ComposerViewContract.IPresenter mComposerViewPresenter;
    private SpenWNote.CustomObjectEventListener mCustomObjectEventListener;
    private HistoryEventListenerImpl.HistoryEventBridgeListener mHistoryEventBridgeListener;
    private SpenPreTouchListenerImpl.PreTouchListener mPreTouchListener;
    private float mPreviousZoomRatio;
    private SpenZoomListenerImpl.ZoomListener mSpenZoomListener;

    public GuideTextView(Context context) {
        super(context);
        this.mPreviousZoomRatio = 0.0f;
    }

    private void addWatcherToDisable() {
        watchPenWritingToDisable();
        watchObjectAddedToDisable();
        watchZoomToDisable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkStylusTouch(int i) {
        if (DeviceUtils.isSpenModel() && i == 2) {
            return true;
        }
        return (DeviceUtils.isSpenModel() || i == 2) ? false : true;
    }

    private void disable() {
        Logger.m10999d(TAG, "disable#");
        removePreference();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.1
            @Override // java.lang.Runnable
            public void run() {
                GuideTextView.this.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableGuideTip() {
        ComposerViewContract.IPresenter iPresenter = this.mComposerViewPresenter;
        if (iPresenter == null) {
            return;
        }
        if (this.mHistoryEventBridgeListener != null) {
            iPresenter.getListenerManager().removeHistoryEventBridgeListener(this.mHistoryEventBridgeListener);
        }
        if (this.mPreTouchListener != null) {
            this.mComposerViewPresenter.getListenerManager().removePreTouchListener(this.mPreTouchListener);
        }
        if (this.mSpenZoomListener != null) {
            this.mComposerViewPresenter.getListenerManager().removeZoomListener(this.mSpenZoomListener);
        }
        if (this.mCustomObjectEventListener != null) {
            this.mComposerViewPresenter.getListenerManager().removeCustomObjectEventListener(this.mCustomObjectEventListener);
        }
        disable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableGuideTipPost() {
        post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.6
            @Override // java.lang.Runnable
            public void run() {
                GuideTextView.this.disableGuideTip();
            }
        });
    }

    private void enable() {
        Logger.m10999d(TAG, "enable#");
        if (DeviceInfo.isVSTModel()) {
            SpenWPage page = this.mComposerViewPresenter.getObjectManager().getNote().getPage(0);
            RectF rectFConvertViewRectIntoContentRect = this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().convertViewRectIntoContentRect(new RectF(0.0f, 0.0f, page.getWidth(), page.getHeight()));
            if (rectFConvertViewRectIntoContentRect != null) {
                setMaxWidth((int) rectFConvertViewRectIntoContentRect.width());
            }
        }
        super.setVisibility(0);
    }

    private boolean isSupported() {
        return !SharedPreferencesCompat.getInstance("Composer").getBoolean(COMPOSER_KEY_BODY_GUIDE_SHOWN, false);
    }

    private void removePreference() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        if (sharedPreferencesCompat.getBoolean(COMPOSER_KEY_BODY_GUIDE_SHOWN, false)) {
            return;
        }
        sharedPreferencesCompat.putBoolean(COMPOSER_KEY_BODY_GUIDE_SHOWN, true);
    }

    private void watchObjectAddedToDisable() {
        this.mHistoryEventBridgeListener = new HistoryEventListenerImpl.HistoryEventBridgeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl.HistoryEventBridgeListener
            public void onUndoable(SpenWNote spenWNote, boolean z) {
                GuideTextView.this.disableGuideTip();
            }
        };
        this.mComposerViewPresenter.getListenerManager().addHistoryEventBridgeListener(this.mHistoryEventBridgeListener);
        this.mCustomObjectEventListener = new SpenWNote.CustomObjectEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.4
            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
            public void onCustomObjectAdded(@NonNull SpenWPage spenWPage, @NonNull ArrayList<SpenCustomObject> arrayList, int i) {
                GuideTextView.this.disableGuideTipPost();
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
            public void onCustomObjectChanged(@NonNull SpenWPage spenWPage, @NonNull SpenWNote.CustomObjectEventListener.CustomObjectChangedInfo customObjectChangedInfo, int i) {
                GuideTextView.this.disableGuideTipPost();
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.CustomObjectEventListener
            public void onCustomObjectRemoved(@NonNull SpenWPage spenWPage, @NonNull ArrayList<SpenCustomObject> arrayList, int i) {
                GuideTextView.this.disableGuideTipPost();
            }
        };
        this.mComposerViewPresenter.getListenerManager().addCustomObjectEventListener(this.mCustomObjectEventListener);
    }

    private void watchPenWritingToDisable() {
        this.mPreTouchListener = new SpenPreTouchListenerImpl.PreTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Logger.m11003i(GuideTextView.TAG, "watchPenWriting onTouch");
                if (GuideTextView.this.mComposerViewPresenter != null && GuideTextView.this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing) && (!GuideTextView.this.mComposerViewPresenter.getComposerModel().isLastSpenOnlyMode() || GuideTextView.this.checkStylusTouch(motionEvent.getToolType(0)))) {
                    GuideTextView.this.disableGuideTip();
                }
                return false;
            }
        };
        this.mComposerViewPresenter.getListenerManager().addPreTouchListener(this.mPreTouchListener);
    }

    private void watchZoomToDisable() {
        this.mSpenZoomListener = new SpenZoomListenerImpl.ZoomListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GuideTextView.5
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenZoomListenerImpl.ZoomListener
            public void onZoom(float f, float f4, float f5, float f6, float f7) {
                if (GuideTextView.this.mPreviousZoomRatio == 0.0f) {
                    GuideTextView.this.mPreviousZoomRatio = f7;
                } else if (GuideTextView.this.mPreviousZoomRatio != f7) {
                    GuideTextView.this.disableGuideTipPost();
                }
            }
        };
        this.mComposerViewPresenter.getListenerManager().addZoomListener(this.mSpenZoomListener);
    }

    public void init(ComposerViewContract.IPresenter iPresenter) {
        if (isSupported()) {
            this.mComposerViewPresenter = iPresenter;
            if (iPresenter.hasBackgroundImage()) {
                return;
            }
            addWatcherToDisable();
            enable();
        }
    }

    public void release() {
        if (getVisibility() == 0) {
            removePreference();
        }
    }

    public GuideTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPreviousZoomRatio = 0.0f;
    }

    public GuideTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPreviousZoomRatio = 0.0f;
    }

    public GuideTextView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPreviousZoomRatio = 0.0f;
    }
}
