package io.grpc.netty;

import io.grpc.Internal;
import io.grpc.InternalChannelz;
import io.grpc.netty.NettySocketSupport;
import io.netty.channel.Channel;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalNettySocketSupport {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InternalHelper extends NettySocketSupport.Helper {
        @Override // io.grpc.netty.NettySocketSupport.Helper
        InternalNativeSocketOptions getNativeSocketOptions(Channel channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InternalNativeSocketOptions extends NettySocketSupport.NativeSocketOptions {
        public InternalNativeSocketOptions(InternalChannelz.TcpInfo tcpInfo, Map<String, String> map) {
            super(tcpInfo, map);
        }
    }

    private InternalNettySocketSupport() {
    }

    public static void setHelper(InternalHelper internalHelper) {
        NettySocketSupport.setHelper(internalHelper);
    }
}
