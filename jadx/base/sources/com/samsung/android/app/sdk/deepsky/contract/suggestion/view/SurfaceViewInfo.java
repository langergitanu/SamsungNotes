package com.samsung.android.app.sdk.deepsky.contract.suggestion.view;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B_\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jj\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0006H\u0016J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\bHÖ\u0001J\u0018\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0006H\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0019¨\u00068"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "revision", "", "surfaceHash", "", "hostToken", "Landroid/os/IBinder;", "displayId", "width", "height", "minHeight", "extras", "Landroid/os/Bundle;", "(ILjava/lang/String;Landroid/os/IBinder;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/os/Bundle;)V", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtras", "()Landroid/os/Bundle;", "getHeight", "setHeight", "(Ljava/lang/Integer;)V", "getHostToken", "()Landroid/os/IBinder;", "getMinHeight", "getRevision", "()I", "getSurfaceHash", "()Ljava/lang/String;", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Landroid/os/IBinder;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/os/Bundle;)Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSurfaceViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SurfaceViewInfo.kt\ncom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final /* data */ class SurfaceViewInfo implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Integer displayId;

    @Nullable
    private final Bundle extras;

    @Nullable
    private Integer height;

    @Nullable
    private final IBinder hostToken;

    @Nullable
    private final Integer minHeight;
    private final int revision;

    @NotNull
    private final String surfaceHash;

    @Nullable
    private Integer width;

    /* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SurfaceViewInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SurfaceViewInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SurfaceViewInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SurfaceViewInfo[] newArray(int size) {
            return new SurfaceViewInfo[size];
        }
    }

    public SurfaceViewInfo(int i, @NotNull String surfaceHash, @Nullable IBinder iBinder, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(surfaceHash, "surfaceHash");
        this.revision = i;
        this.surfaceHash = surfaceHash;
        this.hostToken = iBinder;
        this.displayId = num;
        this.width = num2;
        this.height = num3;
        this.minHeight = num4;
        this.extras = bundle;
    }

    public static /* synthetic */ SurfaceViewInfo copy$default(SurfaceViewInfo surfaceViewInfo, int i, String str, IBinder iBinder, Integer num, Integer num2, Integer num3, Integer num4, Bundle bundle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = surfaceViewInfo.revision;
        }
        if ((i2 & 2) != 0) {
            str = surfaceViewInfo.surfaceHash;
        }
        if ((i2 & 4) != 0) {
            iBinder = surfaceViewInfo.hostToken;
        }
        if ((i2 & 8) != 0) {
            num = surfaceViewInfo.displayId;
        }
        if ((i2 & 16) != 0) {
            num2 = surfaceViewInfo.width;
        }
        if ((i2 & 32) != 0) {
            num3 = surfaceViewInfo.height;
        }
        if ((i2 & 64) != 0) {
            num4 = surfaceViewInfo.minHeight;
        }
        if ((i2 & 128) != 0) {
            bundle = surfaceViewInfo.extras;
        }
        Integer num5 = num4;
        Bundle bundle2 = bundle;
        Integer num6 = num2;
        Integer num7 = num3;
        return surfaceViewInfo.copy(i, str, iBinder, num, num6, num7, num5, bundle2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurfaceHash() {
        return this.surfaceHash;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IBinder getHostToken() {
        return this.hostToken;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getDisplayId() {
        return this.displayId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getMinHeight() {
        return this.minHeight;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @NotNull
    public final SurfaceViewInfo copy(int revision, @NotNull String surfaceHash, @Nullable IBinder hostToken, @Nullable Integer displayId, @Nullable Integer width, @Nullable Integer height, @Nullable Integer minHeight, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(surfaceHash, "surfaceHash");
        return new SurfaceViewInfo(revision, surfaceHash, hostToken, displayId, width, height, minHeight, extras);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurfaceViewInfo)) {
            return false;
        }
        SurfaceViewInfo surfaceViewInfo = (SurfaceViewInfo) other;
        return this.revision == surfaceViewInfo.revision && Intrinsics.areEqual(this.surfaceHash, surfaceViewInfo.surfaceHash) && Intrinsics.areEqual(this.hostToken, surfaceViewInfo.hostToken) && Intrinsics.areEqual(this.displayId, surfaceViewInfo.displayId) && Intrinsics.areEqual(this.width, surfaceViewInfo.width) && Intrinsics.areEqual(this.height, surfaceViewInfo.height) && Intrinsics.areEqual(this.minHeight, surfaceViewInfo.minHeight) && Intrinsics.areEqual(this.extras, surfaceViewInfo.extras);
    }

    @Nullable
    public final Integer getDisplayId() {
        return this.displayId;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final IBinder getHostToken() {
        return this.hostToken;
    }

    @Nullable
    public final Integer getMinHeight() {
        return this.minHeight;
    }

    public final int getRevision() {
        return this.revision;
    }

    @NotNull
    public final String getSurfaceHash() {
        return this.surfaceHash;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iM1202c = AbstractC1038a.m1202c(Integer.hashCode(this.revision) * 31, 31, this.surfaceHash);
        IBinder iBinder = this.hostToken;
        int iHashCode = (iM1202c + (iBinder == null ? 0 : iBinder.hashCode())) * 31;
        Integer num = this.displayId;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.width;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.height;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.minHeight;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Bundle bundle = this.extras;
        return iHashCode5 + (bundle != null ? bundle.hashCode() : 0);
    }

    public final void setHeight(@Nullable Integer num) {
        this.height = num;
    }

    public final void setWidth(@Nullable Integer num) {
        this.width = num;
    }

    @NotNull
    public String toString() {
        int i = this.revision;
        String str = this.surfaceHash;
        IBinder iBinder = this.hostToken;
        Integer num = this.displayId;
        Integer num2 = this.width;
        Integer num3 = this.height;
        Integer num4 = this.minHeight;
        Bundle bundle = this.extras;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("SurfaceViewInfo(revision=", i, ", surfaceHash=", str, ", hostToken=");
        sbM1629s.append(iBinder);
        sbM1629s.append(", displayId=");
        sbM1629s.append(num);
        sbM1629s.append(", width=");
        sbM1629s.append(num2);
        sbM1629s.append(", height=");
        sbM1629s.append(num3);
        sbM1629s.append(", minHeight=");
        sbM1629s.append(num4);
        sbM1629s.append(", extras=");
        sbM1629s.append(bundle);
        sbM1629s.append(")");
        return sbM1629s.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.revision);
        parcel.writeString(this.surfaceHash);
        parcel.writeStrongBinder(this.hostToken);
        parcel.writeValue(this.displayId);
        parcel.writeValue(this.width);
        parcel.writeValue(this.height);
        parcel.writeValue(this.minHeight);
        parcel.writeBundle(this.extras);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SurfaceViewInfo(int r2, java.lang.String r3, android.os.IBinder r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Integer r8, android.os.Bundle r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L5
            r2 = 2
        L5:
            r11 = r10 & 4
            r0 = 0
            if (r11 == 0) goto Lb
            r4 = r0
        Lb:
            r11 = r10 & 8
            if (r11 == 0) goto L10
            r5 = r0
        L10:
            r11 = r10 & 16
            if (r11 == 0) goto L15
            r6 = r0
        L15:
            r11 = r10 & 32
            if (r11 == 0) goto L1a
            r7 = r0
        L1a:
            r11 = r10 & 64
            if (r11 == 0) goto L1f
            r8 = r0
        L1f:
            r10 = r10 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L2d
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L36
        L2d:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L36:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo.<init>(int, java.lang.String, android.os.IBinder, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, android.os.Bundle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SurfaceViewInfo(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        String string = parcel.readString();
        if (string != null) {
            Intrinsics.checkNotNullExpressionValue(string, "checkNotNull(parcel.read… \"surfaceHash is null\" })");
            IBinder strongBinder = parcel.readStrongBinder();
            Class cls = Integer.TYPE;
            Object value = parcel.readValue(cls.getClassLoader());
            Integer num = value instanceof Integer ? (Integer) value : null;
            Object value2 = parcel.readValue(cls.getClassLoader());
            Integer num2 = value2 instanceof Integer ? (Integer) value2 : null;
            Object value3 = parcel.readValue(cls.getClassLoader());
            Integer num3 = value3 instanceof Integer ? (Integer) value3 : null;
            Object value4 = parcel.readValue(cls.getClassLoader());
            this(i, string, strongBinder, num, num2, num3, value4 instanceof Integer ? (Integer) value4 : null, parcel.readBundle(Bundle.class.getClassLoader()));
            return;
        }
        throw new IllegalStateException("surfaceHash is null");
    }
}
