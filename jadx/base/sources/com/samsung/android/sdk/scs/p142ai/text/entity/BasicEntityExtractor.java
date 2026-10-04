package com.samsung.android.sdk.scs.p142ai.text.entity;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import p012C1.CallableC0047c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BasicEntityExtractor {
    private static final int MAP_POI_STABLE_VERSION_CODE = 140032000;
    private static final Set<String> SUPPORTED_LANGUAGE = (Set) Stream.of((Object[]) new String[]{"KO", "ZH", "JA", "EN", "DE", "FR", "ES", "IT", "RU"}).collect(Collectors.collectingAndThen(Collectors.toSet(), new C4662f(18)));
    private static final String TAG = "ScsApi@BasicEntityExtractor";
    private final boolean isBankAccountSupported;
    private final boolean isBasicEntityBulkSupported;
    private final boolean isBasicEntitySupported;
    private final boolean isDateTimeNumeralSupported;
    private final boolean isDateTimeSearchSupported;
    private final boolean isMapAddressPoiSupported;
    private final boolean isPhoneNumberSupported;
    private final boolean isUnitSupported;
    private final boolean isUpiIdSupported;
    private TextServiceExecutor mServiceExecutor;
    private RequestType requestType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DateTimeUnit {
        DATE,
        TIME,
        AMPM
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum EntityType {
        DATE_TIME,
        DATE_TIME_NUMERAL,
        DATE_TIME_SEARCH,
        PHONE_NUMBER,
        EMAIL_ADDRESS,
        URL,
        MAP_ADDRESS,
        MAP_ADDRESS_POI,
        BANK_ACCOUNT,
        VERIFICATION_CODE,
        UPI_ID,
        UNIT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Hemisphere {
        NORTHERN,
        SOUTHERN
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RecurrenceUnit {
        MONTH,
        WEEKDAY,
        DAY,
        START_TIME,
        END_TIME
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RequestType {
        CALENDAR,
        REMINDER,
        SUGGESTION,
        GALLERY,
        CAPTURE,
        DEFAULT
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public BasicEntityExtractor(@NonNull Context context) {
        this.isBasicEntitySupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY") == 0;
        this.isBasicEntityBulkSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_BULK") == 0;
        this.isDateTimeNumeralSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_DATETIME_NUMERAL") == 0;
        this.isDateTimeSearchSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_DATETIME_SEARCH") == 0;
        this.isPhoneNumberSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_PHONE_NUMBER") == 0;
        this.isMapAddressPoiSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_POI") == 0 && Feature.getScsVersionCode(context) >= MAP_POI_STABLE_VERSION_CODE;
        this.isBankAccountSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_BANK") == 0;
        this.isUpiIdSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_UPI_ID") == 0;
        this.isUnitSupported = Feature.checkFeature(context, "FEATURE_TEXT_GET_ENTITY_UNIT") == 0;
        Log.m6485d(TAG, "initConnection");
        this.mServiceExecutor = new TextServiceExecutor(context);
    }

    private Bundle createInputBundle(String str, String str2, Set<EntityType> set, long j, Hemisphere hemisphere, DayOfWeek dayOfWeek) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (EntityType entityType : set) {
            if (entityType != EntityType.DATE_TIME_NUMERAL || this.isDateTimeNumeralSupported) {
                if (entityType != EntityType.DATE_TIME_SEARCH || this.isDateTimeSearchSupported) {
                    if (entityType != EntityType.PHONE_NUMBER || this.isPhoneNumberSupported) {
                        if (entityType != EntityType.MAP_ADDRESS_POI || this.isMapAddressPoiSupported) {
                            if (entityType != EntityType.BANK_ACCOUNT || this.isBankAccountSupported) {
                                if (entityType != EntityType.UPI_ID || this.isUpiIdSupported) {
                                    if (entityType != EntityType.UNIT || this.isUnitSupported) {
                                        arrayList.add(entityType.name());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("language", str);
        bundle.putString("country", str2);
        bundle.putStringArrayList("entityTypeList", arrayList);
        bundle.putLong(TextConst.KEY_PARAM_BASE_TIME, j);
        bundle.putString(TextConst.KEY_PARAM_HEMISPHERE, hemisphere.name());
        bundle.putString(TextConst.KEY_PARAM_START_OF_WEEK, dayOfWeek.name());
        RequestType requestType = this.requestType;
        if (requestType != null) {
            bundle.putString(TextConst.KEY_PARAM_REQUEST_TYPE, requestType.name());
        }
        return bundle;
    }

    @NonNull
    private static String getTruncatedText(String str) {
        int length = str.length();
        if (length <= 10000) {
            return str;
        }
        Log.m6489i(TAG, String.format("BasicEntity input length(%d) exceed MAX_VAL(%d), so cut to %d", Integer.valueOf(length), 10000, 10000));
        return str.substring(0, 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isSupported$0(String str, String str2) {
        try {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            bundle.putString("country", str2);
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_ENTITY_SUPPORTED, (String) null, bundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "BasicEntityExtractor.isSupported(). ContentResolver result is null!!");
                return Boolean.FALSE;
            }
            if (bundleCall.isEmpty()) {
                Log.m6487e(TAG, "BasicEntityExtractor.isSupported(). result is empty!! App version is lower than Sdk so just check in static Array");
                return Boolean.valueOf(SUPPORTED_LANGUAGE.contains(str.toUpperCase()));
            }
            int i = bundleCall.getInt("resultCode");
            if (i == 1) {
                return Boolean.valueOf(bundleCall.getBoolean(TextConst.KEY_TEXT_SUPPORTED_BOOLEAN));
            }
            Log.m6487e(TAG, "unexpected resultCode!!! resultCode: " + i);
            return Boolean.FALSE;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: isSupported", e);
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$requestExtract$1(String str, String str2, String str3, Set set, long j, Hemisphere hemisphere, DayOfWeek dayOfWeek) {
        try {
            String truncatedText = getTruncatedText(str);
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            Bundle bundleCreateInputBundle = createInputBundle(str2, str3, set, j, hemisphere, dayOfWeek);
            bundleCreateInputBundle.putString("string", truncatedText);
            return textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_ENTITY, (String) null, bundleCreateInputBundle);
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: requestExtract", e);
            return null;
        }
    }

    private Bundle requestExtract(final String str, final String str2, final String str3, final Set<EntityType> set, final long j, final Hemisphere hemisphere, final DayOfWeek dayOfWeek) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: m2.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f9531a.lambda$requestExtract$1(str, str2, str3, set, j, hemisphere, dayOfWeek);
            }
        });
        try {
            try {
                try {
                    return (Bundle) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    futureSubmit.cancel(true);
                    Log.m6487e(TAG, "Timeout in requestExtract : " + e.getMessage());
                    return null;
                }
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in requestExtract : " + e2.getMessage());
                return null;
            }
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    @Nullable
    public List<BasicEntity> extract(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Set<EntityType> set) {
        return extract(str, str2, str3, set, System.currentTimeMillis());
    }

    public boolean isSupported(@NonNull String str, @NonNull String str2) {
        Boolean bool;
        Log.m6485d(TAG, "BasicEntityExtractor isSupported - language : " + str + ", country : " + str2);
        if (!this.isBasicEntitySupported) {
            return false;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0047c(this, 9, str, str2));
        try {
            try {
                try {
                    bool = (Boolean) futureSubmit.get(AiSTTListView.USER_SCROLL_INTERVAL, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    futureSubmit.cancel(true);
                    Log.m6487e(TAG, "Timeout in isSupported : " + e.getMessage());
                    bool = Boolean.FALSE;
                }
            } catch (Exception e2) {
                Log.m6487e(TAG, "Exception occurred in isSupported : " + e2.getMessage());
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        } finally {
            executorServiceNewSingleThreadExecutor.shutdownNow();
        }
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Nullable
    public List<BasicEntity> extract(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Set<EntityType> set, long j) {
        return extract(str, str2, str3, set, j, Hemisphere.NORTHERN);
    }

    @Nullable
    public List<BasicEntity> extract(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Set<EntityType> set, long j, @NonNull Hemisphere hemisphere) {
        return extract(str, str2, str3, set, j, hemisphere, DayOfWeek.SUNDAY);
    }

    @Nullable
    public List<BasicEntity> extract(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Set<EntityType> set, long j, @NonNull Hemisphere hemisphere, @NonNull DayOfWeek dayOfWeek) {
        Class cls;
        ArrayList<Integer> arrayList;
        ArrayList<String> arrayList2;
        int i;
        ArrayList<String> arrayList3;
        ArrayList arrayList4;
        Set set2;
        Set set3;
        Log.m6485d(TAG, "BasicEntity extract - language:" + str2 + ", country:" + str3);
        ArrayList arrayList5 = new ArrayList();
        if (!this.isBasicEntitySupported) {
            Log.m6487e(TAG, "Feature.FEATURE_TEXT_GET_ENTITY not supported!");
            return arrayList5;
        }
        if (str.length() < 2) {
            Log.m6487e(TAG, "BasicEntityExtractor.extract() input length is less than 2 so return empty");
            return arrayList5;
        }
        Bundle bundleRequestExtract = requestExtract(str, str2, str3, set, j, hemisphere, dayOfWeek);
        if (bundleRequestExtract == null) {
            Log.m6487e(TAG, "BasicEntityExtractor.extract(). ContentResolver result is null!!");
            return arrayList5;
        }
        int i2 = bundleRequestExtract.getInt("resultCode");
        if (i2 != 1) {
            AbstractC6670b.m4750k(i2, "unexpected resultCode!!! resultCode: ", TAG);
            return arrayList5;
        }
        ArrayList<String> stringArrayList = bundleRequestExtract.getStringArrayList("entityTypeList");
        ArrayList<Integer> integerArrayList = bundleRequestExtract.getIntegerArrayList(TextConst.KEY_START_INDEX_LIST);
        ArrayList<Integer> integerArrayList2 = bundleRequestExtract.getIntegerArrayList(TextConst.KEY_END_INDEX_LIST);
        ArrayList<String> stringArrayList2 = bundleRequestExtract.getStringArrayList("textList");
        ArrayList arrayList6 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_START_DATE_LIST);
        ArrayList arrayList7 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_END_DATE_LIST);
        ArrayList arrayList8 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_START_LOCAL_DATE_TIME_LIST);
        ArrayList arrayList9 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_END_LOCAL_DATE_TIME_LIST);
        ArrayList arrayList10 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_UNRESOLVED_START_DATE_TIME_UNIT_LIST);
        ArrayList arrayList11 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_UNRESOLVED_END_DATE_TIME_UNIT_LIST);
        ArrayList<String> stringArrayList3 = bundleRequestExtract.getStringArrayList(TextConst.KEY_REPEAT_INFO_LIST);
        ArrayList<String> stringArrayList4 = bundleRequestExtract.getStringArrayList(TextConst.KEY_BANK_NAME_LIST);
        ArrayList<String> stringArrayList5 = bundleRequestExtract.getStringArrayList(TextConst.KEY_BANK_ACCOUNT_NUMBER_LIST);
        ArrayList arrayList12 = arrayList5;
        ArrayList<String> stringArrayList6 = bundleRequestExtract.getStringArrayList(TextConst.KEY_BANK_TRANSFER_AMOUNT_LIST);
        boolean[] booleanArray = bundleRequestExtract.getBooleanArray(TextConst.KEY_POI_MAPPABLE_ARRAY);
        boolean[] booleanArray2 = bundleRequestExtract.getBooleanArray(TextConst.KEY_IS_RELATIVE_LIST);
        boolean[] booleanArray3 = bundleRequestExtract.getBooleanArray(TextConst.KEY_IS_SPECIAL_DAY_ARRAY);
        boolean[] booleanArray4 = bundleRequestExtract.getBooleanArray(TextConst.KEY_HAS_YEAR_ARRAY);
        boolean[] booleanArray5 = bundleRequestExtract.getBooleanArray(TextConst.KEY_HAS_MONTH_ARRAY);
        boolean[] booleanArray6 = bundleRequestExtract.getBooleanArray(TextConst.KEY_HAS_DAY_ARRAY);
        ArrayList<String> stringArrayList7 = bundleRequestExtract.getStringArrayList(TextConst.KEY_UNIT_VALUE);
        ArrayList<String> stringArrayList8 = bundleRequestExtract.getStringArrayList(TextConst.KEY_UNIT_SYMBOL);
        ArrayList arrayList13 = (ArrayList) bundleRequestExtract.getSerializable(TextConst.KEY_RECURRENCE_INFO_LIST);
        boolean[] booleanArray7 = bundleRequestExtract.getBooleanArray(TextConst.KEY_HAS_RECURRENCE_WITHIN_RANGE_ARRAY);
        if (stringArrayList != null && stringArrayList2 != null) {
            int size = stringArrayList.size();
            if (size != stringArrayList2.size()) {
                StringBuilder sbM778t = AbstractC0541b.m778t(size, "unexpected size!!! : ", " vs ");
                sbM778t.append(stringArrayList2.size());
                Log.m6487e(TAG, sbM778t.toString());
                return arrayList12;
            }
            int i4 = 0;
            while (i4 < size) {
                BasicEntity basicEntity = new BasicEntity();
                int i5 = size;
                basicEntity.setType(EntityType.valueOf(stringArrayList.get(i4)));
                basicEntity.setString(stringArrayList2.get(i4));
                if (integerArrayList != null) {
                    basicEntity.setStartIndex(integerArrayList.get(i4).intValue());
                }
                if (integerArrayList2 != null) {
                    basicEntity.setEndIndex(integerArrayList2.get(i4).intValue());
                }
                if (arrayList6 != null) {
                    basicEntity.setStartDateTime((Date) arrayList6.get(i4));
                }
                if (arrayList7 != null) {
                    basicEntity.setEndDateTime((Date) arrayList7.get(i4));
                }
                if (arrayList8 != null) {
                    basicEntity.setStartLocalDateTime((LocalDateTime) arrayList8.get(i4));
                }
                if (arrayList9 != null) {
                    basicEntity.setEndLocalDateTime((LocalDateTime) arrayList9.get(i4));
                }
                if (arrayList10 == null || (set3 = (Set) arrayList10.get(i4)) == null) {
                    cls = DateTimeUnit.class;
                    arrayList = integerArrayList;
                } else {
                    cls = DateTimeUnit.class;
                    EnumSet<DateTimeUnit> enumSetNoneOf = EnumSet.noneOf(cls);
                    Iterator it = set3.iterator();
                    while (it.hasNext()) {
                        enumSetNoneOf.add(DateTimeUnit.valueOf((String) it.next()));
                        integerArrayList = integerArrayList;
                    }
                    arrayList = integerArrayList;
                    basicEntity.setUnresolvedStartDateTimeUnit(enumSetNoneOf);
                }
                if (arrayList11 != null && (set2 = (Set) arrayList11.get(i4)) != null) {
                    EnumSet<DateTimeUnit> enumSetNoneOf2 = EnumSet.noneOf(cls);
                    for (Iterator it2 = set2.iterator(); it2.hasNext(); it2 = it2) {
                        enumSetNoneOf2.add(DateTimeUnit.valueOf((String) it2.next()));
                    }
                    basicEntity.setUnresolvedEndDateTimeUnit(enumSetNoneOf2);
                }
                if (stringArrayList3 != null) {
                    basicEntity.setRepeatInfo(stringArrayList3.get(i4));
                }
                if (stringArrayList4 != null) {
                    basicEntity.setBankName(stringArrayList4.get(i4));
                }
                if (stringArrayList5 != null) {
                    basicEntity.setBankAccountNumber(stringArrayList5.get(i4));
                }
                ArrayList<String> arrayList14 = stringArrayList6;
                if (stringArrayList6 != null) {
                    basicEntity.setBankAmount(arrayList14.get(i4));
                }
                if (booleanArray != null) {
                    basicEntity.setMappable(booleanArray[i4]);
                }
                if (booleanArray2 != null) {
                    basicEntity.setRelative(booleanArray2[i4]);
                }
                if (booleanArray3 != null) {
                    basicEntity.setSpecialDay(booleanArray3[i4]);
                }
                if (booleanArray4 != null) {
                    basicEntity.setHasYear(booleanArray4[i4]);
                }
                if (booleanArray5 != null) {
                    basicEntity.setHasMonth(booleanArray5[i4]);
                }
                if (booleanArray6 != null) {
                    basicEntity.setHasDay(booleanArray6[i4]);
                }
                ArrayList<String> arrayList15 = stringArrayList7;
                if (stringArrayList7 != null) {
                    stringArrayList6 = arrayList14;
                    basicEntity.setUnitValue(arrayList15.get(i4));
                } else {
                    stringArrayList6 = arrayList14;
                }
                if (stringArrayList8 != null) {
                    ArrayList<String> arrayList16 = stringArrayList8;
                    arrayList2 = arrayList16;
                    basicEntity.setUnitSymbol(arrayList16.get(i4));
                } else {
                    arrayList2 = stringArrayList8;
                }
                if (arrayList13 != null) {
                    ArrayList arrayList17 = arrayList13;
                    if (arrayList17.get(i4) != null) {
                        arrayList3 = stringArrayList5;
                        HashMap map = new HashMap();
                        for (Map.Entry entry : ((Map) arrayList17.get(i4)).entrySet()) {
                            map.put(RecurrenceUnit.valueOf((String) entry.getKey()), (List) entry.getValue());
                            arrayList17 = arrayList17;
                            i4 = i4;
                        }
                        i = i4;
                        arrayList4 = arrayList17;
                        basicEntity.setRecurrenceInfo(map);
                    } else {
                        i = i4;
                        arrayList4 = arrayList17;
                        arrayList3 = stringArrayList5;
                    }
                } else {
                    i = i4;
                    arrayList3 = stringArrayList5;
                    arrayList4 = arrayList13;
                }
                if (booleanArray7 != null) {
                    basicEntity.setHasRecurrenceWithinRange(booleanArray7[i]);
                }
                ArrayList arrayList18 = arrayList12;
                arrayList18.add(basicEntity);
                stringArrayList5 = arrayList3;
                arrayList12 = arrayList18;
                i4 = i + 1;
                stringArrayList7 = arrayList15;
                stringArrayList8 = arrayList2;
                size = i5;
                arrayList13 = arrayList4;
                integerArrayList = arrayList;
            }
            return arrayList12;
        }
        Log.m6487e(TAG, "null!! entityTypeList: " + stringArrayList + ", textList: " + stringArrayList2);
        return arrayList12;
    }

    @Nullable
    public Task<List<List<BasicEntity>>> extract(@NonNull ArrayList<String> arrayList, @NonNull String str, @NonNull String str2, @NonNull Set<EntityType> set, long j, @NonNull Hemisphere hemisphere) {
        return extract(arrayList, str, str2, set, j, hemisphere, DayOfWeek.SUNDAY);
    }

    @Nullable
    public Task<List<List<BasicEntity>>> extract(@NonNull ArrayList<String> arrayList, @NonNull String str, @NonNull String str2, @NonNull Set<EntityType> set, long j, @NonNull Hemisphere hemisphere, @NonNull DayOfWeek dayOfWeek) {
        Log.m6485d(TAG, "BasicEntity Extract for textList");
        BasicEntityExtractRunnable basicEntityExtractRunnable = new BasicEntityExtractRunnable(this.mServiceExecutor);
        basicEntityExtractRunnable.setBasicEntityBulkSupported(this.isBasicEntityBulkSupported);
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getTruncatedText(it.next()));
        }
        Bundle bundleCreateInputBundle = createInputBundle(str, str2, set, j, hemisphere, dayOfWeek);
        bundleCreateInputBundle.putStringArrayList(TextConst.KEY_PARAM_STRING_LIST, arrayList2);
        basicEntityExtractRunnable.setInputBundle(bundleCreateInputBundle);
        this.mServiceExecutor.execute(basicEntityExtractRunnable);
        return basicEntityExtractRunnable.getTask();
    }
}
