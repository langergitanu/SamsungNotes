package com.microsoft.identity.common.adal.internal.tokensharing;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class TokenCacheItemSerializationAdapater implements JsonDeserializer<ADALTokenCacheItem>, JsonSerializer<ADALTokenCacheItem> {
    private static final String TAG = "TokenCacheItemSerializationAdapater";

    private void throwIfParameterMissing(JsonObject jsonObject, String str) {
        if (!jsonObject.has(str)) {
            throw new JsonParseException(AbstractC0541b.m776r(new StringBuilder(), TAG, "Attribute ", str, " is missing for deserialization."));
        }
    }

    private void throwIfParameterNull(String str, String str2) {
        if (str == null) {
            throw new JsonParseException(AbstractC0541b.m776r(new StringBuilder(), TAG, "Attribute ", str2, " is null for serialization."));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ADALTokenCacheItem deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        throwIfParameterMissing(asJsonObject, "authority");
        throwIfParameterMissing(asJsonObject, "id_token");
        throwIfParameterMissing(asJsonObject, "foci");
        throwIfParameterMissing(asJsonObject, "refresh_token");
        String asString = asJsonObject.get("id_token").getAsString();
        ADALTokenCacheItem aDALTokenCacheItem = new ADALTokenCacheItem();
        aDALTokenCacheItem.setAuthority(asJsonObject.get("authority").getAsString());
        aDALTokenCacheItem.setRawIdToken(asString);
        aDALTokenCacheItem.setFamilyClientId(asJsonObject.get("foci").getAsString());
        aDALTokenCacheItem.setRefreshToken(asJsonObject.get("refresh_token").getAsString());
        return aDALTokenCacheItem;
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(ADALTokenCacheItem aDALTokenCacheItem, Type type, JsonSerializationContext jsonSerializationContext) {
        throwIfParameterNull(aDALTokenCacheItem.getAuthority(), "authority");
        throwIfParameterNull(aDALTokenCacheItem.getRefreshToken(), "refresh_token");
        throwIfParameterNull(aDALTokenCacheItem.getRawIdToken(), "id_token");
        throwIfParameterNull(aDALTokenCacheItem.getFamilyClientId(), "foci");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("authority", new JsonPrimitive(aDALTokenCacheItem.getAuthority()));
        jsonObject.add("refresh_token", new JsonPrimitive(aDALTokenCacheItem.getRefreshToken()));
        jsonObject.add("id_token", new JsonPrimitive(aDALTokenCacheItem.getRawIdToken()));
        jsonObject.add("foci", new JsonPrimitive(aDALTokenCacheItem.getFamilyClientId()));
        return jsonObject;
    }
}
