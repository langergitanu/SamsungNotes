package com.samsung.android.support.notes.bixby.bixby2.aid;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/ComposerValue;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppContextValue;", "<init>", "()V", "isFocusOnNotePage", "", "()Z", "setFocusOnNotePage", "(Z)V", "isSupportS24Feature", "setSupportS24Feature", "resultScreenInfo", "", "getResultScreenInfo", "()Ljava/lang/String;", "setResultScreenInfo", "(Ljava/lang/String;)V", "noteInfo", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/NoteInfo;", "Lkotlin/collections/ArrayList;", "getNoteInfo", "()Ljava/util/ArrayList;", "setNoteInfo", "(Ljava/util/ArrayList;)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerValue extends AppContextValue {
    private boolean isFocusOnNotePage;
    private boolean isSupportS24Feature;

    @Nullable
    private ArrayList<NoteInfo> noteInfo;

    @NotNull
    private String resultScreenInfo = "none";

    @Nullable
    public final ArrayList<NoteInfo> getNoteInfo() {
        return this.noteInfo;
    }

    @NotNull
    public final String getResultScreenInfo() {
        return this.resultScreenInfo;
    }

    /* JADX INFO: renamed from: isFocusOnNotePage, reason: from getter */
    public final boolean getIsFocusOnNotePage() {
        return this.isFocusOnNotePage;
    }

    /* JADX INFO: renamed from: isSupportS24Feature, reason: from getter */
    public final boolean getIsSupportS24Feature() {
        return this.isSupportS24Feature;
    }

    public final void setFocusOnNotePage(boolean z) {
        this.isFocusOnNotePage = z;
    }

    public final void setNoteInfo(@Nullable ArrayList<NoteInfo> arrayList) {
        this.noteInfo = arrayList;
    }

    public final void setResultScreenInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resultScreenInfo = str;
    }

    public final void setSupportS24Feature(boolean z) {
        this.isSupportS24Feature = z;
    }
}
