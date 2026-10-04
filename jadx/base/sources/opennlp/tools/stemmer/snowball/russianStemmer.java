package opennlp.tools.stemmer.snowball;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class russianStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("в", -1, 1), new Among("ив", 0, 2), new Among("ыв", 0, 2), new Among("вши", -1, 1), new Among("ивши", 3, 2), new Among("ывши", 3, 2), new Among("вшись", -1, 1), new Among("ившись", 6, 2), new Among("ывшись", 6, 2)};
    private static final Among[] a_1 = {new Among("ее", -1, 1), new Among("ие", -1, 1), new Among("ое", -1, 1), new Among("ые", -1, 1), new Among("ими", -1, 1), new Among("ыми", -1, 1), new Among("ей", -1, 1), new Among("ий", -1, 1), new Among("ой", -1, 1), new Among("ый", -1, 1), new Among("ем", -1, 1), new Among("им", -1, 1), new Among("ом", -1, 1), new Among("ым", -1, 1), new Among("его", -1, 1), new Among("ого", -1, 1), new Among("ему", -1, 1), new Among("ому", -1, 1), new Among("их", -1, 1), new Among("ых", -1, 1), new Among("ею", -1, 1), new Among("ою", -1, 1), new Among("ую", -1, 1), new Among("юю", -1, 1), new Among("ая", -1, 1), new Among("яя", -1, 1)};
    private static final Among[] a_2 = {new Among("ем", -1, 1), new Among("нн", -1, 1), new Among("вш", -1, 1), new Among("ивш", 2, 2), new Among("ывш", 2, 2), new Among("щ", -1, 1), new Among("ющ", 5, 1), new Among("ующ", 6, 2)};
    private static final Among[] a_3 = {new Among("сь", -1, 1), new Among("ся", -1, 1)};
    private static final Among[] a_4 = {new Among("ла", -1, 1), new Among("ила", 0, 2), new Among("ыла", 0, 2), new Among("на", -1, 1), new Among("ена", 3, 2), new Among("ете", -1, 1), new Among("ите", -1, 2), new Among("йте", -1, 1), new Among("ейте", 7, 2), new Among("уйте", 7, 2), new Among("ли", -1, 1), new Among("или", 10, 2), new Among("ыли", 10, 2), new Among("й", -1, 1), new Among("ей", 13, 2), new Among("уй", 13, 2), new Among("л", -1, 1), new Among("ил", 16, 2), new Among("ыл", 16, 2), new Among("ем", -1, 1), new Among("им", -1, 2), new Among("ым", -1, 2), new Among("н", -1, 1), new Among("ен", 22, 2), new Among("ло", -1, 1), new Among("ило", 24, 2), new Among("ыло", 24, 2), new Among("но", -1, 1), new Among("ено", 27, 2), new Among("нно", 27, 1), new Among("ет", -1, 1), new Among("ует", 30, 2), new Among("ит", -1, 2), new Among("ыт", -1, 2), new Among("ют", -1, 1), new Among("уют", 34, 2), new Among("ят", -1, 2), new Among("ны", -1, 1), new Among("ены", 37, 2), new Among("ть", -1, 1), new Among("ить", 39, 2), new Among("ыть", 39, 2), new Among("ешь", -1, 1), new Among("ишь", -1, 2), new Among("ю", -1, 2), new Among("ую", 44, 2)};
    private static final Among[] a_5 = {new Among("а", -1, 1), new Among("ев", -1, 1), new Among("ов", -1, 1), new Among("е", -1, 1), new Among("ие", 3, 1), new Among("ье", 3, 1), new Among("и", -1, 1), new Among("еи", 6, 1), new Among("ии", 6, 1), new Among("ами", 6, 1), new Among("ями", 6, 1), new Among("иями", 10, 1), new Among("й", -1, 1), new Among("ей", 12, 1), new Among("ией", 13, 1), new Among("ий", 12, 1), new Among("ой", 12, 1), new Among("ам", -1, 1), new Among("ем", -1, 1), new Among("ием", 18, 1), new Among("ом", -1, 1), new Among("ям", -1, 1), new Among("иям", 21, 1), new Among("о", -1, 1), new Among("у", -1, 1), new Among("ах", -1, 1), new Among("ях", -1, 1), new Among("иях", 26, 1), new Among("ы", -1, 1), new Among("ь", -1, 1), new Among("ю", -1, 1), new Among("ию", 30, 1), new Among("ью", 30, 1), new Among("я", -1, 1), new Among("ия", 33, 1), new Among("ья", 33, 1)};
    private static final Among[] a_6 = {new Among("ост", -1, 1), new Among("ость", -1, 1)};
    private static final Among[] a_7 = {new Among("ейше", -1, 1), new Among("н", -1, 2), new Among("ейш", -1, 1), new Among("ь", -1, 3)};
    private static final char[] g_v = {'!', 'A', '\b', 232};
    private int I_p2;
    private int I_pV;

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_adjectival() {
        if (!r_adjective()) {
            return false;
        }
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            this.cursor = this.limit - i4;
        } else {
            int i5 = this.cursor;
            this.bra = i5;
            if (iFind_among_b == 1) {
                int i6 = this.limit - i5;
                if (!eq_s_b("а")) {
                    this.cursor = this.limit - i6;
                    if (eq_s_b("я")) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i4;
                    }
                }
            } else if (iFind_among_b == 2) {
                slice_del();
            }
        }
        return true;
    }

    private boolean r_adjective() {
        this.ket = this.cursor;
        if (find_among_b(a_1) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    private boolean r_derivational() {
        this.ket = this.cursor;
        if (find_among_b(a_6) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R2()) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_pV = i;
        this.I_p2 = i;
        int i2 = this.cursor;
        while (true) {
            if (in_grouping(g_v, 1072, 1103)) {
                this.I_pV = this.cursor;
                while (true) {
                    if (out_grouping(g_v, 1072, 1103)) {
                        while (true) {
                            if (in_grouping(g_v, 1072, 1103)) {
                                while (true) {
                                    if (out_grouping(g_v, 1072, 1103)) {
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
                        int i6 = this.cursor;
                        if (i6 >= this.limit) {
                            break;
                        }
                        this.cursor = i6 + 1;
                    }
                }
            } else {
                int i7 = this.cursor;
                if (i7 >= this.limit) {
                    break;
                }
                this.cursor = i7 + 1;
            }
        }
        this.cursor = i2;
        return true;
    }

    private boolean r_noun() {
        this.ket = this.cursor;
        if (find_among_b(a_5) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    private boolean r_perfective_gerund() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_0);
        if (iFind_among_b == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
        if (iFind_among_b == 1) {
            int i2 = this.limit - i;
            if (!eq_s_b("а")) {
                this.cursor = this.limit - i2;
                if (!eq_s_b("я")) {
                    return false;
                }
            }
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_del();
        }
        return true;
    }

    private boolean r_reflexive() {
        this.ket = this.cursor;
        if (find_among_b(a_3) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    private boolean r_tidy_up() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_7);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b == 1) {
            slice_del();
            this.ket = this.cursor;
            if (!eq_s_b("н")) {
                return false;
            }
            this.bra = this.cursor;
            if (!eq_s_b("н")) {
                return false;
            }
            slice_del();
        } else if (iFind_among_b != 2) {
            if (iFind_among_b == 3) {
                slice_del();
            }
        } else {
            if (!eq_s_b("н")) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_verb() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
        if (iFind_among_b == 1) {
            int i2 = this.limit - i;
            if (!eq_s_b("а")) {
                this.cursor = this.limit - i2;
                if (!eq_s_b("я")) {
                    return false;
                }
            }
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_del();
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof russianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -994517324;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        while (true) {
            int i2 = this.cursor;
            this.bra = i2;
            if (eq_s("ё")) {
                this.ket = this.cursor;
                this.cursor = i2;
                slice_from("е");
            } else {
                this.cursor = i2;
                if (i2 >= this.limit) {
                    break;
                }
                this.cursor = i2 + 1;
            }
        }
        this.cursor = i;
        r_mark_regions();
        int i4 = this.cursor;
        this.limit_backward = i4;
        int i5 = this.limit;
        this.cursor = i5;
        int i6 = this.I_pV;
        if (i5 < i6) {
            return false;
        }
        this.limit_backward = i6;
        if (!r_perfective_gerund()) {
            this.cursor = this.limit;
            if (!r_reflexive()) {
                this.cursor = this.limit;
            }
            int i7 = this.limit - this.cursor;
            if (!r_adjectival()) {
                this.cursor = this.limit - i7;
                if (!r_verb()) {
                    this.cursor = this.limit - i7;
                    r_noun();
                }
            }
        }
        int i8 = this.limit;
        this.cursor = i8;
        this.ket = i8;
        if (eq_s_b("и")) {
            this.bra = this.cursor;
            slice_del();
        } else {
            this.cursor = this.limit;
        }
        int i9 = this.limit - this.cursor;
        r_derivational();
        this.cursor = this.limit - i9;
        r_tidy_up();
        this.limit_backward = i4;
        this.cursor = i4;
        return true;
    }
}
