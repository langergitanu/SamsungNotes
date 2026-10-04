package com.samsung.android.support.notes.bixby.bixby2.aid;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/aid/ActionResult;", "", "<init>", "()V", "noteInfo", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/NoteInfo;", "Lkotlin/collections/ArrayList;", "getNoteInfo", "()Ljava/util/ArrayList;", "setNoteInfo", "(Ljava/util/ArrayList;)V", "folderInfo", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/FolderInfo;", "getFolderInfo", "setFolderInfo", "appState", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppState;", "getAppState", "()Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppState;", "setAppState", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/AppState;)V", "result", "", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "isNoteEmpty", "", "()Ljava/lang/Boolean;", "setNoteEmpty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "contentIdx", "", "getContentIdx", "()I", "setContentIdx", "(I)V", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ActionResult {

    @Nullable
    private AppState appState;
    private int contentIdx;

    @Nullable
    private String description;

    @Nullable
    private ArrayList<FolderInfo> folderInfo;

    @Nullable
    private Boolean isNoteEmpty;

    @Nullable
    private ArrayList<NoteInfo> noteInfo;

    @Nullable
    private String result;

    @Nullable
    public final AppState getAppState() {
        return this.appState;
    }

    public final int getContentIdx() {
        return this.contentIdx;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ArrayList<FolderInfo> getFolderInfo() {
        return this.folderInfo;
    }

    @Nullable
    public final ArrayList<NoteInfo> getNoteInfo() {
        return this.noteInfo;
    }

    @Nullable
    public final String getResult() {
        return this.result;
    }

    @Nullable
    /* JADX INFO: renamed from: isNoteEmpty, reason: from getter */
    public final Boolean getIsNoteEmpty() {
        return this.isNoteEmpty;
    }

    public final void setAppState(@Nullable AppState appState) {
        this.appState = appState;
    }

    public final void setContentIdx(int i) {
        this.contentIdx = i;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setFolderInfo(@Nullable ArrayList<FolderInfo> arrayList) {
        this.folderInfo = arrayList;
    }

    public final void setNoteEmpty(@Nullable Boolean bool) {
        this.isNoteEmpty = bool;
    }

    public final void setNoteInfo(@Nullable ArrayList<NoteInfo> arrayList) {
        this.noteInfo = arrayList;
    }

    public final void setResult(@Nullable String str) {
        this.result = str;
    }
}
