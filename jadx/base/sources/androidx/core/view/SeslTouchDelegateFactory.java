package androidx.core.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.view.SeslTouchTargetDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslTouchDelegateFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Strategy {
        SeslTouchTargetDelegate.ExtraInsets getExtraInsets(Rect rect, Rect rect2, Rect rect3);
    }

    private static List<View> getChildren(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SeslTouchTargetDelegate.ExtraInsets lambda$make$0(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
        return SeslTouchTargetDelegate.ExtraInsets.m1781of(rect3.left - rect2.right, rect3.top - rect.top, Math.max(0, rect4.left - rect3.right) / 2, rect.bottom - rect3.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SeslTouchTargetDelegate.ExtraInsets lambda$make$1(Rect rect, Rect rect2, Rect rect3, Rect rect4) {
        return SeslTouchTargetDelegate.ExtraInsets.m1781of(rect3.left - rect.left, rect3.top - rect2.bottom, rect.right - rect3.right, Math.max(0, rect4.top - rect3.bottom) / 2);
    }

    @Nullable
    public static SeslTouchTargetDelegate.Builder make(@NonNull LinearLayout linearLayout) {
        return make(linearLayout, getChildren(linearLayout));
    }

    @Nullable
    public static SeslTouchTargetDelegate.Builder make(@NonNull LinearLayout linearLayout, @NonNull List<View> list) {
        Strategy strategy;
        if (list.size() == 0) {
            return null;
        }
        int height = linearLayout.getHeight();
        int width = linearLayout.getWidth();
        int i = 0;
        final Rect rect = new Rect(0, 0, width, height);
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(SeslTouchTargetDelegate.calculateViewBounds(linearLayout, it.next()));
        }
        if (linearLayout.getOrientation() == 0) {
            final int i2 = 0;
            strategy = new Strategy() { // from class: androidx.core.view.h
                @Override // androidx.core.view.SeslTouchDelegateFactory.Strategy
                public final SeslTouchTargetDelegate.ExtraInsets getExtraInsets(Rect rect2, Rect rect3, Rect rect4) {
                    switch (i2) {
                        case 0:
                            return SeslTouchDelegateFactory.lambda$make$0(rect, rect2, rect3, rect4);
                        default:
                            return SeslTouchDelegateFactory.lambda$make$1(rect, rect2, rect3, rect4);
                    }
                }
            };
        } else {
            final int i4 = 1;
            strategy = new Strategy() { // from class: androidx.core.view.h
                @Override // androidx.core.view.SeslTouchDelegateFactory.Strategy
                public final SeslTouchTargetDelegate.ExtraInsets getExtraInsets(Rect rect2, Rect rect3, Rect rect4) {
                    switch (i4) {
                        case 0:
                            return SeslTouchDelegateFactory.lambda$make$0(rect, rect2, rect3, rect4);
                        default:
                            return SeslTouchDelegateFactory.lambda$make$1(rect, rect2, rect3, rect4);
                    }
                }
            };
        }
        Rect rect2 = (Rect) AbstractC1974b.m1313f(1, arrayList);
        arrayList.add(new Rect(Math.max(0, width - rect2.right) + width, Math.max(0, height - rect2.bottom) + height, width, height));
        Rect rect3 = new Rect(0, 0, 0, 0);
        SeslTouchTargetDelegate.Builder builder = new SeslTouchTargetDelegate.Builder(linearLayout);
        while (i < list.size()) {
            Rect rect4 = (Rect) arrayList.get(i);
            int i5 = i + 1;
            builder.addDelegateView(list.get(i), strategy.getExtraInsets(rect3, rect4, (Rect) arrayList.get(i5)));
            rect3 = rect4;
            i = i5;
        }
        return builder;
    }
}
