package com.google.android.appfunctions.schema.common.p129v1.types;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0017\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/BooleanField;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "(Ljava/lang/Boolean;)Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class BooleanField implements SetFieldCompanion<Boolean> {

    @NotNull
    public static final BooleanField INSTANCE = new BooleanField();

    private BooleanField() {
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
    public /* bridge */ /* synthetic */ SetField<Boolean> setField(Boolean bool) {
        return setField(bool.booleanValue());
    }

    @NotNull
    public SetBooleanField setField(boolean value) {
        return new SetBooleanField(null, null, value, 3, null);
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
    @NotNull
    public SetField<List<Boolean>> setListField(@NotNull List<? extends Boolean> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new SetBooleanListField(null, null, value, 3, null);
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
    @NotNull
    public SetBooleanNullableField setNullableField(@Nullable Boolean value) {
        return new SetBooleanNullableField(null, null, value, 3, null);
    }
}
