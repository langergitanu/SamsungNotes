package androidx.compose.p109ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.contentcapture.AbstractC2027a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewTranslationCallbackS;", "", "()V", "clearViewTranslationCallback", "", "view", "Landroid/view/View;", "setViewTranslationCallback", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidComposeViewTranslationCallbackS {
    public static final int $stable = 0;

    @NotNull
    public static final AndroidComposeViewTranslationCallbackS INSTANCE = new AndroidComposeViewTranslationCallbackS();

    private AndroidComposeViewTranslationCallbackS() {
    }

    @DoNotInline
    @RequiresApi(31)
    public final void clearViewTranslationCallback(@NotNull View view) {
        view.clearViewTranslationCallback();
    }

    @DoNotInline
    @RequiresApi(31)
    public final void setViewTranslationCallback(@NotNull View view) {
        view.setViewTranslationCallback(AbstractC2027a.m1358o(AndroidComposeViewTranslationCallback.INSTANCE));
    }
}
