package appfunctions_aggregated_deps;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.internal.AppFunctionInvoker;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateNoteParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateNoteParams;
import com.samsung.android.support.senl.p148nt.app.main.appfunction.AppSchemaFunctionsKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInvoker_Impl */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m13886d2 = {"Lappfunctions_aggregated_deps/_com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInvoker_Impl;", "Lcom/google/android/appfunctions/internal/AppFunctionInvoker;", "<init>", "()V", "supportedFunctionIds", "", "", "getSupportedFunctionIds", "()Ljava/util/Set;", "unsafeInvoke", "", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "functionIdentifier", "parameters", "", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class C4174x1d1dad3a implements AppFunctionInvoker {

    @NotNull
    private final Set<String> supportedFunctionIds = SetsKt.setOf((Object[]) new String[]{"com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_findNotes", "com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_createNote", "com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_showNote", "com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_updateNote", "com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_deleteNotes", "com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_getNotes", "com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_createFolder", "com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_deleteFolders", "com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_findFolders", "com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_updateFolder"});

    /* JADX INFO: renamed from: appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInvoker_Impl$unsafeInvoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "appfunctions_aggregated_deps._com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInvoker_Impl", m14021f = "_com_samsung_android_support_senl_nt_app_main_appfunction_AppSchemaFunctions_AppFunctionInvoker_Impl.kt", m14022i = {}, m14023l = {46, 50, 54, 57, 61, 65, 69, 73, 77, 81}, m14024m = "unsafeInvoke", m14025n = {}, m14026s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C4174x1d1dad3a.this.unsafeInvoke(null, null, null, this);
        }
    }

    @Override // com.google.android.appfunctions.internal.AppFunctionInvoker
    @NotNull
    public Set<String> getSupportedFunctionIds() {
        return this.supportedFunctionIds;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a2 A[RETURN] */
    @Override // com.google.android.appfunctions.internal.AppFunctionInvoker
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object unsafeInvoke(@NotNull AppFunctionContext appFunctionContext, @NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull Continuation<Object> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                switch (str.hashCode()) {
                    case -1946939703:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_findNotes")) {
                            Object obj2 = map.get("findNotesParams");
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.FindNotesParams");
                            anonymousClass1.label = 1;
                            Object objNoteFunctions_findNotes = AppSchemaFunctionsKt.NoteFunctions_findNotes(appFunctionContext, (FindNotesParams) obj2, anonymousClass1);
                            return objNoteFunctions_findNotes == coroutine_suspended ? coroutine_suspended : objNoteFunctions_findNotes;
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case -1440469334:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_getNotes")) {
                            Object obj3 = map.get("noteIds");
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            anonymousClass1.label = 6;
                            Object objNoteFunctions_getNotes = AppSchemaFunctionsKt.NoteFunctions_getNotes(appFunctionContext, (List) obj3, anonymousClass1);
                            if (objNoteFunctions_getNotes != coroutine_suspended) {
                                return objNoteFunctions_getNotes;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case -1173471259:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_createFolder")) {
                            Object obj4 = map.get("createFolderParams");
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.CreateFolderParams");
                            anonymousClass1.label = 7;
                            Object objFolderFunctions_createFolder = AppSchemaFunctionsKt.FolderFunctions_createFolder(appFunctionContext, (CreateFolderParams) obj4, anonymousClass1);
                            if (objFolderFunctions_createFolder != coroutine_suspended) {
                                return objFolderFunctions_createFolder;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case -478798278:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_updateNote")) {
                            Object obj5 = map.get("updateNoteParams");
                            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.UpdateNoteParams");
                            anonymousClass1.label = 4;
                            Object objNoteFunctions_updateNote = AppSchemaFunctionsKt.NoteFunctions_updateNote(appFunctionContext, (UpdateNoteParams) obj5, anonymousClass1);
                            if (objNoteFunctions_updateNote != coroutine_suspended) {
                                return objNoteFunctions_updateNote;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case -174193249:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_deleteFolders")) {
                            Object obj6 = map.get("folderIds");
                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            anonymousClass1.label = 8;
                            Object objFolderFunctions_deleteFolders = AppSchemaFunctionsKt.FolderFunctions_deleteFolders(appFunctionContext, (List) obj6, anonymousClass1);
                            if (objFolderFunctions_deleteFolders != coroutine_suspended) {
                                return objFolderFunctions_deleteFolders;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case 554660398:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_showNote")) {
                            Object obj7 = map.get("noteId");
                            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
                            anonymousClass1.label = 3;
                            Object objNoteFunctions_showNote = AppSchemaFunctionsKt.NoteFunctions_showNote(appFunctionContext, (String) obj7, anonymousClass1);
                            if (objNoteFunctions_showNote != coroutine_suspended) {
                                return objNoteFunctions_showNote;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case 645466610:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_updateFolder")) {
                            Object obj8 = map.get("updateFolderParams");
                            Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.UpdateFolderParams");
                            anonymousClass1.label = 10;
                            Object objFolderFunctions_updateFolder = AppSchemaFunctionsKt.FolderFunctions_updateFolder(appFunctionContext, (UpdateFolderParams) obj8, anonymousClass1);
                            if (objFolderFunctions_updateFolder != coroutine_suspended) {
                                return objFolderFunctions_updateFolder;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case 908805905:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#FolderFunctions_findFolders")) {
                            Object obj9 = map.get("findFoldersParams");
                            Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.FindFoldersParams");
                            anonymousClass1.label = 9;
                            Object objFolderFunctions_findFolders = AppSchemaFunctionsKt.FolderFunctions_findFolders(appFunctionContext, (FindFoldersParams) obj9, anonymousClass1);
                            if (objFolderFunctions_findFolders != coroutine_suspended) {
                                return objFolderFunctions_findFolders;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case 1186346221:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_createNote")) {
                            Object obj10 = map.get("createNoteParams");
                            Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.google.android.appfunctions.schema.common.v1.notes.CreateNoteParams");
                            anonymousClass1.label = 2;
                            Object objNoteFunctions_createNote = AppSchemaFunctionsKt.NoteFunctions_createNote(appFunctionContext, (CreateNoteParams) obj10, anonymousClass1);
                            if (objNoteFunctions_createNote != coroutine_suspended) {
                                return objNoteFunctions_createNote;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    case 1788746199:
                        if (str.equals("com.samsung.android.support.senl.nt.app.main.appfunction#NoteFunctions_deleteNotes")) {
                            Object obj11 = map.get("noteIds");
                            Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            anonymousClass1.label = 5;
                            Object objNoteFunctions_deleteNotes = AppSchemaFunctionsKt.NoteFunctions_deleteNotes(appFunctionContext, (List) obj11, anonymousClass1);
                            if (objNoteFunctions_deleteNotes != coroutine_suspended) {
                                return objNoteFunctions_deleteNotes;
                            }
                        }
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                    default:
                        throw new IllegalArgumentException(AbstractC0541b.m773o("Function [", str, "] is not available."));
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 2:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 3:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 4:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 5:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 6:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 7:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 8:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 9:
                ResultKt.throwOnFailure(obj);
                return obj;
            case 10:
                ResultKt.throwOnFailure(obj);
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
