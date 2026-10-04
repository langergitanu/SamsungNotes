package com.samsung.android.support.notes.bixby.bixby2.aid;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/MainListValue;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextValue;", "<init>", "()V", "categoryName", "", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "noteInfo", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/ContextNoteInfo;", "Lkotlin/collections/ArrayList;", "getNoteInfo", "()Ljava/util/ArrayList;", "setNoteInfo", "(Ljava/util/ArrayList;)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MainListValue extends AppContextValue {

    @NotNull
    private String categoryName = "none";

    @Nullable
    private ArrayList<ContextNoteInfo> noteInfo;

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    public final ArrayList<ContextNoteInfo> getNoteInfo() {
        return this.noteInfo;
    }

    public final void setCategoryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
    }

    public final void setNoteInfo(@Nullable ArrayList<ContextNoteInfo> arrayList) {
        this.noteInfo = arrayList;
    }
}
