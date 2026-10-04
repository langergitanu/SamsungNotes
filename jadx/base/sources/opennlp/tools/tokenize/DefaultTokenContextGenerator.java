package opennlp.tools.tokenize;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import opennlp.tools.util.StringUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultTokenContextGenerator implements TokenContextGenerator {
    protected final Set<String> inducedAbbreviations;

    public DefaultTokenContextGenerator() {
        this(Collections.EMPTY_SET);
    }

    public void addCharPreds(String str, char c, List<String> list) {
        list.add(str + MarketingConstants.REFERRER_DELIMITER_U003D + c);
        if (Character.isLetter(c)) {
            list.add(str + "_alpha");
            if (Character.isUpperCase(c)) {
                list.add(str + "_caps");
                return;
            }
            return;
        }
        if (Character.isDigit(c)) {
            list.add(str + "_num");
            return;
        }
        if (StringUtil.isWhitespace(c)) {
            list.add(str + "_ws");
            return;
        }
        if (c == '.' || c == '?' || c == '!') {
            list.add(str + "_eos");
            return;
        }
        if (c == '`' || c == '\"' || c == '\'') {
            list.add(str + "_quote");
            return;
        }
        if (c == '[' || c == '{' || c == '(') {
            list.add(str + "_lp");
            return;
        }
        if (c == ']' || c == '}' || c == ')') {
            list.add(str + "_rp");
        }
    }

    public List<String> createContext(String str, int i) {
        ArrayList arrayList = new ArrayList();
        String strSubstring = str.substring(0, i);
        String strSubstring2 = str.substring(i);
        arrayList.add("p=" + strSubstring);
        arrayList.add("s=" + strSubstring2);
        if (i > 0) {
            int i2 = i - 1;
            addCharPreds("p1", str.charAt(i2), arrayList);
            if (i > 1) {
                int i4 = i - 2;
                addCharPreds("p2", str.charAt(i4), arrayList);
                arrayList.add("p21=" + str.charAt(i4) + str.charAt(i2));
            } else {
                arrayList.add("p2=bok");
            }
            arrayList.add("p1f1=" + str.charAt(i2) + str.charAt(i));
        } else {
            arrayList.add("p1=bok");
        }
        addCharPreds("f1", str.charAt(i), arrayList);
        int i5 = i + 1;
        if (i5 < str.length()) {
            addCharPreds("f2", str.charAt(i5), arrayList);
            arrayList.add("f12=" + str.charAt(i) + str.charAt(i5));
        } else {
            arrayList.add("f2=bok");
        }
        if (str.charAt(0) == '&' && AbstractC0000a.m4a(1, str) == ';') {
            arrayList.add(LogBuilders.Property.COUNTRY_CODE);
        }
        if (i == str.length() - 1 && this.inducedAbbreviations.contains(str)) {
            arrayList.add("pabb");
        }
        return arrayList;
    }

    @Override // opennlp.tools.tokenize.TokenContextGenerator
    public String[] getContext(String str, int i) {
        List<String> listCreateContext = createContext(str, i);
        String[] strArr = new String[listCreateContext.size()];
        listCreateContext.toArray(strArr);
        return strArr;
    }

    public DefaultTokenContextGenerator(Set<String> set) {
        this.inducedAbbreviations = set;
    }
}
