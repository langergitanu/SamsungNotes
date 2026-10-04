package androidx.fragment.app;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.fragment.C2751R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB/\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, m13886d2 = {"Landroidx/fragment/app/SeslFragmentTransactionAnimationSet;", "", "enter", "", "exit", "popEnter", "popExit", "(Ljava/lang/String;IIIII)V", "getEnter$fragment_release", "()I", "getExit$fragment_release", "getPopEnter$fragment_release", "getPopExit$fragment_release", "Horizontal", "HorizontalForRTL", "Companion", "fragment_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public enum SeslFragmentTransactionAnimationSet {
    Horizontal(C2751R.animator.sesl_fragment_open_enter, C2751R.animator.sesl_fragment_open_exit, C2751R.animator.sesl_fragment_close_enter, C2751R.animator.sesl_fragment_close_exit),
    HorizontalForRTL(C2751R.animator.sesl_fragment_open_enter, C2751R.animator.sesl_fragment_open_exit, C2751R.animator.sesl_fragment_close_enter, C2751R.animator.sesl_fragment_close_exit);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int enter;
    private final int exit;
    private final int popEnter;
    private final int popExit;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, m13886d2 = {"Landroidx/fragment/app/SeslFragmentTransactionAnimationSet$Companion;", "", "()V", "isFragmentAnimationRes", "", "resId", "", "isOpenEnter", "isOpenExit", "isPopEnter", "isPopExit", "fragment_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSeslFragmentTransaction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeslFragmentTransaction.kt\nandroidx/fragment/app/SeslFragmentTransactionAnimationSet$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,99:1\n12744#2,2:100\n12744#2,2:102\n12744#2,2:104\n12744#2,2:106\n12744#2,2:108\n*S KotlinDebug\n*F\n+ 1 SeslFragmentTransaction.kt\nandroidx/fragment/app/SeslFragmentTransactionAnimationSet$Companion\n*L\n35#1:100,2\n41#1:102,2\n44#1:104,2\n47#1:106,2\n50#1:108,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isFragmentAnimationRes(@AnimRes @AnimatorRes int resId) {
            for (SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet : SeslFragmentTransactionAnimationSet.values()) {
                if (seslFragmentTransactionAnimationSet.getEnter() == resId || seslFragmentTransactionAnimationSet.getExit() == resId || seslFragmentTransactionAnimationSet.getPopEnter() == resId || seslFragmentTransactionAnimationSet.getPopExit() == resId) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isOpenEnter(@AnimRes @AnimatorRes int resId) {
            for (SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet : SeslFragmentTransactionAnimationSet.values()) {
                if (seslFragmentTransactionAnimationSet.getEnter() == resId) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isOpenExit(@AnimRes @AnimatorRes int resId) {
            for (SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet : SeslFragmentTransactionAnimationSet.values()) {
                if (seslFragmentTransactionAnimationSet.getExit() == resId) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isPopEnter(@AnimRes @AnimatorRes int resId) {
            for (SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet : SeslFragmentTransactionAnimationSet.values()) {
                if (seslFragmentTransactionAnimationSet.getPopEnter() == resId) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isPopExit(@AnimRes @AnimatorRes int resId) {
            for (SeslFragmentTransactionAnimationSet seslFragmentTransactionAnimationSet : SeslFragmentTransactionAnimationSet.values()) {
                if (seslFragmentTransactionAnimationSet.getPopExit() == resId) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    SeslFragmentTransactionAnimationSet(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        this.enter = i;
        this.exit = i2;
        this.popEnter = i4;
        this.popExit = i5;
    }

    /* JADX INFO: renamed from: getEnter$fragment_release, reason: from getter */
    public final int getEnter() {
        return this.enter;
    }

    /* JADX INFO: renamed from: getExit$fragment_release, reason: from getter */
    public final int getExit() {
        return this.exit;
    }

    /* JADX INFO: renamed from: getPopEnter$fragment_release, reason: from getter */
    public final int getPopEnter() {
        return this.popEnter;
    }

    /* JADX INFO: renamed from: getPopExit$fragment_release, reason: from getter */
    public final int getPopExit() {
        return this.popExit;
    }
}
