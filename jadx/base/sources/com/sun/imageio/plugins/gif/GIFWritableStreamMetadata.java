package com.sun.imageio.plugins.gif;

import androidx.exifinterface.media.ExifInterface;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GIFWritableStreamMetadata extends GIFStreamMetadata {
    static final String NATIVE_FORMAT_NAME = "javax_imageio_gif_stream_1.0";

    public GIFWritableStreamMetadata() {
        super(true, NATIVE_FORMAT_NAME, "com.sun.imageio.plugins.gif.GIFStreamMetadataFormat", null, null);
        reset();
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return false;
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeNativeTree(Node node) throws IIOInvalidTreeException {
        if (!node.getNodeName().equals(NATIVE_FORMAT_NAME)) {
            GIFMetadata.fatal(node, "Root must be javax_imageio_gif_stream_1.0");
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            if (nodeName.equals("Version")) {
                this.version = GIFMetadata.getStringAttribute(firstChild, "value", null, true, GIFStreamMetadata.versionStrings);
            } else if (nodeName.equals("LogicalScreenDescriptor")) {
                this.logicalScreenWidth = GIFMetadata.getIntAttribute(firstChild, "logicalScreenWidth", -1, true, true, 1, 65535);
                this.logicalScreenHeight = GIFMetadata.getIntAttribute(firstChild, "logicalScreenHeight", -1, true, true, 1, 65535);
                this.colorResolution = GIFMetadata.getIntAttribute(firstChild, "colorResolution", -1, true, true, 1, 8);
                this.pixelAspectRatio = GIFMetadata.getIntAttribute(firstChild, "pixelAspectRatio", 0, true, true, 0, 255);
            } else if (nodeName.equals("GlobalColorTable")) {
                int intAttribute = GIFMetadata.getIntAttribute(firstChild, "sizeOfGlobalColorTable", true, 2, 256);
                if (intAttribute != 2 && intAttribute != 4 && intAttribute != 8 && intAttribute != 16 && intAttribute != 32 && intAttribute != 64 && intAttribute != 128 && intAttribute != 256) {
                    GIFMetadata.fatal(firstChild, "Bad value for GlobalColorTable attribute sizeOfGlobalColorTable!");
                }
                this.backgroundColorIndex = GIFMetadata.getIntAttribute(firstChild, "backgroundColorIndex", 0, true, true, 0, 255);
                this.sortFlag = GIFMetadata.getBooleanAttribute(firstChild, "sortFlag", false, true);
                this.globalColorTable = getColorTable(firstChild, "ColorTableEntry", true, intAttribute);
            } else {
                GIFMetadata.fatal(firstChild, "Unknown child of root node!");
            }
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeStandardTree(Node node) throws IIOInvalidTreeException {
        if (!node.getNodeName().equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            GIFMetadata.fatal(node, "Root must be javax_imageio_1.0");
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            int i = 0;
            if (nodeName.equals("Chroma")) {
                for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                    String nodeName2 = firstChild2.getNodeName();
                    if (nodeName2.equals("Palette")) {
                        this.globalColorTable = getColorTable(firstChild2, "PaletteEntry", false, -1);
                    } else if (nodeName2.equals("BackgroundIndex")) {
                        this.backgroundColorIndex = GIFMetadata.getIntAttribute(firstChild2, "value", -1, true, true, 0, 255);
                    }
                }
            } else if (nodeName.equals("Data")) {
                Node firstChild3 = firstChild.getFirstChild();
                while (true) {
                    if (firstChild3 == null) {
                        break;
                    }
                    if (firstChild3.getNodeName().equals(ExifInterface.TAG_BITS_PER_SAMPLE)) {
                        this.colorResolution = GIFMetadata.getIntAttribute(firstChild3, "value", -1, true, true, 1, 8);
                        break;
                    }
                    firstChild3 = firstChild3.getNextSibling();
                }
            } else if (nodeName.equals("Dimension")) {
                for (Node firstChild4 = firstChild.getFirstChild(); firstChild4 != null; firstChild4 = firstChild4.getNextSibling()) {
                    String nodeName3 = firstChild4.getNodeName();
                    if (nodeName3.equals("PixelAspectRatio")) {
                        float floatAttribute = GIFMetadata.getFloatAttribute(firstChild4, "value");
                        if (floatAttribute == 1.0f) {
                            this.pixelAspectRatio = 0;
                        } else {
                            this.pixelAspectRatio = Math.max(Math.min((int) ((floatAttribute * 64.0f) - 15.0f), 255), 0);
                        }
                    } else if (nodeName3.equals("HorizontalScreenSize")) {
                        this.logicalScreenWidth = GIFMetadata.getIntAttribute(firstChild4, "value", -1, true, true, 1, 65535);
                    } else if (nodeName3.equals("VerticalScreenSize")) {
                        this.logicalScreenHeight = GIFMetadata.getIntAttribute(firstChild4, "value", -1, true, true, 1, 65535);
                    }
                }
            } else if (nodeName.equals("Document")) {
                Node firstChild5 = firstChild.getFirstChild();
                while (true) {
                    if (firstChild5 == null) {
                        break;
                    }
                    if (firstChild5.getNodeName().equals("FormatVersion")) {
                        String stringAttribute = GIFMetadata.getStringAttribute(firstChild5, "value", null, true, null);
                        while (true) {
                            String[] strArr = GIFStreamMetadata.versionStrings;
                            if (i >= strArr.length) {
                                break;
                            }
                            if (stringAttribute.equals(strArr[i])) {
                                this.version = stringAttribute;
                                break;
                            }
                            i++;
                        }
                    } else {
                        firstChild5 = firstChild5.getNextSibling();
                    }
                }
            }
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, com.sun.imageio.plugins.gif.GIFMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) throws IIOInvalidTreeException {
        if (str.equals(NATIVE_FORMAT_NAME)) {
            if (node == null) {
                throw new IllegalArgumentException("root == null!");
            }
            mergeNativeTree(node);
        } else {
            if (!str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
                throw new IllegalArgumentException("Not a recognized format!");
            }
            if (node == null) {
                throw new IllegalArgumentException("root == null!");
            }
            mergeStandardTree(node);
        }
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        this.version = null;
        this.logicalScreenWidth = -1;
        this.logicalScreenHeight = -1;
        this.colorResolution = -1;
        this.pixelAspectRatio = 0;
        this.backgroundColorIndex = 0;
        this.sortFlag = false;
        this.globalColorTable = null;
    }

    @Override // com.sun.imageio.plugins.gif.GIFStreamMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) throws IIOInvalidTreeException {
        reset();
        mergeTree(str, node);
    }
}
