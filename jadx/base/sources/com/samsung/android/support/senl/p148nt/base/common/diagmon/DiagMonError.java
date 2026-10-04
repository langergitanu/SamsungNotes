package com.samsung.android.support.senl.p148nt.base.common.diagmon;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\n\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError;", "", "<init>", "()V", "getErrorMsg", "", "mainErrCode", "subErrCode", "", "getSubSyncErrorMsg", "getSubServerErrorMsg", "getSubAppErrorMsg", "getSubSPenErrorMsg", "MAIN", "MAIN_PREFERENCE_NAME", "SYNC_SUB", "SYNC_SUB_MSG", "SERVER_SUB", "SERVER_SUB_MSG", "APP_SUB", "APP_SUB_MSG", "SPEN_SUB", "SPEN_SUB_MSG", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DiagMonError {

    @NotNull
    public static final DiagMonError INSTANCE = new DiagMonError();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$APP_SUB;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface APP_SUB {
        public static final int APP_UPDATE_REQUIRED = 100;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$APP_SUB$Companion;", "", "<init>", "()V", "APP_UPDATE_REQUIRED", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int APP_UPDATE_REQUIRED = 100;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$APP_SUB_MSG;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface APP_SUB_MSG {

        @NotNull
        public static final String APP_UPDATE_REQUIRED = "App Update Required";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$APP_SUB_MSG$Companion;", "", "<init>", "()V", "APP_UPDATE_REQUIRED", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String APP_UPDATE_REQUIRED = "App Update Required";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$MAIN;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface MAIN {

        @NotNull
        public static final String APP = "APP_ERROR";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String SERVER = "SERVER_ERROR";

        @NotNull
        public static final String SPEN = "SPEN_ERROR";

        @NotNull
        public static final String SYNC = "SYNC_ERROR";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$MAIN$Companion;", "", "<init>", "()V", "SYNC", "", "SERVER", "APP", "SPEN", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String APP = "APP_ERROR";

            @NotNull
            public static final String SERVER = "SERVER_ERROR";

            @NotNull
            public static final String SPEN = "SPEN_ERROR";

            @NotNull
            public static final String SYNC = "SYNC_ERROR";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$MAIN_PREFERENCE_NAME;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface MAIN_PREFERENCE_NAME {

        @NotNull
        public static final String APP = "APP_ERROR";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String SERVER = "SERVER_ERROR";

        @NotNull
        public static final String SPEN = "SPEN_ERROR";

        @NotNull
        public static final String SYNC = "SYNC_ERROR";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$MAIN_PREFERENCE_NAME$Companion;", "", "<init>", "()V", "SYNC", "", "SERVER", "APP", "SPEN", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String APP = "APP_ERROR";

            @NotNull
            public static final String SERVER = "SERVER_ERROR";

            @NotNull
            public static final String SPEN = "SPEN_ERROR";

            @NotNull
            public static final String SYNC = "SYNC_ERROR";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SERVER_SUB;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SERVER_SUB {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int HTTP_BAD_REQUEST = 101;
        public static final int INTERNAL_SERVER_ERROR = 100;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SERVER_SUB$Companion;", "", "<init>", "()V", "INTERNAL_SERVER_ERROR", "", "HTTP_BAD_REQUEST", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int HTTP_BAD_REQUEST = 101;
            public static final int INTERNAL_SERVER_ERROR = 100;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SERVER_SUB_MSG;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SERVER_SUB_MSG {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String HTTP_BAD_REQUEST = "Bad request to server";

        @NotNull
        public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SERVER_SUB_MSG$Companion;", "", "<init>", "()V", "INTERNAL_SERVER_ERROR", "", "HTTP_BAD_REQUEST", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String HTTP_BAD_REQUEST = "Bad request to server";

            @NotNull
            public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SPEN_SUB;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SPEN_SUB {
        public static final int COMPOSE_XML = 301;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FILE_VERIFICATION = 304;
        public static final int INVALID_DATA_SIZE = 305;
        public static final int INVALID_FILE_HASH = 307;
        public static final int PARSE_XML = 302;
        public static final int RESOURCE_LACKING = 306;
        public static final int SAVE = 300;
        public static final int UNSUPPORTED_TYPE = 303;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SPEN_SUB$Companion;", "", "<init>", "()V", "SAVE", "", "COMPOSE_XML", "PARSE_XML", "UNSUPPORTED_TYPE", "FILE_VERIFICATION", "INVALID_DATA_SIZE", "RESOURCE_LACKING", "INVALID_FILE_HASH", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int COMPOSE_XML = 301;
            public static final int FILE_VERIFICATION = 304;
            public static final int INVALID_DATA_SIZE = 305;
            public static final int INVALID_FILE_HASH = 307;
            public static final int PARSE_XML = 302;
            public static final int RESOURCE_LACKING = 306;
            public static final int SAVE = 300;
            public static final int UNSUPPORTED_TYPE = 303;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SPEN_SUB_MSG;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SPEN_SUB_MSG {

        @NotNull
        public static final String COMPOSE_XML = "Spen SDK can't compose a xml note";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String FILE_VERIFICATION = "A file hash is not valid";

        @NotNull
        public static final String INVALID_DATA_SIZE = "Invalid data size";

        @NotNull
        public static final String INVALID_FILE_HASH = "Invalid file hash";

        @NotNull
        public static final String PARSE_XML = "Spen SDK can't parse a xml note";

        @NotNull
        public static final String RESOURCE_LACKING = "Resource lacking is reported from server";

        @NotNull
        public static final String SAVE = "Spen SDK can't save a note";

        @NotNull
        public static final String UNSUPPORTED_TYPE = "Spen SDK found a unsupported type";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SPEN_SUB_MSG$Companion;", "", "<init>", "()V", "SAVE", "", "COMPOSE_XML", "PARSE_XML", "UNSUPPORTED_TYPE", "FILE_VERIFICATION", "INVALID_DATA_SIZE", "RESOURCE_LACKING", "INVALID_FILE_HASH", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String COMPOSE_XML = "Spen SDK can't compose a xml note";

            @NotNull
            public static final String FILE_VERIFICATION = "A file hash is not valid";

            @NotNull
            public static final String INVALID_DATA_SIZE = "Invalid data size";

            @NotNull
            public static final String INVALID_FILE_HASH = "Invalid file hash";

            @NotNull
            public static final String PARSE_XML = "Spen SDK can't parse a xml note";

            @NotNull
            public static final String RESOURCE_LACKING = "Resource lacking is reported from server";

            @NotNull
            public static final String SAVE = "Spen SDK can't save a note";

            @NotNull
            public static final String UNSUPPORTED_TYPE = "Spen SDK found a unsupported type";

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SYNC_SUB;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SYNC_SUB {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FOLDER_FUTURE_TIME = 201;
        public static final int FOLDER_SYNC = 200;
        public static final int NOTE_OUT_OF_MEMORY = 103;
        public static final int NOTE_OVER_1GB = 102;
        public static final int NOTE_SYNC = 100;
        public static final int NOTE_TOO_MANY_OBJECTS = 101;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SYNC_SUB$Companion;", "", "<init>", "()V", "NOTE_SYNC", "", "NOTE_TOO_MANY_OBJECTS", "NOTE_OVER_1GB", "NOTE_OUT_OF_MEMORY", "FOLDER_SYNC", "FOLDER_FUTURE_TIME", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FOLDER_FUTURE_TIME = 201;
            public static final int FOLDER_SYNC = 200;
            public static final int NOTE_OUT_OF_MEMORY = 103;
            public static final int NOTE_OVER_1GB = 102;
            public static final int NOTE_SYNC = 100;
            public static final int NOTE_TOO_MANY_OBJECTS = 101;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SYNC_SUB_MSG;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SYNC_SUB_MSG {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String FOLDER_FUTURE_TIME = "syncModifiedTime is future";

        @NotNull
        public static final String FOLDER_SYNC = "Folder sync error";

        @NotNull
        public static final String NOTE_OUT_OF_MEMORY = "cannot handle this note due to OOM";

        @NotNull
        public static final String NOTE_OVER_1GB = "The size of a note is over 1GB";

        @NotNull
        public static final String NOTE_SYNC = "Note sync error";

        @NotNull
        public static final String NOTE_TOO_MANY_OBJECTS = "Too many objects";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/diagmon/DiagMonError$SYNC_SUB_MSG$Companion;", "", "<init>", "()V", "NOTE_SYNC", "", "NOTE_TOO_MANY_OBJECTS", "NOTE_OVER_1GB", "NOTE_OUT_OF_MEMORY", "FOLDER_SYNC", "FOLDER_FUTURE_TIME", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String FOLDER_FUTURE_TIME = "syncModifiedTime is future";

            @NotNull
            public static final String FOLDER_SYNC = "Folder sync error";

            @NotNull
            public static final String NOTE_OUT_OF_MEMORY = "cannot handle this note due to OOM";

            @NotNull
            public static final String NOTE_OVER_1GB = "The size of a note is over 1GB";

            @NotNull
            public static final String NOTE_SYNC = "Note sync error";

            @NotNull
            public static final String NOTE_TOO_MANY_OBJECTS = "Too many objects";

            private Companion() {
            }
        }
    }

    private DiagMonError() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    @NotNull
    public static final String getErrorMsg(@Nullable String mainErrCode, int subErrCode) {
        if (mainErrCode == null) {
            return "";
        }
        switch (mainErrCode.hashCode()) {
            case -460935356:
                return !mainErrCode.equals("SYNC_ERROR") ? "" : INSTANCE.getSubSyncErrorMsg(subErrCode);
            case 1178575340:
                return !mainErrCode.equals("SERVER_ERROR") ? "" : INSTANCE.getSubServerErrorMsg(subErrCode);
            case 1237317162:
                return !mainErrCode.equals("APP_ERROR") ? "" : INSTANCE.getSubAppErrorMsg(subErrCode);
            case 1293467695:
                return !mainErrCode.equals("SPEN_ERROR") ? "" : INSTANCE.getSubSPenErrorMsg(subErrCode);
            default:
                return "";
        }
    }

    private final String getSubAppErrorMsg(int subErrCode) {
        return subErrCode == 100 ? "App Update Required" : "";
    }

    private final String getSubSPenErrorMsg(int subErrCode) {
        switch (subErrCode) {
            case 300:
                return "Spen SDK can't save a note";
            case 301:
                return "Spen SDK can't compose a xml note";
            case 302:
                return "Spen SDK can't parse a xml note";
            case 303:
                return "Spen SDK found a unsupported type";
            case 304:
                return "A file hash is not valid";
            case 305:
                return "Invalid data size";
            case 306:
                return "Resource lacking is reported from server";
            case 307:
                return "Invalid file hash";
            default:
                return "";
        }
    }

    private final String getSubServerErrorMsg(int subErrCode) {
        return subErrCode == 100 ? "Internal Server Error" : "";
    }

    private final String getSubSyncErrorMsg(int subErrCode) {
        if (subErrCode == 200) {
            return "Folder sync error";
        }
        if (subErrCode == 201) {
            return "syncModifiedTime is future";
        }
        switch (subErrCode) {
            case 100:
                return "Note sync error";
            case 101:
                return "Too many objects";
            case 102:
                return "The size of a note is over 1GB";
            case 103:
                return "cannot handle this note due to OOM";
            default:
                return "";
        }
    }
}
