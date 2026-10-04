package com.samsung.android.support.senl.p148nt.composer.main.base.widget.animation;

import android.app.Activity;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.ScanningEffectView;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ScanningAnimation {
    private final AtomicBoolean mIsScanningAnimating = new AtomicBoolean(false);
    private ScanningEffectView.AnimationToken mScanningAnimationToken;
    private ScanningEffectView mScanningEffectView;
    private final String mTAG;

    public ScanningAnimation(String str) {
        this.mTAG = str;
    }

    public void clearFlag() {
        this.mIsScanningAnimating.set(false);
    }

    public ScanningEffectView.AnimationToken getScanningAnimationToken() {
        return this.mScanningAnimationToken;
    }

    public ScanningEffectView getScanningEffectView() {
        return this.mScanningEffectView;
    }

    public boolean isScanningAnimating() {
        return this.mIsScanningAnimating.get();
    }

    public void setScanningEffectView(ScanningEffectView scanningEffectView) {
        this.mScanningEffectView = scanningEffectView;
    }

    @RequiresApi(33)
    public boolean showScanningEffectView(final Activity activity, View view) {
        if (this.mScanningEffectView == null) {
            return false;
        }
        Logger.m10999d(this.mTAG, "showScanningEffectView# start");
        this.mIsScanningAnimating.set(true);
        this.mScanningEffectView.setVisibility(0);
        Rect rect = new Rect();
        this.mScanningEffectView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        rect2.offset(0, -rect.top);
        this.mScanningEffectView.setStartPoint(new PointF(rect2.exactCenterX(), rect2.exactCenterY()));
        DeviceUtils.updatePreferredDisplayMode(activity, 60.0f);
        ScanningEffectView.AnimationToken animationTokenStartAnimationTokenized = this.mScanningEffectView.startAnimationTokenized();
        this.mScanningAnimationToken = animationTokenStartAnimationTokenized;
        animationTokenStartAnimationTokenized.setOnExpired(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.widget.animation.ScanningAnimation.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(ScanningAnimation.this.mTAG, "showScanningEffectView#OnExpired");
                DeviceUtils.updatePreferredDisplayMode(activity, 0.0f);
                ScanningAnimation.this.mScanningEffectView.setVisibility(8);
                ScanningAnimation.this.mScanningAnimationToken = null;
                ScanningAnimation.this.mIsScanningAnimating.set(false);
            }
        });
        return true;
    }
}
