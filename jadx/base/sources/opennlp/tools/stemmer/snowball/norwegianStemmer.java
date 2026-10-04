package opennlp.tools.stemmer.snowball;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class norwegianStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_x;
    private static final Among[] a_0 = {new Among("a", -1, 1), new Among("e", -1, 1), new Among("ede", 1, 1), new Among("ande", 1, 1), new Among("ende", 1, 1), new Among("ane", 1, 1), new Among("ene", 1, 1), new Among("hetene", 6, 1), new Among("erte", 1, 3), new Among("en", -1, 1), new Among("heten", 9, 1), new Among("ar", -1, 1), new Among("er", -1, 1), new Among("heter", 12, 1), new Among("s", -1, 2), new Among("as", 14, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, 14, 1), new Among("edes", 16, 1), new Among("endes", 16, 1), new Among("enes", 16, 1), new Among("hetenes", 19, 1), new Among("ens", 14, 1), new Among("hetens", 21, 1), new Among("ers", 14, 1), new Among("ets", 14, 1), new Among("et", -1, 1), new Among("het", 25, 1), new Among("ert", -1, 3), new Among("ast", -1, 1)};
    private static final Among[] a_1 = {new Among("dt", -1, -1), new Among("vt", -1, -1)};
    private static final Among[] a_2 = {new Among("leg", -1, 1), new Among("eleg", 0, 1), new Among("ig", -1, 1), new Among("eig", 2, 1), new Among("lig", 2, 1), new Among("elig", 4, 1), new Among("els", -1, 1), new Among("lov", -1, 1), new Among("elov", 7, 1), new Among("slov", 7, 1), new Among("hetslov", 9, 1)};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 128};
    private static final char[] g_s_ending = {'w', '}', 149, 1};

    private boolean r_consonant_pair() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        int i5 = this.I_p1;
        if (i2 < i5) {
            return false;
        }
        int i6 = this.limit_backward;
        this.limit_backward = i5;
        this.ket = i2;
        if (find_among_b(a_1) == 0) {
            this.limit_backward = i6;
            return false;
        }
        this.bra = this.cursor;
        this.limit_backward = i6;
        int i7 = this.limit - i4;
        this.cursor = i7;
        if (i7 <= i6) {
            return false;
        }
        int i8 = i7 - 1;
        this.cursor = i8;
        this.bra = i8;
        slice_del();
        return true;
    }

    private boolean r_main_suffix() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        int iFind_among_b = find_among_b(a_0);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            int i6 = this.limit - i5;
            if (!in_grouping_b(g_s_ending, 98, 122)) {
                this.cursor = this.limit - i6;
                if (!eq_s_b("k") || !out_grouping_b(g_v, 97, 248)) {
                    return false;
                }
            }
            slice_del();
        } else if (iFind_among_b == 3) {
            slice_from("er");
        }
        return true;
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_p1 = i;
        int i2 = this.cursor;
        int i4 = i2 + 3;
        if (i4 > i) {
            return false;
        }
        this.I_x = i4;
        this.cursor = i2;
        while (true) {
            int i5 = this.cursor;
            if (in_grouping(g_v, 97, 248)) {
                this.cursor = i5;
                while (!out_grouping(g_v, 97, 248)) {
                    int i6 = this.cursor;
                    if (i6 >= this.limit) {
                        return false;
                    }
                    this.cursor = i6 + 1;
                }
                int i7 = this.cursor;
                this.I_p1 = i7;
                int i8 = this.I_x;
                if (i7 >= i8) {
                    return true;
                }
                this.I_p1 = i8;
                return true;
            }
            this.cursor = i5;
            if (i5 >= this.limit) {
                return false;
            }
            this.cursor = i5 + 1;
        }
    }

    private boolean r_other_suffix() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (find_among_b(a_2) == 0) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        this.limit_backward = i4;
        slice_del();
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof norwegianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 1236298233;
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
        r_main_suffix();
        this.cursor = this.limit;
        r_consonant_pair();
        this.cursor = this.limit;
        r_other_suffix();
        this.cursor = this.limit_backward;
        return true;
    }
}
