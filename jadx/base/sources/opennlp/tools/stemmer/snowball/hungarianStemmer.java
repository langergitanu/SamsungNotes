package opennlp.tools.stemmer.snowball;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.pen.ocr.SpenOcrDataProviderContract;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class hungarianStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private static final Among[] a_0 = {new Among("cs", -1, -1), new Among("dzs", -1, -1), new Among("gy", -1, -1), new Among("ly", -1, -1), new Among("ny", -1, -1), new Among("sz", -1, -1), new Among("ty", -1, -1), new Among("zs", -1, -1)};
    private static final Among[] a_1 = {new Among("á", -1, 1), new Among("é", -1, 2)};
    private static final Among[] a_2 = {new Among("bb", -1, -1), new Among(LogBuilders.Property.COUNTRY_CODE, -1, -1), new Among("dd", -1, -1), new Among("ff", -1, -1), new Among("gg", -1, -1), new Among("jj", -1, -1), new Among("kk", -1, -1), new Among("ll", -1, -1), new Among("mm", -1, -1), new Among("nn", -1, -1), new Among("pp", -1, -1), new Among("rr", -1, -1), new Among("ccs", -1, -1), new Among("ss", -1, -1), new Among("zzs", -1, -1), new Among("tt", -1, -1), new Among("vv", -1, -1), new Among("ggy", -1, -1), new Among("lly", -1, -1), new Among("nny", -1, -1), new Among("tty", -1, -1), new Among("ssz", -1, -1), new Among("zz", -1, -1)};
    private static final Among[] a_3 = {new Among("al", -1, 1), new Among("el", -1, 1)};
    private static final Among[] a_4 = {new Among(SpenOcrDataProviderContract.ASSETS_MODEL_BLOCK_ANALYZER, -1, -1), new Among("ra", -1, -1), new Among("be", -1, -1), new Among("re", -1, -1), new Among("ig", -1, -1), new Among("nak", -1, -1), new Among("nek", -1, -1), new Among(VElementFormulasCmd.FVAL, -1, -1), new Among("vel", -1, -1), new Among("ul", -1, -1), new Among("nál", -1, -1), new Among("nél", -1, -1), new Among("ból", -1, -1), new Among("ról", -1, -1), new Among("tól", -1, -1), new Among("ül", -1, -1), new Among("ből", -1, -1), new Among("ről", -1, -1), new Among("től", -1, -1), new Among("n", -1, -1), new Among("an", 19, -1), new Among("ban", 20, -1), new Among("en", 19, -1), new Among("ben", 22, -1), new Among("képpen", 22, -1), new Among("on", 19, -1), new Among("ön", 19, -1), new Among("képp", -1, -1), new Among("kor", -1, -1), new Among("t", -1, -1), new Among(VPathDataCmd.ArcTo, 29, -1), new Among("et", 29, -1), new Among("ként", 29, -1), new Among("anként", 32, -1), new Among("enként", 32, -1), new Among("onként", 32, -1), new Among("ot", 29, -1), new Among("ért", 29, -1), new Among("öt", 29, -1), new Among("hez", -1, -1), new Among("hoz", -1, -1), new Among("höz", -1, -1), new Among("vá", -1, -1), new Among("vé", -1, -1)};
    private static final Among[] a_5 = {new Among("án", -1, 2), new Among("én", -1, 1), new Among("ánként", -1, 2)};
    private static final Among[] a_6 = {new Among("stul", -1, 1), new Among("astul", 0, 1), new Among("ástul", 0, 2), new Among("stül", -1, 1), new Among("estül", 3, 1), new Among("éstül", 3, 3)};
    private static final Among[] a_7 = {new Among("á", -1, 1), new Among("é", -1, 1)};
    private static final Among[] a_8 = {new Among("k", -1, 3), new Among("ak", 0, 3), new Among("ek", 0, 3), new Among("ok", 0, 3), new Among("ák", 0, 1), new Among("ék", 0, 2), new Among("ök", 0, 3)};
    private static final Among[] a_9 = {new Among("éi", -1, 1), new Among("áéi", 0, 3), new Among("ééi", 0, 2), new Among("é", -1, 1), new Among("ké", 3, 1), new Among("aké", 4, 1), new Among("eké", 4, 1), new Among("oké", 4, 1), new Among("áké", 4, 3), new Among("éké", 4, 2), new Among("öké", 4, 1), new Among("éé", 3, 2)};
    private static final Among[] a_10 = {new Among("a", -1, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_JA, 0, 1), new Among("d", -1, 1), new Among("ad", 2, 1), new Among("ed", 2, 1), new Among("od", 2, 1), new Among("ád", 2, 2), new Among("éd", 2, 3), new Among("öd", 2, 1), new Among("e", -1, 1), new Among("je", 9, 1), new Among("nk", -1, 1), new Among("unk", 11, 1), new Among("ánk", 11, 2), new Among("énk", 11, 3), new Among("ünk", 11, 1), new Among("uk", -1, 1), new Among("juk", 16, 1), new Among("ájuk", 17, 2), new Among("ük", -1, 1), new Among("jük", 19, 1), new Among("éjük", 20, 3), new Among("m", -1, 1), new Among("am", 22, 1), new Among("em", 22, 1), new Among("om", 22, 1), new Among("ám", 22, 2), new Among("ém", 22, 3), new Among("o", -1, 1), new Among("á", -1, 2), new Among("é", -1, 3)};
    private static final Among[] a_11 = {new Among("id", -1, 1), new Among(NetworkConfig.FEEDBACK_AID, 0, 1), new Among("jaid", 1, 1), new Among("eid", 0, 1), new Among("jeid", 3, 1), new Among("áid", 0, 2), new Among("éid", 0, 3), new Among("i", -1, 1), new Among("ai", 7, 1), new Among("jai", 8, 1), new Among("ei", 7, 1), new Among("jei", 10, 1), new Among("ái", 7, 2), new Among("éi", 7, 3), new Among("itek", -1, 1), new Among("eitek", 14, 1), new Among("jeitek", 15, 1), new Among("éitek", 14, 3), new Among("ik", -1, 1), new Among("aik", 18, 1), new Among("jaik", 19, 1), new Among("eik", 18, 1), new Among("jeik", 21, 1), new Among("áik", 18, 2), new Among("éik", 18, 3), new Among("ink", -1, 1), new Among("aink", 25, 1), new Among("jaink", 26, 1), new Among("eink", 25, 1), new Among("jeink", 28, 1), new Among("áink", 25, 2), new Among("éink", 25, 3), new Among("aitok", -1, 1), new Among("jaitok", 32, 1), new Among("áitok", -1, 2), new Among("im", -1, 1), new Among("aim", 35, 1), new Among("jaim", 36, 1), new Among("eim", 35, 1), new Among("jeim", 38, 1), new Among("áim", 35, 2), new Among("éim", 35, 3)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 17, '$', '\n', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_case() {
        this.ket = this.cursor;
        if (find_among_b(a_4) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        slice_del();
        return r_v_ending();
    }

    private boolean r_case_other() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_6);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_from("a");
        } else if (iFind_among_b == 3) {
            slice_from("e");
        }
        return true;
    }

    private boolean r_case_special() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_5);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("e");
        } else if (iFind_among_b == 2) {
            slice_from("a");
        }
        return true;
    }

    private boolean r_double() {
        int i = this.limit - this.cursor;
        if (find_among_b(a_2) == 0) {
            return false;
        }
        this.cursor = this.limit - i;
        return true;
    }

    private boolean r_factive() {
        this.ket = this.cursor;
        if (find_among_b(a_7) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1() || !r_double()) {
            return false;
        }
        slice_del();
        return r_undouble();
    }

    private boolean r_instrum() {
        this.ket = this.cursor;
        if (find_among_b(a_3) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1() || !r_double()) {
            return false;
        }
        slice_del();
        return r_undouble();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[LOOP:1: B:18:0x0046->B:23:0x0055, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_regions() {
        this.I_p1 = this.limit;
        int i = this.cursor;
        if (in_grouping(g_v, 97, 369)) {
            while (true) {
                int i2 = this.cursor;
                if (out_grouping(g_v, 97, 369)) {
                    this.cursor = i2;
                    if (find_among(a_0) == 0) {
                        this.cursor = i2;
                        if (i2 < this.limit) {
                            this.cursor = i2 + 1;
                        }
                    }
                    this.I_p1 = this.cursor;
                } else {
                    this.cursor = i2;
                    if (i2 >= this.limit) {
                        break;
                    }
                    this.cursor = i2 + 1;
                }
            }
            this.cursor = i;
            if (out_grouping(g_v, 97, 369)) {
            }
        } else {
            this.cursor = i;
            if (out_grouping(g_v, 97, 369)) {
                return false;
            }
            while (!in_grouping(g_v, 97, 369)) {
                int i4 = this.cursor;
                if (i4 >= this.limit) {
                    return false;
                }
                this.cursor = i4 + 1;
            }
            this.I_p1 = this.cursor;
        }
        return true;
    }

    private boolean r_owned() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_9);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_from("e");
        } else if (iFind_among_b == 3) {
            slice_from("a");
        }
        return true;
    }

    private boolean r_plur_owner() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_11);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_from("a");
        } else if (iFind_among_b == 3) {
            slice_from("e");
        }
        return true;
    }

    private boolean r_plural() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_8);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("a");
        } else if (iFind_among_b == 2) {
            slice_from("e");
        } else if (iFind_among_b == 3) {
            slice_del();
        }
        return true;
    }

    private boolean r_sing_owner() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_10);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_from("a");
        } else if (iFind_among_b == 3) {
            slice_from("e");
        }
        return true;
    }

    private boolean r_undouble() {
        int i = this.cursor;
        int i2 = this.limit_backward;
        if (i <= i2) {
            return false;
        }
        int i4 = i - 1;
        this.cursor = i4;
        this.ket = i4;
        int i5 = i - 2;
        if (i5 < i2) {
            return false;
        }
        this.cursor = i5;
        this.bra = i5;
        slice_del();
        return true;
    }

    private boolean r_v_ending() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_1);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("a");
        } else if (iFind_among_b == 2) {
            slice_from("e");
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof hungarianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -221299064;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        r_mark_regions();
        this.limit_backward = i;
        this.cursor = this.limit;
        r_instrum();
        this.cursor = this.limit;
        r_case();
        this.cursor = this.limit;
        r_case_special();
        this.cursor = this.limit;
        r_case_other();
        this.cursor = this.limit;
        r_factive();
        this.cursor = this.limit;
        r_owned();
        this.cursor = this.limit;
        r_sing_owner();
        this.cursor = this.limit;
        r_plur_owner();
        this.cursor = this.limit;
        r_plural();
        this.cursor = this.limit_backward;
        return true;
    }
}
