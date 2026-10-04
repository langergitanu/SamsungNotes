package com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor;

import android.content.Context;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerManager;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J$\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/constructor/RecogEngineConstructor;", "", "<init>", "()V", "makeRecognizerManager", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizerManager;", "context", "Landroid/content/Context;", "makeResourceProvider", "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider;", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider$EngineType;", "resourceType", "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider$ResourceType;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecogEngineConstructor {

    @NotNull
    public static final RecogEngineConstructor INSTANCE = new RecogEngineConstructor();

    private RecogEngineConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final SpenRecognizerManager makeRecognizerManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SpenRecognizerManager(context);
    }

    @JvmStatic
    @NotNull
    public static final SpenResourceProvider makeResourceProvider(@NotNull Context context, @Nullable SpenResourceProvider.EngineType engineType, @Nullable SpenResourceProvider.ResourceType resourceType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNull(engineType);
        Intrinsics.checkNotNull(resourceType);
        return new SpenResourceProvider(context, engineType, resourceType);
    }
}
