package com.samsung.android.support.senl.p148nt.stt.controller;

import android.content.Context;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.base.common.TranscriptExtraRawData;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.util.STTDataUtils;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import com.sec.android.app.voicenote.common.util.AISummarySectionData;
import com.sec.android.app.voicenote.common.util.AiSpeakerData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0002>?B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fJe\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\r2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'Jl\u0010(\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u00122\b\u0010-\u001a\u0004\u0018\u00010\r2\b\u0010.\u001a\u0004\u0018\u00010\u00142\b\u0010/\u001a\u0004\u0018\u00010\u00142\u0006\u0010%\u001a\u00020&J\"\u00100\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020&J&\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tJ\u0018\u00108\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020\tH\u0002J\u0018\u0010:\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020\tH\u0002J \u0010;\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController;", "", "mVoiceDataList", "", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "<init>", "(Ljava/util/List;)V", "getVoiceText", "", "", "voiceData", "(Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;)[Ljava/lang/String;", "getVoiceTime", "", "getVoiceLength", "", "getVoiceSpeakerID", "getSpeakerNameMap", "", "getParagraphStartTimes", "", "getParagraphEndTimes", "getParagraphSpeakerIDs", "checkEmptyVoiceData", "", "isHaveSTTData", "()Z", "index", "saveDataToSpenVoice", "", "documentPath", "updateItem", "voiceText", "timingInfo", "speechInfoList", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "speakerNameMap", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;", "(Ljava/lang/String;Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;[Ljava/lang/String;[ILjava/util/List;Ljava/util/Map;Lcom/samsung/android/support/senl/nt/stt/presenter/STTUpdateDataTask$Callback;)V", "editSTTVoiceData", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "speakerIDs", "startTimes", "endTimes", "removeSTTVoiceData", "loadDataFromDataBase", "reader", "Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReader;", "context", "Landroid/content/Context;", "uuid", "filePath", "loadSummaryData", "data", "loadSpeakerMap", "loadSTTData", "textData", ExternalDataConstants.Column.EXTRA_DATA, "SummaryOption", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSTTVoiceDataController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTVoiceDataController.kt\ncom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,368:1\n739#2,9:369\n739#2,9:382\n37#3:378\n36#3,3:379\n37#3:391\n36#3,3:392\n*S KotlinDebug\n*F\n+ 1 STTVoiceDataController.kt\ncom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController\n*L\n311#1:369,9\n314#1:382,9\n312#1:378\n312#1:379,3\n315#1:391\n315#1:392,3\n*E\n"})
public final class STTVoiceDataController {

    @NotNull
    private static final String TAG = "STTVoiceDataController";

    @Nullable
    private final List<SpenVoiceData> mVoiceDataList;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/controller/STTVoiceDataController$SummaryOption;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_AS_TIMELINE", "GROUP_BY_SUBJECT", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SummaryOption {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SummaryOption[] $VALUES;
        public static final SummaryOption SHOW_AS_TIMELINE = new SummaryOption("SHOW_AS_TIMELINE", 0);
        public static final SummaryOption GROUP_BY_SUBJECT = new SummaryOption("GROUP_BY_SUBJECT", 1);

        private static final /* synthetic */ SummaryOption[] $values() {
            return new SummaryOption[]{SHOW_AS_TIMELINE, GROUP_BY_SUBJECT};
        }

        static {
            SummaryOption[] summaryOptionArr$values = $values();
            $VALUES = summaryOptionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(summaryOptionArr$values);
        }

        private SummaryOption(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SummaryOption> getEntries() {
            return $ENTRIES;
        }

        public static SummaryOption valueOf(String str) {
            return (SummaryOption) Enum.valueOf(SummaryOption.class, str);
        }

        public static SummaryOption[] values() {
            return (SummaryOption[]) $VALUES.clone();
        }
    }

    public STTVoiceDataController(@Nullable List<SpenVoiceData> list) {
        this.mVoiceDataList = list;
    }

    private final void loadSTTData(SpenVoiceTextDataReader reader, String textData, String extraData) {
        List listEmptyList;
        List listEmptyList2;
        if (textData.length() == 0 || extraData.length() == 0) {
            Logger.m12710d(TAG, "loadSTTData# textData or extraData is null");
            return;
        }
        TranscriptExtraRawData transcriptExtraRawData = new TranscriptExtraRawData();
        try {
            Object objFromJson = new GsonBuilder().create().fromJson(extraData, new TypeToken<TranscriptExtraRawData>() { // from class: com.samsung.android.support.senl.nt.stt.controller.STTVoiceDataController$loadSTTData$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
            transcriptExtraRawData = (TranscriptExtraRawData) objFromJson;
        } catch (ClassCastException e) {
            Logger.m12711e(TAG, "loadSTTData# Cannot cast object: " + e);
        } catch (Exception e2) {
            Logger.m12711e(TAG, "loadSTTData# Cannot convert from json: " + e2);
        }
        try {
            List<String> listSplit = new Regex(" ").split(transcriptExtraRawData.getParagraphInfo(), 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            List<String> listSplit2 = new Regex(" ").split(transcriptExtraRawData.getTimeStamp(), 0);
            if (listSplit2.isEmpty()) {
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList2 = CollectionsKt.emptyList();
            }
            String[] strArr2 = (String[]) listEmptyList2.toArray(new String[0]);
            int i = strArr.length == 0 ? 0 : Integer.parseInt(strArr[0]);
            int[] iArr = new int[i];
            long[] jArr = new long[i];
            long[] jArr2 = new long[i];
            int i2 = strArr2.length == 0 ? 0 : Integer.parseInt(strArr2[0]);
            int[] iArr2 = new int[i2];
            long[] jArr3 = new long[i2];
            long[] jArr4 = new long[i2];
            int[] iArr3 = new int[i2];
            String[] strArr3 = new String[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                strArr3[i4] = "";
            }
            Logger.m12710d(TAG, "loadSTTData# time stamp size =" + i2 + " paragraph size = " + i);
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i5 * 3;
                iArr[i5] = Integer.parseInt(strArr[i6 + 1]);
                jArr[i5] = Long.parseLong(strArr[i6 + 2]);
                jArr2[i5] = Long.parseLong(strArr[i6 + 3]);
            }
            int iAddExact = 0;
            int i7 = 0;
            int i8 = 0;
            while (i7 < i2) {
                int i9 = i7 * 3;
                jArr3[i7] = Long.parseLong(strArr2[i9 + 1]);
                jArr4[i7] = Long.parseLong(strArr2[i9 + 2]);
                int i10 = Integer.parseInt(strArr2[i9 + 3]);
                iArr3[i7] = i10;
                String[] strArr4 = strArr2;
                int i11 = iAddExact + i10;
                int i12 = i;
                String strSubstring = textData.substring(iAddExact, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strArr3[i7] = strSubstring;
                iAddExact = Math.addExact(iAddExact, iArr3[i7]);
                if (i12 > 0) {
                    if (jArr3[i7] < jArr[i8] || jArr4[i7] > jArr2[i8]) {
                        i8++;
                        iArr2[i7] = iArr[i8];
                    } else {
                        iArr2[i7] = iArr[i8];
                    }
                }
                i7++;
                strArr2 = strArr4;
                i = i12;
            }
            reader.setVoiceTexts(strArr3);
            reader.setVoiceSpeakerIDs(iArr2);
            reader.setVoiceTextStartTimes(jArr3);
            reader.setVoiceTextEndTimes(jArr4);
            reader.setVoiceTextLengths(iArr3);
            reader.setParagraphSpeakerIDs(iArr);
            reader.setParagraphStartTimes(jArr);
            reader.setParagraphEndTimes(jArr2);
            reader.updateVoiceTime();
        } catch (NumberFormatException e3) {
            AbstractC12991c.m14005z("loadSTTData# exception: ", e3.getMessage(), TAG);
        }
    }

    private final void loadSpeakerMap(SpenVoiceTextDataReader reader, String data) {
        if (data.length() == 0) {
            Logger.m12710d(TAG, "loadSpeakerMap# data is null");
            return;
        }
        try {
            reader.setSpeakerNameMap(((AiSpeakerData) new GsonBuilder().create().fromJson(data, new TypeToken<AiSpeakerData>() { // from class: com.samsung.android.support.senl.nt.stt.controller.STTVoiceDataController$loadSpeakerMap$type$1
            }.getType())).mSpeakerNameMap);
        } catch (ClassCastException e) {
            Logger.m12711e(TAG, "loadSpeakerMap# Cannot cast object: " + e);
        } catch (Exception e2) {
            Logger.m12711e(TAG, "loadSpeakerMap# Cannot convert from json: " + e2);
        }
    }

    private final void loadSummaryData(SpenVoiceTextDataReader reader, String data) {
        if (data.length() == 0) {
            Logger.m12710d(TAG, "loadSummaryData# data is null");
            return;
        }
        try {
            ArrayList arrayList = (ArrayList) new GsonBuilder().create().fromJson(data, new TypeToken<ArrayList<AISummarySectionData>>() { // from class: com.samsung.android.support.senl.nt.stt.controller.STTVoiceDataController$loadSummaryData$type$1
            }.getType());
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            int i = size + 1;
            String[] strArr = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr[i2] = "";
            }
            ArrayList<String>[] arrayListArr = new ArrayList[i];
            for (int i4 = 0; i4 < i; i4++) {
                arrayListArr[i4] = new ArrayList<>();
            }
            long[] jArr = new long[i];
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = arrayList.get(i5);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                AISummarySectionData aISummarySectionData = (AISummarySectionData) obj;
                String sectionTitle = aISummarySectionData.sectionTitle;
                Intrinsics.checkNotNullExpressionValue(sectionTitle, "sectionTitle");
                strArr[i5] = sectionTitle;
                ArrayList<String> summaryList = aISummarySectionData.summaryList;
                Intrinsics.checkNotNullExpressionValue(summaryList, "summaryList");
                arrayListArr[i5] = summaryList;
                jArr[i5] = aISummarySectionData.timeStamp;
            }
            reader.setSummaryLines(arrayListArr);
            reader.setSummaryTitle(strArr);
            reader.setTimeStamp(jArr);
        } catch (ClassCastException e) {
            Logger.m12711e(TAG, "loadSummaryData# Cannot cast object: " + e);
        } catch (Exception e2) {
            Logger.m12711e(TAG, "loadSummaryData# Cannot convert from json: " + e2);
        }
    }

    public final boolean checkEmptyVoiceData(@Nullable SpenVoiceData voiceData) {
        String[] voiceText = getVoiceText(voiceData);
        return voiceText == null || voiceText.length == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void editSTTVoiceData(@Nullable String documentPath, @Nullable SpenVoiceData updateItem, @NotNull ArrayList<TextData> textDataList, @NotNull Map<Integer, String> speakerNameMap, @Nullable int[] speakerIDs, @Nullable long[] startTimes, @Nullable long[] endTimes, @NotNull STTUpdateDataTask.Callback callback) {
        Intrinsics.checkNotNullParameter(textDataList, "textDataList");
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (documentPath != null && updateItem != 0 && speakerIDs != 0 && startTimes != null && endTimes != null) {
            new STTUpdateDataTask().editSTTVoiceData(documentPath, updateItem, textDataList, speakerNameMap, speakerIDs, startTimes, endTimes, callback);
            return;
        }
        if (documentPath == null) {
            documentPath = "null";
        }
        if (updateItem == 0) {
            updateItem = "null";
        }
        if (speakerIDs == 0) {
            speakerIDs = "null";
        }
        Logger.m12711e(TAG, "editSTTVoiceData# - documentPath# " + documentPath + "  - updateItem# " + updateItem + " - speakerIDs# " + speakerIDs + " - startTimes# " + (startTimes != null ? startTimes : "null") + " - endTimes# " + (endTimes != null ? endTimes : "null"));
    }

    @Nullable
    public final long[] getParagraphEndTimes(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getParagraphEndTimes();
    }

    @Nullable
    public final int[] getParagraphSpeakerIDs(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getParagraphSpeakerIDs();
    }

    @Nullable
    public final long[] getParagraphStartTimes(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getParagraphStartTimes();
    }

    @Nullable
    public final Map<Integer, String> getSpeakerNameMap(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getSpeakerNameMap();
    }

    public final int getVoiceLength(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return 0;
        }
        return (int) voiceData.getRecordingTime();
    }

    @Nullable
    public final int[] getVoiceSpeakerID(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getVoiceSpeakerIDs();
    }

    @Nullable
    public final String[] getVoiceText(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getVoiceTexts();
    }

    @Nullable
    public final int[] getVoiceTime(@Nullable SpenVoiceData voiceData) {
        if (voiceData == null) {
            return null;
        }
        return SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(voiceData).getVoiceTimes();
    }

    public final boolean isHaveSTTData() {
        List<SpenVoiceData> list = this.mVoiceDataList;
        if (list == null) {
            return false;
        }
        Iterator<SpenVoiceData> it = list.iterator();
        while (it.hasNext()) {
            SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(it.next());
            String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
            int[] voiceTimes = spenVoiceTextDataReader.getVoiceTimes();
            if (voiceTexts != null && voiceTimes != null) {
                return true;
            }
        }
        return false;
    }

    public final void loadDataFromDataBase(@NotNull SpenVoiceTextDataReader reader, @NotNull Context context, @NotNull String uuid, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        List<SttContentEntity> sTTDataContent = STTDataUtils.getSTTDataContent(context, uuid, filePath);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        for (SttContentEntity sttContentEntity : sTTDataContent) {
            int type = sttContentEntity.getType();
            if (type == 0) {
                sb.append(sttContentEntity.getContent());
            } else if (type == 1) {
                sb2.append(sttContentEntity.getContent());
            } else if (type == 2) {
                sb4.append(sttContentEntity.getContent());
            } else if (type == 3) {
                sb3.append(sttContentEntity.getContent());
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        loadSTTData(reader, string, string2);
        String string3 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        loadSpeakerMap(reader, string3);
        String string4 = sb4.toString();
        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        loadSummaryData(reader, string4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeSTTVoiceData(@Nullable String documentPath, @Nullable SpenVoiceData updateItem, @NotNull STTUpdateDataTask.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (documentPath != null && updateItem != 0) {
            new STTUpdateDataTask().removeSTTVoiceData(documentPath, updateItem, callback);
            return;
        }
        if (documentPath == null) {
            documentPath = "null";
        }
        if (updateItem == 0) {
            updateItem = "null";
        }
        Logger.m12711e(TAG, "removeSTTVoiceData# - documentPath# " + documentPath + "  - updateItem# " + updateItem);
    }

    public final void saveDataToSpenVoice(@Nullable String documentPath, @Nullable SpenVoiceData updateItem, @Nullable String[] voiceText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, @NotNull Map<Integer, String> speakerNameMap, @NotNull STTUpdateDataTask.Callback callback) {
        Intrinsics.checkNotNullParameter(speakerNameMap, "speakerNameMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (documentPath != null && updateItem != null && voiceText != null && timingInfo != null && speechInfoList != null) {
            new STTUpdateDataTask().saveDataToSpenVoice(documentPath, updateItem, voiceText, timingInfo, speechInfoList, speakerNameMap, callback);
            return;
        }
        Logger.m12711e(TAG, "saveDataToSpenVoice# - documentPath# " + (documentPath == null ? "null" : documentPath) + "  - updateItem# " + (updateItem == null ? "null" : updateItem) + " - voiceText# " + (voiceText != null ? voiceText : "null") + " - timingInfo# " + (timingInfo != null ? timingInfo : "null") + " - speechInfoList# " + (speechInfoList != null ? speechInfoList : "null") + " - speakerNameMap# " + speakerNameMap);
    }

    public final boolean isHaveSTTData(int index) {
        List<SpenVoiceData> list = this.mVoiceDataList;
        if (list != null && !list.isEmpty() && index >= 0 && index < this.mVoiceDataList.size()) {
            SpenVoiceData spenVoiceData = this.mVoiceDataList.get(index);
            SpenVoiceTextDataReader spenVoiceTextDataReader = SpenVoiceTextDataReaderCache.INSTANCE.getInstance().get(spenVoiceData);
            String[] voiceTexts = spenVoiceTextDataReader.getVoiceTexts();
            int[] voiceTimes = spenVoiceTextDataReader.getVoiceTimes();
            if (voiceTexts != null && voiceTimes != null) {
                Logger.m12713i(TAG, "isVoiceDataItemSTTConverted: item " + spenVoiceData.getName() + " is converted");
                return true;
            }
        }
        return false;
    }
}
