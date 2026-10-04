package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableData implements Parcelable {
    public static final Parcelable.Creator<ParcelableData> CREATOR = new Parcelable.Creator<ParcelableData>() { // from class: androidx.work.multiprocess.parcelable.ParcelableData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableData createFromParcel(@NonNull Parcel parcel) {
            return new ParcelableData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableData[] newArray(int i) {
            return new ParcelableData[i];
        }
    };
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    private final Data mData;

    public ParcelableData(@NonNull Data data) {
        this.mData = data;
    }

    private void addEntry(@NonNull Parcel parcel, @NonNull Map<String, Object> map) {
        Object objValueOf;
        byte b = parcel.readByte();
        switch (b) {
            case 0:
                objValueOf = null;
                break;
            case 1:
                objValueOf = Boolean.valueOf(ParcelUtils.readBooleanValue(parcel));
                break;
            case 2:
                objValueOf = Byte.valueOf(parcel.readByte());
                break;
            case 3:
                objValueOf = Integer.valueOf(parcel.readInt());
                break;
            case 4:
                objValueOf = Long.valueOf(parcel.readLong());
                break;
            case 5:
                objValueOf = Float.valueOf(parcel.readFloat());
                break;
            case 6:
                objValueOf = Double.valueOf(parcel.readDouble());
                break;
            case 7:
                objValueOf = parcel.readString();
                break;
            case 8:
                objValueOf = Data.convertPrimitiveBooleanArray(parcel.createBooleanArray());
                break;
            case 9:
                objValueOf = Data.convertPrimitiveByteArray(parcel.createByteArray());
                break;
            case 10:
                objValueOf = Data.convertPrimitiveIntArray(parcel.createIntArray());
                break;
            case 11:
                objValueOf = Data.convertPrimitiveLongArray(parcel.createLongArray());
                break;
            case 12:
                objValueOf = Data.convertPrimitiveFloatArray(parcel.createFloatArray());
                break;
            case 13:
                objValueOf = Data.convertPrimitiveDoubleArray(parcel.createDoubleArray());
                break;
            case 14:
                objValueOf = parcel.createStringArray();
                break;
            default:
                throw new IllegalStateException(AbstractC0000a.m11h(b, "Unsupported type "));
        }
        map.put(parcel.readString(), objValueOf);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public Data getData() {
        return this.mData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        Map<String, Object> keyValueMap = this.mData.getKeyValueMap();
        parcel.writeInt(keyValueMap.size());
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
            writeToParcel(parcel, entry.getKey(), entry.getValue());
        }
    }

    public ParcelableData(@NonNull Parcel parcel) {
        HashMap map = new HashMap();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            addEntry(parcel, map);
        }
        this.mData = new Data(map);
    }

    private void writeToParcel(@NonNull Parcel parcel, @NonNull String str, @Nullable Object obj) {
        if (obj == null) {
            parcel.writeByte((byte) 0);
        } else {
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class) {
                parcel.writeByte((byte) 1);
                ParcelUtils.writeBooleanValue(parcel, ((Boolean) obj).booleanValue());
            } else if (cls == Byte.class) {
                parcel.writeByte((byte) 2);
                parcel.writeByte(((Byte) obj).byteValue());
            } else if (cls == Integer.class) {
                parcel.writeByte((byte) 3);
                parcel.writeInt(((Integer) obj).intValue());
            } else if (cls == Long.class) {
                parcel.writeByte((byte) 4);
                parcel.writeLong(((Long) obj).longValue());
            } else if (cls == Float.class) {
                parcel.writeByte((byte) 5);
                parcel.writeFloat(((Float) obj).floatValue());
            } else if (cls == Double.class) {
                parcel.writeByte((byte) 6);
                parcel.writeDouble(((Double) obj).doubleValue());
            } else if (cls == String.class) {
                parcel.writeByte((byte) 7);
                parcel.writeString((String) obj);
            } else if (cls == Boolean[].class) {
                parcel.writeByte((byte) 8);
                parcel.writeBooleanArray(Data.convertToPrimitiveArray((Boolean[]) obj));
            } else if (cls == Byte[].class) {
                parcel.writeByte((byte) 9);
                parcel.writeByteArray(Data.convertToPrimitiveArray((Byte[]) obj));
            } else if (cls == Integer[].class) {
                parcel.writeByte((byte) 10);
                parcel.writeIntArray(Data.convertToPrimitiveArray((Integer[]) obj));
            } else if (cls == Long[].class) {
                parcel.writeByte((byte) 11);
                parcel.writeLongArray(Data.convertToPrimitiveArray((Long[]) obj));
            } else if (cls == Float[].class) {
                parcel.writeByte((byte) 12);
                parcel.writeFloatArray(Data.convertToPrimitiveArray((Float[]) obj));
            } else if (cls == Double[].class) {
                parcel.writeByte((byte) 13);
                parcel.writeDoubleArray(Data.convertToPrimitiveArray((Double[]) obj));
            } else if (cls == String[].class) {
                parcel.writeByte((byte) 14);
                parcel.writeStringArray((String[]) obj);
            } else {
                throw new IllegalArgumentException("Unsupported value type ".concat(cls.getName()));
            }
        }
        parcel.writeString(str);
    }
}
