package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Call.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0014"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/phone/Call;", "", "namespace", "", "id", "contactId", "isVideoCall", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getContactId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Call {

    @Document.StringProperty(required = true)
    @NotNull
    private final String contactId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isVideoCall;

    @Document.Namespace
    @NotNull
    private final String namespace;

    public Call(@NotNull String namespace, @NotNull String id, @NotNull String contactId, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        this.namespace = namespace;
        this.id = id;
        this.contactId = contactId;
        this.isVideoCall = bool;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Call)) {
            return false;
        }
        Call call = (Call) other;
        return Intrinsics.areEqual(this.contactId, call.contactId) && Intrinsics.areEqual(this.isVideoCall, call.isVideoCall);
    }

    @NotNull
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

    public int hashCode() {
        return Objects.hash(this.contactId, this.isVideoCall);
    }

    @Nullable
    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final Boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    public /* synthetic */ Call(String str, String str2, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : bool);
    }
}
