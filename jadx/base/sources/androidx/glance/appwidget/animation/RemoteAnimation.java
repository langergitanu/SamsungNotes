package androidx.glance.appwidget.animation;

import android.net.Uri;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.internal.StabilityInferred;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation;", "", "()V", "ColorAnimation", "DecimalTextAnimation", "DrawableAnimation", "FloatTextAnimation", "ProgressAnimation", "PropertyAnimation", "RemoteTextAnimation", "ViewAnimation", "WidthAnimation", "Landroidx/glance/appwidget/animation/RemoteAnimation$ColorAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$DrawableAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$PropertyAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$RemoteTextAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$ViewAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$WidthAnimation;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class RemoteAnimation {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$ColorAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", Constants.MessagePayloadKeys.FROM, "Landroidx/compose/ui/graphics/Color;", "to", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFrom-0d7_KjU", "()J", "J", "getTo-0d7_KjU", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ColorAnimation extends RemoteAnimation {
        public static final int $stable = 0;
        private final long from;
        private final long to;

        public /* synthetic */ ColorAnimation(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2);
        }

        /* JADX INFO: renamed from: getFrom-0d7_KjU, reason: not valid java name and from getter */
        public final long getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: getTo-0d7_KjU, reason: not valid java name and from getter */
        public final long getTo() {
            return this.to;
        }

        private ColorAnimation(long j, long j2) {
            super(null);
            this.from = j;
            this.to = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$DecimalTextAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$RemoteTextAnimation;", "", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "(III)V", "getDuration", "()I", "getFrom", "()Ljava/lang/Integer;", "getTo", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class DecimalTextAnimation extends RemoteTextAnimation<Integer> {
        public static final int $stable = 0;
        private final int duration;
        private final int from;
        private final int to;

        public DecimalTextAnimation(int i, int i2, int i4) {
            super(null, "#,###", Integer.valueOf(i), Integer.valueOf(i2), i4, 1, null);
            this.from = i;
            this.to = i2;
            this.duration = i4;
        }

        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        public int getDuration() {
            return this.duration;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        @NotNull
        public Integer getFrom() {
            return Integer.valueOf(this.from);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        @NotNull
        public Integer getTo() {
            return Integer.valueOf(this.to);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$FloatTextAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation$RemoteTextAnimation;", "", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "", "floatPoint", "(FFII)V", "getDuration", "()I", "getFrom", "()Ljava/lang/Float;", "getTo", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class FloatTextAnimation extends RemoteTextAnimation<Float> {
        public static final int $stable = 0;
        private final int duration;
        private final float from;
        private final float to;

        public /* synthetic */ FloatTextAnimation(float f, float f4, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f4, i, (i4 & 8) != 0 ? 1 : i2);
        }

        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        public int getDuration() {
            return this.duration;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[PHI: r0
          0x0003: PHI (r0v4 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0001, B:6:0x0006] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FloatTextAnimation(float f, float f4, int i, int i2) {
            int i4 = 1;
            if (i2 < 1) {
                i2 = i4;
            } else {
                i4 = 3;
                if (i2 > 3) {
                }
            }
            super(null, AbstractC0541b.m772n("0.", StringsKt__StringsJVMKt.repeat("0", i2)), Float.valueOf(f), Float.valueOf(f4), i, 1, null);
            this.from = f;
            this.to = f4;
            this.duration = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        @NotNull
        public Float getFrom() {
            return Float.valueOf(this.from);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.glance.appwidget.animation.RemoteAnimation.RemoteTextAnimation
        @NotNull
        public Float getTo() {
            return Float.valueOf(this.to);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$ProgressAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", Constants.MessagePayloadKeys.FROM, "", "to", XmlErrorCodes.DURATION, "", "(FFI)V", "getDuration", "()I", "getFrom", "()F", "getTo", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ProgressAnimation extends RemoteAnimation {
        public static final int $stable = 0;
        private final int duration;
        private final float from;
        private final float to;

        public ProgressAnimation(@FloatRange(from = 0.0d, m705to = 1.0d) float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, int i) {
            super(null);
            this.from = f;
            this.to = f4;
            this.duration = i;
        }

        public final int getDuration() {
            return this.duration;
        }

        public final float getFrom() {
            return this.from;
        }

        public final float getTo() {
            return this.to;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$PropertyAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "animResId", "", "(I)V", "getAnimResId", "()I", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class PropertyAnimation extends RemoteAnimation {
        public static final int $stable = 0;
        private final int animResId;

        public PropertyAnimation(@AnimatorRes int i) {
            super(null);
            this.animResId = i;
        }

        public final int getAnimResId() {
            return this.animResId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$ViewAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "animResId", "", "(I)V", "getAnimResId", "()I", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class ViewAnimation extends RemoteAnimation {
        public static final int $stable = 0;
        private final int animResId;

        public ViewAnimation(@AnimRes int i) {
            super(null);
            this.animResId = i;
        }

        public final int getAnimResId() {
            return this.animResId;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$WidthAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", Constants.MessagePayloadKeys.FROM, "Landroidx/compose/ui/unit/Dp;", "to", XmlErrorCodes.DURATION, "", "(FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration", "()I", "getFrom-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getTo-D9Ej5fM", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class WidthAnimation extends RemoteAnimation {
        public static final int $stable = 0;
        private final int duration;
        private final float from;
        private final float to;

        public /* synthetic */ WidthAnimation(float f, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f4, i);
        }

        public final int getDuration() {
            return this.duration;
        }

        /* JADX INFO: renamed from: getFrom-D9Ej5fM, reason: not valid java name and from getter */
        public final float getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: getTo-D9Ej5fM, reason: not valid java name and from getter */
        public final float getTo() {
            return this.to;
        }

        private WidthAnimation(float f, float f4, int i) {
            super(null);
            this.from = f;
            this.to = f4;
            this.duration = i;
        }
    }

    public /* synthetic */ RemoteAnimation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$DrawableAnimation;", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "start", "", "drawableResId", "", "(ZI)V", "uri", "Landroid/net/Uri;", "(ZLandroid/net/Uri;)V", "(Z)V", "_resValue", "", "resValue", "getResValue", "()Ljava/lang/Object;", "getStart", "()Z", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @RequiresApi(29)
    public static final class DrawableAnimation extends RemoteAnimation {
        public static final int $stable = 8;
        private Object _resValue;
        private final boolean start;

        public DrawableAnimation(boolean z) {
            super(null);
            this.start = z;
        }

        @NotNull
        public final Object getResValue() {
            Object obj = this._resValue;
            if (obj != null) {
                return obj;
            }
            Intrinsics.throwUninitializedPropertyAccessException("_resValue");
            return Unit.INSTANCE;
        }

        public final boolean getStart() {
            return this.start;
        }

        public DrawableAnimation(boolean z, @DrawableRes int i) {
            this(z);
            this._resValue = Integer.valueOf(i);
        }

        public /* synthetic */ DrawableAnimation(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i2 & 2) != 0 ? 0 : i);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DrawableAnimation(boolean z, @NotNull Uri uri) {
            this(z);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this._resValue = uri;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, m13886d2 = {"Landroidx/glance/appwidget/animation/RemoteAnimation$RemoteTextAnimation;", "T", "Landroidx/glance/appwidget/animation/RemoteAnimation;", "animType", "", "valueType", Constants.MessagePayloadKeys.FROM, "to", XmlErrorCodes.DURATION, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;I)V", "getAnimType", "()Ljava/lang/String;", "getDuration", "()I", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "getValueType", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class RemoteTextAnimation<T> extends RemoteAnimation {
        public static final int $stable = 0;

        @NotNull
        private final String animType;
        private final int duration;
        private final T from;
        private final T to;

        @NotNull
        private final String valueType;

        public /* synthetic */ RemoteTextAnimation(String str, String str2, Object obj, Object obj2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "decimal_text" : str, str2, obj, obj2, i);
        }

        @NotNull
        public final String getAnimType() {
            return this.animType;
        }

        public int getDuration() {
            return this.duration;
        }

        public T getFrom() {
            return this.from;
        }

        public T getTo() {
            return this.to;
        }

        @NotNull
        public final String getValueType() {
            return this.valueType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoteTextAnimation(@NotNull String animType, @NotNull String valueType, T t, T t2, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(animType, "animType");
            Intrinsics.checkNotNullParameter(valueType, "valueType");
            this.animType = animType;
            this.valueType = valueType;
            this.from = t;
            this.to = t2;
            this.duration = i;
        }
    }

    private RemoteAnimation() {
    }
}
