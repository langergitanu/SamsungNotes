package com.samsung.android.support.senl.p148nt.model.importer.task.param;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportSdocParam extends ImportBaseParam<ImportSdocParam> {
    private String mConfirmResult;
    private boolean mFixCache;
    private String[] mPasswordList;

    public ImportSdocParam() {
        super("1");
    }

    public String getConfirmResult() {
        return this.mConfirmResult;
    }

    public boolean getFixCache() {
        return this.mFixCache;
    }

    public String[] getPasswordList() {
        return this.mPasswordList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportBaseParam
    public ImportSdocParam self() {
        return this;
    }

    public ImportSdocParam setConfirmResult(String str) {
        this.mConfirmResult = str;
        return self();
    }

    public ImportSdocParam setFixCache(boolean z) {
        this.mFixCache = z;
        return self();
    }

    public ImportSdocParam setPasswordList(String[] strArr) {
        this.mPasswordList = strArr;
        return self();
    }
}
