package com.sun.imageio.plugins.bmp;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPCompressionTypes {
    private static final String[] compressionTypeNames = {"BI_RGB", "BI_RLE8", "BI_RLE4", "BI_BITFIELDS", "BI_JPEG", "BI_PNG"};

    public static String[] getCompressionTypes() {
        return (String[]) compressionTypeNames.clone();
    }

    public static String getName(int i) {
        return compressionTypeNames[i];
    }

    public static int getType(String str) {
        int i = 0;
        while (true) {
            String[] strArr = compressionTypeNames;
            if (i >= strArr.length) {
                return 0;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }
}
