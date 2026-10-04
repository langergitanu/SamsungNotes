package io.netty.handler.codec.http.multipart;

import androidx.compose.runtime.AbstractC1974b;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125401 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus */
        static final /* synthetic */ int[] f8897xeab8d0a3;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            f8897xeab8d0a3 = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8897xeab8d0a3[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UrlDecoder implements ByteProcessor {
        private byte hiByte;
        private int nextEscapedIdx;
        private final ByteBuf output;

        public UrlDecoder(ByteBuf byteBuf) {
            this.output = byteBuf;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            int i = this.nextEscapedIdx;
            if (i != 0) {
                if (i == 1) {
                    this.hiByte = b;
                    this.nextEscapedIdx = i + 1;
                } else {
                    int iDecodeHexNibble = StringUtil.decodeHexNibble((char) this.hiByte);
                    int iDecodeHexNibble2 = StringUtil.decodeHexNibble((char) b);
                    if (iDecodeHexNibble == -1 || iDecodeHexNibble2 == -1) {
                        this.nextEscapedIdx++;
                        return false;
                    }
                    this.output.writeByte((iDecodeHexNibble << 4) + iDecodeHexNibble2);
                    this.nextEscapedIdx = 0;
                }
            } else if (b == 37) {
                this.nextEscapedIdx = 1;
            } else if (b == 43) {
                this.output.writeByte(32);
            } else {
                this.output.writeByte(b);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UrlEncodedDetector implements ByteProcessor {
        private UrlEncodedDetector() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            return (b == 37 || b == 43) ? false : true;
        }

        public /* synthetic */ UrlEncodedDetector(C125401 c125401) {
            this();
        }
    }

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException("HttpPostStandardRequestDecoder was destroyed already");
        }
    }

    private static String decodeAttribute(String str, Charset charset) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset);
        } catch (IllegalArgumentException e) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(AbstractC1974b.m1315h('\'', "Bad string: '", str), e);
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        int i;
        boolean z;
        Attribute attribute;
        Attribute attribute2;
        int i2;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            return;
        }
        if (!byteBuf.hasArray()) {
            parseBodyAttributesStandard();
            return;
        }
        HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
        int i4 = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        loop0: while (true) {
            i = i4;
            while (true) {
                try {
                    int i5 = seekAheadOptimize.pos;
                    z = true;
                    if (i5 >= seekAheadOptimize.limit) {
                        break loop0;
                    }
                    byte[] bArr = seekAheadOptimize.bytes;
                    seekAheadOptimize.pos = i5 + 1;
                    char c = (char) (bArr[i5] & 255);
                    i2 = i4 + 1;
                    int i6 = C125401.f8897xeab8d0a3[this.currentStatus.ordinal()];
                    if (i6 != 1) {
                        if (i6 != 2) {
                            seekAheadOptimize.setReadPosition(0);
                            i4 = i2;
                            break loop0;
                        }
                        if (c == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            setFinalBuffer(this.undecodedChunk.retainedSlice(i, i4 - i));
                            break;
                        }
                        if (c == '\r') {
                            int i7 = seekAheadOptimize.pos;
                            int i8 = seekAheadOptimize.limit;
                            if (i7 < i8) {
                                byte[] bArr2 = seekAheadOptimize.bytes;
                                seekAheadOptimize.pos = i7 + 1;
                                char c2 = (char) (bArr2[i7] & 255);
                                i2 = i4 + 2;
                                if (c2 != '\n') {
                                    seekAheadOptimize.setReadPosition(0);
                                    throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                }
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, i4 - i));
                            } else if (i8 <= 0) {
                                i4 = i2;
                            }
                        } else {
                            if (c == '\n') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, i4 - i));
                                break loop0;
                            }
                            i4 = i2;
                        }
                    } else {
                        if (c == '=') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                            this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i, i4 - i, this.charset), this.charset));
                            break;
                        }
                        if (c == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i, i4 - i, this.charset), this.charset);
                            if (!strDecodeAttribute.isEmpty()) {
                                Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                                this.currentAttribute = attributeCreateAttribute;
                                attributeCreateAttribute.setValue("");
                                addHttpData(this.currentAttribute);
                            }
                            this.currentAttribute = null;
                        }
                        i4 = i2;
                    }
                } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                }
            }
            i4 = i2;
        }
        i4 = i2;
        i = i4;
        z = false;
        if (!this.isLastChunk || (attribute2 = this.currentAttribute) == null) {
            if (z && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                attribute.addContent(this.undecodedChunk.retainedSlice(i, i4 - i), false);
            }
            this.undecodedChunk.readerIndex(i);
        }
        if (i4 > i) {
            setFinalBuffer(this.undecodedChunk.retainedSlice(i, i4 - i));
        } else if (!attribute2.isCompleted()) {
            setFinalBuffer(Unpooled.EMPTY_BUFFER);
        }
        try {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        } catch (HttpPostRequestDecoder.ErrorDataDecoderException e5) {
            e = e5;
            i = i4;
            this.undecodedChunk.readerIndex(i);
            throw e;
        } catch (IOException e6) {
            e = e6;
            i = i4;
            this.undecodedChunk.readerIndex(i);
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
        } catch (IllegalArgumentException e7) {
            e = e7;
            i = i4;
            this.undecodedChunk.readerIndex(i);
            throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
        }
        i = i4;
        this.undecodedChunk.readerIndex(i);
    }

    private void parseBodyAttributesStandard() {
        Attribute attribute;
        Attribute attribute2;
        int i = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        int i2 = i;
        boolean z = true;
        while (this.undecodedChunk.isReadable() && z) {
            try {
                char unsignedByte = (char) this.undecodedChunk.readUnsignedByte();
                int i4 = i + 1;
                int i5 = C125401.f8897xeab8d0a3[this.currentStatus.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        z = false;
                    } else if (unsignedByte == '&') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                        z = true;
                        i = i4;
                        i2 = i;
                    } else if (unsignedByte == '\r') {
                        if (this.undecodedChunk.isReadable()) {
                            int i6 = i + 2;
                            if (((char) this.undecodedChunk.readUnsignedByte()) != '\n') {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                            }
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                            setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                            i = i6;
                            i2 = i;
                            z = false;
                        } else {
                            continue;
                        }
                    } else if (unsignedByte == '\n') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                        z = false;
                        i = i4;
                        i2 = i;
                    }
                    i = i4;
                } else if (unsignedByte == '=') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                    this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset));
                    i = i4;
                    i2 = i;
                } else if (unsignedByte == '&') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                    String strDecodeAttribute = decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset);
                    if (!strDecodeAttribute.isEmpty()) {
                        Attribute attributeCreateAttribute = this.factory.createAttribute(this.request, strDecodeAttribute);
                        this.currentAttribute = attributeCreateAttribute;
                        attributeCreateAttribute.setValue("");
                        addHttpData(this.currentAttribute);
                    }
                    this.currentAttribute = null;
                    z = true;
                    i = i4;
                    i2 = i;
                } else {
                    i = i4;
                }
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            } catch (IllegalArgumentException e3) {
                e = e3;
            }
        }
        if (this.isLastChunk && (attribute2 = this.currentAttribute) != null) {
            if (i > i2) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
            } else if (!attribute2.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e5) {
                i2 = i;
                e = e5;
                this.undecodedChunk.readerIndex(i2);
                throw e;
            } catch (IOException e6) {
                i2 = i;
                e = e6;
                this.undecodedChunk.readerIndex(i2);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
            } catch (IllegalArgumentException e7) {
                i2 = i;
                e = e7;
                this.undecodedChunk.readerIndex(i2);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e);
            }
        } else if (z && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
            attribute.addContent(this.undecodedChunk.retainedSlice(i2, i - i2), false);
        } else {
            i = i2;
        }
        this.undecodedChunk.readerIndex(i);
    }

    private void setFinalBuffer(ByteBuf byteBuf) {
        this.currentAttribute.addContent(byteBuf, true);
        ByteBuf byteBufDecodeAttribute = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
        if (byteBufDecodeAttribute != null) {
            this.currentAttribute.setContent(byteBufDecodeAttribute);
        }
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
    }

    public void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData == null) {
            return;
        }
        List<InterfaceHttpData> arrayList = this.bodyMapHttpData.get(interfaceHttpData.getName());
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.bodyMapHttpData.put(interfaceHttpData.getName(), arrayList);
        }
        arrayList.add(interfaceHttpData);
        this.bodyListHttpData.add(interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        return this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        cleanFiles();
        for (InterfaceHttpData interfaceHttpData : this.bodyListHttpData) {
            if (interfaceHttpData.refCnt() > 0) {
                interfaceHttpData.release();
            }
        }
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null || byteBuf.refCnt() <= 0) {
            return;
        }
        this.undecodedChunk.release();
        this.undecodedChunk = null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (!this.isLastChunk) {
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        }
        List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (!hasNext()) {
            return null;
        }
        List<InterfaceHttpData> list = this.bodyListHttpData;
        int i = this.bodyListHttpDataRank;
        this.bodyListHttpDataRank = i + 1;
        return list.get(i);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i, "discardThreshold");
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        ByteBuf byteBufContent = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = byteBufContent.alloc().buffer(byteBufContent.readableBytes()).writeBytes(byteBufContent);
        } else {
            byteBuf.writeBytes(byteBufContent);
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            if (this.undecodedChunk.refCnt() == 1) {
                this.undecodedChunk.discardReadBytes();
                return this;
            }
            ByteBuf byteBufBuffer = this.undecodedChunk.alloc().buffer(this.undecodedChunk.readableBytes());
            byteBufBuffer.writeBytes(this.undecodedChunk);
            this.undecodedChunk.release();
            this.undecodedChunk = byteBufBuffer;
        }
        return this;
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) throws Throwable {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = MediaHttpUploader.DEFAULT_CHUNK_SIZE;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        try {
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
            } else {
                parseBody();
            }
        } catch (Throwable th) {
            destroy();
            PlatformDependent.throwException(th);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    private static ByteBuf decodeAttribute(ByteBuf byteBuf, Charset charset) {
        if (byteBuf.forEachByte(new UrlEncodedDetector(null)) == -1) {
            return null;
        }
        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(byteBuf.readableBytes());
        UrlDecoder urlDecoder = new UrlDecoder(byteBufBuffer);
        int iForEachByte = byteBuf.forEachByte(urlDecoder);
        if (urlDecoder.nextEscapedIdx == 0) {
            return byteBufBuffer;
        }
        if (iForEachByte == -1) {
            iForEachByte = byteBuf.readableBytes() - 1;
        }
        int i = iForEachByte - (urlDecoder.nextEscapedIdx - 1);
        byteBufBuffer.release();
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", Integer.valueOf(i), byteBuf.toString(charset)));
    }
}
