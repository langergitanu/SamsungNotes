package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action;

import android.content.ClipData;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.CopyResult;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.TextCopy;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p204m3.RunnableC13530a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0014\u0018\u00010\u0012J0\u0010\u0015\u001a\u00020\u000e2\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0014\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask$Inputs;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask$Results;", "tag", "", "<init>", "(Ljava/lang/String;)V", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "run", "", "clear", "runOnThread", "copyText", "Lkotlin/Pair;", "Landroid/content/ClipData$Item;", "", "handleResult", "result", "endAction", "Ljava/lang/Runnable;", "Inputs", "Results", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AiResultCopyTask extends AiResultTask<Inputs, Results> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Logger.createTag("SmCopyTask");

    @NotNull
    private final Handler handler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return AiResultCopyTask.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask$Inputs;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;)V", "getContext", "()Landroid/content/Context;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Inputs implements AiResultTask.Inputs {

        @NotNull
        private final Context context;

        @NotNull
        private final SimpleEditView textManager;

        public Inputs(@NotNull Context context, @NotNull SimpleEditView textManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(textManager, "textManager");
            this.context = context;
            this.textManager = textManager;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final SimpleEditView getTextManager() {
            return this.textManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultCopyTask$Results;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "showErrorToast", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Results implements AiResultTask.Results {

        @Nullable
        private final Context context;

        /* JADX WARN: Multi-variable type inference failed */
        public Results() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        public final Context getContext() {
            return this.context;
        }

        public final void showErrorToast() {
            Context context = this.context;
            if (context != null) {
                ToastHandler.show(context, C8875R.string.composer_failed_to_copy, 0);
            }
        }

        public Results(@Nullable Context context) {
            this.context = context;
        }

        public /* synthetic */ Results(Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiResultCopyTask(@NotNull String tag) {
        super(tag);
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$1(AiResultCopyTask aiResultCopyTask) {
        aiResultCopyTask.getInputs().getTextManager().clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void runOnThread$lambda$2(AiResultCopyTask aiResultCopyTask, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        aiResultCopyTask.handleResult((Pair) objectRef.element, (Runnable) objectRef2.element);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.ITask
    public void clear() {
        Logger.m11000e(TAG, "clear#");
        this.handler.removeCallbacksAndMessages(null);
        clearService();
    }

    @Nullable
    public final Pair<ClipData.Item, String[]> copyText() {
        Logger.m11000e(TAG, "copyText#");
        String tag = AiResultContextMenuCopy.INSTANCE.getTAG();
        Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
        TextCopy textCopy = new TextCopy(tag, new TextCopy.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.control.action.AiResultCopyTask$copyText$textCopy$1
            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.Contract
            public TextCopy.IObjectSpanConverter makeObjectSpanConverter(Context context, String str) {
                return TextCopy.Contract.DefaultImpls.makeObjectSpanConverter(this, context, str);
            }
        });
        int[] cursor = getInputs().getTextManager().getCursor();
        Context context = getInputs().getContext();
        SpenWNote document = getInputs().getTextManager().getDocument();
        Intrinsics.checkNotNullExpressionValue(document, "getDocument(...)");
        SpenObjectTextBox textBox = getInputs().getTextManager().getTextBox();
        Intrinsics.checkNotNullExpressionValue(textBox, "getTextBox(...)");
        CopyResult copyResultCopyText = textCopy.copyText(context, document, textBox, cursor[0], cursor[1]);
        if (copyResultCopyText != null) {
            return new Pair<>(copyResultCopyText.makeClipDataItem(), copyResultCopyText.getMimeType());
        }
        return null;
    }

    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleResult(@Nullable Pair<? extends ClipData.Item, String[]> result, @Nullable Runnable endAction) {
        Logger.m11000e(TAG, "handleResult#");
        if (endAction != null) {
            endAction.run();
        }
        if (result == null) {
            notifyCallback(false, new Results(getInputs().getContext()));
        } else {
            ClipboardManagerCompat.INSTANCE.getInstance().setClip(getInputs().getContext(), result.getFirst(), result.getSecond(), "");
            notifyCallback(true, new Results(null, 1, 0 == true ? 1 : 0));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask
    public void run() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        setExecutorService(Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG2)));
        ExecutorService executorService = getExecutorService();
        if (executorService != null) {
            executorService.execute(new RunnableC13530a(this, 1));
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, m3.a] */
    public void runOnThread() {
        Logger.m11000e(TAG, "runOnThread#");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        try {
            objectRef.element = copyText();
            objectRef2.element = new RunnableC13530a(this, 0);
        } catch (Exception e) {
            AbstractC8014b.m7198D("copy# ", e.getMessage(), TAG);
        }
        this.handler.post(new RunnableC8928b(this, 29, objectRef, objectRef2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AiResultCopyTask() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        this(TAG2);
    }
}
