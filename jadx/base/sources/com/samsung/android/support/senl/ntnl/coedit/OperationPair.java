package com.samsung.android.support.senl.ntnl.coedit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class OperationPair<O> {
    private final O clientOp;
    private final O serverOp;

    public OperationPair(O o, O o3) {
        this.clientOp = o;
        this.serverOp = o3;
    }

    public O clientOp() {
        return this.clientOp;
    }

    public O serverOp() {
        return this.serverOp;
    }
}
