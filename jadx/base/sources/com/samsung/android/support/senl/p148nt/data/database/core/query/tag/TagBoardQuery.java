package com.samsung.android.support.senl.p148nt.data.database.core.query.tag;

import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.legacy.OldDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagBoardQuery {
    private static final String TAG_ID = "id";
    private static final String TAG_IS_LOCKED = "isLocked";
    private static final String TAG_MIME_TYPE = "mime_type";
    private static final String TAG_SDOC_UUID = "sdocUUID";
    private static final String TAG_TAG = "tag";
    private static final String TAG_TEXT1 = "text_1";
    private static final String TAG_TEXT2 = "text_2";
    private static final String TAG_THUMBNAIL_URI = "thumbnail_uri";
    private static final String TAG_TIMESTAMP = "timestamp";
    private static final String TAG_TIMESTAMP_TAG = "timestamp_tag";

    private String getIconQueryPart() {
        String str = "'" + ExternalDataConstants.BASE_URI_TAG_THUMBNAIL + "/'||";
        return new NotesSQLBuilder().caseWhen(QueryConstants.LOCKED_CONDITION).then("NULL").when("((sdoc.filePath LIKE '%.sdoc') AND (sdoc.firstContentType <= 1) AND (sdoc.secondContentType <= 1))").then("NULL").when("((GROUP_CONCAT(content._data) LIKE '%thumbnail_text%') AND (GROUP_CONCAT(content._data) NOT LIKE '%/image%'))").then("NULL").when("((sdoc.filePath LIKE '%.sdocx') AND (COUNT(content._data) IS 0))").then("NULL").elseEnd(str + "sdoc.UUID").build();
    }

    private String getOldSdocDataQuery(String str, String str2) {
        return new NotesSQLBuilder().select().mo12419as("hashtagContent._id + 1073741823", "id").mo12419as("hashtag.name", "tag").mo12419as("'application/sdoc'", "mime_type").mo12419as("sdoc.createdAt", "timestamp").mo12419as(getIconQueryPart(), "thumbnail_uri").mo12419as("sdoc.title", TAG_TEXT1).mo12419as("CASE WHEN sdoc.isLock = 0 THEN CAST(sdoc.content AS TEXT) ELSE NULL END", TAG_TEXT2).mo12419as("sdoc.UUID", "sdocUUID").mo12419as("sdoc.isLock", TAG_IS_LOCKED).asEnd("MAX(hashtagContent.lastModifiedAt)", TAG_TIMESTAMP_TAG).from(OldDBSchema.HashTagContent.TABLE_NAME).leftJoin(OldDBSchema.HashTag.TABLE_NAME).mo12421on("hashtagContent.hashtagUUID = hashtag.UUID").leftJoin("sdoc").mo12421on("hashtagContent.sdocUUID = sdoc.UUID").leftJoin("content").mo12421on("hashtagContent.sdocUUID = content.sdocUUID").leftJoin(DBSchema.MappedDocument.TABLE_NAME).mo12421on("sdoc.UUID = mapped_document.UUID").where("sdoc.UUID IS NOT NULL").and("hashtagContent.isDeleted IS 0").and("hashtag.isDeleted IS 0").and("sdoc.isDeleted IS 0").and("mapped_document.UUID IS NULL").and(str).orderBy(str2).groupBy("hashtagContent._id").build();
    }

    private String getSdocDataQuery(String str, String str2) {
        return new NotesSQLBuilder().select().mo12419as("tag_list._id", "id").mo12419as("tag_list.displayName", "tag").mo12419as("'application/sdoc'", "mime_type").mo12419as("sdoc.createdAt", "timestamp").mo12419as(getIconQueryPart(), "thumbnail_uri").mo12419as("sdoc.title", TAG_TEXT1).mo12419as("CASE WHEN sdoc.isLock = 0 THEN CAST(sdoc.content AS TEXT) ELSE NULL END", TAG_TEXT2).mo12419as("sdoc.UUID", "sdocUUID").mo12419as("sdoc.isLock", TAG_IS_LOCKED).asEnd("MAX(sdoc.serverTimestamp)", TAG_TIMESTAMP_TAG).from("tag_list").leftJoin("sdoc").mo12421on("tag_list.docUUID = sdoc.UUID").leftJoin("content").mo12421on("tag_list.docUUID = content.sdocUUID").leftJoin(DBSchema.MappedDocument.TABLE_NAME).mo12421on("tag_list.docUUID = mapped_document.UUID").where("sdoc.UUID IS NOT NULL").and("sdoc.isDeleted IS 0").and("mapped_document.mappedUUID IS NULL").and(str).orderBy(str2).groupBy("tag_list._id").build();
    }

    public String getQuery(String str, String str2) {
        return getSdocDataQuery(str, str2) + SQLKeyword.UNION + getOldSdocDataQuery(str, str2);
    }
}
