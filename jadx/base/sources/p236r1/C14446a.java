package p236r1;

import android.os.Build;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.pam.kps.lite.KeyManagementLite;
import java.security.cert.X509Certificate;
import p211o0.C13569c;

/* JADX INFO: renamed from: r1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14446a implements KeyManagementLite {
    /* JADX INFO: renamed from: a */
    public static ScspException m15046a(KmxException kmxException) {
        kmxException.printStackTrace();
        return new ScspException(90005001, AbstractC2322a.m1616f(kmxException.getErrorCode(), "KMX ERROR : ", SQLKeyword.COMMA, kmxException.getMessage()));
    }

    @Override // com.samsung.scsp.pam.kps.lite.KeyManagementLite
    public final String getServiceKeyId(String str) throws ScspException {
        try {
            C13569c c13569cM14375c = C13569c.m14375c();
            c13569cM14375c.getClass();
            Debugger.m8615i("KmxSdkManager", "[EDP] getServiceKeyId() : " + str);
            if (Build.VERSION.SDK_INT >= 28) {
                return c13569cM14375c.f9619b.getServiceKeyId(str);
            }
            return null;
        } catch (KmxException e) {
            throw m15046a(e);
        }
    }

    @Override // com.samsung.scsp.pam.kps.lite.KeyManagementLite
    public final X509Certificate[] getWrapKey(String str) throws ScspException {
        try {
            C13569c c13569cM14375c = C13569c.m14375c();
            c13569cM14375c.getClass();
            Debugger.m8615i("KmxSdkManager", "[EDP] getWrapKey() : " + str);
            if (Build.VERSION.SDK_INT >= 28) {
                return c13569cM14375c.f9619b.getWrapKey(str);
            }
            return null;
        } catch (KmxException e) {
            throw m15046a(e);
        }
    }

    @Override // com.samsung.scsp.pam.kps.lite.KeyManagementLite
    public final String setServiceKey(String str, String str2, byte[] bArr) throws ScspException {
        try {
            C13569c c13569cM14375c = C13569c.m14375c();
            c13569cM14375c.getClass();
            Debugger.m8615i("KmxSdkManager", "[EDP] importServiceKey() : " + str);
            if (Build.VERSION.SDK_INT >= 28) {
                return c13569cM14375c.f9619b.importServiceKey(str, str2, bArr);
            }
            return null;
        } catch (KmxException e) {
            throw m15046a(e);
        }
    }
}
