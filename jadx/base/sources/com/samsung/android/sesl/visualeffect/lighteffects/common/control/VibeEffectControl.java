package com.samsung.android.sesl.visualeffect.lighteffects.common.control;

import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect;
import com.samsung.android.sesl.visualeffect.utils.WeakViewArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(24)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl;", "", "views", "Lcom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList;", "getViews", "()Lcom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList;", "vibeRenderEffect", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "Lkotlin/collections/ArrayList;", "getVibeRenderEffect", "()Ljava/util/ArrayList;", "add", "", "view", "Landroid/view/View;", "remove", "start", "stop", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface VibeEffectControl {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVibeEffectControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VibeEffectControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,34:1\n1863#2,2:35\n1863#2,2:37\n*S KotlinDebug\n*F\n+ 1 VibeEffectControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl$DefaultImpls\n*L\n20#1:35,2\n27#1:37,2\n*E\n"})
    public static final class DefaultImpls {
        public static void add(@NotNull VibeEffectControl vibeEffectControl, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            vibeEffectControl.getViews().add(view);
            Iterator<T> it = vibeEffectControl.getVibeRenderEffect().iterator();
            while (it.hasNext()) {
                ((VibeRenderEffect) it.next()).add(view);
            }
        }

        public static void remove(@NotNull VibeEffectControl vibeEffectControl, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            vibeEffectControl.getViews().remove(view);
            Iterator<T> it = vibeEffectControl.getVibeRenderEffect().iterator();
            while (it.hasNext()) {
                ((VibeRenderEffect) it.next()).remove(view);
            }
        }
    }

    void add(@NotNull View view);

    @NotNull
    ArrayList<VibeRenderEffect> getVibeRenderEffect();

    @NotNull
    WeakViewArrayList getViews();

    void remove(@NotNull View view);

    void start();

    void stop();
}
