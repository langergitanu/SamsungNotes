package io.netty.util.internal.shaded.org.jctools.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface PortableJvmInfo {
    public static final int CACHE_LINE_SIZE = Integer.getInteger("jctools.cacheLineSize", 64).intValue();
    public static final int CPUs;
    public static final int RECOMENDED_OFFER_BATCH;
    public static final int RECOMENDED_POLL_BATCH;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPUs = iAvailableProcessors;
        RECOMENDED_OFFER_BATCH = iAvailableProcessors * 4;
        RECOMENDED_POLL_BATCH = iAvailableProcessors * 4;
    }
}
