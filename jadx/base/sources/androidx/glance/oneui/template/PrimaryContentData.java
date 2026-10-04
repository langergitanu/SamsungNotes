package androidx.glance.oneui.template;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m13886d2 = {"Landroidx/glance/oneui/template/PrimaryContentData;", "", "image", "Landroidx/glance/oneui/template/ImageData;", "(Landroidx/glance/oneui/template/ImageData;)V", "progressIndicator", "Landroidx/glance/oneui/template/CircularProgressData;", "(Landroidx/glance/oneui/template/CircularProgressData;)V", "(Landroidx/glance/oneui/template/ImageData;Landroidx/glance/oneui/template/CircularProgressData;)V", "getImage$glance_oneui_template_release", "()Landroidx/glance/oneui/template/ImageData;", "getProgressIndicator$glance_oneui_template_release", "()Landroidx/glance/oneui/template/CircularProgressData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PrimaryContentData {
    public static final int $stable = 8;

    @Nullable
    private final ImageData image;

    @Nullable
    private final CircularProgressData progressIndicator;

    private PrimaryContentData(ImageData imageData, CircularProgressData circularProgressData) {
        this.image = imageData;
        this.progressIndicator = circularProgressData;
    }

    @Nullable
    /* JADX INFO: renamed from: getImage$glance_oneui_template_release, reason: from getter */
    public final ImageData getImage() {
        return this.image;
    }

    @Nullable
    /* JADX INFO: renamed from: getProgressIndicator$glance_oneui_template_release, reason: from getter */
    public final CircularProgressData getProgressIndicator() {
        return this.progressIndicator;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrimaryContentData(@NotNull ImageData image) {
        this(image, null);
        Intrinsics.checkNotNullParameter(image, "image");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrimaryContentData(@NotNull CircularProgressData progressIndicator) {
        this(null, progressIndicator);
        Intrinsics.checkNotNullParameter(progressIndicator, "progressIndicator");
    }
}
