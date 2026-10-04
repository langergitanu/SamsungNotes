package com.google.android.material.navigation.strategy;

import com.google.android.material.navigation.strategy.ViewTypeStrategy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/StrategyFactory;", "", "()V", "createStrategy", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy;", "type", "", "isFloatingType", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class StrategyFactory {

    @NotNull
    public static final StrategyFactory INSTANCE = new StrategyFactory();

    private StrategyFactory() {
    }

    @NotNull
    public final ViewTypeStrategy createStrategy(int type, boolean isFloatingType) {
        return type != 1 ? type != 2 ? type != 3 ? new ViewTypeStrategy.IconLabelType() : new ViewTypeStrategy.LabelOnlyType() : isFloatingType ? new ViewTypeStrategy.FloatingIconOnlyType() : new ViewTypeStrategy.IconOnlyType() : isFloatingType ? new ViewTypeStrategy.FloatingIconLabelType() : new ViewTypeStrategy.IconLabelType();
    }
}
