package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class InternalAttribute extends AbstractReferenceCounted implements InterfaceHttpData {
    private final Charset charset;
    private int size;
    private final List<ByteBuf> value = new ArrayList();

    public InternalAttribute(Charset charset) {
        this.charset = charset;
    }

    public void addValue(String str) {
        ObjectUtil.checkNotNull(str, "value");
        ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(str, this.charset);
        this.value.add(byteBufCopiedBuffer);
        this.size = byteBufCopiedBuffer.readableBytes() + this.size;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalAttribute) {
            return getName().equalsIgnoreCase(((InternalAttribute) obj).getName());
        }
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.InternalAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return "InternalAttribute";
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public void setValue(String str, int i) {
        ObjectUtil.checkNotNull(str, "value");
        ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(str, this.charset);
        ByteBuf byteBuf = this.value.set(i, byteBufCopiedBuffer);
        if (byteBuf != null) {
            this.size -= byteBuf.readableBytes();
            byteBuf.release();
        }
        this.size = byteBufCopiedBuffer.readableBytes() + this.size;
    }

    public int size() {
        return this.size;
    }

    public ByteBuf toByteBuf() {
        return Unpooled.compositeBuffer().addComponents(this.value).writerIndex(size()).readerIndex(0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString(this.charset));
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof InternalAttribute) {
            return compareTo((InternalAttribute) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain() {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().retain();
        }
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData touch() {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().touch();
        }
        return this;
    }

    public void addValue(String str, int i) {
        ObjectUtil.checkNotNull(str, "value");
        ByteBuf byteBufCopiedBuffer = Unpooled.copiedBuffer(str, this.charset);
        this.value.add(i, byteBufCopiedBuffer);
        this.size = byteBufCopiedBuffer.readableBytes() + this.size;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public InterfaceHttpData retain(int i) {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().retain(i);
        }
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public InterfaceHttpData touch(Object obj) {
        Iterator<ByteBuf> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().touch(obj);
        }
        return this;
    }

    public int compareTo(InternalAttribute internalAttribute) {
        return getName().compareToIgnoreCase(internalAttribute.getName());
    }

    @Override // io.netty.util.AbstractReferenceCounted
    public void deallocate() {
    }
}
