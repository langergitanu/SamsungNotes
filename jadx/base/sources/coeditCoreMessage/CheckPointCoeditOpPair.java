package coeditCoreMessage;

import coeditCoreMessage.DeviceInfo;
import coeditCoreMessage.ObjectInfo;
import coeditOperation.CoeditOperation;
import coeditOperation.CoeditOperationOrBuilder;
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
/* JADX INFO: loaded from: classes5.dex */
public final class CheckPointCoeditOpPair extends GeneratedMessageLite<CheckPointCoeditOpPair, Builder> implements CheckPointCoeditOpPairOrBuilder {
    public static final int CHECKPOINT_FIELD_NUMBER = 1;
    public static final int COEDIT_OPERATION_FIELD_NUMBER = 2;
    private static final CheckPointCoeditOpPair DEFAULT_INSTANCE;
    public static final int DEVICE_INFO_FIELD_NUMBER = 4;
    public static final int EXTRA_DATA_FIELD_NUMBER = 5;
    public static final int OBJECT_INFO_FIELD_NUMBER = 3;
    private static volatile Parser<CheckPointCoeditOpPair> PARSER;
    private long checkpoint_;
    private DeviceInfo deviceInfo_;
    private Internal.ProtobufList<CoeditOperation> coeditOperation_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ObjectInfo> objectInfo_ = GeneratedMessageLite.emptyProtobufList();
    private String extraData_ = "";

    /* JADX INFO: renamed from: coeditCoreMessage.CheckPointCoeditOpPair$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42361 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1865xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1865xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1865xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<CheckPointCoeditOpPair, Builder> implements CheckPointCoeditOpPairOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllCoeditOperation(Iterable<? extends CoeditOperation> iterable) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addAllCoeditOperation(iterable);
            return this;
        }

        public Builder addAllObjectInfo(Iterable<? extends ObjectInfo> iterable) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addAllObjectInfo(iterable);
            return this;
        }

        public Builder addCoeditOperation(CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addCoeditOperation(coeditOperation2);
            return this;
        }

        public Builder addObjectInfo(ObjectInfo objectInfo) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addObjectInfo(objectInfo);
            return this;
        }

        public Builder clearCheckpoint() {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).clearCheckpoint();
            return this;
        }

        public Builder clearCoeditOperation() {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).clearCoeditOperation();
            return this;
        }

        public Builder clearDeviceInfo() {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).clearDeviceInfo();
            return this;
        }

        public Builder clearExtraData() {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).clearExtraData();
            return this;
        }

        public Builder clearObjectInfo() {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).clearObjectInfo();
            return this;
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public long getCheckpoint() {
            return ((CheckPointCoeditOpPair) this.instance).getCheckpoint();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public CoeditOperation getCoeditOperation(int i) {
            return ((CheckPointCoeditOpPair) this.instance).getCoeditOperation(i);
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public int getCoeditOperationCount() {
            return ((CheckPointCoeditOpPair) this.instance).getCoeditOperationCount();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public List<CoeditOperation> getCoeditOperationList() {
            return Collections.unmodifiableList(((CheckPointCoeditOpPair) this.instance).getCoeditOperationList());
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public DeviceInfo getDeviceInfo() {
            return ((CheckPointCoeditOpPair) this.instance).getDeviceInfo();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public String getExtraData() {
            return ((CheckPointCoeditOpPair) this.instance).getExtraData();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public ByteString getExtraDataBytes() {
            return ((CheckPointCoeditOpPair) this.instance).getExtraDataBytes();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public ObjectInfo getObjectInfo(int i) {
            return ((CheckPointCoeditOpPair) this.instance).getObjectInfo(i);
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public int getObjectInfoCount() {
            return ((CheckPointCoeditOpPair) this.instance).getObjectInfoCount();
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public List<ObjectInfo> getObjectInfoList() {
            return Collections.unmodifiableList(((CheckPointCoeditOpPair) this.instance).getObjectInfoList());
        }

        @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
        public boolean hasDeviceInfo() {
            return ((CheckPointCoeditOpPair) this.instance).hasDeviceInfo();
        }

        public Builder mergeDeviceInfo(DeviceInfo deviceInfo) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).mergeDeviceInfo(deviceInfo);
            return this;
        }

        public Builder removeCoeditOperation(int i) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).removeCoeditOperation(i);
            return this;
        }

        public Builder removeObjectInfo(int i) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).removeObjectInfo(i);
            return this;
        }

        public Builder setCheckpoint(long j) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setCheckpoint(j);
            return this;
        }

        public Builder setCoeditOperation(int i, CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setCoeditOperation(i, coeditOperation2);
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setDeviceInfo(deviceInfo);
            return this;
        }

        public Builder setExtraData(String str) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setExtraData(str);
            return this;
        }

        public Builder setExtraDataBytes(ByteString byteString) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setExtraDataBytes(byteString);
            return this;
        }

        public Builder setObjectInfo(int i, ObjectInfo objectInfo) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setObjectInfo(i, objectInfo);
            return this;
        }

        private Builder() {
            super(CheckPointCoeditOpPair.DEFAULT_INSTANCE);
        }

        public Builder addCoeditOperation(int i, CoeditOperation coeditOperation2) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addCoeditOperation(i, coeditOperation2);
            return this;
        }

        public Builder addObjectInfo(int i, ObjectInfo objectInfo) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addObjectInfo(i, objectInfo);
            return this;
        }

        public Builder setCoeditOperation(int i, CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setCoeditOperation(i, builder.build());
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setDeviceInfo(builder.build());
            return this;
        }

        public Builder setObjectInfo(int i, ObjectInfo.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).setObjectInfo(i, builder.build());
            return this;
        }

        public Builder addCoeditOperation(CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addCoeditOperation(builder.build());
            return this;
        }

        public Builder addObjectInfo(ObjectInfo.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addObjectInfo(builder.build());
            return this;
        }

        public Builder addCoeditOperation(int i, CoeditOperation.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addCoeditOperation(i, builder.build());
            return this;
        }

        public Builder addObjectInfo(int i, ObjectInfo.Builder builder) {
            copyOnWrite();
            ((CheckPointCoeditOpPair) this.instance).addObjectInfo(i, builder.build());
            return this;
        }
    }

    static {
        CheckPointCoeditOpPair checkPointCoeditOpPair = new CheckPointCoeditOpPair();
        DEFAULT_INSTANCE = checkPointCoeditOpPair;
        GeneratedMessageLite.registerDefaultInstance(CheckPointCoeditOpPair.class, checkPointCoeditOpPair);
    }

    private CheckPointCoeditOpPair() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCoeditOperation(Iterable<? extends CoeditOperation> iterable) {
        ensureCoeditOperationIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.coeditOperation_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllObjectInfo(Iterable<? extends ObjectInfo> iterable) {
        ensureObjectInfoIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.objectInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoeditOperation(CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.add(coeditOperation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addObjectInfo(ObjectInfo objectInfo) {
        objectInfo.getClass();
        ensureObjectInfoIsMutable();
        this.objectInfo_.add(objectInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCheckpoint() {
        this.checkpoint_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCoeditOperation() {
        this.coeditOperation_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceInfo() {
        this.deviceInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtraData() {
        this.extraData_ = getDefaultInstance().getExtraData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearObjectInfo() {
        this.objectInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCoeditOperationIsMutable() {
        Internal.ProtobufList<CoeditOperation> protobufList = this.coeditOperation_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.coeditOperation_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureObjectInfoIsMutable() {
        Internal.ProtobufList<ObjectInfo> protobufList = this.objectInfo_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.objectInfo_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static CheckPointCoeditOpPair getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDeviceInfo(DeviceInfo deviceInfo) {
        deviceInfo.getClass();
        DeviceInfo deviceInfo2 = this.deviceInfo_;
        if (deviceInfo2 == null || deviceInfo2 == DeviceInfo.getDefaultInstance()) {
            this.deviceInfo_ = deviceInfo;
        } else {
            this.deviceInfo_ = DeviceInfo.newBuilder(this.deviceInfo_).mergeFrom(deviceInfo).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CheckPointCoeditOpPair parseDelimitedFrom(InputStream inputStream) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CheckPointCoeditOpPair parseFrom(ByteBuffer byteBuffer) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CheckPointCoeditOpPair> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCoeditOperation(int i) {
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeObjectInfo(int i) {
        ensureObjectInfoIsMutable();
        this.objectInfo_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckpoint(long j) {
        this.checkpoint_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCoeditOperation(int i, CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.set(i, coeditOperation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceInfo(DeviceInfo deviceInfo) {
        deviceInfo.getClass();
        this.deviceInfo_ = deviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraData(String str) {
        str.getClass();
        this.extraData_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtraDataBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.extraData_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setObjectInfo(int i, ObjectInfo objectInfo) {
        objectInfo.getClass();
        ensureObjectInfoIsMutable();
        this.objectInfo_.set(i, objectInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42361.f1865xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CheckPointCoeditOpPair();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0002\u0002\u001b\u0003\u001b\u0004\t\u0005Ȉ", new Object[]{"checkpoint_", "coeditOperation_", CoeditOperation.class, "objectInfo_", ObjectInfo.class, "deviceInfo_", "extraData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CheckPointCoeditOpPair> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CheckPointCoeditOpPair.class) {
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

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public long getCheckpoint() {
        return this.checkpoint_;
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public CoeditOperation getCoeditOperation(int i) {
        return this.coeditOperation_.get(i);
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public int getCoeditOperationCount() {
        return this.coeditOperation_.size();
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public List<CoeditOperation> getCoeditOperationList() {
        return this.coeditOperation_;
    }

    public CoeditOperationOrBuilder getCoeditOperationOrBuilder(int i) {
        return this.coeditOperation_.get(i);
    }

    public List<? extends CoeditOperationOrBuilder> getCoeditOperationOrBuilderList() {
        return this.coeditOperation_;
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public DeviceInfo getDeviceInfo() {
        DeviceInfo deviceInfo = this.deviceInfo_;
        return deviceInfo == null ? DeviceInfo.getDefaultInstance() : deviceInfo;
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public String getExtraData() {
        return this.extraData_;
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public ByteString getExtraDataBytes() {
        return ByteString.copyFromUtf8(this.extraData_);
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public ObjectInfo getObjectInfo(int i) {
        return this.objectInfo_.get(i);
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public int getObjectInfoCount() {
        return this.objectInfo_.size();
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public List<ObjectInfo> getObjectInfoList() {
        return this.objectInfo_;
    }

    public ObjectInfoOrBuilder getObjectInfoOrBuilder(int i) {
        return this.objectInfo_.get(i);
    }

    public List<? extends ObjectInfoOrBuilder> getObjectInfoOrBuilderList() {
        return this.objectInfo_;
    }

    @Override // coeditCoreMessage.CheckPointCoeditOpPairOrBuilder
    public boolean hasDeviceInfo() {
        return this.deviceInfo_ != null;
    }

    public static Builder newBuilder(CheckPointCoeditOpPair checkPointCoeditOpPair) {
        return DEFAULT_INSTANCE.createBuilder(checkPointCoeditOpPair);
    }

    public static CheckPointCoeditOpPair parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CheckPointCoeditOpPair parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CheckPointCoeditOpPair parseFrom(ByteString byteString) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCoeditOperation(int i, CoeditOperation coeditOperation2) {
        coeditOperation2.getClass();
        ensureCoeditOperationIsMutable();
        this.coeditOperation_.add(i, coeditOperation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addObjectInfo(int i, ObjectInfo objectInfo) {
        objectInfo.getClass();
        ensureObjectInfoIsMutable();
        this.objectInfo_.add(i, objectInfo);
    }

    public static CheckPointCoeditOpPair parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CheckPointCoeditOpPair parseFrom(byte[] bArr) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CheckPointCoeditOpPair parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CheckPointCoeditOpPair parseFrom(InputStream inputStream) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CheckPointCoeditOpPair parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CheckPointCoeditOpPair parseFrom(CodedInputStream codedInputStream) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CheckPointCoeditOpPair parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CheckPointCoeditOpPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
