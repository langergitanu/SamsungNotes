package androidx.glance.oneui.template;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
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
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/oneui/template/ImageButtonData;", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "imageType", "Landroidx/glance/oneui/template/ImageType;", "backgroundColor", "Landroidx/glance/unit/ColorProvider;", "backgroundResId", "", "imageTintColor", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "onClick", "Landroidx/glance/action/Action;", "enabled", "", "keepColor", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/oneui/template/ImageType;Landroidx/glance/unit/ColorProvider;ILandroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation;Landroidx/glance/action/Action;ZZ)V", "getEnabled", "()Z", "getOnClick", "()Landroidx/glance/action/Action;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class ImageButtonData extends ImageWithBackgroundData {
    public static final int $stable = 8;
    private final boolean enabled;

    @Nullable
    private final Action onClick;

    public /* synthetic */ ImageButtonData(ImageProvider imageProvider, String str, ImageType imageType, ColorProvider colorProvider, int i, ColorProvider colorProvider2, RemoteAnimation remoteAnimation, Action action, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageProvider, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? ImageType.Icon : imageType, (i2 & 8) != 0 ? null : colorProvider, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? null : colorProvider2, (i2 & 64) != 0 ? null : remoteAnimation, (i2 & 128) != 0 ? null : action, (i2 & 256) != 0 ? true : z, (i2 & 512) != 0 ? false : z2);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @Nullable
    public final Action getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageButtonData(@NotNull ImageProvider imageProvider, @Nullable String str, @NotNull ImageType imageType, @Nullable ColorProvider colorProvider, @DrawableRes int i, @Nullable ColorProvider colorProvider2, @Nullable RemoteAnimation remoteAnimation, @Nullable Action action, boolean z, boolean z2) {
        super(imageProvider, str, imageType, colorProvider, i, colorProvider2, remoteAnimation, z2);
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        this.onClick = action;
        this.enabled = z;
    }
}
