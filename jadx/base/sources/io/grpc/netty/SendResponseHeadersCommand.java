package io.grpc.netty;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.Status;
import io.grpc.netty.WriteQueue;
import io.netty.handler.codec.http2.Http2Headers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class SendResponseHeadersCommand extends WriteQueue.AbstractQueuedCommand {
    private final Http2Headers headers;
    private final Status status;
    private final StreamIdHolder stream;

    private SendResponseHeadersCommand(StreamIdHolder streamIdHolder, Http2Headers http2Headers, Status status) {
        this.stream = (StreamIdHolder) Preconditions.checkNotNull(streamIdHolder, "stream");
        this.headers = (Http2Headers) Preconditions.checkNotNull(http2Headers, Contract.HEADERS);
        this.status = status;
    }

    public static SendResponseHeadersCommand createHeaders(StreamIdHolder streamIdHolder, Http2Headers http2Headers) {
        return new SendResponseHeadersCommand(streamIdHolder, http2Headers, null);
    }

    public static SendResponseHeadersCommand createTrailers(StreamIdHolder streamIdHolder, Http2Headers http2Headers, Status status) {
        return new SendResponseHeadersCommand(streamIdHolder, http2Headers, (Status) Preconditions.checkNotNull(status, "status"));
    }

    public boolean endOfStream() {
        return this.status != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(SendResponseHeadersCommand.class)) {
            SendResponseHeadersCommand sendResponseHeadersCommand = (SendResponseHeadersCommand) obj;
            if (sendResponseHeadersCommand.stream.equals(this.stream) && sendResponseHeadersCommand.headers.equals(this.headers) && sendResponseHeadersCommand.status.equals(this.status)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.stream, this.status);
    }

    public Http2Headers headers() {
        return this.headers;
    }

    public Status status() {
        return this.status;
    }

    public StreamIdHolder stream() {
        return this.stream;
    }

    public String toString() {
        return "SendResponseHeadersCommand(stream=" + this.stream.mo13754id() + ", headers=" + this.headers + ", status=" + this.status + ")";
    }
}
