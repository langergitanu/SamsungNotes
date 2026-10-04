package com.sun.imageio.plugins.bmp;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import com.sun.imageio.plugins.common.I18N;
import com.sun.imageio.plugins.common.ImageUtil;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPMetadata extends IIOMetadata implements BMPConstants {
    public static final String nativeMetadataFormatName = "javax_imageio_bmp_1.0";
    public int alphaMask;
    public short bitsPerPixel;
    public int blue;
    public int blueMask;
    public double blueX;
    public double blueY;
    public double blueZ;
    public String bmpVersion;
    public int colorSpace;
    public int colorsImportant;
    public int colorsUsed;
    public List comments;
    public int compression;
    public int gammaBlue;
    public int gammaGreen;
    public int gammaRed;
    public int green;
    public int greenMask;
    public double greenX;
    public double greenY;
    public double greenZ;
    public int height;
    public int imageSize;
    public int intent;
    public byte[] palette;
    public int paletteSize;
    public int red;
    public int redMask;
    public double redX;
    public double redY;
    public double redZ;
    public int width;
    public int xPixelsPerMeter;
    public int yPixelsPerMeter;

    public BMPMetadata() {
        super(true, nativeMetadataFormatName, "com.sun.imageio.plugins.bmp.BMPMetadataFormat", null, null);
        this.palette = null;
        this.comments = null;
    }

    private IIOMetadataNode addChildNode(IIOMetadataNode iIOMetadataNode, String str, Object obj) {
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode(str);
        if (obj != null) {
            iIOMetadataNode2.setUserObject(obj);
            iIOMetadataNode2.setNodeValue(ImageUtil.convertObjectToString(obj));
        }
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode2;
    }

    private void addXYZPoints(IIOMetadataNode iIOMetadataNode, String str, double d, double d2, double d3) {
        IIOMetadataNode iIOMetadataNodeAddChildNode = addChildNode(iIOMetadataNode, str, null);
        addChildNode(iIOMetadataNodeAddChildNode, "X", new Double(d));
        addChildNode(iIOMetadataNodeAddChildNode, DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, new Double(d2));
        addChildNode(iIOMetadataNodeAddChildNode, "Z", new Double(d3));
    }

    private String countBits(int i) {
        int i2 = 0;
        while (i > 0) {
            if ((i & 1) == 1) {
                i2++;
            }
            i >>>= 1;
        }
        return i2 == 0 ? "" : AbstractC0000a.m11h(i2, "");
    }

    private Node getNativeTree() {
        int i;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(nativeMetadataFormatName);
        addChildNode(iIOMetadataNode, "BMPVersion", this.bmpVersion);
        addChildNode(iIOMetadataNode, HttpHeaders.WIDTH, new Integer(this.width));
        addChildNode(iIOMetadataNode, "Height", new Integer(this.height));
        addChildNode(iIOMetadataNode, "BitsPerPixel", new Short(this.bitsPerPixel));
        addChildNode(iIOMetadataNode, ExifInterface.TAG_COMPRESSION, new Integer(this.compression));
        addChildNode(iIOMetadataNode, "ImageSize", new Integer(this.imageSize));
        IIOMetadataNode iIOMetadataNodeAddChildNode = addChildNode(iIOMetadataNode, "PixelsPerMeter", null);
        addChildNode(iIOMetadataNodeAddChildNode, "X", new Integer(this.xPixelsPerMeter));
        addChildNode(iIOMetadataNodeAddChildNode, DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, new Integer(this.yPixelsPerMeter));
        addChildNode(iIOMetadataNode, "ColorsUsed", new Integer(this.colorsUsed));
        addChildNode(iIOMetadataNode, "ColorsImportant", new Integer(this.colorsImportant));
        int iCharAt = 0;
        for (int i2 = 0; i2 < this.bmpVersion.length(); i2++) {
            if (Character.isDigit(this.bmpVersion.charAt(i2))) {
                iCharAt = this.bmpVersion.charAt(i2) - '0';
            }
        }
        if (iCharAt >= 4) {
            IIOMetadataNode iIOMetadataNodeAddChildNode2 = addChildNode(iIOMetadataNode, "Mask", null);
            addChildNode(iIOMetadataNodeAddChildNode2, "Red", new Integer(this.redMask));
            addChildNode(iIOMetadataNodeAddChildNode2, "Green", new Integer(this.greenMask));
            addChildNode(iIOMetadataNodeAddChildNode2, "Blue", new Integer(this.blueMask));
            addChildNode(iIOMetadataNodeAddChildNode2, "Alpha", new Integer(this.alphaMask));
            addChildNode(iIOMetadataNode, "ColorSpaceType", new Integer(this.colorSpace));
            IIOMetadataNode iIOMetadataNodeAddChildNode3 = addChildNode(iIOMetadataNode, "CIEXYZEndPoints", null);
            i = 4;
            addXYZPoints(iIOMetadataNodeAddChildNode3, "Red", this.redX, this.redY, this.redZ);
            addXYZPoints(iIOMetadataNodeAddChildNode3, "Green", this.greenX, this.greenY, this.greenZ);
            addXYZPoints(iIOMetadataNodeAddChildNode3, "Blue", this.blueX, this.blueY, this.blueZ);
            addChildNode(iIOMetadataNode, "Intent", new Integer(this.intent));
        } else {
            i = 4;
        }
        if (this.palette != null && this.paletteSize > 0) {
            IIOMetadataNode iIOMetadataNodeAddChildNode4 = addChildNode(iIOMetadataNode, "Palette", null);
            int length = this.palette.length / this.paletteSize;
            int i4 = 0;
            for (int i5 = 0; i5 < this.paletteSize; i5++) {
                IIOMetadataNode iIOMetadataNodeAddChildNode5 = addChildNode(iIOMetadataNodeAddChildNode4, "PaletteEntry", null);
                byte[] bArr = this.palette;
                int i6 = bArr[i4] & 255;
                this.red = i6;
                this.green = bArr[i4 + 1] & 255;
                int i7 = i4 + 3;
                this.blue = bArr[i4 + 2] & 255;
                addChildNode(iIOMetadataNodeAddChildNode5, "Red", new Byte((byte) i6));
                addChildNode(iIOMetadataNodeAddChildNode5, "Green", new Byte((byte) this.green));
                addChildNode(iIOMetadataNodeAddChildNode5, "Blue", new Byte((byte) this.blue));
                if (length == i) {
                    i4 += 4;
                    addChildNode(iIOMetadataNodeAddChildNode5, "Alpha", new Byte((byte) (this.palette[i7] & 255)));
                } else {
                    i4 = i7;
                }
            }
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
        throw new IllegalArgumentException(I18N.getString("BMPMetadata0"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardChromaNode() {
        if (this.palette == null || this.paletteSize <= 0) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Chroma");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Palette");
        int length = this.palette.length / this.paletteSize;
        iIOMetadataNode2.setAttribute("value", "" + length);
        int i = 0;
        for (int i2 = 0; i2 < this.paletteSize; i2++) {
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("PaletteEntry");
            iIOMetadataNode3.setAttribute("index", "" + i2);
            iIOMetadataNode3.setAttribute("red", "" + ((int) this.palette[i]));
            iIOMetadataNode3.setAttribute("green", "" + ((int) this.palette[i + 1]));
            StringBuilder sb = new StringBuilder("");
            int i4 = i + 3;
            sb.append((int) this.palette[i + 2]);
            iIOMetadataNode3.setAttribute("blue", sb.toString());
            if (length != 4 || this.palette[i4] == 0) {
                i = i4;
            } else {
                StringBuilder sb2 = new StringBuilder("");
                i += 4;
                sb2.append((int) this.palette[i4]);
                iIOMetadataNode3.setAttribute("alpha", sb2.toString());
            }
            iIOMetadataNode2.appendChild(iIOMetadataNode3);
        }
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardCompressionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(ExifInterface.TAG_COMPRESSION);
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("CompressionTypeName");
        iIOMetadataNode2.setAttribute("value", BMPCompressionTypes.getName(this.compression));
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDataNode() {
        String str;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Data");
        short s = this.bitsPerPixel;
        if (s == 24) {
            str = "8 8 8 ";
        } else if (s == 16 || s == 32) {
            str = "" + countBits(this.redMask) + " " + countBits(this.greenMask) + countBits(this.blueMask) + "" + countBits(this.alphaMask);
        } else {
            str = "";
        }
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode(ExifInterface.TAG_BITS_PER_SAMPLE);
        iIOMetadataNode2.setAttribute("value", str);
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDimensionNode() {
        if (this.yPixelsPerMeter <= 0.0f || this.xPixelsPerMeter <= 0.0f) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Dimension");
        float f = this.yPixelsPerMeter / this.xPixelsPerMeter;
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("PixelAspectRatio");
        iIOMetadataNode2.setAttribute("value", "" + f);
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("HorizontalPhysicalPixelSpacing");
        iIOMetadataNode3.setAttribute("value", "" + ((1 / this.xPixelsPerMeter) * 1000));
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("VerticalPhysicalPixelSpacing");
        iIOMetadataNode4.setAttribute("value", "" + ((1 / this.yPixelsPerMeter) * 1000));
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) {
        throw new IllegalStateException(I18N.getString("BMPMetadata1"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        throw new IllegalStateException(I18N.getString("BMPMetadata1"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) {
        throw new IllegalStateException(I18N.getString("BMPMetadata1"));
    }
}
