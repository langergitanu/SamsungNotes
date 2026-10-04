package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import p188i3.RunnableC12034a;
import p204m3.RunnableC13531b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCutTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask;", "<init>", "()V", "runOnThread", "", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultCutTask extends AiResultCopyTask {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("SmCutTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCutTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return AiResultCutTask.TAG;
        }

        private Companion() {
        }
    }

    public AiResultCutTask() {
        super(TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$0(AiResultCutTask aiResultCutTask) {
        aiResultCutTask.getInputs().getTextManager().removeSelectedText(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void runOnThread$lambda$1(AiResultCutTask aiResultCutTask, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        aiResultCutTask.handleResult((Pair) objectRef.element, (Runnable) objectRef2.element);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, i3.a] */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCopyTask
    public void runOnThread() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        try {
            objectRef.element = copyText();
            objectRef2.element = new RunnableC12034a(this, 3);
        } catch (Exception e) {
            String tag = AiResultCopyTask.INSTANCE.getTAG();
            Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
            AbstractC12991c.m14005z("copy# ", e.getMessage(), tag);
        }
        getHandler().post(new RunnableC13531b(this, 0, objectRef, objectRef2));
    }
}
