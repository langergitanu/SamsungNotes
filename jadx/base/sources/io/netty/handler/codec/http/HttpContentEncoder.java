package io.netty.handler.codec.http;

import com.google.api.client.http.HttpMethods;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class HttpContentEncoder extends MessageToMessageCodec<HttpRequest, HttpObject> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private EmbeddedChannel encoder;
    private static final CharSequence ZERO_LENGTH_HEAD = "HEAD";
    private static final CharSequence ZERO_LENGTH_CONNECT = HttpMethods.CONNECT;
    private final Queue<CharSequence> acceptEncodingQueue = new ArrayDeque();
    private State state = State.AWAIT_HEADERS;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.HttpContentEncoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125241 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State = iArr;
            try {
                iArr[State.AWAIT_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[State.AWAIT_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[State.PASS_THROUGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Result {
        private final EmbeddedChannel contentEncoder;
        private final String targetContentEncoding;

        public Result(String str, EmbeddedChannel embeddedChannel) {
            this.targetContentEncoding = (String) ObjectUtil.checkNotNull(str, "targetContentEncoding");
            this.contentEncoder = (EmbeddedChannel) ObjectUtil.checkNotNull(embeddedChannel, "contentEncoder");
        }

        public EmbeddedChannel contentEncoder() {
            return this.contentEncoder;
        }

        public String targetContentEncoding() {
            return this.targetContentEncoding;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        PASS_THROUGH,
        AWAIT_HEADERS,
        AWAIT_CONTENT
    }

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.encoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.encoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private boolean encodeContent(HttpContent httpContent, List<Object> list) {
        encode(httpContent.content(), list);
        if (!(httpContent instanceof LastHttpContent)) {
            return false;
        }
        finishEncode(list);
        HttpHeaders httpHeadersTrailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
        if (httpHeadersTrailingHeaders.isEmpty()) {
            list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            return true;
        }
        list.add(new ComposedLastHttpContent(httpHeadersTrailingHeaders, DecoderResult.SUCCESS));
        return true;
    }

    private void encodeFullResponse(HttpResponse httpResponse, HttpContent httpContent, List<Object> list) {
        encodeContent(httpContent, list);
        if (!HttpUtil.isContentLengthSet(httpResponse)) {
            httpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            return;
        }
        int i = 0;
        for (int size = list.size(); size < list.size(); size++) {
            Object obj = list.get(size);
            if (obj instanceof HttpContent) {
                i = ((HttpContent) obj).content().readableBytes() + i;
            }
        }
        HttpUtil.setContentLength(httpResponse, i);
    }

    private static void ensureContent(HttpObject httpObject) {
        if (httpObject instanceof HttpContent) {
            return;
        }
        throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: HttpContent)");
    }

    private static void ensureHeaders(HttpObject httpObject) {
        if (httpObject instanceof HttpResponse) {
            return;
        }
        throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: HttpResponse)");
    }

    private void fetchEncoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.encoder.readOutbound();
            if (byteBuf == null) {
                return;
            }
            if (byteBuf.isReadable()) {
                list.add(new DefaultHttpContent(byteBuf));
            } else {
                byteBuf.release();
            }
        }
    }

    private void finishEncode(List<Object> list) {
        if (this.encoder.finish()) {
            fetchEncoderOutput(list);
        }
        this.encoder = null;
    }

    private static boolean isPassthru(HttpVersion httpVersion, int i, CharSequence charSequence) {
        if (i < 200 || i == 204 || i == 304 || charSequence == ZERO_LENGTH_HEAD) {
            return true;
        }
        return (charSequence == ZERO_LENGTH_CONNECT && i == 200) || httpVersion == HttpVersion.HTTP_1_0;
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public boolean acceptOutboundMessage(Object obj) {
        return (obj instanceof HttpContent) || (obj instanceof HttpResponse);
    }

    public abstract Result beginEncode(HttpResponse httpResponse, String str);

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, List list) {
        decode2(channelHandlerContext, httpRequest, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) {
        encode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, List<Object> list) {
        List<String> all = httpRequest.headers().getAll(HttpHeaderNames.ACCEPT_ENCODING);
        int size = all.size();
        String strJoin = size != 0 ? size != 1 ? StringUtil.join(",", all) : all.get(0) : HttpContentDecoder.IDENTITY;
        HttpMethod httpMethodMethod = httpRequest.method();
        if (HttpMethod.HEAD.equals(httpMethodMethod)) {
            strJoin = ZERO_LENGTH_HEAD;
        } else if (HttpMethod.CONNECT.equals(httpMethodMethod)) {
            strJoin = ZERO_LENGTH_CONNECT;
        }
        this.acceptEncodingQueue.add(strJoin);
        list.add(ReferenceCountUtil.retain(httpRequest));
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) {
        CharSequence charSequencePoll;
        boolean z = (httpObject instanceof HttpResponse) && (httpObject instanceof LastHttpContent);
        int i = C125241.$SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[this.state.ordinal()];
        if (i == 1) {
            ensureHeaders(httpObject);
            HttpResponse httpResponse = (HttpResponse) httpObject;
            int iCode = httpResponse.status().code();
            if (httpResponse.status().codeClass() == HttpStatusClass.INFORMATIONAL) {
                charSequencePoll = null;
            } else {
                charSequencePoll = this.acceptEncodingQueue.poll();
                if (charSequencePoll == null) {
                    throw new IllegalStateException("cannot send more responses than requests");
                }
            }
            if (isPassthru(httpResponse.protocolVersion(), iCode, charSequencePoll)) {
                if (z) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                } else {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    this.state = State.PASS_THROUGH;
                    return;
                }
            }
            if (z && !((ByteBufHolder) httpResponse).content().isReadable()) {
                list.add(ReferenceCountUtil.retain(httpResponse));
                return;
            }
            Result resultBeginEncode = beginEncode(httpResponse, charSequencePoll.toString());
            if (resultBeginEncode == null) {
                if (z) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                } else {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    this.state = State.PASS_THROUGH;
                    return;
                }
            }
            this.encoder = resultBeginEncode.contentEncoder();
            httpResponse.headers().set(HttpHeaderNames.CONTENT_ENCODING, resultBeginEncode.targetContentEncoding());
            if (z) {
                DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                defaultHttpResponse.headers().set(httpResponse.headers());
                list.add(defaultHttpResponse);
                ensureContent(httpResponse);
                encodeFullResponse(defaultHttpResponse, (HttpContent) httpResponse, list);
                return;
            }
            httpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            httpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            list.add(ReferenceCountUtil.retain(httpResponse));
            this.state = State.AWAIT_CONTENT;
            if (!(httpObject instanceof HttpContent)) {
                return;
            }
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            ensureContent(httpObject);
            list.add(ReferenceCountUtil.retain(httpObject));
            if (httpObject instanceof LastHttpContent) {
                this.state = State.AWAIT_HEADERS;
                return;
            }
            return;
        }
        ensureContent(httpObject);
        if (encodeContent((HttpContent) httpObject, list)) {
            this.state = State.AWAIT_HEADERS;
        }
    }

    private void encode(ByteBuf byteBuf, List<Object> list) {
        this.encoder.writeOutbound(byteBuf.retain());
        fetchEncoderOutput(list);
    }
}
