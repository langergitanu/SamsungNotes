package com.samsung.android.support.senl.p148nt.app.main.appfunction;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.appfunctions.AppFunctionContext;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperAppFunction;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.domain.note.UpdateNoteUseCase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "Lcom/samsung/android/support/senl/nt/model/domain/note/UpdateNoteUseCase$Result;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.appfunction.NoteFunctions$updateNote$result$1", m14021f = "NoteFunctions.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class NoteFunctions$updateNote$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpdateNoteUseCase.Result>, Object> {
    final /* synthetic */ AppFunctionContext $appFunctionContext;
    final /* synthetic */ NotesDataRepositoryFactory $factory;
    final /* synthetic */ UpdateNoteUseCase.UpdateNoteParam $updateNoteParam;
    final /* synthetic */ ArrayList<Uri> $uris;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteFunctions$updateNote$result$1(NotesDataRepositoryFactory notesDataRepositoryFactory, AppFunctionContext appFunctionContext, UpdateNoteUseCase.UpdateNoteParam updateNoteParam, ArrayList<Uri> arrayList, Continuation<? super NoteFunctions$updateNote$result$1> continuation) {
        super(2, continuation);
        this.$factory = notesDataRepositoryFactory;
        this.$appFunctionContext = appFunctionContext;
        this.$updateNoteParam = updateNoteParam;
        this.$uris = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(AppFunctionContext appFunctionContext, ArrayList arrayList, UpdateNoteUseCase.UpdateNoteParam updateNoteParam) {
        ActivityManager.AppTask appTask;
        Activity composerToAddContent = ComposerManager.INSTANCE.getInstance().getComposerToAddContent(0);
        if (composerToAddContent == null || (appTask = AppTaskCompat.INSTANCE.getInstance().getAppTask(appFunctionContext.getContext(), composerToAddContent.getTaskId())) == null) {
            return;
        }
        Intent intent = new Intent(appFunctionContext.getContext(), (Class<?>) ComposerActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra(Bixby2Constants.BIXBY_ACTION, Bixby2Constants.BIXBY_ACTION_ADD_CONTENT_TO_EDITING_NOTE);
        intent.putExtra(ActionSendHelperAppFunction.AI_ACTION_UPDATE_EDITING_NOTE, true);
        intent.putExtra("noteId", updateNoteParam.getDocUuid());
        if (updateNoteParam.getTitle() != null) {
            intent.putExtra("android.intent.extra.SUBJECT", updateNoteParam.getTitle());
        }
        if (updateNoteParam.getBodyText() != null) {
            intent.putExtra("android.intent.extra.TEXT", updateNoteParam.getBodyText());
        }
        if (updateNoteParam.getUris() != null) {
            ArrayList<Uri> uris = updateNoteParam.getUris();
            Intrinsics.checkNotNull(uris);
            if (!uris.isEmpty()) {
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) arrayList.get(0));
            }
        }
        if (!TextUtils.isEmpty(updateNoteParam.getFolderUuid())) {
            intent.putExtra("category_id", updateNoteParam.getFolderUuid());
        }
        appTask.startActivity(appFunctionContext.getContext(), intent, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteFunctions$updateNote$result$1(this.$factory, this.$appFunctionContext, this.$updateNoteParam, this.$uris, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = this.$factory.createDocumentDataRepository();
        final AppFunctionContext appFunctionContext = this.$appFunctionContext;
        final ArrayList<Uri> arrayList = this.$uris;
        return new UpdateNoteUseCase(notesDocumentRepositoryCreateDocumentDataRepository, new UpdateNoteUseCase.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.appfunction.a
            @Override // com.samsung.android.support.senl.nt.model.domain.note.UpdateNoteUseCase.Callback
            public final void handleOpenedNote(UpdateNoteUseCase.UpdateNoteParam updateNoteParam) {
                NoteFunctions$updateNote$result$1.invokeSuspend$lambda$0(appFunctionContext, arrayList, updateNoteParam);
            }
        }).execute(this.$appFunctionContext.getContext(), this.$updateNoteParam);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UpdateNoteUseCase.Result> continuation) {
        return ((NoteFunctions$updateNote$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
