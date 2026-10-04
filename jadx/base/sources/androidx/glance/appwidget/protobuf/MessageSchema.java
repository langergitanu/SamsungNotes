package androidx.glance.appwidget.protobuf;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.glance.appwidget.protobuf.ArrayDecoders;
import androidx.glance.appwidget.protobuf.ByteString;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.MapEntryLite;
import androidx.glance.appwidget.protobuf.WireFormat;
import androidx.glance.appwidget.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.MessageSchema$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C30361 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i4, int i5, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i4;
        this.repeatedFieldOffsetStart = i5;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "Mutating immutable message: "));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i4 = registers.int1;
        if (i4 < 0 || i4 > i2 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i5 = iDecodeVarint32 + i4;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i5) {
            int iDecodeVarint322 = iDecodeVarint32 + 1;
            int i6 = bArr[iDecodeVarint32];
            if (i6 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i6, bArr, iDecodeVarint322, registers);
                i6 = registers.int1;
            }
            int i7 = iDecodeVarint322;
            int i8 = i6 >>> 3;
            int i9 = i6 & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i7, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i2, registers);
                }
            } else if (i9 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i7, i2, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i6, bArr, i7, i2, registers);
            }
        }
        if (iDecodeVarint32 != i5) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i5;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (C30361.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[AbstractC2322a.m1610D(i, 3, 2, 1)];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        boolean z;
        int iComputeSizeFixed32List;
        Unsafe unsafe = UNSAFE;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int iM2211b = 0;
        int i7 = 0;
        while (i6 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int iNumberAt = numberAt(i6);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i6 + 2];
                int i8 = i & i4;
                i2 = 1 << (i >>> 20);
                if (i8 != i5) {
                    i7 = unsafe.getInt(t, i8);
                    i5 = i8;
                }
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.m2289id() || iType > FieldType.SINT64_LIST_PACKED.m2289id()) ? 0 : this.buffer[i6 + 2] & i4;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i7 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM2211b = iComputeBytesSize + iM2211b;
                    }
                    break;
                case 9:
                    if ((i7 & i2) != 0) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        iM2211b += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 14:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 31:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM2211b += iComputeSizeFixed32List;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM2211b);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM2211b);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM2211b);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM2211b);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM2211b);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag2);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM2211b);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag2);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM2211b);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeBoolListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM2211b);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM2211b);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeEnumListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM2211b);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag3);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM2211b);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag3);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM2211b);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM2211b);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM2211b);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i6));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM2211b = iComputeBytesSize + iM2211b;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        iM2211b += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        iM2211b += iComputeBoolSize;
                    }
                    break;
            }
            i6 += 3;
            i4 = 1048575;
        }
        int unknownFieldsSerializedSize = iM2211b + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        Unsafe unsafe = UNSAFE;
        int iM2211b = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            int i2 = (iType < FieldType.DOUBLE_LIST_PACKED.m2289id() || iType > FieldType.SINT64_LIST_PACKED.m2289id()) ? 0 : this.buffer[i + 2] & 1048575;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM2211b = iComputeBytesSize + iM2211b;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM2211b += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM2211b += iComputeSizeMessage;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM2211b);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM2211b);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM2211b);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM2211b);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM2211b);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag2);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM2211b);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag2);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM2211b);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeBoolListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM2211b);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM2211b);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeEnumListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM2211b);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag3);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM2211b);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag3);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM2211b);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt32ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM2211b);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt64ListNoTag);
                        }
                        iM2211b = AbstractC2821a.m2211b(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM2211b);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i));
                    iM2211b += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM2211b = iComputeBytesSize + iM2211b;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM2211b += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM2211b += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return iM2211b + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static <T> int intAt(T t, long j) {
        return UnsafeUtil.getInt(t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private boolean isFieldPresent(T t, int i, int i2, int i4, int i5) {
        return i2 == 1048575 ? isFieldPresent(t, i) : (i4 & i5) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!messageFieldSchema.isInitialized(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.glance.appwidget.protobuf.Schema] */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & 268435456) != 0;
    }

    private static List<?> listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    private static <T> long longAt(T t, long j) {
        return UnsafeUtil.getLong(t, j);
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private <UT, UB, ET extends androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.glance.appwidget.protobuf.UnknownFieldSchema<UT, UB> r17, androidx.glance.appwidget.protobuf.ExtensionSchema<ET> r18, T r19, androidx.glance.appwidget.protobuf.Reader r20, androidx.glance.appwidget.protobuf.ExtensionRegistryLite r21) {
        /*
            Method dump skipped, instruction units count: 2040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.mergeFromHelper(androidx.glance.appwidget.protobuf.UnknownFieldSchema, androidx.glance.appwidget.protobuf.ExtensionSchema, java.lang.Object, androidx.glance.appwidget.protobuf.Reader, androidx.glance.appwidget.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jOffset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long jOffset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(t, i)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t, jOffset, object);
                }
                setFieldPresent(t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t, T t2, int i) {
        int iNumberAt = numberAt(i);
        if (isOneofPresent(t2, iNumberAt, i)) {
            long jOffset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t2, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(t, iNumberAt, i)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t, jOffset, object);
                }
                setOneofPresent(t, iNumberAt, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, i);
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, i);
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long jOffset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t, offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i4 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().m2289id() >= 18 && fieldInfo.getType().m2289id() <= 49) {
                i4++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i4 > 0 ? new int[i4] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < fields.length) {
            FieldInfo fieldInfo2 = fields[i5];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i6, objArr);
            if (i7 < checkInitialized.length && checkInitialized[i7] == fieldNumber3) {
                checkInitialized[i7] = i6;
                i7++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i8] = i6;
                i8++;
            } else {
                if (fieldInfo2.getType().m2289id() >= 18 && fieldInfo2.getType().m2289id() <= 49) {
                    i = i6;
                    iArr3[i9] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i9++;
                }
                i5++;
                i6 = i + 3;
            }
            i = i6;
            i5++;
            i6 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        int i22;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i23;
        int i24;
        java.lang.reflect.Field fieldReflectField2;
        java.lang.reflect.Field fieldReflectField3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int i29 = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (stringInfo.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt5 = stringInfo.charAt(i);
        if (iCharAt5 >= 55296) {
            int i32 = iCharAt5 & 8191;
            int i33 = 13;
            while (true) {
                i28 = i31 + 1;
                cCharAt13 = stringInfo.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i28;
            }
            iCharAt5 = i32 | (cCharAt13 << i33);
            i31 = i28;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i4 = 0;
            iCharAt4 = 0;
            i2 = 0;
            iArr = EMPTY_INT_ARRAY;
            i5 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt6 = stringInfo.charAt(i31);
            if (iCharAt6 >= 55296) {
                int i35 = iCharAt6 & 8191;
                int i36 = 13;
                while (true) {
                    i13 = i34 + 1;
                    cCharAt8 = stringInfo.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i13;
                }
                iCharAt6 = i35 | (cCharAt8 << i36);
                i34 = i13;
            }
            int i37 = i34 + 1;
            int iCharAt7 = stringInfo.charAt(i34);
            if (iCharAt7 >= 55296) {
                int i38 = iCharAt7 & 8191;
                int i39 = 13;
                while (true) {
                    i12 = i37 + 1;
                    cCharAt7 = stringInfo.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i12;
                }
                iCharAt7 = i38 | (cCharAt7 << i39);
                i37 = i12;
            }
            int i40 = i37 + 1;
            iCharAt = stringInfo.charAt(i37);
            if (iCharAt >= 55296) {
                int i41 = iCharAt & 8191;
                int i42 = 13;
                while (true) {
                    i11 = i40 + 1;
                    cCharAt6 = stringInfo.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i11;
                }
                iCharAt = i41 | (cCharAt6 << i42);
                i40 = i11;
            }
            int i43 = i40 + 1;
            iCharAt2 = stringInfo.charAt(i40);
            if (iCharAt2 >= 55296) {
                int i44 = iCharAt2 & 8191;
                int i45 = 13;
                while (true) {
                    i10 = i43 + 1;
                    cCharAt5 = stringInfo.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i10;
                }
                iCharAt2 = i44 | (cCharAt5 << i45);
                i43 = i10;
            }
            int i46 = i43 + 1;
            iCharAt3 = stringInfo.charAt(i43);
            if (iCharAt3 >= 55296) {
                int i47 = iCharAt3 & 8191;
                int i48 = 13;
                while (true) {
                    i9 = i46 + 1;
                    cCharAt4 = stringInfo.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i9;
                }
                iCharAt3 = i47 | (cCharAt4 << i48);
                i46 = i9;
            }
            int i49 = i46 + 1;
            int iCharAt8 = stringInfo.charAt(i46);
            if (iCharAt8 >= 55296) {
                int i50 = iCharAt8 & 8191;
                int i51 = 13;
                while (true) {
                    i8 = i49 + 1;
                    cCharAt3 = stringInfo.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i8;
                }
                iCharAt8 = i50 | (cCharAt3 << i51);
                i49 = i8;
            }
            int i52 = i49 + 1;
            int iCharAt9 = stringInfo.charAt(i49);
            if (iCharAt9 >= 55296) {
                int i53 = iCharAt9 & 8191;
                int i54 = 13;
                while (true) {
                    i7 = i52 + 1;
                    cCharAt2 = stringInfo.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i7;
                }
                iCharAt9 = i53 | (cCharAt2 << i54);
                i52 = i7;
            }
            int i55 = i52 + 1;
            iCharAt4 = stringInfo.charAt(i52);
            if (iCharAt4 >= 55296) {
                int i56 = iCharAt4 & 8191;
                int i57 = 13;
                while (true) {
                    i6 = i55 + 1;
                    cCharAt = stringInfo.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i6;
                }
                iCharAt4 = i56 | (cCharAt << i57);
                i55 = i6;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = (iCharAt6 * 2) + iCharAt7;
            i4 = iCharAt8;
            iArr = iArr2;
            i5 = iCharAt6;
            i31 = i55;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 * 2];
        int i58 = i4 + iCharAt4;
        int i59 = i58;
        int i60 = iCharAt4;
        int i61 = 0;
        int i62 = 0;
        while (i31 < length) {
            int i63 = i31 + 1;
            int iCharAt10 = stringInfo.charAt(i31);
            if (iCharAt10 >= i29) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i27 = i65 + 1;
                    cCharAt12 = stringInfo.charAt(i65);
                    i14 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i27;
                    length = i14;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i15 = i27;
            } else {
                i14 = length;
                i15 = i63;
            }
            int i67 = i15 + 1;
            int iCharAt11 = stringInfo.charAt(i15);
            int i68 = iCharAt10;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i69 = iCharAt11 & 8191;
                int i70 = 13;
                while (true) {
                    i26 = i67 + 1;
                    cCharAt11 = stringInfo.charAt(i67);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i67 = i26;
                    c = 55296;
                }
                iCharAt11 = i69 | (cCharAt11 << i70);
                i67 = i26;
            }
            int i71 = iCharAt11 & 255;
            int i72 = i5;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i62] = i61;
                i62++;
            }
            int[] iArr4 = iArr3;
            if (i71 >= 51) {
                int i73 = i67 + 1;
                int iCharAt12 = stringInfo.charAt(i67);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i74 = iCharAt12 & 8191;
                    int i75 = 13;
                    while (true) {
                        i25 = i73 + 1;
                        cCharAt10 = stringInfo.charAt(i73);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i74 |= (cCharAt10 & 8191) << i75;
                        i75 += 13;
                        i73 = i25;
                        c2 = 55296;
                    }
                    iCharAt12 = i74 | (cCharAt10 << i75);
                    i73 = i25;
                }
                int i76 = i71 - 51;
                int i77 = iCharAt12;
                if (i76 == 9 || i76 == 17) {
                    i24 = i73;
                    objArr[AbstractC2322a.m1610D(i61, 3, 2, 1)] = objects[i2];
                    i2++;
                } else if (i76 != 12 || z) {
                    i24 = i73;
                } else {
                    i24 = i73;
                    objArr[AbstractC2322a.m1610D(i61, 3, 2, 1)] = objects[i2];
                    i2++;
                }
                int i78 = i77 * 2;
                Object obj = objects[i78];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i78] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i79 = i78 + 1;
                Object obj2 = objects[i79];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i79] = fieldReflectField3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i16 = iCharAt;
                i21 = i2;
                i22 = iObjectFieldOffset3;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i19 = i24;
                i20 = 0;
                i17 = iCharAt2;
            } else {
                int i80 = i2 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i71 == 9 || i71 == 17) {
                    i16 = iCharAt;
                    i17 = iCharAt2;
                    objArr[AbstractC2322a.m1610D(i61, 3, 2, 1)] = fieldReflectField4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        i16 = iCharAt;
                        i17 = iCharAt2;
                        i23 = i2 + 2;
                        objArr[AbstractC2322a.m1610D(i61, 3, 2, 1)] = objects[i80];
                    } else {
                        if (i71 == 12 || i71 == 30 || i71 == 44) {
                            if (!z) {
                                i16 = iCharAt;
                                i17 = iCharAt2;
                                i23 = i2 + 2;
                                objArr[AbstractC2322a.m1610D(i61, 3, 2, 1)] = objects[i80];
                            }
                        } else if (i71 == 50) {
                            int i81 = i60 + 1;
                            iArr[i60] = i61;
                            int i82 = (i61 / 3) * 2;
                            int i83 = i2 + 2;
                            objArr[i82] = objects[i80];
                            if ((iCharAt11 & 2048) != 0) {
                                i18 = i2 + 3;
                                objArr[i82 + 1] = objects[i83];
                                i16 = iCharAt;
                                i17 = iCharAt2;
                                i60 = i81;
                            } else {
                                i16 = iCharAt;
                                i18 = i83;
                                i60 = i81;
                                i17 = iCharAt2;
                            }
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                            if ((iCharAt11 & 4096) != 4096 || i71 > 17) {
                                iObjectFieldOffset2 = 1048575;
                                i19 = i67;
                                i20 = 0;
                            } else {
                                int i84 = i67 + 1;
                                int iCharAt13 = stringInfo.charAt(i67);
                                if (iCharAt13 >= 55296) {
                                    int i85 = iCharAt13 & 8191;
                                    int i86 = 13;
                                    while (true) {
                                        i19 = i84 + 1;
                                        cCharAt9 = stringInfo.charAt(i84);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i85 |= (cCharAt9 & 8191) << i86;
                                        i86 += 13;
                                        i84 = i19;
                                    }
                                    iCharAt13 = i85 | (cCharAt9 << i86);
                                } else {
                                    i19 = i84;
                                }
                                int i87 = (iCharAt13 / 32) + (i72 * 2);
                                Object obj3 = objects[i87];
                                if (obj3 instanceof java.lang.reflect.Field) {
                                    fieldReflectField = (java.lang.reflect.Field) obj3;
                                } else {
                                    fieldReflectField = reflectField(cls, (String) obj3);
                                    objects[i87] = fieldReflectField;
                                }
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                                i20 = iCharAt13 % 32;
                            }
                            if (i71 >= 18 || i71 > 49) {
                                i21 = i18;
                                i22 = iObjectFieldOffset;
                            } else {
                                iArr[i59] = iObjectFieldOffset;
                                i21 = i18;
                                i22 = iObjectFieldOffset;
                                i59++;
                            }
                        }
                        i16 = iCharAt;
                        i17 = iCharAt2;
                    }
                    i18 = i23;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((iCharAt11 & 4096) != 4096) {
                        iObjectFieldOffset2 = 1048575;
                        i19 = i67;
                        i20 = 0;
                        if (i71 >= 18) {
                            i21 = i18;
                            i22 = iObjectFieldOffset;
                        }
                    }
                }
                i18 = i80;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) != 4096) {
                }
            }
            int i88 = i61 + 1;
            iArr4[i61] = i68;
            int i89 = i61 + 2;
            String str = stringInfo;
            iArr4[i88] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i71 << 20) | i22;
            i61 += 3;
            iArr4[i89] = (i20 << 20) | iObjectFieldOffset2;
            i2 = i21;
            iCharAt = i16;
            stringInfo = str;
            i5 = i72;
            length = i14;
            iCharAt2 = i17;
            i31 = i19;
            iArr3 = iArr4;
            i29 = 55296;
        }
        return new MessageSchema<>(iArr3, objArr, iCharAt, iCharAt2, rawMessageInfo.getDefaultInstance(), z, false, iArr, iCharAt4, i58, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i4, long j, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i4);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, int i8, long j, int i9, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i10 = i + 8;
                unsafe.putInt(t, j2, i5);
                return i10;
            case 52:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i11 = i + 4;
                unsafe.putInt(t, j2, i5);
                return i11;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(registers.long1));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i6 != 1) {
                    return i;
                }
                unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i12 = i + 8;
                unsafe.putInt(t, j2, i5);
                return i12;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i;
                }
                unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i13 = i + 4;
                unsafe.putInt(t, j2, i5);
                return i13;
            case 58:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint642;
            case 59:
                if (i6 != 2) {
                    return i;
                }
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i14 = registers.int1;
                if (i14 == 0) {
                    unsafe.putObject(t, j, "");
                } else {
                    if ((i7 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i14)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t, j, new String(bArr, iDecodeVarint322, i14, Internal.UTF_8));
                    iDecodeVarint322 += i14;
                }
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint322;
            case 60:
                if (i6 != 2) {
                    return i;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t, i5, i9);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i9), bArr, i, i2, registers);
                storeOneofMessageField(t, i5, i9, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (i6 != 2) {
                    return i;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t, j, registers.object1);
                unsafe.putInt(t, j2, i5);
                return iDecodeBytes;
            case 63:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i15 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i9);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i15)) {
                    getMutableUnknownFields(t).storeField(i4, Long.valueOf(i15));
                    return iDecodeVarint323;
                }
                unsafe.putObject(t, j, Integer.valueOf(i15));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint323;
            case 66:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint324;
            case 67:
                if (i6 != 0) {
                    return i;
                }
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t, j2, i5);
                return iDecodeVarint643;
            case 68:
                if (i6 == 3) {
                    Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t, i5, i9);
                    int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i9), bArr, i, i2, (i4 & (-8)) | 4, registers);
                    storeOneofMessageField(t, i5, i9, objMutableOneofMessageFieldForMerge2);
                    return iMergeGroupField;
                }
                break;
        }
        return i;
    }

    @CanIgnoreReturnValue
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        T t2;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr2;
        ArrayDecoders.Registers registers2;
        int i9;
        int i10;
        int iDecodeVarint32;
        T t5;
        Unsafe unsafe2;
        int i11;
        ArrayDecoders.Registers registers3;
        byte[] bArr3;
        int iDecodeVarint64;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        MessageSchema<T> messageSchema = this;
        T t6 = t;
        byte[] bArr4 = bArr;
        int i18 = i2;
        ArrayDecoders.Registers registers4 = registers;
        checkMutable(t6);
        Unsafe unsafe3 = UNSAFE;
        int i19 = -1;
        int i20 = i;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 1048575;
        while (i20 < i18) {
            int iDecodeVarint322 = i20 + 1;
            int i25 = bArr4[i20];
            if (i25 < 0) {
                iDecodeVarint322 = ArrayDecoders.decodeVarint32(i25, bArr4, iDecodeVarint322, registers4);
                i25 = registers4.int1;
            }
            int i26 = i25 >>> 3;
            int i27 = i25 & 7;
            int iPositionForFieldNumber = i26 > i21 ? messageSchema.positionForFieldNumber(i26, i22 / 3) : messageSchema.positionForFieldNumber(i26);
            if (iPositionForFieldNumber == i19) {
                t2 = t6;
                unsafe = unsafe3;
                i4 = i25;
                i5 = iDecodeVarint322;
                i6 = i19;
                i7 = i26;
                i8 = 0;
            } else {
                int i28 = messageSchema.buffer[iPositionForFieldNumber + 1];
                int iType = type(i28);
                i4 = i25;
                int i29 = iPositionForFieldNumber;
                long jOffset = offset(i28);
                if (iType <= 17) {
                    int i30 = messageSchema.buffer[i29 + 2];
                    int i31 = 1 << (i30 >>> 20);
                    int i32 = i30 & 1048575;
                    if (i32 != i24) {
                        if (i24 != 1048575) {
                            unsafe3.putInt(t6, i24, i23);
                            i13 = i32;
                            i12 = 1048575;
                        } else {
                            i12 = 1048575;
                            i13 = i32;
                        }
                        if (i13 != i12) {
                            i23 = unsafe3.getInt(t6, i13);
                        }
                        i24 = i13;
                    }
                    switch (iType) {
                        case 0:
                            byte[] bArr5 = bArr4;
                            i9 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 1) {
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                UnsafeUtil.putDouble(t6, jOffset, ArrayDecoders.decodeDouble(bArr5, i9));
                                i20 = i9 + 8;
                                i23 |= i31;
                                i18 = i2;
                                i22 = i10;
                                i21 = i26;
                                bArr4 = bArr5;
                                i19 = -1;
                                registers4 = registers;
                            }
                            break;
                        case 1:
                            ArrayDecoders.Registers registers5 = registers4;
                            bArr2 = bArr4;
                            registers2 = registers5;
                            i9 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 5) {
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                UnsafeUtil.putFloat(t6, jOffset, ArrayDecoders.decodeFloat(bArr2, i9));
                                i20 = i9 + 4;
                                i23 |= i31;
                                byte[] bArr6 = bArr2;
                                registers4 = registers2;
                                bArr4 = bArr6;
                                i18 = i2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            ArrayDecoders.Registers registers6 = registers4;
                            byte[] bArr7 = bArr4;
                            i9 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 0) {
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr7, i9, registers6);
                                Unsafe unsafe4 = unsafe3;
                                T t7 = t6;
                                unsafe4.putLong(t7, jOffset, registers6.long1);
                                unsafe3 = unsafe4;
                                t6 = t7;
                                i23 |= i31;
                                registers4 = registers6;
                                bArr4 = bArr7;
                                i20 = iDecodeVarint642;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                                i18 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            ArrayDecoders.Registers registers7 = registers4;
                            byte[] bArr8 = bArr4;
                            i9 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 0) {
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr8, i9, registers7);
                                unsafe3.putInt(t6, jOffset, registers7.int1);
                                i23 |= i31;
                                registers4 = registers7;
                                bArr4 = bArr8;
                                i18 = i2;
                                i20 = iDecodeVarint32;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            byte[] bArr9 = bArr4;
                            T t8 = t6;
                            ArrayDecoders.Registers registers8 = registers4;
                            bArr2 = bArr9;
                            Unsafe unsafe5 = unsafe3;
                            int i33 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 1) {
                                t6 = t8;
                                i9 = i33;
                                unsafe3 = unsafe5;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                registers2 = registers8;
                                unsafe5.putLong(t8, jOffset, ArrayDecoders.decodeFixed64(bArr2, i33));
                                unsafe3 = unsafe5;
                                t6 = t8;
                                i20 = i33 + 8;
                                i23 |= i31;
                                byte[] bArr62 = bArr2;
                                registers4 = registers2;
                                bArr4 = bArr62;
                                i18 = i2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            byte[] bArr10 = bArr4;
                            t5 = t6;
                            ArrayDecoders.Registers registers9 = registers4;
                            unsafe2 = unsafe3;
                            i11 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 5) {
                                Unsafe unsafe6 = unsafe2;
                                i9 = i11;
                                unsafe3 = unsafe6;
                                t6 = t5;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                unsafe2.putInt(t5, jOffset, ArrayDecoders.decodeFixed32(bArr10, i11));
                                i20 = i11 + 4;
                                i23 |= i31;
                                registers4 = registers9;
                                t6 = t5;
                                bArr4 = bArr10;
                                unsafe3 = unsafe2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                                i18 = i2;
                            }
                            break;
                        case 7:
                            byte[] bArr11 = bArr4;
                            t5 = t6;
                            registers3 = registers4;
                            bArr3 = bArr11;
                            unsafe2 = unsafe3;
                            i11 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 0) {
                                Unsafe unsafe62 = unsafe2;
                                i9 = i11;
                                unsafe3 = unsafe62;
                                t6 = t5;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr3, i11, registers3);
                                UnsafeUtil.putBoolean(t5, jOffset, registers3.long1 != 0);
                                i23 |= i31;
                                byte[] bArr12 = bArr3;
                                registers4 = registers3;
                                t6 = t5;
                                bArr4 = bArr12;
                                i20 = iDecodeVarint64;
                                unsafe3 = unsafe2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                                i18 = i2;
                            }
                            break;
                        case 8:
                            byte[] bArr13 = bArr4;
                            t5 = t6;
                            registers3 = registers4;
                            bArr3 = bArr13;
                            unsafe2 = unsafe3;
                            i11 = iDecodeVarint322;
                            i10 = i29;
                            if (i27 != 2) {
                                Unsafe unsafe622 = unsafe2;
                                i9 = i11;
                                unsafe3 = unsafe622;
                                t6 = t5;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint64 = (i28 & 536870912) == 0 ? ArrayDecoders.decodeString(bArr3, i11, registers3) : ArrayDecoders.decodeStringRequireUtf8(bArr3, i11, registers3);
                                unsafe2.putObject(t5, jOffset, registers3.object1);
                                i23 |= i31;
                                byte[] bArr122 = bArr3;
                                registers4 = registers3;
                                t6 = t5;
                                bArr4 = bArr122;
                                i20 = iDecodeVarint64;
                                unsafe3 = unsafe2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                                i18 = i2;
                            }
                            break;
                        case 9:
                            i10 = i29;
                            if (i27 != 2) {
                                t6 = t6;
                                i9 = iDecodeVarint322;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                T t9 = t6;
                                Object objMutableMessageFieldForMerge = messageSchema.mutableMessageFieldForMerge(t9, i10);
                                byte[] bArr14 = bArr4;
                                t5 = t9;
                                int i34 = i18;
                                unsafe2 = unsafe3;
                                int i35 = iDecodeVarint322;
                                ArrayDecoders.Registers registers10 = registers4;
                                iDecodeVarint64 = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema.getMessageFieldSchema(i10), bArr14, i35, i34, registers10);
                                bArr3 = bArr14;
                                registers3 = registers10;
                                messageSchema.storeMessageField(t5, i10, objMutableMessageFieldForMerge);
                                i23 |= i31;
                                byte[] bArr1222 = bArr3;
                                registers4 = registers3;
                                t6 = t5;
                                bArr4 = bArr1222;
                                i20 = iDecodeVarint64;
                                unsafe3 = unsafe2;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                                i18 = i2;
                            }
                            break;
                        case 10:
                            i10 = i29;
                            if (i27 != 2) {
                                i9 = iDecodeVarint322;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeBytes(bArr4, iDecodeVarint322, registers4);
                                unsafe3.putObject(t6, jOffset, registers4.object1);
                                i23 |= i31;
                                i20 = iDecodeVarint32;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 12:
                            i10 = i29;
                            if (i27 != 0) {
                                i9 = iDecodeVarint322;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr4, iDecodeVarint322, registers4);
                                unsafe3.putInt(t6, jOffset, registers4.int1);
                                i23 |= i31;
                                i20 = iDecodeVarint32;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 15:
                            i10 = i29;
                            if (i27 != 0) {
                                i9 = iDecodeVarint322;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr4, iDecodeVarint322, registers4);
                                unsafe3.putInt(t6, jOffset, CodedInputStream.decodeZigZag32(registers4.int1));
                                i23 |= i31;
                                i20 = iDecodeVarint32;
                                i22 = i10;
                                i21 = i26;
                                i19 = -1;
                            }
                            break;
                        case 16:
                            if (i27 != 0) {
                                i9 = iDecodeVarint322;
                                i10 = i29;
                                unsafe = unsafe3;
                                i5 = i9;
                                i8 = i10;
                                i7 = i26;
                                i6 = -1;
                                t2 = t6;
                            } else {
                                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr4, iDecodeVarint322, registers4);
                                Unsafe unsafe7 = unsafe3;
                                T t10 = t6;
                                unsafe7.putLong(t10, jOffset, CodedInputStream.decodeZigZag64(registers4.long1));
                                unsafe3 = unsafe7;
                                t6 = t10;
                                i23 |= i31;
                                i20 = iDecodeVarint643;
                                i21 = i26;
                                i22 = i29;
                                i19 = -1;
                            }
                            break;
                        default:
                            i9 = iDecodeVarint322;
                            i10 = i29;
                            unsafe = unsafe3;
                            i5 = i9;
                            i8 = i10;
                            i7 = i26;
                            i6 = -1;
                            t2 = t6;
                            break;
                    }
                } else {
                    int i36 = iDecodeVarint322;
                    byte[] bArr15 = bArr4;
                    if (iType != 27) {
                        Unsafe unsafe8 = unsafe3;
                        if (iType <= 49) {
                            i15 = i23;
                            unsafe = unsafe8;
                            i6 = -1;
                            i17 = i24;
                            int repeatedField = messageSchema.parseRepeatedField(t, bArr, i36, i2, i4 == true ? 1 : 0, i26, i27, i29, i28, iType, jOffset, registers);
                            i16 = i26;
                            i8 = i29;
                            if (repeatedField != i36) {
                                messageSchema = this;
                                t6 = t;
                                i18 = i2;
                                registers4 = registers;
                                i20 = repeatedField;
                                i21 = i16;
                                i24 = i17;
                                i19 = -1;
                                i22 = i8;
                                i23 = i15;
                                unsafe3 = unsafe;
                                bArr4 = bArr;
                            } else {
                                t2 = t;
                                i5 = repeatedField;
                                i7 = i16;
                            }
                        } else {
                            unsafe = unsafe8;
                            i15 = i23;
                            i8 = i29;
                            i6 = -1;
                            i17 = i24;
                            i16 = i26;
                            i14 = i36;
                            if (iType != 50) {
                                i7 = i16;
                                int oneofField = parseOneofField(t, bArr, i14, i2, i4 == true ? 1 : 0, i7, i27, i28, iType, jOffset, i8, registers);
                                t2 = t;
                                if (oneofField != i14) {
                                    messageSchema = this;
                                    registers4 = registers;
                                    i21 = i7;
                                    i20 = oneofField;
                                    t6 = t2;
                                    i24 = i17;
                                    i19 = -1;
                                    i22 = i8;
                                    i23 = i15;
                                    unsafe3 = unsafe;
                                    bArr4 = bArr;
                                    i18 = i2;
                                } else {
                                    i5 = oneofField;
                                }
                            } else if (i27 == 2) {
                                int mapField = parseMapField(t, bArr, i14, i2, i8, jOffset, registers);
                                if (mapField != i14) {
                                    messageSchema = this;
                                    t6 = t;
                                    bArr4 = bArr;
                                    i18 = i2;
                                    registers4 = registers;
                                    i20 = mapField;
                                    i21 = i16;
                                    i24 = i17;
                                    i19 = -1;
                                    i22 = i8;
                                    i23 = i15;
                                    unsafe3 = unsafe;
                                } else {
                                    t2 = t;
                                    i5 = mapField;
                                    i7 = i16;
                                }
                            } else {
                                t2 = t;
                                i5 = i14;
                                i7 = i16;
                            }
                        }
                    } else if (i27 == 2) {
                        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t6, jOffset);
                        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                            int size = protobufListMutableCopyWithCapacity2.size();
                            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe3.putObject(t6, jOffset, protobufListMutableCopyWithCapacity2);
                        }
                        int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(i29), i4 == true ? 1 : 0, bArr15, i36, i2, protobufListMutableCopyWithCapacity2, registers);
                        bArr4 = bArr;
                        registers4 = registers;
                        i20 = iDecodeMessageList;
                        unsafe3 = unsafe3;
                        i21 = i26;
                        i22 = i29;
                        i19 = -1;
                        t6 = t;
                        i18 = i2;
                    } else {
                        i14 = i36;
                        unsafe = unsafe3;
                        i15 = i23;
                        i16 = i26;
                        i8 = i29;
                        i6 = -1;
                        i17 = i24;
                        t2 = t;
                        i5 = i14;
                        i7 = i16;
                    }
                    i24 = i17;
                    i23 = i15;
                }
            }
            int iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i4 == true ? 1 : 0, bArr, i5, i2, getMutableUnknownFields(t2), registers);
            bArr4 = bArr;
            registers4 = registers;
            i21 = i7;
            t6 = t2;
            i19 = i6;
            i22 = i8;
            unsafe3 = unsafe;
            i18 = i2;
            i20 = iDecodeUnknownField;
            messageSchema = this;
        }
        Unsafe unsafe9 = unsafe3;
        int i37 = i18;
        int i38 = i24;
        int i39 = i23;
        T t11 = t6;
        if (i38 != 1048575) {
            unsafe9.putInt(t11, i38, i39);
        }
        if (i20 == i37) {
            return i20;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i4, int i5, int i6, int i7, long j, int i8, long j2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList, registers);
                }
                if (i6 == 1) {
                    return ArrayDecoders.decodeDoubleList(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 19:
            case 36:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList, registers);
                }
                if (i6 == 5) {
                    return ArrayDecoders.decodeFloatList(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeVarint64List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeVarint32List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList, registers);
                }
                if (i6 == 1) {
                    return ArrayDecoders.decodeFixed64List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList, registers);
                }
                if (i6 == 5) {
                    return ArrayDecoders.decodeFixed32List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 25:
            case 42:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeBoolList(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 26:
                if (i6 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i4, bArr, i, i2, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 27:
                if (i6 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i7), i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 28:
                if (i6 == 2) {
                    return ArrayDecoders.decodeBytesList(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i4, bArr, i, i2, protobufList, registers);
                    }
                    return i;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList, registers);
                SchemaUtil.filterUnknownEnumList((Object) t, i5, (List<Integer>) protobufList, getEnumFieldVerifier(i7), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeSInt32List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 34:
            case 48:
                if (i6 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList, registers);
                }
                if (i6 == 0) {
                    return ArrayDecoders.decodeSInt64List(i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            case 49:
                if (i6 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i7), i4, bArr, i, i2, protobufList, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) {
        if (isEnforceUtf8(i)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbM15l = AbstractC0000a.m15l("Field ", str, " for ");
            AbstractC2322a.m1635y(cls, sbM15l, " not found. Known fields are ");
            sbM15l.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbM15l.toString());
        }
    }

    private void setFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t, j));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i4 = (length + i2) >>> 1;
            int i5 = i4 * 3;
            int iNumberAt = numberAt(i5);
            if (i == iNumberAt) {
                return i5;
            }
            if (i < iNumberAt) {
                length = i4 - 1;
            } else {
                i2 = i4 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, Object[] objArr) {
        int iObjectFieldOffset;
        int iM2289id;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iM2289id = type.m2289id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i] = fieldInfo.getFieldNumber();
            iArr[i + 1] = (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (iM2289id << 20) | iObjectFieldOffset;
            iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[AbstractC2322a.m1610D(i, 3, 2, 1)] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[AbstractC2322a.m1610D(i, 3, 2, 1)] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            int i2 = (i / 3) * 2;
            objArr[i2] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i2 + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[i2 + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        iM2289id = fieldInfo.getType().m2289id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (!fieldInfo.isEnforceUtf8()) {
        }
        iArr[i + 1] = (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (iM2289id << 20) | iObjectFieldOffset;
        iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    private void storeMessageField(T t, int i, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        UNSAFE.putObject(t, offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i2 = 1048575;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i6 = this.buffer[i5 + 2];
                int i7 = i6 & 1048575;
                if (i7 != i2) {
                    i4 = unsafe.getInt(t, i7);
                    i2 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i & i4) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                        continue;
                    }
                    break;
                case 1:
                    if ((i & i4) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    if ((i & i4) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    if ((i & i4) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if ((i & i4) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 5:
                    if ((i & i4) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    if ((i & i4) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 7:
                    if ((i & i4) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 8:
                    if ((i & i4) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    } else {
                        continue;
                    }
                    break;
                case 9:
                    if ((i & i4) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    } else {
                        continue;
                    }
                    break;
                case 10:
                    if ((i & i4) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 11:
                    if ((i & i4) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 12:
                    if ((i & i4) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 13:
                    if ((i & i4) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 14:
                    if ((i & i4) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 15:
                    if ((i & i4) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 16:
                    if ((i & i4) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    } else {
                        continue;
                    }
                    break;
                case 17:
                    if ((i & i4) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    } else {
                        continue;
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i5));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, false);
                    continue;
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i5), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i5));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i5);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto3(T t, Writer writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t, Writer writer) {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, length)) {
                        writer.writeInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, length)) {
                        writer.writeEnum(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i2) {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int i2;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i4 = iHashLong + i;
                    break;
                case 1:
                    i = i4 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 2:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 3:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 4:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 5:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 6:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 7:
                    i = i4 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 8:
                    i = i4 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 11:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 12:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 13:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 14:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 15:
                    i2 = i4 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t, jOffset);
                    i4 = i2 + iOneofIntAt;
                    break;
                case 16:
                    i = i4 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i4 = iHashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 50:
                    i = i4 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i4 = iHashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i4 = iHashLong + i;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i2 = i4 * 53;
                        iOneofIntAt = oneofIntAt(t, jOffset);
                        i4 = i2 + iOneofIntAt;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i4 = iHashLong + i;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        i = i4 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i4 = iHashLong + i;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t).hashCode() + (i4 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // androidx.glance.appwidget.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.checkInitializedCount) {
            int i7 = this.intArray[i5];
            int iNumberAt = numberAt(i7);
            int iTypeAndOffsetAt = typeAndOffsetAt(i7);
            int i8 = this.buffer[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i4) {
                if (i9 != 1048575) {
                    i6 = UNSAFE.getInt(t, i9);
                }
                i2 = i6;
                i = i9;
            } else {
                i = i4;
                i2 = i6;
            }
            T t2 = t;
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t2, i7, i, i2, i10)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t2, i7, i, i2, i10) && !isInitialized(t2, iTypeAndOffsetAt, getMessageFieldSchema(i7))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t2, iTypeAndOffsetAt, i7)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t2, iNumberAt, i7) && !isInitialized(t2, iTypeAndOffsetAt, getMessageFieldSchema(i7))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t2, iTypeAndOffsetAt, i7)) {
                    return false;
                }
            }
            i5++;
            t = t2;
            i4 = i;
            i6 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    @Override // androidx.glance.appwidget.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t, jOffset);
                                if (object != null) {
                                    unsafe.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(t, numberAt(i), i)) {
                        getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                    }
                } else if (isFieldPresent(t, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x041c  */
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i4, ArrayDecoders.Registers registers) {
        T t2;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        MessageSchema<T> messageSchema;
        int i8;
        int i9;
        ArrayDecoders.Registers registers2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        T t5;
        int iDecodeUnknownField;
        int i17;
        int i18;
        Unsafe unsafe2;
        int i19;
        ArrayDecoders.Registers registers3;
        byte[] bArr2;
        Unsafe unsafe3;
        ArrayDecoders.Registers registers4;
        T t6;
        Unsafe unsafe4;
        int i20;
        int iDecodeVarint64;
        byte[] bArr3;
        ArrayDecoders.Registers registers5;
        int i21;
        T t7;
        int iDecodeBytes;
        byte[] bArr4;
        int i22;
        int i23;
        MessageSchema<T> messageSchema2 = this;
        T t8 = t;
        byte[] bArr5 = bArr;
        int i24 = i2;
        ArrayDecoders.Registers registers6 = registers;
        checkMutable(t8);
        Unsafe unsafe5 = UNSAFE;
        int i25 = -1;
        int iMergeGroupField = i;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 1048575;
        while (true) {
            if (iMergeGroupField < i24) {
                int iDecodeVarint32 = iMergeGroupField + 1;
                int i31 = bArr5[iMergeGroupField];
                if (i31 < 0) {
                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(i31, bArr5, iDecodeVarint32, registers6);
                    i31 = registers6.int1;
                }
                int i32 = iDecodeVarint32;
                i29 = i31;
                int i33 = (i29 == true ? 1 : 0) >>> 3;
                int i34 = (i29 == true ? 1 : 0) & 7;
                int iPositionForFieldNumber = i33 > i26 ? messageSchema2.positionForFieldNumber(i33, i27 / 3) : messageSchema2.positionForFieldNumber(i33);
                if (iPositionForFieldNumber == i25) {
                    registers2 = registers;
                    i10 = i32;
                    unsafe = unsafe5;
                    i11 = i25;
                    i12 = i28;
                    i13 = i33;
                    i14 = 0;
                    i6 = 1048575;
                    i7 = i4;
                    i15 = i30;
                    messageSchema = messageSchema2;
                } else {
                    int i35 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int i36 = i25;
                    int iType = type(i35);
                    long jOffset = offset(i35);
                    if (iType <= 17) {
                        int i37 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i38 = 1 << (i37 >>> 20);
                        int i39 = i37 & 1048575;
                        i13 = i33;
                        if (i39 != i30) {
                            if (i30 != 1048575) {
                                unsafe5.putInt(t8, i30, i28);
                            }
                            i28 = unsafe5.getInt(t8, i39);
                        } else {
                            i39 = i30;
                        }
                        switch (iType) {
                            case 0:
                                bArr4 = bArr;
                                i18 = iPositionForFieldNumber;
                                i19 = i32;
                                unsafe4 = unsafe5;
                                registers3 = registers;
                                if (i34 == 1) {
                                    UnsafeUtil.putDouble(t8, jOffset, ArrayDecoders.decodeDouble(bArr4, i19));
                                    i22 = i19 + 8;
                                    i28 |= i38;
                                    i24 = i2;
                                    registers6 = registers3;
                                    i30 = i39;
                                    i27 = i18;
                                    i26 = i13;
                                    unsafe5 = unsafe4;
                                    iMergeGroupField = i22;
                                    bArr5 = bArr4;
                                    i25 = i36;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7 || i7 == 0) {
                                        if (!messageSchema.hasExtensions || registers2.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                                            t5 = t;
                                            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i16, bArr, i10, i2, getMutableUnknownFields(t5), registers);
                                            i17 = i2;
                                        } else {
                                            iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i16, bArr, i10, i2, t, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers);
                                            t5 = t;
                                            i17 = i2;
                                        }
                                        iMergeGroupField = iDecodeUnknownField;
                                        bArr5 = bArr;
                                        i29 = i16;
                                        t8 = t5;
                                        i24 = i17;
                                        messageSchema2 = messageSchema;
                                        i27 = i14;
                                        i30 = i15;
                                        i28 = i12;
                                        unsafe5 = unsafe;
                                        i25 = i11;
                                        i26 = i13;
                                        registers6 = registers;
                                    } else {
                                        t2 = t;
                                        i5 = i2;
                                        i29 = i16;
                                        i8 = i10;
                                        i9 = i15;
                                        i28 = i12;
                                    }
                                }
                                break;
                            case 1:
                                bArr4 = bArr;
                                i18 = iPositionForFieldNumber;
                                i19 = i32;
                                unsafe4 = unsafe5;
                                registers3 = registers;
                                if (i34 == 5) {
                                    UnsafeUtil.putFloat(t8, jOffset, ArrayDecoders.decodeFloat(bArr4, i19));
                                    i22 = i19 + 4;
                                    i28 |= i38;
                                    i24 = i2;
                                    registers6 = registers3;
                                    i30 = i39;
                                    i27 = i18;
                                    i26 = i13;
                                    unsafe5 = unsafe4;
                                    iMergeGroupField = i22;
                                    bArr5 = bArr4;
                                    i25 = i36;
                                    break;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                        t5 = t;
                                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i16, bArr, i10, i2, getMutableUnknownFields(t5), registers);
                                        i17 = i2;
                                        iMergeGroupField = iDecodeUnknownField;
                                        bArr5 = bArr;
                                        i29 = i16;
                                        t8 = t5;
                                        i24 = i17;
                                        messageSchema2 = messageSchema;
                                        i27 = i14;
                                        i30 = i15;
                                        i28 = i12;
                                        unsafe5 = unsafe;
                                        i25 = i11;
                                        i26 = i13;
                                        registers6 = registers;
                                        break;
                                    }
                                }
                                break;
                            case 2:
                            case 3:
                                i18 = iPositionForFieldNumber;
                                unsafe2 = unsafe5;
                                i19 = i32;
                                registers3 = registers;
                                if (i34 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i19, registers3);
                                    T t9 = t8;
                                    unsafe2.putLong(t9, jOffset, registers3.long1);
                                    t8 = t9;
                                    i28 |= i38;
                                    unsafe5 = unsafe2;
                                    iMergeGroupField = iDecodeVarint642;
                                    registers6 = registers3;
                                    i24 = i2;
                                    i30 = i39;
                                    bArr5 = bArr;
                                    i27 = i18;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    unsafe4 = unsafe2;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 4:
                            case 11:
                                bArr4 = bArr;
                                i18 = iPositionForFieldNumber;
                                unsafe2 = unsafe5;
                                i19 = i32;
                                registers3 = registers;
                                if (i34 == 0) {
                                    int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr4, i19, registers3);
                                    unsafe2.putInt(t8, jOffset, registers3.int1);
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeVarint322;
                                    registers6 = registers3;
                                    i30 = i39;
                                    i27 = i18;
                                    i26 = i13;
                                    unsafe5 = unsafe2;
                                    bArr5 = bArr4;
                                    i25 = i36;
                                    break;
                                } else {
                                    unsafe4 = unsafe2;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 5:
                            case 14:
                                bArr4 = bArr;
                                i18 = iPositionForFieldNumber;
                                Unsafe unsafe6 = unsafe5;
                                T t10 = t8;
                                if (i34 == 1) {
                                    registers3 = registers;
                                    unsafe6.putLong(t10, jOffset, ArrayDecoders.decodeFixed64(bArr4, i32));
                                    unsafe2 = unsafe6;
                                    t8 = t10;
                                    iMergeGroupField = i32 + 8;
                                    i28 |= i38;
                                    i24 = i2;
                                    registers6 = registers3;
                                    i30 = i39;
                                    i27 = i18;
                                    i26 = i13;
                                    unsafe5 = unsafe2;
                                    bArr5 = bArr4;
                                    i25 = i36;
                                    break;
                                } else {
                                    unsafe2 = unsafe6;
                                    i19 = i32;
                                    registers3 = registers;
                                    unsafe4 = unsafe2;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                registers4 = registers;
                                t6 = t8;
                                if (i34 == 5) {
                                    unsafe3.putInt(t6, jOffset, ArrayDecoders.decodeFixed32(bArr2, i32));
                                    iMergeGroupField = i32 + 4;
                                    i28 |= i38;
                                    i24 = i2;
                                    registers6 = registers4;
                                    t8 = t6;
                                    i30 = i39;
                                    bArr5 = bArr2;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    unsafe4 = unsafe3;
                                    i19 = i32;
                                    registers3 = registers4;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 7:
                                bArr2 = bArr;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                i20 = i32;
                                registers4 = registers;
                                t6 = t8;
                                if (i34 == 0) {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i20, registers4);
                                    UnsafeUtil.putBoolean(t6, jOffset, registers4.long1 != 0);
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeVarint64;
                                    registers6 = registers4;
                                    t8 = t6;
                                    i30 = i39;
                                    bArr5 = bArr2;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    unsafe4 = unsafe3;
                                    registers3 = registers4;
                                    i19 = i20;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 8:
                                bArr2 = bArr;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                i20 = i32;
                                registers4 = registers;
                                t6 = t8;
                                if (i34 == 2) {
                                    iDecodeVarint64 = (536870912 & i35) == 0 ? ArrayDecoders.decodeString(bArr2, i20, registers4) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i20, registers4);
                                    unsafe3.putObject(t6, jOffset, registers4.object1);
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeVarint64;
                                    registers6 = registers4;
                                    t8 = t6;
                                    i30 = i39;
                                    bArr5 = bArr2;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    unsafe4 = unsafe3;
                                    registers3 = registers4;
                                    i19 = i20;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 9:
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                t6 = t8;
                                if (i34 == 2) {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t6, i18);
                                    int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i18), bArr, i32, i2, registers);
                                    bArr2 = bArr;
                                    registers4 = registers;
                                    messageSchema2.storeMessageField(t6, i18, objMutableMessageFieldForMerge);
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iMergeMessageField;
                                    registers6 = registers4;
                                    t8 = t6;
                                    i30 = i39;
                                    bArr5 = bArr2;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    i20 = i32;
                                    registers4 = registers;
                                    unsafe4 = unsafe3;
                                    registers3 = registers4;
                                    i19 = i20;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 10:
                                bArr3 = bArr;
                                registers5 = registers;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                i21 = i32;
                                t7 = t8;
                                if (i34 == 2) {
                                    iDecodeBytes = ArrayDecoders.decodeBytes(bArr3, i21, registers5);
                                    unsafe3.putObject(t7, jOffset, registers5.object1);
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeBytes;
                                    bArr5 = bArr3;
                                    t8 = t7;
                                    i30 = i39;
                                    registers6 = registers5;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    registers3 = registers5;
                                    unsafe4 = unsafe3;
                                    i19 = i21;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 12:
                                bArr3 = bArr;
                                registers5 = registers;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                i21 = i32;
                                t7 = t8;
                                if (i34 == 0) {
                                    iDecodeBytes = ArrayDecoders.decodeVarint32(bArr3, i21, registers5);
                                    int i40 = registers5.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i18);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i40)) {
                                        unsafe3.putInt(t7, jOffset, i40);
                                        i28 |= i38;
                                        i24 = i2;
                                        iMergeGroupField = iDecodeBytes;
                                        bArr5 = bArr3;
                                        t8 = t7;
                                        i30 = i39;
                                        registers6 = registers5;
                                        i27 = i18;
                                        unsafe5 = unsafe3;
                                        i25 = i36;
                                        i26 = i13;
                                    } else {
                                        getMutableUnknownFields(t7).storeField(i29 == true ? 1 : 0, Long.valueOf(i40));
                                        i24 = i2;
                                        iMergeGroupField = iDecodeBytes;
                                        bArr5 = bArr3;
                                        t8 = t7;
                                        i30 = i39;
                                        registers6 = registers5;
                                        i27 = i18;
                                        unsafe5 = unsafe3;
                                        i25 = i36;
                                        i26 = i13;
                                    }
                                    break;
                                } else {
                                    registers3 = registers5;
                                    unsafe4 = unsafe3;
                                    i19 = i21;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 15:
                                bArr3 = bArr;
                                registers5 = registers;
                                i18 = iPositionForFieldNumber;
                                unsafe3 = unsafe5;
                                i21 = i32;
                                t7 = t8;
                                if (i34 == 0) {
                                    iDecodeBytes = ArrayDecoders.decodeVarint32(bArr3, i21, registers5);
                                    unsafe3.putInt(t7, jOffset, CodedInputStream.decodeZigZag32(registers5.int1));
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeBytes;
                                    bArr5 = bArr3;
                                    t8 = t7;
                                    i30 = i39;
                                    registers6 = registers5;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    registers3 = registers5;
                                    unsafe4 = unsafe3;
                                    i19 = i21;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 16:
                                bArr3 = bArr;
                                registers5 = registers;
                                i18 = iPositionForFieldNumber;
                                if (i34 == 0) {
                                    int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr3, i32, registers5);
                                    T t11 = t8;
                                    Unsafe unsafe7 = unsafe5;
                                    unsafe7.putLong(t11, jOffset, CodedInputStream.decodeZigZag64(registers5.long1));
                                    unsafe3 = unsafe7;
                                    t7 = t11;
                                    i28 |= i38;
                                    i24 = i2;
                                    iMergeGroupField = iDecodeVarint643;
                                    bArr5 = bArr3;
                                    t8 = t7;
                                    i30 = i39;
                                    registers6 = registers5;
                                    i27 = i18;
                                    unsafe5 = unsafe3;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    i19 = i32;
                                    unsafe4 = unsafe5;
                                    registers3 = registers5;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            case 17:
                                if (i34 == 3) {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t8, iPositionForFieldNumber);
                                    i18 = iPositionForFieldNumber;
                                    iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i32, i2, (i13 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t8, i18, objMutableMessageFieldForMerge2);
                                    i28 |= i38;
                                    i24 = i2;
                                    bArr5 = bArr;
                                    i30 = i39;
                                    registers6 = registers;
                                    i27 = i18;
                                    i25 = i36;
                                    i26 = i13;
                                    break;
                                } else {
                                    i18 = iPositionForFieldNumber;
                                    unsafe4 = unsafe5;
                                    i19 = i32;
                                    registers3 = registers;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe4;
                                    registers2 = registers3;
                                    i15 = i39;
                                    i16 = i29 == true ? 1 : 0;
                                    i10 = i19;
                                    i11 = i36;
                                    i6 = 1048575;
                                    i7 = i4;
                                    i12 = i28;
                                    i14 = i18;
                                    if (i16 == i7) {
                                    }
                                    if (messageSchema.hasExtensions) {
                                    }
                                }
                                break;
                            default:
                                i18 = iPositionForFieldNumber;
                                unsafe4 = unsafe5;
                                i19 = i32;
                                registers3 = registers;
                                messageSchema = messageSchema2;
                                unsafe = unsafe4;
                                registers2 = registers3;
                                i15 = i39;
                                i16 = i29 == true ? 1 : 0;
                                i10 = i19;
                                i11 = i36;
                                i6 = 1048575;
                                i7 = i4;
                                i12 = i28;
                                i14 = i18;
                                if (i16 == i7) {
                                }
                                if (messageSchema.hasExtensions) {
                                }
                                break;
                        }
                    } else {
                        i13 = i33;
                        int i41 = iPositionForFieldNumber;
                        Unsafe unsafe8 = unsafe5;
                        if (iType != 27) {
                            i23 = i32;
                            if (iType <= 49) {
                                i15 = i30;
                                unsafe = unsafe8;
                                i11 = i36;
                                i6 = 1048575;
                                i12 = i28;
                                int repeatedField = messageSchema2.parseRepeatedField(t, bArr, i23, i2, i29 == true ? 1 : 0, i13, i34, i41, i35, iType, jOffset, registers);
                                i29 = i29 == true ? 1 : 0;
                                i14 = i41;
                                if (repeatedField != i23) {
                                    messageSchema2 = this;
                                    t8 = t;
                                    bArr5 = bArr;
                                    i24 = i2;
                                    iMergeGroupField = repeatedField;
                                    i27 = i14;
                                    i30 = i15;
                                    i28 = i12;
                                    unsafe5 = unsafe;
                                    i25 = i11;
                                    i26 = i13;
                                    registers6 = registers;
                                } else {
                                    messageSchema = this;
                                    i7 = i4;
                                    registers2 = registers;
                                    i10 = repeatedField;
                                }
                            } else {
                                i29 = i29 == true ? 1 : 0;
                                i15 = i30;
                                unsafe = unsafe8;
                                i11 = i36;
                                i6 = 1048575;
                                i12 = i28;
                                i14 = i41;
                                if (iType != 50) {
                                    int oneofField = parseOneofField(t, bArr, i23, i2, i29 == true ? 1 : 0, i13, i34, i35, iType, jOffset, i14, registers);
                                    messageSchema = this;
                                    i16 = i29 == true ? 1 : 0;
                                    registers2 = registers;
                                    if (oneofField != i23) {
                                        t8 = t;
                                        bArr5 = bArr;
                                        i24 = i2;
                                        i29 = i16 == true ? 1 : 0;
                                        iMergeGroupField = oneofField;
                                        messageSchema2 = messageSchema;
                                        i27 = i14;
                                        i30 = i15;
                                        i28 = i12;
                                        unsafe5 = unsafe;
                                        i25 = i11;
                                        registers6 = registers2;
                                    } else {
                                        i7 = i4;
                                        i10 = oneofField;
                                        if (i16 == i7) {
                                        }
                                        if (messageSchema.hasExtensions) {
                                        }
                                    }
                                } else if (i34 == 2) {
                                    int mapField = parseMapField(t, bArr, i23, i2, i14, jOffset, registers);
                                    if (mapField != i23) {
                                        messageSchema2 = this;
                                        t8 = t;
                                        bArr5 = bArr;
                                        i24 = i2;
                                        registers6 = registers;
                                        iMergeGroupField = mapField;
                                        i27 = i14;
                                        i30 = i15;
                                        i28 = i12;
                                        unsafe5 = unsafe;
                                        i25 = i11;
                                    } else {
                                        messageSchema = this;
                                        i7 = i4;
                                        registers2 = registers;
                                        i10 = mapField;
                                    }
                                }
                                i26 = i13;
                            }
                        } else if (i34 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t8, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe8.putObject(t8, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            i24 = i2;
                            registers6 = registers;
                            iMergeGroupField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i41), i29 == true ? 1 : 0, bArr, i32, i2, protobufListMutableCopyWithCapacity2, registers);
                            i27 = i41;
                            unsafe5 = unsafe8;
                            i25 = i36;
                            i26 = i13;
                            t8 = t;
                            bArr5 = bArr;
                        } else {
                            i23 = i32;
                            i15 = i30;
                            unsafe = unsafe8;
                            i11 = i36;
                            i6 = 1048575;
                            i12 = i28;
                            i14 = i41;
                        }
                        messageSchema = this;
                        i7 = i4;
                        registers2 = registers;
                        i10 = i23;
                    }
                }
                i16 = i29;
                if (i16 == i7) {
                }
                if (messageSchema.hasExtensions) {
                }
            } else {
                t2 = t8;
                i5 = i24;
                int i42 = i30;
                unsafe = unsafe5;
                i6 = 1048575;
                i7 = i4;
                messageSchema = messageSchema2;
                i8 = iMergeGroupField;
                i9 = i42;
            }
        }
        if (i9 != i6) {
            unsafe.putInt(t2, i9, i28);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i43 = messageSchema.checkInitializedCount; i43 < messageSchema.repeatedFieldOffsetStart; i43++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i43], unknownFieldSetLite, messageSchema.unknownFieldSchema, t);
        }
        T t12 = t2;
        MessageSchema<T> messageSchema3 = messageSchema;
        if (unknownFieldSetLite != null) {
            messageSchema3.unknownFieldSchema.setBuilderToMessage(t12, unknownFieldSetLite);
        }
        if (i7 == 0) {
            if (i8 != i5) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i8 > i5 || i29 != i7) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i8;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void writeTo(T t, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    private boolean isFieldPresent(T t, int i) {
        boolean zEquals;
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(t, j) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t, jOffset);
                if (object instanceof String) {
                    zEquals = ((String) object).isEmpty();
                } else {
                    if (!(object instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.EMPTY.equals(object);
                }
                break;
            case 9:
                return UnsafeUtil.getObject(t, jOffset) != null;
            case 10:
                zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                break;
            case 11:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    private boolean equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t, t2, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t, t2, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getBoolean(t, jOffset) != UnsafeUtil.getBoolean(t2, jOffset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getInt(t, jOffset) != UnsafeUtil.getInt(t2, jOffset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t, t2, i) || UnsafeUtil.getLong(t, jOffset) != UnsafeUtil.getLong(t2, jOffset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t, t2, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                }
                break;
        }
        return true;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        if (this.proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }
}
