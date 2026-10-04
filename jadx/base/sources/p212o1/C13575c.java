package p212o1;

import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.support.senl.p145cm.base.region.RegionUtils;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.CountryPolicyItem;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import org.json.JSONObject;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0155m;
import p044K.C0158a;
import p207n1.C13535b;
import p234q1.C14433b;

/* JADX INFO: renamed from: o1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13575c {

    /* JADX INFO: renamed from: a */
    public C13535b f9638a;

    /* JADX INFO: renamed from: b */
    public int f9639b;

    /* JADX INFO: renamed from: c */
    public CompletableFuture f9640c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX INFO: renamed from: a */
    public static void m14388a(C13575c c13575c) {
        C13573a c13573a;
        HttpURLConnection httpURLConnection;
        C14433b c14433b = new C14433b(c13575c, 13);
        synchronized (C13573a.class) {
            try {
                if (C13573a.f9633c == null) {
                    C13573a.f9633c = new C13573a(0, false);
                }
                c13573a = C13573a.f9633c;
            } catch (Throwable th) {
                throw th;
            }
        }
        c13573a.getClass();
        Debugger.m8615i("CountryPolicyApi", "[SA] requestCountryPolicy()");
        c13573a.f9635b = c14433b;
        if (!C0158a.m407a().m414e()) {
            throw new SAccountException(SettingsSAConstants.SCREEN_OLDNOTES, "fail to get the country policy! <- Network");
        }
        ?? r32 = 0;
        sb = null;
        sb = null;
        StringBuilder sb = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(RegionUtils.getAccountServerURL() + "/policy/v1/countries").openConnection();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    boolean z = AbstractC0146d.f417a;
                    httpURLConnection.setRequestProperty("User-Agent", SCloudPamHelper.getUserAgent());
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        try {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            try {
                                JSONObject jSONObjectM394i = AbstractC0155m.m394i(inputStream);
                                if (jSONObjectM394i != null) {
                                    CountryPolicyItem countryPolicyItem = new CountryPolicyItem(jSONObjectM394i);
                                    if (countryPolicyItem.parse()) {
                                        C14433b c14433b2 = (C14433b) c13573a.f9635b;
                                        if (c14433b2 != null) {
                                            ((C13575c) c14433b2.f10228b).f9640c.complete(countryPolicyItem);
                                        }
                                        c13573a.f9635b = null;
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        httpURLConnection.disconnect();
                                        return;
                                    }
                                } else {
                                    Debugger.m8609e("CountryPolicyApi", "[SA] request() : result is null!");
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Throwable th3) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                    }
                                }
                                throw th3;
                            }
                        } catch (Exception e) {
                            sb = new StringBuilder("[SA] request() : ");
                            sb.append(e);
                            Debugger.m8609e("CountryPolicyApi", sb.toString());
                        }
                    }
                    httpURLConnection.disconnect();
                    r32 = sb;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection2 = httpURLConnection;
                    Debugger.m8609e("CountryPolicyApi", "[SA] request() :: " + e);
                    r32 = httpURLConnection2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        r32 = httpURLConnection2;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                r32 = httpURLConnection;
                if (r32 != 0) {
                    r32.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        }
        throw new SAccountException("500", "fail to get the country policy!");
    }
}
