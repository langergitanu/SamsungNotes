package com.samsung.android.support.senl.p148nt.data.database.core.document.sort;

import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.math.BigDecimal;
import java.text.Collator;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NameComparator implements Comparator<String> {
    private static final int MAX_LOOP_COUNT = 100;
    private static final String TAG = DataLogger.createTag("NameComparator");
    private static final Collator COLLATOR = Collator.getInstance();

    private static int compareChar(char c, char c2) {
        return COLLATOR.compare(String.valueOf(Character.toUpperCase(c)), String.valueOf(Character.toUpperCase(c2)));
    }

    private int compareToIgnoreCase(String str, String str2) {
        return COLLATOR.compare(str.toUpperCase(), str2.toUpperCase());
    }

    public int compareName(String str, String str2) {
        BigDecimal bigDecimal;
        int iCompareTo;
        String strReplaceAll = str.replaceAll("\\s+", "");
        String strReplaceAll2 = str2.replaceAll("\\s+", "");
        NameComparatorItem nameComparatorItem = new NameComparatorItem(strReplaceAll);
        NameComparatorItem nameComparatorItem2 = new NameComparatorItem(strReplaceAll2);
        int i = 0;
        while (true) {
            nameComparatorItem.checkCharacter();
            nameComparatorItem2.checkCharacter();
            if (nameComparatorItem.isEnd() && nameComparatorItem2.isEnd()) {
                boolean zIsValidStartIndex = nameComparatorItem.isValidStartIndex();
                boolean zIsValidStartIndex2 = nameComparatorItem2.isValidStartIndex();
                if (zIsValidStartIndex && zIsValidStartIndex2) {
                    return nameComparatorItem.compare(nameComparatorItem2);
                }
            } else if (nameComparatorItem.isCharacterOrEnd() && nameComparatorItem2.isCharacterOrEnd()) {
                boolean zIsValidStartIndex3 = nameComparatorItem.isValidStartIndex();
                boolean zIsValidStartIndex4 = nameComparatorItem2.isValidStartIndex();
                if (zIsValidStartIndex3 && zIsValidStartIndex4) {
                    nameComparatorItem.updateNumber();
                    nameComparatorItem2.updateNumber();
                    BigDecimal bigDecimal2 = nameComparatorItem.mNumber;
                    if (bigDecimal2 != null && (bigDecimal = nameComparatorItem2.mNumber) != null && (iCompareTo = bigDecimal2.compareTo(bigDecimal)) != 0) {
                        return iCompareTo;
                    }
                    nameComparatorItem.clearIndex();
                    nameComparatorItem2.clearIndex();
                } else {
                    if (zIsValidStartIndex3) {
                        return -1;
                    }
                    if (zIsValidStartIndex4) {
                        return 1;
                    }
                }
                int iCompareChar = compareChar(nameComparatorItem.mChar, nameComparatorItem2.mChar);
                if (iCompareChar != 0) {
                    return iCompareChar;
                }
                nameComparatorItem.mIndex++;
                nameComparatorItem2.mIndex++;
            }
            i++;
            if (i >= 100 || (nameComparatorItem.isEnd() && nameComparatorItem2.isEnd())) {
                break;
            }
        }
        if (i == 100 && (!nameComparatorItem.isEnd() || !nameComparatorItem2.isEnd())) {
            String str3 = TAG;
            DataLogger.m12309w(str3, "Illegal exit loop item1 : " + nameComparatorItem.mLength + " , " + nameComparatorItem.mIndex + " : " + DataLogger.getEncode(strReplaceAll));
            DataLogger.m12309w(str3, "Illegal exit loop item2 : " + nameComparatorItem2.mLength + " , " + nameComparatorItem2.mIndex + " : " + DataLogger.getEncode(strReplaceAll2));
        }
        return compareToIgnoreCase(str, str2);
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        return compareName(str, str2);
    }
}
