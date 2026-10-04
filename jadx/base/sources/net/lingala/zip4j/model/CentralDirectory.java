package net.lingala.zip4j.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CentralDirectory {
    private DigitalSignature digitalSignature;
    private ArrayList fileHeaders;

    public DigitalSignature getDigitalSignature() {
        return this.digitalSignature;
    }

    public ArrayList getFileHeaders() {
        return this.fileHeaders;
    }

    public void setDigitalSignature(DigitalSignature digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

    public void setFileHeaders(ArrayList arrayList) {
        this.fileHeaders = arrayList;
    }
}
