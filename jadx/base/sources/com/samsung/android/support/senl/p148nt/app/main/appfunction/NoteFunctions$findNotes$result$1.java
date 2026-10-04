package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import com.google.android.appfunctions.AppFunctionContext;
import com.google.android.appfunctions.schema.common.p129v1.notes.FindNotesParams;
import com.google.android.appfunctions.schema.common.p129v1.notes.Note;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.common.data.SearchUseCaseManager;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.model.document.SDocXBodyTextGetter;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\n"}, m13886d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/google/android/appfunctions/schema/common/v1/notes/Note;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions$findNotes$result$1", m14021f = "NoteFunctions.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
@SourceDebugExtension({"SMAP\nNoteFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/NoteFunctions$findNotes$result$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,369:1\n774#2:370\n865#2,2:371\n1563#2:373\n1634#2,3:374\n1193#2,2:377\n1267#2,4:379\n1869#2,2:383\n*S KotlinDebug\n*F\n+ 1 NoteFunctions.kt\ncom/samsung/android/support/senl/nt/app/main/appfunction/NoteFunctions$findNotes$result$1\n*L\n92#1:370\n92#1:371,2\n92#1:373\n92#1:374,3\n94#1:377,2\n94#1:379,4\n99#1:383,2\n*E\n"})
public final class NoteFunctions$findNotes$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Note>>, Object> {
    final /* synthetic */ AppFunctionContext $appFunctionContext;
    final /* synthetic */ FindNotesParams $findNotesParams;
    int label;
    final /* synthetic */ NoteFunctions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteFunctions$findNotes$result$1(FindNotesParams findNotesParams, NoteFunctions noteFunctions, AppFunctionContext appFunctionContext, Continuation<? super NoteFunctions$findNotes$result$1> continuation) {
        super(2, continuation);
        this.$findNotesParams = findNotesParams;
        this.this$0 = noteFunctions;
        this.$appFunctionContext = appFunctionContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteFunctions$findNotes$result$1(this.$findNotesParams, this.this$0, this.$appFunctionContext, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String strReplaceUnicode;
        SearchNoteUseCase.Result resultInvoke;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SearchParam sortParam = new SearchParam(this.$findNotesParams.getQuery()).setSortParam(NotesUtils.getSortParam());
        int maxCount = 30;
        if (this.$findNotesParams.getMaxCount() > 0 && this.$findNotesParams.getMaxCount() < 30) {
            maxCount = this.$findNotesParams.getMaxCount();
        }
        SearchParam maxCount2 = sortParam.setMaxCount(maxCount);
        SearchFilterParam toTime = new SearchFilterParam().setFromTime(this.this$0.getStartTime(this.$findNotesParams.getStartDate())).setToTime(this.this$0.getEndTime(this.$findNotesParams.getEndDate()));
        Intrinsics.checkNotNullExpressionValue(toTime, "setToTime(...)");
        SearchParam searchParamAddStrategy = maxCount2.setFilterParam(toTime).setIncludeLockedNoteTitle(false).setOldDocumentOption(1).addStrategy(12);
        SearchNoteUseCase searchNoteUseCaseCreateSearchNoteUseCase = SearchUseCaseManager.INSTANCE.getInstance().createSearchNoteUseCase();
        List listEmptyList = null;
        List<MainListDocumentData> totalNotes = (searchNoteUseCaseCreateSearchNoteUseCase == null || (resultInvoke = searchNoteUseCaseCreateSearchNoteUseCase.invoke(searchParamAddStrategy)) == null) ? null : resultInvoke.getTotalNotes();
        if (totalNotes != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : totalNotes) {
                if (((MainListDocumentData) obj2).isSDoc()) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((MainListDocumentData) it.next()).getUuid());
            }
            listEmptyList = CollectionsKt.toMutableList((Collection) arrayList2);
        }
        NotesSearchRepository notesSearchRepositoryCreateSearchRepository = NotesDataRepositoryFactory.newInstance(this.$appFunctionContext.getContext()).createSearchRepository();
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<NotesDocumentTextSearchEntity> entities = notesSearchRepositoryCreateSearchRepository.getEntities(listEmptyList);
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        List<NotesDocumentTextSearchEntity> list = entities;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(list)), 16));
        for (NotesDocumentTextSearchEntity notesDocumentTextSearchEntity : list) {
            Pair pairM13893to = TuplesKt.m13893to(notesDocumentTextSearchEntity.getDocUuid(), notesDocumentTextSearchEntity.getStrippedContent());
            linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
        }
        ArrayList arrayList3 = new ArrayList();
        SDocXBodyTextGetter sDocXBodyTextGetter = new SDocXBodyTextGetter(this.$appFunctionContext.getContext());
        if (totalNotes != null) {
            NoteFunctions noteFunctions = this.this$0;
            for (MainListDocumentData mainListDocumentData : totalNotes) {
                if (mainListDocumentData.isSDoc()) {
                    strReplaceUnicode = (String) linkedHashMap.get(mainListDocumentData.getUuid());
                    if (strReplaceUnicode == null) {
                        strReplaceUnicode = "";
                    }
                } else {
                    String filePath = mainListDocumentData.getFilePath();
                    Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
                    strReplaceUnicode = UnicodeUtils.replaceUnicode(sDocXBodyTextGetter.getMaxLengthBodyText(filePath), UnicodeUtils.OBJECT_REPLACEMENT, " ");
                }
                String str = strReplaceUnicode;
                String uuid = mainListDocumentData.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                String title = mainListDocumentData.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
                Note note = new Note("SamsungNotes", uuid, title, str, CollectionsKt.emptyList(), mainListDocumentData.getCategoryUuid());
                arrayList3.add(note);
                AbstractC0000a.m25v("findNotes - result: ", noteFunctions.printNote(note), "NoteFunctions");
            }
        }
        return arrayList3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Note>> continuation) {
        return ((NoteFunctions$findNotes$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
