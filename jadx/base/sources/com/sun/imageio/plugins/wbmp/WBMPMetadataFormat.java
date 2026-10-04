package com.sun.imageio.plugins.wbmp;

import com.google.common.net.HttpHeaders;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormat;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPMetadataFormat extends IIOMetadataFormatImpl {
    private static IIOMetadataFormat instance;

    private WBMPMetadataFormat() {
        super("javax_imageio_wbmp_1.0", 2);
        addElement("ImageDescriptor", "javax_imageio_wbmp_1.0", 0);
        addAttribute("ImageDescriptor", "WBMPType", 2, true, "0");
        addAttribute("ImageDescriptor", HttpHeaders.WIDTH, 2, true, null, "0", "65535", true, true);
        addAttribute("ImageDescriptor", "Height", 2, true, null, "1", "65535", true, true);
    }

    public static synchronized IIOMetadataFormat getInstance() {
        try {
            if (instance == null) {
                instance = new WBMPMetadataFormat();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl, org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public boolean canNodeAppear(String str, ImageTypeSpecifier imageTypeSpecifier) {
        return true;
    }
}
