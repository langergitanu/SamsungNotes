package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
    private final MessageSizeEstimator.Handle handle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HandleImpl implements MessageSizeEstimator.Handle {
        private final int unknownSize;

        @Override // io.netty.channel.MessageSizeEstimator.Handle
        public int size(Object obj) {
            if (obj instanceof ByteBuf) {
                return ((ByteBuf) obj).readableBytes();
            }
            if (obj instanceof ByteBufHolder) {
                return ((ByteBufHolder) obj).content().readableBytes();
            }
            if (obj instanceof FileRegion) {
                return 0;
            }
            return this.unknownSize;
        }

        private HandleImpl(int i) {
            this.unknownSize = i;
        }
    }

    public DefaultMessageSizeEstimator(int i) {
        ObjectUtil.checkPositiveOrZero(i, "unknownSize");
        this.handle = new HandleImpl(i);
    }

    @Override // io.netty.channel.MessageSizeEstimator
    public MessageSizeEstimator.Handle newHandle() {
        return this.handle;
    }
}
