package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenObjectEventListenerImpl implements SpenWNote.ObjectEventListener {
    private static final String TAG = Logger.createTag("SpenObjectEventListenerImpl");
    private BridgeListenerList<SpenWNote.ObjectEventListener> mBridgeListenerList = new BridgeListenerList<>();
    private HandoffHandler mHandoffHandler;

    public SpenObjectEventListenerImpl(HandoffHandler handoffHandler) {
        this.mHandoffHandler = handoffHandler;
    }

    private void sendHandoffDataMsg() {
        HandoffHandler handoffHandler = this.mHandoffHandler;
        if (handoffHandler != null) {
            handoffHandler.sendHandoffDataMsg(1000);
        }
    }

    public void addSpenObjectEventListener(SpenWNote.ObjectEventListener objectEventListener) {
        BridgeListenerList<SpenWNote.ObjectEventListener> bridgeListenerList = this.mBridgeListenerList;
        if (bridgeListenerList == null) {
            return;
        }
        bridgeListenerList.addBridgeListener(objectEventListener);
    }

    public boolean isEnable() {
        if (this.mBridgeListenerList == null) {
            return false;
        }
        return !r0.isEmpty();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectAdded(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
        if (this.mBridgeListenerList == null) {
            return;
        }
        Logger.addFileLog(TAG, "onObjectAdded# " + i, 4);
        Iterator<SpenWNote.ObjectEventListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onObjectAdded(spenWPage, arrayList, i);
        }
        sendHandoffDataMsg();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectChanged(SpenWPage spenWPage, SpenObjectChangedInfo spenObjectChangedInfo, int i) {
        if (this.mBridgeListenerList == null) {
            return;
        }
        Logger.addFileLog(TAG, "onObjectChanged# " + spenObjectChangedInfo.type + ":" + i, 2);
        Iterator<SpenWNote.ObjectEventListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onObjectChanged(spenWPage, spenObjectChangedInfo, i);
        }
        sendHandoffDataMsg();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
    public void onObjectRemoved(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
        if (this.mBridgeListenerList == null) {
            return;
        }
        Logger.addFileLog(TAG, "onObjectRemoved# " + i, 4);
        Iterator<SpenWNote.ObjectEventListener> it = this.mBridgeListenerList.iterator();
        while (it.hasNext()) {
            it.next().onObjectRemoved(spenWPage, arrayList, i);
        }
        sendHandoffDataMsg();
    }

    public void release() {
        this.mHandoffHandler = null;
        this.mBridgeListenerList.clear();
        this.mBridgeListenerList = null;
    }

    public void removeSpenObjectEventListener(SpenWNote.ObjectEventListener objectEventListener) {
        BridgeListenerList<SpenWNote.ObjectEventListener> bridgeListenerList = this.mBridgeListenerList;
        if (bridgeListenerList == null) {
            return;
        }
        bridgeListenerList.removeBridgeListener(objectEventListener);
    }
}
