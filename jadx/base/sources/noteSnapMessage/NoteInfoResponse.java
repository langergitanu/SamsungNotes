package noteSnapMessage;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import noteSnapMessage.ResponseResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class NoteInfoResponse extends GeneratedMessageLite<NoteInfoResponse, Builder> implements NoteInfoResponseOrBuilder {
    public static final int CHECKPOINT_FIELD_NUMBER = 3;
    public static final int COMMIT_ID_FIELD_NUMBER = 2;
    private static final NoteInfoResponse DEFAULT_INSTANCE;
    public static final int MODIFIEDTIME_FIELD_NUMBER = 4;
    private static volatile Parser<NoteInfoResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private long checkpoint_;
    private String commitId_ = "";
    private long modifiedtime_;
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: noteSnapMessage.NoteInfoResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C135631 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f9610xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f9610xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9610xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<NoteInfoResponse, Builder> implements NoteInfoResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearCheckpoint() {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).clearCheckpoint();
            return this;
        }

        public Builder clearCommitId() {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).clearCommitId();
            return this;
        }

        public Builder clearModifiedtime() {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).clearModifiedtime();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public long getCheckpoint() {
            return ((NoteInfoResponse) this.instance).getCheckpoint();
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public String getCommitId() {
            return ((NoteInfoResponse) this.instance).getCommitId();
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public ByteString getCommitIdBytes() {
            return ((NoteInfoResponse) this.instance).getCommitIdBytes();
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public long getModifiedtime() {
            return ((NoteInfoResponse) this.instance).getModifiedtime();
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((NoteInfoResponse) this.instance).getResponseResult();
        }

        @Override // noteSnapMessage.NoteInfoResponseOrBuilder
        public boolean hasResponseResult() {
            return ((NoteInfoResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder setCheckpoint(long j) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setCheckpoint(j);
            return this;
        }

        public Builder setCommitId(String str) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setCommitId(str);
            return this;
        }

        public Builder setCommitIdBytes(ByteString byteString) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setCommitIdBytes(byteString);
            return this;
        }

        public Builder setModifiedtime(long j) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setModifiedtime(j);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(NoteInfoResponse.DEFAULT_INSTANCE);
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((NoteInfoResponse) this.instance).setResponseResult(builder.build());
            return this;
        }
    }

    static {
        NoteInfoResponse noteInfoResponse = new NoteInfoResponse();
        DEFAULT_INSTANCE = noteInfoResponse;
        GeneratedMessageLite.registerDefaultInstance(NoteInfoResponse.class, noteInfoResponse);
    }

    private NoteInfoResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckpoint() {
        this.checkpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCommitId() {
        this.commitId_ = getDefaultInstance().getCommitId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModifiedtime() {
        this.modifiedtime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    public static NoteInfoResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        ResponseResult responseResult2 = this.responseResult_;
        if (responseResult2 == null || responseResult2 == ResponseResult.getDefaultInstance()) {
            this.responseResult_ = responseResult;
        } else {
            this.responseResult_ = ResponseResult.newBuilder(this.responseResult_).mergeFrom(responseResult).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NoteInfoResponse parseDelimitedFrom(InputStream inputStream) {
        return (NoteInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoteInfoResponse parseFrom(ByteBuffer byteBuffer) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NoteInfoResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckpoint(long j) {
        this.checkpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommitId(String str) {
        str.getClass();
        this.commitId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommitIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.commitId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModifiedtime(long j) {
        this.modifiedtime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C135631.f9610xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new NoteInfoResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002Ȉ\u0003\u0002\u0004\u0002", new Object[]{"responseResult_", "commitId_", "checkpoint_", "modifiedtime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NoteInfoResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NoteInfoResponse.class) {
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

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public long getCheckpoint() {
        return this.checkpoint_;
    }

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public String getCommitId() {
        return this.commitId_;
    }

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public ByteString getCommitIdBytes() {
        return ByteString.copyFromUtf8(this.commitId_);
    }

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public long getModifiedtime() {
        return this.modifiedtime_;
    }

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // noteSnapMessage.NoteInfoResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(NoteInfoResponse noteInfoResponse) {
        return DEFAULT_INSTANCE.createBuilder(noteInfoResponse);
    }

    public static NoteInfoResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NoteInfoResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NoteInfoResponse parseFrom(ByteString byteString) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NoteInfoResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NoteInfoResponse parseFrom(byte[] bArr) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NoteInfoResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NoteInfoResponse parseFrom(InputStream inputStream) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoteInfoResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NoteInfoResponse parseFrom(CodedInputStream codedInputStream) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NoteInfoResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteInfoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
