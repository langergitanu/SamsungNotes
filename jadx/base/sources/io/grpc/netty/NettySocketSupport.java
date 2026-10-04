package io.grpc.netty;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.grpc.InternalChannelz;
import io.netty.channel.Channel;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class NettySocketSupport {
    private static volatile Helper instance = new NettySocketHelperImpl();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Helper {
        @Nullable
        NativeSocketOptions getNativeSocketOptions(Channel channel);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NativeSocketOptions {
        public final ImmutableMap<String, String> otherInfo;

        @Nullable
        public final InternalChannelz.TcpInfo tcpInfo;

        public NativeSocketOptions(InternalChannelz.TcpInfo tcpInfo, Map<String, String> map) {
            Preconditions.checkNotNull(map);
            this.tcpInfo = tcpInfo;
            this.otherInfo = ImmutableMap.copyOf((Map) map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NettySocketHelperImpl implements Helper {
        private NettySocketHelperImpl() {
        }

        @Override // io.grpc.netty.NettySocketSupport.Helper
        public NativeSocketOptions getNativeSocketOptions(Channel channel) {
            return null;
        }
    }

    public static NativeSocketOptions getNativeSocketOptions(Channel channel) {
        return instance.getNativeSocketOptions(channel);
    }

    public static void setHelper(Helper helper) {
        instance = (Helper) Preconditions.checkNotNull(helper);
    }
}
