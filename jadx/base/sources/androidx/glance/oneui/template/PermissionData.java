package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/PermissionData;", "", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "mainText", "Landroidx/glance/oneui/template/TextData;", "subText", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;)V", "getIcon", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getMainText", "()Landroidx/glance/oneui/template/TextData;", "getSubText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PermissionData {
    public static final int $stable = 8;

    @NotNull
    private final ImageWithBackgroundData icon;

    @NotNull
    private final TextData mainText;

    @Nullable
    private final TextData subText;

    public PermissionData(@NotNull ImageWithBackgroundData icon, @NotNull TextData mainText, @Nullable TextData textData) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        this.icon = icon;
        this.mainText = mainText;
        this.subText = textData;
    }

    @NotNull
    public final ImageWithBackgroundData getIcon() {
        return this.icon;
    }

    @NotNull
    public final TextData getMainText() {
        return this.mainText;
    }

    @Nullable
    public final TextData getSubText() {
        return this.subText;
    }

    public /* synthetic */ PermissionData(ImageWithBackgroundData imageWithBackgroundData, TextData textData, TextData textData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageWithBackgroundData, textData, (i & 4) != 0 ? null : textData2);
    }
}
