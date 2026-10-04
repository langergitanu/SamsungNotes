package noteSnapMessage;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ResponseResult extends GeneratedMessageLite<ResponseResult, Builder> implements ResponseResultOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final ResponseResult DEFAULT_INSTANCE;
    public static final int LCODE_FIELD_NUMBER = 3;
    public static final int LMSG_FIELD_NUMBER = 5;
    private static volatile Parser<ResponseResult> PARSER = null;
    public static final int RCODE_FIELD_NUMBER = 2;
    public static final int RMSG_FIELD_NUMBER = 4;
    public static final int SIZE_FIELD_NUMBER = 6;
    private int code_;
    private int lcode_;
    private int rcode_;
    private long size_;
    private String rmsg_ = "";
    private String lmsg_ = "";

    /* JADX INFO: renamed from: noteSnapMessage.ResponseResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C135641 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f9611xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f9611xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9611xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<ResponseResult, Builder> implements ResponseResultOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCode() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearCode();
            return this;
        }

        public Builder clearLcode() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearLcode();
            return this;
        }

        public Builder clearLmsg() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearLmsg();
            return this;
        }

        public Builder clearRcode() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearRcode();
            return this;
        }

        public Builder clearRmsg() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearRmsg();
            return this;
        }

        public Builder clearSize() {
            copyOnWrite();
            ((ResponseResult) this.instance).clearSize();
            return this;
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public int getCode() {
            return ((ResponseResult) this.instance).getCode();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public int getLcode() {
            return ((ResponseResult) this.instance).getLcode();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public String getLmsg() {
            return ((ResponseResult) this.instance).getLmsg();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public ByteString getLmsgBytes() {
            return ((ResponseResult) this.instance).getLmsgBytes();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public int getRcode() {
            return ((ResponseResult) this.instance).getRcode();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public String getRmsg() {
            return ((ResponseResult) this.instance).getRmsg();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public ByteString getRmsgBytes() {
            return ((ResponseResult) this.instance).getRmsgBytes();
        }

        @Override // noteSnapMessage.ResponseResultOrBuilder
        public long getSize() {
            return ((ResponseResult) this.instance).getSize();
        }

        public Builder setCode(int i) {
            copyOnWrite();
            ((ResponseResult) this.instance).setCode(i);
            return this;
        }

        public Builder setLcode(int i) {
            copyOnWrite();
            ((ResponseResult) this.instance).setLcode(i);
            return this;
        }

        public Builder setLmsg(String str) {
            copyOnWrite();
            ((ResponseResult) this.instance).setLmsg(str);
            return this;
        }

        public Builder setLmsgBytes(ByteString byteString) {
            copyOnWrite();
            ((ResponseResult) this.instance).setLmsgBytes(byteString);
            return this;
        }

        public Builder setRcode(int i) {
            copyOnWrite();
            ((ResponseResult) this.instance).setRcode(i);
            return this;
        }

        public Builder setRmsg(String str) {
            copyOnWrite();
            ((ResponseResult) this.instance).setRmsg(str);
            return this;
        }

        public Builder setRmsgBytes(ByteString byteString) {
            copyOnWrite();
            ((ResponseResult) this.instance).setRmsgBytes(byteString);
            return this;
        }

        public Builder setSize(long j) {
            copyOnWrite();
            ((ResponseResult) this.instance).setSize(j);
            return this;
        }

        private Builder() {
            super(ResponseResult.DEFAULT_INSTANCE);
        }
    }

    static {
        ResponseResult responseResult = new ResponseResult();
        DEFAULT_INSTANCE = responseResult;
        GeneratedMessageLite.registerDefaultInstance(ResponseResult.class, responseResult);
    }

    private ResponseResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLcode() {
        this.lcode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLmsg() {
        this.lmsg_ = getDefaultInstance().getLmsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRcode() {
        this.rcode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRmsg() {
        this.rmsg_ = getDefaultInstance().getRmsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0L;
    }

    public static ResponseResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ResponseResult parseDelimitedFrom(InputStream inputStream) {
        return (ResponseResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResponseResult parseFrom(ByteBuffer byteBuffer) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ResponseResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLcode(int i) {
        this.lcode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLmsg(String str) {
        str.getClass();
        this.lmsg_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLmsgBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.lmsg_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRcode(int i) {
        this.rcode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRmsg(String str) {
        str.getClass();
        this.rmsg_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRmsgBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.rmsg_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(long j) {
        this.size_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C135641.f9611xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new ResponseResult();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006\u0002", new Object[]{"code_", "rcode_", "lcode_", "rmsg_", "lmsg_", "size_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResponseResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ResponseResult.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public int getCode() {
        return this.code_;
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public int getLcode() {
        return this.lcode_;
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public String getLmsg() {
        return this.lmsg_;
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public ByteString getLmsgBytes() {
        return ByteString.copyFromUtf8(this.lmsg_);
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public int getRcode() {
        return this.rcode_;
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public String getRmsg() {
        return this.rmsg_;
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public ByteString getRmsgBytes() {
        return ByteString.copyFromUtf8(this.rmsg_);
    }

    @Override // noteSnapMessage.ResponseResultOrBuilder
    public long getSize() {
        return this.size_;
    }

    public static Builder newBuilder(ResponseResult responseResult) {
        return DEFAULT_INSTANCE.createBuilder(responseResult);
    }

    public static ResponseResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResponseResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ResponseResult parseFrom(ByteString byteString) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ResponseResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResponseResult parseFrom(byte[] bArr) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ResponseResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ResponseResult parseFrom(InputStream inputStream) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResponseResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResponseResult parseFrom(CodedInputStream codedInputStream) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResponseResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ResponseResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
