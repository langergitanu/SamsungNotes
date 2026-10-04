package com.microsoft.identity.common.internal.authorities;

import androidx.collection.AbstractC0622a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.identity.common.java.authorities.AccountsInOneOrganization;
import com.microsoft.identity.common.java.authorities.AllAccounts;
import com.microsoft.identity.common.java.authorities.AnyOrganizationalAccount;
import com.microsoft.identity.common.java.authorities.AnyPersonalAccount;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.logging.Logger;
import java.lang.reflect.Type;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class AzureActiveDirectoryAudienceDeserializer implements JsonDeserializer<AzureActiveDirectoryAudience> {
    private static final String TAG = "AzureActiveDirectoryAudienceDeserializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AzureActiveDirectoryAudience deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":deserialize", new StringBuilder());
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("type");
        if (jsonElement2 == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        asString.getClass();
        switch (asString) {
            case "PersonalMicrosoftAccount":
                Logger.verbose(strM1170p, "Type: PersonalMicrosoftAccount");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AnyPersonalAccount.class);
            case "AzureADMultipleOrgs":
                Logger.verbose(strM1170p, "Type: AzureADMultipleOrgs");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AnyOrganizationalAccount.class);
            case "AzureADMyOrg":
                Logger.verbose(strM1170p, "Type: AzureADMyOrg");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AccountsInOneOrganization.class);
            case "AzureADandPersonalMicrosoftAccount":
                Logger.verbose(strM1170p, "Type: AzureADandPersonalMicrosoftAccount");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AllAccounts.class);
            default:
                Logger.verbose(strM1170p, "Type: Unknown");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, UnknownAudience.class);
        }
    }
}
