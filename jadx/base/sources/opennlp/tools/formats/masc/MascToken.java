package opennlp.tools.formats.masc;

import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascToken extends Span {
    private static final long serialVersionUID = -780646706788037041L;
    private final String base;
    private final String pos;
    private final MascWord[] quarks;
    private final int tokenId;

    public MascToken(int i, int i2, int i4, String str, String str2, MascWord[] mascWordArr) {
        super(i, i2);
        this.pos = str;
        this.base = str2;
        this.tokenId = i4;
        this.quarks = mascWordArr;
    }

    public String getBase() {
        return this.base;
    }

    public String getPos() {
        return this.pos;
    }

    public MascWord[] getQuarks() {
        return this.quarks;
    }

    public int getTokenId() {
        return this.tokenId;
    }
}
