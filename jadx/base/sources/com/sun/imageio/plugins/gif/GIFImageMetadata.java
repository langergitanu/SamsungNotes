package com.sun.imageio.plugins.gif;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageMetadata extends GIFMetadata {
    static final String[] disposalMethodNames = {"none", "doNotDispose", "restoreToBackgroundColor", "restoreToPrevious", "undefinedDisposalMethod4", "undefinedDisposalMethod5", "undefinedDisposalMethod6", "undefinedDisposalMethod7"};
    static final String nativeMetadataFormatName = "javax_imageio_gif_image_1.0";
    public List applicationData;
    public List applicationIDs;
    public List authenticationCodes;
    public int characterCellHeight;
    public int characterCellWidth;
    public List comments;
    public int delayTime;
    public int disposalMethod;
    public boolean hasPlainTextExtension;
    public int imageHeight;
    public int imageLeftPosition;
    public int imageTopPosition;
    public int imageWidth;
    public boolean interlaceFlag;
    public byte[] localColorTable;
    public boolean sortFlag;
    public byte[] text;
    public int textBackgroundColor;
    public int textForegroundColor;
    public int textGridHeight;
    public int textGridLeft;
    public int textGridTop;
    public int textGridWidth;
    public boolean transparentColorFlag;
    public int transparentColorIndex;
    public boolean userInputFlag;

    public GIFImageMetadata(boolean z, String str, String str2, String[] strArr, String[] strArr2) {
        super(z, str, str2, strArr, strArr2);
        this.interlaceFlag = false;
        this.sortFlag = false;
        this.localColorTable = null;
        this.disposalMethod = 0;
        this.userInputFlag = false;
        this.transparentColorFlag = false;
        this.delayTime = 0;
        this.transparentColorIndex = 0;
        this.hasPlainTextExtension = false;
        this.applicationIDs = null;
        this.authenticationCodes = null;
        this.applicationData = null;
        this.comments = null;
    }

    private Node getNativeTree() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(nativeMetadataFormatName);
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ImageDescriptor");
        iIOMetadataNode2.setAttribute("imageLeftPosition", Integer.toString(this.imageLeftPosition));
        iIOMetadataNode2.setAttribute("imageTopPosition", Integer.toString(this.imageTopPosition));
        iIOMetadataNode2.setAttribute(ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH, Integer.toString(this.imageWidth));
        iIOMetadataNode2.setAttribute(ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT, Integer.toString(this.imageHeight));
        iIOMetadataNode2.setAttribute("interlaceFlag", this.interlaceFlag ? "TRUE" : "FALSE");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        if (this.localColorTable != null) {
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("LocalColorTable");
            int length = this.localColorTable.length / 3;
            iIOMetadataNode3.setAttribute("sizeOfLocalColorTable", Integer.toString(length));
            iIOMetadataNode3.setAttribute("sortFlag", this.sortFlag ? "TRUE" : "FALSE");
            for (int i = 0; i < length; i++) {
                IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("ColorTableEntry");
                iIOMetadataNode4.setAttribute("index", Integer.toString(i));
                byte[] bArr = this.localColorTable;
                int i2 = i * 3;
                int i4 = bArr[i2] & 255;
                int i5 = bArr[i2 + 1] & 255;
                int i6 = bArr[i2 + 2] & 255;
                iIOMetadataNode4.setAttribute("red", Integer.toString(i4));
                iIOMetadataNode4.setAttribute("green", Integer.toString(i5));
                iIOMetadataNode4.setAttribute("blue", Integer.toString(i6));
                iIOMetadataNode3.appendChild(iIOMetadataNode4);
            }
            iIOMetadataNode.appendChild(iIOMetadataNode3);
        }
        IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("GraphicControlExtension");
        iIOMetadataNode5.setAttribute("disposalMethod", disposalMethodNames[this.disposalMethod]);
        iIOMetadataNode5.setAttribute("userInputFlag", this.userInputFlag ? "TRUE" : "FALSE");
        iIOMetadataNode5.setAttribute("transparentColorFlag", this.transparentColorFlag ? "TRUE" : "FALSE");
        iIOMetadataNode5.setAttribute("delayTime", Integer.toString(this.delayTime));
        iIOMetadataNode5.setAttribute("transparentColorIndex", Integer.toString(this.transparentColorIndex));
        iIOMetadataNode.appendChild(iIOMetadataNode5);
        if (this.hasPlainTextExtension) {
            IIOMetadataNode iIOMetadataNode6 = new IIOMetadataNode("PlainTextExtension");
            iIOMetadataNode6.setAttribute("textGridLeft", Integer.toString(this.textGridLeft));
            iIOMetadataNode6.setAttribute("textGridTop", Integer.toString(this.textGridTop));
            iIOMetadataNode6.setAttribute("textGridWidth", Integer.toString(this.textGridWidth));
            iIOMetadataNode6.setAttribute("textGridHeight", Integer.toString(this.textGridHeight));
            iIOMetadataNode6.setAttribute("characterCellWidth", Integer.toString(this.characterCellWidth));
            iIOMetadataNode6.setAttribute("characterCellHeight", Integer.toString(this.characterCellHeight));
            iIOMetadataNode6.setAttribute("textForegroundColor", Integer.toString(this.textForegroundColor));
            iIOMetadataNode6.setAttribute("textBackgroundColor", Integer.toString(this.textBackgroundColor));
            iIOMetadataNode6.setAttribute("text", toISO8859(this.text));
            iIOMetadataNode.appendChild(iIOMetadataNode6);
        }
        List list = this.applicationIDs;
        int size = list == null ? 0 : list.size();
        if (size > 0) {
            Node iIOMetadataNode7 = new IIOMetadataNode("ApplicationExtensions");
            for (int i7 = 0; i7 < size; i7++) {
                IIOMetadataNode iIOMetadataNode8 = new IIOMetadataNode("ApplicationExtension");
                iIOMetadataNode8.setAttribute("applicationID", toISO8859((byte[]) this.applicationIDs.get(i7)));
                iIOMetadataNode8.setAttribute("authenticationCode", toISO8859((byte[]) this.authenticationCodes.get(i7)));
                iIOMetadataNode8.setUserObject((byte[]) ((byte[]) this.applicationData.get(i7)).clone());
                iIOMetadataNode7.appendChild(iIOMetadataNode8);
            }
            iIOMetadataNode.appendChild(iIOMetadataNode7);
        }
        List list2 = this.comments;
        int size2 = list2 == null ? 0 : list2.size();
        if (size2 > 0) {
            Node iIOMetadataNode9 = new IIOMetadataNode("CommentExtensions");
            for (int i8 = 0; i8 < size2; i8++) {
                IIOMetadataNode iIOMetadataNode10 = new IIOMetadataNode("CommentExtension");
                iIOMetadataNode10.setAttribute("value", toISO8859((byte[]) this.comments.get(i8)));
                iIOMetadataNode9.appendChild(iIOMetadataNode10);
            }
            iIOMetadataNode.appendChild(iIOMetadataNode9);
        }
        return iIOMetadataNode;
    }

    private String toISO8859(byte[] bArr) {
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public Node getAsTree(String str) {
        if (str.equals(nativeMetadataFormatName)) {
            return getNativeTree();
        }
        if (str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            return getStandardTree();
        }
        throw new IllegalArgumentException("Not a recognized format!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardChromaNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Chroma");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ColorSpaceType");
        iIOMetadataNode2.setAttribute("name", "RGB");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("NumChannels");
        iIOMetadataNode3.setAttribute("value", this.transparentColorFlag ? "4" : "3");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("BlackIsZero");
        iIOMetadataNode4.setAttribute("value", "TRUE");
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        if (this.localColorTable != null) {
            Node iIOMetadataNode5 = new IIOMetadataNode("Palette");
            int length = this.localColorTable.length / 3;
            for (int i = 0; i < length; i++) {
                IIOMetadataNode iIOMetadataNode6 = new IIOMetadataNode("PaletteEntry");
                iIOMetadataNode6.setAttribute("index", Integer.toString(i));
                int i2 = i * 3;
                iIOMetadataNode6.setAttribute("red", Integer.toString(this.localColorTable[i2] & 255));
                iIOMetadataNode6.setAttribute("green", Integer.toString(this.localColorTable[i2 + 1] & 255));
                iIOMetadataNode6.setAttribute("blue", Integer.toString(this.localColorTable[i2 + 2] & 255));
                iIOMetadataNode5.appendChild(iIOMetadataNode6);
            }
            iIOMetadataNode.appendChild(iIOMetadataNode5);
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardCompressionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(ExifInterface.TAG_COMPRESSION);
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("CompressionTypeName");
        iIOMetadataNode2.setAttribute("value", "lzw");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("Lossless");
        iIOMetadataNode3.setAttribute("value", "TRUE");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("NumProgressiveScans");
        iIOMetadataNode4.setAttribute("value", this.interlaceFlag ? "4" : "1");
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDataNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Data");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("SampleFormat");
        iIOMetadataNode2.setAttribute("value", Bixby2Constants.BIXBY_PARAM_INDEX);
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDimensionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Dimension");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ImageOrientation");
        iIOMetadataNode2.setAttribute("value", "Normal");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("HorizontalPixelOffset");
        iIOMetadataNode3.setAttribute("value", Integer.toString(this.imageLeftPosition));
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("VerticalPixelOffset");
        iIOMetadataNode4.setAttribute("value", Integer.toString(this.imageTopPosition));
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTextNode() {
        List list = this.comments;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT);
        while (it.hasNext()) {
            try {
                String str = new String((byte[]) it.next(), "ISO-8859-1");
                IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("TextEntry");
                iIOMetadataNode2.setAttribute("value", str);
                iIOMetadataNode2.setAttribute(XMLWriter.ENCODING, "ISO-8859-1");
                iIOMetadataNode2.setAttribute("compression", "none");
                iIOMetadataNode.appendChild(iIOMetadataNode2);
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("Encoding ISO-8859-1 unknown!");
            }
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTransparencyNode() {
        if (!this.transparentColorFlag) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Transparency");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("TransparentIndex");
        iIOMetadataNode2.setAttribute("value", Integer.toString(this.transparentColorIndex));
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return true;
    }

    @Override // com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeNativeTree(Node node) {
        throw new IllegalStateException("Metadata is read-only!");
    }

    @Override // com.sun.imageio.plugins.gif.GIFMetadata
    public void mergeStandardTree(Node node) {
        throw new IllegalStateException("Metadata is read-only!");
    }

    @Override // com.sun.imageio.plugins.gif.GIFMetadata, org.apache.poi.javax.imageio.metadata.IIOMetadata
    public /* bridge */ /* synthetic */ void mergeTree(String str, Node node) {
        super.mergeTree(str, node);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        throw new IllegalStateException("Metadata is read-only!");
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) {
        throw new IllegalStateException("Metadata is read-only!");
    }

    public GIFImageMetadata() {
        this(true, nativeMetadataFormatName, "com.sun.imageio.plugins.gif.GIFImageMetadataFormat", null, null);
    }
}
