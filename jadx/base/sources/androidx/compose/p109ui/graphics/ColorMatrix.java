package androidx.compose.p109ui.graphics;

import androidx.core.text.util.LocalePreferences;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0086\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\t0'H\u0082\b¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b0\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b9\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\bH\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M"}, m13886d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "src", "set-jHG-Opc", "([F[F)V", VPathDataCmd.RCurveTo, "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", LocalePreferences.FirstDayOfWeek.SATURDAY, "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nColorMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorMatrix.kt\nandroidx/compose/ui/graphics/ColorMatrix\n*L\n1#1,330:1\n98#1,2:331\n98#1,2:333\n98#1,2:335\n98#1,2:337\n84#1:339\n84#1:340\n84#1:341\n84#1:342\n84#1:343\n84#1:344\n84#1:345\n84#1:346\n84#1:347\n84#1:348\n84#1:349\n84#1:350\n84#1:351\n84#1:352\n84#1:353\n84#1:354\n84#1:355\n84#1:356\n84#1:357\n84#1:358\n98#1,2:359\n98#1,2:361\n98#1,2:363\n98#1,2:365\n98#1,2:367\n98#1,2:369\n98#1,2:371\n98#1,2:373\n98#1,2:375\n98#1,2:377\n98#1,2:379\n98#1,2:381\n98#1,2:383\n98#1,2:385\n98#1,2:387\n98#1,2:389\n98#1,2:391\n98#1,2:393\n98#1,2:395\n98#1,2:397\n84#1:399\n84#1:400\n84#1:401\n84#1:402\n98#1,2:403\n98#1,2:405\n98#1,2:407\n98#1,2:409\n98#1,2:411\n98#1,2:413\n98#1,2:415\n98#1,2:417\n98#1,2:419\n98#1,2:421\n98#1,2:423\n98#1,2:425\n98#1,2:427\n134#1,5:429\n98#1,2:434\n98#1,2:436\n98#1,2:438\n98#1,2:440\n139#1:442\n134#1,5:443\n98#1,2:448\n98#1,2:450\n98#1,2:452\n98#1,2:454\n139#1:456\n134#1,5:457\n98#1,2:462\n98#1,2:464\n98#1,2:466\n98#1,2:468\n139#1:470\n98#1,2:471\n98#1,2:473\n98#1,2:475\n98#1,2:477\n98#1,2:479\n98#1,2:481\n98#1,2:483\n98#1,2:485\n98#1,2:487\n98#1,2:489\n98#1,2:491\n98#1,2:493\n98#1,2:495\n98#1,2:497\n98#1,2:499\n98#1,2:501\n*S KotlinDebug\n*F\n+ 1 ColorMatrix.kt\nandroidx/compose/ui/graphics/ColorMatrix\n*L\n112#1:331,2\n113#1:333,2\n114#1:335,2\n115#1:337,2\n149#1:339\n150#1:340\n151#1:341\n152#1:342\n153#1:343\n159#1:344\n160#1:345\n161#1:346\n162#1:347\n163#1:348\n169#1:349\n170#1:350\n171#1:351\n172#1:352\n173#1:353\n179#1:354\n180#1:355\n181#1:356\n182#1:357\n183#1:358\n185#1:359,2\n186#1:361,2\n187#1:363,2\n188#1:365,2\n189#1:367,2\n190#1:369,2\n191#1:371,2\n192#1:373,2\n193#1:375,2\n194#1:377,2\n195#1:379,2\n196#1:381,2\n197#1:383,2\n198#1:385,2\n199#1:387,2\n200#1:389,2\n201#1:391,2\n202#1:393,2\n203#1:395,2\n204#1:397,2\n212#1:399\n213#1:400\n214#1:401\n215#1:402\n229#1:403,2\n230#1:405,2\n231#1:407,2\n232#1:409,2\n233#1:411,2\n234#1:413,2\n235#1:415,2\n236#1:417,2\n237#1:419,2\n256#1:421,2\n257#1:423,2\n258#1:425,2\n259#1:427,2\n266#1:429,5\n267#1:434,2\n268#1:436,2\n269#1:438,2\n270#1:440,2\n266#1:442\n278#1:443,5\n279#1:448,2\n280#1:450,2\n281#1:452,2\n282#1:454,2\n278#1:456\n290#1:457,5\n291#1:462,2\n292#1:464,2\n293#1:466,2\n294#1:468,2\n290#1:470\n304#1:471,2\n305#1:473,2\n306#1:475,2\n307#1:477,2\n308#1:479,2\n309#1:481,2\n310#1:483,2\n311#1:485,2\n312#1:487,2\n321#1:489,2\n322#1:491,2\n323#1:493,2\n324#1:495,2\n325#1:497,2\n326#1:499,2\n327#1:501,2\n*E\n"})
public final class ColorMatrix {

    @NotNull
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m18580boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m18582constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m18581constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m18583convertRgbToYuvimpl(float[] fArr) {
        m18590resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m18584convertYuvToRgbimpl(float[] fArr) {
        m18590resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* JADX INFO: renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m18585dotMe4OoYI(float[] fArr, float[] fArr2, int i, float[] fArr3, int i2) {
        int i4 = i * 5;
        return (fArr2[i4 + 3] * fArr3[15 + i2]) + (fArr2[i4 + 2] * fArr3[10 + i2]) + (fArr2[i4 + 1] * fArr3[5 + i2]) + (fArr2[i4] * fArr3[i2]);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18586equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual(fArr, ((ColorMatrix) obj).m18601unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18587equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m18588getimpl(float[] fArr, int i, int i2) {
        return fArr[(i * 5) + i2];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18589hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m18590resetimpl(float[] fArr) {
        ArraysKt___ArraysJvmKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m18591rotateInternalimpl(float[] fArr, float f, Function2<? super Float, ? super Float, Unit> function2) {
        m18590resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        function2.invoke(Float.valueOf((float) Math.cos(d)), Float.valueOf((float) Math.sin(d)));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m18592setimpl(float[] fArr, int i, int i2, float f) {
        fArr[(i * 5) + i2] = f;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m18593setjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        ArraysKt___ArraysJvmKt.copyInto$default(fArr2, fArr, 0, 0, 0, 14, (Object) null);
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m18594setToRotateBlueimpl(float[] fArr, float f) {
        m18590resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[6] = fCos;
        fArr[0] = fCos;
        fArr[1] = fSin;
        fArr[5] = -fSin;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m18595setToRotateGreenimpl(float[] fArr, float f) {
        m18590resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[0] = fCos;
        fArr[2] = -fSin;
        fArr[10] = fSin;
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m18596setToRotateRedimpl(float[] fArr, float f) {
        m18590resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        fArr[12] = fCos;
        fArr[6] = fCos;
        fArr[7] = fSin;
        fArr[11] = -fSin;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m18597setToSaturationimpl(float[] fArr, float f) {
        m18590resetimpl(fArr);
        float f4 = 1 - f;
        float f5 = 0.213f * f4;
        float f6 = 0.715f * f4;
        float f7 = f4 * 0.072f;
        fArr[0] = f5 + f;
        fArr[1] = f6;
        fArr[2] = f7;
        fArr[5] = f5;
        fArr[6] = f6 + f;
        fArr[7] = f7;
        fArr[10] = f5;
        fArr[11] = f6;
        fArr[12] = f7 + f;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m18598setToScaleimpl(float[] fArr, float f, float f4, float f5, float f6) {
        m18590resetimpl(fArr);
        fArr[0] = f;
        fArr[6] = f4;
        fArr[12] = f5;
        fArr[18] = f6;
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m18599timesAssignjHGOpc(float[] fArr, @NotNull float[] fArr2) {
        float fM18585dotMe4OoYI = m18585dotMe4OoYI(fArr, fArr, 0, fArr2, 0);
        float fM18585dotMe4OoYI2 = m18585dotMe4OoYI(fArr, fArr, 0, fArr2, 1);
        float fM18585dotMe4OoYI3 = m18585dotMe4OoYI(fArr, fArr, 0, fArr2, 2);
        float fM18585dotMe4OoYI4 = m18585dotMe4OoYI(fArr, fArr, 0, fArr2, 3);
        float f = (fArr[3] * fArr2[19]) + (fArr[2] * fArr2[14]) + (fArr[1] * fArr2[9]) + (fArr[0] * fArr2[4]) + fArr[4];
        float fM18585dotMe4OoYI5 = m18585dotMe4OoYI(fArr, fArr, 1, fArr2, 0);
        float fM18585dotMe4OoYI6 = m18585dotMe4OoYI(fArr, fArr, 1, fArr2, 1);
        float fM18585dotMe4OoYI7 = m18585dotMe4OoYI(fArr, fArr, 1, fArr2, 2);
        float fM18585dotMe4OoYI8 = m18585dotMe4OoYI(fArr, fArr, 1, fArr2, 3);
        float f4 = (fArr[8] * fArr2[19]) + (fArr[7] * fArr2[14]) + (fArr[6] * fArr2[9]) + (fArr[5] * fArr2[4]) + fArr[9];
        float fM18585dotMe4OoYI9 = m18585dotMe4OoYI(fArr, fArr, 2, fArr2, 0);
        float fM18585dotMe4OoYI10 = m18585dotMe4OoYI(fArr, fArr, 2, fArr2, 1);
        float fM18585dotMe4OoYI11 = m18585dotMe4OoYI(fArr, fArr, 2, fArr2, 2);
        float fM18585dotMe4OoYI12 = m18585dotMe4OoYI(fArr, fArr, 2, fArr2, 3);
        float f5 = (fArr[13] * fArr2[19]) + (fArr[12] * fArr2[14]) + (fArr[11] * fArr2[9]) + (fArr[10] * fArr2[4]) + fArr[14];
        float fM18585dotMe4OoYI13 = m18585dotMe4OoYI(fArr, fArr, 3, fArr2, 0);
        float fM18585dotMe4OoYI14 = m18585dotMe4OoYI(fArr, fArr, 3, fArr2, 1);
        float fM18585dotMe4OoYI15 = m18585dotMe4OoYI(fArr, fArr, 3, fArr2, 2);
        float fM18585dotMe4OoYI16 = m18585dotMe4OoYI(fArr, fArr, 3, fArr2, 3);
        float f6 = (fArr[18] * fArr2[19]) + (fArr[17] * fArr2[14]) + (fArr[16] * fArr2[9]) + (fArr[15] * fArr2[4]) + fArr[19];
        fArr[0] = fM18585dotMe4OoYI;
        fArr[1] = fM18585dotMe4OoYI2;
        fArr[2] = fM18585dotMe4OoYI3;
        fArr[3] = fM18585dotMe4OoYI4;
        fArr[4] = f;
        fArr[5] = fM18585dotMe4OoYI5;
        fArr[6] = fM18585dotMe4OoYI6;
        fArr[7] = fM18585dotMe4OoYI7;
        fArr[8] = fM18585dotMe4OoYI8;
        fArr[9] = f4;
        fArr[10] = fM18585dotMe4OoYI9;
        fArr[11] = fM18585dotMe4OoYI10;
        fArr[12] = fM18585dotMe4OoYI11;
        fArr[13] = fM18585dotMe4OoYI12;
        fArr[14] = f5;
        fArr[15] = fM18585dotMe4OoYI13;
        fArr[16] = fM18585dotMe4OoYI14;
        fArr[17] = fM18585dotMe4OoYI15;
        fArr[18] = fM18585dotMe4OoYI16;
        fArr[19] = f6;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18600toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m18586equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m18589hashCodeimpl(this.values);
    }

    public String toString() {
        return m18600toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m18601unboximpl() {
        return this.values;
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m18581constructorimpl(@NotNull float[] fArr) {
        return fArr;
    }
}
