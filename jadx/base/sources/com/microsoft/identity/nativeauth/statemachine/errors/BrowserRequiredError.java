package com.microsoft.identity.nativeauth.statemachine.errors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/errors/BrowserRequiredError;", "", "isBrowserRequired", "", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface BrowserRequiredError {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isBrowserRequired(@NotNull BrowserRequiredError browserRequiredError) {
            Intrinsics.checkNotNull(browserRequiredError, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.statemachine.errors.Error");
            return Intrinsics.areEqual(((Error) browserRequiredError).getErrorType(), ErrorTypes.BROWSER_REQUIRED);
        }
    }

    boolean isBrowserRequired();
}
