package org.brotli.dec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class HuffmanTreeGroup {
    private int alphabetSize;
    int[] codes;
    int[] trees;

    public static void decode(HuffmanTreeGroup huffmanTreeGroup, BitReader bitReader) {
        int length = huffmanTreeGroup.trees.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            huffmanTreeGroup.trees[i2] = i;
            Decode.readHuffmanCode(huffmanTreeGroup.alphabetSize, huffmanTreeGroup.codes, i, bitReader);
            i += 1080;
        }
    }

    public static void init(HuffmanTreeGroup huffmanTreeGroup, int i, int i2) {
        huffmanTreeGroup.alphabetSize = i;
        huffmanTreeGroup.codes = new int[i2 * 1080];
        huffmanTreeGroup.trees = new int[i2];
    }
}
