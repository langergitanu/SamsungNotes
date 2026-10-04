package io.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassResolver classResolver;

    public CompactObjectInputStream(InputStream inputStream, ClassResolver classResolver) {
        super(inputStream);
        this.classResolver = classResolver;
    }

    @Override // java.io.ObjectInputStream
    public ObjectStreamClass readClassDescriptor() throws IOException {
        int i = read();
        if (i < 0) {
            throw new EOFException();
        }
        if (i == 0) {
            return super.readClassDescriptor();
        }
        if (i != 1) {
            throw new StreamCorruptedException(AbstractC0000a.m11h(i, "Unexpected class descriptor type: "));
        }
        return ObjectStreamClass.lookupAny(this.classResolver.resolve(readUTF()));
    }

    @Override // java.io.ObjectInputStream
    public void readStreamHeader() throws StreamCorruptedException {
        int i = readByte() & 255;
        if (i != 5) {
            throw new StreamCorruptedException(AbstractC0000a.m11h(i, "Unsupported version: "));
        }
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return this.classResolver.resolve(objectStreamClass.getName());
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }
}
