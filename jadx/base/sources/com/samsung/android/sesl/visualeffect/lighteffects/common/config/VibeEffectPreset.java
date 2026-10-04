package com.samsung.android.sesl.visualeffect.lighteffects.common.config;

import android.content.Context;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/VibeEffectPreset;", "T", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl;", "", "<init>", "()V", "build", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class VibeEffectPreset<T extends VibeEffectControl> {
    @NotNull
    public abstract T build(@NotNull Context appContext);
}
