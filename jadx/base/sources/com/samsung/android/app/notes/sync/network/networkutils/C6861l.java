package com.samsung.android.app.notes.sync.network.networkutils;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.ByteArrayInOutStream;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.serverspis.SCloudServerConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import p020E.C0073a;
import p022E1.C0077c;
import p026F1.C0097a;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p191j0.C12930p;
import p191j0.C12931q;
import p211o0.C13569c;
import p212o1.C13573a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6861l {

    /* JADX INFO: renamed from: a */
    public final HashMap f4300a;

    /* JADX INFO: renamed from: b */
    public final HashMap f4301b;

    /* JADX INFO: renamed from: c */
    public final Context f4302c;

    /* JADX INFO: renamed from: d */
    public String f4303d;

    /* JADX INFO: renamed from: e */
    public String f4304e;

    /* JADX INFO: renamed from: f */
    public String f4305f;

    /* JADX INFO: renamed from: g */
    public final C6903f f4306g;

    /* JADX INFO: renamed from: h */
    public String f4307h;

    /* JADX INFO: renamed from: i */
    public String f4308i;

    /* JADX INFO: renamed from: j */
    public String f4309j;

    /* JADX INFO: renamed from: k */
    public final String f4310k;

    /* JADX INFO: renamed from: l */
    public C0073a f4311l;

    /* JADX INFO: renamed from: m */
    public InterfaceC6855f f4312m;

    /* JADX INFO: renamed from: n */
    public MultipartEntityBuilder f4313n;

    /* JADX INFO: renamed from: o */
    public final C0097a f4314o;

    public C6861l(C0077c c0077c, C0097a c0097a) {
        this.f4309j = "";
        this.f4302c = c0077c.f262e;
        C6903f c6903f = c0077c.f265h;
        this.f4306g = c6903f;
        this.f4314o = c0097a;
        this.f4300a = m5037g();
        c6903f.getClass();
        this.f4310k = "O4vARCbQ3G";
        this.f4301b = new HashMap();
    }

    /* JADX INFO: renamed from: a */
    public final void m5031a(C12930p c12930p, boolean z) throws SyncException {
        try {
            m5036f();
            C6858i c6858i = c12930p.f9101V;
            if (c6858i != null) {
                try {
                    c6858i.close();
                    c12930p.f9101V = null;
                } catch (IOException e) {
                    Debugger.m8609e("WCon_ObjectStroke", e.getMessage());
                }
            }
            C6858i c6858i2 = new C6858i(c12930p.f9100U);
            c12930p.f9101V = c6858i2;
            C0158a.m407a().getClass();
            if (SyncState.isEdpMode() && z) {
                ByteArrayInOutStream byteArrayInOutStream = new ByteArrayInOutStream();
                try {
                    if (!C13569c.m14375c().m14378b(c6858i2, byteArrayInOutStream)) {
                        throw new SyncException(312, "Fail to encrypt a file!");
                    }
                    c6858i2.f4293b = byteArrayInOutStream.getInputStream();
                    byteArrayInOutStream.close();
                } finally {
                }
            }
            String str = c12930p.f8978I.f9296a + "_" + c12930p.f8980K;
            ContentType contentType = ContentType.APPLICATION_OCTET_STREAM;
            ByteArrayInputStream byteArrayInputStream = c6858i2.f4293b;
            this.f4313n.addPart("strokeResource", new C6866q(c6858i2, contentType, str, byteArrayInputStream == null ? c6858i2.f4294c : byteArrayInputStream.available()));
        } catch (Exception e2) {
            throw new SyncException(312, e2);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m5032b(C12931q c12931q, boolean z) throws SyncException {
        try {
            m5036f();
            C6858i c6858i = c12931q.f9107X;
            if (c6858i != null) {
                try {
                    c6858i.close();
                    c12931q.f9107X = null;
                } catch (IOException e) {
                    Debugger.m8609e("WDocObjectStrokeGroup", e.getMessage());
                }
            }
            C6858i c6858i2 = new C6858i(c12931q.f9106W);
            c12931q.f9107X = c6858i2;
            C0158a.m407a().getClass();
            if (SyncState.isEdpMode() && z) {
                ByteArrayInOutStream byteArrayInOutStream = new ByteArrayInOutStream();
                try {
                    if (!C13569c.m14375c().m14378b(c6858i2, byteArrayInOutStream)) {
                        throw new SyncException(312, "Fail to encrypt a file!");
                    }
                    c6858i2.f4293b = byteArrayInOutStream.getInputStream();
                    byteArrayInOutStream.close();
                } finally {
                }
            }
            String str = c12931q.mo13811k() + "_" + c12931q.mo13808h();
            ContentType contentType = ContentType.APPLICATION_OCTET_STREAM;
            ByteArrayInputStream byteArrayInputStream = c6858i2.f4293b;
            this.f4313n.addPart("strokeGroupResource", new C6866q(c6858i2, contentType, str, byteArrayInputStream == null ? c6858i2.f4294c : byteArrayInputStream.available()));
        } catch (Exception e2) {
            throw new SyncException(312, e2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final C6862m m5033c() throws SyncException {
        if (this.f4305f == null) {
            throw new SyncException(0, "method is required");
        }
        if (TextUtils.isEmpty(this.f4304e)) {
            throw new SyncException(0, "url is null");
        }
        C6862m c6862m = new C6862m();
        c6862m.f4315a = this.f4303d;
        c6862m.f4324j = null;
        c6862m.f4316b = this.f4304e;
        c6862m.f4317c = this.f4305f;
        c6862m.f4318d = this.f4307h;
        c6862m.f4319e = this.f4308i;
        c6862m.f4320f = this.f4300a;
        c6862m.f4321g = this.f4301b;
        c6862m.f4322h = this.f4309j;
        c6862m.f4323i = this.f4302c;
        c6862m.f4325k = this.f4310k;
        c6862m.f4326l = 0;
        c6862m.f4329o = this.f4311l;
        c6862m.f4328n = null;
        c6862m.f4330p = this.f4312m;
        c6862m.f4331q = this.f4313n;
        c6862m.f4332r = this.f4314o;
        return c6862m;
    }

    /* JADX INFO: renamed from: d */
    public final C6865p m5034d() {
        this.f4305f = "GET";
        return m5033c().m5040b();
    }

    /* JADX INFO: renamed from: e */
    public final void m5035e() {
        HashMap map = this.f4300a;
        map.put("Content-Encoding", "gzip");
        map.put("Accept-Encoding", "gzip");
    }

    /* JADX INFO: renamed from: f */
    public final void m5036f() {
        if (this.f4313n == null) {
            this.f4313n = MultipartEntityBuilder.create();
            String strM320e = C0145c.m320e();
            this.f4313n.setBoundary(strM320e);
            this.f4300a.put("Content-Type", "multipart/form-data;boundary=" + strM320e);
        }
    }

    /* JADX INFO: renamed from: g */
    public final HashMap m5037g() {
        C13573a c13573a = new C13573a(9);
        C6903f c6903f = this.f4306g;
        if (c6903f != null) {
            C13573a.m14383e(c13573a, "Authorization", (String) c6903f.f4474b);
            C13573a.m14383e(c13573a, "X-SN-Transaction-ID", (String) c6903f.f4475c);
            C13573a.m14383e(c13573a, "X-SN-Feature-ID", (String) c6903f.f4476d);
        } else {
            Debugger.m8609e("SyncHttpRequest", "no connection info!");
        }
        C13573a.m14383e(c13573a, SCloudServerConstants.SDK_VERSION_HEADER, Integer.toString(5400));
        Context context = this.f4302c;
        C13573a.m14383e(c13573a, SCloudServerConstants.APP_VERSION_HEADER, AbstractC0155m.m399n(context));
        C13573a.m14383e(c13573a, SCloudServerConstants.XML_VERSION_HEADER, Integer.toString(2));
        C13573a.m14383e(c13573a, "x-sc-network", AbstractC0146d.m343b(context));
        C13573a.m14383e(c13573a, SCloudServerConstants.MODEL_NAME_HEADER, DeviceUtils.getEncodedDeviceName(context));
        C13573a.m14383e(c13573a, SCloudServerConstants.USER_AGENT_HEADER, SCloudPamHelper.getUserAgent());
        C13573a.m14383e(c13573a, "Content-Type", "application/xml;Charset=utf-8");
        return (HashMap) c13573a.f9635b;
    }

    /* JADX INFO: renamed from: h */
    public final C6865p m5038h() {
        this.f4305f = "POST";
        return m5033c().m5040b();
    }

    public C6861l(C6903f c6903f, Context context, C0097a c0097a) {
        this.f4309j = "";
        this.f4302c = context;
        this.f4306g = c6903f;
        this.f4314o = c0097a;
        this.f4300a = m5037g();
        c6903f.getClass();
        this.f4310k = "O4vARCbQ3G";
        this.f4301b = new HashMap();
    }
}
