package com.samsung.android.support.senl.p148nt.base.winset.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/util/AnchorViewUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getAnchorView", "Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "anchorRoot", "x", "", "y", "createAnchorView", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AnchorViewUtils {

    @NotNull
    public static final AnchorViewUtils INSTANCE = new AnchorViewUtils();

    @NotNull
    private static final String TAG = "AnchorViewUtils";

    private AnchorViewUtils() {
    }

    private final View createAnchorView(Context context) {
        View view = new View(context);
        view.setId(C8875R.id.anchor_view);
        view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        view.setBackgroundColor(0);
        return view;
    }

    @JvmStatic
    @NotNull
    public static final View getAnchorView(@NotNull ViewGroup root, @NotNull ViewGroup anchorRoot, float x, float y2) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(anchorRoot, "anchorRoot");
        View anchorView = getAnchorView(root);
        if (anchorView == null) {
            AnchorViewUtils anchorViewUtils = INSTANCE;
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            anchorView = anchorViewUtils.createAnchorView(context);
        }
        try {
            try {
                if (anchorView.getParent() != null) {
                    ViewParent parent = anchorView.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (Intrinsics.areEqual(anchorRoot, viewGroup)) {
                        int layoutDirection = anchorRoot.getLayoutDirection();
                        int layoutDirection2 = anchorView.getLayoutDirection();
                        if (layoutDirection != 1 || layoutDirection == layoutDirection2) {
                            anchorView.setX(x);
                        } else {
                            anchorView.setX(x - anchorRoot.getWidth());
                        }
                        anchorView.setY(y2);
                        return anchorView;
                    }
                    viewGroup.removeView(anchorView);
                } else {
                    AnchorViewUtils anchorViewUtils2 = INSTANCE;
                    Context context2 = anchorRoot.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    anchorView = anchorViewUtils2.createAnchorView(context2);
                }
                anchorRoot.addView(anchorView);
                int layoutDirection3 = anchorRoot.getLayoutDirection();
                int layoutDirection4 = anchorView.getLayoutDirection();
                if (layoutDirection3 != 1 || layoutDirection3 == layoutDirection4) {
                    anchorView.setX(x);
                } else {
                    anchorView.setX(x - anchorRoot.getWidth());
                }
                anchorView.setY(y2);
                return anchorView;
            } catch (IllegalStateException e) {
                Logger.m8698e(TAG, "getAnchorView# IllegalStateException: " + e.getMessage());
                int layoutDirection5 = anchorRoot.getLayoutDirection();
                int layoutDirection6 = anchorView.getLayoutDirection();
                if (layoutDirection5 != 1 || layoutDirection5 == layoutDirection6) {
                    anchorView.setX(x);
                } else {
                    anchorView.setX(x - anchorRoot.getWidth());
                }
                anchorView.setY(y2);
                return anchorView;
            }
        } catch (Throwable th) {
            int layoutDirection7 = anchorRoot.getLayoutDirection();
            int layoutDirection8 = anchorView.getLayoutDirection();
            if (layoutDirection7 != 1 || layoutDirection7 == layoutDirection8) {
                anchorView.setX(x);
            } else {
                anchorView.setX(x - anchorRoot.getWidth());
            }
            anchorView.setY(y2);
            throw th;
        }
    }

    @JvmStatic
    @Nullable
    public static final View getAnchorView(@Nullable ViewGroup root) {
        if (root == null) {
            return null;
        }
        return root.findViewById(C8875R.id.anchor_view);
    }
}
