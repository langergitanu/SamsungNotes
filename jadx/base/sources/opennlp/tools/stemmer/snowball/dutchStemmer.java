package opennlp.tools.stemmer.snowball;

import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class dutchStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("", -1, 6), new Among("á", 0, 1), new Among("ä", 0, 1), new Among("é", 0, 2), new Among("ë", 0, 2), new Among("í", 0, 3), new Among("ï", 0, 3), new Among("ó", 0, 4), new Among("ö", 0, 4), new Among("ú", 0, 5), new Among("ü", 0, 5)};
    private static final Among[] a_1 = {new Among("", -1, 3), new Among("I", 0, 2), new Among(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, 0, 1)};
    private static final Among[] a_2 = {new Among("dd", -1, -1), new Among("kk", -1, -1), new Among("tt", -1, -1)};
    private static final Among[] a_3 = {new Among("ene", -1, 2), new Among("se", -1, 3), new Among("en", -1, 2), new Among("heden", 2, 1), new Among("s", -1, 3)};
    private static final Among[] a_4 = {new Among("end", -1, 1), new Among("ig", -1, 2), new Among("ing", -1, 1), new Among("lijk", -1, 3), new Among("baar", -1, 4), new Among("bar", -1, 5)};
    private static final Among[] a_5 = {new Among("aa", -1, -1), new Among("ee", -1, -1), new Among("oo", -1, -1), new Among("uu", -1, -1)};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128};
    private static final char[] g_v_I = {1, 0, 0, 17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128};
    private static final char[] g_v_j = {17, 'C', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128};
    private boolean B_e_found;
    private int I_p1;
    private int I_p2;

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_e_ending() {
        this.B_e_found = false;
        this.ket = this.cursor;
        if (!eq_s_b("e")) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        int i = this.limit - this.cursor;
        if (!out_grouping_b(g_v, 97, JPEG.APP8)) {
            return false;
        }
        this.cursor = this.limit - i;
        slice_del();
        this.B_e_found = true;
        return r_undouble();
    }

    private boolean r_en_ending() {
        if (!r_R1()) {
            return false;
        }
        int i = this.limit - this.cursor;
        if (!out_grouping_b(g_v, 97, JPEG.APP8)) {
            return false;
        }
        int i2 = this.limit;
        int i4 = i2 - i;
        this.cursor = i4;
        int i5 = i2 - i4;
        if (eq_s_b("gem")) {
            return false;
        }
        this.cursor = this.limit - i5;
        slice_del();
        return r_undouble();
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_p1 = i;
        this.I_p2 = i;
        while (!in_grouping(g_v, 97, JPEG.APP8)) {
            int i2 = this.cursor;
            if (i2 >= this.limit) {
                return false;
            }
            this.cursor = i2 + 1;
        }
        while (!out_grouping(g_v, 97, JPEG.APP8)) {
            int i4 = this.cursor;
            if (i4 >= this.limit) {
                return false;
            }
            this.cursor = i4 + 1;
        }
        int i5 = this.cursor;
        this.I_p1 = i5;
        if (i5 < 3) {
            this.I_p1 = 3;
        }
        while (!in_grouping(g_v, 97, JPEG.APP8)) {
            int i6 = this.cursor;
            if (i6 >= this.limit) {
                return false;
            }
            this.cursor = i6 + 1;
        }
        while (!out_grouping(g_v, 97, JPEG.APP8)) {
            int i7 = this.cursor;
            if (i7 >= this.limit) {
                return false;
            }
            this.cursor = i7 + 1;
        }
        this.I_p2 = this.cursor;
        return true;
    }

    private boolean r_postlude() {
        while (true) {
            int i = this.cursor;
            this.bra = i;
            int iFind_among = find_among(a_1);
            int i2 = this.cursor;
            this.ket = i2;
            if (iFind_among == 1) {
                slice_from("y");
            } else if (iFind_among == 2) {
                slice_from("i");
            } else if (iFind_among != 3) {
                continue;
            } else {
                if (i2 >= this.limit) {
                    this.cursor = i;
                    return true;
                }
                this.cursor = i2 + 1;
            }
        }
    }

    private boolean r_prelude() {
        int i;
        int i2 = this.cursor;
        while (true) {
            this.bra = this.cursor;
            int iFind_among = find_among(a_0);
            int i4 = this.cursor;
            this.ket = i4;
            switch (iFind_among) {
                case 1:
                    slice_from("a");
                    break;
                case 2:
                    slice_from("e");
                    break;
                case 3:
                    slice_from("i");
                    break;
                case 4:
                    slice_from("o");
                    break;
                case 5:
                    slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                    break;
                case 6:
                    if (i4 < this.limit) {
                        this.cursor = i4 + 1;
                    } else {
                        this.cursor = i2;
                        this.bra = i2;
                        if (eq_s("y")) {
                            this.ket = this.cursor;
                            slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                        } else {
                            this.cursor = i2;
                        }
                        while (true) {
                            int i5 = this.cursor;
                            while (true) {
                                i = this.cursor;
                                char[] cArr = g_v;
                                if (in_grouping(cArr, 97, JPEG.APP8)) {
                                    int i6 = this.cursor;
                                    this.bra = i6;
                                    if (eq_s("i")) {
                                        this.ket = this.cursor;
                                        if (in_grouping(cArr, 97, JPEG.APP8)) {
                                            slice_from("I");
                                        }
                                    }
                                    this.cursor = i6;
                                    if (eq_s("y")) {
                                        this.ket = this.cursor;
                                        slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                                    }
                                }
                                this.cursor = i;
                                if (i >= this.limit) {
                                    this.cursor = i5;
                                    return true;
                                }
                                this.cursor = i + 1;
                            }
                            this.cursor = i;
                        }
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_standard_suffix() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        int iFind_among_b = find_among_b(a_3);
        if (iFind_among_b != 0) {
            this.bra = this.cursor;
            if (iFind_among_b != 1) {
                if (iFind_among_b == 2) {
                    r_en_ending();
                } else if (iFind_among_b == 3 && r_R1() && out_grouping_b(g_v_j, 97, JPEG.APP8)) {
                    slice_del();
                }
            } else if (r_R1()) {
                slice_from("heid");
            }
        }
        int i5 = this.limit;
        int i6 = i5 - i4;
        this.cursor = i6;
        int i7 = i5 - i6;
        r_e_ending();
        int i8 = this.limit;
        int i9 = i8 - i7;
        this.cursor = i9;
        int i10 = i8 - i9;
        this.ket = i9;
        if (eq_s_b("heid")) {
            this.bra = this.cursor;
            if (r_R2()) {
                int i11 = this.limit - this.cursor;
                if (!eq_s_b("c")) {
                    this.cursor = this.limit - i11;
                    slice_del();
                    this.ket = this.cursor;
                    if (eq_s_b("en")) {
                        this.bra = this.cursor;
                        r_en_ending();
                    }
                }
            }
        }
        int i12 = this.limit;
        int i13 = i12 - i10;
        this.cursor = i13;
        int i14 = i12 - i13;
        this.ket = i13;
        int iFind_among_b2 = find_among_b(a_4);
        if (iFind_among_b2 != 0) {
            this.bra = this.cursor;
            if (iFind_among_b2 != 1) {
                if (iFind_among_b2 != 2) {
                    if (iFind_among_b2 != 3) {
                        if (iFind_among_b2 != 4) {
                            if (iFind_among_b2 == 5 && r_R2() && this.B_e_found) {
                                slice_del();
                            }
                        } else if (r_R2()) {
                            slice_del();
                        }
                    } else if (r_R2()) {
                        slice_del();
                        r_e_ending();
                    }
                } else if (r_R2()) {
                    int i15 = this.limit - this.cursor;
                    if (!eq_s_b("e")) {
                        this.cursor = this.limit - i15;
                        slice_del();
                    }
                }
            } else if (r_R2()) {
                slice_del();
                int i16 = this.limit;
                int i17 = this.cursor;
                int i18 = i16 - i17;
                this.ket = i17;
                if (eq_s_b("ig")) {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        int i19 = this.limit - this.cursor;
                        if (!eq_s_b("e")) {
                            this.cursor = this.limit - i19;
                            slice_del();
                        }
                    }
                } else {
                    this.cursor = this.limit - i18;
                    r_undouble();
                }
            }
        }
        int i20 = this.limit;
        int i21 = i20 - i14;
        this.cursor = i21;
        int i22 = i20 - i21;
        if (out_grouping_b(g_v_I, 73, JPEG.APP8)) {
            int i23 = this.limit - this.cursor;
            if (find_among_b(a_5) != 0 && out_grouping_b(g_v, 97, JPEG.APP8)) {
                int i24 = this.limit - i23;
                this.cursor = i24;
                this.ket = i24;
                if (i24 > this.limit_backward) {
                    int i25 = i24 - 1;
                    this.cursor = i25;
                    this.bra = i25;
                    slice_del();
                }
            }
        }
        this.cursor = this.limit - i22;
        return true;
    }

    private boolean r_undouble() {
        int i = this.limit - this.cursor;
        if (find_among_b(a_2) == 0) {
            return false;
        }
        int i2 = this.limit - i;
        this.cursor = i2;
        this.ket = i2;
        if (i2 <= this.limit_backward) {
            return false;
        }
        int i4 = i2 - 1;
        this.cursor = i4;
        this.bra = i4;
        slice_del();
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof dutchStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 2047761535;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        r_prelude();
        this.cursor = i;
        r_mark_regions();
        this.limit_backward = i;
        this.cursor = this.limit;
        r_standard_suffix();
        int i2 = this.limit_backward;
        this.cursor = i2;
        r_postlude();
        this.cursor = i2;
        return true;
    }
}
