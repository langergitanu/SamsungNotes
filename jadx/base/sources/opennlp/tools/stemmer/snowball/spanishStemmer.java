package opennlp.tools.stemmer.snowball;

import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class spanishStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("", -1, 6), new Among("á", 0, 1), new Among("é", 0, 2), new Among("í", 0, 3), new Among("ó", 0, 4), new Among("ú", 0, 5)};
    private static final Among[] a_1 = {new Among("la", -1, -1), new Among("sela", 0, -1), new Among("le", -1, -1), new Among("me", -1, -1), new Among("se", -1, -1), new Among("lo", -1, -1), new Among("selo", 5, -1), new Among("las", -1, -1), new Among("selas", 7, -1), new Among("les", -1, -1), new Among("los", -1, -1), new Among("selos", 10, -1), new Among("nos", -1, -1)};
    private static final Among[] a_2 = {new Among("ando", -1, 6), new Among("iendo", -1, 6), new Among("yendo", -1, 7), new Among("ándo", -1, 2), new Among("iéndo", -1, 1), new Among("ar", -1, 6), new Among("er", -1, 6), new Among("ir", -1, 6), new Among("ár", -1, 3), new Among("ér", -1, 4), new Among("ír", -1, 5)};
    private static final Among[] a_3 = {new Among("ic", -1, -1), new Among("ad", -1, -1), new Among(NetworkConfig.CLIENTS_OS, -1, -1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_4 = {new Among("able", -1, 1), new Among("ible", -1, 1), new Among("ante", -1, 1)};
    private static final Among[] a_5 = {new Among("ic", -1, 1), new Among("abil", -1, 1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1)};
    private static final Among[] a_6 = {new Among("ica", -1, 1), new Among("ancia", -1, 2), new Among("encia", -1, 5), new Among("adora", -1, 2), new Among("osa", -1, 1), new Among("ista", -1, 1), new Among("iva", -1, 9), new Among("anza", -1, 1), new Among("logía", -1, 3), new Among("idad", -1, 8), new Among("able", -1, 1), new Among("ible", -1, 1), new Among("ante", -1, 2), new Among("mente", -1, 7), new Among("amente", 13, 6), new Among("ación", -1, 2), new Among("ución", -1, 4), new Among("ico", -1, 1), new Among("ismo", -1, 1), new Among("oso", -1, 1), new Among("amiento", -1, 1), new Among("imiento", -1, 1), new Among("ivo", -1, 9), new Among("ador", -1, 2), new Among("icas", -1, 1), new Among("ancias", -1, 2), new Among("encias", -1, 5), new Among("adoras", -1, 2), new Among("osas", -1, 1), new Among("istas", -1, 1), new Among("ivas", -1, 9), new Among("anzas", -1, 1), new Among("logías", -1, 3), new Among("idades", -1, 8), new Among("ables", -1, 1), new Among("ibles", -1, 1), new Among("aciones", -1, 2), new Among("uciones", -1, 4), new Among("adores", -1, 2), new Among("antes", -1, 2), new Among("icos", -1, 1), new Among("ismos", -1, 1), new Among("osos", -1, 1), new Among("amientos", -1, 1), new Among("imientos", -1, 1), new Among("ivos", -1, 9)};
    private static final Among[] a_7 = {new Among("ya", -1, 1), new Among("ye", -1, 1), new Among("yan", -1, 1), new Among("yen", -1, 1), new Among("yeron", -1, 1), new Among("yendo", -1, 1), new Among("yo", -1, 1), new Among("yas", -1, 1), new Among(BooleanUtils.YES, -1, 1), new Among("yais", -1, 1), new Among("yamos", -1, 1), new Among("yó", -1, 1)};
    private static final Among[] a_8 = {new Among("aba", -1, 2), new Among("ada", -1, 2), new Among("ida", -1, 2), new Among("ara", -1, 2), new Among("iera", -1, 2), new Among("ía", -1, 2), new Among("aría", 5, 2), new Among("ería", 5, 2), new Among("iría", 5, 2), new Among("ad", -1, 2), new Among("ed", -1, 2), new Among("id", -1, 2), new Among("ase", -1, 2), new Among("iese", -1, 2), new Among("aste", -1, 2), new Among("iste", -1, 2), new Among("an", -1, 2), new Among("aban", 16, 2), new Among("aran", 16, 2), new Among("ieran", 16, 2), new Among("ían", 16, 2), new Among("arían", 20, 2), new Among("erían", 20, 2), new Among("irían", 20, 2), new Among("en", -1, 1), new Among("asen", 24, 2), new Among("iesen", 24, 2), new Among("aron", -1, 2), new Among("ieron", -1, 2), new Among("arán", -1, 2), new Among("erán", -1, 2), new Among("irán", -1, 2), new Among("ado", -1, 2), new Among("ido", -1, 2), new Among("ando", -1, 2), new Among("iendo", -1, 2), new Among("ar", -1, 2), new Among("er", -1, 2), new Among("ir", -1, 2), new Among("as", -1, 2), new Among("abas", 39, 2), new Among("adas", 39, 2), new Among("idas", 39, 2), new Among("aras", 39, 2), new Among("ieras", 39, 2), new Among("ías", 39, 2), new Among("arías", 45, 2), new Among("erías", 45, 2), new Among("irías", 45, 2), new Among(LangPackConfigConstants.LANGUAGE_CODE_ES, -1, 1), new Among("ases", 49, 2), new Among("ieses", 49, 2), new Among("abais", -1, 2), new Among("arais", -1, 2), new Among("ierais", -1, 2), new Among("íais", -1, 2), new Among("aríais", 55, 2), new Among("eríais", 55, 2), new Among("iríais", 55, 2), new Among("aseis", -1, 2), new Among("ieseis", -1, 2), new Among("asteis", -1, 2), new Among("isteis", -1, 2), new Among("áis", -1, 2), new Among("éis", -1, 1), new Among("aréis", 64, 2), new Among("eréis", 64, 2), new Among("iréis", 64, 2), new Among("ados", -1, 2), new Among("idos", -1, 2), new Among("amos", -1, 2), new Among("ábamos", 70, 2), new Among("áramos", 70, 2), new Among("iéramos", 70, 2), new Among("íamos", 70, 2), new Among("aríamos", 74, 2), new Among("eríamos", 74, 2), new Among("iríamos", 74, 2), new Among("emos", -1, 1), new Among("aremos", 78, 2), new Among("eremos", 78, 2), new Among("iremos", 78, 2), new Among("ásemos", 78, 2), new Among("iésemos", 78, 2), new Among("imos", -1, 2), new Among("arás", -1, 2), new Among("erás", -1, 2), new Among("irás", -1, 2), new Among("ís", -1, 2), new Among("ará", -1, 2), new Among("erá", -1, 2), new Among("irá", -1, 2), new Among("aré", -1, 2), new Among("eré", -1, 2), new Among("iré", -1, 2), new Among("ió", -1, 2)};
    private static final Among[] a_9 = {new Among("a", -1, 1), new Among("e", -1, 2), new Among("o", -1, 1), new Among(NetworkConfig.CLIENTS_OS, -1, 1), new Among("á", -1, 1), new Among("é", -1, 2), new Among("í", -1, 1), new Among("ó", -1, 1)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 17, 4, '\n'};
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

    private boolean r_attached_pronoun() {
        this.ket = this.cursor;
        if (find_among_b(a_1) == 0) {
            return false;
        }
        this.bra = this.cursor;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0 || !r_RV()) {
            return false;
        }
        switch (iFind_among_b) {
            case 1:
                this.bra = this.cursor;
                slice_from("iendo");
                break;
            case 2:
                this.bra = this.cursor;
                slice_from("ando");
                break;
            case 3:
                this.bra = this.cursor;
                slice_from("ar");
                break;
            case 4:
                this.bra = this.cursor;
                slice_from("er");
                break;
            case 5:
                this.bra = this.cursor;
                slice_from("ir");
                break;
            case 6:
                slice_del();
                break;
            case 7:
                if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                    slice_del();
                    break;
                }
                break;
        }
        return false;
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
        if (in_grouping(cArr2, 97, 252)) {
            int i5 = this.cursor;
            if (out_grouping(cArr2, 97, 252)) {
                while (!in_grouping(g_v, 97, 252)) {
                    int i6 = this.cursor;
                    if (i6 >= this.limit) {
                        this.cursor = i5;
                        if (!in_grouping(g_v, 97, 252)) {
                        }
                    } else {
                        this.cursor = i6 + 1;
                    }
                }
                this.I_pV = this.cursor;
            } else {
                this.cursor = i5;
                if (!in_grouping(g_v, 97, 252)) {
                    while (!out_grouping(g_v, 97, 252)) {
                        int i7 = this.cursor;
                        if (i7 >= this.limit) {
                            this.cursor = i4;
                            cArr = g_v;
                            if (out_grouping(cArr, 97, 252)) {
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
            if (out_grouping(cArr, 97, 252)) {
                int i8 = this.cursor;
                if (out_grouping(cArr, 97, 252)) {
                    while (!in_grouping(g_v, 97, 252)) {
                        int i9 = this.cursor;
                        if (i9 >= this.limit) {
                            this.cursor = i8;
                            if (in_grouping(g_v, 97, 252)) {
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
                    if (in_grouping(g_v, 97, 252) && (i = this.cursor) < this.limit) {
                        this.cursor = i + 1;
                        this.I_pV = this.cursor;
                    }
                }
            }
        }
        this.cursor = i4;
        while (true) {
            if (in_grouping(g_v, 97, 252)) {
                while (true) {
                    if (out_grouping(g_v, 97, 252)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 252)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 252)) {
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
            int iFind_among = find_among(a_0);
            int i2 = this.cursor;
            this.ket = i2;
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
                    if (i2 >= this.limit) {
                        this.cursor = i;
                        return true;
                    }
                    this.cursor = i2 + 1;
                    break;
            }
        }
    }

    private boolean r_residual_suffix() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_9);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                if (!r_RV()) {
                    return false;
                }
                slice_del();
                int i = this.limit;
                int i2 = this.cursor;
                int i4 = i - i2;
                this.ket = i2;
                if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                    int i5 = this.cursor;
                    this.bra = i5;
                    int i6 = this.limit - i5;
                    if (eq_s_b("g")) {
                        this.cursor = this.limit - i6;
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
            }
        } else {
            if (!r_RV()) {
                return false;
            }
            slice_del();
        }
        return true;
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
                if (!r_R1()) {
                    return false;
                }
                slice_del();
                int i5 = this.limit;
                int i6 = this.cursor;
                int i7 = i5 - i6;
                this.ket = i6;
                int iFind_among_b2 = find_among_b(a_3);
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
                if (find_among_b(a_5) == 0) {
                    this.cursor = this.limit - i13;
                } else {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i13;
                    }
                }
                return true;
            case 9:
                if (!r_R2()) {
                    return false;
                }
                slice_del();
                int i14 = this.limit;
                int i15 = this.cursor;
                int i16 = i14 - i15;
                this.ket = i15;
                if (eq_s_b(VPathDataCmd.ArcTo)) {
                    this.bra = this.cursor;
                    if (r_R2()) {
                        slice_del();
                    } else {
                        this.cursor = this.limit - i16;
                    }
                } else {
                    this.cursor = this.limit - i16;
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
        int iFind_among_b = find_among_b(a_8);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        this.limit_backward = i4;
        if (iFind_among_b == 1) {
            int i6 = this.limit - i5;
            if (eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                int i7 = this.limit - this.cursor;
                if (eq_s_b("g")) {
                    this.cursor = this.limit - i7;
                } else {
                    this.cursor = this.limit - i6;
                }
            } else {
                this.cursor = this.limit - i6;
            }
            this.bra = this.cursor;
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_del();
        }
        return true;
    }

    private boolean r_y_verb_suffix() {
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
        this.limit_backward = i4;
        if (!eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
            return false;
        }
        slice_del();
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof spanishStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -2003097037;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_attached_pronoun();
        this.cursor = this.limit;
        if (!r_standard_suffix()) {
            this.cursor = this.limit;
            if (!r_y_verb_suffix()) {
                this.cursor = this.limit;
                r_verb_suffix();
            }
        }
        this.cursor = this.limit;
        r_residual_suffix();
        int i = this.limit_backward;
        this.cursor = i;
        r_postlude();
        this.cursor = i;
        return true;
    }
}
