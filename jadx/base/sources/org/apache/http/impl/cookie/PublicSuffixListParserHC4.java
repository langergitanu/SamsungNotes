package org.apache.http.impl.cookie;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class PublicSuffixListParserHC4 {
    private static final int MAX_LINE_LEN = 256;
    private final PublicSuffixFilterHC4 filter;

    public PublicSuffixListParserHC4(PublicSuffixFilterHC4 publicSuffixFilterHC4) {
        this.filter = publicSuffixFilterHC4;
    }

    private boolean readLine(Reader reader, StringBuilder sb) throws IOException {
        char c;
        sb.setLength(0);
        boolean z = false;
        do {
            int i = reader.read();
            if (i == -1 || (c = (char) i) == '\n') {
                return i != -1;
            }
            if (Character.isWhitespace(c)) {
                z = true;
            }
            if (!z) {
                sb.append(c);
            }
        } while (sb.length() <= 256);
        throw new IOException("Line too long");
    }

    public void parse(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder(256);
        boolean line = true;
        while (line) {
            line = readLine(bufferedReader, sb);
            String string = sb.toString();
            if (string.length() != 0 && !string.startsWith("//")) {
                if (string.startsWith(Extension.DOT)) {
                    string = string.substring(1);
                }
                boolean zStartsWith = string.startsWith("!");
                if (zStartsWith) {
                    string = string.substring(1);
                }
                if (zStartsWith) {
                    arrayList2.add(string);
                } else {
                    arrayList.add(string);
                }
            }
        }
        this.filter.setPublicSuffixes(arrayList);
        this.filter.setExceptions(arrayList2);
    }
}
