package p211o0;

import android.content.Context;
import android.os.Build;
import com.samsung.android.kmxservice.sdk.e2ee.KmxE2EEManager;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.ByteArrayInOutStream;
import java.io.InputStream;
import p001A.AbstractC0000a;
import p020E.C0073a;

/* JADX INFO: renamed from: o0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13569c {

    /* JADX INFO: renamed from: e */
    public static C13569c f9617e;

    /* JADX INFO: renamed from: a */
    public final Context f9618a;

    /* JADX INFO: renamed from: b */
    public final KmxE2EEManager f9619b;

    /* JADX INFO: renamed from: c */
    public Boolean f9620c = null;

    /* JADX INFO: renamed from: d */
    public final C0073a f9621d;

    public C13569c(Context context) {
        C0073a c0073a = new C0073a(this, 11);
        this.f9621d = c0073a;
        this.f9618a = context;
        if (this.f9619b == null) {
            KmxSdk.initialize(context, c0073a);
            try {
                this.f9619b = KmxE2EEManager.getInstance();
            } catch (KmxException e) {
                Debugger.m8609e("KmxSdkManager", "[EDP] setupKMX() : " + e);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C13569c m14375c() {
        try {
            if (f9617e == null) {
                f9617e = new C13569c(BaseUtils.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9617e;
    }

    /* JADX INFO: renamed from: d */
    public static synchronized C13569c m14376d(Context context) {
        try {
            if (f9617e == null) {
                f9617e = new C13569c(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9617e;
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m14377a(byte[] bArr) {
        try {
            return this.f9619b.decryptData("si-6vqcx5t", bArr);
        } catch (Exception e) {
            AbstractC0000a.m22s("[EDP] decoding() : ", e, "KmxSdkManager");
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m14378b(InputStream inputStream, ByteArrayInOutStream byteArrayInOutStream) {
        try {
            return this.f9619b.encryptStream("si-6vqcx5t", inputStream, byteArrayInOutStream);
        } catch (Exception e) {
            AbstractC0000a.m22s("[EDP] encryptStream() : ", e, "KmxSdkManager");
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    public final String m14379e() {
        try {
            return this.f9619b.getSAKUid();
        } catch (Exception e) {
            AbstractC0000a.m22s("[EDP] getSakUid() : ", e, "KmxSdkManager");
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public final String m14380f() {
        Debugger.m8615i("KmxSdkManager", "[EDP] getServiceKeyId()");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return this.f9619b.getServiceKeyId("si-6vqcx5t");
            }
            return null;
        } catch (Exception e) {
            AbstractC0000a.m22s("[EDP] getServiceKeyId() : ", e, "KmxSdkManager");
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public final boolean m14381g() {
        Boolean bool = this.f9620c;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(this.f9619b.getE2EEDeviceType() != 0);
        this.f9620c = boolValueOf;
        return boolValueOf.booleanValue();
    }
}
