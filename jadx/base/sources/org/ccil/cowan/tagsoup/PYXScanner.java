package org.ccil.cowan.tagsoup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PYXScanner implements Scanner {
    public static void main(String[] strArr) {
        new PYXScanner().scan(new InputStreamReader(System.in, "UTF-8"), new PYXWriter(new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"))));
    }

    @Override // org.ccil.cowan.tagsoup.Scanner
    public void scan(Reader reader, ScanHandler scanHandler) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        char[] cArr = null;
        boolean z = false;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                scanHandler.eof(cArr, 0, 0);
                return;
            }
            int length = line.length();
            if (cArr == null || cArr.length < length) {
                cArr = new char[length];
            }
            line.getChars(0, length, cArr, 0);
            char c = cArr[0];
            if (c == '(') {
                if (z) {
                    scanHandler.stagc(cArr, 0, 0);
                }
                scanHandler.mo14972gi(cArr, 1, length - 1);
                z = true;
            } else if (c == ')') {
                if (z) {
                    scanHandler.stagc(cArr, 0, 0);
                    z = false;
                }
                scanHandler.etag(cArr, 1, length - 1);
            } else if (c == '-') {
                if (z) {
                    scanHandler.stagc(cArr, 0, 0);
                    z = false;
                }
                if (line.equals("-\\n")) {
                    cArr[0] = '\n';
                    scanHandler.pcdata(cArr, 0, 1);
                } else {
                    scanHandler.pcdata(cArr, 1, length - 1);
                }
            } else if (c == '?') {
                if (z) {
                    scanHandler.stagc(cArr, 0, 0);
                    z = false;
                }
                scanHandler.mo14973pi(cArr, 1, length - 1);
            } else if (c == 'A') {
                int iIndexOf = line.indexOf(32);
                scanHandler.aname(cArr, 1, iIndexOf - 1);
                scanHandler.aval(cArr, iIndexOf + 1, (length - iIndexOf) - 1);
            } else if (c == 'E') {
                if (z) {
                    scanHandler.stagc(cArr, 0, 0);
                    z = false;
                }
                scanHandler.entity(cArr, 1, length - 1);
            }
        }
    }

    @Override // org.ccil.cowan.tagsoup.Scanner
    public void startCDATA() {
    }

    @Override // org.ccil.cowan.tagsoup.Scanner
    public void resetDocumentLocator(String str, String str2) {
    }
}
