package com.microsoft.identity.nativeauth;

import androidx.autofill.HintConstants;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\b\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/UserAttributes;", "", "userAttributes", "", "", "(Ljava/util/Map;)V", "getUserAttributes$msal_distRelease", "()Ljava/util/Map;", "userAttributes$1", "Builder", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class UserAttributes {

    @NotNull
    private static final String CITY = "city";

    @NotNull
    private static final String COUNTRY = "country";

    @NotNull
    private static final String DISPLAY_NAME = "displayName";

    @NotNull
    private static final String EMAIL_ADDRESS = "email";

    @NotNull
    private static final String GIVEN_NAME = "givenName";

    @NotNull
    private static final String JOB_TITLE = "jobTitle";

    @NotNull
    private static final String POSTAL_CODE = "postalCode";

    @NotNull
    private static final String STATE = "state";

    @NotNull
    private static final String STREET_ADDRESS = "streetAddress";

    @NotNull
    private static final String SURNAME = "surname";

    /* JADX INFO: renamed from: userAttributes$1, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> userAttributes;

    /* JADX INFO: renamed from: Builder, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> userAttributes = new LinkedHashMap();

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.UserAttributes$Builder, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/UserAttributes$Builder;", "", "()V", "CITY", "", "COUNTRY", "DISPLAY_NAME", TextConst.ENTITY_TYPE_EMAIL_ADDRESS, "GIVEN_NAME", "JOB_TITLE", "POSTAL_CODE", "STATE", "STREET_ADDRESS", "SURNAME", "userAttributes", "", "build", "Lcom/microsoft/identity/nativeauth/UserAttributes;", "city", "country", "customAttribute", "key", "value", "displayName", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, UserAttributes.GIVEN_NAME, UserAttributes.JOB_TITLE, "postalCode", "state", "streetAddress", UserAttributes.SURNAME, "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserAttributes build() {
            return new UserAttributes(UserAttributes.userAttributes);
        }

        @NotNull
        public final Companion city(@NotNull String city) {
            Intrinsics.checkNotNullParameter(city, "city");
            UserAttributes.userAttributes.put("city", city);
            return this;
        }

        @NotNull
        public final Companion country(@NotNull String country) {
            Intrinsics.checkNotNullParameter(country, "country");
            UserAttributes.userAttributes.put("country", country);
            return this;
        }

        @NotNull
        public final Companion customAttribute(@NotNull String key, @NotNull String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            UserAttributes.userAttributes.put(key, value);
            return this;
        }

        @NotNull
        public final Companion displayName(@NotNull String displayName) {
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            UserAttributes.userAttributes.put("displayName", displayName);
            return this;
        }

        @NotNull
        public final Companion emailAddress(@NotNull String emailAddress) {
            Intrinsics.checkNotNullParameter(emailAddress, "emailAddress");
            UserAttributes.userAttributes.put("email", emailAddress);
            return this;
        }

        @NotNull
        public final Companion givenName(@NotNull String givenName) {
            Intrinsics.checkNotNullParameter(givenName, "givenName");
            UserAttributes.userAttributes.put(UserAttributes.GIVEN_NAME, givenName);
            return this;
        }

        @NotNull
        public final Companion jobTitle(@NotNull String jobTitle) {
            Intrinsics.checkNotNullParameter(jobTitle, "jobTitle");
            UserAttributes.userAttributes.put(UserAttributes.JOB_TITLE, jobTitle);
            return this;
        }

        @NotNull
        public final Companion postalCode(@NotNull String postalCode) {
            Intrinsics.checkNotNullParameter(postalCode, "postalCode");
            UserAttributes.userAttributes.put("postalCode", postalCode);
            return this;
        }

        @NotNull
        public final Companion state(@NotNull String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            UserAttributes.userAttributes.put("state", state);
            return this;
        }

        @NotNull
        public final Companion streetAddress(@NotNull String streetAddress) {
            Intrinsics.checkNotNullParameter(streetAddress, "streetAddress");
            UserAttributes.userAttributes.put("streetAddress", streetAddress);
            return this;
        }

        @NotNull
        public final Companion surname(@NotNull String surname) {
            Intrinsics.checkNotNullParameter(surname, "surname");
            UserAttributes.userAttributes.put(UserAttributes.SURNAME, surname);
            return this;
        }

        private Companion() {
        }
    }

    public UserAttributes(@NotNull Map<String, String> userAttributes2) {
        Intrinsics.checkNotNullParameter(userAttributes2, "userAttributes");
        this.userAttributes = userAttributes2;
    }

    @NotNull
    public final Map<String, String> getUserAttributes$msal_distRelease() {
        return this.userAttributes;
    }
}
