package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class JsonParser {
    private static final Logger logger = Logger.getLogger(JsonParser.class.getName());

    /* JADX INFO: renamed from: io.grpc.internal.JsonParser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C121651 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private JsonParser() {
    }

    public static Object parse(String str) {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            Object recursive = parseRecursive(jsonReader);
            try {
                return recursive;
            } catch (IOException e) {
                return recursive;
            }
        } finally {
            try {
                jsonReader.close();
            } catch (IOException e2) {
                logger.log(Level.WARNING, "Failed to close", (Throwable) e2);
            }
        }
    }

    private static List<?> parseJsonArray(JsonReader jsonReader) {
        jsonReader.beginArray();
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            arrayList.add(parseRecursive(jsonReader));
        }
        Preconditions.checkState(jsonReader.peek() == JsonToken.END_ARRAY, "Bad token: " + jsonReader.getPath());
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    private static Void parseJsonNull(JsonReader jsonReader) {
        jsonReader.nextNull();
        return null;
    }

    private static Map<String, ?> parseJsonObject(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), parseRecursive(jsonReader));
        }
        Preconditions.checkState(jsonReader.peek() == JsonToken.END_OBJECT, "Bad token: " + jsonReader.getPath());
        jsonReader.endObject();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Object parseRecursive(JsonReader jsonReader) {
        Preconditions.checkState(jsonReader.hasNext(), "unexpected end of JSON");
        switch (C121651.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                return parseJsonArray(jsonReader);
            case 2:
                return parseJsonObject(jsonReader);
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                return parseJsonNull(jsonReader);
            default:
                throw new IllegalStateException("Bad token: " + jsonReader.getPath());
        }
    }
}
