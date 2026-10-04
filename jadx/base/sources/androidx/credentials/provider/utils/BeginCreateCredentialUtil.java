package androidx.credentials.provider.utils;

import android.annotation.SuppressLint;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.CallingAppInfo;
import androidx.annotation.RequiresApi;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.AbstractC2557b;
import androidx.credentials.provider.BeginCreateCustomCredentialRequest;
import androidx.credentials.provider.BeginCreatePasswordCredentialRequest;
import androidx.credentials.provider.BeginCreatePublicKeyCredentialRequest;
import androidx.credentials.provider.C2558c;
import androidx.credentials.provider.CreateEntry;
import androidx.credentials.provider.RemoteEntry;
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
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BeginCreateCredentialUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0003¨\u0006\u0019"}, m13886d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion;", "", "()V", "convertToFrameworkRequest", "Landroid/service/credentials/BeginCreateCredentialRequest;", "request", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "convertToFrameworkResponse", "Landroid/service/credentials/BeginCreateCredentialResponse;", "response", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "convertToJetpackRequest", "convertToJetpackRequest$credentials_release", "convertToJetpackResponse", "frameworkResponse", "populateCreateEntries", "", "frameworkBuilder", "Landroid/service/credentials/BeginCreateCredentialResponse$Builder;", "createEntries", "", "Landroidx/credentials/provider/CreateEntry;", "populateRemoteEntry", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nBeginCreateCredentialUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeginCreateCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1855#2,2:166\n1#3:168\n*S KotlinDebug\n*F\n+ 1 BeginCreateCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion\n*L\n123#1:166,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$5(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CreateEntry) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$6(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$7(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CreateEntry) tmp0.invoke(obj);
        }

        private final void populateCreateEntries(BeginCreateCredentialResponse.Builder frameworkBuilder, List<CreateEntry> createEntries) {
            Iterator<T> it = createEntries.iterator();
            while (it.hasNext()) {
                Slice slice = CreateEntry.INSTANCE.toSlice((CreateEntry) it.next());
                if (slice != null) {
                    frameworkBuilder.addCreateEntry(AbstractC2557b.m2066l(slice));
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        private final void populateRemoteEntry(BeginCreateCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            AbstractC2557b.m2052B();
            frameworkBuilder.setRemoteCreateEntry(AbstractC2557b.m2068n(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        @NotNull
        public final BeginCreateCredentialRequest convertToFrameworkRequest(@NotNull androidx.credentials.provider.BeginCreateCredentialRequest request) {
            CallingAppInfo callingAppInfoM2065k;
            Intrinsics.checkNotNullParameter(request, "request");
            if (request.getCallingAppInfo() != null) {
                AbstractC2557b.m2053C();
                callingAppInfoM2065k = AbstractC2557b.m2065k(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin());
            } else {
                callingAppInfoM2065k = null;
            }
            AbstractC2557b.m2054D();
            return AbstractC2557b.m2060f(request.getType(), request.getCandidateQueryData(), callingAppInfoM2065k);
        }

        @NotNull
        public final BeginCreateCredentialResponse convertToFrameworkResponse(@NotNull androidx.credentials.provider.BeginCreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BeginCreateCredentialResponse.Builder builderM2061g = AbstractC2557b.m2061g();
            populateCreateEntries(builderM2061g, response.getCreateEntries());
            populateRemoteEntry(builderM2061g, response.getRemoteEntry());
            BeginCreateCredentialResponse beginCreateCredentialResponseBuild = builderM2061g.build();
            Intrinsics.checkNotNullExpressionValue(beginCreateCredentialResponseBuild, "frameworkBuilder.build()");
            return beginCreateCredentialResponseBuild;
        }

        @JvmStatic
        @NotNull
        public final androidx.credentials.provider.BeginCreateCredentialRequest convertToJetpackRequest$credentials_release(@NotNull BeginCreateCredentialRequest request) {
            androidx.credentials.provider.CallingAppInfo callingAppInfo;
            androidx.credentials.provider.CallingAppInfo callingAppInfo2;
            androidx.credentials.provider.CallingAppInfo callingAppInfo3;
            Intrinsics.checkNotNullParameter(request, "request");
            androidx.credentials.provider.CallingAppInfo callingAppInfo4 = null;
            try {
                String type = request.getType();
                int iHashCode = type.hashCode();
                if (iHashCode != -543568185) {
                    if (iHashCode == -95037569 && type.equals(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                        BeginCreatePublicKeyCredentialRequest.Companion companion = BeginCreatePublicKeyCredentialRequest.INSTANCE;
                        Bundle data = request.getData();
                        Intrinsics.checkNotNullExpressionValue(data, "request.data");
                        CallingAppInfo callingAppInfo5 = request.getCallingAppInfo();
                        if (callingAppInfo5 != null) {
                            String packageName = callingAppInfo5.getPackageName();
                            Intrinsics.checkNotNullExpressionValue(packageName, "it.packageName");
                            SigningInfo signingInfo = callingAppInfo5.getSigningInfo();
                            Intrinsics.checkNotNullExpressionValue(signingInfo, "it.signingInfo");
                            callingAppInfo3 = new androidx.credentials.provider.CallingAppInfo(packageName, signingInfo, callingAppInfo5.getOrigin());
                        } else {
                            callingAppInfo3 = null;
                        }
                        return companion.createFrom$credentials_release(data, callingAppInfo3);
                    }
                } else if (type.equals(PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    BeginCreatePasswordCredentialRequest.Companion companion2 = BeginCreatePasswordCredentialRequest.INSTANCE;
                    Bundle data2 = request.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "request.data");
                    CallingAppInfo callingAppInfo6 = request.getCallingAppInfo();
                    if (callingAppInfo6 != null) {
                        String packageName2 = callingAppInfo6.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName2, "it.packageName");
                        SigningInfo signingInfo2 = callingAppInfo6.getSigningInfo();
                        Intrinsics.checkNotNullExpressionValue(signingInfo2, "it.signingInfo");
                        callingAppInfo = new androidx.credentials.provider.CallingAppInfo(packageName2, signingInfo2, callingAppInfo6.getOrigin());
                    } else {
                        callingAppInfo = null;
                    }
                    return companion2.createFrom$credentials_release(data2, callingAppInfo);
                }
                String type2 = request.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "request.type");
                Bundle data3 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data3, "request.data");
                CallingAppInfo callingAppInfo7 = request.getCallingAppInfo();
                if (callingAppInfo7 != null) {
                    String packageName3 = callingAppInfo7.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName3, "it.packageName");
                    SigningInfo signingInfo3 = callingAppInfo7.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo3, "it.signingInfo");
                    callingAppInfo2 = new androidx.credentials.provider.CallingAppInfo(packageName3, signingInfo3, callingAppInfo7.getOrigin());
                } else {
                    callingAppInfo2 = null;
                }
                return new BeginCreateCustomCredentialRequest(type2, data3, callingAppInfo2);
            } catch (FrameworkClassParsingException unused) {
                String type3 = request.getType();
                Intrinsics.checkNotNullExpressionValue(type3, "request.type");
                Bundle data4 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data4, "request.data");
                CallingAppInfo callingAppInfo8 = request.getCallingAppInfo();
                if (callingAppInfo8 != null) {
                    String packageName4 = callingAppInfo8.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName4, "it.packageName");
                    SigningInfo signingInfo4 = callingAppInfo8.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo4, "it.signingInfo");
                    callingAppInfo4 = new androidx.credentials.provider.CallingAppInfo(packageName4, signingInfo4, callingAppInfo8.getOrigin());
                }
                return new BeginCreateCustomCredentialRequest(type3, data4, callingAppInfo4);
            }
        }

        @NotNull
        public final androidx.credentials.provider.BeginCreateCredentialResponse convertToJetpackResponse(@NotNull BeginCreateCredentialResponse frameworkResponse) {
            RemoteEntry remoteEntryFromSlice;
            Intrinsics.checkNotNullParameter(frameworkResponse, "frameworkResponse");
            Object objCollect = frameworkResponse.getCreateEntries().stream().map(new C2558c(new Function1<android.service.credentials.CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$1
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CreateEntry invoke2(android.service.credentials.CreateEntry createEntry) {
                    CreateEntry.Companion companion = CreateEntry.INSTANCE;
                    Slice slice = createEntry.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "entry.slice");
                    return companion.fromSlice(slice);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CreateEntry invoke(android.service.credentials.CreateEntry createEntry) {
                    return invoke2(AbstractC2560b.m2110m(createEntry));
                }
            }, 1)).filter(new C2559a(new Function1<CreateEntry, Boolean>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable CreateEntry createEntry) {
                    return Boolean.valueOf(createEntry != null);
                }
            }, 0)).map(new C2558c(new Function1<CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$3
                @Override // kotlin.jvm.functions.Function1
                public final CreateEntry invoke(@Nullable CreateEntry createEntry) {
                    Intrinsics.checkNotNull(createEntry);
                    return createEntry;
                }
            }, 2)).collect(Collectors.toList());
            Intrinsics.checkNotNullExpressionValue(objCollect, "frameworkResponse.create…lect(Collectors.toList())");
            List list = (List) objCollect;
            android.service.credentials.RemoteEntry remoteCreateEntry = frameworkResponse.getRemoteCreateEntry();
            if (remoteCreateEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                Slice slice = remoteCreateEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "it.slice");
                remoteEntryFromSlice = companion.fromSlice(slice);
            } else {
                remoteEntryFromSlice = null;
            }
            return new androidx.credentials.provider.BeginCreateCredentialResponse(list, remoteEntryFromSlice);
        }

        private Companion() {
        }
    }
}
