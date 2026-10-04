package com.samsung.android.app.notes.sync.network.networkutils;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import p001A.AbstractC0000a;
import p042J1.AbstractC0153k;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p187i1.C12033b;
import p195k1.C12969a;
import p211o0.C13569c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.networkutils.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6865p {

    /* JADX INFO: renamed from: a */
    public int f4344a;

    /* JADX INFO: renamed from: b */
    public HashMap f4345b;

    /* JADX INFO: renamed from: c */
    public String f4346c;

    /* JADX INFO: renamed from: d */
    public InputStream f4347d;

    /* JADX INFO: renamed from: e */
    public String f4348e;

    /* JADX INFO: renamed from: f */
    public String f4349f;

    /* JADX INFO: renamed from: g */
    public String f4350g;

    /* JADX INFO: renamed from: h */
    public Context f4351h;

    /* JADX INFO: renamed from: i */
    public InterfaceC6855f f4352i;

    /* JADX INFO: renamed from: j */
    public String f4353j;

    /* JADX INFO: renamed from: k */
    public InterfaceC6864o f4354k;

    /* JADX INFO: renamed from: a */
    public static void m5047a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Debugger.m8609e("SyncHttpResponse", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m5048b(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Exception e;
        BufferedReader bufferedReader;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        if (bArr[0] == 31 && bArr[1] == -117) {
            BufferedReader bufferedReader2 = null;
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, StandardCharsets.UTF_8));
                    while (true) {
                        try {
                            try {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    sb2.append(line);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e2) {
                                        AbstractC0000a.m21r(e2, new StringBuilder("decompress() : "), "SyncHttpResponse");
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                Debugger.m8609e("SyncHttpResponse", e.getMessage());
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e5) {
                                        AbstractC0000a.m21r(e5, new StringBuilder("decompress() : "), "SyncHttpResponse");
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Exception e6) {
                                        e = e6;
                                        sb = new StringBuilder("decompress() : ");
                                        AbstractC0000a.m21r(e, sb, "SyncHttpResponse");
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e7) {
                                    AbstractC0000a.m21r(e7, new StringBuilder("decompress() : "), "SyncHttpResponse");
                                }
                            }
                            if (gZIPInputStream != null) {
                                throw th;
                            }
                            try {
                                gZIPInputStream.close();
                                throw th;
                            } catch (Exception e8) {
                                AbstractC0000a.m21r(e8, new StringBuilder("decompress() : "), "SyncHttpResponse");
                                throw th;
                            }
                        }
                    }
                    bufferedReader.close();
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e9) {
                        e = e9;
                        sb = new StringBuilder("decompress() : ");
                        AbstractC0000a.m21r(e, sb, "SyncHttpResponse");
                    }
                } catch (Exception e10) {
                    e = e10;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    if (gZIPInputStream != null) {
                    }
                }
            } catch (Exception e11) {
                gZIPInputStream = null;
                e = e11;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
            }
        } else {
            sb2.append(bArr);
        }
        return sb2.toString();
    }

    /* JADX INFO: renamed from: c */
    public final long m5049c() {
        if (this.f4345b.containsKey("Retry-After")) {
            return Long.parseLong((String) C6903f.m5120e((String) this.f4345b.get("Retry-After")).f4475c);
        }
        if (this.f4345b.containsKey("Retry-After".toLowerCase())) {
            return Long.parseLong((String) C6903f.m5120e((String) this.f4345b.get("Retry-After".toLowerCase())).f4475c);
        }
        return -1L;
    }

    /* JADX INFO: renamed from: d */
    public final void m5050d() throws SyncException {
        boolean zDelete;
        boolean zContains = false;
        if (!TextUtils.isEmpty((CharSequence) this.f4345b.get("Content-Encoding")) ? ((String) this.f4345b.get("Content-Encoding")).contains("gzip") : !TextUtils.isEmpty((CharSequence) this.f4345b.get("Content-Encoding".toLowerCase())) ? ((String) this.f4345b.get("Content-Encoding".toLowerCase())).contains("gzip") : false) {
            if (this.f4347d != null) {
                try {
                    this.f4347d = new GZIPInputStream(this.f4347d);
                } catch (IOException e) {
                    m5047a(this.f4347d);
                    throw new SyncException(312, e);
                }
            } else {
                String str = this.f4346c;
                if (str != null) {
                    try {
                        this.f4346c = m5048b(str.getBytes(StandardCharsets.UTF_8));
                    } catch (IOException e2) {
                        m5047a(this.f4347d);
                        throw new SyncException(312, e2);
                    }
                }
            }
        }
        if (AbstractC0153k.m373b(this.f4351h) && this.f4346c != null) {
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f452a = this.f4348e;
            c0152jM378g.f457f = this.f4350g;
            int i = this.f4344a;
            c0152jM378g.f458g = i;
            c0152jM378g.f453b = "res";
            c0152jM378g.f456e = this.f4353j;
            c0152jM378g.f455d = this.f4346c;
            c0152jM378g.f460i = this.f4345b;
            c0152jM378g.f463l = i != 302 && 300 <= i;
            c0152jM378g.f454c = i != 302 && 300 <= i ? "error" : "";
            c0152jM378g.m371b(this.f4351h);
        }
        int i2 = this.f4344a;
        if (i2 != 302 && 300 <= i2) {
            Debugger.m8609e("SyncHttpResponse", "errorResponse : body = " + this.f4346c);
        } else if (!this.f4348e.equals("compareForDownsync")) {
            Debugger.m8616s("SyncHttpResponse", "Response : body = " + this.f4346c);
        }
        if (this.f4349f != null) {
            File file = (AbstractC4539a.m3210t() && AbstractC0299q.f769b) ? new File(AbstractC0622a.m1170p(this.f4349f, "_", new StringBuilder())) : new File(this.f4349f);
            String parent = file.getParent();
            if (TextUtils.isEmpty(parent)) {
                throw new SyncException(312, "Fail to makeDirectory!");
            }
            FileUtils.makeDirectory(parent);
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i4 = this.f4347d.read(bArr);
                            if (i4 == -1) {
                                break;
                            }
                            InterfaceC6855f interfaceC6855f = this.f4352i;
                            if (interfaceC6855f != null) {
                                interfaceC6855f.mo142h();
                            }
                            fileOutputStream.write(bArr, 0, i4);
                        }
                        fileOutputStream.close();
                        m5047a(this.f4347d);
                        C0158a.m407a().getClass();
                        if (SyncState.isEdpMode() && AbstractC0299q.f769b) {
                            File file2 = new File(this.f4349f);
                            try {
                                try {
                                    FileInputStream fileInputStream = new FileInputStream(file);
                                    try {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                        try {
                                            C13569c c13569cM14375c = C13569c.m14375c();
                                            c13569cM14375c.getClass();
                                            try {
                                                c13569cM14375c.f9619b.decryptStream("si-6vqcx5t", fileInputStream, fileOutputStream2);
                                            } catch (Exception e3) {
                                                Debugger.m8609e("KmxSdkManager", "[EDP] decryptStream() : " + e3);
                                            }
                                            while (true) {
                                                int i5 = System.in.read();
                                                if (i5 == -1) {
                                                    break;
                                                } else {
                                                    fileOutputStream2.write(i5);
                                                }
                                            }
                                            fileOutputStream2.close();
                                            fileInputStream.close();
                                            if (zDelete) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                        throw th;
                                    }
                                } catch (IOException e5) {
                                    throw new SyncException(312, e5);
                                }
                            } finally {
                                if (!file.delete()) {
                                    Debugger.m8609e("SyncHttpResponse", "fail to delete temp file");
                                }
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    m5047a(this.f4347d);
                    throw th5;
                }
            } catch (SocketTimeoutException e6) {
                throw new SyncException(321, e6.getMessage());
            } catch (IOException e7) {
                throw new SyncException(312, e7);
            }
        }
        if (this.f4345b.get("Content-Type") != null && this.f4347d != null) {
            zContains = ((String) this.f4345b.get("Content-Type")).contains("multipart/form-data");
        } else if (this.f4345b.get("Content-Type".toLowerCase()) != null && this.f4347d != null) {
            zContains = ((String) this.f4345b.get("Content-Type".toLowerCase())).contains("multipart/form-data");
        }
        if (!zContains) {
            return;
        }
        StringBuilder sbM1324q = AbstractC0153k.m373b(this.f4351h) ? AbstractC1974b.m1324q("downSyncedStrokeResources\n") : null;
        try {
            try {
                String str2 = (String) this.f4345b.get("Content-Type");
                if (str2 == null) {
                    str2 = (String) this.f4345b.get("Content-Type".toLowerCase());
                }
                Map map = (Map) C6903f.m5120e(str2).f4476d;
                String str3 = map != null ? (String) map.get("boundary") : null;
                if (str3 == null) {
                    throw new SyncException(315, "No boundary!");
                }
                C12033b c12033b = new C12033b(this.f4347d, str3.getBytes(StandardCharsets.UTF_8));
                int i6 = 1;
                for (boolean zM13730f = c12033b.m13730f(); zM13730f; zM13730f = c12033b.m13727c()) {
                    InterfaceC6855f interfaceC6855f2 = this.f4352i;
                    if (interfaceC6855f2 != null) {
                        interfaceC6855f2.mo142h();
                    }
                    C12969a c12969a = new C12969a();
                    try {
                        c12969a.m13876e(c12033b.m13729e());
                        c12969a.m13879h(c12033b);
                        if (((String) c12969a.f9311e).contains("application/octet-stream")) {
                            this.f4354k.handleBinaryBody((String) c12969a.f9309c, (String) c12969a.f9308b, (byte[]) c12969a.f9310d);
                            if (sbM1324q != null) {
                                sbM1324q.append(i6);
                                sbM1324q.append(" : ");
                                sbM1324q.append((String) c12969a.f9308b);
                                sbM1324q.append('\n');
                            }
                            if ("strokeResource".equals((String) c12969a.f9309c)) {
                                if (i6 % 1000 == 1) {
                                    Debugger.m8615i("SyncHttpResponse", "download stroke " + i6);
                                }
                            } else if ("strokeGroupResource".equals((String) c12969a.f9309c) && i6 % 10 == 1) {
                                Debugger.m8615i("SyncHttpResponse", "download stroke group " + i6);
                            }
                            i6++;
                        } else {
                            if (AbstractC0153k.m373b(this.f4351h)) {
                                C0152j c0152jM378g2 = AbstractC0153k.m378g();
                                c0152jM378g2.f452a = this.f4348e;
                                c0152jM378g2.f458g = this.f4344a;
                                c0152jM378g2.f453b = "res";
                                c0152jM378g2.f455d = (String) c12969a.f9307a;
                                c0152jM378g2.f462k = true;
                                c0152jM378g2.f457f = this.f4350g;
                                c0152jM378g2.f454c = "xmlpart";
                                c0152jM378g2.m371b(this.f4351h);
                            }
                            this.f4354k.handleStringBody((String) c12969a.f9309c, (String) c12969a.f9307a);
                        }
                    } catch (IOException e8) {
                        throw new SyncException(312, e8);
                    }
                }
                Debugger.m8615i("SyncHttpResponse", "download total stroke " + (i6 - 1));
                InputStream inputStream = this.f4347d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        this.f4347d = null;
                    } catch (IOException e9) {
                        Debugger.m8609e("SyncHttpResponse", e9.getMessage());
                    }
                }
                if (sbM1324q != null) {
                    C0152j c0152jM378g3 = AbstractC0153k.m378g();
                    c0152jM378g3.f454c = "downSyncedStrokeResources";
                    c0152jM378g3.f455d = sbM1324q.toString();
                    c0152jM378g3.m371b(this.f4351h);
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new SyncException(312, e10);
        }
    }

    public final String toString() {
        return "SyncHttpResponse[statusCode = " + this.f4344a + ", apiName = " + this.f4348e + ", headers = " + this.f4345b + ", body = " + this.f4346c;
    }
}
