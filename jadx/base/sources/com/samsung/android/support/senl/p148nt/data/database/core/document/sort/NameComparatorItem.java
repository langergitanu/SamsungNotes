package com.samsung.android.support.senl.p148nt.data.database.core.document.sort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.math.BigDecimal;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class NameComparatorItem {
    private static final String TAG = DataLogger.createTag("NameComparatorItem");
    char mChar;
    boolean mIsDigitChar;
    final int mLength;
    private final String mName;
    BigDecimal mNumber;
    int mStartIndexOfNumber = -1;
    int mEndIndexOfNumber = -1;
    int mIndex = 0;

    public NameComparatorItem(String str) {
        str = TextUtils.isEmpty(str) ? String.valueOf(CharCompanionObject.MAX_VALUE) : str;
        this.mName = str;
        this.mLength = str.length();
    }

    @Nullable
    private BigDecimal convertStringToBigDecimal(@NonNull String str, @NonNull String str2) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            String str3 = TAG;
            StringBuilder sbM781w = AbstractC0541b.m781w(str2, ", e: ");
            sbM781w.append(e.getMessage());
            DataLogger.m12303e(str3, sbM781w.toString());
            return null;
        }
    }

    public void checkCharacter() {
        int i = this.mIndex;
        char cCharAt = i < this.mLength ? this.mName.charAt(i) : (char) 0;
        this.mChar = cCharAt;
        boolean zIsDigit = Character.isDigit(cCharAt);
        this.mIsDigitChar = zIsDigit;
        if (zIsDigit) {
            if (this.mStartIndexOfNumber == -1) {
                this.mStartIndexOfNumber = this.mIndex;
            }
            this.mIndex++;
        } else if (isValidStartIndex()) {
            this.mEndIndexOfNumber = this.mIndex;
        }
    }

    public void clearIndex() {
        this.mEndIndexOfNumber = -1;
        this.mStartIndexOfNumber = -1;
    }

    public int compare(NameComparatorItem nameComparatorItem) {
        int iCompareTo;
        String strSubstring = this.mName.substring(this.mStartIndexOfNumber, this.mLength);
        this.mNumber = convertStringToBigDecimal(strSubstring, "compare this.num");
        String strSubstring2 = nameComparatorItem.mName.substring(nameComparatorItem.mStartIndexOfNumber, nameComparatorItem.mLength);
        BigDecimal bigDecimalConvertStringToBigDecimal = convertStringToBigDecimal(strSubstring2, "compare that.num");
        nameComparatorItem.mNumber = bigDecimalConvertStringToBigDecimal;
        BigDecimal bigDecimal = this.mNumber;
        return (bigDecimal == null || bigDecimalConvertStringToBigDecimal == null || (iCompareTo = bigDecimal.compareTo(bigDecimalConvertStringToBigDecimal)) == 0) ? strSubstring.compareTo(strSubstring2) : iCompareTo;
    }

    public boolean isCharacterOrEnd() {
        return !this.mIsDigitChar;
    }

    public boolean isEnd() {
        return this.mIndex >= this.mLength;
    }

    public boolean isValidStartIndex() {
        return this.mStartIndexOfNumber > -1;
    }

    public void updateNumber() {
        this.mNumber = convertStringToBigDecimal(this.mName.substring(this.mStartIndexOfNumber, this.mEndIndexOfNumber), "updateNumber");
    }
}
