package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.os.SystemClock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IProgressive;", "", "startProgress", "", "getStartProgress", "()J", "setStartProgress", "(J)V", "setProgress", "", "progress", "", "initProgressByTime", "updateProgressByTime", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface IProgressive {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void initProgressByTime(@NotNull IProgressive iProgressive) {
            iProgressive.setStartProgress(SystemClock.elapsedRealtime());
        }

        public static void updateProgressByTime(@NotNull IProgressive iProgressive) {
            iProgressive.setProgress((SystemClock.elapsedRealtime() - iProgressive.getStartProgress()) * 0.001f);
        }
    }

    long getStartProgress();

    void initProgressByTime();

    void setProgress(float progress);

    void setStartProgress(long j);

    void updateProgressByTime();
}
