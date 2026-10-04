package com.microsoft.identity.common.internal.fido;

import android.webkit.WebView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJD\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/fido/AuthFidoChallengeHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/IChallengeHandler;", "Lcom/microsoft/identity/common/internal/fido/FidoChallenge;", "Ljava/lang/Void;", "fidoManager", "Lcom/microsoft/identity/common/internal/fido/IFidoManager;", "webView", "Landroid/webkit/WebView;", "spanContext", "Lio/opentelemetry/api/trace/SpanContext;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/microsoft/identity/common/internal/fido/IFidoManager;Landroid/webkit/WebView;Lio/opentelemetry/api/trace/SpanContext;Landroidx/lifecycle/LifecycleOwner;)V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "getErrorAssertion", "errorMessage", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "processChallenge", "fidoChallenge", "respondToChallenge", "", "submitUrl", AbstractJwtRequest.ClaimNames.ASSERTION, "context", "span", "Lio/opentelemetry/api/trace/Span;", "respondToChallengeWithError", "methodTag", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AuthFidoChallengeHandler implements IChallengeHandler<FidoChallenge, Void> {

    @NotNull
    private final String TAG;

    @NotNull
    private final IFidoManager fidoManager;

    @Nullable
    private final LifecycleOwner lifecycleOwner;

    @Nullable
    private final SpanContext spanContext;

    @NotNull
    private final WebView webView;

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler$processChallenge$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler$processChallenge$1", m14021f = "AuthFidoChallengeHandler.kt", m14022i = {}, m14023l = {107}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C62731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $allowedCredentials;
        final /* synthetic */ String $authChallenge;
        final /* synthetic */ String $context;
        final /* synthetic */ String $methodTag;
        final /* synthetic */ String $relyingPartyIdentifier;
        final /* synthetic */ Span $span;
        final /* synthetic */ String $submitUrl;
        final /* synthetic */ String $userVerificationPolicy;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62731(String str, String str2, List<String> list, String str3, Span span, String str4, String str5, String str6, Continuation<? super C62731> continuation) {
            super(2, continuation);
            this.$authChallenge = str;
            this.$relyingPartyIdentifier = str2;
            this.$allowedCredentials = list;
            this.$userVerificationPolicy = str3;
            this.$span = span;
            this.$submitUrl = str4;
            this.$context = str5;
            this.$methodTag = str6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AuthFidoChallengeHandler.this.new C62731(this.$authChallenge, this.$relyingPartyIdentifier, this.$allowedCredentials, this.$userVerificationPolicy, this.$span, this.$submitUrl, this.$context, this.$methodTag, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C62731 c62731;
            IFidoManager iFidoManager;
            String str;
            String str2;
            List<String> list;
            String str3;
            Exception exc;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    iFidoManager = AuthFidoChallengeHandler.this.fidoManager;
                    str = this.$authChallenge;
                    str2 = this.$relyingPartyIdentifier;
                    list = this.$allowedCredentials;
                    str3 = this.$userVerificationPolicy;
                    this.label = 1;
                    c62731 = this;
                } catch (Exception e) {
                    e = e;
                    c62731 = this;
                    exc = e;
                    Exception exc2 = exc;
                    AuthFidoChallengeHandler.this.respondToChallengeWithError(c62731.$submitUrl, c62731.$context, c62731.$span, String.valueOf(exc2.getMessage()), exc2, c62731.$methodTag);
                }
                try {
                    obj = iFidoManager.authenticate(str, str2, list, str3, c62731);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    Exception exc22 = exc;
                    AuthFidoChallengeHandler.this.respondToChallengeWithError(c62731.$submitUrl, c62731.$context, c62731.$span, String.valueOf(exc22.getMessage()), exc22, c62731.$methodTag);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    ResultKt.throwOnFailure(obj);
                    c62731 = this;
                } catch (Exception e3) {
                    exc = e3;
                    c62731 = this;
                    Exception exc222 = exc;
                    AuthFidoChallengeHandler.this.respondToChallengeWithError(c62731.$submitUrl, c62731.$context, c62731.$span, String.valueOf(exc222.getMessage()), exc222, c62731.$methodTag);
                }
            }
            c62731.$span.setStatus(StatusCode.OK);
            AuthFidoChallengeHandler.this.respondToChallenge(c62731.$submitUrl, (String) obj, c62731.$context, c62731.$span);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C62731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AuthFidoChallengeHandler(@NotNull IFidoManager fidoManager, @NotNull WebView webView, @Nullable SpanContext spanContext, @Nullable LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(fidoManager, "fidoManager");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.fidoManager = fidoManager;
        this.webView = webView;
        this.spanContext = spanContext;
        this.lifecycleOwner = lifecycleOwner;
        this.TAG = String.valueOf(Reflection.getOrCreateKotlinClass(AuthFidoChallengeHandler.class).getSimpleName());
    }

    private final String getErrorAssertion(String errorMessage, Exception exception) {
        if (exception == null) {
            return AbstractC0541b.m772n(FidoConstants.PASSKEY_PROTOCOL_ERROR_PREFIX_STRING, errorMessage);
        }
        return FidoConstants.PASSKEY_PROTOCOL_ERROR_PREFIX_STRING + exception.getClass().getName() + ": " + exception.getMessage();
    }

    public static /* synthetic */ String getErrorAssertion$default(AuthFidoChallengeHandler authFidoChallengeHandler, String str, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            exc = null;
        }
        return authFidoChallengeHandler.getErrorAssertion(str, exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void respondToChallenge$lambda$0(String methodTag, AuthFidoChallengeHandler this$0, String submitUrl, Map header) {
        Intrinsics.checkNotNullParameter(methodTag, "$methodTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(submitUrl, "$submitUrl");
        Intrinsics.checkNotNullParameter(header, "$header");
        Logger.info(methodTag, "Responding to Fido challenge.");
        this$0.webView.loadUrl(submitUrl, header);
    }

    public static /* synthetic */ void respondToChallengeWithError$default(AuthFidoChallengeHandler authFidoChallengeHandler, String str, String str2, Span span, String str3, Exception exc, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            exc = null;
        }
        Exception exc2 = exc;
        if ((i & 32) != 0) {
            str4 = AbstractC0622a.m1170p(authFidoChallengeHandler.TAG, ":respondToChallengeWithError", new StringBuilder());
        }
        authFidoChallengeHandler.respondToChallengeWithError(str, str2, span, str3, exc2, str4);
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void respondToChallenge(@NotNull String submitUrl, @NotNull String assertion, @NotNull String context, @NotNull Span span) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(assertion, "assertion");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(span, "span");
        String str3 = this.TAG + ":respondToChallenge";
        span.end();
        List listSplit$default = StringsKt__StringsKt.split$default(context, new String[]{" "}, false, 0, 6, (Object) null);
        if (listSplit$default.size() == 2) {
            str = (String) listSplit$default.get(0);
            str2 = (String) listSplit$default.get(1);
        } else {
            str = (String) listSplit$default.get(0);
            str2 = "";
        }
        this.webView.post(new RunnableC0218a(str3, (Object) this, (Object) submitUrl, (Object) MapsKt.mapOf(TuplesKt.m13893to(FidoConstants.PASSKEY_RESPONSE_ASSERTION_HEADER, assertion), TuplesKt.m13893to(FidoConstants.PASSKEY_RESPONSE_CONTEXT_HEADER, str), TuplesKt.m13893to(FidoConstants.PASSKEY_RESPONSE_FLOWTOKEN_HEADER, str2)), 6));
    }

    public final void respondToChallengeWithError(@NotNull String submitUrl, @NotNull String context, @NotNull Span span, @NotNull String errorMessage, @Nullable Exception exception, @Nullable String methodTag) {
        Intrinsics.checkNotNullParameter(submitUrl, "submitUrl");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Logger.error(methodTag, errorMessage, exception);
        if (exception != null) {
            span.recordException(exception);
            span.setStatus(StatusCode.ERROR);
        } else {
            span.setStatus(StatusCode.ERROR, errorMessage);
        }
        respondToChallenge(submitUrl, getErrorAssertion(errorMessage, exception), context, span);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler
    @Nullable
    public Void processChallenge(@NotNull FidoChallenge fidoChallenge) {
        Intrinsics.checkNotNullParameter(fidoChallenge, "fidoChallenge");
        String strM1170p = AbstractC0622a.m1170p(this.TAG, ":processChallenge", new StringBuilder());
        Span spanCreateSpanFromParent = this.spanContext != null ? OTelUtility.createSpanFromParent(SpanName.Fido.name(), this.spanContext) : OTelUtility.createSpan(SpanName.Fido.name());
        Intrinsics.checkNotNullExpressionValue(spanCreateSpanFromParent, "if (spanContext != null)…Name.Fido.name)\n        }");
        spanCreateSpanFromParent.setAttribute(AttributeName.fido_challenge_handler.name(), this.TAG);
        String orThrow = fidoChallenge.getSubmitUrl().getOrThrow();
        String orThrow2 = fidoChallenge.getContext().getOrThrow();
        try {
            String orThrow3 = fidoChallenge.getChallenge().getOrThrow();
            String orThrow4 = fidoChallenge.getRelyingPartyIdentifier().getOrThrow();
            String orThrow5 = fidoChallenge.getUserVerificationPolicy().getOrThrow();
            List<String> orThrow6 = fidoChallenge.getAllowedCredentials().getOrThrow();
            fidoChallenge.getVersion().getOrThrow();
            fidoChallenge.getKeyTypes().getOrThrow();
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                respondToChallengeWithError$default(this, orThrow, orThrow2, spanCreateSpanFromParent, "Cannot get lifecycle owner needed for FIDO API calls.", null, strM1170p, 16, null);
                return null;
            }
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new C62731(orThrow3, orThrow4, orThrow6, orThrow5, spanCreateSpanFromParent, orThrow, orThrow2, strM1170p, null), 3, null);
            return null;
        } catch (Exception e) {
            respondToChallengeWithError(orThrow, orThrow2, spanCreateSpanFromParent, String.valueOf(e.getMessage()), e, strM1170p);
            return null;
        }
    }
}
