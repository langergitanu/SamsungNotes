package androidx.glance.text;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.java.awt.Font;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/text/FontFamily;", "", "family", "", "(Ljava/lang/String;)V", "getFamily", "()Ljava/lang/String;", "toString", "Companion", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class FontFamily {
    public static final int $stable = 0;

    @NotNull
    private final String family;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final FontFamily Serif = new FontFamily("serif");

    @NotNull
    private static final FontFamily SansSerif = new FontFamily("sans-serif");

    @NotNull
    private static final FontFamily Monospace = new FontFamily("monospace");

    @NotNull
    private static final FontFamily Cursive = new FontFamily("cursive");

    @NotNull
    private static final FontFamily Sec = new FontFamily("sec");

    @NotNull
    private static final FontFamily SecNum = new FontFamily("sec-num");

    @NotNull
    private static final FontFamily SecNumFixed = new FontFamily("sec-num-fixed");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/text/FontFamily$Companion;", "", "()V", "Cursive", "Landroidx/glance/text/FontFamily;", "getCursive", "()Landroidx/glance/text/FontFamily;", "Monospace", "getMonospace", Font.SANS_SERIF, "getSansSerif", "Sec", "getSec", "SecNum", "getSecNum", "SecNumFixed", "getSecNumFixed", Font.SERIF, "getSerif", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FontFamily getCursive() {
            return FontFamily.Cursive;
        }

        @NotNull
        public final FontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        @NotNull
        public final FontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        @NotNull
        public final FontFamily getSec() {
            return FontFamily.Sec;
        }

        @NotNull
        public final FontFamily getSecNum() {
            return FontFamily.SecNum;
        }

        @NotNull
        public final FontFamily getSecNumFixed() {
            return FontFamily.SecNumFixed;
        }

        @NotNull
        public final FontFamily getSerif() {
            return FontFamily.Serif;
        }

        private Companion() {
        }
    }

    public FontFamily(@NotNull String family) {
        Intrinsics.checkNotNullParameter(family, "family");
        this.family = family;
    }

    @NotNull
    public final String getFamily() {
        return this.family;
    }

    @NotNull
    public String toString() {
        return this.family;
    }
}
