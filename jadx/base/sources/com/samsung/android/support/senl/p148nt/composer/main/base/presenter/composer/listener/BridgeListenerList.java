package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BridgeListenerList<T> extends CopyOnWriteArrayList<T> {
    public void addBridgeListener(T t) {
        if (contains(t)) {
            return;
        }
        add(t);
    }

    public void removeBridgeListener(T t) {
        remove(t);
    }
}
