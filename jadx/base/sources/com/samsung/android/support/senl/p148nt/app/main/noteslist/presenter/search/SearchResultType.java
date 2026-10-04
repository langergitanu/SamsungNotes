package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "DB", "KEYWORD", "KEYWORD_ETC", "SEMANTIC", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchResultType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SearchResultType[] $VALUES;
    public static final SearchResultType NONE = new SearchResultType(CoverStickerConstants.Category.NONE.NAME, 0);

    /* JADX INFO: renamed from: DB */
    public static final SearchResultType f6227DB = new SearchResultType("DB", 1);
    public static final SearchResultType KEYWORD = new SearchResultType("KEYWORD", 2);
    public static final SearchResultType KEYWORD_ETC = new SearchResultType("KEYWORD_ETC", 3);
    public static final SearchResultType SEMANTIC = new SearchResultType("SEMANTIC", 4);

    private static final /* synthetic */ SearchResultType[] $values() {
        return new SearchResultType[]{NONE, f6227DB, KEYWORD, KEYWORD_ETC, SEMANTIC};
    }

    static {
        SearchResultType[] searchResultTypeArr$values = $values();
        $VALUES = searchResultTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(searchResultTypeArr$values);
    }

    private SearchResultType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<SearchResultType> getEntries() {
        return $ENTRIES;
    }

    public static SearchResultType valueOf(String str) {
        return (SearchResultType) Enum.valueOf(SearchResultType.class, str);
    }

    public static SearchResultType[] values() {
        return (SearchResultType[]) $VALUES.clone();
    }
}
