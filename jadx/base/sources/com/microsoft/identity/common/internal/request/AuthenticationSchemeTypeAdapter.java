package com.microsoft.identity.common.internal.request;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.logging.Logger;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthenticationSchemeTypeAdapter implements JsonDeserializer<AbstractAuthenticationScheme>, JsonSerializer<AbstractAuthenticationScheme> {
    private static final String TAG = "AuthenticationSchemeTypeAdapter";
    private static Gson sRequestAdapterGsonInstance = new GsonBuilder().registerTypeAdapter(AbstractAuthenticationScheme.class, new AuthenticationSchemeTypeAdapter()).create();

    public static Gson getGsonInstance() {
        return sRequestAdapterGsonInstance;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AbstractAuthenticationScheme deserialize(@NonNull JsonElement jsonElement, @NonNull Type type, @NonNull JsonDeserializationContext jsonDeserializationContext) {
        String strM1170p;
        strM1170p = AbstractC0622a.m1170p(TAG, ":deserialize", new StringBuilder());
        String asString = jsonElement.getAsJsonObject().get("name").getAsString();
        asString.getClass();
        switch (asString) {
            case "PoP_With_Client_Key":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, PopAuthenticationSchemeWithClientKeyInternal.class);
            case "PoP":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, PopAuthenticationSchemeInternal.class);
            case "Bearer":
                return (AbstractAuthenticationScheme) jsonDeserializationContext.deserialize(jsonElement, BearerAuthenticationSchemeInternal.class);
            default:
                Logger.warn(strM1170p, "Unrecognized auth scheme. Deserializing as null.");
                return null;
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(@NonNull AbstractAuthenticationScheme abstractAuthenticationScheme, @NonNull Type type, @NonNull JsonSerializationContext jsonSerializationContext) {
        String strM1170p;
        strM1170p = AbstractC0622a.m1170p(TAG, ":serialize", new StringBuilder());
        String name = abstractAuthenticationScheme.getName();
        name.getClass();
        switch (name) {
            case "PoP_With_Client_Key":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, PopAuthenticationSchemeWithClientKeyInternal.class);
            case "PoP":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, PopAuthenticationSchemeInternal.class);
            case "Bearer":
                return jsonSerializationContext.serialize(abstractAuthenticationScheme, BearerAuthenticationSchemeInternal.class);
            default:
                Logger.warn(strM1170p, "Unrecognized auth scheme. Serializing as null.");
                return null;
        }
    }
}
