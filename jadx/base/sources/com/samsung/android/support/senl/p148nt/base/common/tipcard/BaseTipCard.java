package com.samsung.android.support.senl.p148nt.base.common.tipcard;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/tipcard/BaseTipCard;", "", "<init>", "()V", "getBaseTipCard", "", "syncTipcard", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseTipCard {
    public static final int TIP_CARD_APP_UPDATE_FOR_SYNC = 17;
    public static final int TIP_CARD_CAN_NOT_SYNC_OVER_1GB = 10;
    public static final int TIP_CARD_CAN_NOT_SYNC_WIFI_ONLY = 15;
    public static final int TIP_CARD_CHECK_CONVERTED_NOTES = 36;
    public static final int TIP_CARD_CLOUD_SERVER_STORAGE_EXCEEDS = 14;
    public static final int TIP_CARD_CONVERT_NOTES = 21;
    public static final int TIP_CARD_CONVERT_SUGGESTION = 20;
    public static final int TIP_CARD_EDP_KEY_ERROR = 31;
    public static final int TIP_CARD_EDP_NOT_SUPPORTED = 29;
    public static final int TIP_CARD_EDP_NOT_SUPPORTED_RECOMMENT_UPDATE = 30;
    public static final int TIP_CARD_EMAIL_INVALID_ERROR = 16;
    public static final int TIP_CARD_EXTERNAL_STORAGE_NOT_GRANTED = 25;
    public static final int TIP_CARD_FAIL_TO_CONVERT_STORAGE_ERROR = 22;
    public static final int TIP_CARD_FAIL_TO_IMPORT_DEVICE_STORAGE_FULL = 4;
    public static final int TIP_CARD_FAIL_TO_IMPORT_NETWORK_ERROR = 3;
    public static final int TIP_CARD_FAIL_TO_IMPORT_SERVER_ERROR = 2;
    public static final int TIP_CARD_FAIL_TO_SYNC_NETWORK_ERROR = 7;
    public static final int TIP_CARD_FAIL_TO_SYNC_NOT_ENOUGH_DEVICE_STORAGE = 8;
    public static final int TIP_CARD_FAIL_TO_SYNC_PSM = 32;
    public static final int TIP_CARD_FAIL_TO_SYNC_SERVER_BLOCKING = 9;
    public static final int TIP_CARD_FAIL_TO_SYNC_SERVER_ERROR = 6;
    public static final int TIP_CARD_IMPORT_DOWNLOADING = 1;
    public static final int TIP_CARD_IMPORT_NOTE_FROM_ACCOUNT = 18;
    public static final int TIP_CARD_IMPORT_PDF = 26;
    public static final int TIP_CARD_IMPORT_SAMSUNG_NOTES = 24;
    public static final int TIP_CARD_MEET = 28;
    public static final int TIP_CARD_MICROSOFT_ACCOUNT_LOGIN = 23;
    public static final int TIP_CARD_MICROSOFT_ACCOUNT_LOGIN_AGAIN = 27;
    public static final int TIP_CARD_NOT_ENOUGH_CLOUD_STORAGE = 5;
    public static final int TIP_CARD_NOT_ENOUGH_CLOUD_STORAGE_IN_SETTINGS = 12;
    public static final int TIP_CARD_PERMISSION_NOT_GRANTED = 11;
    public static final int TIP_CARD_SHARE_FAIL_TO_SHARE_NOTE = 13;
    public static final int TIP_CARD_SYNC_PROGRESS_FAIL_TO_AUTO_SYNC = 34;
    public static final int TIP_CARD_SYNC_PROGRESS_FAIL_TO_SYNC_OFF = 37;
    public static final int TIP_CARD_SYNC_PROGRESS_FAIL_TO_WIFI_ONLY = 35;
    public static final int TIP_CARD_UNKNOWN = 0;

    public final int getBaseTipCard(int syncTipcard) {
        int i = 1;
        if (syncTipcard != 1) {
            i = 2;
            if (syncTipcard != 2) {
                switch (syncTipcard) {
                    case 4:
                        return 3;
                    case 8:
                        return 4;
                    case 16:
                        return 5;
                    case 32:
                        return 6;
                    case 64:
                        return 7;
                    case 128:
                        return 8;
                    case 256:
                        return 9;
                    case 512:
                        return 10;
                    case 1024:
                        return 11;
                    case 2048:
                        return 12;
                    case 4096:
                        return 13;
                    case 8192:
                        return 14;
                    case 16384:
                        return 15;
                    case 32768:
                        return 16;
                    case 65536:
                        return 17;
                    default:
                        return 0;
                }
            }
        }
        return i;
    }
}
