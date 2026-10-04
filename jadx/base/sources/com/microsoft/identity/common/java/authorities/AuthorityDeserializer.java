package com.microsoft.identity.common.java.authorities;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import cz.msebera.android.httpclient.util.TextUtils;
import java.lang.reflect.Type;
import java.net.URI;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class AuthorityDeserializer implements JsonDeserializer<Authority> {
    private static final String TAG = "AuthorityDeserializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Authority deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        String str;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("type");
        if (jsonElement2 == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        asString.getClass();
        switch (asString) {
            case "AAD":
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":deserialize", "Type: AAD");
                AzureActiveDirectoryAuthority azureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority) jsonDeserializationContext.deserialize(asJsonObject, AzureActiveDirectoryAuthority.class);
                if (azureActiveDirectoryAuthority != null && (str = azureActiveDirectoryAuthority.mAuthorityUrlString) != null) {
                    try {
                        CommonURIBuilder commonURIBuilder = new CommonURIBuilder(URI.create(str));
                        String str2 = commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost();
                        String lastPathSegment = commonURIBuilder.getLastPathSegment();
                        if (!TextUtils.isEmpty(lastPathSegment)) {
                            azureActiveDirectoryAuthority.mAudience = AzureActiveDirectoryAudience.getAzureActiveDirectoryAudience(str2, lastPathSegment);
                            return azureActiveDirectoryAuthority;
                        }
                    } catch (IllegalArgumentException e) {
                        Logger.error(AbstractC0622a.m1170p(TAG, ":deserialize", new StringBuilder()), e.getMessage(), e);
                    }
                }
                return azureActiveDirectoryAuthority;
            case "B2C":
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":deserialize", "Type: B2C");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, AzureActiveDirectoryB2CAuthority.class);
            case "ADFS":
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":deserialize", "Type: ADFS");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, ActiveDirectoryFederationServicesAuthority.class);
            case "CIAM":
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":deserialize", "Type: CIAM");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, CIAMAuthority.class);
            default:
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":deserialize", "Type: Unknown");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, UnknownAuthority.class);
        }
    }
}
