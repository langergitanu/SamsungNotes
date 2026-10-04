package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.scsp.common.Header;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import opennlp.tools.commons.Internal;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class EvalitaNameSampleStream implements ObjectStream<NameSample> {
    public static final String DOCSTART = "-DOCSTART-";
    public static final int GENERATE_GPE_ENTITIES = 8;
    public static final int GENERATE_LOCATION_ENTITIES = 4;
    public static final int GENERATE_ORGANIZATION_ENTITIES = 2;
    public static final int GENERATE_PERSON_ENTITIES = 1;
    private final LANGUAGE lang;
    private final ObjectStream<String> lineStream;
    private final int types;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LANGUAGE {
        IT
    }

    public EvalitaNameSampleStream(LANGUAGE language, ObjectStream<String> objectStream, int i) {
        this.lang = language;
        this.lineStream = objectStream;
        this.types = i;
    }

    private static Span extract(int i, int i2, String str) throws InvalidFormatException {
        String strSubstring;
        String str2;
        strSubstring = str.substring(2);
        strSubstring.getClass();
        switch (strSubstring) {
            case "GPE":
                str2 = "gpe";
                break;
            case "LOC":
                str2 = Header.LOCATION;
                break;
            case "ORG":
                str2 = "organization";
                break;
            case "PER":
                str2 = "person";
                break;
            default:
                throw new InvalidFormatException("Unknown type: ".concat(strSubstring));
        }
        return new Span(i, i2, str2);
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.lineStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.lineStream.reset();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        if (opennlp.tools.formats.EvalitaNameSampleStream.LANGUAGE.f9656IT.equals(r14.lang) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r0.size() <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        r4 = new java.util.ArrayList();
        r8 = 0;
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        if (r8 >= r1.size()) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
    
        r11 = (java.lang.String) r1.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        if (r11.endsWith("PER") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        if ((r14.types & 1) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
    
        if (r11.endsWith("ORG") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        if ((r14.types & 2) != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
    
        if (r11.endsWith("LOC") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bf, code lost:
    
        if ((r14.types & 4) != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c1, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c8, code lost:
    
        if (r11.endsWith("GPE") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ce, code lost:
    
        if ((r14.types & 8) != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d0, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d7, code lost:
    
        if (r11.startsWith("B-") == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d9, code lost:
    
        if (r9 == (-1)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00db, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e8, code lost:
    
        r10 = r8 + 1;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f2, code lost:
    
        if (r11.startsWith("I-") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f4, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fb, code lost:
    
        if (r11.equals("O") == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:
    
        if (r9 == (-1)) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ff, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010e, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011d, code lost:
    
        throw new java.io.IOException("Invalid tag: ".concat(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011e, code lost:
    
        if (r9 == (-1)) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0120, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0142, code lost:
    
        return new opennlp.tools.namefind.NameSample((java.lang.String[]) r0.toArray(new java.lang.String[0]), (opennlp.tools.util.Span[]) r4.toArray(new opennlp.tools.util.Span[0]), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0143, code lost:
    
        if (r4 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0149, code lost:
    
        return read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014a, code lost:
    
        return null;
     */
    @Override // opennlp.tools.util.ObjectStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NameSample read() throws IOException {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        while (true) {
            str = this.lineStream.read();
            if (str == null || StringUtil.isEmpty(str)) {
                break;
            }
            if (str.startsWith("-DOCSTART-")) {
                String str2 = this.lineStream.read();
                if (!StringUtil.isEmpty(str2)) {
                    throw new IOException(AbstractC0541b.m773o("Empty line after -DOCSTART- not empty: '", str2, "'!"));
                }
                z = true;
            } else {
                String[] strArrSplit = str.split(" ");
                if (!LANGUAGE.IT.equals(this.lang) || strArrSplit.length != 4) {
                    break;
                }
                arrayList.add(strArrSplit[0]);
                arrayList2.add(strArrSplit[3]);
            }
        }
        throw new IOException(AbstractC0541b.m773o("Incorrect number of fields per line for language: '", str, "'!"));
    }

    public EvalitaNameSampleStream(LANGUAGE language, InputStreamFactory inputStreamFactory, int i) {
        this(language, new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8), i);
    }
}
