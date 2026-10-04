package os_migration_data_types.p233v1;

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
/* JADX INFO: loaded from: classes11.dex */
public final class NoteMeta extends GeneratedMessageLite<NoteMeta, Builder> implements NoteMetaOrBuilder {
    public static final int CREATION_DATE_MILLIS_SINCE_EPOCH_FIELD_NUMBER = 3;
    private static final NoteMeta DEFAULT_INSTANCE;
    public static final int FOLDER_PATH_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_CLOUD_SYNCED_FIELD_NUMBER = 7;
    public static final int LAST_MODIFIED_DATE_MILLIS_SINCE_EPOCH_FIELD_NUMBER = 4;
    private static volatile Parser<NoteMeta> PARSER = null;
    public static final int TAGS_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 2;
    private long creationDateMillisSinceEpoch_;
    private boolean isCloudSynced_;
    private long lastModifiedDateMillisSinceEpoch_;
    private String id_ = "";
    private String title_ = "";
    private Internal.ProtobufList<String> tags_ = GeneratedMessageLite.emptyProtobufList();
    private String folderPath_ = "";

    /* JADX INFO: renamed from: os_migration_data_types.v1.NoteMeta$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C144311 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f10220xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f10220xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10220xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<NoteMeta, Builder> implements NoteMetaOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder addAllTags(Iterable<String> iterable) {
            copyOnWrite();
            ((NoteMeta) this.instance).addAllTags(iterable);
            return this;
        }

        public Builder addTags(String str) {
            copyOnWrite();
            ((NoteMeta) this.instance).addTags(str);
            return this;
        }

        public Builder addTagsBytes(ByteString byteString) {
            copyOnWrite();
            ((NoteMeta) this.instance).addTagsBytes(byteString);
            return this;
        }

        public Builder clearCreationDateMillisSinceEpoch() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearCreationDateMillisSinceEpoch();
            return this;
        }

        public Builder clearFolderPath() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearFolderPath();
            return this;
        }

        public Builder clearId() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearId();
            return this;
        }

        public Builder clearIsCloudSynced() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearIsCloudSynced();
            return this;
        }

        public Builder clearLastModifiedDateMillisSinceEpoch() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearLastModifiedDateMillisSinceEpoch();
            return this;
        }

        public Builder clearTags() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearTags();
            return this;
        }

        public Builder clearTitle() {
            copyOnWrite();
            ((NoteMeta) this.instance).clearTitle();
            return this;
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public long getCreationDateMillisSinceEpoch() {
            return ((NoteMeta) this.instance).getCreationDateMillisSinceEpoch();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public String getFolderPath() {
            return ((NoteMeta) this.instance).getFolderPath();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public ByteString getFolderPathBytes() {
            return ((NoteMeta) this.instance).getFolderPathBytes();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public String getId() {
            return ((NoteMeta) this.instance).getId();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public ByteString getIdBytes() {
            return ((NoteMeta) this.instance).getIdBytes();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public boolean getIsCloudSynced() {
            return ((NoteMeta) this.instance).getIsCloudSynced();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public long getLastModifiedDateMillisSinceEpoch() {
            return ((NoteMeta) this.instance).getLastModifiedDateMillisSinceEpoch();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public String getTags(int i) {
            return ((NoteMeta) this.instance).getTags(i);
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public ByteString getTagsBytes(int i) {
            return ((NoteMeta) this.instance).getTagsBytes(i);
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public int getTagsCount() {
            return ((NoteMeta) this.instance).getTagsCount();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public List<String> getTagsList() {
            return Collections.unmodifiableList(((NoteMeta) this.instance).getTagsList());
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public String getTitle() {
            return ((NoteMeta) this.instance).getTitle();
        }

        @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
        public ByteString getTitleBytes() {
            return ((NoteMeta) this.instance).getTitleBytes();
        }

        public Builder setCreationDateMillisSinceEpoch(long j) {
            copyOnWrite();
            ((NoteMeta) this.instance).setCreationDateMillisSinceEpoch(j);
            return this;
        }

        public Builder setFolderPath(String str) {
            copyOnWrite();
            ((NoteMeta) this.instance).setFolderPath(str);
            return this;
        }

        public Builder setFolderPathBytes(ByteString byteString) {
            copyOnWrite();
            ((NoteMeta) this.instance).setFolderPathBytes(byteString);
            return this;
        }

        public Builder setId(String str) {
            copyOnWrite();
            ((NoteMeta) this.instance).setId(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((NoteMeta) this.instance).setIdBytes(byteString);
            return this;
        }

        public Builder setIsCloudSynced(boolean z) {
            copyOnWrite();
            ((NoteMeta) this.instance).setIsCloudSynced(z);
            return this;
        }

        public Builder setLastModifiedDateMillisSinceEpoch(long j) {
            copyOnWrite();
            ((NoteMeta) this.instance).setLastModifiedDateMillisSinceEpoch(j);
            return this;
        }

        public Builder setTags(int i, String str) {
            copyOnWrite();
            ((NoteMeta) this.instance).setTags(i, str);
            return this;
        }

        public Builder setTitle(String str) {
            copyOnWrite();
            ((NoteMeta) this.instance).setTitle(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((NoteMeta) this.instance).setTitleBytes(byteString);
            return this;
        }

        private Builder() {
            super(NoteMeta.DEFAULT_INSTANCE);
        }
    }

    static {
        NoteMeta noteMeta = new NoteMeta();
        DEFAULT_INSTANCE = noteMeta;
        GeneratedMessageLite.registerDefaultInstance(NoteMeta.class, noteMeta);
    }

    private NoteMeta() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTags(Iterable<String> iterable) {
        ensureTagsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tags_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTags(String str) {
        str.getClass();
        ensureTagsIsMutable();
        this.tags_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTagsBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureTagsIsMutable();
        this.tags_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCreationDateMillisSinceEpoch() {
        this.creationDateMillisSinceEpoch_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFolderPath() {
        this.folderPath_ = getDefaultInstance().getFolderPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsCloudSynced() {
        this.isCloudSynced_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastModifiedDateMillisSinceEpoch() {
        this.lastModifiedDateMillisSinceEpoch_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTags() {
        this.tags_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureTagsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.tags_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.tags_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static NoteMeta getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NoteMeta parseDelimitedFrom(InputStream inputStream) {
        return (NoteMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoteMeta parseFrom(ByteBuffer byteBuffer) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NoteMeta> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCreationDateMillisSinceEpoch(long j) {
        this.creationDateMillisSinceEpoch_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderPath(String str) {
        str.getClass();
        this.folderPath_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderPathBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.folderPath_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsCloudSynced(boolean z) {
        this.isCloudSynced_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastModifiedDateMillisSinceEpoch(long j) {
        this.lastModifiedDateMillisSinceEpoch_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTags(int i, String str) {
        str.getClass();
        ensureTagsIsMutable();
        this.tags_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C144311.f10220xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new NoteMeta();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0002\u0005Ț\u0006Ȉ\u0007\u0007", new Object[]{"id_", "title_", "creationDateMillisSinceEpoch_", "lastModifiedDateMillisSinceEpoch_", "tags_", "folderPath_", "isCloudSynced_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NoteMeta> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NoteMeta.class) {
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

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public long getCreationDateMillisSinceEpoch() {
        return this.creationDateMillisSinceEpoch_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public String getFolderPath() {
        return this.folderPath_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public ByteString getFolderPathBytes() {
        return ByteString.copyFromUtf8(this.folderPath_);
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public boolean getIsCloudSynced() {
        return this.isCloudSynced_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public long getLastModifiedDateMillisSinceEpoch() {
        return this.lastModifiedDateMillisSinceEpoch_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public String getTags(int i) {
        return this.tags_.get(i);
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public ByteString getTagsBytes(int i) {
        return ByteString.copyFromUtf8(this.tags_.get(i));
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public int getTagsCount() {
        return this.tags_.size();
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public List<String> getTagsList() {
        return this.tags_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // os_migration_data_types.p233v1.NoteMetaOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    public static Builder newBuilder(NoteMeta noteMeta) {
        return DEFAULT_INSTANCE.createBuilder(noteMeta);
    }

    public static NoteMeta parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NoteMeta parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NoteMeta parseFrom(ByteString byteString) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NoteMeta parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NoteMeta parseFrom(byte[] bArr) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NoteMeta parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NoteMeta parseFrom(InputStream inputStream) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NoteMeta parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NoteMeta parseFrom(CodedInputStream codedInputStream) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NoteMeta parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NoteMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
