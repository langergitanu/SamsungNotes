package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArchiveExtraDataRecord {
    private String extraFieldData;
    private int extraFieldLength;
    private int signature;

    public String getExtraFieldData() {
        return this.extraFieldData;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public int getSignature() {
        return this.signature;
    }

    public void setExtraFieldData(String str) {
        this.extraFieldData = str;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public void setSignature(int i) {
        this.signature = i;
    }
}
