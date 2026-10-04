package com.samsung.android.support.senl.docscan.rectify.presenter;

import com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter$LoadImageBitmapTask$execute$1", m14021f = "RectifyListPresenter.kt", m14022i = {}, m14023l = {284}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class RectifyListPresenter$LoadImageBitmapTask$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String>[] $imagePathLists;
    int label;
    final /* synthetic */ RectifyListPresenter.LoadImageBitmapTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyListPresenter$LoadImageBitmapTask$execute$1(RectifyListPresenter.LoadImageBitmapTask loadImageBitmapTask, List<String>[] listArr, Continuation<? super RectifyListPresenter$LoadImageBitmapTask$execute$1> continuation) {
        super(2, continuation);
        this.this$0 = loadImageBitmapTask;
        this.$imagePathLists = listArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RectifyListPresenter$LoadImageBitmapTask$execute$1(this.this$0, this.$imagePathLists, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RectifyListPresenter.LoadImageBitmapTask loadImageBitmapTask = this.this$0;
            List<String>[] listArr = this.$imagePathLists;
            Map mapDoInBackground = loadImageBitmapTask.doInBackground((List[]) Arrays.copyOf(listArr, listArr.length));
            RectifyListPresenter.LoadImageBitmapTask loadImageBitmapTask2 = this.this$0;
            this.label = 1;
            if (loadImageBitmapTask2.onPostExecute(mapDoInBackground, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Job.DefaultImpls.cancel$default((Job) this.this$0.job, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RectifyListPresenter$LoadImageBitmapTask$execute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
