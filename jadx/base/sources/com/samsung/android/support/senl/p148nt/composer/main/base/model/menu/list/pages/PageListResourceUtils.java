package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListResourceUtils {
    private static String ADD_PAGE_DESCRIPTION = "";
    private static String BOOKMARK_DESCRIPTION = "";
    private static String BOOKMARK_OFF_DESCRIPTION = "";
    private static String BOOKMARK_ON_DESCRIPTION = "";
    private static String SORT_PAGE_DESCRIPTION = "";

    public static String getAddPageDescription() {
        return ADD_PAGE_DESCRIPTION;
    }

    public static String getBookmarkOnOffDescription(boolean z) {
        return z ? BOOKMARK_ON_DESCRIPTION : BOOKMARK_OFF_DESCRIPTION;
    }

    public static String getPageDescription() {
        return SORT_PAGE_DESCRIPTION;
    }

    public static String getPageDescriptionWithBookmark() {
        return BOOKMARK_DESCRIPTION + SQLKeyword.COMMA + SORT_PAGE_DESCRIPTION;
    }

    public static void setDescriptions(Context context) {
        SORT_PAGE_DESCRIPTION = context.getString(C9086R.string.composer_sort_pages);
        BOOKMARK_DESCRIPTION = context.getString(C9086R.string.composer_bookmark);
        BOOKMARK_ON_DESCRIPTION = BOOKMARK_DESCRIPTION + " " + context.getString(C9086R.string.f6723on);
        BOOKMARK_OFF_DESCRIPTION = BOOKMARK_DESCRIPTION + " " + context.getString(C9086R.string.off);
        ADD_PAGE_DESCRIPTION = context.getString(C9086R.string.composer_ctx_menu_add_page);
    }
}
