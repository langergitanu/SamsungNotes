package com.google.android.appfunctions;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.sec.spp.push.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00060\u0001j\u0002`\u0002:\u0003\u0017\u0018\u0019B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\f¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMessage", "", "extras", "Landroid/os/Bundle;", "<init>", "(ILjava/lang/String;Landroid/os/Bundle;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getExtras", "()Landroid/os/Bundle;", "toPlatformClass", "Lcom/android/extensions/appfunctions/AppFunctionException;", "errorCategory", "getErrorCategory$annotations", "()V", "getErrorCategory", Config.EXTRA_ERROR_CODE, "ErrorCategory", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AppFunctionException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int errorCategory;
    private final int errorCode;

    @Nullable
    private final String errorMessage;

    @NotNull
    private final Bundle extras;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException$Companion;", "", "<init>", "()V", "fromPlatformClass", "Lcom/google/android/appfunctions/AppFunctionException;", "exception", "Lcom/android/extensions/appfunctions/AppFunctionException;", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(36)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final AppFunctionException fromPlatformClass(@NotNull com.android.extensions.appfunctions.AppFunctionException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            int errorCode = exception.getErrorCode();
            String errorMessage = exception.getErrorMessage();
            Bundle extras = exception.getExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
            return new AppFunctionException(errorCode, errorMessage, extras);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException$ErrorCategory;", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ErrorCategory {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int ERROR_CATEGORY_APP = 3;
        public static final int ERROR_CATEGORY_REQUEST_ERROR = 1;
        public static final int ERROR_CATEGORY_SYSTEM = 2;
        public static final int ERROR_CATEGORY_UNKNOWN = 0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException$ErrorCategory$Companion;", "", "<init>", "()V", "ERROR_CATEGORY_UNKNOWN", "", "ERROR_CATEGORY_REQUEST_ERROR", "ERROR_CATEGORY_SYSTEM", "ERROR_CATEGORY_APP", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ERROR_CATEGORY_APP = 3;
            public static final int ERROR_CATEGORY_REQUEST_ERROR = 1;
            public static final int ERROR_CATEGORY_SYSTEM = 2;
            public static final int ERROR_CATEGORY_UNKNOWN = 0;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException$ErrorCode;", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ErrorCode {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int ERROR_ACTION_NOT_SUPPORTED = 3501;
        public static final int ERROR_ALREADY_EXISTS = 1502;
        public static final int ERROR_APP_UNKNOWN_ERROR = 3000;
        public static final int ERROR_CANCELLED = 2001;
        public static final int ERROR_DENIED = 1000;
        public static final int ERROR_DISABLED = 1002;
        public static final int ERROR_FUNCTION_NOT_FOUND = 1003;
        public static final int ERROR_INVALID_ARGUMENT = 1001;
        public static final int ERROR_LIMIT_EXCEEDED = 1501;
        public static final int ERROR_NOT_FOUND = 1500;
        public static final int ERROR_PERMISSION_REQUIRED = 3500;
        public static final int ERROR_SYSTEM_ERROR = 2000;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionException$ErrorCode$Companion;", "", "<init>", "()V", "ERROR_DENIED", "", "ERROR_INVALID_ARGUMENT", "ERROR_DISABLED", "ERROR_FUNCTION_NOT_FOUND", "ERROR_NOT_FOUND", "ERROR_LIMIT_EXCEEDED", "ERROR_ALREADY_EXISTS", "ERROR_SYSTEM_ERROR", "ERROR_CANCELLED", "ERROR_APP_UNKNOWN_ERROR", "ERROR_PERMISSION_REQUIRED", "ERROR_ACTION_NOT_SUPPORTED", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ERROR_ACTION_NOT_SUPPORTED = 3501;
            public static final int ERROR_ALREADY_EXISTS = 1502;
            public static final int ERROR_APP_UNKNOWN_ERROR = 3000;
            public static final int ERROR_CANCELLED = 2001;
            public static final int ERROR_DENIED = 1000;
            public static final int ERROR_DISABLED = 1002;
            public static final int ERROR_FUNCTION_NOT_FOUND = 1003;
            public static final int ERROR_INVALID_ARGUMENT = 1001;
            public static final int ERROR_LIMIT_EXCEEDED = 1501;
            public static final int ERROR_NOT_FOUND = 1500;
            public static final int ERROR_PERMISSION_REQUIRED = 3500;
            public static final int ERROR_SYSTEM_ERROR = 2000;

            private Companion() {
            }
        }
    }

    public /* synthetic */ AppFunctionException(int i, String str, Bundle bundle, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? Bundle.EMPTY : bundle);
    }

    public final int getErrorCategory() {
        return this.errorCategory;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final Bundle getExtras() {
        return this.extras;
    }

    @RequiresApi(36)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final com.android.extensions.appfunctions.AppFunctionException toPlatformClass() {
        return new com.android.extensions.appfunctions.AppFunctionException(this.errorCode, this.errorMessage, this.extras);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionException(int i, @Nullable String str, @NotNull Bundle extras) {
        super(str);
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.errorCode = i;
        this.errorMessage = str;
        this.extras = extras;
        this.errorCategory = (1000 > i || i >= 2000) ? (2000 > i || i >= 3000) ? (3000 > i || i >= 4000) ? 0 : 3 : 2 : 1;
    }

    @ErrorCategory
    public static /* synthetic */ void getErrorCategory$annotations() {
    }
}
