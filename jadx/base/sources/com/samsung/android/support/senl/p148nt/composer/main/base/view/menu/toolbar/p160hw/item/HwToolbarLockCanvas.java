package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarLockCanvas extends HwToolbarItem {
    private static final int MAX_LOCK_CANVAS_CLICK_COUNT = 3;
    private static final String PREF_KEY_CLICK_COUNT = "hw_lock_canvas_clicked";
    private static final String TAG = Logger.createTag("HwToolbarLockCanvas");
    protected HwToolbarPresenterImpl mPresenter;

    public HwToolbarLockCanvas(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        HwToolbarPresenterImpl hwToolbarPresenter = hwToolbarItemContract.getHwToolbarPresenter();
        this.mPresenter = hwToolbarPresenter;
        hwToolbarPresenter.setSpenGestureControllerListener(new SpenGestureControllerImpl() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarLockCanvas.1
            @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenGestureControllerImpl, com.samsung.android.sdk.pen.engine.SpenIGestureController.Listener
            public void onOneFingerScrollAndScaleLockedChanged(boolean z) {
                View view2 = HwToolbarLockCanvas.this.mView;
                if (view2 == null || view2.isSelected() == z) {
                    return;
                }
                Logger.m11004w(HwToolbarLockCanvas.TAG, "why onZoomLockedChanged# : " + z);
                HwToolbarLockCanvas.this.setSelected(z);
            }
        });
        View view2 = this.mView;
        if (view2 != null) {
            view2.setContentDescription(view2.getResources().getString(C9086R.string.composer_zoom_lock_on_off));
            ViewCompat.getInstance().setTooltipText(this.mView);
        }
    }

    private boolean isValidClickCount() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        int i = sharedPreferencesCompat.getInt(PREF_KEY_CLICK_COUNT, 0);
        if (i == 3) {
            return false;
        }
        sharedPreferencesCompat.putInt(PREF_KEY_CLICK_COUNT, i + 1);
        return true;
    }

    private void toggleSelected() {
        this.mHwSettingViewManager.hide();
        boolean zIsSelected = this.mView.isSelected();
        this.mHwToolbarItemManager.getSettingInstance().setZoomState(!zIsSelected);
        if (zIsSelected) {
            setSelected(false);
        } else {
            this.mHwToolbarItemManager.onSelected(getViewId());
        }
    }

    private void updateIcon(boolean z) {
        if (z) {
            ((ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_lock_canvas_type)).setImageResource(C9086R.drawable.comp_hw_toolbar_ic_lock_canvas);
        } else {
            ((ImageView) this.mView.findViewById(C9086R.id.hw_toolbar_lock_canvas_type)).setImageResource(C9086R.drawable.comp_hw_toolbar_ic_unlock_canvas);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void functionEnable(boolean z) {
        this.mHwToolbarItemManager.getSettingInstance().setZoomLock(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        Logger.m11003i(TAG, "onClick# ");
        toggleSelected();
        talkback();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void setEnable(boolean z) {
        super.setEnable(z);
        if (z) {
            return;
        }
        functionEnable(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public boolean setSelected(boolean z) {
        if (!super.setSelected(z) && z == this.mPresenter.isZoomLocked()) {
            return false;
        }
        if (z && isValidClickCount()) {
            this.mPresenter.showLockCanvasToolTip();
        }
        AbstractC8014b.m7224z("setSelected# ", TAG, z);
        this.mHwToolbarItemManager.getSettingInstance().setZoomLock(z);
        updateIcon(z);
        ComposerSA.insertLog(ComposerSA.getScreenID(true, true, this.mHwSettingViewManager.isTabletLayout()), HWToolbarSAConstants.EVENT_WRITING_ZOOM_LOCK, z ? "1" : "0");
        return true;
    }

    public void toggleLockCanvas() {
        if (this.mView.getVisibility() == 0 && this.mView.isEnabled()) {
            Logger.m11003i(TAG, "toggleLockCanvas# ");
            toggleSelected();
        }
    }

    public void updateLockCanvas() {
        if (this.mPresenter.isLastStateLockCanvas() == this.mPresenter.isZoomLocked() && this.mPresenter.isLastStateLockCanvas() == isSelected()) {
            return;
        }
        setSelected(this.mPresenter.isLastStateLockCanvas());
    }
}
