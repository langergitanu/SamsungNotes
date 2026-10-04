package androidx.compose.p109ui.focus;

import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.p109ui.focus.FocusDirection;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.platform.AndroidComposeView;
import androidx.compose.p109ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a%\u0010\n\u001a\u00020\u000b*\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFocusInteropUtils.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FocusInteropUtils.android.kt\nandroidx/compose/ui/focus/FocusInteropUtils_androidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
public final class FocusInteropUtils_androidKt {
    @NotNull
    public static final Rect calculateBoundingRect(@NotNull View view) {
        int[] tempCoordinates = FocusInteropUtils.INSTANCE.getTempCoordinates();
        view.getLocationInWindow(tempCoordinates);
        int i = tempCoordinates[0];
        return new Rect(i, tempCoordinates[1], i + view.getWidth(), tempCoordinates[1] + view.getHeight());
    }

    public static final boolean requestInteropFocus(@NotNull View view, @Nullable Integer num, @Nullable android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !view.hasFocus()) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    @Nullable
    /* JADX INFO: renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m18210toAndroidFocusDirection3ESFkO8(int i) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m18196equalsimpl0(i, companion.m18209getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18202getDowndhqQ8s())) {
            return 130;
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18205getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18208getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m18196equalsimpl0(i, companion.m18206getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m18196equalsimpl0(i, companion.m18207getPreviousdhqQ8s()) ? 1 : null;
    }

    @Nullable
    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18207getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18206getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18205getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18209getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18208getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m18193boximpl(FocusDirection.INSTANCE.m18202getDowndhqQ8s());
    }

    @Nullable
    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }
}
