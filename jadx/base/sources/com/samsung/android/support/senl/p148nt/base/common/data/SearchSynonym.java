package com.samsung.android.support.senl.p148nt.base.common.data;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonym;", "", "<init>", "()V", "getSynonyms", "", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchSynonym {

    @NotNull
    public static final SearchSynonym INSTANCE = new SearchSynonym();

    private SearchSynonym() {
    }

    @JvmStatic
    @NotNull
    public static final Set<String> getSynonyms(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return CollectionsKt.toSet(CollectionsKt.toMutableList((Collection) SearchSynonymManager.INSTANCE.getInstance().getSearchKeyword(keyword)));
    }
}
