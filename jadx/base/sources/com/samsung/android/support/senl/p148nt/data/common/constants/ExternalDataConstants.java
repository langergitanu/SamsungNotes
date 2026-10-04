package com.samsung.android.support.senl.p148nt.data.common.constants;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalDataConstants {
    public static final String AUTHORITY = "com.samsung.android.app.notes";
    public static final Uri AUTHORITY_URI;
    public static final Uri BASE_URI_NOTE;
    public static final Uri BASE_URI_NOTE_TAG;
    public static final Uri BASE_URI_TAG_THUMBNAIL;
    public static final int BODY_TEXT_MAX_LENGTH = 350000;
    public static final String DOCUMENT_TABLE_NAME = "document";
    public static final int HW_TEXT_MAX_LENGTH = 350000;
    public static final String KEY_DOCUMENT_UUID = "docUUID";
    public static final String KEY_INSERT_NOTE_DB_ONLY = "KEY_INSERT_NOTE_DB_ONLY";
    public static final int PDF_TEXT_MAX_LENGTH = 350000;
    public static final int SIMPLE_BODY_TEXT_MAX_LENGTH = 300;
    public static final Uri URI_FINDER_THUMBNAIL;
    public static final Uri URI_FINDER_UUID;
    public static final Uri URI_MULTIPLE_DOCUMENTS_UPDATED;
    public static final String URI_PATH_CONTENT = "content";
    private static final String URI_PATH_DATA = "data";
    private static final String URI_PATH_DOCUMENT = "data/document";
    public static final String URI_PATH_FINDER = "search_suggest_regex_query";
    public static final String URI_PATH_FINDER_THUMBNAIL = "thumbnail_finder";
    public static final String URI_PATH_FINDER_UUID = "uuid_finder/";
    public static final String URI_PATH_MULTIPLE_DOCUMENTS_UPDATED = "data/document/update_multiple";
    public static final String URI_PATH_SINGLE_DOCUMENT_UPDATED = "data/document/update_single";
    public static final String URI_PATH_TAG = "usertag";
    public static final String URI_PATH_TAG_THUMBNAIL = "thumbnail_tag";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Column {
        public static final String AUDIO_TITLE = "audioTitle";
        public static final String BODY_TEXT = "bodyText";
        public static final String CODE_BLOCK_TEXT = "codeBlockText";
        public static final String CONTENT_URI = "contentUri";
        public static final String COVER_SUMMARY = "coverSummary";
        public static final String CREATED_AT = "createdAt";
        public static final String EXTRA_DATA = "extraData";
        public static final String HANDWRITING_TEXT = "hwText";
        public static final String LAST_MODIFIED_AT = "lastModifiedAt";
        public static final String PDF_TEXT = "pdfText";
        public static final String SEARCH_FILTER = "filter";
        public static final String SIMPLE_BODY_TEXT = "simpleBodyText";
        public static final String TABLE_TEXT = "tableText";
        public static final String TAG_TEXT = "tagText";
        public static final String TEXT_BOX = "textBox";
        public static final String THUMBNAIL_URI = "thumbnailUri";
        public static final String TIME_STAMP = "timestamp";
        public static final String TITLE = "title";
        public static final String UUID = "UUID";
        public static final String VOICE_RECORDING_STT = "voiceRecordingStt";
        public static final String VOICE_RECORDING_TITLE = "voiceRecordingTitle";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface EmbeddingConfig {
        public static final String CHUNKING_SIZE = "size";
        public static final String CHUNK_CONTEXT_FIELD = "contextField";
        public static final String CHUNK_METHOD = "method";
        public static final String CHUNK_OVERLAP = "overlap";
        public static final String CHUNK_POLICY = "chunkPolicy";
        public static final String KEY = "config";
        public static final String TARGET_FIELDS = "targetFields";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Key {
        public static final String IN_APP_SEARCH_INTENT = "inAppSearchIntent";
        public static final String PROJECTION_FIELDS_FOR_SEARCH_ENGINE = "fields";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Method {
        public static final String EMBEDDING_CONFIG_FOR_SEMANTIC_SEARCH = "get_embedding_config";
        public static final String GET_DEFAULT_QUERY_ARGS = "get_default_query_args";
        public static final String GET_SELECTION_FIELDS = "get_selection_fields";
        public static final String IN_APP_SEARCH_INTENT = "getInAppSearchIntent";
        public static final String NOTIFY_DATA_UPDATED = "notify_data_updated";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface SearchFilter {
        public static final String COVER_STICKER = "cover_sticker_id=";
        public static final String HAS_IMAGE = "hasImage";
        public static final String HAS_PDF = "hasPdf";
        public static final String HAS_STROKE = "hasStroke";
        public static final String HAS_TITLE = "hasTitle";
        public static final String HAS_VOICE = "hasVoice";
    }

    static {
        Uri uri = Uri.parse("content://com.samsung.android.app.notes");
        AUTHORITY_URI = uri;
        URI_FINDER_THUMBNAIL = Uri.withAppendedPath(uri, URI_PATH_FINDER_THUMBNAIL);
        URI_FINDER_UUID = Uri.withAppendedPath(uri, URI_PATH_FINDER_UUID);
        BASE_URI_NOTE_TAG = Uri.withAppendedPath(uri, URI_PATH_TAG);
        BASE_URI_TAG_THUMBNAIL = Uri.withAppendedPath(uri, URI_PATH_TAG_THUMBNAIL);
        BASE_URI_NOTE = Uri.withAppendedPath(uri, "sdoc");
        URI_MULTIPLE_DOCUMENTS_UPDATED = Uri.withAppendedPath(uri, URI_PATH_MULTIPLE_DOCUMENTS_UPDATED);
    }

    public static List<String> getProjection() {
        ArrayList arrayList = new ArrayList(getTargetFieldsForSearch());
        arrayList.addAll(Arrays.asList("_id", "UUID", Column.SIMPLE_BODY_TEXT, "createdAt", "lastModifiedAt", Column.THUMBNAIL_URI, Column.CONTENT_URI, "filter", "timestamp"));
        return arrayList;
    }

    public static List<String> getTargetFieldsForSearch() {
        return Arrays.asList("title", Column.BODY_TEXT, Column.HANDWRITING_TEXT, Column.PDF_TEXT, Column.TAG_TEXT, Column.TABLE_TEXT, Column.TEXT_BOX, Column.VOICE_RECORDING_TITLE, Column.VOICE_RECORDING_STT, Column.AUDIO_TITLE, Column.CODE_BLOCK_TEXT, Column.COVER_SUMMARY, Column.EXTRA_DATA);
    }
}
