package androidx.compose.foundation.text;

import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.SpanStyle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "builder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "replaceStyle", "", "style", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class TextAnnotatorScope {

    @NotNull
    private final AnnotatedString.Builder builder;

    public TextAnnotatorScope(@NotNull AnnotatedString.Builder builder) {
        this.builder = builder;
    }

    public final void replaceStyle(@NotNull SpanStyle style, int start, int end) {
        this.builder.addStyle(style, start, end);
    }
}
