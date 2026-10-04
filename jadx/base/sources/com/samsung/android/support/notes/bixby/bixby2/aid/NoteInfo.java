package com.samsung.android.support.notes.bixby.bixby2.aid;

import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/NoteInfo;", "", "<init>", "()V", "noteID", "", "getNoteID", "()Ljava/lang/String;", "setNoteID", "(Ljava/lang/String;)V", Bixby2Constants.BIXBY_PARAM_NOTE_TITLE, "getNoteTitle", "setNoteTitle", "content", "getContent", "setContent", "category", "getCategory", "setCategory", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isLocked", "setLocked", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteInfo {
    private boolean isFavorite;
    private boolean isLocked;

    @NotNull
    private String noteID = "";

    @NotNull
    private String noteTitle = "";

    @NotNull
    private String content = "";

    @NotNull
    private String category = "";

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getNoteID() {
        return this.noteID;
    }

    @NotNull
    public final String getNoteTitle() {
        return this.noteTitle;
    }

    /* JADX INFO: renamed from: isFavorite, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* JADX INFO: renamed from: isLocked, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final void setCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    public final void setLocked(boolean z) {
        this.isLocked = z;
    }

    public final void setNoteID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noteID = str;
    }

    public final void setNoteTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noteTitle = str;
    }
}
