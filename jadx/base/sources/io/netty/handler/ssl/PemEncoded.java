package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
interface PemEncoded extends ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded copy();

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded duplicate();

    boolean isSensitive();

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded replace(ByteBuf byteBuf);

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded retain();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    PemEncoded retainedDuplicate();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded touch();

    @Override // io.netty.buffer.ByteBufHolder, io.netty.util.ReferenceCounted
    PemEncoded touch(Object obj);
}
