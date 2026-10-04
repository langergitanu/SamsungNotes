package com.samsung.android.sdk.scs.p142ai.text.event;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.event.EventExtractor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class EventExtractRunnable extends TaskRunnable<List<Event>> {
    private static final String TAG = "ScsApi@EventExtractRunnable";
    private boolean isEventHasYearMonthDaySupported;
    private boolean isEventIndexSupported;
    private String mLanguage;
    private final TextServiceExecutor mServiceExecutor;
    private EventExtractor.SourceType mSourceType;
    private String mText;

    public EventExtractRunnable(@NonNull TextServiceExecutor textServiceExecutor) {
        this.mServiceExecutor = textServiceExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        int i;
        ArrayList<Integer> arrayList;
        ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
        Bundle bundle = new Bundle();
        bundle.putString("language", this.mLanguage);
        bundle.putString("string", this.mText);
        bundle.putString(TextConst.KEY_PARAM_SOURCE_STRING, this.mSourceType.name());
        Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_EVENT, (String) null, bundle);
        if (bundleCall == null) {
            Log.m6487e(TAG, "EventExtractor.extract(). ContentResolver result is null!!");
            AbstractC6670b.m4749j(5, "ContentResolver result is null", this.mSource);
            return;
        }
        int i2 = bundleCall.getInt("resultCode");
        if (i2 != 1) {
            AbstractC6670b.m4750k(i2, "unexpected resultCode!!! resultCode: ", TAG);
            if (i2 == 500) {
                AbstractC6670b.m4748i(500, this.mSource);
                return;
            } else {
                this.mSource.setException(new ResultException(2000, Integer.toString(i2)));
                return;
            }
        }
        ArrayList<String> stringArrayList = bundleCall.getStringArrayList(TextConst.KEY_EVENT_TITLE_LIST);
        ArrayList<String> stringArrayList2 = bundleCall.getStringArrayList(TextConst.KEY_EVENT_LOCATION_LIST);
        ArrayList arrayList2 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_EVENT_START_DATETIME_LIST);
        ArrayList arrayList3 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_EVENT_END_DATETIME_LIST);
        boolean[] booleanArray = bundleCall.getBooleanArray(TextConst.KEY_IS_ALL_DAY_LIST);
        boolean[] booleanArray2 = bundleCall.getBooleanArray(TextConst.KEY_UNTIL_FLAG_LIST);
        boolean[] booleanArray3 = bundleCall.getBooleanArray(TextConst.KEY_IS_RELATIVE_LIST);
        ArrayList<String> stringArrayList3 = bundleCall.getStringArrayList(TextConst.KEY_EVENT_CYCLIC_TIME_LIST);
        boolean[] booleanArray4 = bundleCall.getBooleanArray(TextConst.KEY_HAS_YEAR_ARRAY);
        boolean[] booleanArray5 = bundleCall.getBooleanArray(TextConst.KEY_HAS_MONTH_ARRAY);
        boolean[] booleanArray6 = bundleCall.getBooleanArray(TextConst.KEY_HAS_DAY_ARRAY);
        ArrayList<Integer> integerArrayList = bundleCall.getIntegerArrayList(TextConst.KEY_START_INDEX_LIST);
        ArrayList<Integer> integerArrayList2 = bundleCall.getIntegerArrayList(TextConst.KEY_END_INDEX_LIST);
        if (stringArrayList == null || stringArrayList2 == null || arrayList2 == null || arrayList3 == null || booleanArray == null || booleanArray2 == null || booleanArray3 == null || stringArrayList3 == null) {
            Log.m6487e(TAG, "null!! eventTitleList: " + stringArrayList + ", eventLocationList: " + stringArrayList2 + ", startDateTimeList: " + arrayList2 + ", endDateTimeList: " + arrayList3 + ", isAllDayList: " + Arrays.toString(booleanArray) + ", untilFlagList: " + Arrays.toString(booleanArray2) + ", isRelativeList : " + Arrays.toString(booleanArray3) + ", cyclicTimeList: " + stringArrayList3);
            AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
            return;
        }
        int size = stringArrayList.size();
        ArrayList<Integer> arrayList4 = integerArrayList2;
        if (size != stringArrayList2.size() || size != arrayList2.size() || size != arrayList3.size() || size != booleanArray.length || size != booleanArray2.length || size != booleanArray3.length || size != stringArrayList3.size()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(size, "unexpected size!!! : ", " vs ");
            sbM778t.append(booleanArray.length);
            sbM778t.append(" vs ");
            sbM778t.append(booleanArray2.length);
            sbM778t.append(" vs ");
            sbM778t.append(booleanArray3.length);
            sbM778t.append(stringArrayList3.size());
            Log.m6487e(TAG, sbM778t.toString());
            AbstractC6670b.m4749j(2000, "list size mismatched", this.mSource);
            return;
        }
        if (this.isEventHasYearMonthDaySupported && (booleanArray4 == null || size != booleanArray4.length || booleanArray5 == null || size != booleanArray5.length || booleanArray6 == null || size != booleanArray6.length)) {
            Log.m6487e(TAG, "has year month day null or unexpected size!!!");
            AbstractC6670b.m4749j(2000, "event has year month day mismatch", this.mSource);
            return;
        }
        if (this.isEventIndexSupported && (integerArrayList == null || size != integerArrayList.size() || arrayList4 == null || size != arrayList4.size())) {
            Log.m6487e(TAG, "start end index null or unexpected size!!!");
            AbstractC6670b.m4749j(2000, "event start end index mismatch", this.mSource);
            return;
        }
        ArrayList arrayList5 = new ArrayList();
        int i4 = 0;
        while (i4 < size) {
            boolean[] zArr = booleanArray4;
            Event eventCreate = Event.create();
            boolean[] zArr2 = booleanArray5;
            eventCreate.setTitle(stringArrayList.get(i4));
            eventCreate.setLocation(stringArrayList2.get(i4));
            eventCreate.setStartDateTime((LocalDateTime) arrayList2.get(i4));
            eventCreate.setEndDateTime((LocalDateTime) arrayList3.get(i4));
            eventCreate.setAllDay(booleanArray[i4]);
            eventCreate.setUntilFlag(booleanArray2[i4]);
            eventCreate.setRelative(booleanArray3[i4]);
            eventCreate.setCyclicTime(stringArrayList3.get(i4));
            if (this.isEventHasYearMonthDaySupported) {
                eventCreate.setHasYear(zArr[i4]);
                eventCreate.setHasMonth(zArr2[i4]);
                eventCreate.setHasDay(booleanArray6[i4]);
            }
            if (this.isEventIndexSupported) {
                eventCreate.setStartIndex(integerArrayList.get(i4).intValue());
                arrayList = arrayList4;
                i = i4;
                eventCreate.setEndIndex(arrayList.get(i4).intValue());
            } else {
                i = i4;
                arrayList = arrayList4;
            }
            arrayList5.add(eventCreate);
            i4 = i + 1;
            arrayList4 = arrayList;
            booleanArray4 = zArr;
            booleanArray5 = zArr2;
        }
        this.mSource.setResult((TResult) arrayList5);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_TEXT_GET_EVENT";
    }

    public void setEventHasYearMonthDaySupported(boolean z) {
        this.isEventHasYearMonthDaySupported = z;
    }

    public void setEventIndexSupported(boolean z) {
        this.isEventIndexSupported = z;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setSourceType(EventExtractor.SourceType sourceType) {
        this.mSourceType = sourceType;
    }

    public void setText(String str) {
        this.mText = str;
    }
}
