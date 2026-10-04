package com.samsung.android.sdk.scs.p142ai.text.entity;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.text.TextServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.text.entity.BasicEntityExtractor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BasicEntityExtractRunnable extends TaskRunnable<List<List<BasicEntity>>> {
    private static final String TAG = "ScsApi@BasicEntityExtractRunnable";
    private Bundle inputBundle;
    private boolean isBasicEntityBulkSupported;
    private TextServiceExecutor mServiceExecutor;

    public BasicEntityExtractRunnable(@NonNull TextServiceExecutor textServiceExecutor) {
        this.mServiceExecutor = textServiceExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        String str;
        ArrayList arrayList11;
        ArrayList arrayList12;
        ArrayList arrayList13;
        ArrayList arrayList14;
        ArrayList arrayList15;
        ArrayList arrayList16;
        ArrayList arrayList17;
        ArrayList arrayList18;
        ArrayList arrayList19;
        ArrayList arrayList20;
        ArrayList arrayList21;
        BasicEntityExtractRunnable basicEntityExtractRunnable;
        String str2;
        String str3;
        ArrayList arrayList22;
        ArrayList arrayList23;
        ArrayList arrayList24;
        ArrayList arrayList25;
        Class cls;
        ArrayList arrayList26;
        ArrayList arrayList27;
        int i;
        ArrayList arrayList28;
        Set set;
        Set set2;
        if (this.isBasicEntityBulkSupported) {
            ContentResolver textContentResolver = this.mServiceExecutor.getTextContentResolver();
            if (this.inputBundle == null) {
                return;
            }
            Bundle bundleCall = textContentResolver.call(Uri.parse(TextConst.URI_STRING), TextConst.METHOD_GET_ENTITY_BULK, (String) null, this.inputBundle);
            if (bundleCall == null) {
                Log.m6487e(TAG, "BasicEntityExtractor.extract() for textList. ContentResolver result is null!!");
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
            ArrayList arrayList29 = (ArrayList) bundleCall.getSerializable("entityTypeList");
            ArrayList arrayList30 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_START_INDEX_LIST);
            ArrayList arrayList31 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_END_INDEX_LIST);
            ArrayList arrayList32 = (ArrayList) bundleCall.getSerializable("textList");
            ArrayList arrayList33 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_START_DATE_LIST);
            ArrayList arrayList34 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_END_DATE_LIST);
            ArrayList arrayList35 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_START_LOCAL_DATE_TIME_LIST);
            ArrayList arrayList36 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_END_LOCAL_DATE_TIME_LIST);
            ArrayList arrayList37 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_UNRESOLVED_START_DATE_TIME_UNIT_LIST);
            ArrayList arrayList38 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_UNRESOLVED_END_DATE_TIME_UNIT_LIST);
            ArrayList arrayList39 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_REPEAT_INFO_LIST);
            ArrayList arrayList40 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_BANK_NAME_LIST);
            ArrayList arrayList41 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_BANK_ACCOUNT_NUMBER_LIST);
            ArrayList arrayList42 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_BANK_TRANSFER_AMOUNT_LIST);
            String str4 = TAG;
            ArrayList arrayList43 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_UNIT_VALUE);
            ArrayList arrayList44 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_UNIT_SYMBOL);
            ArrayList arrayList45 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_RECURRENCE_INFO_LIST);
            ArrayList arrayList46 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_POI_MAPPABLE_ARRAY);
            ArrayList arrayList47 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_IS_RELATIVE_LIST);
            ArrayList arrayList48 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_IS_SPECIAL_DAY_ARRAY);
            ArrayList arrayList49 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_HAS_YEAR_ARRAY);
            ArrayList arrayList50 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_HAS_MONTH_ARRAY);
            ArrayList arrayList51 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_HAS_DAY_ARRAY);
            ArrayList arrayList52 = (ArrayList) bundleCall.getSerializable(TextConst.KEY_HAS_RECURRENCE_WITHIN_RANGE_ARRAY);
            if (arrayList29 == null || arrayList30 == null || arrayList31 == null || arrayList32 == null || arrayList33 == null || arrayList34 == null || arrayList37 == null || arrayList38 == null || arrayList39 == null || arrayList40 == null || arrayList41 == null || arrayList42 == null || arrayList43 == null || arrayList44 == null || arrayList45 == null || arrayList46 == null || arrayList47 == null || arrayList48 == null || arrayList49 == null || arrayList50 == null || arrayList51 == null || arrayList52 == null) {
                Log.m6487e(str4, "null!! entityTypeListResult : " + arrayList29 + ", startIndexListResult : " + arrayList30 + ", endIndexListResult : " + arrayList31 + ", textListResult : " + arrayList32 + ", startDateListResult : " + arrayList33 + ", endDateListResult : " + arrayList34 + ", unresolvedStartDateTimeUnitListResult : " + arrayList37 + ", unresolvedEndDateTimeUnitListResult : " + arrayList38 + ", repeatInfoListResult : " + arrayList39 + ", bankNameListResult : " + arrayList40 + ", bankAccountNumberListResult : " + arrayList41 + ", bankAmountListResult : " + arrayList42 + ", unitValuesResult : " + arrayList43 + ", unitSymbolsResult : " + arrayList44 + ", recurrenceInfoListResult : " + arrayList45 + ", mappableArrayResult : " + arrayList46 + ", isRelativeArrayResult : " + arrayList47 + ", isSpecialDayArrayResult : " + arrayList48 + ", hasYearArrayResult : " + arrayList49 + ", hasMonthArrayResult : " + arrayList50 + ", hasDayArrayResult : " + arrayList51 + ", hasRecurrenceWithinRangeArrayResult : " + arrayList52);
                AbstractC6670b.m4749j(2000, "bundle content is null", this.mSource);
                return;
            }
            int size = arrayList29.size();
            ArrayList arrayList53 = arrayList52;
            ArrayList arrayList54 = arrayList42;
            String str5 = " vs ";
            if (size == arrayList30.size() && size == arrayList31.size() && size == arrayList32.size() && size == arrayList33.size() && size == arrayList34.size() && size == arrayList37.size() && size == arrayList38.size() && size == arrayList39.size() && size == arrayList40.size() && size == arrayList41.size() && size == arrayList54.size() && size == arrayList43.size() && size == arrayList44.size() && size == arrayList45.size() && size == arrayList46.size() && size == arrayList47.size() && size == arrayList48.size() && size == arrayList49.size() && size == arrayList50.size() && size == arrayList51.size()) {
                if (size == arrayList53.size()) {
                    ArrayList arrayList55 = new ArrayList();
                    int i4 = 0;
                    while (i4 < size) {
                        int i5 = size;
                        ArrayList arrayList56 = new ArrayList();
                        ArrayList arrayList57 = arrayList29;
                        ArrayList arrayList58 = (ArrayList) arrayList29.get(i4);
                        ArrayList arrayList59 = arrayList30;
                        ArrayList arrayList60 = (ArrayList) arrayList30.get(i4);
                        ArrayList arrayList61 = arrayList31;
                        ArrayList arrayList62 = (ArrayList) arrayList31.get(i4);
                        ArrayList arrayList63 = arrayList32;
                        ArrayList arrayList64 = (ArrayList) arrayList32.get(i4);
                        ArrayList arrayList65 = arrayList33;
                        ArrayList arrayList66 = (ArrayList) arrayList33.get(i4);
                        ArrayList arrayList67 = arrayList34;
                        ArrayList arrayList68 = (ArrayList) arrayList34.get(i4);
                        if (arrayList35 != null) {
                            arrayList22 = arrayList35;
                            arrayList23 = (ArrayList) arrayList35.get(i4);
                        } else {
                            arrayList22 = arrayList35;
                            arrayList23 = null;
                        }
                        if (arrayList36 != null) {
                            arrayList24 = arrayList36;
                            arrayList25 = (ArrayList) arrayList36.get(i4);
                        } else {
                            arrayList24 = arrayList36;
                            arrayList25 = null;
                        }
                        ArrayList arrayList69 = arrayList37;
                        ArrayList arrayList70 = (ArrayList) arrayList37.get(i4);
                        ArrayList arrayList71 = arrayList38;
                        ArrayList arrayList72 = (ArrayList) arrayList38.get(i4);
                        ArrayList arrayList73 = arrayList39;
                        ArrayList arrayList74 = (ArrayList) arrayList39.get(i4);
                        ArrayList arrayList75 = arrayList40;
                        ArrayList arrayList76 = (ArrayList) arrayList40.get(i4);
                        ArrayList arrayList77 = arrayList41;
                        ArrayList arrayList78 = (ArrayList) arrayList41.get(i4);
                        ArrayList arrayList79 = arrayList56;
                        ArrayList arrayList80 = arrayList54;
                        ArrayList arrayList81 = (ArrayList) arrayList80.get(i4);
                        ArrayList arrayList82 = arrayList46;
                        boolean[] zArr = (boolean[]) arrayList82.get(i4);
                        ArrayList arrayList83 = arrayList47;
                        boolean[] zArr2 = (boolean[]) arrayList83.get(i4);
                        ArrayList arrayList84 = arrayList48;
                        boolean[] zArr3 = (boolean[]) arrayList84.get(i4);
                        ArrayList arrayList85 = arrayList49;
                        boolean[] zArr4 = (boolean[]) arrayList85.get(i4);
                        ArrayList arrayList86 = arrayList50;
                        boolean[] zArr5 = (boolean[]) arrayList86.get(i4);
                        ArrayList arrayList87 = arrayList51;
                        boolean[] zArr6 = (boolean[]) arrayList87.get(i4);
                        ArrayList arrayList88 = arrayList43;
                        ArrayList arrayList89 = (ArrayList) arrayList88.get(i4);
                        ArrayList arrayList90 = arrayList44;
                        ArrayList arrayList91 = (ArrayList) arrayList90.get(i4);
                        ArrayList arrayList92 = arrayList45;
                        ArrayList arrayList93 = (ArrayList) arrayList92.get(i4);
                        ArrayList arrayList94 = arrayList53;
                        boolean[] zArr7 = (boolean[]) arrayList94.get(i4);
                        if (arrayList58 == null || arrayList64 == null) {
                            Log.m6487e(str4, "null!! entityTypeList: " + arrayList58 + ", textList: " + arrayList64);
                            AbstractC6670b.m4749j(2000, "more than one of inner lists is null", this.mSource);
                            return;
                        }
                        int i6 = i4;
                        int size2 = arrayList58.size();
                        if (size2 != arrayList64.size()) {
                            StringBuilder sbM778t = AbstractC0541b.m778t(size2, "unexpected size!!! : ", str5);
                            sbM778t.append(arrayList64.size());
                            Log.m6487e(str4, sbM778t.toString());
                            AbstractC6670b.m4749j(2000, "inner list size mismatched", this.mSource);
                            return;
                        }
                        String str6 = str4;
                        String str7 = str5;
                        int i7 = 0;
                        while (i7 < size2) {
                            int i8 = size2;
                            BasicEntity basicEntity = new BasicEntity();
                            String str8 = str6;
                            basicEntity.setType(BasicEntityExtractor.EntityType.valueOf((String) arrayList58.get(i7)));
                            basicEntity.setString((String) arrayList64.get(i7));
                            if (arrayList60 != null) {
                                basicEntity.setStartIndex(((Integer) arrayList60.get(i7)).intValue());
                            }
                            if (arrayList62 != null) {
                                basicEntity.setEndIndex(((Integer) arrayList62.get(i7)).intValue());
                            }
                            if (arrayList66 != null) {
                                basicEntity.setStartDateTime((Date) arrayList66.get(i7));
                            }
                            if (arrayList68 != null) {
                                basicEntity.setEndDateTime((Date) arrayList68.get(i7));
                            }
                            if (arrayList23 != null) {
                                basicEntity.setStartLocalDateTime((LocalDateTime) arrayList23.get(i7));
                            }
                            if (arrayList25 != null) {
                                basicEntity.setEndLocalDateTime((LocalDateTime) arrayList25.get(i7));
                            }
                            if (arrayList70 == null || (set2 = (Set) arrayList70.get(i7)) == null) {
                                cls = BasicEntityExtractor.DateTimeUnit.class;
                                arrayList26 = arrayList60;
                            } else {
                                cls = BasicEntityExtractor.DateTimeUnit.class;
                                EnumSet<BasicEntityExtractor.DateTimeUnit> enumSetNoneOf = EnumSet.noneOf(cls);
                                Iterator it = set2.iterator();
                                while (it.hasNext()) {
                                    enumSetNoneOf.add(BasicEntityExtractor.DateTimeUnit.valueOf((String) it.next()));
                                    arrayList60 = arrayList60;
                                }
                                arrayList26 = arrayList60;
                                basicEntity.setUnresolvedStartDateTimeUnit(enumSetNoneOf);
                            }
                            if (arrayList72 != null && (set = (Set) arrayList72.get(i7)) != null) {
                                EnumSet<BasicEntityExtractor.DateTimeUnit> enumSetNoneOf2 = EnumSet.noneOf(cls);
                                for (Iterator it2 = set.iterator(); it2.hasNext(); it2 = it2) {
                                    enumSetNoneOf2.add(BasicEntityExtractor.DateTimeUnit.valueOf((String) it2.next()));
                                }
                                basicEntity.setUnresolvedEndDateTimeUnit(enumSetNoneOf2);
                            }
                            if (arrayList74 != null) {
                                basicEntity.setRepeatInfo((String) arrayList74.get(i7));
                            }
                            if (arrayList76 != null) {
                                basicEntity.setBankName((String) arrayList76.get(i7));
                            }
                            if (arrayList78 != null) {
                                basicEntity.setBankAccountNumber((String) arrayList78.get(i7));
                            }
                            ArrayList arrayList95 = arrayList81;
                            if (arrayList81 != null) {
                                basicEntity.setBankAmount((String) arrayList95.get(i7));
                            }
                            if (zArr != null) {
                                basicEntity.setMappable(zArr[i7]);
                            }
                            if (zArr2 != null) {
                                basicEntity.setRelative(zArr2[i7]);
                            }
                            if (zArr3 != null) {
                                basicEntity.setSpecialDay(zArr3[i7]);
                            }
                            if (zArr4 != null) {
                                basicEntity.setHasYear(zArr4[i7]);
                            }
                            if (zArr5 != null) {
                                basicEntity.setHasMonth(zArr5[i7]);
                            }
                            if (zArr6 != null) {
                                basicEntity.setHasDay(zArr6[i7]);
                            }
                            if (arrayList89 != null) {
                                arrayList27 = arrayList89;
                                arrayList81 = arrayList95;
                                basicEntity.setUnitValue((String) arrayList27.get(i7));
                            } else {
                                arrayList81 = arrayList95;
                                arrayList27 = arrayList89;
                            }
                            if (arrayList91 != null) {
                                basicEntity.setUnitSymbol((String) arrayList91.get(i7));
                            }
                            if (arrayList93 != null) {
                                ArrayList arrayList96 = arrayList93;
                                if (arrayList96.get(i7) != null) {
                                    arrayList89 = arrayList27;
                                    HashMap map = new HashMap();
                                    for (Map.Entry entry : ((Map) arrayList96.get(i7)).entrySet()) {
                                        map.put(BasicEntityExtractor.RecurrenceUnit.valueOf((String) entry.getKey()), (List) entry.getValue());
                                        arrayList96 = arrayList96;
                                        i7 = i7;
                                    }
                                    i = i7;
                                    arrayList28 = arrayList96;
                                    basicEntity.setRecurrenceInfo(map);
                                } else {
                                    i = i7;
                                    arrayList28 = arrayList96;
                                    arrayList89 = arrayList27;
                                }
                            } else {
                                i = i7;
                                arrayList89 = arrayList27;
                                arrayList28 = arrayList93;
                            }
                            if (zArr7 != null) {
                                basicEntity.setHasRecurrenceWithinRange(zArr7[i]);
                            }
                            ArrayList arrayList97 = arrayList79;
                            arrayList97.add(basicEntity);
                            arrayList79 = arrayList97;
                            i7 = i + 1;
                            size2 = i8;
                            str6 = str8;
                            arrayList93 = arrayList28;
                            arrayList60 = arrayList26;
                        }
                        String str9 = str6;
                        arrayList55.add(arrayList79);
                        size = i5;
                        arrayList35 = arrayList22;
                        arrayList29 = arrayList57;
                        arrayList30 = arrayList59;
                        arrayList31 = arrayList61;
                        arrayList32 = arrayList63;
                        arrayList33 = arrayList65;
                        arrayList34 = arrayList67;
                        arrayList36 = arrayList24;
                        arrayList37 = arrayList69;
                        arrayList38 = arrayList71;
                        arrayList39 = arrayList73;
                        arrayList40 = arrayList75;
                        arrayList41 = arrayList77;
                        arrayList54 = arrayList80;
                        arrayList46 = arrayList82;
                        arrayList47 = arrayList83;
                        arrayList48 = arrayList84;
                        arrayList49 = arrayList85;
                        arrayList50 = arrayList86;
                        arrayList51 = arrayList87;
                        arrayList43 = arrayList88;
                        arrayList44 = arrayList90;
                        arrayList45 = arrayList92;
                        arrayList53 = arrayList94;
                        i4 = i6 + 1;
                        str5 = str7;
                        str4 = str9;
                    }
                    this.mSource.setResult((TResult) arrayList55);
                    return;
                }
                arrayList = arrayList30;
                arrayList2 = arrayList40;
                arrayList3 = arrayList41;
                arrayList4 = arrayList31;
                arrayList5 = arrayList32;
                arrayList6 = arrayList33;
                arrayList7 = arrayList34;
                arrayList8 = arrayList37;
                arrayList9 = arrayList38;
                arrayList10 = arrayList39;
                str = str4;
                arrayList11 = arrayList43;
                arrayList12 = arrayList44;
                arrayList13 = arrayList45;
                arrayList14 = arrayList46;
                arrayList15 = arrayList47;
                arrayList16 = arrayList48;
                arrayList17 = arrayList49;
                arrayList18 = arrayList50;
                arrayList19 = arrayList51;
                arrayList20 = arrayList53;
                arrayList21 = arrayList54;
                str3 = "unexpected size!!! : ";
                str2 = " vs ";
                basicEntityExtractRunnable = this;
            } else {
                arrayList = arrayList30;
                arrayList2 = arrayList40;
                arrayList3 = arrayList41;
                arrayList4 = arrayList31;
                arrayList5 = arrayList32;
                arrayList6 = arrayList33;
                arrayList7 = arrayList34;
                arrayList8 = arrayList37;
                arrayList9 = arrayList38;
                arrayList10 = arrayList39;
                str = str4;
                arrayList11 = arrayList43;
                arrayList12 = arrayList44;
                arrayList13 = arrayList45;
                arrayList14 = arrayList46;
                arrayList15 = arrayList47;
                arrayList16 = arrayList48;
                arrayList17 = arrayList49;
                arrayList18 = arrayList50;
                arrayList19 = arrayList51;
                arrayList20 = arrayList53;
                arrayList21 = arrayList54;
                basicEntityExtractRunnable = this;
                str2 = " vs ";
                str3 = "unexpected size!!! : ";
            }
            StringBuilder sbM778t2 = AbstractC0541b.m778t(size, str3, str2);
            sbM778t2.append(arrayList.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList4.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList5.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList6.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList7.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList8.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList9.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList10.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList2.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList3.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList21.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList11.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList12.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList13.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList14.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList15.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList16.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList17.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList18.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList19.size());
            sbM778t2.append(str2);
            sbM778t2.append(arrayList20.size());
            Log.m6487e(str, sbM778t2.toString());
            AbstractC6670b.m4749j(2000, "final list size mismatched", basicEntityExtractRunnable.mSource);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_TEXT_GET_ENTITY_BULK";
    }

    public void setBasicEntityBulkSupported(boolean z) {
        this.isBasicEntityBulkSupported = z;
    }

    public void setInputBundle(Bundle bundle) {
        this.inputBundle = bundle;
    }
}
