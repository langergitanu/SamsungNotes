package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.reflect.Type;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommonMoshiJsonAdapter {
    private final Moshi mMoshi = new Moshi.Builder().build();

    public <T> T fromJson(@NonNull String str, @NonNull Class<T> cls) {
        if (str == null) {
            throw new NullPointerException("json is marked non-null but is null");
        }
        if (cls == null) {
            throw new NullPointerException("classOfT is marked non-null but is null");
        }
        try {
            return this.mMoshi.adapter((Class) cls).fromJson(str);
        } catch (IOException e) {
            throw new TerminalException(e.getMessage(), e, ErrorStrings.JSON_DESERIALIZATION_FAILURE);
        }
    }

    public <T> String toJson(@NonNull T t) {
        if (t == null) {
            throw new NullPointerException("obj is marked non-null but is null");
        }
        return this.mMoshi.adapter((Type) t.getClass()).toJson(t);
    }
}
