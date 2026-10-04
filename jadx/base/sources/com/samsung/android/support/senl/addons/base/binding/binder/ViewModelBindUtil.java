package com.samsung.android.support.senl.addons.base.binding.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/ViewModelBindUtil;", "", "<init>", "()V", "inflate", "Lcom/samsung/android/support/senl/addons/base/binding/binder/BinderBuilder;", "inflater", "Landroid/view/LayoutInflater;", "layoutId", "", "container", "Landroid/view/ViewGroup;", "attachToContainer", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewModelBindUtil {

    @NotNull
    public static final ViewModelBindUtil INSTANCE = new ViewModelBindUtil();

    private ViewModelBindUtil() {
    }

    @NotNull
    public final BinderBuilder inflate(@NotNull LayoutInflater inflater, int layoutId, @Nullable ViewGroup container, boolean attachToContainer) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(layoutId, container, attachToContainer);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        BindingParser bindingParser = BindingParser.INSTANCE;
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        List<IViewBind> binding = bindingParser.parseBinding(context, layoutId);
        BinderBuilder binderBuilder = new BinderBuilder(viewInflate);
        binderBuilder.addBindings(binding);
        return binderBuilder;
    }
}
