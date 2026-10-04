package os_migration_data_types.p233v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class AttachmentMeta extends GeneratedMessageLite<AttachmentMeta, Builder> implements AttachmentMetaOrBuilder {
    public static final int ATTACHMENTTYPE_FIELD_NUMBER = 5;
    public static final int ATTACHMENT_NAME_FIELD_NUMBER = 4;
    public static final int AUDIO_ATTACHMENT_ID_FIELD_NUMBER = 2;
    private static final AttachmentMeta DEFAULT_INSTANCE;
    public static final int FILE_NAME_FIELD_NUMBER = 3;
    public static final int NOTE_ID_FIELD_NUMBER = 1;
    private static volatile Parser<AttachmentMeta> PARSER;
    private int attachmentType_;
    private String noteId_ = "";
    private String audioAttachmentId_ = "";
    private String fileName_ = "";
    private String attachmentName_ = "";

    /* JADX INFO: renamed from: os_migration_data_types.v1.AttachmentMeta$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144291 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f10219xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f10219xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10219xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<AttachmentMeta, Builder> implements AttachmentMetaOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearAttachmentName() {
            copyOnWrite();
            ((AttachmentMeta) this.instance).clearAttachmentName();
            return this;
        }

        public Builder clearAttachmentType() {
            copyOnWrite();
            ((AttachmentMeta) this.instance).clearAttachmentType();
            return this;
        }

        public Builder clearAudioAttachmentId() {
            copyOnWrite();
            ((AttachmentMeta) this.instance).clearAudioAttachmentId();
            return this;
        }

        public Builder clearFileName() {
            copyOnWrite();
            ((AttachmentMeta) this.instance).clearFileName();
            return this;
        }

        public Builder clearNoteId() {
            copyOnWrite();
            ((AttachmentMeta) this.instance).clearNoteId();
            return this;
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public String getAttachmentName() {
            return ((AttachmentMeta) this.instance).getAttachmentName();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public ByteString getAttachmentNameBytes() {
            return ((AttachmentMeta) this.instance).getAttachmentNameBytes();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public AttachmentType getAttachmentType() {
            return ((AttachmentMeta) this.instance).getAttachmentType();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public int getAttachmentTypeValue() {
            return ((AttachmentMeta) this.instance).getAttachmentTypeValue();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public String getAudioAttachmentId() {
            return ((AttachmentMeta) this.instance).getAudioAttachmentId();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public ByteString getAudioAttachmentIdBytes() {
            return ((AttachmentMeta) this.instance).getAudioAttachmentIdBytes();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public String getFileName() {
            return ((AttachmentMeta) this.instance).getFileName();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public ByteString getFileNameBytes() {
            return ((AttachmentMeta) this.instance).getFileNameBytes();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public String getNoteId() {
            return ((AttachmentMeta) this.instance).getNoteId();
        }

        @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
        public ByteString getNoteIdBytes() {
            return ((AttachmentMeta) this.instance).getNoteIdBytes();
        }

        public Builder setAttachmentName(String str) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAttachmentName(str);
            return this;
        }

        public Builder setAttachmentNameBytes(ByteString byteString) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAttachmentNameBytes(byteString);
            return this;
        }

        public Builder setAttachmentType(AttachmentType attachmentType) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAttachmentType(attachmentType);
            return this;
        }

        public Builder setAttachmentTypeValue(int i) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAttachmentTypeValue(i);
            return this;
        }

        public Builder setAudioAttachmentId(String str) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAudioAttachmentId(str);
            return this;
        }

        public Builder setAudioAttachmentIdBytes(ByteString byteString) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setAudioAttachmentIdBytes(byteString);
            return this;
        }

        public Builder setFileName(String str) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setFileName(str);
            return this;
        }

        public Builder setFileNameBytes(ByteString byteString) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setFileNameBytes(byteString);
            return this;
        }

        public Builder setNoteId(String str) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setNoteId(str);
            return this;
        }

        public Builder setNoteIdBytes(ByteString byteString) {
            copyOnWrite();
            ((AttachmentMeta) this.instance).setNoteIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(AttachmentMeta.DEFAULT_INSTANCE);
        }
    }

    static {
        AttachmentMeta attachmentMeta = new AttachmentMeta();
        DEFAULT_INSTANCE = attachmentMeta;
        GeneratedMessageLite.registerDefaultInstance(AttachmentMeta.class, attachmentMeta);
    }

    private AttachmentMeta() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAttachmentName() {
        this.attachmentName_ = getDefaultInstance().getAttachmentName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAttachmentType() {
        this.attachmentType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioAttachmentId() {
        this.audioAttachmentId_ = getDefaultInstance().getAudioAttachmentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNoteId() {
        this.noteId_ = getDefaultInstance().getNoteId();
    }

    public static AttachmentMeta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AttachmentMeta parseDelimitedFrom(InputStream inputStream) {
        return (AttachmentMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AttachmentMeta parseFrom(ByteBuffer byteBuffer) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AttachmentMeta> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttachmentName(String str) {
        str.getClass();
        this.attachmentName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttachmentNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.attachmentName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttachmentType(AttachmentType attachmentType) {
        this.attachmentType_ = attachmentType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttachmentTypeValue(int i) {
        this.attachmentType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioAttachmentId(String str) {
        str.getClass();
        this.audioAttachmentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioAttachmentIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.audioAttachmentId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.fileName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoteId(String str) {
        str.getClass();
        this.noteId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoteIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.noteId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C144291.f10219xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new AttachmentMeta();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f", new Object[]{"noteId_", "audioAttachmentId_", "fileName_", "attachmentName_", "attachmentType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AttachmentMeta> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AttachmentMeta.class) {
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

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public String getAttachmentName() {
        return this.attachmentName_;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public ByteString getAttachmentNameBytes() {
        return ByteString.copyFromUtf8(this.attachmentName_);
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public AttachmentType getAttachmentType() {
        AttachmentType attachmentTypeForNumber = AttachmentType.forNumber(this.attachmentType_);
        return attachmentTypeForNumber == null ? AttachmentType.UNRECOGNIZED : attachmentTypeForNumber;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public int getAttachmentTypeValue() {
        return this.attachmentType_;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public String getAudioAttachmentId() {
        return this.audioAttachmentId_;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public ByteString getAudioAttachmentIdBytes() {
        return ByteString.copyFromUtf8(this.audioAttachmentId_);
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public String getFileName() {
        return this.fileName_;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public ByteString getFileNameBytes() {
        return ByteString.copyFromUtf8(this.fileName_);
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public String getNoteId() {
        return this.noteId_;
    }

    @Override // os_migration_data_types.p233v1.AttachmentMetaOrBuilder
    public ByteString getNoteIdBytes() {
        return ByteString.copyFromUtf8(this.noteId_);
    }

    public static Builder newBuilder(AttachmentMeta attachmentMeta) {
        return DEFAULT_INSTANCE.createBuilder(attachmentMeta);
    }

    public static AttachmentMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AttachmentMeta parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AttachmentMeta parseFrom(ByteString byteString) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AttachmentMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AttachmentMeta parseFrom(byte[] bArr) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AttachmentMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AttachmentMeta parseFrom(InputStream inputStream) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AttachmentMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AttachmentMeta parseFrom(CodedInputStream codedInputStream) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AttachmentMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AttachmentMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
