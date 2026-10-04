package androidx.compose.p109ui.graphics;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.MutableRect;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\b'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\b/\u0010+J+\u00100\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001b\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u00020\u00182\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\bF\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H"}, m13886d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", WiggleAnimationConfig.KEY_SCALE, "x", "y", "z", "scale-impl", "([FFFF)V", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, VPathDataCmd.RCurveTo, "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/compose/ui/graphics/Matrix\n*L\n1#1,441:1\n39#1:442\n39#1:443\n39#1:444\n42#1,2:445\n42#1,2:447\n42#1,2:449\n42#1,2:451\n42#1,2:453\n42#1,2:455\n42#1,2:457\n42#1,2:459\n42#1,2:461\n42#1,2:463\n42#1,2:465\n42#1,2:467\n42#1,2:469\n42#1,2:471\n42#1,2:473\n42#1,2:475\n39#1:477\n39#1:478\n39#1:479\n39#1:480\n39#1:481\n39#1:482\n39#1:483\n39#1:484\n39#1:485\n39#1:486\n39#1:487\n39#1:488\n39#1:489\n39#1:490\n39#1:491\n39#1:492\n39#1:493\n39#1:494\n39#1:495\n39#1:496\n42#1,2:497\n42#1,2:499\n42#1,2:501\n42#1,2:503\n42#1,2:505\n42#1,2:507\n42#1,2:509\n42#1,2:511\n42#1,2:513\n42#1,2:515\n42#1,2:517\n42#1,2:519\n42#1,2:521\n42#1,2:523\n42#1,2:525\n42#1,2:527\n42#1,2:529\n39#1:531\n39#1:532\n39#1:533\n39#1:534\n39#1:535\n39#1:536\n39#1:537\n39#1:538\n42#1,2:539\n42#1,2:541\n42#1,2:543\n42#1,2:545\n42#1,2:547\n42#1,2:549\n42#1,2:551\n42#1,2:553\n39#1:555\n39#1:556\n39#1:557\n39#1:558\n39#1:559\n39#1:560\n39#1:561\n39#1:562\n42#1,2:563\n42#1,2:565\n42#1,2:567\n42#1,2:569\n42#1,2:571\n42#1,2:573\n42#1,2:575\n42#1,2:577\n39#1:579\n39#1:580\n39#1:581\n39#1:582\n39#1:583\n39#1:584\n39#1:585\n39#1:586\n42#1,2:587\n42#1,2:589\n42#1,2:591\n42#1,2:593\n42#1,2:595\n42#1,2:597\n42#1,2:599\n42#1,2:601\n39#1,5:603\n39#1,5:608\n39#1,5:613\n39#1,5:618\n39#1,5:623\n39#1,5:628\n39#1,5:633\n39#1,5:638\n39#1,5:643\n39#1,5:648\n39#1,5:653\n39#1,5:658\n39#1:663\n39#1:664\n39#1:665\n39#1:666\n39#1:667\n39#1:668\n39#1:669\n39#1:670\n39#1:671\n39#1:672\n39#1:673\n39#1:674\n39#1:675\n39#1:676\n39#1:677\n39#1:678\n42#1,2:679\n42#1,2:681\n42#1,2:683\n42#1,2:685\n*S KotlinDebug\n*F\n+ 1 Matrix.kt\nandroidx/compose/ui/graphics/Matrix\n*L\n51#1:442\n56#1:443\n57#1:444\n112#1:445,2\n113#1:447,2\n114#1:449,2\n115#1:451,2\n116#1:453,2\n117#1:455,2\n118#1:457,2\n119#1:459,2\n120#1:461,2\n121#1:463,2\n122#1:465,2\n123#1:467,2\n124#1:469,2\n125#1:471,2\n126#1:473,2\n127#1:475,2\n132#1:477\n133#1:478\n134#1:479\n135#1:480\n143#1:481\n144#1:482\n145#1:483\n146#1:484\n147#1:485\n148#1:486\n149#1:487\n150#1:488\n151#1:489\n152#1:490\n153#1:491\n154#1:492\n155#1:493\n156#1:494\n157#1:495\n158#1:496\n177#1:497,2\n178#1:499,2\n179#1:501,2\n180#1:503,2\n181#1:505,2\n182#1:507,2\n183#1:509,2\n184#1:511,2\n185#1:513,2\n186#1:515,2\n187#1:517,2\n188#1:519,2\n189#1:521,2\n190#1:523,2\n191#1:525,2\n192#1:527,2\n201#1:529,2\n220#1:531\n221#1:532\n225#1:533\n226#1:534\n230#1:535\n231#1:536\n235#1:537\n236#1:538\n240#1:539,2\n241#1:541,2\n242#1:543,2\n243#1:545,2\n244#1:547,2\n245#1:549,2\n246#1:551,2\n247#1:553,2\n257#1:555\n258#1:556\n262#1:557\n263#1:558\n267#1:559\n268#1:560\n272#1:561\n273#1:562\n277#1:563,2\n278#1:565,2\n279#1:567,2\n280#1:569,2\n281#1:571,2\n282#1:573,2\n283#1:575,2\n284#1:577,2\n294#1:579\n295#1:580\n299#1:581\n300#1:582\n304#1:583\n305#1:584\n309#1:585\n310#1:586\n314#1:587,2\n315#1:589,2\n316#1:591,2\n317#1:593,2\n318#1:595,2\n319#1:597,2\n320#1:599,2\n321#1:601,2\n326#1:603,5\n327#1:608,5\n328#1:613,5\n329#1:618,5\n330#1:623,5\n331#1:628,5\n332#1:633,5\n333#1:638,5\n334#1:643,5\n335#1:648,5\n336#1:653,5\n337#1:658,5\n342#1:663\n343#1:664\n344#1:665\n345#1:666\n346#1:667\n347#1:668\n348#1:669\n349#1:670\n350#1:671\n351#1:672\n352#1:673\n353#1:674\n354#1:675\n355#1:676\n356#1:677\n357#1:678\n358#1:679,2\n359#1:681,2\n360#1:683,2\n361#1:685,2\n*E\n"})
public final class Matrix {
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;

    @NotNull
    private final float[] values;

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Matrix m18754boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m18756constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m18755constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18757equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).m18777unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18758equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m18759getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 4) + i2];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18760hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: invert-impl, reason: not valid java name */
    public static final void m18761invertimpl(float[] fArr) {
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
            return;
        }
        float f32 = 1.0f / f31;
        fArr[0] = AbstractC0622a.m1152B(f10, f28, (f8 * f30) - (f9 * f29), f32);
        fArr[1] = AbstractC1974b.m1309b(f6, f28, (f5 * f29) + ((-f4) * f30), f32);
        fArr[2] = AbstractC0622a.m1152B(f18, f22, (f16 * f24) - (f17 * f23), f32);
        fArr[3] = AbstractC1974b.m1309b(f14, f22, (f13 * f23) + ((-f12) * f24), f32);
        float f33 = -f7;
        fArr[4] = AbstractC1974b.m1309b(f10, f26, (f9 * f27) + (f33 * f30), f32);
        fArr[5] = AbstractC0622a.m1152B(f6, f26, (f30 * f) - (f5 * f27), f32);
        float f34 = -f15;
        fArr[6] = AbstractC1974b.m1309b(f18, f20, (f17 * f21) + (f34 * f24), f32);
        fArr[7] = AbstractC0622a.m1152B(f14, f20, (f11 * f24) - (f13 * f21), f32);
        fArr[8] = AbstractC0622a.m1152B(f10, f25, (f7 * f29) - (f8 * f27), f32);
        fArr[9] = AbstractC1974b.m1309b(f6, f25, (f27 * f4) + ((-f) * f29), f32);
        fArr[10] = AbstractC0622a.m1152B(f18, f19, (f15 * f23) - (f16 * f21), f32);
        fArr[11] = AbstractC1974b.m1309b(f14, f19, (f12 * f21) + ((-f11) * f23), f32);
        fArr[12] = AbstractC1974b.m1309b(f9, f25, (f8 * f26) + (f33 * f28), f32);
        fArr[13] = AbstractC0622a.m1152B(f5, f25, (f * f28) - (f4 * f26), f32);
        fArr[14] = AbstractC1974b.m1309b(f17, f19, (f16 * f20) + (f34 * f22), f32);
        fArr[15] = AbstractC0622a.m1152B(f13, f19, (f11 * f22) - (f12 * f20), f32);
    }

    /* JADX INFO: renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m18762mapMKHz9U(float[] fArr, long j) {
        float fM18284getXimpl = Offset.m18284getXimpl(j);
        float fM18285getYimpl = Offset.m18285getYimpl(j);
        float f = 1 / (((fArr[7] * fM18285getYimpl) + (fArr[3] * fM18284getXimpl)) + fArr[15]);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            f = 0.0f;
        }
        return OffsetKt.Offset(((fArr[4] * fM18285getYimpl) + (fArr[0] * fM18284getXimpl) + fArr[12]) * f, ((fArr[5] * fM18285getYimpl) + (fArr[1] * fM18284getXimpl) + fArr[13]) * f);
    }

    @NotNull
    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final Rect m18763mapimpl(float[] fArr, @NotNull Rect rect) {
        long jM18762mapMKHz9U = m18762mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long jM18762mapMKHz9U2 = m18762mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long jM18762mapMKHz9U3 = m18762mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long jM18762mapMKHz9U4 = m18762mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        return new Rect(Math.min(Math.min(Offset.m18284getXimpl(jM18762mapMKHz9U), Offset.m18284getXimpl(jM18762mapMKHz9U2)), Math.min(Offset.m18284getXimpl(jM18762mapMKHz9U3), Offset.m18284getXimpl(jM18762mapMKHz9U4))), Math.min(Math.min(Offset.m18285getYimpl(jM18762mapMKHz9U), Offset.m18285getYimpl(jM18762mapMKHz9U2)), Math.min(Offset.m18285getYimpl(jM18762mapMKHz9U3), Offset.m18285getYimpl(jM18762mapMKHz9U4))), Math.max(Math.max(Offset.m18284getXimpl(jM18762mapMKHz9U), Offset.m18284getXimpl(jM18762mapMKHz9U2)), Math.max(Offset.m18284getXimpl(jM18762mapMKHz9U3), Offset.m18284getXimpl(jM18762mapMKHz9U4))), Math.max(Math.max(Offset.m18285getYimpl(jM18762mapMKHz9U), Offset.m18285getYimpl(jM18762mapMKHz9U2)), Math.max(Offset.m18285getYimpl(jM18762mapMKHz9U3), Offset.m18285getYimpl(jM18762mapMKHz9U4))));
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m18765resetimpl(float[] fArr) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                fArr[(i2 * 4) + i] = i == i2 ? 1.0f : 0.0f;
                i2++;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: rotateX-impl, reason: not valid java name */
    public static final void m18766rotateXimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = (f4 * fCos) - (f5 * fSin);
        float f7 = fArr[5];
        float f8 = fArr[6];
        float f9 = (f7 * fCos) - (f8 * fSin);
        float f10 = fArr[9];
        float f11 = fArr[10];
        float f12 = (f10 * fCos) - (f11 * fSin);
        float f13 = fArr[13];
        float f14 = fArr[14];
        float f15 = (f13 * fCos) - (f14 * fSin);
        fArr[1] = f6;
        fArr[2] = (f5 * fCos) + (f4 * fSin);
        fArr[5] = f9;
        fArr[6] = (f8 * fCos) + (f7 * fSin);
        fArr[9] = f12;
        fArr[10] = (f11 * fCos) + (f10 * fSin);
        fArr[13] = f15;
        fArr[14] = (f14 * fCos) + (f13 * fSin);
    }

    /* JADX INFO: renamed from: rotateY-impl, reason: not valid java name */
    public static final void m18767rotateYimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f4 = fArr[0];
        float f5 = fArr[2];
        float f6 = (f5 * fSin) + (f4 * fCos);
        float f7 = fArr[4];
        float f8 = fArr[6];
        float f9 = (f8 * fSin) + (f7 * fCos);
        float f10 = fArr[8];
        float f11 = fArr[10];
        float f12 = (f11 * fSin) + (f10 * fCos);
        float f13 = fArr[12];
        float f14 = fArr[14];
        float f15 = (f14 * fSin) + (f13 * fCos);
        fArr[0] = f6;
        fArr[2] = (f5 * fCos) + ((-f4) * fSin);
        fArr[4] = f9;
        fArr[6] = (f8 * fCos) + ((-f7) * fSin);
        fArr[8] = f12;
        fArr[10] = (f11 * fCos) + ((-f10) * fSin);
        fArr[12] = f15;
        fArr[14] = (f14 * fCos) + ((-f13) * fSin);
    }

    /* JADX INFO: renamed from: rotateZ-impl, reason: not valid java name */
    public static final void m18768rotateZimpl(float[] fArr, float f) {
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f4 = fArr[0];
        float f5 = fArr[4];
        float f6 = (fSin * f5) + (fCos * f4);
        float f7 = -fSin;
        float f8 = (f5 * fCos) + (f4 * f7);
        float f9 = fArr[1];
        float f10 = fArr[5];
        float f11 = (fSin * f10) + (fCos * f9);
        float f12 = (f10 * fCos) + (f9 * f7);
        float f13 = fArr[2];
        float f14 = fArr[6];
        float f15 = (fSin * f14) + (fCos * f13);
        float f16 = (f14 * fCos) + (f13 * f7);
        float f17 = fArr[3];
        float f18 = fArr[7];
        float f19 = (fSin * f18) + (fCos * f17);
        fArr[0] = f6;
        fArr[1] = f11;
        fArr[2] = f15;
        fArr[3] = f19;
        fArr[4] = f8;
        fArr[5] = f12;
        fArr[6] = f16;
        fArr[7] = (fCos * f18) + (f7 * f17);
    }

    /* JADX INFO: renamed from: scale-impl, reason: not valid java name */
    public static final void m18769scaleimpl(float[] fArr, float f, float f4, float f5) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f4;
        fArr[5] = fArr[5] * f4;
        fArr[6] = fArr[6] * f4;
        fArr[7] = fArr[7] * f4;
        fArr[8] = fArr[8] * f5;
        fArr[9] = fArr[9] * f5;
        fArr[10] = fArr[10] * f5;
        fArr[11] = fArr[11] * f5;
    }

    /* JADX INFO: renamed from: scale-impl$default, reason: not valid java name */
    public static /* synthetic */ void m18770scaleimpl$default(float[] fArr, float f, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f4 = 1.0f;
        }
        if ((i & 4) != 0) {
            f5 = 1.0f;
        }
        m18769scaleimpl(fArr, f, f4, f5);
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m18771setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 4) + i2] = f;
    }

    /* JADX INFO: renamed from: setFrom-58bKbWc, reason: not valid java name */
    public static final void m18772setFrom58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        for (int i = 0; i < 16; i++) {
            fArr[i] = fArr2[i];
        }
    }

    /* JADX INFO: renamed from: timesAssign-58bKbWc, reason: not valid java name */
    public static final void m18773timesAssign58bKbWc(float[] fArr, @NotNull float[] fArr2) {
        float fM18779dotp89u6pk = MatrixKt.m18779dotp89u6pk(fArr, 0, fArr2, 0);
        float fM18779dotp89u6pk2 = MatrixKt.m18779dotp89u6pk(fArr, 0, fArr2, 1);
        float fM18779dotp89u6pk3 = MatrixKt.m18779dotp89u6pk(fArr, 0, fArr2, 2);
        float fM18779dotp89u6pk4 = MatrixKt.m18779dotp89u6pk(fArr, 0, fArr2, 3);
        float fM18779dotp89u6pk5 = MatrixKt.m18779dotp89u6pk(fArr, 1, fArr2, 0);
        float fM18779dotp89u6pk6 = MatrixKt.m18779dotp89u6pk(fArr, 1, fArr2, 1);
        float fM18779dotp89u6pk7 = MatrixKt.m18779dotp89u6pk(fArr, 1, fArr2, 2);
        float fM18779dotp89u6pk8 = MatrixKt.m18779dotp89u6pk(fArr, 1, fArr2, 3);
        float fM18779dotp89u6pk9 = MatrixKt.m18779dotp89u6pk(fArr, 2, fArr2, 0);
        float fM18779dotp89u6pk10 = MatrixKt.m18779dotp89u6pk(fArr, 2, fArr2, 1);
        float fM18779dotp89u6pk11 = MatrixKt.m18779dotp89u6pk(fArr, 2, fArr2, 2);
        float fM18779dotp89u6pk12 = MatrixKt.m18779dotp89u6pk(fArr, 2, fArr2, 3);
        float fM18779dotp89u6pk13 = MatrixKt.m18779dotp89u6pk(fArr, 3, fArr2, 0);
        float fM18779dotp89u6pk14 = MatrixKt.m18779dotp89u6pk(fArr, 3, fArr2, 1);
        float fM18779dotp89u6pk15 = MatrixKt.m18779dotp89u6pk(fArr, 3, fArr2, 2);
        float fM18779dotp89u6pk16 = MatrixKt.m18779dotp89u6pk(fArr, 3, fArr2, 3);
        fArr[0] = fM18779dotp89u6pk;
        fArr[1] = fM18779dotp89u6pk2;
        fArr[2] = fM18779dotp89u6pk3;
        fArr[3] = fM18779dotp89u6pk4;
        fArr[4] = fM18779dotp89u6pk5;
        fArr[5] = fM18779dotp89u6pk6;
        fArr[6] = fM18779dotp89u6pk7;
        fArr[7] = fM18779dotp89u6pk8;
        fArr[8] = fM18779dotp89u6pk9;
        fArr[9] = fM18779dotp89u6pk10;
        fArr[10] = fM18779dotp89u6pk11;
        fArr[11] = fM18779dotp89u6pk12;
        fArr[12] = fM18779dotp89u6pk13;
        fArr[13] = fM18779dotp89u6pk14;
        fArr[14] = fM18779dotp89u6pk15;
        fArr[15] = fM18779dotp89u6pk16;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18774toStringimpl(float[] fArr) {
        return StringsKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    /* JADX INFO: renamed from: translate-impl, reason: not valid java name */
    public static final void m18775translateimpl(float[] fArr, float f, float f4, float f5) {
        float f6 = (fArr[8] * f5) + (fArr[4] * f4) + (fArr[0] * f) + fArr[12];
        float f7 = (fArr[9] * f5) + (fArr[5] * f4) + (fArr[1] * f) + fArr[13];
        float f8 = (fArr[10] * f5) + (fArr[6] * f4) + (fArr[2] * f) + fArr[14];
        float f9 = (fArr[11] * f5) + (fArr[7] * f4) + (fArr[3] * f) + fArr[15];
        fArr[12] = f6;
        fArr[13] = f7;
        fArr[14] = f8;
        fArr[15] = f9;
    }

    /* JADX INFO: renamed from: translate-impl$default, reason: not valid java name */
    public static /* synthetic */ void m18776translateimpl$default(float[] fArr, float f, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i & 4) != 0) {
            f5 = 0.0f;
        }
        m18775translateimpl(fArr, f, f4, f5);
    }

    public boolean equals(Object obj) {
        return m18757equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m18760hashCodeimpl(this.values);
    }

    @NotNull
    public String toString() {
        return m18774toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m18777unboximpl() {
        return this.values;
    }

    /* JADX INFO: renamed from: map-impl, reason: not valid java name */
    public static final void m18764mapimpl(float[] fArr, @NotNull MutableRect mutableRect) {
        long jM18762mapMKHz9U = m18762mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getTop()));
        long jM18762mapMKHz9U2 = m18762mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getLeft(), mutableRect.getBottom()));
        long jM18762mapMKHz9U3 = m18762mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getTop()));
        long jM18762mapMKHz9U4 = m18762mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.getRight(), mutableRect.getBottom()));
        mutableRect.setLeft(Math.min(Math.min(Offset.m18284getXimpl(jM18762mapMKHz9U), Offset.m18284getXimpl(jM18762mapMKHz9U2)), Math.min(Offset.m18284getXimpl(jM18762mapMKHz9U3), Offset.m18284getXimpl(jM18762mapMKHz9U4))));
        mutableRect.setTop(Math.min(Math.min(Offset.m18285getYimpl(jM18762mapMKHz9U), Offset.m18285getYimpl(jM18762mapMKHz9U2)), Math.min(Offset.m18285getYimpl(jM18762mapMKHz9U3), Offset.m18285getYimpl(jM18762mapMKHz9U4))));
        mutableRect.setRight(Math.max(Math.max(Offset.m18284getXimpl(jM18762mapMKHz9U), Offset.m18284getXimpl(jM18762mapMKHz9U2)), Math.max(Offset.m18284getXimpl(jM18762mapMKHz9U3), Offset.m18284getXimpl(jM18762mapMKHz9U4))));
        mutableRect.setBottom(Math.max(Math.max(Offset.m18285getYimpl(jM18762mapMKHz9U), Offset.m18285getYimpl(jM18762mapMKHz9U2)), Math.max(Offset.m18285getYimpl(jM18762mapMKHz9U3), Offset.m18285getYimpl(jM18762mapMKHz9U4))));
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m18755constructorimpl(@NotNull float[] fArr) {
        return fArr;
    }
}
