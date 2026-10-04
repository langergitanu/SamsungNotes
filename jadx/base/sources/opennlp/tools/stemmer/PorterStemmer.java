package opennlp.tools.stemmer;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PorterStemmer implements Stemmer {
    private static final int INC = 50;

    /* JADX INFO: renamed from: j */
    private int f9690j;

    /* JADX INFO: renamed from: k */
    private int f9691k;

    /* JADX INFO: renamed from: k0 */
    private int f9692k0;
    private boolean dirty = false;

    /* JADX INFO: renamed from: b */
    private char[] f9688b = new char[50];

    /* JADX INFO: renamed from: i */
    private int f9689i = 0;

    private boolean cons(int i) {
        char c = this.f9688b[i];
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return false;
        }
        return (c == 'y' && i != this.f9692k0 && cons(i - 1)) ? false : true;
    }

    private boolean cvc(int i) {
        char c;
        return (i < this.f9692k0 + 2 || !cons(i) || cons(i + (-1)) || !cons(i + (-2)) || (c = this.f9688b[i]) == 'w' || c == 'x' || c == 'y') ? false : true;
    }

    private boolean doublec(int i) {
        if (i < this.f9692k0 + 1) {
            return false;
        }
        char[] cArr = this.f9688b;
        return cArr[i] == cArr[i + (-1)] && cons(i);
    }

    private boolean ends(String str) {
        int length = str.length();
        int i = (this.f9691k - length) + 1;
        if (i < this.f9692k0) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f9688b[i + i2] != str.charAt(i2)) {
                return false;
            }
        }
        this.f9690j = this.f9691k - length;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        r0 = r0 + 1;
        r2 = r1;
     */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m14506m() {
        int i = this.f9692k0;
        while (true) {
            int i2 = 0;
            if (i > this.f9690j) {
                return 0;
            }
            if (!cons(i)) {
                while (true) {
                    i++;
                    while (i <= this.f9690j) {
                        if (cons(i)) {
                            int i4 = i + 1;
                            int i5 = i2 + 1;
                            while (i4 <= this.f9690j) {
                                if (!cons(i4)) {
                                    break;
                                }
                                i4++;
                            }
                            return i5;
                        }
                    }
                    return i2;
                }
            }
            i++;
        }
    }

    private void step1() {
        if (this.f9688b[this.f9691k] == 's') {
            if (ends("sses")) {
                this.f9691k -= 2;
            } else if (ends("ies")) {
                setto("i");
            } else {
                char[] cArr = this.f9688b;
                int i = this.f9691k;
                if (cArr[i - 1] != 's') {
                    this.f9691k = i - 1;
                }
            }
        }
        if (ends("eed")) {
            if (m14506m() > 0) {
                this.f9691k--;
                return;
            }
            return;
        }
        if ((ends("ed") || ends("ing")) && vowelinstem()) {
            this.f9691k = this.f9690j;
            if (ends(VPathDataCmd.ArcTo)) {
                setto("ate");
                return;
            }
            if (ends("bl")) {
                setto("ble");
                return;
            }
            if (ends("iz")) {
                setto("ize");
                return;
            }
            if (!doublec(this.f9691k)) {
                if (m14506m() == 1 && cvc(this.f9691k)) {
                    setto("e");
                    return;
                }
                return;
            }
            char[] cArr2 = this.f9688b;
            int i2 = this.f9691k;
            this.f9691k = i2 - 1;
            char c = cArr2[i2];
            if (c == 'l' || c == 's' || c == 'z') {
                this.f9691k = i2;
            }
        }
    }

    private void step2() {
        if (ends("y") && vowelinstem()) {
            this.f9688b[this.f9691k] = 'i';
            this.dirty = true;
        }
    }

    private void step3() {
        int i = this.f9691k;
        if (i == this.f9692k0) {
            return;
        }
        char c = this.f9688b[i - 1];
        if (c == 'a') {
            if (ends("ational")) {
                m14507r("ate");
                return;
            } else {
                if (ends("tional")) {
                    m14507r("tion");
                    return;
                }
                return;
            }
        }
        if (c == 'c') {
            if (ends("enci")) {
                m14507r("ence");
                return;
            } else {
                if (ends("anci")) {
                    m14507r("ance");
                    return;
                }
                return;
            }
        }
        if (c == 'e') {
            if (ends("izer")) {
                m14507r("ize");
                return;
            }
            return;
        }
        if (c == 'g') {
            if (ends("logi")) {
                m14507r("log");
                return;
            }
            return;
        }
        if (c == 'l') {
            if (ends("bli")) {
                m14507r("ble");
                return;
            }
            if (ends("alli")) {
                m14507r("al");
                return;
            }
            if (ends("entli")) {
                m14507r("ent");
                return;
            } else if (ends("eli")) {
                m14507r("e");
                return;
            } else {
                if (ends("ousli")) {
                    m14507r("ous");
                    return;
                }
                return;
            }
        }
        if (c == 'o') {
            if (ends("ization")) {
                m14507r("ize");
                return;
            } else if (ends("ation")) {
                m14507r("ate");
                return;
            } else {
                if (ends("ator")) {
                    m14507r("ate");
                    return;
                }
                return;
            }
        }
        if (c != 's') {
            if (c != 't') {
                return;
            }
            if (ends("aliti")) {
                m14507r("al");
                return;
            } else if (ends("iviti")) {
                m14507r("ive");
                return;
            } else {
                if (ends("biliti")) {
                    m14507r("ble");
                    return;
                }
                return;
            }
        }
        if (ends("alism")) {
            m14507r("al");
            return;
        }
        if (ends("iveness")) {
            m14507r("ive");
        } else if (ends("fulness")) {
            m14507r("ful");
        } else if (ends("ousness")) {
            m14507r("ous");
        }
    }

    private void step4() {
        char c = this.f9688b[this.f9691k];
        if (c == 'e') {
            if (ends("icate")) {
                m14507r("ic");
                return;
            } else if (ends("ative")) {
                m14507r("");
                return;
            } else {
                if (ends("alize")) {
                    m14507r("al");
                    return;
                }
                return;
            }
        }
        if (c == 'i') {
            if (ends("iciti")) {
                m14507r("ic");
            }
        } else {
            if (c != 'l') {
                if (c == 's' && ends("ness")) {
                    m14507r("");
                    return;
                }
                return;
            }
            if (ends("ical")) {
                m14507r("ic");
            } else if (ends("ful")) {
                m14507r("");
            }
        }
    }

    private void step5() {
        int i;
        char c;
        int i2 = this.f9691k;
        if (i2 == this.f9692k0) {
            return;
        }
        char c2 = this.f9688b[i2 - 1];
        if (c2 != 'a') {
            if (c2 != 'c') {
                if (c2 != 'e') {
                    if (c2 != 'i') {
                        if (c2 != 'l') {
                            if (c2 != 'z') {
                                if (c2 != 'n') {
                                    if (c2 != 'o') {
                                        switch (c2) {
                                            case 's':
                                                if (!ends("ism")) {
                                                    return;
                                                }
                                                break;
                                            case 't':
                                                if (!ends("ate") && !ends("iti")) {
                                                    return;
                                                }
                                                break;
                                            case 'u':
                                                if (!ends("ous")) {
                                                    return;
                                                }
                                                break;
                                            case 'v':
                                                if (!ends("ive")) {
                                                    return;
                                                }
                                                break;
                                            default:
                                                return;
                                        }
                                    } else if ((!ends("ion") || (i = this.f9690j) < 0 || ((c = this.f9688b[i]) != 's' && c != 't')) && !ends("ou")) {
                                        return;
                                    }
                                } else if (!ends("ant") && !ends("ement") && !ends("ment") && !ends("ent")) {
                                    return;
                                }
                            } else if (!ends("ize")) {
                                return;
                            }
                        } else if (!ends("able") && !ends("ible")) {
                            return;
                        }
                    } else if (!ends("ic")) {
                        return;
                    }
                } else if (!ends("er")) {
                    return;
                }
            } else if (!ends("ance") && !ends("ence")) {
                return;
            }
        } else if (!ends("al")) {
            return;
        }
        if (m14506m() > 1) {
            this.f9691k = this.f9690j;
        }
    }

    private void step6() {
        int iM14506m;
        int i = this.f9691k;
        this.f9690j = i;
        if (this.f9688b[i] == 'e' && ((iM14506m = m14506m()) > 1 || (iM14506m == 1 && !cvc(this.f9691k - 1)))) {
            this.f9691k--;
        }
        char[] cArr = this.f9688b;
        int i2 = this.f9691k;
        if (cArr[i2] == 'l' && doublec(i2) && m14506m() > 1) {
            this.f9691k--;
        }
    }

    private boolean vowelinstem() {
        for (int i = this.f9692k0; i <= this.f9690j; i++) {
            if (!cons(i)) {
                return true;
            }
        }
        return false;
    }

    public void add(char c) {
        char[] cArr = this.f9688b;
        int length = cArr.length;
        int i = this.f9689i;
        if (length == i) {
            char[] cArr2 = new char[i + 50];
            System.arraycopy(cArr, 0, cArr2, 0, i);
            this.f9688b = cArr2;
        }
        char[] cArr3 = this.f9688b;
        int i2 = this.f9689i;
        this.f9689i = i2 + 1;
        cArr3[i2] = c;
    }

    public char[] getResultBuffer() {
        return this.f9688b;
    }

    public int getResultLength() {
        return this.f9689i;
    }

    /* JADX INFO: renamed from: r */
    public void m14507r(String str) {
        if (m14506m() > 0) {
            setto(str);
        }
    }

    public void reset() {
        this.f9689i = 0;
        this.dirty = false;
    }

    public void setto(String str) {
        int length = str.length();
        int i = this.f9690j + 1;
        for (int i2 = 0; i2 < length; i2++) {
            this.f9688b[i + i2] = str.charAt(i2);
        }
        this.f9691k = this.f9690j + length;
        this.dirty = true;
    }

    public String stem(String str) {
        return stem(str.toCharArray(), str.length()) ? toString() : str;
    }

    public String toString() {
        return new String(this.f9688b, 0, this.f9689i);
    }

    @Override // opennlp.tools.stemmer.Stemmer
    public CharSequence stem(CharSequence charSequence) {
        return stem(charSequence.toString());
    }

    public boolean stem(char[] cArr) {
        return stem(cArr, cArr.length);
    }

    public boolean stem(char[] cArr, int i, int i2) {
        reset();
        if (this.f9688b.length < i2) {
            this.f9688b = new char[i2 - i];
        }
        System.arraycopy(cArr, i, this.f9688b, 0, i2);
        this.f9689i = i2;
        return stem(0);
    }

    public boolean stem(char[] cArr, int i) {
        return stem(cArr, 0, i);
    }

    public boolean stem() {
        return stem(0);
    }

    public boolean stem(int i) {
        int i2 = this.f9689i - 1;
        this.f9691k = i2;
        this.f9692k0 = i;
        if (i2 > i + 1) {
            step1();
            step2();
            step3();
            step4();
            step5();
            step6();
        }
        int i4 = this.f9689i;
        int i5 = this.f9691k;
        if (i4 != i5 + 1) {
            this.dirty = true;
        }
        this.f9689i = i5 + 1;
        return this.dirty;
    }
}
