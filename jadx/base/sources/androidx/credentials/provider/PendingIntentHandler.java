package androidx.credentials.provider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.GetCredentialRequest;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.credentials.AbstractC2513b;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.ProviderGetCredentialRequest;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/provider/PendingIntentHandler;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PendingIntentHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PendingIntentHandler";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "retrieveBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "retrieveProviderCreateCredentialRequest", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "retrieveProviderGetCredentialRequest", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "setBeginGetCredentialResponse", "", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "setCreateCredentialException", "exception", "Landroidx/credentials/exceptions/CreateCredentialException;", "setCreateCredentialResponse", "Landroidx/credentials/CreateCredentialResponse;", "setGetCredentialException", "Landroidx/credentials/exceptions/GetCredentialException;", "setGetCredentialResponse", "Landroidx/credentials/GetCredentialResponse;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPendingIntentHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PendingIntentHandler.kt\nandroidx/credentials/provider/PendingIntentHandler$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,335:1\n1#2:336\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialOption retrieveProviderGetCredentialRequest$lambda$1(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CredentialOption) tmp0.invoke(obj);
        }

        @JvmStatic
        @Nullable
        public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            android.service.credentials.BeginGetCredentialRequest beginGetCredentialRequestM1980j = AbstractC2513b.m1980j(intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", AbstractC2557b.m2070p()));
            if (beginGetCredentialRequestM1980j != null) {
                return BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(beginGetCredentialRequestM1980j);
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @Nullable
        public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            CreateCredentialRequest createCredentialRequestM1983m = AbstractC2513b.m1983m(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", AbstractC2513b.m1970D()));
            if (createCredentialRequestM1983m == 0) {
                Log.i(PendingIntentHandler.TAG, "Request not found in pendingIntent");
                return (ProviderCreateCredentialRequest) createCredentialRequestM1983m;
            }
            CreateCredentialRequest.Companion companion = androidx.credentials.CreateCredentialRequest.INSTANCE;
            String type = createCredentialRequestM1983m.getType();
            Intrinsics.checkNotNullExpressionValue(type, "frameworkReq.type");
            Bundle data = createCredentialRequestM1983m.getData();
            Intrinsics.checkNotNullExpressionValue(data, "frameworkReq.data");
            Bundle data2 = createCredentialRequestM1983m.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "frameworkReq.data");
            androidx.credentials.CreateCredentialRequest createCredentialRequestCreateFrom = companion.createFrom(type, data, data2, false, createCredentialRequestM1983m.getCallingAppInfo().getOrigin());
            if (createCredentialRequestCreateFrom == null) {
                return null;
            }
            String packageName = createCredentialRequestM1983m.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "frameworkReq.callingAppInfo.packageName");
            SigningInfo signingInfo = createCredentialRequestM1983m.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "frameworkReq.callingAppInfo.signingInfo");
            return new ProviderCreateCredentialRequest(createCredentialRequestCreateFrom, new CallingAppInfo(packageName, signingInfo, createCredentialRequestM1983m.getCallingAppInfo().getOrigin()));
        }

        @JvmStatic
        @Nullable
        public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GetCredentialRequest getCredentialRequestM2067m = AbstractC2557b.m2067m(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", AbstractC2513b.m1969C()));
            if (getCredentialRequestM2067m == null) {
                Log.i(PendingIntentHandler.TAG, "Get request from framework is null");
                return null;
            }
            ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.INSTANCE;
            Object objCollect = getCredentialRequestM2067m.getCredentialOptions().stream().map(new C2558c(new Function1<android.credentials.CredentialOption, CredentialOption>() { // from class: androidx.credentials.provider.PendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CredentialOption invoke(android.credentials.CredentialOption credentialOption) {
                    return invoke2(AbstractC2557b.m2057c(credentialOption));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CredentialOption invoke2(android.credentials.CredentialOption credentialOption) {
                    CredentialOption.Companion companion2 = CredentialOption.INSTANCE;
                    String type = credentialOption.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "option.type");
                    Bundle credentialRetrievalData = credentialOption.getCredentialRetrievalData();
                    Intrinsics.checkNotNullExpressionValue(credentialRetrievalData, "option.credentialRetrievalData");
                    Bundle candidateQueryData = credentialOption.getCandidateQueryData();
                    Intrinsics.checkNotNullExpressionValue(candidateQueryData, "option.candidateQueryData");
                    boolean zIsSystemProviderRequired = credentialOption.isSystemProviderRequired();
                    Set<ComponentName> allowedProviders = credentialOption.getAllowedProviders();
                    Intrinsics.checkNotNullExpressionValue(allowedProviders, "option.allowedProviders");
                    return companion2.createFrom(type, credentialRetrievalData, candidateQueryData, zIsSystemProviderRequired, allowedProviders);
                }
            }, 0)).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect, "frameworkReq.credentialO…lect(Collectors.toList())");
            String packageName = getCredentialRequestM2067m.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "frameworkReq.callingAppInfo.packageName");
            SigningInfo signingInfo = getCredentialRequestM2067m.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "frameworkReq.callingAppInfo.signingInfo");
            return companion.createFrom$credentials_release((List) objCollect, new CallingAppInfo(packageName, signingInfo, getCredentialRequestM2067m.getCallingAppInfo().getOrigin()));
        }

        @JvmStatic
        public final void setBeginGetCredentialResponse(@NotNull Intent intent, @NotNull BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        public final void setCreateCredentialException(@NotNull Intent intent, @NotNull CreateCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            AbstractC2513b.m1987q();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", AbstractC2513b.m1973c(exception.getType(), exception.getMessage()));
        }

        @JvmStatic
        public final void setCreateCredentialResponse(@NotNull Intent intent, @NotNull CreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            AbstractC2557b.m2077w();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", AbstractC2513b.m1974d(response.getData()));
        }

        @JvmStatic
        public final void setGetCredentialException(@NotNull Intent intent, @NotNull GetCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            AbstractC2513b.m1991u();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", AbstractC2513b.m1977g(exception.getType(), exception.getMessage()));
        }

        @JvmStatic
        public final void setGetCredentialResponse(@NotNull Intent intent, @NotNull GetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            AbstractC2513b.m1996z();
            AbstractC2513b.m1968B();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", AbstractC2513b.m1978h(AbstractC2513b.m1975e(response.getCredential().getData(), response.getCredential().getType())));
        }

        private Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveBeginGetCredentialRequest(intent);
    }

    @JvmStatic
    @Nullable
    public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
    }

    @JvmStatic
    @Nullable
    public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveProviderGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final void setBeginGetCredentialResponse(@NotNull Intent intent, @NotNull BeginGetCredentialResponse beginGetCredentialResponse) {
        INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
    }

    @JvmStatic
    public static final void setCreateCredentialException(@NotNull Intent intent, @NotNull CreateCredentialException createCredentialException) {
        INSTANCE.setCreateCredentialException(intent, createCredentialException);
    }

    @JvmStatic
    public static final void setCreateCredentialResponse(@NotNull Intent intent, @NotNull CreateCredentialResponse createCredentialResponse) {
        INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
    }

    @JvmStatic
    public static final void setGetCredentialException(@NotNull Intent intent, @NotNull GetCredentialException getCredentialException) {
        INSTANCE.setGetCredentialException(intent, getCredentialException);
    }

    @JvmStatic
    public static final void setGetCredentialResponse(@NotNull Intent intent, @NotNull GetCredentialResponse getCredentialResponse) {
        INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
    }
}
