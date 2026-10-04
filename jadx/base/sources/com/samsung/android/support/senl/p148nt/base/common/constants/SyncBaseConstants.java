package com.samsung.android.support.senl.p148nt.base.common.constants;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/SyncBaseConstants;", "", "<init>", "()V", "SYNC_SUPPORT_NOT_SYNCED_IN_TRASH", "", "SYNC_SUPPORT_RESERVED_FOLDER_CONVERTER", "SyncState", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SyncBaseConstants {

    @NotNull
    public static final SyncBaseConstants INSTANCE = new SyncBaseConstants();
    public static final boolean SYNC_SUPPORT_NOT_SYNCED_IN_TRASH = true;
    public static final boolean SYNC_SUPPORT_RESERVED_FOLDER_CONVERTER = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/SyncBaseConstants$SyncState;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SyncState {
        public static final long CORRUPTED = 256;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final long INVALID_DATA_SIZE = 1024;
        public static final long INVALID_FILE_HASH = 4096;
        public static final long INVALID_PAYLOAD = 16384;
        public static final long LOW_VERSION = 32768;
        public static final long MAX_OBJECT_LIMIT = 512;
        public static final long MAX_OBJECT_LIMIT_1 = 65536;
        public static final long NONE = 0;
        public static final long OVER_1GB = 8192;
        public static final long RESOURCE_LACKING_FROM_SERVER = 2048;
        public static final long SYNCHRONIZING = 2;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/SyncBaseConstants$SyncState$Companion;", "", "<init>", "()V", CoverStickerConstants.Category.NONE.NAME, "", "SYNCHRONIZING", "CORRUPTED", "MAX_OBJECT_LIMIT", "INVALID_DATA_SIZE", "RESOURCE_LACKING_FROM_SERVER", "INVALID_FILE_HASH", "OVER_1GB", "INVALID_PAYLOAD", "LOW_VERSION", "MAX_OBJECT_LIMIT_1", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final long CORRUPTED = 256;
            public static final long INVALID_DATA_SIZE = 1024;
            public static final long INVALID_FILE_HASH = 4096;
            public static final long INVALID_PAYLOAD = 16384;
            public static final long LOW_VERSION = 32768;
            public static final long MAX_OBJECT_LIMIT = 512;
            public static final long MAX_OBJECT_LIMIT_1 = 65536;
            public static final long NONE = 0;
            public static final long OVER_1GB = 8192;
            public static final long RESOURCE_LACKING_FROM_SERVER = 2048;
            public static final long SYNCHRONIZING = 2;

            private Companion() {
            }
        }
    }

    private SyncBaseConstants() {
    }
}
