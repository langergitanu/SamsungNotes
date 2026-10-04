package com.samsung.android.support.senl.p148nt.coedit.control.util;

import android.content.Context;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DownSyncUtil {
    private static final String TAG = "NT/DownSyncUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResponseHandler {
        void handleBinaryBody(String str, byte[] bArr);

        void handleDownloadUrlMap(Map<String, String> map);

        void handleDownloadXmlData(String str);
    }

    private static void addContentTypeHeader(Map<String, String> map, ByteArrayInputStream byteArrayInputStream) {
        byteArrayInputStream.mark(1000);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, StandardCharsets.UTF_8));
                try {
                    String line = bufferedReader.readLine();
                    if (line != null && line.startsWith("--")) {
                        map.put("Content-Type", "Content-Type: multipart/form-data; boundary=" + line.substring(2));
                    }
                    bufferedReader.close();
                    gZIPInputStream.close();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    gZIPInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            byteArrayInputStream.reset();
        }
    }

    public static void requestDownSync(Context context, ByteArrayInputStream byteArrayInputStream, final ResponseHandler responseHandler) {
        CoeditLogger.m8923i(TAG, "requestDownSync() : Start");
        HashMap map = new HashMap();
        try {
            addContentTypeHeader(map, byteArrayInputStream);
            map.put("Content-Encoding", "gzip");
            final ParseResponseXml parseResponseXml = new ParseResponseXml();
            InterfaceC6864o interfaceC6864o = new InterfaceC6864o() { // from class: com.samsung.android.support.senl.nt.coedit.control.util.DownSyncUtil.1
                @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o
                public void handleBinaryBody(String str, String str2, byte[] bArr) {
                    responseHandler.handleBinaryBody(str2.split("_")[0], bArr);
                }

                public void handleInputStreamBody(String str, InputStream inputStream) {
                }

                @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6864o
                public void handleStringBody(String str, String str2) {
                    parseResponseXml.extractDownloadUrls(str2);
                    parseResponseXml.extractNoteResource(str2);
                }
            };
            C6865p c6865p = new C6865p();
            c6865p.f4347d = byteArrayInputStream;
            c6865p.f4348e = "";
            c6865p.f4345b = map;
            c6865p.f4344a = 0;
            c6865p.f4346c = null;
            c6865p.f4354k = interfaceC6864o;
            c6865p.f4349f = null;
            c6865p.f4351h = context;
            c6865p.f4352i = null;
            c6865p.f4350g = null;
            c6865p.f4353j = null;
            c6865p.m5050d();
            responseHandler.handleDownloadUrlMap(parseResponseXml.getDownloadUrlMap());
            responseHandler.handleDownloadXmlData(parseResponseXml.getXmlBody());
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("requestDownSync, fail to requestDownSync : "), TAG);
        }
    }
}
