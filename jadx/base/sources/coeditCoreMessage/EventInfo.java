package coeditCoreMessage;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class EventInfo extends GeneratedMessageLite<EventInfo, Builder> implements EventInfoOrBuilder {
    private static final EventInfo DEFAULT_INSTANCE;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<EventInfo> PARSER = null;
    public static final int WRITABLE_FIELD_NUMBER = 2;
    private int eventType_;
    private boolean writable_;

    /* JADX INFO: renamed from: coeditCoreMessage.EventInfo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42411 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1868xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1868xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1868xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<EventInfo, Builder> implements EventInfoOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearEventType() {
            copyOnWrite();
            ((EventInfo) this.instance).clearEventType();
            return this;
        }

        public Builder clearWritable() {
            copyOnWrite();
            ((EventInfo) this.instance).clearWritable();
            return this;
        }

        @Override // coeditCoreMessage.EventInfoOrBuilder
        public EventType getEventType() {
            return ((EventInfo) this.instance).getEventType();
        }

        @Override // coeditCoreMessage.EventInfoOrBuilder
        public int getEventTypeValue() {
            return ((EventInfo) this.instance).getEventTypeValue();
        }

        @Override // coeditCoreMessage.EventInfoOrBuilder
        public boolean getWritable() {
            return ((EventInfo) this.instance).getWritable();
        }

        public Builder setEventType(EventType eventType) {
            copyOnWrite();
            ((EventInfo) this.instance).setEventType(eventType);
            return this;
        }

        public Builder setEventTypeValue(int i) {
            copyOnWrite();
            ((EventInfo) this.instance).setEventTypeValue(i);
            return this;
        }

        public Builder setWritable(boolean z) {
            copyOnWrite();
            ((EventInfo) this.instance).setWritable(z);
            return this;
        }

        private Builder() {
            super(EventInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        EventInfo eventInfo = new EventInfo();
        DEFAULT_INSTANCE = eventInfo;
        GeneratedMessageLite.registerDefaultInstance(EventInfo.class, eventInfo);
    }

    private EventInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventType() {
        this.eventType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWritable() {
        this.writable_ = false;
    }

    public static EventInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static EventInfo parseDelimitedFrom(InputStream inputStream) {
        return (EventInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EventInfo parseFrom(ByteBuffer byteBuffer) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EventInfo> parser() {
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
    public void setWritable(boolean z) {
        this.writable_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42411.f1868xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new EventInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u0007", new Object[]{"eventType_", "writable_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EventInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (EventInfo.class) {
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

    @Override // coeditCoreMessage.EventInfoOrBuilder
    public EventType getEventType() {
        EventType eventTypeForNumber = EventType.forNumber(this.eventType_);
        return eventTypeForNumber == null ? EventType.UNRECOGNIZED : eventTypeForNumber;
    }

    @Override // coeditCoreMessage.EventInfoOrBuilder
    public int getEventTypeValue() {
        return this.eventType_;
    }

    @Override // coeditCoreMessage.EventInfoOrBuilder
    public boolean getWritable() {
        return this.writable_;
    }

    public static Builder newBuilder(EventInfo eventInfo) {
        return DEFAULT_INSTANCE.createBuilder(eventInfo);
    }

    public static EventInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EventInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EventInfo parseFrom(ByteString byteString) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EventInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EventInfo parseFrom(byte[] bArr) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EventInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EventInfo parseFrom(InputStream inputStream) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EventInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EventInfo parseFrom(CodedInputStream codedInputStream) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EventInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EventInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
