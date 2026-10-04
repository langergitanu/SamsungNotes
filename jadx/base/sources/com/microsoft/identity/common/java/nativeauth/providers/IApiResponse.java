package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "statusCode", "", "correlationId", "", "(ILjava/lang/String;)V", "<set-?>", "getCorrelationId", "()Ljava/lang/String;", "setCorrelationId$common4j", "(Ljava/lang/String;)V", "getStatusCode", "()I", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class IApiResponse implements ILoggable {

    @NotNull
    private String correlationId;
    private final transient int statusCode;

    public IApiResponse(int i, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.correlationId = correlationId;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    @NotNull
    public final String getCorrelationId() {
        return this.correlationId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public final void setCorrelationId$common4j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.correlationId = str;
    }
}
