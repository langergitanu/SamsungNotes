package opennlp.tools.sentdetect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultSDContextGenerator implements SDContextGenerator {
    protected final StringBuffer buf;
    protected final List<String> collectFeats;
    private final Set<Character> eosCharacters;
    private final Set<String> inducedAbbreviations;

    public DefaultSDContextGenerator(char[] cArr) {
        this(Collections.EMPTY_SET, cArr);
    }

    private static String escapeChar(Character ch) {
        return ch.charValue() == '\n' ? "<LF>" : ch.charValue() == '\r' ? "<CR>" : new String(new char[]{ch.charValue()});
    }

    private static boolean isFirstUpper(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    private static int nextSpaceIndex(CharSequence charSequence, int i, int i2) {
        do {
            i++;
            if (i >= i2) {
                return i2;
            }
        } while (!StringUtil.isWhitespace(charSequence.charAt(i)));
        while (true) {
            int i4 = i + 1;
            if (charSequence.length() <= i4 || !StringUtil.isWhitespace(charSequence.charAt(i4))) {
                break;
            }
            i = i4;
        }
        return i;
    }

    private static int previousSpaceIndex(CharSequence charSequence, int i) {
        do {
            i--;
            if (i <= 0) {
                break;
            }
        } while (!StringUtil.isWhitespace(charSequence.charAt(i)));
        if (i <= 0 || !StringUtil.isWhitespace(charSequence.charAt(i))) {
            return 0;
        }
        while (i > 0 && StringUtil.isWhitespace(charSequence.charAt(i - 1))) {
            i--;
        }
        return i;
    }

    public void collectFeatures(String str, String str2, String str3, String str4, Character ch) {
        this.buf.append("x=");
        this.buf.append(str);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        if (!str.isEmpty()) {
            this.collectFeats.add(Integer.toString(str.length()));
            if (isFirstUpper(str)) {
                this.collectFeats.add("xcap");
            }
            if (ch != null) {
                if (this.inducedAbbreviations.contains(str + ch)) {
                    this.collectFeats.add("xabbrev");
                }
            }
        }
        this.buf.append("v=");
        this.buf.append(str3);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        if (!str3.isEmpty()) {
            if (isFirstUpper(str3)) {
                this.collectFeats.add("vcap");
            }
            if (this.inducedAbbreviations.contains(str3)) {
                this.collectFeats.add("vabbrev");
            }
        }
        this.buf.append("s=");
        this.buf.append(str2);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        if (!str2.isEmpty()) {
            if (isFirstUpper(str2)) {
                this.collectFeats.add("scap");
            }
            if (this.inducedAbbreviations.contains(str2)) {
                this.collectFeats.add("sabbrev");
            }
        }
        this.buf.append("n=");
        this.buf.append(str4);
        this.collectFeats.add(this.buf.toString());
        this.buf.setLength(0);
        if (str4.isEmpty()) {
            return;
        }
        if (isFirstUpper(str4)) {
            this.collectFeats.add("ncap");
        }
        if (this.inducedAbbreviations.contains(str4)) {
            this.collectFeats.add("nabbrev");
        }
    }

    @Override // opennlp.tools.sentdetect.SDContextGenerator
    public String[] getContext(CharSequence charSequence, int i) {
        String strTrim;
        String str;
        int length = charSequence.length();
        int i2 = length - 1;
        if (i > 0 && StringUtil.isWhitespace(charSequence.charAt(i - 1))) {
            this.collectFeats.add("sp");
        }
        if (i < i2 && StringUtil.isWhitespace(charSequence.charAt(i + 1))) {
            this.collectFeats.add("sn");
        }
        AbstractC12991c.m13977A("eos=", escapeChar(Character.valueOf(charSequence.charAt(i))), this.collectFeats);
        int iPreviousSpaceIndex = previousSpaceIndex(charSequence, i);
        int i4 = i;
        while (true) {
            int i5 = i4 - 1;
            if (i5 <= iPreviousSpaceIndex) {
                break;
            }
            if (this.eosCharacters.contains(Character.valueOf(charSequence.charAt(i5)))) {
                iPreviousSpaceIndex = i5;
            } else {
                i4 = i5;
            }
        }
        String strTrim2 = String.valueOf(charSequence.subSequence(iPreviousSpaceIndex, i)).trim();
        String strTrim3 = String.valueOf(charSequence.subSequence(previousSpaceIndex(charSequence, iPreviousSpaceIndex), iPreviousSpaceIndex)).trim();
        int iNextSpaceIndex = nextSpaceIndex(charSequence, i, i2);
        int i6 = i;
        while (true) {
            int i7 = i6 + 1;
            if (i7 >= iNextSpaceIndex) {
                break;
            }
            if (this.eosCharacters.contains(Character.valueOf(charSequence.charAt(i7)))) {
                iNextSpaceIndex = i7;
            } else {
                i6 = i7;
            }
        }
        int i8 = iNextSpaceIndex + 1;
        int iNextSpaceIndex2 = nextSpaceIndex(charSequence, i8, length);
        if (i == i2) {
            str = "";
            strTrim = str;
        } else {
            String strTrim4 = String.valueOf(charSequence.subSequence(i + 1, iNextSpaceIndex)).trim();
            strTrim = String.valueOf(charSequence.subSequence(i8, iNextSpaceIndex2)).trim();
            str = strTrim4;
        }
        collectFeatures(strTrim2, str, strTrim3, strTrim, Character.valueOf(charSequence.charAt(i)));
        String[] strArr = (String[]) this.collectFeats.toArray(new String[this.collectFeats.size()]);
        this.collectFeats.clear();
        return strArr;
    }

    public DefaultSDContextGenerator(Set<String> set, char[] cArr) {
        this.inducedAbbreviations = set;
        this.eosCharacters = new HashSet();
        for (char c : cArr) {
            this.eosCharacters.add(Character.valueOf(c));
        }
        this.buf = new StringBuffer();
        this.collectFeats = new ArrayList();
    }
}
