package opennlp.tools.stemmer.snowball;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class germanStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_p2;
    private int I_x;
    private static final Among[] a_0 = {new Among("", -1, 5), new Among(VPathDataCmd.AngleEllipseTo, 0, 2), new Among("oe", 0, 3), new Among("qu", 0, -1), new Among("ue", 0, 4), new Among("ß", 0, 1)};
    private static final Among[] a_1 = {new Among("", -1, 5), new Among("U", 0, 2), new Among(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, 0, 1), new Among("ä", 0, 3), new Among("ö", 0, 4), new Among("ü", 0, 2)};
    private static final Among[] a_2 = {new Among("e", -1, 3), new Among("em", -1, 1), new Among("en", -1, 3), new Among("ern", -1, 2), new Among("er", -1, 2), new Among("s", -1, 4), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, 5, 3)};
    private static final Among[] a_3 = {new Among("en", -1, 1), new Among("er", -1, 1), new Among("st", -1, 2), new Among("est", 2, 1)};
    private static final Among[] a_4 = {new Among("ig", -1, 1), new Among("lich", -1, 1)};
    private static final Among[] a_5 = {new Among("end", -1, 1), new Among("ig", -1, 2), new Among("ung", -1, 1), new Among("lich", -1, 3), new Among("isch", -1, 2), new Among("ik", -1, 2), new Among("heit", -1, 3), new Among("keit", -1, 4)};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '\b', 0, ' ', '\b'};
    private static final char[] g_s_ending = {'u', 30, 5};
    private static final char[] g_st_ending = {'u', 30, 4};

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_mark_regions() {
        int i = this.limit;
        this.I_p1 = i;
        this.I_p2 = i;
        int i2 = this.cursor;
        int i4 = i2 + 3;
        if (i4 > i) {
            return false;
        }
        this.I_x = i4;
        this.cursor = i2;
        while (!in_grouping(g_v, 97, 252)) {
            int i5 = this.cursor;
            if (i5 >= this.limit) {
                return false;
            }
            this.cursor = i5 + 1;
        }
        while (!out_grouping(g_v, 97, 252)) {
            int i6 = this.cursor;
            if (i6 >= this.limit) {
                return false;
            }
            this.cursor = i6 + 1;
        }
        int i7 = this.cursor;
        this.I_p1 = i7;
        int i8 = this.I_x;
        if (i7 < i8) {
            this.I_p1 = i8;
        }
        while (!in_grouping(g_v, 97, 252)) {
            int i9 = this.cursor;
            if (i9 >= this.limit) {
                return false;
            }
            this.cursor = i9 + 1;
        }
        while (!out_grouping(g_v, 97, 252)) {
            int i10 = this.cursor;
            if (i10 >= this.limit) {
                return false;
            }
            this.cursor = i10 + 1;
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
                slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
            } else if (iFind_among == 3) {
                slice_from("a");
            } else if (iFind_among == 4) {
                slice_from("o");
            } else if (iFind_among != 5) {
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_prelude() {
        int i = this.cursor;
        while (true) {
            int i2 = this.cursor;
            char[] cArr = g_v;
            if (in_grouping(cArr, 97, 252)) {
                int i4 = this.cursor;
                this.bra = i4;
                if (eq_s(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                    this.ket = this.cursor;
                    if (in_grouping(cArr, 97, 252)) {
                        slice_from("U");
                    }
                    this.cursor = i2;
                } else {
                    this.cursor = i4;
                    if (eq_s("y")) {
                        this.ket = this.cursor;
                        if (in_grouping(cArr, 97, 252)) {
                            slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                            this.cursor = i2;
                        }
                    }
                }
            }
            this.cursor = i2;
            if (i2 >= this.limit) {
                break;
            }
            this.cursor = i2 + 1;
        }
        this.cursor = i;
        while (true) {
            int i5 = this.cursor;
            this.bra = i5;
            int iFind_among = find_among(a_0);
            int i6 = this.cursor;
            this.ket = i6;
            if (iFind_among == 1) {
                slice_from("ss");
            } else if (iFind_among == 2) {
                slice_from("ä");
            } else if (iFind_among == 3) {
                slice_from("ö");
            } else if (iFind_among == 4) {
                slice_from("ü");
            } else if (iFind_among != 5) {
                continue;
            } else {
                if (i6 >= this.limit) {
                    this.cursor = i5;
                    return true;
                }
                this.cursor = i6 + 1;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_standard_suffix() {
        int i;
        int i2 = this.limit;
        int i4 = this.cursor;
        int i5 = i2 - i4;
        this.ket = i4;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b != 0) {
            this.bra = this.cursor;
            if (r_R1()) {
                if (iFind_among_b == 1) {
                    int i6 = this.limit - this.cursor;
                    if (!eq_s_b("syst")) {
                        this.cursor = this.limit - i6;
                        slice_del();
                    }
                } else if (iFind_among_b == 2) {
                    slice_del();
                } else if (iFind_among_b == 3) {
                    slice_del();
                    int i7 = this.limit;
                    int i8 = this.cursor;
                    int i9 = i7 - i8;
                    this.ket = i8;
                    if (eq_s_b("s")) {
                        this.bra = this.cursor;
                        if (eq_s_b("nis")) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i9;
                        }
                    } else {
                        this.cursor = this.limit - i9;
                    }
                } else if (iFind_among_b == 4 && in_grouping_b(g_s_ending, 98, 116)) {
                    slice_del();
                }
            }
        }
        int i10 = this.limit;
        int i11 = i10 - i5;
        this.cursor = i11;
        int i12 = i10 - i11;
        this.ket = i11;
        int iFind_among_b2 = find_among_b(a_3);
        if (iFind_among_b2 != 0) {
            this.bra = this.cursor;
            if (r_R1()) {
                if (iFind_among_b2 == 1) {
                    slice_del();
                } else if (iFind_among_b2 == 2 && in_grouping_b(g_st_ending, 98, 116) && (i = this.cursor - 3) >= this.limit_backward) {
                    this.cursor = i;
                    slice_del();
                }
            }
        }
        int i13 = this.limit;
        int i14 = i13 - i12;
        this.cursor = i14;
        int i15 = i13 - i14;
        this.ket = i14;
        int iFind_among_b3 = find_among_b(a_5);
        if (iFind_among_b3 != 0) {
            this.bra = this.cursor;
            if (r_R2()) {
                if (iFind_among_b3 == 1) {
                    slice_del();
                    int i16 = this.limit;
                    int i17 = this.cursor;
                    int i18 = i16 - i17;
                    this.ket = i17;
                    if (eq_s_b("ig")) {
                        int i19 = this.cursor;
                        this.bra = i19;
                        int i20 = this.limit - i19;
                        if (eq_s_b("e")) {
                            this.cursor = this.limit - i18;
                        } else {
                            this.cursor = this.limit - i20;
                            if (r_R2()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i18;
                            }
                        }
                    } else {
                        this.cursor = this.limit - i18;
                    }
                } else if (iFind_among_b3 == 2) {
                    int i21 = this.limit - this.cursor;
                    if (!eq_s_b("e")) {
                        this.cursor = this.limit - i21;
                        slice_del();
                    }
                } else if (iFind_among_b3 == 3) {
                    slice_del();
                    int i22 = this.limit;
                    int i23 = this.cursor;
                    int i24 = i22 - i23;
                    this.ket = i23;
                    int i25 = i22 - i23;
                    if (!eq_s_b("er")) {
                        this.cursor = this.limit - i25;
                        if (eq_s_b("en")) {
                            this.bra = this.cursor;
                            if (r_R1()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i24;
                            }
                        } else {
                            this.cursor = this.limit - i24;
                        }
                    }
                } else if (iFind_among_b3 == 4) {
                    slice_del();
                    int i26 = this.limit;
                    int i27 = this.cursor;
                    int i28 = i26 - i27;
                    this.ket = i27;
                    if (find_among_b(a_4) == 0) {
                        this.cursor = this.limit - i28;
                    } else {
                        this.bra = this.cursor;
                        if (r_R2()) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i28;
                        }
                    }
                }
            }
        }
        this.cursor = this.limit - i15;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof germanStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -1482942475;
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
