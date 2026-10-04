package androidx.compose.p109ui.text.platform;

import android.text.style.ClickableSpan;
import android.view.View;
import androidx.compose.p109ui.text.LinkAnnotation;
import androidx.compose.p109ui.text.LinkInteractionListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/text/platform/ComposeClickableSpan;", "Landroid/text/style/ClickableSpan;", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/LinkAnnotation;)V", "onClick", "", "widget", "Landroid/view/View;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ComposeClickableSpan extends ClickableSpan {

    @NotNull
    private final LinkAnnotation link;

    public ComposeClickableSpan(@NotNull LinkAnnotation linkAnnotation) {
        this.link = linkAnnotation;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        LinkInteractionListener linkInteractionListener = this.link.getLinkInteractionListener();
        if (linkInteractionListener != null) {
            linkInteractionListener.onClick(this.link);
        }
    }
}
