package com.samsung.android.support.senl.p148nt.stt.common.util.search;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchHelper;", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "<init>", "(Ljava/lang/String;)V", "text", "position", "", "subPosition", "deltaPosition", "isTranslation", "", "setText", "setPosition", "setSubPosition", "setDeltaPosition", "setTranslation", InputMethodCompat.EXTRA_VALUE_BOARD_HBD_TRANSLATE, "search", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchFoundItem;", "Lkotlin/collections/ArrayList;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchHelper {
    private int deltaPosition;
    private boolean isTranslation;

    @Nullable
    private final String keyword;
    private int position;
    private int subPosition;

    @Nullable
    private String text;

    public SearchHelper(@Nullable String str) {
        this.keyword = str;
    }

    @NotNull
    public final ArrayList<SearchFoundItem> search() {
        String str;
        int iM14129C;
        ArrayList<SearchFoundItem> arrayList = new ArrayList<>();
        if (this.text != null && (str = this.keyword) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str2 = this.text;
            Intrinsics.checkNotNull(str2);
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase2 = str2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            BreakIterator characterInstance = BreakIterator.getCharacterInstance();
            characterInstance.setText(lowerCase2);
            int iFirst = characterInstance.first();
            for (int next = characterInstance.next(); next != -1; next = characterInstance.next()) {
                String strSubstring = lowerCase2.substring(iFirst, next);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                if (StringsKt.m14162r(strSubstring, lowerCase) && (iM14129C = StringsKt.m14129C(lowerCase, 0, 6, strSubstring)) != -1) {
                    arrayList.add(new SearchFoundItem(this.position, this.subPosition, this.deltaPosition, iM14129C + iFirst, next, this.isTranslation));
                    iFirst = next;
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final SearchHelper setDeltaPosition(int deltaPosition) {
        this.deltaPosition = deltaPosition;
        return this;
    }

    @NotNull
    public final SearchHelper setPosition(int position) {
        this.position = position;
        return this;
    }

    @NotNull
    public final SearchHelper setSubPosition(int subPosition) {
        this.subPosition = subPosition;
        return this;
    }

    @NotNull
    public final SearchHelper setText(@Nullable String text) {
        this.text = text;
        return this;
    }

    @NotNull
    public final SearchHelper setTranslation(boolean translation) {
        this.isTranslation = translation;
        return this;
    }
}
