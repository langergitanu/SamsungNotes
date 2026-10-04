package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class ArrayJsonAdapter extends JsonAdapter<Object> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.ArrayJsonAdapter.1
        @Override // com.squareup.moshi.JsonAdapter.Factory
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Type typeArrayComponentType = Types.arrayComponentType(type);
            if (typeArrayComponentType != null && set.isEmpty()) {
                return new ArrayJsonAdapter(Types.getRawType(typeArrayComponentType), moshi.adapter(typeArrayComponentType)).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    public ArrayJsonAdapter(Class<?> cls, JsonAdapter<Object> jsonAdapter) {
        this.elementClass = cls;
        this.elementAdapter = jsonAdapter;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public Object fromJson(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        Object objNewInstance = Array.newInstance(this.elementClass, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, Object obj) {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.elementAdapter.toJson(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }

    public String toString() {
        return this.elementAdapter + ".array()";
    }
}
