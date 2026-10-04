package com.samsung.android.support.senl.p148nt.data.repository.converter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.AndroidInstanceConstructor;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentEntityConverter {
    public Bundle convert(@NonNull NotesDocumentEntity notesDocumentEntity) {
        Bundle bundleMakeBundle = AndroidInstanceConstructor.makeBundle();
        bundleMakeBundle.putLong("_id", notesDocumentEntity.getId().longValue());
        bundleMakeBundle.putString("UUID", notesDocumentEntity.getUuid());
        bundleMakeBundle.putInt("isDeleted", notesDocumentEntity.getIsDeleted());
        bundleMakeBundle.putInt("isDirty", notesDocumentEntity.getIsDirty());
        bundleMakeBundle.putString("accountType", notesDocumentEntity.getAccountType());
        bundleMakeBundle.putString("accountName", notesDocumentEntity.getAccountName());
        bundleMakeBundle.putString("title", notesDocumentEntity.getTitle());
        bundleMakeBundle.putString("content", notesDocumentEntity.getContent());
        bundleMakeBundle.putByteArray("displayContent", notesDocumentEntity.getDisplayContent());
        bundleMakeBundle.putLong("createdAt", notesDocumentEntity.getCreatedAt());
        bundleMakeBundle.putLong("lastModifiedAt", notesDocumentEntity.getLastModifiedAt());
        bundleMakeBundle.putLong("serverTimestamp", notesDocumentEntity.getServerTimestamp().longValue());
        bundleMakeBundle.putString(DBSchema.Document.VR_UUID, notesDocumentEntity.getVrUuid());
        bundleMakeBundle.putString(DBSchema.Document.CONTENT_UUID, notesDocumentEntity.getContentUuid());
        bundleMakeBundle.putInt("firstContentType", notesDocumentEntity.getFirstContentType().intValue());
        bundleMakeBundle.putInt("secondContentType", notesDocumentEntity.getSecondContentType().intValue());
        bundleMakeBundle.putString("strokeUUID", notesDocumentEntity.getStrokeUuid());
        bundleMakeBundle.putFloat("strokeRatio", notesDocumentEntity.getStrokeRatio().floatValue());
        bundleMakeBundle.putString("categoryUUID", notesDocumentEntity.getCategoryUuid());
        bundleMakeBundle.putLong(DBSchema.Document.CATEGORY_SERVER_TIMESTAMP, notesDocumentEntity.getCategoryServerTimeStamp().longValue());
        bundleMakeBundle.putInt(DBSchema.Document.CATEGORY_IS_DIRTY, notesDocumentEntity.getCategoryIsDirty());
        bundleMakeBundle.putString("filePath", notesDocumentEntity.getFilePath());
        bundleMakeBundle.putString(DBSchema.Document.NOTENAME, notesDocumentEntity.getNoteName());
        bundleMakeBundle.putInt("isFavorite", notesDocumentEntity.getIsFavorite());
        bundleMakeBundle.putInt("isLock", 0);
        bundleMakeBundle.putInt("saveType", notesDocumentEntity.getSaveType());
        bundleMakeBundle.putInt("reminderRequestCode", notesDocumentEntity.getReminderRequestCode());
        bundleMakeBundle.putLong("reminderTriggerTime", notesDocumentEntity.getReminderTriggerTime());
        bundleMakeBundle.putLong("recycle_bin_time_moved", notesDocumentEntity.getRecycleBinTimeMoved());
        bundleMakeBundle.putInt("contentSecureVersion", notesDocumentEntity.getContentSecureVersion());
        bundleMakeBundle.putInt("size", (int) notesDocumentEntity.getSize());
        bundleMakeBundle.putByteArray("displayTitle", notesDocumentEntity.getDisplayTitle());
        bundleMakeBundle.putLong("firstOpendAt", notesDocumentEntity.getFirstOpendAt());
        bundleMakeBundle.putLong("secondOpenedAt", notesDocumentEntity.getSecondOpenedAt());
        bundleMakeBundle.putLong("lastOpenedAt", notesDocumentEntity.getLastOpenedAt());
        bundleMakeBundle.putLong("importedAt", notesDocumentEntity.getImportedAt());
        bundleMakeBundle.putLong("recommendedAt", notesDocumentEntity.getRecommendedAt());
        bundleMakeBundle.putLong(DBSchema.Document.LAST_MAPPED_AT, notesDocumentEntity.getLastMappedAt());
        bundleMakeBundle.putString("mdeSpaceId", notesDocumentEntity.getMdeSpaceId());
        bundleMakeBundle.putString("mdeItemId", notesDocumentEntity.getMdeItemId());
        bundleMakeBundle.putString("mdeExtra", notesDocumentEntity.getMdeExtra());
        bundleMakeBundle.putString("mdeGroupId", notesDocumentEntity.getMdeGroupId());
        bundleMakeBundle.putString("mdeOwnerId", notesDocumentEntity.getMdeOwnerId());
        bundleMakeBundle.putInt("firstHandwritingHeight", notesDocumentEntity.getFirstHandwritingHeight());
        bundleMakeBundle.putInt("deleteRecommended", notesDocumentEntity.getDeleteRecommended());
        bundleMakeBundle.putString(DBSchema.Document.ABSOLUTE_PATH, notesDocumentEntity.getAbsolutePath());
        bundleMakeBundle.putInt("backgroundColor", notesDocumentEntity.getBackgroundColor());
        return bundleMakeBundle;
    }
}
