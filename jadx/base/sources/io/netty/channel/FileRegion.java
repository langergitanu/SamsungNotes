package io.netty.channel;

import io.netty.util.ReferenceCounted;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface FileRegion extends ReferenceCounted {
    long count();

    long position();

    @Override // io.netty.util.ReferenceCounted
    FileRegion retain();

    @Override // io.netty.util.ReferenceCounted
    FileRegion retain(int i);

    @Override // io.netty.util.ReferenceCounted
    FileRegion touch();

    @Override // io.netty.util.ReferenceCounted
    FileRegion touch(Object obj);

    long transferTo(WritableByteChannel writableByteChannel, long j);

    @Deprecated
    long transfered();

    long transferred();
}
