package com.samsung.android.support.senl.p148nt.model.service;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentServiceConstants {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Action {
        public static final String ACTION_REMOVE_CACHE_AND_RESAVE = "ACTION_REMOVE_CACHE_AND_RESAVE";
        public static final String ACTION_RESTORE_CACHE = "ACTION_RESTORE_CACHE";
        public static final String ACTION_SAVE_BY_TITLE_BODY = "ACTION_SAVE_BY_TITLE_BODY";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Cache {
        public static final String CACHE_DIR = "sdocservice";
        public static final String CACHE_DIR_CONVERTED = "converted";
        public static final String CACHE_DIR_PDF_WRITIER = "pdfwriter";
        public static final String DATA_FILE_EXTENSION = ".dat";
        public static final int MAX_CACHE_SIZE = 50;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocumentServiceAlreadyClosedException extends RuntimeException {
        public DocumentServiceAlreadyClosedException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Extra {
        public static final String ARG_BODY = "body";
        public static final String ARG_FOLDER_PATH = "folder_path";
        public static final String ARG_FOLDER_UUID = "folder_uuid";
        public static final String ARG_MIME_TYPES = "mime_types";
        public static final String ARG_RESTORE_UUID = "restore_uuid";
        public static final String ARG_SDOC_PATH = "doc_path";
        public static final String ARG_SDOC_UUID = "sdoc_uuid";
        public static final String ARG_SUBSCRIPTION_ID = "subscription_id";
        public static final String ARG_TITLE = "title";
        public static final String ARG_URIS = "uris";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LockGuid {
        public static final String FROM_SHARED_NOTES_GUID = "FROM_SHARED_NOTES_GUID";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Task {
        public static final String CACHE_RESAVE_TASK_IN_PROGRESS = "CACHE_RESAVE_TASK_IN_PROGRESS";
    }
}
