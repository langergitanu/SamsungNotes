package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.SearchResult;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.platformstorage.AbstractC0570e;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SearchResultToPlatformConverter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(33)
    public static class ApiHelperForT {
        private ApiHelperForT() {
        }

        @DoNotInline
        public static int getSubmatchRangeEnd(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getEnd();
        }

        @DoNotInline
        public static int getSubmatchRangeStart(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getStart();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    public static class ApiHelperForU {
        private ApiHelperForU() {
        }

        @DoNotInline
        public static List<SearchResult> getJoinedResults(SearchResult searchResult) {
            return searchResult.getJoinedResults();
        }
    }

    private SearchResultToPlatformConverter() {
    }

    private static SearchResult.MatchInfo toJetpackMatchInfo(SearchResult.MatchInfo matchInfo) {
        Preconditions.checkNotNull(matchInfo);
        SearchResult.MatchInfo.Builder snippetRange = new SearchResult.MatchInfo.Builder(matchInfo.getPropertyPath()).setExactMatchRange(new SearchResult.MatchRange(matchInfo.getExactMatchRange().getStart(), matchInfo.getExactMatchRange().getEnd())).setSnippetRange(new SearchResult.MatchRange(matchInfo.getSnippetRange().getStart(), matchInfo.getSnippetRange().getEnd()));
        if (Build.VERSION.SDK_INT >= 33) {
            snippetRange.setSubmatchRange(new SearchResult.MatchRange(ApiHelperForT.getSubmatchRangeStart(matchInfo), ApiHelperForT.getSubmatchRangeEnd(matchInfo)));
        }
        return snippetRange.build();
    }

    public static androidx.appsearch.app.SearchResult toJetpackSearchResult(android.app.appsearch.SearchResult searchResult) {
        Preconditions.checkNotNull(searchResult);
        SearchResult.Builder rankingSignal = new SearchResult.Builder(searchResult.getPackageName(), searchResult.getDatabaseName()).setGenericDocument(GenericDocumentToPlatformConverter.toJetpackGenericDocument(searchResult.getGenericDocument())).setRankingSignal(searchResult.getRankingSignal());
        List matchInfos = searchResult.getMatchInfos();
        for (int i = 0; i < matchInfos.size(); i++) {
            rankingSignal.addMatchInfo(toJetpackMatchInfo(AbstractC0567d.m972f(matchInfos.get(i))));
        }
        if (Build.VERSION.SDK_INT >= 34) {
            Iterator<android.app.appsearch.SearchResult> it = ApiHelperForU.getJoinedResults(searchResult).iterator();
            while (it.hasNext()) {
                rankingSignal.addJoinedResult(toJetpackSearchResult(AbstractC0570e.m1029g(it.next())));
            }
        }
        return rankingSignal.build();
    }
}
