package opennlp.tools.sentdetect.lang.p221th;

import kotlin.collections.AbstractC12991c;
import opennlp.tools.sentdetect.DefaultSDContextGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceContextGenerator extends DefaultSDContextGenerator {
    public static final char[] eosCharacters = {' ', '\n'};

    public SentenceContextGenerator() {
        super(eosCharacters);
    }

    @Override // opennlp.tools.sentdetect.DefaultSDContextGenerator
    public void collectFeatures(String str, String str2, String str3, String str4, Character ch) {
        this.buf.append("p=");
        this.buf.append(str);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        this.buf.append("s=");
        this.buf.append(str2);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        AbstractC12991c.m13977A("p1=", str.substring(StrictMath.max(str.length() - 1, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p2=", str.substring(StrictMath.max(str.length() - 2, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p3=", str.substring(StrictMath.max(str.length() - 3, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p4=", str.substring(StrictMath.max(str.length() - 4, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p5=", str.substring(StrictMath.max(str.length() - 5, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p6=", str.substring(StrictMath.max(str.length() - 6, 0)), this.collectFeats);
        AbstractC12991c.m13977A("p7=", str.substring(StrictMath.max(str.length() - 7, 0)), this.collectFeats);
        AbstractC12991c.m13977A("n1=", str2.substring(0, StrictMath.min(1, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n2=", str2.substring(0, StrictMath.min(2, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n3=", str2.substring(0, StrictMath.min(3, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n4=", str2.substring(0, StrictMath.min(4, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n5=", str2.substring(0, StrictMath.min(5, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n6=", str2.substring(0, StrictMath.min(6, str2.length())), this.collectFeats);
        AbstractC12991c.m13977A("n7=", str2.substring(0, StrictMath.min(7, str2.length())), this.collectFeats);
    }
}
