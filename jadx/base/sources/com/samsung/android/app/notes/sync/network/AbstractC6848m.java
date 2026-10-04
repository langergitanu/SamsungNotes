package com.samsung.android.app.notes.sync.network;

import android.util.Base64;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import com.samsung.android.app.notes.sync.network.networkutils.C6856g;
import com.samsung.android.app.notes.sync.network.networkutils.C6857h;
import com.samsung.android.app.notes.sync.network.networkutils.C6866q;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0146d;
import p042J1.AbstractC0155m;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6848m {
    /* JADX INFO: renamed from: a */
    public static void m5008a(C6845j c6845j, String str, String str2, InterfaceC6846k interfaceC6846k) {
        StringBuilder sb = new StringBuilder();
        AbstractC2821a.m2207B(sb, c6845j.f4269a, "/snote/delete/", str, MsalUtils.QUERY_STRING_SYMBOL);
        sb.append(c6845j.m5007a());
        sb.append("&clientTimestamp=");
        sb.append(str2);
        AbstractC6854e.m5028h(c6845j.f4271c, sb.toString(), AbstractC0146d.m342a(c6845j.f4270b), new C6844i(interfaceC6846k, new int[]{-1}, 0));
        Debugger.m8607d("NT$NoteServiceHelper", "deleteFile Done");
    }

    /* JADX INFO: renamed from: b */
    public static ArrayList m5009b(C6845j c6845j, String str, final String str2) {
        final ArrayList arrayList = new ArrayList();
        final SyncException[] syncExceptionArr = new SyncException[1];
        Debugger.m8607d("NT$NoteServiceHelper", "downloadFile [" + Thread.currentThread().getId() + "]");
        StringBuilder sb = new StringBuilder();
        AbstractC2821a.m2207B(sb, c6845j.f4269a, "/snote/download/", str, MsalUtils.QUERY_STRING_SYMBOL);
        sb.append(c6845j.m5007a());
        AbstractC6854e.m5026f(c6845j.f4271c, sb.toString(), AbstractC0146d.m342a(c6845j.f4270b), new InterfaceC6851b() { // from class: com.samsung.android.app.notes.sync.network.g
            @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b
            /* JADX INFO: renamed from: a */
            public final void mo5001a(Header header, InputStream inputStream) {
                String str3 = str2;
                ArrayList arrayList2 = arrayList;
                SyncException[] syncExceptionArr2 = syncExceptionArr;
                Debugger.m8616s("NT$NoteServiceHelper", "downloadFile Finished - ");
                try {
                    for (String str4 : AbstractC6848m.m5012e(header, inputStream, str3)) {
                        Debugger.m8607d("NT$NoteServiceHelper", "downloadFile : " + str4);
                        arrayList2.add(str4);
                    }
                } catch (SyncException e) {
                    AbstractC6670b.m4752m(e, new StringBuilder("downloadFile list2:"), "NT$NoteServiceHelper");
                    syncExceptionArr2[0] = e;
                } catch (IOException e2) {
                    Debugger.m8609e("NT$NoteServiceHelper", "downloadFile list3:" + e2.getMessage());
                    syncExceptionArr2[0] = new SyncException(312);
                } catch (IllegalStateException e3) {
                    Debugger.m8609e("NT$NoteServiceHelper", "downloadFile list4:" + e3.getMessage());
                    syncExceptionArr2[0] = new SyncException(307);
                }
            }
        });
        SyncException syncException = syncExceptionArr[0];
        if (syncException != null) {
            throw syncException;
        }
        Debugger.m8607d("NT$NoteServiceHelper", "downloadFile finish [" + Thread.currentThread().getId() + "]");
        return arrayList;
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m5010c(C6845j c6845j, String str, boolean z) {
        boolean z2;
        final ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder(c6845j.f4269a);
        sb.append("/snote/list");
        sb.append('?');
        sb.append(c6845j.m5007a());
        sb.append("&coldStartable=true");
        if (z) {
            sb.append("&file_type=meta");
        }
        if (str != null && !str.isEmpty() && !str.equals("0") && !str.equals("1464416139847")) {
            sb.append("&modified_after=");
            sb.append(str);
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        Debugger.m8615i("NT$NoteServiceHelper", "downloadList url : " + ((Object) sb));
        do {
            AbstractC6854e.m5026f(c6845j.f4271c, sb2.toString(), AbstractC0146d.m342a(c6845j.f4270b), new InterfaceC6851b() { // from class: com.samsung.android.app.notes.sync.network.h
                @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b
                /* JADX INFO: renamed from: a */
                public final void mo5001a(Header header, InputStream inputStream) {
                    ArrayList arrayList2 = arrayList;
                    Debugger.m8607d("NT$NoteServiceHelper", "downloadList Finished - ");
                    try {
                        arrayList2.add(AbstractC0155m.m394i(inputStream));
                    } catch (IOException e) {
                        AbstractC0000a.m20q(e, new StringBuilder("Failed to startImport:"), "NT$NoteServiceHelper");
                    }
                }
            });
            try {
                JSONObject jSONObject = (JSONObject) arrayList.get(arrayList.size() - 1);
                z2 = jSONObject.getBoolean("next");
                if (z2) {
                    String string = jSONObject.getString("next_key");
                    StringBuilder sb3 = new StringBuilder(sb.toString());
                    sb3.append("&start_key=");
                    sb3.append(string);
                    sb2 = sb3;
                }
            } catch (JSONException e) {
                String str2 = "Failed to startImport - " + e.getMessage();
                Debugger.m8609e("NT$NoteServiceHelper", str2);
                throw new SyncException(406, str2);
            }
        } while (z2);
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public static OutputStream m5011d(String str, byte[] bArr) throws FileNotFoundException {
        if (!AbstractC0155m.m403r(AbstractC0155m.f474a, bArr)) {
            return new FileOutputStream(str);
        }
        try {
            Object objCreate = C0322h.m670a().f817c.create(str);
            C6856g c6856g = new C6856g();
            c6856g.f4285a = objCreate;
            return c6856g;
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e0  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList m5012e(Header header, InputStream inputStream, String str) throws Throwable {
        OutputStream outputStream;
        FileOutputStream fileOutputStream;
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        Debugger.m8616s("NT$NoteServiceHelper", "parseAndDownload");
        BufferedReader bufferedReader = null;
        OutputStream outputStreamM5011d = null;
        bufferedReader = null;
        try {
            String str3 = "--" + header.getElements()[0].getParameterByName("boundary").getValue();
            Debugger.m8616s("NT$NoteServiceHelper", "boundary : " + str3);
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
            try {
                C6847l c6847l = new C6847l();
                c6847l.f4272a = 0;
                c6847l.f4273b = "";
                fileOutputStream = null;
                int length = 0;
                int i = 0;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        boolean zM403r = true;
                        if (!line.equals(str3)) {
                            int i2 = c6847l.f4272a;
                            if (i2 == 8) {
                                byte[] bArrDecode = Base64.decode(line, 0);
                                length += bArrDecode.length;
                                if (length / 65535 > i) {
                                    Debugger.m8607d("NT$NoteServiceHelper", "Downloading file : " + length);
                                    i = length / 65535;
                                }
                                if (outputStreamM5011d == null && !str2.isEmpty()) {
                                    outputStreamM5011d = m5011d(str2, bArrDecode);
                                    if (!AbstractC0155m.m403r(AbstractC0155m.f474a, bArrDecode)) {
                                        zM403r = AbstractC0155m.m403r(AbstractC0155m.f475b, bArrDecode);
                                    }
                                    if (zM403r) {
                                        int length2 = bArrDecode.length - 8;
                                        byte[] bArr = new byte[length2];
                                        System.arraycopy(bArrDecode, 8, bArr, 0, length2);
                                        bArrDecode = bArr;
                                    }
                                }
                                if (outputStreamM5011d != null) {
                                    outputStreamM5011d.write(bArrDecode);
                                }
                            } else if (i2 == 1 && fileOutputStream != null) {
                                Debugger.m8616s("NT$NoteServiceHelper", "snote_detail : " + line);
                                fileOutputStream.write(line.getBytes(Charset.defaultCharset()));
                            }
                        } else {
                            if (!m5013f(bufferedReader2, c6847l)) {
                                break;
                            }
                            int i4 = c6847l.f4272a;
                            if (i4 == 8) {
                                File parentFile = new File(str + c6847l.f4273b).getParentFile();
                                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                    Debugger.m8609e("NT$NoteServiceHelper", "parent.mkdirs returned false");
                                }
                                str2 = str + c6847l.f4273b;
                                arrayList.add(c6847l.f4273b);
                            } else if (i4 == 1) {
                                File parentFile2 = new File(str + c6847l.f4273b).getParentFile();
                                if (parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs()) {
                                    Debugger.m8609e("NT$NoteServiceHelper", "parent.mkdirs returned false");
                                }
                                fileOutputStream = new FileOutputStream(str + "content.sync");
                            }
                        }
                    } catch (SocketTimeoutException e) {
                        e = e;
                        OutputStream outputStream2 = outputStreamM5011d;
                        bufferedReader = bufferedReader2;
                        outputStream = outputStream2;
                        try {
                            throw new SyncException(321, e.getMessage());
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        OutputStream outputStream3 = outputStreamM5011d;
                        bufferedReader = bufferedReader2;
                        outputStream = outputStream3;
                        if (bufferedReader != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                if (outputStreamM5011d != null) {
                    outputStreamM5011d.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                Debugger.m8607d("NT$NoteServiceHelper", "parseAndDownload : " + length);
                Debugger.m8616s("NT$NoteServiceHelper", "read end");
                return arrayList;
            } catch (SocketTimeoutException e2) {
                e = e2;
                fileOutputStream = null;
                bufferedReader = bufferedReader2;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bufferedReader = bufferedReader2;
                outputStream = null;
            }
        } catch (SocketTimeoutException e3) {
            e = e3;
            outputStream = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static boolean m5013f(BufferedReader bufferedReader, C6847l c6847l) throws IOException {
        c6847l.f4272a = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.isEmpty() || line.charAt(0) == '\n' || line.charAt(0) == '\r') {
                break;
            }
            String[] strArrSplit = line.split(":");
            if (strArrSplit.length > 1 && strArrSplit[0].equalsIgnoreCase("content-disposition")) {
                String[] strArrSplit2 = strArrSplit[1].split(";");
                if (strArrSplit2.length > 1) {
                    for (String str : strArrSplit2) {
                        String[] strArrSplit3 = str.trim().split(MarketingConstants.REFERRER_DELIMITER_U003D);
                        if (strArrSplit3.length > 1) {
                            if (strArrSplit3[0].equalsIgnoreCase("name")) {
                                String strReplaceAll = strArrSplit3[1].replaceAll("\"", "");
                                if (strReplaceAll.equalsIgnoreCase("file")) {
                                    c6847l.f4272a = 8;
                                } else if (strReplaceAll.equalsIgnoreCase("snote_detail")) {
                                    c6847l.f4272a = 1;
                                }
                            } else if (strArrSplit3[0].equalsIgnoreCase(UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME)) {
                                c6847l.f4273b = strArrSplit3[1].replaceAll("\"", "");
                                Debugger.m8616s("NT$NoteServiceHelper", "snoteHeader.filename : " + c6847l.f4273b);
                            }
                        }
                    }
                }
            }
        }
        return c6847l.f4272a != 0;
    }

    /* JADX INFO: renamed from: g */
    public static void m5014g(C6845j c6845j, String str, String str2, String str3, JSONObject jSONObject, InterfaceC6846k interfaceC6846k) {
        C6857h c6857h;
        int[] iArr = {-1};
        Debugger.m8607d("NT$NoteServiceHelper", "uploadFile - timeStamp : " + str3);
        StringBuilder sb = new StringBuilder();
        AbstractC2821a.m2207B(sb, c6845j.f4269a, "/snote/upload/", str2, MsalUtils.QUERY_STRING_SYMBOL);
        sb.append(c6845j.m5007a());
        sb.append("&clientTimestamp=");
        sb.append(str3);
        String string = sb.toString();
        String str4 = "*****" + System.currentTimeMillis() + "*****";
        MultipartEntityBuilder multipartEntityBuilderCreate = MultipartEntityBuilder.create();
        multipartEntityBuilderCreate.setBoundary(str4);
        File file = new File(str);
        if (!file.exists()) {
            throw new SyncException(312, AbstractC0541b.m772n("There is no wanted file. ", str));
        }
        Debugger.m8616s("NT$NoteServiceHelper", "uploadFile - filepath : " + file.getName());
        multipartEntityBuilderCreate.addTextBody("snote_detail", jSONObject.toString(), ContentType.APPLICATION_JSON);
        C6857h c6857h2 = null;
        try {
            c6857h = new C6857h(str, SpenSDocFile.isEncrypted(str));
        } catch (Exception e) {
            e = e;
        }
        try {
            multipartEntityBuilderCreate.addPart("file", new C6866q(c6857h, ContentType.APPLICATION_OCTET_STREAM, file.getName(), c6857h.f4288c));
            AbstractC6854e.m5029i(c6845j.f4271c, string, AbstractC0146d.m342a(c6845j.f4270b), multipartEntityBuilderCreate.build(), new C6844i(interfaceC6846k, iArr, 1));
            Debugger.m8607d("NT$NoteServiceHelper", "uploadFile finish");
        } catch (Exception e2) {
            e = e2;
            c6857h2 = c6857h;
            if (c6857h2 != null) {
                try {
                    c6857h2.close();
                } catch (IOException e3) {
                    Debugger.m8609e("NT$NoteServiceHelper", "upload err : " + e3);
                }
            }
            throw new SyncException(312, e.getMessage());
        }
    }
}
