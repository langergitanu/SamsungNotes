package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import com.google.android.appfunctions.schema.common.p129v1.notes.FindFoldersParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Folder;
import com.samsung.android.support.senl.p148nt.app.common.data.SearchUseCaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchFolderUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\n"}, m13886d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/google/android/appfunctions/schema/common/v1/notes/Folder;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.FolderFunctions$findFolders$result$1", m14021f = "FolderFunctions.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
@SourceDebugExtension({"SMAP\nFolderFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FolderFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/FolderFunctions$findFolders$result$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,156:1\n1869#2,2:157\n*S KotlinDebug\n*F\n+ 1 FolderFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/FolderFunctions$findFolders$result$1\n*L\n101#1:157,2\n*E\n"})
public final class FolderFunctions$findFolders$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Folder>>, Object> {
    final /* synthetic */ FindFoldersParams $findFoldersParams;
    final /* synthetic */ int $maxCount;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderFunctions$findFolders$result$1(FindFoldersParams findFoldersParams, int i, Continuation<? super FolderFunctions$findFolders$result$1> continuation) {
        super(2, continuation);
        this.$findFoldersParams = findFoldersParams;
        this.$maxCount = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderFunctions$findFolders$result$1(this.$findFoldersParams, this.$maxCount, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SearchParam maxCount = new SearchParam(this.$findFoldersParams.getQuery()).addStrategy(4).setMaxCount(this.$maxCount);
        SearchFolderUseCase searchFolderUseCaseCreateSearchFolderUseCase = SearchUseCaseManager.INSTANCE.getInstance().createSearchFolderUseCase();
        List<NotesCategoryTreeEntity> listInvoke = searchFolderUseCaseCreateSearchFolderUseCase != null ? searchFolderUseCaseCreateSearchFolderUseCase.invoke(maxCount) : null;
        ArrayList arrayList = new ArrayList();
        if (listInvoke != null) {
            for (NotesCategoryTreeEntity notesCategoryTreeEntity : listInvoke) {
                if (notesCategoryTreeEntity != null) {
                    String uuid = notesCategoryTreeEntity.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                    String displayName = notesCategoryTreeEntity.getDisplayName();
                    Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
                    arrayList.add(new Folder("SamsungNotes", uuid, displayName));
                }
            }
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Folder>> continuation) {
        return ((FolderFunctions$findFolders$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
