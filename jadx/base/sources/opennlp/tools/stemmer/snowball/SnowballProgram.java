package opennlp.tools.stemmer.snowball;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class SnowballProgram {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SnowballProgram.class);
    protected int bra;
    protected StringBuilder current;
    protected int cursor;
    protected int ket;
    protected int limit;
    protected int limit_backward;

    public SnowballProgram() {
        this.current = new StringBuilder();
        init();
    }

    private void init() {
        this.cursor = 0;
        int length = this.current.length();
        this.limit = length;
        this.limit_backward = 0;
        this.bra = this.cursor;
        this.ket = length;
    }

    public void copy_from(SnowballProgram snowballProgram) {
        this.current = snowballProgram.current;
        this.cursor = snowballProgram.cursor;
        this.limit = snowballProgram.limit;
        this.limit_backward = snowballProgram.limit_backward;
        this.bra = snowballProgram.bra;
        this.ket = snowballProgram.ket;
    }

    public boolean eq_s(CharSequence charSequence) {
        if (this.limit - this.cursor < charSequence.length()) {
            return false;
        }
        for (int i = 0; i != charSequence.length(); i++) {
            if (this.current.charAt(this.cursor + i) != charSequence.charAt(i)) {
                return false;
            }
        }
        this.cursor = charSequence.length() + this.cursor;
        return true;
    }

    public boolean eq_s_b(CharSequence charSequence) {
        if (this.cursor - this.limit_backward < charSequence.length()) {
            return false;
        }
        for (int i = 0; i != charSequence.length(); i++) {
            if (this.current.charAt((this.cursor - charSequence.length()) + i) != charSequence.charAt(i)) {
                return false;
            }
        }
        this.cursor -= charSequence.length();
        return true;
    }

    public int find_among(Among[] amongArr) {
        boolean zEquals;
        int length = amongArr.length;
        int i = this.cursor;
        int i2 = this.limit;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (true) {
            int i7 = ((length - i4) >> 1) + i4;
            int i8 = i5 < i6 ? i5 : i6;
            Among among = amongArr[i7];
            int i9 = i8;
            int iCharAt = 0;
            while (true) {
                if (i8 >= among.f9693s.length) {
                    break;
                }
                int i10 = i + i9;
                if (i10 == i2) {
                    iCharAt = -1;
                    break;
                }
                iCharAt = this.current.charAt(i10) - among.f9693s[i8];
                if (iCharAt != 0) {
                    break;
                }
                i9++;
                i8++;
            }
            if (iCharAt < 0) {
                length = i7;
                i6 = i9;
            } else {
                i4 = i7;
                i5 = i9;
            }
            if (length - i4 <= 1) {
                if (i4 > 0 || length == i4 || z) {
                    break;
                }
                z = true;
            }
        }
        do {
            Among among2 = amongArr[i4];
            char[] cArr = among2.f9693s;
            if (i5 >= cArr.length) {
                this.cursor = cArr.length + i;
                Method method = among2.method;
                if (method == null) {
                    return among2.result;
                }
                try {
                    zEquals = method.invoke(this, null).toString().equals("true");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.warn(e.getLocalizedMessage(), e);
                    zEquals = false;
                }
                this.cursor = among2.f9693s.length + i;
                if (zEquals) {
                    return among2.result;
                }
            }
            i4 = among2.substring_i;
        } while (i4 >= 0);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int find_among_b(Among[] amongArr) {
        int i;
        ?? Equals;
        int length = amongArr.length;
        int i2 = this.cursor;
        int i4 = this.limit_backward;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        while (true) {
            int i8 = ((length - i5) >> 1) + i5;
            int i9 = i6 < i7 ? i6 : i7;
            Among among = amongArr[i8];
            int length2 = (among.f9693s.length - 1) - i9;
            int iCharAt = 0;
            while (true) {
                if (length2 < 0) {
                    break;
                }
                if (i2 - i9 == i4) {
                    iCharAt = -1;
                    break;
                }
                i = 0;
                iCharAt = this.current.charAt((i2 - 1) - i9) - among.f9693s[length2];
                if (iCharAt != 0) {
                    break;
                }
                i9++;
                length2--;
            }
            if (iCharAt < 0) {
                length = i8;
                i7 = i9;
            } else {
                i5 = i8;
                i6 = i9;
            }
            if (length - i5 <= 1) {
                if (i5 > 0 || length == i5 || z) {
                    break;
                }
                z = true;
            }
        }
        do {
            Among among2 = amongArr[i5];
            char[] cArr = among2.f9693s;
            if (i6 >= cArr.length) {
                this.cursor = i2 - cArr.length;
                Method method = among2.method;
                if (method == null) {
                    return among2.result;
                }
                try {
                    Equals = method.invoke(this, null).toString().equals("true");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.warn("Triggered by {}. Exception: {}", this.current, e.getLocalizedMessage(), e);
                    Equals = i;
                }
                this.cursor = i2 - among2.f9693s.length;
                if (Equals != 0) {
                    return among2.result;
                }
            }
            i5 = among2.substring_i;
        } while (i5 >= 0);
        return i;
    }

    public String getCurrent() {
        return this.current.toString();
    }

    public boolean in_grouping(char[] cArr, int i, int i2) {
        char cCharAt;
        int i4 = this.cursor;
        if (i4 >= this.limit || (cCharAt = this.current.charAt(i4)) > i2 || cCharAt < i) {
            return false;
        }
        char c = (char) (cCharAt - i);
        if ((cArr[c >> 3] & (1 << (c & 7))) == 0) {
            return false;
        }
        this.cursor++;
        return true;
    }

    public boolean in_grouping_b(char[] cArr, int i, int i2) {
        char cCharAt;
        int i4 = this.cursor;
        if (i4 <= this.limit_backward || (cCharAt = this.current.charAt(i4 - 1)) > i2 || cCharAt < i) {
            return false;
        }
        char c = (char) (cCharAt - i);
        if ((cArr[c >> 3] & (1 << (c & 7))) == 0) {
            return false;
        }
        this.cursor--;
        return true;
    }

    public void insert(int i, int i2, String str) {
        int iReplace_s = replace_s(i, i2, str);
        int i4 = this.bra;
        if (i <= i4) {
            this.bra = i4 + iReplace_s;
        }
        int i5 = this.ket;
        if (i <= i5) {
            this.ket = i5 + iReplace_s;
        }
    }

    public boolean out_grouping(char[] cArr, int i, int i2) {
        int i4 = this.cursor;
        if (i4 >= this.limit) {
            return false;
        }
        char cCharAt = this.current.charAt(i4);
        if (cCharAt > i2 || cCharAt < i) {
            this.cursor++;
            return true;
        }
        char c = (char) (cCharAt - i);
        if ((cArr[c >> 3] & (1 << (c & 7))) != 0) {
            return false;
        }
        this.cursor++;
        return true;
    }

    public boolean out_grouping_b(char[] cArr, int i, int i2) {
        int i4 = this.cursor;
        if (i4 <= this.limit_backward) {
            return false;
        }
        char cCharAt = this.current.charAt(i4 - 1);
        if (cCharAt > i2 || cCharAt < i) {
            this.cursor--;
            return true;
        }
        char c = (char) (cCharAt - i);
        if ((cArr[c >> 3] & (1 << (c & 7))) != 0) {
            return false;
        }
        this.cursor--;
        return true;
    }

    public int replace_s(int i, int i2, String str) {
        int length = str.length() - (i2 - i);
        this.current.replace(i, i2, str);
        this.limit += length;
        int i4 = this.cursor;
        if (i4 >= i2) {
            this.cursor = i4 + length;
            return length;
        }
        if (i4 > i) {
            this.cursor = i;
        }
        return length;
    }

    public void setCurrent(String str) {
        this.current = new StringBuilder(str);
        init();
    }

    public void slice_check() {
        int i;
        int i2;
        int i4 = this.bra;
        if (i4 < 0 || i4 > (i = this.ket) || i > (i2 = this.limit) || i2 > this.current.length()) {
            logger.error("faulty slice operation");
        }
    }

    public void slice_del() {
        slice_from("");
    }

    public void slice_from(String str) {
        slice_check();
        replace_s(this.bra, this.ket, str);
    }

    public void slice_to(StringBuilder sb) {
        slice_check();
        sb.replace(0, sb.length(), this.current.substring(this.bra, this.ket));
    }

    public void slice_from(CharSequence charSequence) {
        slice_from(charSequence.toString());
    }

    public SnowballProgram(SnowballProgram snowballProgram) {
        this.current = snowballProgram.current;
        this.cursor = snowballProgram.cursor;
        this.limit = snowballProgram.limit;
        this.limit_backward = snowballProgram.limit_backward;
        this.bra = snowballProgram.bra;
        this.ket = snowballProgram.ket;
    }

    public void insert(int i, int i2, CharSequence charSequence) {
        insert(i, i2, charSequence.toString());
    }
}
