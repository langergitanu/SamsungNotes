package com.samsung.android.support.senl.p148nt.model.collector.repository;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.collect.CollectTestLogger;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyTextEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectRepository implements ICollectRepository {
    private static final String TAG = CollectLogger.createTag("CollectRepository");
    private String mBodyTextData;
    private String mTitleData;
    private final List<NotesStrokeSearchEntity> mObjectRecognitionSearchData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mObjectRecognitionActionLinkData = new ArrayList();
    private final List<String> mEntireObjectRecognitionData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mPdfRecognitionData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mTextBoxSearchData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mVoiceRecordingData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mAudioData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mTableTextData = new ArrayList();
    private final List<NotesStrokeSearchEntity> mCodeBlockData = new ArrayList();
    private final List<StickyStrokeSearchEntity> mStickyStrokeSearchData = new ArrayList();
    private final List<StickyStrokeSearchEntity> mStickyStrokeActionLinkData = new ArrayList();
    private final List<StickyTextEntity> mStickyBodyTextData = new ArrayList();

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpBodyTextData() {
        if (DeviceInfo.isEngMode()) {
            DataLogger.m12302d(TAG, "dumpBodyTextData : " + this.mBodyTextData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpCodeBlockData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mCodeBlockData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpCodeBlockData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpCollectResults(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("OR" + this.mEntireObjectRecognitionData.size() + "/");
        sb.append("PR" + this.mPdfRecognitionData.size() + "/");
        sb.append("TB" + this.mTextBoxSearchData.size() + "/");
        sb.append("TA" + this.mTableTextData.size() + "/");
        sb.append("CB" + this.mCodeBlockData.size() + "/");
        if (!TextUtils.isEmpty(this.mBodyTextData)) {
            sb.append("BT" + this.mBodyTextData.length() + "/");
        }
        if (!TextUtils.isEmpty(this.mTitleData)) {
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + DataLogger.getEncode(this.mTitleData));
        }
        String str2 = TAG;
        DataLogger.m12305f(str2, str + ":" + ((Object) sb));
        CollectTestLogger.log(str2 + str + ":" + ((Object) sb));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpEntireObjectRecognitionData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.mEntireObjectRecognitionData.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpEntireObjectRecognitionData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpObjectRecognitionActionLinkData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mObjectRecognitionActionLinkData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpObjectRecognitionActionLinkData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpObjectRecognitionSearchData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mObjectRecognitionSearchData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpObjectRecognitionSearchData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpPdfRecognitionData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mPdfRecognitionData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpPdfRecognitionData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpTableTextData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mTableTextData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpTableTextData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpTextBoxSearchData() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            Iterator<NotesStrokeSearchEntity> it = this.mTextBoxSearchData.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getText());
                sb.append(SQLKeyword.COMMA);
            }
            DataLogger.m12302d(TAG, "dumpTextBoxSearchData : " + ((Object) sb));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void dumpTitleData() {
        if (DeviceInfo.isEngMode()) {
            DataLogger.m12302d(TAG, "dumpTitleData : " + this.mTitleData);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getAudioData() {
        return this.mAudioData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public String getBodyTextData() {
        return this.mBodyTextData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getCodeBlockData() {
        return this.mCodeBlockData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public List<String> getEntireObjectRecognitionData() {
        return this.mEntireObjectRecognitionData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getObjectRecognitionActionLinkData() {
        return this.mObjectRecognitionActionLinkData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getObjectRecognitionSearchData() {
        return this.mObjectRecognitionSearchData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getPdfRecognitionData() {
        return this.mPdfRecognitionData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public List<StickyTextEntity> getStickyBodyTextData() {
        return this.mStickyBodyTextData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public List<StickyStrokeSearchEntity> getStickyStrokeActionLinkData() {
        return this.mStickyStrokeActionLinkData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public List<StickyStrokeSearchEntity> getStickyStrokeSearchData() {
        return this.mStickyStrokeSearchData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getTableTextData() {
        return this.mTableTextData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getTextBoxSearchData() {
        return this.mTextBoxSearchData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public String getTitleData() {
        return this.mTitleData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    @NonNull
    public List<NotesStrokeSearchEntity> getVoiceRecordingData() {
        return this.mVoiceRecordingData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setAudioData(List<NotesStrokeSearchEntity> list) {
        this.mAudioData.addAll(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setBodyTextData(String str) {
        DataLogger.m12302d(TAG, "setBodyTextData");
        this.mBodyTextData = str;
        dumpBodyTextData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setCodeBlockData(List<NotesStrokeSearchEntity> list) {
        DataLogger.m12302d(TAG, "setCodeBlockData");
        this.mCodeBlockData.addAll(list);
        dumpTextBoxSearchData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setEntireObjectRecognitionData(List<String> list) {
        DataLogger.m12302d(TAG, "setEntireObjectRecognitionData");
        this.mEntireObjectRecognitionData.addAll(list);
        dumpEntireObjectRecognitionData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setObjectRecognitionActionLinkData(List<NotesStrokeSearchEntity> list) {
        DataLogger.m12302d(TAG, "setObjectRecognitionActionLinkData");
        this.mObjectRecognitionActionLinkData.addAll(list);
        dumpObjectRecognitionActionLinkData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setObjectRecognitionSearchData(List<NotesStrokeSearchEntity> list) {
        DataLogger.m12302d(TAG, "setObjectRecognitionSearchData");
        this.mObjectRecognitionSearchData.addAll(list);
        dumpObjectRecognitionSearchData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setPdfRecognitionData(List<NotesStrokeSearchEntity> list) {
        DataLogger.m12302d(TAG, "setPdfRecognitionData");
        this.mPdfRecognitionData.addAll(list);
        dumpPdfRecognitionData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setStickyBodyTextData(StickyTextEntity stickyTextEntity) {
        this.mStickyBodyTextData.add(stickyTextEntity);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setStickyStrokeActionLinkData(List<StickyStrokeSearchEntity> list) {
        this.mStickyStrokeActionLinkData.addAll(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setStickyStrokeSearchData(List<StickyStrokeSearchEntity> list) {
        this.mStickyStrokeSearchData.addAll(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setTableTextData(List<NotesStrokeSearchEntity> list) {
        this.mTableTextData.addAll(list);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setTextBoxSearchData(List<NotesStrokeSearchEntity> list) {
        DataLogger.m12302d(TAG, "setTextBoxSearchData");
        this.mTextBoxSearchData.addAll(list);
        dumpTextBoxSearchData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setTitleData(String str) {
        DataLogger.m12302d(TAG, "setTitleData");
        this.mTitleData = str;
        dumpTitleData();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.collector.repository.ICollectRepository
    public void setVoiceRecordingData(List<NotesStrokeSearchEntity> list) {
        this.mVoiceRecordingData.addAll(list);
    }
}
