package androidx.fragment.app;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¨\u0006\u0006"}, m13886d2 = {"seslSetAnimations", "Landroidx/fragment/app/FragmentTransaction;", "context", "Landroid/content/Context;", "isRtl", "", "fragment_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SeslFragmentTransactionKt {
    @RequiresApi(23)
    @NotNull
    public static final FragmentTransaction seslSetAnimations(@NotNull FragmentTransaction fragmentTransaction, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (seslSetAnimations$isDefaultTheme(context)) {
            return seslSetAnimations(fragmentTransaction, AbstractC0541b.m759a(context) == 1);
        }
        return fragmentTransaction;
    }

    private static final boolean seslSetAnimations$isDefaultTheme(Context context) {
        return TextUtils.isEmpty(Settings.System.getString(context.getContentResolver(), "current_sec_active_themepackage")) && !seslSetAnimations$themeParkApplied();
    }

    private static final boolean seslSetAnimations$themeParkApplied() {
        return AbstractC2322a.m1607A("/data/overlays/themepark/state_applied.txt");
    }

    @Deprecated(message = "This api was deprecated. please use with context", replaceWith = @ReplaceWith(expression = "this.seslSetAnimations(context)", imports = {}))
    @RequiresApi(23)
    @NotNull
    public static final FragmentTransaction seslSetAnimations(@NotNull FragmentTransaction fragmentTransaction) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        return seslSetAnimations(fragmentTransaction, false);
    }

    @RequiresApi(23)
    private static final FragmentTransaction seslSetAnimations(FragmentTransaction fragmentTransaction, boolean z) {
        SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet;
        if (z) {
            seslFragmentTransactionAnimationSet = SeslFragmentTransactionAnimationSet.HorizontalForRTL;
        } else {
            seslFragmentTransactionAnimationSet = SeslFragmentTransactionAnimationSet.Horizontal;
        }
        fragmentTransaction.setCustomAnimations(seslFragmentTransactionAnimationSet.getEnter(), seslFragmentTransactionAnimationSet.getExit(), seslFragmentTransactionAnimationSet.getPopEnter(), seslFragmentTransactionAnimationSet.getPopExit());
        return fragmentTransaction;
    }
}
