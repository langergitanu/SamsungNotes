package io.netty.buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SizeClassesMetric {
    int normalizeSize(int i);

    long pageIdx2size(int i);

    long pageIdx2sizeCompute(int i);

    int pages2pageIdx(int i);

    int pages2pageIdxFloor(int i);

    int size2SizeIdx(int i);

    int sizeIdx2size(int i);

    int sizeIdx2sizeCompute(int i);
}
