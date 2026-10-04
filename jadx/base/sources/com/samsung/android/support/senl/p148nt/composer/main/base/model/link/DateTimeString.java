package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class DateTimeString {
    static String mAfternoon;
    static String[] mArrDayOfWeek = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
    static String mDay01;
    static String mDay02;
    static String mDay03;
    static String mDay04;
    static String mDay05;
    static String mDay06;
    static String mDay07;
    static String mDayFormat;
    static String mEvening;
    static String mHour;
    static String mKrMorning2;
    static String mKrMorning3;
    static String mMinute;
    static String mMonth01;
    static String mMonth01_abb;
    static String mMonth02;
    static String mMonth02_abb;
    static String mMonth03;
    static String mMonth03_abb;
    static String mMonth04;
    static String mMonth04_abb;
    static String mMonth05;
    static String mMonth05_abb;
    static String mMonth06;
    static String mMonth06_abb;
    static String mMonth07;
    static String mMonth07_abb;
    static String mMonth08;
    static String mMonth08_abb;
    static String mMonth09;
    static String mMonth09_abb;
    static String mMonth10;
    static String mMonth10_abb;
    static String mMonth11;
    static String mMonth11_abb;
    static String mMonth12;
    static String mMonth12_abb;
    static ArrayList<String> mMonthAbbList;
    static ArrayList<String> mMonthList;
    static String mMorning;
    static String mNight;
    static String mTimePm;
    static String mToday;
    static String mTomorrow;
    static String mTonight;

    public static String[] extractDate(String[] strArr) {
        String[] strArr2 = new String[3];
        int i = 0;
        while (true) {
            if (i >= 2) {
                break;
            }
            if (getMonth(strArr[i]) > 0) {
                strArr2[1] = Integer.toString(getMonth(strArr[i]));
                String str = strArr[Math.abs(i - 1)];
                strArr2[2] = str;
                if (str.length() >= 3) {
                    strArr2[2] = AbstractC2322a.m1614d(2, 0, strArr2[2]);
                }
            } else {
                i++;
            }
        }
        strArr2[0] = strArr[2];
        return strArr2;
    }

    public static String getEnglishWeekDay(String str) {
        return str.equals(mDay01) ? mArrDayOfWeek[0] : str.equals(mDay02) ? mArrDayOfWeek[1] : str.equals(mDay03) ? mArrDayOfWeek[2] : str.equals(mDay04) ? mArrDayOfWeek[3] : str.equals(mDay05) ? mArrDayOfWeek[4] : str.equals(mDay06) ? mArrDayOfWeek[5] : str.equals(mDay07) ? mArrDayOfWeek[6] : str;
    }

    public static int getMonth(String str) {
        char cM4a = AbstractC0000a.m4a(1, str);
        if (cM4a == '.' || cM4a == ',') {
            str = AbstractC2322a.m1614d(1, 0, str);
        }
        int iIndexOf = mMonthList.indexOf(str);
        if (iIndexOf != -1) {
            return iIndexOf + 1;
        }
        int iIndexOf2 = mMonthAbbList.indexOf(str);
        return iIndexOf2 != -1 ? iIndexOf2 + 1 : getMonthEnglish(str);
    }

    private static int getMonthEnglish(String str) {
        if (str == null) {
            return -1;
        }
        switch (str) {
        }
        return -1;
    }

    private static void initKoreanFormat() {
        DateFormats.KOREAN_DAY_KEYWORD_FORMAT = AbstractC0622a.m1170p(mDayFormat, ")", new StringBuilder("("));
        StringBuilder sb = new StringBuilder("(((");
        sb.append(mKrMorning2);
        sb.append(") (([0][1-5]|[1-5])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        sb.append(mMinute);
        sb.append(")?|([0][1-5]|[1-5])(\\:)([0-5][0-9]|[1-9])))|((");
        sb.append(mMorning);
        sb.append(") (([0][6-9]|[1][0-1]|[6-9])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        sb.append(mMinute);
        sb.append(")?|([0][6-9]|[1][0-1]|[6-9])(\\:)([0-5][0-9]|[1-9])))|((");
        sb.append(mKrMorning3);
        sb.append(") (([0][6-9]|[1][0-1]|[6-9])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        sb.append(mMinute);
        sb.append(")?|([0][6-9]|[1][0-1]|[6-9])(\\:)([0-5][0-9]|[1-9])))|((");
        sb.append(mTimePm);
        sb.append(") (([0][1-5]|[1][2]|[1-5])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        sb.append(mMinute);
        sb.append(")?|([0][1-5]|[1][2]|[1-5])(\\:)([0-5][0-9]|[1-9])))|((");
        sb.append(mEvening);
        sb.append(") (([0][6-9]|[1][0]|[6-9])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        sb.append(mMinute);
        sb.append(")?|([0][6-9]|[1][0]|[6-9])(\\:)([0-5][0-9]|[1-9])))|((");
        sb.append(mTonight);
        sb.append(") (([0][8-9]|[1][0-2]|[8-9])");
        sb.append(mHour);
        sb.append("([ ]([0-5][0-9]|[1-9])");
        DateFormats.KOREAN_TIME_KEYWORD_FORMAT = AbstractC0622a.m1170p(mMinute, ")?|([0][8-9]|[1][0-2]|[8-9])(\\:)([0-5][0-9]|[1-9]))))", sb);
        StringBuilder sb2 = new StringBuilder("((");
        sb2.append(mToday);
        sb2.append("|");
        DateFormats.KOREAN_DATE_KEYWORD_FORMAT = AbstractC0622a.m1170p(mTomorrow, ")[ \\,][ ]?(((([0-1][0-9]|[1-9]|([2][0-4]))시)[ ]?(([0-5][0-9]|[1-9])분)?)|(((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?))))", sb2);
        DatePatterns.KOREAN_DATE_KEYWORD_PATTERN = Pattern.compile("(" + DateFormats.KOREAN_DATE_KEYWORD_FORMAT + "([ \\,][ ]?(((([0-1][0-9]|[1-9]|([2][0-4]))시)[ ]?(([0-5][0-9]|[1-9])분)?)|(((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?))))?)");
    }

    private static void initWesternDayMonthFormat() {
        StringBuilder sb = new StringBuilder("((0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|3(0(th)?|1(st)?)) ((");
        sb.append(mMonth01);
        sb.append("|");
        sb.append(mMonth07);
        sb.append("|");
        sb.append(mMonth03);
        sb.append("|");
        sb.append(mMonth05);
        sb.append("|");
        sb.append(mMonth08);
        sb.append("|");
        sb.append(mMonth10);
        sb.append("|");
        sb.append(mMonth12);
        sb.append(")|((");
        sb.append(mMonth01_abb);
        sb.append("|");
        sb.append(mMonth07_abb);
        sb.append("|");
        sb.append(mMonth03_abb);
        sb.append("|");
        sb.append(mMonth05_abb);
        sb.append("|");
        sb.append(mMonth08_abb);
        sb.append("|");
        sb.append(mMonth10_abb);
        sb.append("|");
        sb.append(mMonth12_abb);
        sb.append(")[\\.\\,]?))|(0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|30(th)?) ((");
        sb.append(mMonth04);
        sb.append("|");
        sb.append(mMonth06);
        sb.append("|");
        sb.append(mMonth09);
        sb.append("|");
        sb.append(mMonth11);
        sb.append(")|((");
        sb.append(mMonth04_abb);
        sb.append("|");
        sb.append(mMonth06_abb);
        sb.append("|");
        sb.append(mMonth09_abb);
        sb.append("|");
        sb.append(mMonth11_abb);
        sb.append(")[\\.\\,]?))|(0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|2([1](st)?|[2](nd)?|[3](rd)?|[4-80](th)?)) (");
        sb.append(mMonth02);
        sb.append("|");
        sb.append(mMonth02_abb);
        sb.append("[\\.\\,]?)|29(th)? (");
        sb.append(mMonth02);
        sb.append("|");
        DateFormats.WESTERN_DAY_MONTH_FORMAT = AbstractC0622a.m1170p(mMonth02_abb, "[\\.\\,]?) ((0[48]|[2468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26])))", sb);
    }

    private static void initWesternFormat() {
        initWesternMonthDayFormat();
        initWesternDayMonthFormat();
        StringBuilder sb = new StringBuilder("((");
        sb.append(mTonight);
        sb.append("|");
        sb.append(mToday);
        sb.append("|");
        sb.append(mTomorrow);
        sb.append("|");
        String str = mTonight;
        Locale locale = Locale.US;
        sb.append(str.toLowerCase(locale));
        sb.append("|");
        sb.append(mToday.toLowerCase(locale));
        sb.append("|");
        sb.append(mTomorrow.toLowerCase(locale));
        sb.append("))");
        DateFormats.WESTERN_DATE_KEYWORD_FORMAT = sb.toString();
        StringBuilder sb2 = new StringBuilder("((");
        sb2.append(mDay01);
        sb2.append("|");
        sb2.append(mDay02);
        sb2.append("|");
        sb2.append(mDay03);
        sb2.append("|");
        sb2.append(mDay04);
        sb2.append("|");
        sb2.append(mDay05);
        sb2.append("|");
        sb2.append(mDay06);
        sb2.append("|");
        DateFormats.WESTERN_DAY_KEYWORD_FORMAT = AbstractC0622a.m1170p(mDay07, "|))", sb2);
        DateFormats.WESTERN_TIME_KEYWORD_FORMAT = "(((" + mMorning + "|" + mMorning.toLowerCase(locale) + ") ([0][6-9]|[1][0-1]|[6-9])(\\:)([0-5][0-9]|[1-9]))|((" + mAfternoon + "|" + mAfternoon.toLowerCase(locale) + ") ([0][1-5]|[1][2]|[1-5])(\\:)([0-5][0-9]|[1-9]))|((" + mEvening + "|" + mEvening.toLowerCase(locale) + ") ([0][6-9]|[1][0]|[6-9])(\\:)([0-5][0-9]|[1-9]))|((" + mNight + "|" + mNight.toLowerCase(locale) + ") ([0][8-9]|[1][0-2]|[8-9])(\\:)([0-5][0-9]|[1-9])))";
        StringBuilder sb3 = new StringBuilder("((");
        sb3.append(DateFormats.WESTERN_MONTH_DAY_FORMAT);
        sb3.append("|");
        sb3.append(DateFormats.WESTERN_DAY_MONTH_FORMAT);
        sb3.append(") (18|19|20|21)\\d{2})");
        DatePatterns.WESTERN_ONLY_DATE_PATTERN = Pattern.compile(sb3.toString());
        StringBuilder sb4 = new StringBuilder("((");
        sb4.append(DateFormats.WESTERN_MONTH_DAY_FORMAT);
        sb4.append("|");
        sb4.append(DateFormats.WESTERN_DAY_MONTH_FORMAT);
        sb4.append(") (18|19|20|21)\\d{2}[ \\,][ ]?(((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?)))");
        DatePatterns.WESTERN_DATE_TIME_PATTERN = Pattern.compile(sb4.toString());
        DatePatterns.WESTERN_TIME_DATE_PATTERN = Pattern.compile("((((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?))[ \\,][ ]?(" + DateFormats.WESTERN_MONTH_DAY_FORMAT + "|" + DateFormats.WESTERN_DAY_MONTH_FORMAT + ") (18|19|20|21)\\d{2})");
        StringBuilder sb5 = new StringBuilder("(");
        sb5.append(DateFormats.WESTERN_DATE_KEYWORD_FORMAT);
        sb5.append("([ \\,][ ]?(((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?)))?)");
        DatePatterns.WESTERN_DATE_KEYWORD_PATTERN = Pattern.compile(sb5.toString());
        DatePatterns.WESTERN_TIME_KEYWORD_PATTERN = Pattern.compile("(" + DateFormats.WESTERN_DAY_KEYWORD_FORMAT + "[ \\,][ ]?((((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?))|" + DateFormats.WESTERN_TIME_KEYWORD_FORMAT + "))");
    }

    private static void initWesternMonthDayFormat() {
        StringBuilder sb = new StringBuilder("(((");
        sb.append(mMonth01);
        sb.append("|");
        sb.append(mMonth07);
        sb.append("|");
        sb.append(mMonth03);
        sb.append("|");
        sb.append(mMonth05);
        sb.append("|");
        sb.append(mMonth08);
        sb.append("|");
        sb.append(mMonth10);
        sb.append("|");
        sb.append(mMonth12);
        sb.append(")|((");
        sb.append(mMonth01_abb);
        sb.append("|");
        sb.append(mMonth07_abb);
        sb.append("|");
        sb.append(mMonth03_abb);
        sb.append("|");
        sb.append(mMonth05_abb);
        sb.append("|");
        sb.append(mMonth08_abb);
        sb.append("|");
        sb.append(mMonth10_abb);
        sb.append("|");
        sb.append(mMonth12_abb);
        sb.append(")[\\.\\,]?)) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|3(0(th)?|1(st)?))|((");
        sb.append(mMonth04);
        sb.append("|");
        sb.append(mMonth06);
        sb.append("|");
        sb.append(mMonth09);
        sb.append("|");
        sb.append(mMonth11);
        sb.append(")|((");
        sb.append(mMonth04_abb);
        sb.append("|");
        sb.append(mMonth06_abb);
        sb.append("|");
        sb.append(mMonth09_abb);
        sb.append("|");
        sb.append(mMonth11_abb);
        sb.append(")[\\.\\,]?)) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|30(th)?)|(");
        sb.append(mMonth02);
        sb.append("|");
        sb.append(mMonth02_abb);
        sb.append("[\\.\\,]?) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|2([1](st)?|[2](nd)?|[3](rd)?|[4-80](th)?))|(");
        sb.append(mMonth02);
        sb.append("|");
        DateFormats.WESTERN_MONTH_DAY_FORMAT = AbstractC0622a.m1170p(mMonth02_abb, "[\\.\\,]?)29(th)? ((0[48]|[2468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26])))", sb);
    }

    private static void initWord(Context context) {
        ArrayList<String> arrayList = new ArrayList<>(12);
        mMonthList = arrayList;
        String string = context.getString(C9086R.string.composer_date_month_01);
        mMonth01 = string;
        arrayList.add(string);
        ArrayList<String> arrayList2 = mMonthList;
        String string2 = context.getString(C9086R.string.composer_date_month_02);
        mMonth02 = string2;
        arrayList2.add(string2);
        ArrayList<String> arrayList3 = mMonthList;
        String string3 = context.getString(C9086R.string.composer_date_month_03);
        mMonth03 = string3;
        arrayList3.add(string3);
        ArrayList<String> arrayList4 = mMonthList;
        String string4 = context.getString(C9086R.string.composer_date_month_04);
        mMonth04 = string4;
        arrayList4.add(string4);
        ArrayList<String> arrayList5 = mMonthList;
        String string5 = context.getString(C9086R.string.composer_date_month_05);
        mMonth05 = string5;
        arrayList5.add(string5);
        ArrayList<String> arrayList6 = mMonthList;
        String string6 = context.getString(C9086R.string.composer_date_month_06);
        mMonth06 = string6;
        arrayList6.add(string6);
        ArrayList<String> arrayList7 = mMonthList;
        String string7 = context.getString(C9086R.string.composer_date_month_07);
        mMonth07 = string7;
        arrayList7.add(string7);
        ArrayList<String> arrayList8 = mMonthList;
        String string8 = context.getString(C9086R.string.composer_date_month_08);
        mMonth08 = string8;
        arrayList8.add(string8);
        ArrayList<String> arrayList9 = mMonthList;
        String string9 = context.getString(C9086R.string.composer_date_month_09);
        mMonth09 = string9;
        arrayList9.add(string9);
        ArrayList<String> arrayList10 = mMonthList;
        String string10 = context.getString(C9086R.string.composer_date_month_10);
        mMonth10 = string10;
        arrayList10.add(string10);
        ArrayList<String> arrayList11 = mMonthList;
        String string11 = context.getString(C9086R.string.composer_date_month_11);
        mMonth11 = string11;
        arrayList11.add(string11);
        ArrayList<String> arrayList12 = mMonthList;
        String string12 = context.getString(C9086R.string.composer_date_month_12);
        mMonth12 = string12;
        arrayList12.add(string12);
        ArrayList<String> arrayList13 = new ArrayList<>(12);
        mMonthAbbList = arrayList13;
        String string13 = context.getString(C9086R.string.month01_abb);
        mMonth01_abb = string13;
        arrayList13.add(string13);
        ArrayList<String> arrayList14 = mMonthAbbList;
        String string14 = context.getString(C9086R.string.month02_abb);
        mMonth02_abb = string14;
        arrayList14.add(string14);
        ArrayList<String> arrayList15 = mMonthAbbList;
        String string15 = context.getString(C9086R.string.month03_abb);
        mMonth03_abb = string15;
        arrayList15.add(string15);
        ArrayList<String> arrayList16 = mMonthAbbList;
        String string16 = context.getString(C9086R.string.month04_abb);
        mMonth04_abb = string16;
        arrayList16.add(string16);
        ArrayList<String> arrayList17 = mMonthAbbList;
        String string17 = context.getString(C9086R.string.month05_abb);
        mMonth05_abb = string17;
        arrayList17.add(string17);
        ArrayList<String> arrayList18 = mMonthAbbList;
        String string18 = context.getString(C9086R.string.month06_abb);
        mMonth06_abb = string18;
        arrayList18.add(string18);
        ArrayList<String> arrayList19 = mMonthAbbList;
        String string19 = context.getString(C9086R.string.month07_abb);
        mMonth07_abb = string19;
        arrayList19.add(string19);
        ArrayList<String> arrayList20 = mMonthAbbList;
        String string20 = context.getString(C9086R.string.month08_abb);
        mMonth08_abb = string20;
        arrayList20.add(string20);
        ArrayList<String> arrayList21 = mMonthAbbList;
        String string21 = context.getString(C9086R.string.month09_abb);
        mMonth09_abb = string21;
        arrayList21.add(string21);
        ArrayList<String> arrayList22 = mMonthAbbList;
        String string22 = context.getString(C9086R.string.month10_abb);
        mMonth10_abb = string22;
        arrayList22.add(string22);
        ArrayList<String> arrayList23 = mMonthAbbList;
        String string23 = context.getString(C9086R.string.month11_abb);
        mMonth11_abb = string23;
        arrayList23.add(string23);
        ArrayList<String> arrayList24 = mMonthAbbList;
        String string24 = context.getString(C9086R.string.month12_abb);
        mMonth12_abb = string24;
        arrayList24.add(string24);
        mDay01 = context.getString(C9086R.string.day01);
        mDay02 = context.getString(C9086R.string.day02);
        mDay03 = context.getString(C9086R.string.day03);
        mDay04 = context.getString(C9086R.string.day04);
        mDay05 = context.getString(C9086R.string.day05);
        mDay06 = context.getString(C9086R.string.day06);
        mDay07 = context.getString(C9086R.string.day07);
        mTonight = context.getString(C9086R.string.tonight);
        mToday = context.getString(C9086R.string.today);
        mTomorrow = context.getString(C9086R.string.tomorrow);
        mMorning = context.getString(C9086R.string.morining);
        mAfternoon = context.getString(C9086R.string.afternoon);
        mEvening = context.getString(C9086R.string.evening);
        mNight = context.getString(C9086R.string.night);
        mHour = context.getString(C9086R.string.kr_hour);
        mMinute = context.getString(C9086R.string.kr_minute);
        mKrMorning2 = context.getString(C9086R.string.kr_morning2);
        mKrMorning3 = context.getString(C9086R.string.time_am);
        mDayFormat = context.getString(C9086R.string.kr_day_format);
        mTimePm = context.getString(C9086R.string.time_pm);
    }

    public static void setWesternDateTimeFormat(Context context) {
        initWord(context);
        initKoreanFormat();
        initWesternFormat();
    }
}
