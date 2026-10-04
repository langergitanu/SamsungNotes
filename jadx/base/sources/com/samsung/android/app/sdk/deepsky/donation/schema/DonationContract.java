package com.samsung.android.app.sdk.deepsky.donation.schema;

import android.net.Uri;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/schema/DonationContract;", "", "()V", "AUTHORITY", "", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getCONTENT_URI", "()Landroid/net/Uri;", "DONATION_DATE_FORMAT", "DONATION_LOCALE", "Ljava/util/Locale;", "getDONATION_LOCALE", "()Ljava/util/Locale;", "DONATION_METHOD_CALL", "DONATION_RESULT_KEY", "DONATION_WIDGET_METHOD_CALL", "KEY_ACTIONTABLE", "KEY_ACTIONVIEW", "KEY_COMPONENT_NAME", "KEY_DURATION", "KEY_PARAM_NAME_REMOVE", "KEY_PARAM_VALUE_REMOVE", "KEY_SCORE", "KEY_START_TIME", "KEY_VISIBILITY", "KEY_WILL_PROVIDE_REASON", "LEGACY_KEY_DURATION", "READ_CONTENT_URI", "getREAD_CONTENT_URI", "REMOVE_DONATED_DATA", "ColumnNames", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DonationContract {

    @NotNull
    private static final String AUTHORITY = "com.samsung.android.app.deepsky.donation.donateaction";

    @NotNull
    public static final String DONATION_DATE_FORMAT = "yyyy-MM-dd";

    @NotNull
    public static final String DONATION_METHOD_CALL = "donate_user_action";

    @NotNull
    public static final String DONATION_RESULT_KEY = "db_insert_result";

    @NotNull
    public static final String DONATION_WIDGET_METHOD_CALL = "donate_relevant_widget";

    @NotNull
    private static final String KEY_ACTIONTABLE = "ActionDataTable";

    @NotNull
    private static final String KEY_ACTIONVIEW = "ActionView";

    @NotNull
    public static final String KEY_COMPONENT_NAME = "key_component_name";

    @NotNull
    public static final String KEY_DURATION = "key_duration";

    @NotNull
    public static final String KEY_PARAM_NAME_REMOVE = "key_param_name_remove";

    @NotNull
    public static final String KEY_PARAM_VALUE_REMOVE = "key_param_value_remove";

    @NotNull
    public static final String KEY_SCORE = "key_score";

    @NotNull
    public static final String KEY_START_TIME = "key_start_time";

    @NotNull
    public static final String KEY_VISIBILITY = "key_visibility";

    @NotNull
    public static final String KEY_WILL_PROVIDE_REASON = "key_will_provide_reason";

    @NotNull
    public static final String LEGACY_KEY_DURATION = "key_duration_second";

    @NotNull
    public static final String REMOVE_DONATED_DATA = "remove_donated_data";

    @NotNull
    public static final DonationContract INSTANCE = new DonationContract();
    private static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.app.deepsky.donation.donateaction/ActionDataTable");
    private static final Uri READ_CONTENT_URI = Uri.parse("content://com.samsung.android.app.deepsky.donation.donateaction/ActionView");
    private static final Locale DONATION_LOCALE = Locale.US;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/schema/DonationContract$ColumnNames;", "", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface ColumnNames {

        @NotNull
        public static final String ACTION_ID = "actionId";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String INTENT_NAME = "intentName";

        @NotNull
        public static final String INTENT_URL = "intentUrl";

        @NotNull
        public static final String PACKAGE_NAME = "packageName";

        @NotNull
        public static final String PARAM_CONTENT = "paramContent";

        @NotNull
        public static final String TIME_STAMP = "timeStamp";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/schema/DonationContract$ColumnNames$Companion;", "", "()V", "ACTION_ID", "", "INTENT_NAME", "INTENT_URL", "PACKAGE_NAME", "PARAM_CONTENT", "TIME_STAMP", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            public static final String ACTION_ID = "actionId";

            @NotNull
            public static final String INTENT_NAME = "intentName";

            @NotNull
            public static final String INTENT_URL = "intentUrl";

            @NotNull
            public static final String PACKAGE_NAME = "packageName";

            @NotNull
            public static final String PARAM_CONTENT = "paramContent";

            @NotNull
            public static final String TIME_STAMP = "timeStamp";

            private Companion() {
            }
        }
    }

    private DonationContract() {
    }

    public final Uri getCONTENT_URI() {
        return CONTENT_URI;
    }

    public final Locale getDONATION_LOCALE() {
        return DONATION_LOCALE;
    }

    public final Uri getREAD_CONTENT_URI() {
        return READ_CONTENT_URI;
    }
}
