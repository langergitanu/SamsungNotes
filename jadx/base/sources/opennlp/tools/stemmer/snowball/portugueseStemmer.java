package opennlp.tools.stemmer.snowball;

import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class portugueseStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("", -1, 3), new Among("ã", 0, 1), new Among("õ", 0, 2)};
    private static final Among[] a_1 = {new Among("", -1, 3), new Among("a~", 0, 1), new Among("o~", 0, 2)};
    private static final Among[] a_2 = {new Among("ic", -1, -1), new Among("ad", -1, -1), new Among(NetworkConfig.CLIENTS_OS, -1, -1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_3 = {new Among("ante", -1, 1), new Among("avel", -1, 1), new Among("ível", -1, 1)};
    private static final Among[] a_4 = {new Among("ic", -1, 1), new Among("abil", -1, 1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_5 = {new Among("ica", -1, 1), new Among("ância", -1, 1), new Among("ência", -1, 4), new Among("logia", -1, 2), new Among("ira", -1, 9), new Among("adora", -1, 1), new Among("osa", -1, 1), new Among("ista", -1, 1), new Among("iva", -1, 8), new Among("eza", -1, 1), new Among("idade", -1, 7), new Among("ante", -1, 1), new Among("mente", -1, 6), new Among("amente", 12, 5), new Among("ável", -1, 1), new Among("ível", -1, 1), new Among("ico", -1, 1), new Among("ismo", -1, 1), new Among("oso", -1, 1), new Among("amento", -1, 1), new Among("imento", -1, 1), new Among("ivo", -1, 8), new Among("aça~o", -1, 1), new Among("uça~o", -1, 3), new Among("ador", -1, 1), new Among("icas", -1, 1), new Among("ências", -1, 4), new Among("logias", -1, 2), new Among("iras", -1, 9), new Among("adoras", -1, 1), new Among("osas", -1, 1), new Among("istas", -1, 1), new Among("ivas", -1, 8), new Among("ezas", -1, 1), new Among("idades", -1, 7), new Among("adores", -1, 1), new Among("antes", -1, 1), new Among("aço~es", -1, 1), new Among("uço~es", -1, 3), new Among("icos", -1, 1), new Among("ismos", -1, 1), new Among("osos", -1, 1), new Among("amentos", -1, 1), new Among("imentos", -1, 1), new Among("ivos", -1, 8)};
    private static final Among[] a_6 = {new Among("ada", -1, 1), new Among("ida", -1, 1), new Among("ia", -1, 1), new Among("aria", 2, 1), new Among("eria", 2, 1), new Among("iria", 2, 1), new Among("ara", -1, 1), new Among("era", -1, 1), new Among("ira", -1, 1), new Among("ava", -1, 1), new Among("asse", -1, 1), new Among("esse", -1, 1), new Among("isse", -1, 1), new Among("aste", -1, 1), new Among("este", -1, 1), new Among("iste", -1, 1), new Among("ei", -1, 1), new Among("arei", 16, 1), new Among("erei", 16, 1), new Among("irei", 16, 1), new Among("am", -1, 1), new Among("iam", 20, 1), new Among("ariam", 21, 1), new Among("eriam", 21, 1), new Among("iriam", 21, 1), new Among("aram", 20, 1), new Among("eram", 20, 1), new Among("iram", 20, 1), new Among("avam", 20, 1), new Among("em", -1, 1), new Among("arem", 29, 1), new Among("erem", 29, 1), new Among("irem", 29, 1), new Among("assem", 29, 1), new Among("essem", 29, 1), new Among("issem", 29, 1), new Among("ado", -1, 1), new Among("ido", -1, 1), new Among("ando", -1, 1), new Among("endo", -1, 1), new Among("indo", -1, 1), new Among("ara~o", -1, 1), new Among("era~o", -1, 1), new Among("ira~o", -1, 1), new Among("ar", -1, 1), new Among("er", -1, 1), new Among("ir", -1, 1), new Among("as", -1, 1), new Among("adas", 47, 1), new Among("idas", 47, 1), new Among("ias", 47, 1), new Among("arias", 50, 1), new Among("erias", 50, 1), new Among("irias", 50, 1), new Among("aras", 47, 1), new Among("eras", 47, 1), new Among("iras", 47, 1), new Among("avas", 47, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, -1, 1), new Among("ardes", 58, 1), new Among("erdes", 58, 1), new Among("irdes", 58, 1), new Among("ares", 58, 1), new Among("eres", 58, 1), new Among("ires", 58, 1), new Among("asses", 58, 1), new Among("esses", 58, 1), new Among("isses", 58, 1), new Among("astes", 58, 1), new Among("estes", 58, 1), new Among("istes", 58, 1), new Among("is", -1, 1), new Among("ais", 71, 1), new Among("eis", 71, 1), new Among("areis", 73, 1), new Among("ereis", 73, 1), new Among("ireis", 73, 1), new Among("áreis", 73, 1), new Among("éreis", 73, 1), new Among("íreis", 73, 1), new Among("ásseis", 73, 1), new Among("ésseis", 73, 1), new Among("ísseis", 73, 1), new Among("áveis", 73, 1), new Among("íeis", 73, 1), new Among("aríeis", 84, 1), new Among("eríeis", 84, 1), new Among("iríeis", 84, 1), new Among("ados", -1, 1), new Among("idos", -1, 1), new Among("amos", -1, 1), new Among("áramos", 90, 1), new Among("éramos", 90, 1), new Among("íramos", 90, 1), new Among("ávamos", 90, 1), new Among("íamos", 90, 1), new Among("aríamos", 95, 1), new Among("eríamos", 95, 1), new Among("iríamos", 95, 1), new Among("emos", -1, 1), new Among("aremos", 99, 1), new Among("eremos", 99, 1), new Among("iremos", 99, 1), new Among("ássemos", 99, 1), new Among("êssemos", 99, 1), new Among("íssemos", 99, 1), new Among("imos", -1, 1), new Among("armos", -1, 1), new Among("ermos", -1, 1), new Among("irmos", -1, 1), new Among("ámos", -1, 1), new Among("arás", -1, 1), new Among("erás", -1, 1), new Among("irás", -1, 1), new Among("eu", -1, 1), new Among("iu", -1, 1), new Among("ou", -1, 1), new Among("ará", -1, 1), new Among("erá", -1, 1), new Among("irá", -1, 1)};
    private static final Among[] a_7 = {new Among("a", -1, 1), new Among("i", -1, 1), new Among("o", -1, 1), new Among(NetworkConfig.CLIENTS_OS, -1, 1), new Among("á", -1, 1), new Among("í", -1, 1), new Among("ó", -1, 1)};
    private static final Among[] a_8 = {new Among("e", -1, 1), new Among("ç", -1, 2), new Among("é", -1, 1), new Among("ê", -1, 1)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 19, '\f', 2};
    private int I_p1;
    private int I_p2;
    private int I_pV;

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_RV() {
        return this.I_pV <= this.cursor;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[LOOP:5: B:15:0x003a->B:37:0x0085, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_regions() {
        char[] cArr;
        int i;
        int i2 = this.limit;
        this.I_pV = i2;
        this.I_p1 = i2;
        this.I_p2 = i2;
        int i4 = this.cursor;
        char[] cArr2 = g_v;
        if (in_grouping(cArr2, 97, 250)) {
            int i5 = this.cursor;
            if (out_grouping(cArr2, 97, 250)) {
                while (!in_grouping(g_v, 97, 250)) {
                    int i6 = this.cursor;
                    if (i6 >= this.limit) {
                        this.cursor = i5;
                        if (!in_grouping(g_v, 97, 250)) {
                        }
                    } else {
                        this.cursor = i6 + 1;
                    }
                }
                this.I_pV = this.cursor;
            } else {
                this.cursor = i5;
                if (!in_grouping(g_v, 97, 250)) {
                    while (!out_grouping(g_v, 97, 250)) {
                        int i7 = this.cursor;
                        if (i7 >= this.limit) {
                            this.cursor = i4;
                            cArr = g_v;
                            if (out_grouping(cArr, 97, 250)) {
                            }
                        } else {
                            this.cursor = i7 + 1;
                        }
                    }
                    this.I_pV = this.cursor;
                }
            }
        } else {
            this.cursor = i4;
            cArr = g_v;
            if (out_grouping(cArr, 97, 250)) {
                int i8 = this.cursor;
                if (out_grouping(cArr, 97, 250)) {
                    while (!in_grouping(g_v, 97, 250)) {
                        int i9 = this.cursor;
                        if (i9 >= this.limit) {
                            this.cursor = i8;
                            if (in_grouping(g_v, 97, 250)) {
                                this.cursor = i + 1;
                                this.I_pV = this.cursor;
                            }
                        } else {
                            this.cursor = i9 + 1;
                        }
                    }
                    this.I_pV = this.cursor;
                } else {
                    this.cursor = i8;
                    if (in_grouping(g_v, 97, 250) && (i = this.cursor) < this.limit) {
                        this.cursor = i + 1;
                        this.I_pV = this.cursor;
                    }
                }
            }
        }
        this.cursor = i4;
        while (true) {
            if (in_grouping(g_v, 97, 250)) {
                while (true) {
                    if (out_grouping(g_v, 97, 250)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 250)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 250)) {
                                        this.I_p2 = this.cursor;
                                        break;
                                    }
                                    int i10 = this.cursor;
                                    if (i10 >= this.limit) {
                                        break;
                                    }
                                    this.cursor = i10 + 1;
                                }
                            } else {
                                int i11 = this.cursor;
                                if (i11 >= this.limit) {
                                    break;
                                }
                                this.cursor = i11 + 1;
                            }
                        }
                    } else {
                        int i12 = this.cursor;
                        if (i12 >= this.limit) {
                            break;
                        }
                        this.cursor = i12 + 1;
                    }
                }
            } else {
                int i13 = this.cursor;
                if (i13 >= this.limit) {
                    break;
                }
                this.cursor = i13 + 1;
            }
        }
        this.cursor = i4;
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
                slice_from("ã");
            } else if (iFind_among == 2) {
                slice_from("õ");
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
        while (true) {
            int i = this.cursor;
            this.bra = i;
            int iFind_among = find_among(a_0);
            int i2 = this.cursor;
            this.ket = i2;
            if (iFind_among == 1) {
                slice_from("a~");
            } else if (iFind_among == 2) {
                slice_from("o~");
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_residual_form() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_8);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                slice_from("c");
            }
        } else {
            if (!r_RV()) {
                return false;
            }
            slice_del();
            int i = this.cursor;
            this.ket = i;
            int i2 = this.limit - i;
            if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                int i4 = this.cursor;
                this.bra = i4;
                int i5 = this.limit - i4;
                if (eq_s_b("g")) {
                    this.cursor = this.limit - i5;
                }
                if (r_RV()) {
                }
            } else {
                this.cursor = this.limit - i2;
                if (!eq_s_b("i")) {
                    return false;
                }
                int i6 = this.cursor;
                this.bra = i6;
                int i7 = this.limit - i6;
                if (!eq_s_b("c")) {
                    return false;
                }
                this.cursor = this.limit - i7;
                if (r_RV()) {
                    return false;
                }
                slice_del();
            }
        }
        return true;
    }

    private boolean r_residual_suffix() {
        this.ket = this.cursor;
        if (find_among_b(a_7) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_RV()) {
            return false;
        }
        slice_del();
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean r_standard_suffix() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_5);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        switch (iFind_among_b) {
            case 1:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                return true;
            case 2:
                if (!r_R2()) {
                    return false;
                }
                slice_from("log");
                return true;
            case 3:
                if (!r_R2()) {
                    return false;
                }
                slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                return true;
            case 4:
                if (!r_R2()) {
                    return false;
                }
                slice_from("ente");
                return true;
            case 5:
                if (!r_R1()) {
                    return false;
                }
                slice_del();
                int i = this.limit;
                int i2 = this.cursor;
                int i4 = i - i2;
                this.ket = i2;
                int iFind_among_b2 = find_among_b(a_2);
                if (iFind_among_b2 == 0) {
                    this.cursor = this.limit - i4;
                } else {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                        if (iFind_among_b2 == 1) {
                            this.ket = this.cursor;
                            if (eq_s_b(VPathDataCmd.ArcTo)) {
                                this.bra = this.cursor;
                                if (r_R2()) {
                                    slice_del();
                                } else {
                                    this.cursor = this.limit - i4;
                                }
                            } else {
                                this.cursor = this.limit - i4;
                            }
                        }
                    } else {
                        this.cursor = this.limit - i4;
                    }
                }
                return true;
            case 6:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i5 = this.limit;
                int i6 = this.cursor;
                int i7 = i5 - i6;
                this.ket = i6;
                if (find_among_b(a_3) == 0) {
                    this.cursor = this.limit - i7;
                } else {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i7;
                    }
                }
                return true;
            case 7:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i8 = this.limit;
                int i9 = this.cursor;
                int i10 = i8 - i9;
                this.ket = i9;
                if (find_among_b(a_4) == 0) {
                    this.cursor = this.limit - i10;
                } else {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i10;
                    }
                }
                return true;
            case 8:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i11 = this.limit;
                int i12 = this.cursor;
                int i13 = i11 - i12;
                this.ket = i12;
                if (eq_s_b(VPathDataCmd.ArcTo)) {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i13;
                    }
                } else {
                    this.cursor = this.limit - i13;
                }
                return true;
            case 9:
                if (!r_RV() || !eq_s_b("e")) {
                    return false;
                }
                slice_from("ir");
                return true;
            default:
                return true;
        }
    }

    private boolean r_verb_suffix() {
        int i = this.cursor;
        int i2 = this.I_pV;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (find_among_b(a_6) == 0) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.limit_backward = i4;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof portugueseStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 382436198;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean stem() {
        int i = this.cursor;
        r_prelude();
        this.cursor = i;
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        if (!r_standard_suffix()) {
            this.cursor = this.limit;
            if (r_verb_suffix()) {
                int i2 = this.limit;
                this.cursor = i2;
                this.ket = i2;
                if (eq_s_b("i")) {
                    int i4 = this.cursor;
                    this.bra = i4;
                    int i5 = this.limit - i4;
                    if (eq_s_b("c")) {
                        this.cursor = this.limit - i5;
                        if (r_RV()) {
                            slice_del();
                        }
                    }
                }
                this.cursor = this.limit;
            } else {
                this.cursor = this.limit;
                r_residual_suffix();
            }
        }
        this.cursor = this.limit;
        r_residual_form();
        int i6 = this.limit_backward;
        this.cursor = i6;
        r_postlude();
        this.cursor = i6;
        return true;
    }
}
