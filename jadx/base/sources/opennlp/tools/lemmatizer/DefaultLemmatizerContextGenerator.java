package opennlp.tools.lemmatizer;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultLemmatizerContextGenerator implements LemmatizerContextGenerator {
    private static final Pattern PATTERN_HAS_CAP = Pattern.compile("[A-Z]");
    private static final Pattern PATTERN_HAS_NUM = Pattern.compile("[0-9]");
    private static final int PREFIX_LENGTH = 5;
    private static final int SUFFIX_LENGTH = 7;

    public static String[] getPrefixes(String str) {
        String[] strArr = new String[5];
        int i = 1;
        while (i < 5) {
            int i2 = i + 1;
            strArr[i] = str.substring(0, StrictMath.min(i2, str.length()));
            i = i2;
        }
        return strArr;
    }

    public static String[] getSuffixes(String str) {
        String[] strArr = new String[7];
        for (int i = 1; i < 7; i++) {
            strArr[i] = str.substring(StrictMath.max((str.length() - i) - 1, 0));
        }
        return strArr;
    }

    @Override // opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, Object[] objArr) {
        return getContext(i, strArr, (String[]) objArr[0], strArr2);
    }

    @Override // opennlp.tools.lemmatizer.LemmatizerContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, String[] strArr3) {
        String strM772n;
        String str = strArr[i];
        if (i < 1) {
            strM772n = "p_1=bos";
        } else {
            strM772n = AbstractC0541b.m772n("p_1=", strArr3[i - 1]);
        }
        String strM772n2 = AbstractC0541b.m772n("w0=", strArr[i]);
        String strM772n3 = AbstractC0541b.m772n("t0=", strArr2[i]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(strM772n2);
        arrayList.add(strM772n3);
        arrayList.add(strM772n);
        arrayList.add(strM772n + strM772n3);
        arrayList.add(strM772n + strM772n2);
        String[] suffixes = getSuffixes(str);
        int length = suffixes.length;
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add("suf=" + suffixes[i2]);
        }
        for (String str2 : getPrefixes(str)) {
            arrayList.add("pre=" + str2);
        }
        if (str.indexOf(45) != -1) {
            arrayList.add("h");
        }
        if (PATTERN_HAS_CAP.matcher(str).find()) {
            arrayList.add("c");
        }
        if (PATTERN_HAS_NUM.matcher(str).find()) {
            arrayList.add("d");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
