package androidx.compose.p109ui.autofill;

import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "getView", "()Landroid/view/View;", "cancelAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "requestAutofillForNode", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(26)
@ExperimentalComposeUiApi
@SourceDebugExtension({"SMAP\nAndroidAutofill.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidAutofill.android.kt\nandroidx/compose/ui/autofill/AndroidAutofill\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,143:1\n26#2:144\n26#2:145\n26#2:146\n26#2:147\n*S KotlinDebug\n*F\n+ 1 AndroidAutofill.android.kt\nandroidx/compose/ui/autofill/AndroidAutofill\n*L\n56#1:144\n57#1:145\n58#1:146\n59#1:147\n*E\n"})
public final class AndroidAutofill implements Autofill {
    public static final int $stable = 8;

    @NotNull
    private final AutofillManager autofillManager;

    @NotNull
    private final AutofillTree autofillTree;

    @NotNull
    private final View view;

    public AndroidAutofill(@NotNull View view, @NotNull AutofillTree autofillTree) {
        this.view = view;
        this.autofillTree = autofillTree;
        AutofillManager autofillManager = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        if (autofillManager == null) {
            throw new IllegalStateException("Autofill service could not be located.");
        }
        this.autofillManager = autofillManager;
        view.setImportantForAutofill(1);
    }

    @Override // androidx.compose.p109ui.autofill.Autofill
    public void cancelAutofillForNode(@NotNull AutofillNode autofillNode) {
        this.autofillManager.notifyViewExited(this.view, autofillNode.getId());
    }

    @NotNull
    public final AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    @NotNull
    public final AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    @Override // androidx.compose.p109ui.autofill.Autofill
    public void requestAutofillForNode(@NotNull AutofillNode autofillNode) {
        Rect boundingBox = autofillNode.getBoundingBox();
        if (boundingBox == null) {
            throw new IllegalStateException("requestAutofill called before onChildPositioned()");
        }
        this.autofillManager.notifyViewEntered(this.view, autofillNode.getId(), new android.graphics.Rect(Math.round(boundingBox.getLeft()), Math.round(boundingBox.getTop()), Math.round(boundingBox.getRight()), Math.round(boundingBox.getBottom())));
    }
}
