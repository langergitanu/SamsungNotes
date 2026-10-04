package com.samsung.android.support.senl.p145cm.base.common.constants;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/SaveStrategy;", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public @interface SaveStrategy {
    public static final int BROADCAST_FORCE_UPDATE = 8192;
    public static final int BROADCAST_RELOAD_AFTER_SAVE = 2;
    public static final int CLOSE_AFTER_SAVE = 4;
    public static final int CREATE_AUTO_TITLE = 8;
    public static final int CREATE_THUMBNAIL_CACHE = 2048;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT_MODEL_STRATEGY = 67760;
    public static final int DEFAULT_SDOCX_DATA_STRATEGY = 67592;
    public static final int DEFAULT_SDOC_DATA_STRATEGY = 2056;
    public static final int DO_NOT_COLLECT_SEARCH_DATA = 262144;
    public static final int DO_NOT_DELETE_SERVICE_CACHE = 64;
    public static final int DO_NOT_UPDATE_DATABASE = 1024;
    public static final int DO_NOT_UPDATE_MAPPING_TABLE = 4096;
    public static final int DO_NOT_UPDATE_MODIFIED_TIME = 16384;
    public static final int DO_NOT_UPDATE_WIDGET = 32768;
    public static final int FORCE_SAVE = 128;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int NONE = 1;
    public static final int REMOVE_HANDWRITING_SEARCH_DATA = 131072;
    public static final int SEND_ANALYTICS = 65536;
    public static final int SHOW_DELETE_EMPTY_DOCUMENT_MESSAGE = 32;
    public static final int SHOW_SAVE_SUCCESS_MESSAGE = 16;
    public static final int UPDATE_DATABASE_AFTER_FILE_SAVE = 524288;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/SaveStrategy$Companion;", "", "<init>", "()V", CoverStickerConstants.Category.NONE.NAME, "", "BROADCAST_RELOAD_AFTER_SAVE", "CLOSE_AFTER_SAVE", "CREATE_AUTO_TITLE", "SHOW_SAVE_SUCCESS_MESSAGE", "SHOW_DELETE_EMPTY_DOCUMENT_MESSAGE", "DO_NOT_DELETE_SERVICE_CACHE", "FORCE_SAVE", "DO_NOT_UPDATE_DATABASE", "CREATE_THUMBNAIL_CACHE", "DO_NOT_UPDATE_MAPPING_TABLE", "BROADCAST_FORCE_UPDATE", "DO_NOT_UPDATE_MODIFIED_TIME", "DO_NOT_UPDATE_WIDGET", "SEND_ANALYTICS", "REMOVE_HANDWRITING_SEARCH_DATA", "DO_NOT_COLLECT_SEARCH_DATA", "UPDATE_DATABASE_AFTER_FILE_SAVE", "MAX_VALUE", "DEFAULT_MODEL_STRATEGY", "DEFAULT_SDOCX_DATA_STRATEGY", "DEFAULT_SDOC_DATA_STRATEGY", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BROADCAST_FORCE_UPDATE = 8192;
        public static final int BROADCAST_RELOAD_AFTER_SAVE = 2;
        public static final int CLOSE_AFTER_SAVE = 4;
        public static final int CREATE_AUTO_TITLE = 8;
        public static final int CREATE_THUMBNAIL_CACHE = 2048;
        public static final int DEFAULT_MODEL_STRATEGY = 67760;
        public static final int DEFAULT_SDOCX_DATA_STRATEGY = 67592;
        public static final int DEFAULT_SDOC_DATA_STRATEGY = 2056;
        public static final int DO_NOT_COLLECT_SEARCH_DATA = 262144;
        public static final int DO_NOT_DELETE_SERVICE_CACHE = 64;
        public static final int DO_NOT_UPDATE_DATABASE = 1024;
        public static final int DO_NOT_UPDATE_MAPPING_TABLE = 4096;
        public static final int DO_NOT_UPDATE_MODIFIED_TIME = 16384;
        public static final int DO_NOT_UPDATE_WIDGET = 32768;
        public static final int FORCE_SAVE = 128;
        public static final int MAX_VALUE = Integer.MAX_VALUE;
        public static final int NONE = 1;
        public static final int REMOVE_HANDWRITING_SEARCH_DATA = 131072;
        public static final int SEND_ANALYTICS = 65536;
        public static final int SHOW_DELETE_EMPTY_DOCUMENT_MESSAGE = 32;
        public static final int SHOW_SAVE_SUCCESS_MESSAGE = 16;
        public static final int UPDATE_DATABASE_AFTER_FILE_SAVE = 524288;

        private Companion() {
        }
    }
}
