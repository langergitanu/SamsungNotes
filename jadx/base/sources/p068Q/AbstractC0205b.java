package p068Q;

import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;

/* JADX INFO: renamed from: Q.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC0205b {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f636a;

    static {
        int[] iArr = new int[ShareConstants$ResultCode.values().length];
        f636a = iArr;
        try {
            iArr[ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_NOT_AUTHORIZED_EXCEPTION.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_NOT_SUPPORTED_API_EXCEPTION.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_NOT_SUCCEEDED_API_EXCEPTION.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_NOT_ENOUGH_CLOUD_STORAGE_EXCEPTION.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_NETWORK_EXCEPTION.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_SERVER_EXCEPTION.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f636a[ShareConstants$ResultCode.FAIL_WIFI_ONLY_EXCEPTION.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
