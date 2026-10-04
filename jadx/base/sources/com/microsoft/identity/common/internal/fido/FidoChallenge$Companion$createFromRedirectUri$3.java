package com.microsoft.identity.common.internal.fido;

import com.microsoft.identity.common.internal.fido.FidoChallengeField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
public /* synthetic */ class FidoChallenge$Companion$createFromRedirectUri$3 extends FunctionReferenceImpl implements Function2<FidoRequestField, String, String> {
    public FidoChallenge$Companion$createFromRedirectUri$3(Object obj) {
        super(2, obj, FidoChallengeField.Companion.class, "throwIfInvalidRequiredParameter", "throwIfInvalidRequiredParameter(Lcom/microsoft/identity/common/internal/fido/FidoRequestField;Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    @NotNull
    public final String invoke(@NotNull FidoRequestField p0, @Nullable String str) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((FidoChallengeField.Companion) this.receiver).throwIfInvalidRequiredParameter(p0, str);
    }
}
