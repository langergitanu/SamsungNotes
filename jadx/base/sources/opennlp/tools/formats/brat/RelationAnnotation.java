package opennlp.tools.formats.brat;

import androidx.constraintlayout.motion.widget.AbstractC2322a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RelationAnnotation extends BratAnnotation {
    private final String arg1;
    private final String arg2;

    public RelationAnnotation(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.arg1 = str3;
        this.arg2 = str4;
    }

    public String getArg1() {
        return this.arg1;
    }

    public String getArg2() {
        return this.arg2;
    }

    @Override // opennlp.tools.formats.brat.BratAnnotation
    public String toString() {
        return AbstractC2322a.m1622l(super.toString(), " arg1:", getArg1(), " arg2:", getArg2());
    }
}
