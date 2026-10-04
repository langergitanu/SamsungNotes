package androidx.compose.p109ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.p109ui.text.TtsAnnotation;
import androidx.compose.p109ui.text.VerbatimTtsAnnotation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, m13886d2 = {"toSpan", "Landroid/text/style/TtsSpan;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TtsAnnotationExtensions_androidKt {
    @NotNull
    public static final TtsSpan toSpan(@NotNull TtsAnnotation ttsAnnotation) {
        if (ttsAnnotation instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) ttsAnnotation);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final TtsSpan toSpan(@NotNull VerbatimTtsAnnotation verbatimTtsAnnotation) {
        return new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.getVerbatim()).build();
    }
}
