package com.samsung.android.app.notes.sync.network.networkutils;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.ByteArrayInOutStream;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.GzipCompressingEntity;
import org.apache.http.client.methods.HttpDeleteHC4;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.client.methods.HttpPutHC4;
import org.apache.http.client.methods.HttpRequestBaseHC4;
import org.apache.http.entity.InputStreamEntityHC4;
import org.apache.http.entity.StringEntityHC4;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p211o0.C13569c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6862m {

    /* JADX INFO: renamed from: a */
    public String f4315a;

    /* JADX INFO: renamed from: b */
    public String f4316b;

    /* JADX INFO: renamed from: c */
    public String f4317c;

    /* JADX INFO: renamed from: d */
    public String f4318d;

    /* JADX INFO: renamed from: e */
    public String f4319e;

    /* JADX INFO: renamed from: f */
    public HashMap f4320f;

    /* JADX INFO: renamed from: g */
    public HashMap f4321g;

    /* JADX INFO: renamed from: h */
    public String f4322h;

    /* JADX INFO: renamed from: i */
    public Context f4323i;

    /* JADX INFO: renamed from: j */
    public InputStream f4324j;

    /* JADX INFO: renamed from: k */
    public String f4325k;

    /* JADX INFO: renamed from: l */
    public int f4326l;

    /* JADX INFO: renamed from: m */
    public C6865p f4327m;

    /* JADX INFO: renamed from: n */
    public HttpEntity f4328n;

    /* JADX INFO: renamed from: o */
    public C0073a f4329o;

    /* JADX INFO: renamed from: p */
    public InterfaceC6855f f4330p;

    /* JADX INFO: renamed from: q */
    public MultipartEntityBuilder f4331q;

    /* JADX INFO: renamed from: r */
    public C0097a f4332r;

    /* JADX INFO: renamed from: a */
    public final C6863n m5039a() {
        C6863n c6863n = new C6863n();
        c6863n.f4338f = this.f4322h;
        c6863n.f4339g = this.f4323i;
        c6863n.f4340h = this.f4317c;
        c6863n.f4337e = this.f4316b;
        c6863n.f4341i = this.f4329o;
        c6863n.f4342j = this.f4319e;
        c6863n.f4343k = this.f4330p;
        return c6863n;
    }

    /* JADX INFO: renamed from: b */
    public final C6865p m5040b() {
        String string;
        HttpRequestBaseHC4 httpRequestBaseHC4;
        HttpEntity httpEntity;
        string = this.f4316b;
        HashMap map = this.f4321g;
        if (map != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!string.contains(MsalUtils.QUERY_STRING_SYMBOL)) {
                sb.append('?');
            }
            boolean zEndsWith = sb.toString().endsWith(MsalUtils.QUERY_STRING_DELIMITER);
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0299q.m627f(sb, (String) entry.getKey(), (String) entry.getValue(), zEndsWith);
                zEndsWith = false;
            }
            string = sb.toString();
        }
        MultipartEntityBuilder multipartEntityBuilder = this.f4331q;
        if (multipartEntityBuilder != null) {
            this.f4328n = multipartEntityBuilder.build();
        } else {
            String str = this.f4315a;
            if (str != null) {
                StringEntityHC4 stringEntityHC4 = new StringEntityHC4(str, "UTF-8");
                stringEntityHC4.setContentType(m5041c("Content-Type"));
                this.f4328n = stringEntityHC4;
            } else {
                InputStream inputStream = this.f4324j;
                if (inputStream != null) {
                    this.f4328n = m5042d(inputStream);
                } else if (this.f4318d != null) {
                    try {
                        C0158a.m407a().getClass();
                        if (SyncState.isEdpMode() && NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(this.f4332r.f319b)) {
                            FileInputStream fileInputStream = new FileInputStream(this.f4318d);
                            try {
                                ByteArrayInOutStream byteArrayInOutStream = new ByteArrayInOutStream();
                                try {
                                    if (!C13569c.m14375c().m14378b(fileInputStream, byteArrayInOutStream)) {
                                        throw new SyncException(312, "Fail to encrypt a file!");
                                    }
                                    this.f4324j = byteArrayInOutStream.getInputStream();
                                    byteArrayInOutStream.close();
                                    fileInputStream.close();
                                } finally {
                                }
                            } finally {
                            }
                        } else {
                            this.f4324j = new FileInputStream(this.f4318d);
                        }
                        this.f4328n = m5042d(this.f4324j);
                    } catch (IOException e) {
                        throw new SyncException(312, e);
                    }
                }
            }
        }
        if (m5044f("Content-Encoding", "gzip") && (httpEntity = this.f4328n) != null) {
            this.f4328n = new GzipCompressingEntity(httpEntity);
        }
        String str2 = this.f4317c;
        str2.getClass();
        switch (str2) {
            case "GET":
                HttpGetHC4 httpGetHC4 = new HttpGetHC4(string);
                this.f4320f.remove("Content-Encoding");
                this.f4320f.remove("Content-Type");
                httpRequestBaseHC4 = httpGetHC4;
                break;
            case "PUT":
                HttpPutHC4 httpPutHC4 = new HttpPutHC4(string);
                httpPutHC4.setEntity(this.f4328n);
                httpRequestBaseHC4 = httpPutHC4;
                break;
            case "POST":
                HttpPostHC4 httpPostHC4 = new HttpPostHC4(string);
                httpPostHC4.setEntity(this.f4328n);
                httpRequestBaseHC4 = httpPostHC4;
                break;
            case "PATCH":
                HttpPatch httpPatch = new HttpPatch(string);
                httpPatch.setEntity(this.f4328n);
                httpRequestBaseHC4 = httpPatch;
                break;
            case "DELETE":
                HttpDeleteHC4 httpDeleteHC4 = new HttpDeleteHC4(string);
                this.f4320f.remove("Content-Encoding");
                httpRequestBaseHC4 = httpDeleteHC4;
                break;
            default:
                throw new SyncException(326, "method was not set");
        }
        Debugger.m8615i("SyncHttpRequest", this.f4317c + " " + this.f4316b + ", transactionId = " + m5041c("X-SN-Transaction-ID") + ", featureId = " + m5041c("X-SN-Feature-ID"));
        if (AbstractC0153k.m373b(this.f4323i)) {
            String str3 = (this.f4315a == null || this.f4328n == null) ? null : "xmlpart";
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f452a = this.f4322h;
            c0152jM378g.f453b = "req";
            c0152jM378g.f457f = this.f4316b;
            c0152jM378g.f456e = this.f4317c;
            c0152jM378g.f460i = this.f4320f;
            c0152jM378g.f461j = this.f4321g;
            c0152jM378g.f454c = str3;
            c0152jM378g.f455d = this.f4315a;
            c0152jM378g.m371b(this.f4323i);
        }
        for (Map.Entry entry2 : this.f4320f.entrySet()) {
            httpRequestBaseHC4.addHeader((String) entry2.getKey(), (String) entry2.getValue());
        }
        boolean zM3210t = AbstractC4539a.m3210t();
        String str4 = CoverStickerConstants.Category.NONE.NAME;
        if (zM3210t) {
            C0097a c0097a = this.f4332r;
            if (c0097a != null && !TextUtils.isEmpty(c0097a.f319b)) {
                str4 = this.f4332r.f319b;
            }
            Debugger.m8615i("SyncHttpRequest", "[EDP] x-sc-e2ee-state = " + str4);
            httpRequestBaseHC4.addHeader("x-sc-e2ee-state", str4);
        } else {
            C0097a c0097a2 = this.f4332r;
            if (c0097a2 != null && c0097a2.f318a >= 3) {
                Debugger.m8607d("SyncHttpRequest", "[EDP] x-sc-e2ee-state = NONE by V3+");
                httpRequestBaseHC4.addHeader("x-sc-e2ee-state", CoverStickerConstants.Category.NONE.NAME);
            }
        }
        try {
            try {
                AbstractC6854e.m5021a(this.f4325k, httpRequestBaseHC4, m5043e());
                C6865p c6865p = this.f4327m;
                if (c6865p == null) {
                    throw new SyncException(315, "response is null");
                }
                int i = c6865p.f4344a;
                if (i == 302) {
                    this.f4316b = (String) c6865p.f4345b.get("Location");
                    m5040b();
                } else if (i == 251) {
                    int i2 = this.f4326l;
                    if (3 < i2) {
                        throw new SyncException(315, "network fail after retry =" + this.f4326l);
                    }
                    this.f4326l = i2 + 1;
                    m5040b();
                }
                return this.f4327m;
            } catch (SyncException e2) {
                InterfaceC6855f interfaceC6855f = this.f4330p;
                if (interfaceC6855f != null) {
                    interfaceC6855f.mo142h();
                } else {
                    Debugger.m8609e("SyncHttpRequest", "mSyncErrorChecker is null!");
                }
                throw e2;
            }
        } finally {
            InputStream inputStream2 = this.f4324j;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    Debugger.m8610e("SyncHttpRequest", "failed to close inputStream", e3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final String m5041c(String str) {
        String str2 = (String) this.f4320f.get(str);
        return str2 == null ? (String) this.f4320f.get(str.toLowerCase()) : str2;
    }

    /* JADX INFO: renamed from: d */
    public final InputStreamEntityHC4 m5042d(InputStream inputStream) throws SyncException {
        try {
            int iAvailable = inputStream.available();
            StringBuilder sb = new StringBuilder("bytes=0-");
            sb.append(iAvailable - 1);
            this.f4320f.put("Range", sb.toString());
            InputStreamEntityHC4 inputStreamEntityHC4 = new InputStreamEntityHC4(inputStream);
            inputStreamEntityHC4.setContentType(m5041c("Content-Type"));
            return inputStreamEntityHC4;
        } catch (IOException e) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                AbstractC0000a.m20q(e2, new StringBuilder("upload err : "), "SyncHttpRequest");
            }
            throw new SyncException(312, e);
        }
    }

    /* JADX INFO: renamed from: e */
    public final InterfaceC6852c m5043e() {
        return (this.f4319e != null || m5044f("Accept", "multipart/form-data")) ? new C6859j(this) : new C6860k(this);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m5044f(String str, String str2) {
        if (!TextUtils.isEmpty((CharSequence) this.f4320f.get(str))) {
            return ((String) this.f4320f.get(str)).contains(str2);
        }
        if (TextUtils.isEmpty((CharSequence) this.f4320f.get(str.toLowerCase()))) {
            return false;
        }
        return ((String) this.f4320f.get(str.toLowerCase())).contains(str2);
    }
}
