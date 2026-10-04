package opennlp.tools.stemmer.snowball;

import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class irishStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("b'", -1, 1), new Among("bh", -1, 4), new Among("bhf", 1, 2), new Among("bp", -1, 8), new Among("ch", -1, 5), new Among("d'", -1, 1), new Among("d'fh", 5, 2), new Among("dh", -1, 6), new Among("dt", -1, 9), new Among("fh", -1, 2), new Among("gc", -1, 5), new Among("gh", -1, 7), new Among("h-", -1, 1), new Among("m'", -1, 1), new Among("mb", -1, 4), new Among("mh", -1, 10), new Among("n-", -1, 1), new Among(SAConstants.DETAIL_SAVE_DEFAULT_TEMPLATE_DEFAULT_POSTFIX_ND, -1, 6), new Among("ng", -1, 7), new Among("ph", -1, 8), new Among("sh", -1, 3), new Among("t-", -1, 1), new Among("th", -1, 9), new Among(DBContract.AckColumns.TIMESTAMP, -1, 3)};
    private static final Among[] a_1 = {new Among("íochta", -1, 1), new Among("aíochta", 0, 1), new Among("ire", -1, 2), new Among("aire", 2, 2), new Among("abh", -1, 1), new Among("eabh", 4, 1), new Among("ibh", -1, 1), new Among("aibh", 6, 1), new Among("amh", -1, 1), new Among("eamh", 8, 1), new Among("imh", -1, 1), new Among("aimh", 10, 1), new Among("íocht", -1, 1), new Among("aíocht", 12, 1), new Among("irí", -1, 2), new Among("airí", 14, 2)};
    private static final Among[] a_2 = {new Among("óideacha", -1, 6), new Among("patacha", -1, 5), new Among("achta", -1, 1), new Among("arcachta", 2, 2), new Among("eachta", 2, 1), new Among("grafaíochta", -1, 4), new Among("paite", -1, 5), new Among("ach", -1, 1), new Among("each", 7, 1), new Among("óideach", 8, 6), new Among("gineach", 8, 3), new Among("patach", 7, 5), new Among("grafaíoch", -1, 4), new Among("pataigh", -1, 5), new Among("óidigh", -1, 6), new Among("achtúil", -1, 1), new Among("eachtúil", 15, 1), new Among("gineas", -1, 3), new Among("ginis", -1, 3), new Among("acht", -1, 1), new Among("arcacht", 19, 2), new Among("eacht", 19, 1), new Among("grafaíocht", -1, 4), new Among("arcachtaí", -1, 2), new Among("grafaíochtaí", -1, 4)};
    private static final Among[] a_3 = {new Among("imid", -1, 1), new Among("aimid", 0, 1), new Among("ímid", -1, 1), new Among("aímid", 2, 1), new Among("adh", -1, 2), new Among("eadh", 4, 2), new Among("faidh", -1, 1), new Among("fidh", -1, 1), new Among("áil", -1, 2), new Among("ain", -1, 2), new Among("tear", -1, 2), new Among("tar", -1, 2)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 17, 4, 2};
    private int I_p1;
    private int I_p2;
    private int I_pV;

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_RV() {
        return this.I_pV <= this.cursor;
    }

    private boolean r_deriv() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        switch (iFind_among_b) {
            case 1:
                if (r_R2()) {
                    slice_del();
                    break;
                }
                break;
            case 2:
                slice_from(VMetaDataPredefinedShape.ARC);
                break;
            case 3:
                slice_from("gin");
                break;
            case 4:
                slice_from("graf");
                break;
            case 5:
                slice_from("paite");
                break;
            case 6:
                slice_from("óid");
                break;
        }
        return false;
    }

    private boolean r_initial_morph() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_0);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        switch (iFind_among) {
            case 1:
                slice_del();
                return true;
            case 2:
                slice_from("f");
                return true;
            case 3:
                slice_from("s");
                return true;
            case 4:
                slice_from("b");
                return true;
            case 5:
                slice_from("c");
                return true;
            case 6:
                slice_from("d");
                return true;
            case 7:
                slice_from("g");
                return true;
            case 8:
                slice_from("p");
                return true;
            case 9:
                slice_from("t");
                return true;
            case 10:
                slice_from("m");
                return true;
            default:
                return true;
        }
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_pV = i;
        this.I_p1 = i;
        this.I_p2 = i;
        int i2 = this.cursor;
        while (true) {
            if (in_grouping(g_v, 97, 250)) {
                this.I_pV = this.cursor;
                while (true) {
                    if (out_grouping(g_v, 97, 250)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 250)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 250)) {
                                        this.I_p2 = this.cursor;
                                        break;
                                    }
                                    int i4 = this.cursor;
                                    if (i4 >= this.limit) {
                                        break;
                                    }
                                    this.cursor = i4 + 1;
                                }
                            } else {
                                int i5 = this.cursor;
                                if (i5 >= this.limit) {
                                    break;
                                }
                                this.cursor = i5 + 1;
                            }
                        }
                    } else {
                        int i6 = this.cursor;
                        if (i6 >= this.limit) {
                            break;
                        }
                        this.cursor = i6 + 1;
                    }
                }
            } else {
                int i7 = this.cursor;
                if (i7 >= this.limit) {
                    break;
                }
                this.cursor = i7 + 1;
            }
        }
        this.cursor = i2;
        return true;
    }

    private boolean r_noun_sfx() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_1);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                if (!r_R2()) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (!r_R1()) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_verb_sfx() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_3);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                if (!r_R1()) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (!r_RV()) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof irishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -1493724462;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        r_initial_morph();
        this.cursor = i;
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_noun_sfx();
        this.cursor = this.limit;
        r_deriv();
        this.cursor = this.limit;
        r_verb_sfx();
        this.cursor = this.limit_backward;
        return true;
    }
}
