package com.sun.imageio.plugins.jpeg;

import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGStreamMetadataFormat extends JPEGMetadataFormat {
    private static JPEGStreamMetadataFormat theInstance;

    private JPEGStreamMetadataFormat() {
        super(JPEG.nativeStreamMetadataFormatName, 4);
        addStreamElements(getRootName());
    }

    public static synchronized IIOMetadataFormat getInstance() {
        try {
            if (theInstance == null) {
                theInstance = new JPEGStreamMetadataFormat();
            }
        } catch (Throwable th) {
            throw th;
        }
        return theInstance;
    }

    @Override // com.sun.imageio.plugins.jpeg.JPEGMetadataFormat, org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl, org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public /* bridge */ /* synthetic */ boolean canNodeAppear(String str, ImageTypeSpecifier imageTypeSpecifier) {
        return super.canNodeAppear(str, imageTypeSpecifier);
    }
}
