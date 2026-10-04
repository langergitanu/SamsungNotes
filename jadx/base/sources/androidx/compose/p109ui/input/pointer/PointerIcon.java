package androidx.compose.p109ui.input.pointer;

import androidx.compose.runtime.Stable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon;", "", "Companion", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PointerIcon {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/PointerIcon$Companion;", "", "()V", "Crosshair", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getCrosshair", "()Landroidx/compose/ui/input/pointer/PointerIcon;", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "getDefault", "Hand", "getHand", Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT, "getText", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();

        @NotNull
        private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();

        @NotNull
        private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();

        @NotNull
        private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

        private Companion() {
        }

        @NotNull
        public final PointerIcon getCrosshair() {
            return Crosshair;
        }

        @NotNull
        public final PointerIcon getDefault() {
            return Default;
        }

        @NotNull
        public final PointerIcon getHand() {
            return Hand;
        }

        @NotNull
        public final PointerIcon getText() {
            return Text;
        }
    }
}
