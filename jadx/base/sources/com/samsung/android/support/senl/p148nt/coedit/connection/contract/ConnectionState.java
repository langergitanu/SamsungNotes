package com.samsung.android.support.senl.p148nt.coedit.connection.contract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface ConnectionState {
    boolean isAlreadyClosed();

    boolean isAlreadyStopped();

    boolean isNotOpenedState();

    boolean isStartedState();

    boolean isUndefinedState();

    String printState();

    void setClosedState();

    void setOpenedState();

    void setStartedState();

    void setStoppedState();
}
