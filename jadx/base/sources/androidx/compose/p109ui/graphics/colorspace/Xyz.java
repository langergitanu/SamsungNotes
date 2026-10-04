package androidx.compose.p109ui.graphics.colorspace;

import androidx.compose.p109ui.graphics.ColorKt;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0082\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J%\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u001bJ=\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "clamp", "", "x", "fromXyz", "", VPathDataCmd.RCurveTo, "getMaxValue", "component", "getMinValue", "toXy", "", "v0", "v1", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nXyz.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Xyz.kt\nandroidx/compose/ui/graphics/colorspace/Xyz\n+ 2 MathHelpers.kt\nandroidx/compose/ui/util/MathHelpersKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,82:1\n79#1:83\n79#1:100\n79#1:117\n79#1:134\n79#1:154\n79#1:171\n79#1:188\n79#1:205\n79#1:222\n71#2,16:84\n71#2,16:101\n71#2,16:118\n71#2,16:135\n71#2,16:155\n71#2,16:172\n71#2,16:189\n71#2,16:206\n71#2,16:223\n71#2,16:239\n63#3,3:151\n*S KotlinDebug\n*F\n+ 1 Xyz.kt\nandroidx/compose/ui/graphics/colorspace/Xyz\n*L\n46#1:83\n47#1:100\n48#1:117\n53#1:134\n57#1:154\n67#1:171\n71#1:188\n72#1:205\n73#1:222\n46#1:84,16\n47#1:101,16\n48#1:118,16\n53#1:135,16\n57#1:155,16\n67#1:172,16\n71#1:189,16\n72#1:206,16\n73#1:223,16\n79#1:239,16\n53#1:151,3\n*E\n"})
public final class Xyz extends ColorSpace {
    public Xyz(@NotNull String str, int i) {
        super(str, ColorModel.INSTANCE.m18940getXyzxdoWZVw(), i, null);
    }

    private final float clamp(float x) {
        if (x < -2.0f) {
            x = -2.0f;
        }
        if (x > 2.0f) {
            return 2.0f;
        }
        return x;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v) {
        float f = v[0];
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        v[0] = f;
        float f4 = v[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        v[1] = f4;
        float f5 = v[2];
        float f6 = f5 >= -2.0f ? f5 : -2.0f;
        v[2] = f6 <= 2.0f ? f6 : 2.0f;
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return 2.0f;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return -2.0f;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: isWideGamut */
    public boolean getIsWideGamut() {
        return true;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v02, float v12, float v22) {
        if (v02 < -2.0f) {
            v02 = -2.0f;
        }
        if (v02 > 2.0f) {
            v02 = 2.0f;
        }
        if (v12 < -2.0f) {
            v12 = -2.0f;
        }
        return (((long) Float.floatToRawIntBits(v02)) << 32) | (((long) Float.floatToRawIntBits(v12 <= 2.0f ? v12 : 2.0f)) & 4294967295L);
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v) {
        float f = v[0];
        if (f < -2.0f) {
            f = -2.0f;
        }
        if (f > 2.0f) {
            f = 2.0f;
        }
        v[0] = f;
        float f4 = v[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        v[1] = f4;
        float f5 = v[2];
        float f6 = f5 >= -2.0f ? f5 : -2.0f;
        v[2] = f6 <= 2.0f ? f6 : 2.0f;
        return v;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v02, float v12, float v22) {
        if (v22 < -2.0f) {
            v22 = -2.0f;
        }
        if (v22 > 2.0f) {
            return 2.0f;
        }
        return v22;
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.ColorSpace
    /* JADX INFO: renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo18942xyzaToColorJlNiLsg$ui_graphics_release(float x, float y2, float z, float a, @NotNull ColorSpace colorSpace) {
        if (x < -2.0f) {
            x = -2.0f;
        }
        if (x > 2.0f) {
            x = 2.0f;
        }
        if (y2 < -2.0f) {
            y2 = -2.0f;
        }
        if (y2 > 2.0f) {
            y2 = 2.0f;
        }
        if (z < -2.0f) {
            z = -2.0f;
        }
        return ColorKt.Color(x, y2, z <= 2.0f ? z : 2.0f, a, colorSpace);
    }
}
