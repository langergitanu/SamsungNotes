package com.microsoft.identity.common.java.util;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrokerProtocolVersionUtil {
    public static final String MSAL_TO_BROKER_PROTOCOL_ACCOUNT_FROM_PRT_CHANGES_MINIMUM_VERSION = "8.0";
    public static final String MSAL_TO_BROKER_PROTOCOL_BROKER_MSA_SUPPORT_MINIMUM_VERSION = "14.0";
    public static final String MSAL_TO_BROKER_PROTOCOL_COMPRESSION_CHANGES_MINIMUM_VERSION = "5.0";
    public static final String MSAL_TO_BROKER_PROTOCOL_NAA_MINIMUM_VERSION = "15.0";
    public static final String MSAL_TO_BROKER_PROTOCOL_PKEYAUTH_HEADER_CHANGES_MINIMUM_VERSION = "9.0";

    /* JADX INFO: renamed from: MSAL_TO_BROKER_PROTOCOL_POP_SCHEME_WITH_CLIENT_KEY_MINIMUM_VERSION */
    public static final String f3611x4a7f8eb7 = "11.0";

    public static final boolean canCompressBrokerPayloads(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, MSAL_TO_BROKER_PROTOCOL_COMPRESSION_CHANGES_MINIMUM_VERSION);
    }

    public static final boolean canFociAppsConstructAccountsFromPrtIdTokens(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, MSAL_TO_BROKER_PROTOCOL_ACCOUNT_FROM_PRT_CHANGES_MINIMUM_VERSION);
    }

    public static boolean canSendPKeyAuthHeaderToTheTokenEndpoint(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, MSAL_TO_BROKER_PROTOCOL_PKEYAUTH_HEADER_CHANGES_MINIMUM_VERSION);
    }

    public static boolean canSupportMsaAccountsInBroker(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, MSAL_TO_BROKER_PROTOCOL_BROKER_MSA_SUPPORT_MINIMUM_VERSION);
    }

    public static boolean canSupportNestedAppAuthentication(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, "15.0");
    }

    public static boolean canSupportPopAuthenticationSchemeWithClientKey(@Nullable String str) {
        return isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(str, f3611x4a7f8eb7);
    }

    public static final int compareSemanticVersion(@NonNull String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("thisVersion is marked non-null but is null");
        }
        if (str2 == null) {
            return 1;
        }
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        String[] strArrSplit2 = str2.split(RemoteConstant.VERSION_DIVIDE);
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int i2 = i < strArrSplit.length ? Integer.parseInt(strArrSplit[i]) : 0;
            int i4 = i < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i]) : 0;
            if (i2 < i4) {
                return -1;
            }
            if (i2 > i4) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public static boolean isFirstVersionNewerOrEqual(@NonNull String str, @Nullable String str2) {
        if (str != null) {
            return compareSemanticVersion(str, str2) >= 0;
        }
        throw new NullPointerException("first is marked non-null but is null");
    }

    public static boolean isFirstVersionOlderOrEqual(@NonNull String str, @Nullable String str2) {
        if (str != null) {
            return compareSemanticVersion(str, str2) <= 0;
        }
        throw new NullPointerException("first is marked non-null but is null");
    }

    public static boolean isProvidedBrokerProtocolLargerOrEqualThanRequiredBrokerProtocol(@Nullable String str, @NonNull String str2) {
        if (str2 == null) {
            throw new NullPointerException("requiredBrokerProtocol is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return isFirstVersionNewerOrEqual(str, str2);
    }
}
