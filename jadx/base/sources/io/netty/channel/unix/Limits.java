package io.netty.channel.unix;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Limits {
    public static final int IOV_MAX = LimitsStaticallyReferencedJniMethods.iovMax();
    public static final int UIO_MAX_IOV = LimitsStaticallyReferencedJniMethods.uioMaxIov();
    public static final long SSIZE_MAX = LimitsStaticallyReferencedJniMethods.ssizeMax();
    public static final int SIZEOF_JLONG = LimitsStaticallyReferencedJniMethods.sizeOfjlong();

    private Limits() {
    }
}
