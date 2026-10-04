package opennlp.tools.formats.masc;

import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascWord extends Span {
    private static final long serialVersionUID = 2133473549058189775L;

    /* JADX INFO: renamed from: id */
    private final int f9663id;

    public MascWord(int i, int i2, int i4) {
        super(i, i2);
        this.f9663id = i4;
    }

    public int getId() {
        return this.f9663id;
    }
}
