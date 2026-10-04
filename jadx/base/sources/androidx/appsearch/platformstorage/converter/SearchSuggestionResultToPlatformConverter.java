package androidx.appsearch.platformstorage.converter;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.SearchSuggestionResult;
import androidx.appsearch.platformstorage.AbstractC0575j;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SearchSuggestionResultToPlatformConverter {
    private SearchSuggestionResultToPlatformConverter() {
    }

    public static List<SearchSuggestionResult> toJetpackSearchSuggestionResults(List<android.app.appsearch.SearchSuggestionResult> list) {
        Preconditions.checkNotNull(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new SearchSuggestionResult.Builder().setSuggestedResult(AbstractC0575j.m1089g(list.get(i)).getSuggestedResult()).build());
        }
        return arrayList;
    }
}
