package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import android.text.Spannable;
import android.text.format.Time;
import androidx.collection.AbstractC0622a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateTimeLinkifyHelper {
    private static long mModifiedTime;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DateTimeData {
        Boolean isAllDay;
        String sTime;

        public /* synthetic */ DateTimeData(int i) {
            this();
        }

        private DateTimeData() {
        }
    }

    public static void applyLink(String str, int i, int i2, Spannable spannable) {
        DateTimeData dateTimeData = new DateTimeData(0);
        dateTimeData.sTime = str;
        dateTimeData.isAllDay = Boolean.FALSE;
        InternalURLSpan internalURLSpan = new InternalURLSpan();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.DATE_FORMAT);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormats.DAY_FORMAT);
        if (dateTimeData.sTime.startsWith("standard_date_time_1://")) {
            dateTimeData.isAllDay = Boolean.TRUE;
            dateTimeData.sTime = dateTimeData.sTime.substring(23) + " 00:00";
        } else if (dateTimeData.sTime.startsWith("standard_data_time_2://")) {
            dateTimeData.sTime = dateTimeData.sTime.substring(23);
            StringBuffer stringBuffer = new StringBuffer(simpleDateFormat.format(Long.valueOf(mModifiedTime)));
            stringBuffer.append(' ');
            stringBuffer.append(dateTimeData.sTime);
            dateTimeData.sTime = stringBuffer.toString();
        } else if (dateTimeData.sTime.startsWith("standard_date_time_3://")) {
            dateTimeData.sTime = dateTimeData.sTime.substring(23);
        } else {
            if (dateTimeData.sTime.startsWith("standard_date_time_4://")) {
                String strSubstring = dateTimeData.sTime.substring(23);
                dateTimeData.sTime = strSubstring;
                String lowerCase = strSubstring.toLowerCase(Locale.US);
                dateTimeData.sTime = lowerCase;
                String strReplace = lowerCase.replace(" am", "am");
                dateTimeData.sTime = strReplace;
                String strReplace2 = strReplace.replace(" pm", "pm");
                dateTimeData.sTime = strReplace2;
                String strReplace3 = strReplace2.replace(",", " ");
                dateTimeData.sTime = strReplace3;
                String strReplaceAll = strReplace3.trim().replaceAll("\\s+", " ");
                dateTimeData.sTime = strReplaceAll;
                String[] strArrSplit = strReplaceAll.split(" ");
                dateTimeData.sTime = strArrSplit[1] + " " + strArrSplit[0];
            } else if (dateTimeData.sTime.startsWith("english_date_time_1://")) {
                handleEngWesternScheme1(dateTimeData, "english_date_time_1://");
            } else if (dateTimeData.sTime.startsWith("english_date_time_2://")) {
                dateTimeData.sTime = DateTimeScheme.englishDateTime2Scheme(dateTimeData.sTime);
            } else if (dateTimeData.sTime.startsWith("english_date_time_3://")) {
                dateTimeData.sTime = DateTimeScheme.englishDateTime3Scheme(dateTimeData.sTime);
            } else if (dateTimeData.sTime.startsWith("english_date_time_4://")) {
                String strSubstring2 = dateTimeData.sTime.substring(22);
                dateTimeData.sTime = strSubstring2;
                String[] strArrSplit2 = strSubstring2.split(" ");
                String str2 = dateTimeData.sTime;
                Locale locale = Locale.US;
                if (str2.toLowerCase(locale).startsWith("tomorrow")) {
                    mModifiedTime += 86400000;
                }
                if (strArrSplit2.length != 1) {
                    String str3 = simpleDateFormat.format(Long.valueOf(mModifiedTime));
                    dateTimeData.sTime = str3;
                    StringBuffer stringBuffer2 = new StringBuffer(str3);
                    int length = strArrSplit2.length;
                    for (int i4 = 1; i4 < length; i4++) {
                        stringBuffer2.append(' ');
                        stringBuffer2.append(strArrSplit2[i4]);
                    }
                    dateTimeData.sTime = stringBuffer2.toString();
                } else if (dateTimeData.sTime.toLowerCase(locale).startsWith("tonight")) {
                    dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " 8pm";
                } else {
                    dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " 00:00";
                    dateTimeData.isAllDay = Boolean.TRUE;
                }
            } else if (dateTimeData.sTime.startsWith("english_date_time_5://")) {
                dateTimeData.sTime = DateTimeScheme.englishDateTime5Scheme(dateTimeData.sTime, simpleDateFormat, simpleDateFormat2, mModifiedTime);
            } else if (!handleKoreanDateTime(dateTimeData, simpleDateFormat, simpleDateFormat2)) {
                handleWesternDateTime(dateTimeData, simpleDateFormat, simpleDateFormat2);
            }
        }
        internalURLSpan.setTimeString(dateTimeData.sTime);
        internalURLSpan.setAllDay(dateTimeData.isAllDay.booleanValue());
        spannable.setSpan(internalURLSpan, i, i2, 33);
    }

    public static void gatherLinks(ArrayList<DateLinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            arrayList.add(new DateLinkSpec(6, matcher.start(), matcher.end(), UriLinkHelper.makeUrl(matcher.group(0), strArr)));
        }
    }

    private static DateFormat getDateFormat(String str) {
        return new SimpleDateFormat(str);
    }

    public static long getModifiedTime() {
        return mModifiedTime;
    }

    private static void handleEngWesternScheme1(DateTimeData dateTimeData, String str) {
        dateTimeData.isAllDay = Boolean.TRUE;
        String strSubstring = dateTimeData.sTime.substring(str.length());
        dateTimeData.sTime = strSubstring;
        String[] strArrExtractDate = DateTimeString.extractDate(strSubstring.split(" "));
        StringBuilder sb = new StringBuilder();
        sb.append(strArrExtractDate[0]);
        sb.append("/");
        sb.append(strArrExtractDate[1]);
        sb.append("/");
        dateTimeData.sTime = AbstractC0622a.m1170p(strArrExtractDate[2], " 00:00", sb);
    }

    private static boolean handleKoreanDateTime(DateTimeData dateTimeData, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        if (dateTimeData.sTime.startsWith("korean_date_time_1://")) {
            dateTimeData.isAllDay = Boolean.TRUE;
            String strSubstring = dateTimeData.sTime.substring(21);
            dateTimeData.sTime = strSubstring;
            String strReplace = strSubstring.replace("년 ", "/");
            dateTimeData.sTime = strReplace;
            String strReplace2 = strReplace.replace("월 ", "/");
            dateTimeData.sTime = strReplace2;
            dateTimeData.sTime = strReplace2.replace("일", "");
            dateTimeData.sTime = AbstractC0622a.m1170p(dateTimeData.sTime, " 00:00", new StringBuilder());
            return true;
        }
        if (dateTimeData.sTime.startsWith("korean_date_time_2://")) {
            String strSubstring2 = dateTimeData.sTime.substring(21);
            dateTimeData.sTime = strSubstring2;
            String strReplace3 = strSubstring2.replace("년 ", "/");
            dateTimeData.sTime = strReplace3;
            String strReplace4 = strReplace3.replace("월 ", "/");
            dateTimeData.sTime = strReplace4;
            String strReplace5 = strReplace4.replace("일 ", " ");
            dateTimeData.sTime = strReplace5;
            String strReplace6 = strReplace5.replace("시", ":");
            dateTimeData.sTime = strReplace6;
            dateTimeData.sTime = strReplace6.replace("분", "");
            return true;
        }
        if (dateTimeData.sTime.startsWith("korean_date_time_3://")) {
            String strSubstring3 = dateTimeData.sTime.substring(21);
            dateTimeData.sTime = strSubstring3;
            String strReplace7 = strSubstring3.replace("년 ", "/");
            dateTimeData.sTime = strReplace7;
            String strReplace8 = strReplace7.replace("월 ", "/");
            dateTimeData.sTime = strReplace8;
            String strReplace9 = strReplace8.replace("일", " ");
            dateTimeData.sTime = strReplace9;
            String strReplace10 = strReplace9.replace("시", ":");
            dateTimeData.sTime = strReplace10;
            String strReplace11 = strReplace10.replace("분", "");
            dateTimeData.sTime = strReplace11;
            int iIndexOf = strReplace11.indexOf(47);
            StringBuilder sb = new StringBuilder();
            String str = dateTimeData.sTime;
            sb.append(str.substring(iIndexOf - 4, str.length()));
            sb.append(" ");
            sb.append(dateTimeData.sTime.substring(0, iIndexOf - 5));
            dateTimeData.sTime = sb.toString();
            return true;
        }
        if (!dateTimeData.sTime.startsWith("korean_date_time_4://")) {
            if (dateTimeData.sTime.startsWith("korean_date_time_5://")) {
                dateTimeData.sTime = DateTimeScheme.koreanDateTime5Scheme(dateTimeData.sTime, simpleDateFormat, mModifiedTime);
                return true;
            }
            if (!dateTimeData.sTime.startsWith("korean_date_time_6://")) {
                return false;
            }
            String strSubstring4 = dateTimeData.sTime.substring(21);
            dateTimeData.sTime = strSubstring4;
            String strReplace12 = strSubstring4.replace("시 ", ":");
            dateTimeData.sTime = strReplace12;
            String strReplace13 = strReplace12.replace("분", "");
            dateTimeData.sTime = strReplace13;
            dateTimeData.sTime = strReplace13.replace("시", ":");
            dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " " + dateTimeData.sTime;
            return true;
        }
        String strSubstring5 = dateTimeData.sTime.substring(21);
        dateTimeData.sTime = strSubstring5;
        String strReplace14 = strSubstring5.replace("시 ", ":");
        dateTimeData.sTime = strReplace14;
        String strReplace15 = strReplace14.replace("분", "");
        dateTimeData.sTime = strReplace15;
        String strReplace16 = strReplace15.replace("시", ":");
        dateTimeData.sTime = strReplace16;
        String[] strArrSplit = strReplace16.split(" ");
        if (dateTimeData.sTime.startsWith(DateTimeString.mTomorrow)) {
            mModifiedTime += 86400000;
        }
        if (strArrSplit.length == 1) {
            dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " 00:00";
            dateTimeData.isAllDay = Boolean.TRUE;
        } else {
            dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dateTimeData.sTime);
            int length = strArrSplit.length;
            for (int i = 1; i < length; i++) {
                sb2.append(' ');
                sb2.append(strArrSplit[i]);
            }
            dateTimeData.sTime = sb2.toString();
        }
        return true;
    }

    private static void handleWesternDateTime(DateTimeData dateTimeData, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        if (dateTimeData.sTime.startsWith("western_date_time_1://")) {
            handleEngWesternScheme1(dateTimeData, "western_date_time_1://");
            return;
        }
        if (dateTimeData.sTime.startsWith("western_date_time_2://")) {
            dateTimeData.sTime = DateTimeScheme.westernDateTime2Scheme(dateTimeData.sTime);
            return;
        }
        if (dateTimeData.sTime.startsWith("western_date_time_3://")) {
            dateTimeData.sTime = DateTimeScheme.westernDateTime3Scheme(dateTimeData.sTime);
            return;
        }
        if (!dateTimeData.sTime.startsWith("western_date_time_4://")) {
            if (dateTimeData.sTime.startsWith("western_date_time_5://")) {
                dateTimeData.sTime = DateTimeScheme.westernDateTime5Scheme(dateTimeData.sTime, simpleDateFormat, simpleDateFormat2, mModifiedTime);
                return;
            }
            return;
        }
        String strSubstring = dateTimeData.sTime.substring(22);
        dateTimeData.sTime = strSubstring;
        String[] strArrSplit = strSubstring.split(" ");
        String str = dateTimeData.sTime;
        Locale locale = Locale.US;
        if (str.toLowerCase(locale).startsWith(DateTimeString.mTomorrow.toLowerCase(locale))) {
            mModifiedTime += 86400000;
        }
        if (strArrSplit.length != 1) {
            String str2 = simpleDateFormat.format(Long.valueOf(mModifiedTime));
            dateTimeData.sTime = str2;
            StringBuffer stringBuffer = new StringBuffer(str2);
            int length = strArrSplit.length;
            for (int i = 1; i < length; i++) {
                stringBuffer.append(' ');
                stringBuffer.append(strArrSplit[i]);
            }
            dateTimeData.sTime = stringBuffer.toString();
            return;
        }
        if (dateTimeData.sTime.toLowerCase(locale).startsWith(DateTimeString.mTonight.toLowerCase(locale))) {
            dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " 8pm";
            return;
        }
        dateTimeData.sTime = simpleDateFormat.format(Long.valueOf(mModifiedTime)) + " 00:00";
        dateTimeData.isAllDay = Boolean.TRUE;
    }

    public static Date toDate(Context context, String str) {
        boolean z;
        Date date = new Date();
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("pm")) {
                lowerCase = lowerCase.replace("pm", "");
                z = true;
            } else {
                if (lowerCase.contains("am")) {
                    lowerCase = lowerCase.replace("am", "");
                }
                z = false;
            }
            String strReplace = lowerCase.trim().replace('/', ' ');
            if (!strReplace.contains(":")) {
                strReplace = strReplace.concat(":00");
            } else if (strReplace.endsWith(":")) {
                strReplace = strReplace.concat("00");
            }
            String[] strArrSplit = strReplace.replace(':', ' ').replace(',', ' ').trim().replaceAll("\\s+", " ").split(" ");
            String[] strArr = new String[5];
            System.arraycopy(strArrSplit, 0, strArr, 0, strArrSplit.length);
            if (strArrSplit[0].length() < 4) {
                strArr[0] = strArrSplit[2];
                if (Integer.parseInt(strArrSplit[1]) > 12) {
                    strArr[1] = strArrSplit[0];
                    strArr[2] = strArrSplit[1];
                } else if (Integer.parseInt(strArrSplit[0]) > 12) {
                    strArr[1] = strArrSplit[1];
                    strArr[2] = strArrSplit[0];
                } else {
                    strArr[1] = strArrSplit[0];
                    strArr[2] = strArrSplit[1];
                    String localizedPattern = ((SimpleDateFormat) android.text.format.DateFormat.getDateFormat(context)).toLocalizedPattern();
                    if (localizedPattern != null && (localizedPattern.equals("dd-MM-yyyy") || localizedPattern.equals("d/M/yy") || localizedPattern.equals("dd/MM/yy") || localizedPattern.equals("dd/MM/y") || localizedPattern.equals("dd.MM.yy"))) {
                        strArr[1] = strArrSplit[1];
                        strArr[2] = strArrSplit[0];
                    }
                }
            }
            for (int i = 1; i < 5; i++) {
                String str2 = strArr[i];
                if (str2 != null && str2.length() == 1) {
                    strArr[i] = "0" + strArr[i];
                }
            }
            if (z) {
                strArr[3] = String.valueOf(Integer.parseInt(strArr[3]) + 12);
            }
            try {
                Date date2 = getDateFormat("yyyy/MM/dd HH:mm").parse((strArr[0] + "/" + strArr[1] + "/" + strArr[2] + " " + strArr[3] + ":" + strArr[4]).trim());
                "Asia/Shanghai".equals(Time.getCurrentTimezone());
                return date2;
            } catch (ParseException unused) {
            }
        }
        return date;
    }
}
