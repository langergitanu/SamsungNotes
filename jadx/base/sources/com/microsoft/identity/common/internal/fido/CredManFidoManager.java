package com.microsoft.identity.common.internal.fido;

import android.content.Context;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetPublicKeyCredentialOption;
import androidx.credentials.PublicKeyCredential;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/CredManFidoManager;", "Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "credentialManager", "Landroidx/credentials/CredentialManager;", "getCredentialManager", "()Landroidx/credentials/CredentialManager;", "authenticate", "", "challenge", "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class CredManFidoManager implements IFidoManager {

    @NotNull
    private final Context context;

    @NotNull
    private final CredentialManager credentialManager;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.fido.CredManFidoManager$authenticate$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.fido.CredManFidoManager", m14021f = "CredManFidoManager.kt", m14022i = {}, m14023l = {60}, m14024m = "authenticate", m14025n = {}, m14026s = {})
    public static final class C62741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C62741(Continuation<? super C62741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CredManFidoManager.this.authenticate(null, null, null, null, this);
        }
    }

    public CredManFidoManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.credentialManager = CredentialManager.INSTANCE.create(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.microsoft.identity.common.internal.fido.IFidoManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object authenticate(@NotNull String str, @NotNull String str2, @Nullable List<String> list, @NotNull String str3, @NotNull Continuation<? super String> continuation) {
        C62741 c62741;
        if (continuation instanceof C62741) {
            c62741 = (C62741) continuation;
            int i = c62741.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c62741.label = i - Integer.MIN_VALUE;
            } else {
                c62741 = new C62741(continuation);
            }
        }
        Object credential = c62741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c62741.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(credential);
            GetCredentialRequest getCredentialRequest = new GetCredentialRequest(CollectionsKt.listOf(new GetPublicKeyCredentialOption(WebAuthnJsonUtil.INSTANCE.createJsonAuthRequest(str, str2, list, str3), (byte[]) null, (Set) null, 6, (DefaultConstructorMarker) null)), null, false, null, false, 30, null);
            CredentialManager credentialManager = this.credentialManager;
            Context context = this.context;
            c62741.label = 1;
            credential = credentialManager.getCredential(context, getCredentialRequest, c62741);
            if (credential == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(credential);
        }
        Credential credential2 = ((GetCredentialResponse) credential).getCredential();
        Intrinsics.checkNotNull(credential2, "null cannot be cast to non-null type androidx.credentials.PublicKeyCredential");
        return WebAuthnJsonUtil.INSTANCE.extractAuthenticatorAssertionResponseJson(((PublicKeyCredential) credential2).getAuthenticationResponseJson());
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final CredentialManager getCredentialManager() {
        return this.credentialManager;
    }
}
