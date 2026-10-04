package com.samsung.android.support.senl.p148nt.data.contract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataToComposerManager {
    private static DataToComposerManager sInstance;
    private ParseHyperTextContract mParseHyperTextContract = null;

    public static synchronized DataToComposerManager getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DataToComposerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public ParseHyperTextContract getParseHyperTextContract() {
        return this.mParseHyperTextContract;
    }

    public void setParseHyperTextContract(ParseHyperTextContract parseHyperTextContract) {
        this.mParseHyperTextContract = parseHyperTextContract;
    }
}
