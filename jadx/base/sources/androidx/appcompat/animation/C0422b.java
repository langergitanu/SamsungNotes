package androidx.appcompat.animation;

import android.view.View;
import androidx.appcompat.animation.SeslRecoilAnimator;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilAnimator;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: androidx.appcompat.animation.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0422b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f929a;

    public /* synthetic */ C0422b(int i) {
        this.f929a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f929a) {
            case 0:
                SeslRecoilAnimator.Holder.lambda$setRelease$0((SeslRecoilAnimator) obj);
                break;
            case 1:
                VibeRenderEffectBase.stop$lambda$5((View) obj);
                break;
            case 2:
                VibeRenderEffectBase.start$lambda$4((View) obj);
                break;
            case 3:
                CustomRecoilAnimator.Holder.setRelease$lambda$0((CustomRecoilAnimator) obj);
                break;
            case 4:
                Objects.requireNonNull((FailableRunnable) obj, "runnable");
                break;
            case 5:
                ((ConcurrentMap) obj).clear();
                break;
            default:
                ((LogFactory) obj).release();
                break;
        }
    }
}
