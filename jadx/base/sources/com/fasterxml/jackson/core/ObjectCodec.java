package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectCodec {
    public abstract TreeNode createArrayNode();

    public abstract TreeNode createObjectNode();

    public JsonFactory getFactory() {
        return getJsonFactory();
    }

    @Deprecated
    public abstract JsonFactory getJsonFactory();

    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser);

    public abstract <T> T readValue(JsonParser jsonParser, ResolvedType resolvedType);

    public abstract <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference);

    public abstract <T> T readValue(JsonParser jsonParser, Class<T> cls);

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, ResolvedType resolvedType);

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, TypeReference<?> typeReference);

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls);

    public abstract JsonParser treeAsTokens(TreeNode treeNode);

    public abstract <T> T treeToValue(TreeNode treeNode, Class<T> cls);

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj);
}
