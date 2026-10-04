package com.google.android.material.appbar.model;

import android.content.Context;
import android.view.View;
import com.google.android.material.appbar.model.view.AppBarView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000eB\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/google/android/material/appbar/model/AppBarModel;", "T", "Lcom/google/android/material/appbar/model/view/AppBarView;", "", "kclazz", "Lkotlin/reflect/KClass;", "context", "Landroid/content/Context;", "(Lkotlin/reflect/KClass;Landroid/content/Context;)V", "create", "()Lcom/google/android/material/appbar/model/view/AppBarView;", "init", "moduleView", "(Lcom/google/android/material/appbar/model/view/AppBarView;)Lcom/google/android/material/appbar/model/view/AppBarView;", "OnClickListener", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class AppBarModel<T extends AppBarView> {

    @NotNull
    private final Context context;

    @NotNull
    private final KClass<T> kclazz;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m13886d2 = {"Lcom/google/android/material/appbar/model/AppBarModel$OnClickListener;", "", "onClick", "", "view", "Landroid/view/View;", "module", "Lcom/google/android/material/appbar/model/AppBarModel;", "Lcom/google/android/material/appbar/model/view/AppBarView;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface OnClickListener {
        void onClick(@NotNull View view, @NotNull AppBarModel<? extends AppBarView> module);
    }

    public AppBarModel(@NotNull KClass<T> kclazz, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(kclazz, "kclazz");
        Intrinsics.checkNotNullParameter(context, "context");
        this.kclazz = kclazz;
        this.context = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public T create() {
        return (T) init((AppBarView) ((KFunction) CollectionsKt.first(this.kclazz.getConstructors())).call(this.context, null));
    }

    @NotNull
    public T init(@NotNull T moduleView) {
        Intrinsics.checkNotNullParameter(moduleView, "moduleView");
        return moduleView;
    }
}
