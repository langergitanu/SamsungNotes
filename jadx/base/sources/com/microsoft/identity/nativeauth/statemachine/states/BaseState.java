package com.microsoft.identity.nativeauth.statemachine.states;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "", "continuationToken", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class BaseState {

    @Nullable
    private final String continuationToken;

    @NotNull
    private final String correlationId;

    public BaseState(@Nullable String str, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.continuationToken = str;
        this.correlationId = correlationId;
    }

    @Nullable
    /* JADX INFO: renamed from: getContinuationToken$msal_distRelease, reason: from getter */
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @NotNull
    /* JADX INFO: renamed from: getCorrelationId$msal_distRelease, reason: from getter */
    public String getCorrelationId() {
        return this.correlationId;
    }
}
