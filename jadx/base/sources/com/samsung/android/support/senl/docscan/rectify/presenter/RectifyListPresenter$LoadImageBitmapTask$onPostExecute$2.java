package com.samsung.android.support.senl.docscan.rectify.presenter;

import android.graphics.Bitmap;
import com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2", m14021f = "RectifyListPresenter.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Bitmap> $imageDataMap;
    int label;
    final /* synthetic */ RectifyListPresenter.LoadImageBitmapTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2(RectifyListPresenter.LoadImageBitmapTask loadImageBitmapTask, Map<String, Bitmap> map, Continuation<? super RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2> continuation) {
        super(2, continuation);
        this.this$0 = loadImageBitmapTask;
        this.$imageDataMap = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2(this.this$0, this.$imageDataMap, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RectifyListPresenter.LoadImageBitmapTask.PostRunnable postRunnable = this.this$0.mPostRunnable;
        if (postRunnable == null) {
            return null;
        }
        postRunnable.accept(this.$imageDataMap);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RectifyListPresenter$LoadImageBitmapTask$onPostExecute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
