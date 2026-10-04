package com.samsung.android.support.senl.p148nt.app.provider.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.model.domain.search.FinderSearchNoteUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\f2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/provider/helper/OldFinderSearchHelper;", "", "<init>", "()V", "search", "Landroid/database/Cursor;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "selectionArgs", "", "", "(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;)Landroid/database/Cursor;", "getQuery", "([Ljava/lang/String;)Ljava/lang/String;", "getLimit", "", "getModifiedTimeCondition", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldFinderSearchHelper {

    @NotNull
    private static final String KEY_END_TIME = "etime";

    @NotNull
    private static final String KEY_LIMIT = "limit";

    @NotNull
    private static final String KEY_START_TIME = "stime";

    @NotNull
    private static final String OLD_FINDER_END_CHAR_OF_KEYWORD = "\n";

    @NotNull
    private static final String OLD_FINDER_KEYWORD_SEPARATOR = "&";

    @NotNull
    private static final String TAG = "OldFinderSearchHelper";

    private final int getLimit(Uri uri) {
        Integer intOrNull;
        String queryParameter = uri.getQueryParameter("limit");
        if (queryParameter == null || (intOrNull = StringsKt.toIntOrNull(queryParameter)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    private final String getModifiedTimeCondition(Uri uri) {
        String queryParameter = uri.getQueryParameter(KEY_START_TIME);
        String queryParameter2 = uri.getQueryParameter(KEY_END_TIME);
        return (queryParameter == null || queryParameter2 == null) ? "" : AbstractC0541b.m774p("lastModifiedAt >= ", queryParameter, " AND lastModifiedAt <= ", queryParameter2);
    }

    private final String getQuery(String[] selectionArgs) {
        String str;
        return (selectionArgs == null || selectionArgs.length == 0 || (str = selectionArgs[0]) == null || str.length() == 0) ? "" : StringsKt.m14139M(StringsKt.m14139M(str, "\n", ""), "&", " ");
    }

    @Nullable
    public final Cursor search(@NotNull Context context, @NotNull Uri uri, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Logger.m8697d(TAG, "search");
        try {
            NotesSearchRepository notesSearchRepositoryCreateSearchRepository = NotesDataRepositoryFactory.newInstance(context).createSearchRepository();
            Intrinsics.checkNotNullExpressionValue(notesSearchRepositoryCreateSearchRepository, "createSearchRepository(...)");
            return new FinderSearchNoteUseCase(notesSearchRepositoryCreateSearchRepository).invoke(new FinderSearchNoteUseCase.Param(getQuery(selectionArgs), getLimit(uri), getModifiedTimeCondition(uri)));
        } catch (SQLException e) {
            AbstractC4539a.m3214x("search, e: ", e.getMessage(), TAG);
            throw e;
        }
    }
}
