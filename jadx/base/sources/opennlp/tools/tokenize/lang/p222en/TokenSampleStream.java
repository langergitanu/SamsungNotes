package opennlp.tools.tokenize.lang.p222en;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import opennlp.tools.parser.Parse;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenSampleStream implements Iterator<TokenSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenSampleStream.class);
    private final Pattern alphaNumeric = Pattern.compile("[A-Za-z0-9]");
    private boolean evenq = true;

    /* JADX INFO: renamed from: in */
    private final BufferedReader f9696in;
    private String line;

    public TokenSampleStream(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.f9696in = bufferedReader;
        this.line = bufferedReader.readLine();
    }

    private static void usage() {
        Logger logger2 = logger;
        logger2.info("TokenSampleStream [-spans] < in");
        logger2.info("Where in is a space delimited list of tokens.");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.line != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    @Override // java.util.Iterator
    public TokenSample next() {
        boolean z;
        String[] strArrSplit = this.line.split("\\s+");
        boolean z2 = true;
        if (strArrSplit.length == 0) {
            this.evenq = true;
        }
        StringBuilder sb = new StringBuilder(this.line.length());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = 0;
        while (i < strArrSplit.length) {
            String str = strArrSplit[i];
            int i2 = i - 1;
            String str2 = i2 >= 0 ? strArrSplit[i2] : "";
            str.getClass();
            ?? r11 = -1;
            r11 = -1;
            r11 = -1;
            r11 = -1;
            r11 = -1;
            switch (str.hashCode()) {
                case 43889039:
                    if (str.equals("-LCB-")) {
                        r11 = 0;
                    }
                    break;
                case 43903454:
                    if (str.equals("-LRB-")) {
                        r11 = z2;
                    }
                    break;
                case 44067785:
                    if (str.equals("-RCB-")) {
                        r11 = 2;
                    }
                    break;
                case 44082200:
                    if (str.equals("-RRB-")) {
                        r11 = 3;
                    }
                    break;
            }
            switch (r11) {
                case 0:
                    str = Parse.BRACKET_LCB;
                    break;
                case 1:
                    str = "(";
                    break;
                case 2:
                    str = "}";
                    break;
                case 3:
                    str = ")";
                    break;
            }
            if (sb.length() != 0) {
                z = z2;
                if (!this.alphaNumeric.matcher(str).find() || str.startsWith("'") || str.equalsIgnoreCase("n't") ? (str.equals("``") || str.equals("--") || str.equals("$") || str.equals("(") || str.equals(MsalUtils.QUERY_STRING_DELIMITER) || str.equals(ContentUtils.HASH_SYMBOL) || (str.equals("\"") && this.evenq && i != strArrSplit.length - 1)) && (!str2.equals("(") || !str2.equals(Parse.BRACKET_LCB)) : !str2.equals("``") && ((!str2.equals("\"") || this.evenq) && !str2.equals("(") && !str2.equals(Parse.BRACKET_LCB) && !str2.equals("$") && !str2.equals(ContentUtils.HASH_SYMBOL))) {
                    length++;
                }
            } else {
                z = z2;
            }
            if (str.equals("\"")) {
                this.evenq = (i == strArrSplit.length + (-1) || !this.evenq) ? z : false;
            }
            if (sb.length() < length) {
                sb.append(" ");
            }
            sb.append(str);
            arrayList.add(new Span(length, str.length() + length));
            length += str.length();
            i++;
            z2 = z;
        }
        try {
            this.line = this.f9696in.readLine();
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage(), (Throwable) e);
            this.line = null;
        }
        return new TokenSample(sb.toString(), (Span[]) arrayList.toArray(new Span[0]));
    }
}
