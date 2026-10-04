package opennlp.tools.stemmer.snowball;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class englishStemmer extends AbstractSnowballStemmer {
    private boolean B_Y_found;
    private int I_p1;
    private int I_p2;
    private static final Among[] a_0 = {new Among("arsen", -1, -1), new Among("commun", -1, -1), new Among("gener", -1, -1)};
    private static final Among[] a_1 = {new Among("'", -1, 1), new Among("'s'", 0, 1), new Among("'s", -1, 1)};
    private static final Among[] a_2 = {new Among("ied", -1, 2), new Among("s", -1, 3), new Among("ies", 1, 2), new Among("sses", 1, 1), new Among("ss", 1, -1), new Among("us", 1, -1)};
    private static final Among[] a_3 = {new Among("", -1, 3), new Among("bb", 0, 2), new Among("dd", 0, 2), new Among("ff", 0, 2), new Among("gg", 0, 2), new Among("bl", 0, 1), new Among("mm", 0, 2), new Among("nn", 0, 2), new Among("pp", 0, 2), new Among("rr", 0, 2), new Among(VPathDataCmd.ArcTo, 0, 1), new Among("tt", 0, 2), new Among("iz", 0, 1)};
    private static final Among[] a_4 = {new Among("ed", -1, 2), new Among("eed", 0, 1), new Among("ing", -1, 2), new Among("edly", -1, 2), new Among("eedly", 3, 1), new Among("ingly", -1, 2)};
    private static final Among[] a_5 = {new Among("anci", -1, 3), new Among("enci", -1, 2), new Among("ogi", -1, 13), new Among("li", -1, 15), new Among("bli", 3, 12), new Among("abli", 4, 4), new Among("alli", 3, 8), new Among("fulli", 3, 9), new Among("lessli", 3, 14), new Among("ousli", 3, 10), new Among("entli", 3, 5), new Among("aliti", -1, 8), new Among("biliti", -1, 12), new Among("iviti", -1, 11), new Among("tional", -1, 1), new Among("ational", 14, 7), new Among("alism", -1, 8), new Among("ation", -1, 7), new Among("ization", 17, 6), new Among("izer", -1, 6), new Among("ator", -1, 7), new Among("iveness", -1, 11), new Among("fulness", -1, 9), new Among("ousness", -1, 10)};
    private static final Among[] a_6 = {new Among("icate", -1, 4), new Among("ative", -1, 6), new Among("alize", -1, 3), new Among("iciti", -1, 4), new Among("ical", -1, 4), new Among("tional", -1, 1), new Among("ational", 5, 2), new Among("ful", -1, 5), new Among("ness", -1, 5)};
    private static final Among[] a_7 = {new Among("ic", -1, 1), new Among("ance", -1, 1), new Among("ence", -1, 1), new Among("able", -1, 1), new Among("ible", -1, 1), new Among("ate", -1, 1), new Among("ive", -1, 1), new Among("ize", -1, 1), new Among("iti", -1, 1), new Among("al", -1, 1), new Among("ism", -1, 1), new Among("ion", -1, 2), new Among("er", -1, 1), new Among("ous", -1, 1), new Among("ant", -1, 1), new Among("ent", -1, 1), new Among("ment", 15, 1), new Among("ement", 16, 1)};
    private static final Among[] a_8 = {new Among("e", -1, 1), new Among("l", -1, 2)};
    private static final Among[] a_9 = {new Among("succeed", -1, -1), new Among("proceed", -1, -1), new Among("exceed", -1, -1), new Among("canning", -1, -1), new Among("inning", -1, -1), new Among("earring", -1, -1), new Among("herring", -1, -1), new Among("outing", -1, -1)};
    private static final Among[] a_10 = {new Among("andes", -1, -1), new Among("atlas", -1, -1), new Among("bias", -1, -1), new Among("cosmos", -1, -1), new Among("dying", -1, 3), new Among("early", -1, 9), new Among("gently", -1, 7), new Among("howe", -1, -1), new Among("idly", -1, 6), new Among("lying", -1, 4), new Among("news", -1, -1), new Among("only", -1, 10), new Among("singly", -1, 11), new Among("skies", -1, 2), new Among("skis", -1, 1), new Among("sky", -1, -1), new Among("tying", -1, 5), new Among("ugly", -1, 8)};
    private static final char[] g_aeo = {17, '@'};
    private static final char[] g_v = {17, 'A', 16, 1};
    private static final char[] g_v_WXY = {1, 17, 'A', 208, 1};
    private static final char[] g_valid_LI = {'7', 141, 2};

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_Step_1a() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (find_among_b(a_1) == 0) {
            this.cursor = this.limit - i4;
        } else {
            this.bra = this.cursor;
            slice_del();
        }
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        if (iFind_among_b == 1) {
            slice_from("ss");
        } else if (iFind_among_b == 2) {
            int i6 = this.limit;
            int i7 = i6 - i5;
            int i8 = i5 - 2;
            if (i8 < this.limit_backward) {
                this.cursor = i6 - i7;
                slice_from("ie");
            } else {
                this.cursor = i8;
                slice_from("i");
            }
        } else if (iFind_among_b == 3) {
            if (i5 <= this.limit_backward) {
                return false;
            }
            this.cursor = i5 - 1;
            while (!in_grouping_b(g_v, 97, 121)) {
                int i9 = this.cursor;
                if (i9 <= this.limit_backward) {
                    return false;
                }
                this.cursor = i9 - 1;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Step_1b() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                int i2 = this.limit - i;
                while (!in_grouping_b(g_v, 97, 121)) {
                    int i4 = this.cursor;
                    if (i4 <= this.limit_backward) {
                        return false;
                    }
                    this.cursor = i4 - 1;
                }
                this.cursor = this.limit - i2;
                slice_del();
                int i5 = this.cursor;
                this.ket = i5;
                this.bra = i5;
                int i6 = this.limit - i5;
                int iFind_among_b2 = find_among_b(a_3);
                if (iFind_among_b2 == 1) {
                    slice_from("e");
                    return false;
                }
                if (iFind_among_b2 == 2) {
                    int i7 = this.limit - this.cursor;
                    if (in_grouping_b(g_aeo, 97, 111) && this.cursor <= this.limit_backward) {
                        return false;
                    }
                    this.cursor = this.limit - i7;
                } else if (iFind_among_b2 == 3) {
                    int i8 = this.cursor;
                    if (i8 != this.I_p1) {
                        return false;
                    }
                    int i9 = this.limit - i8;
                    if (!r_shortv()) {
                        return false;
                    }
                    this.cursor = this.limit - i9;
                    slice_from("e");
                    return false;
                }
                int i10 = this.limit - i6;
                this.cursor = i10;
                this.ket = i10;
                if (i10 <= this.limit_backward) {
                    return false;
                }
                int i11 = i10 - 1;
                this.cursor = i11;
                this.bra = i11;
                slice_del();
            }
        } else {
            if (!r_R1()) {
                return false;
            }
            slice_from("ee");
        }
        return true;
    }

    private boolean r_Step_1c() {
        int i = this.cursor;
        this.ket = i;
        int i2 = this.limit - i;
        if (!eq_s_b("y")) {
            this.cursor = this.limit - i2;
            if (!eq_s_b(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY)) {
                return false;
            }
        }
        this.bra = this.cursor;
        if (!out_grouping_b(g_v, 97, 121) || this.cursor <= this.limit_backward) {
            return false;
        }
        slice_from("i");
        return true;
    }

    private boolean r_Step_2() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_5);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        switch (iFind_among_b) {
            case 1:
                slice_from("tion");
                break;
            case 2:
                slice_from("ence");
                break;
            case 3:
                slice_from("ance");
                break;
            case 4:
                slice_from("able");
                break;
            case 5:
                slice_from("ent");
                break;
            case 6:
                slice_from("ize");
                break;
            case 7:
                slice_from("ate");
                break;
            case 8:
                slice_from("al");
                break;
            case 9:
                slice_from("ful");
                break;
            case 10:
                slice_from("ous");
                break;
            case 11:
                slice_from("ive");
                break;
            case 12:
                slice_from("ble");
                break;
            case 13:
                if (eq_s_b("l")) {
                    slice_from("og");
                    break;
                }
                break;
            case 14:
                slice_from("less");
                break;
            case 15:
                if (in_grouping_b(g_valid_LI, 99, 116)) {
                    slice_del();
                    break;
                }
                break;
        }
        return false;
    }

    private boolean r_Step_3() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_6);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        switch (iFind_among_b) {
            case 1:
                slice_from("tion");
                break;
            case 2:
                slice_from("ate");
                break;
            case 3:
                slice_from("al");
                break;
            case 4:
                slice_from("ic");
                break;
            case 5:
                slice_del();
                break;
            case 6:
                if (r_R2()) {
                    slice_del();
                    break;
                }
                break;
        }
        return false;
    }

    private boolean r_Step_4() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_7);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R2()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            int i = this.limit - this.cursor;
            if (!eq_s_b("s")) {
                this.cursor = this.limit - i;
                if (!eq_s_b("t")) {
                    return false;
                }
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Step_5() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_8);
        if (iFind_among_b == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
        if (iFind_among_b == 1) {
            int i2 = this.limit - i;
            if (!r_R2()) {
                this.cursor = this.limit - i2;
                if (!r_R1()) {
                    return false;
                }
                int i4 = this.limit - this.cursor;
                if (r_shortv()) {
                    return false;
                }
                this.cursor = this.limit - i4;
            }
            slice_del();
        } else if (iFind_among_b == 2) {
            if (!r_R2() || !eq_s_b("l")) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_exception1() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_10);
        if (iFind_among == 0) {
            return false;
        }
        int i = this.cursor;
        this.ket = i;
        if (i < this.limit) {
            return false;
        }
        switch (iFind_among) {
            case 1:
                slice_from("ski");
                break;
            case 2:
                slice_from("sky");
                break;
            case 3:
                slice_from("die");
                break;
            case 4:
                slice_from("lie");
                break;
            case 5:
                slice_from("tie");
                break;
            case 6:
                slice_from("idl");
                break;
            case 7:
                slice_from("gentl");
                break;
            case 8:
                slice_from("ugli");
                break;
            case 9:
                slice_from("earli");
                break;
            case 10:
                slice_from("onli");
                break;
            case 11:
                slice_from("singl");
                break;
        }
        return false;
    }

    private boolean r_exception2() {
        this.ket = this.cursor;
        if (find_among_b(a_9) == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
        return i <= this.limit_backward;
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_p1 = i;
        this.I_p2 = i;
        int i2 = this.cursor;
        if (find_among(a_0) != 0) {
            this.I_p1 = this.cursor;
            while (true) {
                if (in_grouping(g_v, 97, 121)) {
                    while (true) {
                        if (out_grouping(g_v, 97, 121)) {
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
            this.cursor = i2;
            while (true) {
                if (in_grouping(g_v, 97, 121)) {
                    while (!out_grouping(g_v, 97, 121)) {
                        int i6 = this.cursor;
                        if (i6 >= this.limit) {
                            break;
                        }
                        this.cursor = i6 + 1;
                    }
                } else {
                    int i7 = this.cursor;
                    if (i7 >= this.limit) {
                        break;
                    }
                    this.cursor = i7 + 1;
                }
            }
        }
        this.cursor = i2;
        return true;
    }

    private boolean r_postlude() {
        int i;
        if (!this.B_Y_found) {
            return false;
        }
        while (true) {
            int i2 = this.cursor;
            while (true) {
                i = this.cursor;
                this.bra = i;
                if (!eq_s(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY)) {
                    this.cursor = i;
                    if (i >= this.limit) {
                        this.cursor = i2;
                        return true;
                    }
                    this.cursor = i + 1;
                }
            }
            this.ket = this.cursor;
            this.cursor = i;
            slice_from("y");
        }
    }

    private boolean r_prelude() {
        this.B_Y_found = false;
        int i = this.cursor;
        this.bra = i;
        if (eq_s("'")) {
            this.ket = this.cursor;
            slice_del();
        }
        this.cursor = i;
        this.bra = i;
        if (eq_s("y")) {
            this.ket = this.cursor;
            slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
            this.B_Y_found = true;
        }
        this.cursor = i;
        while (true) {
            int i2 = this.cursor;
            if (in_grouping(g_v, 97, 121)) {
                this.bra = this.cursor;
                if (eq_s("y")) {
                    this.ket = this.cursor;
                    this.cursor = i2;
                    slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                    this.B_Y_found = true;
                }
            }
            this.cursor = i2;
            if (i2 >= this.limit) {
                this.cursor = i;
                return true;
            }
            this.cursor = i2 + 1;
        }
    }

    private boolean r_shortv() {
        int i = this.limit - this.cursor;
        if (out_grouping_b(g_v_WXY, 89, 121)) {
            char[] cArr = g_v;
            if (in_grouping_b(cArr, 97, 121) && out_grouping_b(cArr, 97, 121)) {
                return true;
            }
        }
        this.cursor = this.limit - i;
        char[] cArr2 = g_v;
        return out_grouping_b(cArr2, 97, 121) && in_grouping_b(cArr2, 97, 121) && this.cursor <= this.limit_backward;
    }

    public boolean equals(Object obj) {
        return obj instanceof englishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 1439994167;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        if (r_exception1()) {
            return true;
        }
        this.cursor = i;
        if (i + 3 > this.limit) {
            this.cursor = i;
            return true;
        }
        this.cursor = i;
        r_prelude();
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_Step_1a();
        this.cursor = this.limit;
        if (!r_exception2()) {
            this.cursor = this.limit;
            r_Step_1b();
            this.cursor = this.limit;
            r_Step_1c();
            this.cursor = this.limit;
            r_Step_2();
            this.cursor = this.limit;
            r_Step_3();
            this.cursor = this.limit;
            r_Step_4();
            this.cursor = this.limit;
            r_Step_5();
            this.cursor = this.limit;
        }
        int i2 = this.limit_backward;
        this.cursor = i2;
        r_postlude();
        this.cursor = i2;
        return true;
    }
}
