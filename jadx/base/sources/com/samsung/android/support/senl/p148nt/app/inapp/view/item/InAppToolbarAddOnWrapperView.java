package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarAddOnWrapperView;", "", "context", "Landroid/content/Context;", "child", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "view", "getView", "()Landroid/view/View;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppToolbarAddOnWrapperView {

    @NotNull
    private final View view;

    public InAppToolbarAddOnWrapperView(@Nullable Context context, @Nullable View view) {
        if ((view != null ? view.getParent() : null) != null) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
        View viewInflate = LayoutInflater.from(context).inflate(C8003R.layout.in_app_collaboration_add_on_toolbar_wrapper_container, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.view = viewInflate;
        viewInflate.setId(ViewCompat.generateViewId());
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C8003R.id.toolbar_add_on_item);
        if (frameLayout != null) {
            frameLayout.addView(view);
        }
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
