package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateTimeLinkify {
    private final Context mContext;
    private HyperTextEntityExtractor mHyperTextEntityExtractor;
    private final DateTimeLinkifyDelegate mImpl;
    private final Locale mLocale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DateTimeData {
        Boolean isAllDay;
        Long modifiedTime;
        String sTime;
        String url;

        public /* synthetic */ DateTimeData(int i) {
            this();
        }

        private DateTimeData() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class DateTimeLinkifyDelegate {
        public /* synthetic */ DateTimeLinkifyDelegate(int i) {
            this();
        }

        @NonNull
        public Intent getDateTimeIntent() {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.addFlags(268435456);
            return intent;
        }

        public abstract Intent setIntentExtraForDate(String str);

        private DateTimeLinkifyDelegate() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DateTimeLinkifyDelegateImpl extends DateTimeLinkifyDelegate {
        public /* synthetic */ DateTimeLinkifyDelegateImpl(DateTimeLinkify dateTimeLinkify, int i) {
            this();
        }

        @Nullable
        private String addPrefix(Spannable spannable) {
            DateTimeString.setWesternDateTimeFormat(DateTimeLinkify.this.mContext);
            ArrayList<DateLinkSpec> arrayList = new ArrayList<>();
            getherLinksStandard(spannable, arrayList);
            getherLinksEnglish(spannable, arrayList);
            String language = DateTimeLinkify.this.mLocale.getLanguage();
            if (LangPackConfigConstants.LANGUAGE_CODE_FR.equals(language)) {
                getherLinksWestern(spannable, arrayList);
            } else if (language.equals(Locale.KOREAN.getLanguage())) {
                getherLinksKorean(spannable, arrayList);
            }
            DateLinkifyHelper.pruneOverlaps(arrayList);
            removeSpanForTel(spannable, arrayList);
            if (arrayList.isEmpty()) {
                return null;
            }
            DateLinkSpec dateLinkSpec = arrayList.get(0);
            DateTimeLinkifyHelper.applyLink(dateLinkSpec.mUrl, dateLinkSpec.start, dateLinkSpec.end, spannable);
            return dateLinkSpec.mUrl;
        }

        @Nullable
        private Pair<Long, Boolean> getTime(String str) {
            String strAddPrefix = addPrefix(new SpannableString(str));
            if (TextUtils.isEmpty(strAddPrefix)) {
                return null;
            }
            DateTimeData dateTimeData = new DateTimeData(0);
            dateTimeData.modifiedTime = Long.valueOf(System.currentTimeMillis());
            dateTimeData.url = strAddPrefix;
            dateTimeData.sTime = strAddPrefix;
            dateTimeData.isAllDay = Boolean.FALSE;
            if (strAddPrefix.startsWith("standard_date_time_1://")) {
                dateTimeData.isAllDay = Boolean.TRUE;
                dateTimeData.sTime = strAddPrefix.substring(23) + " 00:00";
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormats.DATE_FORMAT);
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormats.DAY_FORMAT);
                if (strAddPrefix.startsWith("standard_data_time_2://")) {
                    dateTimeData.sTime = strAddPrefix.substring(23);
                    StringBuffer stringBuffer = new StringBuffer(simpleDateFormat.format(dateTimeData.modifiedTime));
                    stringBuffer.append(' ');
                    stringBuffer.append(dateTimeData.sTime);
                    dateTimeData.sTime = stringBuffer.toString();
                } else if (strAddPrefix.startsWith("standard_date_time_3://")) {
                    dateTimeData.sTime = strAddPrefix.substring(23);
                } else if (strAddPrefix.startsWith("standard_date_time_4://")) {
                    String strSubstring = strAddPrefix.substring(23);
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
                } else if (!handleEnglishDateTime(dateTimeData, simpleDateFormat, simpleDateFormat2) && !handleKoreanDateTime(dateTimeData, simpleDateFormat)) {
                    handleWesternDateTime(dateTimeData, simpleDateFormat, simpleDateFormat2);
                }
            }
            return new Pair<>(Long.valueOf(DateTimeLinkifyHelper.toDate(DateTimeLinkify.this.mContext, dateTimeData.sTime).getTime()), dateTimeData.isAllDay);
        }

        private void getherLinksEnglish(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_ONLY_DATE_PATTERN, new String[]{"english_date_time_1://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_DATE_TIME_PATTERN, new String[]{"english_date_time_2://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_TIME_DATE_PATTERN, new String[]{"english_date_time_3://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_DATE_KEYWORD_PATTERN, new String[]{"english_date_time_4://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.ENGLISH_TIME_KEYWORD_PATTERN, new String[]{"english_date_time_5://"});
        }

        private void getherLinksKorean(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.KOREAN_ONLY_DATE_PATTERN, new String[]{"korean_date_time_1://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.KOREAN_DATE_TIME_PATTERN, new String[]{"korean_date_time_2://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.KOREAN_TIME_DATE_PATTERN, new String[]{"korean_date_time_3://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.KOREAN_DATE_KEYWORD_PATTERN, new String[]{"korean_date_time_4://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.KOREAN_ONLY_TIME_PATTERN, new String[]{"korean_date_time_6://"});
        }

        private void getherLinksStandard(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.STANDARD_ONLY_DATE_PATTERN, new String[]{"standard_date_time_1://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.STANDARD_ONLY_TIME_PATTERN, new String[]{"standard_data_time_2://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.STANDARD_DATE_TIME_PATTERN, new String[]{"standard_date_time_3://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.STANDARD_TIME_DATE_PATTERN, new String[]{"standard_date_time_4://"});
        }

        private void getherLinksWestern(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.WESTERN_ONLY_DATE_PATTERN, new String[]{"western_date_time_1://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.WESTERN_DATE_TIME_PATTERN, new String[]{"western_date_time_2://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.WESTERN_TIME_DATE_PATTERN, new String[]{"western_date_time_3://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.WESTERN_DATE_KEYWORD_PATTERN, new String[]{"western_date_time_4://"});
            DateTimeLinkifyHelper.gatherLinks(arrayList, spannable, DatePatterns.WESTERN_TIME_KEYWORD_PATTERN, new String[]{"western_date_time_5://"});
        }

        private boolean handleEngWesternDateTime1(DateTimeData dateTimeData, String str, boolean z) {
            String strM1614d;
            dateTimeData.isAllDay = Boolean.TRUE;
            String strSubstring = dateTimeData.url.substring(str.length());
            dateTimeData.sTime = strSubstring;
            String string = "";
            if (z) {
                String strReplace = strSubstring.replace(",", "");
                dateTimeData.sTime = strReplace;
                dateTimeData.sTime = strReplace.replace(Extension.DOT, "");
            }
            String[] strArrSplit = dateTimeData.sTime.split(" ");
            int i = 0;
            while (true) {
                if (i >= 2) {
                    strM1614d = "";
                    break;
                }
                if (DateTimeString.getMonth(strArrSplit[i]) > 0) {
                    string = Integer.toString(DateTimeString.getMonth(strArrSplit[i]));
                    String str2 = strArrSplit[Math.abs(i - 1)];
                    strM1614d = str2.length() >= 3 ? AbstractC2322a.m1614d(2, 0, str2) : str2;
                } else {
                    i++;
                }
            }
            StringBuilder sbM2228s = AbstractC2821a.m2228s(strArrSplit[2], "/", string, "/", strM1614d);
            sbM2228s.append(" 00:00");
            dateTimeData.sTime = sbM2228s.toString();
            return true;
        }

        private boolean handleEnglishDateTime(DateTimeData dateTimeData, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            if (dateTimeData.url.startsWith("english_date_time_1://")) {
                return handleEngWesternDateTime1(dateTimeData, "english_date_time_1://", true);
            }
            if (dateTimeData.url.startsWith("english_date_time_2://")) {
                dateTimeData.sTime = DateTimeScheme.englishDateTime2Scheme(dateTimeData.url);
                return true;
            }
            if (dateTimeData.url.startsWith("english_date_time_3://")) {
                dateTimeData.sTime = DateTimeScheme.englishDateTime3Scheme(dateTimeData.url);
                return true;
            }
            if (!dateTimeData.url.startsWith("english_date_time_4://")) {
                if (!dateTimeData.url.startsWith("english_date_time_5://")) {
                    return false;
                }
                dateTimeData.sTime = DateTimeScheme.englishDateTime5Scheme(dateTimeData.url, simpleDateFormat, simpleDateFormat2, DateTimeLinkifyHelper.getModifiedTime());
                return true;
            }
            String strSubstring = dateTimeData.url.substring(22);
            dateTimeData.sTime = strSubstring;
            String[] strArrSplit = strSubstring.split(" ");
            String str = dateTimeData.sTime;
            Locale locale = Locale.US;
            if (str.toLowerCase(locale).startsWith("tomorrow")) {
                dateTimeData.modifiedTime = Long.valueOf(dateTimeData.modifiedTime.longValue() + 86400000);
            }
            if (strArrSplit.length != 1) {
                String str2 = simpleDateFormat.format(dateTimeData.modifiedTime);
                dateTimeData.sTime = str2;
                StringBuffer stringBuffer = new StringBuffer(str2);
                int length = strArrSplit.length;
                for (int i = 1; i < length; i++) {
                    stringBuffer.append(' ');
                    stringBuffer.append(strArrSplit[i]);
                }
                dateTimeData.sTime = stringBuffer.toString();
            } else if (dateTimeData.sTime.toLowerCase(locale).startsWith("tonight")) {
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " 8pm";
            } else {
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " 00:00";
                dateTimeData.isAllDay = Boolean.TRUE;
            }
            return true;
        }

        private boolean handleKoreanDateTime(DateTimeData dateTimeData, SimpleDateFormat simpleDateFormat) {
            if (dateTimeData.url.startsWith("korean_date_time_1://")) {
                dateTimeData.isAllDay = Boolean.TRUE;
                String strSubstring = dateTimeData.url.substring(21);
                dateTimeData.sTime = strSubstring;
                String strReplace = strSubstring.replace("년 ", "/");
                dateTimeData.sTime = strReplace;
                String strReplace2 = strReplace.replace("월 ", "/");
                dateTimeData.sTime = strReplace2;
                dateTimeData.sTime = strReplace2.replace("일", "");
                dateTimeData.sTime = AbstractC0622a.m1170p(dateTimeData.sTime, " 00:00", new StringBuilder());
                return true;
            }
            if (dateTimeData.url.startsWith("korean_date_time_2://")) {
                String strSubstring2 = dateTimeData.url.substring(21);
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
            if (dateTimeData.url.startsWith("korean_date_time_3://")) {
                String strSubstring3 = dateTimeData.url.substring(21);
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
                dateTimeData.sTime = dateTimeData.sTime.substring(iIndexOf - 4) + " " + dateTimeData.sTime.substring(0, iIndexOf - 5);
                return true;
            }
            if (!dateTimeData.url.startsWith("korean_date_time_4://")) {
                if (dateTimeData.url.startsWith("korean_date_time_5://")) {
                    dateTimeData.sTime = DateTimeScheme.koreanDateTime5Scheme(dateTimeData.url, simpleDateFormat, DateTimeLinkifyHelper.getModifiedTime());
                    return true;
                }
                if (!dateTimeData.url.startsWith("korean_date_time_6://")) {
                    return false;
                }
                String strSubstring4 = dateTimeData.url.substring(21);
                dateTimeData.sTime = strSubstring4;
                String strReplace12 = strSubstring4.replace("시 ", ":");
                dateTimeData.sTime = strReplace12;
                String strReplace13 = strReplace12.replace("분", "");
                dateTimeData.sTime = strReplace13;
                dateTimeData.sTime = strReplace13.replace("시", ":");
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " " + dateTimeData.sTime;
                return true;
            }
            String strSubstring5 = dateTimeData.url.substring(21);
            dateTimeData.sTime = strSubstring5;
            String strReplace14 = strSubstring5.replace("시 ", ":");
            dateTimeData.sTime = strReplace14;
            String strReplace15 = strReplace14.replace("분", "");
            dateTimeData.sTime = strReplace15;
            String strReplace16 = strReplace15.replace("시", ":");
            dateTimeData.sTime = strReplace16;
            String[] strArrSplit = strReplace16.split(" ");
            if (dateTimeData.sTime.startsWith(DateTimeString.mTomorrow)) {
                dateTimeData.modifiedTime = Long.valueOf(dateTimeData.modifiedTime.longValue() + 86400000);
            }
            if (strArrSplit.length == 1) {
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " 00:00";
                dateTimeData.isAllDay = Boolean.TRUE;
            } else {
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime);
                StringBuilder sb = new StringBuilder();
                sb.append(dateTimeData.sTime);
                int length = strArrSplit.length;
                for (int i = 1; i < length; i++) {
                    sb.append(' ');
                    sb.append(strArrSplit[i]);
                }
                dateTimeData.sTime = sb.toString();
            }
            return true;
        }

        private void handleWesternDateTime(DateTimeData dateTimeData, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
            if (dateTimeData.url.startsWith("western_date_time_1://")) {
                handleEngWesternDateTime1(dateTimeData, "western_date_time_1://", true);
                return;
            }
            if (dateTimeData.url.startsWith("western_date_time_2://")) {
                dateTimeData.sTime = DateTimeScheme.westernDateTime2Scheme(dateTimeData.url);
                return;
            }
            if (dateTimeData.url.startsWith("western_date_time_3://")) {
                dateTimeData.sTime = DateTimeScheme.westernDateTime3Scheme(dateTimeData.url);
                return;
            }
            if (!dateTimeData.url.startsWith("western_date_time_4://")) {
                if (dateTimeData.url.startsWith("western_date_time_5://")) {
                    dateTimeData.sTime = DateTimeScheme.westernDateTime5Scheme(dateTimeData.url, simpleDateFormat, simpleDateFormat2, DateTimeLinkifyHelper.getModifiedTime());
                    return;
                }
                return;
            }
            String strSubstring = dateTimeData.url.substring(22);
            dateTimeData.sTime = strSubstring;
            String[] strArrSplit = strSubstring.split(" ");
            String str = dateTimeData.sTime;
            Locale locale = Locale.US;
            if (str.toLowerCase(locale).startsWith(DateTimeString.mTomorrow.toLowerCase(locale))) {
                dateTimeData.modifiedTime = Long.valueOf(dateTimeData.modifiedTime.longValue() + 86400000);
            }
            if (strArrSplit.length != 1) {
                String str2 = simpleDateFormat.format(dateTimeData.modifiedTime);
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
                dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " 8pm";
                return;
            }
            dateTimeData.sTime = simpleDateFormat.format(dateTimeData.modifiedTime) + " 00:00";
            dateTimeData.isAllDay = Boolean.TRUE;
        }

        private void removeSpanForTel(Spannable spannable, ArrayList<DateLinkSpec> arrayList) {
            for (DateLinkSpec dateLinkSpec : arrayList) {
                int i = dateLinkSpec.start;
                String strReplaceAll = dateLinkSpec.mUrl.substring(23).replaceAll("\\p{Space}", "");
                URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(dateLinkSpec.start, dateLinkSpec.end, URLSpan.class);
                for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
                    String url = uRLSpanArr[length].getURL();
                    if (url.startsWith("tel:")) {
                        int spanStart = spannable.getSpanStart(uRLSpanArr[length]);
                        int spanEnd = spannable.getSpanEnd(uRLSpanArr[length]);
                        if (strReplaceAll.contains(url.substring(4))) {
                            spannable.removeSpan(uRLSpanArr[length]);
                        } else if (spanStart <= i && i <= spanEnd) {
                            spannable.removeSpan(uRLSpanArr[length]);
                        }
                    }
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.DateTimeLinkify.DateTimeLinkifyDelegate
        @Nullable
        public Intent setIntentExtraForDate(String str) {
            Pair<Long, Boolean> time = getTime(str.replace('-', '/').replace('.', '/'));
            if (time == null) {
                return null;
            }
            Intent dateTimeIntent = getDateTimeIntent();
            dateTimeIntent.putExtra("beginTime", (Serializable) time.first);
            dateTimeIntent.putExtra("endTime", ((Long) time.first).longValue() + 3600000);
            dateTimeIntent.putExtra("allDay", (Serializable) time.second);
            return dateTimeIntent;
        }

        private DateTimeLinkifyDelegateImpl() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntityExtractorImpl extends DateTimeLinkifyDelegate {
        public /* synthetic */ EntityExtractorImpl(DateTimeLinkify dateTimeLinkify, int i) {
            this();
        }

        private void updateIntentEventAllDay(DateLinkSpec dateLinkSpec, Intent intent) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateLinkSpec.mStartDate);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(dateLinkSpec.mEndDate);
            if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar2.get(11) == 23 && calendar2.get(12) == 59) {
                intent.putExtra("allDay", Boolean.TRUE);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.link.DateTimeLinkify.DateTimeLinkifyDelegate
        @Nullable
        public Intent setIntentExtraForDate(String str) {
            int i = 0;
            if (DateTimeLinkify.this.mHyperTextEntityExtractor == null) {
                return new DateTimeLinkifyDelegateImpl(DateTimeLinkify.this, i).setIntentExtraForDate(str);
            }
            ArrayList<CustomLinkSpec> arrayListAddLinks = DateTimeLinkify.this.mHyperTextEntityExtractor.addLinks(str, 16);
            if (arrayListAddLinks.isEmpty()) {
                return new DateTimeLinkifyDelegateImpl(DateTimeLinkify.this, i).setIntentExtraForDate(str);
            }
            DateLinkSpec dateLinkSpec = (DateLinkSpec) arrayListAddLinks.get(0);
            long time = dateLinkSpec.mStartDate.getTime();
            Intent dateTimeIntent = getDateTimeIntent();
            dateTimeIntent.putExtra("beginTime", time);
            Date date = dateLinkSpec.mEndDate;
            if (date == null) {
                dateTimeIntent.putExtra("endTime", time + 3600000);
                dateTimeIntent.putExtra("allDay", Boolean.TRUE);
                return dateTimeIntent;
            }
            if (time == date.getTime()) {
                dateTimeIntent.putExtra("endTime", time + 3600000);
                return dateTimeIntent;
            }
            updateIntentEventAllDay(dateLinkSpec, dateTimeIntent);
            dateTimeIntent.putExtra("endTime", dateLinkSpec.mEndDate.getTime());
            return dateTimeIntent;
        }

        private EntityExtractorImpl() {
            super(0);
        }
    }

    public DateTimeLinkify(Context context) {
        this(context, Locale.getDefault());
    }

    @Nullable
    public Intent getIntentForDate(String str) {
        return this.mImpl.setIntentExtraForDate(str);
    }

    public DateTimeLinkify(Context context, Locale locale) {
        boolean zIsSupported;
        this.mContext = context;
        this.mLocale = locale;
        int i = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            HyperTextEntityExtractor hyperTextEntityExtractor = HyperTextEntityExtractor.getInstance(context);
            this.mHyperTextEntityExtractor = hyperTextEntityExtractor;
            hyperTextEntityExtractor.setLocale(locale);
            zIsSupported = this.mHyperTextEntityExtractor.isSupported();
        } else {
            zIsSupported = false;
        }
        if (zIsSupported) {
            this.mImpl = new EntityExtractorImpl(this, i);
        } else {
            this.mImpl = new DateTimeLinkifyDelegateImpl(this, i);
        }
    }
}
