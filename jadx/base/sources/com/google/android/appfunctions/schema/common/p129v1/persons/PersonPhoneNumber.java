package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appsearch.annotation.Document;
import androidx.autofill.HintConstants;
import com.google.android.appfunctions.schema.common.p129v1.types.SetField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__PersonPhoneNumber.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/PersonPhoneNumber;", "", "namespace", "", "id", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "type", "customType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getPhoneNumber", "getType", "getCustomType", "equals", "", "other", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class PersonPhoneNumber {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Document.StringProperty
    @Nullable
    private final String customType;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String phoneNumber;

    @Document.StringProperty(required = true)
    @NotNull
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/PersonPhoneNumber$Companion;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "Lcom/google/android/appfunctions/schema/common/v1/persons/PersonPhoneNumber;", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements SetFieldCompanion<PersonPhoneNumber> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetPersonPhoneNumberField setField(@NotNull PersonPhoneNumber value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetPersonPhoneNumberField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetField<List<PersonPhoneNumber>> setListField(@NotNull List<? extends PersonPhoneNumber> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetPersonPhoneNumberListField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetPersonPhoneNumberNullableField setNullableField(@Nullable PersonPhoneNumber value) {
            return new SetPersonPhoneNumberNullableField(null, null, value, 3, null);
        }
    }

    public PersonPhoneNumber(@NotNull String namespace, @NotNull String id, @NotNull String phoneNumber, @NotNull String type, @Nullable String str) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(type, "type");
        this.namespace = namespace;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.customType = str;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof PersonPhoneNumber)) {
            return false;
        }
        PersonPhoneNumber personPhoneNumber = (PersonPhoneNumber) other;
        return Intrinsics.areEqual(this.phoneNumber, personPhoneNumber.phoneNumber) && Intrinsics.areEqual(this.type, personPhoneNumber.type) && Intrinsics.areEqual(this.customType, personPhoneNumber.customType);
    }

    @Nullable
    public final String getCustomType() {
        return this.customType;
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
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.phoneNumber, this.type, this.customType);
    }

    public /* synthetic */ PersonPhoneNumber(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, str4, (i & 16) != 0 ? null : str5);
    }
}
