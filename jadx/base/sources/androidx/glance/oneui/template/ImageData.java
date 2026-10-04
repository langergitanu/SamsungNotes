package androidx.glance.oneui.template;

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
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m13886d2 = {"Landroidx/glance/oneui/template/ImageData;", "Landroidx/glance/oneui/template/BaseComponent;", "imageProvider", "Landroidx/glance/ImageProvider;", "contentDescription", "", "imageType", "Landroidx/glance/oneui/template/ImageType;", "imageTintColor", "Landroidx/glance/unit/ColorProvider;", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "keepColor", "", "(Landroidx/glance/ImageProvider;Ljava/lang/String;Landroidx/glance/oneui/template/ImageType;Landroidx/glance/unit/ColorProvider;Landroidx/glance/appwidget/animation/RemoteAnimation;Z)V", "getAnimation", "()Landroidx/glance/appwidget/animation/RemoteAnimation;", "getContentDescription", "()Ljava/lang/String;", "getImageProvider", "()Landroidx/glance/ImageProvider;", "getImageTintColor$glance_oneui_template_release", "()Landroidx/glance/unit/ColorProvider;", "setImageTintColor$glance_oneui_template_release", "(Landroidx/glance/unit/ColorProvider;)V", "getImageType$glance_oneui_template_release", "()Landroidx/glance/oneui/template/ImageType;", "setImageType$glance_oneui_template_release", "(Landroidx/glance/oneui/template/ImageType;)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class ImageData extends BaseComponent {
    public static final int $stable = 8;

    @Nullable
    private final RemoteAnimation animation;

    @Nullable
    private final String contentDescription;

    @NotNull
    private final ImageProvider imageProvider;

    @Nullable
    private ColorProvider imageTintColor;

    @NotNull
    private ImageType imageType;

    public /* synthetic */ ImageData(ImageProvider imageProvider, String str, ImageType imageType, ColorProvider colorProvider, RemoteAnimation remoteAnimation, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageProvider, (i & 2) != 0 ? null : str, (i & 4) != 0 ? ImageType.Icon : imageType, (i & 8) != 0 ? null : colorProvider, (i & 16) != 0 ? null : remoteAnimation, (i & 32) != 0 ? false : z);
    }

    @Nullable
    public final RemoteAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @NotNull
    public final ImageProvider getImageProvider() {
        return this.imageProvider;
    }

    @Nullable
    /* JADX INFO: renamed from: getImageTintColor$glance_oneui_template_release, reason: from getter */
    public final ColorProvider getImageTintColor() {
        return this.imageTintColor;
    }

    @NotNull
    /* JADX INFO: renamed from: getImageType$glance_oneui_template_release, reason: from getter */
    public final ImageType getImageType() {
        return this.imageType;
    }

    public final void setImageTintColor$glance_oneui_template_release(@Nullable ColorProvider colorProvider) {
        this.imageTintColor = colorProvider;
    }

    public final void setImageType$glance_oneui_template_release(@NotNull ImageType imageType) {
        Intrinsics.checkNotNullParameter(imageType, "<set-?>");
        this.imageType = imageType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageData(@NotNull ImageProvider imageProvider, @Nullable String str, @NotNull ImageType imageType, @Nullable ColorProvider colorProvider, @Nullable RemoteAnimation remoteAnimation, boolean z) {
        super(z);
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        this.imageProvider = imageProvider;
        this.contentDescription = str;
        this.imageType = imageType;
        this.imageTintColor = colorProvider;
        this.animation = remoteAnimation;
    }
}
