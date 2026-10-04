package com.google.android.material.appbar.model;

import android.content.Context;
import com.google.android.material.appbar.model.view.AppBarView;
import com.google.android.material.appbar.model.view.ViewPagerAppBarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000fB3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00030\t¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/google/android/material/appbar/model/ViewPagerAppBarModel;", "T", "Lcom/google/android/material/appbar/model/view/ViewPagerAppBarView;", "Lcom/google/android/material/appbar/model/AppBarModel;", "kclazz", "Lkotlin/reflect/KClass;", "context", "Landroid/content/Context;", "appBarModels", "", "Lcom/google/android/material/appbar/model/view/AppBarView;", "(Lkotlin/reflect/KClass;Landroid/content/Context;Ljava/util/List;)V", "init", "moduleView", "(Lcom/google/android/material/appbar/model/view/ViewPagerAppBarView;)Lcom/google/android/material/appbar/model/view/ViewPagerAppBarView;", "Builder", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class ViewPagerAppBarModel<T extends ViewPagerAppBarView> extends AppBarModel<T> {

    @NotNull
    private final List<AppBarModel<? extends AppBarView>> appBarModels;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ#\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\n\"\n\b\u0001\u0010\r\u0018\u0001*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0082\bJ\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/google/android/material/appbar/model/ViewPagerAppBarModel$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appBarModels", "", "Lcom/google/android/material/appbar/model/AppBarModel;", "Lcom/google/android/material/appbar/model/view/AppBarView;", "build", "Lcom/google/android/material/appbar/model/ViewPagerAppBarModel;", "Lcom/google/android/material/appbar/model/view/ViewPagerAppBarView;", "create", "T", "setModels", "models", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nViewPagerAppBarModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewPagerAppBarModel.kt\ncom/google/android/material/appbar/model/ViewPagerAppBarModel$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,53:1\n50#1:55\n1#2:54\n*S KotlinDebug\n*F\n+ 1 ViewPagerAppBarModel.kt\ncom/google/android/material/appbar/model/ViewPagerAppBarModel$Builder\n*L\n45#1:55\n*E\n"})
    public static final class Builder {

        @NotNull
        private List<? extends AppBarModel<AppBarView>> appBarModels;

        @NotNull
        private final Context context;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.appBarModels = CollectionsKt.emptyList();
        }

        private final /* synthetic */ <T extends ViewPagerAppBarView> ViewPagerAppBarModel<T> create(Context context) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return new ViewPagerAppBarModel<>(Reflection.getOrCreateKotlinClass(ViewPagerAppBarView.class), context, this.appBarModels);
        }

        @NotNull
        public final ViewPagerAppBarModel<ViewPagerAppBarView> build() {
            return new ViewPagerAppBarModel<>(Reflection.getOrCreateKotlinClass(ViewPagerAppBarView.class), this.context, this.appBarModels);
        }

        @NotNull
        public final Builder setModels(@NotNull List<AppBarModel<AppBarView>> models) {
            Intrinsics.checkNotNullParameter(models, "models");
            this.appBarModels = models;
            return this;
        }
    }

    public /* synthetic */ ViewPagerAppBarModel(KClass kClass, Context context, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, context, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @Override // com.google.android.material.appbar.model.AppBarModel
    @NotNull
    public T init(@NotNull T moduleView) {
        Intrinsics.checkNotNullParameter(moduleView, "moduleView");
        return moduleView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ViewPagerAppBarModel(@NotNull KClass<T> kclazz, @NotNull Context context, @NotNull List<? extends AppBarModel<? extends AppBarView>> appBarModels) {
        super(kclazz, context);
        Intrinsics.checkNotNullParameter(kclazz, "kclazz");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appBarModels, "appBarModels");
        this.appBarModels = appBarModels;
    }
}
