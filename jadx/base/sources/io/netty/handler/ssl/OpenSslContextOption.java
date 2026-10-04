package io.netty.handler.ssl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslContextOption<T> extends SslContextOption<T> {
    public static final OpenSslContextOption<Boolean> USE_TASKS = new OpenSslContextOption<>("USE_TASKS");
    public static final OpenSslContextOption<Boolean> TLS_FALSE_START = new OpenSslContextOption<>("TLS_FALSE_START");
    public static final OpenSslContextOption<OpenSslPrivateKeyMethod> PRIVATE_KEY_METHOD = new OpenSslContextOption<>("PRIVATE_KEY_METHOD");
    public static final OpenSslContextOption<OpenSslAsyncPrivateKeyMethod> ASYNC_PRIVATE_KEY_METHOD = new OpenSslContextOption<>("ASYNC_PRIVATE_KEY_METHOD");
    public static final OpenSslContextOption<OpenSslCertificateCompressionConfig> CERTIFICATE_COMPRESSION_ALGORITHMS = new OpenSslContextOption<>("CERTIFICATE_COMPRESSION_ALGORITHMS");
    public static final OpenSslContextOption<Integer> MAX_CERTIFICATE_LIST_BYTES = new OpenSslContextOption<>("MAX_CERTIFICATE_LIST_BYTES");

    private OpenSslContextOption(String str) {
        super(str);
    }
}
