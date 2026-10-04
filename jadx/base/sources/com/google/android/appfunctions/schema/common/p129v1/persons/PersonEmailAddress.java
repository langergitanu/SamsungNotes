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
@Document(name = C$$__AppSearch__PersonEmailAddress.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/PersonEmailAddress;", "", "namespace", "", "id", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "type", "customType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getEmailAddress", "getType", "getCustomType", "equals", "", "other", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class PersonEmailAddress {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Document.StringProperty
    @Nullable
    private final String customType;

    @Document.StringProperty(required = true)
    @NotNull
    private final String emailAddress;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/PersonEmailAddress$Companion;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "Lcom/google/android/appfunctions/schema/common/v1/persons/PersonEmailAddress;", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements SetFieldCompanion<PersonEmailAddress> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetPersonEmailAddressField setField(@NotNull PersonEmailAddress value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetPersonEmailAddressField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetField<List<PersonEmailAddress>> setListField(@NotNull List<? extends PersonEmailAddress> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetPersonEmailAddressListField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetPersonEmailAddressNullableField setNullableField(@Nullable PersonEmailAddress value) {
            return new SetPersonEmailAddressNullableField(null, null, value, 3, null);
        }
    }

    public PersonEmailAddress(@NotNull String namespace, @NotNull String id, @NotNull String emailAddress, @NotNull String type, @Nullable String str) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(emailAddress, "emailAddress");
        Intrinsics.checkNotNullParameter(type, "type");
        this.namespace = namespace;
        this.id = id;
        this.emailAddress = emailAddress;
        this.type = type;
        this.customType = str;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof PersonEmailAddress)) {
            return false;
        }
        PersonEmailAddress personEmailAddress = (PersonEmailAddress) other;
        return Intrinsics.areEqual(this.emailAddress, personEmailAddress.emailAddress) && Intrinsics.areEqual(this.type, personEmailAddress.type) && Intrinsics.areEqual(this.customType, personEmailAddress.customType);
    }

    @Nullable
    public final String getCustomType() {
        return this.customType;
    }

    @NotNull
    public final String getEmailAddress() {
        return this.emailAddress;
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
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.emailAddress, this.type, this.customType);
    }

    public /* synthetic */ PersonEmailAddress(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, str4, (i & 16) != 0 ? null : str5);
    }
}
