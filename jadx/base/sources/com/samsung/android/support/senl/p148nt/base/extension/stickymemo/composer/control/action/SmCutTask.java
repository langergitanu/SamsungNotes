package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCutTask;", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCopyTask;", "<init>", "()V", "runOnThread", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmCutTask extends SmCopyTask {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmCutTask");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmCutTask$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmCutTask.TAG;
        }

        private Companion() {
        }
    }

    public SmCutTask() {
        super(TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$0(SmCutTask smCutTask) {
        smCutTask.getInputs().getTextManager().removeSelectedText(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnThread$lambda$2(SmCutTask smCutTask) {
        ArrayList<SpenObjectBase> selectedObjectList = smCutTask.getInputs().getObjectManager().getSelectedObjectList();
        smCutTask.getInputs().getObjectManager().clearSelectObject();
        smCutTask.getInputs().getObjectManager().deleteObjectList(selectedObjectList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void runOnThread$lambda$3(SmCutTask smCutTask, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        smCutTask.handleResult((Pair) objectRef.element, (Runnable) objectRef2.element);
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v13, types: [T, com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.c] */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.c] */
    @Override // com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmCopyTask
    public void runOnThread() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        try {
            if (getInputs().getObjectManager().isSelectedTextBox()) {
                objectRef.element = copyText();
                final int i = 0;
                objectRef2.element = new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SmCutTask f6467b;

                    {
                        this.f6467b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                SmCutTask.runOnThread$lambda$0(this.f6467b);
                                break;
                            default:
                                SmCutTask.runOnThread$lambda$2(this.f6467b);
                                break;
                        }
                    }
                };
            } else if (getInputs().getObjectManager().isSelectedObject()) {
                objectRef.element = copyStroke();
                final int i2 = 1;
                objectRef2.element = new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SmCutTask f6467b;

                    {
                        this.f6467b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                SmCutTask.runOnThread$lambda$0(this.f6467b);
                                break;
                            default:
                                SmCutTask.runOnThread$lambda$2(this.f6467b);
                                break;
                        }
                    }
                };
            }
        } catch (Exception e) {
            SmLogger.m8662e(SmCopyTask.INSTANCE.getTAG(), "copy# " + e.getMessage());
        }
        getHandler().post(new RunnableC8928b(this, 1, objectRef, objectRef2));
    }
}
