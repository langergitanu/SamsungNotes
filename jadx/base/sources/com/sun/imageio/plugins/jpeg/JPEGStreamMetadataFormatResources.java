package com.sun.imageio.plugins.jpeg;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGStreamMetadataFormatResources extends JPEGMetadataFormatResources {
    @Override // java.util.ListResourceBundle
    public Object[][] getContents() {
        Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, JPEGMetadataFormatResources.commonContents.length, 2);
        int i = 0;
        while (true) {
            Object[][] objArr2 = JPEGMetadataFormatResources.commonContents;
            if (i >= objArr2.length) {
                return objArr;
            }
            objArr[i][0] = objArr2[i][0];
            objArr[i][1] = objArr2[i][1];
            i++;
        }
    }
}
