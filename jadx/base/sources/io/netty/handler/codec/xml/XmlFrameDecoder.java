package io.netty.handler.codec.xml;

import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class XmlFrameDecoder extends ByteToMessageDecoder {
    private final int maxFrameLength;

    public XmlFrameDecoder(int i) {
        this.maxFrameLength = ObjectUtil.checkPositive(i, "maxFrameLength");
    }

    private static ByteBuf extractFrame(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.copy(i, i2);
    }

    private void fail(long j) {
        if (j <= 0) {
            throw new TooLongFrameException(AbstractC2821a.m2223n(new StringBuilder("frame length exceeds "), " - discarding", this.maxFrameLength));
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
    }

    private static boolean isCDATABlockStart(ByteBuf byteBuf, int i) {
        return i < byteBuf.writerIndex() + (-8) && byteBuf.getByte(i + 2) == 91 && byteBuf.getByte(i + 3) == 67 && byteBuf.getByte(i + 4) == 68 && byteBuf.getByte(i + 5) == 65 && byteBuf.getByte(i + 6) == 84 && byteBuf.getByte(i + 7) == 65 && byteBuf.getByte(i + 8) == 91;
    }

    private static boolean isCommentBlockStart(ByteBuf byteBuf, int i) {
        return i < byteBuf.writerIndex() + (-3) && byteBuf.getByte(i + 2) == 45 && byteBuf.getByte(i + 3) == 45;
    }

    private static boolean isValidStartCharForXmlElement(byte b) {
        if (b < 97 || b > 122) {
            return (b >= 65 && b <= 90) || b == 58 || b == 95;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        long j;
        int i;
        int i2;
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex > this.maxFrameLength) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            fail(iWriterIndex);
            return;
        }
        int i4 = byteBuf.readerIndex();
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        long j2 = 0;
        int i6 = 0;
        boolean z3 = false;
        while (true) {
            if (i4 >= iWriterIndex) {
                j = 0;
                break;
            }
            byte b = byteBuf.getByte(i4);
            if (!z && Character.isWhitespace(b)) {
                i5++;
            } else {
                if (!z && b != 60) {
                    fail(channelHandlerContext);
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                }
                j = 0;
                if (!z2 && b == 60) {
                    int i7 = iWriterIndex - 1;
                    if (i4 < i7) {
                        byte b5 = byteBuf.getByte(i4 + 1);
                        if (b5 == 47) {
                            int i8 = i4 + 2;
                            while (true) {
                                if (i8 > i7) {
                                    break;
                                }
                                if (byteBuf.getByte(i8) == 62) {
                                    j2--;
                                    break;
                                }
                                i8++;
                            }
                        } else if (isValidStartCharForXmlElement(b5)) {
                            j2++;
                            z3 = true;
                        } else if (b5 == 33) {
                            if (isCommentBlockStart(byteBuf, i4)) {
                                j2++;
                            } else if (isCDATABlockStart(byteBuf, i4)) {
                                j2++;
                                z2 = true;
                            }
                        } else if (b5 == 63) {
                        }
                    }
                    z = true;
                } else if (z2 || b != 47) {
                    if (b == 62) {
                        i6 = i4 + 1;
                        int i9 = i4 - 1;
                        if (i9 > -1) {
                            byte b6 = byteBuf.getByte(i9);
                            if (z2) {
                                if (b6 == 93 && i4 - 2 > -1 && byteBuf.getByte(i) == 93) {
                                    j2--;
                                    z2 = false;
                                }
                            } else if (b6 == 63 || (b6 == 45 && i4 - 2 > -1 && byteBuf.getByte(i2) == 45)) {
                                j2--;
                            }
                        }
                        if (z3 && j2 == 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (i4 < iWriterIndex - 1 && byteBuf.getByte(i4 + 1) == 62) {
                    j2--;
                }
            }
            i4++;
        }
        int i10 = byteBuf.readerIndex();
        int i11 = i6 - i10;
        if (j2 != j || i11 <= 0) {
            return;
        }
        if (i10 + i11 >= iWriterIndex) {
            i11 = byteBuf.readableBytes();
        }
        ByteBuf byteBufExtractFrame = extractFrame(byteBuf, i10 + i5, i11 - i5);
        byteBuf.skipBytes(i11);
        list.add(byteBufExtractFrame);
    }

    private static void fail(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireExceptionCaught((Throwable) new CorruptedFrameException("frame contains content before the xml starts"));
    }
}
