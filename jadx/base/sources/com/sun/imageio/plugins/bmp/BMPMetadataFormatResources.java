package com.sun.imageio.plugins.bmp;

import com.google.common.net.HttpHeaders;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPMetadataFormatResources extends ListResourceBundle {
    @Override // java.util.ListResourceBundle
    public Object[][] getContents() {
        return new Object[][]{new Object[]{"BMPVersion", "BMP version string"}, new Object[]{HttpHeaders.WIDTH, "The width of the image"}, new Object[]{"Height", "The height of the image"}, new Object[]{"BitsPerPixel", ""}, new Object[]{"PixelsPerMeter", "Resolution in pixels per unit distance"}, new Object[]{"X", "Pixels Per Meter along X"}, new Object[]{DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, "Pixels Per Meter along Y"}, new Object[]{"ColorsUsed", "Number of color indexes in the color table actually used"}, new Object[]{"ColorsImportant", "Number of color indexes considered important for display"}, new Object[]{"Mask", "Color masks; present for BI_BITFIELDS compression only"}, new Object[]{"Intent", "Rendering intent"}, new Object[]{"Palette", "The color palette"}, new Object[]{"Red", "Red Mask/Color Palette"}, new Object[]{"Green", "Green Mask/Color Palette/Gamma"}, new Object[]{"Blue", "Blue Mask/Color Palette/Gamma"}, new Object[]{"Alpha", "Alpha Mask/Color Palette/Gamma"}, new Object[]{"ColorSpaceType", "Color Space Type"}, new Object[]{"X", "The X coordinate of a point in XYZ color space"}, new Object[]{DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, "The Y coordinate of a point in XYZ color space"}, new Object[]{"Z", "The Z coordinate of a point in XYZ color space"}};
    }
}
