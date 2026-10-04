package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSearchManager {
    public static final String FINDER_SEARCH_BODY_CONTENT = "suggest_text_2";
    public static final String FINDER_SEARCH_THUMBNAIL = "suggest_icon_1";
    public static final String FINDER_SEARCH_TITLE = "suggest_text_1";
    private static final String SUGGEST_COLUMN_EXTRA = "suggest_extra_flags";
    private static final String SUGGEST_COLUMN_MIME_TYPE = "suggest_mime_type";
    private static final String SUGGEST_COLUMN_TEXT_3 = "suggest_text_3";
    private static final String SUGGEST_COLUMN_URI = "suggest_uri";
    private static final String TAG = DataLogger.createTag("NotesSearchManager");
    private static ISearchManagerHelper sSearchManagerHelper = new SearchManagerHelper();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISearchManagerHelper {
        Object getField(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SearchManagerHelper implements ISearchManagerHelper {
        @Override // com.samsung.android.support.senl.nt.data.database.core.query.search.NotesSearchManager.ISearchManagerHelper
        public Object getField(@NonNull String str) {
            return Class.forName("android.app.SearchManager").getField(str).get(null);
        }
    }

    public static String get_SUGGEST_COLUMN_EXTRA() {
        try {
            return sSearchManagerHelper.getField("SUGGEST_COLUMN_EXTRA").toString();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("get_SUGGEST_COLUMN_EXTRA, e : "), TAG);
            return SUGGEST_COLUMN_EXTRA;
        }
    }

    public static String get_SUGGEST_COLUMN_MIME_TYPE() {
        try {
            return sSearchManagerHelper.getField("SUGGEST_COLUMN_MIME_TYPE").toString();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("get_SUGGEST_COLUMN_MIME_TYPE, e : "), TAG);
            return SUGGEST_COLUMN_MIME_TYPE;
        }
    }

    public static String get_SUGGEST_COLUMN_TEXT_3() {
        try {
            return sSearchManagerHelper.getField("SUGGEST_COLUMN_TEXT_3").toString();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("get_SUGGEST_COLUMN_TEXT_3, e : "), TAG);
            return SUGGEST_COLUMN_TEXT_3;
        }
    }

    public static String get_SUGGEST_COLUMN_URI() {
        try {
            return sSearchManagerHelper.getField("SUGGEST_COLUMN_URI").toString();
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("get_SUGGEST_COLUMN_URI, e : "), TAG);
            return SUGGEST_COLUMN_URI;
        }
    }

    @VisibleForTesting
    public static void setSearchManagerHelper(ISearchManagerHelper iSearchManagerHelper) {
        sSearchManagerHelper = iSearchManagerHelper;
    }
}
