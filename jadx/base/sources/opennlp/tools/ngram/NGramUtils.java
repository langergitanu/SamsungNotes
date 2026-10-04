package opennlp.tools.ngram;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static double calculateBigramMLProbability(String str, String str2, Collection<StringList> collection) {
        return calculateNgramMLProbability(new StringList(str, str2), collection);
    }

    public static double calculateBigramPriorSmoothingProbability(String str, String str2, Collection<StringList> collection, Double d) {
        return ((calculateUnigramMLProbability(str2, collection) * d.doubleValue()) + count(new StringList(str, str2), collection).doubleValue()) / ((d.doubleValue() * ((double) collection.size())) + count(new StringList(str), collection).doubleValue());
    }

    public static double calculateLaplaceSmoothingProbability(StringList stringList, Iterable<StringList> iterable, Double d) {
        return (d.doubleValue() + count(stringList, iterable).doubleValue()) / ((d.doubleValue() * 1.0d) + count(getNMinusOneTokenFirst(stringList), iterable).doubleValue());
    }

    public static double calculateMissingNgramProbabilityMass(StringList stringList, double d, Iterable<StringList> iterable) {
        double dDoubleValue = count(stringList, iterable).doubleValue();
        Iterator<String> it = flatSet(iterable).iterator();
        double dDoubleValue2 = 0.0d;
        while (it.hasNext()) {
            dDoubleValue2 += (count(getNPlusOneNgram(stringList, it.next()), iterable).doubleValue() - d) / dDoubleValue;
        }
        return 1.0d - dDoubleValue2;
    }

    public static double calculateNgramMLProbability(StringList stringList, Iterable<StringList> iterable) {
        return count(stringList, iterable).doubleValue() / count(getNMinusOneTokenFirst(stringList), iterable).doubleValue();
    }

    public static double calculateTrigramLinearInterpolationProbability(String str, String str2, String str3, Collection<StringList> collection, Double d, Double d2, Double d3) {
        return (calculateUnigramMLProbability(str3, collection) * d3.doubleValue()) + (calculateBigramMLProbability(str2, str3, collection) * d2.doubleValue()) + (calculateTrigramMLProbability(str, str2, str3, collection) * d.doubleValue());
    }

    public static double calculateTrigramMLProbability(String str, String str2, String str3, Iterable<StringList> iterable) {
        return calculateNgramMLProbability(new StringList(str, str2, str3), iterable);
    }

    public static double calculateUnigramMLProbability(String str, Collection<StringList> collection) {
        Iterator<StringList> it = collection.iterator();
        double size = 0.0d;
        while (it.hasNext()) {
            size += (double) it.next().size();
        }
        return count(new StringList(str), collection).doubleValue() / size;
    }

    private static Double count(StringList stringList, Iterable<StringList> iterable) {
        Double dValueOf = Double.valueOf(0.0d);
        for (StringList stringList2 : iterable) {
            int iIndexOf = indexOf(stringList2, stringList.getToken(0));
            if (iIndexOf >= 0 && stringList2.size() >= stringList.size() + iIndexOf) {
                boolean zEquals = true;
                for (int i = 1; i < stringList.size(); i++) {
                    zEquals &= stringList2.getToken(iIndexOf + i).equals(stringList.getToken(i));
                }
                if (zEquals) {
                    dValueOf = Double.valueOf(dValueOf.doubleValue() + 1.0d);
                }
            }
        }
        return dValueOf;
    }

    private static Collection<String> flatSet(Iterable<StringList> iterable) {
        HashSet hashSet = new HashSet();
        Iterator<StringList> it = iterable.iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = it.next().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return hashSet;
    }

    public static Collection<StringList> getNGrams(StringList stringList, int i) {
        LinkedList linkedList = new LinkedList();
        if (i == -1 || i >= stringList.size()) {
            linkedList.add(stringList);
            return linkedList;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (true) {
            if (i2 >= (stringList.size() - i) + 1) {
                return linkedList;
            }
            strArr[0] = stringList.getToken(i2);
            for (int i4 = 1; i4 < i; i4++) {
                strArr[i4] = stringList.getToken(i2 + i4);
            }
            linkedList.add(new StringList(strArr));
            i2++;
        }
    }

    public static StringList getNMinusOneTokenFirst(StringList stringList) {
        int size = stringList.size() - 1;
        String[] strArr = new String[size];
        for (int i = 0; i < stringList.size() - 1; i++) {
            strArr[i] = stringList.getToken(i);
        }
        if (size > 0) {
            return new StringList(strArr);
        }
        return null;
    }

    public static StringList getNMinusOneTokenLast(StringList stringList) {
        int size = stringList.size() - 1;
        String[] strArr = new String[size];
        for (int i = 1; i < stringList.size(); i++) {
            strArr[i - 1] = stringList.getToken(i);
        }
        if (size > 0) {
            return new StringList(strArr);
        }
        return null;
    }

    private static StringList getNPlusOneNgram(StringList stringList, String str) {
        int size = stringList.size();
        String[] strArr = new String[size + 1];
        for (int i = 0; i < stringList.size(); i++) {
            strArr[i] = stringList.getToken(i);
        }
        strArr[size] = str;
        return new StringList(strArr);
    }

    private static int indexOf(StringList stringList, String str) {
        for (int i = 0; i < stringList.size(); i++) {
            if (str.equals(stringList.getToken(i))) {
                return i;
            }
        }
        return -1;
    }

    public static Collection<String[]> getNGrams(String[] strArr, int i) {
        LinkedList linkedList = new LinkedList();
        if (i == -1 || i >= strArr.length) {
            linkedList.add(strArr);
            return linkedList;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= (strArr.length - i) + 1) {
                return linkedList;
            }
            String[] strArr2 = new String[i];
            strArr2[0] = strArr[i2];
            for (int i4 = 1; i4 < i; i4++) {
                strArr2[i4] = strArr[i2 + i4];
            }
            linkedList.add(strArr2);
            i2++;
        }
    }
}
