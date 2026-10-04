package com.microsoft.identity.common.java.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.logging.Logger;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import kotlin.text.Typography;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ObjectMapper {
    public static final String ENCODING_SCHEME = "UTF-8";
    public static final Gson GSON = new GsonBuilder().registerTypeAdapterFactory(new UnknownParamTypeAdapterFactory()).create();
    public static final String TAG = "ObjectMapper";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnknownParamTypeAdapterFactory implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
            if (IHasExtraParameters.class.isAssignableFrom(typeToken.getRawType())) {
                return new TypeAdapter<T>() { // from class: com.microsoft.identity.common.java.util.ObjectMapper.UnknownParamTypeAdapterFactory.1
                    @Override // com.google.gson.TypeAdapter
                    /* JADX INFO: renamed from: read */
                    public T read2(final JsonReader jsonReader) {
                        final LinkedHashMap linkedHashMap = new LinkedHashMap();
                        T t = (T) delegateAdapter.read2(new JsonReader(new Reader() { // from class: com.microsoft.identity.common.java.util.ObjectMapper.UnknownParamTypeAdapterFactory.1.1
                            @Override // java.io.Reader
                            public int read(char[] cArr, int i, int i2) {
                                return 0;
                            }

                            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
                            public void close() {
                            }
                        }) { // from class: com.microsoft.identity.common.java.util.ObjectMapper.UnknownParamTypeAdapterFactory.1.2
                            String lastName = null;

                            @Override // com.google.gson.stream.JsonReader
                            public void beginArray() {
                                jsonReader.beginArray();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public void beginObject() throws IOException {
                                jsonReader.beginObject();
                            }

                            @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
                            public void close() throws IOException {
                                jsonReader.close();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public void endArray() {
                                jsonReader.endArray();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public void endObject() throws IOException {
                                jsonReader.endObject();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public String getPath() {
                                return jsonReader.getPath();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public boolean hasNext() {
                                return jsonReader.hasNext();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public boolean nextBoolean() {
                                return jsonReader.nextBoolean();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public double nextDouble() {
                                return jsonReader.nextDouble();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public int nextInt() {
                                return jsonReader.nextInt();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public long nextLong() {
                                return jsonReader.nextLong();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public String nextName() throws IOException {
                                String strNextName = jsonReader.nextName();
                                this.lastName = strNextName;
                                return strNextName;
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public void nextNull() {
                                jsonReader.nextNull();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public String nextString() {
                                return jsonReader.nextString();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public JsonToken peek() {
                                return jsonReader.peek();
                            }

                            @Override // com.google.gson.stream.JsonReader
                            public void skipValue() throws IOException {
                                if (jsonReader.peek() == JsonToken.STRING) {
                                    linkedHashMap.put(this.lastName, jsonReader.nextString());
                                } else {
                                    jsonReader.skipValue();
                                }
                            }

                            @Override // com.google.gson.stream.JsonReader
                            @NonNull
                            public String toString() {
                                return jsonReader.toString();
                            }
                        });
                        ((IHasExtraParameters) t).setExtraParameters(Collections.unmodifiableMap(linkedHashMap).entrySet());
                        return t;
                    }

                    @Override // com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, T t) {
                        delegateAdapter.write(jsonWriter, t);
                    }
                };
            }
            return null;
        }
    }

    private ObjectMapper() {
    }

    public static Map<String, String> constructMapFromObject(Object obj) {
        Iterable<Map.Entry<String, String>> extraParameters;
        TreeMap treeMap = (TreeMap) new Gson().fromJson(serializeObjectToJsonString(obj), TypeToken.getParameterized(TreeMap.class, String.class, String.class).getType());
        if ((obj instanceof IHasExtraParameters) && (extraParameters = ((IHasExtraParameters) obj).getExtraParameters()) != null) {
            for (Map.Entry<String, String> entry : extraParameters) {
                if (entry.getKey() != null) {
                    treeMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return treeMap;
    }

    public static <T> T deserializeJsonStringToObject(String str, Class<T> cls) {
        return (T) GSON.fromJson(str, (Class) cls);
    }

    public static Map<String, String> deserializeQueryStringToMap(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!StringUtil.isNullOrEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, MsalUtils.QUERY_STRING_DELIMITER);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().split(MarketingConstants.REFERRER_DELIMITER_U003D);
                if (strArrSplit.length == 2) {
                    try {
                        String strDecode = URLDecoder.decode(strArrSplit[0], "UTF-8");
                        String strDecode2 = URLDecoder.decode(strArrSplit[1], "UTF-8");
                        if (!StringUtil.isNullOrEmpty(strDecode) && !StringUtil.isNullOrEmpty(strDecode2)) {
                            linkedHashMap.put(strDecode, strDecode2);
                        }
                    } catch (UnsupportedEncodingException e) {
                        Logger.error(TAG, null, "Decode failed.", e);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static String serializeExposedFieldsOfObjectToJsonString(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        return gsonBuilder.create().toJson(obj);
    }

    public static Map<String, Object> serializeObjectHashMap(Object obj) {
        return (Map) GSON.fromJson(serializeObjectToJsonString(obj), Map.class);
    }

    public static String serializeObjectToFormUrlEncoded(Object obj) {
        Map<String, String> mapConstructMapFromObject = constructMapFromObject(obj);
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = mapConstructMapFromObject.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(URLEncoder.encode(next.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
            if (it.hasNext()) {
                sb.append(Typography.amp);
            }
        }
        return sb.toString();
    }

    public static String serializeObjectToJsonString(Object obj) {
        return GSON.toJson(obj);
    }
}
