package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class NettyRuntime {
    private static final AvailableProcessorsHolder holder = new AvailableProcessorsHolder();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AvailableProcessorsHolder {
        private int availableProcessors;

        @SuppressForbidden(reason = "to obtain default number of available processors")
        public synchronized int availableProcessors() {
            try {
                if (this.availableProcessors == 0) {
                    setAvailableProcessors(SystemPropertyUtil.getInt("io.netty.availableProcessors", Runtime.getRuntime().availableProcessors()));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.availableProcessors;
        }

        public synchronized void setAvailableProcessors(int i) {
            ObjectUtil.checkPositive(i, "availableProcessors");
            int i2 = this.availableProcessors;
            if (i2 != 0) {
                Locale locale = Locale.ROOT;
                throw new IllegalStateException("availableProcessors is already set to [" + i2 + "], rejecting [" + i + "]");
            }
            this.availableProcessors = i;
        }
    }

    private NettyRuntime() {
    }

    public static int availableProcessors() {
        return holder.availableProcessors();
    }

    public static void setAvailableProcessors(int i) {
        holder.setAvailableProcessors(i);
    }
}
