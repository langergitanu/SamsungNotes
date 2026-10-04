package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSslCertificateCompressionConfig implements Iterable<AlgorithmConfig> {
    private final List<AlgorithmConfig> pairList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class AlgorithmConfig {
        private final OpenSslCertificateCompressionAlgorithm algorithm;
        private final AlgorithmMode mode;

        public OpenSslCertificateCompressionAlgorithm algorithm() {
            return this.algorithm;
        }

        public AlgorithmMode mode() {
            return this.mode;
        }

        private AlgorithmConfig(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm, AlgorithmMode algorithmMode) {
            this.algorithm = (OpenSslCertificateCompressionAlgorithm) ObjectUtil.checkNotNull(openSslCertificateCompressionAlgorithm, "algorithm");
            this.mode = (AlgorithmMode) ObjectUtil.checkNotNull(algorithmMode, "mode");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AlgorithmMode {
        Compress,
        Decompress,
        Both
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final List<AlgorithmConfig> algorithmList;

        public Builder addAlgorithm(OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm, AlgorithmMode algorithmMode) {
            this.algorithmList.add(new AlgorithmConfig(openSslCertificateCompressionAlgorithm, algorithmMode));
            return this;
        }

        public OpenSslCertificateCompressionConfig build() {
            return new OpenSslCertificateCompressionConfig((AlgorithmConfig[]) this.algorithmList.toArray(new AlgorithmConfig[0]));
        }

        private Builder() {
            this.algorithmList = new ArrayList();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // java.lang.Iterable
    public Iterator<AlgorithmConfig> iterator() {
        return this.pairList.iterator();
    }

    private OpenSslCertificateCompressionConfig(AlgorithmConfig... algorithmConfigArr) {
        this.pairList = Collections.unmodifiableList(Arrays.asList(algorithmConfigArr));
    }
}
