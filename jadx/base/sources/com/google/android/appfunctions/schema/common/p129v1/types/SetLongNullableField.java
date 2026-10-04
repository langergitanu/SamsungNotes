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
@Document(name = C$$__AppSearch__SetLongNullableField.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/SetLongNullableField;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetField;", "", "namespace", "", "id", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getValue", "()Ljava/lang/Long;", "Ljava/lang/Long;", "equals", "", "other", "", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SetLongNullableField implements SetField<Long> {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty
    @Nullable
    private final Long value;

    public SetLongNullableField(@NotNull String namespace, @NotNull String id, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.value = l;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SetLongNullableField) && Intrinsics.areEqual(getValue(), ((SetLongNullableField) other).getValue());
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
    @Nullable
    public Long getValue() {
        return this.value;
    }

    public /* synthetic */ SetLongNullableField(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, l);
    }
}
