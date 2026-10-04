package com.samsung.android.support.senl.p148nt.data.common.utils;

import androidx.annotation.NonNull;
import androidx.window.embedding.C4013a;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchUtils {
    private static final String TAG = DataLogger.createTag("SearchUtils");
    private static String sCoverTemplateUuidsWithSummaryAndCategory;
    private static long sRequestedTime;
    private static final Set<String> sSearchResults;
    private static final Set<String> sTargetContents;

    static {
        HashSet hashSet = new HashSet();
        sTargetContents = hashSet;
        sSearchResults = new HashSet();
        hashSet.add(SearchConstants.TargetContents.TITLE);
        hashSet.add(SearchConstants.TargetContents.BODY_TEXT);
        hashSet.add(SearchConstants.TargetContents.TAG);
        hashSet.add(SearchConstants.TargetContents.STROKE);
        hashSet.add(SearchConstants.TargetContents.COVER_SUMMARY);
        hashSet.add(SearchConstants.TargetContents.STT_CONTENT);
    }

    public static int getArgCountInTotalQuery(boolean z) {
        return sTargetContents.size() + (z ? 1 : 0);
    }

    @NonNull
    public static synchronized String getCoverTemplateUuidsWithSummaryAndCategoryQuery() {
        try {
            if (sCoverTemplateUuidsWithSummaryAndCategory == null) {
                sCoverTemplateUuidsWithSummaryAndCategory = QueryUtils.getCommaSeparatedString(CoverConstants.getCoverTemplateUuidsWithSummaryAndCategory());
            }
        } catch (Throwable th) {
            throw th;
        }
        return sCoverTemplateUuidsWithSummaryAndCategory;
    }

    public static synchronized Collection<String> getDocumentUuidsInSearchResult(@NonNull Collection<String> collection) {
        Stream<String> stream;
        Set<String> set;
        stream = collection.stream();
        set = sSearchResults;
        Objects.requireNonNull(set);
        return (Collection) stream.filter(new C4013a(set, 2)).collect(Collectors.toSet());
    }

    public static boolean isSemanticSearchable(@NonNull String str) {
        return str.length() > 4 || str.contains(" ");
    }

    public static boolean isTargetContent(@SearchConstants.TargetContents String str) {
        return sTargetContents.contains(str);
    }

    public static synchronized boolean isValidRequestedTime(long j) {
        boolean z;
        z = j >= sRequestedTime;
        if (!z) {
            DataLogger.m12309w(TAG, "[Semantic] invalid request/prev: " + j + " / " + sRequestedTime);
        }
        return z;
    }

    public static synchronized void setRequestedTime(long j) {
        sRequestedTime = j;
    }

    public static synchronized void updateResults(@NonNull Collection<String> collection) {
        Set<String> set = sSearchResults;
        set.clear();
        set.addAll(collection);
    }
}
