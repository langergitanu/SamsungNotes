package p122b2;

import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.scsp.common.DeviceHealthCheckPushExecutorImpl;
import com.samsung.scsp.error.LoggerConfig;
import com.samsung.scsp.pam.kps.lite.KpsGetPolicyJobImpl;
import java.util.function.Supplier;
import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: b2.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4194q implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1808a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1809b;

    public /* synthetic */ C4194q(String str, int i) {
        this.f1808a = i;
        this.f1809b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1808a) {
            case 0:
                return ContinuitySession.lambda$handlePeerDisconnected$7(this.f1809b);
            case 1:
                return ContinuitySession.lambda$forceDisconnect$9(this.f1809b);
            case 2:
                return DeviceHealthCheckPushExecutorImpl.lambda$accept$0(this.f1809b);
            case 3:
                return LoggerConfig.lambda$new$0(this.f1809b);
            case 4:
                return KpsGetPolicyJobImpl.lambda$onStream$2(this.f1809b);
            case 5:
                return SystemProperties.lambda$getProperty$0(this.f1809b);
            case 6:
                return LogFactory.lambda$getFactory$11(this.f1809b);
            case 7:
                return LogFactory.lambda$getFactory$4(this.f1809b);
            case 8:
                return LogFactory.lambda$implementsLogFactory$19(this.f1809b);
            default:
                return LogFactory.lambda$implementsLogFactory$20(this.f1809b);
        }
    }
}
