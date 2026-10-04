package com.google.android.appfunctions;

import androidx.appsearch.annotation.Document;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;", "", "id", "", "namespace", "dataType", "", "isList", "", "isNullable", "documentType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getNamespace", "getDataType", "()I", "()Z", "getDocumentType", "equals", "other", "hashCode", "toString", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AppFunctionDataTypeMetadata {

    @Document.LongProperty
    private final int dataType;

    @Document.StringProperty
    @Nullable
    private final String documentType;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    private final boolean isList;

    @Document.BooleanProperty
    private final boolean isNullable;

    @Document.Namespace
    @NotNull
    private final String namespace;

    public AppFunctionDataTypeMetadata(@NotNull String id, @NotNull String namespace, int i, boolean z, boolean z2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        this.id = id;
        this.namespace = namespace;
        this.dataType = i;
        this.isList = z;
        this.isNullable = z2;
        this.documentType = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionDataTypeMetadata)) {
            return false;
        }
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = (AppFunctionDataTypeMetadata) other;
        return Objects.equals(this.namespace, appFunctionDataTypeMetadata.namespace) && Objects.equals(this.id, appFunctionDataTypeMetadata.id) && this.dataType == appFunctionDataTypeMetadata.dataType && Objects.equals(this.documentType, appFunctionDataTypeMetadata.documentType) && this.isList == appFunctionDataTypeMetadata.isList && this.isNullable == appFunctionDataTypeMetadata.isNullable;
    }

    public final int getDataType() {
        return this.dataType;
    }

    @Nullable
    public final String getDocumentType() {
        return this.documentType;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return Objects.hash(this.namespace, this.id, Integer.valueOf(this.dataType), this.documentType, Boolean.valueOf(this.isList), Boolean.valueOf(this.isNullable));
    }

    /* JADX INFO: renamed from: isList, reason: from getter */
    public final boolean getIsList() {
        return this.isList;
    }

    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    @NotNull
    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        int i = this.dataType;
        String str3 = this.documentType;
        boolean z = this.isList;
        boolean z2 = this.isNullable;
        StringBuilder sbM16m = AbstractC0000a.m16m("AppFunctionDataTypeMetadata(namespace=", str, ", id=", str2, ", dataType=");
        AbstractC1974b.m1331x(sbM16m, i, ", documentType=", str3, ", isList=");
        sbM16m.append(z);
        sbM16m.append(", isNullable=");
        sbM16m.append(z2);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    public /* synthetic */ AppFunctionDataTypeMetadata(String str, String str2, int i, boolean z, boolean z2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, z, z2, (i2 & 32) != 0 ? null : str3);
    }
}
