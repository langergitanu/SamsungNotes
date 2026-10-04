package com.google.api.client.util;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ObjectParser {
    <T> T parseAndClose(InputStream inputStream, Charset charset, Class<T> cls);

    Object parseAndClose(InputStream inputStream, Charset charset, Type type);

    <T> T parseAndClose(Reader reader, Class<T> cls);

    Object parseAndClose(Reader reader, Type type);
}
