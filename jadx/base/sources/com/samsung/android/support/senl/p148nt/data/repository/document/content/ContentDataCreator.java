package com.samsung.android.support.senl.p148nt.data.repository.document.content;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContentDataCreator {
    private static final String DEFAULT_AUDIO_CONTENT_TITLE = "Audio";
    private static final String DEFAULT_VOICE_CONTENT_TITLE = "Voice";
    private final Context mAppContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class VoiceContentInfo {
        private final String mFilePath;
        private final String mPlayTime;
        private final String mTitle;
        private final String mType;

        public VoiceContentInfo(@DataConstants.MIME_TYPE String str, String str2, String str3, String str4) {
            this.mType = str;
            this.mTitle = str2;
            this.mPlayTime = str3;
            this.mFilePath = str4;
        }
    }

    public ContentDataCreator(@NonNull Context context) {
        this.mAppContext = context;
    }

    @NonNull
    private NotesContentEntity createVoiceContentEntity(String str, @DataConstants.MIME_TYPE String str2, String str3, String str4, String str5) {
        NotesContentEntity notesContentEntity = new NotesContentEntity();
        notesContentEntity.setUuid(UUIDUtils.newUUID(this.mAppContext));
        notesContentEntity.setSdocUuid(str);
        notesContentEntity.setMimeType(str2);
        notesContentEntity.setDisplayName(str3);
        notesContentEntity.setMediaData(String.valueOf(str4));
        notesContentEntity.setFilePath(FileUtils.extractFile(str5));
        if (str5 != null) {
            File file = new File(str5);
            if (file.exists()) {
                notesContentEntity.setSize(file.length());
                notesContentEntity.setCreatedAt(file.lastModified());
            }
        }
        return notesContentEntity;
    }

    private List<VoiceContentInfo> getAudioContents(@NonNull SpenWNote spenWNote) {
        ArrayList arrayList = new ArrayList();
        for (SpenObjectVoice spenObjectVoice : new SpenWNoteObjectHelper().getSortedObjectList(spenWNote, 512)) {
            arrayList.add(new VoiceContentInfo(DataConstants.MIME_TYPE.AUDIO, spenObjectVoice.getTitle() != null ? spenObjectVoice.getTitle() : DEFAULT_AUDIO_CONTENT_TITLE, spenObjectVoice.getPlayTime(), spenObjectVoice.getAttachedFile()));
        }
        return arrayList;
    }

    private List<VoiceContentInfo> getVoiceContents(@NonNull SpenWNote spenWNote) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        if (voiceDataList != null) {
            for (SpenVoiceData spenVoiceData : voiceDataList) {
                arrayList.add(new VoiceContentInfo(DataConstants.MIME_TYPE.VOICE_RECORDING, spenVoiceData.getName() != null ? spenVoiceData.getName() : DEFAULT_VOICE_CONTENT_TITLE, spenVoiceData.getPlayTime(), spenVoiceData.getAttachedFile()));
            }
        }
        return arrayList;
    }

    public List<NotesContentEntity> createThumbnailEntities(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = new File(PageCacheUtils.getCacheDirectory(this.mAppContext, str, Constants.MAIN_THUMBNAIL_PATH) + File.separator).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                NotesContentEntity notesContentEntity = new NotesContentEntity();
                notesContentEntity.setUuid(UUIDUtils.newUUID(this.mAppContext));
                notesContentEntity.setSdocUuid(str);
                notesContentEntity.setMimeType(DataConstants.MIME_TYPE.IMAGE);
                notesContentEntity.setMediaData(file.getAbsolutePath());
                notesContentEntity.setSize(file.length());
                notesContentEntity.setCreatedAt(file.lastModified());
                arrayList.add(notesContentEntity);
            }
        }
        return arrayList;
    }

    public List<NotesContentEntity> createVoiceEntities(@NonNull SpenWNote spenWNote, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<VoiceContentInfo> arrayList2 = new ArrayList();
        arrayList2.addAll(getAudioContents(spenWNote));
        arrayList2.addAll(getVoiceContents(spenWNote));
        for (VoiceContentInfo voiceContentInfo : arrayList2) {
            String str2 = str;
            arrayList.add(createVoiceContentEntity(str2, voiceContentInfo.mType, voiceContentInfo.mTitle, VoiceTimeDataUtils.convertPlayTime(voiceContentInfo.mPlayTime), voiceContentInfo.mFilePath));
            str = str2;
        }
        return arrayList;
    }
}
