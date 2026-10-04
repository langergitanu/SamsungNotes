package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface StateChangeListener {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INITIALIZED,
        DESTROYED_WITH_SAVE,
        DESTROYED_WITHOUT_SAVE,
        RESUME
    }

    void onStateChanged(State state);
}
