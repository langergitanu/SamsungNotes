package opennlp.tools.stemmer.snowball;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class finnishStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("pa", -1, 1), new Among("sti", -1, 2), new Among("kaan", -1, 1), new Among("han", -1, 1), new Among("kin", -1, 1), new Among("hän", -1, 1), new Among("kään", -1, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_KO, -1, 1), new Among("pä", -1, 1), new Among("kö", -1, 1)};
    private static final Among[] a_1 = {new Among("lla", -1, -1), new Among("na", -1, -1), new Among("ssa", -1, -1), new Among("ta", -1, -1), new Among("lta", 3, -1), new Among("sta", 3, -1)};
    private static final Among[] a_2 = {new Among("llä", -1, -1), new Among("nä", -1, -1), new Among("ssä", -1, -1), new Among("tä", -1, -1), new Among("ltä", 3, -1), new Among("stä", 3, -1)};
    private static final Among[] a_3 = {new Among("lle", -1, -1), new Among("ine", -1, -1)};
    private static final Among[] a_4 = {new Among("nsa", -1, 3), new Among("mme", -1, 3), new Among("nne", -1, 3), new Among("ni", -1, 2), new Among("si", -1, 1), new Among("an", -1, 4), new Among("en", -1, 6), new Among("än", -1, 5), new Among("nsä", -1, 3)};
    private static final Among[] a_5 = {new Among("aa", -1, -1), new Among("ee", -1, -1), new Among("ii", -1, -1), new Among("oo", -1, -1), new Among("uu", -1, -1), new Among("ää", -1, -1), new Among("öö", -1, -1)};
    private static final Among[] a_6 = {new Among("a", -1, 8), new Among("lla", 0, -1), new Among("na", 0, -1), new Among("ssa", 0, -1), new Among("ta", 0, -1), new Among("lta", 4, -1), new Among("sta", 4, -1), new Among("tta", 4, 2), new Among("lle", -1, -1), new Among("ine", -1, -1), new Among("ksi", -1, -1), new Among("n", -1, 7), new Among("han", 11, 1), new Among("den", 11, -1, "r_VI", finnishStemmer.class), new Among("seen", 11, -1, "r_LONG", finnishStemmer.class), new Among("hen", 11, 2), new Among("tten", 11, -1, "r_VI", finnishStemmer.class), new Among("hin", 11, 3), new Among("siin", 11, -1, "r_VI", finnishStemmer.class), new Among("hon", 11, 4), new Among("hän", 11, 5), new Among("hön", 11, 6), new Among("ä", -1, 8), new Among("llä", 22, -1), new Among("nä", 22, -1), new Among("ssä", 22, -1), new Among("tä", 22, -1), new Among("ltä", 26, -1), new Among("stä", 26, -1), new Among("ttä", 26, 2)};
    private static final Among[] a_7 = {new Among("eja", -1, -1), new Among("mma", -1, 1), new Among("imma", 1, -1), new Among("mpa", -1, 1), new Among("impa", 3, -1), new Among("mmi", -1, 1), new Among("immi", 5, -1), new Among("mpi", -1, 1), new Among("impi", 7, -1), new Among("ejä", -1, -1), new Among("mmä", -1, 1), new Among("immä", 10, -1), new Among("mpä", -1, 1), new Among("impä", 12, -1)};
    private static final Among[] a_8 = {new Among("i", -1, -1), new Among("j", -1, -1)};
    private static final Among[] a_9 = {new Among("mma", -1, 1), new Among("imma", 0, -1)};
    private static final char[] g_AEI = {17, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b'};
    private static final char[] g_C = {'w', 223, 'w', 1};
    private static final char[] g_V1 = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b', 0, ' '};
    private static final char[] g_V2 = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b', 0, ' '};
    private static final char[] g_particle_end = {17, 'a', 24, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b', 0, ' '};
    private boolean B_ending_removed;
    private int I_p1;
    private int I_p2;
    private StringBuilder S_x = new StringBuilder();

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_case_ending() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        int iFind_among_b = find_among_b(a_6);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        this.limit_backward = i4;
        switch (iFind_among_b) {
            case 1:
                if (!eq_s_b("a")) {
                    return false;
                }
                break;
            case 2:
                if (!eq_s_b("e")) {
                    return false;
                }
                break;
            case 3:
                if (!eq_s_b("i")) {
                    return false;
                }
                break;
            case 4:
                if (!eq_s_b("o")) {
                    return false;
                }
                break;
            case 5:
                if (!eq_s_b("ä")) {
                    return false;
                }
                break;
            case 6:
                if (!eq_s_b("ö")) {
                    return false;
                }
                break;
            case 7:
                int i6 = this.limit;
                int i7 = i6 - i5;
                int i8 = i6 - i5;
                int i9 = i6 - i5;
                if (!r_LONG()) {
                    this.cursor = this.limit - i9;
                    if (!eq_s_b("ie")) {
                        this.cursor = this.limit - i7;
                    } else {
                        int i10 = this.limit;
                        int i11 = i10 - i8;
                        this.cursor = i11;
                        if (i11 > this.limit_backward) {
                            int i12 = i11 - 1;
                            this.cursor = i12;
                            this.bra = i12;
                        } else {
                            this.cursor = i10 - i7;
                        }
                    }
                    break;
                }
                break;
            case 8:
                if (!in_grouping_b(g_V1, 97, 246) || !in_grouping_b(g_C, 98, 122)) {
                    return false;
                }
                break;
        }
        slice_del();
        this.B_ending_removed = true;
        return true;
    }

    private boolean r_i_plural() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (find_among_b(a_8) == 0) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        this.limit_backward = i4;
        slice_del();
        return true;
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_p1 = i;
        this.I_p2 = i;
        while (true) {
            int i2 = this.cursor;
            if (in_grouping(g_V1, 97, 246)) {
                this.cursor = i2;
                while (!out_grouping(g_V1, 97, 246)) {
                    int i4 = this.cursor;
                    if (i4 >= this.limit) {
                        return false;
                    }
                    this.cursor = i4 + 1;
                }
                this.I_p1 = this.cursor;
                while (true) {
                    int i5 = this.cursor;
                    if (in_grouping(g_V1, 97, 246)) {
                        this.cursor = i5;
                        while (!out_grouping(g_V1, 97, 246)) {
                            int i6 = this.cursor;
                            if (i6 >= this.limit) {
                                return false;
                            }
                            this.cursor = i6 + 1;
                        }
                        this.I_p2 = this.cursor;
                        return true;
                    }
                    this.cursor = i5;
                    if (i5 >= this.limit) {
                        return false;
                    }
                    this.cursor = i5 + 1;
                }
            } else {
                this.cursor = i2;
                if (i2 >= this.limit) {
                    return false;
                }
                this.cursor = i2 + 1;
            }
        }
    }

    private boolean r_other_endings() {
        int i = this.cursor;
        int i2 = this.I_p2;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        int iFind_among_b = find_among_b(a_7);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            int i6 = this.limit - i5;
            if (eq_s_b("po")) {
                return false;
            }
            this.cursor = this.limit - i6;
        }
        slice_del();
        return true;
    }

    private boolean r_particle_etc() {
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
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2 && !r_R2()) {
                return false;
            }
        } else if (!in_grouping_b(g_particle_end, 97, 246)) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_possessive() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        this.limit_backward = i4;
        switch (iFind_among_b) {
            case 1:
                int i6 = this.limit - i5;
                if (!eq_s_b("k")) {
                    this.cursor = this.limit - i6;
                    slice_del();
                }
                break;
            case 2:
                slice_del();
                this.ket = this.cursor;
                if (eq_s_b("kse")) {
                    this.bra = this.cursor;
                    slice_from("ksi");
                    break;
                }
                break;
            case 3:
                slice_del();
                break;
            case 4:
                if (find_among_b(a_1) != 0) {
                    slice_del();
                    break;
                }
                break;
            case 5:
                if (find_among_b(a_2) != 0) {
                    slice_del();
                    break;
                }
                break;
            case 6:
                if (find_among_b(a_3) != 0) {
                    slice_del();
                    break;
                }
                break;
        }
        return false;
    }

    private boolean r_t_plural() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (!eq_s_b("t")) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        int i6 = this.limit - i5;
        if (!in_grouping_b(g_V1, 97, 246)) {
            this.limit_backward = i4;
            return false;
        }
        this.cursor = this.limit - i6;
        slice_del();
        this.limit_backward = i4;
        int i7 = this.cursor;
        int i8 = this.I_p2;
        if (i7 < i8) {
            return false;
        }
        this.limit_backward = i8;
        this.ket = i7;
        int iFind_among_b = find_among_b(a_9);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i9 = this.cursor;
        this.bra = i9;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            int i10 = this.limit - i9;
            if (eq_s_b("po")) {
                return false;
            }
            this.cursor = this.limit - i10;
        }
        slice_del();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_tidy() {
        int i = this.cursor;
        int i2 = this.I_p1;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        int i5 = this.limit;
        int i6 = i5 - i;
        int i7 = i5 - i;
        if (r_LONG()) {
            int i8 = this.limit - i7;
            this.cursor = i8;
            this.ket = i8;
            if (i8 > this.limit_backward) {
                int i9 = i8 - 1;
                this.cursor = i9;
                this.bra = i9;
                slice_del();
            }
        }
        int i10 = this.limit;
        int i11 = i10 - i6;
        this.cursor = i11;
        int i12 = i10 - i11;
        this.ket = i11;
        if (in_grouping_b(g_AEI, 97, JPEG.APP4)) {
            this.bra = this.cursor;
            if (in_grouping_b(g_C, 98, 122)) {
                slice_del();
            }
        }
        int i13 = this.limit;
        int i14 = i13 - i12;
        this.cursor = i14;
        int i15 = i13 - i14;
        this.ket = i14;
        if (eq_s_b("j")) {
            int i16 = this.cursor;
            this.bra = i16;
            int i17 = this.limit - i16;
            if (!eq_s_b("o")) {
                this.cursor = this.limit - i17;
                if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                    slice_del();
                }
            }
        }
        int i18 = this.limit;
        int i19 = i18 - i15;
        this.cursor = i19;
        int i20 = i18 - i19;
        this.ket = i19;
        if (eq_s_b("o")) {
            this.bra = this.cursor;
            if (eq_s_b("j")) {
                slice_del();
            }
        }
        this.cursor = this.limit - i20;
        this.limit_backward = i4;
        while (true) {
            int i21 = this.limit - this.cursor;
            if (out_grouping_b(g_V1, 97, 246)) {
                int i22 = this.limit - i21;
                this.cursor = i22;
                this.ket = i22;
                if (!in_grouping_b(g_C, 98, 122)) {
                    return false;
                }
                this.bra = this.cursor;
                slice_to(this.S_x);
                if (!eq_s_b(this.S_x)) {
                    return false;
                }
                slice_del();
                return true;
            }
            int i23 = this.limit - i21;
            this.cursor = i23;
            if (i23 <= this.limit_backward) {
                return false;
            }
            this.cursor = i23 - 1;
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof finnishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -288873108;
    }

    public boolean r_LONG() {
        return find_among_b(a_5) != 0;
    }

    public boolean r_VI() {
        return eq_s_b("i") && in_grouping_b(g_V2, 97, 246);
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        r_mark_regions();
        this.B_ending_removed = false;
        this.limit_backward = i;
        this.cursor = this.limit;
        r_particle_etc();
        this.cursor = this.limit;
        r_possessive();
        this.cursor = this.limit;
        r_case_ending();
        this.cursor = this.limit;
        r_other_endings();
        this.cursor = this.limit;
        if (this.B_ending_removed) {
            r_i_plural();
            this.cursor = this.limit;
        } else {
            r_t_plural();
            this.cursor = this.limit;
        }
        r_tidy();
        this.cursor = this.limit_backward;
        return true;
    }
}
