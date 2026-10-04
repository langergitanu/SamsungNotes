package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/DataFieldDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DataFieldDeserializer implements JsonDeserializer<Object> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Object deserialize(@Nullable JsonElement json, @Nullable Type typeOfT, @Nullable JsonDeserializationContext context) {
        if (json == null) {
            return null;
        }
        if (json.isJsonObject()) {
            json = json.getAsJsonObject().getAsJsonArray("actions");
        } else if (!json.isJsonArray()) {
            json = null;
        }
        return new Data(context != null ? (List) context.deserialize(json, new TypeToken<List<? extends Action>>() { // from class: com.samsung.android.sdk.scs.ai.visual.c2pa.DataFieldDeserializer$deserialize$actionsList$1
        }.getType()) : null);
    }
}
