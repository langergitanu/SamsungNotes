package androidx.glance.oneui.template;

import androidx.annotation.StringRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.text.FontFamily;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextDirection;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001Bµ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0000H'¢\u0006\u0002\u0010#¨\u0006$"}, m13886d2 = {"Landroidx/glance/oneui/template/CustomTypedTextData;", "Landroidx/glance/oneui/template/TypedTextData;", "text", "", "textResId", "", "textType", "Landroidx/glance/oneui/template/TextType;", "textColor", "Landroidx/glance/unit/ColorProvider;", "textAlign", "Landroidx/glance/text/TextAlign;", "textDecoration", "Landroidx/glance/text/TextDecoration;", "textDirection", "Landroidx/glance/text/TextDirection;", "fontFamily", "Landroidx/glance/text/FontFamily;", "maxLines", "enabled", "", "hasShadow", "textShadowStyle", "Landroidx/glance/text/TextShadowStyle;", "contentDescription", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "keepColor", "textVerticalAlign", "Landroidx/glance/text/TextVerticalAlign;", "textAppearanceResource", "(Ljava/lang/String;IILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "CustomContent", "", "data", "(Landroidx/glance/oneui/template/CustomTypedTextData;Landroidx/compose/runtime/Composer;I)V", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class CustomTypedTextData extends TypedTextData {
    public static final int $stable = 0;

    public /* synthetic */ CustomTypedTextData(String str, @StringRes int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str2, remoteAnimation, z3, i7, i8);
    }

    @Composable
    public abstract void CustomContent(@NotNull CustomTypedTextData customTypedTextData, @Nullable Composer composer, int i);

    public /* synthetic */ CustomTypedTextData(String str, int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i9 & 2) != 0 ? 0 : i, i2, (i9 & 8) != 0 ? null : colorProvider, (i9 & 16) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i4, (i9 & 32) != 0 ? null : textDecoration, (i9 & 64) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i5, (i9 & 128) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily, (i9 & 256) != 0 ? 1 : i6, (i9 & 512) != 0 ? true : z, (i9 & 1024) != 0 ? false : z2, (i9 & 2048) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i9 & 4096) != 0 ? null : str2, (i9 & 8192) != 0 ? null : remoteAnimation, (i9 & 16384) != 0 ? false : z3, (32768 & i9) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i7, (i9 & 65536) != 0 ? 0 : i8, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private CustomTypedTextData(String str, int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8) {
        super(str, i, i2, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str2, remoteAnimation, z3, i7, i8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
    }
}
