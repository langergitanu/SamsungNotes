package com.samsung.android.app.notes.sync.microsoft.graph.http;

import android.os.AsyncTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NotePageTask extends AsyncTask<Void, Void, C0124c> {
    private static final String TAG = "NotePageTask";
    private InterfaceC0122a mCallback;
    private String method;
    private List<String> pathList;
    private String title;
    private String url;
    private int width;

    public NotePageTask(String str, String str2, String str3, List<String> list, int i, InterfaceC0122a interfaceC0122a) {
        this.url = str;
        this.method = str2;
        this.title = str3;
        this.pathList = list;
        this.width = i;
        this.mCallback = interfaceC0122a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0041: MOVE (r13 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:10:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0249 A[Catch: all -> 0x024d, Exception -> 0x024f, LOOP:3: B:80:0x0243->B:82:0x0249, LOOP_END, TryCatch #2 {Exception -> 0x024f, blocks: (B:79:0x0239, B:80:0x0243, B:82:0x0249, B:87:0x0251), top: B:113:0x0239, outer: #4 }] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.PrintWriter] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0124c doInBackground(Void... voidArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        ?? r9;
        ?? r32;
        boolean z;
        OutputStream outputStream;
        PrintWriter printWriter;
        int responseCode;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        StringBuilder sb;
        String line;
        MSLogger.m8632d(TAG, "doInBackground");
        String str = this.url;
        String str2 = this.method;
        String str3 = (String) C0112b.m261h().f363b;
        String str4 = this.title;
        List<String> list = this.pathList;
        int i = this.width;
        String str5 = IdentityApiContract.Token.BEARER_;
        try {
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (httpURLConnection2 == null) {
                        C0124c c0124c = new C0124c(null, -1);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return c0124c;
                    }
                    try {
                        httpURLConnection2.setRequestMethod(str2);
                        httpURLConnection2.setRequestProperty("Authorization", IdentityApiContract.Token.BEARER_ + str3);
                        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=__NotePagePartBoundary__");
                        httpURLConnection2.setRequestProperty("Accept", "application/json");
                        z = true;
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.setDoInput(true);
                        outputStream = httpURLConnection2.getOutputStream();
                    } catch (Throwable th) {
                        th = th;
                        r32 = str3;
                        r9 = str5;
                    }
                    try {
                        printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                        try {
                            printWriter.append((CharSequence) "--__NotePagePartBoundary__").append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) "Content-Disposition: form-data; name=\"Presentation\"").append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) "Content-Type: text/html").append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) ("<html><head><title>" + str4 + "</title></head><body>")).append((CharSequence) "\r\n");
                            int size = list.size();
                            int i2 = 0;
                            while (i2 < size) {
                                i2++;
                                boolean z2 = z;
                                printWriter.append((CharSequence) ("<img src=\"name:imageBlock" + i2 + "\" alt=\"an image on the page\" width=\"" + i + "\"")).append((CharSequence) "\r\n");
                                z = z2;
                            }
                            printWriter.append((CharSequence) "</body></html>").append((CharSequence) "\r\n");
                            printWriter.flush();
                            Iterator<String> it = list.iterator();
                            int i4 = 0;
                            while (it.hasNext()) {
                                int i5 = i4 + 1;
                                File file = new File(it.next());
                                printWriter.append((CharSequence) ("--__NotePagePartBoundary__")).append((CharSequence) "\r\n");
                                printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"imageBlock" + i5 + "\"")).append((CharSequence) "\r\n");
                                printWriter.append((CharSequence) "Content-Type:image/jpeg").append((CharSequence) "\r\n");
                                printWriter.append((CharSequence) "\r\n");
                                printWriter.flush();
                                FileInputStream fileInputStream = new FileInputStream(file);
                                try {
                                    try {
                                        byte[] bArr = new byte[(int) file.length()];
                                        while (true) {
                                            int i6 = fileInputStream.read(bArr);
                                            if (i6 == -1) {
                                                break;
                                            }
                                            outputStream.write(bArr, 0, i6);
                                        }
                                        outputStream.flush();
                                        printWriter.append((CharSequence) "\r\n");
                                        printWriter.flush();
                                    } catch (Exception e) {
                                        Debugger.m8611e("RequestHttpMultiPart", e);
                                    }
                                    fileInputStream.close();
                                    i4 = i5;
                                } finally {
                                    fileInputStream.close();
                                }
                            }
                            printWriter.append((CharSequence) ("--__NotePagePartBoundary__--")).append((CharSequence) "\r\n");
                            printWriter.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } catch (RuntimeException e2) {
                            e = e2;
                            Debugger.m8609e("RequestHttpMultiPart", "Unrecoverable runtimeException. Failed. " + e.toString() + e.getMessage());
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (printWriter != null) {
                            }
                            httpURLConnection2.connect();
                            responseCode = httpURLConnection2.getResponseCode();
                            if (responseCode == 200) {
                            }
                            inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream(), StandardCharsets.UTF_8);
                            try {
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader);
                                    sb = new StringBuilder();
                                } catch (Exception e3) {
                                    Debugger.m8611e("RequestHttpMultiPart", e3);
                                    inputStreamReader.close();
                                    httpURLConnection2.disconnect();
                                    return new C0124c(null, -1);
                                }
                            } finally {
                                inputStreamReader.close();
                            }
                            while (true) {
                                line = bufferedReader.readLine();
                                if (line == null) {
                                }
                                inputStreamReader.close();
                                sb.append(line);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            Debugger.m8611e("RequestHttpMultiPart", e);
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (printWriter != null) {
                            }
                            httpURLConnection2.connect();
                            responseCode = httpURLConnection2.getResponseCode();
                            if (responseCode == 200) {
                            }
                            inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream(), StandardCharsets.UTF_8);
                            bufferedReader = new BufferedReader(inputStreamReader);
                            sb = new StringBuilder();
                            while (true) {
                                line = bufferedReader.readLine();
                                if (line == null) {
                                }
                                inputStreamReader.close();
                                sb.append(line);
                            }
                        }
                    } catch (RuntimeException e6) {
                        e = e6;
                        printWriter = null;
                    } catch (Exception e7) {
                        e = e7;
                        printWriter = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r9 = 0;
                        r32 = outputStream;
                        if (r32 != 0) {
                            r32.close();
                        }
                        if (r9 != 0) {
                            r9.close();
                        }
                        throw th;
                    }
                    printWriter.close();
                    httpURLConnection2.connect();
                    responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 200 && responseCode != 201 && responseCode != 202) {
                        MSLogger.m8633e("RequestHttpMultiPart", "HTTP Fail, response code : " + responseCode);
                        C0124c c0124c2 = new C0124c(null, -1);
                        httpURLConnection2.disconnect();
                        return c0124c2;
                    }
                    inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream(), StandardCharsets.UTF_8);
                    bufferedReader = new BufferedReader(inputStreamReader);
                    sb = new StringBuilder();
                    while (true) {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            C0124c c0124c3 = new C0124c(sb.toString(), responseCode);
                            inputStreamReader.close();
                            httpURLConnection2.disconnect();
                            return c0124c3;
                        }
                        sb.append(line);
                        inputStreamReader.close();
                    }
                } catch (IOException e8) {
                    e = e8;
                    Debugger.m8611e("RequestHttpMultiPart", e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return new C0124c(null, -1);
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            httpURLConnection2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(C0124c c0124c) {
        super.onPostExecute(c0124c);
        this.mCallback.mo252g(c0124c);
    }
}
