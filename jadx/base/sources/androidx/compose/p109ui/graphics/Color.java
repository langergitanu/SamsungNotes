package androidx.compose.p109ui.graphics;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.graphics.colorspace.ColorSpace;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p109ui.graphics.colorspace.Rgb;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b&\u0010\u0013J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J=\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, m13886d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", MarkdownConverter.PREFIX_NAME, "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nColor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/Color\n+ 2 ColorSpaces.kt\nandroidx/compose/ui/graphics/colorspace/ColorSpaces\n+ 3 Float16.kt\nandroidx/compose/ui/graphics/Float16Kt\n+ 4 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,723:1\n322#2:724\n650#3,12:725\n662#3,17:738\n650#3,12:755\n662#3,17:768\n650#3,12:785\n662#3,17:798\n22#4:737\n22#4:767\n22#4:797\n*S KotlinDebug\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/Color\n*L\n128#1:724\n164#1:725,12\n164#1:738,17\n186#1:755,12\n186#1:768,17\n208#1:785,12\n208#1:798,17\n164#1:737\n186#1:767\n208#1:797\n*E\n"})
public final class Color {
    private final long value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long Black = ColorKt.Color(4278190080L);
    private static final long DarkGray = ColorKt.Color(4282664004L);
    private static final long Gray = ColorKt.Color(4287137928L);
    private static final long LightGray = ColorKt.Color(4291611852L);
    private static final long White = ColorKt.Color(4294967295L);
    private static final long Red = ColorKt.Color(4294901760L);
    private static final long Green = ColorKt.Color(4278255360L);
    private static final long Blue = ColorKt.Color(4278190335L);
    private static final long Yellow = ColorKt.Color(4294967040L);
    private static final long Cyan = ColorKt.Color(4278255615L);
    private static final long Magenta = ColorKt.Color(4294902015L);
    private static final long Transparent = ColorKt.Color(0);
    private static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J(\u00107\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020/H\u0002J?\u0010=\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010>\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00106J(\u0010@\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R$\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007R$\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0007R$\u0010'\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007R$\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, m13886d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", VPathDataCmd.RCurveTo, "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nColor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/Color$Companion\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/graphics/InlineClassHelperKt\n*L\n1#1,723:1\n33#2,7:724\n33#2,7:731\n*S KotlinDebug\n*F\n+ 1 Color.kt\nandroidx/compose/ui/graphics/Color$Companion\n*L\n349#1:724,7\n384#1:731,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: hsl-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m18549hslJlNiLsg$default(Companion companion, float f, float f4, float f5, float f6, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f6 = 1.0f;
            }
            float f7 = f6;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m18564hslJlNiLsg(f, f4, f5, f7, rgb);
        }

        private final float hslToRgbComponent(int n, float h, float s, float l) {
            float f = ((h / 30.0f) + n) % 12.0f;
            return l - (Math.max(-1.0f, Math.min(f - 3, Math.min(9 - f, 1.0f))) * (Math.min(l, 1.0f - l) * s));
        }

        /* JADX INFO: renamed from: hsv-JlNiLsg$default, reason: not valid java name */
        public static /* synthetic */ long m18550hsvJlNiLsg$default(Companion companion, float f, float f4, float f5, float f6, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f6 = 1.0f;
            }
            float f7 = f6;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m18565hsvJlNiLsg(f, f4, f5, f7, rgb);
        }

        private final float hsvToRgbComponent(int n, float h, float s, float v) {
            float f = ((h / 60.0f) + n) % 6.0f;
            return v - (Math.max(0.0f, Math.min(f, Math.min(4 - f, 1.0f))) * (s * v));
        }

        /* JADX INFO: renamed from: getBlack-0d7_KjU, reason: not valid java name */
        public final long m18551getBlack0d7_KjU() {
            return Color.Black;
        }

        /* JADX INFO: renamed from: getBlue-0d7_KjU, reason: not valid java name */
        public final long m18552getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* JADX INFO: renamed from: getCyan-0d7_KjU, reason: not valid java name */
        public final long m18553getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* JADX INFO: renamed from: getDarkGray-0d7_KjU, reason: not valid java name */
        public final long m18554getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* JADX INFO: renamed from: getGray-0d7_KjU, reason: not valid java name */
        public final long m18555getGray0d7_KjU() {
            return Color.Gray;
        }

        /* JADX INFO: renamed from: getGreen-0d7_KjU, reason: not valid java name */
        public final long m18556getGreen0d7_KjU() {
            return Color.Green;
        }

        /* JADX INFO: renamed from: getLightGray-0d7_KjU, reason: not valid java name */
        public final long m18557getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* JADX INFO: renamed from: getMagenta-0d7_KjU, reason: not valid java name */
        public final long m18558getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* JADX INFO: renamed from: getRed-0d7_KjU, reason: not valid java name */
        public final long m18559getRed0d7_KjU() {
            return Color.Red;
        }

        /* JADX INFO: renamed from: getTransparent-0d7_KjU, reason: not valid java name */
        public final long m18560getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* JADX INFO: renamed from: getUnspecified-0d7_KjU, reason: not valid java name */
        public final long m18561getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* JADX INFO: renamed from: getWhite-0d7_KjU, reason: not valid java name */
        public final long m18562getWhite0d7_KjU() {
            return Color.White;
        }

        /* JADX INFO: renamed from: getYellow-0d7_KjU, reason: not valid java name */
        public final long m18563getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* JADX INFO: renamed from: hsl-JlNiLsg, reason: not valid java name */
        public final long m18564hslJlNiLsg(float hue, float saturation, float lightness, float alpha, @NotNull Rgb colorSpace) {
            if (!(0.0f <= hue && hue <= 360.0f && 0.0f <= saturation && saturation <= 1.0f && 0.0f <= lightness && lightness <= 1.0f)) {
                StringBuilder sbM1176v = AbstractC0622a.m1176v("HSL (", hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA);
                sbM1176v.append(lightness);
                sbM1176v.append(") must be in range (0..360, 0..1, 0..1)");
                InlineClassHelperKt.throwIllegalArgumentException(sbM1176v.toString());
            }
            return ColorKt.Color(hslToRgbComponent(0, hue, saturation, lightness), hslToRgbComponent(8, hue, saturation, lightness), hslToRgbComponent(4, hue, saturation, lightness), alpha, colorSpace);
        }

        /* JADX INFO: renamed from: hsv-JlNiLsg, reason: not valid java name */
        public final long m18565hsvJlNiLsg(float hue, float saturation, float value, float alpha, @NotNull Rgb colorSpace) {
            if (!(0.0f <= hue && hue <= 360.0f && 0.0f <= saturation && saturation <= 1.0f && 0.0f <= value && value <= 1.0f)) {
                StringBuilder sbM1176v = AbstractC0622a.m1176v("HSV (", hue, SQLKeyword.COMMA, saturation, SQLKeyword.COMMA);
                sbM1176v.append(value);
                sbM1176v.append(") must be in range (0..360, 0..1, 0..1)");
                InlineClassHelperKt.throwIllegalArgumentException(sbM1176v.toString());
            }
            return ColorKt.Color(hsvToRgbComponent(5, hue, saturation, value), hsvToRgbComponent(3, hue, saturation, value), hsvToRgbComponent(1, hue, saturation, value), alpha, colorSpace);
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: getBlack-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18536getBlack0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getBlue-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18537getBlue0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getCyan-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18538getCyan0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getDarkGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18539getDarkGray0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18540getGray0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getGreen-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18541getGreen0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getLightGray-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18542getLightGray0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getMagenta-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18543getMagenta0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getRed-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18544getRed0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getTransparent-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18545getTransparent0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18546getUnspecified0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getWhite-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18547getWhite0d7_KjU$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getYellow-0d7_KjU$annotations, reason: not valid java name */
        public static /* synthetic */ void m18548getYellow0d7_KjU$annotations() {
        }
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Color m18515boximpl(long j) {
        return new Color(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m18516component1impl(long j) {
        return m18531getRedimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m18517component2impl(long j) {
        return m18530getGreenimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component3-impl, reason: not valid java name */
    public static final float m18518component3impl(long j) {
        return m18528getBlueimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component4-impl, reason: not valid java name */
    public static final float m18519component4impl(long j) {
        return m18527getAlphaimpl(j);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: component5-impl, reason: not valid java name */
    public static final ColorSpace m18520component5impl(long j) {
        return m18529getColorSpaceimpl(j);
    }

    /* JADX INFO: renamed from: convert-vNxB06k, reason: not valid java name */
    public static final long m18522convertvNxB06k(long j, @NotNull ColorSpace colorSpace) {
        return ColorSpaceKt.m18944connectYBCOT_4$default(m18529getColorSpaceimpl(j), colorSpace, 0, 2, null).mo18947transformToColorl2rxGTc$ui_graphics_release(j);
    }

    @Stable
    /* JADX INFO: renamed from: copy-wmQWz5c, reason: not valid java name */
    public static final long m18523copywmQWz5c(long j, float f, float f4, float f5, float f6) {
        return ColorKt.Color(f4, f5, f6, f, m18529getColorSpaceimpl(j));
    }

    /* JADX INFO: renamed from: copy-wmQWz5c$default, reason: not valid java name */
    public static /* synthetic */ long m18524copywmQWz5c$default(long j, float f, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m18527getAlphaimpl(j);
        }
        float f7 = f;
        if ((i & 2) != 0) {
            f4 = m18531getRedimpl(j);
        }
        float f8 = f4;
        if ((i & 4) != 0) {
            f5 = m18530getGreenimpl(j);
        }
        float f9 = f5;
        if ((i & 8) != 0) {
            f6 = m18528getBlueimpl(j);
        }
        return m18523copywmQWz5c(j, f7, f8, f9, f6);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18525equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m18535unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18526equalsimpl0(long j, long j2) {
        return ULong.m22396equalsimpl0(j, j2);
    }

    /* JADX INFO: renamed from: getAlpha-impl, reason: not valid java name */
    public static final float m18527getAlphaimpl(long j) {
        float fUlongToDouble;
        float f;
        if (ULong.m22389constructorimpl(63 & j) == 0) {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            fUlongToDouble = (float) UnsignedKt.ulongToDouble(ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 6) & ErrorCodeConvertor.ERROR_ITEM_REQUEST_LIMIT_EXCEEEDED));
            f = 1023.0f;
        }
        return fUlongToDouble / f;
    }

    /* JADX INFO: renamed from: getBlue-impl, reason: not valid java name */
    public static final float m18528getBlueimpl(long j) {
        int i;
        int i2;
        int i4;
        if (ULong.m22389constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 32) & 255))) / 255.0f;
        }
        short sM22389constructorimpl = (short) ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 16) & 65535);
        int i5 = Short.MIN_VALUE & sM22389constructorimpl;
        int i6 = ((65535 & sM22389constructorimpl) >>> 10) & 31;
        int i7 = sM22389constructorimpl & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = i6 + 112;
            }
            int i9 = i;
            i2 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: getColorSpace-impl, reason: not valid java name */
    public static final ColorSpace m18529getColorSpaceimpl(long j) {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        return colorSpaces.getColorSpacesArray$ui_graphics_release()[(int) ULong.m22389constructorimpl(j & 63)];
    }

    /* JADX INFO: renamed from: getGreen-impl, reason: not valid java name */
    public static final float m18530getGreenimpl(long j) {
        int i;
        int i2;
        int i4;
        if (ULong.m22389constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 40) & 255))) / 255.0f;
        }
        short sM22389constructorimpl = (short) ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 32) & 65535);
        int i5 = Short.MIN_VALUE & sM22389constructorimpl;
        int i6 = ((65535 & sM22389constructorimpl) >>> 10) & 31;
        int i7 = sM22389constructorimpl & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = i6 + 112;
            }
            int i9 = i;
            i2 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i2);
    }

    /* JADX INFO: renamed from: getRed-impl, reason: not valid java name */
    public static final float m18531getRedimpl(long j) {
        int i;
        int i2;
        int i4;
        if (ULong.m22389constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 48) & 255))) / 255.0f;
        }
        short sM22389constructorimpl = (short) ULong.m22389constructorimpl(ULong.m22389constructorimpl(j >>> 48) & 65535);
        int i5 = Short.MIN_VALUE & sM22389constructorimpl;
        int i6 = ((65535 & sM22389constructorimpl) >>> 10) & 31;
        int i7 = sM22389constructorimpl & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = i6 + 112;
            }
            int i9 = i;
            i2 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18532hashCodeimpl(long j) {
        return ULong.m22401hashCodeimpl(j);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18533toStringimpl(long j) {
        return "Color(" + m18531getRedimpl(j) + SQLKeyword.COMMA + m18530getGreenimpl(j) + SQLKeyword.COMMA + m18528getBlueimpl(j) + SQLKeyword.COMMA + m18527getAlphaimpl(j) + SQLKeyword.COMMA + m18529getColorSpaceimpl(j).getName() + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m18525equalsimpl(this.value, obj);
    }

    /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name and from getter */
    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        return m18532hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m18533toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m18535unboximpl() {
        return this.value;
    }

    @Stable
    public static /* synthetic */ void getAlpha$annotations() {
    }

    @Stable
    public static /* synthetic */ void getBlue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getColorSpace$annotations() {
    }

    @Stable
    public static /* synthetic */ void getGreen$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRed$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m18521constructorimpl(long j) {
        return j;
    }
}
