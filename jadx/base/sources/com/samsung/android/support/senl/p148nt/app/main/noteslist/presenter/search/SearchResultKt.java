package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0000\u001aD\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¨\u0006\f"}, m13886d2 = {"printSearchResultLog", "", "keywordNotes", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "semanticNotes", "semanticScores", "", "", "", "contextualKeywordNotes", "", "ntApp_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchResultKt {
    public static final void printSearchResultLog(@NotNull List<? extends MainListDocumentData> keywordNotes, @NotNull List<? extends MainListDocumentData> semanticNotes, @NotNull Map<String, Float> semanticScores, @NotNull Set<String> contextualKeywordNotes) {
        Intrinsics.checkNotNullParameter(keywordNotes, "keywordNotes");
        Intrinsics.checkNotNullParameter(semanticNotes, "semanticNotes");
        Intrinsics.checkNotNullParameter(semanticScores, "semanticScores");
        Intrinsics.checkNotNullParameter(contextualKeywordNotes, "contextualKeywordNotes");
        if (!keywordNotes.isEmpty()) {
            Logger.m8697d("SearchResult", Logger.getEncode("contextual (" + contextualKeywordNotes.size() + ") " + contextualKeywordNotes));
            return;
        }
        if (semanticNotes.isEmpty()) {
            return;
        }
        Logger.m8697d("SearchResult", Logger.getEncode("semanticNotes (" + semanticNotes.size() + "), semanticScores (" + semanticScores.size() + ")"));
    }
}
