package opennlp.tools.stemmer.snowball;

import com.google.common.base.Ascii;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.ocr.BuildConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class swedishStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_x;
    private static final Among[] a_0 = {new Among("a", -1, 1), new Among("arna", 0, 1), new Among("erna", 0, 1), new Among("heterna", 2, 1), new Among("orna", 0, 1), new Among("ad", -1, 1), new Among("e", -1, 1), new Among("ade", 6, 1), new Among("ande", 6, 1), new Among("arne", 6, 1), new Among("are", 6, 1), new Among("aste", 6, 1), new Among("en", -1, 1), new Among("anden", 12, 1), new Among("aren", 12, 1), new Among("heten", 12, 1), new Among("ern", -1, 1), new Among("ar", -1, 1), new Among("er", -1, 1), new Among("heter", 18, 1), new Among("or", -1, 1), new Among("s", -1, 2), new Among("as", 21, 1), new Among("arnas", 22, 1), new Among("ernas", 22, 1), new Among("ornas", 22, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, 21, 1), new Among("ades", 26, 1), new Among("andes", 26, 1), new Among("ens", 21, 1), new Among("arens", 29, 1), new Among("hetens", 29, 1), new Among("erns", 21, 1), new Among(VPathDataCmd.ArcTo, -1, 1), new Among("andet", -1, 1), new Among("het", -1, 1), new Among("ast", -1, 1)};
    private static final Among[] a_1 = {new Among("dd", -1, -1), new Among(LogBuilders.Property.GENDER, -1, -1), new Among("nn", -1, -1), new Among("dt", -1, -1), new Among("gt", -1, -1), new Among("kt", -1, -1), new Among("tt", -1, -1)};
    private static final Among[] a_2 = {new Among("ig", -1, 1), new Among("lig", 0, 1), new Among("els", -1, 1), new Among("fullt", -1, 3), new Among("öst", -1, 2)};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24, 0, ' '};
    private static final char[] g_s_ending = {'w', Ascii.MAX, 149};
    private static final char[] g_ost_ending = {173, ':'};

    private boolean r_consonant_pair() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        int i5 = this.limit - i;
        if (find_among_b(a_1) == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i6 = this.limit - i5;
        this.cursor = i6;
        this.ket = i6;
        if (i6 <= this.limit_backward) {
            this.limit_backward = i4;
            return false;
        }
        int i7 = i6 - 1;
        this.cursor = i7;
        this.bra = i7;
        slice_del();
        this.limit_backward = i4;
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
            if (!in_grouping_b(g_s_ending, 98, 121)) {
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
            if (in_grouping(g_v, 97, 246)) {
                this.cursor = i5;
                while (!out_grouping(g_v, 97, 246)) {
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
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b != 2) {
            if (iFind_among_b == 3) {
                slice_from(BuildConfig.FLAVOR);
            }
        } else {
            if (!in_grouping_b(g_ost_ending, 105, 118)) {
                return false;
            }
            slice_from("ös");
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof swedishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 1544024492;
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
