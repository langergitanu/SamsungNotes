package com.google.android.appfunctions.schema.common.p129v1.clock;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/AlarmStatus;", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface AlarmStatus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String DISMISSED = "DISMISSED";

    @NotNull
    public static final String FIRING = "FIRING";

    @NotNull
    public static final String MISSED = "MISSED";

    @NotNull
    public static final String SCHEDULED = "SCHEDULED";

    @NotNull
    public static final String SNOOZED = "SNOOZED";

    @NotNull
    public static final String UNKNOWN = "UNKNOWN";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/AlarmStatus$Companion;", "", "<init>", "()V", "UNKNOWN", "", "SCHEDULED", "FIRING", "DISMISSED", "SNOOZED", "MISSED", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String DISMISSED = "DISMISSED";

        @NotNull
        public static final String FIRING = "FIRING";

        @NotNull
        public static final String MISSED = "MISSED";

        @NotNull
        public static final String SCHEDULED = "SCHEDULED";

        @NotNull
        public static final String SNOOZED = "SNOOZED";

        @NotNull
        public static final String UNKNOWN = "UNKNOWN";

        private Companion() {
        }
    }
}
