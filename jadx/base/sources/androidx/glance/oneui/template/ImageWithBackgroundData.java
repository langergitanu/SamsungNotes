package androidx.glance.oneui.template;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.ImageProvider;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m13886d2 = {"Landroidx/glance/oneui/template/ImageWithBackgroundData;", "Landroidx/glance/oneui/template/ImageData;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "imageType", "Landroidx/glance/oneui/template/ImageType;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "backgroundResId", "", "imageTintColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "keepColor", "", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/oneui/template/ImageType;Landroidx/glance/unit/ColorProvider;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation;Z)V", "getBackgroundColor$glance_oneui_template_release", "()Landroidx/glance/unit/ColorProvider;", "setBackgroundColor$glance_oneui_template_release", "(Landroidx/glance/unit/ColorProvider;)V", "getBackgroundResId", "()I", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class ImageWithBackgroundData extends ImageData {
    public static final int $stable = 8;

    @Nullable
    private ColorProvider backgroundColor;
    private final int backgroundResId;

    public /* synthetic */ ImageWithBackgroundData(ImageProvider imageProvider, String str, ImageType imageType, ColorProvider colorProvider, int i, ColorProvider colorProvider2, RemoteAnimation remoteAnimation, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageProvider, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? ImageType.Icon : imageType, (i2 & 8) != 0 ? null : colorProvider, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? null : colorProvider2, (i2 & 64) != 0 ? null : remoteAnimation, (i2 & 128) != 0 ? false : z);
    }

    @Nullable
    /* JADX INFO: renamed from: getBackgroundColor$glance_oneui_template_release, reason: from getter */
    public final ColorProvider getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBackgroundResId() {
        return this.backgroundResId;
    }

    public final void setBackgroundColor$glance_oneui_template_release(@Nullable ColorProvider colorProvider) {
        this.backgroundColor = colorProvider;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithBackgroundData(@NotNull ImageProvider imageProvider, @Nullable String str, @NotNull ImageType imageType, @Nullable ColorProvider colorProvider, @DrawableRes int i, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation remoteAnimation, boolean z) {
        super(imageProvider, str, imageType, colorProvider2, remoteAnimation, z);
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        this.backgroundColor = colorProvider;
        this.backgroundResId = i;
    }
}
