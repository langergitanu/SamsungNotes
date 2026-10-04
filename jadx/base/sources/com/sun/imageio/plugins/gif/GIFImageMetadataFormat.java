package com.sun.imageio.plugins.gif;

import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import java.util.Arrays;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormat;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageMetadataFormat extends IIOMetadataFormatImpl {
    private static IIOMetadataFormat instance;

    private GIFImageMetadataFormat() {
        super("javax_imageio_gif_image_1.0", 2);
        addElement("ImageDescriptor", "javax_imageio_gif_image_1.0", 0);
        addAttribute("ImageDescriptor", "imageLeftPosition", 2, true, null, "0", "65535", true, true);
        addAttribute("ImageDescriptor", "imageTopPosition", 2, true, null, "0", "65535", true, true);
        addAttribute("ImageDescriptor", ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH, 2, true, null, "1", "65535", true, true);
        addAttribute("ImageDescriptor", ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT, 2, true, null, "1", "65535", true, true);
        addBooleanAttribute("ImageDescriptor", "interlaceFlag", false, false);
        addElement("LocalColorTable", "javax_imageio_gif_image_1.0", 2, 256);
        addAttribute("LocalColorTable", "sizeOfLocalColorTable", 2, true, (String) null, Arrays.asList(GIFStreamMetadata.colorTableSizes));
        addBooleanAttribute("LocalColorTable", "sortFlag", false, false);
        addElement("ColorTableEntry", "LocalColorTable", 0);
        addAttribute("ColorTableEntry", "index", 2, true, null, "0", "255", true, true);
        addAttribute("ColorTableEntry", "red", 2, true, null, "0", "255", true, true);
        addAttribute("ColorTableEntry", "green", 2, true, null, "0", "255", true, true);
        addAttribute("ColorTableEntry", "blue", 2, true, null, "0", "255", true, true);
        addElement("GraphicControlExtension", "javax_imageio_gif_image_1.0", 0);
        addAttribute("GraphicControlExtension", "disposalMethod", 0, true, (String) null, Arrays.asList(GIFImageMetadata.disposalMethodNames));
        addBooleanAttribute("GraphicControlExtension", "userInputFlag", false, false);
        addBooleanAttribute("GraphicControlExtension", "transparentColorFlag", false, false);
        addAttribute("GraphicControlExtension", "delayTime", 2, true, null, "0", "65535", true, true);
        addAttribute("GraphicControlExtension", "transparentColorIndex", 2, true, null, "0", "255", true, true);
        addElement("PlainTextExtension", "javax_imageio_gif_image_1.0", 0);
        addAttribute("PlainTextExtension", "textGridLeft", 2, true, null, "0", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridTop", 2, true, null, "0", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridWidth", 2, true, null, "1", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridHeight", 2, true, null, "1", "65535", true, true);
        addAttribute("PlainTextExtension", "characterCellWidth", 2, true, null, "1", "65535", true, true);
        addAttribute("PlainTextExtension", "characterCellHeight", 2, true, null, "1", "65535", true, true);
        addAttribute("PlainTextExtension", "textForegroundColor", 2, true, null, "0", "255", true, true);
        addAttribute("PlainTextExtension", "textBackgroundColor", 2, true, null, "0", "255", true, true);
        addElement("ApplicationExtensions", "javax_imageio_gif_image_1.0", 1, Integer.MAX_VALUE);
        addElement("ApplicationExtension", "ApplicationExtensions", 0);
        addAttribute("ApplicationExtension", "applicationID", 0, true, null);
        addAttribute("ApplicationExtension", "authenticationCode", 0, true, null);
        addObjectValue("ApplicationExtension", Byte.TYPE, 0, Integer.MAX_VALUE);
        addElement("CommentExtensions", "javax_imageio_gif_image_1.0", 1, Integer.MAX_VALUE);
        addElement("CommentExtension", "CommentExtensions", 0);
        addAttribute("CommentExtension", "value", 0, true, null);
    }

    public static synchronized IIOMetadataFormat getInstance() {
        try {
            if (instance == null) {
                instance = new GIFImageMetadataFormat();
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
