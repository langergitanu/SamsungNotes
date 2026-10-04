package androidx.datastore.preferences.protobuf;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
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

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C26771 {
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
        switch (C26771.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
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

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
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
        int i4 = -1;
        int i5 = 0;
        int iM1608B = 0;
        int i6 = 0;
        while (i5 < this.buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                i = this.buffer[i5 + 2];
                int i7 = OFFSET_MASK & i;
                int i8 = 1 << (i >>> 20);
                if (i7 != i4) {
                    i6 = unsafe.getInt(t, i7);
                    i4 = i7;
                }
                i2 = i8;
            } else {
                i = (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.m2159id() || iType > FieldType.SINT64_LIST_PACKED.m2159id()) ? 0 : this.buffer[i5 + 2] & OFFSET_MASK;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            int i9 = i4;
            switch (iType) {
                case 0:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if ((i6 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i6 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM1608B = iComputeBytesSize + iM1608B;
                    }
                    break;
                case 9:
                    if ((i6 & i2) != 0) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM1608B += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 14:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i6 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 31:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    iM1608B += iComputeSizeFixed32List;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM1608B);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM1608B);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM1608B);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM1608B);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM1608B);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag2);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM1608B);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag2);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM1608B);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeBoolListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM1608B);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeUInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM1608B);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeEnumListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM1608B);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed32ListNoTag3);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM1608B);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag3);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM1608B);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM1608B);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeSInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM1608B);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i5));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM1608B = iComputeBytesSize + iM1608B;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM1608B += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i5));
                        iM1608B += iComputeBoolSize;
                    }
                    break;
            }
            i5 += 3;
            i4 = i9;
        }
        int unknownFieldsSerializedSize = iM1608B + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeBytesSize;
        int iComputeSizeMessage;
        Unsafe unsafe = UNSAFE;
        int iM1608B = 0;
        for (int i = 0; i < this.buffer.length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            int i2 = (iType < FieldType.DOUBLE_LIST_PACKED.m2159id() || iType > FieldType.SINT64_LIST_PACKED.m2159id()) ? 0 : this.buffer[i + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 1:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 2:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 3:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 4:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 5:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 6:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t, i)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        iM1608B = iComputeBytesSize + iM1608B;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM1608B += iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    iM1608B += iComputeSizeMessage;
                    break;
                case 35:
                    int iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag, iM1608B);
                    }
                    break;
                case 36:
                    int iComputeSizeFixed32ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag, iM1608B);
                    }
                    break;
                case 37:
                    int iComputeSizeInt64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt64ListNoTag, iM1608B);
                    }
                    break;
                case 38:
                    int iComputeSizeUInt64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeUInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt64ListNoTag, iM1608B);
                    }
                    break;
                case 39:
                    int iComputeSizeInt32ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeInt32ListNoTag, iM1608B);
                    }
                    break;
                case 40:
                    int iComputeSizeFixed64ListNoTag2 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag2);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag2, iM1608B);
                    }
                    break;
                case 41:
                    int iComputeSizeFixed32ListNoTag2 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag2 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag2);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag2, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag2, iM1608B);
                    }
                    break;
                case 42:
                    int iComputeSizeBoolListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeBoolListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeBoolListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeBoolListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeBoolListNoTag, iM1608B);
                    }
                    break;
                case 43:
                    int iComputeSizeUInt32ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeUInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeUInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeUInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeUInt32ListNoTag, iM1608B);
                    }
                    break;
                case 44:
                    int iComputeSizeEnumListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeEnumListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeEnumListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeEnumListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeEnumListNoTag, iM1608B);
                    }
                    break;
                case 45:
                    int iComputeSizeFixed32ListNoTag3 = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed32ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed32ListNoTag3);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed32ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed32ListNoTag3, iM1608B);
                    }
                    break;
                case 46:
                    int iComputeSizeFixed64ListNoTag3 = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag3 > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeFixed64ListNoTag3);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeFixed64ListNoTag3, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeFixed64ListNoTag3, iM1608B);
                    }
                    break;
                case 47:
                    int iComputeSizeSInt32ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt32ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt32ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeSInt32ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt32ListNoTag, iM1608B);
                    }
                    break;
                case 48:
                    int iComputeSizeSInt64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeSInt64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i2, iComputeSizeSInt64ListNoTag);
                        }
                        iM1608B = AbstractC2322a.m1608B(iComputeSizeSInt64ListNoTag, CodedOutputStream.computeTagSize(iNumberAt), iComputeSizeSInt64ListNoTag, iM1608B);
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i));
                    iM1608B += iComputeSizeMessage;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        iComputeBytesSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        iM1608B = iComputeBytesSize + iM1608B;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM1608B += iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i));
                        iM1608B += iComputeDoubleSize;
                    }
                    break;
            }
        }
        return iM1608B + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
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

    private boolean isFieldPresent(T t, int i, int i2, int i4) {
        return this.proto3 ? isFieldPresent(t, i) : (i2 & i4) != 0;
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
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.Schema] */
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

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & OFFSET_MASK;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == i;
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

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.repeatedFieldOffsetStart) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = filterMapUnknownEnumValues(r9, r14.intArray[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0638 A[LOOP:3: B:197:0x0634->B:199:0x0638, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x060f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0, types: [androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int i;
        ExtensionSchema<ET> extensionSchema2;
        Object objFindExtensionByNumber;
        Object obj;
        T t2 = t;
        ExtensionRegistryLite extensionRegistryLite2 = extensionRegistryLite;
        Object objFilterMapUnknownEnumValues = null;
        FieldSet mutableExtensions = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    Reader reader2 = reader;
                    obj = objFilterMapUnknownEnumValues;
                    int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                    switch (type(iTypeAndOffsetAt)) {
                        case 0:
                            UnsafeUtil.putDouble(t2, offset(iTypeAndOffsetAt), reader2.readDouble());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 1:
                            UnsafeUtil.putFloat(t2, offset(iTypeAndOffsetAt), reader2.readFloat());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 2:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 3:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readUInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 4:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 5:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 6:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 7:
                            UnsafeUtil.putBoolean(t2, offset(iTypeAndOffsetAt), reader2.readBool());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 8:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 9:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 10:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 11:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readUInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 12:
                            int i2 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i2)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i2, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), i2);
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 13:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSFixed32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 14:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSFixed64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 15:
                            UnsafeUtil.putInt(t2, offset(iTypeAndOffsetAt), reader2.readSInt32());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 16:
                            UnsafeUtil.putLong(t2, offset(iTypeAndOffsetAt), reader2.readSInt64());
                            setFieldPresent(t2, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 17:
                            if (isFieldPresent(t2, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 18:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 19:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 20:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 21:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 22:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 23:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 24:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 25:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 26:
                            readStringList(t2, iTypeAndOffsetAt, reader2);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 27:
                            T t5 = t2;
                            try {
                                readMessageList(t5, iTypeAndOffsetAt, reader2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                t2 = t5;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                t2 = t5;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 28:
                            reader2.readBytesList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 29:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 30:
                            List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 31:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 32:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 33:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 34:
                            reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 35:
                            reader2.readDoubleList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 36:
                            reader2.readFloatList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 37:
                            reader2.readInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 38:
                            reader2.readUInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 39:
                            reader2.readInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 40:
                            reader2.readFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 41:
                            reader2.readFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 42:
                            reader2.readBoolList(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 43:
                            reader2.readUInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 44:
                            List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt));
                            reader2.readEnumList(listMutableListAt2);
                            objFilterMapUnknownEnumValues = SchemaUtil.filterUnknownEnumList(fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), obj, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                            extensionRegistryLite2 = extensionRegistryLite;
                            break;
                        case 45:
                            reader2.readSFixed32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 46:
                            reader2.readSFixed64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 47:
                            reader2.readSInt32List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                            extensionRegistryLite2 = extensionRegistryLite;
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 48:
                            try {
                                reader2.readSInt64List(this.listFieldSchema.mutableListAt(t2, offset(iTypeAndOffsetAt)));
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 49:
                            try {
                                try {
                                    readGroupList(t, offset(iTypeAndOffsetAt), reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    t2 = t;
                                    extensionRegistryLite2 = extensionRegistryLite;
                                    objFilterMapUnknownEnumValues = obj;
                                } catch (Throwable th) {
                                    th = th;
                                    t2 = t;
                                    objFilterMapUnknownEnumValues = obj;
                                    for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    }
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                t2 = t;
                                reader2 = reader;
                                objFilterMapUnknownEnumValues = obj;
                                extensionRegistryLite2 = extensionRegistryLite;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            }
                            break;
                        case 50:
                            try {
                                mergeMap(t2, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite2, reader);
                                t2 = t;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused4) {
                                t2 = t;
                                reader2 = reader;
                                extensionRegistryLite2 = extensionRegistryLite;
                                objFilterMapUnknownEnumValues = obj;
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                t2 = t;
                                objFilterMapUnknownEnumValues = obj;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                            break;
                        case 51:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Double.valueOf(reader2.readDouble()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 52:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Float.valueOf(reader2.readFloat()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 53:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 54:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readUInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 55:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 56:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 57:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 58:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Boolean.valueOf(reader2.readBool()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 59:
                            readString(t2, iTypeAndOffsetAt, reader2);
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 60:
                            if (isOneofPresent(t2, fieldNumber, iPositionForFieldNumber)) {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Internal.mergeMessage(UnsafeUtil.getObject(t2, offset(iTypeAndOffsetAt)), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2)));
                            } else {
                                UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readMessageBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                                setFieldPresent(t2, iPositionForFieldNumber);
                            }
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 61:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readBytes());
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 62:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readUInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 63:
                            int i4 = reader2.readEnum();
                            Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                            if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i4)) {
                                objFilterMapUnknownEnumValues = SchemaUtil.storeUnknownEnum(fieldNumber, i4, obj, unknownFieldSchema);
                            }
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(i4));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 64:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSFixed32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 65:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSFixed64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 66:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Integer.valueOf(reader2.readSInt32()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 67:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), Long.valueOf(reader2.readSInt64()));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        case 68:
                            UnsafeUtil.putObject(t2, offset(iTypeAndOffsetAt), reader2.readGroupBySchemaWithCheck(getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2));
                            setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                            objFilterMapUnknownEnumValues = obj;
                            break;
                        default:
                            objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.newBuilder() : obj;
                            try {
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused5) {
                                if (!unknownFieldSchema.shouldDiscardUnknownFields(reader2)) {
                                    if (objFilterMapUnknownEnumValues == null) {
                                        objFilterMapUnknownEnumValues = unknownFieldSchema.getBuilderFromMessage(t2);
                                    }
                                    if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                        for (int i5 = this.checkInitializedCount; i5 < this.repeatedFieldOffsetStart; i5++) {
                                            objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i5], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                        }
                                        if (objFilterMapUnknownEnumValues == null) {
                                            return;
                                        }
                                        unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                        return;
                                    }
                                } else if (!reader2.skipField()) {
                                    for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i6], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                    }
                                    if (objFilterMapUnknownEnumValues == null) {
                                        return;
                                    }
                                    unknownFieldSchema.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
                                    return;
                                }
                            }
                            if (!unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader2)) {
                                for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                                    objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i7], objFilterMapUnknownEnumValues, unknownFieldSchema);
                                }
                                if (objFilterMapUnknownEnumValues == null) {
                                    return;
                                }
                            }
                            break;
                    }
                } else if (fieldNumber == Integer.MAX_VALUE) {
                    for (int i8 = this.checkInitializedCount; i8 < this.repeatedFieldOffsetStart; i8++) {
                        objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t2, this.intArray[i8], objFilterMapUnknownEnumValues, unknownFieldSchema);
                    }
                    if (objFilterMapUnknownEnumValues == null) {
                        return;
                    }
                } else {
                    if (this.hasExtensions) {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = extensionSchema2.findExtensionByNumber(extensionRegistryLite2, this.defaultInstance, fieldNumber);
                    } else {
                        extensionSchema2 = extensionSchema;
                        objFindExtensionByNumber = null;
                    }
                    if (objFindExtensionByNumber != null) {
                        if (mutableExtensions == null) {
                            try {
                                mutableExtensions = extensionSchema.getMutableExtensions(t);
                            } catch (Throwable th3) {
                                th = th3;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                        }
                        FieldSet fieldSet = mutableExtensions;
                        objFilterMapUnknownEnumValues = extensionSchema2.parseExtension(reader, objFindExtensionByNumber, extensionRegistryLite2, fieldSet, objFilterMapUnknownEnumValues, unknownFieldSchema);
                        mutableExtensions = fieldSet;
                    } else {
                        obj = objFilterMapUnknownEnumValues;
                        try {
                            if (unknownFieldSchema.shouldDiscardUnknownFields(reader)) {
                                if (!reader.skipField()) {
                                    objFilterMapUnknownEnumValues = obj;
                                }
                                objFilterMapUnknownEnumValues = obj;
                            } else {
                                objFilterMapUnknownEnumValues = obj == null ? unknownFieldSchema.getBuilderFromMessage(t2) : obj;
                                if (unknownFieldSchema.mergeOneFieldFrom(objFilterMapUnknownEnumValues, reader)) {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objFilterMapUnknownEnumValues = obj;
                            while (i < this.repeatedFieldOffsetStart) {
                            }
                            if (objFilterMapUnknownEnumValues != null) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
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

    private void mergeMessage(T t, T t2, int i) {
        long jOffset = offset(typeAndOffsetAt(i));
        if (isFieldPresent(t2, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setFieldPresent(t, i);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        int iNumberAt = numberAt(i);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, i)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, iNumberAt, i);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setOneofPresent(t, iNumberAt, i);
            }
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
            } else if (fieldInfo.getType().m2159id() >= 18 && fieldInfo.getType().m2159id() <= 49) {
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
            storeFieldData(fieldInfo2, iArr, i6, z, objArr);
            if (i7 < checkInitialized.length && checkInitialized[i7] == fieldNumber3) {
                checkInitialized[i7] = i6;
                i7++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i8] = i6;
                i8++;
            } else {
                if (fieldInfo2.getType().m2159id() >= 18 && fieldInfo2.getType().m2159id() <= 49) {
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

    /* JADX WARN: Removed duplicated region for block: B:166:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i2;
        int i4;
        int i5;
        int[] iArr;
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
        boolean z;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int iObjectFieldOffset2;
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
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        char cCharAt14;
        int i30 = 0;
        boolean z2 = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int iCharAt4 = stringInfo.charAt(0);
        if (iCharAt4 >= 55296) {
            int i31 = iCharAt4 & 8191;
            int i32 = 1;
            int i33 = 13;
            while (true) {
                i = i32 + 1;
                cCharAt14 = stringInfo.charAt(i32);
                if (cCharAt14 < 55296) {
                    break;
                }
                i31 |= (cCharAt14 & 8191) << i33;
                i33 += 13;
                i32 = i;
            }
            iCharAt4 = i31 | (cCharAt14 << i33);
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt5 = stringInfo.charAt(i);
        if (iCharAt5 >= 55296) {
            int i35 = iCharAt5 & 8191;
            int i36 = 13;
            while (true) {
                i29 = i34 + 1;
                cCharAt13 = stringInfo.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i29;
            }
            iCharAt5 = i35 | (cCharAt13 << i36);
            i34 = i29;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i2 = 0;
            iCharAt3 = 0;
            iArr = EMPTY_INT_ARRAY;
            i4 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt6 = stringInfo.charAt(i34);
            if (iCharAt6 >= 55296) {
                int i38 = iCharAt6 & 8191;
                int i39 = 13;
                while (true) {
                    i13 = i37 + 1;
                    cCharAt8 = stringInfo.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i13;
                }
                iCharAt6 = i38 | (cCharAt8 << i39);
                i37 = i13;
            }
            int i40 = i37 + 1;
            int iCharAt7 = stringInfo.charAt(i37);
            if (iCharAt7 >= 55296) {
                int i41 = iCharAt7 & 8191;
                int i42 = 13;
                while (true) {
                    i12 = i40 + 1;
                    cCharAt7 = stringInfo.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i12;
                }
                iCharAt7 = i41 | (cCharAt7 << i42);
                i40 = i12;
            }
            int i43 = i40 + 1;
            iCharAt = stringInfo.charAt(i40);
            if (iCharAt >= 55296) {
                int i44 = iCharAt & 8191;
                int i45 = 13;
                while (true) {
                    i11 = i43 + 1;
                    cCharAt6 = stringInfo.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i11;
                }
                iCharAt = i44 | (cCharAt6 << i45);
                i43 = i11;
            }
            int i46 = i43 + 1;
            int iCharAt8 = stringInfo.charAt(i43);
            if (iCharAt8 >= 55296) {
                int i47 = iCharAt8 & 8191;
                int i48 = 13;
                while (true) {
                    i10 = i46 + 1;
                    cCharAt5 = stringInfo.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i10;
                }
                iCharAt8 = i47 | (cCharAt5 << i48);
                i46 = i10;
            }
            int i49 = i46 + 1;
            int iCharAt9 = stringInfo.charAt(i46);
            if (iCharAt9 >= 55296) {
                int i50 = iCharAt9 & 8191;
                int i51 = 13;
                while (true) {
                    i9 = i49 + 1;
                    cCharAt4 = stringInfo.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i9;
                }
                iCharAt9 = i50 | (cCharAt4 << i51);
                i49 = i9;
            }
            int i52 = i49 + 1;
            iCharAt2 = stringInfo.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i8 = i52 + 1;
                    cCharAt3 = stringInfo.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i8;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i8;
            }
            int i55 = i52 + 1;
            int iCharAt10 = stringInfo.charAt(i52);
            if (iCharAt10 >= 55296) {
                int i56 = iCharAt10 & 8191;
                int i57 = 13;
                while (true) {
                    i7 = i55 + 1;
                    cCharAt2 = stringInfo.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i7;
                }
                iCharAt10 = i56 | (cCharAt2 << i57);
                i55 = i7;
            }
            int i58 = i55 + 1;
            iCharAt3 = stringInfo.charAt(i55);
            if (iCharAt3 >= 55296) {
                int i59 = iCharAt3 & 8191;
                int i60 = i58;
                int i61 = 13;
                while (true) {
                    i6 = i60 + 1;
                    cCharAt = stringInfo.charAt(i60);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i61;
                    i61 += 13;
                    i60 = i6;
                }
                iCharAt3 = i59 | (cCharAt << i61);
                i58 = i6;
            }
            int[] iArr2 = new int[iCharAt3 + iCharAt2 + iCharAt10];
            i2 = (iCharAt6 * 2) + iCharAt7;
            i4 = iCharAt8;
            i5 = iCharAt9;
            iArr = iArr2;
            i30 = iCharAt6;
            i34 = i58;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[i5 * 3];
        int i62 = i30;
        Object[] objArr = new Object[i5 * 2];
        int i63 = iCharAt2 + iCharAt3;
        int i64 = i63;
        int i65 = iCharAt3;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt11 = stringInfo.charAt(i34);
            int i69 = length;
            if (iCharAt11 >= 55296) {
                int i70 = iCharAt11 & 8191;
                int i71 = i68;
                int i72 = 13;
                while (true) {
                    i28 = i71 + 1;
                    cCharAt12 = stringInfo.charAt(i71);
                    i14 = iCharAt4;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i70 |= (cCharAt12 & 8191) << i72;
                    i72 += 13;
                    i71 = i28;
                    iCharAt4 = i14;
                }
                iCharAt11 = i70 | (cCharAt12 << i72);
                i15 = i28;
            } else {
                i14 = iCharAt4;
                i15 = i68;
            }
            int i73 = i15 + 1;
            int iCharAt12 = stringInfo.charAt(i15);
            if (iCharAt12 >= 55296) {
                int i74 = iCharAt12 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i26 = i75 + 1;
                    cCharAt11 = stringInfo.charAt(i75);
                    i27 = i74;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i74 = i27 | ((cCharAt11 & 8191) << i76);
                    i76 += 13;
                    i75 = i26;
                }
                iCharAt12 = i27 | (cCharAt11 << i76);
                i16 = i26;
            } else {
                i16 = i73;
            }
            int[] iArr4 = iArr3;
            int i77 = iCharAt12 & 255;
            int i78 = iCharAt11;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i67] = i66;
                i67++;
            }
            int i79 = i4;
            if (i77 >= 51) {
                int i80 = i16 + 1;
                int iCharAt13 = stringInfo.charAt(i16);
                char c = 55296;
                if (iCharAt13 >= 55296) {
                    int i81 = iCharAt13 & 8191;
                    int i82 = 13;
                    while (true) {
                        i25 = i80 + 1;
                        cCharAt10 = stringInfo.charAt(i80);
                        if (cCharAt10 < c) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i82;
                        i82 += 13;
                        i80 = i25;
                        c = 55296;
                    }
                    iCharAt13 = i81 | (cCharAt10 << i82);
                    i80 = i25;
                }
                int i83 = i77 - 51;
                int i84 = iCharAt13;
                if (i83 == 9 || i83 == 17) {
                    i24 = i80;
                    objArr[AbstractC2322a.m1610D(i66, 3, 2, 1)] = objects[i2];
                    i2++;
                } else if (i83 == 12) {
                    i24 = i80;
                    if ((i14 & 1) == 1) {
                        objArr[AbstractC2322a.m1610D(i66, 3, 2, 1)] = objects[i2];
                        i2++;
                    }
                } else {
                    i24 = i80;
                }
                int i85 = i84 * 2;
                Object obj = objects[i85];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i85] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i86 = i85 + 1;
                Object obj2 = objects[i86];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i86] = fieldReflectField3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                z = z2;
                i21 = i2;
                i19 = i24;
                i17 = iCharAt;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                i22 = iObjectFieldOffset3;
                i20 = 0;
            } else {
                int i87 = i2 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i77 == 9 || i77 == 17) {
                    i17 = iCharAt;
                    z = z2;
                    objArr[AbstractC2322a.m1610D(i66, 3, 2, 1)] = fieldReflectField4.getType();
                } else {
                    if (i77 == 27 || i77 == 49) {
                        i17 = iCharAt;
                        z = z2;
                        i23 = i2 + 2;
                        objArr[AbstractC2322a.m1610D(i66, 3, 2, 1)] = objects[i87];
                    } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                        i17 = iCharAt;
                        z = z2;
                        if ((i14 & 1) == 1) {
                            i23 = i2 + 2;
                            objArr[AbstractC2322a.m1610D(i66, 3, 2, 1)] = objects[i87];
                        }
                    } else if (i77 == 50) {
                        int i88 = i65 + 1;
                        iArr[i65] = i66;
                        int i89 = (i66 / 3) * 2;
                        int i90 = i2 + 2;
                        objArr[i89] = objects[i87];
                        if ((iCharAt12 & 2048) != 0) {
                            i18 = i2 + 3;
                            objArr[i89 + 1] = objects[i90];
                            i17 = iCharAt;
                            z = z2;
                            i65 = i88;
                        } else {
                            z = z2;
                            i18 = i90;
                            i65 = i88;
                            i17 = iCharAt;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((i14 & 1) != 1 || i77 > 17) {
                            i19 = i16;
                            i20 = 0;
                            iObjectFieldOffset2 = 0;
                        } else {
                            int i91 = i16 + 1;
                            int iCharAt14 = stringInfo.charAt(i16);
                            if (iCharAt14 >= 55296) {
                                int i92 = iCharAt14 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i19 = i91 + 1;
                                    cCharAt9 = stringInfo.charAt(i91);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i92 |= (cCharAt9 & 8191) << i93;
                                    i93 += 13;
                                    i91 = i19;
                                }
                                iCharAt14 = i92 | (cCharAt9 << i93);
                            } else {
                                i19 = i91;
                            }
                            int i94 = (iCharAt14 / 32) + (i62 * 2);
                            Object obj3 = objects[i94];
                            if (obj3 instanceof java.lang.reflect.Field) {
                                fieldReflectField = (java.lang.reflect.Field) obj3;
                            } else {
                                fieldReflectField = reflectField(cls, (String) obj3);
                                objects[i94] = fieldReflectField;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                            i20 = iCharAt14 % 32;
                        }
                        if (i77 >= 18 || i77 > 49) {
                            i21 = i18;
                            i22 = iObjectFieldOffset;
                        } else {
                            iArr[i64] = iObjectFieldOffset;
                            i21 = i18;
                            i22 = iObjectFieldOffset;
                            i64++;
                        }
                    } else {
                        i17 = iCharAt;
                        z = z2;
                    }
                    i18 = i23;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((i14 & 1) != 1) {
                        i19 = i16;
                        i20 = 0;
                        iObjectFieldOffset2 = 0;
                        if (i77 >= 18) {
                            i21 = i18;
                            i22 = iObjectFieldOffset;
                        }
                    }
                }
                i18 = i87;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((i14 & 1) != 1) {
                }
            }
            int i95 = i66 + 1;
            iArr4[i66] = i78;
            int i96 = i66 + 2;
            iArr4[i95] = ((iCharAt12 & 256) != 0 ? 268435456 : 0) | ((iCharAt12 & 512) != 0 ? 536870912 : 0) | (i77 << 20) | i22;
            i66 += 3;
            iArr4[i96] = (i20 << 20) | iObjectFieldOffset2;
            i2 = i21;
            z2 = z;
            iArr3 = iArr4;
            length = i69;
            iCharAt4 = i14;
            iCharAt = i17;
            i34 = i19;
            i4 = i79;
        }
        return new MessageSchema<>(iArr3, objArr, iCharAt, i4, rawMessageInfo.getDefaultInstance(), z2, false, iArr, iCharAt3, i63, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & OFFSET_MASK;
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
        Object object;
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i9 + 2] & OFFSET_MASK;
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
                int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i9), bArr, i, i2, registers);
                object = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                if (object == null) {
                    unsafe.putObject(t, j, registers.object1);
                } else {
                    unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                }
                unsafe.putInt(t, j2, i5);
                return iDecodeMessageField;
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
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i9), bArr, i, i2, (i4 & (-8)) | 4, registers);
                    object = unsafe.getInt(t, j2) == i5 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i5);
                    return iDecodeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0053. Please report as an issue. */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe2;
        int iDecodeVarint64;
        int i7;
        int i8;
        int i9;
        MessageSchema<T> messageSchema = this;
        byte[] bArr2 = bArr;
        int i10 = i2;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe3 = UNSAFE;
        int i11 = -1;
        int iDecodeUnknownField = i;
        int i12 = -1;
        int i13 = 0;
        while (iDecodeUnknownField < i10) {
            int iDecodeVarint32 = iDecodeUnknownField + 1;
            int i14 = bArr2[iDecodeUnknownField];
            if (i14 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(i14, bArr2, iDecodeVarint32, registers2);
                i14 = registers2.int1;
            }
            int i15 = iDecodeVarint32;
            int i16 = i14;
            int i17 = (i16 == true ? 1 : 0) >>> 3;
            int i18 = (i16 == true ? 1 : 0) & 7;
            int iPositionForFieldNumber = i17 > i12 ? messageSchema.positionForFieldNumber(i17, i13 / 3) : messageSchema.positionForFieldNumber(i17);
            if (iPositionForFieldNumber == i11) {
                unsafe = unsafe3;
                i4 = i15;
                i5 = i17;
                iPositionForFieldNumber = 0;
            } else {
                int i19 = messageSchema.buffer[iPositionForFieldNumber + 1];
                int iType = type(i19);
                long jOffset = offset(i19);
                if (iType <= 17) {
                    switch (iType) {
                        case 0:
                            i6 = i16 == true ? 1 : 0;
                            if (i18 == 1) {
                                UnsafeUtil.putDouble(t, jOffset, ArrayDecoders.decodeDouble(bArr2, i15));
                                iDecodeUnknownField = i15 + 8;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 1:
                            i6 = i16 == true ? 1 : 0;
                            if (i18 == 5) {
                                UnsafeUtil.putFloat(t, jOffset, ArrayDecoders.decodeFloat(bArr2, i15));
                                iDecodeUnknownField = i15 + 4;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 2:
                        case 3:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 != 0) {
                                unsafe = unsafe2;
                                i7 = i15;
                                i8 = i17;
                                i9 = i6;
                                i4 = i7;
                                i5 = i8;
                                i16 = i9;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                unsafe3 = unsafe2;
                                unsafe3.putLong(t, jOffset, registers2.long1);
                                iDecodeUnknownField = iDecodeVarint64;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            break;
                        case 4:
                        case 11:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 5:
                        case 14:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 1) {
                                unsafe2.putLong(t, jOffset, ArrayDecoders.decodeFixed64(bArr2, i15));
                                unsafe2 = unsafe2;
                                iDecodeUnknownField = i15 + 8;
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 6:
                        case 13:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 5) {
                                unsafe2.putInt(t, jOffset, ArrayDecoders.decodeFixed32(bArr2, i15));
                                iDecodeUnknownField = i15 + 4;
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 7:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                UnsafeUtil.putBoolean(t, jOffset, registers2.long1 != 0);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 8:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = (536870912 & i19) == 0 ? ArrayDecoders.decodeString(bArr2, i15, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i15, registers2);
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 9:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeMessageField(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), bArr2, i15, i10, registers2);
                                Object object = unsafe2.getObject(t, jOffset);
                                if (object == null) {
                                    unsafe2.putObject(t, jOffset, registers2.object1);
                                } else {
                                    unsafe2.putObject(t, jOffset, Internal.mergeMessage(object, registers2.object1));
                                }
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 10:
                            i6 = i16 == true ? 1 : 0;
                            unsafe2 = unsafe3;
                            if (i18 == 2) {
                                iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i15, registers2);
                                unsafe2.putObject(t, jOffset, registers2.object1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i6;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 12:
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t, jOffset, registers2.int1);
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 15:
                            unsafe2 = unsafe3;
                            if (i18 == 0) {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i15, registers2);
                                unsafe2.putInt(t, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                unsafe3 = unsafe2;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            unsafe = unsafe2;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                        case 16:
                            if (i18 != 0) {
                                unsafe2 = unsafe3;
                                unsafe = unsafe2;
                                i7 = i15;
                                i8 = i17;
                                i9 = i16 == true ? 1 : 0;
                                i4 = i7;
                                i5 = i8;
                                i16 = i9;
                            } else {
                                iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i15, registers2);
                                unsafe3.putLong(t, jOffset, CodedInputStream.decodeZigZag64(registers2.long1));
                                unsafe3 = unsafe3;
                                iDecodeUnknownField = iDecodeVarint64;
                                i12 = i17;
                                i13 = iPositionForFieldNumber;
                            }
                            break;
                        default:
                            unsafe = unsafe3;
                            i7 = i15;
                            i8 = i17;
                            i9 = i16 == true ? 1 : 0;
                            i4 = i7;
                            i5 = i8;
                            i16 = i9;
                            break;
                    }
                } else {
                    i6 = i16 == true ? 1 : 0;
                    if (iType == 27) {
                        if (i18 == 2) {
                            Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe3.getObject(t, jOffset);
                            if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                int size = protobufListMutableCopyWithCapacity2.size();
                                protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                unsafe3.putObject(t, jOffset, protobufListMutableCopyWithCapacity2);
                            }
                            unsafe = unsafe3;
                            iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), i6 == true ? 1 : 0, bArr2, i15, i10, protobufListMutableCopyWithCapacity2, registers2);
                            bArr2 = bArr;
                            i10 = i2;
                            registers2 = registers;
                            i12 = i17;
                        }
                        unsafe = unsafe3;
                        i7 = i15;
                        i8 = i17;
                        i9 = i6;
                        i4 = i7;
                        i5 = i8;
                        i16 = i9;
                    } else {
                        unsafe = unsafe3;
                        if (iType <= 49) {
                            int repeatedField = messageSchema.parseRepeatedField(t, bArr, i15, i2, i6 == true ? 1 : 0, i17, i18, iPositionForFieldNumber, i19, iType, jOffset, registers);
                            i9 = i6 == true ? 1 : 0;
                            i8 = i17;
                            iPositionForFieldNumber = iPositionForFieldNumber;
                            if (repeatedField != i15) {
                                messageSchema = this;
                                i10 = i2;
                                registers2 = registers;
                                iDecodeUnknownField = repeatedField;
                                i12 = i8;
                                i13 = iPositionForFieldNumber;
                                unsafe3 = unsafe;
                                i11 = -1;
                                bArr2 = bArr;
                            } else {
                                i4 = repeatedField;
                                i5 = i8;
                                i16 = i9;
                            }
                        } else {
                            i8 = i17;
                            i9 = i6 == true ? 1 : 0;
                            i7 = i15;
                            if (iType == 50) {
                                if (i18 == 2) {
                                    int mapField = parseMapField(t, bArr, i7, i2, iPositionForFieldNumber, jOffset, registers);
                                    if (mapField != i7) {
                                        messageSchema = this;
                                        bArr2 = bArr;
                                        i10 = i2;
                                        registers2 = registers;
                                        iDecodeUnknownField = mapField;
                                        i12 = i8;
                                    } else {
                                        i4 = mapField;
                                    }
                                } else {
                                    i4 = i7;
                                }
                                i5 = i8;
                                i16 = i9;
                            } else {
                                i5 = i8;
                                i16 = i9 == true ? 1 : 0;
                                int oneofField = parseOneofField(t, bArr, i7, i2, i16 == true ? 1 : 0, i5, i18, i19, iType, jOffset, iPositionForFieldNumber, registers);
                                if (oneofField != i7) {
                                    messageSchema = this;
                                    i10 = i2;
                                    registers2 = registers;
                                    i12 = i5;
                                    iDecodeUnknownField = oneofField;
                                    i13 = iPositionForFieldNumber;
                                    unsafe3 = unsafe;
                                    i11 = -1;
                                    bArr2 = bArr;
                                } else {
                                    i4 = oneofField;
                                }
                            }
                        }
                    }
                    i13 = iPositionForFieldNumber;
                    unsafe3 = unsafe;
                }
                i11 = -1;
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i16 == true ? 1 : 0, bArr, i4, i2, getMutableUnknownFields(t), registers);
            messageSchema = this;
            bArr2 = bArr;
            registers2 = registers;
            i10 = i2;
            i12 = i5;
            i13 = iPositionForFieldNumber;
            unsafe3 = unsafe;
            i11 = -1;
        }
        if (iDecodeUnknownField == i10) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
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
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i5, (List<Integer>) protobufList, getEnumFieldVerifier(i7), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
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
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t, j, UnsafeUtil.getInt(t, j) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & OFFSET_MASK, i);
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, boolean z, Object[] objArr) {
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int iM2159id;
        int iNumberOfTrailingZeros;
        int i2;
        int i4;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            int iM2159id2 = type.m2159id();
            if (!z && !type.isList() && !type.isMap()) {
                int iObjectFieldOffset3 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getPresenceField());
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
                iM2159id = iM2159id2;
                i2 = iObjectFieldOffset;
                i4 = iObjectFieldOffset3;
            } else if (fieldInfo.getCachedSizeField() == null) {
                iNumberOfTrailingZeros = 0;
                iM2159id = iM2159id2;
                i2 = iObjectFieldOffset;
                i4 = 0;
            } else {
                iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
                iM2159id = iM2159id2;
            }
            iArr[i] = fieldInfo.getFieldNumber();
            iArr[i + 1] = (iM2159id << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | i2;
            iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i4;
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
            int i5 = (i / 3) * 2;
            objArr[i5] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i5 + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[i5 + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        iM2159id = fieldInfo.getType().m2159id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        iObjectFieldOffset2 = (int) UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        i2 = iObjectFieldOffset;
        i4 = iObjectFieldOffset2;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (!fieldInfo.isEnforceUtf8()) {
        }
        iArr[i + 1] = (iM2159id << 20) | (fieldInfo.isRequired() ? 268435456 : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | i2;
        iArr[i + 2] = (iNumberOfTrailingZeros << 20) | i4;
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, Writer writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        boolean z;
        int i;
        boolean z2;
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
        int i2 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iType = type(iTypeAndOffsetAt);
            if (this.proto3 || iType > 17) {
                z = true;
                entry = entry;
                i = 0;
            } else {
                int i6 = this.buffer[i4 + 2];
                int i7 = i6 & OFFSET_MASK;
                Map.Entry<?, ?> entry2 = entry;
                z = true;
                if (i7 != i2) {
                    i5 = unsafe.getInt(t, i7);
                    i2 = i7;
                }
                i = 1 << (i6 >>> 20);
                entry = entry2;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            Iterator it2 = it;
            int i8 = i;
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i5 & i8) != 0) {
                        writer.writeDouble(iNumberAt, doubleAt(t, jOffset));
                    }
                    break;
                case 1:
                    if ((i5 & i8) != 0) {
                        writer.writeFloat(iNumberAt, floatAt(t, jOffset));
                    }
                    break;
                case 2:
                    if ((i5 & i8) != 0) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 3:
                    if ((i5 & i8) != 0) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 4:
                    if ((i5 & i8) != 0) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 5:
                    if ((i5 & i8) != 0) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 6:
                    if ((i5 & i8) != 0) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 7:
                    if ((i5 & i8) != 0) {
                        writer.writeBool(iNumberAt, booleanAt(t, jOffset));
                    }
                    break;
                case 8:
                    if ((i5 & i8) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 9:
                    if ((i5 & i8) != 0) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
                case 10:
                    if ((i5 & i8) != 0) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 11:
                    if ((i5 & i8) != 0) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 12:
                    if ((i5 & i8) != 0) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 13:
                    if ((i5 & i8) != 0) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 14:
                    if ((i5 & i8) != 0) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 15:
                    if ((i5 & i8) != 0) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t, jOffset));
                    }
                    break;
                case 16:
                    if ((i5 & i8) != 0) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t, jOffset));
                    }
                    break;
                case 17:
                    if ((i5 & i8) != 0) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i4));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer);
                    break;
                case 29:
                    z2 = false;
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 30:
                    z2 = false;
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 31:
                    z2 = false;
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 32:
                    z2 = false;
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 33:
                    z2 = false;
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 34:
                    z2 = false;
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, z);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i4), (List) unsafe.getObject(t, jOffset), writer, getMessageFieldSchema(i4));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, unsafe.getObject(t, jOffset), i4);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t, jOffset));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t, jOffset));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t, jOffset));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writeString(iNumberAt, unsafe.getObject(t, jOffset), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t, jOffset));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t, jOffset));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i4));
                    }
                    break;
            }
            i4 += 3;
            it = it2;
        }
        Iterator it3 = it;
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
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

    @Override // androidx.datastore.preferences.protobuf.Schema
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

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isInitialized(T t) {
        int i;
        int i2 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.checkInitializedCount; i5++) {
            int i6 = this.intArray[i5];
            int iNumberAt = numberAt(i6);
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            if (this.proto3) {
                i = 0;
            } else {
                int i7 = this.buffer[i6 + 2];
                int i8 = OFFSET_MASK & i7;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = UNSAFE.getInt(t, i8);
                    i2 = i8;
                }
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i6, i4, i)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t, i6, i4, i) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t, iNumberAt, i6) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            }
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t) {
        int i;
        int i2 = this.checkInitializedCount;
        while (true) {
            i = this.repeatedFieldOffsetStart;
            if (i2 >= i) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (i < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[i]);
            i++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        t2.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        if (this.proto3) {
            return;
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0090. Please report as an issue. */
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i4, ArrayDecoders.Registers registers) {
        T t2;
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        int i5;
        int i6;
        int i7;
        ArrayDecoders.Registers registers2;
        int i8;
        int i9;
        T t5;
        int iDecodeUnknownField;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        T t6;
        Unsafe unsafe2;
        byte[] bArr2;
        int i18;
        Unsafe unsafe3;
        byte[] bArr3;
        int iDecodeVarint32;
        int i19;
        int i20;
        byte[] bArr4;
        int iDecodeMessageField;
        MessageSchema<T> messageSchema2 = this;
        T t7 = t;
        byte[] bArr5 = bArr;
        int i21 = i2;
        ArrayDecoders.Registers registers3 = registers;
        Unsafe unsafe4 = UNSAFE;
        int i22 = -1;
        int i23 = i;
        int i24 = -1;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            if (i23 < i21) {
                int iDecodeVarint322 = i23 + 1;
                int i29 = bArr5[i23];
                if (i29 < 0) {
                    iDecodeVarint322 = ArrayDecoders.decodeVarint32(i29, bArr5, iDecodeVarint322, registers3);
                    i29 = registers3.int1;
                }
                int i30 = iDecodeVarint322;
                i28 = i29;
                int i31 = (i28 == true ? 1 : 0) >>> 3;
                int i32 = (i28 == true ? 1 : 0) & 7;
                int iPositionForFieldNumber = i31 > i24 ? messageSchema2.positionForFieldNumber(i31, i26 / 3) : messageSchema2.positionForFieldNumber(i31);
                if (iPositionForFieldNumber == i22) {
                    i5 = i30;
                    unsafe = unsafe4;
                    i6 = i25;
                    i7 = i31;
                    registers2 = registers;
                    messageSchema = messageSchema2;
                    i8 = i28 == true ? 1 : 0;
                    i9 = 0;
                } else {
                    int i33 = messageSchema2.buffer[iPositionForFieldNumber + 1];
                    int iType = type(i33);
                    int i34 = i25;
                    long jOffset = offset(i33);
                    if (iType <= 17) {
                        int i35 = messageSchema2.buffer[iPositionForFieldNumber + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & OFFSET_MASK;
                        i7 = i31;
                        if (i37 != i34) {
                            i13 = iType;
                            if (i34 != -1) {
                                unsafe4.putInt(t7, i34, i27);
                            }
                            i15 = i37;
                            i14 = unsafe4.getInt(t7, i37);
                        } else {
                            i13 = iType;
                            i14 = i27;
                            i15 = i34;
                        }
                        switch (i13) {
                            case 0:
                                i16 = iPositionForFieldNumber;
                                i17 = i30;
                                registers2 = registers;
                                t6 = t7;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i32 == 1) {
                                    UnsafeUtil.putDouble(t6, jOffset, ArrayDecoders.decodeDouble(bArr2, i17));
                                    i23 = i17 + 8;
                                    i18 = i14 | i36;
                                    i21 = i2;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t7 = t6;
                                    i22 = -1;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 1:
                                i16 = iPositionForFieldNumber;
                                i17 = i30;
                                registers2 = registers;
                                t6 = t7;
                                unsafe2 = unsafe4;
                                bArr2 = bArr;
                                if (i32 == 5) {
                                    UnsafeUtil.putFloat(t6, jOffset, ArrayDecoders.decodeFloat(bArr2, i17));
                                    i23 = i17 + 4;
                                    i18 = i14 | i36;
                                    i21 = i2;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t7 = t6;
                                    i22 = -1;
                                } else {
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 2:
                            case 3:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i17 = i30;
                                bArr2 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i17, registers2);
                                    T t8 = t7;
                                    unsafe2 = unsafe3;
                                    unsafe2.putLong(t8, jOffset, registers2.long1);
                                    t6 = t8;
                                    i18 = i14 | i36;
                                    i21 = i2;
                                    i23 = iDecodeVarint64;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i18;
                                    bArr5 = bArr2;
                                    unsafe4 = unsafe2;
                                    t7 = t6;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 4:
                            case 11:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i17 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr3, i17, registers2);
                                    unsafe3.putInt(t7, jOffset, registers2.int1);
                                    Unsafe unsafe5 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i2;
                                } else {
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 5:
                            case 14:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 1) {
                                    T t9 = t7;
                                    unsafe3.putLong(t9, jOffset, ArrayDecoders.decodeFixed64(bArr3, i30));
                                    unsafe3 = unsafe3;
                                    t7 = t9;
                                    iDecodeVarint32 = i30 + 8;
                                    Unsafe unsafe52 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i2;
                                } else {
                                    i17 = i30;
                                    unsafe2 = unsafe3;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 6:
                            case 13:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 5) {
                                    unsafe3.putInt(t7, jOffset, ArrayDecoders.decodeFixed32(bArr3, i19));
                                    iDecodeVarint32 = i19 + 4;
                                    Unsafe unsafe522 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe522;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i2;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 7:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 0) {
                                    iDecodeVarint32 = ArrayDecoders.decodeVarint64(bArr3, i19, registers2);
                                    UnsafeUtil.putBoolean(t7, jOffset, registers2.long1 != 0);
                                    Unsafe unsafe5222 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe5222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i2;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 8:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr3 = bArr;
                                registers2 = registers;
                                if (i32 == 2) {
                                    iDecodeVarint32 = (i33 & 536870912) == 0 ? ArrayDecoders.decodeString(bArr3, i19, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr3, i19, registers2);
                                    unsafe3.putObject(t7, jOffset, registers2.object1);
                                    Unsafe unsafe52222 = unsafe3;
                                    i23 = iDecodeVarint32;
                                    bArr5 = bArr3;
                                    unsafe4 = unsafe52222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                    i27 = i14 | i36;
                                    i21 = i2;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 9:
                                i20 = i21;
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                if (i32 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(i16), bArr4, i19, i20, registers2);
                                    if ((i14 & i36) == 0) {
                                        unsafe3.putObject(t7, jOffset, registers2.object1);
                                    } else {
                                        unsafe3.putObject(t7, jOffset, Internal.mergeMessage(unsafe3.getObject(t7, jOffset), registers2.object1));
                                    }
                                    Unsafe unsafe6 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 10:
                                i20 = i21;
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                if (i32 == 2) {
                                    iDecodeMessageField = ArrayDecoders.decodeBytes(bArr4, i19, registers2);
                                    unsafe3.putObject(t7, jOffset, registers2.object1);
                                    Unsafe unsafe62 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe62;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 12:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                registers2 = registers;
                                i20 = i21;
                                if (i32 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i19, registers2);
                                    int i38 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i16);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i38)) {
                                        unsafe3.putInt(t7, jOffset, i38);
                                        Unsafe unsafe622 = unsafe3;
                                        i23 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe622;
                                        registers3 = registers2;
                                        i25 = i15;
                                        i26 = i16;
                                        i24 = i7;
                                        i27 = i14 | i36;
                                        i21 = i20;
                                        i22 = -1;
                                    } else {
                                        getMutableUnknownFields(t7).storeField(i28 == true ? 1 : 0, Long.valueOf(i38));
                                        i23 = iDecodeMessageField;
                                        bArr5 = bArr4;
                                        unsafe4 = unsafe3;
                                        i21 = i20;
                                        registers3 = registers2;
                                        i25 = i15;
                                        i27 = i14;
                                        i26 = i16;
                                        i24 = i7;
                                        i22 = -1;
                                    }
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 15:
                                i16 = iPositionForFieldNumber;
                                unsafe3 = unsafe4;
                                i19 = i30;
                                bArr4 = bArr;
                                registers2 = registers;
                                i20 = i21;
                                if (i32 == 0) {
                                    iDecodeMessageField = ArrayDecoders.decodeVarint32(bArr4, i19, registers2);
                                    unsafe3.putInt(t7, jOffset, CodedInputStream.decodeZigZag32(registers2.int1));
                                    Unsafe unsafe6222 = unsafe3;
                                    i23 = iDecodeMessageField;
                                    bArr5 = bArr4;
                                    unsafe4 = unsafe6222;
                                    registers3 = registers2;
                                    i25 = i15;
                                    i26 = i16;
                                    i24 = i7;
                                    i27 = i14 | i36;
                                    i21 = i20;
                                    i22 = -1;
                                } else {
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 16:
                                i16 = iPositionForFieldNumber;
                                i19 = i30;
                                if (i32 == 0) {
                                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i19, registers);
                                    T t10 = t7;
                                    Unsafe unsafe7 = unsafe4;
                                    unsafe7.putLong(t10, jOffset, CodedInputStream.decodeZigZag64(registers.long1));
                                    t7 = t10;
                                    int i39 = i15;
                                    i27 = i14 | i36;
                                    bArr5 = bArr;
                                    unsafe4 = unsafe7;
                                    i23 = iDecodeVarint642;
                                    registers3 = registers;
                                    i25 = i39;
                                    i21 = i2;
                                    i26 = i16;
                                    i24 = i7;
                                    i22 = -1;
                                } else {
                                    unsafe3 = unsafe4;
                                    registers2 = registers;
                                    unsafe2 = unsafe3;
                                    i17 = i19;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            case 17:
                                if (i32 == 3) {
                                    int i40 = iPositionForFieldNumber;
                                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i30, i21, (i7 << 3) | 4, registers);
                                    if ((i14 & i36) == 0) {
                                        unsafe4.putObject(t7, jOffset, registers.object1);
                                    } else {
                                        unsafe4.putObject(t7, jOffset, Internal.mergeMessage(unsafe4.getObject(t7, jOffset), registers.object1));
                                    }
                                    i23 = iDecodeGroupField;
                                    bArr5 = bArr;
                                    registers3 = registers;
                                    i25 = i15;
                                    i26 = i40;
                                    i22 = -1;
                                    i21 = i2;
                                    i27 = i14 | i36;
                                    i24 = i7;
                                } else {
                                    i16 = iPositionForFieldNumber;
                                    registers2 = registers;
                                    unsafe2 = unsafe4;
                                    i17 = i30;
                                    messageSchema = messageSchema2;
                                    unsafe = unsafe2;
                                    i5 = i17;
                                    i6 = i15;
                                    i8 = i28 == true ? 1 : 0;
                                    i27 = i14;
                                    i9 = i16;
                                }
                                break;
                            default:
                                registers2 = registers;
                                i16 = iPositionForFieldNumber;
                                unsafe2 = unsafe4;
                                i17 = i30;
                                messageSchema = messageSchema2;
                                unsafe = unsafe2;
                                i5 = i17;
                                i6 = i15;
                                i8 = i28 == true ? 1 : 0;
                                i27 = i14;
                                i9 = i16;
                                break;
                        }
                    } else {
                        int i41 = iPositionForFieldNumber;
                        i7 = i31;
                        T t11 = t7;
                        Unsafe unsafe8 = unsafe4;
                        i6 = i34;
                        if (iType == 27) {
                            if (i32 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe8.getObject(t11, jOffset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe8.putObject(t11, jOffset, protobufListMutableCopyWithCapacity2);
                                }
                                unsafe4 = unsafe8;
                                int iDecodeMessageList = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(i41), i28 == true ? 1 : 0, bArr, i30, i2, protobufListMutableCopyWithCapacity2, registers);
                                bArr5 = bArr;
                                i21 = i2;
                                registers3 = registers;
                                i23 = iDecodeMessageList;
                                t7 = t11;
                                i26 = i41;
                                i24 = i7;
                                i25 = i6;
                                i22 = -1;
                            } else {
                                unsafe = unsafe8;
                                i12 = i30;
                                i10 = i27;
                                i11 = i28 == true ? 1 : 0;
                                i9 = i41;
                                messageSchema = this;
                                registers2 = registers;
                                i5 = i12;
                                i8 = i11;
                            }
                        } else if (iType <= 49) {
                            unsafe = unsafe8;
                            i10 = i27;
                            int repeatedField = messageSchema2.parseRepeatedField(t, bArr, i30, i2, i28 == true ? 1 : 0, i7, i32, i41, i33, iType, jOffset, registers);
                            i11 = i28 == true ? 1 : 0;
                            i9 = i41;
                            if (repeatedField != i30) {
                                messageSchema2 = this;
                                t7 = t;
                                bArr5 = bArr;
                                i21 = i2;
                                i23 = repeatedField;
                                i26 = i9;
                                i27 = i10;
                                i24 = i7;
                                i25 = i6;
                                unsafe4 = unsafe;
                                registers3 = registers;
                                i28 = i11;
                                i22 = -1;
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i5 = repeatedField;
                                i8 = i11;
                            }
                        } else {
                            unsafe = unsafe8;
                            i10 = i27;
                            i11 = i28 == true ? 1 : 0;
                            i9 = i41;
                            i12 = i30;
                            if (iType != 50) {
                                int oneofField = parseOneofField(t, bArr, i12, i2, i11 == true ? 1 : 0, i7, i32, i33, iType, jOffset, i9, registers);
                                messageSchema = this;
                                i8 = i11 == true ? 1 : 0;
                                registers2 = registers;
                                if (oneofField != i12) {
                                    t7 = t;
                                    bArr5 = bArr;
                                    i21 = i2;
                                    i23 = oneofField;
                                    registers3 = registers2;
                                    i26 = i9;
                                    i27 = i10;
                                    i24 = i7;
                                    i25 = i6;
                                    i22 = -1;
                                    i28 = i8;
                                    messageSchema2 = messageSchema;
                                    unsafe4 = unsafe;
                                } else {
                                    i5 = oneofField;
                                }
                            } else if (i32 == 2) {
                                int mapField = parseMapField(t, bArr, i12, i2, i9, jOffset, registers);
                                if (mapField != i12) {
                                    messageSchema2 = this;
                                    t7 = t;
                                    bArr5 = bArr;
                                    i21 = i2;
                                    registers3 = registers;
                                    i23 = mapField;
                                    i26 = i9;
                                    i27 = i10;
                                    i24 = i7;
                                    i25 = i6;
                                    unsafe4 = unsafe;
                                    i28 = i11;
                                    i22 = -1;
                                } else {
                                    messageSchema = this;
                                    registers2 = registers;
                                    i5 = mapField;
                                    i8 = i11;
                                }
                            } else {
                                messageSchema = this;
                                registers2 = registers;
                                i5 = i12;
                                i8 = i11;
                            }
                        }
                        i27 = i10;
                    }
                }
                if (i8 != i4 || i4 == 0) {
                    if (!messageSchema.hasExtensions || registers2.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) {
                        t5 = t;
                        iDecodeUnknownField = ArrayDecoders.decodeUnknownField(i8 == true ? 1 : 0, bArr, i5, i2, getMutableUnknownFields(t5), registers);
                        i21 = i2;
                    } else {
                        iDecodeUnknownField = ArrayDecoders.decodeExtensionOrUnknownField(i8 == true ? 1 : 0, bArr, i5, i2, t, messageSchema.defaultInstance, messageSchema.unknownFieldSchema, registers2);
                        t5 = t;
                        i21 = i2;
                    }
                    i23 = iDecodeUnknownField;
                    bArr5 = bArr;
                    registers3 = registers;
                    t7 = t5;
                    i26 = i9;
                    i24 = i7;
                    i25 = i6;
                    i22 = -1;
                    i28 = i8;
                    messageSchema2 = messageSchema;
                    unsafe4 = unsafe;
                } else {
                    t2 = t;
                    i21 = i2;
                    i28 = i8 == true ? 1 : 0;
                    i23 = i5;
                    i25 = i6;
                }
            } else {
                t2 = t7;
                unsafe = unsafe4;
                messageSchema = messageSchema2;
            }
        }
        if (i25 != -1) {
            unsafe.putInt(t2, i25, i27);
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i42 = messageSchema.checkInitializedCount; i42 < messageSchema.repeatedFieldOffsetStart; i42++) {
            unknownFieldSetLite = (UnknownFieldSetLite) messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[i42], unknownFieldSetLite, messageSchema.unknownFieldSchema);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i23 != i21) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i23 > i21 || i28 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i23;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
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
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, jOffset) != 0.0f;
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
                    } else if (object instanceof ByteString) {
                        zEquals = ByteString.EMPTY.equals(object);
                    } else {
                        throw new IllegalArgumentException();
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
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        return (UnsafeUtil.getInt(t, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
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

    @Override // androidx.datastore.preferences.protobuf.Schema
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
