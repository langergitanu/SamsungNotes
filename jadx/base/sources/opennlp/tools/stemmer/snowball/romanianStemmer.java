package opennlp.tools.stemmer.snowball;

import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsIdToken;
import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class romanianStemmer extends AbstractSnowballStemmer {
    private static final Among[] a_0 = {new Among("ş", -1, 1), new Among("ţ", -1, 2)};
    private static final Among[] a_1 = {new Among("", -1, 3), new Among("I", 0, 1), new Among("U", 0, 2)};
    private static final Among[] a_2 = {new Among("ea", -1, 3), new Among("ația", -1, 7), new Among("aua", -1, 2), new Among("iua", -1, 4), new Among("ație", -1, 7), new Among("ele", -1, 3), new Among("ile", -1, 5), new Among("iile", 6, 4), new Among("iei", -1, 4), new Among("atei", -1, 6), new Among("ii", -1, 4), new Among("ului", -1, 1), new Among("ul", -1, 1), new Among("elor", -1, 3), new Among("ilor", -1, 4), new Among("iilor", 14, 4)};
    private static final Among[] a_3 = {new Among("icala", -1, 4), new Among("iciva", -1, 4), new Among("ativa", -1, 5), new Among("itiva", -1, 6), new Among("icale", -1, 4), new Among("ațiune", -1, 5), new Among("ițiune", -1, 6), new Among("atoare", -1, 5), new Among("itoare", -1, 6), new Among("ătoare", -1, 5), new Among("icitate", -1, 4), new Among("abilitate", -1, 1), new Among("ibilitate", -1, 2), new Among("ivitate", -1, 3), new Among("icive", -1, 4), new Among("ative", -1, 5), new Among("itive", -1, 6), new Among("icali", -1, 4), new Among("atori", -1, 5), new Among("icatori", 18, 4), new Among("itori", -1, 6), new Among("ători", -1, 5), new Among("icitati", -1, 4), new Among("abilitati", -1, 1), new Among("ivitati", -1, 3), new Among("icivi", -1, 4), new Among("ativi", -1, 5), new Among("itivi", -1, 6), new Among("icităi", -1, 4), new Among("abilităi", -1, 1), new Among("ivităi", -1, 3), new Among("icități", -1, 4), new Among("abilități", -1, 1), new Among("ivități", -1, 3), new Among("ical", -1, 4), new Among("ator", -1, 5), new Among("icator", 35, 4), new Among("itor", -1, 6), new Among("ător", -1, 5), new Among("iciv", -1, 4), new Among("ativ", -1, 5), new Among("itiv", -1, 6), new Among("icală", -1, 4), new Among("icivă", -1, 4), new Among("ativă", -1, 5), new Among("itivă", -1, 6)};
    private static final Among[] a_4 = {new Among("ica", -1, 1), new Among("abila", -1, 1), new Among("ibila", -1, 1), new Among("oasa", -1, 1), new Among("ata", -1, 1), new Among("ita", -1, 1), new Among("anta", -1, 1), new Among("ista", -1, 3), new Among("uta", -1, 1), new Among("iva", -1, 1), new Among("ic", -1, 1), new Among("ice", -1, 1), new Among("abile", -1, 1), new Among("ibile", -1, 1), new Among("isme", -1, 3), new Among("iune", -1, 2), new Among("oase", -1, 1), new Among("ate", -1, 1), new Among("itate", 17, 1), new Among("ite", -1, 1), new Among("ante", -1, 1), new Among("iste", -1, 3), new Among("ute", -1, 1), new Among("ive", -1, 1), new Among("ici", -1, 1), new Among("abili", -1, 1), new Among("ibili", -1, 1), new Among("iuni", -1, 2), new Among("atori", -1, 1), new Among("osi", -1, 1), new Among("ati", -1, 1), new Among("itati", 30, 1), new Among("iti", -1, 1), new Among("anti", -1, 1), new Among("isti", -1, 3), new Among(MicrosoftStsIdToken.UTI, -1, 1), new Among("iști", -1, 3), new Among("ivi", -1, 1), new Among("ităi", -1, 1), new Among("oși", -1, 1), new Among("ități", -1, 1), new Among("abil", -1, 1), new Among("ibil", -1, 1), new Among("ism", -1, 3), new Among("ator", -1, 1), new Among(NetworkConfig.CLIENTS_OS, -1, 1), new Among(VPathDataCmd.ArcTo, -1, 1), new Among(LangPackConfigConstants.LANGUAGE_CODE_IT, -1, 1), new Among("ant", -1, 1), new Among("ist", -1, 3), new Among("ut", -1, 1), new Among(HeaderParameterNames.INITIALIZATION_VECTOR, -1, 1), new Among("ică", -1, 1), new Among("abilă", -1, 1), new Among("ibilă", -1, 1), new Among("oasă", -1, 1), new Among("ată", -1, 1), new Among("ită", -1, 1), new Among("antă", -1, 1), new Among("istă", -1, 3), new Among("ută", -1, 1), new Among("ivă", -1, 1)};
    private static final Among[] a_5 = {new Among("ea", -1, 1), new Among("ia", -1, 1), new Among("esc", -1, 1), new Among("ăsc", -1, 1), new Among("ind", -1, 1), new Among("ând", -1, 1), new Among("are", -1, 1), new Among("ere", -1, 1), new Among("ire", -1, 1), new Among("âre", -1, 1), new Among("se", -1, 2), new Among("ase", 10, 1), new Among("sese", 10, 2), new Among("ise", 10, 1), new Among("use", 10, 1), new Among("âse", 10, 1), new Among("ește", -1, 1), new Among("ăște", -1, 1), new Among("eze", -1, 1), new Among("ai", -1, 1), new Among("eai", 19, 1), new Among("iai", 19, 1), new Among("sei", -1, 2), new Among("ești", -1, 1), new Among("ăști", -1, 1), new Among("ui", -1, 1), new Among("ezi", -1, 1), new Among("âi", -1, 1), new Among("ași", -1, 1), new Among("seși", -1, 2), new Among("aseși", 29, 1), new Among("seseși", 29, 2), new Among("iseși", 29, 1), new Among("useși", 29, 1), new Among("âseși", 29, 1), new Among("iși", -1, 1), new Among("uși", -1, 1), new Among("âși", -1, 1), new Among("ați", -1, 2), new Among("eați", 38, 1), new Among("iați", 38, 1), new Among("eți", -1, 2), new Among("iți", -1, 2), new Among("âți", -1, 2), new Among("arăți", -1, 1), new Among("serăți", -1, 2), new Among("aserăți", 45, 1), new Among("seserăți", 45, 2), new Among("iserăți", 45, 1), new Among("userăți", 45, 1), new Among("âserăți", 45, 1), new Among("irăți", -1, 1), new Among("urăți", -1, 1), new Among("ârăți", -1, 1), new Among("am", -1, 1), new Among("eam", 54, 1), new Among("iam", 54, 1), new Among("em", -1, 2), new Among("asem", 57, 1), new Among("sesem", 57, 2), new Among("isem", 57, 1), new Among("usem", 57, 1), new Among("âsem", 57, 1), new Among("im", -1, 2), new Among("âm", -1, 2), new Among("ăm", -1, 2), new Among("arăm", 65, 1), new Among("serăm", 65, 2), new Among("aserăm", 67, 1), new Among("seserăm", 67, 2), new Among("iserăm", 67, 1), new Among("userăm", 67, 1), new Among("âserăm", 67, 1), new Among("irăm", 65, 1), new Among("urăm", 65, 1), new Among("ârăm", 65, 1), new Among("au", -1, 1), new Among("eau", 76, 1), new Among("iau", 76, 1), new Among("indu", -1, 1), new Among("ându", -1, 1), new Among("ez", -1, 1), new Among("ească", -1, 1), new Among("ară", -1, 1), new Among("seră", -1, 2), new Among("aseră", 84, 1), new Among("seseră", 84, 2), new Among("iseră", 84, 1), new Among("useră", 84, 1), new Among("âseră", 84, 1), new Among("iră", -1, 1), new Among("ură", -1, 1), new Among("âră", -1, 1), new Among("ează", -1, 1)};
    private static final Among[] a_6 = {new Among("a", -1, 1), new Among("e", -1, 1), new Among("ie", 1, 1), new Among("i", -1, 1), new Among("ă", -1, 1)};
    private static final char[] g_v = {17, 'A', 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, ' ', 0, 0, 4};
    private boolean B_standard_suffix_removed;
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

    private boolean r_combo_suffix() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        int iFind_among_b = find_among_b(a_3);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        switch (iFind_among_b) {
            case 1:
                slice_from("abil");
                break;
            case 2:
                slice_from("ibil");
                break;
            case 3:
                slice_from(HeaderParameterNames.INITIALIZATION_VECTOR);
                break;
            case 4:
                slice_from("ic");
                break;
            case 5:
                slice_from(VPathDataCmd.ArcTo);
                break;
            case 6:
                slice_from(LangPackConfigConstants.LANGUAGE_CODE_IT);
                break;
        }
        this.B_standard_suffix_removed = true;
        this.cursor = this.limit - i4;
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
        if (in_grouping(cArr2, 97, 259)) {
            int i5 = this.cursor;
            if (out_grouping(cArr2, 97, 259)) {
                while (!in_grouping(g_v, 97, 259)) {
                    int i6 = this.cursor;
                    if (i6 >= this.limit) {
                        this.cursor = i5;
                        if (!in_grouping(g_v, 97, 259)) {
                        }
                    } else {
                        this.cursor = i6 + 1;
                    }
                }
                this.I_pV = this.cursor;
            } else {
                this.cursor = i5;
                if (!in_grouping(g_v, 97, 259)) {
                    while (!out_grouping(g_v, 97, 259)) {
                        int i7 = this.cursor;
                        if (i7 >= this.limit) {
                            this.cursor = i4;
                            cArr = g_v;
                            if (out_grouping(cArr, 97, 259)) {
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
            if (out_grouping(cArr, 97, 259)) {
                int i8 = this.cursor;
                if (out_grouping(cArr, 97, 259)) {
                    while (!in_grouping(g_v, 97, 259)) {
                        int i9 = this.cursor;
                        if (i9 >= this.limit) {
                            this.cursor = i8;
                            if (in_grouping(g_v, 97, 259)) {
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
                    if (in_grouping(g_v, 97, 259) && (i = this.cursor) < this.limit) {
                        this.cursor = i + 1;
                        this.I_pV = this.cursor;
                    }
                }
            }
        }
        this.cursor = i4;
        while (true) {
            if (in_grouping(g_v, 97, 259)) {
                while (true) {
                    if (out_grouping(g_v, 97, 259)) {
                        this.I_p1 = this.cursor;
                        while (true) {
                            if (in_grouping(g_v, 97, 259)) {
                                while (true) {
                                    if (out_grouping(g_v, 97, 259)) {
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

    private boolean r_norm() {
        int i = this.cursor;
        while (true) {
            int i2 = this.cursor;
            this.bra = i2;
            int iFind_among = find_among(a_0);
            if (iFind_among == 0) {
                this.cursor = i2;
                if (i2 >= this.limit) {
                    this.cursor = i;
                    return true;
                }
                this.cursor = i2 + 1;
            } else {
                this.ket = this.cursor;
                if (iFind_among == 1) {
                    slice_from("ș");
                } else if (iFind_among == 2) {
                    slice_from("ț");
                }
                this.cursor = i2;
            }
        }
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
        while (true) {
            int i2 = this.cursor;
            while (true) {
                i = this.cursor;
                char[] cArr = g_v;
                if (in_grouping(cArr, 97, 259)) {
                    int i4 = this.cursor;
                    this.bra = i4;
                    if (eq_s(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                        this.ket = this.cursor;
                        if (in_grouping(cArr, 97, 259)) {
                            slice_from("U");
                            break;
                        }
                    }
                    this.cursor = i4;
                    if (eq_s("i")) {
                        this.ket = this.cursor;
                        if (in_grouping(cArr, 97, 259)) {
                            slice_from("I");
                            break;
                        }
                    }
                }
                this.cursor = i;
                if (i >= this.limit) {
                    this.cursor = i2;
                    return true;
                }
                this.cursor = i + 1;
            }
            this.cursor = i;
        }
    }

    private boolean r_standard_suffix() {
        int i;
        this.B_standard_suffix_removed = false;
        do {
            i = this.limit - this.cursor;
        } while (r_combo_suffix());
        int i2 = this.limit - i;
        this.cursor = i2;
        this.ket = i2;
        int iFind_among_b = find_among_b(a_4);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R2()) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_del();
        } else if (iFind_among_b != 2) {
            if (iFind_among_b == 3) {
                slice_from("ist");
            }
        } else {
            if (!eq_s_b("ț")) {
                return false;
            }
            this.bra = this.cursor;
            slice_from("t");
        }
        this.B_standard_suffix_removed = true;
        return true;
    }

    private boolean r_step_0() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_R1()) {
            return false;
        }
        switch (iFind_among_b) {
            case 1:
                slice_del();
                break;
            case 2:
                slice_from("a");
                break;
            case 3:
                slice_from("e");
                break;
            case 4:
                slice_from("i");
                break;
            case 5:
                int i = this.limit - this.cursor;
                if (!eq_s_b("ab")) {
                    this.cursor = this.limit - i;
                    slice_from("i");
                }
                break;
            case 6:
                slice_from(VPathDataCmd.ArcTo);
                break;
            case 7:
                slice_from("ați");
                break;
        }
        return false;
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
        int iFind_among_b = find_among_b(a_5);
        if (iFind_among_b == 0) {
            this.limit_backward = i4;
            return false;
        }
        int i5 = this.cursor;
        this.bra = i5;
        if (iFind_among_b == 1) {
            int i6 = this.limit - i5;
            if (!out_grouping_b(g_v, 97, 259)) {
                this.cursor = this.limit - i6;
                if (!eq_s_b(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
                    this.limit_backward = i4;
                    return false;
                }
            }
            slice_del();
        } else if (iFind_among_b == 2) {
            slice_del();
        }
        this.limit_backward = i4;
        return true;
    }

    private boolean r_vowel_suffix() {
        this.ket = this.cursor;
        if (find_among_b(a_6) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (!r_RV()) {
            return false;
        }
        slice_del();
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof romanianStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -1524366238;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        r_norm();
        int i = this.cursor;
        r_prelude();
        this.cursor = i;
        r_mark_regions();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_step_0();
        this.cursor = this.limit;
        r_standard_suffix();
        int i2 = this.limit;
        this.cursor = i2;
        if (!this.B_standard_suffix_removed) {
            this.cursor = i2;
            r_verb_suffix();
        }
        this.cursor = this.limit;
        r_vowel_suffix();
        int i4 = this.limit_backward;
        this.cursor = i4;
        r_postlude();
        this.cursor = i4;
        return true;
    }
}
