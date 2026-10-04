package com.microsoft.identity.common.java.nativeauth.controllers.results;

import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordNotAccepted;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$PasswordResetFailed;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordCommandResult$UserNotFound;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface ResetPasswordSubmitNewPasswordCommandResult extends INativeAuthCommandResult {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(@NotNull ResetPasswordSubmitNewPasswordCommandResult resetPasswordSubmitNewPasswordCommandResult) {
            return INativeAuthCommandResult.DefaultImpls.containsPii(resetPasswordSubmitNewPasswordCommandResult);
        }
    }
}
