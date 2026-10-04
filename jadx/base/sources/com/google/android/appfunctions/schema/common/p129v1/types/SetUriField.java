package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__SetUriField.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00028\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/SetUriField;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetField;", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "namespace", "", "id", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getValue", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "equals", "", "other", "", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SetUriField implements SetField<Uri> {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri value;

    public SetUriField(@NotNull String namespace, @NotNull String id, @NotNull Uri value) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(value, "value");
        this.namespace = namespace;
        this.id = id;
        this.value = value;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SetUriField) && Intrinsics.areEqual(getValue(), ((SetUriField) other).getValue());
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
        return Objects.hash(getValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetField
    @NotNull
    public Uri getValue() {
        return this.value;
    }

    public /* synthetic */ SetUriField(String str, String str2, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, uri);
    }
}
