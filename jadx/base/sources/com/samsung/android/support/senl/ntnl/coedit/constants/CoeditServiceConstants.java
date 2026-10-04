package com.samsung.android.support.senl.ntnl.coedit.constants;

import android.text.TextUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CoeditServiceConstants {
    public static final long CHECKPOINT_DEFAULT = -1;
    public static final long CHECKPOINT_INVALID = -2;
    public static final long CHECKPOINT_START = 0;
    public static final boolean ENTRY_IMPROVE_FEATURE = false;
    public static final boolean FEATURE_TEST_DEBUG_INFO = false;
    public static final int NOT_DEFINED_XML_DOCUMENT_SIZE = -1;
    public static final int RICH_TEXT_START_INDEX = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AbnormalReleaseState {
        public static final int ABNORMAL_RELEASE_STATE_MULTIPLE_SUBMIT = 1;
        public static final int ABNORMAL_RELEASE_STATE_NONE = 0;
        public static final int ABNORMAL_RELEASE_STATE_SUBMIT_FAIL_RESPONSE = 4;
        public static final int ABNORMAL_RELEASE_STATE_SUBMIT_FAIL_TRANSFORM = 3;
        public static final int ABNORMAL_RELEASE_STATE_UPDATE_FAIL_TRANSFORM = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    public @interface Action {
        public static final String ACTION_CONNECT_BY_RESUME = "CONNECT_BY_RESUME";
        public static final String ACTION_LEAVE_BY_BACK_KEY = "LEAVE_BY_BACK_KEY";
        public static final String ACTION_LEAVE_BY_HOME_KEY = "LEAVE_BY_HOME_KEY";
        public static final String ACTION_LEAVE_BY_SCREEN_OFF = "LEAVE_BY_SCREEN_OFF";
        public static final String ACTION_LEAVE_BY_TASK_CHANGE = "LEAVE_BY_TASK_CHANGE";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Annotation {
        public static final String TYPE_OBJECT_SPAN = "objectSpan/";
        public static final String TYPE_PARAGRAPH = "paragraph/";
        public static final String TYPE_SPAN = "span/";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Attribute {
        public static final String KEY_HASH = "hash";
        public static final String KEY_ID = "id";
        public static final String KEY_MODIFIED_TIME = "modifiedTime";
        public static final String KEY_REF_COUNT = "refCount";
        public static final String KEY_SESSION_HISTORY = "sessionHistory";
        public static final String KEY_STROKE_BINARY = "strokeBinary";
        public static final String KEY_TYPE = "type";
        public static final String VALUE_DUMMY = "Dummy";
        public static final String VALUE_DUMMY_STROKE_BINARY = "DummyStrokeBinaryData";
        public static final String VALUE_TYPE_IMAGE = "image";
        public static final String VALUE_TYPE_STROKE = "stroke";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CONCURRNCY_KEY {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class AUTO_RELEASE {
            public static final String COMPOSER_REQUEST = "AUTO_RELEASE_COMPOSER_REQUEST";
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class INFINITY {
            public static final String COEDIT_RELEASE = "COEDIT_RELEASE";
            public static final String COMPOSER_REQUEST = "INFINITY_COMPOSER_REQUEST";
            public static final String ERROR_OCCURED = "ERROR_OCCURED";
            public static final String NETWORK_ISSUE = "NETWORK_ISSUE";
            public static final String NO_PERMISSION = "NO_PERMISSION";
            public static final String SNAP_UPLOADING = "SNAP_UPLOADING";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CONCURRNCY_RESULT {
        public static final int ALREADY_SET_PAUSE = 5;
        public static final int ALREADY_SET_RESUME = 6;
        public static final int EXCEED_MEMORY = 7;
        public static final int FAIL_PAUSE = 4;
        public static final int FAIL_RESUME = 3;
        public static final int NOT_DEFINE = 0;
        public static final int SUCCESS_PAUSE = 2;
        public static final int SUCCESS_RESUME = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheFilePath {
        public static final String CURRENT_CACHE = "c";
        public static final String SUBMIT_CACHE = "s";
        public static final String TEMP_CACHE = "t";
        public static final String UPDATE_CACHE = "u";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface ClientError {
        public static final String ADD_ANNOTATION = "CLIENT_ERROR_ADD_ANNOTATION";
        public static final String ADD_OBJECT_SPAN = "CLIENT_ERROR_ADD_OBJECT_SPAN";
        public static final String FORCE_REFRESH = "CLIENT_ERROR_FORCE_REFRESH";
        public static final String INSERT_CONTENT_FILE = "CLIENT_ERROR_INSERT_CONTENT_FILE";
        public static final String INSERT_OBJECT = "CLIENT_ERROR_INSERT_OBJECT";
        public static final String REMOVE_CONTENT_FILE = "CLIENT_ERROR_REMOVE_CONTENT_FILE";
        public static final String REMOVE_OBJECT = "CLIENT_ERROR_REMOVE_OBJECT";
        public static final String REQUEST_PARTIAL_UPDATE = "CLIENT_ERROR_REQUEST_PARTIAL_UPDATE";
        public static final String UPDATE_OBJECT_GET_XML = "CLIENT_ERROR_UPDATE_OBJECT_GET_XML";
        public static final String UPDATE_OBJECT_SET_XML = "CLIENT_ERROR_UPDATE_OBJECT_SET_XML";
        public static final String UPDATE_TEXT_VIEW = "CLIENT_ERROR_UPDATE_TEXT_VIEW";
        public static final String UPDATE_VIEW_FAIL = "CLIENT_ERROR_UPDATE_VIEW_FAIL";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface ConcurrencyError {
        public static final String CATCHUP_FAILED = "CONCURRENCY_ERROR_CATCHUP_FAILED";
        public static final String MULTIPLE_TRANSFORM_FAILED = "CONCURRENCY_ERROR_MULTIPLE_TRANSFORM_FAILED";
        public static final String SERVER = "CONCURRENCY_ERROR_SERVER";
        public static final String SUBMIT_FAILED = "CONCURRENCY_ERROR_SUBMIT_FAILED";
        public static final String TRANSFORM_FAILED = "CONCURRENCY_ERROR_TRANSFORM_FAILED";
        public static final String TRANSFORM_WITH_MULTIPLE_FAILED = "CONCURRENCY_ERROR_TRANSFORM_WITH_MULTIPLE_FAILED";
        public static final String UPLOAD_FAILED = "CONCURRENCY_ERROR_SUBMIT_UPLOAD_FAILED";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContentFile {
        public static final int ELEMENT_SIZE = 2;
        public static final int HASH_DATA_SIZE = 0;
        public static final int OBJECT_XML_SIZE = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Document {
        public static final String KEY_APP_VERSION = "app_ver";
        public static final String KEY_SDK_VERSION = "sdk_ver";
        public static final String KEY_XML_VERSION = "xml_ver";
        public static final String TYPE_CURRENT = "Current Document";
        public static final String TYPE_OPERATION = "Operation";
        public static final String TYPE_WNOTE = "WNote Document";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Element {
        public static final String NAME_CONTENT_FILE = "contentFile";
        public static final String NAME_OBJECT = "object";
        public static final String NAME_PAGE = "page";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Extension {
        public static final String OBJECT_SPI = "spi";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Extra {
        public static final String ARG_DOCUMENT_UUID = "document_uuid";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GrpcInterval {
        public static final long COEDIT_NOTE_RELEASE_DELAY_MILLIS = 1000;
        public static final int FILE_SERVER_RETRY_INTERVAL_TIME_COUNT = 5;
        public static final int FILE_SERVER_RETRY_INTERVAL_TIME_MILLIS = 5000;
        public static final int GRPC_CATCHUP_RETRY_COUNT = 2;
        public static final int GRPC_CHANNEL_SHUTDOWN_DELAY_TIME_MILLIS = 200;
        public static final int GRPC_GET_NOTE_LAST_INFO_REQUEST_TIMEOUT_TIME_MILLIS = 10000;
        public static final int GRPC_PERMISSION_REQUEST_TIMEOUT_TIME_MILLIS = 3000;
        public static final int GRPC_RESET_WORKSPACE_INTERVAL_TIME_MILLIS = 1000;
        public static final int GRPC_RESET_WORKSPACE_RETRY_COUNT = 3;
        public static final int GRPC_RESET_WORKSPACE_TIMEOUT_TIME_MILLIS = 10000;
        public static final int GRPC_TRANSFORM_RETRY_COUNT = 3;
        public static final int GRPC_TRANSFORM_RETRY_INTERVAL_TIME_MILLIS = 1000;
        public static final int GRPC_TRANSFORM_TIMEOUT_TIME_MILLIS = 60000;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LastUpdateState {
        public static final int APPLY_FILE_ABNORMAL_RELEASED = 5;
        public static final int APPLY_FILE_END = 4;
        public static final int APPLY_FILE_START = 3;
        public static final int LOST_RETRY_DATA = 6;
        public static final int XML_UPDATE_ABNORMAL_RELEASED = 2;
        public static final int XML_UPDATE_END = 1;
        public static final int XML_UPDATE_START = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MetaData {
        public static final String METADATA_KEY_CONTENT_ID = "cid";
        public static final String METADATA_KEY_REQUEST_ID = "requestId";
        public static final String METADATA_VAL_CONTENT_ID = "LeAmLaorme";
        public static final String MODEL = "model";
        public static final String USER_AGENT = "useragent";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MimeType {
        public static final String AUDIO_MP4 = "audio/mp4";
        public static final String IMAGE_JPEG = "image/jpeg";
        public static final String IMAGE_JPG = "image/jpg";
        public static final String IMAGE_PNG = "image/png";
        public static final String MULTI = "*/*";
        public static final String NOTE_TYPE_FILE = "application/file";
        public static final String NOTE_TYPE_STREAM = "application/octet-stream";
        public static final String NOTE_TYPE_STROKE = "application/stroke";
        public static final String NOTE_TYPE_XML = "application/xml";
        public static final String OBJECT_SPI = "object/spi";
        public static final String OBJECT_STROKE = "object/stroke";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface ServerError {
        public static final String AUTH_TOKEN_EXPIRED = "LOCAL_ERROR_AUTH_TOKEN_EXPIRED";
        public static final String MAINTENANCE = "SERVER_ERROR_MAINTENANCE";
        public static final String UNEXPECTED = "SERVER_ERRORUNEXPECTED";
        public static final String UNKNOWN = "SERVER_ERROR_UNKNOWN";
        public static final String UPDATE_APP_VERSION = "SERVER_ERROR_UPDATE_APP_VERSION";
        public static final String UPDATE_XML_VERSION = "SERVER_ERROR_UPDATE_XML_VERSION";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ServerResponse {
        public static final String BLOCKED = "workspace has been blocked";
        public static final String DEDUPLICATED = "deduplicated";
        public static final String DEVICE_INFO_CONNECTION_TYPE = "device_info_connection_type";
        public static final String DEVICE_INFO_DEVICE_ID = "dvc_id";
        public static final String DEVICE_INFO_LIST = "device_info_list";
        public static final String DEVICE_INFO_PERMISSION_TYPE = "device_info_permission_type";
        public static final String DEVICE_INFO_USER_ID = "uid";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ServerResponseCode {
        private static final String ABORTED_NOTESNAP_MSG = "Aborted notesnap";
        public static final String FAILED_PRECONDITION_WORKSPACE_NOT_BLOCKED_MSG = "9026";
        public static final String FAILED_PRECONDITION_WORKSPACE_RESET_NO_CHANGE_MSG = "9027";
        public static final String SERVER_RESPONSE_CODE_ABORTED = "ABORTED";
        public static final String SERVER_RESPONSE_CODE_ABORTED_METRIC = "ABORTED_METRIC";
        public static final String SERVER_RESPONSE_CODE_ALREADY_EXISTS = "ALREADY_EXISTS";
        public static final String SERVER_RESPONSE_CODE_CANCELLED = "CANCELLED";
        public static final String SERVER_RESPONSE_CODE_DATA_LOSS = "DATA_LOSS";
        public static final String SERVER_RESPONSE_CODE_DEADLINE_EXCEEDED = "DEADLINE_EXCEEDED";
        public static final String SERVER_RESPONSE_CODE_FAILED_PRECONDITION = "FAILED_PRECONDITION";
        public static final String SERVER_RESPONSE_CODE_INTERNAL = "INTERNAL";
        public static final String SERVER_RESPONSE_CODE_INVALID_ARGUMENT = "INVALID_ARGUMENT";
        public static final String SERVER_RESPONSE_CODE_NOT_FOUND = "NOT_FOUND";
        public static final String SERVER_RESPONSE_CODE_OK = "OK";
        public static final String SERVER_RESPONSE_CODE_OUT_OF_RANGE = "OUT_OF_RANGE";
        public static final String SERVER_RESPONSE_CODE_PERMISSION_DENIED = "PERMISSION_DENIED";
        public static final String SERVER_RESPONSE_CODE_RESOURCE_EXHAUSTED = "RESOURCE_EXHAUSTED";
        public static final String SERVER_RESPONSE_CODE_UNAUTHENTICATED = "UNAUTHENTICATED";
        public static final String SERVER_RESPONSE_CODE_UNAVAILABLE = "UNAVAILABLE";
        public static final String SERVER_RESPONSE_CODE_UNIMPLEMENTED = "UNIMPLEMENTED";
        public static final String SERVER_RESPONSE_CODE_UNKNOWN = "UNKNOWN";
        public static final String SERVER_RESPONSE_NOT_FOUND_DEVICE = "5002";
        private static final String WORKSPACE_NOT_BLOCKED_MSG = "workspace is not blocked";
        private static final String WORKSPACE_RESET_NO_CHANGE_MSG = "change no need reset";

        public static boolean isConnectNeeded(String str) {
            return !TextUtils.isEmpty(str) && str.contains(SERVER_RESPONSE_CODE_NOT_FOUND) && str.contains("5002");
        }

        public static boolean isDeadlineExceeded(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains(SERVER_RESPONSE_CODE_DEADLINE_EXCEEDED);
        }

        public static boolean isResetNotNeeded(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains(FAILED_PRECONDITION_WORKSPACE_NOT_BLOCKED_MSG) || str.contains(FAILED_PRECONDITION_WORKSPACE_RESET_NO_CHANGE_MSG) || str.contains(WORKSPACE_NOT_BLOCKED_MSG) || str.contains(WORKSPACE_RESET_NO_CHANGE_MSG);
        }

        public static boolean isRetryNeeded(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (isUnavailable(str)) {
                return true;
            }
            return (!str.contains(SERVER_RESPONSE_CODE_ABORTED) || str.contains(SERVER_RESPONSE_CODE_ABORTED_METRIC) || str.contains(ABORTED_NOTESNAP_MSG)) ? false : true;
        }

        public static boolean isUnavailable(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("UNAVAILABLE");
        }

        public static boolean isUploadNeeded(String str) {
            return !TextUtils.isEmpty(str) && str.contains(SERVER_RESPONSE_CODE_ABORTED) && str.contains(ABORTED_NOTESNAP_MSG);
        }

        public static boolean isWorkspaceBlocked(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains(ServerResponse.BLOCKED);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface SnapError {
        public static final String ALREADY_CO_EDITING = "SNAP_ERROR_ALREADY_CO_EDITING";
        public static final String DOWNLOAD_FAIL = "SNAP_ERROR_DOWNLOAD_FAIL";
        public static final String EMPTY_XML_FAIL = "SNAP_ERROR_EMPTY_XML_FAIL";
        public static final String EXTERNAL_SNAP_PROCESSING = "SNAP_ERROR_PROCESSING_EXTERNAL_SNAP";
        public static final String INTERNAL_SNAP_PROCESSING = "SNAP_ERROR_PROCESSING_INTERNAL_SNAP";
        public static final String INVALID_DOCUMENT_FAIL = "SNAP_ERROR_INVALID_DOCUMENT_FAIL";
        public static final String NO_NETWORK = "SNAP_ERROR_NO_NETWORK";
        public static final String SET_XML_FAIL = "SNAP_ERROR_SET_XML_FAIL";
        public static final String UPLOAD_FAIL = "SNAP_ERROR_UPLOAD_FAIL";
        public static final String UPLOAD_FAIL_LARGE_XML_SIZE = "SNAP_ERROR_UPLOAD_FAIL_LARGE_XML_SIZE";
        public static final String VIEW_REATTACH = "SNAP_ERROR_VIEW_REATTACH";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface WorkspaceError {
        public static final String BLOCK = "WORKSPACE_ERROR_BLOCK";
        public static final String CONNECT_BLOCKED = "CONNECT_BLOCKED";
        public static final String RESET = "WORKSPACE_ERROR_RESET";
        public static final String RESET_WORKSPACE_DURATION = "RESET_WORKSPACE_DURATION";
    }

    public static boolean isClientError(String str) {
        return ClientError.FORCE_REFRESH.equals(str) || ClientError.UPDATE_OBJECT_GET_XML.equals(str) || ClientError.UPDATE_OBJECT_SET_XML.equals(str) || isClientUpdateError(str);
    }

    public static boolean isClientUpdateError(String str) {
        return ClientError.UPDATE_VIEW_FAIL.equals(str) || ClientError.ADD_ANNOTATION.equals(str) || ClientError.ADD_OBJECT_SPAN.equals(str) || ClientError.UPDATE_TEXT_VIEW.equals(str) || ClientError.INSERT_CONTENT_FILE.equals(str) || ClientError.REMOVE_CONTENT_FILE.equals(str) || ClientError.INSERT_OBJECT.equals(str) || ClientError.REMOVE_OBJECT.equals(str) || ClientError.REQUEST_PARTIAL_UPDATE.equals(str);
    }

    public static boolean isConcurrencyError(String str) {
        return ConcurrencyError.SERVER.equals(str) || ConcurrencyError.SUBMIT_FAILED.equals(str) || ConcurrencyError.TRANSFORM_FAILED.equals(str) || ConcurrencyError.MULTIPLE_TRANSFORM_FAILED.equals(str) || ConcurrencyError.TRANSFORM_WITH_MULTIPLE_FAILED.equals(str) || ConcurrencyError.CATCHUP_FAILED.equals(str);
    }

    public static boolean isServerError(String str) {
        return ServerError.UPDATE_XML_VERSION.equals(str) || ServerError.UPDATE_APP_VERSION.equals(str) || ServerError.MAINTENANCE.equals(str);
    }
}
