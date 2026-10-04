package androidx.credentials.provider.utils;

import android.annotation.SuppressLint;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.AbstractC2557b;
import androidx.credentials.provider.Action;
import androidx.credentials.provider.AuthenticationAction;
import androidx.credentials.provider.BeginGetCredentialOption;
import androidx.credentials.provider.C2558c;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CredentialEntry;
import androidx.credentials.provider.RemoteEntry;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BeginGetCredentialUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0002J\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017H\u0002J\u001a\u0010 \u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0003¨\u0006#"}, m13886d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil$Companion;", "", "()V", "convertToFrameworkRequest", "Landroid/service/credentials/BeginGetCredentialRequest;", "request", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "convertToFrameworkResponse", "Landroid/service/credentials/BeginGetCredentialResponse;", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "convertToJetpackBeginOption", "Landroid/service/credentials/BeginGetCredentialOption;", "option", "Landroidx/credentials/provider/BeginGetCredentialOption;", "convertToJetpackRequest", "convertToJetpackRequest$credentials_release", "convertToJetpackResponse", "populateActionEntries", "", "builder", "Landroid/service/credentials/BeginGetCredentialResponse$Builder;", "actionEntries", "", "Landroidx/credentials/provider/Action;", "populateAuthenticationEntries", "frameworkBuilder", "authenticationActions", "Landroidx/credentials/provider/AuthenticationAction;", "populateCredentialEntries", "credentialEntries", "Landroidx/credentials/provider/CredentialEntry;", "populateRemoteEntry", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nBeginGetCredentialUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeginGetCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginGetCredentialUtil$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1855#2,2:179\n1855#2,2:181\n1855#2,2:183\n1855#2,2:185\n1#3:187\n*S KotlinDebug\n*F\n+ 1 BeginGetCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginGetCredentialUtil$Companion\n*L\n43#1:179,2\n86#1:181,2\n99#1:183,2\n112#1:185,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BeginGetCredentialOption convertToFrameworkRequest$lambda$5(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return AbstractC2560b.m2101d(tmp0.invoke(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BeginGetCredentialOption convertToJetpackBeginOption(androidx.credentials.provider.BeginGetCredentialOption option) {
            AbstractC2560b.m2097D();
            return AbstractC2560b.m2103f(option.getId(), option.getType(), option.getCandidateQueryData());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$10(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$11(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Action) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$12(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (AuthenticationAction) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$13(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$14(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (AuthenticationAction) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$6(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CredentialEntry) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$7(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$8(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CredentialEntry) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$9(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Action) tmp0.invoke(obj);
        }

        private final void populateActionEntries(BeginGetCredentialResponse.Builder builder, List<Action> actionEntries) {
            for (Action action : actionEntries) {
                AbstractC2560b.m2117t();
                builder.addAction(AbstractC2560b.m2100c(Action.INSTANCE.toSlice(action)));
            }
        }

        private final void populateAuthenticationEntries(BeginGetCredentialResponse.Builder frameworkBuilder, List<AuthenticationAction> authenticationActions) {
            for (AuthenticationAction authenticationAction : authenticationActions) {
                AbstractC2560b.m2117t();
                frameworkBuilder.addAuthenticationAction(AbstractC2560b.m2100c(AuthenticationAction.INSTANCE.toSlice(authenticationAction)));
            }
        }

        private final void populateCredentialEntries(BeginGetCredentialResponse.Builder builder, List<? extends CredentialEntry> credentialEntries) {
            for (CredentialEntry credentialEntry : credentialEntries) {
                Slice slice$credentials_release = CredentialEntry.INSTANCE.toSlice$credentials_release(credentialEntry);
                if (slice$credentials_release != null) {
                    AbstractC2560b.m2094A();
                    AbstractC2560b.m2097D();
                    String id = credentialEntry.getBeginGetCredentialOption().getId();
                    String type = credentialEntry.getType();
                    Bundle bundle = Bundle.EMPTY;
                    builder.addCredentialEntry(AbstractC2560b.m2111n(AbstractC2560b.m2102e(id, type), slice$credentials_release));
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        private final void populateRemoteEntry(BeginGetCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            AbstractC2557b.m2052B();
            frameworkBuilder.setRemoteCredentialEntry(AbstractC2557b.m2068n(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        @NotNull
        public final BeginGetCredentialRequest convertToFrameworkRequest(@NotNull androidx.credentials.provider.BeginGetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            BeginGetCredentialRequest.Builder builderM2104g = AbstractC2560b.m2104g();
            if (request.getCallingAppInfo() != null) {
                AbstractC2557b.m2053C();
                builderM2104g.setCallingAppInfo(AbstractC2557b.m2065k(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin()));
            }
            BeginGetCredentialRequest beginGetCredentialRequestBuild = builderM2104g.setBeginGetCredentialOptions((List) request.getBeginGetCredentialOptions().stream().map(new C2558c(new Function1<androidx.credentials.provider.BeginGetCredentialOption, BeginGetCredentialOption>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToFrameworkRequest$1
                @Override // kotlin.jvm.functions.Function1
                public final BeginGetCredentialOption invoke(androidx.credentials.provider.BeginGetCredentialOption option) {
                    BeginGetCredentialUtil.Companion companion = BeginGetCredentialUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(option, "option");
                    return companion.convertToJetpackBeginOption(option);
                }
            }, 9)).collect(Collectors.toList())).build();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialRequestBuild, "builder.setBeginGetCrede…\n                .build()");
            return beginGetCredentialRequestBuild;
        }

        @NotNull
        public final BeginGetCredentialResponse convertToFrameworkResponse(@NotNull androidx.credentials.provider.BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BeginGetCredentialResponse.Builder builderM2107j = AbstractC2560b.m2107j();
            populateCredentialEntries(builderM2107j, response.getCredentialEntries());
            populateActionEntries(builderM2107j, response.getActions());
            populateAuthenticationEntries(builderM2107j, response.getAuthenticationActions());
            populateRemoteEntry(builderM2107j, response.getRemoteEntry());
            BeginGetCredentialResponse beginGetCredentialResponseBuild = builderM2107j.build();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialResponseBuild, "frameworkBuilder.build()");
            return beginGetCredentialResponseBuild;
        }

        @JvmStatic
        @NotNull
        public final androidx.credentials.provider.BeginGetCredentialRequest convertToJetpackRequest$credentials_release(@NotNull BeginGetCredentialRequest request) {
            CallingAppInfo callingAppInfo;
            Intrinsics.checkNotNullParameter(request, "request");
            ArrayList arrayList = new ArrayList();
            List beginGetCredentialOptions = request.getBeginGetCredentialOptions();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialOptions, "request.beginGetCredentialOptions");
            Iterator it = beginGetCredentialOptions.iterator();
            while (it.hasNext()) {
                BeginGetCredentialOption beginGetCredentialOptionM2101d = AbstractC2560b.m2101d(it.next());
                BeginGetCredentialOption.Companion companion = androidx.credentials.provider.BeginGetCredentialOption.INSTANCE;
                String id = beginGetCredentialOptionM2101d.getId();
                Intrinsics.checkNotNullExpressionValue(id, "it.id");
                String type = beginGetCredentialOptionM2101d.getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                Bundle candidateQueryData = beginGetCredentialOptionM2101d.getCandidateQueryData();
                Intrinsics.checkNotNullExpressionValue(candidateQueryData, "it.candidateQueryData");
                arrayList.add(companion.createFrom$credentials_release(id, type, candidateQueryData));
            }
            android.service.credentials.CallingAppInfo callingAppInfo2 = request.getCallingAppInfo();
            if (callingAppInfo2 != null) {
                String packageName = callingAppInfo2.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "it.packageName");
                SigningInfo signingInfo = callingAppInfo2.getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "it.signingInfo");
                callingAppInfo = new CallingAppInfo(packageName, signingInfo, callingAppInfo2.getOrigin());
            } else {
                callingAppInfo = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialRequest(arrayList, callingAppInfo);
        }

        @NotNull
        public final androidx.credentials.provider.BeginGetCredentialResponse convertToJetpackResponse(@NotNull BeginGetCredentialResponse response) {
            RemoteEntry remoteEntryFromSlice;
            Intrinsics.checkNotNullParameter(response, "response");
            Object objCollect = response.getCredentialEntries().stream().map(new C2558c(new Function1<android.service.credentials.CredentialEntry, CredentialEntry>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$1
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CredentialEntry invoke2(android.service.credentials.CredentialEntry credentialEntry) {
                    CredentialEntry.Companion companion = CredentialEntry.INSTANCE;
                    Slice slice = credentialEntry.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "entry.slice");
                    return companion.createFrom$credentials_release(slice);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CredentialEntry invoke(android.service.credentials.CredentialEntry credentialEntry) {
                    return invoke2(AbstractC2560b.m2112o(credentialEntry));
                }
            }, 4)).filter(new C2559a(new Function1<CredentialEntry, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable CredentialEntry credentialEntry) {
                    return Boolean.valueOf(credentialEntry != null);
                }
            }, 2)).map(new C2558c(new Function1<CredentialEntry, CredentialEntry>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$3
                @Override // kotlin.jvm.functions.Function1
                public final CredentialEntry invoke(@Nullable CredentialEntry credentialEntry) {
                    Intrinsics.checkNotNull(credentialEntry);
                    return credentialEntry;
                }
            }, 5)).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect, "response.credentialEntri…lect(Collectors.toList())");
            List list = (List) objCollect;
            Object objCollect2 = response.getActions().stream().map(new C2558c(new Function1<android.service.credentials.Action, Action>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$4
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Action invoke2(android.service.credentials.Action action) {
                    Action.Companion companion = Action.INSTANCE;
                    Slice slice = action.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "entry.slice");
                    return companion.fromSlice(slice);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Action invoke(android.service.credentials.Action action) {
                    return invoke2(AbstractC2561c.m2139l(action));
                }
            }, 6)).filter(new C2559a(new Function1<Action, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$5
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable Action action) {
                    return Boolean.valueOf(action != null);
                }
            }, 3)).map(new C2558c(new Function1<Action, Action>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$6
                @Override // kotlin.jvm.functions.Function1
                public final Action invoke(@Nullable Action action) {
                    Intrinsics.checkNotNull(action);
                    return action;
                }
            }, 7)).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect2, "response.actions.stream(…lect(Collectors.toList())");
            List list2 = (List) objCollect2;
            Object objCollect3 = response.getAuthenticationActions().stream().map(new C2558c(new Function1<android.service.credentials.Action, AuthenticationAction>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$7
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final AuthenticationAction invoke2(android.service.credentials.Action action) {
                    AuthenticationAction.Companion companion = AuthenticationAction.INSTANCE;
                    Slice slice = action.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "entry.slice");
                    return companion.fromSlice(slice);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ AuthenticationAction invoke(android.service.credentials.Action action) {
                    return invoke2(AbstractC2561c.m2139l(action));
                }
            }, 8)).filter(new C2559a(new Function1<AuthenticationAction, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$8
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable AuthenticationAction authenticationAction) {
                    return Boolean.valueOf(authenticationAction != null);
                }
            }, 1)).map(new C2558c(new Function1<AuthenticationAction, AuthenticationAction>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$9
                @Override // kotlin.jvm.functions.Function1
                public final AuthenticationAction invoke(@Nullable AuthenticationAction authenticationAction) {
                    Intrinsics.checkNotNull(authenticationAction);
                    return authenticationAction;
                }
            }, 3)).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect3, "response.authenticationA…lect(Collectors.toList())");
            List list3 = (List) objCollect3;
            android.service.credentials.RemoteEntry remoteCredentialEntry = response.getRemoteCredentialEntry();
            if (remoteCredentialEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                Slice slice = remoteCredentialEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "it.slice");
                remoteEntryFromSlice = companion.fromSlice(slice);
            } else {
                remoteEntryFromSlice = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialResponse(list, list2, list3, remoteEntryFromSlice);
        }

        private Companion() {
        }
    }
}
