package appfunctions_aggregated_deps;

import com.google.android.appfunctions.AppFunctionDataTypeMetadata;
import com.google.android.appfunctions.AppFunctionMetadata;
import com.google.android.appfunctions.AppFunctionParameterMetadata;
import com.google.android.appfunctions.internal.AppFunctionInventory;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__CreateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__CreateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__Folder;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__Note;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__UpdateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.C$$__AppSearch__UpdateNoteParams;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020(0'\u0012\u0004\u0012\u00020\t0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006+"}, m13886d2 = {"Lappfunctions_aggregated_deps/_com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInventory_Impl;", "Lcom/google/android/appfunctions/internal/AppFunctionInventory;", "<init>", "()V", "NOTEFUNCTIONS_FINDNOTES_PARAMETER_1", "Lcom/google/android/appfunctions/AppFunctionParameterMetadata;", "NOTEFUNCTIONS_FINDNOTES_PARAMETERS", "", "NOTEFUNCTIONS_FINDNOTES", "Lcom/google/android/appfunctions/AppFunctionMetadata;", "NOTEFUNCTIONS_CREATENOTE_PARAMETER_1", "NOTEFUNCTIONS_CREATENOTE_PARAMETERS", "NOTEFUNCTIONS_CREATENOTE", "NOTEFUNCTIONS_SHOWNOTE_PARAMETER_1", "NOTEFUNCTIONS_SHOWNOTE_PARAMETERS", "NOTEFUNCTIONS_SHOWNOTE", "NOTEFUNCTIONS_UPDATENOTE_PARAMETER_1", "NOTEFUNCTIONS_UPDATENOTE_PARAMETERS", "NOTEFUNCTIONS_UPDATENOTE", "NOTEFUNCTIONS_DELETENOTES_PARAMETER_1", "NOTEFUNCTIONS_DELETENOTES_PARAMETERS", "NOTEFUNCTIONS_DELETENOTES", "NOTEFUNCTIONS_GETNOTES_PARAMETER_1", "NOTEFUNCTIONS_GETNOTES_PARAMETERS", "NOTEFUNCTIONS_GETNOTES", "FOLDERFUNCTIONS_CREATEFOLDER_PARAMETER_1", "FOLDERFUNCTIONS_CREATEFOLDER_PARAMETERS", "FOLDERFUNCTIONS_CREATEFOLDER", "FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETER_1", "FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETERS", "FOLDERFUNCTIONS_DELETEFOLDERS", "FOLDERFUNCTIONS_FINDFOLDERS_PARAMETER_1", "FOLDERFUNCTIONS_FINDFOLDERS_PARAMETERS", "FOLDERFUNCTIONS_FINDFOLDERS", "FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETER_1", "FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETERS", "FOLDERFUNCTIONS_UPDATEFOLDER", "functionToMetadataMap", "", "Lkotlin/Function;", "", "getFunctionToMetadataMap", "()Ljava/util/Map;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class C4163xedbaad8 implements AppFunctionInventory {

    @NotNull
    private final AppFunctionMetadata FOLDERFUNCTIONS_CREATEFOLDER;

    @NotNull
    private final List<AppFunctionParameterMetadata> FOLDERFUNCTIONS_CREATEFOLDER_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata FOLDERFUNCTIONS_CREATEFOLDER_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata FOLDERFUNCTIONS_DELETEFOLDERS;

    @NotNull
    private final List<AppFunctionParameterMetadata> FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata FOLDERFUNCTIONS_FINDFOLDERS;

    @NotNull
    private final List<AppFunctionParameterMetadata> FOLDERFUNCTIONS_FINDFOLDERS_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata FOLDERFUNCTIONS_FINDFOLDERS_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata FOLDERFUNCTIONS_UPDATEFOLDER;

    @NotNull
    private final List<AppFunctionParameterMetadata> FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_CREATENOTE;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_CREATENOTE_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_CREATENOTE_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_DELETENOTES;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_DELETENOTES_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_DELETENOTES_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_FINDNOTES;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_FINDNOTES_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_FINDNOTES_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_GETNOTES;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_GETNOTES_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_GETNOTES_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_SHOWNOTE;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_SHOWNOTE_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_SHOWNOTE_PARAMETER_1;

    @NotNull
    private final AppFunctionMetadata NOTEFUNCTIONS_UPDATENOTE;

    @NotNull
    private final List<AppFunctionParameterMetadata> NOTEFUNCTIONS_UPDATENOTE_PARAMETERS;

    @NotNull
    private final AppFunctionParameterMetadata NOTEFUNCTIONS_UPDATENOTE_PARAMETER_1;

    @NotNull
    private final Map<Function<Object>, AppFunctionMetadata> functionToMetadataMap;

    public C4163xedbaad8() {
        AppFunctionParameterMetadata appFunctionParameterMetadata = new AppFunctionParameterMetadata("findNotesParams", "androidx.appsearch.functions", "findNotesParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_findNotes#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__FindNotesParams.SCHEMA_NAME));
        this.NOTEFUNCTIONS_FINDNOTES_PARAMETER_1 = appFunctionParameterMetadata;
        List<AppFunctionParameterMetadata> listListOf = CollectionsKt.listOf(appFunctionParameterMetadata);
        this.NOTEFUNCTIONS_FINDNOTES_PARAMETERS = listListOf;
        AppFunctionMetadata appFunctionMetadata = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_findNotes", "androidx.appsearch.functions", true, "findNotes schema impl", listListOf, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_findNotes#RETURN_TYPE", "androidx.appsearch.functions", 3, true, false, C$$__AppSearch__Note.SCHEMA_NAME));
        this.NOTEFUNCTIONS_FINDNOTES = appFunctionMetadata;
        AppFunctionParameterMetadata appFunctionParameterMetadata2 = new AppFunctionParameterMetadata("createNoteParams", "androidx.appsearch.functions", "createNoteParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_createNote#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__CreateNoteParams.SCHEMA_NAME));
        this.NOTEFUNCTIONS_CREATENOTE_PARAMETER_1 = appFunctionParameterMetadata2;
        List<AppFunctionParameterMetadata> listListOf2 = CollectionsKt.listOf(appFunctionParameterMetadata2);
        this.NOTEFUNCTIONS_CREATENOTE_PARAMETERS = listListOf2;
        AppFunctionMetadata appFunctionMetadata2 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_createNote", "androidx.appsearch.functions", true, "createNote schema impl", listListOf2, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_createNote#RETURN_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__Note.SCHEMA_NAME));
        this.NOTEFUNCTIONS_CREATENOTE = appFunctionMetadata2;
        AppFunctionParameterMetadata appFunctionParameterMetadata3 = new AppFunctionParameterMetadata("noteId", "androidx.appsearch.functions", "noteId", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_showNote#PARAMETER_TYPE", "androidx.appsearch.functions", 8, false, false, null));
        this.NOTEFUNCTIONS_SHOWNOTE_PARAMETER_1 = appFunctionParameterMetadata3;
        List<AppFunctionParameterMetadata> listListOf3 = CollectionsKt.listOf(appFunctionParameterMetadata3);
        this.NOTEFUNCTIONS_SHOWNOTE_PARAMETERS = listListOf3;
        AppFunctionMetadata appFunctionMetadata3 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_showNote", "androidx.appsearch.functions", true, "showNote schema impl", listListOf3, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_showNote#RETURN_TYPE", "androidx.appsearch.functions", 9, false, false, null));
        this.NOTEFUNCTIONS_SHOWNOTE = appFunctionMetadata3;
        AppFunctionParameterMetadata appFunctionParameterMetadata4 = new AppFunctionParameterMetadata("updateNoteParams", "androidx.appsearch.functions", "updateNoteParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_updateNote#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__UpdateNoteParams.SCHEMA_NAME));
        this.NOTEFUNCTIONS_UPDATENOTE_PARAMETER_1 = appFunctionParameterMetadata4;
        List<AppFunctionParameterMetadata> listListOf4 = CollectionsKt.listOf(appFunctionParameterMetadata4);
        this.NOTEFUNCTIONS_UPDATENOTE_PARAMETERS = listListOf4;
        AppFunctionMetadata appFunctionMetadata4 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_updateNote", "androidx.appsearch.functions", true, "updateNote schema impl", listListOf4, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_updateNote#RETURN_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__Note.SCHEMA_NAME));
        this.NOTEFUNCTIONS_UPDATENOTE = appFunctionMetadata4;
        AppFunctionParameterMetadata appFunctionParameterMetadata5 = new AppFunctionParameterMetadata("noteIds", "androidx.appsearch.functions", "noteIds", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_deleteNotes#PARAMETER_TYPE", "androidx.appsearch.functions", 8, true, false, null));
        this.NOTEFUNCTIONS_DELETENOTES_PARAMETER_1 = appFunctionParameterMetadata5;
        List<AppFunctionParameterMetadata> listListOf5 = CollectionsKt.listOf(appFunctionParameterMetadata5);
        this.NOTEFUNCTIONS_DELETENOTES_PARAMETERS = listListOf5;
        AppFunctionMetadata appFunctionMetadata5 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_deleteNotes", "androidx.appsearch.functions", true, "deleteNote schema impl", listListOf5, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_deleteNotes#RETURN_TYPE", "androidx.appsearch.functions", 8, true, false, null));
        this.NOTEFUNCTIONS_DELETENOTES = appFunctionMetadata5;
        AppFunctionParameterMetadata appFunctionParameterMetadata6 = new AppFunctionParameterMetadata("noteIds", "androidx.appsearch.functions", "noteIds", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_getNotes#PARAMETER_TYPE", "androidx.appsearch.functions", 8, true, false, null));
        this.NOTEFUNCTIONS_GETNOTES_PARAMETER_1 = appFunctionParameterMetadata6;
        List<AppFunctionParameterMetadata> listListOf6 = CollectionsKt.listOf(appFunctionParameterMetadata6);
        this.NOTEFUNCTIONS_GETNOTES_PARAMETERS = listListOf6;
        AppFunctionMetadata appFunctionMetadata6 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_getNotes", "androidx.appsearch.functions", true, "getNotes schema impl", listListOf6, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_getNotes#RETURN_TYPE", "androidx.appsearch.functions", 3, true, false, C$$__AppSearch__Note.SCHEMA_NAME));
        this.NOTEFUNCTIONS_GETNOTES = appFunctionMetadata6;
        AppFunctionParameterMetadata appFunctionParameterMetadata7 = new AppFunctionParameterMetadata("createFolderParams", "androidx.appsearch.functions", "createFolderParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_createFolder#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__CreateFolderParams.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_CREATEFOLDER_PARAMETER_1 = appFunctionParameterMetadata7;
        List<AppFunctionParameterMetadata> listListOf7 = CollectionsKt.listOf(appFunctionParameterMetadata7);
        this.FOLDERFUNCTIONS_CREATEFOLDER_PARAMETERS = listListOf7;
        AppFunctionMetadata appFunctionMetadata7 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_createFolder", "androidx.appsearch.functions", true, "createFolder schema impl", listListOf7, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_createFolder#RETURN_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__Folder.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_CREATEFOLDER = appFunctionMetadata7;
        AppFunctionParameterMetadata appFunctionParameterMetadata8 = new AppFunctionParameterMetadata("folderIds", "androidx.appsearch.functions", "folderIds", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_deleteFolders#PARAMETER_TYPE", "androidx.appsearch.functions", 8, true, false, null));
        this.FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETER_1 = appFunctionParameterMetadata8;
        List<AppFunctionParameterMetadata> listListOf8 = CollectionsKt.listOf(appFunctionParameterMetadata8);
        this.FOLDERFUNCTIONS_DELETEFOLDERS_PARAMETERS = listListOf8;
        AppFunctionMetadata appFunctionMetadata8 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_deleteFolders", "androidx.appsearch.functions", true, "deleteFolders schema impl", listListOf8, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_deleteFolders#RETURN_TYPE", "androidx.appsearch.functions", 8, true, false, null));
        this.FOLDERFUNCTIONS_DELETEFOLDERS = appFunctionMetadata8;
        AppFunctionParameterMetadata appFunctionParameterMetadata9 = new AppFunctionParameterMetadata("findFoldersParams", "androidx.appsearch.functions", "findFoldersParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_findFolders#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__FindFoldersParams.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_FINDFOLDERS_PARAMETER_1 = appFunctionParameterMetadata9;
        List<AppFunctionParameterMetadata> listListOf9 = CollectionsKt.listOf(appFunctionParameterMetadata9);
        this.FOLDERFUNCTIONS_FINDFOLDERS_PARAMETERS = listListOf9;
        AppFunctionMetadata appFunctionMetadata9 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_findFolders", "androidx.appsearch.functions", true, "findFolders schema impl", listListOf9, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_findFolders#RETURN_TYPE", "androidx.appsearch.functions", 3, true, false, C$$__AppSearch__Folder.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_FINDFOLDERS = appFunctionMetadata9;
        AppFunctionParameterMetadata appFunctionParameterMetadata10 = new AppFunctionParameterMetadata("updateFolderParams", "androidx.appsearch.functions", "updateFolderParams", "", new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_updateFolder#PARAMETER_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__UpdateFolderParams.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETER_1 = appFunctionParameterMetadata10;
        List<AppFunctionParameterMetadata> listListOf10 = CollectionsKt.listOf(appFunctionParameterMetadata10);
        this.FOLDERFUNCTIONS_UPDATEFOLDER_PARAMETERS = listListOf10;
        AppFunctionMetadata appFunctionMetadata10 = new AppFunctionMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_updateFolder", "androidx.appsearch.functions", true, "updateFolder schema impl", listListOf10, new AppFunctionDataTypeMetadata("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_updateFolder#RETURN_TYPE", "androidx.appsearch.functions", 3, false, false, C$$__AppSearch__Folder.SCHEMA_NAME));
        this.FOLDERFUNCTIONS_UPDATEFOLDER = appFunctionMetadata10;
        C4164xdbf4917b c4164xdbf4917b = C4164xdbf4917b.INSTANCE;
        Intrinsics.checkNotNull(c4164xdbf4917b, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to = TuplesKt.m13893to(c4164xdbf4917b, appFunctionMetadata);
        C4166xdbf4917c c4166xdbf4917c = C4166xdbf4917c.INSTANCE;
        Intrinsics.checkNotNull(c4166xdbf4917c, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to2 = TuplesKt.m13893to(c4166xdbf4917c, appFunctionMetadata2);
        C4167xdbf4917d c4167xdbf4917d = C4167xdbf4917d.INSTANCE;
        Intrinsics.checkNotNull(c4167xdbf4917d, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to3 = TuplesKt.m13893to(c4167xdbf4917d, appFunctionMetadata3);
        C4168xdbf4917e c4168xdbf4917e = C4168xdbf4917e.INSTANCE;
        Intrinsics.checkNotNull(c4168xdbf4917e, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to4 = TuplesKt.m13893to(c4168xdbf4917e, appFunctionMetadata4);
        C4169xdbf4917f c4169xdbf4917f = C4169xdbf4917f.INSTANCE;
        Intrinsics.checkNotNull(c4169xdbf4917f, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to5 = TuplesKt.m13893to(c4169xdbf4917f, appFunctionMetadata5);
        C4170xdbf49180 c4170xdbf49180 = C4170xdbf49180.INSTANCE;
        Intrinsics.checkNotNull(c4170xdbf49180, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to6 = TuplesKt.m13893to(c4170xdbf49180, appFunctionMetadata6);
        C4171xdbf49181 c4171xdbf49181 = C4171xdbf49181.INSTANCE;
        Intrinsics.checkNotNull(c4171xdbf49181, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to7 = TuplesKt.m13893to(c4171xdbf49181, appFunctionMetadata7);
        C4172xdbf49182 c4172xdbf49182 = C4172xdbf49182.INSTANCE;
        Intrinsics.checkNotNull(c4172xdbf49182, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to8 = TuplesKt.m13893to(c4172xdbf49182, appFunctionMetadata8);
        C4173xdbf49183 c4173xdbf49183 = C4173xdbf49183.INSTANCE;
        Intrinsics.checkNotNull(c4173xdbf49183, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        Pair pairM13893to9 = TuplesKt.m13893to(c4173xdbf49183, appFunctionMetadata9);
        C4165xa29d9e15 c4165xa29d9e15 = C4165xa29d9e15.INSTANCE;
        Intrinsics.checkNotNull(c4165xa29d9e15, "null cannot be cast to non-null type kotlin.Function<kotlin.Any>");
        this.functionToMetadataMap = MapsKt.mapOf(pairM13893to, pairM13893to2, pairM13893to3, pairM13893to4, pairM13893to5, pairM13893to6, pairM13893to7, pairM13893to8, pairM13893to9, TuplesKt.m13893to(c4165xa29d9e15, appFunctionMetadata10));
    }

    @Override // com.google.android.appfunctions.internal.AppFunctionInventory
    @NotNull
    public Map<Function<Object>, AppFunctionMetadata> getFunctionToMetadataMap() {
        return this.functionToMetadataMap;
    }
}
