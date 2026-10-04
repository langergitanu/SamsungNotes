package com.samsung.android.sdk.bixby2.labs.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/bixby2/labs/data/RootViewNode;", "", "rootViewName", "", "viewNodeInfo", "Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;", "windowType", "", "error", "Lcom/samsung/android/sdk/bixby2/labs/data/ErrorInfo;", "(Ljava/lang/String;Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;Ljava/lang/Integer;Lcom/samsung/android/sdk/bixby2/labs/data/ErrorInfo;)V", "getError", "()Lcom/samsung/android/sdk/bixby2/labs/data/ErrorInfo;", "getRootViewName", "()Ljava/lang/String;", "getViewNodeInfo", "()Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;", "getWindowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/samsung/android/sdk/bixby2/labs/data/ViewNodeInfo;Ljava/lang/Integer;Lcom/samsung/android/sdk/bixby2/labs/data/ErrorInfo;)Lcom/samsung/android/sdk/bixby2/labs/data/RootViewNode;", "equals", "", "other", "hashCode", "toString", "bixbyappsdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class RootViewNode {

    @Nullable
    private final ErrorInfo error;

    @NotNull
    private final String rootViewName;

    @Nullable
    private final ViewNodeInfo viewNodeInfo;

    @Nullable
    private final Integer windowType;

    public RootViewNode(@NotNull String rootViewName, @Nullable ViewNodeInfo viewNodeInfo, @Nullable Integer num, @Nullable ErrorInfo errorInfo) {
        Intrinsics.checkNotNullParameter(rootViewName, "rootViewName");
        this.rootViewName = rootViewName;
        this.viewNodeInfo = viewNodeInfo;
        this.windowType = num;
        this.error = errorInfo;
    }

    public static /* synthetic */ RootViewNode copy$default(RootViewNode rootViewNode, String str, ViewNodeInfo viewNodeInfo, Integer num, ErrorInfo errorInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rootViewNode.rootViewName;
        }
        if ((i & 2) != 0) {
            viewNodeInfo = rootViewNode.viewNodeInfo;
        }
        if ((i & 4) != 0) {
            num = rootViewNode.windowType;
        }
        if ((i & 8) != 0) {
            errorInfo = rootViewNode.error;
        }
        return rootViewNode.copy(str, viewNodeInfo, num, errorInfo);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRootViewName() {
        return this.rootViewName;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ViewNodeInfo getViewNodeInfo() {
        return this.viewNodeInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getWindowType() {
        return this.windowType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ErrorInfo getError() {
        return this.error;
    }

    @NotNull
    public final RootViewNode copy(@NotNull String rootViewName, @Nullable ViewNodeInfo viewNodeInfo, @Nullable Integer windowType, @Nullable ErrorInfo error) {
        Intrinsics.checkNotNullParameter(rootViewName, "rootViewName");
        return new RootViewNode(rootViewName, viewNodeInfo, windowType, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RootViewNode)) {
            return false;
        }
        RootViewNode rootViewNode = (RootViewNode) other;
        return Intrinsics.areEqual(this.rootViewName, rootViewNode.rootViewName) && Intrinsics.areEqual(this.viewNodeInfo, rootViewNode.viewNodeInfo) && Intrinsics.areEqual(this.windowType, rootViewNode.windowType) && Intrinsics.areEqual(this.error, rootViewNode.error);
    }

    @Nullable
    public final ErrorInfo getError() {
        return this.error;
    }

    @NotNull
    public final String getRootViewName() {
        return this.rootViewName;
    }

    @Nullable
    public final ViewNodeInfo getViewNodeInfo() {
        return this.viewNodeInfo;
    }

    @Nullable
    public final Integer getWindowType() {
        return this.windowType;
    }

    public int hashCode() {
        int iHashCode = this.rootViewName.hashCode() * 31;
        ViewNodeInfo viewNodeInfo = this.viewNodeInfo;
        int iHashCode2 = (iHashCode + (viewNodeInfo == null ? 0 : viewNodeInfo.hashCode())) * 31;
        Integer num = this.windowType;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        ErrorInfo errorInfo = this.error;
        return iHashCode3 + (errorInfo != null ? errorInfo.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RootViewNode(rootViewName=" + this.rootViewName + ", viewNodeInfo=" + this.viewNodeInfo + ", windowType=" + this.windowType + ", error=" + this.error + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ RootViewNode(String str, ViewNodeInfo viewNodeInfo, Integer num, ErrorInfo errorInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : viewNodeInfo, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : errorInfo);
    }
}
