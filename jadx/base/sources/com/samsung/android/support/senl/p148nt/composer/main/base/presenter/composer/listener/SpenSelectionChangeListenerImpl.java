package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenSelectionChangeListenerImpl implements SpenSelectionChangeListener {
    private final BridgeListenerList<SpenSelectionChangeListener> mBridgeListenerList = new BridgeListenerList<>();

    public void addBridgeListener(SpenSelectionChangeListener spenSelectionChangeListener) {
        this.mBridgeListenerList.addBridgeListener(spenSelectionChangeListener);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
    public void onChanged(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        Iterator<SpenSelectionChangeListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onChanged(spenSettingSelectionInfo);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
    public void onPositionUpdated(RectF rectF) {
        Iterator<SpenSelectionChangeListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onPositionUpdated(rectF);
        }
    }

    public void removeBridgeListener(SpenSelectionChangeListener spenSelectionChangeListener) {
        this.mBridgeListenerList.removeBridgeListener(spenSelectionChangeListener);
    }
}
