package opennlp.tools.postag;

import java.util.ArrayList;
import java.util.regex.Pattern;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.util.Cache;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultPOSContextGenerator implements POSContextGenerator {
    private static final int PREFIX_LENGTH = 4;
    private static final int SUFFIX_LENGTH = 4;
    private static final Pattern hasCap = Pattern.compile("[A-Z]");
    private static final Pattern hasNum = Pattern.compile("[0-9]");

    /* JADX INFO: renamed from: SB */
    protected final String f9683SB;

    /* JADX INFO: renamed from: SE */
    protected final String f9684SE;
    private Cache<String, String[]> contextsCache;
    private final Dictionary dict;
    private Object wordsKey;

    public DefaultPOSContextGenerator(Dictionary dictionary) {
        this(0, dictionary);
    }

    public static String[] getPrefixes(String str) {
        String[] strArr = new String[4];
        int i = 0;
        while (i < 4) {
            int i2 = i + 1;
            strArr[i] = str.substring(0, StrictMath.min(i2, str.length()));
            i = i2;
        }
        return strArr;
    }

    public static String[] getSuffixes(String str) {
        String[] strArr = new String[4];
        for (int i = 0; i < 4; i++) {
            strArr[i] = str.substring(StrictMath.max((str.length() - i) - 1, 0));
        }
        return strArr;
    }

    public DefaultPOSContextGenerator(int i, Dictionary dictionary) {
        this.f9684SE = "*SE*";
        this.f9683SB = "*SB*";
        this.dict = dictionary;
        if (i > 0) {
            this.contextsCache = new Cache<>(i);
        }
    }

    @Override // opennlp.tools.postag.POSContextGenerator, opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, Object[] objArr) {
        return getContext(i, strArr, strArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String[] getContext(int i, Object[] objArr, String[] strArr) {
        String string;
        String string2;
        String str;
        String string3;
        String str2;
        String string4 = objArr[i].toString();
        int i2 = i + 1;
        string = "*SE*";
        String str3 = null;
        if (objArr.length > i2) {
            int i4 = i + 2;
            string = objArr[i2].toString();
            string2 = objArr.length > i4 ? objArr[i4].toString() : "*SE*";
        } else {
            string2 = null;
        }
        int i5 = i - 1;
        if (i5 < 0) {
            str = null;
            string3 = "*SB*";
            str2 = null;
        } else {
            string3 = objArr[i5].toString();
            String str4 = strArr[i5];
            int i6 = i - 2;
            if (i6 < 0) {
                str3 = str4;
                str = "*SB*";
                str2 = null;
            } else {
                String string5 = objArr[i6].toString();
                str2 = strArr[i6];
                str3 = str4;
                str = string5;
            }
        }
        String str5 = i + str3 + str2;
        Cache<String, String[]> cache = this.contextsCache;
        if (cache != null) {
            if (this.wordsKey == objArr) {
                String[] strArr2 = cache.get(str5);
                if (strArr2 != null) {
                    return strArr2;
                }
            } else {
                cache.clear();
                this.wordsKey = objArr;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("default");
        arrayList.add("w=" + string4);
        Dictionary dictionary = this.dict;
        if (dictionary == null || !dictionary.contains(new StringList(string4))) {
            for (String str6 : getSuffixes(string4)) {
                arrayList.add("suf=" + str6);
            }
            for (String str7 : getPrefixes(string4)) {
                arrayList.add("pre=" + str7);
            }
            if (string4.indexOf(45) != -1) {
                arrayList.add("h");
            }
            if (hasCap.matcher(string4).find()) {
                arrayList.add("c");
            }
            if (hasNum.matcher(string4).find()) {
                arrayList.add("d");
            }
        }
        if (string3 != null) {
            arrayList.add("p=".concat(string3));
            if (str3 != null) {
                arrayList.add("t=".concat(str3));
            }
            if (str != null) {
                arrayList.add("pp=".concat(str));
                if (str2 != null) {
                    arrayList.add("t2=" + str2 + "," + str3);
                }
            }
        }
        if (string != null) {
            arrayList.add("n=".concat(string));
            if (string2 != null) {
                arrayList.add("nn=".concat(string2));
            }
        }
        String[] strArr3 = (String[]) arrayList.toArray(new String[0]);
        Cache<String, String[]> cache2 = this.contextsCache;
        if (cache2 != null) {
            cache2.put(str5, strArr3);
        }
        return strArr3;
    }
}
