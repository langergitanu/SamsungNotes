package opennlp.tools.stemmer.snowball;

import androidx.core.text.util.LocalePreferences;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class turkishStemmer extends AbstractSnowballStemmer {
    private boolean B_continue_stemming_noun_suffixes;
    private static final Among[] a_0 = {new Among("m", -1, -1), new Among("n", -1, -1), new Among("miz", -1, -1), new Among("niz", -1, -1), new Among("muz", -1, -1), new Among("nuz", -1, -1), new Among("müz", -1, -1), new Among("nüz", -1, -1), new Among("mız", -1, -1), new Among("nız", -1, -1)};
    private static final Among[] a_1 = {new Among("leri", -1, -1), new Among("ları", -1, -1)};
    private static final Among[] a_2 = {new Among("ni", -1, -1), new Among("nu", -1, -1), new Among("nü", -1, -1), new Among("nı", -1, -1)};
    private static final Among[] a_3 = {new Among("in", -1, -1), new Among("un", -1, -1), new Among("ün", -1, -1), new Among("ın", -1, -1)};
    private static final Among[] a_4 = {new Among("a", -1, -1), new Among("e", -1, -1)};
    private static final Among[] a_5 = {new Among("na", -1, -1), new Among("ne", -1, -1)};
    private static final Among[] a_6 = {new Among("da", -1, -1), new Among("ta", -1, -1), new Among(LangPackConfigConstants.LANGUAGE_CODE_DE, -1, -1), new Among("te", -1, -1)};
    private static final Among[] a_7 = {new Among("nda", -1, -1), new Among("nde", -1, -1)};
    private static final Among[] a_8 = {new Among("dan", -1, -1), new Among(VElementFormulasCmd.FTAN, -1, -1), new Among("den", -1, -1), new Among("ten", -1, -1)};
    private static final Among[] a_9 = {new Among("ndan", -1, -1), new Among("nden", -1, -1)};
    private static final Among[] a_10 = {new Among("la", -1, -1), new Among("le", -1, -1)};
    private static final Among[] a_11 = {new Among("ca", -1, -1), new Among("ce", -1, -1)};
    private static final Among[] a_12 = {new Among("im", -1, -1), new Among("um", -1, -1), new Among("üm", -1, -1), new Among("ım", -1, -1)};
    private static final Among[] a_13 = {new Among(VElementFormulasCmd.FSIN, -1, -1), new Among(LocalePreferences.FirstDayOfWeek.SUNDAY, -1, -1), new Among("sün", -1, -1), new Among("sın", -1, -1)};
    private static final Among[] a_14 = {new Among("iz", -1, -1), new Among("uz", -1, -1), new Among("üz", -1, -1), new Among("ız", -1, -1)};
    private static final Among[] a_15 = {new Among("siniz", -1, -1), new Among("sunuz", -1, -1), new Among("sünüz", -1, -1), new Among("sınız", -1, -1)};
    private static final Among[] a_16 = {new Among("lar", -1, -1), new Among("ler", -1, -1)};
    private static final Among[] a_17 = {new Among("niz", -1, -1), new Among("nuz", -1, -1), new Among("nüz", -1, -1), new Among("nız", -1, -1)};
    private static final Among[] a_18 = {new Among("dir", -1, -1), new Among("tir", -1, -1), new Among("dur", -1, -1), new Among("tur", -1, -1), new Among("dür", -1, -1), new Among("tür", -1, -1), new Among("dır", -1, -1), new Among("tır", -1, -1)};
    private static final Among[] a_19 = {new Among("casına", -1, -1), new Among("cesine", -1, -1)};
    private static final Among[] a_20 = {new Among("di", -1, -1), new Among("ti", -1, -1), new Among("dik", -1, -1), new Among("tik", -1, -1), new Among("duk", -1, -1), new Among("tuk", -1, -1), new Among("dük", -1, -1), new Among("tük", -1, -1), new Among("dık", -1, -1), new Among("tık", -1, -1), new Among("dim", -1, -1), new Among("tim", -1, -1), new Among("dum", -1, -1), new Among("tum", -1, -1), new Among("düm", -1, -1), new Among("tüm", -1, -1), new Among("dım", -1, -1), new Among("tım", -1, -1), new Among("din", -1, -1), new Among("tin", -1, -1), new Among("dun", -1, -1), new Among("tun", -1, -1), new Among("dün", -1, -1), new Among("tün", -1, -1), new Among("dın", -1, -1), new Among("tın", -1, -1), new Among("du", -1, -1), new Among("tu", -1, -1), new Among("dü", -1, -1), new Among("tü", -1, -1), new Among("dı", -1, -1), new Among("tı", -1, -1)};
    private static final Among[] a_21 = {new Among("sa", -1, -1), new Among("se", -1, -1), new Among("sak", -1, -1), new Among("sek", -1, -1), new Among("sam", -1, -1), new Among("sem", -1, -1), new Among("san", -1, -1), new Among("sen", -1, -1)};
    private static final Among[] a_22 = {new Among("miş", -1, -1), new Among("muş", -1, -1), new Among("müş", -1, -1), new Among("mış", -1, -1)};
    private static final Among[] a_23 = {new Among("b", -1, 1), new Among("c", -1, 2), new Among("d", -1, 3), new Among("ğ", -1, 4)};
    private static final char[] g_vowel = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', '\b', 0, 0, 0, 0, 0, 0, 1};
    private static final char[] g_U = {1, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b', 0, 0, 0, 0, 0, 0, 1};
    private static final char[] g_vowel1 = {1, '@', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final char[] g_vowel2 = {17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 130};
    private static final char[] g_vowel3 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private static final char[] g_vowel4 = {17};
    private static final char[] g_vowel5 = {'A'};
    private static final char[] g_vowel6 = {'A'};

    private boolean r_append_U_to_stems_ending_with_d_or_g() {
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        int i2 = this.limit - i;
        if (!eq_s_b("d")) {
            this.cursor = this.limit - i2;
            if (!eq_s_b("g")) {
                return false;
            }
        }
        while (true) {
            int i4 = this.limit - this.cursor;
            if (in_grouping_b(g_vowel, 97, 305)) {
                int i5 = this.limit;
                int i6 = i5 - i4;
                this.cursor = i6;
                int i7 = i5 - i6;
                int i8 = i5 - i6;
                if (!eq_s_b("a")) {
                    this.cursor = this.limit - i8;
                    if (!eq_s_b("ı")) {
                        int i9 = this.limit;
                        int i10 = i9 - i7;
                        this.cursor = i10;
                        int i11 = i9 - i10;
                        if (!eq_s_b("e")) {
                            this.cursor = this.limit - i11;
                            if (!eq_s_b("i")) {
                                int i12 = this.limit;
                                int i13 = i12 - i7;
                                this.cursor = i13;
                                int i14 = i12 - i13;
                                if (!eq_s_b("o")) {
                                    this.cursor = this.limit - i14;
                                    if (!eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                                        int i15 = this.limit;
                                        int i16 = i15 - i7;
                                        this.cursor = i16;
                                        int i17 = i15 - i16;
                                        if (!eq_s_b("ö")) {
                                            this.cursor = this.limit - i17;
                                            if (!eq_s_b("ü")) {
                                                return false;
                                            }
                                        }
                                        slice_from("ü");
                                        return true;
                                    }
                                }
                                slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                                return true;
                            }
                        }
                        slice_from("i");
                        return true;
                    }
                }
                slice_from("ı");
                return true;
            }
            int i18 = this.limit - i4;
            this.cursor = i18;
            if (i18 <= this.limit_backward) {
                return false;
            }
            this.cursor = i18 - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[LOOP:2: B:19:0x005e->B:78:0x019a, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[EDGE_INSN: B:89:0x0074->B:23:0x0074 BREAK  A[LOOP:2: B:19:0x005e->B:78:0x019a]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[LOOP:3: B:26:0x0082->B:76:0x018e, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[EDGE_INSN: B:91:0x0098->B:30:0x0098 BREAK  A[LOOP:3: B:26:0x0082->B:76:0x018e]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6 A[LOOP:4: B:33:0x00a6->B:74:0x0182, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be A[EDGE_INSN: B:93:0x00be->B:37:0x00be BREAK  A[LOOP:4: B:33:0x00a6->B:74:0x0182]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0 A[LOOP:5: B:40:0x00d0->B:72:0x0176, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6 A[EDGE_INSN: B:95:0x00e6->B:44:0x00e6 BREAK  A[LOOP:5: B:40:0x00d0->B:72:0x0176]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[LOOP:6: B:47:0x00f6->B:70:0x016b, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010c A[EDGE_INSN: B:97:0x010c->B:51:0x010c BREAK  A[LOOP:6: B:47:0x00f6->B:70:0x016b]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011a A[LOOP:7: B:54:0x011a->B:68:0x0160, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0130 A[EDGE_INSN: B:99:0x0130->B:58:0x0130 BREAK  A[LOOP:7: B:54:0x011a->B:68:0x0160]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e A[LOOP:8: B:61:0x013e->B:66:0x0155, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_check_vowel_harmony() {
        int i = this.limit - this.cursor;
        while (true) {
            int i2 = this.limit - this.cursor;
            if (in_grouping_b(g_vowel, 97, 305)) {
                int i4 = this.limit;
                int i5 = i4 - i2;
                this.cursor = i5;
                int i6 = i4 - i5;
                if (eq_s_b("a")) {
                    while (true) {
                        int i7 = this.limit - this.cursor;
                        if (in_grouping_b(g_vowel1, 97, 305)) {
                            this.cursor = this.limit - i7;
                            break;
                        }
                        int i8 = this.limit - i7;
                        this.cursor = i8;
                        if (i8 <= this.limit_backward) {
                            break;
                        }
                        this.cursor = i8 - 1;
                    }
                    this.cursor = this.limit - i6;
                    if (eq_s_b("e")) {
                    }
                } else {
                    this.cursor = this.limit - i6;
                    if (eq_s_b("e")) {
                        this.cursor = this.limit - i6;
                        if (eq_s_b("ı")) {
                            this.cursor = this.limit - i6;
                            if (eq_s_b("i")) {
                                this.cursor = this.limit - i6;
                                if (eq_s_b("o")) {
                                    this.cursor = this.limit - i6;
                                    if (eq_s_b("ö")) {
                                        this.cursor = this.limit - i6;
                                        if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                                            this.cursor = this.limit - i6;
                                            if (!eq_s_b("ü")) {
                                                while (true) {
                                                    int i9 = this.limit - this.cursor;
                                                    if (in_grouping_b(g_vowel6, 246, 252)) {
                                                        this.cursor = this.limit - i9;
                                                        break;
                                                    }
                                                    int i10 = this.limit - i9;
                                                    this.cursor = i10;
                                                    if (i10 <= this.limit_backward) {
                                                        return false;
                                                    }
                                                    this.cursor = i10 - 1;
                                                }
                                            } else {
                                                return false;
                                            }
                                        } else {
                                            while (true) {
                                                int i11 = this.limit - this.cursor;
                                                if (in_grouping_b(g_vowel5, 111, 117)) {
                                                    this.cursor = this.limit - i11;
                                                    break;
                                                }
                                                int i12 = this.limit - i11;
                                                this.cursor = i12;
                                                if (i12 <= this.limit_backward) {
                                                    break;
                                                }
                                                this.cursor = i12 - 1;
                                            }
                                            this.cursor = this.limit - i6;
                                            if (!eq_s_b("ü")) {
                                            }
                                        }
                                    } else {
                                        while (true) {
                                            int i13 = this.limit - this.cursor;
                                            if (in_grouping_b(g_vowel6, 246, 252)) {
                                                this.cursor = this.limit - i13;
                                                break;
                                            }
                                            int i14 = this.limit - i13;
                                            this.cursor = i14;
                                            if (i14 <= this.limit_backward) {
                                                break;
                                            }
                                            this.cursor = i14 - 1;
                                        }
                                        this.cursor = this.limit - i6;
                                        if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                                        }
                                    }
                                } else {
                                    while (true) {
                                        int i15 = this.limit - this.cursor;
                                        if (in_grouping_b(g_vowel5, 111, 117)) {
                                            this.cursor = this.limit - i15;
                                            break;
                                        }
                                        int i16 = this.limit - i15;
                                        this.cursor = i16;
                                        if (i16 <= this.limit_backward) {
                                            break;
                                        }
                                        this.cursor = i16 - 1;
                                    }
                                    this.cursor = this.limit - i6;
                                    if (eq_s_b("ö")) {
                                    }
                                }
                            } else {
                                while (true) {
                                    int i17 = this.limit - this.cursor;
                                    if (in_grouping_b(g_vowel4, 101, 105)) {
                                        this.cursor = this.limit - i17;
                                        break;
                                    }
                                    int i18 = this.limit - i17;
                                    this.cursor = i18;
                                    if (i18 <= this.limit_backward) {
                                        break;
                                    }
                                    this.cursor = i18 - 1;
                                }
                                this.cursor = this.limit - i6;
                                if (eq_s_b("o")) {
                                }
                            }
                        } else {
                            while (true) {
                                int i19 = this.limit - this.cursor;
                                if (in_grouping_b(g_vowel3, 97, 305)) {
                                    this.cursor = this.limit - i19;
                                    break;
                                }
                                int i20 = this.limit - i19;
                                this.cursor = i20;
                                if (i20 <= this.limit_backward) {
                                    break;
                                }
                                this.cursor = i20 - 1;
                            }
                            this.cursor = this.limit - i6;
                            if (eq_s_b("i")) {
                            }
                        }
                    } else {
                        while (true) {
                            int i21 = this.limit - this.cursor;
                            if (in_grouping_b(g_vowel2, 101, 252)) {
                                this.cursor = this.limit - i21;
                                break;
                            }
                            int i22 = this.limit - i21;
                            this.cursor = i22;
                            if (i22 <= this.limit_backward) {
                                break;
                            }
                            this.cursor = i22 - 1;
                        }
                        this.cursor = this.limit - i6;
                        if (eq_s_b("ı")) {
                        }
                    }
                }
                this.cursor = this.limit - i;
                return true;
            }
            int i23 = this.limit - i2;
            this.cursor = i23;
            if (i23 <= this.limit_backward) {
                return false;
            }
            this.cursor = i23 - 1;
        }
    }

    private boolean r_is_reserved_word() {
        if (!eq_s_b("ad")) {
            return false;
        }
        int i = this.limit - this.cursor;
        if (!eq_s_b("soy")) {
            this.cursor = this.limit - i;
        }
        return this.cursor <= this.limit_backward;
    }

    private boolean r_mark_DA() {
        return r_check_vowel_harmony() && find_among_b(a_6) != 0;
    }

    private boolean r_mark_DAn() {
        return r_check_vowel_harmony() && find_among_b(a_8) != 0;
    }

    private boolean r_mark_DUr() {
        return r_check_vowel_harmony() && find_among_b(a_18) != 0;
    }

    private boolean r_mark_cAsInA() {
        return find_among_b(a_19) != 0;
    }

    private boolean r_mark_ki() {
        return eq_s_b("ki");
    }

    private boolean r_mark_lAr() {
        return r_check_vowel_harmony() && find_among_b(a_16) != 0;
    }

    private boolean r_mark_lArI() {
        return find_among_b(a_1) != 0;
    }

    private boolean r_mark_nA() {
        return r_check_vowel_harmony() && find_among_b(a_5) != 0;
    }

    private boolean r_mark_nU() {
        return r_check_vowel_harmony() && find_among_b(a_2) != 0;
    }

    private boolean r_mark_nUn() {
        return r_check_vowel_harmony() && find_among_b(a_3) != 0 && r_mark_suffix_with_optional_n_consonant();
    }

    private boolean r_mark_nUz() {
        return r_check_vowel_harmony() && find_among_b(a_17) != 0;
    }

    private boolean r_mark_ncA() {
        return r_check_vowel_harmony() && find_among_b(a_11) != 0 && r_mark_suffix_with_optional_n_consonant();
    }

    private boolean r_mark_ndA() {
        return r_check_vowel_harmony() && find_among_b(a_7) != 0;
    }

    private boolean r_mark_ndAn() {
        return r_check_vowel_harmony() && find_among_b(a_9) != 0;
    }

    private boolean r_mark_possessives() {
        return find_among_b(a_0) != 0 && r_mark_suffix_with_optional_U_vowel();
    }

    private boolean r_mark_sU() {
        return r_check_vowel_harmony() && in_grouping_b(g_U, 105, 305) && r_mark_suffix_with_optional_s_consonant();
    }

    private boolean r_mark_sUn() {
        return r_check_vowel_harmony() && find_among_b(a_13) != 0;
    }

    private boolean r_mark_sUnUz() {
        return find_among_b(a_15) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_suffix_with_optional_U_vowel() {
        int i = this.limit - this.cursor;
        char[] cArr = g_U;
        if (in_grouping_b(cArr, 105, 305)) {
            int i2 = this.limit - this.cursor;
            if (out_grouping_b(g_vowel, 97, 305)) {
                this.cursor = this.limit - i2;
            }
        } else {
            int i4 = this.limit;
            int i5 = i4 - i;
            this.cursor = i5;
            int i6 = i4 - i5;
            int i7 = i4 - i5;
            if (in_grouping_b(cArr, 105, 305)) {
                this.cursor = this.limit - i7;
                return false;
            }
            int i8 = this.limit;
            int i9 = i8 - i6;
            this.cursor = i9;
            int i10 = i8 - i9;
            if (i9 <= this.limit_backward) {
                return false;
            }
            this.cursor = i9 - 1;
            if (!out_grouping_b(g_vowel, 97, 305)) {
                return false;
            }
            this.cursor = this.limit - i10;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_suffix_with_optional_n_consonant() {
        int i = this.limit - this.cursor;
        if (eq_s_b("n")) {
            int i2 = this.limit - this.cursor;
            if (in_grouping_b(g_vowel, 97, 305)) {
                this.cursor = this.limit - i2;
            }
        } else {
            int i4 = this.limit;
            int i5 = i4 - i;
            this.cursor = i5;
            int i6 = i4 - i5;
            int i7 = i4 - i5;
            if (eq_s_b("n")) {
                this.cursor = this.limit - i7;
                return false;
            }
            int i8 = this.limit;
            int i9 = i8 - i6;
            this.cursor = i9;
            int i10 = i8 - i9;
            if (i9 <= this.limit_backward) {
                return false;
            }
            this.cursor = i9 - 1;
            if (!in_grouping_b(g_vowel, 97, 305)) {
                return false;
            }
            this.cursor = this.limit - i10;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_suffix_with_optional_s_consonant() {
        int i = this.limit - this.cursor;
        if (eq_s_b("s")) {
            int i2 = this.limit - this.cursor;
            if (in_grouping_b(g_vowel, 97, 305)) {
                this.cursor = this.limit - i2;
            }
        } else {
            int i4 = this.limit;
            int i5 = i4 - i;
            this.cursor = i5;
            int i6 = i4 - i5;
            int i7 = i4 - i5;
            if (eq_s_b("s")) {
                this.cursor = this.limit - i7;
                return false;
            }
            int i8 = this.limit;
            int i9 = i8 - i6;
            this.cursor = i9;
            int i10 = i8 - i9;
            if (i9 <= this.limit_backward) {
                return false;
            }
            this.cursor = i9 - 1;
            if (!in_grouping_b(g_vowel, 97, 305)) {
                return false;
            }
            this.cursor = this.limit - i10;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_suffix_with_optional_y_consonant() {
        int i = this.limit - this.cursor;
        if (eq_s_b("y")) {
            int i2 = this.limit - this.cursor;
            if (in_grouping_b(g_vowel, 97, 305)) {
                this.cursor = this.limit - i2;
            }
        } else {
            int i4 = this.limit;
            int i5 = i4 - i;
            this.cursor = i5;
            int i6 = i4 - i5;
            int i7 = i4 - i5;
            if (eq_s_b("y")) {
                this.cursor = this.limit - i7;
                return false;
            }
            int i8 = this.limit;
            int i9 = i8 - i6;
            this.cursor = i9;
            int i10 = i8 - i9;
            if (i9 <= this.limit_backward) {
                return false;
            }
            this.cursor = i9 - 1;
            if (!in_grouping_b(g_vowel, 97, 305)) {
                return false;
            }
            this.cursor = this.limit - i10;
        }
        return true;
    }

    private boolean r_mark_yA() {
        return r_check_vowel_harmony() && find_among_b(a_4) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_yDU() {
        return r_check_vowel_harmony() && find_among_b(a_20) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_yU() {
        return r_check_vowel_harmony() && in_grouping_b(g_U, 105, 305) && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_yUm() {
        return r_check_vowel_harmony() && find_among_b(a_12) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_yUz() {
        return r_check_vowel_harmony() && find_among_b(a_14) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_yken() {
        return eq_s_b("ken") && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_ylA() {
        return r_check_vowel_harmony() && find_among_b(a_10) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_ymUs_() {
        return r_check_vowel_harmony() && find_among_b(a_22) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_mark_ysA() {
        return find_among_b(a_21) != 0 && r_mark_suffix_with_optional_y_consonant();
    }

    private boolean r_more_than_one_syllable_word() {
        int i = this.cursor;
        for (int i2 = 2; i2 > 0; i2--) {
            while (!in_grouping(g_vowel, 97, 305)) {
                int i4 = this.cursor;
                if (i4 >= this.limit) {
                    return false;
                }
                this.cursor = i4 + 1;
            }
        }
        this.cursor = i;
        return true;
    }

    private boolean r_post_process_last_consonants() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_23);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b == 1) {
            slice_from("p");
        } else if (iFind_among_b == 2) {
            slice_from("ç");
        } else if (iFind_among_b == 3) {
            slice_from("t");
        } else if (iFind_among_b == 4) {
            slice_from("k");
        }
        return true;
    }

    private boolean r_postlude() {
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        if (r_is_reserved_word()) {
            return false;
        }
        this.cursor = this.limit;
        r_append_U_to_stems_ending_with_d_or_g();
        this.cursor = this.limit;
        r_post_process_last_consonants();
        this.cursor = this.limit_backward;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_stem_nominal_verb_suffixes() {
        int i = this.cursor;
        this.ket = i;
        this.B_continue_stemming_noun_suffixes = true;
        int i2 = this.limit;
        int i4 = i2 - i;
        int i5 = i2 - i;
        if (!r_mark_ymUs_()) {
            this.cursor = this.limit - i5;
            if (!r_mark_yDU()) {
                this.cursor = this.limit - i5;
                if (!r_mark_ysA()) {
                    this.cursor = this.limit - i5;
                    if (!r_mark_yken()) {
                        this.cursor = this.limit - i4;
                        if (r_mark_cAsInA()) {
                            int i6 = this.limit - this.cursor;
                            if (!r_mark_sUnUz()) {
                                this.cursor = this.limit - i6;
                                if (!r_mark_lAr()) {
                                    this.cursor = this.limit - i6;
                                    if (!r_mark_yUm()) {
                                        this.cursor = this.limit - i6;
                                        if (!r_mark_sUn()) {
                                            this.cursor = this.limit - i6;
                                            if (!r_mark_yUz()) {
                                                this.cursor = this.limit - i6;
                                            }
                                        }
                                    }
                                }
                            }
                            if (!r_mark_ymUs_()) {
                            }
                        } else {
                            this.cursor = this.limit - i4;
                            if (r_mark_lAr()) {
                                this.bra = this.cursor;
                                slice_del();
                                int i7 = this.limit;
                                int i8 = this.cursor;
                                int i9 = i7 - i8;
                                this.ket = i8;
                                int i10 = i7 - i8;
                                if (!r_mark_DUr()) {
                                    this.cursor = this.limit - i10;
                                    if (!r_mark_yDU()) {
                                        this.cursor = this.limit - i10;
                                        if (!r_mark_ysA()) {
                                            this.cursor = this.limit - i10;
                                            if (!r_mark_ymUs_()) {
                                                this.cursor = this.limit - i9;
                                            }
                                        }
                                    }
                                }
                                this.B_continue_stemming_noun_suffixes = false;
                            } else {
                                this.cursor = this.limit - i4;
                                if (r_mark_nUz()) {
                                    int i11 = this.limit - this.cursor;
                                    if (!r_mark_yDU()) {
                                        this.cursor = this.limit - i11;
                                        if (!r_mark_ysA()) {
                                        }
                                    }
                                } else {
                                    int i12 = this.limit;
                                    int i13 = i12 - i4;
                                    this.cursor = i13;
                                    int i14 = i12 - i13;
                                    if (!r_mark_sUnUz()) {
                                        this.cursor = this.limit - i14;
                                        if (!r_mark_yUz()) {
                                            this.cursor = this.limit - i14;
                                            if (!r_mark_sUn()) {
                                                this.cursor = this.limit - i14;
                                                if (r_mark_yUm()) {
                                                    this.bra = this.cursor;
                                                    slice_del();
                                                    int i15 = this.limit;
                                                    int i16 = this.cursor;
                                                    int i17 = i15 - i16;
                                                    this.ket = i16;
                                                    if (!r_mark_ymUs_()) {
                                                        this.cursor = this.limit - i17;
                                                    }
                                                } else {
                                                    this.cursor = this.limit - i4;
                                                    if (!r_mark_DUr()) {
                                                        return false;
                                                    }
                                                    this.bra = this.cursor;
                                                    slice_del();
                                                    int i18 = this.limit;
                                                    int i19 = this.cursor;
                                                    int i20 = i18 - i19;
                                                    this.ket = i19;
                                                    int i21 = i18 - i19;
                                                    if (!r_mark_sUnUz()) {
                                                        this.cursor = this.limit - i21;
                                                        if (!r_mark_lAr()) {
                                                            this.cursor = this.limit - i21;
                                                            if (!r_mark_yUm()) {
                                                                this.cursor = this.limit - i21;
                                                                if (!r_mark_sUn()) {
                                                                    this.cursor = this.limit - i21;
                                                                    if (!r_mark_yUz()) {
                                                                        this.cursor = this.limit - i21;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (!r_mark_ymUs_()) {
                                                        this.cursor = this.limit - i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_stem_noun_suffixes() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (r_mark_lAr()) {
            this.bra = this.cursor;
            slice_del();
            int i5 = this.limit - this.cursor;
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
            this.cursor = this.limit - i5;
            return true;
        }
        int i6 = this.limit - i4;
        this.cursor = i6;
        this.ket = i6;
        if (r_mark_ncA()) {
            this.bra = this.cursor;
            slice_del();
            int i7 = this.limit;
            int i8 = this.cursor;
            int i9 = i7 - i8;
            int i10 = i7 - i8;
            this.ket = i8;
            if (r_mark_lArI()) {
                this.bra = this.cursor;
                slice_del();
                return true;
            }
            int i11 = this.limit;
            int i12 = i11 - i10;
            this.cursor = i12;
            this.ket = i12;
            int i13 = i11 - i12;
            if (!r_mark_possessives()) {
                this.cursor = this.limit - i13;
                if (!r_mark_sU()) {
                    int i14 = this.limit - i10;
                    this.cursor = i14;
                    this.ket = i14;
                    if (!r_mark_lAr()) {
                        this.cursor = this.limit - i9;
                        return true;
                    }
                    this.bra = this.cursor;
                    slice_del();
                    if (r_stem_suffix_chain_before_ki()) {
                        return true;
                    }
                    this.cursor = this.limit - i9;
                    return true;
                }
            }
            this.bra = this.cursor;
            slice_del();
            int i15 = this.limit;
            int i16 = this.cursor;
            int i17 = i15 - i16;
            this.ket = i16;
            if (!r_mark_lAr()) {
                this.cursor = this.limit - i17;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
            this.cursor = this.limit - i17;
            return true;
        }
        int i18 = this.limit;
        int i19 = i18 - i4;
        this.cursor = i19;
        this.ket = i19;
        int i20 = i18 - i19;
        if (!r_mark_ndA()) {
            this.cursor = this.limit - i20;
            if (r_mark_nA()) {
                int i21 = this.limit - this.cursor;
                if (r_mark_lArI()) {
                    this.bra = this.cursor;
                    slice_del();
                    return true;
                }
                this.cursor = this.limit - i21;
                if (r_mark_sU()) {
                    this.bra = this.cursor;
                    slice_del();
                    int i22 = this.limit;
                    int i23 = this.cursor;
                    int i24 = i22 - i23;
                    this.ket = i23;
                    if (!r_mark_lAr()) {
                        this.cursor = this.limit - i24;
                        return true;
                    }
                    this.bra = this.cursor;
                    slice_del();
                    if (r_stem_suffix_chain_before_ki()) {
                        return true;
                    }
                    this.cursor = this.limit - i24;
                    return true;
                }
                this.cursor = this.limit - i21;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
            }
        }
        int i25 = this.limit;
        int i26 = i25 - i4;
        this.cursor = i26;
        this.ket = i26;
        int i27 = i25 - i26;
        if (!r_mark_ndAn()) {
            this.cursor = this.limit - i27;
            if (r_mark_nU()) {
                int i28 = this.limit - this.cursor;
                if (r_mark_sU()) {
                    this.bra = this.cursor;
                    slice_del();
                    int i29 = this.limit;
                    int i30 = this.cursor;
                    int i31 = i29 - i30;
                    this.ket = i30;
                    if (!r_mark_lAr()) {
                        this.cursor = this.limit - i31;
                        return true;
                    }
                    this.bra = this.cursor;
                    slice_del();
                    if (r_stem_suffix_chain_before_ki()) {
                        return true;
                    }
                    this.cursor = this.limit - i31;
                    return true;
                }
                this.cursor = this.limit - i28;
                if (r_mark_lArI()) {
                    return true;
                }
            }
        }
        int i32 = this.limit - i4;
        this.cursor = i32;
        this.ket = i32;
        if (r_mark_DAn()) {
            this.bra = this.cursor;
            slice_del();
            int i33 = this.limit;
            int i34 = this.cursor;
            int i35 = i33 - i34;
            this.ket = i34;
            int i36 = i33 - i34;
            if (!r_mark_possessives()) {
                this.cursor = this.limit - i36;
                if (!r_mark_lAr()) {
                    this.cursor = this.limit - i36;
                    if (r_stem_suffix_chain_before_ki()) {
                        return true;
                    }
                    this.cursor = this.limit - i35;
                    return true;
                }
                this.bra = this.cursor;
                slice_del();
                int i37 = this.limit - this.cursor;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                this.cursor = this.limit - i37;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            int i38 = this.limit;
            int i39 = this.cursor;
            int i40 = i38 - i39;
            this.ket = i39;
            if (!r_mark_lAr()) {
                this.cursor = this.limit - i40;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
            this.cursor = this.limit - i40;
            return true;
        }
        int i41 = this.limit;
        int i42 = i41 - i4;
        this.cursor = i42;
        this.ket = i42;
        int i43 = i41 - i42;
        if (!r_mark_nUn()) {
            this.cursor = this.limit - i43;
            if (!r_mark_ylA()) {
                int i44 = this.limit - i4;
                this.cursor = i44;
                this.ket = i44;
                if (r_mark_lArI()) {
                    this.bra = this.cursor;
                    slice_del();
                    return true;
                }
                this.cursor = this.limit - i4;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                int i45 = this.limit;
                int i46 = i45 - i4;
                this.cursor = i46;
                this.ket = i46;
                int i47 = i45 - i46;
                if (!r_mark_DA()) {
                    this.cursor = this.limit - i47;
                    if (!r_mark_yU()) {
                        this.cursor = this.limit - i47;
                        if (!r_mark_yA()) {
                            int i48 = this.limit;
                            int i49 = i48 - i4;
                            this.cursor = i49;
                            this.ket = i49;
                            int i50 = i48 - i49;
                            if (!r_mark_possessives()) {
                                this.cursor = this.limit - i50;
                                if (!r_mark_sU()) {
                                    return false;
                                }
                            }
                            this.bra = this.cursor;
                            slice_del();
                            int i51 = this.limit;
                            int i52 = this.cursor;
                            int i53 = i51 - i52;
                            this.ket = i52;
                            if (!r_mark_lAr()) {
                                this.cursor = this.limit - i53;
                                return true;
                            }
                            this.bra = this.cursor;
                            slice_del();
                            if (r_stem_suffix_chain_before_ki()) {
                                return true;
                            }
                            this.cursor = this.limit - i53;
                            return true;
                        }
                    }
                }
                this.bra = this.cursor;
                slice_del();
                int i54 = this.limit;
                int i55 = this.cursor;
                int i56 = i54 - i55;
                this.ket = i55;
                int i57 = i54 - i55;
                if (r_mark_possessives()) {
                    this.bra = this.cursor;
                    slice_del();
                    int i58 = this.limit;
                    int i59 = this.cursor;
                    int i60 = i58 - i59;
                    this.ket = i59;
                    if (!r_mark_lAr()) {
                        this.cursor = this.limit - i60;
                    }
                } else {
                    this.cursor = this.limit - i57;
                    if (!r_mark_lAr()) {
                        this.cursor = this.limit - i56;
                        return true;
                    }
                }
                this.bra = this.cursor;
                slice_del();
                this.ket = this.cursor;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                this.cursor = this.limit - i56;
                return true;
            }
        }
        this.bra = this.cursor;
        slice_del();
        int i61 = this.limit;
        int i62 = this.cursor;
        int i63 = i61 - i62;
        int i64 = i61 - i62;
        this.ket = i62;
        if (r_mark_lAr()) {
            this.bra = this.cursor;
            slice_del();
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
        }
        int i65 = this.limit;
        int i66 = i65 - i64;
        this.cursor = i66;
        this.ket = i66;
        int i67 = i65 - i66;
        if (!r_mark_possessives()) {
            this.cursor = this.limit - i67;
            if (!r_mark_sU()) {
                this.cursor = this.limit - i64;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                this.cursor = this.limit - i63;
                return true;
            }
        }
        this.bra = this.cursor;
        slice_del();
        int i68 = this.limit;
        int i69 = this.cursor;
        int i70 = i68 - i69;
        this.ket = i69;
        if (!r_mark_lAr()) {
            this.cursor = this.limit - i70;
            return true;
        }
        this.bra = this.cursor;
        slice_del();
        if (r_stem_suffix_chain_before_ki()) {
            return true;
        }
        this.cursor = this.limit - i70;
        return true;
    }

    private boolean r_stem_suffix_chain_before_ki() {
        this.ket = this.cursor;
        if (!r_mark_ki()) {
            return false;
        }
        int i = this.limit - this.cursor;
        if (r_mark_DA()) {
            this.bra = this.cursor;
            slice_del();
            int i2 = this.limit;
            int i4 = this.cursor;
            int i5 = i2 - i4;
            this.ket = i4;
            int i6 = i2 - i4;
            if (r_mark_lAr()) {
                this.bra = this.cursor;
                slice_del();
                int i7 = this.limit - this.cursor;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                this.cursor = this.limit - i7;
                return true;
            }
            this.cursor = this.limit - i6;
            if (!r_mark_possessives()) {
                this.cursor = this.limit - i5;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            int i8 = this.limit;
            int i9 = this.cursor;
            int i10 = i8 - i9;
            this.ket = i9;
            if (!r_mark_lAr()) {
                this.cursor = this.limit - i10;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
            this.cursor = this.limit - i10;
            return true;
        }
        this.cursor = this.limit - i;
        if (!r_mark_nUn()) {
            this.cursor = this.limit - i;
            if (!r_mark_ndA()) {
                return false;
            }
            int i11 = this.limit - this.cursor;
            if (r_mark_lArI()) {
                this.bra = this.cursor;
                slice_del();
                return true;
            }
            this.cursor = this.limit - i11;
            if (!r_mark_sU()) {
                this.cursor = this.limit - i11;
                return r_stem_suffix_chain_before_ki();
            }
            this.bra = this.cursor;
            slice_del();
            int i12 = this.limit;
            int i13 = this.cursor;
            int i14 = i12 - i13;
            this.ket = i13;
            if (!r_mark_lAr()) {
                this.cursor = this.limit - i14;
                return true;
            }
            this.bra = this.cursor;
            slice_del();
            if (r_stem_suffix_chain_before_ki()) {
                return true;
            }
            this.cursor = this.limit - i14;
            return true;
        }
        this.bra = this.cursor;
        slice_del();
        int i15 = this.limit;
        int i16 = this.cursor;
        int i17 = i15 - i16;
        this.ket = i16;
        int i18 = i15 - i16;
        if (r_mark_lArI()) {
            this.bra = this.cursor;
            slice_del();
            return true;
        }
        int i19 = this.limit;
        int i20 = i19 - i18;
        this.cursor = i20;
        this.ket = i20;
        int i21 = i19 - i20;
        if (!r_mark_possessives()) {
            this.cursor = this.limit - i21;
            if (!r_mark_sU()) {
                this.cursor = this.limit - i18;
                if (r_stem_suffix_chain_before_ki()) {
                    return true;
                }
                this.cursor = this.limit - i17;
                return true;
            }
        }
        this.bra = this.cursor;
        slice_del();
        int i22 = this.limit;
        int i23 = this.cursor;
        int i24 = i22 - i23;
        this.ket = i23;
        if (!r_mark_lAr()) {
            this.cursor = this.limit - i24;
            return true;
        }
        this.bra = this.cursor;
        slice_del();
        if (r_stem_suffix_chain_before_ki()) {
            return true;
        }
        this.cursor = this.limit - i24;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof turkishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -685377693;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        if (!r_more_than_one_syllable_word()) {
            return false;
        }
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_stem_nominal_verb_suffixes();
        this.cursor = this.limit;
        if (!this.B_continue_stemming_noun_suffixes) {
            return false;
        }
        r_stem_noun_suffixes();
        this.cursor = this.limit_backward;
        return r_postlude();
    }
}
