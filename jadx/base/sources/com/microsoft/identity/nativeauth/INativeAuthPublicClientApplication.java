package com.microsoft.identity.nativeauth;

import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccountResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordStartResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\rH&J7\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J6\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0015H&J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ0\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u001bH&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "Lcom/microsoft/identity/client/IPublicClientApplication;", "getCurrentAccount", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "resetPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "signIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "password", "", "scopes", "", "(Ljava/lang/String;[CLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "signUp", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "(Ljava/lang/String;[CLcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", "INativeAuthApplicationCreatedListener", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface INativeAuthPublicClientApplication extends IPublicClientApplication {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object signIn$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, List list, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signIn");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                list = null;
            }
            return iNativeAuthPublicClientApplication.signIn(str, cArr, (List<String>) list, (Continuation<? super SignInResult>) continuation);
        }

        public static /* synthetic */ Object signUp$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, UserAttributes userAttributes, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signUp");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                userAttributes = null;
            }
            return iNativeAuthPublicClientApplication.signUp(str, cArr, userAttributes, (Continuation<? super SignUpResult>) continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void signIn$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, List list, NativeAuthPublicClientApplication.SignInCallback signInCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signIn");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                list = null;
            }
            iNativeAuthPublicClientApplication.signIn(str, cArr, (List<String>) list, signInCallback);
        }

        public static /* synthetic */ void signUp$default(INativeAuthPublicClientApplication iNativeAuthPublicClientApplication, String str, char[] cArr, UserAttributes userAttributes, NativeAuthPublicClientApplication.SignUpCallback signUpCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signUp");
            }
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                userAttributes = null;
            }
            iNativeAuthPublicClientApplication.signUp(str, cArr, userAttributes, signUpCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication$INativeAuthApplicationCreatedListener;", "", "onCreated", "", "application", "Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "onError", "exception", "Lcom/microsoft/identity/client/exception/MsalException;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface INativeAuthApplicationCreatedListener {
        void onCreated(@NotNull INativeAuthPublicClientApplication application);

        void onError(@NotNull MsalException exception);
    }

    @Nullable
    Object getCurrentAccount(@NotNull Continuation<? super GetAccountResult> continuation);

    void getCurrentAccount(@NotNull NativeAuthPublicClientApplication.GetCurrentAccountCallback callback);

    @Nullable
    Object resetPassword(@NotNull String str, @NotNull Continuation<? super ResetPasswordStartResult> continuation);

    void resetPassword(@NotNull String username, @NotNull NativeAuthPublicClientApplication.ResetPasswordCallback callback);

    @Nullable
    Object signIn(@NotNull String str, @Nullable char[] cArr, @Nullable List<String> list, @NotNull Continuation<? super SignInResult> continuation);

    void signIn(@NotNull String username, @Nullable char[] password, @Nullable List<String> scopes, @NotNull NativeAuthPublicClientApplication.SignInCallback callback);

    @Nullable
    Object signUp(@NotNull String str, @Nullable char[] cArr, @Nullable UserAttributes userAttributes, @NotNull Continuation<? super SignUpResult> continuation);

    void signUp(@NotNull String username, @Nullable char[] password, @Nullable UserAttributes attributes, @NotNull NativeAuthPublicClientApplication.SignUpCallback callback);
}
