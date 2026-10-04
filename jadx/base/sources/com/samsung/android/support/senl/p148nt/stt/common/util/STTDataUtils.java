package com.samsung.android.support.senl.p148nt.stt.common.util;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.common.TranscriptExtraRawData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.SttContentRepository;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReader;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J@\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J8\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J8\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J8\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J&\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH\u0002J8\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J8\u0010$\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0013H\u0002J(\u0010'\u001a\u00020(2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fH\u0007J.\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000ej\b\u0012\u0004\u0012\u00020\u0013`\u000f2\u0006\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0007H\u0007J\u001c\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u00101\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/common/util/STTDataUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getSTTDataContent", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/SttContentEntity;", "context", "Landroid/content/Context;", "docUuid", "filePath", "setSTTDataContentToDB", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reader", "Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReader;", "type", "", "lastModifiedAt", "", "saveSummaryData", "saveAISpeaker", "saveTranscriptExtraData", "getRawTimeStampData", "startTimeStamps", "", "endTimeStamps", "voiceTextLengths", "", "getRawParagraphData", "paragraphSpeakerIDs", "startParagraphTimes", "endParagraphTimes", "saveTranscriptText", "createEntity", "data", "index", "insertAllToDatabase", "", "sttContentList", "getVoiceListBySearch", "textSearch", "listVoice", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "isContains", "", "textS", "textVoice", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSTTDataUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 STTDataUtils.kt\ncom/samsung/android/support/senl/nt/stt/common/util/STTDataUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,326:1\n13472#2,2:327\n*S KotlinDebug\n*F\n+ 1 STTDataUtils.kt\ncom/samsung/android/support/senl/nt/stt/common/util/STTDataUtils\n*L\n230#1:327,2\n*E\n"})
public final class STTDataUtils {

    @NotNull
    public static final STTDataUtils INSTANCE = new STTDataUtils();

    @NotNull
    private static final String TAG = "STTDataUtils";

    private STTDataUtils() {
    }

    private final SttContentEntity createEntity(String docUuid, String filePath, long lastModifiedAt, int type, String data, int index) {
        SttContentEntity sttContentEntity = new SttContentEntity();
        sttContentEntity.setDocumentUuid(docUuid);
        sttContentEntity.setFilePath(filePath);
        sttContentEntity.setIndex(index);
        sttContentEntity.setType(type);
        sttContentEntity.setContent(data);
        sttContentEntity.setLastModifiedAt(lastModifiedAt);
        return sttContentEntity;
    }

    private final String getRawParagraphData(int[] paragraphSpeakerIDs, long[] startParagraphTimes, long[] endParagraphTimes) {
        int length = paragraphSpeakerIDs != null ? paragraphSpeakerIDs.length : 0;
        StringBuilder sb = new StringBuilder(AbstractC2322a.m1615e(length, " "));
        if (length > 0) {
            Intrinsics.checkNotNull(paragraphSpeakerIDs);
            int length2 = paragraphSpeakerIDs.length;
            for (int i = 0; i < length2; i++) {
                sb.append(paragraphSpeakerIDs[i]);
                sb.append(" ");
                Long lValueOf = null;
                sb.append(startParagraphTimes != null ? Long.valueOf(startParagraphTimes[i]) : null);
                sb.append(" ");
                if (endParagraphTimes != null) {
                    lValueOf = Long.valueOf(endParagraphTimes[i]);
                }
                sb.append(lValueOf);
                sb.append(" ");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String getRawTimeStampData(long[] startTimeStamps, long[] endTimeStamps, int[] voiceTextLengths) {
        StringBuilder sb = new StringBuilder();
        sb.append(startTimeStamps.length);
        sb.append(" ");
        int length = startTimeStamps.length;
        for (int i = 0; i < length; i++) {
            sb.append(startTimeStamps[i]);
            sb.append(" ");
            sb.append(endTimeStamps[i]);
            sb.append(" ");
            sb.append(voiceTextLengths[i]);
            sb.append(" ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final List<SttContentEntity> getSTTDataContent(@NotNull Context context, @NotNull String docUuid, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        SttContentRepository sttContentRepositoryCreateSttContentRepository = NotesDataRepositoryFactory.newInstance(context).createSttContentRepository();
        Intrinsics.checkNotNullExpressionValue(sttContentRepositoryCreateSttContentRepository, "createSttContentRepository(...)");
        List<SttContentEntity> entities = sttContentRepositoryCreateSttContentRepository.getEntities(docUuid, filePath);
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        return entities;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<Integer> getVoiceListBySearch(@NotNull String textSearch, @NotNull List<SpenVoiceData> listVoice) {
        Intrinsics.checkNotNullParameter(textSearch, "textSearch");
        Intrinsics.checkNotNullParameter(listVoice, "listVoice");
        String lowerCase = textSearch.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        boolean z = lowerCase.length() == 0;
        List<String> listSplit$default = StringsKt__StringsKt.split$default(lowerCase, new String[]{"\n", " "}, false, 0, 6, (Object) null);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = -1;
        for (SpenVoiceData spenVoiceData : listVoice) {
            i++;
            SpenVoiceTextDataReaderCache companion = SpenVoiceTextDataReaderCache.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            String[] voiceTexts = companion.get(spenVoiceData).getVoiceTexts();
            if (voiceTexts != null && voiceTexts.length != 0) {
                if (z) {
                    arrayList.add(Integer.valueOf(i));
                } else {
                    Iterator it = ArrayIteratorKt.iterator(voiceTexts);
                    while (true) {
                        if (it.hasNext()) {
                            if (INSTANCE.isContains(listSplit$default, (String) it.next())) {
                                arrayList.add(Integer.valueOf(i));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final void insertAllToDatabase(@NotNull Context context, @NotNull ArrayList<SttContentEntity> sttContentList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sttContentList, "sttContentList");
        SttContentRepository sttContentRepositoryCreateSttContentRepository = NotesDataRepositoryFactory.newInstance(context).createSttContentRepository();
        Intrinsics.checkNotNullExpressionValue(sttContentRepositoryCreateSttContentRepository, "createSttContentRepository(...)");
        sttContentRepositoryCreateSttContentRepository.insert(sttContentList);
    }

    private final ArrayList<SttContentEntity> saveAISpeaker(SpenVoiceTextDataReader reader, String filePath, String docUuid, long lastModifiedAt) {
        ArrayList<SttContentEntity> arrayList = new ArrayList<>();
        String speakerNameMapJSON = reader.getSpeakerNameMapJSON();
        if (speakerNameMapJSON == null || speakerNameMapJSON.length() == 0) {
            Logger.m12710d(TAG, "saveAISpeaker# data is empty or null");
            return arrayList;
        }
        arrayList.add(createEntity(docUuid, filePath, lastModifiedAt, 3, speakerNameMapJSON, 0));
        return arrayList;
    }

    private final ArrayList<SttContentEntity> saveSummaryData(SpenVoiceTextDataReader reader, String filePath, String docUuid, long lastModifiedAt) {
        ArrayList<SttContentEntity> arrayList = new ArrayList<>();
        String summaryDataJSON = reader.getSummaryDataJSON();
        if (summaryDataJSON == null || summaryDataJSON.length() == 0) {
            Logger.m12710d(TAG, "saveSummaryData# data is empty or null");
            return arrayList;
        }
        int length = (summaryDataJSON.length() / 40960) + 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String strSubstring = summaryDataJSON.substring(i * 40960, Math.min(i2 * 40960, summaryDataJSON.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            arrayList.add(createEntity(docUuid, filePath, lastModifiedAt, 2, strSubstring, i));
            i = i2;
        }
        return arrayList;
    }

    private final ArrayList<SttContentEntity> saveTranscriptExtraData(SpenVoiceTextDataReader reader, String filePath, String docUuid, long lastModifiedAt) {
        ArrayList<SttContentEntity> arrayList = new ArrayList<>();
        String[] voiceTexts = reader.getVoiceTexts();
        if (voiceTexts == null || voiceTexts.length == 0) {
            Logger.m12710d(TAG, "saveTranscriptExtraData# data is empty or null");
            return arrayList;
        }
        TranscriptExtraRawData transcriptExtraRawData = new TranscriptExtraRawData();
        transcriptExtraRawData.setParagraphInfo(getRawParagraphData(reader.getParagraphSpeakerIDs(), reader.getParagraphStartTimes(), reader.getParagraphEndTimes()));
        long[] voiceTextStartTimes = reader.getVoiceTextStartTimes();
        Intrinsics.checkNotNull(voiceTextStartTimes);
        long[] voiceTextEndTimes = reader.getVoiceTextEndTimes();
        Intrinsics.checkNotNull(voiceTextEndTimes);
        int[] voiceTextLengths = reader.getVoiceTextLengths();
        Intrinsics.checkNotNull(voiceTextLengths);
        transcriptExtraRawData.setTimeStamp(getRawTimeStampData(voiceTextStartTimes, voiceTextEndTimes, voiceTextLengths));
        String json = new GsonBuilder().create().toJson(transcriptExtraRawData, new TypeToken<TranscriptExtraRawData>() { // from class: com.samsung.android.support.senl.nt.stt.common.util.STTDataUtils$saveTranscriptExtraData$type$1
        }.getType());
        int length = (json.length() / 40960) + 1;
        Logger.m12710d(TAG, "saveTranscriptExtraData# data = ".concat(json));
        int i = 0;
        while (i < length) {
            Intrinsics.checkNotNull(json);
            int i2 = i + 1;
            String strSubstring = json.substring(i * 40960, Math.min(i2 * 40960, json.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            arrayList.add(createEntity(docUuid, filePath, lastModifiedAt, 1, strSubstring, i));
            i = i2;
        }
        return arrayList;
    }

    private final ArrayList<SttContentEntity> saveTranscriptText(SpenVoiceTextDataReader reader, String filePath, String docUuid, long lastModifiedAt) {
        ArrayList<SttContentEntity> arrayList = new ArrayList<>();
        String[] voiceTexts = reader.getVoiceTexts();
        if (voiceTexts == null || voiceTexts.length == 0) {
            Logger.m12710d(TAG, "saveTranscriptText# data is empty or null");
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        String[] voiceTexts2 = reader.getVoiceTexts();
        if (voiceTexts2 != null) {
            for (String str : voiceTexts2) {
                sb.append(str);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m12710d(TAG, "saveTranscriptText# data = " + string);
        int length = (string.length() / 40960) + 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String strSubstring = string.substring(i * 40960, Math.min(i2 * 40960, string.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            arrayList.add(createEntity(docUuid, filePath, lastModifiedAt, 0, strSubstring, i));
            i = i2;
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<SttContentEntity> setSTTDataContentToDB(@NotNull SpenVoiceTextDataReader reader, @NotNull String docUuid, @NotNull String filePath, int type, long lastModifiedAt) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return type != 0 ? type != 1 ? type != 2 ? type != 3 ? new ArrayList<>() : INSTANCE.saveAISpeaker(reader, filePath, docUuid, lastModifiedAt) : INSTANCE.saveSummaryData(reader, filePath, docUuid, lastModifiedAt) : INSTANCE.saveTranscriptExtraData(reader, filePath, docUuid, lastModifiedAt) : INSTANCE.saveTranscriptText(reader, filePath, docUuid, lastModifiedAt);
    }

    public final boolean isContains(@NotNull List<String> textS, @NotNull String textVoice) {
        Intrinsics.checkNotNullParameter(textS, "textS");
        Intrinsics.checkNotNullParameter(textVoice, "textVoice");
        for (String str : textS) {
            if (str.length() != 0) {
                String lowerCase = textVoice.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.m14162r(lowerCase, str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
