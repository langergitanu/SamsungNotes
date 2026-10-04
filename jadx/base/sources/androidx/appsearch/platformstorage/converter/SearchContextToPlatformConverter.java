package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.AppSearchManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.PlatformStorage;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SearchContextToPlatformConverter {
    private SearchContextToPlatformConverter() {
    }

    public static AppSearchManager.SearchContext toPlatformSearchContext(PlatformStorage.SearchContext searchContext) {
        Preconditions.checkNotNull(searchContext);
        AbstractC0567d.m988v();
        return AbstractC0567d.m970d(searchContext.getDatabaseName()).build();
    }
}
