package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appsearch.annotation.Document;
import androidx.autofill.HintConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__MakeCallParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/phone/MakeCallParams;", "", "namespace", "", "id", "type", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "contactId", "shouldRecord", "", "isSpeakerOn", "isVideoCall", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getType", "getPhoneNumber", "getContactId", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class MakeCallParams {

    @Document.StringProperty
    @Nullable
    private final String contactId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isSpeakerOn;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isVideoCall;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String phoneNumber;

    @Document.BooleanProperty
    @JvmField
    @Nullable
    public final Boolean shouldRecord;

    @Document.StringProperty(required = true)
    @NotNull
    private final String type;

    public MakeCallParams(@NotNull String namespace, @NotNull String id, @NotNull String type, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.namespace = namespace;
        this.id = id;
        this.type = type;
        this.phoneNumber = str;
        this.contactId = str2;
        this.shouldRecord = bool;
        this.isSpeakerOn = bool2;
        this.isVideoCall = bool3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof MakeCallParams)) {
            return false;
        }
        MakeCallParams makeCallParams = (MakeCallParams) other;
        return Intrinsics.areEqual(this.type, makeCallParams.type) && Intrinsics.areEqual(this.phoneNumber, makeCallParams.phoneNumber) && Intrinsics.areEqual(this.contactId, makeCallParams.contactId) && Intrinsics.areEqual(this.shouldRecord, makeCallParams.shouldRecord) && Intrinsics.areEqual(this.isSpeakerOn, makeCallParams.isSpeakerOn) && Intrinsics.areEqual(this.isVideoCall, makeCallParams.isVideoCall);
    }

    @Nullable
    public final String getContactId() {
        return this.contactId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.phoneNumber, this.contactId, this.shouldRecord, this.isSpeakerOn, this.isVideoCall);
    }

    @Nullable
    /* JADX INFO: renamed from: isSpeakerOn, reason: from getter */
    public final Boolean getIsSpeakerOn() {
        return this.isSpeakerOn;
    }

    @Nullable
    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final Boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public /* synthetic */ MakeCallParams(String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : bool3);
    }
}
