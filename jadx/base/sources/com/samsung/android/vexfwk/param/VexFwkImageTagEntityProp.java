package com.samsung.android.vexfwk.param;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\t\u0010&\u001a\u00020\rHÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rHÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018¨\u00062"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkImageTagEntityProp;", "Landroid/os/Parcelable;", "entityType", "Lcom/samsung/android/vexfwk/param/EntityType;", "mainCategoryTag", "", "mainCategoryTagScore", "", "subCategoryTag", "subCategoryTagScore", BuddyContract.Address.REGION, "Landroid/graphics/Rect;", "clusterId", "", "clusterIdStory", "(Lcom/samsung/android/vexfwk/param/EntityType;Ljava/lang/String;FLjava/lang/String;FLandroid/graphics/Rect;II)V", "getClusterId", "()I", "getClusterIdStory", "getEntityType", "()Lcom/samsung/android/vexfwk/param/EntityType;", "getMainCategoryTag", "()Ljava/lang/String;", "getMainCategoryTagScore", "()F", "getRegion", "()Landroid/graphics/Rect;", "getSubCategoryTag", "getSubCategoryTagScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class VexFwkImageTagEntityProp implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<VexFwkImageTagEntityProp> CREATOR = new Creator();
    private final int clusterId;
    private final int clusterIdStory;

    @NotNull
    private final EntityType entityType;

    @NotNull
    private final String mainCategoryTag;
    private final float mainCategoryTagScore;

    @NotNull
    private final Rect region;

    @NotNull
    private final String subCategoryTag;
    private final float subCategoryTagScore;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<VexFwkImageTagEntityProp> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageTagEntityProp createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VexFwkImageTagEntityProp(EntityType.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readFloat(), parcel.readString(), parcel.readFloat(), (Rect) parcel.readParcelable(VexFwkImageTagEntityProp.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VexFwkImageTagEntityProp[] newArray(int i) {
            return new VexFwkImageTagEntityProp[i];
        }
    }

    public VexFwkImageTagEntityProp(@NotNull EntityType entityType, @NotNull String mainCategoryTag, float f, @NotNull String subCategoryTag, float f4, @NotNull Rect region, int i, int i2) {
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        Intrinsics.checkNotNullParameter(mainCategoryTag, "mainCategoryTag");
        Intrinsics.checkNotNullParameter(subCategoryTag, "subCategoryTag");
        Intrinsics.checkNotNullParameter(region, "region");
        this.entityType = entityType;
        this.mainCategoryTag = mainCategoryTag;
        this.mainCategoryTagScore = f;
        this.subCategoryTag = subCategoryTag;
        this.subCategoryTagScore = f4;
        this.region = region;
        this.clusterId = i;
        this.clusterIdStory = i2;
    }

    public static /* synthetic */ VexFwkImageTagEntityProp copy$default(VexFwkImageTagEntityProp vexFwkImageTagEntityProp, EntityType entityType, String str, float f, String str2, float f4, Rect rect, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            entityType = vexFwkImageTagEntityProp.entityType;
        }
        if ((i4 & 2) != 0) {
            str = vexFwkImageTagEntityProp.mainCategoryTag;
        }
        if ((i4 & 4) != 0) {
            f = vexFwkImageTagEntityProp.mainCategoryTagScore;
        }
        if ((i4 & 8) != 0) {
            str2 = vexFwkImageTagEntityProp.subCategoryTag;
        }
        if ((i4 & 16) != 0) {
            f4 = vexFwkImageTagEntityProp.subCategoryTagScore;
        }
        if ((i4 & 32) != 0) {
            rect = vexFwkImageTagEntityProp.region;
        }
        if ((i4 & 64) != 0) {
            i = vexFwkImageTagEntityProp.clusterId;
        }
        if ((i4 & 128) != 0) {
            i2 = vexFwkImageTagEntityProp.clusterIdStory;
        }
        int i5 = i;
        int i6 = i2;
        float f5 = f4;
        Rect rect2 = rect;
        return vexFwkImageTagEntityProp.copy(entityType, str, f, str2, f5, rect2, i5, i6);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EntityType getEntityType() {
        return this.entityType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMainCategoryTag() {
        return this.mainCategoryTag;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getMainCategoryTagScore() {
        return this.mainCategoryTagScore;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubCategoryTag() {
        return this.subCategoryTag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getSubCategoryTagScore() {
        return this.subCategoryTagScore;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Rect getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getClusterId() {
        return this.clusterId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getClusterIdStory() {
        return this.clusterIdStory;
    }

    @NotNull
    public final VexFwkImageTagEntityProp copy(@NotNull EntityType entityType, @NotNull String mainCategoryTag, float mainCategoryTagScore, @NotNull String subCategoryTag, float subCategoryTagScore, @NotNull Rect region, int clusterId, int clusterIdStory) {
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        Intrinsics.checkNotNullParameter(mainCategoryTag, "mainCategoryTag");
        Intrinsics.checkNotNullParameter(subCategoryTag, "subCategoryTag");
        Intrinsics.checkNotNullParameter(region, "region");
        return new VexFwkImageTagEntityProp(entityType, mainCategoryTag, mainCategoryTagScore, subCategoryTag, subCategoryTagScore, region, clusterId, clusterIdStory);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VexFwkImageTagEntityProp)) {
            return false;
        }
        VexFwkImageTagEntityProp vexFwkImageTagEntityProp = (VexFwkImageTagEntityProp) other;
        return this.entityType == vexFwkImageTagEntityProp.entityType && Intrinsics.areEqual(this.mainCategoryTag, vexFwkImageTagEntityProp.mainCategoryTag) && Float.compare(this.mainCategoryTagScore, vexFwkImageTagEntityProp.mainCategoryTagScore) == 0 && Intrinsics.areEqual(this.subCategoryTag, vexFwkImageTagEntityProp.subCategoryTag) && Float.compare(this.subCategoryTagScore, vexFwkImageTagEntityProp.subCategoryTagScore) == 0 && Intrinsics.areEqual(this.region, vexFwkImageTagEntityProp.region) && this.clusterId == vexFwkImageTagEntityProp.clusterId && this.clusterIdStory == vexFwkImageTagEntityProp.clusterIdStory;
    }

    public final int getClusterId() {
        return this.clusterId;
    }

    public final int getClusterIdStory() {
        return this.clusterIdStory;
    }

    @NotNull
    public final EntityType getEntityType() {
        return this.entityType;
    }

    @NotNull
    public final String getMainCategoryTag() {
        return this.mainCategoryTag;
    }

    public final float getMainCategoryTagScore() {
        return this.mainCategoryTagScore;
    }

    @NotNull
    public final Rect getRegion() {
        return this.region;
    }

    @NotNull
    public final String getSubCategoryTag() {
        return this.subCategoryTag;
    }

    public final float getSubCategoryTagScore() {
        return this.subCategoryTagScore;
    }

    public int hashCode() {
        return Integer.hashCode(this.clusterIdStory) + AbstractC0622a.m1157c(this.clusterId, (this.region.hashCode() + AbstractC0622a.m1156b(this.subCategoryTagScore, AbstractC1038a.m1202c(AbstractC0622a.m1156b(this.mainCategoryTagScore, AbstractC1038a.m1202c(this.entityType.hashCode() * 31, 31, this.mainCategoryTag), 31), 31, this.subCategoryTag), 31)) * 31, 31);
    }

    @NotNull
    public String toString() {
        EntityType entityType = this.entityType;
        String str = this.mainCategoryTag;
        float f = this.mainCategoryTagScore;
        String str2 = this.subCategoryTag;
        float f4 = this.subCategoryTagScore;
        Rect rect = this.region;
        int i = this.clusterId;
        int i2 = this.clusterIdStory;
        StringBuilder sb = new StringBuilder("VexFwkImageTagEntityProp(entityType=");
        sb.append(entityType);
        sb.append(", mainCategoryTag=");
        sb.append(str);
        sb.append(", mainCategoryTagScore=");
        sb.append(f);
        sb.append(", subCategoryTag=");
        sb.append(str2);
        sb.append(", subCategoryTagScore=");
        sb.append(f4);
        sb.append(", region=");
        sb.append(rect);
        sb.append(", clusterId=");
        return AbstractC2322a.m1625o(sb, i, i2, ", clusterIdStory=", ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.entityType.writeToParcel(parcel, flags);
        parcel.writeString(this.mainCategoryTag);
        parcel.writeFloat(this.mainCategoryTagScore);
        parcel.writeString(this.subCategoryTag);
        parcel.writeFloat(this.subCategoryTagScore);
        parcel.writeParcelable(this.region, flags);
        parcel.writeInt(this.clusterId);
        parcel.writeInt(this.clusterIdStory);
    }
}
