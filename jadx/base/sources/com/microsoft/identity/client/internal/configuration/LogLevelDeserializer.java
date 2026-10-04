package com.microsoft.identity.client.internal.configuration;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.microsoft.identity.client.Logger;
import java.lang.reflect.Type;
import java.util.Locale;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class LogLevelDeserializer implements JsonDeserializer<Logger.LogLevel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Logger.LogLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Logger.LogLevel.valueOf(jsonElement.getAsString().toUpperCase(Locale.US));
    }
}
