package androidx.appcompat.oneui.common.internal.util;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\u0004\u001a\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0002H\u0007\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u000f"}, m13886d2 = {"isLayoutRtl", "", "Landroid/view/View;", "(Landroid/view/View;)Z", "getFloat", "id", "", "out", "Landroid/util/TypedValue;", "", "default", "getResourceEntryName", "", "isAtBottom", "isAtTop", "appcompat_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ViewHelperKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean getFloat(@NotNull View view, @DimenRes int i, @NotNull TypedValue out) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        view.getResources().getValue(i, out, true);
        return out.type == 4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public static final String getResourceEntryName(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Resources resources = view.getResources();
        if (resources != null) {
            return resources.getResourceEntryName(view.getId());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isAtBottom(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return !view.canScrollVertically(1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isAtTop(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return !view.canScrollVertically(-1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isLayoutRtl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getLayoutDirection() == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float getFloat(@NotNull View view, @DimenRes int i, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        TypedValue typedValue = new TypedValue();
        view.getResources().getValue(i, typedValue, true);
        return typedValue.type == 4 ? typedValue.getFloat() : f;
    }
}
