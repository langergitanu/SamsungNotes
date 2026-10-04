package androidx.appsearch.platformstorage.converter;

import android.annotation.SuppressLint;
import android.app.appsearch.JoinSpec;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.platformstorage.AbstractC0575j;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JoinSpecToPlatformConverter {
    private JoinSpecToPlatformConverter() {
    }

    @SuppressLint({"WrongConstant"})
    public static JoinSpec toPlatformJoinSpec(androidx.appsearch.app.JoinSpec joinSpec) {
        Preconditions.checkNotNull(joinSpec);
        AbstractC0575j.m1095m();
        return AbstractC0575j.m1087e(joinSpec.getChildPropertyExpression()).setNestedSearch(joinSpec.getNestedQuery(), SearchSpecToPlatformConverter.toPlatformSearchSpec(joinSpec.getNestedSearchSpec())).setMaxJoinedResultCount(joinSpec.getMaxJoinedResultCount()).setAggregationScoringStrategy(joinSpec.getAggregationScoringStrategy()).build();
    }
}
