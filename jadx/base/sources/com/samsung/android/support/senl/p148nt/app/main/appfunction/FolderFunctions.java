package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import android.app.KeyguardManager;
import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.AppFunctionException;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolder;
import com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.DeleteFolders;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindFolders;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Folder;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateFolder;
import com.google.android.appfunctions.schema.common.p129v1.notes.UpdateFolderParams;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.domain.folder.AddFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.folder.DeleteFolderUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.folder.UpdateFolderUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001#B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/appfunction/FolderFunctions;", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolder;", "Lcom/google/android/appfunctions/schema/common/v1/notes/DeleteFolders;", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindFolders;", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateFolder;", "<init>", "()V", "createFolder", "Lcom/google/android/appfunctions/schema/common/v1/notes/Folder;", "appFunctionContext", "Lcom/google/android/appfunctions/AppFunctionContext;", "createFolderParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolderParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/CreateFolderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFolders", "", "", "folderIds", "(Lcom/google/android/appfunctions/AppFunctionContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findFolders", "findFoldersParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/FindFoldersParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFolder", "updateFolderParams", "Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateFolderParams;", "(Lcom/google/android/appfunctions/AppFunctionContext;Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateFolderParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "printFindFoldersParams", ActionHandler.PARAMS, "printCreateFolderParams", "printUpdateFolderParams", "checkInvalidStatus", "", "context", "Landroid/content/Context;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFolderFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FolderFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/FolderFunctions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,156:1\n1869#2,2:157\n31#3:159\n*S KotlinDebug\n*F\n+ 1 FolderFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/FolderFunctions\n*L\n64#1:157,2\n144#1:159\n*E\n"})
public final class FolderFunctions implements CreateFolder, DeleteFolders, FindFolders, UpdateFolder {

    @NotNull
    private static final String NAME_SPACE = "SamsungNotes";

    @NotNull
    private static final String TAG = "FolderFunctions";

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.appfunction.FolderFunctions$findFolders$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.FolderFunctions", m14021f = "FolderFunctions.kt", m14022i = {}, m14023l = {93}, m14024m = "findFolders", m14025n = {}, m14026s = {})
    public static final class C81541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C81541(Continuation<? super C81541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FolderFunctions.this.findFolders(null, null, this);
        }
    }

    private final void checkInvalidStatus(Context context) throws AppFunctionException {
        if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500) {
            KeyguardManager keyguardManager = context != null ? (KeyguardManager) ContextCompat.getSystemService(context, KeyguardManager.class) : null;
            if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
                return;
            }
            MainLogger.m7254d(TAG, "ERROR_APP_UNKNOWN_ERROR by KeyguardLocked");
            throw new AppFunctionException(3000, "This function is unavailable while the device is locked.", null, 4, null);
        }
    }

    private final String printCreateFolderParams(CreateFolderParams params) {
        return AbstractC0541b.m775q("[id: ", params.getId(), ", name: ", MainLogger.getEncode(params.getName()), "]");
    }

    private final String printFindFoldersParams(FindFoldersParams params) {
        String id = params.getId();
        String encode = MainLogger.getEncode(params.getQuery());
        return AbstractC2821a.m2223n(AbstractC0000a.m16m("[id: ", id, ", query: ", encode, ", maxCount: "), "]", params.getMaxCount());
    }

    private final String printUpdateFolderParams(UpdateFolderParams params) {
        String id = params.getId();
        String folderId = params.getFolderId();
        SetStringField name = params.getName();
        return AbstractC0622a.m1170p(MainLogger.getEncode(name != null ? name.getValue() : null), "]", AbstractC0000a.m16m("[id: ", id, ", folderId: ", folderId, ", name: "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFolder$lambda$1(String str, NotesCategoryTreeEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        entity.setDisplayName(str);
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.CreateFolder
    @Nullable
    public Object createFolder(@NotNull AppFunctionContext appFunctionContext, @NotNull CreateFolderParams createFolderParams, @NotNull Continuation<? super Folder> continuation) throws AppFunctionException {
        MainLogger.m7254d(TAG, "createFolder - name: " + printCreateFolderParams(createFolderParams));
        String strNewUUID = UUIDUtils.newUUID(appFunctionContext.getContext());
        if (new AddFolderUseCase().execute(new NotesCategoryTreeEntity(strNewUUID, "uncategorized:///", createFolderParams.getName(), null))) {
            return new Folder(NAME_SPACE, strNewUUID, createFolderParams.getName());
        }
        throw new AppFunctionException(1502, null, null, 6, null);
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.DeleteFolders
    @Nullable
    public Object deleteFolders(@NotNull AppFunctionContext appFunctionContext, @NotNull List<String> list, @NotNull Continuation<? super List<String>> continuation) throws AppFunctionException {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AbstractC0000a.m25v("deleteFolders - folderId: ", (String) it.next(), TAG);
        }
        checkInvalidStatus(appFunctionContext.getContext());
        DeleteFolderUseCase.Result resultExecute = new DeleteFolderUseCase(NotesDataRepositoryFactory.newInstance(appFunctionContext.getContext()).createCategoryTreeClosureRepository()).execute(list);
        if (resultExecute != null && !resultExecute.getDeletedFolders().isEmpty()) {
            return new ArrayList(resultExecute.getDeletedFolders());
        }
        throw new AppFunctionException(1500, null, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.FindFolders
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findFolders(@NotNull AppFunctionContext appFunctionContext, @NotNull FindFoldersParams findFoldersParams, @NotNull Continuation<? super List<Folder>> continuation) throws AppFunctionException {
        C81541 c81541;
        if (continuation instanceof C81541) {
            c81541 = (C81541) continuation;
            int i = c81541.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c81541.label = i - Integer.MIN_VALUE;
            } else {
                c81541 = new C81541(continuation);
            }
        }
        Object objWithContext = c81541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c81541.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainLogger.m7254d(TAG, "findFolders - findFoldersParams: " + printFindFoldersParams(findFoldersParams));
            checkInvalidStatus(appFunctionContext.getContext());
            int maxCount = 30;
            if (findFoldersParams.getMaxCount() > 0 && findFoldersParams.getMaxCount() < 30) {
                maxCount = findFoldersParams.getMaxCount();
            }
            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
            FolderFunctions$findFolders$result$1 folderFunctions$findFolders$result$1 = new FolderFunctions$findFolders$result$1(findFoldersParams, maxCount, null);
            c81541.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, folderFunctions$findFolders$result$1, c81541);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return (ArrayList) objWithContext;
    }

    @Override // com.google.android.appfunctions.schema.common.p129v1.notes.UpdateFolder
    @Nullable
    public Object updateFolder(@NotNull AppFunctionContext appFunctionContext, @NotNull UpdateFolderParams updateFolderParams, @NotNull Continuation<? super Folder> continuation) throws AppFunctionException {
        String value2;
        MainLogger.m7254d(TAG, "updateFolder - updateFolderParams: " + printUpdateFolderParams(updateFolderParams));
        checkInvalidStatus(appFunctionContext.getContext());
        SetStringField name = updateFolderParams.getName();
        if (name == null || (value2 = name.getValue()) == null) {
            value2 = "";
        }
        if (new UpdateFolderUseCase().execute(updateFolderParams.getFolderId(), new C4191n(value2, 17))) {
            return new Folder(NAME_SPACE, updateFolderParams.getFolderId(), value2);
        }
        throw new AppFunctionException(1500, null, null, 6, null);
    }
}
