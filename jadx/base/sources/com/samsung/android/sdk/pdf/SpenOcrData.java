package com.samsung.android.sdk.pdf;

import android.graphics.Rect;
import androidx.collection.AbstractC0622a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenOcrData;", "", "blockList", "", "Lcom/samsung/android/sdk/pdf/SpenBlockInfo;", "validRect", "Landroid/graphics/Rect;", "version", "", "<init>", "(Ljava/util/List;Landroid/graphics/Rect;Ljava/lang/String;)V", "getBlockList", "()Ljava/util/List;", "getValidRect", "()Landroid/graphics/Rect;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class SpenOcrData {

    @NotNull
    private final List<SpenBlockInfo> blockList;

    @NotNull
    private final Rect validRect;

    @NotNull
    private final String version;

    public SpenOcrData(@NotNull List<SpenBlockInfo> blockList, @NotNull Rect validRect, @NotNull String version) {
        Intrinsics.checkNotNullParameter(blockList, "blockList");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        Intrinsics.checkNotNullParameter(version, "version");
        this.blockList = blockList;
        this.validRect = validRect;
        this.version = version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpenOcrData copy$default(SpenOcrData spenOcrData, List list, Rect rect, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = spenOcrData.blockList;
        }
        if ((i & 2) != 0) {
            rect = spenOcrData.validRect;
        }
        if ((i & 4) != 0) {
            str = spenOcrData.version;
        }
        return spenOcrData.copy(list, rect, str);
    }

    @NotNull
    public final List<SpenBlockInfo> component1() {
        return this.blockList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Rect getValidRect() {
        return this.validRect;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final SpenOcrData copy(@NotNull List<SpenBlockInfo> blockList, @NotNull Rect validRect, @NotNull String version) {
        Intrinsics.checkNotNullParameter(blockList, "blockList");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        Intrinsics.checkNotNullParameter(version, "version");
        return new SpenOcrData(blockList, validRect, version);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpenOcrData)) {
            return false;
        }
        SpenOcrData spenOcrData = (SpenOcrData) other;
        return Intrinsics.areEqual(this.blockList, spenOcrData.blockList) && Intrinsics.areEqual(this.validRect, spenOcrData.validRect) && Intrinsics.areEqual(this.version, spenOcrData.version);
    }

    @NotNull
    public final List<SpenBlockInfo> getBlockList() {
        return this.blockList;
    }

    @NotNull
    public final Rect getValidRect() {
        return this.validRect;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.version.hashCode() + ((this.validRect.hashCode() + (this.blockList.hashCode() * 31)) * 31);
    }

    @NotNull
    public String toString() {
        List<SpenBlockInfo> list = this.blockList;
        Rect rect = this.validRect;
        String str = this.version;
        StringBuilder sb = new StringBuilder("SpenOcrData(blockList=");
        sb.append(list);
        sb.append(", validRect=");
        sb.append(rect);
        sb.append(", version=");
        return AbstractC0622a.m1170p(str, ")", sb);
    }
}
