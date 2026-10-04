package com.sun.imageio.plugins.jpeg;

import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGImageReaderResources extends ListResourceBundle {
    @Override // java.util.ListResourceBundle
    public Object[][] getContents() {
        return new Object[][]{new Object[]{Integer.toString(0), "Truncated File - Missing EOI marker"}, new Object[]{Integer.toString(1), "JFIF markers not allowed in JFIF JPEG thumbnail; ignored"}, new Object[]{Integer.toString(2), "Embedded color profile is invalid; ignored"}};
    }
}
