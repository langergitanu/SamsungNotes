package com.google.android.appfunctions.schema.common.p129v1.persons;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CreatePersonParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006#"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/persons/CreatePersonParams;", "", "namespace", "", "id", "displayName", "givenName", "middleName", "familyName", "externalUri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", Privacy.KEY_PHONE_NUMBERS, "", "Lcom/google/android/appfunctions/schema/common/v1/persons/PersonPhoneNumber;", Privacy.KEY_EMAIL_ADDRESSES, "Lcom/google/android/appfunctions/schema/common/v1/persons/PersonEmailAddress;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/util/List;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getDisplayName", "getGivenName", "getMiddleName", "getFamilyName", "getExternalUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getPhoneNumbers", "()Ljava/util/List;", "getEmailAddresses", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreatePersonParams {

    @Document.StringProperty(required = true)
    @NotNull
    private final String displayName;

    @Document.DocumentProperty
    @NotNull
    private final List<PersonEmailAddress> emailAddresses;

    @Document.DocumentProperty
    @Nullable
    private final Uri externalUri;

    @Document.StringProperty
    @Nullable
    private final String familyName;

    @Document.StringProperty
    @Nullable
    private final String givenName;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String middleName;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @NotNull
    private final List<PersonPhoneNumber> phoneNumbers;

    public CreatePersonParams(@NotNull String namespace, @NotNull String id, @NotNull String displayName, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Uri uri, @NotNull List<PersonPhoneNumber> phoneNumbers, @NotNull List<PersonEmailAddress> emailAddresses) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(phoneNumbers, "phoneNumbers");
        Intrinsics.checkNotNullParameter(emailAddresses, "emailAddresses");
        this.namespace = namespace;
        this.id = id;
        this.displayName = displayName;
        this.givenName = str;
        this.middleName = str2;
        this.familyName = str3;
        this.externalUri = uri;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreatePersonParams)) {
            return false;
        }
        CreatePersonParams createPersonParams = (CreatePersonParams) other;
        return Intrinsics.areEqual(this.displayName, createPersonParams.displayName) && Intrinsics.areEqual(this.givenName, createPersonParams.givenName) && Intrinsics.areEqual(this.middleName, createPersonParams.middleName) && Intrinsics.areEqual(this.familyName, createPersonParams.familyName) && Intrinsics.areEqual(this.externalUri, createPersonParams.externalUri) && Intrinsics.areEqual(this.phoneNumbers, createPersonParams.phoneNumbers) && Intrinsics.areEqual(this.emailAddresses, createPersonParams.emailAddresses);
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final List<PersonEmailAddress> getEmailAddresses() {
        return this.emailAddresses;
    }

    @Nullable
    public final Uri getExternalUri() {
        return this.externalUri;
    }

    @Nullable
    public final String getFamilyName() {
        return this.familyName;
    }

    @Nullable
    public final String getGivenName() {
        return this.givenName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMiddleName() {
        return this.middleName;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final List<PersonPhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public int hashCode() {
        return Objects.hash(this.displayName, this.givenName, this.middleName, this.familyName, this.externalUri, this.phoneNumbers, this.emailAddresses);
    }

    public /* synthetic */ CreatePersonParams(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : uri, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
