package com.google.api.client.json;

import com.google.api.client.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonFactory {
    private ByteArrayOutputStream toByteStream(Object obj, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator jsonGeneratorCreateJsonGenerator = createJsonGenerator(byteArrayOutputStream, Charsets.UTF_8);
        if (z) {
            jsonGeneratorCreateJsonGenerator.enablePrettyPrint();
        }
        jsonGeneratorCreateJsonGenerator.serialize(obj);
        jsonGeneratorCreateJsonGenerator.flush();
        return byteArrayOutputStream;
    }

    public abstract JsonGenerator createJsonGenerator(OutputStream outputStream, Charset charset);

    public abstract JsonGenerator createJsonGenerator(Writer writer);

    public final JsonObjectParser createJsonObjectParser() {
        return new JsonObjectParser(this);
    }

    public abstract JsonParser createJsonParser(InputStream inputStream);

    public abstract JsonParser createJsonParser(InputStream inputStream, Charset charset);

    public abstract JsonParser createJsonParser(Reader reader);

    public abstract JsonParser createJsonParser(String str);

    public final <T> T fromInputStream(InputStream inputStream, Class<T> cls) {
        return (T) createJsonParser(inputStream).parseAndClose((Class) cls);
    }

    public final <T> T fromReader(Reader reader, Class<T> cls) {
        return (T) createJsonParser(reader).parseAndClose((Class) cls);
    }

    public final <T> T fromString(String str, Class<T> cls) {
        return (T) createJsonParser(str).parse((Class) cls);
    }

    public final byte[] toByteArray(Object obj) {
        return toByteStream(obj, false).toByteArray();
    }

    public final String toPrettyString(Object obj) {
        return toString(obj, true);
    }

    public final String toString(Object obj) {
        return toString(obj, false);
    }

    private String toString(Object obj, boolean z) {
        return toByteStream(obj, z).toString("UTF-8");
    }

    public final <T> T fromInputStream(InputStream inputStream, Charset charset, Class<T> cls) {
        return (T) createJsonParser(inputStream, charset).parseAndClose((Class) cls);
    }
}
