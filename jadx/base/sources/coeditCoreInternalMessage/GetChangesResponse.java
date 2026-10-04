package coeditCoreInternalMessage;

import coeditCoreMessage.CheckPointCoeditOpPair;
import coeditCoreMessage.CheckPointCoeditOpPairOrBuilder;
import coeditCoreMessage.ResponseResult;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class GetChangesResponse extends GeneratedMessageLite<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
    public static final int CHECKPOINT_COEDITOP_PAIR_FIELD_NUMBER = 2;
    private static final GetChangesResponse DEFAULT_INSTANCE;
    private static volatile Parser<GetChangesResponse> PARSER = null;
    public static final int RESPONSE_RESULT_FIELD_NUMBER = 1;
    private Internal.ProtobufList<CheckPointCoeditOpPair> checkpointCoeditopPair_ = GeneratedMessageLite.emptyProtobufList();
    private ResponseResult responseResult_;

    /* JADX INFO: renamed from: coeditCoreInternalMessage.GetChangesResponse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42291 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1859xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1859xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1859xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllCheckpointCoeditopPair(Iterable<? extends CheckPointCoeditOpPair> iterable) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).addAllCheckpointCoeditopPair(iterable);
            return this;
        }

        public Builder addCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).addCheckpointCoeditopPair(checkPointCoeditOpPair);
            return this;
        }

        public Builder clearCheckpointCoeditopPair() {
            copyOnWrite();
            ((GetChangesResponse) this.instance).clearCheckpointCoeditopPair();
            return this;
        }

        public Builder clearResponseResult() {
            copyOnWrite();
            ((GetChangesResponse) this.instance).clearResponseResult();
            return this;
        }

        @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
        public CheckPointCoeditOpPair getCheckpointCoeditopPair(int i) {
            return ((GetChangesResponse) this.instance).getCheckpointCoeditopPair(i);
        }

        @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
        public int getCheckpointCoeditopPairCount() {
            return ((GetChangesResponse) this.instance).getCheckpointCoeditopPairCount();
        }

        @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
        public List<CheckPointCoeditOpPair> getCheckpointCoeditopPairList() {
            return Collections.unmodifiableList(((GetChangesResponse) this.instance).getCheckpointCoeditopPairList());
        }

        @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
        public ResponseResult getResponseResult() {
            return ((GetChangesResponse) this.instance).getResponseResult();
        }

        @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
        public boolean hasResponseResult() {
            return ((GetChangesResponse) this.instance).hasResponseResult();
        }

        public Builder mergeResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).mergeResponseResult(responseResult);
            return this;
        }

        public Builder removeCheckpointCoeditopPair(int i) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).removeCheckpointCoeditopPair(i);
            return this;
        }

        public Builder setCheckpointCoeditopPair(int i, CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).setCheckpointCoeditopPair(i, checkPointCoeditOpPair);
            return this;
        }

        public Builder setResponseResult(ResponseResult responseResult) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).setResponseResult(responseResult);
            return this;
        }

        private Builder() {
            super(GetChangesResponse.DEFAULT_INSTANCE);
        }

        public Builder addCheckpointCoeditopPair(int i, CheckPointCoeditOpPair checkPointCoeditOpPair) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).addCheckpointCoeditopPair(i, checkPointCoeditOpPair);
            return this;
        }

        public Builder setCheckpointCoeditopPair(int i, CheckPointCoeditOpPair.Builder builder) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).setCheckpointCoeditopPair(i, builder.build());
            return this;
        }

        public Builder setResponseResult(ResponseResult.Builder builder) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).setResponseResult(builder.build());
            return this;
        }

        public Builder addCheckpointCoeditopPair(CheckPointCoeditOpPair.Builder builder) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).addCheckpointCoeditopPair(builder.build());
            return this;
        }

        public Builder addCheckpointCoeditopPair(int i, CheckPointCoeditOpPair.Builder builder) {
            copyOnWrite();
            ((GetChangesResponse) this.instance).addCheckpointCoeditopPair(i, builder.build());
            return this;
        }
    }

    static {
        GetChangesResponse getChangesResponse = new GetChangesResponse();
        DEFAULT_INSTANCE = getChangesResponse;
        GeneratedMessageLite.registerDefaultInstance(GetChangesResponse.class, getChangesResponse);
    }

    private GetChangesResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCheckpointCoeditopPair(Iterable<? extends CheckPointCoeditOpPair> iterable) {
        ensureCheckpointCoeditopPairIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.checkpointCoeditopPair_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCheckpointCoeditopPair(CheckPointCoeditOpPair checkPointCoeditOpPair) {
        checkPointCoeditOpPair.getClass();
        ensureCheckpointCoeditopPairIsMutable();
        this.checkpointCoeditopPair_.add(checkPointCoeditOpPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckpointCoeditopPair() {
        this.checkpointCoeditopPair_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseResult() {
        this.responseResult_ = null;
    }

    private void ensureCheckpointCoeditopPairIsMutable() {
        Internal.ProtobufList<CheckPointCoeditOpPair> protobufList = this.checkpointCoeditopPair_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.checkpointCoeditopPair_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GetChangesResponse getDefaultInstance() {
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

    public static GetChangesResponse parseDelimitedFrom(InputStream inputStream) {
        return (GetChangesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetChangesResponse parseFrom(ByteBuffer byteBuffer) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetChangesResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCheckpointCoeditopPair(int i) {
        ensureCheckpointCoeditopPairIsMutable();
        this.checkpointCoeditopPair_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckpointCoeditopPair(int i, CheckPointCoeditOpPair checkPointCoeditOpPair) {
        checkPointCoeditOpPair.getClass();
        ensureCheckpointCoeditopPairIsMutable();
        this.checkpointCoeditopPair_.set(i, checkPointCoeditOpPair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseResult(ResponseResult responseResult) {
        responseResult.getClass();
        this.responseResult_ = responseResult;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42291.f1859xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new GetChangesResponse();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"responseResult_", "checkpointCoeditopPair_", CheckPointCoeditOpPair.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetChangesResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetChangesResponse.class) {
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

    @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
    public CheckPointCoeditOpPair getCheckpointCoeditopPair(int i) {
        return this.checkpointCoeditopPair_.get(i);
    }

    @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
    public int getCheckpointCoeditopPairCount() {
        return this.checkpointCoeditopPair_.size();
    }

    @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
    public List<CheckPointCoeditOpPair> getCheckpointCoeditopPairList() {
        return this.checkpointCoeditopPair_;
    }

    public CheckPointCoeditOpPairOrBuilder getCheckpointCoeditopPairOrBuilder(int i) {
        return this.checkpointCoeditopPair_.get(i);
    }

    public List<? extends CheckPointCoeditOpPairOrBuilder> getCheckpointCoeditopPairOrBuilderList() {
        return this.checkpointCoeditopPair_;
    }

    @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
    public ResponseResult getResponseResult() {
        ResponseResult responseResult = this.responseResult_;
        return responseResult == null ? ResponseResult.getDefaultInstance() : responseResult;
    }

    @Override // coeditCoreInternalMessage.GetChangesResponseOrBuilder
    public boolean hasResponseResult() {
        return this.responseResult_ != null;
    }

    public static Builder newBuilder(GetChangesResponse getChangesResponse) {
        return DEFAULT_INSTANCE.createBuilder(getChangesResponse);
    }

    public static GetChangesResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetChangesResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetChangesResponse parseFrom(ByteString byteString) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCheckpointCoeditopPair(int i, CheckPointCoeditOpPair checkPointCoeditOpPair) {
        checkPointCoeditOpPair.getClass();
        ensureCheckpointCoeditopPairIsMutable();
        this.checkpointCoeditopPair_.add(i, checkPointCoeditOpPair);
    }

    public static GetChangesResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetChangesResponse parseFrom(byte[] bArr) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetChangesResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetChangesResponse parseFrom(InputStream inputStream) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetChangesResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetChangesResponse parseFrom(CodedInputStream codedInputStream) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetChangesResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
