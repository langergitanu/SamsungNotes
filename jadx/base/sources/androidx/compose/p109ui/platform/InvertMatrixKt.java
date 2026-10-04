package androidx.compose.p109ui.platform;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m13886d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInvertMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InvertMatrix.kt\nandroidx/compose/ui/platform/InvertMatrixKt\n+ 2 Matrix.kt\nandroidx/compose/ui/graphics/Matrix\n*L\n1#1,78:1\n39#2:79\n39#2:80\n39#2:81\n39#2:82\n39#2:83\n39#2:84\n39#2:85\n39#2:86\n39#2:87\n39#2:88\n39#2:89\n39#2:90\n39#2:91\n39#2:92\n39#2:93\n39#2:94\n42#2,2:95\n42#2,2:97\n42#2,2:99\n42#2,2:101\n42#2,2:103\n42#2,2:105\n42#2,2:107\n42#2,2:109\n42#2,2:111\n42#2,2:113\n42#2,2:115\n42#2,2:117\n42#2,2:119\n42#2,2:121\n42#2,2:123\n42#2,2:125\n*S KotlinDebug\n*F\n+ 1 InvertMatrix.kt\nandroidx/compose/ui/platform/InvertMatrixKt\n*L\n26#1:79\n27#1:80\n28#1:81\n29#1:82\n30#1:83\n31#1:84\n32#1:85\n33#1:86\n34#1:87\n35#1:88\n36#1:89\n37#1:90\n38#1:91\n39#1:92\n40#1:93\n41#1:94\n60#1:95,2\n61#1:97,2\n62#1:99,2\n63#1:101,2\n64#1:103,2\n65#1:105,2\n66#1:107,2\n67#1:109,2\n68#1:111,2\n69#1:113,2\n70#1:115,2\n71#1:117,2\n72#1:119,2\n73#1:121,2\n74#1:123,2\n75#1:125,2\n*E\n"})
public final class InvertMatrixKt {
    /* JADX INFO: renamed from: invertTo-JiSxe2E, reason: not valid java name */
    public static final boolean m20214invertToJiSxe2E(@NotNull float[] fArr, @NotNull float[] fArr2) {
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        float f12 = fArr[9];
        float f13 = fArr[10];
        float f14 = fArr[11];
        float f15 = fArr[12];
        float f16 = fArr[13];
        float f17 = fArr[14];
        float f18 = fArr[15];
        float f19 = (f * f8) - (f4 * f7);
        float f20 = (f * f9) - (f5 * f7);
        float f21 = (f * f10) - (f6 * f7);
        float f22 = (f4 * f9) - (f5 * f8);
        float f23 = (f4 * f10) - (f6 * f8);
        float f24 = (f5 * f10) - (f6 * f9);
        float f25 = (f11 * f16) - (f12 * f15);
        float f26 = (f11 * f17) - (f13 * f15);
        float f27 = (f11 * f18) - (f14 * f15);
        float f28 = (f12 * f17) - (f13 * f16);
        float f29 = (f12 * f18) - (f14 * f16);
        float f30 = (f13 * f18) - (f14 * f17);
        float f31 = (f24 * f25) + (((f22 * f27) + ((f21 * f28) + ((f19 * f30) - (f20 * f29)))) - (f23 * f26));
        if (f31 == 0.0f) {
            return false;
        }
        float f32 = 1.0f / f31;
        fArr2[0] = AbstractC0622a.m1152B(f10, f28, (f8 * f30) - (f9 * f29), f32);
        fArr2[1] = AbstractC1974b.m1309b(f6, f28, (f5 * f29) + ((-f4) * f30), f32);
        fArr2[2] = AbstractC0622a.m1152B(f18, f22, (f16 * f24) - (f17 * f23), f32);
        fArr2[3] = AbstractC1974b.m1309b(f14, f22, (f13 * f23) + ((-f12) * f24), f32);
        float f33 = -f7;
        fArr2[4] = AbstractC1974b.m1309b(f10, f26, (f9 * f27) + (f33 * f30), f32);
        fArr2[5] = AbstractC0622a.m1152B(f6, f26, (f30 * f) - (f5 * f27), f32);
        float f34 = -f15;
        fArr2[6] = AbstractC1974b.m1309b(f18, f20, (f17 * f21) + (f34 * f24), f32);
        fArr2[7] = AbstractC0622a.m1152B(f14, f20, (f11 * f24) - (f13 * f21), f32);
        fArr2[8] = AbstractC0622a.m1152B(f10, f25, (f7 * f29) - (f8 * f27), f32);
        fArr2[9] = AbstractC1974b.m1309b(f6, f25, (f27 * f4) + ((-f) * f29), f32);
        fArr2[10] = AbstractC0622a.m1152B(f18, f19, (f15 * f23) - (f16 * f21), f32);
        fArr2[11] = AbstractC1974b.m1309b(f14, f19, (f12 * f21) + ((-f11) * f23), f32);
        fArr2[12] = AbstractC1974b.m1309b(f9, f25, (f8 * f26) + (f33 * f28), f32);
        fArr2[13] = AbstractC0622a.m1152B(f5, f25, (f * f28) - (f4 * f26), f32);
        fArr2[14] = AbstractC1974b.m1309b(f17, f19, (f16 * f20) + (f34 * f22), f32);
        fArr2[15] = AbstractC0622a.m1152B(f13, f19, (f11 * f22) - (f12 * f20), f32);
        return true;
    }
}
