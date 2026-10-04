package coeditOperation;

import androidx.room.util.TableInfo;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class CoeditOperation extends GeneratedMessageLite<CoeditOperation, Builder> implements CoeditOperationOrBuilder {
    public static final int CHANGE_TYPE_FIELD_NUMBER = 1;
    private static final CoeditOperation DEFAULT_INSTANCE;
    public static final int DELETE_CHARACTERS_FIELD_NUMBER = 5;
    public static final int DELETE_ELEMENTS_FIELD_NUMBER = 7;
    public static final int DELETE_OBJECT_SPAN_FIELD_NUMBER = 12;
    public static final int INDEX_FIELD_NUMBER = 2;
    public static final int INSERT_CHARACTERS_FIELD_NUMBER = 4;
    public static final int INSERT_ELEMENTS_FIELD_NUMBER = 6;
    public static final int INSERT_OBJECT_SPAN_FIELD_NUMBER = 11;
    private static volatile Parser<CoeditOperation> PARSER = null;
    public static final int REPLACE_ATTRIBUTES_FIELD_NUMBER = 9;
    public static final int SET_ANNOTATIONS_FIELD_NUMBER = 10;
    public static final int SIZE_FIELD_NUMBER = 3;
    public static final int UPDATE_ATTRIBUTES_FIELD_NUMBER = 8;
    private int changeType_;
    private Elements deleteElements_;
    private ObjectSpan deleteObjectSpan_;
    private int index_;
    private Elements insertElements_;
    private ObjectSpan insertObjectSpan_;
    private ReplaceAttributes replaceAttributes_;
    private SetAnnotations setAnnotations_;
    private int size_;
    private UpdateAttributes updateAttributes_;
    private String insertCharacters_ = "";
    private String deleteCharacters_ = "";

    /* JADX INFO: renamed from: coeditOperation.CoeditOperation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C42831 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1894xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1894xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1894xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends GeneratedMessageLite.Builder<CoeditOperation, Builder> implements CoeditOperationOrBuilder {
        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder clearChangeType() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearChangeType();
            return this;
        }

        public Builder clearDeleteCharacters() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearDeleteCharacters();
            return this;
        }

        public Builder clearDeleteElements() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearDeleteElements();
            return this;
        }

        public Builder clearDeleteObjectSpan() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearDeleteObjectSpan();
            return this;
        }

        public Builder clearIndex() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearIndex();
            return this;
        }

        public Builder clearInsertCharacters() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearInsertCharacters();
            return this;
        }

        public Builder clearInsertElements() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearInsertElements();
            return this;
        }

        public Builder clearInsertObjectSpan() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearInsertObjectSpan();
            return this;
        }

        public Builder clearReplaceAttributes() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearReplaceAttributes();
            return this;
        }

        public Builder clearSetAnnotations() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearSetAnnotations();
            return this;
        }

        public Builder clearSize() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearSize();
            return this;
        }

        public Builder clearUpdateAttributes() {
            copyOnWrite();
            ((CoeditOperation) this.instance).clearUpdateAttributes();
            return this;
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ChangeType getChangeType() {
            return ((CoeditOperation) this.instance).getChangeType();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public int getChangeTypeValue() {
            return ((CoeditOperation) this.instance).getChangeTypeValue();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public String getDeleteCharacters() {
            return ((CoeditOperation) this.instance).getDeleteCharacters();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ByteString getDeleteCharactersBytes() {
            return ((CoeditOperation) this.instance).getDeleteCharactersBytes();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public Elements getDeleteElements() {
            return ((CoeditOperation) this.instance).getDeleteElements();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ObjectSpan getDeleteObjectSpan() {
            return ((CoeditOperation) this.instance).getDeleteObjectSpan();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public int getIndex() {
            return ((CoeditOperation) this.instance).getIndex();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public String getInsertCharacters() {
            return ((CoeditOperation) this.instance).getInsertCharacters();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ByteString getInsertCharactersBytes() {
            return ((CoeditOperation) this.instance).getInsertCharactersBytes();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public Elements getInsertElements() {
            return ((CoeditOperation) this.instance).getInsertElements();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ObjectSpan getInsertObjectSpan() {
            return ((CoeditOperation) this.instance).getInsertObjectSpan();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public ReplaceAttributes getReplaceAttributes() {
            return ((CoeditOperation) this.instance).getReplaceAttributes();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public SetAnnotations getSetAnnotations() {
            return ((CoeditOperation) this.instance).getSetAnnotations();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public int getSize() {
            return ((CoeditOperation) this.instance).getSize();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public UpdateAttributes getUpdateAttributes() {
            return ((CoeditOperation) this.instance).getUpdateAttributes();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasDeleteElements() {
            return ((CoeditOperation) this.instance).hasDeleteElements();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasDeleteObjectSpan() {
            return ((CoeditOperation) this.instance).hasDeleteObjectSpan();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasInsertElements() {
            return ((CoeditOperation) this.instance).hasInsertElements();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasInsertObjectSpan() {
            return ((CoeditOperation) this.instance).hasInsertObjectSpan();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasReplaceAttributes() {
            return ((CoeditOperation) this.instance).hasReplaceAttributes();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasSetAnnotations() {
            return ((CoeditOperation) this.instance).hasSetAnnotations();
        }

        @Override // coeditOperation.CoeditOperationOrBuilder
        public boolean hasUpdateAttributes() {
            return ((CoeditOperation) this.instance).hasUpdateAttributes();
        }

        public Builder mergeDeleteElements(Elements elements) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeDeleteElements(elements);
            return this;
        }

        public Builder mergeDeleteObjectSpan(ObjectSpan objectSpan) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeDeleteObjectSpan(objectSpan);
            return this;
        }

        public Builder mergeInsertElements(Elements elements) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeInsertElements(elements);
            return this;
        }

        public Builder mergeInsertObjectSpan(ObjectSpan objectSpan) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeInsertObjectSpan(objectSpan);
            return this;
        }

        public Builder mergeReplaceAttributes(ReplaceAttributes replaceAttributes) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeReplaceAttributes(replaceAttributes);
            return this;
        }

        public Builder mergeSetAnnotations(SetAnnotations setAnnotations) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeSetAnnotations(setAnnotations);
            return this;
        }

        public Builder mergeUpdateAttributes(UpdateAttributes updateAttributes) {
            copyOnWrite();
            ((CoeditOperation) this.instance).mergeUpdateAttributes(updateAttributes);
            return this;
        }

        public Builder setChangeType(ChangeType changeType) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setChangeType(changeType);
            return this;
        }

        public Builder setChangeTypeValue(int i) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setChangeTypeValue(i);
            return this;
        }

        public Builder setDeleteCharacters(String str) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteCharacters(str);
            return this;
        }

        public Builder setDeleteCharactersBytes(ByteString byteString) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteCharactersBytes(byteString);
            return this;
        }

        public Builder setDeleteElements(Elements elements) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteElements(elements);
            return this;
        }

        public Builder setDeleteObjectSpan(ObjectSpan objectSpan) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteObjectSpan(objectSpan);
            return this;
        }

        public Builder setIndex(int i) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setIndex(i);
            return this;
        }

        public Builder setInsertCharacters(String str) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertCharacters(str);
            return this;
        }

        public Builder setInsertCharactersBytes(ByteString byteString) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertCharactersBytes(byteString);
            return this;
        }

        public Builder setInsertElements(Elements elements) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertElements(elements);
            return this;
        }

        public Builder setInsertObjectSpan(ObjectSpan objectSpan) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertObjectSpan(objectSpan);
            return this;
        }

        public Builder setReplaceAttributes(ReplaceAttributes replaceAttributes) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setReplaceAttributes(replaceAttributes);
            return this;
        }

        public Builder setSetAnnotations(SetAnnotations setAnnotations) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setSetAnnotations(setAnnotations);
            return this;
        }

        public Builder setSize(int i) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setSize(i);
            return this;
        }

        public Builder setUpdateAttributes(UpdateAttributes updateAttributes) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setUpdateAttributes(updateAttributes);
            return this;
        }

        private Builder() {
            super(CoeditOperation.DEFAULT_INSTANCE);
        }

        public Builder setDeleteElements(Elements.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteElements(builder.build());
            return this;
        }

        public Builder setDeleteObjectSpan(ObjectSpan.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setDeleteObjectSpan(builder.build());
            return this;
        }

        public Builder setInsertElements(Elements.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertElements(builder.build());
            return this;
        }

        public Builder setInsertObjectSpan(ObjectSpan.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setInsertObjectSpan(builder.build());
            return this;
        }

        public Builder setReplaceAttributes(ReplaceAttributes.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setReplaceAttributes(builder.build());
            return this;
        }

        public Builder setSetAnnotations(SetAnnotations.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setSetAnnotations(builder.build());
            return this;
        }

        public Builder setUpdateAttributes(UpdateAttributes.Builder builder) {
            copyOnWrite();
            ((CoeditOperation) this.instance).setUpdateAttributes(builder.build());
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Element extends GeneratedMessageLite<Element, Builder> implements ElementOrBuilder {
        public static final int ATTRIBUTE_FIELD_NUMBER = 3;
        private static final Element DEFAULT_INSTANCE;
        public static final int ELEMENT_END_FIELD_NUMBER = 1;
        private static volatile Parser<Element> PARSER = null;
        public static final int TAG_NAME_FIELD_NUMBER = 2;
        private boolean elementEnd_;
        private String tagName_ = "";
        private Internal.ProtobufList<KeyValuePair> attribute_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<Element, Builder> implements ElementOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllAttribute(Iterable<? extends KeyValuePair> iterable) {
                copyOnWrite();
                ((Element) this.instance).addAllAttribute(iterable);
                return this;
            }

            public Builder addAttribute(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((Element) this.instance).addAttribute(keyValuePair);
                return this;
            }

            public Builder clearAttribute() {
                copyOnWrite();
                ((Element) this.instance).clearAttribute();
                return this;
            }

            public Builder clearElementEnd() {
                copyOnWrite();
                ((Element) this.instance).clearElementEnd();
                return this;
            }

            public Builder clearTagName() {
                copyOnWrite();
                ((Element) this.instance).clearTagName();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public KeyValuePair getAttribute(int i) {
                return ((Element) this.instance).getAttribute(i);
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public int getAttributeCount() {
                return ((Element) this.instance).getAttributeCount();
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public List<KeyValuePair> getAttributeList() {
                return Collections.unmodifiableList(((Element) this.instance).getAttributeList());
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public boolean getElementEnd() {
                return ((Element) this.instance).getElementEnd();
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public String getTagName() {
                return ((Element) this.instance).getTagName();
            }

            @Override // coeditOperation.CoeditOperation.ElementOrBuilder
            public ByteString getTagNameBytes() {
                return ((Element) this.instance).getTagNameBytes();
            }

            public Builder removeAttribute(int i) {
                copyOnWrite();
                ((Element) this.instance).removeAttribute(i);
                return this;
            }

            public Builder setAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((Element) this.instance).setAttribute(i, keyValuePair);
                return this;
            }

            public Builder setElementEnd(boolean z) {
                copyOnWrite();
                ((Element) this.instance).setElementEnd(z);
                return this;
            }

            public Builder setTagName(String str) {
                copyOnWrite();
                ((Element) this.instance).setTagName(str);
                return this;
            }

            public Builder setTagNameBytes(ByteString byteString) {
                copyOnWrite();
                ((Element) this.instance).setTagNameBytes(byteString);
                return this;
            }

            private Builder() {
                super(Element.DEFAULT_INSTANCE);
            }

            public Builder addAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((Element) this.instance).addAttribute(i, keyValuePair);
                return this;
            }

            public Builder setAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((Element) this.instance).setAttribute(i, builder.build());
                return this;
            }

            public Builder addAttribute(KeyValuePair.Builder builder) {
                copyOnWrite();
                ((Element) this.instance).addAttribute(builder.build());
                return this;
            }

            public Builder addAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((Element) this.instance).addAttribute(i, builder.build());
                return this;
            }
        }

        static {
            Element element = new Element();
            DEFAULT_INSTANCE = element;
            GeneratedMessageLite.registerDefaultInstance(Element.class, element);
        }

        private Element() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAttribute(Iterable<? extends KeyValuePair> iterable) {
            ensureAttributeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.attribute_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttribute(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureAttributeIsMutable();
            this.attribute_.add(keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAttribute() {
            this.attribute_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElementEnd() {
            this.elementEnd_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTagName() {
            this.tagName_ = getDefaultInstance().getTagName();
        }

        private void ensureAttributeIsMutable() {
            Internal.ProtobufList<KeyValuePair> protobufList = this.attribute_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.attribute_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static Element getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Element parseDelimitedFrom(InputStream inputStream) {
            return (Element) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Element parseFrom(ByteBuffer byteBuffer) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Element> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAttribute(int i) {
            ensureAttributeIsMutable();
            this.attribute_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureAttributeIsMutable();
            this.attribute_.set(i, keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElementEnd(boolean z) {
            this.elementEnd_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTagName(String str) {
            str.getClass();
            this.tagName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTagNameBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.tagName_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new Element();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0007\u0002Ȉ\u0003\u001b", new Object[]{"elementEnd_", "tagName_", "attribute_", KeyValuePair.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Element> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Element.class) {
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

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public KeyValuePair getAttribute(int i) {
            return this.attribute_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public int getAttributeCount() {
            return this.attribute_.size();
        }

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public List<KeyValuePair> getAttributeList() {
            return this.attribute_;
        }

        public KeyValuePairOrBuilder getAttributeOrBuilder(int i) {
            return this.attribute_.get(i);
        }

        public List<? extends KeyValuePairOrBuilder> getAttributeOrBuilderList() {
            return this.attribute_;
        }

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public boolean getElementEnd() {
            return this.elementEnd_;
        }

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public String getTagName() {
            return this.tagName_;
        }

        @Override // coeditOperation.CoeditOperation.ElementOrBuilder
        public ByteString getTagNameBytes() {
            return ByteString.copyFromUtf8(this.tagName_);
        }

        public static Builder newBuilder(Element element) {
            return DEFAULT_INSTANCE.createBuilder(element);
        }

        public static Element parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Element parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Element parseFrom(ByteString byteString) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureAttributeIsMutable();
            this.attribute_.add(i, keyValuePair);
        }

        public static Element parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Element parseFrom(byte[] bArr) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Element parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Element parseFrom(InputStream inputStream) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Element parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Element parseFrom(CodedInputStream codedInputStream) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Element parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Element) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ElementOrBuilder extends MessageLiteOrBuilder {
        KeyValuePair getAttribute(int i);

        int getAttributeCount();

        List<KeyValuePair> getAttributeList();

        boolean getElementEnd();

        String getTagName();

        ByteString getTagNameBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Elements extends GeneratedMessageLite<Elements, Builder> implements ElementsOrBuilder {
        private static final Elements DEFAULT_INSTANCE;
        public static final int ELEMENT_FIELD_NUMBER = 1;
        private static volatile Parser<Elements> PARSER;
        private Internal.ProtobufList<Element> element_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<Elements, Builder> implements ElementsOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllElement(Iterable<? extends Element> iterable) {
                copyOnWrite();
                ((Elements) this.instance).addAllElement(iterable);
                return this;
            }

            public Builder addElement(Element element) {
                copyOnWrite();
                ((Elements) this.instance).addElement(element);
                return this;
            }

            public Builder clearElement() {
                copyOnWrite();
                ((Elements) this.instance).clearElement();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
            public Element getElement(int i) {
                return ((Elements) this.instance).getElement(i);
            }

            @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
            public int getElementCount() {
                return ((Elements) this.instance).getElementCount();
            }

            @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
            public List<Element> getElementList() {
                return Collections.unmodifiableList(((Elements) this.instance).getElementList());
            }

            public Builder removeElement(int i) {
                copyOnWrite();
                ((Elements) this.instance).removeElement(i);
                return this;
            }

            public Builder setElement(int i, Element element) {
                copyOnWrite();
                ((Elements) this.instance).setElement(i, element);
                return this;
            }

            private Builder() {
                super(Elements.DEFAULT_INSTANCE);
            }

            public Builder addElement(int i, Element element) {
                copyOnWrite();
                ((Elements) this.instance).addElement(i, element);
                return this;
            }

            public Builder setElement(int i, Element.Builder builder) {
                copyOnWrite();
                ((Elements) this.instance).setElement(i, builder.build());
                return this;
            }

            public Builder addElement(Element.Builder builder) {
                copyOnWrite();
                ((Elements) this.instance).addElement(builder.build());
                return this;
            }

            public Builder addElement(int i, Element.Builder builder) {
                copyOnWrite();
                ((Elements) this.instance).addElement(i, builder.build());
                return this;
            }
        }

        static {
            Elements elements = new Elements();
            DEFAULT_INSTANCE = elements;
            GeneratedMessageLite.registerDefaultInstance(Elements.class, elements);
        }

        private Elements() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllElement(Iterable<? extends Element> iterable) {
            ensureElementIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.element_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addElement(Element element) {
            element.getClass();
            ensureElementIsMutable();
            this.element_.add(element);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElement() {
            this.element_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureElementIsMutable() {
            Internal.ProtobufList<Element> protobufList = this.element_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.element_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static Elements getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Elements parseDelimitedFrom(InputStream inputStream) {
            return (Elements) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Elements parseFrom(ByteBuffer byteBuffer) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Elements> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeElement(int i) {
            ensureElementIsMutable();
            this.element_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElement(int i, Element element) {
            element.getClass();
            ensureElementIsMutable();
            this.element_.set(i, element);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new Elements();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"element_", Element.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Elements> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Elements.class) {
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

        @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
        public Element getElement(int i) {
            return this.element_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
        public int getElementCount() {
            return this.element_.size();
        }

        @Override // coeditOperation.CoeditOperation.ElementsOrBuilder
        public List<Element> getElementList() {
            return this.element_;
        }

        public ElementOrBuilder getElementOrBuilder(int i) {
            return this.element_.get(i);
        }

        public List<? extends ElementOrBuilder> getElementOrBuilderList() {
            return this.element_;
        }

        public static Builder newBuilder(Elements elements) {
            return DEFAULT_INSTANCE.createBuilder(elements);
        }

        public static Elements parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Elements parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Elements parseFrom(ByteString byteString) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addElement(int i, Element element) {
            element.getClass();
            ensureElementIsMutable();
            this.element_.add(i, element);
        }

        public static Elements parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Elements parseFrom(byte[] bArr) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Elements parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Elements parseFrom(InputStream inputStream) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Elements parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Elements parseFrom(CodedInputStream codedInputStream) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Elements parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Elements) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ElementsOrBuilder extends MessageLiteOrBuilder {
        Element getElement(int i);

        int getElementCount();

        List<Element> getElementList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class KeyValuePair extends GeneratedMessageLite<KeyValuePair, Builder> implements KeyValuePairOrBuilder {
        private static final KeyValuePair DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        private static volatile Parser<KeyValuePair> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private String key_ = "";
        private String value_ = "";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<KeyValuePair, Builder> implements KeyValuePairOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValuePair) this.instance).clearKey();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((KeyValuePair) this.instance).clearValue();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
            public String getKey() {
                return ((KeyValuePair) this.instance).getKey();
            }

            @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
            public ByteString getKeyBytes() {
                return ((KeyValuePair) this.instance).getKeyBytes();
            }

            @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
            public String getValue() {
                return ((KeyValuePair) this.instance).getValue();
            }

            @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
            public ByteString getValueBytes() {
                return ((KeyValuePair) this.instance).getValueBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setKey(str);
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setKeyBytes(byteString);
                return this;
            }

            public Builder setValue(String str) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setValue(str);
                return this;
            }

            public Builder setValueBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValuePair) this.instance).setValueBytes(byteString);
                return this;
            }

            private Builder() {
                super(KeyValuePair.DEFAULT_INSTANCE);
            }
        }

        static {
            KeyValuePair keyValuePair = new KeyValuePair();
            DEFAULT_INSTANCE = keyValuePair;
            GeneratedMessageLite.registerDefaultInstance(KeyValuePair.class, keyValuePair);
        }

        private KeyValuePair() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static KeyValuePair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static KeyValuePair parseDelimitedFrom(InputStream inputStream) {
            return (KeyValuePair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValuePair parseFrom(ByteBuffer byteBuffer) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<KeyValuePair> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(String str) {
            str.getClass();
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.value_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyValuePair();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"key_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<KeyValuePair> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (KeyValuePair.class) {
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

        @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
        public String getValue() {
            return this.value_;
        }

        @Override // coeditOperation.CoeditOperation.KeyValuePairOrBuilder
        public ByteString getValueBytes() {
            return ByteString.copyFromUtf8(this.value_);
        }

        public static Builder newBuilder(KeyValuePair keyValuePair) {
            return DEFAULT_INSTANCE.createBuilder(keyValuePair);
        }

        public static KeyValuePair parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyValuePair parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KeyValuePair parseFrom(ByteString byteString) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KeyValuePair parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KeyValuePair parseFrom(byte[] bArr) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyValuePair parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KeyValuePair parseFrom(InputStream inputStream) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValuePair parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyValuePair parseFrom(CodedInputStream codedInputStream) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KeyValuePair parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValuePair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeyValuePairOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        String getValue();

        ByteString getValueBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class KeyValueUpdate extends GeneratedMessageLite<KeyValueUpdate, Builder> implements KeyValueUpdateOrBuilder {
        private static final KeyValueUpdate DEFAULT_INSTANCE;
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int NEW_VALUE_FIELD_NUMBER = 3;
        public static final int OLD_VALUE_FIELD_NUMBER = 2;
        private static volatile Parser<KeyValueUpdate> PARSER;
        private String key_ = "";
        private String oldValue_ = "";
        private String newValue_ = "";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<KeyValueUpdate, Builder> implements KeyValueUpdateOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder clearKey() {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).clearKey();
                return this;
            }

            public Builder clearNewValue() {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).clearNewValue();
                return this;
            }

            public Builder clearOldValue() {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).clearOldValue();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public String getKey() {
                return ((KeyValueUpdate) this.instance).getKey();
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public ByteString getKeyBytes() {
                return ((KeyValueUpdate) this.instance).getKeyBytes();
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public String getNewValue() {
                return ((KeyValueUpdate) this.instance).getNewValue();
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public ByteString getNewValueBytes() {
                return ((KeyValueUpdate) this.instance).getNewValueBytes();
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public String getOldValue() {
                return ((KeyValueUpdate) this.instance).getOldValue();
            }

            @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
            public ByteString getOldValueBytes() {
                return ((KeyValueUpdate) this.instance).getOldValueBytes();
            }

            public Builder setKey(String str) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setKey(str);
                return this;
            }

            public Builder setKeyBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setKeyBytes(byteString);
                return this;
            }

            public Builder setNewValue(String str) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setNewValue(str);
                return this;
            }

            public Builder setNewValueBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setNewValueBytes(byteString);
                return this;
            }

            public Builder setOldValue(String str) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setOldValue(str);
                return this;
            }

            public Builder setOldValueBytes(ByteString byteString) {
                copyOnWrite();
                ((KeyValueUpdate) this.instance).setOldValueBytes(byteString);
                return this;
            }

            private Builder() {
                super(KeyValueUpdate.DEFAULT_INSTANCE);
            }
        }

        static {
            KeyValueUpdate keyValueUpdate = new KeyValueUpdate();
            DEFAULT_INSTANCE = keyValueUpdate;
            GeneratedMessageLite.registerDefaultInstance(KeyValueUpdate.class, keyValueUpdate);
        }

        private KeyValueUpdate() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKey() {
            this.key_ = getDefaultInstance().getKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewValue() {
            this.newValue_ = getDefaultInstance().getNewValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOldValue() {
            this.oldValue_ = getDefaultInstance().getOldValue();
        }

        public static KeyValueUpdate getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static KeyValueUpdate parseDelimitedFrom(InputStream inputStream) {
            return (KeyValueUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValueUpdate parseFrom(ByteBuffer byteBuffer) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<KeyValueUpdate> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKey(String str) {
            str.getClass();
            this.key_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.key_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewValue(String str) {
            str.getClass();
            this.newValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.newValue_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOldValue(String str) {
            str.getClass();
            this.oldValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOldValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.oldValue_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyValueUpdate();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"key_", "oldValue_", "newValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<KeyValueUpdate> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (KeyValueUpdate.class) {
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

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public String getKey() {
            return this.key_;
        }

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public ByteString getKeyBytes() {
            return ByteString.copyFromUtf8(this.key_);
        }

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public String getNewValue() {
            return this.newValue_;
        }

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public ByteString getNewValueBytes() {
            return ByteString.copyFromUtf8(this.newValue_);
        }

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public String getOldValue() {
            return this.oldValue_;
        }

        @Override // coeditOperation.CoeditOperation.KeyValueUpdateOrBuilder
        public ByteString getOldValueBytes() {
            return ByteString.copyFromUtf8(this.oldValue_);
        }

        public static Builder newBuilder(KeyValueUpdate keyValueUpdate) {
            return DEFAULT_INSTANCE.createBuilder(keyValueUpdate);
        }

        public static KeyValueUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyValueUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static KeyValueUpdate parseFrom(ByteString byteString) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KeyValueUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static KeyValueUpdate parseFrom(byte[] bArr) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyValueUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static KeyValueUpdate parseFrom(InputStream inputStream) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyValueUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static KeyValueUpdate parseFrom(CodedInputStream codedInputStream) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static KeyValueUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (KeyValueUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeyValueUpdateOrBuilder extends MessageLiteOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        String getNewValue();

        ByteString getNewValueBytes();

        String getOldValue();

        ByteString getOldValueBytes();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ObjectSpan extends GeneratedMessageLite<ObjectSpan, Builder> implements ObjectSpanOrBuilder {
        private static final ObjectSpan DEFAULT_INSTANCE;
        public static final int OBJECT_SPAN_FIELD_NUMBER = 1;
        private static volatile Parser<ObjectSpan> PARSER;
        private KeyValuePair objectSpan_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<ObjectSpan, Builder> implements ObjectSpanOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder clearObjectSpan() {
                copyOnWrite();
                ((ObjectSpan) this.instance).clearObjectSpan();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.ObjectSpanOrBuilder
            public KeyValuePair getObjectSpan() {
                return ((ObjectSpan) this.instance).getObjectSpan();
            }

            @Override // coeditOperation.CoeditOperation.ObjectSpanOrBuilder
            public boolean hasObjectSpan() {
                return ((ObjectSpan) this.instance).hasObjectSpan();
            }

            public Builder mergeObjectSpan(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ObjectSpan) this.instance).mergeObjectSpan(keyValuePair);
                return this;
            }

            public Builder setObjectSpan(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ObjectSpan) this.instance).setObjectSpan(keyValuePair);
                return this;
            }

            private Builder() {
                super(ObjectSpan.DEFAULT_INSTANCE);
            }

            public Builder setObjectSpan(KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ObjectSpan) this.instance).setObjectSpan(builder.build());
                return this;
            }
        }

        static {
            ObjectSpan objectSpan = new ObjectSpan();
            DEFAULT_INSTANCE = objectSpan;
            GeneratedMessageLite.registerDefaultInstance(ObjectSpan.class, objectSpan);
        }

        private ObjectSpan() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearObjectSpan() {
            this.objectSpan_ = null;
        }

        public static ObjectSpan getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeObjectSpan(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            KeyValuePair keyValuePair2 = this.objectSpan_;
            if (keyValuePair2 == null || keyValuePair2 == KeyValuePair.getDefaultInstance()) {
                this.objectSpan_ = keyValuePair;
            } else {
                this.objectSpan_ = KeyValuePair.newBuilder(this.objectSpan_).mergeFrom(keyValuePair).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ObjectSpan parseDelimitedFrom(InputStream inputStream) {
            return (ObjectSpan) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ObjectSpan parseFrom(ByteBuffer byteBuffer) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ObjectSpan> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setObjectSpan(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            this.objectSpan_ = keyValuePair;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ObjectSpan();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"objectSpan_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ObjectSpan> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ObjectSpan.class) {
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

        @Override // coeditOperation.CoeditOperation.ObjectSpanOrBuilder
        public KeyValuePair getObjectSpan() {
            KeyValuePair keyValuePair = this.objectSpan_;
            return keyValuePair == null ? KeyValuePair.getDefaultInstance() : keyValuePair;
        }

        @Override // coeditOperation.CoeditOperation.ObjectSpanOrBuilder
        public boolean hasObjectSpan() {
            return this.objectSpan_ != null;
        }

        public static Builder newBuilder(ObjectSpan objectSpan) {
            return DEFAULT_INSTANCE.createBuilder(objectSpan);
        }

        public static ObjectSpan parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ObjectSpan parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ObjectSpan parseFrom(ByteString byteString) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ObjectSpan parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ObjectSpan parseFrom(byte[] bArr) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ObjectSpan parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ObjectSpan parseFrom(InputStream inputStream) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ObjectSpan parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ObjectSpan parseFrom(CodedInputStream codedInputStream) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ObjectSpan parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ObjectSpan) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ObjectSpanOrBuilder extends MessageLiteOrBuilder {
        KeyValuePair getObjectSpan();

        boolean hasObjectSpan();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReplaceAttributes extends GeneratedMessageLite<ReplaceAttributes, Builder> implements ReplaceAttributesOrBuilder {
        private static final ReplaceAttributes DEFAULT_INSTANCE;
        public static final int NEW_ATTRIBUTE_FIELD_NUMBER = 2;
        public static final int OLD_ATTRIBUTE_FIELD_NUMBER = 1;
        private static volatile Parser<ReplaceAttributes> PARSER;
        private Internal.ProtobufList<KeyValuePair> oldAttribute_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<KeyValuePair> newAttribute_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<ReplaceAttributes, Builder> implements ReplaceAttributesOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllNewAttribute(Iterable<? extends KeyValuePair> iterable) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addAllNewAttribute(iterable);
                return this;
            }

            public Builder addAllOldAttribute(Iterable<? extends KeyValuePair> iterable) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addAllOldAttribute(iterable);
                return this;
            }

            public Builder addNewAttribute(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addNewAttribute(keyValuePair);
                return this;
            }

            public Builder addOldAttribute(KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addOldAttribute(keyValuePair);
                return this;
            }

            public Builder clearNewAttribute() {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).clearNewAttribute();
                return this;
            }

            public Builder clearOldAttribute() {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).clearOldAttribute();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public KeyValuePair getNewAttribute(int i) {
                return ((ReplaceAttributes) this.instance).getNewAttribute(i);
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public int getNewAttributeCount() {
                return ((ReplaceAttributes) this.instance).getNewAttributeCount();
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public List<KeyValuePair> getNewAttributeList() {
                return Collections.unmodifiableList(((ReplaceAttributes) this.instance).getNewAttributeList());
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public KeyValuePair getOldAttribute(int i) {
                return ((ReplaceAttributes) this.instance).getOldAttribute(i);
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public int getOldAttributeCount() {
                return ((ReplaceAttributes) this.instance).getOldAttributeCount();
            }

            @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
            public List<KeyValuePair> getOldAttributeList() {
                return Collections.unmodifiableList(((ReplaceAttributes) this.instance).getOldAttributeList());
            }

            public Builder removeNewAttribute(int i) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).removeNewAttribute(i);
                return this;
            }

            public Builder removeOldAttribute(int i) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).removeOldAttribute(i);
                return this;
            }

            public Builder setNewAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).setNewAttribute(i, keyValuePair);
                return this;
            }

            public Builder setOldAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).setOldAttribute(i, keyValuePair);
                return this;
            }

            private Builder() {
                super(ReplaceAttributes.DEFAULT_INSTANCE);
            }

            public Builder addNewAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addNewAttribute(i, keyValuePair);
                return this;
            }

            public Builder addOldAttribute(int i, KeyValuePair keyValuePair) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addOldAttribute(i, keyValuePair);
                return this;
            }

            public Builder setNewAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).setNewAttribute(i, builder.build());
                return this;
            }

            public Builder setOldAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).setOldAttribute(i, builder.build());
                return this;
            }

            public Builder addNewAttribute(KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addNewAttribute(builder.build());
                return this;
            }

            public Builder addOldAttribute(KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addOldAttribute(builder.build());
                return this;
            }

            public Builder addNewAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addNewAttribute(i, builder.build());
                return this;
            }

            public Builder addOldAttribute(int i, KeyValuePair.Builder builder) {
                copyOnWrite();
                ((ReplaceAttributes) this.instance).addOldAttribute(i, builder.build());
                return this;
            }
        }

        static {
            ReplaceAttributes replaceAttributes = new ReplaceAttributes();
            DEFAULT_INSTANCE = replaceAttributes;
            GeneratedMessageLite.registerDefaultInstance(ReplaceAttributes.class, replaceAttributes);
        }

        private ReplaceAttributes() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllNewAttribute(Iterable<? extends KeyValuePair> iterable) {
            ensureNewAttributeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.newAttribute_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllOldAttribute(Iterable<? extends KeyValuePair> iterable) {
            ensureOldAttributeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.oldAttribute_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNewAttribute(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureNewAttributeIsMutable();
            this.newAttribute_.add(keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOldAttribute(KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureOldAttributeIsMutable();
            this.oldAttribute_.add(keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNewAttribute() {
            this.newAttribute_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOldAttribute() {
            this.oldAttribute_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureNewAttributeIsMutable() {
            Internal.ProtobufList<KeyValuePair> protobufList = this.newAttribute_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.newAttribute_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        private void ensureOldAttributeIsMutable() {
            Internal.ProtobufList<KeyValuePair> protobufList = this.oldAttribute_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.oldAttribute_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ReplaceAttributes getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ReplaceAttributes parseDelimitedFrom(InputStream inputStream) {
            return (ReplaceAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReplaceAttributes parseFrom(ByteBuffer byteBuffer) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ReplaceAttributes> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeNewAttribute(int i) {
            ensureNewAttributeIsMutable();
            this.newAttribute_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeOldAttribute(int i) {
            ensureOldAttributeIsMutable();
            this.oldAttribute_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNewAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureNewAttributeIsMutable();
            this.newAttribute_.set(i, keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOldAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureOldAttributeIsMutable();
            this.oldAttribute_.set(i, keyValuePair);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReplaceAttributes();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"oldAttribute_", KeyValuePair.class, "newAttribute_", KeyValuePair.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReplaceAttributes> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ReplaceAttributes.class) {
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

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public KeyValuePair getNewAttribute(int i) {
            return this.newAttribute_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public int getNewAttributeCount() {
            return this.newAttribute_.size();
        }

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public List<KeyValuePair> getNewAttributeList() {
            return this.newAttribute_;
        }

        public KeyValuePairOrBuilder getNewAttributeOrBuilder(int i) {
            return this.newAttribute_.get(i);
        }

        public List<? extends KeyValuePairOrBuilder> getNewAttributeOrBuilderList() {
            return this.newAttribute_;
        }

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public KeyValuePair getOldAttribute(int i) {
            return this.oldAttribute_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public int getOldAttributeCount() {
            return this.oldAttribute_.size();
        }

        @Override // coeditOperation.CoeditOperation.ReplaceAttributesOrBuilder
        public List<KeyValuePair> getOldAttributeList() {
            return this.oldAttribute_;
        }

        public KeyValuePairOrBuilder getOldAttributeOrBuilder(int i) {
            return this.oldAttribute_.get(i);
        }

        public List<? extends KeyValuePairOrBuilder> getOldAttributeOrBuilderList() {
            return this.oldAttribute_;
        }

        public static Builder newBuilder(ReplaceAttributes replaceAttributes) {
            return DEFAULT_INSTANCE.createBuilder(replaceAttributes);
        }

        public static ReplaceAttributes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReplaceAttributes parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReplaceAttributes parseFrom(ByteString byteString) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addNewAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureNewAttributeIsMutable();
            this.newAttribute_.add(i, keyValuePair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOldAttribute(int i, KeyValuePair keyValuePair) {
            keyValuePair.getClass();
            ensureOldAttributeIsMutable();
            this.oldAttribute_.add(i, keyValuePair);
        }

        public static ReplaceAttributes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReplaceAttributes parseFrom(byte[] bArr) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReplaceAttributes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReplaceAttributes parseFrom(InputStream inputStream) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReplaceAttributes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReplaceAttributes parseFrom(CodedInputStream codedInputStream) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReplaceAttributes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReplaceAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ReplaceAttributesOrBuilder extends MessageLiteOrBuilder {
        KeyValuePair getNewAttribute(int i);

        int getNewAttributeCount();

        List<KeyValuePair> getNewAttributeList();

        KeyValuePair getOldAttribute(int i);

        int getOldAttributeCount();

        List<KeyValuePair> getOldAttributeList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SetAnnotations extends GeneratedMessageLite<SetAnnotations, Builder> implements SetAnnotationsOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 2;
        private static final SetAnnotations DEFAULT_INSTANCE;
        public static final int END_INDEX_FIELD_NUMBER = 1;
        private static volatile Parser<SetAnnotations> PARSER;
        private Internal.ProtobufList<KeyValueUpdate> annotation_ = GeneratedMessageLite.emptyProtobufList();
        private int endIndex_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<SetAnnotations, Builder> implements SetAnnotationsOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllAnnotation(Iterable<? extends KeyValueUpdate> iterable) {
                copyOnWrite();
                ((SetAnnotations) this.instance).addAllAnnotation(iterable);
                return this;
            }

            public Builder addAnnotation(KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((SetAnnotations) this.instance).addAnnotation(keyValueUpdate);
                return this;
            }

            public Builder clearAnnotation() {
                copyOnWrite();
                ((SetAnnotations) this.instance).clearAnnotation();
                return this;
            }

            public Builder clearEndIndex() {
                copyOnWrite();
                ((SetAnnotations) this.instance).clearEndIndex();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
            public KeyValueUpdate getAnnotation(int i) {
                return ((SetAnnotations) this.instance).getAnnotation(i);
            }

            @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
            public int getAnnotationCount() {
                return ((SetAnnotations) this.instance).getAnnotationCount();
            }

            @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
            public List<KeyValueUpdate> getAnnotationList() {
                return Collections.unmodifiableList(((SetAnnotations) this.instance).getAnnotationList());
            }

            @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
            public int getEndIndex() {
                return ((SetAnnotations) this.instance).getEndIndex();
            }

            public Builder removeAnnotation(int i) {
                copyOnWrite();
                ((SetAnnotations) this.instance).removeAnnotation(i);
                return this;
            }

            public Builder setAnnotation(int i, KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((SetAnnotations) this.instance).setAnnotation(i, keyValueUpdate);
                return this;
            }

            public Builder setEndIndex(int i) {
                copyOnWrite();
                ((SetAnnotations) this.instance).setEndIndex(i);
                return this;
            }

            private Builder() {
                super(SetAnnotations.DEFAULT_INSTANCE);
            }

            public Builder addAnnotation(int i, KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((SetAnnotations) this.instance).addAnnotation(i, keyValueUpdate);
                return this;
            }

            public Builder setAnnotation(int i, KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((SetAnnotations) this.instance).setAnnotation(i, builder.build());
                return this;
            }

            public Builder addAnnotation(KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((SetAnnotations) this.instance).addAnnotation(builder.build());
                return this;
            }

            public Builder addAnnotation(int i, KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((SetAnnotations) this.instance).addAnnotation(i, builder.build());
                return this;
            }
        }

        static {
            SetAnnotations setAnnotations = new SetAnnotations();
            DEFAULT_INSTANCE = setAnnotations;
            GeneratedMessageLite.registerDefaultInstance(SetAnnotations.class, setAnnotations);
        }

        private SetAnnotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAnnotation(Iterable<? extends KeyValueUpdate> iterable) {
            ensureAnnotationIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.annotation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.add(keyValueUpdate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAnnotation() {
            this.annotation_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndIndex() {
            this.endIndex_ = 0;
        }

        private void ensureAnnotationIsMutable() {
            Internal.ProtobufList<KeyValueUpdate> protobufList = this.annotation_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.annotation_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static SetAnnotations getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static SetAnnotations parseDelimitedFrom(InputStream inputStream) {
            return (SetAnnotations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetAnnotations parseFrom(ByteBuffer byteBuffer) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<SetAnnotations> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAnnotation(int i) {
            ensureAnnotationIsMutable();
            this.annotation_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAnnotation(int i, KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.set(i, keyValueUpdate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndIndex(int i) {
            this.endIndex_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new SetAnnotations();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"endIndex_", "annotation_", KeyValueUpdate.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SetAnnotations> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SetAnnotations.class) {
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

        @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
        public KeyValueUpdate getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
        public List<KeyValueUpdate> getAnnotationList() {
            return this.annotation_;
        }

        public KeyValueUpdateOrBuilder getAnnotationOrBuilder(int i) {
            return this.annotation_.get(i);
        }

        public List<? extends KeyValueUpdateOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // coeditOperation.CoeditOperation.SetAnnotationsOrBuilder
        public int getEndIndex() {
            return this.endIndex_;
        }

        public static Builder newBuilder(SetAnnotations setAnnotations) {
            return DEFAULT_INSTANCE.createBuilder(setAnnotations);
        }

        public static SetAnnotations parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetAnnotations parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SetAnnotations parseFrom(ByteString byteString) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAnnotation(int i, KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureAnnotationIsMutable();
            this.annotation_.add(i, keyValueUpdate);
        }

        public static SetAnnotations parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SetAnnotations parseFrom(byte[] bArr) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SetAnnotations parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SetAnnotations parseFrom(InputStream inputStream) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetAnnotations parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetAnnotations parseFrom(CodedInputStream codedInputStream) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SetAnnotations parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (SetAnnotations) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SetAnnotationsOrBuilder extends MessageLiteOrBuilder {
        KeyValueUpdate getAnnotation(int i);

        int getAnnotationCount();

        List<KeyValueUpdate> getAnnotationList();

        int getEndIndex();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UpdateAttributes extends GeneratedMessageLite<UpdateAttributes, Builder> implements UpdateAttributesOrBuilder {
        public static final int CHANGE_FIELD_NUMBER = 1;
        private static final UpdateAttributes DEFAULT_INSTANCE;
        private static volatile Parser<UpdateAttributes> PARSER;
        private Internal.ProtobufList<KeyValueUpdate> change_ = GeneratedMessageLite.emptyProtobufList();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<UpdateAttributes, Builder> implements UpdateAttributesOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllChange(Iterable<? extends KeyValueUpdate> iterable) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).addAllChange(iterable);
                return this;
            }

            public Builder addChange(KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).addChange(keyValueUpdate);
                return this;
            }

            public Builder clearChange() {
                copyOnWrite();
                ((UpdateAttributes) this.instance).clearChange();
                return this;
            }

            @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
            public KeyValueUpdate getChange(int i) {
                return ((UpdateAttributes) this.instance).getChange(i);
            }

            @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
            public int getChangeCount() {
                return ((UpdateAttributes) this.instance).getChangeCount();
            }

            @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
            public List<KeyValueUpdate> getChangeList() {
                return Collections.unmodifiableList(((UpdateAttributes) this.instance).getChangeList());
            }

            public Builder removeChange(int i) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).removeChange(i);
                return this;
            }

            public Builder setChange(int i, KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).setChange(i, keyValueUpdate);
                return this;
            }

            private Builder() {
                super(UpdateAttributes.DEFAULT_INSTANCE);
            }

            public Builder addChange(int i, KeyValueUpdate keyValueUpdate) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).addChange(i, keyValueUpdate);
                return this;
            }

            public Builder setChange(int i, KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).setChange(i, builder.build());
                return this;
            }

            public Builder addChange(KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).addChange(builder.build());
                return this;
            }

            public Builder addChange(int i, KeyValueUpdate.Builder builder) {
                copyOnWrite();
                ((UpdateAttributes) this.instance).addChange(i, builder.build());
                return this;
            }
        }

        static {
            UpdateAttributes updateAttributes = new UpdateAttributes();
            DEFAULT_INSTANCE = updateAttributes;
            GeneratedMessageLite.registerDefaultInstance(UpdateAttributes.class, updateAttributes);
        }

        private UpdateAttributes() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChange(Iterable<? extends KeyValueUpdate> iterable) {
            ensureChangeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.change_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChange(KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureChangeIsMutable();
            this.change_.add(keyValueUpdate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChange() {
            this.change_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureChangeIsMutable() {
            Internal.ProtobufList<KeyValueUpdate> protobufList = this.change_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.change_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static UpdateAttributes getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static UpdateAttributes parseDelimitedFrom(InputStream inputStream) {
            return (UpdateAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpdateAttributes parseFrom(ByteBuffer byteBuffer) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<UpdateAttributes> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChange(int i) {
            ensureChangeIsMutable();
            this.change_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChange(int i, KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureChangeIsMutable();
            this.change_.set(i, keyValueUpdate);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new UpdateAttributes();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"change_", KeyValueUpdate.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UpdateAttributes> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (UpdateAttributes.class) {
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

        @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
        public KeyValueUpdate getChange(int i) {
            return this.change_.get(i);
        }

        @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
        public int getChangeCount() {
            return this.change_.size();
        }

        @Override // coeditOperation.CoeditOperation.UpdateAttributesOrBuilder
        public List<KeyValueUpdate> getChangeList() {
            return this.change_;
        }

        public KeyValueUpdateOrBuilder getChangeOrBuilder(int i) {
            return this.change_.get(i);
        }

        public List<? extends KeyValueUpdateOrBuilder> getChangeOrBuilderList() {
            return this.change_;
        }

        public static Builder newBuilder(UpdateAttributes updateAttributes) {
            return DEFAULT_INSTANCE.createBuilder(updateAttributes);
        }

        public static UpdateAttributes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpdateAttributes parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UpdateAttributes parseFrom(ByteString byteString) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChange(int i, KeyValueUpdate keyValueUpdate) {
            keyValueUpdate.getClass();
            ensureChangeIsMutable();
            this.change_.add(i, keyValueUpdate);
        }

        public static UpdateAttributes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UpdateAttributes parseFrom(byte[] bArr) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UpdateAttributes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UpdateAttributes parseFrom(InputStream inputStream) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpdateAttributes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpdateAttributes parseFrom(CodedInputStream codedInputStream) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UpdateAttributes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (UpdateAttributes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UpdateAttributesOrBuilder extends MessageLiteOrBuilder {
        KeyValueUpdate getChange(int i);

        int getChangeCount();

        List<KeyValueUpdate> getChangeList();
    }

    static {
        CoeditOperation coeditOperation2 = new CoeditOperation();
        DEFAULT_INSTANCE = coeditOperation2;
        GeneratedMessageLite.registerDefaultInstance(CoeditOperation.class, coeditOperation2);
    }

    private CoeditOperation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChangeType() {
        this.changeType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleteCharacters() {
        this.deleteCharacters_ = getDefaultInstance().getDeleteCharacters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleteElements() {
        this.deleteElements_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeleteObjectSpan() {
        this.deleteObjectSpan_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIndex() {
        this.index_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInsertCharacters() {
        this.insertCharacters_ = getDefaultInstance().getInsertCharacters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInsertElements() {
        this.insertElements_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInsertObjectSpan() {
        this.insertObjectSpan_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReplaceAttributes() {
        this.replaceAttributes_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSetAnnotations() {
        this.setAnnotations_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdateAttributes() {
        this.updateAttributes_ = null;
    }

    public static CoeditOperation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDeleteElements(Elements elements) {
        elements.getClass();
        Elements elements2 = this.deleteElements_;
        if (elements2 == null || elements2 == Elements.getDefaultInstance()) {
            this.deleteElements_ = elements;
        } else {
            this.deleteElements_ = Elements.newBuilder(this.deleteElements_).mergeFrom(elements).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDeleteObjectSpan(ObjectSpan objectSpan) {
        objectSpan.getClass();
        ObjectSpan objectSpan2 = this.deleteObjectSpan_;
        if (objectSpan2 == null || objectSpan2 == ObjectSpan.getDefaultInstance()) {
            this.deleteObjectSpan_ = objectSpan;
        } else {
            this.deleteObjectSpan_ = ObjectSpan.newBuilder(this.deleteObjectSpan_).mergeFrom(objectSpan).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInsertElements(Elements elements) {
        elements.getClass();
        Elements elements2 = this.insertElements_;
        if (elements2 == null || elements2 == Elements.getDefaultInstance()) {
            this.insertElements_ = elements;
        } else {
            this.insertElements_ = Elements.newBuilder(this.insertElements_).mergeFrom(elements).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeInsertObjectSpan(ObjectSpan objectSpan) {
        objectSpan.getClass();
        ObjectSpan objectSpan2 = this.insertObjectSpan_;
        if (objectSpan2 == null || objectSpan2 == ObjectSpan.getDefaultInstance()) {
            this.insertObjectSpan_ = objectSpan;
        } else {
            this.insertObjectSpan_ = ObjectSpan.newBuilder(this.insertObjectSpan_).mergeFrom(objectSpan).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReplaceAttributes(ReplaceAttributes replaceAttributes) {
        replaceAttributes.getClass();
        ReplaceAttributes replaceAttributes2 = this.replaceAttributes_;
        if (replaceAttributes2 == null || replaceAttributes2 == ReplaceAttributes.getDefaultInstance()) {
            this.replaceAttributes_ = replaceAttributes;
        } else {
            this.replaceAttributes_ = ReplaceAttributes.newBuilder(this.replaceAttributes_).mergeFrom(replaceAttributes).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSetAnnotations(SetAnnotations setAnnotations) {
        setAnnotations.getClass();
        SetAnnotations setAnnotations2 = this.setAnnotations_;
        if (setAnnotations2 == null || setAnnotations2 == SetAnnotations.getDefaultInstance()) {
            this.setAnnotations_ = setAnnotations;
        } else {
            this.setAnnotations_ = SetAnnotations.newBuilder(this.setAnnotations_).mergeFrom(setAnnotations).buildPartial();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUpdateAttributes(UpdateAttributes updateAttributes) {
        updateAttributes.getClass();
        UpdateAttributes updateAttributes2 = this.updateAttributes_;
        if (updateAttributes2 == null || updateAttributes2 == UpdateAttributes.getDefaultInstance()) {
            this.updateAttributes_ = updateAttributes;
        } else {
            this.updateAttributes_ = UpdateAttributes.newBuilder(this.updateAttributes_).mergeFrom(updateAttributes).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CoeditOperation parseDelimitedFrom(InputStream inputStream) {
        return (CoeditOperation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoeditOperation parseFrom(ByteBuffer byteBuffer) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CoeditOperation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeType(ChangeType changeType) {
        this.changeType_ = changeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeTypeValue(int i) {
        this.changeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteCharacters(String str) {
        str.getClass();
        this.deleteCharacters_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteCharactersBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.deleteCharacters_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteElements(Elements elements) {
        elements.getClass();
        this.deleteElements_ = elements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeleteObjectSpan(ObjectSpan objectSpan) {
        objectSpan.getClass();
        this.deleteObjectSpan_ = objectSpan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndex(int i) {
        this.index_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInsertCharacters(String str) {
        str.getClass();
        this.insertCharacters_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInsertCharactersBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.insertCharacters_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInsertElements(Elements elements) {
        elements.getClass();
        this.insertElements_ = elements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInsertObjectSpan(ObjectSpan objectSpan) {
        objectSpan.getClass();
        this.insertObjectSpan_ = objectSpan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReplaceAttributes(ReplaceAttributes replaceAttributes) {
        replaceAttributes.getClass();
        this.replaceAttributes_ = replaceAttributes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSetAnnotations(SetAnnotations setAnnotations) {
        setAnnotations.getClass();
        this.setAnnotations_ = setAnnotations;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(int i) {
        this.size_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateAttributes(UpdateAttributes updateAttributes) {
        updateAttributes.getClass();
        this.updateAttributes_ = updateAttributes;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (C42831.f1894xa1df5c61[methodToInvoke.ordinal()]) {
            case 1:
                return new CoeditOperation();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001\f\u0002\u0004\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006\t\u0007\t\b\t\t\t\n\t\u000b\t\f\t", new Object[]{"changeType_", TableInfo.Index.DEFAULT_PREFIX, "size_", "insertCharacters_", "deleteCharacters_", "insertElements_", "deleteElements_", "updateAttributes_", "replaceAttributes_", "setAnnotations_", "insertObjectSpan_", "deleteObjectSpan_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CoeditOperation> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CoeditOperation.class) {
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

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ChangeType getChangeType() {
        ChangeType changeTypeForNumber = ChangeType.forNumber(this.changeType_);
        return changeTypeForNumber == null ? ChangeType.UNRECOGNIZED : changeTypeForNumber;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public int getChangeTypeValue() {
        return this.changeType_;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public String getDeleteCharacters() {
        return this.deleteCharacters_;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ByteString getDeleteCharactersBytes() {
        return ByteString.copyFromUtf8(this.deleteCharacters_);
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public Elements getDeleteElements() {
        Elements elements = this.deleteElements_;
        return elements == null ? Elements.getDefaultInstance() : elements;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ObjectSpan getDeleteObjectSpan() {
        ObjectSpan objectSpan = this.deleteObjectSpan_;
        return objectSpan == null ? ObjectSpan.getDefaultInstance() : objectSpan;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public int getIndex() {
        return this.index_;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public String getInsertCharacters() {
        return this.insertCharacters_;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ByteString getInsertCharactersBytes() {
        return ByteString.copyFromUtf8(this.insertCharacters_);
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public Elements getInsertElements() {
        Elements elements = this.insertElements_;
        return elements == null ? Elements.getDefaultInstance() : elements;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ObjectSpan getInsertObjectSpan() {
        ObjectSpan objectSpan = this.insertObjectSpan_;
        return objectSpan == null ? ObjectSpan.getDefaultInstance() : objectSpan;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public ReplaceAttributes getReplaceAttributes() {
        ReplaceAttributes replaceAttributes = this.replaceAttributes_;
        return replaceAttributes == null ? ReplaceAttributes.getDefaultInstance() : replaceAttributes;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public SetAnnotations getSetAnnotations() {
        SetAnnotations setAnnotations = this.setAnnotations_;
        return setAnnotations == null ? SetAnnotations.getDefaultInstance() : setAnnotations;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public int getSize() {
        return this.size_;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public UpdateAttributes getUpdateAttributes() {
        UpdateAttributes updateAttributes = this.updateAttributes_;
        return updateAttributes == null ? UpdateAttributes.getDefaultInstance() : updateAttributes;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasDeleteElements() {
        return this.deleteElements_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasDeleteObjectSpan() {
        return this.deleteObjectSpan_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasInsertElements() {
        return this.insertElements_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasInsertObjectSpan() {
        return this.insertObjectSpan_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasReplaceAttributes() {
        return this.replaceAttributes_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasSetAnnotations() {
        return this.setAnnotations_ != null;
    }

    @Override // coeditOperation.CoeditOperationOrBuilder
    public boolean hasUpdateAttributes() {
        return this.updateAttributes_ != null;
    }

    public static Builder newBuilder(CoeditOperation coeditOperation2) {
        return DEFAULT_INSTANCE.createBuilder(coeditOperation2);
    }

    public static CoeditOperation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoeditOperation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CoeditOperation parseFrom(ByteString byteString) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CoeditOperation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CoeditOperation parseFrom(byte[] bArr) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CoeditOperation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CoeditOperation parseFrom(InputStream inputStream) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CoeditOperation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CoeditOperation parseFrom(CodedInputStream codedInputStream) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CoeditOperation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CoeditOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
