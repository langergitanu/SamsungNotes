package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", "()V", "performHandwritingGesture", "", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "intConsumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class Api34PerformHandwritingGestureImpl {

    @NotNull
    public static final Api34PerformHandwritingGestureImpl INSTANCE = new Api34PerformHandwritingGestureImpl();

    private Api34PerformHandwritingGestureImpl() {
    }

    @DoNotInline
    public final void performHandwritingGesture(@NotNull TextInputSession session, @NotNull HandwritingGesture gesture, @Nullable Executor executor, @Nullable IntConsumer intConsumer) {
        int iPerformHandwritingGesture = session.performHandwritingGesture(gesture);
        if (intConsumer == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new RunnableC1345c(intConsumer, iPerformHandwritingGesture, 1));
        } else {
            intConsumer.accept(iPerformHandwritingGesture);
        }
    }

    @DoNotInline
    public final boolean previewHandwritingGesture(@NotNull TextInputSession session, @NotNull PreviewableHandwritingGesture gesture, @Nullable CancellationSignal cancellationSignal) {
        return session.previewHandwritingGesture(gesture, cancellationSignal);
    }
}
