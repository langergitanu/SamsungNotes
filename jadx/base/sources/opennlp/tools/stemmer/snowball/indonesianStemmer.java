package opennlp.tools.stemmer.snowball;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class indonesianStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("kah", -1, 1), new Among("lah", -1, 1), new Among("pun", -1, 1)};
    private static final Among[] a_1 = {new Among("nya", -1, 1), new Among("ku", -1, 1), new Among("mu", -1, 1)};
    private static final Among[] a_2 = {new Among("i", -1, 1, "r_SUFFIX_I_OK", indonesianStemmer.class), new Among("an", -1, 1, "r_SUFFIX_AN_OK", indonesianStemmer.class), new Among("kan", 1, 1, "r_SUFFIX_KAN_OK", indonesianStemmer.class)};
    private static final Among[] a_3 = {new Among("di", -1, 1), new Among("ke", -1, 2), new Among("me", -1, 1), new Among("mem", 2, 5), new Among("men", 2, 1), new Among("meng", 4, 1), new Among("meny", 4, 3, "r_VOWEL", indonesianStemmer.class), new Among("pem", -1, 6), new Among("pen", -1, 2), new Among("peng", 8, 2), new Among("peny", 8, 4, "r_VOWEL", indonesianStemmer.class), new Among("ter", -1, 1)};
    private static final Among[] a_4 = {new Among("be", -1, 3, "r_KER", indonesianStemmer.class), new Among("belajar", 0, 4), new Among("ber", 0, 3), new Among("pe", -1, 1), new Among("pelajar", 3, 2), new Among("per", 3, 1)};
    private static final char[] g_vowel = {17, 'A', 16};
    private int I_measure;
    private int I_prefix;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean r_remove_first_order_prefix() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_3);
        if (iFind_among == 0) {
            return false;
        }
        int i = this.cursor;
        this.ket = i;
        switch (iFind_among) {
            case 1:
                slice_del();
                this.I_prefix = 1;
                this.I_measure--;
                return true;
            case 2:
                slice_del();
                this.I_prefix = 3;
                this.I_measure--;
                return true;
            case 3:
                this.I_prefix = 1;
                slice_from("s");
                this.I_measure--;
                return true;
            case 4:
                this.I_prefix = 3;
                slice_from("s");
                this.I_measure--;
                return true;
            case 5:
                this.I_prefix = 1;
                this.I_measure--;
                if (in_grouping(g_vowel, 97, 117)) {
                    this.cursor = i;
                    slice_from("p");
                } else {
                    this.cursor = i;
                    slice_del();
                }
                return true;
            case 6:
                this.I_prefix = 3;
                this.I_measure--;
                if (in_grouping(g_vowel, 97, 117)) {
                    this.cursor = i;
                    slice_from("p");
                } else {
                    this.cursor = i;
                    slice_del();
                }
                return true;
            default:
                return true;
        }
    }

    private boolean r_remove_particle() {
        this.ket = this.cursor;
        if (find_among_b(a_0) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.I_measure--;
        return true;
    }

    private boolean r_remove_possessive_pronoun() {
        this.ket = this.cursor;
        if (find_among_b(a_1) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.I_measure--;
        return true;
    }

    private boolean r_remove_second_order_prefix() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_4);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among == 1) {
            slice_del();
            this.I_prefix = 2;
            this.I_measure--;
        } else if (iFind_among == 2) {
            slice_from("ajar");
            this.I_measure--;
        } else if (iFind_among == 3) {
            slice_del();
            this.I_prefix = 4;
            this.I_measure--;
        } else if (iFind_among == 4) {
            slice_from("ajar");
            this.I_prefix = 4;
            this.I_measure--;
        }
        return true;
    }

    private boolean r_remove_suffix() {
        this.ket = this.cursor;
        if (find_among_b(a_2) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.I_measure--;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof indonesianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -104955823;
    }

    public boolean r_KER() {
        return out_grouping(g_vowel, 97, 117) && eq_s("er");
    }

    public boolean r_SUFFIX_AN_OK() {
        return this.I_prefix != 1;
    }

    public boolean r_SUFFIX_I_OK() {
        if (this.I_prefix > 2) {
            return false;
        }
        int i = this.limit - this.cursor;
        if (eq_s_b("s")) {
            return false;
        }
        this.cursor = this.limit - i;
        return true;
    }

    public boolean r_SUFFIX_KAN_OK() {
        int i = this.I_prefix;
        return (i == 3 || i == 2) ? false : true;
    }

    public boolean r_VOWEL() {
        return in_grouping(g_vowel, 97, 117);
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i;
        this.I_measure = 0;
        int i2 = this.cursor;
        while (true) {
            if (in_grouping(g_vowel, 97, 117)) {
                this.I_measure++;
            } else {
                int i4 = this.cursor;
                i = this.limit;
                if (i4 >= i) {
                    break;
                }
                this.cursor = i4 + 1;
            }
        }
        this.cursor = i2;
        if (this.I_measure <= 2) {
            return false;
        }
        this.I_prefix = 0;
        this.limit_backward = i2;
        this.cursor = i;
        r_remove_particle();
        this.cursor = this.limit;
        if (this.I_measure <= 2) {
            return false;
        }
        r_remove_possessive_pronoun();
        int i5 = this.limit_backward;
        this.cursor = i5;
        if (this.I_measure <= 2) {
            return false;
        }
        if (r_remove_first_order_prefix()) {
            int i6 = this.cursor;
            if (this.I_measure > 2) {
                this.limit_backward = i6;
                this.cursor = this.limit;
                if (r_remove_suffix()) {
                    this.cursor = i6;
                    if (this.I_measure > 2) {
                        r_remove_second_order_prefix();
                    }
                }
            }
            this.cursor = i5;
        } else {
            this.cursor = i5;
            r_remove_second_order_prefix();
            this.cursor = i5;
            if (this.I_measure > 2) {
                this.limit_backward = i5;
                this.cursor = this.limit;
                if (r_remove_suffix()) {
                    this.cursor = this.limit_backward;
                }
            }
            this.cursor = i5;
        }
        return true;
    }
}
