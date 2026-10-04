package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetUriNullableField;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdatePersonParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006)"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/UpdatePersonParams;", "", "namespace", "", "id", "personId", "displayName", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "givenName", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "middleName", "familyName", "externalUri", "Lcom/google/android/appfunctions/schema/common/v1/types/SetUriNullableField;", Privacy.KEY_PHONE_NUMBERS, "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberListField;", Privacy.KEY_EMAIL_ADDRESSES, "Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressListField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetUriNullableField;Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberListField;Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressListField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getPersonId", "getDisplayName", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getGivenName", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getMiddleName", "getFamilyName", "getExternalUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetUriNullableField;", "getPhoneNumbers", "()Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonPhoneNumberListField;", "getEmailAddresses", "()Lcom/google/android/appfunctions/schema/common/v1/persons/SetPersonEmailAddressListField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdatePersonParams {

    @Document.DocumentProperty
    @Nullable
    private final SetStringField displayName;

    @Document.DocumentProperty
    @Nullable
    private final SetPersonEmailAddressListField emailAddresses;

    @Document.DocumentProperty
    @Nullable
    private final SetUriNullableField externalUri;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField familyName;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField givenName;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField middleName;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String personId;

    @Document.DocumentProperty
    @Nullable
    private final SetPersonPhoneNumberListField phoneNumbers;

    public UpdatePersonParams(@NotNull String namespace, @NotNull String id, @NotNull String personId, @Nullable SetStringField setStringField, @Nullable SetStringNullableField setStringNullableField, @Nullable SetStringNullableField setStringNullableField2, @Nullable SetStringNullableField setStringNullableField3, @Nullable SetUriNullableField setUriNullableField, @Nullable SetPersonPhoneNumberListField setPersonPhoneNumberListField, @Nullable SetPersonEmailAddressListField setPersonEmailAddressListField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(personId, "personId");
        this.namespace = namespace;
        this.id = id;
        this.personId = personId;
        this.displayName = setStringField;
        this.givenName = setStringNullableField;
        this.middleName = setStringNullableField2;
        this.familyName = setStringNullableField3;
        this.externalUri = setUriNullableField;
        this.phoneNumbers = setPersonPhoneNumberListField;
        this.emailAddresses = setPersonEmailAddressListField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdatePersonParams)) {
            return false;
        }
        UpdatePersonParams updatePersonParams = (UpdatePersonParams) other;
        return Intrinsics.areEqual(this.personId, updatePersonParams.personId) && Intrinsics.areEqual(this.displayName, updatePersonParams.displayName) && Intrinsics.areEqual(this.givenName, updatePersonParams.givenName) && Intrinsics.areEqual(this.middleName, updatePersonParams.middleName) && Intrinsics.areEqual(this.familyName, updatePersonParams.familyName) && Intrinsics.areEqual(this.externalUri, updatePersonParams.externalUri) && Intrinsics.areEqual(this.phoneNumbers, updatePersonParams.phoneNumbers) && Intrinsics.areEqual(this.emailAddresses, updatePersonParams.emailAddresses);
    }

    @Nullable
    public final SetStringField getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final SetPersonEmailAddressListField getEmailAddresses() {
        return this.emailAddresses;
    }

    @Nullable
    public final SetUriNullableField getExternalUri() {
        return this.externalUri;
    }

    @Nullable
    public final SetStringNullableField getFamilyName() {
        return this.familyName;
    }

    @Nullable
    public final SetStringNullableField getGivenName() {
        return this.givenName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringNullableField getMiddleName() {
        return this.middleName;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getPersonId() {
        return this.personId;
    }

    @Nullable
    public final SetPersonPhoneNumberListField getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public int hashCode() {
        return Objects.hash(this.personId, this.displayName, this.givenName, this.middleName, this.familyName, this.externalUri, this.phoneNumbers, this.emailAddresses);
    }

    public /* synthetic */ UpdatePersonParams(String str, String str2, String str3, SetStringField setStringField, SetStringNullableField setStringNullableField, SetStringNullableField setStringNullableField2, SetStringNullableField setStringNullableField3, SetUriNullableField setUriNullableField, SetPersonPhoneNumberListField setPersonPhoneNumberListField, SetPersonEmailAddressListField setPersonEmailAddressListField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setStringNullableField, (i & 32) != 0 ? null : setStringNullableField2, (i & 64) != 0 ? null : setStringNullableField3, (i & 128) != 0 ? null : setUriNullableField, (i & 256) != 0 ? null : setPersonPhoneNumberListField, (i & 512) != 0 ? null : setPersonEmailAddressListField);
    }
}
