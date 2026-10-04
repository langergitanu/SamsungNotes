package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.input.EditCommand;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J.\u0010\u0014\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/Api34LegacyPerformHandwritingGestureImpl;", "", "()V", "performHandwritingGesture", "", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class Api34LegacyPerformHandwritingGestureImpl {

    @NotNull
    public static final Api34LegacyPerformHandwritingGestureImpl INSTANCE = new Api34LegacyPerformHandwritingGestureImpl();

    private Api34LegacyPerformHandwritingGestureImpl() {
    }

    @DoNotInline
    public final void performHandwritingGesture(@Nullable LegacyTextFieldState legacyTextFieldState, @Nullable TextFieldSelectionManager textFieldSelectionManager, @NotNull HandwritingGesture gesture, @Nullable ViewConfiguration viewConfiguration, @Nullable Executor executor, @Nullable IntConsumer consumer, @NotNull Function1<? super EditCommand, Unit> editCommandConsumer) {
        int iPerformHandwritingGesture$foundation_release = legacyTextFieldState != null ? HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation_release(legacyTextFieldState, gesture, textFieldSelectionManager, viewConfiguration, editCommandConsumer) : 3;
        if (consumer == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new RunnableC1345c(consumer, iPerformHandwritingGesture$foundation_release, 0));
        } else {
            consumer.accept(iPerformHandwritingGesture$foundation_release);
        }
    }

    @DoNotInline
    public final boolean previewHandwritingGesture(@Nullable LegacyTextFieldState legacyTextFieldState, @Nullable TextFieldSelectionManager textFieldSelectionManager, @NotNull PreviewableHandwritingGesture gesture, @Nullable CancellationSignal cancellationSignal) {
        if (legacyTextFieldState != null) {
            return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation_release(legacyTextFieldState, gesture, textFieldSelectionManager, cancellationSignal);
        }
        return false;
    }
}
