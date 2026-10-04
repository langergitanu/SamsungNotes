package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.C3604R;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"findViewTreeLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "get", "setViewTreeLifecycleOwner", "", "lifecycleOwner", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "lifecycle-runtime_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @JvmName(name = "get")
    @Nullable
    public static final LifecycleOwner get(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (LifecycleOwner) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(view, new Function1<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final View invoke(@NotNull View currentView) {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, LifecycleOwner>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final LifecycleOwner invoke(@NotNull View viewParent) {
                Intrinsics.checkNotNullParameter(viewParent, "viewParent");
                Object tag = viewParent.getTag(C3604R.id.view_tree_lifecycle_owner);
                if (tag instanceof LifecycleOwner) {
                    return (LifecycleOwner) tag;
                }
                return null;
            }
        }));
    }

    @JvmName(name = FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX)
    public static final void set(@NotNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(C3604R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
