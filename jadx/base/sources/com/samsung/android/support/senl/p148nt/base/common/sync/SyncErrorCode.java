package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0005H\u0007J\u001c\u0010+\u001a\u00020,2\n\u0010-\u001a\u00060.j\u0002`/2\u0006\u0010*\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/SyncErrorCode;", "", "<init>", "()V", "ERROR_CODE_NOERROR", "", "ERROR_CODE_UNKNOWN", "ERROR_CODE_NOT_ENOUGH_CLOUD_STORAGE", "ERROR_CODE_NETWORK_ERROR", "ERROR_CODE_PERMISSION_NOT_GRANTED", "ERROR_CODE_CANNOT_SYNC_WIFI_ONLY", "ERROR_CODE_DEVICE_STORAGE_FULL", "ERROR_CODE_NO_SAMSUNG_ACCOUNT_PACKAGE", "ERROR_CODE_SAMSUNG_ACCOUNT_ERROR", "ERROR_CODE_NOT_LOGGED_IN", "ERROR_CODE_SERVER_BLOCKED_ERROR", "ERROR_CODE_NATIONAL_DISASTER_NET", "ERROR_CODE_UNPACK_DEVICE", "ERROR_CODE_RDU_MODEL", "ERROR_CODE_KNOX_MODE", "ERROR_CODE_POWER_MANAGE_MODE", "ERROR_CODE_BLOCKED_BY_INTERNAL_TASKS", "ERROR_CODE_DISABLED_MASTER_SYNC", "ERROR_CODE_BLOCKED_BY_CLOUD_SETTING", "ERROR_CODE_DISABLED_AUTO_SYNC", "ERROR_CODE_DATA_NETWORK_NOT_AVAILABLE", "ERROR_CODE_NO_PERSONAL_INFO", "ERROR_CODE_NO_PRIVACY_NOTICE", "ERROR_CODE_BLOCKED_BY_SMART_SWITCH", "ERROR_CODE_SAMSUNG_CLOUD", "ERROR_CODE_DISABLE_RECYCLE_BIN_MODEL", "ERROR_CODE_UNSUPPORTED_EDP_DEVICE", "ERROR_CODE_INVALID_KEY_BY_EDP", "ERROR_CODE_POWER_SAVING_MODE", "ERROR_CODE_CANNOT_EXCEED_1G", "ERROR_CODE_SERVER_ERROR", "ERROR_CODE_CANNOT_IMPORT_NOTES", "ERROR_CODE_GOOGLEDRIVE_AUTHENTICATION", "mErrorCodeHashMap", "", "", "getErrorCodesString", "errorCode", "getErrorCodeString", "", "fullErrorString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncErrorCode {
    public static final int ERROR_CODE_BLOCKED_BY_CLOUD_SETTING = 116;
    public static final int ERROR_CODE_BLOCKED_BY_INTERNAL_TASKS = 114;
    public static final int ERROR_CODE_BLOCKED_BY_SMART_SWITCH = 121;
    public static final int ERROR_CODE_CANNOT_EXCEED_1G = 200;
    public static final int ERROR_CODE_CANNOT_IMPORT_NOTES = 900;
    public static final int ERROR_CODE_CANNOT_SYNC_WIFI_ONLY = 103;
    public static final int ERROR_CODE_DATA_NETWORK_NOT_AVAILABLE = 118;
    public static final int ERROR_CODE_DEVICE_STORAGE_FULL = 104;
    public static final int ERROR_CODE_DISABLED_AUTO_SYNC = 117;
    public static final int ERROR_CODE_DISABLED_MASTER_SYNC = 115;
    public static final int ERROR_CODE_DISABLE_RECYCLE_BIN_MODEL = 123;
    public static final int ERROR_CODE_GOOGLEDRIVE_AUTHENTICATION = 901;
    public static final int ERROR_CODE_INVALID_KEY_BY_EDP = 125;
    public static final int ERROR_CODE_KNOX_MODE = 112;
    public static final int ERROR_CODE_NATIONAL_DISASTER_NET = 109;
    public static final int ERROR_CODE_NETWORK_ERROR = 101;
    public static final int ERROR_CODE_NOERROR = 0;
    public static final int ERROR_CODE_NOT_ENOUGH_CLOUD_STORAGE = 100;
    public static final int ERROR_CODE_NOT_LOGGED_IN = 107;
    public static final int ERROR_CODE_NO_PERSONAL_INFO = 119;
    public static final int ERROR_CODE_NO_PRIVACY_NOTICE = 120;
    public static final int ERROR_CODE_NO_SAMSUNG_ACCOUNT_PACKAGE = 105;
    public static final int ERROR_CODE_PERMISSION_NOT_GRANTED = 102;
    public static final int ERROR_CODE_POWER_MANAGE_MODE = 113;
    public static final int ERROR_CODE_POWER_SAVING_MODE = 126;
    public static final int ERROR_CODE_RDU_MODEL = 111;
    public static final int ERROR_CODE_SAMSUNG_ACCOUNT_ERROR = 106;
    public static final int ERROR_CODE_SAMSUNG_CLOUD = 122;
    public static final int ERROR_CODE_SERVER_BLOCKED_ERROR = 108;
    public static final int ERROR_CODE_SERVER_ERROR = 201;
    public static final int ERROR_CODE_UNKNOWN = 1;
    public static final int ERROR_CODE_UNPACK_DEVICE = 110;
    public static final int ERROR_CODE_UNSUPPORTED_EDP_DEVICE = 124;

    @NotNull
    public static final SyncErrorCode INSTANCE = new SyncErrorCode();

    @NotNull
    private static final Map<Integer, String> mErrorCodeHashMap;

    static {
        HashMap map = new HashMap();
        mErrorCodeHashMap = map;
        AbstractC6670b.m4751l(0, map, "ERROR_CODE_NOERROR", 1, "ERROR_CODE_UNKNOWN");
        AbstractC6670b.m4751l(100, map, "ERROR_CODE_NOT_ENOUGH_CLOUD_STORAGE", 200, "ERROR_CODE_CANNOT_EXCEED_1G");
        AbstractC6670b.m4751l(101, map, "ERROR_CODE_NETWORK_ERROR", 201, "ERROR_CODE_SERVER_ERROR");
        AbstractC6670b.m4751l(102, map, "ERROR_CODE_PERMISSION_NOT_GRANTED", 103, "ERROR_CODE_CANNOT_SYNC_WIFI_ONLY");
        AbstractC6670b.m4751l(104, map, "ERROR_CODE_DEVICE_STORAGE_FULL", 105, "ERROR_CODE_NO_SAMSUNG_ACCOUNT_PACKAGE");
        AbstractC6670b.m4751l(106, map, "ERROR_CODE_EMAIL_INVALID_ERROR", 107, "ERROR_CODE_NOT_LOGGED_IN");
        AbstractC6670b.m4751l(108, map, "ERROR_CODE_SERVER_BLOCKED_ERROR", 109, "ERROR_CODE_NATIONAL_DISASTER_NET");
        AbstractC6670b.m4751l(110, map, "ERROR_CODE_UNPACK_DEVICE", 111, "ERROR_CODE_RDU_MODEL");
        AbstractC6670b.m4751l(112, map, "ERROR_CODE_KNOX_MODE", 113, "ERROR_CODE_POWER_MANAGE_MODE");
        AbstractC6670b.m4751l(114, map, "ERROR_CODE_BLOCKED_BY_INTERNAL_TASKS", 115, "ERROR_CODE_DISABLED_MASTER_SYNC");
        AbstractC6670b.m4751l(116, map, "ERROR_CODE_BLOCKED_BY_CLOUD_SETTING", 117, "ERROR_CODE_DISABLED_AUTO_SYNC");
        AbstractC6670b.m4751l(118, map, "ERROR_CODE_DATA_NETWORK_NOT_AVAILABLE", 119, "ERROR_CODE_NO_PERSONAL_INFO");
        AbstractC6670b.m4751l(120, map, "ERROR_CODE_NO_PRIVACY_NOTICE", 121, "ERROR_CODE_BLOCKED_BY_SMART_SWITCH");
        AbstractC6670b.m4751l(122, map, "ERROR_CODE_SAMSUNG_CLOUD", 123, "ERROR_CODE_DISABLE_RECYCLE_BIN_MODEL");
        AbstractC6670b.m4751l(124, map, "ERROR_CODE_UNSUPPORTED_EDP_DEVICE", 125, "ERROR_CODE_INVALID_KEY_BY_EDP");
        AbstractC6670b.m4751l(126, map, "ERROR_CODE_POWER_SAVING_MODE", 900, "ERROR_CODE_CANNOT_IMPORT_NOTES");
        map.put(901, "ERROR_CODE_GOOGLEDRIVE_AUTHENTICATION");
    }

    private SyncErrorCode() {
    }

    private final void getErrorCodeString(StringBuilder fullErrorString, int errorCode) {
        fullErrorString.append("[");
        fullErrorString.append(mErrorCodeHashMap.get(Integer.valueOf(errorCode)));
        fullErrorString.append("]");
    }

    @JvmStatic
    @NotNull
    public static final String getErrorCodesString(int errorCode) {
        StringBuilder sb = new StringBuilder();
        INSTANCE.getErrorCodeString(sb, errorCode);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
