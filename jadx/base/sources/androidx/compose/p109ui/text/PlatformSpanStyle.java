package androidx.compose.p109ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, m13886d2 = {"Landroidx/compose/ui/text/PlatformSpanStyle;", "", "()V", "equals", "", "other", "hashCode", "", "merge", "toString", "", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PlatformSpanStyle {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final PlatformSpanStyle Default = new PlatformSpanStyle();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/ui/text/PlatformSpanStyle$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/PlatformSpanStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlatformSpanStyle getDefault() {
            return PlatformSpanStyle.Default;
        }

        private Companion() {
        }
    }

    public boolean equals(@Nullable Object other) {
        return this == other || (other instanceof PlatformSpanStyle);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlatformSpanStyle()";
    }

    @NotNull
    public final PlatformSpanStyle merge(@Nullable PlatformSpanStyle other) {
        return this;
    }
}
