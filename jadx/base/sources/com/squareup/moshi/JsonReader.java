package com.squareup.moshi;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class JsonReader implements Closeable {
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices;
    String[] pathNames;
    int[] scopes;
    int stackSize;
    private Map<Class<?>, Object> tags;

    /* JADX INFO: renamed from: com.squareup.moshi.JsonReader$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117411 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[Token.values().length];
            $SwitchMap$com$squareup$moshi$JsonReader$Token = iArr;
            try {
                iArr[Token.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$moshi$JsonReader$Token[Token.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        @CheckReturnValue
        /* JADX INFO: renamed from: of */
        public static Options m13161of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonUtf8Writer.string(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.m14404of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public List<String> strings() {
            return Collections.unmodifiableList(Arrays.asList(this.strings));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public JsonReader() {
        this.scopes = new int[32];
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
    }

    @CheckReturnValue
    /* JADX INFO: renamed from: of */
    public static JsonReader m13160of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    public abstract void beginArray();

    public abstract void beginObject();

    public abstract void endArray();

    public abstract void endObject();

    @CheckReturnValue
    public final boolean failOnUnknown() {
        return this.failOnUnknown;
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    @CheckReturnValue
    public abstract boolean hasNext();

    @CheckReturnValue
    public final boolean isLenient() {
        return this.lenient;
    }

    public abstract boolean nextBoolean();

    public abstract double nextDouble();

    public abstract int nextInt();

    public abstract long nextLong();

    @CheckReturnValue
    public abstract String nextName();

    @Nullable
    public abstract <T> T nextNull();

    public abstract BufferedSource nextSource();

    public abstract String nextString();

    @CheckReturnValue
    public abstract Token peek();

    @CheckReturnValue
    public abstract JsonReader peekJson();

    public abstract void promoteNameToValue();

    public final void pushScope(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.scopes;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.scopes;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr3[i4] = i;
    }

    @Nullable
    public final Object readJsonValue() {
        switch (C117411.$SwitchMap$com$squareup$moshi$JsonReader$Token[peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                beginArray();
                while (hasNext()) {
                    arrayList.add(readJsonValue());
                }
                endArray();
                return arrayList;
            case 2:
                LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
                beginObject();
                while (hasNext()) {
                    String strNextName = nextName();
                    Object jsonValue = readJsonValue();
                    Object objPut = linkedHashTreeMap.put(strNextName, jsonValue);
                    if (objPut != null) {
                        StringBuilder sbM15l = AbstractC0000a.m15l("Map key '", strNextName, "' has multiple values at path ");
                        sbM15l.append(getPath());
                        sbM15l.append(": ");
                        sbM15l.append(objPut);
                        sbM15l.append(" and ");
                        sbM15l.append(jsonValue);
                        throw new JsonDataException(sbM15l.toString());
                    }
                }
                endObject();
                return linkedHashTreeMap;
            case 3:
                return nextString();
            case 4:
                return Double.valueOf(nextDouble());
            case 5:
                return Boolean.valueOf(nextBoolean());
            case 6:
                return nextNull();
            default:
                throw new IllegalStateException("Expected a value but was " + peek() + " at path " + getPath());
        }
    }

    @CheckReturnValue
    public abstract int selectName(Options options);

    @CheckReturnValue
    public abstract int selectString(Options options);

    public final void setFailOnUnknown(boolean z) {
        this.failOnUnknown = z;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final <T> void setTag(Class<T> cls, T t) {
        if (!cls.isAssignableFrom(t.getClass())) {
            throw new IllegalArgumentException("Tag value must be of type ".concat(cls.getName()));
        }
        if (this.tags == null) {
            this.tags = new LinkedHashMap();
        }
        this.tags.put(cls, t);
    }

    public abstract void skipName();

    public abstract void skipValue();

    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " at path ");
        sbM781w.append(getPath());
        throw new JsonEncodingException(sbM781w.toString());
    }

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    public final JsonDataException typeMismatch(@Nullable Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + getPath());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + getPath());
    }

    public JsonReader(JsonReader jsonReader) {
        this.stackSize = jsonReader.stackSize;
        this.scopes = (int[]) jsonReader.scopes.clone();
        this.pathNames = (String[]) jsonReader.pathNames.clone();
        this.pathIndices = (int[]) jsonReader.pathIndices.clone();
        this.lenient = jsonReader.lenient;
        this.failOnUnknown = jsonReader.failOnUnknown;
    }
}
