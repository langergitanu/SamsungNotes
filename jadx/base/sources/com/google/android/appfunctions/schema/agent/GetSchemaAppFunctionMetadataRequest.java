package com.google.android.appfunctions.schema.agent;

import androidx.annotation.RestrictTo;
import androidx.glance.AbstractC2821a;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/agent/GetSchemaAppFunctionMetadataRequest;", "", "category", "", "schemaName", "schemaVersion", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCategory", "()Ljava/lang/String;", "getSchemaName", "getSchemaVersion", "()I", "equals", "", "other", "hashCode", "toString", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class GetSchemaAppFunctionMetadataRequest {

    @NotNull
    private final String category;

    @NotNull
    private final String schemaName;
    private final int schemaVersion;

    public GetSchemaAppFunctionMetadataRequest(@NotNull String category, @NotNull String schemaName, int i) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(schemaName, "schemaName");
        this.category = category;
        this.schemaName = schemaName;
        this.schemaVersion = i;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetSchemaAppFunctionMetadataRequest)) {
            return false;
        }
        GetSchemaAppFunctionMetadataRequest getSchemaAppFunctionMetadataRequest = (GetSchemaAppFunctionMetadataRequest) other;
        return Objects.equals(this.category, getSchemaAppFunctionMetadataRequest.category) && Objects.equals(this.schemaName, getSchemaAppFunctionMetadataRequest.schemaName) && this.schemaVersion == getSchemaAppFunctionMetadataRequest.schemaVersion;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getSchemaName() {
        return this.schemaName;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public int hashCode() {
        return Objects.hash(this.category, this.schemaName, Integer.valueOf(this.schemaVersion));
    }

    @NotNull
    public String toString() {
        String str = this.category;
        String str2 = this.schemaName;
        return AbstractC2821a.m2223n(AbstractC0000a.m16m("GetSchemaAppFunctionMetadataRequest(category='", str, "', schemaName='", str2, "', schemaVersion="), ")", this.schemaVersion);
    }
}
