package p042J1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.util.IOUtils;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import p007B0.C0027j;
import p186h1.C12020a;

/* JADX INFO: renamed from: J1.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0152j {

    /* JADX INFO: renamed from: a */
    public String f452a;

    /* JADX INFO: renamed from: b */
    public String f453b;

    /* JADX INFO: renamed from: c */
    public String f454c;

    /* JADX INFO: renamed from: d */
    public String f455d;

    /* JADX INFO: renamed from: e */
    public String f456e;

    /* JADX INFO: renamed from: f */
    public String f457f;

    /* JADX INFO: renamed from: g */
    public int f458g;

    /* JADX INFO: renamed from: h */
    public Date f459h;

    /* JADX INFO: renamed from: i */
    public HashMap f460i;

    /* JADX INFO: renamed from: j */
    public HashMap f461j;

    /* JADX INFO: renamed from: k */
    public boolean f462k;

    /* JADX INFO: renamed from: l */
    public boolean f463l;

    /* JADX INFO: renamed from: m */
    public SimpleDateFormat f464m;

    /* JADX INFO: renamed from: a */
    public final void m370a() {
        if (AbstractC0153k.f466b == null) {
            AbstractC0153k.f466b = new C0027j("SyncLogs");
        }
        C0027j.m50a(AbstractC0153k.f466b);
        if (this.f463l) {
            if (AbstractC0153k.f465a == null) {
                AbstractC0153k.f465a = new C0027j("SyncLogError");
            }
            C0027j.m50a(AbstractC0153k.f465a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m371b(Context context) {
        String str;
        String str2;
        String str3;
        try {
            if (AbstractC0153k.m373b(context)) {
                String str4 = this.f452a;
                if (str4 == null || !(str4.equals("uploadFile") || str4.equals("downloadFile"))) {
                    m370a();
                    this.f459h = Calendar.getInstance().getTime();
                    HashMap map = this.f460i;
                    if (map != null) {
                        String str5 = (String) map.get("Content-Type");
                        if (str5 == null) {
                            str5 = (String) this.f460i.get("content-type");
                        }
                        if (str5 == null) {
                            str = Constants.TEXT_EXTENSION;
                        } else if (str5.contains("xml")) {
                            str = "xml";
                        } else if (str5.contains("json")) {
                            str = "json";
                        }
                    } else if (this.f462k) {
                        str = "xml";
                    }
                    String str6 = this.f454c;
                    if (str6 != null && str6.contains("xml")) {
                        str = "xml";
                    }
                    if (TextUtils.isEmpty(this.f455d)) {
                        str = Constants.TEXT_EXTENSION;
                    }
                    if ("xml".equals(str)) {
                        str2 = "<!--";
                        str3 = "-->";
                    } else if ("json".equals(str)) {
                        str2 = "/*";
                        str3 = Constants.MIME_MULTI_START;
                    } else {
                        Constants.TEXT_EXTENSION.equals(str);
                        str2 = "";
                        str3 = "";
                    }
                    C12020a c12020a = new C12020a((char) 0, 5);
                    StringBuilder sb = new StringBuilder();
                    c12020a.f8772b = sb;
                    c12020a.m13627F(str2);
                    c12020a.m13628G("ApiName", this.f452a);
                    c12020a.m13628G("StatusCode", Integer.toString(this.f458g));
                    c12020a.m13628G("Method", this.f456e);
                    c12020a.m13627F(this.f453b);
                    c12020a.m13628G("Url", this.f457f);
                    c12020a.m13629H(this.f461j, ActionHandler.PARAMS);
                    c12020a.m13629H(this.f460i, Contract.HEADERS);
                    c12020a.m13627F(str3);
                    String string = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    String str7 = this.f464m.format(this.f459h);
                    if (sb2.length() != 0) {
                        sb2.append("_");
                    }
                    if (str7 != null) {
                        sb2.append(str7);
                    }
                    String strM325j = C0145c.m325j(context);
                    if (sb2.length() != 0) {
                        sb2.append("_");
                    }
                    if (strM325j != null) {
                        sb2.append(strM325j);
                    }
                    String str8 = this.f452a;
                    if (sb2.length() != 0) {
                        sb2.append("_");
                    }
                    if (str8 != null) {
                        sb2.append(str8);
                    }
                    String str9 = this.f453b;
                    if (sb2.length() != 0) {
                        sb2.append("_");
                    }
                    if (str9 != null) {
                        sb2.append(str9);
                    }
                    String str10 = this.f454c;
                    if (sb2.length() != 0) {
                        sb2.append("_");
                    }
                    if (str10 != null) {
                        sb2.append(str10);
                    }
                    sb2.append(Extension.DOT);
                    sb2.append(str);
                    String string2 = sb2.toString();
                    if (!TextUtils.isEmpty(this.f454c) && 30 < this.f454c.length()) {
                        this.f454c = this.f454c.substring(30);
                    }
                    C0027j c0027j = AbstractC0153k.f466b;
                    c0027j.getClass();
                    File file = new File(c0027j.f144b, string2);
                    try {
                        try {
                            C0027j c0027j2 = AbstractC0153k.f466b;
                            c0027j2.getClass();
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(c0027j2.f144b, string2)), StandardCharsets.UTF_8);
                            try {
                                outputStreamWriter.write(string);
                                String str11 = this.f455d;
                                if (str11 != null) {
                                    outputStreamWriter.write(str11);
                                }
                                C0027j.m52c(AbstractC0153k.f466b, file);
                                if (this.f463l) {
                                    for (File file2 : C0027j.m51b(AbstractC0153k.f466b)) {
                                        C0027j c0027j3 = AbstractC0153k.f465a;
                                        String name = file2.getName();
                                        c0027j3.getClass();
                                        File file3 = new File(c0027j3.f144b, name);
                                        if (!file3.exists()) {
                                            FileUtil.copyFile(file2, file3);
                                            C0027j.m52c(AbstractC0153k.f465a, file3);
                                        }
                                    }
                                }
                                outputStreamWriter.close();
                            } catch (Throwable th) {
                                try {
                                    outputStreamWriter.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } finally {
                            IOUtils.closeQuietly((Closeable) null);
                        }
                    } catch (Exception e) {
                        Debugger.m8609e("SyncLogger", "failed to write log filename = " + file.getName() + " e=" + e.getMessage());
                    }
                }
            }
        } catch (Exception e2) {
            AbstractC4539a.m3213w(e2, new StringBuilder("write() : "), "SyncLogger");
        }
    }
}
