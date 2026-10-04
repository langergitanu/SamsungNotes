package io.netty.channel;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class WriteBufferWaterMark {
    public static final WriteBufferWaterMark DEFAULT = new WriteBufferWaterMark(32768, 65536, false);
    private static final int DEFAULT_HIGH_WATER_MARK = 65536;
    private static final int DEFAULT_LOW_WATER_MARK = 32768;
    private final int high;
    private final int low;

    public WriteBufferWaterMark(int i, int i2) {
        this(i, i2, true);
    }

    public int high() {
        return this.high;
    }

    public int low() {
        return this.low;
    }

    public String toString() {
        StringBuilder sbM1627q = AbstractC2322a.m1627q(55, "WriteBufferWaterMark(low: ");
        sbM1627q.append(this.low);
        sbM1627q.append(", high: ");
        return AbstractC2821a.m2223n(sbM1627q, ")", this.high);
    }

    public WriteBufferWaterMark(int i, int i2, boolean z) {
        if (z) {
            ObjectUtil.checkPositiveOrZero(i, ShareApi.HQVGA_240_SIZE_IMAGE);
            if (i2 < i) {
                throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "write buffer's high water mark cannot be less than  low water mark (", "): "));
            }
        }
        this.low = i;
        this.high = i2;
    }
}
