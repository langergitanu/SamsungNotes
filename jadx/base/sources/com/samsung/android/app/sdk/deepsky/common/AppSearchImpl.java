package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.AppSearchSession;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.SearchResults;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.content.Context;
import android.content.pm.Signature;
import androidx.annotation.RequiresApi;
import androidx.appsearch.platformstorage.AbstractC0570e;
import androidx.appsearch.platformstorage.AbstractC0573h;
import androidx.appsearch.platformstorage.converter.AbstractC0565b;
import androidx.appsearch.platformstorage.converter.AbstractC0568e;
import com.google.android.material.motion.AbstractC4744a;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0017J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/AppSearchImpl;", "Lcom/samsung/android/app/sdk/deepsky/common/AppSearch;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "putDocument", "", "appSearchSchema", "Landroid/app/appsearch/AppSearchSchema;", ExternalDataConstants.DOCUMENT_TABLE_NAME, "Landroid/app/appsearch/GenericDocument;", "permissions", "", "", "permittedSssOnly", "removeDocument", "id", "", "removeOldDocument", "", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppSearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSearch.kt\ncom/samsung/android/app/sdk/deepsky/common/AppSearchImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,140:1\n1549#2:141\n1620#2,3:142\n*S KotlinDebug\n*F\n+ 1 AppSearch.kt\ncom/samsung/android/app/sdk/deepsky/common/AppSearchImpl\n*L\n91#1:141\n91#1:142,3\n*E\n"})
public final class AppSearchImpl implements AppSearch {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DATABASE_NAME = "app-search-db";
    private static final int MAX_SIZE = 15;

    @NotNull
    private static final String TAG = "AppSearch";

    @NotNull
    private static final String sssPackageName = "com.samsung.android.smartsuggestions";

    @NotNull
    private final Context context;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/common/AppSearchImpl$Companion;", "", "()V", "DATABASE_NAME", "", "MAX_SIZE", "", SearchConstants.TargetContents.TAG, "sssPackageName", "getSha256Certificate", "", "context", "Landroid/content/Context;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final byte[] getSha256Certificate(Context context) throws CertificateEncodingException {
            Signature[] apkContentsSigners = context.getPackageManager().getPackageInfo(AppSearchImpl.sssPackageName, 134217728).signingInfo.getApkContentsSigners();
            Intrinsics.checkNotNullExpressionValue(apkContentsSigners, "context.packageManager.g…ngInfo.apkContentsSigners");
            Signature signature = (Signature) ArraysKt.firstOrNull(apkContentsSigners);
            if (signature == null) {
                return new byte[0];
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray())).getEncoded());
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "getInstance(\"SHA-256\").digest(encodedCert)");
            return bArrDigest;
        }

        private Companion() {
        }
    }

    public AppSearchImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putDocument$lambda$3(SetSchemaRequest setSchemaRequest, ExecutorService executorService, PutDocumentsRequest putDocumentsRequest, AppSearchResult appSearchResult) {
        Intrinsics.checkNotNullParameter(setSchemaRequest, "$setSchemaRequest");
        Intrinsics.checkNotNullParameter(putDocumentsRequest, "$putDocumentsRequest");
        AppSearchSession appSearchSessionM1026d = AbstractC0570e.m1026d(appSearchResult.getResultValue());
        if (appSearchSessionM1026d != null) {
            appSearchSessionM1026d.setSchema(setSchemaRequest, executorService, executorService, new C7016c());
            appSearchSessionM1026d.put(putDocumentsRequest, executorService, new C7015b(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void putDocument$lambda$3$lambda$2$lambda$0(AppSearchResult appSearchResult) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDocument$lambda$12(RemoveByDocumentIdRequest removeByDocumentIdRequest, ExecutorService executorService, AppSearchResult appSearchResult) {
        Intrinsics.checkNotNullParameter(removeByDocumentIdRequest, "$removeByDocumentIdRequest");
        AppSearchSession appSearchSessionM1026d = AbstractC0570e.m1026d(appSearchResult.getResultValue());
        if (appSearchSessionM1026d != null) {
            appSearchSessionM1026d.remove(removeByDocumentIdRequest, executorService, new C7015b(2));
        }
    }

    @RequiresApi(33)
    private final void removeOldDocument() {
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(this.context.getSystemService(AbstractC0570e.m1033k()));
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        AppSearchManager.SearchContext searchContextBuild = AbstractC4744a.m3462b().build();
        Intrinsics.checkNotNullExpressionValue(searchContextBuild, "Builder(DATABASE_NAME).build()");
        SearchSpec searchSpecBuild = AbstractC0568e.m995c().setResultCountPerPage(10000).setRankingStrategy(2).build();
        Intrinsics.checkNotNullExpressionValue(searchSpecBuild, "Builder()\n            .s…AMP)\n            .build()");
        appSearchManagerM1025c.createSearchSession(searchContextBuild, executorServiceNewSingleThreadExecutor, new C7014a(searchSpecBuild, executorServiceNewSingleThreadExecutor, this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeOldDocument$lambda$9(SearchSpec searchSpec, ExecutorService executorService, AppSearchImpl this$0, AppSearchResult appSearchResult) {
        Intrinsics.checkNotNullParameter(searchSpec, "$searchSpec");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppSearchSession appSearchSessionM1026d = AbstractC0570e.m1026d(appSearchResult.getResultValue());
        if (appSearchSessionM1026d != null) {
            SearchResults searchResultsSearch = appSearchSessionM1026d.search("", searchSpec);
            Intrinsics.checkNotNullExpressionValue(searchResultsSearch, "appSearchSession.search(\"\", searchSpec)");
            searchResultsSearch.getNextPage(executorService, new C7014a(this$0, appSearchSessionM1026d, executorService));
            searchResultsSearch.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeOldDocument$lambda$9$lambda$8$lambda$7(AppSearchImpl this$0, AppSearchSession appSearchSession, ExecutorService executorService, AppSearchResult appSearchResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appSearchSession, "$appSearchSession");
        List list = (List) appSearchResult.getResultValue();
        if (list != null) {
            List listDrop = CollectionsKt.drop(list, 15);
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listDrop));
            Iterator it = listDrop.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC0570e.m1029g(it.next()).getGenericDocument().getId());
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AbstractC0573h.m1052D();
            RemoveByDocumentIdRequest removeByDocumentIdRequestBuild = AbstractC0573h.m1063k(this$0.context.getPackageName()).addIds(arrayList).build();
            Intrinsics.checkNotNullExpressionValue(removeByDocumentIdRequestBuild, "Builder(context.packageN…                 .build()");
            appSearchSession.remove(removeByDocumentIdRequestBuild, executorService, new C7015b(0));
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AppSearch
    @RequiresApi(33)
    public boolean putDocument(@NotNull AppSearchSchema appSearchSchema, @NotNull GenericDocument document, @NotNull List<Integer> permissions, boolean permittedSssOnly) {
        Intrinsics.checkNotNullParameter(appSearchSchema, "appSearchSchema");
        Intrinsics.checkNotNullParameter(document, "document");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        removeOldDocument();
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(this.context.getSystemService(AbstractC0570e.m1033k()));
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        AppSearchManager.SearchContext searchContextBuild = AbstractC4744a.m3462b().build();
        Intrinsics.checkNotNullExpressionValue(searchContextBuild, "Builder(DATABASE_NAME).build()");
        SetSchemaRequest.Builder builderM999g = AbstractC0568e.m999g();
        builderM999g.addSchemas(appSearchSchema);
        builderM999g.setForceOverride(true);
        if (permittedSssOnly) {
            String schemaType = appSearchSchema.getSchemaType();
            AbstractC0568e.m1007o();
            builderM999g.setSchemaTypeVisibilityForPackage(schemaType, true, AbstractC4744a.m3469i(INSTANCE.getSha256Certificate(this.context)));
        } else {
            builderM999g.addRequiredPermissionsForSchemaTypeVisibility(appSearchSchema.getSchemaType(), CollectionsKt.toSet(permissions));
        }
        SetSchemaRequest setSchemaRequestBuild = builderM999g.build();
        Intrinsics.checkNotNullExpressionValue(setSchemaRequestBuild, "setSchemaRequestBuilder.build()");
        PutDocumentsRequest putDocumentsRequestBuild = AbstractC0565b.m935i().addGenericDocuments(document).build();
        Intrinsics.checkNotNullExpressionValue(putDocumentsRequestBuild, "Builder()\n            .a…ent)\n            .build()");
        appSearchManagerM1025c.createSearchSession(searchContextBuild, executorServiceNewSingleThreadExecutor, new C7014a(setSchemaRequestBuild, executorServiceNewSingleThreadExecutor, putDocumentsRequestBuild, 0));
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.samsung.android.app.sdk.deepsky.common.d] */
    @Override // com.samsung.android.app.sdk.deepsky.common.AppSearch
    @RequiresApi(33)
    public boolean removeDocument(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AppSearchManager appSearchManagerM1025c = AbstractC0570e.m1025c(this.context.getSystemService(AbstractC0570e.m1033k()));
        final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        AppSearchManager.SearchContext searchContextBuild = AbstractC4744a.m3462b().build();
        Intrinsics.checkNotNullExpressionValue(searchContextBuild, "Builder(DATABASE_NAME).build()");
        AbstractC0573h.m1052D();
        final RemoveByDocumentIdRequest removeByDocumentIdRequestBuild = AbstractC0573h.m1063k(this.context.getPackageName()).addIds(id).build();
        Intrinsics.checkNotNullExpressionValue(removeByDocumentIdRequestBuild, "Builder(context.packageN…(id)\n            .build()");
        appSearchManagerM1025c.createSearchSession(searchContextBuild, executorServiceNewSingleThreadExecutor, new Consumer() { // from class: com.samsung.android.app.sdk.deepsky.common.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AppSearchImpl.removeDocument$lambda$12(removeByDocumentIdRequestBuild, executorServiceNewSingleThreadExecutor, (AppSearchResult) obj);
            }
        });
        return true;
    }
}
