package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__AcceptCallParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0007\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/phone/AcceptCallParams;", "", "namespace", "", "id", "shouldRecord", "", "isSpeakerOn", "isVideoCall", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getNamespace", "()Ljava/lang/String;", "getId", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AcceptCallParams {

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

    @Document.BooleanProperty
    @JvmField
    @Nullable
    public final Boolean shouldRecord;

    public AcceptCallParams() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof AcceptCallParams)) {
            return false;
        }
        AcceptCallParams acceptCallParams = (AcceptCallParams) other;
        return Intrinsics.areEqual(this.shouldRecord, acceptCallParams.shouldRecord) && Intrinsics.areEqual(this.isSpeakerOn, acceptCallParams.isSpeakerOn) && Intrinsics.areEqual(this.isVideoCall, acceptCallParams.isVideoCall);
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
        return Objects.hash(this.shouldRecord, this.isSpeakerOn, this.isVideoCall);
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

    public AcceptCallParams(@NotNull String namespace, @NotNull String id, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.shouldRecord = bool;
        this.isSpeakerOn = bool2;
        this.isVideoCall = bool3;
    }

    public /* synthetic */ AcceptCallParams(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : bool3);
    }
}
