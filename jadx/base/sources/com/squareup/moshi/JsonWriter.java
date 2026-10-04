package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class JsonWriter implements Closeable, Flushable {
    String indent;
    boolean lenient;
    boolean promoteValueToName;
    boolean serializeNulls;
    private Map<Class<?>, Object> tags;
    int stackSize = 0;
    int[] scopes = new int[32];
    String[] pathNames = new String[32];
    int[] pathIndices = new int[32];
    int flattenStackSize = -1;

    @CheckReturnValue
    /* JADX INFO: renamed from: of */
    public static JsonWriter m13162of(BufferedSink bufferedSink) {
        return new JsonUtf8Writer(bufferedSink);
    }

    public abstract JsonWriter beginArray();

    @CheckReturnValue
    public final int beginFlatten() {
        int iPeekScope = peekScope();
        if (iPeekScope != 5 && iPeekScope != 3 && iPeekScope != 2 && iPeekScope != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i = this.flattenStackSize;
        this.flattenStackSize = this.stackSize;
        return i;
    }

    public abstract JsonWriter beginObject();

    public final boolean checkStack() {
        int i = this.stackSize;
        int[] iArr = this.scopes;
        if (i != iArr.length) {
            return false;
        }
        if (i == 256) {
            throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
        }
        this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
        String[] strArr = this.pathNames;
        this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        int[] iArr2 = this.pathIndices;
        this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
        if (!(this instanceof JsonValueWriter)) {
            return true;
        }
        JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
        Object[] objArr = jsonValueWriter.stack;
        jsonValueWriter.stack = Arrays.copyOf(objArr, objArr.length * 2);
        return true;
    }

    public abstract JsonWriter endArray();

    public final void endFlatten(int i) {
        this.flattenStackSize = i;
    }

    public abstract JsonWriter endObject();

    @CheckReturnValue
    public final String getIndent() {
        String str = this.indent;
        return str != null ? str : "";
    }

    @CheckReturnValue
    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    @CheckReturnValue
    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    @CheckReturnValue
    public final boolean isLenient() {
        return this.lenient;
    }

    public final JsonWriter jsonValue(@Nullable Object obj) {
        if (obj instanceof Map) {
            beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw new IllegalArgumentException(key == null ? "Map keys must be non-null" : "Map keys must be of type String: ".concat(key.getClass().getName()));
                }
                name((String) key);
                jsonValue(entry.getValue());
            }
            endObject();
            return this;
        }
        if (obj instanceof List) {
            beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jsonValue(it.next());
            }
            endArray();
            return this;
        }
        if (obj instanceof String) {
            value((String) obj);
            return this;
        }
        if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
            return this;
        }
        if (obj instanceof Double) {
            value(((Double) obj).doubleValue());
            return this;
        }
        if (obj instanceof Long) {
            value(((Long) obj).longValue());
            return this;
        }
        if (obj instanceof Number) {
            value((Number) obj);
            return this;
        }
        if (obj != null) {
            throw new IllegalArgumentException("Unsupported type: ".concat(obj.getClass().getName()));
        }
        nullValue();
        return this;
    }

    public abstract JsonWriter name(String str);

    public abstract JsonWriter nullValue();

    public final int peekScope() {
        int i = this.stackSize;
        if (i != 0) {
            return this.scopes[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void promoteValueToName() {
        int iPeekScope = peekScope();
        if (iPeekScope != 5 && iPeekScope != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.promoteValueToName = true;
    }

    public final void pushScope(int i) {
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr[i2] = i;
    }

    public final void replaceTop(int i) {
        this.scopes[this.stackSize - 1] = i;
    }

    public void setIndent(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.indent = str;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
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

    @CheckReturnValue
    @Nullable
    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return (T) map.get(cls);
    }

    public abstract JsonWriter value(double d);

    public abstract JsonWriter value(long j);

    public abstract JsonWriter value(@Nullable Boolean bool);

    public abstract JsonWriter value(@Nullable Number number);

    public abstract JsonWriter value(@Nullable String str);

    public final JsonWriter value(BufferedSource bufferedSource) {
        if (this.promoteValueToName) {
            throw new IllegalStateException("BufferedSource cannot be used as a map key in JSON at path " + getPath());
        }
        BufferedSink bufferedSinkValueSink = valueSink();
        try {
            bufferedSource.readAll(bufferedSinkValueSink);
            if (bufferedSinkValueSink != null) {
                bufferedSinkValueSink.close();
            }
            return this;
        } catch (Throwable th) {
            if (bufferedSinkValueSink != null) {
                try {
                    bufferedSinkValueSink.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public abstract JsonWriter value(boolean z);

    @CheckReturnValue
    public abstract BufferedSink valueSink();
}
