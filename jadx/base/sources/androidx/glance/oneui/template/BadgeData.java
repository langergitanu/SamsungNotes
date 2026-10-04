package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/template/BadgeData;", "Landroidx/glance/oneui/template/BaseComponent;", "text", "", "collapsed", "", "textColor", "Landroidx/glance/unit/ColorProvider;", "backgroundColor", "keepColor", "(Ljava/lang/String;ZLandroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Z)V", "getBackgroundColor", "()Landroidx/glance/unit/ColorProvider;", "getCollapsed", "()Z", "getText", "()Ljava/lang/String;", "getTextColor", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class BadgeData extends BaseComponent {
    public static final int $stable = 8;

    @Nullable
    private final ColorProvider backgroundColor;
    private final boolean collapsed;

    @NotNull
    private final String text;

    @Nullable
    private final ColorProvider textColor;

    public /* synthetic */ BadgeData(String str, boolean z, ColorProvider colorProvider, ColorProvider colorProvider2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : colorProvider, (i & 8) != 0 ? null : colorProvider2, (i & 16) != 0 ? false : z2);
    }

    @Nullable
    public final ColorProvider getBackgroundColor() {
        return this.backgroundColor;
    }

    public final boolean getCollapsed() {
        return this.collapsed;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final ColorProvider getTextColor() {
        return this.textColor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgeData(@NotNull String text, boolean z, @Nullable ColorProvider colorProvider, @Nullable ColorProvider colorProvider2, boolean z2) {
        super(z2);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.collapsed = z;
        this.textColor = colorProvider;
        this.backgroundColor = colorProvider2;
    }
}
