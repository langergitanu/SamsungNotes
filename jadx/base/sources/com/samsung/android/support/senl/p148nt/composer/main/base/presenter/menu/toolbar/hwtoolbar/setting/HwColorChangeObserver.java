package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.graphics.Color;
import android.os.Handler;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.engine.SpenColorPickerListener;
import com.samsung.android.sdk.pen.engine.SpenRecentColorListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwColorChangeObserver {
    private static final int SPEN_COLOR_INTV_MS = 10;
    private static final String TAG = Logger.createTag("HwColorChangeObserver");
    private Runnable mEyedropperColorRunnable;
    private Handler mHandler;
    private int mPreActionType;
    private HwSettingContract.IPresenter mPresenter;
    private Runnable mRecentColorRunnable;
    private final WritingToolManager mWritingToolManager;

    public HwColorChangeObserver(WritingToolManager writingToolManager, HwSettingContract.IPresenter iPresenter) {
        this.mWritingToolManager = writingToolManager;
        this.mPresenter = iPresenter;
        initRunnable();
        setRecentColorListener();
    }

    private int removeAlpha(int i) {
        return Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEyeDropperColor(int i) {
        this.mPresenter.getHwToolbarState().setEyedropperColor(i);
        this.mHandler.removeCallbacks(this.mEyedropperColorRunnable);
        this.mHandler.postDelayed(this.mEyedropperColorRunnable, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecentColor(int i) {
        int iRemoveAlpha = removeAlpha(i);
        if (this.mPresenter.getHwToolbarState().getRecentColor() == iRemoveAlpha) {
            return;
        }
        this.mPresenter.getHwToolbarState().setRecentColor(iRemoveAlpha);
        this.mHandler.removeCallbacks(this.mRecentColorRunnable);
        this.mHandler.postDelayed(this.mRecentColorRunnable, 10L);
    }

    public void close() {
        this.mWritingToolManager.setColorPickerListener(null);
        this.mWritingToolManager.setRecentColorListener(null);
        this.mHandler.removeCallbacks(this.mRecentColorRunnable);
        this.mHandler.removeCallbacks(this.mEyedropperColorRunnable);
    }

    public void initRunnable() {
        this.mHandler = new Handler();
        this.mEyedropperColorRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwColorChangeObserver.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m11003i(HwColorChangeObserver.TAG, "eyedropperColorThread onChanged : color = " + HwColorChangeObserver.this.mPresenter.getHwToolbarState().getEyedropperColor());
                HwColorChangeObserver.this.mPresenter.onUpdateEyedropperColor();
            }
        };
        this.mRecentColorRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwColorChangeObserver.2
            @Override // java.lang.Runnable
            public void run() {
                HwColorChangeObserver.this.mPresenter.getSettingInfoManager().getColorRecentData().addRecentColor(HwColorChangeObserver.this.mPresenter.getHwToolbarState().getRecentColor());
                HwColorChangeObserver.this.mPresenter.notifyRecentColorChanged();
            }
        };
    }

    public void setColorPickerListener(boolean z) {
        if (z) {
            this.mWritingToolManager.setColorPickerListener(new SpenColorPickerListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwColorChangeObserver.3
                @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
                public void onColorPicked(int i, float f, float f4) {
                    String str = HwColorChangeObserver.TAG;
                    StringBuilder sbM1628r = AbstractC2322a.m1628r("onColorPicked color = ", i, " x= ", f, " y= ");
                    sbM1628r.append(f4);
                    Logger.m10999d(str, sbM1628r.toString());
                    if (HwColorChangeObserver.this.mPresenter.getHwToolbarState().getEyedropperColor() != i) {
                        HwColorChangeObserver.this.setEyeDropperColor(i);
                    }
                }
            });
        } else {
            this.mWritingToolManager.setColorPickerListener(null);
        }
    }

    public void setEyedropperMode(boolean z) {
        setColorPickerListener(z);
        if (z) {
            this.mPreActionType = this.mWritingToolManager.getToolTypeAction(2);
            this.mWritingToolManager.setToolTypeAction(2, 9);
            return;
        }
        setRecentColor(this.mPresenter.getHwToolbarState().getEyedropperColor());
        int i = this.mPreActionType;
        if (i == 18) {
            this.mPresenter.setEnableLaserPen(true);
        } else {
            this.mWritingToolManager.setToolTypeAction(2, i);
        }
    }

    public void setRecentColorListener() {
        this.mWritingToolManager.setRecentColorListener(new SpenRecentColorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwColorChangeObserver.4
            @Override // com.samsung.android.sdk.pen.engine.SpenRecentColorListener
            public void onAddStroke(int i) {
                AbstractC0000a.m3D(i, "setRecentColorListener onAddStroke : ", HwColorChangeObserver.TAG);
                HwColorChangeObserver.this.setRecentColor(i);
                HwColorChangeObserver.this.mPresenter.updateLastPenInfo();
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenRecentColorListener
            public void onChangeStyle(int i) {
                if (HwColorChangeObserver.this.mPresenter.getHwToolbarState().getRecentStyleColor() != i) {
                    AbstractC0000a.m3D(i, "setRecentColorListener onChangeStyle : ", HwColorChangeObserver.TAG);
                    HwColorChangeObserver.this.setRecentColor(i);
                }
            }
        });
    }
}
