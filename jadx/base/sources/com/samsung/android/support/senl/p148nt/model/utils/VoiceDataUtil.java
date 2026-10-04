package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.os.Process;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.ContentFileData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.VoiceRecordingDataSource;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class VoiceDataUtil {
    public static final int RECORDING_MIN_TIME = 1200;
    private static final String TAG = ModelLogger.createTag("VoiceDataUtil");

    private static void applyVoiceData(SpenWNote spenWNote, VoiceRecordingDataSource voiceRecordingDataSource, int i, boolean z) {
        SpenVoiceData voiceData = spenWNote.getVoiceData(i);
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "applyVoiceData# contentIndex:", " voiceData: ");
        sbM778t.append(voiceData.getName());
        sbM778t.append(SQLKeyword.COMMA);
        sbM778t.append(voiceData.getAttachedFile());
        sbM778t.append(SQLKeyword.COMMA);
        sbM778t.append(voiceData.getRecordingTime());
        DataLogger.m12302d(str, sbM778t.toString());
        String filePath = voiceRecordingDataSource.getFilePath();
        int playTime = VoiceTimeDataUtils.getPlayTime(filePath);
        DataLogger.m12302d(str, "applyVoiceData#  cachePath: " + filePath + ", playTime: " + playTime);
        if (playTime <= 1200) {
            DataLogger.m12307i(str, "applyVoiceData# removeVoiceData is true.");
            spenWNote.removeVoiceData(i);
        } else if (z) {
            DataLogger.m12302d(str, "applyVoiceData# isCoeditNote is true");
            DataLogger.m12307i(str, "applyVoiceData# removeVoiceData is true.");
            spenWNote.removeVoiceData(i);
        } else {
            voiceData.setPlayTime(VoiceTimeDataUtils.createTimeString(playTime / 1000, false));
            voiceData.setRecordingTime(playTime);
            voiceData.attachFile(filePath);
        }
        FileUtils.deleteFile(filePath);
    }

    public static List<ContentFileData> getContentFileDataSearch(Context context, String str) {
        return NotesDataRepositoryFactory.newInstance(context).createDocumentContentRepository().getContentFileDataByQuery(DataConstants.MIME_TYPE.VOICE_RECORDING, str);
    }

    public static LiveData<List<ContentFileData>> getLiveContentFileData(Context context) {
        return NotesDataRepositoryFactory.newInstance(context).createDocumentContentRepository().getLiveContentFileDataByMimeType(DataConstants.MIME_TYPE.VOICE_RECORDING);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setCachedVoiceRecordingPath(DocumentDataSource documentDataSource, SpenSDoc spenSDoc) {
        if (documentDataSource == null || spenSDoc == null) {
            return;
        }
        VoiceRecordingDataSource voiceRecordingInfo = documentDataSource.getVoiceRecordingInfo();
        int iMyPid = Process.myPid();
        String str = TAG;
        DataLogger.m12302d(str, "setCachedVoiceRecordingPath, vInfo: " + voiceRecordingInfo + ", currentPid: " + iMyPid);
        if (voiceRecordingInfo != null && voiceRecordingInfo.isValid() && voiceRecordingInfo.getProcessId() == iMyPid) {
            if (spenSDoc.getContentCount() <= 0) {
                documentDataSource.clearVoiceRecordingInfo();
                return;
            }
            int contentIndex = voiceRecordingInfo.getContentIndex();
            int contentCount = spenSDoc.getContentCount();
            if (contentIndex < 0 || contentIndex >= contentCount) {
                DataLogger.m12303e(str, "setCachedVoiceRecordingPath# contentIndex is wrong. size:" + contentCount + ", contentIndex:" + contentIndex);
                documentDataSource.clearVoiceRecordingInfo();
                return;
            }
            SpenContentBase content = spenSDoc.getContent(contentIndex);
            if (!(content instanceof SpenContentVoice)) {
                DataLogger.m12303e(str, "setCachedVoiceRecordingPath# contentBase is wrong. contentIndex:" + contentIndex);
                documentDataSource.clearVoiceRecordingInfo();
                return;
            }
            SpenContentVoice spenContentVoice = (SpenContentVoice) content;
            String filePath = voiceRecordingInfo.getFilePath();
            StringBuilder sbM778t = AbstractC0541b.m778t(contentIndex, "setCachedVoiceRecordingPath# contentIndex:", " voiceData: ");
            sbM778t.append(spenContentVoice.getAttachedFile());
            sbM778t.append(SQLKeyword.COMMA);
            sbM778t.append(spenContentVoice.getPlayTime());
            sbM778t.append(" cachePath: ");
            sbM778t.append(filePath);
            DataLogger.m12302d(str, sbM778t.toString());
            if (FileUtils.exists(voiceRecordingInfo.getFilePath())) {
                int playTime = VoiceTimeDataUtils.getPlayTime(filePath);
                DataLogger.m12302d(str, "setCachedVoiceRecordingPath, playTime: " + playTime);
                if (playTime > 1200) {
                    spenContentVoice.setPlayTime(VoiceTimeDataUtils.createTimeString(playTime / 1000, false));
                    spenContentVoice.attachFile(filePath);
                } else {
                    spenSDoc.removeContent(spenContentVoice);
                }
            }
            documentDataSource.clearVoiceRecordingInfo();
        }
    }

    public static void setCachedVoiceRecordingPath(DocumentDataSource documentDataSource, SpenWNote spenWNote, boolean z) {
        if (documentDataSource == null || spenWNote == null) {
            return;
        }
        VoiceRecordingDataSource voiceRecordingInfo = documentDataSource.getVoiceRecordingInfo();
        String str = TAG;
        DataLogger.m12302d(str, "setCachedVoiceRecordingPath# vInfo: " + voiceRecordingInfo);
        if (voiceRecordingInfo == null || !voiceRecordingInfo.isValid()) {
            return;
        }
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList != null && !voiceDataList.isEmpty()) {
            int contentIndex = voiceRecordingInfo.getContentIndex();
            int size = voiceDataList.size();
            if (contentIndex >= 0 && contentIndex < size) {
                int iMyPid = Process.myPid();
                if (FileUtils.exists(voiceRecordingInfo.getFilePath()) && voiceRecordingInfo.getProcessId() != iMyPid) {
                    applyVoiceData(spenWNote, voiceRecordingInfo, contentIndex, z);
                    documentDataSource.clearVoiceRecordingInfo();
                    return;
                }
                DataLogger.m12303e(str, "setCachedVoiceRecordingPath# vInfo is wrong. filePath:" + voiceRecordingInfo.getFilePath() + ", currentPid:" + iMyPid);
                documentDataSource.clearVoiceRecordingInfo();
                return;
            }
            DataLogger.m12303e(str, "setCachedVoiceRecordingPath# contentIndex is wrong. size:" + size + ", contentIndex:" + contentIndex);
            documentDataSource.clearVoiceRecordingInfo();
            return;
        }
        documentDataSource.clearVoiceRecordingInfo();
    }
}
