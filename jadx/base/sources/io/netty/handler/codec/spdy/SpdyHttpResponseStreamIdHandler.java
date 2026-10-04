package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdyHttpResponseStreamIdHandler extends MessageToMessageCodec<Object, HttpMessage> {
    private static final Integer NO_ID = -1;
    private final Queue<Integer> ids = new ArrayDeque();

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public boolean acceptInboundMessage(Object obj) {
        return (obj instanceof HttpMessage) || (obj instanceof SpdyRstStreamFrame);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public void decode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
        if (obj instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) obj;
            HttpHeaders httpHeadersHeaders = httpMessage.headers();
            AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
            if (httpHeadersHeaders.contains(asciiString)) {
                this.ids.add(httpMessage.headers().getInt(asciiString));
            } else {
                this.ids.add(NO_ID);
            }
        } else if (obj instanceof SpdyRstStreamFrame) {
            this.ids.remove(Integer.valueOf(((SpdyRstStreamFrame) obj).streamId()));
        }
        list.add(ReferenceCountUtil.retain(obj));
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage, List list) {
        encode2(channelHandlerContext, httpMessage, (List<Object>) list);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage, List<Object> list) {
        Integer numPoll = this.ids.poll();
        if (numPoll != null && numPoll.intValue() != NO_ID.intValue()) {
            HttpHeaders httpHeadersHeaders = httpMessage.headers();
            AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
            if (!httpHeadersHeaders.contains(asciiString)) {
                httpMessage.headers().setInt(asciiString, numPoll.intValue());
            }
        }
        list.add(ReferenceCountUtil.retain(httpMessage));
    }
}
