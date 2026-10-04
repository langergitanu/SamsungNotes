package com.microsoft.identity.nativeauth;

import android.text.TextUtils;
import androidx.compose.runtime.AbstractC1974b;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0000J\u0016\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;", "Ljava/io/Serializable;", "()V", "challengeTypes", "", "", "dc", "getDc", "()Ljava/lang/String;", "setDc", "(Ljava/lang/String;)V", "useMockAuthority", "", "getUseMockAuthority", "()Ljava/lang/Boolean;", "setUseMockAuthority", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checkIntentFilterAddedToAppManifestForBrokerFlow", "", "getChallengeTypes", "mergeConfiguration", ExternalDataConstants.EmbeddingConfig.KEY, "setChallengeTypes", "validateChallengeTypes", "validateConfiguration", "Companion", "NativeAuthSerializedNames", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthPublicClientApplicationConfiguration extends PublicClientApplicationConfiguration implements Serializable {
    private static final String TAG = "NativeAuthPublicClientApplicationConfiguration";

    @NotNull
    private static final List<String> VALID_CHALLENGE_TYPES = CollectionsKt.listOf((Object[]) new String[]{"password", "oob", "redirect"});

    @SerializedName(NativeAuthSerializedNames.CHALLENGE_TYPES)
    @Nullable
    private List<String> challengeTypes;

    @SerializedName("dc")
    @Nullable
    private String dc;

    @SerializedName(NativeAuthSerializedNames.USE_MOCK_API)
    @Nullable
    private Boolean useMockAuthority;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration$NativeAuthSerializedNames;", "", "()V", "CHALLENGE_TYPES", "", "DC", "USE_MOCK_API", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class NativeAuthSerializedNames {

        @NotNull
        public static final String CHALLENGE_TYPES = "challenge_types";

        @NotNull
        public static final String DC = "dc";

        @NotNull
        public static final NativeAuthSerializedNames INSTANCE = new NativeAuthSerializedNames();

        @NotNull
        public static final String USE_MOCK_API = "use_mock_api_for_native_auth";

        private NativeAuthSerializedNames() {
        }
    }

    private final void validateChallengeTypes() throws MsalClientException {
        ArrayList<String> arrayList;
        List<String> list = this.challengeTypes;
        if (list != null) {
            List<String> list2 = list;
            arrayList = new ArrayList(CollectionsKt.m13952k(list2));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList.add(lowerCase);
            }
        } else {
            arrayList = null;
        }
        this.challengeTypes = arrayList;
        if (arrayList != null) {
            for (String str : arrayList) {
                if (!VALID_CHALLENGE_TYPES.contains(str)) {
                    throw new MsalClientException(MsalClientException.NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_CODE, AbstractC1974b.m1315h('\"', "NativeAuthPublicClientApplication detected invalid challenge type. \"", str));
                }
            }
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplicationConfiguration
    public void checkIntentFilterAddedToAppManifestForBrokerFlow() throws MsalClientException {
        if (getRedirectUri() != null) {
            super.checkIntentFilterAddedToAppManifestForBrokerFlow();
        }
    }

    @Nullable
    public final List<String> getChallengeTypes() {
        return this.challengeTypes;
    }

    @Nullable
    public final String getDc() {
        return this.dc;
    }

    @Nullable
    public final Boolean getUseMockAuthority() {
        return this.useMockAuthority;
    }

    public final void mergeConfiguration(@NotNull NativeAuthPublicClientApplicationConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.mergeConfiguration((PublicClientApplicationConfiguration) config);
        setAccountMode(config.getAccountMode() != null ? config.getAccountMode() : getAccountMode());
        List<String> list = config.challengeTypes;
        if (list == null) {
            list = this.challengeTypes;
        }
        this.challengeTypes = list;
        Boolean bool = config.useMockAuthority;
        if (bool == null) {
            bool = this.useMockAuthority;
        }
        this.useMockAuthority = bool;
        String str = config.dc;
        if (str == null) {
            str = this.dc;
        }
        this.dc = str;
    }

    public final void setChallengeTypes(@Nullable List<String> challengeTypes) {
        this.challengeTypes = challengeTypes;
    }

    public final void setDc(@Nullable String str) {
        this.dc = str;
    }

    public final void setUseMockAuthority(@Nullable Boolean bool) {
        this.useMockAuthority = bool;
    }

    @Override // com.microsoft.identity.client.PublicClientApplicationConfiguration
    public void validateConfiguration() throws MsalClientException {
        if (TextUtils.isEmpty(getClientId())) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_MESSAGE);
        }
        if (getRedirectUri() != null) {
            super.validateConfiguration();
        } else {
            Logger.warn(TAG, "No redirect URI was passed.");
        }
        if (getAccountMode() != AccountMode.SINGLE) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_CODE, MsalClientException.NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_MESSAGE);
        }
        if (getAuthorities() == null || getAuthorities().size() == 0) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_MESSAGE);
        }
        if (getAuthorities().size() > 1) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_MESSAGE);
        }
        if (!(getDefaultAuthority() instanceof NativeAuthCIAMAuthority)) {
            if (!(getDefaultAuthority() instanceof CIAMAuthority)) {
                throw new MsalClientException("native_auth_invalid_ciam_authority", MsalClientException.NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_MESSAGE);
            }
            String string = getDefaultAuthority().getAuthorityUri().toString();
            Intrinsics.checkNotNullExpressionValue(string, "defaultAuthority.authorityUri.toString()");
            String clientId = getClientId();
            Intrinsics.checkNotNullExpressionValue(clientId, "clientId");
            NativeAuthCIAMAuthority nativeAuthCIAMAuthority = new NativeAuthCIAMAuthority(string, clientId);
            getAuthorities().clear();
            getAuthorities().add(nativeAuthCIAMAuthority);
        }
        if (getIsSharedDevice()) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_CODE, MsalClientException.NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_MESSAGE);
        }
        validateChallengeTypes();
    }
}
