package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class AdapterMethodsFactory implements JsonAdapter.Factory {
    private final List<AdapterMethod> fromAdapters;
    private final List<AdapterMethod> toAdapters;

    public AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    public static AdapterMethod fromAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Set<? extends Annotation> setJsonAnnotations = Util.jsonAnnotations(method);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int length = genericParameterTypes.length;
        Class cls = Void.TYPE;
        if (length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != cls && parametersAreJsonAdapters(1, genericParameterTypes)) {
            return new AdapterMethod(genericReturnType, setJsonAnnotations, obj, method, genericParameterTypes.length, 1, true) { // from class: com.squareup.moshi.AdapterMethodsFactory.4
                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public Object fromJson(Moshi moshi, JsonReader jsonReader) {
                    return invoke(jsonReader);
                }
            };
        }
        if (genericParameterTypes.length == 1 && genericReturnType != cls) {
            final Set<? extends Annotation> setJsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            return new AdapterMethod(genericReturnType, setJsonAnnotations, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) { // from class: com.squareup.moshi.AdapterMethodsFactory.5
                JsonAdapter<Object> delegate;

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                    super.bind(moshi, factory);
                    this.delegate = (Types.equals(genericParameterTypes[0], genericReturnType) && setJsonAnnotations2.equals(setJsonAnnotations)) ? moshi.nextAdapter(factory, genericParameterTypes[0], setJsonAnnotations2) : moshi.adapter(genericParameterTypes[0], setJsonAnnotations2);
                }

                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public Object fromJson(Moshi moshi, JsonReader jsonReader) {
                    return invoke(this.delegate.fromJson(jsonReader));
                }
            };
        }
        throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
    }

    public static AdapterMethodsFactory get(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Method method : superclass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod adapter = toAdapter(obj, method);
                    AdapterMethod adapterMethod = get(arrayList, adapter.type, adapter.annotations);
                    if (adapterMethod != null) {
                        throw new IllegalArgumentException("Conflicting @ToJson methods:\n    " + adapterMethod.method + "\n    " + adapter.method);
                    }
                    arrayList.add(adapter);
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod adapterMethodFromAdapter = fromAdapter(obj, method);
                    AdapterMethod adapterMethod2 = get(arrayList2, adapterMethodFromAdapter.type, adapterMethodFromAdapter.annotations);
                    if (adapterMethod2 != null) {
                        throw new IllegalArgumentException("Conflicting @FromJson methods:\n    " + adapterMethod2.method + "\n    " + adapterMethodFromAdapter.method);
                    }
                    arrayList2.add(adapterMethodFromAdapter);
                }
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            throw new IllegalArgumentException("Expected at least one @ToJson or @FromJson method on ".concat(obj.getClass().getName()));
        }
        return new AdapterMethodsFactory(arrayList, arrayList2);
    }

    private static boolean parametersAreJsonAdapters(int i, Type[] typeArr) {
        int length = typeArr.length;
        while (i < length) {
            Type type = typeArr[i];
            if (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != JsonAdapter.class) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static AdapterMethod toAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int length = genericParameterTypes.length;
        Class cls = Void.TYPE;
        if (length >= 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == cls && parametersAreJsonAdapters(2, genericParameterTypes)) {
            return new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true) { // from class: com.squareup.moshi.AdapterMethodsFactory.2
                @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
                public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj2) {
                    invoke(jsonWriter, obj2);
                }
            };
        }
        if (genericParameterTypes.length != 1 || genericReturnType == cls) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        }
        final Set<? extends Annotation> setJsonAnnotations = Util.jsonAnnotations(method);
        final Set<? extends Annotation> setJsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
        return new AdapterMethod(genericParameterTypes[0], setJsonAnnotations2, obj, method, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) { // from class: com.squareup.moshi.AdapterMethodsFactory.3
            private JsonAdapter<Object> delegate;

            @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
            public void bind(Moshi moshi, JsonAdapter.Factory factory) {
                super.bind(moshi, factory);
                this.delegate = (Types.equals(genericParameterTypes[0], genericReturnType) && setJsonAnnotations2.equals(setJsonAnnotations)) ? moshi.nextAdapter(factory, genericReturnType, setJsonAnnotations) : moshi.adapter(genericReturnType, setJsonAnnotations);
            }

            @Override // com.squareup.moshi.AdapterMethodsFactory.AdapterMethod
            public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj2) {
                this.delegate.toJson(jsonWriter, invoke(obj2));
            }
        };
    }

    @Override // com.squareup.moshi.JsonAdapter.Factory
    @Nullable
    public JsonAdapter<?> create(final Type type, final Set<? extends Annotation> set, final Moshi moshi) {
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        JsonAdapter jsonAdapterNextAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapterNextAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException e) {
                StringBuilder sbM15l = AbstractC0000a.m15l("No ", adapterMethod == null ? "@ToJson" : "@FromJson", " adapter for ");
                sbM15l.append(Util.typeAnnotatedWithAnnotations(type, set));
                throw new IllegalArgumentException(sbM15l.toString(), e);
            }
        }
        final JsonAdapter jsonAdapter = jsonAdapterNextAdapter;
        if (adapterMethod != null) {
            adapterMethod.bind(moshi, this);
        }
        if (adapterMethod2 != null) {
            adapterMethod2.bind(moshi, this);
        }
        return new JsonAdapter<Object>() { // from class: com.squareup.moshi.AdapterMethodsFactory.1
            @Override // com.squareup.moshi.JsonAdapter
            @Nullable
            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod3 = adapterMethod2;
                if (adapterMethod3 == null) {
                    return jsonAdapter.fromJson(jsonReader);
                }
                if (!adapterMethod3.nullable && jsonReader.peek() == JsonReader.Token.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return adapterMethod2.fromJson(moshi, jsonReader);
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                }
            }

            @Override // com.squareup.moshi.JsonAdapter
            public void toJson(JsonWriter jsonWriter, @Nullable Object obj) throws IOException {
                AdapterMethod adapterMethod3 = adapterMethod;
                if (adapterMethod3 == null) {
                    jsonAdapter.toJson(jsonWriter, obj);
                    return;
                }
                if (!adapterMethod3.nullable && obj == null) {
                    jsonWriter.nullValue();
                    return;
                }
                try {
                    adapterMethod3.toJson(moshi, jsonWriter, obj);
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    }
                    throw new JsonDataException(cause + " at " + jsonWriter.getPath(), cause);
                }
            }

            public String toString() {
                return "JsonAdapter" + set + "(" + type + ")";
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AdapterMethod {
        final Object adapter;
        final int adaptersOffset;
        final Set<? extends Annotation> annotations;
        final JsonAdapter<?>[] jsonAdapters;
        final Method method;
        final boolean nullable;
        final Type type;

        public AdapterMethod(Type type, Set<? extends Annotation> set, Object obj, Method method, int i, int i2, boolean z) {
            this.type = Util.canonicalize(type);
            this.annotations = set;
            this.adapter = obj;
            this.method = method;
            this.adaptersOffset = i2;
            this.jsonAdapters = new JsonAdapter[i - i2];
            this.nullable = z;
        }

        public void bind(Moshi moshi, JsonAdapter.Factory factory) {
            if (this.jsonAdapters.length > 0) {
                Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i = this.adaptersOffset; i < length; i++) {
                    Type type = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments()[0];
                    Set<? extends Annotation> setJsonAnnotations = Util.jsonAnnotations(parameterAnnotations[i]);
                    this.jsonAdapters[i - this.adaptersOffset] = (Types.equals(this.type, type) && this.annotations.equals(setJsonAnnotations)) ? moshi.nextAdapter(factory, type, setJsonAnnotations) : moshi.adapter(type, setJsonAnnotations);
                }
            }
        }

        @Nullable
        public Object fromJson(Moshi moshi, JsonReader jsonReader) {
            throw new AssertionError();
        }

        @Nullable
        public Object invoke(@Nullable Object obj) {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[jsonAdapterArr.length + 1];
            objArr[0] = obj;
            System.arraycopy(jsonAdapterArr, 0, objArr, 1, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, @Nullable Object obj) {
            throw new AssertionError();
        }

        public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[jsonAdapterArr.length + 2];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(jsonAdapterArr, 0, objArr, 2, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }

    @Nullable
    private static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterMethod adapterMethod = list.get(i);
            if (Types.equals(adapterMethod.type, type) && adapterMethod.annotations.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }
}
