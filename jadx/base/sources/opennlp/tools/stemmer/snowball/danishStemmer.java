package opennlp.tools.stemmer.snowball;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class danishStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_x;
    private StringBuilder S_ch = new StringBuilder();
    private static final Among[] a_0 = {new Among("hed", -1, 1), new Among("ethed", 0, 1), new Among("ered", -1, 1), new Among("e", -1, 1), new Among("erede", 3, 1), new Among("ende", 3, 1), new Among("erende", 5, 1), new Among("ene", 3, 1), new Among("erne", 3, 1), new Among("ere", 3, 1), new Among("en", -1, 1), new Among("heden", 10, 1), new Among("eren", 10, 1), new Among("er", -1, 1), new Among("heder", 13, 1), new Among("erer", 13, 1), new Among("s", -1, 2), new Among("heds", 16, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, 16, 1), new Among("endes", 18, 1), new Among("erendes", 19, 1), new Among("enes", 18, 1), new Among("ernes", 18, 1), new Among("eres", 18, 1), new Among("ens", 16, 1), new Among("hedens", 24, 1), new Among("erens", 24, 1), new Among("ers", 16, 1), new Among("ets", 16, 1), new Among("erets", 28, 1), new Among("et", -1, 1), new Among("eret", 30, 1)};
    private static final Among[] a_1 = {new Among(LogBuilders.Property.GENDER, -1, -1), new Among("dt", -1, -1), new Among("gt", -1, -1), new Among("kt", -1, -1)};
    private static final Among[] a_2 = {new Among("ig", -1, 1), new Among("lig", 0, 1), new Among("elig", 1, 1), new Among("els", -1, 1), new Among("løst", -1, 2)};
    private static final char[] g_c = {'w', 223, 'w', 1};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 0, 128};
    private static final char[] g_s_ending = {239, 254, '*', 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

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
        this.bra = this.cursor;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            if (!in_grouping_b(g_s_ending, 97, JPEG.APP5)) {
                return false;
            }
            slice_del();
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
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (eq_s_b("st")) {
            this.bra = this.cursor;
            if (eq_s_b("ig")) {
                slice_del();
            }
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        int i6 = this.I_p1;
        if (i5 < i6) {
            return false;
        }
        int i7 = this.limit_backward;
        this.limit_backward = i6;
        this.ket = i5;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            this.limit_backward = i7;
            return false;
        }
        this.bra = this.cursor;
        this.limit_backward = i7;
        if (iFind_among_b == 1) {
            slice_del();
            int i8 = this.limit - this.cursor;
            r_consonant_pair();
            this.cursor = this.limit - i8;
        } else if (iFind_among_b == 2) {
            slice_from("løs");
        }
        return true;
    }

    private boolean r_undouble() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (!in_grouping_b(g_c, 98, 122)) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        slice_to(this.S_ch);
        this.limit_backward = i4;
        if (!eq_s_b(this.S_ch)) {
            return false;
        }
        slice_del();
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof danishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -1776508850;
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
        this.cursor = this.limit;
        r_undouble();
        this.cursor = this.limit_backward;
        return true;
    }
}
