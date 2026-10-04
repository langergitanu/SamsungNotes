package com.google.android.appfunctions.schema.common.p129v1.phone;

import androidx.appsearch.annotation.Document;
import androidx.autofill.HintConstants;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CallRecord.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0007\u0010\u0016R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006#"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/phone/CallRecord;", "", "namespace", "", "id", "contactId", "callType", "isVideoCall", "", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "durationMillis", "", "sipAddress", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getContactId", "getCallType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSipAddress", "getPhoneNumber", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CallRecord {

    @Document.StringProperty(required = true)
    @NotNull
    private final String callType;

    @Document.StringProperty(required = true)
    @NotNull
    private final String contactId;

    @Document.LongProperty
    @Nullable
    private final Long durationMillis;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isVideoCall;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String phoneNumber;

    @Document.StringProperty
    @Nullable
    private final String sipAddress;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final DateTime startTime;

    public CallRecord(@NotNull String namespace, @NotNull String id, @NotNull String contactId, @NotNull String callType, @Nullable Boolean bool, @NotNull DateTime startTime, @Nullable Long l, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        Intrinsics.checkNotNullParameter(callType, "callType");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        this.namespace = namespace;
        this.id = id;
        this.contactId = contactId;
        this.callType = callType;
        this.isVideoCall = bool;
        this.startTime = startTime;
        this.durationMillis = l;
        this.sipAddress = str;
        this.phoneNumber = str2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CallRecord)) {
            return false;
        }
        CallRecord callRecord = (CallRecord) other;
        return Intrinsics.areEqual(this.id, callRecord.id) && Intrinsics.areEqual(this.contactId, callRecord.contactId) && Intrinsics.areEqual(this.callType, callRecord.callType) && Intrinsics.areEqual(this.isVideoCall, callRecord.isVideoCall) && Intrinsics.areEqual(this.startTime, callRecord.startTime) && Intrinsics.areEqual(this.durationMillis, callRecord.durationMillis) && Intrinsics.areEqual(this.sipAddress, callRecord.sipAddress) && Intrinsics.areEqual(this.phoneNumber, callRecord.phoneNumber);
    }

    @NotNull
    public final String getCallType() {
        return this.callType;
    }

    @NotNull
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final Long getDurationMillis() {
        return this.durationMillis;
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

    @Nullable
    public final String getSipAddress() {
        return this.sipAddress;
    }

    @NotNull
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.contactId, this.callType, this.isVideoCall, this.startTime, this.durationMillis, this.sipAddress, this.phoneNumber);
    }

    @Nullable
    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final Boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ CallRecord(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.Boolean r6, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r7, java.lang.Long r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r12 = r11 & 16
            r0 = 0
            if (r12 == 0) goto Lc
            r6 = r0
        Lc:
            r12 = r11 & 64
            if (r12 == 0) goto L11
            r8 = r0
        L11:
            r12 = r11 & 128(0x80, float:1.8E-43)
            if (r12 == 0) goto L16
            r9 = r0
        L16:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L25
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2f
        L25:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2f:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.phone.CallRecord.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, com.google.android.appfunctions.schema.common.v1.types.DateTime, java.lang.Long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
