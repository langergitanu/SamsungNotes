package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p103Z1.AbstractC0351a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0007H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003J]\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0007HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00068"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/ImageTensor;", "Landroid/os/Parcelable;", "tensorName", "", "tensorData", "Landroid/os/SharedMemory;", "batch", "", "height", "width", NetworkConfig.CLIENTS_CHANNEL, "dataType", "Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;", "byteData", "", "<init>", "(Ljava/lang/String;Landroid/os/SharedMemory;IIIILcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;[B)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTensorName", "()Ljava/lang/String;", "getTensorData", "()Landroid/os/SharedMemory;", "getBatch", "()I", "setBatch", "(I)V", "getHeight", "getWidth", "getChannel", "getDataType", "()Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;", "getByteData", "()[B", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageTensor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageTensor.kt\ncom/samsung/android/core/ai/sdkcommon/ImageTensor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
public final /* data */ class ImageTensor implements Parcelable {
    private static final int FLAG_INLINE_DATA = 0;
    private static final int FLAG_NO_DATA = -1;
    private static final int FLAG_SHARED_MEM = 1;
    private static final int MAX_INLINE_BYTE_SIZE = 8192;

    @NotNull
    private static final String TAG = "ImageTensor";
    private int batch;

    @Nullable
    private final byte[] byteData;
    private final int channel;

    @NotNull
    private final TensorPrecisionType dataType;
    private final int height;

    @Nullable
    private final SharedMemory tensorData;

    @NotNull
    private final String tensorName;
    private final int width;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ImageTensor> CREATOR = new Parcelable.Creator<ImageTensor>() { // from class: com.samsung.android.core.ai.sdkcommon.ImageTensor$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageTensor createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ImageTensor(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageTensor[] newArray(int size) {
            return new ImageTensor[size];
        }
    };

    public /* synthetic */ ImageTensor(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static /* synthetic */ ImageTensor copy$default(ImageTensor imageTensor, String str, SharedMemory sharedMemory, int i, int i2, int i4, int i5, TensorPrecisionType tensorPrecisionType, byte[] bArr, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = imageTensor.tensorName;
        }
        if ((i6 & 2) != 0) {
            sharedMemory = imageTensor.tensorData;
        }
        if ((i6 & 4) != 0) {
            i = imageTensor.batch;
        }
        if ((i6 & 8) != 0) {
            i2 = imageTensor.height;
        }
        if ((i6 & 16) != 0) {
            i4 = imageTensor.width;
        }
        if ((i6 & 32) != 0) {
            i5 = imageTensor.channel;
        }
        if ((i6 & 64) != 0) {
            tensorPrecisionType = imageTensor.dataType;
        }
        if ((i6 & 128) != 0) {
            bArr = imageTensor.byteData;
        }
        TensorPrecisionType tensorPrecisionType2 = tensorPrecisionType;
        byte[] bArr2 = bArr;
        int i7 = i4;
        int i8 = i5;
        return imageTensor.copy(str, sharedMemory, i, i2, i7, i8, tensorPrecisionType2, bArr2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTensorName() {
        return this.tensorName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SharedMemory getTensorData() {
        return this.tensorData;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBatch() {
        return this.batch;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getChannel() {
        return this.channel;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final TensorPrecisionType getDataType() {
        return this.dataType;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final byte[] getByteData() {
        return this.byteData;
    }

    @NotNull
    public final ImageTensor copy(@NotNull String tensorName, @Nullable SharedMemory tensorData, int batch, int height, int width, int channel, @NotNull TensorPrecisionType dataType, @Nullable byte[] byteData) {
        Intrinsics.checkNotNullParameter(tensorName, "tensorName");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        return new ImageTensor(tensorName, tensorData, batch, height, width, channel, dataType, byteData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageTensor)) {
            return false;
        }
        ImageTensor imageTensor = (ImageTensor) other;
        return Intrinsics.areEqual(this.tensorName, imageTensor.tensorName) && Intrinsics.areEqual(this.tensorData, imageTensor.tensorData) && this.batch == imageTensor.batch && this.height == imageTensor.height && this.width == imageTensor.width && this.channel == imageTensor.channel && this.dataType == imageTensor.dataType && Intrinsics.areEqual(this.byteData, imageTensor.byteData);
    }

    public final int getBatch() {
        return this.batch;
    }

    @Nullable
    public final byte[] getByteData() {
        return this.byteData;
    }

    public final int getChannel() {
        return this.channel;
    }

    @NotNull
    public final TensorPrecisionType getDataType() {
        return this.dataType;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final SharedMemory getTensorData() {
        return this.tensorData;
    }

    @NotNull
    public final String getTensorName() {
        return this.tensorName;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iHashCode = this.tensorName.hashCode() * 31;
        SharedMemory sharedMemory = this.tensorData;
        int iHashCode2 = (this.dataType.hashCode() + AbstractC0622a.m1157c(this.channel, AbstractC0622a.m1157c(this.width, AbstractC0622a.m1157c(this.height, AbstractC0622a.m1157c(this.batch, (iHashCode + (sharedMemory == null ? 0 : sharedMemory.hashCode())) * 31, 31), 31), 31), 31)) * 31;
        byte[] bArr = this.byteData;
        return iHashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public final void setBatch(int i) {
        this.batch = i;
    }

    @NotNull
    public String toString() {
        String str = this.tensorName;
        SharedMemory sharedMemory = this.tensorData;
        int i = this.batch;
        int i2 = this.height;
        int i4 = this.width;
        int i5 = this.channel;
        TensorPrecisionType tensorPrecisionType = this.dataType;
        String string = Arrays.toString(this.byteData);
        StringBuilder sb = new StringBuilder("ImageTensor(tensorName=");
        sb.append(str);
        sb.append(", tensorData=");
        sb.append(sharedMemory);
        sb.append(", batch=");
        AbstractC2821a.m2235z(sb, i, i2, ", height=", ", width=");
        AbstractC2821a.m2235z(sb, i4, i5, ", channel=", ", dataType=");
        sb.append(tensorPrecisionType);
        sb.append(", byteData=");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.tensorName);
        dest.writeParcelable(this.tensorData, flags);
        dest.writeInt(this.batch);
        dest.writeInt(this.height);
        dest.writeInt(this.width);
        dest.writeInt(this.channel);
        dest.writeInt(this.dataType.ordinal());
        byte[] bArr = this.byteData;
        if (bArr == null) {
            dest.writeInt(-1);
            return;
        }
        if (bArr.length <= 8192) {
            dest.writeInt(0);
            dest.writeByteArray(bArr);
            return;
        }
        dest.writeInt(1);
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("ImageTensor", bArr.length);
            Intrinsics.checkNotNullExpressionValue(sharedMemoryCreate, "create(...)");
            ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            Intrinsics.checkNotNullExpressionValue(byteBufferMapReadWrite, "mapReadWrite(...)");
            byteBufferMapReadWrite.put(bArr);
            SharedMemory.unmap(byteBufferMapReadWrite);
            dest.writeParcelable(sharedMemoryCreate, flags);
            sharedMemoryCreate.close();
        } catch (Exception e) {
            Log.e(TAG, "Failed to write SharedMemory", e);
            dest.writeParcelable(null, flags);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageTensor(@NotNull String tensorName, @Nullable SharedMemory sharedMemory, int i, int i2, int i4, int i5, @NotNull TensorPrecisionType dataType) {
        this(tensorName, sharedMemory, i, i2, i4, i5, dataType, null, 128, null);
        Intrinsics.checkNotNullParameter(tensorName, "tensorName");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
    }

    @JvmOverloads
    public ImageTensor(@NotNull String tensorName, @Nullable SharedMemory sharedMemory, int i, int i2, int i4, int i5, @NotNull TensorPrecisionType dataType, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(tensorName, "tensorName");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        this.tensorName = tensorName;
        this.tensorData = sharedMemory;
        this.batch = i;
        this.height = i2;
        this.width = i4;
        this.channel = i5;
        this.dataType = dataType;
        this.byteData = bArr;
    }

    public /* synthetic */ ImageTensor(String str, SharedMemory sharedMemory, int i, int i2, int i4, int i5, TensorPrecisionType tensorPrecisionType, byte[] bArr, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, sharedMemory, i, i2, i4, i5, tensorPrecisionType, (i6 & 128) != 0 ? null : bArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ImageTensor(Parcel parcel) {
        String string = parcel.readString();
        String str = string == null ? "" : string;
        SharedMemory sharedMemoryM679g = AbstractC0351a.m679g(parcel.readParcelable(AbstractC0351a.m681i().getClassLoader(), AbstractC0351a.m681i()));
        int i = parcel.readInt();
        int i2 = parcel.readInt();
        int i4 = parcel.readInt();
        int i5 = parcel.readInt();
        int i6 = parcel.readInt();
        EnumEntries<TensorPrecisionType> entries = TensorPrecisionType.getEntries();
        TensorPrecisionType tensorPrecisionType = (i6 < 0 || i6 >= entries.size()) ? TensorPrecisionType.FP32 : entries.get(i6);
        int i7 = parcel.readInt();
        byte[] bArrCreateByteArray = null;
        if (i7 != -1) {
            if (i7 == 0) {
                bArrCreateByteArray = parcel.createByteArray();
            } else if (i7 == 1) {
                SharedMemory sharedMemoryM679g2 = AbstractC0351a.m679g(parcel.readParcelable(AbstractC0351a.m681i().getClassLoader(), AbstractC0351a.m681i()));
                if (sharedMemoryM679g2 != null) {
                    try {
                        Log.e(TAG, "Failed to read SharedMemory");
                        ByteBuffer byteBufferMapReadOnly = sharedMemoryM679g2.mapReadOnly();
                        Intrinsics.checkNotNullExpressionValue(byteBufferMapReadOnly, "mapReadOnly(...)");
                        byte[] bArr = new byte[sharedMemoryM679g2.getSize()];
                        byteBufferMapReadOnly.get(bArr);
                        SharedMemory.unmap(byteBufferMapReadOnly);
                        sharedMemoryM679g2.close();
                        bArrCreateByteArray = bArr;
                    } catch (Exception e) {
                        Log.e(TAG, "Failed to read SharedMemory", e);
                    }
                }
            } else {
                Log.w(TAG, "Unknown byteData flag: " + i7);
            }
        }
        this(str, sharedMemoryM679g, i, i2, i4, i5, tensorPrecisionType, bArrCreateByteArray);
    }
}
