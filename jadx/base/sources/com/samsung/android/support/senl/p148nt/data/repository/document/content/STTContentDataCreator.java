package com.samsung.android.support.senl.p148nt.data.repository.document.content;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.support.senl.p148nt.base.common.TranscriptExtraRawData;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AIParagraphAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISpeakerAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.AISummarySectionAtomHelper;
import com.samsung.android.support.senl.p148nt.stt.base.filedata.M4aSerializableAtomHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class STTContentDataCreator {
    private static final String TAG = DataLogger.createTag("STTContentDataCreator");

    private SttContentEntity createEntity(@NonNull String str, @NonNull String str2, long j, @DataConstants.STT_CONTENT_TYPE int i, String str3, int i2) {
        SttContentEntity sttContentEntity = new SttContentEntity();
        sttContentEntity.setDocumentUuid(str);
        sttContentEntity.setFilePath(str2);
        sttContentEntity.setIndex(i2);
        sttContentEntity.setType(i);
        sttContentEntity.setContent(str3);
        sttContentEntity.setLastModifiedAt(j);
        return sttContentEntity;
    }

    private List<SttContentEntity> createSTTContentEntities(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getTranscriptTextEntities(str, str2, j));
        arrayList.addAll(getSummaryDataEntities(str, str2, j));
        arrayList.addAll(getTranscriptExtraDataEntities(str, str2, j));
        arrayList.addAll(getAISpeakerEntities(str, str2, j));
        return arrayList;
    }

    private List<SttContentEntity> getAISpeakerEntities(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        AISpeakerAtomHelper aISpeakerAtomHelper = new AISpeakerAtomHelper(str);
        if (aISpeakerAtomHelper.getSpeakerData() == null || aISpeakerAtomHelper.getSpeakerData().isEmpty()) {
            DataLogger.m12302d(TAG, "saveAISpeaker, data is empty or null");
            return arrayList;
        }
        arrayList.add(createEntity(str2, FileUtils.extractFile(str), j, 3, aISpeakerAtomHelper.getJson(), 0));
        return arrayList;
    }

    private String getRawParagraphData(int[] iArr, long[] jArr, long[] jArr2) {
        int length = iArr == null ? 0 : iArr.length;
        StringBuilder sb = new StringBuilder(AbstractC2322a.m1615e(length, " "));
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            sb.append(" ");
            sb.append(jArr[i]);
            sb.append(" ");
            sb.append(jArr2[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getRawTimeStampData(long[] jArr, long[] jArr2, int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(jArr.length);
        sb.append(" ");
        for (int i = 0; i < jArr.length; i++) {
            sb.append(jArr[i]);
            sb.append(" ");
            sb.append(jArr2[i]);
            sb.append(" ");
            sb.append(iArr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private List<SttContentEntity> getSummaryDataEntities(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        AISummarySectionAtomHelper aISummarySectionAtomHelper = new AISummarySectionAtomHelper(str);
        if (aISummarySectionAtomHelper.getSummaryTitle() == null || aISummarySectionAtomHelper.getSummaryTitle().length == 0) {
            DataLogger.m12302d(TAG, "saveSummaryData, data is empty or null");
            return arrayList;
        }
        String json = aISummarySectionAtomHelper.getJson();
        int length = (json.length() / 40960) + 1;
        String strExtractFile = FileUtils.extractFile(str);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            arrayList.add(createEntity(str2, strExtractFile, j, 2, json.substring(i * 40960, Math.min(i2 * 40960, json.length())), i));
            i = i2;
        }
        return arrayList;
    }

    private List<SttContentEntity> getTranscriptExtraDataEntities(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        AIParagraphAtomHelper aIParagraphAtomHelper = new AIParagraphAtomHelper(str);
        if (aIParagraphAtomHelper.getVoiceTexts() == null || aIParagraphAtomHelper.getVoiceTexts().length == 0) {
            DataLogger.m12302d(TAG, "getTranscriptExtraDataEntities, data is empty");
            return arrayList;
        }
        TranscriptExtraRawData transcriptExtraRawData = new TranscriptExtraRawData();
        transcriptExtraRawData.setParagraphInfo(getRawParagraphData(aIParagraphAtomHelper.getSpeakerIdList(), aIParagraphAtomHelper.getStartTimeList(), aIParagraphAtomHelper.getEndTimeList()));
        transcriptExtraRawData.setTimeStamp(getRawTimeStampData(aIParagraphAtomHelper.getVoiceTextStartTimes(), aIParagraphAtomHelper.getVoiceTextEndTimes(), aIParagraphAtomHelper.getVoiceTextLengths()));
        String json = new GsonBuilder().create().toJson(transcriptExtraRawData, new TypeToken<TranscriptExtraRawData>() { // from class: com.samsung.android.support.senl.nt.data.repository.document.content.STTContentDataCreator.1
        }.getType());
        int length = (json.length() / 40960) + 1;
        String strExtractFile = FileUtils.extractFile(str);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            arrayList.add(createEntity(str2, strExtractFile, j, 1, json.substring(i * 40960, Math.min(i2 * 40960, json.length())), i));
            i = i2;
        }
        return arrayList;
    }

    private List<SttContentEntity> getTranscriptTextEntities(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        String[] voiceTexts = new M4aSerializableAtomHelper(str).getVoiceTexts();
        if (voiceTexts == null || voiceTexts.length == 0) {
            DataLogger.m12302d(TAG, "saveTranscriptText, voiceTexts is empty or null");
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str3 : voiceTexts) {
            sb.append(str3);
        }
        String string = sb.toString();
        String strExtractFile = FileUtils.extractFile(str);
        int length = (string.length() / 40960) + 1;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            i = i2 + 1;
            arrayList.add(createEntity(str2, strExtractFile, j, 0, string.substring(i2 * 40960, Math.min(i * 40960, string.length())), i2));
        }
    }

    public List<SttContentEntity> createEntities(@NonNull String str, @NonNull Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : set) {
            if (str2 != null) {
                File file = new File(str2);
                if (file.exists()) {
                    arrayList.addAll(createSTTContentEntities(str2, str, file.lastModified()));
                } else {
                    DataLogger.m12309w(TAG, "createEntities, file not exist: " + DataLogger.getEncode(str2));
                }
            }
        }
        return arrayList;
    }
}
