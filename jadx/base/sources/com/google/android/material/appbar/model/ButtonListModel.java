package com.google.android.material.appbar.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/google/android/material/appbar/model/ButtonListModel;", "", "buttonStyle", "Lcom/google/android/material/appbar/model/ButtonStyle;", "buttonModels", "", "Lcom/google/android/material/appbar/model/ButtonModel;", "(Lcom/google/android/material/appbar/model/ButtonStyle;Ljava/util/List;)V", "getButtonModels", "()Ljava/util/List;", "getButtonStyle", "()Lcom/google/android/material/appbar/model/ButtonStyle;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ButtonListModel {

    @NotNull
    private final List<ButtonModel> buttonModels;

    @NotNull
    private final ButtonStyle buttonStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public ButtonListModel(@NotNull ButtonStyle buttonStyle, @NotNull List<? extends ButtonModel> buttonModels) {
        Intrinsics.checkNotNullParameter(buttonStyle, "buttonStyle");
        Intrinsics.checkNotNullParameter(buttonModels, "buttonModels");
        this.buttonStyle = buttonStyle;
        this.buttonModels = buttonModels;
    }

    @NotNull
    public final List<ButtonModel> getButtonModels() {
        return this.buttonModels;
    }

    @NotNull
    public final ButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }
}
