package p202m1;

import com.samsung.android.sdk.smp.common.exception.IErrors;
import p042J1.C0145c;

/* JADX INFO: renamed from: m1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC13528c {

    /* JADX INFO: renamed from: a */
    public static final String[] f9529a = {"SMP_0101", IErrors.ERROR_CODE_SMP_0301, IErrors.ERROR_CODE_SMP_0401, IErrors.ERROR_CODE_SMP_0501, IErrors.ERROR_CODE_SMP_0502, IErrors.ERROR_CODE_SMP_5001, IErrors.ERROR_CODE_SMP_5002};

    /* JADX INFO: renamed from: b */
    public static final String[] f9530b = {"PERMISSION_IS_NOT_GRANTED", "NETWORK_IS_NOT_AVAILABLE", "INTERNAL_ERROR", "INTERNAL_SERVER_ERROR", "INVALID_SERVER_RESPONSE", "INVALID_SPP_APP_ID", "SPP_IS_NOT_INSTALLED"};

    /* JADX INFO: renamed from: a */
    public static void m14278a(int i) {
        C0145c.m306N(i, "SMP_PREFERENCE", "smp_init_result_received");
    }
}
