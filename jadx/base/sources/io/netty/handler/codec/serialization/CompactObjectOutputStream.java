package io.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    public CompactObjectOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.ObjectOutputStream
    public void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> clsForClass = objectStreamClass.forClass();
        if (clsForClass.isPrimitive() || clsForClass.isArray() || clsForClass.isInterface() || objectStreamClass.getSerialVersionUID() == 0) {
            write(0);
            super.writeClassDescriptor(objectStreamClass);
        } else {
            write(1);
            writeUTF(objectStreamClass.getName());
        }
    }

    @Override // java.io.ObjectOutputStream
    public void writeStreamHeader() throws IOException {
        writeByte(5);
    }
}
