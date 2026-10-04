package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface HttpData extends InterfaceHttpData, ByteBufHolder {
    void addContent(ByteBuf byteBuf, boolean z);

    void checkSize(long j);

    HttpData copy();

    long definedLength();

    void delete();

    HttpData duplicate();

    byte[] get();

    ByteBuf getByteBuf();

    Charset getCharset();

    ByteBuf getChunk(int i);

    File getFile();

    long getMaxSize();

    String getString();

    String getString(Charset charset);

    boolean isCompleted();

    boolean isInMemory();

    long length();

    boolean renameTo(File file);

    HttpData replace(ByteBuf byteBuf);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData retain(int i);

    HttpData retainedDuplicate();

    void setCharset(Charset charset);

    void setContent(ByteBuf byteBuf);

    void setContent(File file);

    void setContent(InputStream inputStream);

    void setMaxSize(long j);

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch();

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData, io.netty.util.ReferenceCounted
    HttpData touch(Object obj);
}
