package androidx.glance.appwidget.proto;

import androidx.glance.appwidget.protobuf.AbstractMessageLite;
import androidx.glance.appwidget.protobuf.ByteString;
import androidx.glance.appwidget.protobuf.CodedInputStream;
import androidx.glance.appwidget.protobuf.ExtensionRegistryLite;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.MessageLiteOrBuilder;
import androidx.glance.appwidget.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class LayoutProto {

    /* JADX INFO: renamed from: androidx.glance.appwidget.proto.LayoutProto$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C29901 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f1571xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f1571xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1571xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ContentScale implements Internal.EnumLite {
        UNSPECIFIED_CONTENT_SCALE(0),
        FIT(1),
        CROP(2),
        FILL_BOUNDS(3),
        UNRECOGNIZED(-1);

        public static final int CROP_VALUE = 2;
        public static final int FILL_BOUNDS_VALUE = 3;
        public static final int FIT_VALUE = 1;
        public static final int UNSPECIFIED_CONTENT_SCALE_VALUE = 0;
        private static final Internal.EnumLiteMap<ContentScale> internalValueMap = new Internal.EnumLiteMap<ContentScale>() { // from class: androidx.glance.appwidget.proto.LayoutProto.ContentScale.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public ContentScale findValueByNumber(int i) {
                return ContentScale.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class ContentScaleVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ContentScaleVerifier();

            private ContentScaleVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return ContentScale.forNumber(i) != null;
            }
        }

        ContentScale(int i) {
            this.value = i;
        }

        public static ContentScale forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED_CONTENT_SCALE;
            }
            if (i == 1) {
                return FIT;
            }
            if (i == 2) {
                return CROP;
            }
            if (i != 3) {
                return null;
            }
            return FILL_BOUNDS;
        }

        public static Internal.EnumLiteMap<ContentScale> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ContentScaleVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ContentScale valueOf(int i) {
            return forNumber(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DimensionType implements Internal.EnumLite {
        UNKNOWN_DIMENSION_TYPE(0),
        EXACT(1),
        WRAP(2),
        FILL(3),
        EXPAND(4),
        UNRECOGNIZED(-1);

        public static final int EXACT_VALUE = 1;
        public static final int EXPAND_VALUE = 4;
        public static final int FILL_VALUE = 3;
        public static final int UNKNOWN_DIMENSION_TYPE_VALUE = 0;
        public static final int WRAP_VALUE = 2;
        private static final Internal.EnumLiteMap<DimensionType> internalValueMap = new Internal.EnumLiteMap<DimensionType>() { // from class: androidx.glance.appwidget.proto.LayoutProto.DimensionType.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public DimensionType findValueByNumber(int i) {
                return DimensionType.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class DimensionTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new DimensionTypeVerifier();

            private DimensionTypeVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return DimensionType.forNumber(i) != null;
            }
        }

        DimensionType(int i) {
            this.value = i;
        }

        public static DimensionType forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_DIMENSION_TYPE;
            }
            if (i == 1) {
                return EXACT;
            }
            if (i == 2) {
                return WRAP;
            }
            if (i == 3) {
                return FILL;
            }
            if (i != 4) {
                return null;
            }
            return EXPAND;
        }

        public static Internal.EnumLiteMap<DimensionType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DimensionTypeVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static DimensionType valueOf(int i) {
            return forNumber(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HorizontalAlignment implements Internal.EnumLite {
        UNSPECIFIED_HORIZONTAL_ALIGNMENT(0),
        START(1),
        CENTER_HORIZONTALLY(2),
        END(3),
        UNRECOGNIZED(-1);

        public static final int CENTER_HORIZONTALLY_VALUE = 2;
        public static final int END_VALUE = 3;
        public static final int START_VALUE = 1;
        public static final int UNSPECIFIED_HORIZONTAL_ALIGNMENT_VALUE = 0;
        private static final Internal.EnumLiteMap<HorizontalAlignment> internalValueMap = new Internal.EnumLiteMap<HorizontalAlignment>() { // from class: androidx.glance.appwidget.proto.LayoutProto.HorizontalAlignment.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public HorizontalAlignment findValueByNumber(int i) {
                return HorizontalAlignment.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class HorizontalAlignmentVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new HorizontalAlignmentVerifier();

            private HorizontalAlignmentVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return HorizontalAlignment.forNumber(i) != null;
            }
        }

        HorizontalAlignment(int i) {
            this.value = i;
        }

        public static HorizontalAlignment forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED_HORIZONTAL_ALIGNMENT;
            }
            if (i == 1) {
                return START;
            }
            if (i == 2) {
                return CENTER_HORIZONTALLY;
            }
            if (i != 3) {
                return null;
            }
            return END;
        }

        public static Internal.EnumLiteMap<HorizontalAlignment> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return HorizontalAlignmentVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static HorizontalAlignment valueOf(int i) {
            return forNumber(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LayoutConfig extends GeneratedMessageLite<LayoutConfig, Builder> implements LayoutConfigOrBuilder {
        private static final LayoutConfig DEFAULT_INSTANCE;
        public static final int LAYOUT_FIELD_NUMBER = 1;
        public static final int NEXT_INDEX_FIELD_NUMBER = 2;
        private static volatile Parser<LayoutConfig> PARSER;
        private Internal.ProtobufList<LayoutDefinition> layout_ = GeneratedMessageLite.emptyProtobufList();
        private int nextIndex_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutConfig, Builder> implements LayoutConfigOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllLayout(Iterable<? extends LayoutDefinition> iterable) {
                copyOnWrite();
                ((LayoutConfig) this.instance).addAllLayout(iterable);
                return this;
            }

            public Builder addLayout(LayoutDefinition layoutDefinition) {
                copyOnWrite();
                ((LayoutConfig) this.instance).addLayout(layoutDefinition);
                return this;
            }

            public Builder clearLayout() {
                copyOnWrite();
                ((LayoutConfig) this.instance).clearLayout();
                return this;
            }

            public Builder clearNextIndex() {
                copyOnWrite();
                ((LayoutConfig) this.instance).clearNextIndex();
                return this;
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
            public LayoutDefinition getLayout(int i) {
                return ((LayoutConfig) this.instance).getLayout(i);
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
            public int getLayoutCount() {
                return ((LayoutConfig) this.instance).getLayoutCount();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
            public List<LayoutDefinition> getLayoutList() {
                return Collections.unmodifiableList(((LayoutConfig) this.instance).getLayoutList());
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
            public int getNextIndex() {
                return ((LayoutConfig) this.instance).getNextIndex();
            }

            public Builder removeLayout(int i) {
                copyOnWrite();
                ((LayoutConfig) this.instance).removeLayout(i);
                return this;
            }

            public Builder setLayout(int i, LayoutDefinition layoutDefinition) {
                copyOnWrite();
                ((LayoutConfig) this.instance).setLayout(i, layoutDefinition);
                return this;
            }

            public Builder setNextIndex(int i) {
                copyOnWrite();
                ((LayoutConfig) this.instance).setNextIndex(i);
                return this;
            }

            private Builder() {
                super(LayoutConfig.DEFAULT_INSTANCE);
            }

            public Builder addLayout(int i, LayoutDefinition layoutDefinition) {
                copyOnWrite();
                ((LayoutConfig) this.instance).addLayout(i, layoutDefinition);
                return this;
            }

            public Builder setLayout(int i, LayoutDefinition.Builder builder) {
                copyOnWrite();
                ((LayoutConfig) this.instance).setLayout(i, builder.build());
                return this;
            }

            public Builder addLayout(LayoutDefinition.Builder builder) {
                copyOnWrite();
                ((LayoutConfig) this.instance).addLayout(builder.build());
                return this;
            }

            public Builder addLayout(int i, LayoutDefinition.Builder builder) {
                copyOnWrite();
                ((LayoutConfig) this.instance).addLayout(i, builder.build());
                return this;
            }
        }

        static {
            LayoutConfig layoutConfig = new LayoutConfig();
            DEFAULT_INSTANCE = layoutConfig;
            GeneratedMessageLite.registerDefaultInstance(LayoutConfig.class, layoutConfig);
        }

        private LayoutConfig() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLayout(Iterable<? extends LayoutDefinition> iterable) {
            ensureLayoutIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.layout_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLayout(LayoutDefinition layoutDefinition) {
            layoutDefinition.getClass();
            ensureLayoutIsMutable();
            this.layout_.add(layoutDefinition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLayout() {
            this.layout_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNextIndex() {
            this.nextIndex_ = 0;
        }

        private void ensureLayoutIsMutable() {
            Internal.ProtobufList<LayoutDefinition> protobufList = this.layout_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.layout_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static LayoutConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static LayoutConfig parseDelimitedFrom(InputStream inputStream) {
            return (LayoutConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutConfig parseFrom(ByteBuffer byteBuffer) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<LayoutConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLayout(int i) {
            ensureLayoutIsMutable();
            this.layout_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLayout(int i, LayoutDefinition layoutDefinition) {
            layoutDefinition.getClass();
            ensureLayoutIsMutable();
            this.layout_.set(i, layoutDefinition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextIndex(int i) {
            this.nextIndex_ = i;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C29901.f1571xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutConfig();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"layout_", LayoutDefinition.class, "nextIndex_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutConfig.class) {
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

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
        public LayoutDefinition getLayout(int i) {
            return this.layout_.get(i);
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
        public int getLayoutCount() {
            return this.layout_.size();
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
        public List<LayoutDefinition> getLayoutList() {
            return this.layout_;
        }

        public LayoutDefinitionOrBuilder getLayoutOrBuilder(int i) {
            return this.layout_.get(i);
        }

        public List<? extends LayoutDefinitionOrBuilder> getLayoutOrBuilderList() {
            return this.layout_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutConfigOrBuilder
        public int getNextIndex() {
            return this.nextIndex_;
        }

        public static Builder newBuilder(LayoutConfig layoutConfig) {
            return DEFAULT_INSTANCE.createBuilder(layoutConfig);
        }

        public static LayoutConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LayoutConfig parseFrom(ByteString byteString) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLayout(int i, LayoutDefinition layoutDefinition) {
            layoutDefinition.getClass();
            ensureLayoutIsMutable();
            this.layout_.add(i, layoutDefinition);
        }

        public static LayoutConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LayoutConfig parseFrom(byte[] bArr) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LayoutConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LayoutConfig parseFrom(InputStream inputStream) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutConfig parseFrom(CodedInputStream codedInputStream) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LayoutConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LayoutConfigOrBuilder extends MessageLiteOrBuilder {
        LayoutDefinition getLayout(int i);

        int getLayoutCount();

        List<LayoutDefinition> getLayoutList();

        int getNextIndex();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LayoutDefinition extends GeneratedMessageLite<LayoutDefinition, Builder> implements LayoutDefinitionOrBuilder {
        private static final LayoutDefinition DEFAULT_INSTANCE;
        public static final int LAYOUT_FIELD_NUMBER = 1;
        public static final int LAYOUT_INDEX_FIELD_NUMBER = 2;
        private static volatile Parser<LayoutDefinition> PARSER;
        private int layoutIndex_;
        private LayoutNode layout_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutDefinition, Builder> implements LayoutDefinitionOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder clearLayout() {
                copyOnWrite();
                ((LayoutDefinition) this.instance).clearLayout();
                return this;
            }

            public Builder clearLayoutIndex() {
                copyOnWrite();
                ((LayoutDefinition) this.instance).clearLayoutIndex();
                return this;
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
            public LayoutNode getLayout() {
                return ((LayoutDefinition) this.instance).getLayout();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
            public int getLayoutIndex() {
                return ((LayoutDefinition) this.instance).getLayoutIndex();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
            public boolean hasLayout() {
                return ((LayoutDefinition) this.instance).hasLayout();
            }

            public Builder mergeLayout(LayoutNode layoutNode) {
                copyOnWrite();
                ((LayoutDefinition) this.instance).mergeLayout(layoutNode);
                return this;
            }

            public Builder setLayout(LayoutNode layoutNode) {
                copyOnWrite();
                ((LayoutDefinition) this.instance).setLayout(layoutNode);
                return this;
            }

            public Builder setLayoutIndex(int i) {
                copyOnWrite();
                ((LayoutDefinition) this.instance).setLayoutIndex(i);
                return this;
            }

            private Builder() {
                super(LayoutDefinition.DEFAULT_INSTANCE);
            }

            public Builder setLayout(LayoutNode.Builder builder) {
                copyOnWrite();
                ((LayoutDefinition) this.instance).setLayout(builder.build());
                return this;
            }
        }

        static {
            LayoutDefinition layoutDefinition = new LayoutDefinition();
            DEFAULT_INSTANCE = layoutDefinition;
            GeneratedMessageLite.registerDefaultInstance(LayoutDefinition.class, layoutDefinition);
        }

        private LayoutDefinition() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLayout() {
            this.layout_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLayoutIndex() {
            this.layoutIndex_ = 0;
        }

        public static LayoutDefinition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLayout(LayoutNode layoutNode) {
            layoutNode.getClass();
            LayoutNode layoutNode2 = this.layout_;
            if (layoutNode2 == null || layoutNode2 == LayoutNode.getDefaultInstance()) {
                this.layout_ = layoutNode;
            } else {
                this.layout_ = LayoutNode.newBuilder(this.layout_).mergeFrom(layoutNode).buildPartial();
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static LayoutDefinition parseDelimitedFrom(InputStream inputStream) {
            return (LayoutDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutDefinition parseFrom(ByteBuffer byteBuffer) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<LayoutDefinition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLayout(LayoutNode layoutNode) {
            layoutNode.getClass();
            this.layout_ = layoutNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLayoutIndex(int i) {
            this.layoutIndex_ = i;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C29901.f1571xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutDefinition();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0004", new Object[]{"layout_", "layoutIndex_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutDefinition> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutDefinition.class) {
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

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
        public LayoutNode getLayout() {
            LayoutNode layoutNode = this.layout_;
            return layoutNode == null ? LayoutNode.getDefaultInstance() : layoutNode;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
        public int getLayoutIndex() {
            return this.layoutIndex_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutDefinitionOrBuilder
        public boolean hasLayout() {
            return this.layout_ != null;
        }

        public static Builder newBuilder(LayoutDefinition layoutDefinition) {
            return DEFAULT_INSTANCE.createBuilder(layoutDefinition);
        }

        public static LayoutDefinition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutDefinition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LayoutDefinition parseFrom(ByteString byteString) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LayoutDefinition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LayoutDefinition parseFrom(byte[] bArr) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LayoutDefinition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LayoutDefinition parseFrom(InputStream inputStream) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutDefinition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutDefinition parseFrom(CodedInputStream codedInputStream) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LayoutDefinition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutDefinition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LayoutDefinitionOrBuilder extends MessageLiteOrBuilder {
        LayoutNode getLayout();

        int getLayoutIndex();

        boolean hasLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LayoutNode extends GeneratedMessageLite<LayoutNode, Builder> implements LayoutNodeOrBuilder {
        public static final int CHILDREN_FIELD_NUMBER = 7;
        private static final LayoutNode DEFAULT_INSTANCE;
        public static final int HASACTION_FIELD_NUMBER = 9;
        public static final int HAS_IMAGE_COLOR_FILTER_FIELD_NUMBER = 11;
        public static final int HAS_IMAGE_DESCRIPTION_FIELD_NUMBER = 10;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        public static final int HORIZONTAL_ALIGNMENT_FIELD_NUMBER = 4;
        public static final int IDENTITY_FIELD_NUMBER = 8;
        public static final int IMAGE_SCALE_FIELD_NUMBER = 6;
        private static volatile Parser<LayoutNode> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VERTICAL_ALIGNMENT_FIELD_NUMBER = 5;
        public static final int WIDTH_FIELD_NUMBER = 2;
        private Internal.ProtobufList<LayoutNode> children_ = GeneratedMessageLite.emptyProtobufList();
        private boolean hasAction_;
        private boolean hasImageColorFilter_;
        private boolean hasImageDescription_;
        private int height_;
        private int horizontalAlignment_;
        private int identity_;
        private int imageScale_;
        private int type_;
        private int verticalAlignment_;
        private int width_;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Builder extends GeneratedMessageLite.Builder<LayoutNode, Builder> implements LayoutNodeOrBuilder {
            public /* synthetic */ Builder(int i) {
                this();
            }

            public Builder addAllChildren(Iterable<? extends LayoutNode> iterable) {
                copyOnWrite();
                ((LayoutNode) this.instance).addAllChildren(iterable);
                return this;
            }

            public Builder addChildren(LayoutNode layoutNode) {
                copyOnWrite();
                ((LayoutNode) this.instance).addChildren(layoutNode);
                return this;
            }

            public Builder clearChildren() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearChildren();
                return this;
            }

            public Builder clearHasAction() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearHasAction();
                return this;
            }

            public Builder clearHasImageColorFilter() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearHasImageColorFilter();
                return this;
            }

            public Builder clearHasImageDescription() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearHasImageDescription();
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearHeight();
                return this;
            }

            public Builder clearHorizontalAlignment() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearHorizontalAlignment();
                return this;
            }

            public Builder clearIdentity() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearIdentity();
                return this;
            }

            public Builder clearImageScale() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearImageScale();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearType();
                return this;
            }

            public Builder clearVerticalAlignment() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearVerticalAlignment();
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((LayoutNode) this.instance).clearWidth();
                return this;
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public LayoutNode getChildren(int i) {
                return ((LayoutNode) this.instance).getChildren(i);
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getChildrenCount() {
                return ((LayoutNode) this.instance).getChildrenCount();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public List<LayoutNode> getChildrenList() {
                return Collections.unmodifiableList(((LayoutNode) this.instance).getChildrenList());
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public boolean getHasAction() {
                return ((LayoutNode) this.instance).getHasAction();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public boolean getHasImageColorFilter() {
                return ((LayoutNode) this.instance).getHasImageColorFilter();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public boolean getHasImageDescription() {
                return ((LayoutNode) this.instance).getHasImageDescription();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public DimensionType getHeight() {
                return ((LayoutNode) this.instance).getHeight();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getHeightValue() {
                return ((LayoutNode) this.instance).getHeightValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public HorizontalAlignment getHorizontalAlignment() {
                return ((LayoutNode) this.instance).getHorizontalAlignment();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getHorizontalAlignmentValue() {
                return ((LayoutNode) this.instance).getHorizontalAlignmentValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public NodeIdentity getIdentity() {
                return ((LayoutNode) this.instance).getIdentity();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getIdentityValue() {
                return ((LayoutNode) this.instance).getIdentityValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public ContentScale getImageScale() {
                return ((LayoutNode) this.instance).getImageScale();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getImageScaleValue() {
                return ((LayoutNode) this.instance).getImageScaleValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public LayoutType getType() {
                return ((LayoutNode) this.instance).getType();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getTypeValue() {
                return ((LayoutNode) this.instance).getTypeValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public VerticalAlignment getVerticalAlignment() {
                return ((LayoutNode) this.instance).getVerticalAlignment();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getVerticalAlignmentValue() {
                return ((LayoutNode) this.instance).getVerticalAlignmentValue();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public DimensionType getWidth() {
                return ((LayoutNode) this.instance).getWidth();
            }

            @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
            public int getWidthValue() {
                return ((LayoutNode) this.instance).getWidthValue();
            }

            public Builder removeChildren(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).removeChildren(i);
                return this;
            }

            public Builder setChildren(int i, LayoutNode layoutNode) {
                copyOnWrite();
                ((LayoutNode) this.instance).setChildren(i, layoutNode);
                return this;
            }

            public Builder setHasAction(boolean z) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHasAction(z);
                return this;
            }

            public Builder setHasImageColorFilter(boolean z) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHasImageColorFilter(z);
                return this;
            }

            public Builder setHasImageDescription(boolean z) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHasImageDescription(z);
                return this;
            }

            public Builder setHeight(DimensionType dimensionType) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHeight(dimensionType);
                return this;
            }

            public Builder setHeightValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHeightValue(i);
                return this;
            }

            public Builder setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHorizontalAlignment(horizontalAlignment);
                return this;
            }

            public Builder setHorizontalAlignmentValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setHorizontalAlignmentValue(i);
                return this;
            }

            public Builder setIdentity(NodeIdentity nodeIdentity) {
                copyOnWrite();
                ((LayoutNode) this.instance).setIdentity(nodeIdentity);
                return this;
            }

            public Builder setIdentityValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setIdentityValue(i);
                return this;
            }

            public Builder setImageScale(ContentScale contentScale) {
                copyOnWrite();
                ((LayoutNode) this.instance).setImageScale(contentScale);
                return this;
            }

            public Builder setImageScaleValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setImageScaleValue(i);
                return this;
            }

            public Builder setType(LayoutType layoutType) {
                copyOnWrite();
                ((LayoutNode) this.instance).setType(layoutType);
                return this;
            }

            public Builder setTypeValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setTypeValue(i);
                return this;
            }

            public Builder setVerticalAlignment(VerticalAlignment verticalAlignment) {
                copyOnWrite();
                ((LayoutNode) this.instance).setVerticalAlignment(verticalAlignment);
                return this;
            }

            public Builder setVerticalAlignmentValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setVerticalAlignmentValue(i);
                return this;
            }

            public Builder setWidth(DimensionType dimensionType) {
                copyOnWrite();
                ((LayoutNode) this.instance).setWidth(dimensionType);
                return this;
            }

            public Builder setWidthValue(int i) {
                copyOnWrite();
                ((LayoutNode) this.instance).setWidthValue(i);
                return this;
            }

            private Builder() {
                super(LayoutNode.DEFAULT_INSTANCE);
            }

            public Builder addChildren(int i, LayoutNode layoutNode) {
                copyOnWrite();
                ((LayoutNode) this.instance).addChildren(i, layoutNode);
                return this;
            }

            public Builder setChildren(int i, Builder builder) {
                copyOnWrite();
                ((LayoutNode) this.instance).setChildren(i, builder.build());
                return this;
            }

            public Builder addChildren(Builder builder) {
                copyOnWrite();
                ((LayoutNode) this.instance).addChildren(builder.build());
                return this;
            }

            public Builder addChildren(int i, Builder builder) {
                copyOnWrite();
                ((LayoutNode) this.instance).addChildren(i, builder.build());
                return this;
            }
        }

        static {
            LayoutNode layoutNode = new LayoutNode();
            DEFAULT_INSTANCE = layoutNode;
            GeneratedMessageLite.registerDefaultInstance(LayoutNode.class, layoutNode);
        }

        private LayoutNode() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChildren(Iterable<? extends LayoutNode> iterable) {
            ensureChildrenIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.children_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildren(LayoutNode layoutNode) {
            layoutNode.getClass();
            ensureChildrenIsMutable();
            this.children_.add(layoutNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChildren() {
            this.children_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasAction() {
            this.hasAction_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasImageColorFilter() {
            this.hasImageColorFilter_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasImageDescription() {
            this.hasImageDescription_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.height_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHorizontalAlignment() {
            this.horizontalAlignment_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdentity() {
            this.identity_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImageScale() {
            this.imageScale_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerticalAlignment() {
            this.verticalAlignment_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.width_ = 0;
        }

        private void ensureChildrenIsMutable() {
            Internal.ProtobufList<LayoutNode> protobufList = this.children_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.children_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static LayoutNode getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static LayoutNode parseDelimitedFrom(InputStream inputStream) {
            return (LayoutNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutNode parseFrom(ByteBuffer byteBuffer) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<LayoutNode> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChildren(int i) {
            ensureChildrenIsMutable();
            this.children_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChildren(int i, LayoutNode layoutNode) {
            layoutNode.getClass();
            ensureChildrenIsMutable();
            this.children_.set(i, layoutNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasAction(boolean z) {
            this.hasAction_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasImageColorFilter(boolean z) {
            this.hasImageColorFilter_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasImageDescription(boolean z) {
            this.hasImageDescription_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(DimensionType dimensionType) {
            this.height_ = dimensionType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeightValue(int i) {
            this.height_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
            this.horizontalAlignment_ = horizontalAlignment.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHorizontalAlignmentValue(int i) {
            this.horizontalAlignment_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentity(NodeIdentity nodeIdentity) {
            this.identity_ = nodeIdentity.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentityValue(int i) {
            this.identity_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageScale(ContentScale contentScale) {
            this.imageScale_ = contentScale.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImageScaleValue(int i) {
            this.imageScale_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(LayoutType layoutType) {
            this.type_ = layoutType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeValue(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
            this.verticalAlignment_ = verticalAlignment.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerticalAlignmentValue(int i) {
            this.verticalAlignment_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(DimensionType dimensionType) {
            this.width_ = dimensionType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidthValue(int i) {
            this.width_ = i;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (C29901.f1571xa1df5c61[methodToInvoke.ordinal()]) {
                case 1:
                    return new LayoutNode();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0001\u0000\u0001\f\u0002\f\u0003\f\u0004\f\u0005\f\u0006\f\u0007\u001b\b\f\t\u0007\n\u0007\u000b\u0007", new Object[]{"type_", "width_", "height_", "horizontalAlignment_", "verticalAlignment_", "imageScale_", "children_", LayoutNode.class, "identity_", "hasAction_", "hasImageDescription_", "hasImageColorFilter_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LayoutNode> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LayoutNode.class) {
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

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public LayoutNode getChildren(int i) {
            return this.children_.get(i);
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getChildrenCount() {
            return this.children_.size();
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public List<LayoutNode> getChildrenList() {
            return this.children_;
        }

        public LayoutNodeOrBuilder getChildrenOrBuilder(int i) {
            return this.children_.get(i);
        }

        public List<? extends LayoutNodeOrBuilder> getChildrenOrBuilderList() {
            return this.children_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public boolean getHasAction() {
            return this.hasAction_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public boolean getHasImageColorFilter() {
            return this.hasImageColorFilter_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public boolean getHasImageDescription() {
            return this.hasImageDescription_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public DimensionType getHeight() {
            DimensionType dimensionTypeForNumber = DimensionType.forNumber(this.height_);
            return dimensionTypeForNumber == null ? DimensionType.UNRECOGNIZED : dimensionTypeForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getHeightValue() {
            return this.height_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public HorizontalAlignment getHorizontalAlignment() {
            HorizontalAlignment horizontalAlignmentForNumber = HorizontalAlignment.forNumber(this.horizontalAlignment_);
            return horizontalAlignmentForNumber == null ? HorizontalAlignment.UNRECOGNIZED : horizontalAlignmentForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getHorizontalAlignmentValue() {
            return this.horizontalAlignment_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public NodeIdentity getIdentity() {
            NodeIdentity nodeIdentityForNumber = NodeIdentity.forNumber(this.identity_);
            return nodeIdentityForNumber == null ? NodeIdentity.UNRECOGNIZED : nodeIdentityForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getIdentityValue() {
            return this.identity_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public ContentScale getImageScale() {
            ContentScale contentScaleForNumber = ContentScale.forNumber(this.imageScale_);
            return contentScaleForNumber == null ? ContentScale.UNRECOGNIZED : contentScaleForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getImageScaleValue() {
            return this.imageScale_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public LayoutType getType() {
            LayoutType layoutTypeForNumber = LayoutType.forNumber(this.type_);
            return layoutTypeForNumber == null ? LayoutType.UNRECOGNIZED : layoutTypeForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public VerticalAlignment getVerticalAlignment() {
            VerticalAlignment verticalAlignmentForNumber = VerticalAlignment.forNumber(this.verticalAlignment_);
            return verticalAlignmentForNumber == null ? VerticalAlignment.UNRECOGNIZED : verticalAlignmentForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getVerticalAlignmentValue() {
            return this.verticalAlignment_;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public DimensionType getWidth() {
            DimensionType dimensionTypeForNumber = DimensionType.forNumber(this.width_);
            return dimensionTypeForNumber == null ? DimensionType.UNRECOGNIZED : dimensionTypeForNumber;
        }

        @Override // androidx.glance.appwidget.proto.LayoutProto.LayoutNodeOrBuilder
        public int getWidthValue() {
            return this.width_;
        }

        public static Builder newBuilder(LayoutNode layoutNode) {
            return DEFAULT_INSTANCE.createBuilder(layoutNode);
        }

        public static LayoutNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LayoutNode parseFrom(ByteString byteString) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildren(int i, LayoutNode layoutNode) {
            layoutNode.getClass();
            ensureChildrenIsMutable();
            this.children_.add(i, layoutNode);
        }

        public static LayoutNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LayoutNode parseFrom(byte[] bArr) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LayoutNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LayoutNode parseFrom(InputStream inputStream) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LayoutNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LayoutNode parseFrom(CodedInputStream codedInputStream) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LayoutNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (LayoutNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LayoutNodeOrBuilder extends MessageLiteOrBuilder {
        LayoutNode getChildren(int i);

        int getChildrenCount();

        List<LayoutNode> getChildrenList();

        boolean getHasAction();

        boolean getHasImageColorFilter();

        boolean getHasImageDescription();

        DimensionType getHeight();

        int getHeightValue();

        HorizontalAlignment getHorizontalAlignment();

        int getHorizontalAlignmentValue();

        NodeIdentity getIdentity();

        int getIdentityValue();

        ContentScale getImageScale();

        int getImageScaleValue();

        LayoutType getType();

        int getTypeValue();

        VerticalAlignment getVerticalAlignment();

        int getVerticalAlignmentValue();

        DimensionType getWidth();

        int getWidthValue();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LayoutType implements Internal.EnumLite {
        UNKNOWN_TYPE(0),
        ROW(1),
        COLUMN(2),
        BOX(3),
        TEXT(4),
        LAZY_COLUMN(5),
        LIST_ITEM(6),
        CHECK_BOX(7),
        BUTTON(8),
        SPACER(9),
        SWITCH(10),
        ANDROID_REMOTE_VIEWS(11),
        REMOTE_VIEWS_ROOT(12),
        IMAGE(13),
        LINEAR_PROGRESS_INDICATOR(14),
        CIRCULAR_PROGRESS_INDICATOR(15),
        LAZY_VERTICAL_GRID(16),
        VERTICAL_GRID_ITEM(17),
        RADIO_GROUP(18),
        RADIO_BUTTON(19),
        RADIO_ROW(20),
        RADIO_COLUMN(21),
        SIZE_BOX(22),
        ARC_PROGRESS_INDICATOR(23),
        ARC_MEASUREMENT_INDICATOR(24),
        IMAGE_BUTTON(25),
        STACKED_PROGRESS_INDICATOR(26),
        UNRECOGNIZED(-1);

        public static final int ANDROID_REMOTE_VIEWS_VALUE = 11;
        public static final int ARC_MEASUREMENT_INDICATOR_VALUE = 24;
        public static final int ARC_PROGRESS_INDICATOR_VALUE = 23;
        public static final int BOX_VALUE = 3;
        public static final int BUTTON_VALUE = 8;
        public static final int CHECK_BOX_VALUE = 7;
        public static final int CIRCULAR_PROGRESS_INDICATOR_VALUE = 15;
        public static final int COLUMN_VALUE = 2;
        public static final int IMAGE_BUTTON_VALUE = 25;
        public static final int IMAGE_VALUE = 13;
        public static final int LAZY_COLUMN_VALUE = 5;
        public static final int LAZY_VERTICAL_GRID_VALUE = 16;
        public static final int LINEAR_PROGRESS_INDICATOR_VALUE = 14;
        public static final int LIST_ITEM_VALUE = 6;
        public static final int RADIO_BUTTON_VALUE = 19;
        public static final int RADIO_COLUMN_VALUE = 21;
        public static final int RADIO_GROUP_VALUE = 18;
        public static final int RADIO_ROW_VALUE = 20;
        public static final int REMOTE_VIEWS_ROOT_VALUE = 12;
        public static final int ROW_VALUE = 1;
        public static final int SIZE_BOX_VALUE = 22;
        public static final int SPACER_VALUE = 9;
        public static final int STACKED_PROGRESS_INDICATOR_VALUE = 26;
        public static final int SWITCH_VALUE = 10;
        public static final int TEXT_VALUE = 4;
        public static final int UNKNOWN_TYPE_VALUE = 0;
        public static final int VERTICAL_GRID_ITEM_VALUE = 17;
        private static final Internal.EnumLiteMap<LayoutType> internalValueMap = new Internal.EnumLiteMap<LayoutType>() { // from class: androidx.glance.appwidget.proto.LayoutProto.LayoutType.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public LayoutType findValueByNumber(int i) {
                return LayoutType.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class LayoutTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new LayoutTypeVerifier();

            private LayoutTypeVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return LayoutType.forNumber(i) != null;
            }
        }

        LayoutType(int i) {
            this.value = i;
        }

        public static LayoutType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_TYPE;
                case 1:
                    return ROW;
                case 2:
                    return COLUMN;
                case 3:
                    return BOX;
                case 4:
                    return TEXT;
                case 5:
                    return LAZY_COLUMN;
                case 6:
                    return LIST_ITEM;
                case 7:
                    return CHECK_BOX;
                case 8:
                    return BUTTON;
                case 9:
                    return SPACER;
                case 10:
                    return SWITCH;
                case 11:
                    return ANDROID_REMOTE_VIEWS;
                case 12:
                    return REMOTE_VIEWS_ROOT;
                case 13:
                    return IMAGE;
                case 14:
                    return LINEAR_PROGRESS_INDICATOR;
                case 15:
                    return CIRCULAR_PROGRESS_INDICATOR;
                case 16:
                    return LAZY_VERTICAL_GRID;
                case 17:
                    return VERTICAL_GRID_ITEM;
                case 18:
                    return RADIO_GROUP;
                case 19:
                    return RADIO_BUTTON;
                case 20:
                    return RADIO_ROW;
                case 21:
                    return RADIO_COLUMN;
                case 22:
                    return SIZE_BOX;
                case 23:
                    return ARC_PROGRESS_INDICATOR;
                case 24:
                    return ARC_MEASUREMENT_INDICATOR;
                case 25:
                    return IMAGE_BUTTON;
                case 26:
                    return STACKED_PROGRESS_INDICATOR;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LayoutType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return LayoutTypeVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LayoutType valueOf(int i) {
            return forNumber(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NodeIdentity implements Internal.EnumLite {
        DEFAULT_IDENTITY(0),
        BACKGROUND_NODE(1),
        UNRECOGNIZED(-1);

        public static final int BACKGROUND_NODE_VALUE = 1;
        public static final int DEFAULT_IDENTITY_VALUE = 0;
        private static final Internal.EnumLiteMap<NodeIdentity> internalValueMap = new Internal.EnumLiteMap<NodeIdentity>() { // from class: androidx.glance.appwidget.proto.LayoutProto.NodeIdentity.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public NodeIdentity findValueByNumber(int i) {
                return NodeIdentity.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class NodeIdentityVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NodeIdentityVerifier();

            private NodeIdentityVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return NodeIdentity.forNumber(i) != null;
            }
        }

        NodeIdentity(int i) {
            this.value = i;
        }

        public static NodeIdentity forNumber(int i) {
            if (i == 0) {
                return DEFAULT_IDENTITY;
            }
            if (i != 1) {
                return null;
            }
            return BACKGROUND_NODE;
        }

        public static Internal.EnumLiteMap<NodeIdentity> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NodeIdentityVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static NodeIdentity valueOf(int i) {
            return forNumber(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum VerticalAlignment implements Internal.EnumLite {
        UNSPECIFIED_VERTICAL_ALIGNMENT(0),
        TOP(1),
        CENTER_VERTICALLY(2),
        BOTTOM(3),
        UNRECOGNIZED(-1);

        public static final int BOTTOM_VALUE = 3;
        public static final int CENTER_VERTICALLY_VALUE = 2;
        public static final int TOP_VALUE = 1;
        public static final int UNSPECIFIED_VERTICAL_ALIGNMENT_VALUE = 0;
        private static final Internal.EnumLiteMap<VerticalAlignment> internalValueMap = new Internal.EnumLiteMap<VerticalAlignment>() { // from class: androidx.glance.appwidget.proto.LayoutProto.VerticalAlignment.1
            @Override // androidx.glance.appwidget.protobuf.Internal.EnumLiteMap
            public VerticalAlignment findValueByNumber(int i) {
                return VerticalAlignment.forNumber(i);
            }
        };
        private final int value;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class VerticalAlignmentVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new VerticalAlignmentVerifier();

            private VerticalAlignmentVerifier() {
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return VerticalAlignment.forNumber(i) != null;
            }
        }

        VerticalAlignment(int i) {
            this.value = i;
        }

        public static VerticalAlignment forNumber(int i) {
            if (i == 0) {
                return UNSPECIFIED_VERTICAL_ALIGNMENT;
            }
            if (i == 1) {
                return TOP;
            }
            if (i == 2) {
                return CENTER_VERTICALLY;
            }
            if (i != 3) {
                return null;
            }
            return BOTTOM;
        }

        public static Internal.EnumLiteMap<VerticalAlignment> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return VerticalAlignmentVerifier.INSTANCE;
        }

        @Override // androidx.glance.appwidget.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static VerticalAlignment valueOf(int i) {
            return forNumber(i);
        }
    }

    private LayoutProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
