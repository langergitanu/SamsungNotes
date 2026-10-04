package opennlp.tools.stemmer.snowball;

import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsIdToken;
import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class italianStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_p2;
    private int I_pV;
    private static final Among[] a_0 = {new Among("", -1, 7), new Among("qu", 0, 6), new Among("á", 0, 1), new Among("é", 0, 2), new Among("í", 0, 3), new Among("ó", 0, 4), new Among("ú", 0, 5)};
    private static final Among[] a_1 = {new Among("", -1, 3), new Among("I", 0, 1), new Among("U", 0, 2)};
    private static final Among[] a_2 = {new Among("la", -1, -1), new Among("cela", 0, -1), new Among("gliela", 0, -1), new Among("mela", 0, -1), new Among("tela", 0, -1), new Among("vela", 0, -1), new Among("le", -1, -1), new Among("cele", 6, -1), new Among("gliele", 6, -1), new Among("mele", 6, -1), new Among("tele", 6, -1), new Among("vele", 6, -1), new Among("ne", -1, -1), new Among("cene", 12, -1), new Among("gliene", 12, -1), new Among("mene", 12, -1), new Among("sene", 12, -1), new Among("tene", 12, -1), new Among("vene", 12, -1), new Among("ci", -1, -1), new Among("li", -1, -1), new Among("celi", 20, -1), new Among("glieli", 20, -1), new Among("meli", 20, -1), new Among("teli", 20, -1), new Among("veli", 20, -1), new Among("gli", 20, -1), new Among("mi", -1, -1), new Among("si", -1, -1), new Among("ti", -1, -1), new Among(LangPackConfigConstants.LANGUAGE_CODE_VI, -1, -1), new Among("lo", -1, -1), new Among("celo", 31, -1), new Among("glielo", 31, -1), new Among("melo", 31, -1), new Among("telo", 31, -1), new Among("velo", 31, -1)};
    private static final Among[] a_3 = {new Among("ando", -1, 1), new Among("endo", -1, 1), new Among("ar", -1, 2), new Among("er", -1, 2), new Among("ir", -1, 2)};
    private static final Among[] a_4 = {new Among("ic", -1, -1), new Among("abil", -1, -1), new Among(NetworkConfig.CLIENTS_OS, -1, -1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_5 = {new Among("ic", -1, 1), new Among("abil", -1, 1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_6 = {new Among("ica", -1, 1), new Among("logia", -1, 3), new Among("osa", -1, 1), new Among("ista", -1, 1), new Among("iva", -1, 9), new Among("anza", -1, 1), new Among("enza", -1, 5), new Among("ice", -1, 1), new Among("atrice", 7, 1), new Among("iche", -1, 1), new Among("logie", -1, 3), new Among("abile", -1, 1), new Among("ibile", -1, 1), new Among("usione", -1, 4), new Among("azione", -1, 2), new Among("uzione", -1, 4), new Among("atore", -1, 2), new Among("ose", -1, 1), new Among("ante", -1, 1), new Among("mente", -1, 1), new Among("amente", 19, 7), new Among("iste", -1, 1), new Among("ive", -1, 9), new Among("anze", -1, 1), new Among("enze", -1, 5), new Among("ici", -1, 1), new Among("atrici", 25, 1), new Among("ichi", -1, 1), new Among("abili", -1, 1), new Among("ibili", -1, 1), new Among("ismi", -1, 1), new Among("usioni", -1, 4), new Among("azioni", -1, 2), new Among("uzioni", -1, 4), new Among("atori", -1, 2), new Among("osi", -1, 1), new Among("anti", -1, 1), new Among("amenti", -1, 6), new Among("imenti", -1, 6), new Among("isti", -1, 1), new Among("ivi", -1, 9), new Among("ico", -1, 1), new Among("ismo", -1, 1), new Among("oso", -1, 1), new Among("amento", -1, 6), new Among("imento", -1, 6), new Among("ivo", -1, 9), new Among("ità", -1, 8), new Among("istà", -1, 1), new Among("istè", -1, 1), new Among("istì", -1, 1)};
    private static final Among[] a_7 = {new Among("isca", -1, 1), new Among("enda", -1, 1), new Among("ata", -1, 1), new Among("ita", -1, 1), new Among("uta", -1, 1), new Among("ava", -1, 1), new Among("eva", -1, 1), new Among("iva", -1, 1), new Among("erebbe", -1, 1), new Among("irebbe", -1, 1), new Among("isce", -1, 1), new Among("ende", -1, 1), new Among("are", -1, 1), new Among("ere", -1, 1), new Among("ire", -1, 1), new Among("asse", -1, 1), new Among("ate", -1, 1), new Among("avate", 16, 1), new Among("evate", 16, 1), new Among("ivate", 16, 1), new Among("ete", -1, 1), new Among("erete", 20, 1), new Among("irete", 20, 1), new Among("ite", -1, 1), new Among("ereste", -1, 1), new Among("ireste", -1, 1), new Among("ute", -1, 1), new Among("erai", -1, 1), new Among("irai", -1, 1), new Among("isci", -1, 1), new Among("endi", -1, 1), new Among("erei", -1, 1), new Among("irei", -1, 1), new Among("assi", -1, 1), new Among("ati", -1, 1), new Among("iti", -1, 1), new Among("eresti", -1, 1), new Among("iresti", -1, 1), new Among(MicrosoftStsIdToken.UTI, -1, 1), new Among("avi", -1, 1), new Among("evi", -1, 1), new Among("ivi", -1, 1), new Among("isco", -1, 1), new Among("ando", -1, 1), new Among("endo", -1, 1), new Among("Yamo", -1, 1), new Among("iamo", -1, 1), new Among("avamo", -1, 1), new Among("evamo", -1, 1), new Among("ivamo", -1, 1), new Among("eremo", -1, 1), new Among("iremo", -1, 1), new Among("assimo", -1, 1), new Among("ammo", -1, 1), new Among("emmo", -1, 1), new Among("eremmo", 54, 1), new Among("iremmo", 54, 1), new Among("immo", -1, 1), new Among("ano", -1, 1), new Among("iscano", 58, 1), new Among("avano", 58, 1), new Among("evano", 58, 1), new Among("ivano", 58, 1), new Among("eranno", -1, 1), new Among("iranno", -1, 1), new Among("ono", -1, 1), new Among("iscono", 65, 1), new Among("arono", 65, 1), new Among("erono", 65, 1), new Among("irono", 65, 1), new Among("erebbero", -1, 1), new Among("irebbero", -1, 1), new Among("assero", -1, 1), new Among("essero", -1, 1), new Among("issero", -1, 1), new Among("ato", -1, 1), new Among("ito", -1, 1), new Among("uto", -1, 1), new Among("avo", -1, 1), new Among("evo", -1, 1), new Among("ivo", -1, 1), new Among("ar", -1, 1), new Among("ir", -1, 1), new Among("erà", -1, 1), new Among("irà", -1, 1), new Among("erò", -1, 1), new Among("irò", -1, 1)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 128, '\b', 2, 1};
    private static final char[] g_AEIO = {17, 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 128, '\b', 2};
    private static final char[] g_CG = {17};

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_RV() {
        return this.I_pV <= this.cursor;
    }

    private boolean r_attached_pronoun() {
        this.ket = this.cursor;
        if (find_among_b(a_2) == 0) {
            return false;
        }
        this.bra = this.cursor;
        int iFind_among_b = find_among_b(a_3);
        if (iFind_among_b == 0 || !r_RV()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_from("e");
        }
        return true;
    }

    private boolean r_exceptions() {
        int i;
        this.bra = this.cursor;
        if (!eq_s("divano") || (i = this.cursor) < this.limit) {
            return false;
        }
        this.ket = i;
        slice_from("divan");
        return true;
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
        if (in_grouping(cArr2, 97, 249)) {
            int i5 = this.cursor;
            if (out_grouping(cArr2, 97, 249)) {
                while (!in_grouping(g_v, 97, 249)) {
                    int i6 = this.cursor;
                    if (i6 >= this.limit) {
                        this.cursor = i5;
                        if (!in_grouping(g_v, 97, 249)) {
                        }
                    } else {
                        this.cursor = i6 + 1;
                    }
                }
                this.I_pV = this.cursor;
            } else {
                this.cursor = i5;
                if (!in_grouping(g_v, 97, 249)) {
                    while (!out_grouping(g_v, 97, 249)) {
                        int i7 = this.cursor;
                        if (i7 >= this.limit) {
                            this.cursor = i4;
                            cArr = g_v;
                            if (out_grouping(cArr, 97, 249)) {
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
            if (out_grouping(cArr, 97, 249)) {
                int i8 = this.cursor;
                if (out_grouping(cArr, 97, 249)) {
                    while (!in_grouping(g_v, 97, 249)) {
                        int i9 = this.cursor;
                        if (i9 >= this.limit) {
                            this.cursor = i8;
                            if (in_grouping(g_v, 97, 249)) {
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
                    if (in_grouping(g_v, 97, 249) && (i = this.cursor) < this.limit) {
                        this.cursor = i + 1;
                        this.I_pV = this.cursor;
                    }
                }
            }
        }
        this.cursor = i4;
        while (true) {
            if (in_grouping(g_v, 97, 249)) {
                while (true) {
                    if (out_grouping(g_v, 97, 249)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 249)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 249)) {
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
                slice_from("i");
            } else if (iFind_among == 2) {
                slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
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
                    slice_from("à");
                    break;
                case 2:
                    slice_from("è");
                    break;
                case 3:
                    slice_from("ì");
                    break;
                case 4:
                    slice_from("ò");
                    break;
                case 5:
                    slice_from("ù");
                    break;
                case 6:
                    slice_from("qU");
                    break;
                case 7:
                    if (i4 < this.limit) {
                        this.cursor = i4 + 1;
                    } else {
                        this.cursor = i2;
                        while (true) {
                            int i5 = this.cursor;
                            while (true) {
                                i = this.cursor;
                                char[] cArr = g_v;
                                if (in_grouping(cArr, 97, 249)) {
                                    int i6 = this.cursor;
                                    this.bra = i6;
                                    if (eq_s(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                                        this.ket = this.cursor;
                                        if (in_grouping(cArr, 97, 249)) {
                                            slice_from("U");
                                        }
                                    }
                                    this.cursor = i6;
                                    if (eq_s("i")) {
                                        this.ket = this.cursor;
                                        if (in_grouping(cArr, 97, 249)) {
                                            slice_from("I");
                                        }
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean r_standard_suffix() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_6);
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
                slice_del();
                int i = this.limit;
                int i2 = this.cursor;
                int i4 = i - i2;
                this.ket = i2;
                if (eq_s_b("ic")) {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i4;
                    }
                } else {
                    this.cursor = this.limit - i4;
                }
                return true;
            case 3:
                if (!r_R2()) {
                    return false;
                }
                slice_from("log");
                return true;
            case 4:
                if (!r_R2()) {
                    return false;
                }
                slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                return true;
            case 5:
                if (!r_R2()) {
                    return false;
                }
                slice_from("ente");
                return true;
            case 6:
                if (!r_RV()) {
                    return false;
                }
                slice_del();
                return true;
            case 7:
                if (!r_R1()) {
                    return false;
                }
                slice_del();
                int i5 = this.limit;
                int i6 = this.cursor;
                int i7 = i5 - i6;
                this.ket = i6;
                int iFind_among_b2 = find_among_b(a_4);
                if (iFind_among_b2 == 0) {
                    this.cursor = this.limit - i7;
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
                                    this.cursor = this.limit - i7;
                                }
                            } else {
                                this.cursor = this.limit - i7;
                            }
                        }
                    } else {
                        this.cursor = this.limit - i7;
                    }
                }
                return true;
            case 8:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i8 = this.limit;
                int i9 = this.cursor;
                int i10 = i8 - i9;
                this.ket = i9;
                if (find_among_b(a_5) == 0) {
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
            case 9:
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
                        this.ket = this.cursor;
                        if (eq_s_b("ic")) {
                            this.bra = this.cursor;
                            if (r_R2()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i13;
                            }
                        } else {
                            this.cursor = this.limit - i13;
                        }
                    } else {
                        this.cursor = this.limit - i13;
                    }
                } else {
                    this.cursor = this.limit - i13;
                }
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
        if (find_among_b(a_7) == 0) {
            this.limit_backward = i4;
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.limit_backward = i4;
        return true;
    }

    private boolean r_vowel_suffix() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (in_grouping_b(g_AEIO, 97, 242)) {
            this.bra = this.cursor;
            if (r_RV()) {
                slice_del();
                this.ket = this.cursor;
                if (eq_s_b("i")) {
                    this.bra = this.cursor;
                    if (r_RV()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i4;
                    }
                } else {
                    this.cursor = this.limit - i4;
                }
            } else {
                this.cursor = this.limit - i4;
            }
        } else {
            this.cursor = this.limit - i4;
        }
        int i5 = this.limit;
        int i6 = this.cursor;
        int i7 = i5 - i6;
        this.ket = i6;
        if (!eq_s_b("h")) {
            this.cursor = this.limit - i7;
            return true;
        }
        this.bra = this.cursor;
        if (!in_grouping_b(g_CG, 99, 103)) {
            this.cursor = this.limit - i7;
            return true;
        }
        if (r_RV()) {
            slice_del();
            return true;
        }
        this.cursor = this.limit - i7;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof italianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 1219181991;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        int i = this.cursor;
        if (r_exceptions()) {
            return true;
        }
        this.cursor = i;
        r_prelude();
        this.cursor = i;
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_attached_pronoun();
        this.cursor = this.limit;
        if (!r_standard_suffix()) {
            this.cursor = this.limit;
            r_verb_suffix();
        }
        this.cursor = this.limit;
        r_vowel_suffix();
        int i2 = this.limit_backward;
        this.cursor = i2;
        r_postlude();
        this.cursor = i2;
        return true;
    }
}
