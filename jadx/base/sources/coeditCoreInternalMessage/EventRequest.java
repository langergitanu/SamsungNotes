package coeditCoreInternalMessage;

import coeditCoreMessage.EventType;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class EventRequest extends GeneratedMessageLite<EventRequest, Builder> implements EventRequestOrBuilder {
    private static final EventRequest DEFAULT_INSTANCE;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<EventRequest> PARSER = null;
    public static final int TARGET_UID_FIELD_NUMBER = 2;
    public static final int WRITABLE_FIELD_NUMBER = 3;
    private int eventType_;
    private String targetUid_ = "";
    private boolean writable_;

    /* JADX INFO: renamed from: coeditCoreInternalMessage.EventRequest$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42261 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1856xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1856xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1856xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<EventRequest, Builder> implements EventRequestOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearEventType() {
            copyOnWrite();
            ((EventRequest) this.instance).clearEventType();
            return this;
        }

        public Builder clearTargetUid() {
            copyOnWrite();
            ((EventRequest) this.instance).clearTargetUid();
            return this;
        }

        public Builder clearWritable() {
            copyOnWrite();
            ((EventRequest) this.instance).clearWritable();
            return this;
        }

        @Override // coeditCoreInternalMessage.EventRequestOrBuilder
        public EventType getEventType() {
            return ((EventRequest) this.instance).getEventType();
        }

        @Override // coeditCoreInternalMessage.EventRequestOrBuilder
        public int getEventTypeValue() {
            return ((EventRequest) this.instance).getEventTypeValue();
        }

        @Override // coeditCoreInternalMessage.EventRequestOrBuilder
        public String getTargetUid() {
            return ((EventRequest) this.instance).getTargetUid();
        }

        @Override // coeditCoreInternalMessage.EventRequestOrBuilder
        public ByteString getTargetUidBytes() {
            return ((EventRequest) this.instance).getTargetUidBytes();
        }

        @Override // coeditCoreInternalMessage.EventRequestOrBuilder
        public boolean getWritable() {
            return ((EventRequest) this.instance).getWritable();
        }

        public Builder setEventType(EventType eventType) {
            copyOnWrite();
            ((EventRequest) this.instance).setEventType(eventType);
            return this;
        }

        public Builder setEventTypeValue(int i) {
            copyOnWrite();
            ((EventRequest) this.instance).setEventTypeValue(i);
            return this;
        }

        public Builder setTargetUid(String str) {
            copyOnWrite();
            ((EventRequest) this.instance).setTargetUid(str);
            return this;
        }

        public Builder setTargetUidBytes(ByteString byteString) {
            copyOnWrite();
            ((EventRequest) this.instance).setTargetUidBytes(byteString);
            return this;
        }

        public Builder setWritable(boolean z) {
            copyOnWrite();
            ((EventRequest) this.instance).setWritable(z);
            return this;
        }

        private Builder() {
            super(EventRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        EventRequest eventRequest = new EventRequest();
        DEFAULT_INSTANCE = eventRequest;
        GeneratedMessageLite.registerDefaultInstance(EventRequest.class, eventRequest);
    }

    private EventRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventType() {
        this.eventType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetUid() {
        this.targetUid_ = getDefaultInstance().getTargetUid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWritable() {
        this.writable_ = false;
    }

    public static EventRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static EventRequest parseDelimitedFrom(InputStream inputStream) {
        return (EventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EventRequest parseFrom(ByteBuffer byteBuffer) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EventRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventType(EventType eventType) {
        this.eventType_ = eventType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventTypeValue(int i) {
        this.eventType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetUid(String str) {
        str.getClass();
        this.targetUid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetUidBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.targetUid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWritable(boolean z) {
        this.writable_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42261.f1856xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new EventRequest();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003\u0007", new Object[]{"eventType_", "targetUid_", "writable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EventRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (EventRequest.class) {
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

    @Override // coeditCoreInternalMessage.EventRequestOrBuilder
    public EventType getEventType() {
        EventType eventTypeForNumber = EventType.forNumber(this.eventType_);
        return eventTypeForNumber == null ? EventType.UNRECOGNIZED : eventTypeForNumber;
    }

    @Override // coeditCoreInternalMessage.EventRequestOrBuilder
    public int getEventTypeValue() {
        return this.eventType_;
    }

    @Override // coeditCoreInternalMessage.EventRequestOrBuilder
    public String getTargetUid() {
        return this.targetUid_;
    }

    @Override // coeditCoreInternalMessage.EventRequestOrBuilder
    public ByteString getTargetUidBytes() {
        return ByteString.copyFromUtf8(this.targetUid_);
    }

    @Override // coeditCoreInternalMessage.EventRequestOrBuilder
    public boolean getWritable() {
        return this.writable_;
    }

    public static Builder newBuilder(EventRequest eventRequest) {
        return DEFAULT_INSTANCE.createBuilder(eventRequest);
    }

    public static EventRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EventRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EventRequest parseFrom(ByteString byteString) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EventRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EventRequest parseFrom(byte[] bArr) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EventRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EventRequest parseFrom(InputStream inputStream) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EventRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EventRequest parseFrom(CodedInputStream codedInputStream) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EventRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
