package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$requestCoverGenerate$1$onFailed$1", m14021f = "NoteStyleActivity.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class NoteStyleActivity$requestCoverGenerate$1$onFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ NoteStyleActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteStyleActivity$requestCoverGenerate$1$onFailed$1(NoteStyleActivity noteStyleActivity, String str, Continuation<? super NoteStyleActivity$requestCoverGenerate$1$onFailed$1> continuation) {
        super(2, continuation);
        this.this$0 = noteStyleActivity;
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoteStyleActivity$requestCoverGenerate$1$onFailed$1(this.this$0, this.$msg, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoverData coverData;
        CoverData coverData2;
        CoverData coverData3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoverStylePresenter coverStylePresenter = this.this$0.mCoverPresenter;
        Logger.m10999d(NoteStyleActivity.TAG, "onFailed# isEnabled : " + ((coverStylePresenter == null || (coverData3 = coverStylePresenter.getCoverData()) == null) ? null : Boxing.boxBoolean(coverData3.isEnabled())));
        CoverStylePresenter coverStylePresenter2 = this.this$0.mCoverPresenter;
        if (coverStylePresenter2 != null && (coverData2 = coverStylePresenter2.getCoverData()) != null && coverData2.isEnabled()) {
            this.this$0.setAvailableGenerateCover(true);
            this.this$0.enableEditor(true);
        }
        NoteStyleLayout noteStyleLayout = this.this$0.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            noteStyleLayout.stopAnimation(false);
        }
        CoverStylePresenter coverStylePresenter3 = this.this$0.mCoverPresenter;
        if (coverStylePresenter3 != null && (coverData = coverStylePresenter3.getCoverData()) != null) {
            coverData.setGenerateState(0);
        }
        String str = this.$msg;
        if (str != null && str.length() != 0) {
            ToastHandler.show(BaseUtils.getContext(), this.$msg, 1);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NoteStyleActivity$requestCoverGenerate$1$onFailed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
