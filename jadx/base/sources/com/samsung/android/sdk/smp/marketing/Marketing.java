package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.network.NetworkManager;
import com.samsung.android.sdk.smp.common.network.NetworkResult;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariableManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.FilePathUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.common.util.TimeUtil;
import com.samsung.android.sdk.smp.display.DisplayManager;
import com.samsung.android.sdk.smp.display.DisplayMeta;
import com.samsung.android.sdk.smp.display.DisplayResultHandler;
import com.samsung.android.sdk.smp.task.SMarketingTask;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Marketing implements DisplayMeta {
    private static final int[] CANCEL_DELAY_TIME_DIVIDER = {6, 3, 2};
    private static final long CANCEL_RETRY_DELAY_TIME_MAX = Constants.HOURMILLIS;
    private static final long[] CANCEL_RETRY_DELAY_TIME_MIN;
    private static final String TAG = "Marketing";
    private int mCctimeMinutes;
    private int mChannelType;
    private long mClearTimeMillis;
    private JSONObject mContentsUrl;
    private final int mDisplayId;
    private int mDisplayTimeHourEnd;
    private int mDisplayTimeHourStart;
    private int mDisplayTimeMinEnd;
    private int mDisplayTimeMinStart;
    private int mDoNotDisturbTimeHourEnd;
    private int mDoNotDisturbTimeHourStart;
    private int mDoNotDisturbTimeMinEnd;
    private int mDoNotDisturbTimeMinStart;
    private long mExpectedDisplayTimeMillis;
    private int mFeedbackDispersionMax;
    private int mFeedbackDispersionMin;
    private MarketingFilter mFilter;
    private int mFreqCapping_Day;
    private int mFreqCapping_DayLimit;
    private int mFreqCapping_Hour;
    private int mFreqCapping_HourLimit;
    private boolean mIsResourceParsed;
    private final String mMarketingType;
    private final String mMid;
    private final String mMsgType;
    private boolean mPLink;
    private int mRandomMinutes;
    private int mScreenOnTimeMinutes;
    private JSONObject mStyle;
    private String mTimeBase;
    private long mTtlEndMillis;
    private long mTtlStartMillis;
    private boolean mUndeletable;

    static {
        long j = Constants.MINMILLIS;
        CANCEL_RETRY_DELAY_TIME_MIN = new long[]{5 * j, 10 * j, j * 15};
    }

    public Marketing(String str, String str2, String str3, int i) {
        this.mMid = str;
        this.mMsgType = str2;
        this.mMarketingType = str3;
        this.mDisplayId = i;
    }

    private List<TimeUtil.TimeRange> adjustDisplayTimeRange() throws InternalException.DisplayErrorDueToDoNotDisturbTimeException {
        String str;
        ArrayList arrayList = new ArrayList();
        TimeUtil.Time displayTimeStart = getDisplayTimeStart();
        TimeUtil.Time displayTimeEnd = getDisplayTimeEnd();
        TimeUtil.Time doNotDisturbTimeStart = getDoNotDisturbTimeStart();
        TimeUtil.Time doNotDisturbTimeEnd = getDoNotDisturbTimeEnd();
        String str2 = TAG;
        SmpLog.m6499i(str2, getMid(), "displayTime in local : [" + displayTimeStart.toString() + "~" + displayTimeEnd.toString() + "), doNotDisturbTime : [" + doNotDisturbTimeStart.toString() + "~" + doNotDisturbTimeEnd.toString() + ")");
        if (isDoNotDisturbTimeOff()) {
            arrayList.add(new TimeUtil.TimeRange(displayTimeStart, displayTimeEnd));
            SmpLog.m6499i(str2, getMid(), "doNotDisturbTime is off. display range : " + ((TimeUtil.TimeRange) arrayList.get(0)).toString());
            return arrayList;
        }
        if (TimeUtil.isTimeInBetween(displayTimeStart, displayTimeEnd, doNotDisturbTimeStart)) {
            if (!isDoNotDisturbEndInBetweenDisplayTime(displayTimeStart, displayTimeEnd, doNotDisturbTimeEnd)) {
                arrayList.add(new TimeUtil.TimeRange(displayTimeStart, doNotDisturbTimeStart));
            } else if (TimeUtil.isTimeInBetween(doNotDisturbTimeStart, doNotDisturbTimeEnd, displayTimeStart)) {
                arrayList.add(new TimeUtil.TimeRange(doNotDisturbTimeEnd, doNotDisturbTimeStart));
            } else {
                arrayList.add(new TimeUtil.TimeRange(displayTimeStart, doNotDisturbTimeStart));
                arrayList.add(new TimeUtil.TimeRange(doNotDisturbTimeEnd, displayTimeEnd));
            }
        } else if (isDoNotDisturbEndInBetweenDisplayTime(displayTimeStart, displayTimeEnd, doNotDisturbTimeEnd)) {
            arrayList.add(new TimeUtil.TimeRange(doNotDisturbTimeEnd, displayTimeEnd));
        } else {
            if (TimeUtil.isTimeInBetween(doNotDisturbTimeStart, doNotDisturbTimeEnd, displayTimeStart)) {
                SmpLog.m6494e(str2, "display not available after applying doNotDisturbTime");
                throw new InternalException.DisplayErrorDueToDoNotDisturbTimeException();
            }
            arrayList.add(new TimeUtil.TimeRange(displayTimeStart, displayTimeEnd));
        }
        String mid = getMid();
        StringBuilder sb = new StringBuilder("updated display range : ");
        sb.append(((TimeUtil.TimeRange) arrayList.get(0)).toString());
        if (arrayList.size() == 2) {
            str = SQLKeyword.COMMA + ((TimeUtil.TimeRange) arrayList.get(1)).toString();
        } else {
            str = "";
        }
        sb.append(str);
        SmpLog.m6499i(str2, mid, sb.toString());
        return arrayList;
    }

    private void applyRandomTimeForDisplay(Calendar calendar, int i, int i2, long j, int i4) {
        long timeInMillis = j - calendar.getTimeInMillis();
        long j2 = Constants.MINMILLIS;
        if (timeInMillis <= j2 * 30) {
            SmpLog.m6499i(TAG, this.mMid, "do not random display. less than 30 min left until ttlEnd");
            return;
        }
        long j3 = ((((long) (i2 - calendar.get(12))) * j2) + (((long) (i - calendar.get(11))) * Constants.HOURMILLIS)) - ((long) calendar.get(13));
        if (j3 < 0) {
            j3 += Constants.DAYMILLIS;
        }
        long j5 = ((long) i4) * j2;
        if (j5 <= j3) {
            j3 = j5;
        }
        if (j3 > timeInMillis - (j2 * 30)) {
            j3 = timeInMillis - (30 * j2);
        }
        long randomMillis = TimeUtil.getRandomMillis(0L, j3);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + randomMillis);
        String str = TAG;
        String str2 = this.mMid;
        StringBuilder sb = new StringBuilder("random display(s):");
        sb.append(randomMillis / Constants.SECMILLIS);
        sb.append(", display(m):");
        sb.append(randomMillis / j2);
        sb.append(", range(m) : [0,");
        SmpLog.m6499i(str, str2, AbstractC2821a.m2224o(sb, "]", j3 / j2));
    }

    private long calculateDisplayTimeForOneRange(Context context, TimeUtil.Time time, TimeUtil.Time time2, Calendar calendar) {
        Calendar calendar2;
        long ttlStartMillis = getTtlStartMillis();
        long ttlEndMillis = getTtlEndMillis();
        int randomMinutes = getRandomMinutes();
        if (!TimeUtil.isTimeInBetween(time, time2, calendar.get(11), calendar.get(12))) {
            TimeUtil.setTime(calendar, time.getHour(), time.getMin(), 0);
            if (calendar.getTimeInMillis() < ttlStartMillis || calendar.getTimeInMillis() < System.currentTimeMillis()) {
                calendar.setTimeInMillis(calendar.getTimeInMillis() + Constants.DAYMILLIS);
            }
        }
        if (needRandomDisplay(context)) {
            calendar2 = calendar;
            applyRandomTimeForDisplay(calendar2, time2.getHour(), time2.getMin(), ttlEndMillis, randomMinutes);
        } else {
            calendar2 = calendar;
        }
        return calendar2.getTimeInMillis();
    }

    private long calculateDisplayTimeForTwoRanges(Context context, TimeUtil.TimeRange timeRange, TimeUtil.TimeRange timeRange2, Calendar calendar) {
        if (canIgnoreRange1(timeRange, timeRange2, calendar.get(11), calendar.get(12))) {
            SmpLog.m6500v(TAG, "can ignore range " + timeRange.toString() + ". calculate display time with range " + timeRange2.toString());
            return calculateDisplayTimeForOneRange(context, timeRange2.getStartTime(), timeRange2.getEndTime(), calendar);
        }
        int timeDiffMin = TimeUtil.getTimeDiffMin(timeRange.getEndTime(), timeRange2.getStartTime());
        long j = ((long) timeDiffMin) * Constants.MINMILLIS;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + j);
        TimeUtil.Time timeShiftTime = TimeUtil.shiftTime(timeRange.getStartTime(), j);
        String str = TAG;
        SmpLog.m6500v(str, "shift " + timeRange.getStartTime().toString() + " to " + timeShiftTime.toString() + ". shifted:" + timeDiffMin + "(m)");
        long jCalculateDisplayTimeForOneRange = calculateDisplayTimeForOneRange(context, timeShiftTime, timeRange2.getEndTime(), calendar);
        if (!TimeUtil.isTimeInBetween(timeRange.getEndTime(), timeRange2.getStartTime(), jCalculateDisplayTimeForOneRange)) {
            return jCalculateDisplayTimeForOneRange;
        }
        SmpLog.m6500v(str, "calculated display time is not in display time range. shift time back");
        return jCalculateDisplayTimeForOneRange - j;
    }

    private static boolean canChangeStateToFail(MarketingState marketingState) {
        return MarketingState.INCOMP_GET_STATUS_API.equals(marketingState) || MarketingState.INCOMP_RESOURCE.equals(marketingState) || MarketingState.INCOMP_DISPLAY.equals(marketingState);
    }

    private boolean canIgnoreRange1(TimeUtil.TimeRange timeRange, TimeUtil.TimeRange timeRange2, int i, int i2) {
        return TimeUtil.isTimeInBetween(timeRange.getEndTime(), timeRange2.getEndTime(), i, i2);
    }

    private boolean checkDisplayTime(Context context, boolean z) {
        if (isOverTtl(context)) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        if (!z) {
            calendar.setTimeInMillis(getExpectedDisplayTimeMillis());
        }
        if (isValidDisplayTimeRange(calendar.getTimeInMillis())) {
            return true;
        }
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        SmpLog.m6502w(TAG, this.mMid, "not valid display time range. " + TimeUtil.timeToString(i, i2) + " is not in " + getDisplayTimeStart().toString() + "~" + getDisplayTimeEnd().toString());
        try {
            updateExpectedDisplayTime(context);
            if (isOverTtl(context)) {
                return false;
            }
            if (!z) {
                return true;
            }
            setAlarmForDisplay(context);
            return false;
        } catch (InternalException.DBException unused) {
            setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.DB_ERROR);
            return false;
        } catch (InternalException.DisplayErrorDueToDoNotDisturbTimeException unused2) {
            setToFail(context, FeedbackEvent.CONSUME_FAIL, FeedbackDetailConstants.FAIL_DUE_TO_DO_NOT_DISTURB_TIME);
            return false;
        }
    }

    private boolean checkFilterInstall(Context context) {
        JSONArray installPkg = this.mFilter.getInstallPkg();
        int installCount = this.mFilter.getInstallCount();
        if (installPkg == null) {
            SmpLog.m6492d(TAG, "installArray is null");
            return true;
        }
        for (int i = 0; i < installPkg.length(); i++) {
            try {
                if (DeviceInfoUtil.isPkgInstalled(context, installPkg.getString(i)) && installCount - 1 <= 0) {
                    return true;
                }
            } catch (Exception e) {
                AbstractC6670b.m4737B(e, new StringBuilder("checkFilterInstall exception: "), TAG);
            }
        }
        return false;
    }

    private boolean checkFilterNotInstall(Context context) {
        JSONArray notInstallPkg = this.mFilter.getNotInstallPkg();
        int notInstallCount = this.mFilter.getNotInstallCount();
        if (notInstallPkg == null) {
            SmpLog.m6492d(TAG, "notInstallArray is null");
            return true;
        }
        for (int i = 0; i < notInstallPkg.length(); i++) {
            try {
                if (!DeviceInfoUtil.isPkgInstalled(context, notInstallPkg.getString(i)) && notInstallCount - 1 <= 0) {
                    return true;
                }
            } catch (Exception e) {
                AbstractC6670b.m4737B(e, new StringBuilder("checkFilterNotInstall exception: "), TAG);
            }
        }
        return false;
    }

    private boolean checkFilterPkg(Context context) {
        if (this.mFilter == null) {
            SmpLog.m6492d(TAG, "mFilter is null");
            return true;
        }
        if (!checkFilterInstall(context)) {
            setToFail(context, FeedbackEvent.INSTALL_CHECK_FAIL, null);
            return false;
        }
        if (checkFilterNotInstall(context)) {
            return true;
        }
        setToFail(context, FeedbackEvent.NOT_INSTALL_CHECK_FAIL, null);
        return false;
    }

    private boolean checkFrequencyCapping(Context context) {
        DBHandler dBHandlerOpen;
        if (isTestMsg() || isFreqCappingOff() || (dBHandlerOpen = DBHandler.open(context)) == null) {
            return true;
        }
        try {
            if (dBHandlerOpen.countMarketingsDisplayedIn(((long) this.mFreqCapping_Day) * Constants.DAYMILLIS) >= this.mFreqCapping_DayLimit) {
                SmpLog.m6502w(TAG, this.mMid, "over frequency capping rule(day)");
                setToFail(context, FeedbackEvent.FC_LIMIT_OVER, null);
                return false;
            }
            if (dBHandlerOpen.countMarketingsDisplayedIn(((long) this.mFreqCapping_Hour) * Constants.HOURMILLIS) < this.mFreqCapping_HourLimit) {
                return true;
            }
            SmpLog.m6502w(TAG, this.mMid, "over frequency capping rule(hour)");
            setToFail(context, FeedbackEvent.FC_LIMIT_OVER, null);
            return false;
        } finally {
            dBHandlerOpen.close();
        }
    }

    private boolean checkOptIn(Context context) {
        if (!"marketing".equals(getMsgType())) {
            return true;
        }
        PrefManager prefManager = PrefManager.getInstance(context);
        if (SmpConstants.OptInPolicy.INTEGRATED_BASED.equals(prefManager.getOptinPolicy()) && !TextUtils.isEmpty(prefManager.getUID())) {
            SmpLog.m6499i(TAG, this.mMid, "account based opt-in. skip checking opt in");
            return true;
        }
        boolean optIn = prefManager.getOptIn();
        if (!optIn) {
            SmpLog.m6502w(TAG, this.mMid, "fail to display. currently opt out.");
            setToFail(context, FeedbackEvent.DISAGREE, null);
        }
        return optIn;
    }

    public static Marketing getMarketingByMarketingType(Context context, String str, String str2, String str3, int i) throws InternalException.NotSupportedTypeException {
        if ("1".equals(str3)) {
            return new NotificationMarketing(str, str2, str3, i);
        }
        if ("2".equals(str3)) {
            return new PopupMarketing(str, str2, str3, i);
        }
        SmpLog.m6495e(TAG, str, "invalid marketingtype : " + str3);
        throw new InternalException.NotSupportedTypeException();
    }

    private long getMarketingStatusAlarmTime() {
        return this.mExpectedDisplayTimeMillis - (((long) this.mCctimeMinutes) * Constants.MINMILLIS);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[PHI: r2
      0x001c: PHI (r2v4 long) = (r2v2 long), (r2v6 long), (r2v7 long) binds: [B:15:0x003a, B:12:0x002a, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long getMarketingStatusRetryDelayTime(int i) {
        long j;
        long j2;
        long j3 = ((long) this.mCctimeMinutes) * Constants.MINMILLIS;
        if (i == 0 || i == 1) {
            j = j3 / ((long) CANCEL_DELAY_TIME_DIVIDER[0]);
            j2 = CANCEL_RETRY_DELAY_TIME_MIN[0];
            if (j < j2) {
                j = j2;
            }
        } else if (i != 2) {
            j = j3 / ((long) CANCEL_DELAY_TIME_DIVIDER[2]);
            j2 = CANCEL_RETRY_DELAY_TIME_MIN[2];
            if (j < j2) {
            }
        } else {
            j = j3 / ((long) CANCEL_DELAY_TIME_DIVIDER[1]);
            j2 = CANCEL_RETRY_DELAY_TIME_MIN[1];
            if (j < j2) {
            }
        }
        long j5 = CANCEL_RETRY_DELAY_TIME_MAX;
        return j > j5 ? j5 : j;
    }

    private long getScreenOnAlarmTime() {
        return this.mExpectedDisplayTimeMillis - (((long) this.mScreenOnTimeMinutes) * Constants.MINMILLIS);
    }

    private boolean isDoNotDisturbEndInBetweenDisplayTime(TimeUtil.Time time, TimeUtil.Time time2, TimeUtil.Time time3) {
        return TimeUtil.isTimeInBetween(time, time2, time3) && !TimeUtil.equals(time, time3);
    }

    private boolean isDoNotDisturbTimeOff() {
        return getDoNotDisturbTimeStart().getHour() == -1;
    }

    private boolean isFreqCappingOff() {
        return this.mFreqCapping_Day == -1 && this.mFreqCapping_DayLimit == -1 && this.mFreqCapping_Hour == -1 && this.mFreqCapping_HourLimit == -1;
    }

    private boolean isLocalTimeBase() {
        return "local".equals(getTimeBase());
    }

    private boolean isOverTtl(Context context) {
        long ttlEndMillis = getTtlEndMillis();
        if (ttlEndMillis >= System.currentTimeMillis() && ttlEndMillis >= getExpectedDisplayTimeMillis()) {
            return false;
        }
        String str = TAG;
        SmpLog.m6499i(str, this.mMid, "current:" + TimeUtil.getString(System.currentTimeMillis()) + ", until:" + TimeUtil.getString(ttlEndMillis));
        SmpLog.m6495e(str, this.mMid, "over display time");
        if (DeviceInfoUtil.isPowerSaveMode(context)) {
            setToFail(context, FeedbackEvent.POWER_SAVING_MODE, null);
            return true;
        }
        if (DeviceInfoUtil.isDataSaverMode(context)) {
            setToFail(context, FeedbackEvent.DATA_SAVER_MODE, null);
            return true;
        }
        setToFail(context, FeedbackEvent.CONSUME_FAIL, null);
        return true;
    }

    private boolean isValidDisplayTimeRange(long j) {
        return TimeUtil.isTimeInBetween(getDisplayTimeStart(), getDisplayTimeEnd(), getDoNotDisturbTimeStart(), getDoNotDisturbTimeEnd(), j);
    }

    private boolean needRandomDisplay(Context context) {
        if (isTestMsg()) {
            SmpLog.m6499i(TAG, this.mMid, "skip random display : test message");
            return false;
        }
        if (!SharedMemoryVariableManager.getInstance(context).isRunningRealtimeMidInFcmService(getMid())) {
            return true;
        }
        SmpLog.m6499i(TAG, this.mMid, "skip random display : real time marketing");
        return false;
    }

    private boolean needToCallGetMarketingStatusApi() {
        return (isTestMsg() || this.mCctimeMinutes == -1) ? false : true;
    }

    private void onGetMarketingStatusFail(Context context, int i) {
        if (DeviceInfoUtil.isPowerSaveMode(context)) {
            setToFail(context, this.mMid, FeedbackEvent.POWER_SAVING_MODE, null);
            return;
        }
        if (DeviceInfoUtil.isDataSaverMode(context)) {
            setToFail(context, this.mMid, FeedbackEvent.DATA_SAVER_MODE, null);
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, this.mMid, "db open fail");
            return;
        }
        try {
            int marketingFailCount = dBHandlerOpen.getMarketingFailCount(this.mMid);
            if (i != 1002) {
                marketingFailCount++;
                dBHandlerOpen.updateMarketingFailCount(this.mMid, marketingFailCount);
            }
            if (400 <= i && i < 500) {
                dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.INCOMP_DISPLAY);
                dBHandlerOpen.updateMarketingFailCount(this.mMid, 0);
                FeedbackManager.addFeedback(context, this.mMid, FeedbackEvent.GET_MARKETING_STATUS_FAIL, "" + i);
                setAlarmForDisplay(context);
            } else if (marketingFailCount > 3) {
                dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.INCOMP_DISPLAY);
                dBHandlerOpen.updateMarketingFailCount(this.mMid, 0);
                FeedbackManager.addFeedback(context, this.mMid, FeedbackEvent.GET_MARKETING_STATUS_FAIL, "C1009_" + i);
                setAlarmForDisplay(context);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis() + getMarketingStatusRetryDelayTime(marketingFailCount);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_GET_MARKETING_STATUS);
                STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, this.mMid), jCurrentTimeMillis, 0);
            }
            dBHandlerOpen.close();
        } catch (Throwable th) {
            dBHandlerOpen.close();
            throw th;
        }
    }

    private void onGetMarketingStatusSuccess(Context context, String str) {
        if (str == null) {
            onGetMarketingStatusFail(context, 1015);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("status");
            long j = jSONObject.getLong(MarketingConstants.RESPONSE_KEY_SERVER_TIMESTAMP);
            int i2 = jSONObject.getInt(MarketingConstants.RESPONSE_KEY_TIP);
            if (i != 200) {
                if (i == 400) {
                    setToCanceled(context);
                    return;
                } else if (i != 300) {
                    if (i != 301) {
                        onGetMarketingStatusFail(context, 1015);
                        return;
                    } else {
                        setToFail(context, this.mMid, FeedbackEvent.DISAGREE, null);
                        return;
                    }
                }
            }
            DBHandler dBHandlerOpen = DBHandler.open(context);
            if (dBHandlerOpen != null) {
                if (System.currentTimeMillis() - j > ((long) i2) * Constants.SECMILLIS || j >= getTtlEndMillis()) {
                    setToFail(context, FeedbackEvent.USER_CHANGE_DATE_AND_TIME_ERROR, null);
                    dBHandlerOpen.close();
                } else {
                    dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.INCOMP_DISPLAY);
                    dBHandlerOpen.updateMarketingFailCount(this.mMid, 0);
                    dBHandlerOpen.close();
                    setAlarmForDisplay(context);
                }
            }
        } catch (JSONException e) {
            SmpLog.m6495e(TAG, this.mMid, "fail to get marketing status. " + e.toString());
            onGetMarketingStatusFail(context, 1015);
        }
    }

    private void onResourceDownloadFail(Context context, int i) {
        if (400 <= i && i < 500) {
            setToFail(context, this.mMid, FeedbackEvent.DOWNLOAD_FAIL, "" + i);
            return;
        }
        if (DeviceInfoUtil.isPowerSaveMode(context)) {
            setToFail(context, this.mMid, FeedbackEvent.POWER_SAVING_MODE, null);
            return;
        }
        if (DeviceInfoUtil.isDataSaverMode(context)) {
            setToFail(context, this.mMid, FeedbackEvent.DATA_SAVER_MODE, null);
            return;
        }
        if (i == 1004 || i == 1008 || i == 1011) {
            setToFail(context, this.mMid, FeedbackEvent.DOWNLOAD_FAIL, FeedbackDetailConstants.PREFIX_CLIENT_ERROR + i);
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, this.mMid, "db open fail");
            return;
        }
        try {
            int marketingFailCount = dBHandlerOpen.getMarketingFailCount(this.mMid);
            if (marketingFailCount >= 5) {
                setToFail(context, this.mMid, FeedbackEvent.DOWNLOAD_FAIL, "C1009_" + i);
                return;
            }
            dBHandlerOpen.updateMarketingFailCount(this.mMid, marketingFailCount + 1);
            dBHandlerOpen.close();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_DOWNLOAD_RESOURCE);
            STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, this.mMid), System.currentTimeMillis() + MarketingConstants.REQUEST_RESOURCE_DELAY_MILLIS, 0);
        } finally {
            dBHandlerOpen.close();
        }
    }

    private void onResourceDownloadSuccess(Context context, String str) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, this.mMid, "db open fail");
            return;
        }
        dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.INCOMP_GET_STATUS_API);
        dBHandlerOpen.updateMarketingFailCount(this.mMid, 0);
        FeedbackManager.addFeedback(context, this.mMid, FeedbackEvent.DOWNLOADED, str);
        if (parseResource(context)) {
            setAlarmForScreenOnListener(context);
            setAlarmForGetMarketingStatus(context);
        }
        dBHandlerOpen.close();
    }

    private boolean parseResource(Context context) {
        try {
            MarketingParser.parseResource(context, this);
            return true;
        } catch (InternalException.InvalidArgumentException unused) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource");
            setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return false;
        } catch (InternalException.InvalidReferrerException unused2) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. invalid referrer");
            setToFail(context, FeedbackEvent.REFERRER_VALIDATION_FAIL, null);
            return false;
        } catch (InternalException.LocaleNotMatchException unused3) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. no matched locale");
            setToFail(context, FeedbackEvent.LOCALE_NOT_MATCHED, null);
            return false;
        } catch (InternalException.NotSupportedTypeException unused4) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. not supported type");
            setToFail(context, FeedbackEvent.UNSUPPORTED_TYPE, null);
            return false;
        } catch (InternalException.WrongMarketingDataException unused5) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. invalid data");
            setToFail(context, FeedbackEvent.CONTENTS_FILE_ERROR, null);
            return false;
        } catch (IOException e) {
            if (!(e instanceof FileNotFoundException)) {
                SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. IOException");
                setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.FILE_IO_ERROR);
                return false;
            }
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource. file not found" + e.toString());
            setToFail(context, FeedbackEvent.CONTENTS_FILE_ERROR, FeedbackDetailConstants.TXT_FILE_NOT_FOUND_ERROR);
            return false;
        } catch (Exception e2) {
            SmpLog.m6495e(TAG, this.mMid, "fail to parse resource." + e2.toString());
            setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            return false;
        }
    }

    private void setExpectedDisplayTime(Context context, long j) throws InternalException.DBException {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, this.mMid, "updateExpectedDisplayTime. db open fail");
            throw new InternalException.DBException();
        }
        try {
            setExpectedDisplayTimeMillis(j);
            if (dBHandlerOpen.updateMarketingExpectedDisplayTime(this.mMid, j)) {
                return;
            }
            SmpLog.m6495e(TAG, this.mMid, "updateExpectedDisplayTime. update fail");
            throw new InternalException.DBException();
        } finally {
            dBHandlerOpen.close();
        }
    }

    private void setToCanceled(Context context) {
        if (context != null) {
            DBHandler dBHandlerOpen = DBHandler.open(context);
            if (dBHandlerOpen == null) {
                SmpLog.m6495e(TAG, this.mMid, "db open fail");
                return;
            }
            dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.CANCELED);
            FeedbackManager.addFeedback(context, this.mMid, FeedbackEvent.MARKETING_CANCELED, null);
            FileIOUtil.deleteFiles(FilePathUtil.getResDirectory(context, this.mMid));
            dBHandlerOpen.close();
        }
    }

    public static void setToGone(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            SmpLog.m6495e(TAG, str, "Fail to change to [gone] - invalid params");
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "Fail to change to [gone] - db open fail");
            return;
        }
        try {
            MarketingState marketingState = dBHandlerOpen.getMarketingState(str);
            MarketingState marketingState2 = MarketingState.GONE;
            if (marketingState2.equals(marketingState)) {
                return;
            }
            if (!MarketingState.DISPLAYED.equals(marketingState)) {
                SmpLog.m6502w(TAG, str, "Fail to change to [gone] - not displayed/incomp_api");
                return;
            }
            if (z) {
                dBHandlerOpen.updateMarketingClickedTime(str, System.currentTimeMillis());
            }
            dBHandlerOpen.updateMarketingState(str, marketingState2);
            FileIOUtil.deleteFiles(FilePathUtil.getResDirectory(context, str));
            STaskDispatcher.cancelDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CLEAR, null, str));
            STaskDispatcher.cancelDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.CHECK_NOTIFICATION_CLEARED, null, str));
        } finally {
            dBHandlerOpen.close();
        }
    }

    public boolean checkNotificationSettingOption(Context context, int i) {
        try {
            if (!DeviceInfoUtil.isNotiSettingOptionDisabled(context, PrefManager.getInstance(context).getNotiChannelId(i))) {
                return true;
            }
            SmpLog.m6495e(TAG, getMid(), "cannot show notification : disabled notification option");
            setToFail(context, FeedbackEvent.DISABLE_NOTI_OPTION, null);
            return false;
        } catch (InternalException.IllegalPushChannelException unused) {
            SmpLog.m6495e(TAG, getMid(), "cannot show notification : channel not created");
            setToFail(context, FeedbackEvent.PUSH_CHANNEL_NOT_CREATED, null);
            return false;
        }
    }

    public void clearDisplayedMarketing(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "fail to clear. db open fail");
            return;
        }
        DisplayManager displayManager = DisplayManager.getDisplayManager(getMarketingType());
        if (displayManager != null) {
            displayManager.clear(context, getDisplayId());
        }
        if (MarketingState.DISPLAYED.equals(dBHandlerOpen.getMarketingState(this.mMid))) {
            setToGone(context, this.mMid, false);
        }
        dBHandlerOpen.close();
    }

    public void displayMarketing(Context context, boolean z) {
        if (!z || filterBeforeDisplay(context)) {
            DisplayManager displayManager = DisplayManager.getDisplayManager(this.mMarketingType);
            if (displayManager == null) {
                SmpLog.m6495e(TAG, this.mMid, "fail to display. displaymanager null");
                setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, null);
            } else if (isResourceParsed() || parseResource(context)) {
                displayManager.display(context, getDisplayMeta(), new DisplayResultHandler(getMid(), getClearTimeMillis(), z));
            }
        }
    }

    public boolean filterBeforeDisplay(Context context) {
        return checkOptIn(context) && checkFrequencyCapping(context) && checkDisplayTime(context, true) && checkFilterPkg(context);
    }

    public boolean filterBeforeGetMarketingStatus(Context context) {
        return checkOptIn(context) && checkDisplayTime(context, false);
    }

    public boolean filterBeforeResourceDownload(Context context) {
        return checkOptIn(context) && checkDisplayTime(context, false);
    }

    public void forceDisplay(Context context) throws InternalException.DBException {
        String str = TAG;
        SmpLog.m6499i(str, this.mMid, "force display");
        setExpectedDisplayTime(context, System.currentTimeMillis());
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(str, this.mMid, "forceDisplay. db open fail");
            throw new InternalException.DBException();
        }
        MarketingState marketingState = dBHandlerOpen.getMarketingState(this.mMid);
        dBHandlerOpen.close();
        if (MarketingState.INCOMP_GET_STATUS_API.equals(marketingState)) {
            requestGetMarketingStatus(context);
        } else {
            if (MarketingState.INCOMP_DISPLAY.equals(marketingState)) {
                displayMarketing(context, true);
                return;
            }
            SmpLog.m6501w(str, "forceDisplay. state not supported : " + marketingState);
        }
    }

    public int getCctimeMinutes() {
        return this.mCctimeMinutes;
    }

    public int getChannelType() {
        return this.mChannelType;
    }

    public long getClearTimeMillis() {
        return isLocalTimeBase() ? TimeUtil.adjustLocalTimeToUtc0(this.mClearTimeMillis) : this.mClearTimeMillis;
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    @Override // com.samsung.android.sdk.smp.display.DisplayMeta
    public Bundle getDisplayMeta() {
        Bundle bundle = new Bundle();
        bundle.putString("mid", getMid());
        bundle.putInt(MarketingConstants.DisplayConst.DISPLAYID, getDisplayId());
        bundle.putInt(MarketingConstants.DisplayConst.CHANNEL_TYPE, getChannelType());
        bundle.putBoolean("p_link", isPLink());
        bundle.putBoolean("undeletable", isUndeletable());
        return bundle;
    }

    public TimeUtil.Time getDisplayTimeEnd() {
        return isLocalTimeBase() ? new TimeUtil.Time(this.mDisplayTimeHourEnd, this.mDisplayTimeMinEnd) : TimeUtil.adjustUtc0ToLocalTime(this.mDisplayTimeHourEnd, this.mDisplayTimeMinEnd);
    }

    public TimeUtil.Time getDisplayTimeStart() {
        return isLocalTimeBase() ? new TimeUtil.Time(this.mDisplayTimeHourStart, this.mDisplayTimeMinStart) : TimeUtil.adjustUtc0ToLocalTime(this.mDisplayTimeHourStart, this.mDisplayTimeMinStart);
    }

    public TimeUtil.Time getDoNotDisturbTimeEnd() {
        return new TimeUtil.Time(this.mDoNotDisturbTimeHourEnd, this.mDoNotDisturbTimeMinEnd);
    }

    public TimeUtil.Time getDoNotDisturbTimeStart() {
        return new TimeUtil.Time(this.mDoNotDisturbTimeHourStart, this.mDoNotDisturbTimeMinStart);
    }

    public long getExpectedDisplayTimeMillis() {
        return this.mExpectedDisplayTimeMillis;
    }

    public int getFeedbackDispersionMax() {
        return this.mFeedbackDispersionMax;
    }

    public int getFeedbackDispersionMin() {
        return this.mFeedbackDispersionMin;
    }

    public MarketingFilter getFilter() {
        return this.mFilter;
    }

    public String getMarketingType() {
        return this.mMarketingType;
    }

    public String getMid() {
        return this.mMid;
    }

    public String getMsgType() {
        return this.mMsgType;
    }

    public int getRandomMinutes() {
        return this.mRandomMinutes;
    }

    public JSONObject getStyle() {
        return this.mStyle;
    }

    public String getTimeBase() {
        return this.mTimeBase;
    }

    public long getTtlEndMillis() {
        return isLocalTimeBase() ? TimeUtil.adjustLocalTimeToUtc0(this.mTtlEndMillis) : this.mTtlEndMillis;
    }

    public long getTtlStartMillis() {
        return isLocalTimeBase() ? TimeUtil.adjustLocalTimeToUtc0(this.mTtlStartMillis) : this.mTtlStartMillis;
    }

    public boolean isPLink() {
        return this.mPLink;
    }

    public boolean isResourceParsed() {
        return this.mIsResourceParsed;
    }

    public boolean isSupportType() {
        return "passive".equals(getMsgType()) || "test".equals(getMsgType()) || "marketing".equals(getMsgType());
    }

    public boolean isTestMsg() {
        return isTestMsg(getMid(), getMsgType());
    }

    public boolean isUndeletable() {
        return this.mUndeletable;
    }

    public void requestDownloadResource(Context context) {
        if (filterBeforeResourceDownload(context)) {
            try {
                Pair<String, String> resourceUrl = MarketingParser.parseResourceUrl(context, this.mContentsUrl);
                String str = (String) resourceUrl.first;
                String str2 = (String) resourceUrl.second;
                if (TextUtils.isEmpty(str)) {
                    SmpLog.m6495e(TAG, this.mMid, "fail to request resource. contents url not found");
                    setToFail(context, FeedbackEvent.WRONG_META_DATA, FeedbackDetailConstants.CONTENTS_URL_NOT_FOUND);
                    return;
                }
                String strSubstring = str.substring(str.lastIndexOf("/") + 1);
                String resDirectory = FilePathUtil.getResDirectory(context, this.mMid);
                NetworkResult networkResultDownloadResource = NetworkManager.downloadResource(context, str, strSubstring, resDirectory, 60);
                if (!networkResultDownloadResource.isSuccess()) {
                    onResourceDownloadFail(context, networkResultDownloadResource.getResponseCode());
                    return;
                }
                if (FileIOUtil.unzip(resDirectory, strSubstring, resDirectory)) {
                    onResourceDownloadSuccess(context, str2);
                } else if (strSubstring.toLowerCase().endsWith("zip")) {
                    onResourceDownloadFail(context, 1007);
                } else {
                    setToFail(context, FeedbackEvent.WRONG_META_DATA, null);
                }
            } catch (IndexOutOfBoundsException e) {
                e = e;
                SmpLog.m6495e(TAG, this.mMid, "fail to request resource. invalid contents url. " + e.toString());
                setToFail(context, FeedbackEvent.WRONG_META_DATA, FeedbackDetailConstants.CONTENTS_URL_NOT_FOUND);
            } catch (JSONException e2) {
                e = e2;
                SmpLog.m6495e(TAG, this.mMid, "fail to request resource. invalid contents url. " + e.toString());
                setToFail(context, FeedbackEvent.WRONG_META_DATA, FeedbackDetailConstants.CONTENTS_URL_NOT_FOUND);
            }
        }
    }

    public void requestGetMarketingStatus(Context context) {
        if (filterBeforeGetMarketingStatus(context)) {
            String appId = InitOptionsHolder.getInstance().getAppId(context);
            if (TextUtils.isEmpty(appId)) {
                SmpLog.m6495e(TAG, this.mMid, "fail to get marketing status. appid null");
                setToFail(context, FeedbackEvent.CLIENT_INTERNAL_ERROR, FeedbackDetailConstants.APPID_ERROR);
                return;
            }
            NetworkResult networkResultRequest = NetworkManager.request(context, new GetMarketingStatusRequest(this.mMid, appId, null), 60);
            if (networkResultRequest.isSuccess()) {
                onGetMarketingStatusSuccess(context, networkResultRequest.getResponseMsg());
            } else {
                onGetMarketingStatusFail(context, networkResultRequest.getResponseCode());
            }
        }
    }

    public void setAlarmForDisplay(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, "display");
        bundle.putBoolean(Constants.EXTRA_KEY_IS_FIRST_DISPLAY, true);
        STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, bundle, this.mMid), this.mExpectedDisplayTimeMillis, 0);
    }

    public void setAlarmForGetMarketingStatus(Context context) {
        if (needToCallGetMarketingStatusApi()) {
            STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.BASIC, AbstractC2821a.m2215f(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_GET_MARKETING_STATUS), this.mMid), getMarketingStatusAlarmTime(), 0);
            return;
        }
        String str = TAG;
        SmpLog.m6492d(str, "skip get status");
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(str, this.mMid, "db open fail");
            return;
        }
        dBHandlerOpen.updateMarketingState(this.mMid, MarketingState.INCOMP_DISPLAY);
        dBHandlerOpen.close();
        setAlarmForDisplay(context);
    }

    public void setAlarmForScreenOnListener(Context context) {
        if (this.mScreenOnTimeMinutes <= 0) {
            return;
        }
        if (getExpectedDisplayTimeMillis() < System.currentTimeMillis()) {
            SmpLog.m6498i(TAG, "already display time. skip screen on listening");
            return;
        }
        TimeUtil.Time displayTimeStart = getDisplayTimeStart();
        TimeUtil.Time displayTimeEnd = getDisplayTimeEnd();
        TimeUtil.Time doNotDisturbTimeStart = getDoNotDisturbTimeStart();
        TimeUtil.Time doNotDisturbTimeEnd = getDoNotDisturbTimeEnd();
        Bundle bundleM2215f = AbstractC2821a.m2215f(Constants.EXTRA_KEY_MARKETING_SUB_ACTION, Constants.EXTRA_ACTION_SCREEN_ON_LISTENING_START);
        bundleM2215f.putInt(Constants.EXTRA_KEY_DISPLAY_START_HOUR, displayTimeStart.getHour());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DISPLAY_START_MIN, displayTimeStart.getMin());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DISPLAY_END_HOUR, displayTimeEnd.getHour());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DISPLAY_END_MIN, displayTimeEnd.getMin());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DO_NOT_DISTURB_START_HOUR, doNotDisturbTimeStart.getHour());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DO_NOT_DISTURB_START_MIN, doNotDisturbTimeStart.getMin());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DO_NOT_DISTURB_END_HOUR, doNotDisturbTimeEnd.getHour());
        bundleM2215f.putInt(Constants.EXTRA_KEY_DO_NOT_DISTURB_END_MIN, doNotDisturbTimeEnd.getMin());
        bundleM2215f.putLong(Constants.EXTRA_KEY_SCREEN_ON_END_TIME, getExpectedDisplayTimeMillis());
        STaskDispatcher.setDispatchAlarm(context, new SMarketingTask(STask.MarketingAction.SCREEN_ON, bundleM2215f, this.mMid), getScreenOnAlarmTime(), 0);
    }

    public void setCctimeMinutes(int i) {
        this.mCctimeMinutes = i;
    }

    public void setChannelType(int i) {
        this.mChannelType = i;
    }

    public void setClearTimeMillis(long j) {
        this.mClearTimeMillis = j;
    }

    public void setContentsUrl(JSONObject jSONObject) {
        this.mContentsUrl = jSONObject;
    }

    public void setDisplayTimeEnd(TimeUtil.Time time) {
        this.mDisplayTimeHourEnd = time.getHour();
        this.mDisplayTimeMinEnd = time.getMin();
    }

    public void setDisplayTimeStart(TimeUtil.Time time) {
        this.mDisplayTimeHourStart = time.getHour();
        this.mDisplayTimeMinStart = time.getMin();
    }

    public void setDoNotDisturbTimeEnd(TimeUtil.Time time) {
        this.mDoNotDisturbTimeHourEnd = time.getHour();
        this.mDoNotDisturbTimeMinEnd = time.getMin();
    }

    public void setDoNotDisturbTimeStart(TimeUtil.Time time) {
        this.mDoNotDisturbTimeHourStart = time.getHour();
        this.mDoNotDisturbTimeMinStart = time.getMin();
    }

    public void setExpectedDisplayTimeMillis(long j) {
        this.mExpectedDisplayTimeMillis = j;
    }

    public void setFeedbackDispersionMax(int i) {
        this.mFeedbackDispersionMax = i;
    }

    public void setFeedbackDispersionMin(int i) {
        this.mFeedbackDispersionMin = i;
    }

    public void setFilter(MarketingFilter marketingFilter) {
        this.mFilter = marketingFilter;
    }

    public void setFreqCapping(int i, int i2, int i4, int i5) {
        this.mFreqCapping_Day = i;
        this.mFreqCapping_DayLimit = i2;
        this.mFreqCapping_Hour = i4;
        this.mFreqCapping_HourLimit = i5;
    }

    public void setPLink(boolean z) {
        this.mPLink = z;
    }

    public void setRandomMinutes(int i) {
        this.mRandomMinutes = i;
    }

    public void setScreenOnTimeMinutes(int i) {
        this.mScreenOnTimeMinutes = i;
    }

    public void setStyle(JSONObject jSONObject) {
        this.mStyle = jSONObject;
    }

    public void setTimeBase(String str) {
        this.mTimeBase = str;
    }

    public void setToFail(Context context, FeedbackEvent feedbackEvent, String str) {
        setToFail(context, this.mMid, feedbackEvent, str);
    }

    public void setToResourceParsed() {
        this.mIsResourceParsed = true;
    }

    public void setTtlEndMillis(long j) {
        this.mTtlEndMillis = j;
    }

    public void setTtlStartMillis(long j) {
        this.mTtlStartMillis = j;
    }

    public void setUndeletable(boolean z) {
        this.mUndeletable = z;
    }

    public void updateExpectedDisplayTime(Context context) {
        long jCalculateDisplayTimeForTwoRanges;
        List<TimeUtil.TimeRange> listAdjustDisplayTimeRange = adjustDisplayTimeRange();
        long ttlStartMillis = getTtlStartMillis();
        Calendar calendar = Calendar.getInstance();
        if (System.currentTimeMillis() < ttlStartMillis) {
            calendar.setTimeInMillis(ttlStartMillis);
        }
        if (listAdjustDisplayTimeRange.size() == 1) {
            TimeUtil.TimeRange timeRange = listAdjustDisplayTimeRange.get(0);
            jCalculateDisplayTimeForTwoRanges = calculateDisplayTimeForOneRange(context, timeRange.getStartTime(), timeRange.getEndTime(), calendar);
        } else {
            jCalculateDisplayTimeForTwoRanges = calculateDisplayTimeForTwoRanges(context, listAdjustDisplayTimeRange.get(0), listAdjustDisplayTimeRange.get(1), calendar);
        }
        setExpectedDisplayTime(context, jCalculateDisplayTimeForTwoRanges);
        String str = TAG;
        String str2 = this.mMid;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(jCalculateDisplayTimeForTwoRanges, "update expected display time:", "(");
        sbM1323p.append(TimeUtil.getString(jCalculateDisplayTimeForTwoRanges));
        sbM1323p.append(")");
        SmpLog.m6499i(str, str2, sbM1323p.toString());
    }

    public static boolean isTestMsg(String str, String str2) {
        if ("test".equals(str2)) {
            return true;
        }
        return str != null && str.toLowerCase().endsWith("test");
    }

    public static void setToFail(Context context, String str, FeedbackEvent feedbackEvent, String str2) {
        if (context == null || TextUtils.isEmpty(str) || feedbackEvent == null) {
            return;
        }
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6495e(TAG, str, "db open fail");
            return;
        }
        try {
            if (dBHandlerOpen.isMarketingExist(str)) {
                MarketingState marketingState = dBHandlerOpen.getMarketingState(str);
                if (!canChangeStateToFail(marketingState)) {
                    String str3 = TAG;
                    StringBuilder sb = new StringBuilder("Fail to change to [fail] - current state : ");
                    sb.append(marketingState != null ? marketingState.name() : "");
                    SmpLog.m6502w(str3, str, sb.toString());
                    dBHandlerOpen.close();
                    return;
                }
                dBHandlerOpen.updateMarketingState(str, MarketingState.FAILED);
                FeedbackManager.addFeedback(context, str, feedbackEvent, str2);
                FileIOUtil.deleteFiles(FilePathUtil.getResDirectory(context, str));
            }
            dBHandlerOpen.close();
        } catch (Throwable th) {
            dBHandlerOpen.close();
            throw th;
        }
    }
}
