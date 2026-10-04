package com.yubico.yubikit.piv;

import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public enum Slot {
    AUTHENTICATION(154, ObjectId.AUTHENTICATION),
    SIGNATURE(156, ObjectId.SIGNATURE),
    KEY_MANAGEMENT(157, ObjectId.KEY_MANAGEMENT),
    CARD_AUTH(158, ObjectId.CARD_AUTH),
    RETIRED1(130, ObjectId.RETIRED1),
    RETIRED2(131, ObjectId.RETIRED2),
    RETIRED3(132, ObjectId.RETIRED3),
    RETIRED4(133, ObjectId.RETIRED4),
    RETIRED5(134, ObjectId.RETIRED5),
    RETIRED6(135, ObjectId.RETIRED6),
    RETIRED7(136, ObjectId.RETIRED7),
    RETIRED8(137, ObjectId.RETIRED8),
    RETIRED9(138, ObjectId.RETIRED9),
    RETIRED10(139, ObjectId.RETIRED10),
    RETIRED11(140, ObjectId.RETIRED11),
    RETIRED12(141, ObjectId.RETIRED12),
    RETIRED13(142, ObjectId.RETIRED13),
    RETIRED14(143, ObjectId.RETIRED14),
    RETIRED15(144, ObjectId.RETIRED15),
    RETIRED16(145, ObjectId.RETIRED16),
    RETIRED17(146, ObjectId.RETIRED17),
    RETIRED18(147, ObjectId.RETIRED18),
    RETIRED19(148, ObjectId.RETIRED19),
    RETIRED20(149, ObjectId.RETIRED20),
    ATTESTATION(249, ObjectId.ATTESTATION);

    public final int objectId;
    public final int value;

    Slot(int i, int i2) {
        this.value = i;
        this.objectId = i2;
    }

    public static Slot fromStringAlias(String str) {
        return fromValue(Integer.parseInt(str, 16));
    }

    public static Slot fromValue(int i) {
        for (Slot slot : values()) {
            if (slot.value == i) {
                return slot;
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Not a valid Slot :"));
    }

    public String getStringAlias() {
        return Integer.toString(this.value, 16);
    }
}
