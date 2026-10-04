package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.widget.TipPopupWidgetWrapper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SmartTipPopup {
    private static final String TAG = Logger.createTag("SmartTipPopup");
    private static final AtomicBoolean mIsShown = new AtomicBoolean(false);
    private OnDismissListener mDismissListener;
    private Handler mHandler;
    private View.OnLayoutChangeListener mLayoutChangeListener;
    private View mParentView;
    private TipPopupWidgetWrapper mSmartTipPopup;
    private OnStateChangeListener mStateChangeListener;
    private Runnable mUpdateRunnable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDismissListener {
        void onDismissed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnStateChangeListener {
        void onStateChanged(int i);
    }

    public SmartTipPopup(View view, String str) throws InstantiationException {
        if (view == null) {
            Logger.m11003i(TAG, "SmartTipPopup# target is null");
            return;
        }
        Context context = view.getContext();
        try {
            this.mParentView = view;
            this.mHandler = new Handler(Looper.getMainLooper());
            TipPopupWidgetWrapper tipPopupWidgetWrapper = new TipPopupWidgetWrapper(this.mParentView);
            this.mSmartTipPopup = tipPopupWidgetWrapper;
            tipPopupWidgetWrapper.setMessage(str);
            this.mSmartTipPopup.setExpanded(true);
            Resources resources = context.getResources();
            this.mSmartTipPopup.setBackgroundColor(resources.getColor(C9086R.color.smart_tip_popup_guide_background_color, null));
            this.mSmartTipPopup.setBorderColor(resources.getColor(C9086R.color.smart_tip_popup_guide_background_color, null));
            this.mSmartTipPopup.setMessageTextColor(resources.getColor(C9086R.color.smart_tip_popup_guide_text_color, null));
            this.mParentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    SmartTipPopup.this.update();
                }
            });
            this.mLayoutChangeListener = getLayoutChangeListener();
            this.mParentView.getRootView().addOnLayoutChangeListener(this.mLayoutChangeListener);
        } catch (Error e) {
            Logger.m11000e(TAG, "SmartTipPopup# " + e.getMessage());
            throw new InstantiationException("fail to make instance cause " + e.getMessage());
        }
    }

    private Runnable getUpdateRunnable() {
        Runnable runnable = this.mUpdateRunnable;
        if (runnable != null) {
            return runnable;
        }
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.5
            @Override // java.lang.Runnable
            public void run() {
                if (SmartTipPopup.this.mSmartTipPopup == null || !SmartTipPopup.this.mSmartTipPopup.isShowing()) {
                    return;
                }
                try {
                    if (SmartTipPopup.this.isValidParentView()) {
                        SmartTipPopup.this.mSmartTipPopup.update();
                    } else {
                        SmartTipPopup.this.mSmartTipPopup.dismiss(false);
                    }
                } catch (IllegalArgumentException e) {
                    Logger.m11000e(SmartTipPopup.TAG, "update " + e.getMessage());
                }
                Logger.m10999d(SmartTipPopup.TAG, "updated SmartTipPopup");
            }
        };
        this.mUpdateRunnable = runnable2;
        return runnable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidParentView() {
        View view = this.mParentView;
        return view != null && view.isAttachedToWindow() && this.mParentView.getVisibility() == 0;
    }

    public void dismiss() {
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mSmartTipPopup;
        if (tipPopupWidgetWrapper == null || !tipPopupWidgetWrapper.isShowing()) {
            Logger.m11003i(TAG, "dismiss# mSmartTipPopup is null or not Showing.");
            return;
        }
        Logger.m11003i(TAG, "dismiss SmartTipPopup");
        this.mSmartTipPopup.dismiss(false);
        this.mSmartTipPopup = null;
    }

    public View.OnLayoutChangeListener getLayoutChangeListener() {
        return new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (i == i6 && i4 == i8 && i2 == i7 && i5 == i9) {
                    return;
                }
                SmartTipPopup.this.update();
            }
        };
    }

    public View getParentView() {
        return this.mParentView;
    }

    public boolean isShowing() {
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mSmartTipPopup;
        if (tipPopupWidgetWrapper != null) {
            return tipPopupWidgetWrapper.isShowing();
        }
        return false;
    }

    public void setAction(String str, View.OnClickListener onClickListener) {
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mSmartTipPopup;
        if (tipPopupWidgetWrapper != null) {
            tipPopupWidgetWrapper.setAction(str, onClickListener);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        if (this.mSmartTipPopup != null) {
            this.mDismissListener = onDismissListener;
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (this.mSmartTipPopup != null) {
            this.mStateChangeListener = onStateChangeListener;
        }
    }

    public void setTargetPosition(int i, int i2) {
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mSmartTipPopup;
        if (tipPopupWidgetWrapper == null || tipPopupWidgetWrapper.isShowing()) {
            Logger.m11003i(TAG, "setTargetPosition# mSmartTipPopup is null or Showing.");
        } else {
            this.mSmartTipPopup.setTargetPosition(i, i2);
        }
    }

    public boolean show() {
        TipPopupWidgetWrapper tipPopupWidgetWrapper = this.mSmartTipPopup;
        if (tipPopupWidgetWrapper == null || tipPopupWidgetWrapper.isShowing()) {
            Logger.m11003i(TAG, "show# mSmartTipPopup is null or Showing.");
            return false;
        }
        if (!mIsShown.compareAndSet(false, true)) {
            Logger.m11003i(TAG, "show# mIsShown is true. skip it.");
            return false;
        }
        Logger.m11003i(TAG, "show# SmartTipPopup");
        this.mSmartTipPopup.show(-1);
        this.mSmartTipPopup.setOnStateChangeListener(new TipPopupWidgetWrapper.OnStateChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.4
            @Override // com.samsung.android.support.senl.cm.base.framework.sem.widget.TipPopupImpl.OnStateChangeListener
            public void onStateChanged(int i) {
                AbstractC8014b.m7217s(i, "onStateChanged# state ", SmartTipPopup.TAG);
                if (SmartTipPopup.this.mStateChangeListener != null) {
                    SmartTipPopup.this.mStateChangeListener.onStateChanged(i);
                }
                if (i != 0) {
                    return;
                }
                SmartTipPopup.mIsShown.set(false);
                if (SmartTipPopup.this.mDismissListener != null) {
                    SmartTipPopup.this.mDismissListener.onDismissed();
                }
                SmartTipPopup.this.mParentView.getRootView().removeOnLayoutChangeListener(SmartTipPopup.this.mLayoutChangeListener);
                SmartTipPopup.this.mLayoutChangeListener = null;
            }
        });
        return true;
    }

    public void update() {
        if (this.mHandler != null) {
            Logger.m11003i(TAG, Constants.ARG_UPDATE);
            this.mHandler.removeCallbacks(getUpdateRunnable());
            this.mHandler.postDelayed(getUpdateRunnable(), 100L);
        }
    }

    public SmartTipPopup(View view, String str, boolean z) throws InstantiationException {
        if (view == null) {
            Logger.m11003i(TAG, "SmartTipPopup# target is null");
            return;
        }
        Logger.m11003i(TAG, "SmartTipPopup# content/expanded " + str + "/" + z);
        Context context = view.getContext();
        try {
            this.mParentView = view;
            this.mHandler = new Handler(Looper.getMainLooper());
            TipPopupWidgetWrapper tipPopupWidgetWrapper = new TipPopupWidgetWrapper(this.mParentView);
            this.mSmartTipPopup = tipPopupWidgetWrapper;
            tipPopupWidgetWrapper.setMessage(str);
            this.mSmartTipPopup.setExpanded(z);
            Resources resources = context.getResources();
            this.mSmartTipPopup.setBackgroundColor(resources.getColor(C9086R.color.smart_tip_popup_guide_background_color, null));
            this.mSmartTipPopup.setBorderColor(resources.getColor(C9086R.color.smart_tip_popup_guide_text_color, null));
            this.mSmartTipPopup.setMessageTextColor(resources.getColor(C9086R.color.smart_tip_popup_guide_text_color, null));
            this.mParentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.util.SmartTipPopup.2
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    SmartTipPopup.this.update();
                }
            });
            this.mLayoutChangeListener = getLayoutChangeListener();
            this.mParentView.getRootView().addOnLayoutChangeListener(this.mLayoutChangeListener);
        } catch (Error e) {
            Logger.m11000e(TAG, "SmartTipPopup# " + e.getMessage());
            throw new InstantiationException("fail to make instance cause " + e.getMessage());
        }
    }
}
