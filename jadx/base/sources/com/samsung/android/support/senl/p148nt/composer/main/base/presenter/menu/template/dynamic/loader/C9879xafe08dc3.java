package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import android.graphics.PointF;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import java.util.concurrent.CountDownLatch;
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

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader$initTemplateContents$initTemplateContentsRunnable$1$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader$initTemplateContents$initTemplateContentsRunnable$1$1", m14021f = "DynamicTemplateLoader.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class C9879xafe08dc3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CountDownLatch $countDownLatch;
    final /* synthetic */ int $targetPageIndex;
    final /* synthetic */ Page $templatePage;
    int label;
    final /* synthetic */ DynamicTemplateLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9879xafe08dc3(Page page, DynamicTemplateLoader dynamicTemplateLoader, int i, CountDownLatch countDownLatch, Continuation<? super C9879xafe08dc3> continuation) {
        super(2, continuation);
        this.$templatePage = page;
        this.this$0 = dynamicTemplateLoader;
        this.$targetPageIndex = i;
        this.$countDownLatch = countDownLatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C9879xafe08dc3(this.$templatePage, this.this$0, this.$targetPageIndex, this.$countDownLatch, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int size = this.$templatePage.getGroups().size();
        ComposerModel composerModel = this.this$0.composerModel;
        ComposerModel composerModel2 = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel = null;
        }
        SpenWNote doc = composerModel.getDoc();
        Intrinsics.checkNotNullExpressionValue(doc, "getDoc(...)");
        PointF pageSize = PageSizeUtil.getPageSize(doc, this.$targetPageIndex);
        float width = this.$templatePage.getWidth();
        float width2 = this.$templatePage.getWidth();
        ComposerModel composerModel3 = this.this$0.composerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
            composerModel3 = null;
        }
        float pageDefaultHeight = width2 * composerModel3.getDoc().getPageDefaultHeight();
        ComposerModel composerModel4 = this.this$0.composerModel;
        if (composerModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerModel");
        } else {
            composerModel2 = composerModel4;
        }
        PointF pointF = new PointF(width, pageDefaultHeight / composerModel2.getDoc().getPageDefaultWidth());
        for (int i = 0; i < size; i++) {
            this.this$0.initTemplateGroup(this.$templatePage.getGroups().get(i), pageSize, pointF, this.$targetPageIndex);
        }
        this.$countDownLatch.countDown();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C9879xafe08dc3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
