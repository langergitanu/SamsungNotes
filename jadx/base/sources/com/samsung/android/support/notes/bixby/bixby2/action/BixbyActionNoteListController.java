package com.samsung.android.support.notes.bixby.bixby2.action;

import com.samsung.android.support.notes.bixby.bixby2.aid.AbsBixby2Async;
import com.samsung.android.support.notes.bixby.bixby2.aid.BixbySearchParam;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.notes.bixby.bixby2.contract.IBixby2ActionBackgound;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u001d\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00072\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010$\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u000eJ%\u0010'\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010\u000eJ\"\u0010+\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionNoteListController;", "", "<init>", "()V", "mBixbyCallBack", "Lcom/samsung/android/support/notes/bixby/bixby2/contract/IBixby2ActionBackgound;", "setBixbyCallBack", "", "cb", "release", "isValidUUIDs", "", "noteIds", "", "", "([Ljava/lang/String;)Z", "deleteNotes", "asyncParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;", "successResponse", "Ljava/lang/Runnable;", "([Ljava/lang/String;Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;Ljava/lang/Runnable;)V", "searchNotes", "searchParam", "Lcom/samsung/android/support/notes/bixby/bixby2/aid/BixbySearchParam;", "saveNotes", Bixby2Constants.BIXBY_PARAM_NOTE_TITLE, "content", "category", "updateNotes", "noteId", "getAppState", "isNoteEmpty", "showRecentNotes", "maxCount", "", "diagnoseTroubleShooting", "searchFolders", "folderName", "deleteFolders", "folderIds", "(Lcom/samsung/android/support/notes/bixby/bixby2/aid/AbsBixby2Async$AsyncParam;[Ljava/lang/String;)V", "createFolder", "updateFolder", "folderId", "Companion", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BixbyActionNoteListController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static BixbyActionNoteListController mInstance;

    @Nullable
    private IBixby2ActionBackgound mBixbyCallBack;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionNoteListController$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionNoteListController;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/notes/bixby/bixby2/action/BixbyActionNoteListController;", "bixby_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @Nullable
        public final synchronized BixbyActionNoteListController getInstance() {
            try {
                if (BixbyActionNoteListController.mInstance == null) {
                    BixbyActionNoteListController.mInstance = new BixbyActionNoteListController();
                }
            } catch (Throwable th) {
                throw th;
            }
            return BixbyActionNoteListController.mInstance;
        }

        private Companion() {
        }
    }

    @Nullable
    public static final synchronized BixbyActionNoteListController getInstance() {
        return INSTANCE.getInstance();
    }

    public final void createFolder(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderName) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.createFolder(asyncParam, folderName);
        }
    }

    public final void deleteFolders(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String[] folderIds) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.deleteFolders(asyncParam, folderIds);
        }
    }

    public final void deleteNotes(@Nullable String[] noteIds, @NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable Runnable successResponse) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.deleteNotes(noteIds, asyncParam, successResponse);
        }
    }

    public final void diagnoseTroubleShooting(@Nullable String category, @NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.diagnoseTroubleShooting(category, asyncParam);
        }
    }

    public final void getAppState(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.getAppState(asyncParam);
        }
    }

    public final void isNoteEmpty(@NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.isNoteEmpty(asyncParam);
        }
    }

    public final boolean isValidUUIDs(@Nullable String[] noteIds) {
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            return iBixby2ActionBackgound.isValidUUIDs(noteIds);
        }
        return false;
    }

    public final void release() {
        if (this.mBixbyCallBack != null) {
            this.mBixbyCallBack = null;
        }
    }

    public final void saveNotes(@Nullable String noteTitle, @Nullable String content, @Nullable String category, @NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.saveNotes(noteTitle, content, category, asyncParam);
        }
    }

    public final void searchFolders(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderName) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.searchFolders(asyncParam, folderName);
        }
    }

    public final void searchNotes(@NotNull BixbySearchParam searchParam, @NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(searchParam, "searchParam");
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.searchNotes(searchParam, asyncParam);
        }
    }

    public final void setBixbyCallBack(@Nullable IBixby2ActionBackgound cb) {
        this.mBixbyCallBack = cb;
    }

    public final void showRecentNotes(int maxCount, @NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.showRecentNotes(maxCount, asyncParam);
        }
    }

    public final void updateFolder(@NotNull AbsBixby2Async.AsyncParam asyncParam, @Nullable String folderId, @Nullable String folderName) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.updateFolder(asyncParam, folderId, folderName);
        }
    }

    public final void updateNotes(@Nullable String noteId, @Nullable String noteTitle, @Nullable String content, @NotNull AbsBixby2Async.AsyncParam asyncParam) {
        Intrinsics.checkNotNullParameter(asyncParam, "asyncParam");
        IBixby2ActionBackgound iBixby2ActionBackgound = this.mBixbyCallBack;
        if (iBixby2ActionBackgound != null) {
            iBixby2ActionBackgound.updateNotes(noteId, noteTitle, content, asyncParam);
        }
    }
}
