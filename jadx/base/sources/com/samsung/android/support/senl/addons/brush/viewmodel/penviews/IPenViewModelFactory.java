package com.samsung.android.support.senl.addons.brush.viewmodel.penviews;

import com.samsung.android.support.senl.addons.brush.model.pen.IPenModelList;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModelList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \t*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003:\u0001\tJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelFactory;", "T", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "", "createViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModel;", "name", "", "createEraserViewModel", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPenViewModelFactory<T extends PenModelList> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final String[] NAME = IPenModelList.INSTANCE.getPEN_NAMES();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0001¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModelFactory$Companion;", "", "<init>", "()V", "NAME", "", "", "[Ljava/lang/String;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Nullable
    PenViewModel createEraserViewModel();

    @Nullable
    PenViewModel createViewModel(@Nullable String name);
}
