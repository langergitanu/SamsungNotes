package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.FilePathUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
abstract class MarketingParser {
    protected static final String TAG = "MarketingParser";
    private static final int TIME_END = 1;
    private static final int TIME_START = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AppData {
        final String customContent;
        final String mid;
        final String msgType;
        final String userdata;

        public AppData(String str, String str2, String str3, String str4) {
            this.mid = str;
            this.msgType = str2;
            this.userdata = str3;
            this.customContent = str4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MarketingDisplayTime {
        public PairTime<TimeUtil.Time> displayTime;
        public PairTime<TimeUtil.Time> doNotDisturbTime;
        public String timeBase;
        public PairTime<Long> ttl;

        public MarketingDisplayTime(String str, PairTime<Long> pairTime, PairTime<TimeUtil.Time> pairTime2, PairTime<TimeUtil.Time> pairTime3) {
            this.timeBase = str;
            this.ttl = pairTime;
            this.displayTime = pairTime2;
            this.doNotDisturbTime = pairTime3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PairTime<T> {
        public T end;
        public T start;

        public PairTime(T t, T t2) {
            this.start = t;
            this.end = t2;
        }
    }

    private static String getLocaleConstants(String str) {
        str.getClass();
        switch (str) {
            case "type1":
                return MarketingConstants.TYPE_1_LOCALE;
            case "type2":
                return MarketingConstants.TYPE_2_LOCALE;
            case "type3":
                return MarketingConstants.TYPE_3_LOCALE;
            default:
                return null;
        }
    }

    private static MarketingParser getParser(Marketing marketing) throws InternalException.NotSupportedTypeException {
        if (marketing instanceof NotificationMarketing) {
            return new NotificationMarketingParser();
        }
        if (marketing instanceof PopupMarketing) {
            return new PopupMarketingParser();
        }
        throw new InternalException.NotSupportedTypeException();
    }

    private static Pair<String, String> getResourceUrl(JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString(str);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(getLocaleConstants(str));
        return jSONArrayOptJSONArray == null ? new Pair<>(string, str) : new Pair<>(getResourceUrlByLocale(str, jSONObject.getString(MarketingConstants.CONTENTS_BASE_URL), jSONObject.getString(MarketingConstants.CONTENTS_FILENAME), jSONArrayOptJSONArray, string), str);
    }

    private static String getResourceUrlByLocale(String str, String str2, String str3, JSONArray jSONArray, String str4) {
        String subLocale;
        if (str == null || str2 == null || str3 == null || jSONArray == null || str4 == null) {
            SmpLog.m6494e(TAG, "fail to get res url by locale. invalid params");
            return null;
        }
        String locale = DeviceInfoUtil.getLocale();
        int i = 0;
        while (true) {
            try {
                if (i >= jSONArray.length()) {
                    subLocale = null;
                    break;
                }
                if (locale.equals(jSONArray.getString(i))) {
                    subLocale = locale;
                    break;
                }
                i++;
            } catch (JSONException e) {
                SmpLog.m6494e(TAG, "fail to get res url by locale." + e.toString());
                return null;
            }
        }
        if (subLocale == null) {
            subLocale = getSubLocale(jSONArray);
            SmpLog.m6492d(TAG, "use sub locale : " + subLocale);
        }
        if (subLocale == null) {
            SmpLog.m6492d(TAG, "cannot get resource locale:" + locale + ". use default url");
            return str4;
        }
        return str2 + "/" + str + "/" + subLocale + "/" + str3;
    }

    private static String getSubLocale(Iterator<String> it) {
        String language = DeviceInfoUtil.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith(language)) {
                return next;
            }
        }
        return null;
    }

    private static JSONObject getTextResourceByLanguage(JSONObject jSONObject) throws InternalException.WrongMarketingDataException, InternalException.LocaleNotMatchException {
        try {
            String locale = DeviceInfoUtil.getLocale();
            if (!jSONObject.has(locale)) {
                locale = getSubLocale(jSONObject.keys());
                if (TextUtils.isEmpty(locale)) {
                    StringBuilder sb = new StringBuilder();
                    Locale locale2 = Locale.US;
                    sb.append(locale2.getLanguage());
                    sb.append("_");
                    sb.append(locale2.getCountry());
                    locale = sb.toString();
                    if (!jSONObject.has(locale)) {
                        throw new InternalException.LocaleNotMatchException();
                    }
                    SmpLog.m6492d(TAG, "use default locale");
                } else {
                    SmpLog.m6492d(TAG, "use sub locale : " + locale);
                }
            }
            return jSONObject.getJSONObject(locale);
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "invalid text resource. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }

    private boolean isValidFilter(MarketingFilter marketingFilter) {
        JSONArray installPkg = marketingFilter.getInstallPkg();
        int installCount = marketingFilter.getInstallCount();
        if (installPkg != null && (installPkg.length() < installCount || installCount <= 0)) {
            return false;
        }
        JSONArray notInstallPkg = marketingFilter.getNotInstallPkg();
        int notInstallCount = marketingFilter.getNotInstallCount();
        if (notInstallPkg != null) {
            return notInstallPkg.length() >= notInstallCount && notInstallCount > 0;
        }
        return true;
    }

    private boolean isValidTime(String str, MarketingDisplayTime marketingDisplayTime, int i, int i2, long j, int i4, int[] iArr) {
        if (!MarketingConstants.TIME_BASE_UTC0.equals(marketingDisplayTime.timeBase) && !"local".equals(marketingDisplayTime.timeBase)) {
            SmpLog.m6494e(TAG, "invalid timeBase");
            return false;
        }
        PairTime<TimeUtil.Time> pairTime = marketingDisplayTime.displayTime;
        if (!isValidTimeRange(str, pairTime.start, pairTime.end, false)) {
            SmpLog.m6495e(TAG, str, "invalid displayTime");
            return false;
        }
        PairTime<TimeUtil.Time> pairTime2 = marketingDisplayTime.doNotDisturbTime;
        if (!isValidTimeRange(str, pairTime2.start, pairTime2.end, true)) {
            SmpLog.m6495e(TAG, str, "invalid doNotDisturbTime");
            return false;
        }
        if (marketingDisplayTime.ttl.start.longValue() < 0 || marketingDisplayTime.ttl.end.longValue() < 0 || marketingDisplayTime.ttl.start.longValue() >= marketingDisplayTime.ttl.end.longValue()) {
            SmpLog.m6495e(TAG, str, "invalid ttl");
            return false;
        }
        if (TimeUtil.isInvalidRandom(i)) {
            SmpLog.m6495e(TAG, str, "invalid random");
            return false;
        }
        if (i2 < -1) {
            SmpLog.m6495e(TAG, str, "invalid cctime");
            return false;
        }
        if (j < 0 || j > marketingDisplayTime.ttl.end.longValue()) {
            SmpLog.m6495e(TAG, str, "invalid clearTime");
            return false;
        }
        if (i4 < 0) {
            SmpLog.m6495e(TAG, str, "invalid screenOnTime");
            return false;
        }
        if (iArr[0] <= iArr[1]) {
            return true;
        }
        SmpLog.m6494e(TAG, "invalid feedbackDispersion");
        return false;
    }

    private boolean isValidTimeRange(String str, TimeUtil.Time time, TimeUtil.Time time2, boolean z) {
        if (z && time.getHour() == -1 && time2.getHour() == -1) {
            return true;
        }
        if (TimeUtil.isInvalidHour(time.getHour()) || TimeUtil.isInvalidHour(time2.getHour())) {
            SmpLog.m6495e(TAG, str, "invalid time range : hour");
            return false;
        }
        if (TimeUtil.isInvalidMinute(time.getMin()) || TimeUtil.isInvalidMinute(time2.getMin())) {
            SmpLog.m6495e(TAG, str, "invalid time range : min");
            return false;
        }
        if (time.getHour() != time2.getHour() || time.getMin() != time2.getMin()) {
            return true;
        }
        SmpLog.m6495e(TAG, str, "invalid time range : start and end time are same");
        return false;
    }

    public static AppData parseAppData(String str) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "appdata is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new AppData(jSONObject.optString("mid", null), jSONObject.optString("type", null), jSONObject.optString("userdata", null), jSONObject.optString(MarketingConstants.CUSTOM_CONTENT, null));
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "invalid appdata. " + e.toString());
            return null;
        }
    }

    public static PairTime<TimeUtil.Time> parseDisplayTime(String str, JSONObject jSONObject) throws InternalException.WrongMarketingDataException {
        List timeList = parseTimeList(str, jSONObject, "cardDisplayTime", Integer.class);
        List timeList2 = parseTimeList(str, jSONObject, "cardDisplayTimeMin", Integer.class, MarketingConstants.DEFAULT_TIME_MIN);
        return new PairTime<>(new TimeUtil.Time(((Integer) timeList.get(0)).intValue(), ((Integer) timeList2.get(0)).intValue()), new TimeUtil.Time(((Integer) timeList.get(1)).intValue(), ((Integer) timeList2.get(1)).intValue()));
    }

    private static PairTime<TimeUtil.Time> parseDoNotDisturbTime(String str, JSONObject jSONObject, String str2) {
        List<Integer> timeList;
        List listAsList;
        if ("local".equals(str2)) {
            listAsList = Arrays.asList(-1, -1);
            timeList = MarketingConstants.DEFAULT_TIME_MIN;
        } else {
            List timeList2 = parseTimeList(str, jSONObject, MarketingConstants.DO_NOT_DISTURB_TIME, Integer.class, MarketingConstants.DEFAULT_DO_NOT_DISTURB_TIME);
            timeList = parseTimeList(str, jSONObject, MarketingConstants.DO_NOT_DISTURB_TIME_MIN, Integer.class, MarketingConstants.DEFAULT_TIME_MIN);
            listAsList = timeList2;
        }
        return new PairTime<>(new TimeUtil.Time(((Integer) listAsList.get(0)).intValue(), timeList.get(0).intValue()), new TimeUtil.Time(((Integer) listAsList.get(1)).intValue(), timeList.get(1).intValue()));
    }

    private int[] parseFeedbackDispersion(JSONArray jSONArray) throws InternalException.WrongMarketingDataException {
        int[] iArr = new int[2];
        if (jSONArray == null) {
            iArr[0] = 1;
            iArr[1] = 10;
            return iArr;
        }
        if (jSONArray.length() != 2) {
            throw new InternalException.WrongMarketingDataException();
        }
        iArr[0] = jSONArray.getInt(0);
        iArr[1] = jSONArray.getInt(1);
        return iArr;
    }

    public static MarketingDisplayTime parseMarketingDisplayTime(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(MarketingConstants.TIME_BASE, "local");
        return new MarketingDisplayTime(strOptString, parseTtlTime(str, jSONObject), parseDisplayTime(str, jSONObject), parseDoNotDisturbTime(str, jSONObject, strOptString));
    }

    public static void parseResource(Context context, Marketing marketing) {
        try {
            String file = FileIOUtil.readFile(FilePathUtil.getTxtFilePath(context, marketing.getMid()));
            JSONObject textResourceByLanguage = getTextResourceByLanguage(new JSONObject(file.substring(file.indexOf(123), file.lastIndexOf(125) + 1)));
            MarketingParser parser = getParser(marketing);
            parser.parseTextContents(context, marketing, textResourceByLanguage);
            parser.parseImageContents(context, marketing);
            marketing.setToResourceParsed();
        } catch (IndexOutOfBoundsException | JSONException e) {
            SmpLog.m6495e(TAG, marketing.getMid(), "invalid resource. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }

    public static Pair<String, String> parseResourceUrl(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return new Pair<>(null, null);
        }
        String contentsTypePolicy = PrefManager.getInstance(context).getContentsTypePolicy();
        return !TextUtils.isEmpty(contentsTypePolicy) ? parseResourceUrlByPolicy(context, jSONObject, contentsTypePolicy) : parseResourceUrlForType(DeviceInfoUtil.getContentsType(context), jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        if (r5.equals("type1") != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        return getResourceUrl(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (r5.equals("type2") != false) goto L12;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<String, String> parseResourceUrlByPolicy(Context context, JSONObject jSONObject, String str) {
        String str2 = TAG;
        SmpLog.m6498i(str2, "contents type policy: " + str);
        int iHashCode = str.hashCode();
        if (iHashCode != -1600030548) {
            switch (iHashCode) {
                case 110843961:
                    str.equals("type3");
                    break;
            }
        } else if (str.equals(DeviceInfoUtil.CONTENTS_TYPE_RESOLUTION)) {
            return getResourceUrl(jSONObject, DeviceInfoUtil.getContentsTypeByResolution(context));
        }
        SmpLog.m6498i(str2, "invalid contents type policy: ".concat(str));
        return new Pair<>(null, null);
    }

    private static Pair<String, String> parseResourceUrlForType(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString("type1");
        return "type1".equals(str) ? TextUtils.isEmpty(strOptString) ? new Pair<>(null, null) : getResourceUrl(jSONObject, "type1") : "type3".equals(str) ? getResourceUrl(jSONObject, "type3") : TextUtils.isEmpty(jSONObject.optString("type2")) ? TextUtils.isEmpty(strOptString) ? new Pair<>(null, null) : new Pair<>(strOptString, "type1") : getResourceUrl(jSONObject, "type2");
    }

    private static <T> List<T> parseTimeList(String str, JSONObject jSONObject, String str2, Class<T> cls) throws InternalException.WrongMarketingDataException {
        String[] strArrSplit = replaceWhiteSpace(jSONObject.getString(str2)).split(",");
        if (strArrSplit.length != 2) {
            SmpLog.m6495e(TAG, str, "invalid " + str2);
            throw new InternalException.WrongMarketingDataException();
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrSplit) {
            if (Integer.class.equals(cls)) {
                arrayList.add(cls.cast(Integer.valueOf(Integer.parseInt(str3))));
            } else if (Long.class.equals(cls)) {
                arrayList.add(cls.cast(Long.valueOf(Long.parseLong(str3))));
            } else {
                arrayList.add(cls.cast(str3));
            }
        }
        return arrayList;
    }

    private static PairTime<Long> parseTtlTime(String str, JSONObject jSONObject) throws InternalException.WrongMarketingDataException {
        List timeList = parseTimeList(str, jSONObject, "ttl", Long.class);
        return new PairTime<>((Long) timeList.get(0), (Long) timeList.get(1));
    }

    private static String replaceWhiteSpace(String str) {
        return str.replaceAll("\\p{Space}", "");
    }

    public String applyLRMUnicode(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = z ? "<br>" : "\n";
        return "\u200e" + str.replaceAll("(?i)".concat(str2), str2.concat("\u200e"));
    }

    public abstract void parseImageContents(Context context, Marketing marketing);

    public abstract void parseTextContents(Context context, Marketing marketing, JSONObject jSONObject);

    public void parseUserData(Context context, Marketing marketing, JSONObject jSONObject) {
        try {
            marketing.setStyle(jSONObject.getJSONObject("st"));
            MarketingDisplayTime marketingDisplayTime = parseMarketingDisplayTime(marketing.getMid(), jSONObject);
            long jOptLong = jSONObject.optLong(MarketingConstants.CLEAR_TIME, 0L);
            if (jOptLong == 0) {
                SmpLog.m6499i(TAG, marketing.getMid(), "replace clearTime to ttl end");
                jOptLong = marketingDisplayTime.ttl.end.longValue();
            }
            int iOptInt = jSONObject.optInt("random", 60);
            int iOptInt2 = jSONObject.optInt(MarketingConstants.CCTIME, 0);
            int iOptInt3 = jSONObject.optInt(MarketingConstants.SCREEN_ON_TIME, 0);
            int[] feedbackDispersion = parseFeedbackDispersion(jSONObject.optJSONArray(MarketingConstants.FEEDBACK_DISPERSION));
            if (!isValidTime(marketing.getMid(), marketingDisplayTime, iOptInt, iOptInt2, jOptLong, iOptInt3, feedbackDispersion)) {
                throw new InternalException.WrongMarketingDataException();
            }
            marketing.setFeedbackDispersionMin(feedbackDispersion[0]);
            marketing.setFeedbackDispersionMax(feedbackDispersion[1]);
            marketing.setTimeBase(marketingDisplayTime.timeBase);
            marketing.setDisplayTimeStart(marketingDisplayTime.displayTime.start);
            marketing.setDisplayTimeEnd(marketingDisplayTime.displayTime.end);
            marketing.setDoNotDisturbTimeStart(marketingDisplayTime.doNotDisturbTime.start);
            marketing.setDoNotDisturbTimeEnd(marketingDisplayTime.doNotDisturbTime.end);
            marketing.setTtlStartMillis(marketingDisplayTime.ttl.start.longValue());
            marketing.setTtlEndMillis(marketingDisplayTime.ttl.end.longValue());
            marketing.setClearTimeMillis(jOptLong);
            marketing.setRandomMinutes(iOptInt);
            marketing.setCctimeMinutes(iOptInt2);
            marketing.setPLink(jSONObject.optBoolean(MarketingConstants.P_LINK, false));
            if (DeviceInfoUtil.isSamsungPushService(context)) {
                marketing.setScreenOnTimeMinutes(iOptInt3);
            }
            marketing.setContentsUrl(jSONObject.getJSONObject("contents"));
            int iOptInt4 = jSONObject.optInt(MarketingConstants.CHANNEL, 2);
            if (iOptInt4 != 1 && iOptInt4 != 2) {
                iOptInt4 = 1;
            }
            marketing.setChannelType(iOptInt4);
            if (jSONObject.has("filter")) {
                MarketingFilter marketingFilter = new MarketingFilter();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(MarketingConstants.FILTER_INSTALL);
                if (jSONObjectOptJSONObject2 != null) {
                    marketingFilter.setInstallPkg(jSONObjectOptJSONObject2.getJSONArray("pkg"));
                    marketingFilter.setInstallCount(jSONObjectOptJSONObject2.getInt("count"));
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(MarketingConstants.FILTER_NOT_INSTALL);
                if (jSONObjectOptJSONObject3 != null) {
                    marketingFilter.setNotInstallPkg(jSONObjectOptJSONObject3.getJSONArray("pkg"));
                    marketingFilter.setNotInstallCount(jSONObjectOptJSONObject3.getInt("count"));
                }
                if (!isValidFilter(marketingFilter)) {
                    throw new InternalException.WrongMarketingDataException();
                }
                marketing.setFilter(marketingFilter);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(MarketingConstants.FREQUENCY_CAPPING);
            if (jSONArrayOptJSONArray == null) {
                marketing.setFreqCapping(-1, -1, -1, -1);
            } else {
                marketing.setFreqCapping(jSONArrayOptJSONArray.getInt(0), jSONArrayOptJSONArray.getInt(1), jSONArrayOptJSONArray.getInt(2), jSONArrayOptJSONArray.getInt(3));
            }
            marketing.setUndeletable(jSONObject.optBoolean("undeletable", false));
        } catch (Exception e) {
            SmpLog.m6495e(TAG, marketing.getMid(), "invalid userdata. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }

    private static String getSubLocale(JSONArray jSONArray) throws JSONException {
        String language = DeviceInfoUtil.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            if (string.startsWith(language)) {
                return string;
            }
        }
        return null;
    }

    public static Marketing parseAppData(Context context, String str, String str2, String str3, int i) throws InternalException.WrongMarketingDataException, InternalException.NotSupportedTypeException {
        if (str != null && str2 != null && str3 != null && i >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Marketing marketingByMarketingType = Marketing.getMarketingByMarketingType(context, str, str2, jSONObject.getString(MarketingConstants.MARKETING_TYPE), i);
                getParser(marketingByMarketingType).parseUserData(context, marketingByMarketingType, jSONObject);
                if (marketingByMarketingType.isSupportType()) {
                    return marketingByMarketingType;
                }
                throw new InternalException.NotSupportedTypeException();
            } catch (JSONException e) {
                SmpLog.m6495e(TAG, str, "invalid appdata. " + e.toString());
                throw new InternalException.WrongMarketingDataException();
            }
        }
        SmpLog.m6495e(TAG, str, "invalid appdata");
        throw new InternalException.WrongMarketingDataException();
    }

    private static <T> List<T> parseTimeList(String str, JSONObject jSONObject, String str2, Class<T> cls, List<T> list) {
        if (!jSONObject.has(str2)) {
            SmpLog.m6498i(TAG, str2 + " not found. set to default");
            return list;
        }
        return parseTimeList(str, jSONObject, str2, cls);
    }
}
