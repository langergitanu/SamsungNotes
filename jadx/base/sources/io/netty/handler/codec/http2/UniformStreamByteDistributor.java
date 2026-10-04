package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class UniformStreamByteDistributor implements StreamByteDistributor {
    private final Http2Connection.PropertyKey stateKey;
    private long totalStreamableBytes;
    private final Deque<State> queue = new ArrayDeque(4);
    private int minAllocationChunk = 1024;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean enqueued;
        final Http2Stream stream;
        int streamableBytes;
        boolean windowNegative;
        boolean writing;

        public State(Http2Stream http2Stream) {
            this.stream = http2Stream;
        }

        public void addToQueue() {
            if (this.enqueued) {
                return;
            }
            this.enqueued = true;
            UniformStreamByteDistributor.this.queue.addLast(this);
        }

        public void close() {
            removeFromQueue();
            updateStreamableBytes(0, false, 0);
        }

        public void removeFromQueue() {
            if (this.enqueued) {
                this.enqueued = false;
                UniformStreamByteDistributor.this.queue.remove(this);
            }
        }

        public void updateStreamableBytes(int i, boolean z, int i2) {
            int i4 = i - this.streamableBytes;
            if (i4 != 0) {
                this.streamableBytes = i;
                UniformStreamByteDistributor.this.totalStreamableBytes += (long) i4;
            }
            this.windowNegative = i2 < 0;
            if (z) {
                if (i2 > 0 || (i2 == 0 && !this.writing)) {
                    addToQueue();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void write(int i, StreamByteDistributor.Writer writer) {
            this.writing = true;
            try {
                writer.write(this.stream, i);
            } finally {
            }
        }
    }

    public UniformStreamByteDistributor(Http2Connection http2Connection) {
        Http2Connection.PropertyKey propertyKeyNewKey = http2Connection.newKey();
        this.stateKey = propertyKeyNewKey;
        Http2Stream http2StreamConnectionStream = http2Connection.connectionStream();
        http2StreamConnectionStream.setProperty(propertyKeyNewKey, new State(http2StreamConnectionStream));
        http2Connection.addListener(new Http2ConnectionAdapter() { // from class: io.netty.handler.codec.http2.UniformStreamByteDistributor.1
            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamAdded(Http2Stream http2Stream) {
                http2Stream.setProperty(UniformStreamByteDistributor.this.stateKey, UniformStreamByteDistributor.this.new State(http2Stream));
            }

            @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
            public void onStreamClosed(Http2Stream http2Stream) {
                UniformStreamByteDistributor.this.state(http2Stream).close();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State state(Http2Stream http2Stream) {
        return (State) ((Http2Stream) ObjectUtil.checkNotNull(http2Stream, "stream")).getProperty(this.stateKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[EDGE_INSN: B:23:0x0051->B:19:0x0051 BREAK  A[LOOP:0: B:9:0x0024->B:25:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:0: B:9:0x0024->B:25:?, LOOP_END, SYNTHETIC] */
    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean distribute(int i, StreamByteDistributor.Writer writer) {
        int size = this.queue.size();
        if (size == 0) {
            return this.totalStreamableBytes > 0;
        }
        int iMax = Math.max(this.minAllocationChunk, i / size);
        State statePollFirst = this.queue.pollFirst();
        while (true) {
            statePollFirst.enqueued = false;
            if (!statePollFirst.windowNegative) {
                if (i == 0 && statePollFirst.streamableBytes > 0) {
                    this.queue.addFirst(statePollFirst);
                    statePollFirst.enqueued = true;
                    break;
                }
                int iMin = Math.min(iMax, Math.min(i, statePollFirst.streamableBytes));
                i -= iMin;
                statePollFirst.write(iMin, writer);
                statePollFirst = this.queue.pollFirst();
                if (statePollFirst != null) {
                    break;
                }
            } else {
                statePollFirst = this.queue.pollFirst();
                if (statePollFirst != null) {
                }
            }
        }
        return this.totalStreamableBytes > 0;
    }

    public void minAllocationChunk(int i) {
        ObjectUtil.checkPositive(i, "minAllocationChunk");
        this.minAllocationChunk = i;
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame(), streamState.windowSize());
    }

    @Override // io.netty.handler.codec.http2.StreamByteDistributor
    public void updateDependencyTree(int i, int i2, short s, boolean z) {
    }
}
