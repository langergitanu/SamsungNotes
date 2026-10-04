package com.nimbusds.jose.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class IOUtils {
    private IOUtils() {
    }

    public static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static String readFileToString(File file) {
        return readInputStreamToString(new FileInputStream(file));
    }

    public static String readInputStreamToString(InputStream inputStream) {
        return readInputStreamToString(inputStream, StandardCharset.UTF_8);
    }

    public static String readFileToString(File file, Charset charset) {
        return readInputStreamToString(new FileInputStream(file), charset);
    }

    public static String readInputStreamToString(InputStream inputStream, Charset charset) throws IOException {
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        while (true) {
            try {
                int i = inputStreamReader.read(cArr, 0, 1024);
                if (i < 0) {
                    String string = sb.toString();
                    inputStreamReader.close();
                    return string;
                }
                sb.append(cArr, 0, i);
            } catch (Throwable th) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
