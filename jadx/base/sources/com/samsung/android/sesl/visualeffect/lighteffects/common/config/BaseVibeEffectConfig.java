package com.samsung.android.sesl.visualeffect.lighteffects.common.config;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R2\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/BaseVibeEffectConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/VibeEffectConfig;", "<init>", "()V", "animatableAttribute", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/AnimatableAttribute;", "Lkotlin/collections/ArrayList;", "getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release", "()Ljava/util/ArrayList;", "setAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release", "(Ljava/util/ArrayList;)V", "add", "", "attr", "destroy", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class BaseVibeEffectConfig implements VibeEffectConfig {

    @NotNull
    private ArrayList<AnimatableAttribute<?>> animatableAttribute = new ArrayList<>();

    public final boolean add(@NotNull AnimatableAttribute<?> attr) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        return this.animatableAttribute.add(attr);
    }

    public final void destroy() {
        this.animatableAttribute.clear();
    }

    @NotNull
    public final ArrayList<AnimatableAttribute<?>> getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release() {
        return this.animatableAttribute;
    }

    public final void setAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release(@NotNull ArrayList<AnimatableAttribute<?>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.animatableAttribute = arrayList;
    }
}
