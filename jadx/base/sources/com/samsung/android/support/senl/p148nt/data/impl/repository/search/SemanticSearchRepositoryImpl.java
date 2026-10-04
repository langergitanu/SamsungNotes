package com.samsung.android.support.senl.p148nt.data.impl.repository.search;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCallback;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupInvitationContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.repository.search.SemanticSearchRepository;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl;", "Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository;", "<init>", "()V", "search", "Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository$Result;", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", GroupInvitationContract.Invitation.REQUESTED_TIME, "", "limit", "", "filterParam", "Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SearchFilterParam;", "checkStatus", "", "isReadyForSearch", "createQueryArgs", "Landroid/os/Bundle;", "setFilter", "", "queryArgs", "getContentType", "", "contains", "contentFilter", "filterType", "cancel", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSemanticSearchRepositoryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticSearchRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,284:1\n37#2:285\n36#2,3:286\n29#3:289\n*S KotlinDebug\n*F\n+ 1 SemanticSearchRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl\n*L\n156#1:285\n156#1:286,3\n201#1:289\n*E\n"})
public final class SemanticSearchRepositoryImpl implements SemanticSearchRepository {

    @NotNull
    private static final String AUTHORITY = "com.samsung.android.smartsuggestions.search";

    @NotNull
    private static final Uri AUTHORITY_URI;
    private static final float KEYWORD_SEARCH_SCORE_WITHOUT_QP = 10000.0f;
    private static final float KEYWORD_SEARCH_SCORE_WITH_QP = 100.0f;

    @NotNull
    private static final String KEY_CONTEXTUAL_KEYWORDS = "contextual_keywords";

    @NotNull
    private static final String KEY_FILTER_CONTENT_TYPE = "query-arg-filter-content-types";

    @NotNull
    private static final String KEY_FILTER_DATE_RANGE = "query-arg-filter-date-range";

    @NotNull
    private static final String KEY_INDEXING_STATUS = "index_status";

    @NotNull
    private static final String KEY_REPHASE_STRING = "rephaseString";

    @NotNull
    private static final String KEY_SIMILARITY = "similarity";

    @NotNull
    private static final String KEY_STATUS = "status";

    @NotNull
    private static final String METHOD_INDEX_STATUS = "get_index_status";

    @NotNull
    private static final String METHOD_IS_DATA_CONFIG_ENABLED = "is_data_config_enabled";

    @NotNull
    private static final String METHOD_IS_SEMANTIC_SEARCH_SUPPORTED = "is_semantic_search_supported";

    @NotNull
    private static final Uri NOTES_URI;

    @NotNull
    private static final Uri V1_URI;

    @NotNull
    private static final ArrayList<CancellationSignal> signals;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = DataLogger.createTag("SemanticSearchRepositoryImpl");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0007J\u0016\u0010#\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0007J\b\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020%H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "AUTHORITY", "AUTHORITY_URI", "Landroid/net/Uri;", "V1_URI", "NOTES_URI", "KEY_SIMILARITY", "KEY_REPHASE_STRING", "KEY_CONTEXTUAL_KEYWORDS", "KEY_FILTER_DATE_RANGE", "KEY_FILTER_CONTENT_TYPE", "METHOD_IS_DATA_CONFIG_ENABLED", "METHOD_INDEX_STATUS", "METHOD_IS_SEMANTIC_SEARCH_SUPPORTED", "KEY_INDEXING_STATUS", ContinuityCallback.KEY_STATUS, "KEYWORD_SEARCH_SCORE_WITHOUT_QP", "", "KEYWORD_SEARCH_SCORE_WITH_QP", "signals", "Ljava/util/ArrayList;", "Landroid/os/CancellationSignal;", "Lkotlin/collections/ArrayList;", "createDefaultSearchQueryArgs", "Landroid/os/Bundle;", "requestUpdate", "", "uuids", "", "requestDelete", "isAllowedToCollectPersonalData", "", "isSemanticSearchCoreLibInstalled", "EngineStatus", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSemanticSearchRepositoryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SemanticSearchRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,284:1\n37#2:285\n36#2,3:286\n37#2:289\n36#2,3:290\n*S KotlinDebug\n*F\n+ 1 SemanticSearchRepositoryImpl.kt\ncom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl$Companion\n*L\n238#1:285\n238#1:286,3\n249#1:289\n249#1:290,3\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl$Companion$EngineStatus;", "", "Companion", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface EngineStatus {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = Companion.$$INSTANCE;

            @NotNull
            public static final String READY = "ready";

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/impl/repository/search/SemanticSearchRepositoryImpl$Companion$EngineStatus$Companion;", "", "<init>", "()V", "READY", "", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();

                @NotNull
                public static final String READY = "ready";

                private Companion() {
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Bundle createDefaultSearchQueryArgs() {
            Bundle bundle = new Bundle();
            bundle.putInt("android:query-arg-limit", 1000);
            return bundle;
        }

        @JvmStatic
        public final boolean isAllowedToCollectPersonalData() {
            if (!SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
                return true;
            }
            Bundle bundleCall = DataUtils.getContext().getContentResolver().call(SemanticSearchRepositoryImpl.NOTES_URI, SemanticSearchRepositoryImpl.METHOD_IS_DATA_CONFIG_ENABLED, "com.samsung.android.app.notes", (Bundle) null);
            if (!Intrinsics.areEqual(bundleCall != null ? Boolean.valueOf(bundleCall.getBoolean("com.samsung.android.app.notes")) : null, Boolean.FALSE)) {
                return true;
            }
            DataLogger.m12307i(SemanticSearchRepositoryImpl.TAG, "[Semantic] isAllowedToCollectPersonalData, SSE is disabled");
            return false;
        }

        @JvmStatic
        public final boolean isSemanticSearchCoreLibInstalled() {
            Bundle bundleCall = DataUtils.getContext().getContentResolver().call(SemanticSearchRepositoryImpl.AUTHORITY_URI, SemanticSearchRepositoryImpl.METHOD_IS_SEMANTIC_SEARCH_SUPPORTED, "", (Bundle) null);
            if (bundleCall == null) {
                DataLogger.m12307i(SemanticSearchRepositoryImpl.TAG, "[Semantic] isSemanticSearchCoreLibInstalled, null");
                return false;
            }
            boolean z = bundleCall.getBoolean("status");
            if (!z) {
                DataLogger.m12307i(SemanticSearchRepositoryImpl.TAG, "[Semantic] isSemanticSearchCoreLibInstalled, false");
            }
            return z;
        }

        @JvmStatic
        public final void requestDelete(@NotNull Collection<String> uuids) {
            Intrinsics.checkNotNullParameter(uuids, "uuids");
            try {
                int iDelete = DataUtils.getContext().getContentResolver().delete(SemanticSearchRepositoryImpl.NOTES_URI, "UUID", (String[]) uuids.toArray(new String[0]));
                DataLogger.m12302d(SemanticSearchRepositoryImpl.TAG, "[Semantic] requestDelete: " + iDelete);
            } catch (RuntimeException e) {
                AbstractC11014a.m12314C("[Semantic] requestDelete, e: ", e.getMessage(), SemanticSearchRepositoryImpl.TAG);
            }
        }

        @JvmStatic
        public final void requestUpdate(@NotNull Collection<String> uuids) {
            Intrinsics.checkNotNullParameter(uuids, "uuids");
            try {
                int iUpdate = DataUtils.getContext().getContentResolver().update(SemanticSearchRepositoryImpl.NOTES_URI, new ContentValues(), "UUID", (String[]) uuids.toArray(new String[0]));
                DataLogger.m12302d(SemanticSearchRepositoryImpl.TAG, "[Semantic] requestUpdate: " + iUpdate);
            } catch (RuntimeException e) {
                AbstractC11014a.m12314C("[Semantic] requestUpdate, e: ", e.getMessage(), SemanticSearchRepositoryImpl.TAG);
            }
        }

        private Companion() {
        }
    }

    static {
        Uri uri = Uri.parse("content://com.samsung.android.smartsuggestions.search");
        AUTHORITY_URI = uri;
        Uri uriWithAppendedPath = Uri.withAppendedPath(uri, "v1");
        Intrinsics.checkNotNullExpressionValue(uriWithAppendedPath, "withAppendedPath(...)");
        V1_URI = uriWithAppendedPath;
        Uri uriWithAppendedPath2 = Uri.withAppendedPath(uriWithAppendedPath, Privacy.KEY_NOTES);
        Intrinsics.checkNotNullExpressionValue(uriWithAppendedPath2, "withAppendedPath(...)");
        NOTES_URI = uriWithAppendedPath2;
        signals = new ArrayList<>();
    }

    private final void cancel() {
        ArrayList<CancellationSignal> arrayList = signals;
        synchronized (arrayList) {
            try {
                if (!arrayList.isEmpty()) {
                    DataLogger.m12302d(TAG, "[Semantic] cancel");
                    arrayList.get(0).cancel();
                    arrayList.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean checkStatus() {
        try {
            if (!INSTANCE.isAllowedToCollectPersonalData()) {
                return false;
            }
            if (isReadyForSearch()) {
                return true;
            }
        } catch (RuntimeException e) {
            AbstractC11014a.m12314C("[Semantic] checkStatus, e: ", e.getMessage(), TAG);
        }
        return false;
    }

    private final boolean contains(int contentFilter, @SearchConstants.ContentFilter int filterType) {
        return (contentFilter & filterType) != 0;
    }

    @JvmStatic
    @NotNull
    public static final Bundle createDefaultSearchQueryArgs() {
        return INSTANCE.createDefaultSearchQueryArgs();
    }

    private final Bundle createQueryArgs(String keyword, SearchFilterParam filterParam) {
        Bundle bundleCreateDefaultSearchQueryArgs = INSTANCE.createDefaultSearchQueryArgs();
        bundleCreateDefaultSearchQueryArgs.putString("android:query-arg-sql-selection", keyword);
        setFilter(bundleCreateDefaultSearchQueryArgs, filterParam);
        return bundleCreateDefaultSearchQueryArgs;
    }

    @JvmStatic
    public static final boolean isAllowedToCollectPersonalData() {
        return INSTANCE.isAllowedToCollectPersonalData();
    }

    private final boolean isReadyForSearch() {
        Bundle bundleCall = DataUtils.getContext().getContentResolver().call(NOTES_URI, METHOD_INDEX_STATUS, "com.samsung.android.app.notes", (Bundle) null);
        if (bundleCall == null) {
            return false;
        }
        String string = bundleCall.getString(KEY_INDEXING_STATUS);
        if (Intrinsics.areEqual("ready", string)) {
            return true;
        }
        AbstractC0000a.m2C("[Semantic] checkStatus: ", string, TAG);
        return false;
    }

    @JvmStatic
    public static final boolean isSemanticSearchCoreLibInstalled() {
        return INSTANCE.isSemanticSearchCoreLibInstalled();
    }

    @JvmStatic
    public static final void requestDelete(@NotNull Collection<String> collection) {
        INSTANCE.requestDelete(collection);
    }

    @JvmStatic
    public static final void requestUpdate(@NotNull Collection<String> collection) {
        INSTANCE.requestUpdate(collection);
    }

    private final void setFilter(Bundle queryArgs, SearchFilterParam filterParam) {
        List<String> contentType = getContentType(filterParam);
        if (!contentType.isEmpty()) {
            queryArgs.putStringArray(KEY_FILTER_CONTENT_TYPE, (String[]) contentType.toArray(new String[0]));
        }
        if (filterParam.getFromTime() <= 0 || filterParam.getToTime() <= 0 || filterParam.getToTime() <= filterParam.getFromTime()) {
            return;
        }
        queryArgs.putLongArray(KEY_FILTER_DATE_RANGE, new long[]{filterParam.getFromTime(), filterParam.getToTime()});
    }

    @NotNull
    public final List<String> getContentType(@NotNull SearchFilterParam filterParam) {
        Intrinsics.checkNotNullParameter(filterParam, "filterParam");
        ArrayList arrayList = new ArrayList();
        int contentType = filterParam.getContentType();
        if (contentType != 0) {
            if (contains(contentType, 1)) {
                arrayList.add(ExternalDataConstants.SearchFilter.HAS_TITLE);
            }
            if (contains(contentType, 2)) {
                arrayList.add(ExternalDataConstants.SearchFilter.HAS_VOICE);
            }
        }
        if (!Intrinsics.areEqual(CoverStickerConstants.Category.NONE.UUID, filterParam.getCoverSticker())) {
            arrayList.add(ExternalDataConstants.SearchFilter.COVER_STICKER + filterParam.getCoverSticker());
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.repository.search.SemanticSearchRepository
    @NotNull
    public SemanticSearchRepository.Result search(@NotNull String keyword, long requestedTime, int limit, @NotNull SearchFilterParam filterParam) {
        ArrayList<CancellationSignal> arrayList;
        float f;
        String string;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(filterParam, "filterParam");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!SearchUtils.isValidRequestedTime(requestedTime)) {
            return new SemanticSearchRepository.Result(linkedHashMap, "");
        }
        cancel();
        if (!checkStatus()) {
            return new SemanticSearchRepository.Result(linkedHashMap, "");
        }
        String[] strArr = {"UUID"};
        Bundle bundleCreateQueryArgs = createQueryArgs(keyword, filterParam);
        CancellationSignal cancellationSignal = new CancellationSignal();
        ArrayList<CancellationSignal> arrayList2 = signals;
        synchronized (arrayList2) {
            arrayList2.add(cancellationSignal);
        }
        String str = "";
        try {
            try {
                Cursor cursorQuery = DataUtils.getContext().getContentResolver().query(NOTES_URI, strArr, bundleCreateQueryArgs, cancellationSignal);
                try {
                    Cursor cursor = cursorQuery;
                    if (cursor == null || !cursor.moveToFirst()) {
                        DataLogger.m12302d(TAG, "[Semantic] empty result");
                        Unit unit = Unit.INSTANCE;
                    } else {
                        String str2 = TAG;
                        DataLogger.m12302d(str2, "[Semantic] search, result: " + cursor.getCount());
                        int columnIndex = cursor.getColumnIndex("UUID");
                        int columnIndex2 = cursor.getColumnIndex(KEY_SIMILARITY);
                        if (columnIndex >= 0) {
                            while (true) {
                                String string2 = cursor.getString(columnIndex);
                                if (string2 != null) {
                                    if (columnIndex2 < 0 || (string = cursor.getString(columnIndex2)) == null) {
                                        f = 0.0f;
                                    } else {
                                        try {
                                            f = Float.parseFloat(string);
                                        } catch (NumberFormatException e) {
                                            DataLogger.m12303e(TAG, "[Semantic] fail to convert Float, e: " + e.getMessage());
                                        }
                                    }
                                    linkedHashMap.put(string2, new SemanticSearchRepository.Result.Note(string2, f == 0.0f ? 0 : f == 10000.0f ? 1 : f == 100.0f ? 2 : 3, f));
                                }
                                if (!cursor.moveToNext() || (limit > 0 && linkedHashMap.size() >= limit)) {
                                    break;
                                }
                            }
                            String string3 = cursor.getExtras().getString(KEY_REPHASE_STRING);
                            if (string3 != null) {
                                JSONObject jSONObject = new JSONObject(string3);
                                if (jSONObject.has(KEY_CONTEXTUAL_KEYWORDS)) {
                                    String string4 = jSONObject.getString(KEY_CONTEXTUAL_KEYWORDS);
                                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                    try {
                                        DataLogger.m12307i(TAG, "[Semantic] contextualKeyword: " + DataLogger.getEncode(string4));
                                        str = string4;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            CloseableKt.closeFinally(cursorQuery, th);
                                            throw th2;
                                        }
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } else {
                            DataLogger.m12303e(str2, "[Semantic] uuidIndex is wrong: " + columnIndex);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                    CloseableKt.closeFinally(cursorQuery, null);
                    arrayList = signals;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (RuntimeException e2) {
                DataLogger.m12303e(TAG, "[Semantic] search, e: " + e2.getMessage());
                arrayList = signals;
                synchronized (arrayList) {
                    arrayList.clear();
                    Unit unit4 = Unit.INSTANCE;
                }
            }
            synchronized (arrayList) {
                arrayList.clear();
                Unit unit5 = Unit.INSTANCE;
                return new SemanticSearchRepository.Result(linkedHashMap, str);
            }
        } catch (Throwable th4) {
            ArrayList<CancellationSignal> arrayList3 = signals;
            synchronized (arrayList3) {
                arrayList3.clear();
                Unit unit6 = Unit.INSTANCE;
                throw th4;
            }
        }
    }
}
