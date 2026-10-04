package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/IRequesterBase;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IRequesterBase {

    @NotNull
    public static final String AUTH_ERROR = "AUTH_ERROR";

    @NotNull
    public static final String AUTH_SA_ERROR = "AUTH_SA_ERROR";

    @NotNull
    public static final String CLIENT_ERROR = "CLIENT_ERROR";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String INPUT_DATA_ERROR = "INPUT_DATA_ERROR";

    @NotNull
    public static final String INPUT_TOO_LONG = "INPUT_TOO_LONG";

    @NotNull
    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";

    @NotNull
    public static final String MISSING_MANDATORY_FIELD = "MISSING_MANDATORY_FIELD";

    @NotNull
    public static final String NETWORK_ERROR = "NETWORK_ERROR";

    @NotNull
    public static final String REMOTE_SERVER_ERROR = "REMOTE_SERVER_ERROR";

    @NotNull
    public static final String RESTRICTED_USER_ERROR = "RESTRICTED_USER_ERROR";
    public static final int RETRY_NUM = 1;

    @NotNull
    public static final String SAFE_FILTER_ERROR = "SAFE_FILTER_ERROR";

    @NotNull
    public static final String SAFE_FILTER_ERROR_CHILD = "SAFE_FILTER_ERROR_CHILD";

    @NotNull
    public static final String SAFE_FILTER_ERROR_CHN_SENSITIVE = "SAFE_FILTER_ERROR_CHN_SENSITIVE";

    @NotNull
    public static final String SAFE_FILTER_ERROR_RECITATION = "SAFE_FILTER_ERROR_RECITATION";

    @NotNull
    public static final String SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE = "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE";
    public static final int SCS_CHN_REQUEST_TIMEOUT = 40;
    public static final int SCS_CHN_STREAMING_REQUEST_TIMEOUT = 100;
    public static final int SCS_LVM_REQUEST_TIMEOUT = 60;
    public static final int SCS_ON_DEVICE_REQUEST_TIMEOUT = 60;
    public static final int SCS_REQUEST_TIMEOUT = 30;

    @NotNull
    public static final String SERVER_ERROR = "SERVER_ERROR";

    @NotNull
    public static final String SERVER_QUOTA_ERROR = "SERVER_QUOTA_ERROR";

    @NotNull
    public static final String SERVICE_IS_BUSY = "SERVICE_IS_BUSY";

    @NotNull
    public static final String TIMEOUT_ERROR = "TIMEOUT_ERROR";

    @NotNull
    public static final String UNEXPECTED_ERROR = "UNEXPECTED_ERROR";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/IRequesterBase$Companion;", "", "<init>", "()V", "SCS_REQUEST_TIMEOUT", "", "SCS_CHN_REQUEST_TIMEOUT", "SCS_CHN_STREAMING_REQUEST_TIMEOUT", "SCS_ON_DEVICE_REQUEST_TIMEOUT", "SCS_LVM_REQUEST_TIMEOUT", "RETRY_NUM", "NETWORK_ERROR", "", "SAFE_FILTER_ERROR", "SAFE_FILTER_ERROR_RECITATION", "SAFE_FILTER_ERROR_CHILD", "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE", "SAFE_FILTER_ERROR_CHN_SENSITIVE", "REMOTE_SERVER_ERROR", "INTERNAL_SERVER_ERROR", "TIMEOUT_ERROR", "INPUT_DATA_ERROR", "MISSING_MANDATORY_FIELD", "CLIENT_ERROR", "AUTH_ERROR", "AUTH_SA_ERROR", "SERVER_ERROR", "SERVER_QUOTA_ERROR", "UNEXPECTED_ERROR", "RESTRICTED_USER_ERROR", "SERVICE_IS_BUSY", "INPUT_TOO_LONG", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String AUTH_ERROR = "AUTH_ERROR";

        @NotNull
        public static final String AUTH_SA_ERROR = "AUTH_SA_ERROR";

        @NotNull
        public static final String CLIENT_ERROR = "CLIENT_ERROR";

        @NotNull
        public static final String INPUT_DATA_ERROR = "INPUT_DATA_ERROR";

        @NotNull
        public static final String INPUT_TOO_LONG = "INPUT_TOO_LONG";

        @NotNull
        public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";

        @NotNull
        public static final String MISSING_MANDATORY_FIELD = "MISSING_MANDATORY_FIELD";

        @NotNull
        public static final String NETWORK_ERROR = "NETWORK_ERROR";

        @NotNull
        public static final String REMOTE_SERVER_ERROR = "REMOTE_SERVER_ERROR";

        @NotNull
        public static final String RESTRICTED_USER_ERROR = "RESTRICTED_USER_ERROR";
        public static final int RETRY_NUM = 1;

        @NotNull
        public static final String SAFE_FILTER_ERROR = "SAFE_FILTER_ERROR";

        @NotNull
        public static final String SAFE_FILTER_ERROR_CHILD = "SAFE_FILTER_ERROR_CHILD";

        @NotNull
        public static final String SAFE_FILTER_ERROR_CHN_SENSITIVE = "SAFE_FILTER_ERROR_CHN_SENSITIVE";

        @NotNull
        public static final String SAFE_FILTER_ERROR_RECITATION = "SAFE_FILTER_ERROR_RECITATION";

        @NotNull
        public static final String SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE = "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE";
        public static final int SCS_CHN_REQUEST_TIMEOUT = 40;
        public static final int SCS_CHN_STREAMING_REQUEST_TIMEOUT = 100;
        public static final int SCS_LVM_REQUEST_TIMEOUT = 60;
        public static final int SCS_ON_DEVICE_REQUEST_TIMEOUT = 60;
        public static final int SCS_REQUEST_TIMEOUT = 30;

        @NotNull
        public static final String SERVER_ERROR = "SERVER_ERROR";

        @NotNull
        public static final String SERVER_QUOTA_ERROR = "SERVER_QUOTA_ERROR";

        @NotNull
        public static final String SERVICE_IS_BUSY = "SERVICE_IS_BUSY";

        @NotNull
        public static final String TIMEOUT_ERROR = "TIMEOUT_ERROR";

        @NotNull
        public static final String UNEXPECTED_ERROR = "UNEXPECTED_ERROR";

        private Companion() {
        }
    }
}
