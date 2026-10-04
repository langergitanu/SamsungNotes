package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.results.Result;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SignUpSubmitCodeResult extends Result {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(@NotNull SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isComplete(signUpSubmitCodeResult);
        }

        public static boolean isError(@NotNull SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isError(signUpSubmitCodeResult);
        }

        public static boolean isSuccess(@NotNull SignUpSubmitCodeResult signUpSubmitCodeResult) {
            return Result.DefaultImpls.isSuccess(signUpSubmitCodeResult);
        }
    }
}
