package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.ArrayDecoders;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T t, T t2);

    int getSerializedSize(T t);

    int hashCode(T t);

    boolean isInitialized(T t);

    void makeImmutable(T t);

    void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t, T t2);

    void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers);

    T newInstance();

    void writeTo(T t, Writer writer);
}
