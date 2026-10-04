package com.samsung.android.sdk.bixby2.labs.data;

import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/bixby2/labs/data/ErrorInfo;", "", "type", "", "stackTrace", "(Ljava/lang/String;Ljava/lang/String;)V", "getStackTrace", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bixbyappsdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ErrorInfo {

    @Nullable
    private final String stackTrace;

    @Nullable
    private final String type;

    public ErrorInfo(@Nullable String str, @Nullable String str2) {
        this.type = str;
        this.stackTrace = str2;
    }

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorInfo.type;
        }
        if ((i & 2) != 0) {
            str2 = errorInfo.stackTrace;
        }
        return errorInfo.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStackTrace() {
        return this.stackTrace;
    }

    @NotNull
    public final ErrorInfo copy(@Nullable String type, @Nullable String stackTrace) {
        return new ErrorInfo(type, stackTrace);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) other;
        return Intrinsics.areEqual(this.type, errorInfo.type) && Intrinsics.areEqual(this.stackTrace, errorInfo.stackTrace);
    }

    @Nullable
    public final String getStackTrace() {
        return this.stackTrace;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.stackTrace;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ErrorInfo(type=");
        sb.append(this.type);
        sb.append(", stackTrace=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.stackTrace, sb);
    }
}
