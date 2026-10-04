package opennlp.tools.stemmer.snowball;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class porterStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("s", -1, 3), new Among("ies", 0, 2), new Among("sses", 0, 1), new Among("ss", 0, -1)};
    private static final Among[] a_1 = {new Among("", -1, 3), new Among("bb", 0, 2), new Among("dd", 0, 2), new Among("ff", 0, 2), new Among("gg", 0, 2), new Among("bl", 0, 1), new Among("mm", 0, 2), new Among("nn", 0, 2), new Among("pp", 0, 2), new Among("rr", 0, 2), new Among(VPathDataCmd.ArcTo, 0, 1), new Among("tt", 0, 2), new Among("iz", 0, 1)};
    private static final Among[] a_2 = {new Among("ed", -1, 2), new Among("eed", 0, 1), new Among("ing", -1, 2)};
    private static final Among[] a_3 = {new Among("anci", -1, 3), new Among("enci", -1, 2), new Among("abli", -1, 4), new Among("eli", -1, 6), new Among("alli", -1, 9), new Among("ousli", -1, 11), new Among("entli", -1, 5), new Among("aliti", -1, 9), new Among("biliti", -1, 13), new Among("iviti", -1, 12), new Among("tional", -1, 1), new Among("ational", 10, 8), new Among("alism", -1, 9), new Among("ation", -1, 8), new Among("ization", 13, 7), new Among("izer", -1, 7), new Among("ator", -1, 8), new Among("iveness", -1, 12), new Among("fulness", -1, 10), new Among("ousness", -1, 11)};
    private static final Among[] a_4 = {new Among("icate", -1, 2), new Among("ative", -1, 3), new Among("alize", -1, 1), new Among("iciti", -1, 2), new Among("ical", -1, 2), new Among("ful", -1, 3), new Among("ness", -1, 3)};
    private static final Among[] a_5 = {new Among("ic", -1, 1), new Among("ance", -1, 1), new Among("ence", -1, 1), new Among("able", -1, 1), new Among("ible", -1, 1), new Among("ate", -1, 1), new Among("ive", -1, 1), new Among("ize", -1, 1), new Among("iti", -1, 1), new Among("al", -1, 1), new Among("ism", -1, 1), new Among("ion", -1, 2), new Among("er", -1, 1), new Among("ous", -1, 1), new Among("ant", -1, 1), new Among("ent", -1, 1), new Among("ment", 15, 1), new Among("ement", 16, 1), new Among("ou", -1, 1)};
    private static final char[] g_v = {17, 'A', 16, 1};
    private static final char[] g_v_WXY = {1, 17, 'A', 208, 1};
    private boolean B_Y_found;
    private int I_p1;
    private int I_p2;

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_Step_1a() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_0);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b == 1) {
            slice_from("ss");
        } else if (iFind_among_b == 2) {
            slice_from("i");
        } else if (iFind_among_b == 3) {
            slice_del();
        }
        return true;
    }

    private boolean r_Step_1b() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_2);
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
                int i5 = this.limit - this.cursor;
                int iFind_among_b2 = find_among_b(a_1);
                int i6 = this.limit;
                int i7 = i6 - i5;
                this.cursor = i7;
                if (iFind_among_b2 == 1) {
                    insert(i7, i7, "e");
                    this.cursor = i7;
                } else if (iFind_among_b2 == 2) {
                    this.ket = i7;
                    if (i7 <= this.limit_backward) {
                        return false;
                    }
                    int i8 = i7 - 1;
                    this.cursor = i8;
                    this.bra = i8;
                    slice_del();
                } else if (iFind_among_b2 == 3) {
                    if (i7 != this.I_p1) {
                        return false;
                    }
                    int i9 = i6 - i7;
                    if (!r_shortv()) {
                        return false;
                    }
                    int i10 = this.limit - i9;
                    this.cursor = i10;
                    insert(i10, i10, "e");
                    this.cursor = i10;
                }
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
        while (!in_grouping_b(g_v, 97, 121)) {
            int i4 = this.cursor;
            if (i4 <= this.limit_backward) {
                return false;
            }
            this.cursor = i4 - 1;
        }
        slice_from("i");
        return true;
    }

    private boolean r_Step_2() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_3);
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
                slice_from("e");
                break;
            case 7:
                slice_from("ize");
                break;
            case 8:
                slice_from("ate");
                break;
            case 9:
                slice_from("al");
                break;
            case 10:
                slice_from("ful");
                break;
            case 11:
                slice_from("ous");
                break;
            case 12:
                slice_from("ive");
                break;
            case 13:
                slice_from("ble");
                break;
        }
        return false;
    }

    private boolean r_Step_3() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("al");
        } else if (iFind_among_b == 2) {
            slice_from("ic");
        } else if (iFind_among_b == 3) {
            slice_del();
        }
        return true;
    }

    private boolean r_Step_4() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_5);
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

    private boolean r_Step_5a() {
        this.ket = this.cursor;
        if (!eq_s_b("e")) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
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
        return true;
    }

    private boolean r_Step_5b() {
        this.ket = this.cursor;
        if (!eq_s_b("l")) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R2() || !eq_s_b("l")) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_shortv() {
        if (!out_grouping_b(g_v_WXY, 89, 121)) {
            return false;
        }
        char[] cArr = g_v;
        return in_grouping_b(cArr, 97, 121) && out_grouping_b(cArr, 97, 121);
    }

    public boolean equals(Object obj) {
        return obj instanceof porterStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -171946099;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i;
        int i2;
        int i4;
        this.B_Y_found = false;
        int i5 = this.cursor;
        this.bra = i5;
        if (eq_s("y")) {
            this.ket = this.cursor;
            slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
            this.B_Y_found = true;
        }
        this.cursor = i5;
        while (true) {
            int i6 = this.cursor;
            if (in_grouping(g_v, 97, 121)) {
                this.bra = this.cursor;
                if (eq_s("y")) {
                    this.ket = this.cursor;
                    this.cursor = i6;
                    slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                    this.B_Y_found = true;
                }
            }
            this.cursor = i6;
            i = this.limit;
            if (i6 >= i) {
                break;
            }
            this.cursor = i6 + 1;
        }
        this.cursor = i5;
        this.I_p1 = i;
        this.I_p2 = i;
        while (true) {
            if (in_grouping(g_v, 97, 121)) {
                while (true) {
                    if (out_grouping(g_v, 97, 121)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 121)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 121)) {
                                        this.I_p2 = this.cursor;
                                        break;
                                    }
                                    int i7 = this.cursor;
                                    if (i7 >= this.limit) {
                                        break;
                                    }
                                    this.cursor = i7 + 1;
                                }
                            } else {
                                int i8 = this.cursor;
                                if (i8 >= this.limit) {
                                    break;
                                }
                                this.cursor = i8 + 1;
                            }
                        }
                    } else {
                        int i9 = this.cursor;
                        if (i9 >= this.limit) {
                            break;
                        }
                        this.cursor = i9 + 1;
                    }
                }
            } else {
                int i10 = this.cursor;
                if (i10 >= this.limit) {
                    break;
                }
                this.cursor = i10 + 1;
            }
        }
        this.limit_backward = i5;
        this.cursor = this.limit;
        r_Step_1a();
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
        r_Step_5a();
        this.cursor = this.limit;
        r_Step_5b();
        int i11 = this.limit_backward;
        this.cursor = i11;
        if (this.B_Y_found) {
            loop2: while (true) {
                i2 = this.cursor;
                while (true) {
                    i4 = this.cursor;
                    this.bra = i4;
                    if (!eq_s(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY)) {
                        this.cursor = i4;
                        if (i4 >= this.limit) {
                            break loop2;
                        }
                        this.cursor = i4 + 1;
                    }
                }
                this.ket = this.cursor;
                this.cursor = i4;
                slice_from("y");
            }
            this.cursor = i2;
        }
        this.cursor = i11;
        return true;
    }
}
