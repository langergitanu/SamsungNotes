package com.samsung.android.support.senl.p148nt.app.version.history;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class VersionUpdate {
    private final int newVersion;
    private final int oldVersion;

    public VersionUpdate(int i, int i2) {
        this.oldVersion = i;
        this.newVersion = i2;
    }

    public int getNewVersion() {
        return this.newVersion;
    }

    public int getOldVersion() {
        return this.oldVersion;
    }

    public abstract void onUpgrade();
}
