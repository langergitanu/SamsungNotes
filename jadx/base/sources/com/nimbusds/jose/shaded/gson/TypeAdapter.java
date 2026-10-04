package com.nimbusds.jose.shaded.gson;

import com.nimbusds.jose.shaded.gson.internal.bind.JsonTreeReader;
import com.nimbusds.jose.shaded.gson.internal.bind.JsonTreeWriter;
import com.nimbusds.jose.shaded.gson.stream.JsonReader;
import com.nimbusds.jose.shaded.gson.stream.JsonToken;
import com.nimbusds.jose.shaded.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) {
        return read2(new JsonReader(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read2(new JsonTreeReader(jsonElement));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.nimbusds.jose.shaded.gson.TypeAdapter.1
            @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
            /* JADX INFO: renamed from: read */
            public T read2(JsonReader jsonReader) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return (T) TypeAdapter.this.read2(jsonReader);
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.nimbusds.jose.shaded.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    TypeAdapter.this.write(jsonWriter, t);
                }
            }
        };
    }

    /* JADX INFO: renamed from: read */
    public abstract T read2(JsonReader jsonReader);

    public final void toJson(Writer writer, T t) {
        write(new JsonWriter(writer), t);
    }

    public final JsonElement toJsonTree(T t) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, t);
            return jsonTreeWriter.get();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t);

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
