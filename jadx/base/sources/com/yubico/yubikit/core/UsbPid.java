package com.yubico.yubikit.core;

import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NEO_OTP' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class UsbPid {
    private static final /* synthetic */ UsbPid[] $VALUES;
    public static final UsbPid NEO_CCID;
    public static final UsbPid NEO_FIDO;
    public static final UsbPid NEO_FIDO_CCID;
    public static final UsbPid NEO_OTP;
    public static final UsbPid NEO_OTP_CCID;
    public static final UsbPid NEO_OTP_FIDO;
    public static final UsbPid NEO_OTP_FIDO_CCID;
    public static final UsbPid SKY_FIDO;
    public static final UsbPid YK4_CCID;
    public static final UsbPid YK4_FIDO;
    public static final UsbPid YK4_FIDO_CCID;
    public static final UsbPid YK4_OTP;
    public static final UsbPid YK4_OTP_CCID;
    public static final UsbPid YK4_OTP_FIDO;
    public static final UsbPid YK4_OTP_FIDO_CCID;
    public static final UsbPid YKP_OTP_FIDO;
    public static final UsbPid YKS_OTP;
    public final YubiKeyType type;
    public final int usbInterfaces;
    public final int value;

    static {
        UsbPid usbPid = new UsbPid("YKS_OTP", 0, 16, YubiKeyType.YKS, 1);
        YKS_OTP = usbPid;
        YubiKeyType yubiKeyType = YubiKeyType.NEO;
        UsbPid usbPid2 = new UsbPid("NEO_OTP", 1, 272, yubiKeyType, 1);
        NEO_OTP = usbPid2;
        UsbPid usbPid3 = new UsbPid("NEO_OTP_CCID", 2, 273, yubiKeyType, 5);
        NEO_OTP_CCID = usbPid3;
        UsbPid usbPid4 = new UsbPid("NEO_CCID", 3, 274, yubiKeyType, 4);
        NEO_CCID = usbPid4;
        UsbPid usbPid5 = new UsbPid("NEO_FIDO", 4, 275, yubiKeyType, 2);
        NEO_FIDO = usbPid5;
        UsbPid usbPid6 = new UsbPid("NEO_OTP_FIDO", 5, 276, yubiKeyType, 3);
        NEO_OTP_FIDO = usbPid6;
        UsbPid usbPid7 = new UsbPid("NEO_FIDO_CCID", 6, 277, yubiKeyType, 6);
        NEO_FIDO_CCID = usbPid7;
        UsbPid usbPid8 = new UsbPid("NEO_OTP_FIDO_CCID", 7, 278, yubiKeyType, 7);
        NEO_OTP_FIDO_CCID = usbPid8;
        UsbPid usbPid9 = new UsbPid("SKY_FIDO", 8, 288, YubiKeyType.SKY, 2);
        SKY_FIDO = usbPid9;
        YubiKeyType yubiKeyType2 = YubiKeyType.YK4;
        UsbPid usbPid10 = new UsbPid("YK4_OTP", 9, 1025, yubiKeyType2, 1);
        YK4_OTP = usbPid10;
        UsbPid usbPid11 = new UsbPid("YK4_FIDO", 10, 1026, yubiKeyType2, 2);
        YK4_FIDO = usbPid11;
        UsbPid usbPid12 = new UsbPid("YK4_OTP_FIDO", 11, 1027, yubiKeyType2, 3);
        YK4_OTP_FIDO = usbPid12;
        UsbPid usbPid13 = new UsbPid("YK4_CCID", 12, 1028, yubiKeyType2, 4);
        YK4_CCID = usbPid13;
        UsbPid usbPid14 = new UsbPid("YK4_OTP_CCID", 13, 1029, yubiKeyType2, 5);
        YK4_OTP_CCID = usbPid14;
        UsbPid usbPid15 = new UsbPid("YK4_FIDO_CCID", 14, 1030, yubiKeyType2, 6);
        YK4_FIDO_CCID = usbPid15;
        UsbPid usbPid16 = new UsbPid("YK4_OTP_FIDO_CCID", 15, ErrorCodeConvertor.TEMP_AGENT_WIFI_ONLY_MODEL, yubiKeyType2, 7);
        YK4_OTP_FIDO_CCID = usbPid16;
        UsbPid usbPid17 = new UsbPid("YKP_OTP_FIDO", 16, 1040, YubiKeyType.YKP, 3);
        YKP_OTP_FIDO = usbPid17;
        $VALUES = new UsbPid[]{usbPid, usbPid2, usbPid3, usbPid4, usbPid5, usbPid6, usbPid7, usbPid8, usbPid9, usbPid10, usbPid11, usbPid12, usbPid13, usbPid14, usbPid15, usbPid16, usbPid17};
    }

    private UsbPid(String str, int i, int i2, YubiKeyType yubiKeyType, int i4) {
        this.value = i2;
        this.type = yubiKeyType;
        this.usbInterfaces = i4;
    }

    public static UsbPid fromValue(int i) {
        for (UsbPid usbPid : values()) {
            if (usbPid.value == i) {
                return usbPid;
            }
        }
        throw new IllegalArgumentException("invalid pid value");
    }

    public static UsbPid valueOf(String str) {
        return (UsbPid) Enum.valueOf(UsbPid.class, str);
    }

    public static UsbPid[] values() {
        return (UsbPid[]) $VALUES.clone();
    }
}
