package com.google.android.appfunctions;

import androidx.appsearch.annotation.Document;
import androidx.glance.AbstractC2821a;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionParameterMetadata;", "", "id", "", "namespace", "name", "description", "parameterType", "Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;)V", "getId", "()Ljava/lang/String;", "getNamespace", "getName", "getDescription", "getParameterType", "()Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;", "equals", "", "other", "hashCode", "", "toString", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AppFunctionParameterMetadata {

    @Document.StringProperty
    @NotNull
    private final String description;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @NotNull
    private final String name;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @NotNull
    private final AppFunctionDataTypeMetadata parameterType;

    public AppFunctionParameterMetadata(@NotNull String id, @NotNull String namespace, @NotNull String name, @NotNull String description, @NotNull AppFunctionDataTypeMetadata parameterType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(parameterType, "parameterType");
        this.id = id;
        this.namespace = namespace;
        this.name = name;
        this.description = description;
        this.parameterType = parameterType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionParameterMetadata)) {
            return false;
        }
        AppFunctionParameterMetadata appFunctionParameterMetadata = (AppFunctionParameterMetadata) other;
        return Objects.equals(this.namespace, appFunctionParameterMetadata.namespace) && Objects.equals(this.id, appFunctionParameterMetadata.id) && Objects.equals(this.name, appFunctionParameterMetadata.name) && Objects.equals(this.description, appFunctionParameterMetadata.description) && Objects.equals(this.parameterType, appFunctionParameterMetadata.parameterType);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final AppFunctionDataTypeMetadata getParameterType() {
        return this.parameterType;
    }

    public int hashCode() {
        return Objects.hash(this.namespace, this.id, this.name, this.description, this.parameterType);
    }

    @NotNull
    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        String str3 = this.name;
        String str4 = this.description;
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.parameterType;
        StringBuilder sbM16m = AbstractC0000a.m16m("AppFunctionParameterMetadata(namespace=", str, ", id=", str2, ", name=");
        AbstractC2821a.m2207B(sbM16m, str3, ", description=", str4, ", parameterType=");
        sbM16m.append(appFunctionDataTypeMetadata);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
