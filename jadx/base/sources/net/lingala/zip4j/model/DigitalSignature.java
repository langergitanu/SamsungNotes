package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DigitalSignature {
    private int headerSignature;
    private String signatureData;
    private int sizeOfData;

    public int getHeaderSignature() {
        return this.headerSignature;
    }

    public String getSignatureData() {
        return this.signatureData;
    }

    public int getSizeOfData() {
        return this.sizeOfData;
    }

    public void setHeaderSignature(int i) {
        this.headerSignature = i;
    }

    public void setSignatureData(String str) {
        this.signatureData = str;
    }

    public void setSizeOfData(int i) {
        this.sizeOfData = i;
    }
}
