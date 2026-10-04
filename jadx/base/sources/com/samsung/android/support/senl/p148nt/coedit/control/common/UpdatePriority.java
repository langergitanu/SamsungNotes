package com.samsung.android.support.senl.p148nt.coedit.control.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public enum UpdatePriority {
    STANDALONE_PRIORITY(5),
    COMPOSE_PRIORITY(4),
    IMPORT_PRIORITY(3),
    LIST_PRIORITY(2),
    BACKGROUND_PRIORITY(1);

    public final int value;

    UpdatePriority(int i) {
        this.value = i;
    }
}
