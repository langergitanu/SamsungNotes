package com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common;

import com.samsung.android.mcf.continuity.interfaces.ContinuityBundleFactory;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003!\"#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant;", "", "<init>", "()V", "HANDOFF_ENABLED", "", "HANDOFF_VERSION", "", "URI_HANDOFF", "URI_HANDOFF_APP_EVENT_CHANGED", "URI_HANDOFF_DATA_SENDING_SUCCESS", "URI_HANDOFF_DATA_RECEIVING_SUCCESS", "ENABLE_HANDOFF", "DISABLE_HANDOFF", "REQUEST_SYNC_HANDOFF_DATA", "GET_HANDOFF_INFO", "GET_HANDOFF_DATA", "KEY_IS_HANDOFF_LAUNCH", ContinuityBundleFactory.KEY_DEVICE_TYPE, "KEY_SENDER_NAME", "KEY_LAST_MODIFIED_TYPE", "KEY_HANDOFF_DATA", "KEY_HANDLE_HANDOFF_BASED_ON_CURRENT_ACTIVITY", "KEY_EXPIRY_TIME", "KEY_APP_ID", "KEY_HANDOFF_VERSION", "KEY_SYNC_ENABLED", "KEY_ACTIVITY_TYPE", "HANDOFF_DEFAULT_TIME_OUT", "", "DELAY_PENDING_RECEIVE", "", "DELAY_SHOW_PROGRESS", "ActivityType", "DeviceType", "Caller", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandoffConstant {
    public static final long DELAY_PENDING_RECEIVE = 30000;
    public static final long DELAY_SHOW_PROGRESS = 2000;

    @NotNull
    public static final String DISABLE_HANDOFF = "disableHandoff";

    @NotNull
    public static final String ENABLE_HANDOFF = "enableHandoff";

    @NotNull
    public static final String GET_HANDOFF_DATA = "getHandoffData";

    @NotNull
    public static final String GET_HANDOFF_INFO = "getHandoffInfo";
    public static final int HANDOFF_DEFAULT_TIME_OUT = 600000;
    public static final boolean HANDOFF_ENABLED = true;

    @NotNull
    public static final String HANDOFF_VERSION = "1.0.0";

    @NotNull
    public static final HandoffConstant INSTANCE = new HandoffConstant();

    @NotNull
    public static final String KEY_ACTIVITY_TYPE = "activity_type";

    @NotNull
    public static final String KEY_APP_ID = "app_id";

    @NotNull
    public static final String KEY_DEVICE_TYPE = "deviceType";

    @NotNull
    public static final String KEY_EXPIRY_TIME = "expiryTime";

    @NotNull
    public static final String KEY_HANDLE_HANDOFF_BASED_ON_CURRENT_ACTIVITY = "handleHandoffBasedOnCurrentActivity";

    @NotNull
    public static final String KEY_HANDOFF_DATA = "handoffData";

    @NotNull
    public static final String KEY_HANDOFF_VERSION = "version";

    @NotNull
    public static final String KEY_IS_HANDOFF_LAUNCH = "handoff";

    @NotNull
    public static final String KEY_LAST_MODIFIED_TYPE = "lastModificationTime";

    @NotNull
    public static final String KEY_SENDER_NAME = "senderName";

    @NotNull
    public static final String KEY_SYNC_ENABLED = "sync_on";

    @NotNull
    public static final String REQUEST_SYNC_HANDOFF_DATA = "requestSyncHandoffData";

    @NotNull
    public static final String URI_HANDOFF = "content://com.samsung.android.mcfds.HandoffProvider";

    @NotNull
    public static final String URI_HANDOFF_APP_EVENT_CHANGED = "content://com.samsung.android.mcfds.HandoffProvider/AppEventChanged/com.samsung.android.app.notes";

    @NotNull
    public static final String URI_HANDOFF_DATA_RECEIVING_SUCCESS = "content://com.samsung.android.mcfds.HandoffProvider/DataReceivingSuccess/com.samsung.android.app.notes";

    @NotNull
    public static final String URI_HANDOFF_DATA_SENDING_SUCCESS = "content://com.samsung.android.mcfds.HandoffProvider/DataSendingSuccess/com.samsung.android.app.notes";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$ActivityType;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActivityType {

        @NotNull
        public static final String COMPOSER = "Composer";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String FOLDER_LIST = "FolderList";

        @NotNull
        public static final String GCS_LIST = "GCSList";

        @NotNull
        public static final String GCS_NOTE = "GCSNote";

        @NotNull
        public static final String HANDOFF = "Handoff";

        @NotNull
        public static final String HASH_TAG_LIST = "TagList";

        @NotNull
        public static final String HASH_TAG_NOTE = "TagNote";

        @NotNull
        public static final String MAIN_LIST = "Main";

        @NotNull
        public static final String OLD_LIST = "OldList";

        @NotNull
        public static final String OLD_NOTE = "OldNote";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$ActivityType$Companion;", "", "<init>", "()V", "HANDOFF", "", "MAIN_LIST", "FOLDER_LIST", "COMPOSER", "HASH_TAG_LIST", "HASH_TAG_NOTE", "OLD_LIST", "OLD_NOTE", "GCS_LIST", "GCS_NOTE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String COMPOSER = "Composer";

            @NotNull
            public static final String FOLDER_LIST = "FolderList";

            @NotNull
            public static final String GCS_LIST = "GCSList";

            @NotNull
            public static final String GCS_NOTE = "GCSNote";

            @NotNull
            public static final String HANDOFF = "Handoff";

            @NotNull
            public static final String HASH_TAG_LIST = "TagList";

            @NotNull
            public static final String HASH_TAG_NOTE = "TagNote";

            @NotNull
            public static final String MAIN_LIST = "Main";

            @NotNull
            public static final String OLD_LIST = "OldList";

            @NotNull
            public static final String OLD_NOTE = "OldNote";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$Caller;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Caller {
        public static final int COMPOSER = 1;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int MAIN = 0;
        public static final int NONE = -1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$Caller$Companion;", "", "<init>", "()V", CoverStickerConstants.Category.NONE.NAME, "", "MAIN", "COMPOSER", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int COMPOSER = 1;
            public static final int MAIN = 0;
            public static final int NONE = -1;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$DeviceType;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DeviceType {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int MOBILE = 0;
        public static final int TABLET = 1;
        public static final int UNKNOWN = -1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/mcf/handoff/common/HandoffConstant$DeviceType$Companion;", "", "<init>", "()V", "UNKNOWN", "", "MOBILE", "TABLET", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int MOBILE = 0;
            public static final int TABLET = 1;
            public static final int UNKNOWN = -1;

            private Companion() {
            }
        }
    }

    private HandoffConstant() {
    }
}
