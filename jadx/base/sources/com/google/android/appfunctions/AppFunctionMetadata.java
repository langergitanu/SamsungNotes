package com.google.android.appfunctions;

import androidx.appsearch.annotation.Document;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionMetadata;", "", "id", "", "namespace", "enabledByDefault", "", "description", "parameters", "", "Lcom/google/android/appfunctions/AppFunctionParameterMetadata;", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE, "Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;)V", "getId", "()Ljava/lang/String;", "getNamespace", "getEnabledByDefault", "()Z", "getDescription", "getParameters", "()Ljava/util/List;", "getReturnType", "()Lcom/google/android/appfunctions/AppFunctionDataTypeMetadata;", "toString", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AppFunctionMetadata {

    @Document.StringProperty
    @NotNull
    private final String description;

    @Document.BooleanProperty
    private final boolean enabledByDefault;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @NotNull
    private final List<AppFunctionParameterMetadata> parameters;

    @Document.DocumentProperty
    @NotNull
    private final AppFunctionDataTypeMetadata returnType;

    public AppFunctionMetadata(@NotNull String id, @NotNull String namespace, boolean z, @NotNull String description, @NotNull List<AppFunctionParameterMetadata> parameters, @NotNull AppFunctionDataTypeMetadata returnType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        this.id = id;
        this.namespace = namespace;
        this.enabledByDefault = z;
        this.description = description;
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionMetadata)) {
            return false;
        }
        AppFunctionMetadata appFunctionMetadata = (AppFunctionMetadata) other;
        return Objects.equals(this.namespace, appFunctionMetadata.namespace) && Objects.equals(this.id, appFunctionMetadata.id) && this.enabledByDefault == appFunctionMetadata.enabledByDefault && Objects.equals(this.description, appFunctionMetadata.description) && Objects.equals(this.parameters, appFunctionMetadata.parameters) && Objects.equals(this.returnType, appFunctionMetadata.returnType);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnabledByDefault() {
        return this.enabledByDefault;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final List<AppFunctionParameterMetadata> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final AppFunctionDataTypeMetadata getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return Objects.hash(this.namespace, this.id, Boolean.valueOf(this.enabledByDefault), this.description, this.parameters, this.returnType);
    }

    @NotNull
    public String toString() {
        String str = this.namespace;
        String str2 = this.id;
        boolean z = this.enabledByDefault;
        String str3 = this.description;
        List<AppFunctionParameterMetadata> list = this.parameters;
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.returnType;
        StringBuilder sbM16m = AbstractC0000a.m16m("AppFunctionMetadata(namespace='", str, "', id='", str2, "', enabledByDefault=");
        sbM16m.append(z);
        sbM16m.append(", description='");
        sbM16m.append(str3);
        sbM16m.append("', parameters=");
        sbM16m.append(list);
        sbM16m.append(", returnType=");
        sbM16m.append(appFunctionDataTypeMetadata);
        sbM16m.append(")");
        return sbM16m.toString();
    }
}
