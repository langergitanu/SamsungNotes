package opennlp.tools.formats;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
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
public class Conll02NameSampleStream implements ObjectStream<NameSample> {
    public static final String DOCSTART = "-DOCSTART-";
    public static final int GENERATE_LOCATION_ENTITIES = 4;
    public static final int GENERATE_MISC_ENTITIES = 8;
    public static final int GENERATE_ORGANIZATION_ENTITIES = 2;
    public static final int GENERATE_PERSON_ENTITIES = 1;
    private final LANGUAGE lang;
    private final ObjectStream<String> lineStream;
    private final int types;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LANGUAGE {
        NLD,
        SPA
    }

    public Conll02NameSampleStream(LANGUAGE language, ObjectStream<String> objectStream, int i) {
        this.lang = language;
        this.lineStream = objectStream;
        this.types = i;
    }

    public static Span extract(int i, int i2, String str) throws InvalidFormatException {
        String strSubstring;
        String str2;
        strSubstring = str.substring(2);
        strSubstring.getClass();
        switch (strSubstring) {
            case "LOC":
                str2 = Header.LOCATION;
                break;
            case "ORG":
                str2 = "organization";
                break;
            case "PER":
                str2 = "person";
                break;
            case "MISC":
                str2 = "misc";
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        if (opennlp.tools.formats.Conll02NameSampleStream.LANGUAGE.SPA.equals(r14.lang) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (r0.size() <= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        r4 = new java.util.ArrayList();
        r8 = 0;
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        if (r8 >= r1.size()) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        r11 = (java.lang.String) r1.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        if (r11.endsWith("PER") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
    
        if ((r14.types & 1) != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
    
        if (r11.endsWith("ORG") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if ((r14.types & 2) != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
    
        if (r11.endsWith("LOC") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
    
        if ((r14.types & 4) != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        if (r11.endsWith("MISC") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b7, code lost:
    
        if ((r14.types & 8) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b9, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c0, code lost:
    
        if (r11.startsWith("B-") == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
    
        if (r9 == (-1)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
    
        r10 = r8 + 1;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:
    
        if (r11.startsWith("I-") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e4, code lost:
    
        if (r11.equals("O") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e6, code lost:
    
        if (r9 == (-1)) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e8, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f7, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0106, code lost:
    
        throw new java.io.IOException("Invalid tag: ".concat(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0107, code lost:
    
        if (r9 == (-1)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0109, code lost:
    
        r4.add(extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012b, code lost:
    
        return new opennlp.tools.namefind.NameSample((java.lang.String[]) r0.toArray(new java.lang.String[0]), (opennlp.tools.util.Span[]) r4.toArray(new opennlp.tools.util.Span[0]), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012c, code lost:
    
        if (r4 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0132, code lost:
    
        return read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0133, code lost:
    
        return null;
     */
    @Override // opennlp.tools.util.ObjectStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NameSample read() throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        while (true) {
            String str = this.lineStream.read();
            if (str == null || StringUtil.isEmpty(str)) {
                break;
            }
            if (LANGUAGE.NLD.equals(this.lang) && str.startsWith("-DOCSTART-")) {
                z = true;
            } else {
                String[] strArrSplit = str.split(" ");
                if (strArrSplit.length != 3) {
                    throw new IOException(AbstractC11014a.m12321f("Expected three fields per line in training data, got ", strArrSplit.length, " for line '", str, "'!"));
                }
                arrayList.add(strArrSplit[0]);
                arrayList2.add(strArrSplit[2]);
            }
        }
    }

    public Conll02NameSampleStream(LANGUAGE language, InputStreamFactory inputStreamFactory, int i) {
        this(language, new PlainTextByLineStream(inputStreamFactory, StandardCharsets.ISO_8859_1), i);
    }
}
