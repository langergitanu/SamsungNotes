package com.samsung.android.lib.galaxyfinder.search.util;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/util/SearchQueryUtils;", "", "()V", "getLimit", "", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)Ljava/lang/Integer;", "getQuery", "", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SearchQueryUtils {

    @NotNull
    public static final SearchQueryUtils INSTANCE = new SearchQueryUtils();

    private SearchQueryUtils() {
    }

    @Nullable
    public final Integer getLimit(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            String queryParameter = uri.getQueryParameter("limit");
            if (queryParameter != null) {
                return Integer.valueOf(Integer.parseInt(queryParameter));
            }
            return null;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Nullable
    public final String getQuery(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            return Uri.decode(uri.getQueryParameter("query"));
        } catch (Exception unused) {
            return null;
        }
    }
}
