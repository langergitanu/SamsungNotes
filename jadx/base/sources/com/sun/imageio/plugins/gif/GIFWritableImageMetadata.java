package com.sun.imageio.plugins.gif;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GIFWritableImageMetadata extends GIFImageMetadata {
    static final String NATIVE_FORMAT_NAME = "javax_imageio_gif_image_1.0";

    public GIFWritableImageMetadata() {
        super(true, NATIVE_FORMAT_NAME, "com.sun.imageio.plugins.gif.GIFImageMetadataFormat", null, null);
    }

    private byte[] fromISO8859(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return "".getBytes();
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFImageMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return false;
    }

    @Override // com.sun.imageio.plugins.gif.GIFImageMetadata, com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeNativeTree(Node node) throws IIOInvalidTreeException {
        if (!node.getNodeName().equals(NATIVE_FORMAT_NAME)) {
            GIFMetadata.fatal(node, "Root must be javax_imageio_gif_image_1.0");
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            if (nodeName.equals("ImageDescriptor")) {
                this.imageLeftPosition = GIFMetadata.getIntAttribute(firstChild, "imageLeftPosition", -1, true, true, 0, 65535);
                this.imageTopPosition = GIFMetadata.getIntAttribute(firstChild, "imageTopPosition", -1, true, true, 0, 65535);
                this.imageWidth = GIFMetadata.getIntAttribute(firstChild, ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH, -1, true, true, 1, 65535);
                this.imageHeight = GIFMetadata.getIntAttribute(firstChild, ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT, -1, true, true, 1, 65535);
                this.interlaceFlag = GIFMetadata.getBooleanAttribute(firstChild, "interlaceFlag", false, true);
            } else if (nodeName.equals("LocalColorTable")) {
                int intAttribute = GIFMetadata.getIntAttribute(firstChild, "sizeOfLocalColorTable", true, 2, 256);
                if (intAttribute != 2 && intAttribute != 4 && intAttribute != 8 && intAttribute != 16 && intAttribute != 32 && intAttribute != 64 && intAttribute != 128 && intAttribute != 256) {
                    GIFMetadata.fatal(firstChild, "Bad value for LocalColorTable attribute sizeOfLocalColorTable!");
                }
                this.sortFlag = GIFMetadata.getBooleanAttribute(firstChild, "sortFlag", false, true);
                this.localColorTable = getColorTable(firstChild, "ColorTableEntry", true, intAttribute);
            } else if (nodeName.equals("GraphicControlExtension")) {
                String stringAttribute = GIFMetadata.getStringAttribute(firstChild, "disposalMethod", null, true, GIFImageMetadata.disposalMethodNames);
                this.disposalMethod = 0;
                while (!stringAttribute.equals(GIFImageMetadata.disposalMethodNames[this.disposalMethod])) {
                    this.disposalMethod++;
                }
                this.userInputFlag = GIFMetadata.getBooleanAttribute(firstChild, "userInputFlag", false, true);
                this.transparentColorFlag = GIFMetadata.getBooleanAttribute(firstChild, "transparentColorFlag", false, true);
                this.delayTime = GIFMetadata.getIntAttribute(firstChild, "delayTime", -1, true, true, 0, 65535);
                this.transparentColorIndex = GIFMetadata.getIntAttribute(firstChild, "transparentColorIndex", -1, true, true, 0, 65535);
            } else if (nodeName.equals("PlainTextExtension")) {
                this.hasPlainTextExtension = true;
                this.textGridLeft = GIFMetadata.getIntAttribute(firstChild, "textGridLeft", -1, true, true, 0, 65535);
                this.textGridTop = GIFMetadata.getIntAttribute(firstChild, "textGridTop", -1, true, true, 0, 65535);
                this.textGridWidth = GIFMetadata.getIntAttribute(firstChild, "textGridWidth", -1, true, true, 1, 65535);
                this.textGridHeight = GIFMetadata.getIntAttribute(firstChild, "textGridHeight", -1, true, true, 1, 65535);
                this.characterCellWidth = GIFMetadata.getIntAttribute(firstChild, "characterCellWidth", -1, true, true, 1, 65535);
                this.characterCellHeight = GIFMetadata.getIntAttribute(firstChild, "characterCellHeight", -1, true, true, 1, 65535);
                this.textForegroundColor = GIFMetadata.getIntAttribute(firstChild, "textForegroundColor", -1, true, true, 0, 255);
                this.textBackgroundColor = GIFMetadata.getIntAttribute(firstChild, "textBackgroundColor", -1, true, true, 0, 255);
                this.text = fromISO8859(GIFMetadata.getStringAttribute(firstChild, "text", "", false, null));
            } else if (nodeName.equals("ApplicationExtensions")) {
                IIOMetadataNode iIOMetadataNode = (IIOMetadataNode) firstChild.getFirstChild();
                if (!iIOMetadataNode.getNodeName().equals("ApplicationExtension")) {
                    GIFMetadata.fatal(firstChild, "Only a ApplicationExtension may be a child of a ApplicationExtensions!");
                }
                String stringAttribute2 = GIFMetadata.getStringAttribute(iIOMetadataNode, "applicationID", null, true, null);
                String stringAttribute3 = GIFMetadata.getStringAttribute(iIOMetadataNode, "authenticationCode", null, true, null);
                Object userObject = iIOMetadataNode.getUserObject();
                if (userObject == null || !(userObject instanceof byte[])) {
                    GIFMetadata.fatal(iIOMetadataNode, "Bad user object in ApplicationExtension!");
                }
                if (this.applicationIDs == null) {
                    this.applicationIDs = new ArrayList();
                    this.authenticationCodes = new ArrayList();
                    this.applicationData = new ArrayList();
                }
                this.applicationIDs.add(fromISO8859(stringAttribute2));
                this.authenticationCodes.add(fromISO8859(stringAttribute3));
                this.applicationData.add(userObject);
            } else if (nodeName.equals("CommentExtensions")) {
                Node firstChild2 = firstChild.getFirstChild();
                if (firstChild2 != null) {
                    while (firstChild2 != null) {
                        if (!firstChild2.getNodeName().equals("CommentExtension")) {
                            GIFMetadata.fatal(firstChild, "Only a CommentExtension may be a child of a CommentExtensions!");
                        }
                        if (this.comments == null) {
                            this.comments = new ArrayList();
                        }
                        this.comments.add(fromISO8859(GIFMetadata.getStringAttribute(firstChild2, "value", null, true, null)));
                        firstChild2 = firstChild2.getNextSibling();
                    }
                }
            } else {
                GIFMetadata.fatal(firstChild, "Unknown child of root node!");
            }
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFImageMetadata, com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeStandardTree(Node node) throws IIOInvalidTreeException {
        if (!node.getNodeName().equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            GIFMetadata.fatal(node, "Root must be javax_imageio_1.0");
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            if (nodeName.equals("Chroma")) {
                Node firstChild2 = firstChild.getFirstChild();
                while (true) {
                    if (firstChild2 == null) {
                        break;
                    }
                    if (firstChild2.getNodeName().equals("Palette")) {
                        this.localColorTable = getColorTable(firstChild2, "PaletteEntry", false, -1);
                        break;
                    }
                    firstChild2 = firstChild2.getNextSibling();
                }
            } else if (nodeName.equals(ExifInterface.TAG_COMPRESSION)) {
                Node firstChild3 = firstChild.getFirstChild();
                while (true) {
                    if (firstChild3 == null) {
                        break;
                    }
                    if (!firstChild3.getNodeName().equals("NumProgressiveScans")) {
                        firstChild3 = firstChild3.getNextSibling();
                    } else if (GIFMetadata.getIntAttribute(firstChild3, "value", 4, false, true, 1, Integer.MAX_VALUE) > 1) {
                        this.interlaceFlag = true;
                    }
                }
            } else if (nodeName.equals("Dimension")) {
                for (Node firstChild4 = firstChild.getFirstChild(); firstChild4 != null; firstChild4 = firstChild4.getNextSibling()) {
                    String nodeName2 = firstChild4.getNodeName();
                    if (nodeName2.equals("HorizontalPixelOffset")) {
                        this.imageLeftPosition = GIFMetadata.getIntAttribute(firstChild4, "value", -1, true, true, 0, 65535);
                    } else if (nodeName2.equals("VerticalPixelOffset")) {
                        this.imageTopPosition = GIFMetadata.getIntAttribute(firstChild4, "value", -1, true, true, 0, 65535);
                    }
                }
            } else if (nodeName.equals(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT)) {
                for (Node firstChild5 = firstChild.getFirstChild(); firstChild5 != null; firstChild5 = firstChild5.getNextSibling()) {
                    if (firstChild5.getNodeName().equals("TextEntry") && GIFMetadata.getAttribute(firstChild5, "compression", "none", false).equals("none") && Charset.isSupported(GIFMetadata.getAttribute(firstChild5, XMLWriter.ENCODING, "ISO-8859-1", false))) {
                        byte[] bArrFromISO8859 = fromISO8859(GIFMetadata.getAttribute(firstChild5, "value"));
                        if (this.comments == null) {
                            this.comments = new ArrayList();
                        }
                        this.comments.add(bArrFromISO8859);
                    }
                }
            } else if (nodeName.equals("Transparency")) {
                Node firstChild6 = firstChild.getFirstChild();
                while (true) {
                    if (firstChild6 == null) {
                        break;
                    }
                    if (firstChild6.getNodeName().equals("TransparentIndex")) {
                        this.transparentColorIndex = GIFMetadata.getIntAttribute(firstChild6, "value", -1, true, true, 0, 255);
                        this.transparentColorFlag = true;
                        break;
                    }
                    firstChild6 = firstChild6.getNextSibling();
                }
            }
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFImageMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        this.imageLeftPosition = 0;
        this.imageTopPosition = 0;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.interlaceFlag = false;
        this.sortFlag = false;
        this.localColorTable = null;
        this.disposalMethod = 0;
        this.userInputFlag = false;
        this.transparentColorFlag = false;
        this.delayTime = 0;
        this.transparentColorIndex = 0;
        this.hasPlainTextExtension = false;
        this.textGridLeft = 0;
        this.textGridTop = 0;
        this.textGridWidth = 0;
        this.textGridHeight = 0;
        this.characterCellWidth = 0;
        this.characterCellHeight = 0;
        this.textForegroundColor = 0;
        this.textBackgroundColor = 0;
        this.text = null;
        this.applicationIDs = null;
        this.authenticationCodes = null;
        this.applicationData = null;
        this.comments = null;
    }

    @Override // com.sun.imageio.plugins.gif.GIFImageMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) {
        reset();
        mergeTree(str, node);
    }
}
