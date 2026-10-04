package androidx.glance.unit;

import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m13886d2 = {"Landroidx/glance/unit/Dimension;", "", "()V", "Dp", "Expand", "Fill", "Resource", "Wrap", "Landroidx/glance/unit/Dimension$Dp;", "Landroidx/glance/unit/Dimension$Expand;", "Landroidx/glance/unit/Dimension$Fill;", "Landroidx/glance/unit/Dimension$Resource;", "Landroidx/glance/unit/Dimension$Wrap;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Dimension {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: androidx.glance.unit.Dimension$Dp */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m13886d2 = {"Landroidx/glance/unit/Dimension$Dp;", "Landroidx/glance/unit/Dimension;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDp-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class C3532Dp extends Dimension {
        public static final int $stable = 0;
        private final float dp;

        public /* synthetic */ C3532Dp(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        /* JADX INFO: renamed from: getDp-D9Ej5fM, reason: not valid java name and from getter */
        public final float getDp() {
            return this.dp;
        }

        private C3532Dp(float f) {
            super(null);
            this.dp = f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/unit/Dimension$Expand;", "Landroidx/glance/unit/Dimension;", "()V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Expand extends Dimension {
        public static final int $stable = 0;

        @NotNull
        public static final Expand INSTANCE = new Expand();

        private Expand() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/unit/Dimension$Fill;", "Landroidx/glance/unit/Dimension;", "()V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Fill extends Dimension {
        public static final int $stable = 0;

        @NotNull
        public static final Fill INSTANCE = new Fill();

        private Fill() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/glance/unit/Dimension$Resource;", "Landroidx/glance/unit/Dimension;", "res", "", "(I)V", "getRes", "()I", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Resource extends Dimension {
        public static final int $stable = 0;
        private final int res;

        public Resource(@DimenRes int i) {
            super(null);
            this.res = i;
        }

        public final int getRes() {
            return this.res;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/unit/Dimension$Wrap;", "Landroidx/glance/unit/Dimension;", "()V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Wrap extends Dimension {
        public static final int $stable = 0;

        @NotNull
        public static final Wrap INSTANCE = new Wrap();

        private Wrap() {
            super(null);
        }
    }

    public /* synthetic */ Dimension(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Dimension() {
    }
}
