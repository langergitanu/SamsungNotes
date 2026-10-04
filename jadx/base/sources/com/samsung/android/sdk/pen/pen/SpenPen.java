package com.samsung.android.sdk.pen.pen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import com.samsung.android.sdk.pen.view.SpenMotionEvent;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b+\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B#\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u00020\u00182\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0 j\b\u0012\u0004\u0012\u00020\u001b`!2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0018\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0016J\u0010\u0010K\u001a\u00020=2\u0006\u0010L\u001a\u00020\u0007H\u0016J\u000e\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020OJC\u0010M\u001a\u00020\u001d2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010)\u001a\u00020*2\u0006\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u00020FH\u0016¢\u0006\u0002\u0010YR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010)\u001a\u00020*2\u0006\u0010)\u001a\u00020*8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0014\u00101\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010,R$\u00103\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R$\u00106\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R$\u00109\u001a\u00020*2\u0006\u00109\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R$\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020=8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010E\u001a\u00020F2\u0006\u0010E\u001a\u00020F8W@WX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010[\u001a\u00020=2\u0006\u0010Z\u001a\u00020=8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010?\"\u0004\b\\\u0010AR$\u0010]\u001a\u00020*2\u0006\u0010]\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010,\"\u0004\b_\u0010.R$\u0010`\u001a\u00020=2\u0006\u0010<\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010?\"\u0004\ba\u0010AR$\u0010b\u001a\u00020=2\u0006\u0010<\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010?\"\u0004\bc\u0010AR$\u0010d\u001a\u00020=2\u0006\u0010<\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010?\"\u0004\be\u0010AR$\u0010g\u001a\u00020*2\u0006\u0010f\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bh\u0010,\"\u0004\bi\u0010.R$\u0010j\u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010\u0012\"\u0004\bl\u0010\u0014R$\u0010m\u001a\u00020*2\u0006\u0010m\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010,\"\u0004\bo\u0010.R$\u0010p\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0012\"\u0004\br\u0010\u0014R$\u0010s\u001a\u00020*2\u0006\u0010s\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010,\"\u0004\bu\u0010.R$\u0010v\u001a\u00020*2\u0006\u0010)\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bw\u0010,\"\u0004\bx\u0010.R$\u0010y\u001a\u00020*2\u0006\u0010f\u001a\u00020*8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bz\u0010,\"\u0004\b{\u0010.R$\u0010|\u001a\u00020=2\u0006\u0010<\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010?\"\u0004\b}\u0010AR$\u0010~\u001a\u00020=2\u0006\u0010<\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010?\"\u0004\b\u007f\u0010A¨\u0006\u0081\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPen;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenPenInterface;", "context", "Landroid/content/Context;", "nativeHandle", "", "penType", "", "<init>", "(Landroid/content/Context;JI)V", "mContext", "penNativeHandle", "getPenNativeHandle", "()J", "setPenNativeHandle", "(J)V", "mType", "getMType", "()I", "setMType", "(I)V", "mBitmap", "Landroid/graphics/Bitmap;", "close", "", "draw", "event", "Landroid/view/MotionEvent;", "rect", "Landroid/graphics/RectF;", "redrawPen", "eventList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "setReferenceBitmap", "setDepthMapBitmap", "size", "", "getSize", "()F", "setSize", "(F)V", "minSettingValue", "getMinSettingValue", "maxSettingValue", "getMaxSettingValue", "color", "getColor", "setColor", "particleDensity", "getParticleDensity", "setParticleDensity", "particleSize", "getParticleSize", "setParticleSize", "enable", "", "isCurveEnabled", "()Z", "setCurveEnabled", "(Z)V", "setScreenResolution", "width", "height", "advancedSetting", "", "getAdvancedSetting", "()Ljava/lang/String;", "setAdvancedSetting", "(Ljava/lang/String;)V", "getPenAttribute", "attribute", "getStrokeRect", "stroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "points", "", "Landroid/graphics/PointF;", "pressures", "", "timestamps", "", "isCurvable", "advanced", "([Landroid/graphics/PointF;[F[IFZLjava/lang/String;)Landroid/graphics/RectF;", "eraser", "isEraserEnabled", "setEraserEnabled", "fixedWidth", "getFixedWidth", "setFixedWidth", "isFixedWidthEnabled", "setFixedWidthEnabled", "isFixedOpacityEnabled", "setFixedOpacityEnabled", "isAutoSizeEnabled", "setAutoSizeEnabled", "ratio", "fitRatio", "getFitRatio", "setFitRatio", "patternIndex", "getPatternIndex", "setPatternIndex", "patternScale", "getPatternScale", "setPatternScale", "dashType", "getDashType", "setDashType", "dashOffset", "getDashOffset", "setDashOffset", "blurSize", "getBlurSize", "setBlurSize", "insideRatio", "getInsideRatio", "setInsideRatio", "isRainbowEffectEnabled", "setRainbowEffectEnabled", "isTypePointerEnabled", "setTypePointerEnabled", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPen.kt\ncom/samsung/android/sdk/pen/pen/SpenPen\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,912:1\n1#2:913\n37#3,2:914\n*S KotlinDebug\n*F\n+ 1 SpenPen.kt\ncom/samsung/android/sdk/pen/pen/SpenPen\n*L\n156#1:914,2\n*E\n"})
public final class SpenPen implements SpenPenInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int PEN_ATTRIBUTE_ADVANCED_SETTING = 4;
    public static final int PEN_ATTRIBUTE_ALPHA = 1;
    public static final int PEN_ATTRIBUTE_COLOR = 2;
    public static final int PEN_ATTRIBUTE_CURVE = 3;
    public static final int PEN_ATTRIBUTE_FIXED_ALPHA = 9;
    public static final int PEN_ATTRIBUTE_FIXED_WIDTH = 8;
    public static final int PEN_ATTRIBUTE_PARTICLE_DENSITY = 5;
    public static final int PEN_ATTRIBUTE_PARTICLE_SIZE = 6;
    public static final int PEN_ATTRIBUTE_SECONDARY_COLOR = 7;
    public static final int PEN_ATTRIBUTE_SIZE = 0;
    public static final int PEN_TYPE_PEN = 0;
    public static final int PEN_TYPE_PREVIEWPEN = 1;

    @NotNull
    private static final String TAG = "SpenPen";

    @Nullable
    private Bitmap mBitmap;

    @Nullable
    private Context mContext;
    private int mType;
    private long penNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b3\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J+\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J\u001b\u0010!\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J\u001b\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u001fH\u0083 J\u001b\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u001fH\u0083 J\u0019\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0083 J\u0011\u0010)\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0011\u0010*\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0011\u0010+\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0007H\u0083 J\u0011\u0010.\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010/\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0007H\u0083 J\u0011\u00101\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0017H\u0083 J\u0011\u00104\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u00105\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0017H\u0083 J\u0011\u00107\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J!\u00108\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0083 J\u0019\u0010;\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u0005H\u0083 J\u0011\u0010=\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 JO\u0010>\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010'\u001a\u00020(2\u0006\u0010F\u001a\u00020\u00172\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0019\u0010H\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0007H\u0083 JA\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00010Kj\b\u0012\u0004\u0012\u00020\u0001`L2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u00072\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u00010Kj\b\u0012\u0004\u0012\u00020\u0001`LH\u0083 J\t\u0010O\u001a\u00020\u0017H\u0083 J+\u0010P\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J+\u0010Q\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J1\u0010R\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010@2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J\u001b\u0010T\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0083 J\u0019\u0010U\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001fH\u0083 J\u0019\u0010V\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001fH\u0083 J\u0011\u0010W\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0011\u0010X\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010Y\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020(H\u0083 J\u0011\u0010[\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010\\\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010]\u001a\u00020(H\u0083 J\u0011\u0010^\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010_\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0017H\u0083 J\u0011\u0010a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0017H\u0083 J\u0011\u0010c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010e\u001a\u00020(H\u0083 J\u0011\u0010f\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010g\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0017H\u0083 J\u0011\u0010h\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010i\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010j\u001a\u00020\u0007H\u0083 J\u0011\u0010k\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010l\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010m\u001a\u00020(H\u0083 J\u0011\u0010n\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010o\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010p\u001a\u00020\u0007H\u0083 J\u0011\u0010q\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010r\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010s\u001a\u00020(H\u0083 J\u0011\u0010t\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010u\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0083 J\u0011\u0010v\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010w\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010x\u001a\u00020(H\u0083 J\u0011\u0010y\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010z\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0017H\u0083 J\u0011\u0010{\u001a\u00020\u00172\u0006\u0010|\u001a\u00020\u0019H\u0083 J\u0019\u0010}\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0017H\u0083 J\u0011\u0010~\u001a\u00020\u00172\u0006\u0010|\u001a\u00020\u0019H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u007f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/pen/SpenPen$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PEN_ATTRIBUTE_SIZE", "", "PEN_ATTRIBUTE_ALPHA", "PEN_ATTRIBUTE_COLOR", "PEN_ATTRIBUTE_CURVE", "PEN_ATTRIBUTE_PARTICLE_DENSITY", "PEN_ATTRIBUTE_PARTICLE_SIZE", "PEN_ATTRIBUTE_SECONDARY_COLOR", "PEN_ATTRIBUTE_FIXED_WIDTH", "PEN_ATTRIBUTE_FIXED_ALPHA", "PEN_TYPE_PEN", "PEN_TYPE_PREVIEWPEN", "PEN_ATTRIBUTE_ADVANCED_SETTING", "getPEN_ATTRIBUTE_ADVANCED_SETTING$annotations", "getPEN_ATTRIBUTE_ADVANCED_SETTING", "()I", "native_draw", "", "nativePen", "", "event", "Lcom/samsung/android/sdk/pen/view/SpenMotionEvent;", "rect", "Landroid/graphics/RectF;", "bitmap", "Landroid/graphics/Bitmap;", "native_redraw", "native_setBitmap", "native_setReferenceBitmap", "background", "native_setDepthMapBitmap", "depthMap", "native_setSize", "size", "", "native_getSize", "native_getMinSettingValue", "native_getMaxSettingValue", "native_setColor", "color", "native_getColor", "native_setParticleDensity", "particleDensity", "native_getParticleDensity", "native_setCurveEnabled", VMetaDataPredefinedShape.CURVE, "native_isCurveEnabled", "native_setEraserEnabled", "eraser", "native_isEraserEnabled", "native_setScreenResolution", "width", "height", "native_setAdvancedSetting", "advancedSetting", "native_getAdvancedSetting", "native_getStrokeRect", "points", "", "Landroid/graphics/PointF;", "pressures", "", "timestamps", "", "isCurvable", "advanced", "native_getPenAttribute", "attribute", "native_command", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Contract.COMMAND, "objectList", "native_close", "native_preview_draw", "native_preview_redraw", "native_preview_redraw_list", "eventList", "native_preview_setBitmap", "native_preview_setReferenceBitmap", "native_preview_setDepthMapBitmap", "native_getMinDpSettingValue", "native_getMaxDpSettingValue", "native_setParticleSize", "particleSize", "native_getParticleSize", "native_setFixedWidth", "fixedWidth", "native_getFixedWidth", "native_setFixedWidthEnabled", "enable", "native_isFixedWidthEnabled", "native_setFixedOpacityEnabled", "native_isFixedOpacityEnabled", "native_setFitRatio", "fitRatio", "native_getFitRatio", "native_setAutoSizeEnabled", "native_isAutoSizeEnabled", "native_setPatternIndex", "index", "native_getPatternIndex", "native_setPatternScale", WiggleAnimationConfig.KEY_SCALE, "native_getPatternScale", "native_setDashType", "dashType", "native_getDashType", "native_setDashOffset", "dashOffset", "native_getDashOffset", "native_setBlurSize", "native_getBlurSize", "native_setInsideRatio", "ratio", "native_getInsideRatio", "native_setRainbowEffectEnabled", "native_isRainbowEffectEnabled", "mNativeHandle", "native_setTypePointerEnabled", "native_isTypePointerEnabled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getPEN_ATTRIBUTE_ADVANCED_SETTING$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_close() {
            return SpenPen.native_close();
        }

        @JvmStatic
        private final ArrayList<Object> native_command(long nativePen, int command, ArrayList<Object> objectList) {
            return SpenPen.native_command(nativePen, command, objectList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_draw(long nativePen, SpenMotionEvent event, RectF rect, Bitmap bitmap) {
            return SpenPen.native_draw(nativePen, event, rect, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String native_getAdvancedSetting(long nativePen) {
            return SpenPen.native_getAdvancedSetting(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getBlurSize(long nativePen) {
            return SpenPen.native_getBlurSize(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getColor(long nativePen) {
            return SpenPen.native_getColor(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getDashOffset(long nativePen) {
            return SpenPen.native_getDashOffset(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getDashType(long nativePen) {
            return SpenPen.native_getDashType(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getFitRatio(long nativePen) {
            return SpenPen.native_getFitRatio(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getFixedWidth(long nativePen) {
            return SpenPen.native_getFixedWidth(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getInsideRatio(long nativePen) {
            return SpenPen.native_getInsideRatio(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getMaxDpSettingValue(long nativePen) {
            return SpenPen.native_getMaxDpSettingValue(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getMaxSettingValue(long nativePen) {
            return SpenPen.native_getMaxSettingValue(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getMinDpSettingValue(long nativePen) {
            return SpenPen.native_getMinDpSettingValue(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getMinSettingValue(long nativePen) {
            return SpenPen.native_getMinSettingValue(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getParticleDensity(long nativePen) {
            return SpenPen.native_getParticleDensity(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getParticleSize(long nativePen) {
            return SpenPen.native_getParticleSize(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int native_getPatternIndex(long nativePen) {
            return SpenPen.native_getPatternIndex(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getPatternScale(long nativePen) {
            return SpenPen.native_getPatternScale(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_getPenAttribute(long nativePen, int attribute) {
            return SpenPen.native_getPenAttribute(nativePen, attribute);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float native_getSize(long nativePen) {
            return SpenPen.native_getSize(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF native_getStrokeRect(long j, PointF[] pointFArr, float[] fArr, int[] iArr, float f, boolean z, String str) {
            return SpenPen.native_getStrokeRect(j, pointFArr, fArr, iArr, f, z, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isAutoSizeEnabled(long nativePen) {
            return SpenPen.native_isAutoSizeEnabled(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isCurveEnabled(long nativePen) {
            return SpenPen.native_isCurveEnabled(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isEraserEnabled(long nativePen) {
            return SpenPen.native_isEraserEnabled(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isFixedOpacityEnabled(long nativePen) {
            return SpenPen.native_isFixedOpacityEnabled(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isFixedWidthEnabled(long nativePen) {
            return SpenPen.native_isFixedWidthEnabled(nativePen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isRainbowEffectEnabled(long mNativeHandle) {
            return SpenPen.native_isRainbowEffectEnabled(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_isTypePointerEnabled(long mNativeHandle) {
            return SpenPen.native_isTypePointerEnabled(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_draw(long nativePen, SpenMotionEvent event, RectF rect, Bitmap bitmap) {
            return SpenPen.native_preview_draw(nativePen, event, rect, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_redraw(long nativePen, SpenMotionEvent event, RectF rect, Bitmap bitmap) {
            return SpenPen.native_preview_redraw(nativePen, event, rect, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_redraw_list(long j, Object[] objArr, RectF rectF, Bitmap bitmap) {
            return SpenPen.native_preview_redraw_list(j, objArr, rectF, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_setBitmap(long nativePen, Bitmap bitmap) {
            return SpenPen.native_preview_setBitmap(nativePen, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_setDepthMapBitmap(long nativePen, Bitmap depthMap) {
            return SpenPen.native_preview_setDepthMapBitmap(nativePen, depthMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_preview_setReferenceBitmap(long nativePen, Bitmap background) {
            return SpenPen.native_preview_setReferenceBitmap(nativePen, background);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_redraw(long nativePen, SpenMotionEvent event, RectF rect, Bitmap bitmap) {
            return SpenPen.native_redraw(nativePen, event, rect, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setAdvancedSetting(long nativePen, String advancedSetting) {
            return SpenPen.native_setAdvancedSetting(nativePen, advancedSetting);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setAutoSizeEnabled(long nativePen, boolean enable) {
            return SpenPen.native_setAutoSizeEnabled(nativePen, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setBitmap(long nativePen, Bitmap bitmap) {
            return SpenPen.native_setBitmap(nativePen, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setBlurSize(long nativePen, float size) {
            return SpenPen.native_setBlurSize(nativePen, size);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setColor(long nativePen, int color) {
            return SpenPen.native_setColor(nativePen, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setCurveEnabled(long nativePen, boolean curve) {
            return SpenPen.native_setCurveEnabled(nativePen, curve);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setDashOffset(long nativePen, float dashOffset) {
            return SpenPen.native_setDashOffset(nativePen, dashOffset);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setDashType(long nativePen, int dashType) {
            return SpenPen.native_setDashType(nativePen, dashType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setDepthMapBitmap(long nativePen, Bitmap depthMap) {
            return SpenPen.native_setDepthMapBitmap(nativePen, depthMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setEraserEnabled(long nativePen, boolean eraser) {
            return SpenPen.native_setEraserEnabled(nativePen, eraser);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setFitRatio(long nativePen, float fitRatio) {
            return SpenPen.native_setFitRatio(nativePen, fitRatio);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setFixedOpacityEnabled(long nativePen, boolean enable) {
            return SpenPen.native_setFixedOpacityEnabled(nativePen, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setFixedWidth(long nativePen, float fixedWidth) {
            return SpenPen.native_setFixedWidth(nativePen, fixedWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setFixedWidthEnabled(long nativePen, boolean enable) {
            return SpenPen.native_setFixedWidthEnabled(nativePen, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setInsideRatio(long nativePen, float ratio) {
            return SpenPen.native_setInsideRatio(nativePen, ratio);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setParticleDensity(long nativePen, int particleDensity) {
            return SpenPen.native_setParticleDensity(nativePen, particleDensity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setParticleSize(long nativePen, float particleSize) {
            return SpenPen.native_setParticleSize(nativePen, particleSize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setPatternIndex(long nativePen, int index) {
            return SpenPen.native_setPatternIndex(nativePen, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setPatternScale(long nativePen, float scale) {
            return SpenPen.native_setPatternScale(nativePen, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setRainbowEffectEnabled(long nativePen, boolean enable) {
            return SpenPen.native_setRainbowEffectEnabled(nativePen, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setReferenceBitmap(long nativePen, Bitmap background) {
            return SpenPen.native_setReferenceBitmap(nativePen, background);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setScreenResolution(long nativePen, int width, int height) {
            return SpenPen.native_setScreenResolution(nativePen, width, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setSize(long nativePen, float size) {
            return SpenPen.native_setSize(nativePen, size);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean native_setTypePointerEnabled(long nativePen, boolean enable) {
            return SpenPen.native_setTypePointerEnabled(nativePen, enable);
        }

        public final int getPEN_ATTRIBUTE_ADVANCED_SETTING() {
            return SpenPen.PEN_ATTRIBUTE_ADVANCED_SETTING;
        }

        private Companion() {
        }
    }

    public SpenPen(@Nullable Context context, long j, int i) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        if (j == 0) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'nativeHandle' is null");
        }
        this.mContext = context;
        this.penNativeHandle = j;
        this.mType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_close();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<Object> native_command(long j, int i, ArrayList<Object> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_draw(long j, SpenMotionEvent spenMotionEvent, RectF rectF, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String native_getAdvancedSetting(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getBlurSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getColor(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getDashOffset(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getDashType(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getFitRatio(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getFixedWidth(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getInsideRatio(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getMaxDpSettingValue(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getMaxSettingValue(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getMinDpSettingValue(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getMinSettingValue(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getParticleDensity(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getParticleSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int native_getPatternIndex(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getPatternScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_getPenAttribute(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float native_getSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF native_getStrokeRect(long j, PointF[] pointFArr, float[] fArr, int[] iArr, float f, boolean z, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isAutoSizeEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isCurveEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isEraserEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isFixedOpacityEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isFixedWidthEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isRainbowEffectEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_isTypePointerEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_draw(long j, SpenMotionEvent spenMotionEvent, RectF rectF, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_redraw(long j, SpenMotionEvent spenMotionEvent, RectF rectF, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_redraw_list(long j, Object[] objArr, RectF rectF, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_setBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_setDepthMapBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_preview_setReferenceBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_redraw(long j, SpenMotionEvent spenMotionEvent, RectF rectF, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setAdvancedSetting(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setAutoSizeEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setBlurSize(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setColor(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setCurveEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setDashOffset(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setDashType(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setDepthMapBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setEraserEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setFitRatio(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setFixedOpacityEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setFixedWidth(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setFixedWidthEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setInsideRatio(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setParticleDensity(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setParticleSize(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setPatternIndex(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setPatternScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setRainbowEffectEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setReferenceBitmap(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setScreenResolution(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setSize(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean native_setTypePointerEnabled(long j, boolean z);

    public final void close() {
        this.mContext = null;
        INSTANCE.native_close();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void draw(@NotNull MotionEvent event, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.penNativeHandle == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        if (bitmap != null && bitmap.isRecycled()) {
            this.mBitmap = null;
            return;
        }
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 != null) {
            bitmap2.setPixel(0, 0, 0);
        }
        SpenMotionEvent spenMotionEvent = new SpenMotionEvent(event);
        int i = this.mType;
        if (i == 0) {
            if (INSTANCE.native_draw(this.penNativeHandle, spenMotionEvent, rect, this.mBitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        } else {
            if (i != 1 || INSTANCE.native_preview_draw(this.penNativeHandle, spenMotionEvent, rect, this.mBitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    @Deprecated(message = "")
    @NotNull
    public String getAdvancedSetting() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getAdvancedSetting(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    @Nullable
    public Bitmap getBitmap() {
        if (this.penNativeHandle != 0) {
            return this.mBitmap;
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getBlurSize() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getBlurSize(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public int getColor() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getColor(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getDashOffset() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getDashOffset(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final int getDashType() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getDashType(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getFitRatio() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getFitRatio(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getFixedWidth() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getFixedWidth(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getInsideRatio() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getInsideRatio(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final int getMType() {
        return this.mType;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMaxSettingValue() {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        int i = this.mType;
        if (i == 0) {
            return INSTANCE.native_getMaxSettingValue(j);
        }
        if (i == 1) {
            return INSTANCE.native_getMaxDpSettingValue(j);
        }
        return -1.0f;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getMinSettingValue() {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        int i = this.mType;
        if (i == 0) {
            return INSTANCE.native_getMinSettingValue(j);
        }
        if (i == 1) {
            return INSTANCE.native_getMinDpSettingValue(j);
        }
        return -1.0f;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public int getParticleDensity() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getParticleDensity(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getParticleSize() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getParticleSize(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final int getPatternIndex() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getPatternIndex(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final float getPatternScale() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getPatternScale(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean getPenAttribute(int attribute) {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getPenAttribute(j, attribute);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final long getPenNativeHandle() {
        return this.penNativeHandle;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public float getSize() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getSize(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @NotNull
    public final RectF getStrokeRect(@NotNull SpenObjectStroke stroke) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getStrokeRect(j, stroke.getPoints(), stroke.getPressures(), stroke.getTimeStamps(), stroke.getPenSize(), stroke.isCurveEnabled(), stroke.getAdvancedPenSetting());
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final boolean isAutoSizeEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isAutoSizeEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean isCurveEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isCurveEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public boolean isEraserEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isEraserEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final boolean isFixedOpacityEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isFixedOpacityEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final boolean isFixedWidthEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isFixedWidthEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final boolean isRainbowEffectEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isRainbowEffectEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final boolean isTypePointerEnabled() {
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_isTypePointerEnabled(j);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void redrawPen(@NotNull MotionEvent event, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.penNativeHandle == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        if (bitmap != null && bitmap.isRecycled()) {
            Log.d(TAG, "redrawPen mBitmap.isRecycled(");
            this.mBitmap = null;
            return;
        }
        Bitmap bitmap2 = this.mBitmap;
        if (bitmap2 != null) {
            bitmap2.setPixel(0, 0, 0);
        }
        SpenMotionEvent spenMotionEvent = new SpenMotionEvent(event);
        int i = this.mType;
        if (i == 0) {
            if (INSTANCE.native_redraw(this.penNativeHandle, spenMotionEvent, rect, this.mBitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        } else {
            if (i != 1 || INSTANCE.native_preview_redraw(this.penNativeHandle, spenMotionEvent, rect, this.mBitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    @Deprecated(message = "")
    public void setAdvancedSetting(@NotNull String advancedSetting) {
        Intrinsics.checkNotNullParameter(advancedSetting, "advancedSetting");
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setAdvancedSetting(j, advancedSetting)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setAutoSizeEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setAutoSizeEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setBitmap(@Nullable Bitmap bitmap) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        this.mBitmap = bitmap;
        if (bitmap == null) {
            return;
        }
        int i = this.mType;
        if (i == 0) {
            if (INSTANCE.native_setBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        } else {
            if (i != 1 || INSTANCE.native_preview_setBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    public final void setBlurSize(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setBlurSize(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setColor(int i) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setColor(j, i)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setCurveEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setCurveEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setDashOffset(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setDashOffset(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setDashType(int i) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setDashType(j, i)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setDepthMapBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        int i = this.mType;
        if (i == 0) {
            if (INSTANCE.native_setDepthMapBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        } else {
            if (i != 1 || INSTANCE.native_preview_setDepthMapBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setEraserEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setEraserEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setFitRatio(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setFitRatio(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setFixedOpacityEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setFixedOpacityEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setFixedWidth(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setFixedWidth(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setFixedWidthEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setFixedWidthEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setInsideRatio(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setInsideRatio(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setParticleDensity(int i) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setParticleDensity(j, i)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setParticleSize(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setParticleSize(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setPatternIndex(int i) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setPatternIndex(j, i)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setPatternScale(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setPatternScale(j, f)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    public final void setPenNativeHandle(long j) {
        this.penNativeHandle = j;
    }

    public final void setRainbowEffectEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setRainbowEffectEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setReferenceBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        int i = this.mType;
        if (i == 0) {
            if (INSTANCE.native_setReferenceBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        } else {
            if (i != 1 || INSTANCE.native_preview_setReferenceBitmap(j, bitmap)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setScreenResolution(int width, int height) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setScreenResolution(j, width, height)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    public void setSize(float f) {
        long j = this.penNativeHandle;
        if (j == 0) {
            SpenError.ThrowUncheckedException(8, "pen is not loaded");
        } else if (f <= 0.0f) {
            SpenError.ThrowUncheckedException(7, "pen size is invalid");
        } else {
            if (INSTANCE.native_setSize(j, f)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError(), toString());
        }
    }

    public final void setTypePointerEnabled(boolean z) {
        long j = this.penNativeHandle;
        if (j == 0) {
            throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
        }
        if (INSTANCE.native_setTypePointerEnabled(j, z)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface
    @NotNull
    public RectF getStrokeRect(@NotNull PointF[] points, @NotNull float[] pressures, @NotNull int[] timestamps, float size, boolean isCurvable, @NotNull String advanced) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(pressures, "pressures");
        Intrinsics.checkNotNullParameter(timestamps, "timestamps");
        Intrinsics.checkNotNullParameter(advanced, "advanced");
        long j = this.penNativeHandle;
        if (j != 0) {
            return INSTANCE.native_getStrokeRect(j, points, pressures, timestamps, size, isCurvable, advanced);
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }

    public final void redrawPen(@NotNull ArrayList<MotionEvent> eventList, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.penNativeHandle != 0) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null) {
                return;
            }
            if (bitmap != null && bitmap.isRecycled()) {
                Log.d(TAG, "redrawPen mBitmap.isRecycled(");
                this.mBitmap = null;
                return;
            }
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 != null) {
                bitmap2.setPixel(0, 0, 0);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<MotionEvent> it = eventList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MotionEvent next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                arrayList.add(new SpenMotionEvent(next));
            }
            int i = this.mType;
            if (i != 0) {
                if (i != 1 || INSTANCE.native_preview_redraw_list(this.penNativeHandle, arrayList.toArray(new Object[0]), rect, this.mBitmap)) {
                    return;
                }
                SpenError.ThrowUncheckedException(SpenError.getError(), toString());
                return;
            }
            Iterator it2 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                SpenMotionEvent spenMotionEvent = (SpenMotionEvent) next2;
                if (this.mType == 0) {
                    RectF rectF = rect;
                    if (!INSTANCE.native_redraw(this.penNativeHandle, spenMotionEvent, rectF, this.mBitmap)) {
                        SpenError.ThrowUncheckedException(SpenError.getError(), toString());
                    }
                    rect = rectF;
                }
            }
            return;
        }
        throw new IllegalStateException("E_INVALID_STATE : pen is not loaded");
    }
}
