package com.microsoft.identity.common.internal.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ICacheRecordGsonAdapter implements JsonDeserializer<ICacheRecord> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ICacheRecord deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return (ICacheRecord) jsonDeserializationContext.deserialize(jsonElement, CacheRecord.class);
    }
}
