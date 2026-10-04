package opennlp.tools.stemmer.snowball;

import com.nimbusds.jose.HeaderParameterNames;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class frenchStemmer extends AbstractSnowballStemmer {
    private int I_p1;
    private int I_p2;
    private int I_pV;
    private static final Among[] a_0 = {new Among("col", -1, -1), new Among("par", -1, -1), new Among("tap", -1, -1)};
    private static final Among[] a_1 = {new Among("", -1, 7), new Among("H", 0, 6), new Among("He", 1, 4), new Among(HWToolbarSAConstants.DETAIL_MARKER_PEN, 1, 5), new Among("I", 0, 1), new Among("U", 0, 2), new Among(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, 0, 3)};
    private static final Among[] a_2 = {new Among("iqU", -1, 3), new Among("abl", -1, 3), new Among("Ièr", -1, 4), new Among("ièr", -1, 4), new Among("eus", -1, 2), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_3 = {new Among("ic", -1, 2), new Among("abil", -1, 1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 3)};
    private static final Among[] a_4 = {new Among("iqUe", -1, 1), new Among("atrice", -1, 2), new Among("ance", -1, 1), new Among("ence", -1, 5), new Among("logie", -1, 3), new Among("able", -1, 1), new Among("isme", -1, 1), new Among("euse", -1, 11), new Among("iste", -1, 1), new Among("ive", -1, 8), new Among(VElementFormulasCmd.FIF, -1, 8), new Among("usion", -1, 4), new Among("ation", -1, 2), new Among("ution", -1, 4), new Among("ateur", -1, 2), new Among("iqUes", -1, 1), new Among("atrices", -1, 2), new Among("ances", -1, 1), new Among("ences", -1, 5), new Among("logies", -1, 3), new Among("ables", -1, 1), new Among("ismes", -1, 1), new Among("euses", -1, 11), new Among("istes", -1, 1), new Among("ives", -1, 8), new Among("ifs", -1, 8), new Among("usions", -1, 4), new Among("ations", -1, 2), new Among("utions", -1, 4), new Among("ateurs", -1, 2), new Among("ments", -1, 15), new Among("ements", 30, 6), new Among("issements", 31, 12), new Among("ités", -1, 7), new Among("ment", -1, 15), new Among("ement", 34, 6), new Among("issement", 35, 12), new Among("amment", 34, 13), new Among("emment", 34, 14), new Among("aux", -1, 10), new Among("eaux", 39, 9), new Among("eux", -1, 1), new Among("ité", -1, 7)};
    private static final Among[] a_5 = {new Among("ira", -1, 1), new Among("ie", -1, 1), new Among("isse", -1, 1), new Among("issante", -1, 1), new Among("i", -1, 1), new Among("irai", 4, 1), new Among("ir", -1, 1), new Among("iras", -1, 1), new Among("ies", -1, 1), new Among("îmes", -1, 1), new Among("isses", -1, 1), new Among("issantes", -1, 1), new Among("îtes", -1, 1), new Among("is", -1, 1), new Among("irais", 13, 1), new Among("issais", 13, 1), new Among("irions", -1, 1), new Among("issions", -1, 1), new Among("irons", -1, 1), new Among("issons", -1, 1), new Among("issants", -1, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_IT, -1, 1), new Among("irait", 21, 1), new Among("issait", 21, 1), new Among("issant", -1, 1), new Among("iraIent", -1, 1), new Among("issaIent", -1, 1), new Among("irent", -1, 1), new Among("issent", -1, 1), new Among("iront", -1, 1), new Among("ît", -1, 1), new Among("iriez", -1, 1), new Among("issiez", -1, 1), new Among("irez", -1, 1), new Among("issez", -1, 1)};
    private static final Among[] a_6 = {new Among("a", -1, 3), new Among("era", 0, 2), new Among("asse", -1, 3), new Among("ante", -1, 3), new Among("ée", -1, 2), new Among("ai", -1, 3), new Among("erai", 5, 2), new Among("er", -1, 2), new Among("as", -1, 3), new Among("eras", 8, 2), new Among("âmes", -1, 3), new Among("asses", -1, 3), new Among("antes", -1, 3), new Among("âtes", -1, 3), new Among("ées", -1, 2), new Among("ais", -1, 3), new Among("erais", 15, 2), new Among("ions", -1, 1), new Among("erions", 17, 2), new Among("assions", 17, 3), new Among("erons", -1, 2), new Among("ants", -1, 3), new Among("és", -1, 2), new Among("ait", -1, 3), new Among("erait", 23, 2), new Among("ant", -1, 3), new Among("aIent", -1, 3), new Among("eraIent", 26, 2), new Among("èrent", -1, 2), new Among("assent", -1, 3), new Among("eront", -1, 2), new Among("ât", -1, 3), new Among("ez", -1, 2), new Among("iez", 32, 2), new Among("eriez", 33, 2), new Among("assiez", 33, 3), new Among("erez", 32, 2), new Among("é", -1, 2)};
    private static final Among[] a_7 = {new Among("e", -1, 3), new Among("Ière", 0, 2), new Among("ière", 0, 2), new Among("ion", -1, 1), new Among("Ier", -1, 2), new Among("ier", -1, 2)};
    private static final Among[] a_8 = {new Among("ell", -1, -1), new Among("eill", -1, -1), new Among("enn", -1, -1), new Among("onn", -1, -1), new Among("ett", -1, -1)};
    private static final char[] g_v = {17, 'A', 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 130, DeviceInfoUtil.FLAVOR_TYPE_G, '\b', 5};
    private static final char[] g_keep_with_s = {1, 'A', 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128};

    private boolean r_R1() {
        return this.I_p1 <= this.cursor;
    }

    private boolean r_R2() {
        return this.I_p2 <= this.cursor;
    }

    private boolean r_RV() {
        return this.I_pV <= this.cursor;
    }

    private boolean r_i_verb_suffix() {
        int i = this.cursor;
        int i2 = this.I_pV;
        if (i < i2) {
            return false;
        }
        int i4 = this.limit_backward;
        this.limit_backward = i2;
        this.ket = i;
        if (find_among_b(a_5) == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        int i6 = this.limit - i5;
        if (eq_s_b("H")) {
            this.limit_backward = i4;
            return false;
        }
        this.cursor = this.limit - i6;
        if (!out_grouping_b(g_v, 97, 251)) {
            this.limit_backward = i4;
            return false;
        }
        slice_del();
        this.limit_backward = i4;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_mark_regions() {
        int i;
        int i2;
        int i4 = this.limit;
        this.I_pV = i4;
        this.I_p1 = i4;
        this.I_p2 = i4;
        int i5 = this.cursor;
        char[] cArr = g_v;
        if (!in_grouping(cArr, 97, 251) || !in_grouping(cArr, 97, 251) || (i2 = this.cursor) >= this.limit) {
            this.cursor = i5;
            if (find_among(a_0) == 0) {
                this.cursor = i5;
                if (i5 < this.limit) {
                    this.cursor = i5 + 1;
                    while (!in_grouping(g_v, 97, 251)) {
                        int i6 = this.cursor;
                        if (i6 >= this.limit) {
                            break;
                        }
                        this.cursor = i6 + 1;
                    }
                }
            }
            this.cursor = i5;
            while (true) {
                if (!in_grouping(g_v, 97, 251)) {
                    while (true) {
                        if (out_grouping(g_v, 97, 251)) {
                            this.I_p1 = this.cursor;
                            while (true) {
                                if (in_grouping(g_v, 97, 251)) {
                                    while (true) {
                                        if (out_grouping(g_v, 97, 251)) {
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
                    i = this.cursor;
                    if (i >= this.limit) {
                        break;
                    }
                    this.cursor = i + 1;
                }
            }
            this.cursor = i5;
            return true;
        }
        this.cursor = i2 + 1;
        this.I_pV = this.cursor;
        this.cursor = i5;
        while (true) {
            if (!in_grouping(g_v, 97, 251)) {
            }
            this.cursor = i + 1;
        }
        this.cursor = i5;
        return true;
    }

    private boolean r_postlude() {
        while (true) {
            int i = this.cursor;
            this.bra = i;
            int iFind_among = find_among(a_1);
            int i2 = this.cursor;
            this.ket = i2;
            switch (iFind_among) {
                case 1:
                    slice_from("i");
                    break;
                case 2:
                    slice_from(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE);
                    break;
                case 3:
                    slice_from("y");
                    break;
                case 4:
                    slice_from("ë");
                    break;
                case 5:
                    slice_from("ï");
                    break;
                case 6:
                    slice_del();
                    break;
                case 7:
                    if (i2 >= this.limit) {
                        this.cursor = i;
                        return true;
                    }
                    this.cursor = i2 + 1;
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_prelude() {
        int i;
        while (true) {
            int i2 = this.cursor;
            while (true) {
                i = this.cursor;
                char[] cArr = g_v;
                if (!in_grouping(cArr, 97, 251)) {
                    this.cursor = i;
                    this.bra = i;
                    if (!eq_s("ë")) {
                        this.cursor = i;
                        this.bra = i;
                        if (!eq_s("ï")) {
                            this.cursor = i;
                            this.bra = i;
                            if (eq_s("y")) {
                                this.ket = this.cursor;
                                if (in_grouping(cArr, 97, 251)) {
                                    slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                                    break;
                                }
                            } else {
                                this.cursor = i;
                                if (eq_s(JWKParameterNames.RSA_SECOND_PRIME_FACTOR)) {
                                    this.bra = this.cursor;
                                    if (eq_s(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                                        this.ket = this.cursor;
                                        slice_from("U");
                                        break;
                                    }
                                }
                                this.cursor = i;
                                if (i >= this.limit) {
                                    this.cursor = i2;
                                    return true;
                                }
                                this.cursor = i + 1;
                            }
                        } else {
                            this.ket = this.cursor;
                            slice_from(HWToolbarSAConstants.DETAIL_MARKER_PEN);
                            break;
                        }
                    } else {
                        this.ket = this.cursor;
                        slice_from("He");
                        break;
                    }
                } else {
                    int i4 = this.cursor;
                    this.bra = i4;
                    if (!eq_s(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                        this.cursor = i4;
                        if (!eq_s("i")) {
                            this.cursor = i4;
                            if (eq_s("y")) {
                                this.ket = this.cursor;
                                slice_from(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY);
                                break;
                            }
                        } else {
                            this.ket = this.cursor;
                            if (in_grouping(cArr, 97, 251)) {
                                slice_from("I");
                                break;
                            }
                        }
                    } else {
                        this.ket = this.cursor;
                        if (in_grouping(cArr, 97, 251)) {
                            slice_from("U");
                            break;
                        }
                    }
                }
            }
            this.cursor = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean r_residual_suffix() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (eq_s_b("s")) {
            int i5 = this.cursor;
            this.bra = i5;
            int i6 = this.limit;
            int i7 = i6 - i5;
            int i8 = i6 - i5;
            if (!eq_s_b(HWToolbarSAConstants.DETAIL_MARKER_PEN)) {
                this.cursor = this.limit - i8;
                if (out_grouping_b(g_keep_with_s, 97, JPEG.APP8)) {
                    this.cursor = this.limit - i7;
                    slice_del();
                } else {
                    this.cursor = this.limit - i4;
                }
            }
        } else {
            this.cursor = this.limit - i4;
        }
        int i9 = this.cursor;
        int i10 = this.I_pV;
        if (i9 < i10) {
            return false;
        }
        int i11 = this.limit_backward;
        this.limit_backward = i10;
        this.ket = i9;
        int iFind_among_b = find_among_b(a_7);
        if (iFind_among_b == 0) {
            this.limit_backward = i11;
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                slice_from("i");
            } else if (iFind_among_b == 3) {
                slice_del();
            }
        } else {
            if (!r_R2()) {
                this.limit_backward = i11;
                return false;
            }
            int i12 = this.limit - this.cursor;
            if (!eq_s_b("s")) {
                this.cursor = this.limit - i12;
                if (!eq_s_b("t")) {
                    this.limit_backward = i11;
                    return false;
                }
            }
            slice_del();
        }
        this.limit_backward = i11;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean r_standard_suffix() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            return false;
        }
        int i = this.cursor;
        this.bra = i;
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
                int i2 = this.limit;
                int i4 = this.cursor;
                int i5 = i2 - i4;
                this.ket = i4;
                if (eq_s_b("ic")) {
                    int i6 = this.cursor;
                    this.bra = i6;
                    int i7 = this.limit - i6;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i7;
                        slice_from("iqU");
                    }
                } else {
                    this.cursor = this.limit - i5;
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
                slice_from("ent");
                return true;
            case 6:
                if (!r_RV()) {
                    return false;
                }
                slice_del();
                int i8 = this.limit;
                int i9 = this.cursor;
                int i10 = i8 - i9;
                this.ket = i9;
                int iFind_among_b2 = find_among_b(a_2);
                if (iFind_among_b2 == 0) {
                    this.cursor = this.limit - i10;
                } else {
                    int i11 = this.cursor;
                    this.bra = i11;
                    if (iFind_among_b2 != 1) {
                        if (iFind_among_b2 == 2) {
                            int i12 = this.limit - i11;
                            if (r_R2()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i12;
                                if (r_R1()) {
                                    slice_from("eux");
                                } else {
                                    this.cursor = this.limit - i10;
                                }
                            }
                        } else if (iFind_among_b2 != 3) {
                            if (iFind_among_b2 == 4) {
                                if (r_RV()) {
                                    slice_from("i");
                                } else {
                                    this.cursor = this.limit - i10;
                                }
                            }
                        } else if (r_R2()) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i10;
                        }
                    } else if (r_R2()) {
                        slice_del();
                        this.ket = this.cursor;
                        if (eq_s_b(VPathDataCmd.ArcTo)) {
                            this.bra = this.cursor;
                            if (r_R2()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i10;
                            }
                        } else {
                            this.cursor = this.limit - i10;
                        }
                    } else {
                        this.cursor = this.limit - i10;
                    }
                }
                return true;
            case 7:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i13 = this.limit;
                int i14 = this.cursor;
                int i15 = i13 - i14;
                this.ket = i14;
                int iFind_among_b3 = find_among_b(a_3);
                if (iFind_among_b3 == 0) {
                    this.cursor = this.limit - i15;
                } else {
                    int i16 = this.cursor;
                    this.bra = i16;
                    if (iFind_among_b3 == 1) {
                        int i17 = this.limit - i16;
                        if (r_R2()) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i17;
                            slice_from("abl");
                        }
                    } else if (iFind_among_b3 == 2) {
                        int i18 = this.limit - i16;
                        if (r_R2()) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i18;
                            slice_from("iqU");
                        }
                    } else if (iFind_among_b3 == 3) {
                        if (r_R2()) {
                            slice_del();
                        } else {
                            this.cursor = this.limit - i15;
                        }
                    }
                }
                return true;
            case 8:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i19 = this.limit;
                int i20 = this.cursor;
                int i21 = i19 - i20;
                this.ket = i20;
                if (eq_s_b(VPathDataCmd.ArcTo)) {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                        this.ket = this.cursor;
                        if (eq_s_b("ic")) {
                            int i22 = this.cursor;
                            this.bra = i22;
                            int i23 = this.limit - i22;
                            if (r_R2()) {
                                slice_del();
                            } else {
                                this.cursor = this.limit - i23;
                                slice_from("iqU");
                            }
                        } else {
                            this.cursor = this.limit - i21;
                        }
                    } else {
                        this.cursor = this.limit - i21;
                    }
                } else {
                    this.cursor = this.limit - i21;
                }
                return true;
            case 9:
                slice_from("eau");
                return true;
            case 10:
                if (!r_R1()) {
                    return false;
                }
                slice_from("al");
                return true;
            case 11:
                int i24 = this.limit - i;
                if (r_R2()) {
                    slice_del();
                } else {
                    this.cursor = this.limit - i24;
                    if (!r_R1()) {
                        return false;
                    }
                    slice_from("eux");
                }
                return true;
            case 12:
                if (!r_R1() || !out_grouping_b(g_v, 97, 251)) {
                    return false;
                }
                slice_del();
                return true;
            case 13:
                if (!r_RV()) {
                    return false;
                }
                slice_from("ant");
                return false;
            case 14:
                if (!r_RV()) {
                    return false;
                }
                slice_from("ent");
                return false;
            case 15:
                int i25 = this.limit - i;
                if (!in_grouping_b(g_v, 97, 251) || !r_RV()) {
                    return false;
                }
                this.cursor = this.limit - i25;
                slice_del();
                return false;
            default:
                return true;
        }
    }

    private boolean r_un_accent() {
        int i = 1;
        while (out_grouping_b(g_v, 97, 251)) {
            i--;
        }
        if (i > 0) {
            return false;
        }
        int i2 = this.cursor;
        this.ket = i2;
        int i4 = this.limit - i2;
        if (!eq_s_b("é")) {
            this.cursor = this.limit - i4;
            if (!eq_s_b("è")) {
                return false;
            }
        }
        this.bra = this.cursor;
        slice_from("e");
        return true;
    }

    private boolean r_un_double() {
        int i = this.limit - this.cursor;
        if (find_among_b(a_8) == 0) {
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

    private boolean r_verb_suffix() {
        int i = this.cursor;
        int i2 = this.I_pV;
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
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                slice_del();
            } else if (iFind_among_b == 3) {
                slice_del();
                int i5 = this.limit;
                int i6 = this.cursor;
                int i7 = i5 - i6;
                this.ket = i6;
                if (eq_s_b("e")) {
                    this.bra = this.cursor;
                    slice_del();
                } else {
                    this.cursor = this.limit - i7;
                }
            }
        } else {
            if (!r_R2()) {
                this.limit_backward = i4;
                return false;
            }
            slice_del();
        }
        this.limit_backward = i4;
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof frenchStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 990684513;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
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
            if (!r_i_verb_suffix()) {
                this.cursor = this.limit;
                if (r_verb_suffix()) {
                    int i2 = this.limit;
                    this.cursor = i2;
                    this.ket = i2;
                    if (eq_s_b(DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY)) {
                        this.bra = this.cursor;
                        slice_from("i");
                    } else {
                        this.cursor = this.limit;
                        if (eq_s_b("ç")) {
                            this.bra = this.cursor;
                            slice_from("c");
                        } else {
                            this.cursor = this.limit;
                        }
                    }
                } else {
                    this.cursor = this.limit;
                    r_residual_suffix();
                }
            }
        }
        this.cursor = this.limit;
        r_un_double();
        this.cursor = this.limit;
        r_un_accent();
        int i4 = this.limit_backward;
        this.cursor = i4;
        r_postlude();
        this.cursor = i4;
        return true;
    }
}
