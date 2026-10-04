package com.samsung.android.app.sdk.deepsky.textextraction.action;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/ActionConstants;", "", "()V", "ACTION_ADD_CONTACT", "", "ACTION_ADD_EVENT", "ACTION_ADD_REMINDER", "ACTION_CALL", "ACTION_CATEGORY_BOARDING_PASS", "ACTION_CATEGORY_BOOK", "ACTION_CATEGORY_COUPON", "ACTION_CATEGORY_FOOD", "ACTION_CATEGORY_LIST", "", "getACTION_CATEGORY_LIST", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ACTION_CATEGORY_LOCATION", "ACTION_CATEGORY_MEMBERSHIP", "ACTION_CATEGORY_NULL", "ACTION_CATEGORY_SCHEDULE", "ACTION_CATEGORY_SHOPPING", "ACTION_EXPIRATION_DATE_INVALID_VALUE", "", "ACTION_SEND_MESSAGE", "BARCODE_LOOKUP_TABLE", "", "", "getBARCODE_LOOKUP_TABLE", "()Ljava/util/Map;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ActionConstants {

    @NotNull
    public static final String ACTION_ADD_CONTACT = "Add contact";

    @NotNull
    public static final String ACTION_ADD_EVENT = "Add event";

    @NotNull
    public static final String ACTION_ADD_REMINDER = "Add reminder";

    @NotNull
    public static final String ACTION_CALL = "Call";

    @NotNull
    public static final String ACTION_CATEGORY_LOCATION = "Location";

    @NotNull
    public static final String ACTION_CATEGORY_NULL = "Null";

    @NotNull
    public static final String ACTION_CATEGORY_SCHEDULE = "Schedule";

    @NotNull
    public static final String ACTION_CATEGORY_SHOPPING = "Shopping";
    public static final long ACTION_EXPIRATION_DATE_INVALID_VALUE = -1;

    @NotNull
    public static final String ACTION_SEND_MESSAGE = "Send message";

    @NotNull
    public static final ActionConstants INSTANCE = new ActionConstants();

    @NotNull
    private static final Map<String, Integer> BARCODE_LOOKUP_TABLE = MapsKt.mapOf(TuplesKt.m13893to("UNKNOWN", -1), TuplesKt.m13893to("ALL_FORMATS", 0), TuplesKt.m13893to("CODE_128", 1), TuplesKt.m13893to("CODE_39", 2), TuplesKt.m13893to("CODE_93", 4), TuplesKt.m13893to("CODABAR", 8), TuplesKt.m13893to("DATA_MATRIX", 16), TuplesKt.m13893to("EAN_13", 32), TuplesKt.m13893to("EAN_8", 64), TuplesKt.m13893to("ITF", 128), TuplesKt.m13893to("QR_CODE", 256), TuplesKt.m13893to("UPC_A", 512), TuplesKt.m13893to("UPC_E", 1024), TuplesKt.m13893to("PDF_417", 2048), TuplesKt.m13893to("AZTEC", 4096));

    @NotNull
    public static final String ACTION_CATEGORY_COUPON = "Coupon";

    @NotNull
    public static final String ACTION_CATEGORY_BOOK = "Book";

    @NotNull
    public static final String ACTION_CATEGORY_FOOD = "Food";

    @NotNull
    public static final String ACTION_CATEGORY_BOARDING_PASS = "Boardingpass";

    @NotNull
    public static final String ACTION_CATEGORY_MEMBERSHIP = "Membership";

    @NotNull
    private static final String[] ACTION_CATEGORY_LIST = {ACTION_CATEGORY_COUPON, "Location", "Schedule", ACTION_CATEGORY_BOOK, ACTION_CATEGORY_FOOD, ACTION_CATEGORY_BOARDING_PASS, ACTION_CATEGORY_MEMBERSHIP};

    private ActionConstants() {
    }

    @NotNull
    public final String[] getACTION_CATEGORY_LIST() {
        return ACTION_CATEGORY_LIST;
    }

    @NotNull
    public final Map<String, Integer> getBARCODE_LOOKUP_TABLE() {
        return BARCODE_LOOKUP_TABLE;
    }
}
