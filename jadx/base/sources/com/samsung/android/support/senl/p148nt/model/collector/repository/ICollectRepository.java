package com.samsung.android.support.senl.p148nt.model.collector.repository;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyTextEntity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICollectRepository {
    void dumpBodyTextData();

    void dumpCodeBlockData();

    void dumpCollectResults(String str);

    void dumpEntireObjectRecognitionData();

    void dumpObjectRecognitionActionLinkData();

    void dumpObjectRecognitionSearchData();

    void dumpPdfRecognitionData();

    void dumpTableTextData();

    void dumpTextBoxSearchData();

    void dumpTitleData();

    @NonNull
    List<NotesStrokeSearchEntity> getAudioData();

    String getBodyTextData();

    @NonNull
    List<NotesStrokeSearchEntity> getCodeBlockData();

    List<String> getEntireObjectRecognitionData();

    @NonNull
    List<NotesStrokeSearchEntity> getObjectRecognitionActionLinkData();

    @NonNull
    List<NotesStrokeSearchEntity> getObjectRecognitionSearchData();

    @NonNull
    List<NotesStrokeSearchEntity> getPdfRecognitionData();

    List<StickyTextEntity> getStickyBodyTextData();

    List<StickyStrokeSearchEntity> getStickyStrokeActionLinkData();

    List<StickyStrokeSearchEntity> getStickyStrokeSearchData();

    @NonNull
    List<NotesStrokeSearchEntity> getTableTextData();

    @NonNull
    List<NotesStrokeSearchEntity> getTextBoxSearchData();

    String getTitleData();

    @NonNull
    List<NotesStrokeSearchEntity> getVoiceRecordingData();

    void setAudioData(List<NotesStrokeSearchEntity> list);

    void setBodyTextData(String str);

    void setCodeBlockData(List<NotesStrokeSearchEntity> list);

    void setEntireObjectRecognitionData(List<String> list);

    void setObjectRecognitionActionLinkData(List<NotesStrokeSearchEntity> list);

    void setObjectRecognitionSearchData(List<NotesStrokeSearchEntity> list);

    void setPdfRecognitionData(List<NotesStrokeSearchEntity> list);

    void setStickyBodyTextData(StickyTextEntity stickyTextEntity);

    void setStickyStrokeActionLinkData(List<StickyStrokeSearchEntity> list);

    void setStickyStrokeSearchData(List<StickyStrokeSearchEntity> list);

    void setTableTextData(List<NotesStrokeSearchEntity> list);

    void setTextBoxSearchData(List<NotesStrokeSearchEntity> list);

    void setTitleData(String str);

    void setVoiceRecordingData(List<NotesStrokeSearchEntity> list);
}
