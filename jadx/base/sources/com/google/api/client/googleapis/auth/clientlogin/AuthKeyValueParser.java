package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
final class AuthKeyValueParser implements ObjectParser {
    public static final AuthKeyValueParser INSTANCE = new AuthKeyValueParser();

    private AuthKeyValueParser() {
    }

    public String getContentType() {
        return "text/plain";
    }

    public <T> T parse(HttpResponse httpResponse, Class<T> cls) throws IOException {
        httpResponse.setContentLoggingLimit(0);
        InputStream content = httpResponse.getContent();
        try {
            return (T) parse(content, cls);
        } finally {
            content.close();
        }
    }

    @Override // com.google.api.client.util.ObjectParser
    public <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls) {
        return (T) parseAndClose((Reader) new InputStreamReader(inputStream, charset), (Class) cls);
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(InputStream inputStream, Charset charset, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.api.client.util.ObjectParser
    public <T> T parseAndClose(Reader reader, Class<T> cls) throws IOException {
        Object objValueOf;
        try {
            ClassInfo classInfoM4224of = ClassInfo.m4224of(cls);
            T t = (T) Types.newInstance(cls);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    reader.close();
                    return t;
                }
                int iIndexOf = line.indexOf(61);
                String strSubstring = line.substring(0, iIndexOf);
                String strSubstring2 = line.substring(iIndexOf + 1);
                Field field = classInfoM4224of.getField(strSubstring);
                if (field != null) {
                    Class<?> type = field.getType();
                    if (type == Boolean.TYPE) {
                        objValueOf = Boolean.valueOf(strSubstring2);
                        FieldInfo.setFieldValue(field, t, objValueOf);
                    } else {
                        objValueOf = strSubstring2;
                        if (type == Boolean.class) {
                            objValueOf = Boolean.valueOf(strSubstring2);
                        }
                        FieldInfo.setFieldValue(field, t, objValueOf);
                    }
                } else if (GenericData.class.isAssignableFrom(cls)) {
                    ((GenericData) t).set(strSubstring, strSubstring2);
                } else if (Map.class.isAssignableFrom(cls)) {
                    ((Map) t).put(strSubstring, strSubstring2);
                }
            }
        } catch (Throwable th) {
            reader.close();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T parse(InputStream inputStream, Class<T> cls) throws IOException {
        ClassInfo classInfoM4224of = ClassInfo.m4224of(cls);
        T t = (T) Types.newInstance(cls);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return t;
            }
            int iIndexOf = line.indexOf(61);
            String strSubstring = line.substring(0, iIndexOf);
            String strSubstring2 = line.substring(iIndexOf + 1);
            Field field = classInfoM4224of.getField(strSubstring);
            if (field != null) {
                Class<?> type = field.getType();
                if (type != Boolean.TYPE) {
                    Object objValueOf = strSubstring2;
                    if (type == Boolean.class) {
                        objValueOf = Boolean.valueOf(strSubstring2);
                    }
                    FieldInfo.setFieldValue(field, t, objValueOf);
                }
            } else if (GenericData.class.isAssignableFrom(cls)) {
                ((GenericData) t).set(strSubstring, strSubstring2);
            } else if (Map.class.isAssignableFrom(cls)) {
                ((Map) t).put(strSubstring, strSubstring2);
            }
        }
    }

    @Override // com.google.api.client.util.ObjectParser
    public Object parseAndClose(Reader reader, Type type) {
        throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
    }
}
