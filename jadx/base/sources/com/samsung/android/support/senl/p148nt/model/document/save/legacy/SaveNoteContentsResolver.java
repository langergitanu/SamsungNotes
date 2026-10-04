package com.samsung.android.support.senl.p148nt.model.document.save.legacy;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayData;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.DisplayDataHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.legacy.SaveNoteContents;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SaveNoteContentsResolver {
    private static final String TAG = DataLogger.createTag("SaveNoteContentsResolver");
    private static final int THUMBNAIL_HW_GRID_HEIGHT_MAX = 1013;
    private static final float THUMBNAIL_HW_GRID_RATIO = 0.5f;
    private static final int THUMBNAIL_HW_LIST_WIDTH = 1440;
    private ContainsContentsInfo cInfo;
    private final Context mAppContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContainsContentsInfo {
        public String contentUuid;
        public CharSequence displayContent;
        public boolean isFirstJoin;
        public float strokeRatio;
        public String strokeUuid;
        public StringBuilder textContent;
        public String vrUuid;

        public /* synthetic */ ContainsContentsInfo(int i) {
            this();
        }

        public void joinDisplayContent(CharSequence charSequence) {
            if (charSequence == null) {
                DataLogger.m12302d(SaveNoteContentsResolver.TAG, "joinDisplayContent, sequence is null.");
            } else if (!this.isFirstJoin) {
                this.displayContent = TextUtils.concat(this.displayContent, charSequence);
            } else {
                this.displayContent = charSequence;
                this.isFirstJoin = false;
            }
        }

        private ContainsContentsInfo() {
            this.displayContent = "";
            this.isFirstJoin = true;
            this.contentUuid = null;
            this.strokeUuid = null;
            this.strokeRatio = 0.0f;
            this.vrUuid = null;
            this.textContent = new StringBuilder();
        }
    }

    public SaveNoteContentsResolver(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void insertContents(String str, SpenSDoc spenSDoc, ArrayList<SpenContentBase> arrayList, NotesDocumentEntity notesDocumentEntity, boolean z) {
        String str2;
        this.cInfo = new ContainsContentsInfo(0);
        SaveNoteContents.TaskInfo taskInfo = new SaveNoteContents.TaskInfo();
        if (z && spenSDoc.getSearchData() != null && !spenSDoc.getSearchData().isEmpty()) {
            spenSDoc.setSearchData(new ArrayList<>());
        }
        int size = arrayList.size() - 1;
        int i = 0;
        while (i <= size) {
            SpenContentBase spenContentBase = arrayList.get(i);
            if (i > 0) {
                taskInfo = new SaveNoteContents.TaskInfo(arrayList.get(i - 1));
            }
            SaveNoteContents.TaskInfo taskInfo2 = taskInfo;
            int type = spenContentBase.getType();
            if (type == 1) {
                str2 = str;
                insertContentsText(spenContentBase, taskInfo2, i == size);
            } else if (type == 2) {
                str2 = str;
                insertContentsImage(str2, i, spenContentBase, taskInfo2, i != size);
            } else {
                if (type != 3) {
                    if (type != 4) {
                        if (type == 5) {
                            insertContentsWeb(str, i, spenContentBase);
                        } else if (type == 7) {
                            insertContentsVoice(str, i, spenContentBase);
                        }
                    }
                    str2 = str;
                    insertContentsImage(str2, i, spenContentBase, taskInfo2, i != size);
                } else {
                    if (z) {
                        removeHandwritingSearchData((SpenContentHandWriting) spenContentBase);
                    }
                    insertContentsHandWriting(str, i, spenContentBase, notesDocumentEntity);
                }
                str2 = str;
            }
            i++;
            str = str2;
            taskInfo = taskInfo2;
        }
        insertContentsEnd();
    }

    private void insertContentsEnd() {
        if (this.cInfo.displayContent.length() > 300) {
            String string = this.cInfo.displayContent.subSequence(0, 300).toString();
            try {
                int iCodePointCount = string.codePointCount(0, string.length());
                int iOffsetByCodePoints = this.cInfo.displayContent.toString().offsetByCodePoints(0, iCodePointCount);
                if (iOffsetByCodePoints > string.length()) {
                    iOffsetByCodePoints = this.cInfo.displayContent.toString().offsetByCodePoints(0, iCodePointCount - 1);
                }
                DataLogger.m12302d(TAG, "subSequence, endIndex: " + iOffsetByCodePoints);
                ContainsContentsInfo containsContentsInfo = this.cInfo;
                containsContentsInfo.displayContent = containsContentsInfo.displayContent.subSequence(0, iOffsetByCodePoints);
            } catch (Exception unused) {
                ContainsContentsInfo containsContentsInfo2 = this.cInfo;
                containsContentsInfo2.displayContent = containsContentsInfo2.displayContent.subSequence(0, 300);
            }
        }
    }

    private void insertContentsHandWriting(String str, int i, SpenContentBase spenContentBase, NotesDocumentEntity notesDocumentEntity) {
        boolean z;
        String str2;
        boolean z2;
        if (this.cInfo.strokeUuid != null) {
            DataLogger.m12302d(TAG, "insertContents, stroke already added.");
            return;
        }
        SpenContentHandWriting spenContentHandWriting = (SpenContentHandWriting) spenContentBase;
        if (TextUtils.isEmpty(spenContentHandWriting.getAttachedFile())) {
            DataLogger.m12302d(TAG, "insertContents, attachedFile is empty.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        if (spenContentHandWriting.getThumbnailPathList() != null) {
            DataLogger.m12302d(TAG, "insertContents, thumbnailPathList size: " + spenContentHandWriting.getThumbnailPathList().size());
            z = false;
            for (String str4 : spenContentHandWriting.getThumbnailPathList()) {
                if (str4 == null) {
                    str4 = "";
                }
                arrayList.add(str4);
                if (str4.contains("jpg")) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (arrayList.isEmpty()) {
            DataLogger.m12302d(TAG, "insertContents, getThumbnailPathList is empty, retry getThumbnailPath");
            String thumbnailPath = spenContentHandWriting.getThumbnailPath();
            if (TextUtils.isEmpty(thumbnailPath)) {
                return;
            }
            arrayList.add(thumbnailPath);
            return;
        }
        Bitmap bitmapCreateResultBitmap = HandWritingBitmap.createResultBitmap(this.mAppContext, spenContentHandWriting, arrayList);
        if (bitmapCreateResultBitmap == null) {
            DataLogger.m12302d(TAG, "insertContents, handwriting resultBitmap is null.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (bitmapCreateResultBitmap.getHeight() > 1440) {
            arrayList2.add(resizeHwListBitmap(bitmapCreateResultBitmap));
            arrayList3.add(DataConstants.LIST_POSTFIX);
        }
        if (bitmapCreateResultBitmap.getHeight() > 1013) {
            arrayList2.add(resizeHwGridBitmap(bitmapCreateResultBitmap));
            arrayList3.add(DataConstants.GRID_POSTFIX);
        }
        Bitmap bitmapResizeBitmapFitingToScreen = ImageUtils.resizeBitmapFitingToScreen(bitmapCreateResultBitmap, 768);
        arrayList2.add(bitmapResizeBitmapFitingToScreen);
        arrayList3.add("");
        notesDocumentEntity.setBackgroundColor(-1);
        if (z || spenContentHandWriting.getBackgroundColor() != 0) {
            str2 = str3;
            z2 = false;
        } else if (spenContentHandWriting.isImageIncluded()) {
            z2 = true;
            str2 = "";
        } else {
            notesDocumentEntity.setBackgroundColor(0);
            str3 = "d_";
            str2 = str3;
            z2 = false;
        }
        try {
            this.cInfo.strokeUuid = UUIDUtils.newUUID(this.mAppContext);
            this.cInfo.strokeRatio = bitmapResizeBitmapFitingToScreen.getHeight() / bitmapResizeBitmapFitingToScreen.getWidth();
            String strCreateHWThumbnailFiles = DataToSyncManager.getInstance().createHWThumbnailFiles(this.mAppContext, arrayList2, this.cInfo.strokeUuid, arrayList3, str2, z2);
            DataLogger.m12302d(TAG, "insertContents, thumbnail: " + DataLogger.getEncode(strCreateHWThumbnailFiles) + ", exist: " + new File(strCreateHWThumbnailFiles).exists() + ", isImageIncluded : " + z2);
            NotesContentEntity notesContentEntity = new NotesContentEntity();
            notesContentEntity.setUuid(this.cInfo.strokeUuid);
            notesContentEntity.setSdocUuid(str);
            notesContentEntity.setSrcId(i);
            notesContentEntity.setMimeType(DataConstants.MIME_TYPE.HANDWRITING);
            notesContentEntity.setMediaData(strCreateHWThumbnailFiles);
            notesContentEntity.setFilePath(FileUtils.extractFile((String) arrayList.get(0)));
            NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentContentRepository().insert(notesContentEntity);
            bitmapResizeBitmapFitingToScreen.recycle();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((Bitmap) it.next()).recycle();
            }
            DataLogger.m12302d(TAG, "insertContents, content uuid: " + this.cInfo.strokeUuid);
        } catch (IOException e) {
            DataLogger.m12304e(TAG, "insertContents", e);
        }
    }

    private void insertContentsImage(String str, int i, SpenContentBase spenContentBase, SaveNoteContents.TaskInfo taskInfo, boolean z) {
        String str2 = spenContentBase.getType() == 4 ? DataConstants.MIME_TYPE.DRAWING : DataConstants.MIME_TYPE.IMAGE;
        if (spenContentBase.getTaskStyle() != 0) {
            this.cInfo.joinDisplayContent(SaveNoteContents.getDisplayText(spenContentBase, taskInfo, z));
        }
        if (this.cInfo.contentUuid != null) {
            DataLogger.m12302d(TAG, "insertContents, image already added.");
            return;
        }
        String thumbnailPath = spenContentBase.getThumbnailPath();
        if (TextUtils.isEmpty(thumbnailPath)) {
            DataLogger.m12302d(TAG, "insertContents, image path is empty.");
            return;
        }
        Bitmap bitmapDecodeSampledBitmapFromFile = DataToSyncManager.getInstance().decodeSampledBitmapFromFile(this.mAppContext, thumbnailPath);
        if (bitmapDecodeSampledBitmapFromFile == null) {
            DataLogger.m12302d(TAG, "insertContents, image bitmap is null.");
            return;
        }
        try {
            this.cInfo.contentUuid = UUIDUtils.newUUID(this.mAppContext);
            String strCreateThumbnailFile = DataToSyncManager.getInstance().createThumbnailFile(this.mAppContext, bitmapDecodeSampledBitmapFromFile, this.cInfo.contentUuid);
            if (TextUtils.isEmpty(strCreateThumbnailFile)) {
                return;
            }
            NotesContentEntity notesContentEntity = new NotesContentEntity();
            notesContentEntity.setUuid(this.cInfo.contentUuid);
            notesContentEntity.setSdocUuid(str);
            notesContentEntity.setSrcId(i);
            notesContentEntity.setMimeType(str2);
            notesContentEntity.setMediaData(strCreateThumbnailFile);
            notesContentEntity.setFilePath(FileUtils.extractFile(thumbnailPath));
            NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentContentRepository().insert(notesContentEntity);
        } catch (IOException e) {
            DataLogger.m12304e(TAG, "insertContents", e);
        }
    }

    private void insertContentsText(SpenContentBase spenContentBase, SaveNoteContents.TaskInfo taskInfo, boolean z) {
        if (spenContentBase.getText() != null) {
            StringBuilder sb = this.cInfo.textContent;
            sb.append(spenContentBase.getText());
            sb.append("\n");
        }
        if (this.cInfo.displayContent.length() >= 300) {
            return;
        }
        this.cInfo.joinDisplayContent(SaveNoteContents.getDisplayText(spenContentBase, taskInfo, z));
    }

    private void insertContentsVoice(String str, int i, SpenContentBase spenContentBase) {
        SpenContentVoice spenContentVoice = (SpenContentVoice) spenContentBase;
        if (spenContentVoice.getAttachedFile() == null) {
            DataLogger.m12302d(TAG, "insertContents, attached file is null.");
            return;
        }
        String strNewUUID = UUIDUtils.newUUID(this.mAppContext);
        ContainsContentsInfo containsContentsInfo = this.cInfo;
        if (containsContentsInfo.vrUuid == null) {
            containsContentsInfo.vrUuid = strNewUUID;
        }
        NotesContentEntity notesContentEntity = new NotesContentEntity();
        notesContentEntity.setUuid(strNewUUID);
        notesContentEntity.setSdocUuid(str);
        notesContentEntity.setSrcId(i);
        notesContentEntity.setMimeType(DataConstants.MIME_TYPE.VOICE);
        notesContentEntity.setDisplayName(spenContentVoice.getText() != null ? spenContentVoice.getText() : "Voice");
        notesContentEntity.setMediaData(VoiceTimeDataUtils.convertPlayTime(spenContentVoice.getPlayTime()));
        notesContentEntity.setFilePath(FileUtils.extractFile(spenContentVoice.getAttachedFile()));
        NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentContentRepository().insert(notesContentEntity);
    }

    private void insertContentsWeb(String str, int i, SpenContentBase spenContentBase) {
        if (this.cInfo.contentUuid != null) {
            DataLogger.m12302d(TAG, "insertContents, web already added.");
            return;
        }
        String thumbnailPath = spenContentBase.getThumbnailPath();
        if (thumbnailPath == null) {
            DataLogger.m12302d(TAG, "insertContents, web thumbnail path is null.");
            return;
        }
        Bitmap bitmapDecodeSampledBitmapFromFile = DataToSyncManager.getInstance().decodeSampledBitmapFromFile(this.mAppContext, thumbnailPath);
        if (bitmapDecodeSampledBitmapFromFile == null) {
            DataLogger.m12302d(TAG, "insertContents, bitmap is null.");
            return;
        }
        try {
            this.cInfo.contentUuid = UUIDUtils.newUUID(this.mAppContext);
            String strCreateThumbnailFile = DataToSyncManager.getInstance().createThumbnailFile(this.mAppContext, bitmapDecodeSampledBitmapFromFile, this.cInfo.contentUuid);
            if (TextUtils.isEmpty(strCreateThumbnailFile)) {
                return;
            }
            NotesContentEntity notesContentEntity = new NotesContentEntity();
            notesContentEntity.setUuid(this.cInfo.contentUuid);
            notesContentEntity.setSdocUuid(str);
            notesContentEntity.setSrcId(i);
            notesContentEntity.setMimeType(DataConstants.MIME_TYPE.WEB);
            notesContentEntity.setMediaData(strCreateThumbnailFile);
            NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentContentRepository().insert(notesContentEntity);
        } catch (IOException e) {
            DataLogger.m12304e(TAG, "updateContents", e);
        }
    }

    private void removeHandwritingSearchData(@NonNull SpenContentHandWriting spenContentHandWriting) {
        spenContentHandWriting.setText("");
        spenContentHandWriting.setActionLinkData(new ArrayList<>());
    }

    private static Bitmap resizeHwGridBitmap(Bitmap bitmap) {
        int height = (int) (bitmap.getHeight() * 0.5f);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.5f), height, true);
        int width = (int) (bitmapCreateScaledBitmap.getWidth() * 1.0f);
        if (height > width) {
            bitmapCreateScaledBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap, 0, 0, bitmapCreateScaledBitmap.getWidth(), width);
        }
        DataLogger.m12302d(TAG, "resizeHwGridBitmap, width = " + bitmapCreateScaledBitmap.getWidth() + ", height = " + bitmapCreateScaledBitmap.getHeight());
        return bitmapCreateScaledBitmap;
    }

    private static Bitmap resizeHwListBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        if (bitmap.getHeight() > 1440) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, 1440);
        }
        DataLogger.m12302d(TAG, "resizeHwListBitmap, width = " + bitmap.getWidth() + ", height = " + bitmap.getHeight());
        return bitmap;
    }

    public void removeContents(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentContentRepository().deleteBySDocUuid(Collections.singleton(str));
    }

    public void updateContents(@NonNull NotesDocumentEntity notesDocumentEntity, String str, SpenSDoc spenSDoc, boolean z, boolean z2) {
        ArrayList<SpenContentBase> contentList = spenSDoc.getContentList();
        if (contentList == null || contentList.isEmpty()) {
            DataLogger.m12303e(TAG, "contentData is empty.");
            return;
        }
        Pair<Integer, Integer> contentsType = SaveNoteContents.getContentsType(contentList);
        String str2 = TAG;
        DataLogger.m12302d(str2, "updateContents, cType: " + contentsType);
        notesDocumentEntity.setFirstContentType((Integer) contentsType.first);
        notesDocumentEntity.setSecondContentType((Integer) contentsType.second);
        insertContents(str, spenSDoc, contentList, notesDocumentEntity, z2);
        DataLogger.m12302d(str2, "updateContents, isCreateTitleAutomatically: " + z);
        notesDocumentEntity.setContent(DisplayDataConverter.trimMaxContentString(SaveNoteContents.makeStrippedContent(DisplayDataConverter.trimMaxIndexContentString(this.cInfo.textContent.toString()))));
        DisplayData displayData = new DisplayData();
        displayData.setContent(this.cInfo.displayContent);
        notesDocumentEntity.setDisplayContent(DisplayDataHelper.marshall(displayData));
        notesDocumentEntity.setContentSecureVersion(0);
        notesDocumentEntity.setContentUuid(this.cInfo.contentUuid);
        notesDocumentEntity.setStrokeUuid(this.cInfo.strokeUuid);
        notesDocumentEntity.setStrokeRatio(Float.valueOf(this.cInfo.strokeRatio));
        notesDocumentEntity.setVrUuid(this.cInfo.vrUuid);
    }
}
