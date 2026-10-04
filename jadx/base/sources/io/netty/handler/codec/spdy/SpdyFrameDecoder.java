package io.netty.handler.codec.spdy;

import androidx.compose.p109ui.layout.LayoutKt;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SpdyFrameDecoder {
    private final SpdyFrameDecoderDelegate delegate;
    private byte flags;
    private int length;
    private final int maxChunkSize;
    private int numSettings;
    private final int spdyVersion;
    private State state;
    private int streamId;

    /* JADX INFO: renamed from: io.netty.handler.codec.spdy.SpdyFrameDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C126531 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State = iArr;
            try {
                iArr[State.READ_COMMON_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_DATA_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_STREAM_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SYN_REPLY_FRAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_RST_STREAM_FRAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTINGS_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_SETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_PING_FRAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_GOAWAY_FRAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADERS_FRAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_WINDOW_UPDATE_FRAME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.READ_HEADER_BLOCK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.DISCARD_FRAME.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[State.FRAME_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        READ_COMMON_HEADER,
        READ_DATA_FRAME,
        READ_SYN_STREAM_FRAME,
        READ_SYN_REPLY_FRAME,
        READ_RST_STREAM_FRAME,
        READ_SETTINGS_FRAME,
        READ_SETTING,
        READ_PING_FRAME,
        READ_GOAWAY_FRAME,
        READ_HEADERS_FRAME,
        READ_WINDOW_UPDATE_FRAME,
        READ_HEADER_BLOCK,
        DISCARD_FRAME,
        FRAME_ERROR
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate) {
        this(spdyVersion, spdyFrameDecoderDelegate, 8192);
    }

    private static State getNextState(int i, int i2) {
        switch (i) {
            case 0:
                return State.READ_DATA_FRAME;
            case 1:
                return State.READ_SYN_STREAM_FRAME;
            case 2:
                return State.READ_SYN_REPLY_FRAME;
            case 3:
                return State.READ_RST_STREAM_FRAME;
            case 4:
                return State.READ_SETTINGS_FRAME;
            case 5:
            default:
                return i2 != 0 ? State.DISCARD_FRAME : State.READ_COMMON_HEADER;
            case 6:
                return State.READ_PING_FRAME;
            case 7:
                return State.READ_GOAWAY_FRAME;
            case 8:
                return State.READ_HEADERS_FRAME;
            case 9:
                return State.READ_WINDOW_UPDATE_FRAME;
        }
    }

    private static boolean hasFlag(byte b, byte b5) {
        return (b & b5) != 0;
    }

    private static boolean isValidFrameHeader(int i, int i2, byte b, int i4) {
        switch (i2) {
            case 0:
                if (i != 0) {
                }
                break;
            case 1:
                if (i4 >= 10) {
                }
                break;
            case 2:
                if (i4 >= 4) {
                }
                break;
            case 3:
                if (b != 0 || i4 != 8) {
                }
                break;
            case 4:
                if (i4 >= 4) {
                }
                break;
            case 6:
                if (i4 == 4) {
                }
                break;
            case 7:
                if (i4 == 8) {
                }
                break;
            case 8:
                if (i4 >= 4) {
                }
                break;
            case 9:
                if (i4 == 8) {
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void decode(ByteBuf byteBuf) {
        int unsignedShort;
        while (true) {
            int i = 0;
            z = false;
            boolean z = false;
            switch (C126531.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[this.state.ordinal()]) {
                case 1:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    int i2 = byteBuf.readerIndex();
                    int i4 = i2 + 4;
                    int i5 = i2 + 5;
                    byteBuf.skipBytes(8);
                    if ((byteBuf.getByte(i2) & 128) != 0) {
                        unsignedShort = SpdyCodecUtil.getUnsignedShort(byteBuf, i2) & LayoutKt.LargeDimension;
                        int unsignedShort2 = SpdyCodecUtil.getUnsignedShort(byteBuf, i2 + 2);
                        this.streamId = 0;
                        i = unsignedShort2;
                    } else {
                        unsignedShort = this.spdyVersion;
                        this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, i2);
                    }
                    this.flags = byteBuf.getByte(i4);
                    int unsignedMedium = SpdyCodecUtil.getUnsignedMedium(byteBuf, i5);
                    this.length = unsignedMedium;
                    if (unsignedShort != this.spdyVersion) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SPDY Version");
                    } else if (!isValidFrameHeader(this.streamId, i, this.flags, unsignedMedium)) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid Frame Error");
                    } else {
                        this.state = getNextState(i, this.length);
                    }
                    break;
                case 2:
                    int i6 = this.length;
                    if (i6 != 0) {
                        int iMin = Math.min(this.maxChunkSize, i6);
                        if (byteBuf.readableBytes() < iMin) {
                            return;
                        }
                        ByteBuf byteBufBuffer = byteBuf.alloc().buffer(iMin);
                        byteBufBuffer.writeBytes(byteBuf, iMin);
                        int i7 = this.length - iMin;
                        this.length = i7;
                        if (i7 == 0) {
                            this.state = State.READ_COMMON_HEADER;
                        }
                        if (i7 == 0 && hasFlag(this.flags, (byte) 1)) {
                            z = true;
                        }
                        this.delegate.readDataFrame(this.streamId, z, byteBufBuffer);
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readDataFrame(this.streamId, hasFlag(this.flags, (byte) 1), Unpooled.buffer(0));
                    }
                    break;
                case 3:
                    if (byteBuf.readableBytes() < 10) {
                        return;
                    }
                    int i8 = byteBuf.readerIndex();
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, i8);
                    int unsignedInt = SpdyCodecUtil.getUnsignedInt(byteBuf, i8 + 4);
                    byte b = (byte) ((byteBuf.getByte(i8 + 8) >> 5) & 7);
                    boolean zHasFlag = hasFlag(this.flags, (byte) 1);
                    boolean zHasFlag2 = hasFlag(this.flags, (byte) 2);
                    byteBuf.skipBytes(10);
                    this.length -= 10;
                    int i9 = this.streamId;
                    if (i9 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readSynStreamFrame(i9, unsignedInt, b, zHasFlag, zHasFlag2);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SYN_STREAM Frame");
                    }
                    break;
                case 4:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    boolean zHasFlag3 = hasFlag(this.flags, (byte) 1);
                    byteBuf.skipBytes(4);
                    this.length -= 4;
                    int i10 = this.streamId;
                    if (i10 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readSynReplyFrame(i10, zHasFlag3);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SYN_REPLY Frame");
                    }
                    break;
                case 5:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int signedInt = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    int i11 = this.streamId;
                    if (i11 == 0 || signedInt == 0) {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid RST_STREAM Frame");
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readRstStreamFrame(i11, signedInt);
                    }
                    break;
                case 6:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    boolean zHasFlag4 = hasFlag(this.flags, (byte) 1);
                    this.numSettings = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    byteBuf.skipBytes(4);
                    int i12 = this.length - 4;
                    this.length = i12;
                    if ((i12 & 7) == 0 && (i12 >> 3) == this.numSettings) {
                        this.state = State.READ_SETTING;
                        this.delegate.readSettingsFrame(zHasFlag4);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid SETTINGS Frame");
                    }
                    break;
                case 7:
                    if (this.numSettings == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readSettingsEnd();
                    } else {
                        if (byteBuf.readableBytes() < 8) {
                            return;
                        }
                        byte b5 = byteBuf.getByte(byteBuf.readerIndex());
                        int unsignedMedium2 = SpdyCodecUtil.getUnsignedMedium(byteBuf, byteBuf.readerIndex() + 1);
                        int signedInt2 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                        boolean zHasFlag5 = hasFlag(b5, (byte) 1);
                        boolean zHasFlag6 = hasFlag(b5, (byte) 2);
                        byteBuf.skipBytes(8);
                        this.numSettings--;
                        this.delegate.readSetting(unsignedMedium2, signedInt2, zHasFlag5, zHasFlag6);
                    }
                    break;
                case 8:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    int signedInt3 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex());
                    byteBuf.skipBytes(4);
                    this.state = State.READ_COMMON_HEADER;
                    this.delegate.readPingFrame(signedInt3);
                    break;
                case 9:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    int unsignedInt2 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int signedInt4 = SpdyCodecUtil.getSignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    this.state = State.READ_COMMON_HEADER;
                    this.delegate.readGoAwayFrame(unsignedInt2, signedInt4);
                    break;
                case 10:
                    if (byteBuf.readableBytes() < 4) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    boolean zHasFlag7 = hasFlag(this.flags, (byte) 1);
                    byteBuf.skipBytes(4);
                    this.length -= 4;
                    int i13 = this.streamId;
                    if (i13 != 0) {
                        this.state = State.READ_HEADER_BLOCK;
                        this.delegate.readHeadersFrame(i13, zHasFlag7);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid HEADERS Frame");
                    }
                    break;
                case 11:
                    if (byteBuf.readableBytes() < 8) {
                        return;
                    }
                    this.streamId = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex());
                    int unsignedInt3 = SpdyCodecUtil.getUnsignedInt(byteBuf, byteBuf.readerIndex() + 4);
                    byteBuf.skipBytes(8);
                    if (unsignedInt3 != 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readWindowUpdateFrame(this.streamId, unsignedInt3);
                    } else {
                        this.state = State.FRAME_ERROR;
                        this.delegate.readFrameError("Invalid WINDOW_UPDATE Frame");
                    }
                    break;
                case 12:
                    if (this.length == 0) {
                        this.state = State.READ_COMMON_HEADER;
                        this.delegate.readHeaderBlockEnd();
                    } else {
                        if (!byteBuf.isReadable()) {
                            return;
                        }
                        int iMin2 = Math.min(byteBuf.readableBytes(), this.length);
                        ByteBuf byteBufBuffer2 = byteBuf.alloc().buffer(iMin2);
                        byteBufBuffer2.writeBytes(byteBuf, iMin2);
                        this.length -= iMin2;
                        this.delegate.readHeaderBlock(byteBufBuffer2);
                    }
                    break;
                case 13:
                    int iMin3 = Math.min(byteBuf.readableBytes(), this.length);
                    byteBuf.skipBytes(iMin3);
                    int i14 = this.length - iMin3;
                    this.length = i14;
                    if (i14 != 0) {
                        return;
                    } else {
                        this.state = State.READ_COMMON_HEADER;
                    }
                    break;
                case 14:
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                default:
                    throw new Error("Shouldn't reach here.");
            }
        }
    }

    public SpdyFrameDecoder(SpdyVersion spdyVersion, SpdyFrameDecoderDelegate spdyFrameDecoderDelegate, int i) {
        this.spdyVersion = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion, "spdyVersion")).getVersion();
        this.delegate = (SpdyFrameDecoderDelegate) ObjectUtil.checkNotNull(spdyFrameDecoderDelegate, "delegate");
        this.maxChunkSize = ObjectUtil.checkPositive(i, "maxChunkSize");
        this.state = State.READ_COMMON_HEADER;
    }
}
