package androidx.glance.oneui.template;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0017\u0018\u00002\u00020\u0001B£\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001cB¥\u0001\b\u0016\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001eB\u0097\u0001\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\"\u0010\u0006\u001a\u00020\u0007X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u0010\u001b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0019\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\b7\u0010*R\u0011\u00108\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0011\u0010\u001d\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\"\u0010\u0019\u001a\u00020\u001aX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, m13886d2 = {"Landroidx/glance/oneui/template/TextData;", "Landroidx/glance/oneui/template/BaseComponent;", "text", "", "textColor", "Landroidx/glance/unit/ColorProvider;", "textAlign", "Landroidx/glance/text/TextAlign;", "textDecoration", "Landroidx/glance/text/TextDecoration;", "textDirection", "Landroidx/glance/text/TextDirection;", "fontFamily", "Landroidx/glance/text/FontFamily;", "maxLines", "", "enabled", "", "hasShadow", "textShadowStyle", "Landroidx/glance/text/TextShadowStyle;", "contentDescription", "animation", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "keepColor", "textVerticalAlign", "Landroidx/glance/text/TextVerticalAlign;", "textAppearanceResource", "(Ljava/lang/String;Landroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "textResId", "(ILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;ILandroidx/glance/unit/ColorProvider;ILandroidx/glance/text/TextDecoration;ILandroidx/glance/text/FontFamily;IZZLandroidx/glance/text/TextShadowStyle;Ljava/lang/String;Landroidx/glance/appwidget/animation/RemoteAnimation;ZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimation", "()Landroidx/glance/appwidget/animation/RemoteAnimation;", "getContentDescription", "()Ljava/lang/String;", "getEnabled", "()Z", "getFontFamily", "()Landroidx/glance/text/FontFamily;", "getHasShadow", "getMaxLines$glance_oneui_template_release", "()I", "setMaxLines$glance_oneui_template_release", "(I)V", "getText", "getTextAlign-ROrN78o$glance_oneui_template_release", "setTextAlign-b1p-sNo$glance_oneui_template_release", "I", "getTextAppearanceResource", "setTextAppearanceResource", "getTextColor", "()Landroidx/glance/unit/ColorProvider;", "getTextDecoration-W4vNVHs", "()Landroidx/glance/text/TextDecoration;", "getTextDirection-yyWj0Bs", "textLength", "getTextLength", "(Landroidx/compose/runtime/Composer;I)I", "getTextResId", "getTextShadowStyle", "()Landroidx/glance/text/TextShadowStyle;", "getTextVerticalAlign-J86Ipig", "setTextVerticalAlign-m3QoQYQ", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceTemplate.kt\nandroidx/glance/oneui/template/TextData\n+ 2 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocal\n*L\n1#1,673:1\n74#2:674\n*S KotlinDebug\n*F\n+ 1 GlanceTemplate.kt\nandroidx/glance/oneui/template/TextData\n*L\n224#1:674\n*E\n"})
public class TextData extends BaseComponent {
    public static final int $stable = 8;

    @Nullable
    private final RemoteAnimation animation;

    @Nullable
    private final String contentDescription;
    private final boolean enabled;

    @NotNull
    private final FontFamily fontFamily;
    private final boolean hasShadow;
    private int maxLines;

    @Nullable
    private final String text;
    private int textAlign;
    private int textAppearanceResource;

    @Nullable
    private final ColorProvider textColor;

    @Nullable
    private final TextDecoration textDecoration;
    private final int textDirection;
    private final int textResId;

    @NotNull
    private final TextShadowStyle textShadowStyle;
    private int textVerticalAlign;

    public /* synthetic */ TextData(@StringRes int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str, remoteAnimation, z3, i6, i7);
    }

    @Nullable
    public final RemoteAnimation getAnimation() {
        return this.animation;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final boolean getHasShadow() {
        return this.hasShadow;
    }

    /* JADX INFO: renamed from: getMaxLines$glance_oneui_template_release, reason: from getter */
    public final int getMaxLines() {
        return this.maxLines;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: getTextAlign-ROrN78o$glance_oneui_template_release, reason: not valid java name and from getter */
    public final int getTextAlign() {
        return this.textAlign;
    }

    public final int getTextAppearanceResource() {
        return this.textAppearanceResource;
    }

    @Nullable
    public final ColorProvider getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextDecoration-W4vNVHs, reason: not valid java name and from getter */
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    /* JADX INFO: renamed from: getTextDirection-yyWj0Bs, reason: not valid java name and from getter */
    public final int getTextDirection() {
        return this.textDirection;
    }

    @Composable
    @JvmName(name = "getTextLength")
    public final int getTextLength(@Nullable Composer composer, int i) {
        int length;
        composer.startReplaceableGroup(-831526062);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-831526062, i, -1, "androidx.glance.oneui.template.TextData.<get-textLength> (GlanceTemplate.kt:222)");
        }
        if (this.textResId != 0) {
            length = ((Context) composer.consume(androidx.glance.CompositionLocalsKt.getLocalContext())).getResources().getString(this.textResId).length();
        } else {
            String str = this.text;
            length = str != null ? str.length() : 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return length;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    @NotNull
    public final TextShadowStyle getTextShadowStyle() {
        return this.textShadowStyle;
    }

    /* JADX INFO: renamed from: getTextVerticalAlign-J86Ipig, reason: not valid java name and from getter */
    public final int getTextVerticalAlign() {
        return this.textVerticalAlign;
    }

    public final void setMaxLines$glance_oneui_template_release(int i) {
        this.maxLines = i;
    }

    /* JADX INFO: renamed from: setTextAlign-b1p-sNo$glance_oneui_template_release, reason: not valid java name */
    public final void m21678setTextAlignb1psNo$glance_oneui_template_release(int i) {
        this.textAlign = i;
    }

    public final void setTextAppearanceResource(int i) {
        this.textAppearanceResource = i;
    }

    /* JADX INFO: renamed from: setTextVerticalAlign-m3QoQYQ, reason: not valid java name */
    public final void m21679setTextVerticalAlignm3QoQYQ(int i) {
        this.textVerticalAlign = i;
    }

    public /* synthetic */ TextData(String str, @StringRes int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i6, @StyleRes int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str2, remoteAnimation, z3, i6, i7);
    }

    public /* synthetic */ TextData(String str, ColorProvider colorProvider, int i, TextDecoration textDecoration, int i2, FontFamily fontFamily, int i4, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, colorProvider, i, textDecoration, i2, fontFamily, i4, z, z2, textShadowStyle, str2, remoteAnimation, z3, i5, i6);
    }

    public /* synthetic */ TextData(String str, int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str2, remoteAnimation, (i8 & 8192) != 0 ? false : z3, i6, (i8 & 32768) != 0 ? 0 : i7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private TextData(String str, int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7) {
        super(z3);
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
        this.text = str;
        this.textResId = i;
        this.textColor = colorProvider;
        this.textAlign = i2;
        this.textDecoration = textDecoration;
        this.textDirection = i4;
        this.fontFamily = fontFamily;
        this.maxLines = i5;
        this.enabled = z;
        this.hasShadow = z2;
        this.textShadowStyle = textShadowStyle;
        this.contentDescription = str2;
        this.animation = remoteAnimation;
        this.textVerticalAlign = i6;
        this.textAppearanceResource = i7;
        if (str == null && i == 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public /* synthetic */ TextData(String str, ColorProvider colorProvider, int i, TextDecoration textDecoration, int i2, FontFamily fontFamily, int i4, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str2, RemoteAnimation remoteAnimation, boolean z3, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i7 & 2) != 0 ? null : colorProvider, (i7 & 4) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i, (i7 & 8) != 0 ? null : textDecoration, (i7 & 16) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i2, (i7 & 32) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily, (i7 & 64) != 0 ? 1 : i4, (i7 & 128) != 0 ? true : z, (i7 & 256) != 0 ? false : z2, (i7 & 512) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i7 & 1024) != 0 ? null : str2, (i7 & 2048) != 0 ? null : remoteAnimation, (i7 & 4096) != 0 ? false : z3, (i7 & 8192) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i5, (i7 & 16384) != 0 ? 0 : i6, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextData(String text, ColorProvider colorProvider, int i, TextDecoration textDecoration, int i2, FontFamily fontFamily, int i4, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i5, int i6) {
        this(text, 0, colorProvider, i, textDecoration, i2, fontFamily, i4, z, z2, textShadowStyle, str, remoteAnimation, z3, i5, i6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
    }

    public /* synthetic */ TextData(int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i8 & 2) != 0 ? null : colorProvider, (i8 & 4) != 0 ? TextAlign.INSTANCE.m22011getStartROrN78o() : i2, (i8 & 8) != 0 ? null : textDecoration, (i8 & 16) != 0 ? TextDirection.INSTANCE.m22033getDefaultTextDirectionyyWj0Bs() : i4, (i8 & 32) != 0 ? FontFamily.INSTANCE.getSec() : fontFamily, (i8 & 64) != 0 ? 1 : i5, (i8 & 128) != 0 ? true : z, (i8 & 256) != 0 ? false : z2, (i8 & 512) != 0 ? new TextShadowStyle(0.0f, 0.0f, 0.0f, 0L, 15, null) : textShadowStyle, (i8 & 1024) != 0 ? null : str, (i8 & 2048) != 0 ? null : remoteAnimation, (i8 & 4096) != 0 ? false : z3, (i8 & 8192) != 0 ? TextVerticalAlign.INSTANCE.m22054getTopJ86Ipig() : i6, (i8 & 16384) != 0 ? 0 : i7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextData(int i, ColorProvider colorProvider, int i2, TextDecoration textDecoration, int i4, FontFamily fontFamily, int i5, boolean z, boolean z2, TextShadowStyle textShadowStyle, String str, RemoteAnimation remoteAnimation, boolean z3, int i6, int i7) {
        this((String) null, i, colorProvider, i2, textDecoration, i4, fontFamily, i5, z, z2, textShadowStyle, str, remoteAnimation, z3, i6, i7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(textShadowStyle, "textShadowStyle");
    }
}
