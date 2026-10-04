package androidx.compose.p109ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.BlendMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0006H\u0001¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, m13886d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidBlendMode_androidKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlendMode.values().length];
            try {
                BlendMode unused = BlendMode.CLEAR;
                iArr[BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BlendMode unused3 = BlendMode.SRC;
                iArr[BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BlendMode unused5 = BlendMode.DST;
                iArr[BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BlendMode unused7 = BlendMode.SRC_OVER;
                iArr[BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                BlendMode unused9 = BlendMode.DST_OVER;
                iArr[BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                BlendMode unused11 = BlendMode.SRC_IN;
                iArr[BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                BlendMode unused13 = BlendMode.DST_IN;
                iArr[BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                BlendMode unused15 = BlendMode.SRC_OUT;
                iArr[BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                BlendMode unused17 = BlendMode.DST_OUT;
                iArr[BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                BlendMode unused19 = BlendMode.SRC_ATOP;
                iArr[BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                BlendMode unused21 = BlendMode.DST_ATOP;
                iArr[BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                BlendMode unused23 = BlendMode.XOR;
                iArr[BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                BlendMode unused25 = BlendMode.PLUS;
                iArr[BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                BlendMode unused27 = BlendMode.MODULATE;
                iArr[BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                BlendMode unused29 = BlendMode.SCREEN;
                iArr[BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                BlendMode unused31 = BlendMode.OVERLAY;
                iArr[BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                BlendMode unused33 = BlendMode.DARKEN;
                iArr[BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                BlendMode unused35 = BlendMode.LIGHTEN;
                iArr[BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                BlendMode unused37 = BlendMode.COLOR_DODGE;
                iArr[BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                BlendMode unused39 = BlendMode.COLOR_BURN;
                iArr[BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                BlendMode unused41 = BlendMode.HARD_LIGHT;
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                BlendMode unused43 = BlendMode.SOFT_LIGHT;
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                BlendMode unused45 = BlendMode.DIFFERENCE;
                iArr[BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                BlendMode unused47 = BlendMode.EXCLUSION;
                iArr[BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                BlendMode unused49 = BlendMode.MULTIPLY;
                iArr[BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                BlendMode unused51 = BlendMode.HUE;
                iArr[BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                BlendMode unused53 = BlendMode.SATURATION;
                iArr[BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                BlendMode unused55 = BlendMode.COLOR;
                iArr[BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                BlendMode unused57 = BlendMode.LUMINOSITY;
                iArr[BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused58) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m18375isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m18436equalsimpl0(i, BlendMode.INSTANCE.m18467getSrcOver0nO6VwU()) || m18377toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    @RequiresApi(29)
    @NotNull
    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m18376toAndroidBlendModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.INSTANCE;
        return BlendMode.m18436equalsimpl0(i, companion.m18440getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m18436equalsimpl0(i, companion.m18463getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m18436equalsimpl0(i, companion.m18446getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m18436equalsimpl0(i, companion.m18467getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m18436equalsimpl0(i, companion.m18450getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m18436equalsimpl0(i, companion.m18465getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m18436equalsimpl0(i, companion.m18448getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m18436equalsimpl0(i, companion.m18466getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m18436equalsimpl0(i, companion.m18449getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m18436equalsimpl0(i, companion.m18464getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m18436equalsimpl0(i, companion.m18447getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m18436equalsimpl0(i, companion.m18468getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m18436equalsimpl0(i, companion.m18459getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m18436equalsimpl0(i, companion.m18456getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m18436equalsimpl0(i, companion.m18461getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m18436equalsimpl0(i, companion.m18458getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m18436equalsimpl0(i, companion.m18444getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m18436equalsimpl0(i, companion.m18454getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m18436equalsimpl0(i, companion.m18443getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m18436equalsimpl0(i, companion.m18442getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m18436equalsimpl0(i, companion.m18452getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m18436equalsimpl0(i, companion.m18462getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m18436equalsimpl0(i, companion.m18445getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m18436equalsimpl0(i, companion.m18451getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m18436equalsimpl0(i, companion.m18457getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m18436equalsimpl0(i, companion.m18453getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m18436equalsimpl0(i, companion.m18460getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m18436equalsimpl0(i, companion.m18441getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m18436equalsimpl0(i, companion.m18455getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    @RequiresApi(29)
    public static final int toComposeBlendMode(@NotNull android.graphics.BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.INSTANCE.m18440getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m18463getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m18446getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m18467getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m18450getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m18465getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m18448getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m18466getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m18449getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m18464getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m18447getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m18468getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m18459getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m18456getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m18461getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m18458getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m18444getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m18454getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m18443getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m18442getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m18452getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m18462getSoftlight0nO6VwU();
            case 23:
                return BlendMode.INSTANCE.m18445getDifference0nO6VwU();
            case 24:
                return BlendMode.INSTANCE.m18451getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m18457getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m18453getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m18460getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m18441getColor0nO6VwU();
            case 29:
                return BlendMode.INSTANCE.m18455getLuminosity0nO6VwU();
            default:
                return BlendMode.INSTANCE.m18467getSrcOver0nO6VwU();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m18377toPorterDuffModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.INSTANCE;
        return BlendMode.m18436equalsimpl0(i, companion.m18440getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m18436equalsimpl0(i, companion.m18463getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m18436equalsimpl0(i, companion.m18446getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m18436equalsimpl0(i, companion.m18467getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m18436equalsimpl0(i, companion.m18450getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m18436equalsimpl0(i, companion.m18465getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m18436equalsimpl0(i, companion.m18448getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m18436equalsimpl0(i, companion.m18466getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m18436equalsimpl0(i, companion.m18449getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m18436equalsimpl0(i, companion.m18464getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m18436equalsimpl0(i, companion.m18447getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m18436equalsimpl0(i, companion.m18468getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m18436equalsimpl0(i, companion.m18459getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m18436equalsimpl0(i, companion.m18461getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m18436equalsimpl0(i, companion.m18458getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m18436equalsimpl0(i, companion.m18444getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m18436equalsimpl0(i, companion.m18454getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m18436equalsimpl0(i, companion.m18456getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
