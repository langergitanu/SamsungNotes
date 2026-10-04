package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.CopyResult;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.ObjectCopy;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.TextCopy;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuCopy;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001a\u001b\u001cB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0014\u0018\u00010\u0012J\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00140\u0012J0\u0010\u0016\u001a\u00020\u000e2\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0014\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask$Results;", "tag", "", "<init>", "(Ljava/lang/String;)V", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "run", "", "clear", "runOnThread", "copyText", "Lkotlin/Pair;", "Landroid/content/ClipData$Item;", "", "copyStroke", "handleResult", "result", "endAction", "Ljava/lang/Runnable;", "Inputs", "Results", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SmCopyTask extends SmTask<Inputs, Results> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmCopyTask");

    @NotNull
    private final Handler handler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmCopyTask.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask$Inputs;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Inputs;", "context", "Landroid/content/Context;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;)V", "getContext", "()Landroid/content/Context;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Inputs implements SmTask.Inputs {

        @NotNull
        private final Context context;

        @NotNull
        private final SmObjectManager objectManager;

        @NotNull
        private final SmTextManager textManager;

        public Inputs(@NotNull Context context, @NotNull SmObjectManager objectManager, @NotNull SmTextManager textManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(objectManager, "objectManager");
            Intrinsics.checkNotNullParameter(textManager, "textManager");
            this.context = context;
            this.objectManager = objectManager;
            this.textManager = textManager;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final SmObjectManager getObjectManager() {
            return this.objectManager;
        }

        @NotNull
        public final SmTextManager getTextManager() {
            return this.textManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask$Results;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTask$Results;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "showErrorToast", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Results implements SmTask.Results {

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
    public SmCopyTask(@NotNull String tag) {
        super(tag);
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.handler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$1(SmCopyTask smCopyTask) {
        smCopyTask.getInputs().getTextManager().clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$2(SmCopyTask smCopyTask) {
        smCopyTask.getInputs().getObjectManager().clearSelectObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void runOnThread$lambda$3(SmCopyTask smCopyTask, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        smCopyTask.handleResult((Pair) objectRef.element, (Runnable) objectRef2.element);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.ITask
    public void clear() {
        SmLogger.m8662e(TAG, "clear#");
        this.handler.removeCallbacksAndMessages(null);
        clearService();
    }

    @NotNull
    public final Pair<ClipData.Item, String[]> copyStroke() {
        SmLogger.m8662e(TAG, "copyStroke#");
        CopyResult copyResultCopyObject = new ObjectCopy(SmContextMenuCopy.INSTANCE.getTAG(), new ObjectCopy.Contract() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmCopyTask$copyStroke$objectCopy$1
            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            public void addPdfImageObject(Context context, String str, ArrayList<SpenObjectBase> arrayList) {
                ObjectCopy.Contract.DefaultImpls.addPdfImageObject(this, context, str, arrayList);
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            public Bitmap getSelectedObjectBitmap() {
                return this.this$0.getInputs().getObjectManager().getSelectedObjectBitmap();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            public String saveAsImage(SpenObjectBase spenObjectBase, String str) {
                return ObjectCopy.Contract.DefaultImpls.saveAsImage(this, spenObjectBase, str);
            }
        }).copyObject(getInputs().getContext(), getInputs().getObjectManager().getNote(), getInputs().getObjectManager().getSelectedObjectList());
        return new Pair<>(copyResultCopyObject.makeClipDataItem(), copyResultCopyObject.getMimeType());
    }

    @Nullable
    public final Pair<ClipData.Item, String[]> copyText() {
        SmLogger.m8662e(TAG, "copyText#");
        TextCopy textCopy = new TextCopy(SmContextMenuCopy.INSTANCE.getTAG(), new TextCopy.Contract() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmCopyTask$copyText$textCopy$1
            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.Contract
            public TextCopy.IObjectSpanConverter makeObjectSpanConverter(Context context, String str) {
                return TextCopy.Contract.DefaultImpls.makeObjectSpanConverter(this, context, str);
            }
        });
        int[] cursor = getInputs().getTextManager().getCursor();
        CopyResult copyResultCopyText = textCopy.copyText(getInputs().getContext(), getInputs().getObjectManager().getNote(), getInputs().getTextManager().getTextBox(), cursor[0], cursor[1]);
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
        SmLogger.m8662e(TAG, "handleResult#");
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

    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask
    public void run() {
        setExecutorService(Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG)));
        ExecutorService executorService = getExecutorService();
        if (executorService != null) {
            executorService.execute(new RunnableC8927a(this, 2));
        }
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.a] */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.a] */
    public void runOnThread() {
        SmLogger.m8662e(TAG, "runOnThread#");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        try {
            if (getInputs().getObjectManager().isSelectedTextBox()) {
                objectRef.element = copyText();
                objectRef2.element = new RunnableC8927a(this, 0);
            } else if (getInputs().getObjectManager().isSelectedObject()) {
                objectRef.element = copyStroke();
                objectRef2.element = new RunnableC8927a(this, 1);
            }
        } catch (Exception e) {
            SmLogger.m8662e(TAG, "copy# " + e.getMessage());
        }
        this.handler.post(new RunnableC8928b(this, 0, objectRef, objectRef2));
    }

    public SmCopyTask() {
        this(TAG);
    }
}
