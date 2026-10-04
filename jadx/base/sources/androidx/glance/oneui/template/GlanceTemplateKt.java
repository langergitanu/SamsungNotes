package androidx.glance.oneui.template;

import androidx.glance.ImageKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.text.FontFamily;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"ImageWithBackgroundDataNotDefined", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getImageWithBackgroundDataNotDefined", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "TypedTextDataNotDefined", "Landroidx/glance/oneui/template/TypedTextData;", "getTypedTextDataNotDefined", "()Landroidx/glance/oneui/template/TypedTextData;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class GlanceTemplateKt {

    @NotNull
    private static final ImageWithBackgroundData ImageWithBackgroundDataNotDefined = new ImageWithBackgroundData(ImageKt.ImageProvider(0), "", null, null, 0, null, null, false, 252, null);

    @NotNull
    private static final TypedTextData TypedTextDataNotDefined = new TypedTextData("", TextType.INSTANCE.m21694getTitlegxbDmow(), (ColorProvider) null, 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 65532, (DefaultConstructorMarker) null);

    @NotNull
    public static final ImageWithBackgroundData getImageWithBackgroundDataNotDefined() {
        return ImageWithBackgroundDataNotDefined;
    }

    @NotNull
    public static final TypedTextData getTypedTextDataNotDefined() {
        return TypedTextDataNotDefined;
    }
}
