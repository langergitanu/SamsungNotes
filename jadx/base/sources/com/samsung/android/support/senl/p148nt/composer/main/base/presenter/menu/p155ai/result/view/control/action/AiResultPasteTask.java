package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action;

import android.content.ClipData;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.composer.action.PasteHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask$Inputs;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask$Results;", "<init>", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "beginHistory", "", "getBeginHistory", "()Z", "setBeginHistory", "(Z)V", "run", "", "clear", "paste", "clipData", "Landroid/content/ClipData;", "pasteRawContents", "endHistoryGroup", "notifyCallback", "success", "results", "Inputs", "Results", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultPasteTask extends AiResultTask<Inputs, Results> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("SmPasteTask");
    private boolean beginHistory;

    @NotNull
    private Handler handler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return AiResultPasteTask.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask$Inputs;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Inputs;", "context", "Landroid/content/Context;", "textManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "clipData", "Landroid/content/ClipData;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;Landroid/content/ClipData;)V", "getContext", "()Landroid/content/Context;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/SimpleEditView;", "getClipData", "()Landroid/content/ClipData;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Inputs implements AiResultTask.Inputs {

        @NotNull
        private final ClipData clipData;

        @NotNull
        private final Context context;

        @NotNull
        private final SimpleEditView textManager;

        public Inputs(@NotNull Context context, @NotNull SimpleEditView textManager, @NotNull ClipData clipData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(textManager, "textManager");
            Intrinsics.checkNotNullParameter(clipData, "clipData");
            this.context = context;
            this.textManager = textManager;
            this.clipData = clipData;
        }

        @NotNull
        public final ClipData getClipData() {
            return this.clipData;
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
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultPasteTask$Results;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/control/action/AiResultTask$Results;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "showErrorToast", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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

    public AiResultPasteTask() {
        super(TAG);
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void endHistoryGroup() {
        if (this.beginHistory) {
            getInputs().getTextManager().getDocument().endHistoryGroup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void paste(ClipData clipData) {
        int i = 1;
        if (!getInputs().getTextManager().getDocument().isGroupingHistory()) {
            getInputs().getTextManager().getDocument().beginHistoryGroup();
            this.beginHistory = true;
        }
        getInputs().getTextManager().removeSelectedText(false);
        pasteRawContents(clipData);
        notifyCallback(true, new Results(null, i, 0 == true ? 1 : 0));
    }

    private final void pasteRawContents(ClipData clipData) {
        String text = getInputs().getTextManager().getTextBox().getText();
        if ((text != null ? text.length() : 0) >= 350000) {
            Context context = getInputs().getContext();
            String string = context.getString(C8875R.string.ss_maximum_number_of_characters_exceeded, 350000);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 0);
            return;
        }
        int itemCount = clipData.getItemCount();
        Logger.m12710d(getTag(), "pasteRawContents# clipData item count:" + itemCount);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (!TextUtils.isEmpty(itemAt.getHtmlText())) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(CharUtils.fromHtml(itemAt.getHtmlText()));
                PasteHelper pasteHelper = PasteHelper.INSTANCE;
                SpannableStringBuilder spannableStringBuilderRearrangeText = pasteHelper.rearrangeText(spannableStringBuilder2, 0, spannableStringBuilder2.length());
                pasteHelper.removeImageSpan(spannableStringBuilderRearrangeText);
                spannableStringBuilder.append((CharSequence) spannableStringBuilderRearrangeText);
            } else if (!TextUtils.isEmpty(itemAt.getText())) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(StringsKt.m14139M(itemAt.getText().toString(), "\r\n", "\n"));
                spannableStringBuilder.append((CharSequence) PasteHelper.INSTANCE.rearrangeText(spannableStringBuilder3, 0, spannableStringBuilder3.length()));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            Logger.m12710d(getTag(), "pasteRawContents# length " + spannableStringBuilder.length());
            SpenObjectTextBox spenObjectTextBoxMakeNewTextBox = getInputs().getTextManager().makeNewTextBox();
            spenObjectTextBoxMakeNewTextBox.insertText(spannableStringBuilder.toString(), 0);
            Intrinsics.checkNotNull(spenObjectTextBoxMakeNewTextBox);
            CharUtils.convertSpannablerToSpen(spannableStringBuilder, spenObjectTextBoxMakeNewTextBox);
            int[] cursor = getInputs().getTextManager().getCursor();
            SpenObjectTextBox textBox = getInputs().getTextManager().getTextBox();
            int i2 = cursor[0];
            String text2 = spenObjectTextBoxMakeNewTextBox.getText();
            Intrinsics.checkNotNull(text2);
            textBox.insertText(i2, spenObjectTextBoxMakeNewTextBox, 0, text2.length());
        }
        Logger.m12710d(getTag(), "pasteRawContents# end");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.ITask
    public void clear() {
        this.handler.removeCallbacksAndMessages(null);
        clearService();
    }

    public final boolean getBeginHistory() {
        return this.beginHistory;
    }

    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask
    public void run() {
        paste(getInputs().getClipData());
    }

    public final void setBeginHistory(boolean z) {
        this.beginHistory = z;
    }

    public final void setHandler(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTask
    public void notifyCallback(boolean success, @NotNull Results results) {
        Intrinsics.checkNotNullParameter(results, "results");
        endHistoryGroup();
        super.notifyCallback(success, results);
    }
}
