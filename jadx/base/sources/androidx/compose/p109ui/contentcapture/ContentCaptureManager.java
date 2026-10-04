package androidx.compose.p109ui.contentcapture;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "", "Companion", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ContentCaptureManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R,\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/contentcapture/ContentCaptureManager$Companion;", "", "()V", "<set-?>", "", "isEnabled", "isEnabled$annotations", "()Z", "setEnabled", "(Z)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean isEnabled = true;

        private Companion() {
        }

        @ExperimentalComposeUiApi
        public final boolean isEnabled() {
            return isEnabled;
        }

        @ExperimentalComposeUiApi
        public final void setEnabled(boolean z) {
            isEnabled = z;
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void isEnabled$annotations() {
        }
    }
}
