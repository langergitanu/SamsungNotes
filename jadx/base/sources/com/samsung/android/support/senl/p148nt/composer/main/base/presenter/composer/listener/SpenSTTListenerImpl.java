package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenSTTListenerImpl extends SPenSTTListener {
    private static final String TAG = Logger.createTag("SpenSTTListenerImpl");
    private final BridgeListenerList<SPenSTTListener> mBridgeListenerList = new BridgeListenerList<>();

    public void addBridgeListener(SPenSTTListener sPenSTTListener) {
        this.mBridgeListenerList.addBridgeListener(sPenSTTListener);
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
    public void onPenDrawingStarted(float f, float f4, int i) {
        AbstractC8014b.m7195A(AbstractC0622a.m1176v("onSpenToTextPenDrawingStarted x :", f, " y :", f4, " mode :"), TAG, i);
        Iterator<SPenSTTListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onPenDrawingStarted(f, f4, i);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
    public void onRecognitionFailed() {
        Logger.m11003i(TAG, "onSpenToTextRecognitionFailed ");
        Iterator<SPenSTTListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onRecognitionFailed();
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
    public void onRecognitionStarted() {
        Logger.m11003i(TAG, "onRecognitionStarted");
        Iterator<SPenSTTListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onRecognitionStarted();
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.spentotext.SPenSTTListener
    public void onResultInserted() {
        Logger.m11003i(TAG, "onSpenToTextResultInserted ");
        Iterator<SPenSTTListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onResultInserted();
        }
    }

    public void release() {
        this.mBridgeListenerList.clear();
    }

    public void removeBridgeListener(SPenSTTListener sPenSTTListener) {
        this.mBridgeListenerList.removeBridgeListener(sPenSTTListener);
    }
}
