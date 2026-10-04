package opennlp.tools.formats.conllu;

import androidx.appcompat.widget.AbstractC0541b;
import opennlp.tools.util.InvalidFormatException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluWordLine {
    private final String deprel;
    private final String deps;
    private final String feats;
    private final String form;
    private final String head;

    /* JADX INFO: renamed from: id */
    private final String f9662id;
    private final String lemma;
    private final String misc;
    private final String uPosTag;
    private final String xPosTag;

    /* JADX INFO: renamed from: opennlp.tools.formats.conllu.ConlluWordLine$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C136331 {
        static final /* synthetic */ int[] $SwitchMap$opennlp$tools$formats$conllu$ConlluTagset;

        static {
            int[] iArr = new int[ConlluTagset.values().length];
            $SwitchMap$opennlp$tools$formats$conllu$ConlluTagset = iArr;
            try {
                iArr[ConlluTagset.U.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$opennlp$tools$formats$conllu$ConlluTagset[ConlluTagset.X.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ConlluWordLine(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f9662id = str;
        this.form = str2;
        this.lemma = str3;
        this.uPosTag = str4;
        this.xPosTag = str5;
        this.feats = str6;
        this.head = str7;
        this.deprel = str8;
        this.deps = str9;
        this.misc = str10;
    }

    public String getDeprel() {
        return this.deprel;
    }

    public String getDeps() {
        return this.deps;
    }

    public String getFeats() {
        return this.feats;
    }

    public String getForm() {
        return this.form;
    }

    public String getHead() {
        return this.head;
    }

    public String getId() {
        return this.f9662id;
    }

    public String getLemma() {
        return this.lemma;
    }

    public String getMisc() {
        return this.misc;
    }

    public String getPosTag(ConlluTagset conlluTagset) {
        int i = C136331.$SwitchMap$opennlp$tools$formats$conllu$ConlluTagset[conlluTagset.ordinal()];
        if (i == 1) {
            return this.uPosTag;
        }
        if (i == 2) {
            return this.xPosTag;
        }
        throw new IllegalStateException("Unexpected tagset value: " + conlluTagset);
    }

    public ConlluWordLine(String str) throws InvalidFormatException {
        String[] strArrSplit = str.split("\t");
        if (strArrSplit.length == 10) {
            this.f9662id = strArrSplit[0];
            this.form = strArrSplit[1];
            this.lemma = strArrSplit[2];
            this.uPosTag = strArrSplit[3];
            this.xPosTag = strArrSplit[4];
            this.feats = strArrSplit[5];
            this.head = strArrSplit[6];
            this.deprel = strArrSplit[7];
            this.deps = strArrSplit[8];
            this.misc = strArrSplit[9];
            return;
        }
        throw new InvalidFormatException(AbstractC0541b.m773o("Line [", str, "] must have exactly 10 fields"));
    }
}
