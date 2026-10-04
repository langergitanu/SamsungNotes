package androidx.glance.oneui.template;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001%B«\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0002\u0010\u001eB\u00ad\u0001\b\u0016\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0002\u0010 B£\u0001\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0003\u0010\u001d\u001a\u00020\u0011¢\u0006\u0002\u0010!R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m13886d2 = {"Landroidx/glance/oneui/template/TypedTextData;", "Landroidx/glance/oneui/template/TextData;", "text", "", "textType", "Landroidx/glance/oneui/template/TextType;", "textColor", "Landroidx/glance/unit/ColorProvider;", "textAlign", "Landroidx/glance/text/TextAlign;", "textDecoration", "Landroidx/glance/text/TextDecoration;", "textDirection", "Landroidx/glance/text/TextDirection;", "fontFamily", "Landroidx/glance/text/FontFamily;", "maxLines", "", "enabled", "", "hasShadow", "textShadowStyle", "Landroidx/glance/text/TextShadowStyle;", "contentDescription", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "keepColor", "textVerticalAlign", "Landroidx/glance/text/TextVerticalAlign;", "textAppearanceResource", "(Ljava/lang/String;ILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "textResId", "(IILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;IILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextType-gxbDmow", "()I", "I", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public class TypedTextData extends TextData {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int textType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/oneui/template/TypedTextData$Companion;", "", "()V", "valueOf", "Landroidx/glance/oneui/template/TypedTextData;", "textData", "Landroidx/glance/oneui/template/TextData;", "textType", "Landroidx/glance/oneui/template/TextType;", "valueOf-6zbYUVM", "(Landroidx/glance/oneui/template/TextData;I)Landroidx/glance/oneui/template/TypedTextData;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* JADX INFO: renamed from: valueOf-6zbYUVM, reason: not valid java name */
        public final TypedTextData m21697valueOf6zbYUVM(@NotNull TextData textData, int textType) {
            Intrinsics.checkNotNullParameter(textData, "textData");
            return new TypedTextData(textData.getText(), textData.getTextResId(), textType, textData.getTextColor(), textData.getTextAlign(), textData.getTextDecoration(), textData.getTextDirection(), textData.getFontFamily(), textData.getMaxLines(), textData.getEnabled(), textData.getHasShadow(), textData.getTextShadowStyle(), textData.getContentDescription(), textData.getAnimation(), textData.getKeepColor(), textData.getTextVerticalAlign(), textData.getTextAppearanceResource(), (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ TypedTextData(@StringRes int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str, remoteAnimation, z3, i7, i8);
    }

    /* JADX INFO: renamed from: getTextType-gxbDmow, reason: not valid java name and from getter */
    public final int getTextType() {
        return this.textType;
    }

    public /* synthetic */ TypedTextData(String str, @StringRes int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, @StyleRes int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str2, remoteAnimation, z3, i7, i8);
    }

    public /* synthetic */ TypedTextData(String str, int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str2, remoteAnimation, z3, i6, i7);
    }

    public /* synthetic */ TypedTextData(String str, int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, colorProvider, (i9 & 16) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str2, remoteAnimation, (i9 & 16384) != 0 ? false : z3, (32768 & i9) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i7, (i9 & 65536) != 0 ? 0 : i8, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private TypedTextData(String str, int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8) {
        super(str, i, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str2, remoteAnimation, z3, i7, i8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
        this.textType = i2;
    }

    public /* synthetic */ TypedTextData(String str, int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i8 & 4) != 0 ? null : colorProvider, (i8 & 8) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i2, (i8 & 16) != 0 ? null : textDecoration, (i8 & 32) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i4, (i8 & 64) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily, (i8 & 128) != 0 ? 1 : i5, (i8 & 256) != 0 ? true : z, (i8 & 512) != 0 ? false : z2, (i8 & 1024) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i8 & 2048) != 0 ? null : str2, (i8 & 4096) != 0 ? null : remoteAnimation, (i8 & 8192) != 0 ? false : z3, (i8 & 16384) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i6, (i8 & 32768) != 0 ? 0 : i7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TypedTextData(String text, int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7) {
        this(text, 0, i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str, remoteAnimation, z3, i6, i7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
    }

    public /* synthetic */ TypedTextData(int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i9 & 4) != 0 ? null : colorProvider, (i9 & 8) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i4, (i9 & 16) != 0 ? null : textDecoration, (i9 & 32) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i5, (i9 & 64) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily, (i9 & 128) != 0 ? 1 : i6, (i9 & 256) != 0 ? true : z, (i9 & 512) != 0 ? false : z2, (i9 & 1024) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i9 & 2048) != 0 ? null : str, (i9 & 4096) != 0 ? null : remoteAnimation, (i9 & 8192) != 0 ? false : z3, (i9 & 16384) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i7, (i9 & 32768) != 0 ? 0 : i8, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TypedTextData(int i, int i2, ColorProvider colorProvider, int i4, TextDecoration textDecoration, int i5, FontFamily fontFamily, int i6, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i7, int i8) {
        this((String) null, i, i2, colorProvider, i4, textDecoration, i5, fontFamily, i6, z, z2, textShadowStyle, str, remoteAnimation, z3, i7, i8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
    }
}
