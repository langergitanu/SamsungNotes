package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Conll03NameSampleStream implements ObjectStream<NameSample> {
    private final LANGUAGE lang;
    private final ObjectStream<String> lineStream;
    private final int types;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LANGUAGE {
        EN,
        DE
    }

    public Conll03NameSampleStream(LANGUAGE language, ObjectStream<String> objectStream, int i) {
        this.lang = language;
        this.lineStream = objectStream;
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

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        if (r0.size() <= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
    
        r4 = new java.util.ArrayList();
        r8 = 0;
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        if (r8 >= r1.size()) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
    
        r11 = (java.lang.String) r1.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ab, code lost:
    
        if (r11.endsWith("PER") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
    
        if ((r14.types & 1) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        if (r11.endsWith("ORG") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
    
        if ((r14.types & 2) != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
    
        if (r11.endsWith("LOC") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cd, code lost:
    
        if ((r14.types & 4) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cf, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d6, code lost:
    
        if (r11.endsWith("MISC") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dc, code lost:
    
        if ((r14.types & 8) != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00de, code lost:
    
        r11 = "O";
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e3, code lost:
    
        if (r11.equals("O") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e5, code lost:
    
        if (r9 == (-1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e7, code lost:
    
        r4.add(opennlp.tools.formats.Conll02NameSampleStream.extract(r9, r10, (java.lang.String) r1.get(r9)));
        r9 = -1;
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fd, code lost:
    
        if (r11.startsWith("B-") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ff, code lost:
    
        if (r9 == (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0101, code lost:
    
        r4.add(opennlp.tools.formats.Conll02NameSampleStream.extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
    
        r10 = r8 + 1;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0118, code lost:
    
        if (r11.startsWith("I-") == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011a, code lost:
    
        if (r9 != (-1)) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
    
        if (r11.endsWith(((java.lang.String) r1.get(r9)).substring(1)) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012d, code lost:
    
        r4.add(opennlp.tools.formats.Conll02NameSampleStream.extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013b, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013d, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014c, code lost:
    
        throw new java.io.IOException("Invalid tag: ".concat(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014d, code lost:
    
        if (r9 == (-1)) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014f, code lost:
    
        r4.add(opennlp.tools.formats.Conll02NameSampleStream.extract(r9, r10, (java.lang.String) r1.get(r9)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0171, code lost:
    
        return new opennlp.tools.namefind.NameSample((java.lang.String[]) r0.toArray(new java.lang.String[0]), (opennlp.tools.util.Span[]) r4.toArray(new opennlp.tools.util.Span[0]), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0172, code lost:
    
        if (r4 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0178, code lost:
    
        return read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0179, code lost:
    
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
                if (LANGUAGE.EN.equals(this.lang) && strArrSplit.length == 4) {
                    arrayList.add(strArrSplit[0]);
                    arrayList2.add(strArrSplit[3]);
                } else {
                    if (!LANGUAGE.DE.equals(this.lang) || strArrSplit.length != 5) {
                        break;
                    }
                    arrayList.add(strArrSplit[0]);
                    arrayList2.add(strArrSplit[4]);
                }
            }
        }
        throw new IOException(AbstractC0541b.m773o("Incorrect number of fields per line for language: '", str, "'!"));
    }

    public Conll03NameSampleStream(LANGUAGE language, InputStreamFactory inputStreamFactory, int i) {
        this(language, new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8), i);
    }
}
