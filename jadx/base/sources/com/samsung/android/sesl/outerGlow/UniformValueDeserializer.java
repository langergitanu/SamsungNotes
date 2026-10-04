package com.samsung.android.sesl.outerGlow;

import androidx.annotation.Keep;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/UniformValueDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class UniformValueDeserializer implements JsonDeserializer<Object> {
    @Override // com.google.gson.JsonDeserializer
    @Keep
    @NotNull
    public Object deserialize(@NotNull JsonElement json, @NotNull Type typeOfT, @NotNull JsonDeserializationContext context) {
        Object objValueOf;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
        Intrinsics.checkNotNullParameter(context, "context");
        if (json.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = json.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                objValueOf = Float.valueOf(asJsonPrimitive.getAsFloat());
            } else if (asJsonPrimitive.isString()) {
                objValueOf = asJsonPrimitive.getAsString();
            } else {
                if (!asJsonPrimitive.isBoolean()) {
                    throw new JsonParseException("Unsupported primitive uniform value type");
                }
                objValueOf = Boolean.valueOf(asJsonPrimitive.getAsBoolean());
            }
            Intrinsics.checkNotNull(objValueOf);
            return objValueOf;
        }
        if (!json.isJsonArray()) {
            throw new JsonParseException("Unsupported uniform value type");
        }
        JsonArray asJsonArray = json.getAsJsonArray();
        int size = asJsonArray.size();
        if (size == 2) {
            return new float[]{asJsonArray.get(0).getAsFloat(), asJsonArray.get(1).getAsFloat()};
        }
        if (size == 3) {
            return new float[]{asJsonArray.get(0).getAsFloat(), asJsonArray.get(1).getAsFloat(), asJsonArray.get(2).getAsFloat()};
        }
        if (size == 4) {
            return new float[]{asJsonArray.get(0).getAsFloat(), asJsonArray.get(1).getAsFloat(), asJsonArray.get(2).getAsFloat(), asJsonArray.get(3).getAsFloat()};
        }
        ArrayList arrayList = new ArrayList(asJsonArray.size());
        for (JsonElement jsonElement : asJsonArray) {
            if (!jsonElement.isJsonPrimitive()) {
                throw new JsonParseException("Array elements must be primitives");
            }
            JsonPrimitive asJsonPrimitive2 = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive2.isNumber()) {
                arrayList.add(Float.valueOf(asJsonPrimitive2.getAsFloat()));
            } else if (asJsonPrimitive2.isString()) {
                arrayList.add(asJsonPrimitive2.getAsString());
            } else {
                if (!asJsonPrimitive2.isBoolean()) {
                    throw new JsonParseException("Unsupported array element type");
                }
                arrayList.add(Boolean.valueOf(asJsonPrimitive2.getAsBoolean()));
            }
        }
        return arrayList;
    }
}
