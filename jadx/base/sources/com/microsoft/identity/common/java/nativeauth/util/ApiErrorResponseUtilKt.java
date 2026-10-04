package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\t\u001a\u000e\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\t\u001a\u000e\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\u000e\u001a\u00020\u0001*\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\u0010\t\u001a\u000e\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0010\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0011\u0010\u0011\u001a\u00020\u0001*\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t\u001a\u000e\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0013\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0014\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001a\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001c\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001d\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010 \u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#0\"H\u0000¨\u0006$"}, m13886d2 = {"isAttributeValidationFailed", "", "", "isAttributesRequired", "isAuthNotSupported", "isCredentialRequired", "isExpiredToken", "isInvalidAuthenticationType", "", "(Ljava/lang/Integer;)Z", "isInvalidClient", "isInvalidCredentials", "isInvalidGrant", "isInvalidOOBValue", "isInvalidParameter", "isInvalidRequest", "isInvalidUsername", "isMFARequired", "isOOB", "isPassword", "isPasswordBanned", "isPasswordInvalid", "isPasswordRecentlyUsed", "isPasswordTooLong", "isPasswordTooShort", "isPasswordTooWeak", "isPollInProgress", "isPollSucceeded", "isRedirect", "isUnsupportedChallengeType", "isUserAlreadyExists", "isUserNotFound", "isVerificationRequired", "toAttributeList", "", "", "common4j"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ApiErrorResponseUtilKt {
    public static final boolean isAttributeValidationFailed(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "attribute_validation_failed", true);
    }

    public static final boolean isAttributesRequired(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "attributes_required", true);
    }

    public static final boolean isAuthNotSupported(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, SignUpErrorTypes.AUTH_NOT_SUPPORTED, true) || StringsKt__StringsJVMKt.contentEquals(str, "unsupported_auth_method", true);
    }

    public static final boolean isCredentialRequired(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "credential_required", true);
    }

    public static final boolean isExpiredToken(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, ErrorStrings.DEVICE_CODE_FLOW_EXPIRED_TOKEN_ERROR_CODE, true);
    }

    public static final boolean isInvalidAuthenticationType(@Nullable Integer num) {
        return num != null && num.intValue() == 400002;
    }

    public static final boolean isInvalidClient(@Nullable String str) {
        return str != null && StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "client_id parameter is empty or not valid", true);
    }

    public static final boolean isInvalidCredentials(@Nullable Integer num) {
        return num != null && num.intValue() == 50126;
    }

    public static final boolean isInvalidGrant(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "invalid_grant", true);
    }

    public static final boolean isInvalidOOBValue(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "invalid_oob_value", true);
    }

    public static final boolean isInvalidParameter(@Nullable Integer num) {
        return num != null && num.intValue() == 90100;
    }

    public static final boolean isInvalidRequest(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "invalid_request", true);
    }

    public static final boolean isInvalidUsername(@Nullable String str) {
        return str != null && StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "username parameter is empty or not valid", true);
    }

    public static final boolean isMFARequired(@Nullable Integer num) {
        return num != null && num.intValue() == 50076;
    }

    public static final boolean isOOB(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "oob", true);
    }

    public static final boolean isPassword(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password", true);
    }

    public static final boolean isPasswordBanned(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_banned", true);
    }

    public static final boolean isPasswordInvalid(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_is_invalid", true);
    }

    public static final boolean isPasswordRecentlyUsed(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_recently_used", true);
    }

    public static final boolean isPasswordTooLong(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_too_long", true);
    }

    public static final boolean isPasswordTooShort(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_too_short", true);
    }

    public static final boolean isPasswordTooWeak(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "password_too_weak", true);
    }

    public static final boolean isPollInProgress(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "in_progress", true);
    }

    public static final boolean isPollSucceeded(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, TelemetryEventStrings.Value.SUCCEEDED, true);
    }

    public static final boolean isRedirect(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "redirect", true);
    }

    public static final boolean isUnsupportedChallengeType(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "unsupported_challenge_type", true);
    }

    public static final boolean isUserAlreadyExists(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, SignUpErrorTypes.USER_ALREADY_EXISTS, true);
    }

    public static final boolean isUserNotFound(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, ErrorTypes.USER_NOT_FOUND, true);
    }

    public static final boolean isVerificationRequired(@Nullable String str) {
        return StringsKt__StringsJVMKt.contentEquals(str, "verification_required", true);
    }

    @NotNull
    public static final List<String> toAttributeList(@NotNull List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String str = (String) ((Map) it.next()).get("name");
            if (str != null) {
                arrayList.add(str);
            }
        }
        return CollectionsKt.toList(arrayList);
    }
}
