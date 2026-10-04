package androidx.compose.p109ui.layout;

import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\fH\u0002\u001a%\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0019\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, m13886d2 = {"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScaleFactor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaleFactor.kt\nandroidx/compose/ui/layout/ScaleFactorKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,199:1\n131#1:203\n63#2,3:200\n*S KotlinDebug\n*F\n+ 1 ScaleFactor.kt\nandroidx/compose/ui/layout/ScaleFactorKt\n*L\n145#1:203\n32#1:200,3\n*E\n"})
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f, float f4) {
        return ScaleFactor.m19938constructorimpl((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m19952divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m18353getWidthimpl(j) / ScaleFactor.m19944getScaleXimpl(j2), Size.m18350getHeightimpl(j) / ScaleFactor.m19945getScaleYimpl(j2));
    }

    /* JADX INFO: renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m19953isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.Companion.m19951getUnspecified_hLwfpc();
    }

    /* JADX INFO: renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m19955isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.Companion.m19951getUnspecified_hLwfpc();
    }

    @Stable
    /* JADX INFO: renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m19957lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m19944getScaleXimpl(j), ScaleFactor.m19944getScaleXimpl(j2), f), MathHelpersKt.lerp(ScaleFactor.m19945getScaleYimpl(j), ScaleFactor.m19945getScaleYimpl(j2), f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f) {
        float f4 = 10;
        float f5 = f * f4;
        int i = (int) f5;
        if (f5 - i >= 0.5f) {
            i++;
        }
        return i / f4;
    }

    /* JADX INFO: renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m19958takeOrElseoyDd2qo(long j, @NotNull Function0<ScaleFactor> function0) {
        return j != ScaleFactor.Companion.m19951getUnspecified_hLwfpc() ? j : function0.invoke().m19949unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m19959timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(ScaleFactor.m19944getScaleXimpl(j2) * Size.m18353getWidthimpl(j), ScaleFactor.m19945getScaleYimpl(j2) * Size.m18350getHeightimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m19960timesmw2e94(long j, long j2) {
        return m19959timesUQTWf7w(j2, j);
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m19954isSpecifiedFK8aYYs$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m19956isUnspecifiedFK8aYYs$annotations(long j) {
    }
}
