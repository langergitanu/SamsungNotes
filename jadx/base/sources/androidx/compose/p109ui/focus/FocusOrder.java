package androidx.compose.p109ui.focus;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Deprecated(message = "Use FocusProperties instead")
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000b¨\u0006!"}, m13886d2 = {"Landroidx/compose/ui/focus/FocusOrder;", "", "()V", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "(Landroidx/compose/ui/focus/FocusProperties;)V", "down", "Landroidx/compose/ui/focus/FocusRequester;", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FocusOrder {
    public static final int $stable = 8;

    @NotNull
    private final FocusProperties focusProperties;

    public FocusOrder(@NotNull FocusProperties focusProperties) {
        this.focusProperties = focusProperties;
    }

    @NotNull
    public final FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    @NotNull
    public final FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    @NotNull
    public final FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    @NotNull
    public final FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    @NotNull
    public final FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    @NotNull
    public final FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    @NotNull
    public final FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    @NotNull
    public final FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setDown(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setDown(focusRequester);
    }

    public final void setEnd(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setEnd(focusRequester);
    }

    public final void setLeft(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setLeft(focusRequester);
    }

    public final void setNext(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setNext(focusRequester);
    }

    public final void setPrevious(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setPrevious(focusRequester);
    }

    public final void setRight(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setRight(focusRequester);
    }

    public final void setStart(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setStart(focusRequester);
    }

    public final void setUp(@NotNull FocusRequester focusRequester) {
        this.focusProperties.setUp(focusRequester);
    }

    public FocusOrder() {
        this(new FocusPropertiesImpl());
    }
}
