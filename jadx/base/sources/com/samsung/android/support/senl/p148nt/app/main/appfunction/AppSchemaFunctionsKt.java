package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import android.app.PendingIntent;
import com.google.android.appfunctions.AppFunction;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.app.AppFunctionSchema;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Folder;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNoteParams;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u0007\u001a\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0087@¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0087@¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u0017\u001a*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001d\u001a*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001H\u0087@¢\u0006\u0002\u0010\u0017\u001a$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H\u0087@¢\u0006\u0002\u0010#\u001a\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0087@¢\u0006\u0002\u0010'¨\u0006("}, m13886d2 = {"NoteFunctions_findNotes", "", "Lcom/google/android/appfunctions/schema/common/v1/notes/Note;", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "findNotesParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotesParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindNotesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoteFunctions_createNote", "createNoteParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoteFunctions_showNote", "Landroid/app/PendingIntent;", "noteId", "", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoteFunctions_updateNote", "updateNoteParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoteFunctions_deleteNotes", "noteIds", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NoteFunctions_getNotes", "FolderFunctions_createFolder", "Lcom/google/android/appfunctions/schema/common/v1/notes/Folder;", "createFolderParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolderParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FolderFunctions_deleteFolders", "folderIds", "FolderFunctions_findFolders", "findFoldersParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FolderFunctions_updateFolder", "updateFolderParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateFolderParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateFolderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ntApp_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppSchemaFunctionsKt {
    @AppFunction(description = "createFolder schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "createFolder", version = 1)
    @Nullable
    public static final Object FolderFunctions_createFolder(@NotNull AppFunctionContext appFunctionContext, @NotNull CreateFolderParams createFolderParams, @NotNull Continuation<? super Folder> continuation) {
        return new FolderFunctions().createFolder(appFunctionContext, createFolderParams, continuation);
    }

    @AppFunction(description = "deleteFolders schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "deleteFolders", version = 1)
    @Nullable
    public static final Object FolderFunctions_deleteFolders(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<String>> continuation) {
        return new FolderFunctions().deleteFolders(appFunctionContext, list, continuation);
    }

    @AppFunction(description = "findFolders schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "findFolders", version = 1)
    @Nullable
    public static final Object FolderFunctions_findFolders(@NotNull AppFunctionContext appFunctionContext, @NotNull FindFoldersParams findFoldersParams, @NotNull Continuation<? super List<Folder>> continuation) {
        return new FolderFunctions().findFolders(appFunctionContext, findFoldersParams, continuation);
    }

    @AppFunction(description = "updateFolder schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "updateFolder", version = 1)
    @Nullable
    public static final Object FolderFunctions_updateFolder(@NotNull AppFunctionContext appFunctionContext, @NotNull UpdateFolderParams updateFolderParams, @NotNull Continuation<? super Folder> continuation) {
        return new FolderFunctions().updateFolder(appFunctionContext, updateFolderParams, continuation);
    }

    @AppFunction(description = "createNote schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "createNote", version = 1)
    @Nullable
    public static final Object NoteFunctions_createNote(@NotNull AppFunctionContext appFunctionContext, @NotNull CreateNoteParams createNoteParams, @NotNull Continuation<? super Note> continuation) {
        return new NoteFunctions().createNote(appFunctionContext, createNoteParams, continuation);
    }

    @AppFunction(description = "deleteNote schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "deleteNotes", version = 1)
    @Nullable
    public static final Object NoteFunctions_deleteNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<String>> continuation) {
        return new NoteFunctions().deleteNotes(appFunctionContext, list, continuation);
    }

    @AppFunction(description = "findNotes schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "findNotes", version = 1)
    @Nullable
    public static final Object NoteFunctions_findNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull FindNotesParams findNotesParams, @NotNull Continuation<? super List<Note>> continuation) {
        return new NoteFunctions().findNotes(appFunctionContext, findNotesParams, continuation);
    }

    @AppFunction(description = "getNotes schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "getNotes", version = 1)
    @Nullable
    public static final Object NoteFunctions_getNotes(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<Note>> continuation) {
        return new NoteFunctions().getNotes(appFunctionContext, list, continuation);
    }

    @AppFunction(description = "showNote schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "showNote", version = 1)
    @Nullable
    public static final Object NoteFunctions_showNote(@NotNull AppFunctionContext appFunctionContext, @NotNull String str, @NotNull Continuation<? super PendingIntent> continuation) {
        return new NoteFunctions().showNote(appFunctionContext, str, continuation);
    }

    @AppFunction(description = "updateNote schema impl", displayNameStringRes = 0, enabledByDefault = true, restrictCallersWithExecuteAppFunctions = false)
    @AppFunctionSchema(category = Privacy.KEY_NOTES, name = "updateNote", version = 1)
    @Nullable
    public static final Object NoteFunctions_updateNote(@NotNull AppFunctionContext appFunctionContext, @NotNull UpdateNoteParams updateNoteParams, @NotNull Continuation<? super Note> continuation) {
        return new NoteFunctions().updateNote(appFunctionContext, updateNoteParams, continuation);
    }
}
