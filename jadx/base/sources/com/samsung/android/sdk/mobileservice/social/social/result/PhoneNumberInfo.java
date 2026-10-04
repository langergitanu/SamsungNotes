package com.samsung.android.sdk.mobileservice.social.social.result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PhoneNumberInfo {
    private final String hash;
    private final String number;
    private final Type type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Type {
        IMS,
        SIM,
        SERVICE_NUMBER,
        UNKNOWN
    }

    public PhoneNumberInfo(String str, String str2, Type type) {
        this.hash = str;
        this.number = str2;
        this.type = type;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type mapToType(String str) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != -2029057005) {
            if (iHashCode != 104399) {
                b = (iHashCode == 113879 && str.equals("sim")) ? (byte) 1 : (byte) -1;
            } else if (str.equals("ims")) {
                b = 0;
            }
        } else if (str.equals("service_number")) {
            b = 2;
        }
        return b != 0 ? b != 1 ? b != 2 ? Type.UNKNOWN : Type.SERVICE_NUMBER : Type.SIM : Type.IMS;
    }

    public String getHash() {
        return this.hash;
    }

    public String getNumber() {
        return this.number;
    }

    public Type getType() {
        return this.type;
    }
}
