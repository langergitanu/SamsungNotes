package opennlp.tools.formats;

import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import opennlp.tools.commons.Internal;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class BioNLP2004NameSampleStream implements ObjectStream<NameSample> {
    public static final int GENERATE_CELLLINE_ENTITIES = 8;
    public static final int GENERATE_CELLTYPE_ENTITIES = 4;
    public static final int GENERATE_DNA_ENTITIES = 1;
    public static final int GENERATE_PROTEIN_ENTITIES = 2;
    public static final int GENERATE_RNA_ENTITIES = 16;
    private final ObjectStream<String> lineStream;
    private final int types;

    public BioNLP2004NameSampleStream(InputStreamFactory inputStreamFactory, int i) {
        this.lineStream = new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8);
        this.types = i;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.lineStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.lineStream.reset();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r0.size() <= 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        r4 = new java.util.ArrayList();
        r8 = 0;
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
    
        if (r8 >= r1.size()) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        r11 = (java.lang.String) r1.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (r11.endsWith("DNA") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        if ((r14.types & 1) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        if (r11.endsWith("protein") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0095, code lost:
    
        if ((r14.types & 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        if (r11.endsWith("cell_type") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a4, code lost:
    
        if ((r14.types & 4) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
    
        if (r11.endsWith("cell_line") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
    
        if ((r14.types & 4) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b5, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
    
        if (r11.endsWith("RNA") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        if ((r14.types & 16) != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c4, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cb, code lost:
    
        if (r11.startsWith("B-") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        if (r9 == (-1)) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cf, code lost:
    
        r4.add(new opennlp.tools.util.Span(r9, r10, ((java.lang.String) r1.get(r9)).substring(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r10 = r8 + 1;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00eb, code lost:
    
        if (r11.startsWith("I-") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ed, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f4, code lost:
    
        if (r11.equals("O") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f6, code lost:
    
        if (r9 == (-1)) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
    
        r4.add(new opennlp.tools.util.Span(r9, r10, ((java.lang.String) r1.get(r9)).substring(2)));
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011b, code lost:
    
        throw new java.io.IOException("Invalid tag: ".concat(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
    
        if (r9 == (-1)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x011e, code lost:
    
        r4.add(new opennlp.tools.util.Span(r9, r10, ((java.lang.String) r1.get(r9)).substring(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0145, code lost:
    
        return new opennlp.tools.namefind.NameSample((java.lang.String[]) r0.toArray(new java.lang.String[0]), (opennlp.tools.util.Span[]) r4.toArray(new opennlp.tools.util.Span[0]), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0146, code lost:
    
        if (r4 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        return read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014d, code lost:
    
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
            if (str == null || StringUtil.isEmpty(str.trim())) {
                break;
            }
            if (str.startsWith("###MEDLINE:")) {
                this.lineStream.read();
                z = true;
            } else if (str.contains("ABSTRACT TRUNCATED")) {
                continue;
            } else {
                String[] strArrSplit = str.split("\t");
                if (strArrSplit.length != 2) {
                    throw new IOException(AbstractC11014a.m12321f("Expected two fields per line in training data, got ", strArrSplit.length, " for line '", str, "'!"));
                }
                arrayList.add(strArrSplit[0]);
                arrayList2.add(strArrSplit[1]);
            }
        }
    }
}
