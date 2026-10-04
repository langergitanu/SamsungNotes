package com.sun.imageio.plugins.png;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PNGMetadata extends IIOMetadata implements Cloneable {
    public static final int PHYS_UNIT_METER = 1;
    public static final int PHYS_UNIT_UNKNOWN = 0;
    protected static final String nativeMetadataFormatClassName = "com.sun.imageio.plugins.png.PNGMetadataFormat";
    public static final String nativeMetadataFormatName = "javax_imageio_png_1.0";
    public int IHDR_bitDepth;
    public int IHDR_colorType;
    public int IHDR_compressionMethod;
    public int IHDR_filterMethod;
    public int IHDR_height;
    public int IHDR_interlaceMethod;
    public boolean IHDR_present;
    public int IHDR_width;
    public byte[] PLTE_blue;
    public byte[] PLTE_green;
    public int[] PLTE_order;
    public boolean PLTE_present;
    public byte[] PLTE_red;
    public int bKGD_blue;
    public int bKGD_colorType;
    public int bKGD_gray;
    public int bKGD_green;
    public int bKGD_index;
    public boolean bKGD_present;
    public int bKGD_red;
    public int cHRM_blueX;
    public int cHRM_blueY;
    public int cHRM_greenX;
    public int cHRM_greenY;
    public boolean cHRM_present;
    public int cHRM_redX;
    public int cHRM_redY;
    public int cHRM_whitePointX;
    public int cHRM_whitePointY;
    public int gAMA_gamma;
    public boolean gAMA_present;
    public char[] hIST_histogram;
    public boolean hIST_present;
    public byte[] iCCP_compressedProfile;
    public int iCCP_compressionMethod;
    public boolean iCCP_present;
    public String iCCP_profileName;
    public ArrayList<Boolean> iTXt_compressionFlag;
    public ArrayList<Integer> iTXt_compressionMethod;
    public ArrayList<String> iTXt_keyword;
    public ArrayList<String> iTXt_languageTag;
    public ArrayList<String> iTXt_text;
    public ArrayList<String> iTXt_translatedKeyword;
    public int pHYs_pixelsPerUnitXAxis;
    public int pHYs_pixelsPerUnitYAxis;
    public boolean pHYs_present;
    public int pHYs_unitSpecifier;
    public int sBIT_alphaBits;
    public int sBIT_blueBits;
    public int sBIT_colorType;
    public int sBIT_grayBits;
    public int sBIT_greenBits;
    public boolean sBIT_present;
    public int sBIT_redBits;
    public int[] sPLT_alpha;
    public int[] sPLT_blue;
    public int[] sPLT_frequency;
    public int[] sPLT_green;
    public String sPLT_paletteName;
    public boolean sPLT_present;
    public int[] sPLT_red;
    public int sPLT_sampleDepth;
    public boolean sRGB_present;
    public int sRGB_renderingIntent;
    public ArrayList<String> tEXt_keyword;
    public ArrayList<String> tEXt_text;
    public int tIME_day;
    public int tIME_hour;
    public int tIME_minute;
    public int tIME_month;
    public boolean tIME_present;
    public int tIME_second;
    public int tIME_year;
    public byte[] tRNS_alpha;
    public int tRNS_blue;
    public int tRNS_colorType;
    public int tRNS_gray;
    public int tRNS_green;
    public boolean tRNS_present;
    public int tRNS_red;
    public ArrayList<byte[]> unknownChunkData;
    public ArrayList<String> unknownChunkType;
    public ArrayList<Integer> zTXt_compressionMethod;
    public ArrayList<String> zTXt_keyword;
    public ArrayList<String> zTXt_text;
    static final String[] IHDR_colorTypeNames = {"Grayscale", null, "RGB", "Palette", "GrayAlpha", null, "RGBAlpha"};
    static final int[] IHDR_numChannels = {1, 0, 3, 3, 2, 0, 4};
    static final String[] IHDR_bitDepths = {"1", "2", "4", "8", "16"};
    static final String[] IHDR_compressionMethodNames = {"deflate"};
    static final String[] IHDR_filterMethodNames = {"adaptive"};
    static final String[] IHDR_interlaceMethodNames = {"none", "adam7"};
    static final String[] iCCP_compressionMethodNames = {"deflate"};
    static final String[] zTXt_compressionMethodNames = {"deflate"};
    static final String[] unitSpecifierNames = {"unknown", "meter"};
    static final String[] renderingIntentNames = {"Perceptual", "Relative colorimetric", ExifInterface.TAG_SATURATION, "Absolute colorimetric"};
    static final String[] colorSpaceTypeNames = {"GRAY", null, "RGB", "RGB", "GRAY", null, "RGB"};

    public PNGMetadata() {
        super(true, nativeMetadataFormatName, nativeMetadataFormatClassName, null, null);
        this.PLTE_order = null;
        this.iTXt_keyword = new ArrayList<>();
        this.iTXt_compressionFlag = new ArrayList<>();
        this.iTXt_compressionMethod = new ArrayList<>();
        this.iTXt_languageTag = new ArrayList<>();
        this.iTXt_translatedKeyword = new ArrayList<>();
        this.iTXt_text = new ArrayList<>();
        this.tEXt_keyword = new ArrayList<>();
        this.tEXt_text = new ArrayList<>();
        this.zTXt_keyword = new ArrayList<>();
        this.zTXt_compressionMethod = new ArrayList<>();
        this.zTXt_text = new ArrayList<>();
        this.unknownChunkType = new ArrayList<>();
        this.unknownChunkData = new ArrayList<>();
    }

    private ArrayList<byte[]> cloneBytesArrayList(ArrayList<byte[]> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<byte[]> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] next = it.next();
            arrayList2.add(next == null ? null : (byte[]) next.clone());
        }
        return arrayList2;
    }

    private void fatal(Node node, String str) throws IIOInvalidTreeException {
        throw new IIOInvalidTreeException(str, node);
    }

    private String getAttribute(Node node, String str, String str2, boolean z) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return str2;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        return namedItem.getNodeValue();
    }

    private boolean getBooleanAttribute(Node node, String str, boolean z, boolean z2) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z2) {
                return z;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        String nodeValue = namedItem.getNodeValue();
        if (nodeValue.equals("TRUE") || nodeValue.equals("true")) {
            return true;
        }
        if (!nodeValue.equals("FALSE") && !nodeValue.equals("false")) {
            fatal(node, AbstractC0541b.m773o("Attribute ", str, " must be 'TRUE' or 'FALSE'!"));
        }
        return false;
    }

    private int getEnumeratedAttribute(Node node, String str, String[] strArr, int i, boolean z) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return i;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        String nodeValue = namedItem.getNodeValue();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (nodeValue.equals(strArr[i2])) {
                return i2;
            }
        }
        fatal(node, AbstractC0541b.m773o("Illegal value for attribute ", str, "!"));
        return -1;
    }

    private float getFloatAttribute(Node node, String str, float f, boolean z) throws IIOInvalidTreeException {
        String stringAttribute = getStringAttribute(node, str, null, z);
        return stringAttribute == null ? f : Float.parseFloat(stringAttribute);
    }

    private int getIntAttribute(Node node, String str, int i, boolean z) throws IIOInvalidTreeException {
        String stringAttribute = getStringAttribute(node, str, null, z);
        return stringAttribute == null ? i : Integer.parseInt(stringAttribute);
    }

    private Node getNativeTree() throws CloneNotSupportedException {
        IIOMetadataNode iIOMetadataNode;
        IIOMetadataNode iIOMetadataNode2;
        IIOMetadataNode iIOMetadataNode3;
        IIOMetadataNode iIOMetadataNode4;
        IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode(nativeMetadataFormatName);
        if (this.IHDR_present) {
            IIOMetadataNode iIOMetadataNode6 = new IIOMetadataNode("IHDR");
            iIOMetadataNode6.setAttribute("width", Integer.toString(this.IHDR_width));
            iIOMetadataNode6.setAttribute("height", Integer.toString(this.IHDR_height));
            iIOMetadataNode6.setAttribute("bitDepth", Integer.toString(this.IHDR_bitDepth));
            iIOMetadataNode6.setAttribute("colorType", IHDR_colorTypeNames[this.IHDR_colorType]);
            iIOMetadataNode6.setAttribute("compressionMethod", IHDR_compressionMethodNames[this.IHDR_compressionMethod]);
            iIOMetadataNode6.setAttribute("filterMethod", IHDR_filterMethodNames[this.IHDR_filterMethod]);
            iIOMetadataNode6.setAttribute("interlaceMethod", IHDR_interlaceMethodNames[this.IHDR_interlaceMethod]);
            iIOMetadataNode5.appendChild(iIOMetadataNode6);
        }
        if (this.PLTE_present) {
            Node iIOMetadataNode7 = new IIOMetadataNode("PLTE");
            int length = this.PLTE_red.length;
            for (int i = 0; i < length; i++) {
                IIOMetadataNode iIOMetadataNode8 = new IIOMetadataNode("PLTEEntry");
                iIOMetadataNode8.setAttribute("index", Integer.toString(i));
                iIOMetadataNode8.setAttribute("red", Integer.toString(this.PLTE_red[i] & 255));
                iIOMetadataNode8.setAttribute("green", Integer.toString(this.PLTE_green[i] & 255));
                iIOMetadataNode8.setAttribute("blue", Integer.toString(this.PLTE_blue[i] & 255));
                iIOMetadataNode7.appendChild(iIOMetadataNode8);
            }
            iIOMetadataNode5.appendChild(iIOMetadataNode7);
        }
        IIOMetadataNode iIOMetadataNode9 = null;
        if (this.bKGD_present) {
            Node iIOMetadataNode10 = new IIOMetadataNode("bKGD");
            int i2 = this.bKGD_colorType;
            if (i2 == 3) {
                iIOMetadataNode9 = new IIOMetadataNode("bKGD_Palette");
                iIOMetadataNode9.setAttribute("index", Integer.toString(this.bKGD_index));
            } else if (i2 == 0) {
                iIOMetadataNode9 = new IIOMetadataNode("bKGD_Grayscale");
                iIOMetadataNode9.setAttribute("gray", Integer.toString(this.bKGD_gray));
            } else if (i2 == 2) {
                iIOMetadataNode9 = new IIOMetadataNode("bKGD_RGB");
                iIOMetadataNode9.setAttribute("red", Integer.toString(this.bKGD_red));
                iIOMetadataNode9.setAttribute("green", Integer.toString(this.bKGD_green));
                iIOMetadataNode9.setAttribute("blue", Integer.toString(this.bKGD_blue));
            }
            iIOMetadataNode10.appendChild(iIOMetadataNode9);
            iIOMetadataNode5.appendChild(iIOMetadataNode10);
        }
        if (this.cHRM_present) {
            IIOMetadataNode iIOMetadataNode11 = new IIOMetadataNode("cHRM");
            iIOMetadataNode11.setAttribute("whitePointX", Integer.toString(this.cHRM_whitePointX));
            iIOMetadataNode11.setAttribute("whitePointY", Integer.toString(this.cHRM_whitePointY));
            iIOMetadataNode11.setAttribute("redX", Integer.toString(this.cHRM_redX));
            iIOMetadataNode11.setAttribute("redY", Integer.toString(this.cHRM_redY));
            iIOMetadataNode11.setAttribute("greenX", Integer.toString(this.cHRM_greenX));
            iIOMetadataNode11.setAttribute("greenY", Integer.toString(this.cHRM_greenY));
            iIOMetadataNode11.setAttribute("blueX", Integer.toString(this.cHRM_blueX));
            iIOMetadataNode11.setAttribute("blueY", Integer.toString(this.cHRM_blueY));
            iIOMetadataNode5.appendChild(iIOMetadataNode11);
        }
        if (this.gAMA_present) {
            IIOMetadataNode iIOMetadataNode12 = new IIOMetadataNode("gAMA");
            iIOMetadataNode12.setAttribute("value", Integer.toString(this.gAMA_gamma));
            iIOMetadataNode5.appendChild(iIOMetadataNode12);
        }
        if (this.hIST_present) {
            Node iIOMetadataNode13 = new IIOMetadataNode("hIST");
            for (int i4 = 0; i4 < this.hIST_histogram.length; i4++) {
                IIOMetadataNode iIOMetadataNode14 = new IIOMetadataNode("hISTEntry");
                iIOMetadataNode14.setAttribute("index", Integer.toString(i4));
                iIOMetadataNode14.setAttribute("value", Integer.toString(this.hIST_histogram[i4]));
                iIOMetadataNode13.appendChild(iIOMetadataNode14);
            }
            iIOMetadataNode5.appendChild(iIOMetadataNode13);
        }
        if (this.iCCP_present) {
            IIOMetadataNode iIOMetadataNode15 = new IIOMetadataNode("iCCP");
            iIOMetadataNode15.setAttribute("profileName", this.iCCP_profileName);
            iIOMetadataNode15.setAttribute("compressionMethod", iCCP_compressionMethodNames[this.iCCP_compressionMethod]);
            Object objClone = this.iCCP_compressedProfile;
            if (objClone != null) {
                objClone = objClone.clone();
            }
            iIOMetadataNode15.setUserObject(objClone);
            iIOMetadataNode5.appendChild(iIOMetadataNode15);
        }
        if (this.iTXt_keyword.size() > 0) {
            Node iIOMetadataNode16 = new IIOMetadataNode("iTXt");
            int i5 = 0;
            while (i5 < this.iTXt_keyword.size()) {
                IIOMetadataNode iIOMetadataNode17 = new IIOMetadataNode("iTXtEntry");
                iIOMetadataNode17.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.iTXt_keyword.get(i5));
                IIOMetadataNode iIOMetadataNode18 = iIOMetadataNode9;
                iIOMetadataNode17.setAttribute("compressionFlag", this.iTXt_compressionFlag.get(i5).booleanValue() ? "TRUE" : "FALSE");
                iIOMetadataNode17.setAttribute("compressionMethod", this.iTXt_compressionMethod.get(i5).toString());
                iIOMetadataNode17.setAttribute("languageTag", this.iTXt_languageTag.get(i5));
                iIOMetadataNode17.setAttribute("translatedKeyword", this.iTXt_translatedKeyword.get(i5));
                iIOMetadataNode17.setAttribute("text", this.iTXt_text.get(i5));
                iIOMetadataNode16.appendChild(iIOMetadataNode17);
                i5++;
                iIOMetadataNode9 = iIOMetadataNode18;
            }
            iIOMetadataNode = iIOMetadataNode9;
            iIOMetadataNode5.appendChild(iIOMetadataNode16);
        } else {
            iIOMetadataNode = iIOMetadataNode9;
        }
        if (this.pHYs_present) {
            IIOMetadataNode iIOMetadataNode19 = new IIOMetadataNode("pHYs");
            iIOMetadataNode19.setAttribute("pixelsPerUnitXAxis", Integer.toString(this.pHYs_pixelsPerUnitXAxis));
            iIOMetadataNode19.setAttribute("pixelsPerUnitYAxis", Integer.toString(this.pHYs_pixelsPerUnitYAxis));
            iIOMetadataNode19.setAttribute("unitSpecifier", unitSpecifierNames[this.pHYs_unitSpecifier]);
            iIOMetadataNode5.appendChild(iIOMetadataNode19);
        }
        if (this.sBIT_present) {
            Node iIOMetadataNode20 = new IIOMetadataNode("sBIT");
            int i6 = this.sBIT_colorType;
            if (i6 == 0) {
                iIOMetadataNode2 = new IIOMetadataNode("sBIT_Grayscale");
                iIOMetadataNode2.setAttribute("gray", Integer.toString(this.sBIT_grayBits));
            } else if (i6 == 4) {
                iIOMetadataNode2 = new IIOMetadataNode("sBIT_GrayAlpha");
                iIOMetadataNode2.setAttribute("gray", Integer.toString(this.sBIT_grayBits));
                iIOMetadataNode2.setAttribute("alpha", Integer.toString(this.sBIT_alphaBits));
            } else if (i6 == 2) {
                iIOMetadataNode2 = new IIOMetadataNode("sBIT_RGB");
                iIOMetadataNode2.setAttribute("red", Integer.toString(this.sBIT_redBits));
                iIOMetadataNode2.setAttribute("green", Integer.toString(this.sBIT_greenBits));
                iIOMetadataNode2.setAttribute("blue", Integer.toString(this.sBIT_blueBits));
            } else if (i6 == 6) {
                iIOMetadataNode2 = new IIOMetadataNode("sBIT_RGBAlpha");
                iIOMetadataNode2.setAttribute("red", Integer.toString(this.sBIT_redBits));
                iIOMetadataNode2.setAttribute("green", Integer.toString(this.sBIT_greenBits));
                iIOMetadataNode2.setAttribute("blue", Integer.toString(this.sBIT_blueBits));
                iIOMetadataNode2.setAttribute("alpha", Integer.toString(this.sBIT_alphaBits));
            } else if (i6 == 3) {
                iIOMetadataNode2 = new IIOMetadataNode("sBIT_Palette");
                iIOMetadataNode2.setAttribute("red", Integer.toString(this.sBIT_redBits));
                iIOMetadataNode2.setAttribute("green", Integer.toString(this.sBIT_greenBits));
                iIOMetadataNode2.setAttribute("blue", Integer.toString(this.sBIT_blueBits));
            } else {
                iIOMetadataNode2 = iIOMetadataNode;
            }
            iIOMetadataNode20.appendChild(iIOMetadataNode2);
            iIOMetadataNode5.appendChild(iIOMetadataNode20);
        } else {
            iIOMetadataNode2 = iIOMetadataNode;
        }
        if (this.sPLT_present) {
            IIOMetadataNode iIOMetadataNode21 = new IIOMetadataNode("sPLT");
            iIOMetadataNode21.setAttribute("name", this.sPLT_paletteName);
            iIOMetadataNode21.setAttribute("sampleDepth", Integer.toString(this.sPLT_sampleDepth));
            int length2 = this.sPLT_red.length;
            int i7 = 0;
            while (i7 < length2) {
                int i8 = length2;
                IIOMetadataNode iIOMetadataNode22 = new IIOMetadataNode("sPLTEntry");
                iIOMetadataNode22.setAttribute("index", Integer.toString(i7));
                iIOMetadataNode22.setAttribute("red", Integer.toString(this.sPLT_red[i7]));
                iIOMetadataNode22.setAttribute("green", Integer.toString(this.sPLT_green[i7]));
                iIOMetadataNode22.setAttribute("blue", Integer.toString(this.sPLT_blue[i7]));
                iIOMetadataNode22.setAttribute("alpha", Integer.toString(this.sPLT_alpha[i7]));
                iIOMetadataNode22.setAttribute("frequency", Integer.toString(this.sPLT_frequency[i7]));
                iIOMetadataNode21.appendChild(iIOMetadataNode22);
                i7++;
                length2 = i8;
                iIOMetadataNode2 = iIOMetadataNode2;
            }
            iIOMetadataNode3 = iIOMetadataNode2;
            iIOMetadataNode5.appendChild(iIOMetadataNode21);
        } else {
            iIOMetadataNode3 = iIOMetadataNode2;
        }
        if (this.sRGB_present) {
            IIOMetadataNode iIOMetadataNode23 = new IIOMetadataNode("sRGB");
            iIOMetadataNode23.setAttribute("renderingIntent", renderingIntentNames[this.sRGB_renderingIntent]);
            iIOMetadataNode5.appendChild(iIOMetadataNode23);
        }
        if (this.tEXt_keyword.size() > 0) {
            Node iIOMetadataNode24 = new IIOMetadataNode("tEXt");
            for (int i9 = 0; i9 < this.tEXt_keyword.size(); i9++) {
                IIOMetadataNode iIOMetadataNode25 = new IIOMetadataNode("tEXtEntry");
                iIOMetadataNode25.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.tEXt_keyword.get(i9));
                iIOMetadataNode25.setAttribute("value", this.tEXt_text.get(i9));
                iIOMetadataNode24.appendChild(iIOMetadataNode25);
            }
            iIOMetadataNode5.appendChild(iIOMetadataNode24);
        }
        if (this.tIME_present) {
            IIOMetadataNode iIOMetadataNode26 = new IIOMetadataNode("tIME");
            iIOMetadataNode26.setAttribute("year", Integer.toString(this.tIME_year));
            iIOMetadataNode26.setAttribute("month", Integer.toString(this.tIME_month));
            iIOMetadataNode26.setAttribute("day", Integer.toString(this.tIME_day));
            iIOMetadataNode26.setAttribute("hour", Integer.toString(this.tIME_hour));
            iIOMetadataNode26.setAttribute("minute", Integer.toString(this.tIME_minute));
            iIOMetadataNode26.setAttribute("second", Integer.toString(this.tIME_second));
            iIOMetadataNode5.appendChild(iIOMetadataNode26);
        }
        if (this.tRNS_present) {
            IIOMetadataNode iIOMetadataNode27 = new IIOMetadataNode("tRNS");
            int i10 = this.tRNS_colorType;
            if (i10 == 3) {
                iIOMetadataNode4 = new IIOMetadataNode("tRNS_Palette");
                for (int i11 = 0; i11 < this.tRNS_alpha.length; i11++) {
                    IIOMetadataNode iIOMetadataNode28 = new IIOMetadataNode("tRNS_PaletteEntry");
                    iIOMetadataNode28.setAttribute("index", Integer.toString(i11));
                    iIOMetadataNode28.setAttribute("alpha", Integer.toString(this.tRNS_alpha[i11] & 255));
                    iIOMetadataNode4.appendChild(iIOMetadataNode28);
                }
            } else if (i10 == 0) {
                iIOMetadataNode4 = new IIOMetadataNode("tRNS_Grayscale");
                iIOMetadataNode4.setAttribute("gray", Integer.toString(this.tRNS_gray));
            } else if (i10 == 2) {
                iIOMetadataNode4 = new IIOMetadataNode("tRNS_RGB");
                iIOMetadataNode4.setAttribute("red", Integer.toString(this.tRNS_red));
                iIOMetadataNode4.setAttribute("green", Integer.toString(this.tRNS_green));
                iIOMetadataNode4.setAttribute("blue", Integer.toString(this.tRNS_blue));
            } else {
                iIOMetadataNode4 = iIOMetadataNode3;
            }
            iIOMetadataNode27.appendChild(iIOMetadataNode4);
            iIOMetadataNode5.appendChild(iIOMetadataNode27);
        }
        if (this.zTXt_keyword.size() > 0) {
            Node iIOMetadataNode29 = new IIOMetadataNode("zTXt");
            for (int i12 = 0; i12 < this.zTXt_keyword.size(); i12++) {
                IIOMetadataNode iIOMetadataNode30 = new IIOMetadataNode("zTXtEntry");
                iIOMetadataNode30.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.zTXt_keyword.get(i12));
                iIOMetadataNode30.setAttribute("compressionMethod", zTXt_compressionMethodNames[this.zTXt_compressionMethod.get(i12).intValue()]);
                iIOMetadataNode30.setAttribute("text", this.zTXt_text.get(i12));
                iIOMetadataNode29.appendChild(iIOMetadataNode30);
            }
            iIOMetadataNode5.appendChild(iIOMetadataNode29);
        }
        if (this.unknownChunkType.size() > 0) {
            Node iIOMetadataNode31 = new IIOMetadataNode("UnknownChunks");
            for (int i13 = 0; i13 < this.unknownChunkType.size(); i13++) {
                IIOMetadataNode iIOMetadataNode32 = new IIOMetadataNode("UnknownChunk");
                iIOMetadataNode32.setAttribute("type", this.unknownChunkType.get(i13));
                iIOMetadataNode32.setUserObject(this.unknownChunkData.get(i13));
                iIOMetadataNode31.appendChild(iIOMetadataNode32);
            }
            iIOMetadataNode5.appendChild(iIOMetadataNode31);
        }
        return iIOMetadataNode5;
    }

    private int getNumChannels() {
        int[] iArr = IHDR_numChannels;
        int i = this.IHDR_colorType;
        int i2 = iArr[i];
        if (i == 3 && this.tRNS_present && this.tRNS_colorType == i) {
            return 4;
        }
        return i2;
    }

    private String getStringAttribute(Node node, String str, String str2, boolean z) throws IIOInvalidTreeException {
        Node namedItem = node.getAttributes().getNamedItem(str);
        if (namedItem == null) {
            if (!z) {
                return str2;
            }
            fatal(node, AbstractC0541b.m773o("Required attribute ", str, " not present!"));
        }
        return namedItem.getNodeValue();
    }

    private boolean isISOLatin(String str, boolean z) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < ' ' || cCharAt > 255 || (cCharAt > '~' && cCharAt < 161)) && !(z && cCharAt == 16)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidKeyword(String str) {
        int length = str.length();
        if (length < 1 || length >= 80 || str.startsWith(" ") || str.endsWith(" ") || str.contains(Constant.WHITE_SPACE_FOR_LINK_ICON)) {
            return false;
        }
        return isISOLatin(str, false);
    }

    private void mergeNativeTree(Node node) throws IIOInvalidTreeException {
        Node node2;
        if (node.getNodeName().equals(nativeMetadataFormatName)) {
            node2 = node;
        } else {
            node2 = node;
            fatal(node2, "Root must be javax_imageio_png_1.0");
        }
        for (Node firstChild = node2.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            if (nodeName.equals("IHDR")) {
                this.IHDR_width = getIntAttribute(firstChild, "width");
                this.IHDR_height = getIntAttribute(firstChild, "height");
                String[] strArr = IHDR_bitDepths;
                this.IHDR_bitDepth = Integer.valueOf(strArr[getEnumeratedAttribute(firstChild, "bitDepth", strArr)]).intValue();
                this.IHDR_colorType = getEnumeratedAttribute(firstChild, "colorType", IHDR_colorTypeNames);
                this.IHDR_compressionMethod = getEnumeratedAttribute(firstChild, "compressionMethod", IHDR_compressionMethodNames);
                this.IHDR_filterMethod = getEnumeratedAttribute(firstChild, "filterMethod", IHDR_filterMethodNames);
                this.IHDR_interlaceMethod = getEnumeratedAttribute(firstChild, "interlaceMethod", IHDR_interlaceMethodNames);
                this.IHDR_present = true;
            } else if (nodeName.equals("PLTE")) {
                byte[] bArr = new byte[256];
                byte[] bArr2 = new byte[256];
                byte[] bArr3 = new byte[256];
                Node firstChild2 = firstChild.getFirstChild();
                if (firstChild2 == null) {
                    fatal(firstChild, "Palette has no entries!");
                }
                int i = -1;
                while (firstChild2 != null) {
                    if (!firstChild2.getNodeName().equals("PLTEEntry")) {
                        fatal(firstChild, "Only a PLTEEntry may be a child of a PLTE!");
                    }
                    int intAttribute = getIntAttribute(firstChild2, "index");
                    if (intAttribute < 0 || intAttribute > 255) {
                        fatal(firstChild, "Bad value for PLTEEntry attribute index!");
                    }
                    if (intAttribute > i) {
                        i = intAttribute;
                    }
                    bArr[intAttribute] = (byte) getIntAttribute(firstChild2, "red");
                    bArr2[intAttribute] = (byte) getIntAttribute(firstChild2, "green");
                    bArr3[intAttribute] = (byte) getIntAttribute(firstChild2, "blue");
                    firstChild2 = firstChild2.getNextSibling();
                }
                int i2 = i + 1;
                byte[] bArr4 = new byte[i2];
                this.PLTE_red = bArr4;
                this.PLTE_green = new byte[i2];
                this.PLTE_blue = new byte[i2];
                System.arraycopy(bArr, 0, bArr4, 0, i2);
                System.arraycopy(bArr2, 0, this.PLTE_green, 0, i2);
                System.arraycopy(bArr3, 0, this.PLTE_blue, 0, i2);
                this.PLTE_present = true;
            } else if (nodeName.equals("bKGD")) {
                this.bKGD_present = false;
                Node firstChild3 = firstChild.getFirstChild();
                if (firstChild3 == null) {
                    fatal(firstChild, "bKGD node has no children!");
                }
                String nodeName2 = firstChild3.getNodeName();
                if (nodeName2.equals("bKGD_Palette")) {
                    this.bKGD_index = getIntAttribute(firstChild3, "index");
                    this.bKGD_colorType = 3;
                } else if (nodeName2.equals("bKGD_Grayscale")) {
                    this.bKGD_gray = getIntAttribute(firstChild3, "gray");
                    this.bKGD_colorType = 0;
                } else if (nodeName2.equals("bKGD_RGB")) {
                    this.bKGD_red = getIntAttribute(firstChild3, "red");
                    this.bKGD_green = getIntAttribute(firstChild3, "green");
                    this.bKGD_blue = getIntAttribute(firstChild3, "blue");
                    this.bKGD_colorType = 2;
                } else {
                    fatal(firstChild, "Bad child of a bKGD node!");
                }
                if (firstChild3.getNextSibling() != null) {
                    fatal(firstChild, "bKGD node has more than one child!");
                }
                this.bKGD_present = true;
            } else if (nodeName.equals("cHRM")) {
                this.cHRM_whitePointX = getIntAttribute(firstChild, "whitePointX");
                this.cHRM_whitePointY = getIntAttribute(firstChild, "whitePointY");
                this.cHRM_redX = getIntAttribute(firstChild, "redX");
                this.cHRM_redY = getIntAttribute(firstChild, "redY");
                this.cHRM_greenX = getIntAttribute(firstChild, "greenX");
                this.cHRM_greenY = getIntAttribute(firstChild, "greenY");
                this.cHRM_blueX = getIntAttribute(firstChild, "blueX");
                this.cHRM_blueY = getIntAttribute(firstChild, "blueY");
                this.cHRM_present = true;
            } else if (nodeName.equals("gAMA")) {
                this.gAMA_gamma = getIntAttribute(firstChild, "value");
                this.gAMA_present = true;
            } else if (nodeName.equals("hIST")) {
                char[] cArr = new char[256];
                Node firstChild4 = firstChild.getFirstChild();
                if (firstChild4 == null) {
                    fatal(firstChild, "hIST node has no children!");
                }
                int i4 = -1;
                while (firstChild4 != null) {
                    if (!firstChild4.getNodeName().equals("hISTEntry")) {
                        fatal(firstChild, "Only a hISTEntry may be a child of a hIST!");
                    }
                    int intAttribute2 = getIntAttribute(firstChild4, "index");
                    if (intAttribute2 < 0 || intAttribute2 > 255) {
                        fatal(firstChild, "Bad value for histEntry attribute index!");
                    }
                    if (intAttribute2 > i4) {
                        i4 = intAttribute2;
                    }
                    cArr[intAttribute2] = (char) getIntAttribute(firstChild4, "value");
                    firstChild4 = firstChild4.getNextSibling();
                }
                int i5 = i4 + 1;
                char[] cArr2 = new char[i5];
                this.hIST_histogram = cArr2;
                System.arraycopy(cArr, 0, cArr2, 0, i5);
                this.hIST_present = true;
            } else if (nodeName.equals("iCCP")) {
                this.iCCP_profileName = getAttribute(firstChild, "profileName");
                this.iCCP_compressionMethod = getEnumeratedAttribute(firstChild, "compressionMethod", iCCP_compressionMethodNames);
                Object userObject = ((IIOMetadataNode) firstChild).getUserObject();
                if (userObject == null) {
                    fatal(firstChild, "No ICCP profile present in user object!");
                }
                if (!(userObject instanceof byte[])) {
                    fatal(firstChild, "User object not a byte array!");
                }
                this.iCCP_compressedProfile = (byte[]) ((byte[]) userObject).clone();
                this.iCCP_present = true;
            } else if (nodeName.equals("iTXt")) {
                for (Node firstChild5 = firstChild.getFirstChild(); firstChild5 != null; firstChild5 = firstChild5.getNextSibling()) {
                    if (!firstChild5.getNodeName().equals("iTXtEntry")) {
                        fatal(firstChild, "Only an iTXtEntry may be a child of an iTXt!");
                    }
                    String attribute = getAttribute(firstChild5, Bixby2Constants.BIXBY_PARAM_KEYWORD);
                    if (isValidKeyword(attribute)) {
                        this.iTXt_keyword.add(attribute);
                        this.iTXt_compressionFlag.add(Boolean.valueOf(getBooleanAttribute(firstChild5, "compressionFlag")));
                        this.iTXt_compressionMethod.add(Integer.valueOf(getAttribute(firstChild5, "compressionMethod")));
                        this.iTXt_languageTag.add(getAttribute(firstChild5, "languageTag"));
                        this.iTXt_translatedKeyword.add(getAttribute(firstChild5, "translatedKeyword"));
                        this.iTXt_text.add(getAttribute(firstChild5, "text"));
                    }
                }
            } else if (nodeName.equals("pHYs")) {
                this.pHYs_pixelsPerUnitXAxis = getIntAttribute(firstChild, "pixelsPerUnitXAxis");
                this.pHYs_pixelsPerUnitYAxis = getIntAttribute(firstChild, "pixelsPerUnitYAxis");
                this.pHYs_unitSpecifier = getEnumeratedAttribute(firstChild, "unitSpecifier", unitSpecifierNames);
                this.pHYs_present = true;
            } else if (nodeName.equals("sBIT")) {
                this.sBIT_present = false;
                Node firstChild6 = firstChild.getFirstChild();
                if (firstChild6 == null) {
                    fatal(firstChild, "sBIT node has no children!");
                }
                String nodeName3 = firstChild6.getNodeName();
                if (nodeName3.equals("sBIT_Grayscale")) {
                    this.sBIT_grayBits = getIntAttribute(firstChild6, "gray");
                    this.sBIT_colorType = 0;
                } else if (nodeName3.equals("sBIT_GrayAlpha")) {
                    this.sBIT_grayBits = getIntAttribute(firstChild6, "gray");
                    this.sBIT_alphaBits = getIntAttribute(firstChild6, "alpha");
                    this.sBIT_colorType = 4;
                } else if (nodeName3.equals("sBIT_RGB")) {
                    this.sBIT_redBits = getIntAttribute(firstChild6, "red");
                    this.sBIT_greenBits = getIntAttribute(firstChild6, "green");
                    this.sBIT_blueBits = getIntAttribute(firstChild6, "blue");
                    this.sBIT_colorType = 2;
                } else if (nodeName3.equals("sBIT_RGBAlpha")) {
                    this.sBIT_redBits = getIntAttribute(firstChild6, "red");
                    this.sBIT_greenBits = getIntAttribute(firstChild6, "green");
                    this.sBIT_blueBits = getIntAttribute(firstChild6, "blue");
                    this.sBIT_alphaBits = getIntAttribute(firstChild6, "alpha");
                    this.sBIT_colorType = 6;
                } else if (nodeName3.equals("sBIT_Palette")) {
                    this.sBIT_redBits = getIntAttribute(firstChild6, "red");
                    this.sBIT_greenBits = getIntAttribute(firstChild6, "green");
                    this.sBIT_blueBits = getIntAttribute(firstChild6, "blue");
                    this.sBIT_colorType = 3;
                } else {
                    fatal(firstChild, "Bad child of an sBIT node!");
                }
                if (firstChild6.getNextSibling() != null) {
                    fatal(firstChild, "sBIT node has more than one child!");
                }
                this.sBIT_present = true;
            } else if (nodeName.equals("sPLT")) {
                this.sPLT_paletteName = getAttribute(firstChild, "name");
                this.sPLT_sampleDepth = getIntAttribute(firstChild, "sampleDepth");
                int[] iArr = new int[256];
                int[] iArr2 = new int[256];
                int[] iArr3 = new int[256];
                int[] iArr4 = new int[256];
                int[] iArr5 = new int[256];
                Node firstChild7 = firstChild.getFirstChild();
                if (firstChild7 == null) {
                    fatal(firstChild, "sPLT node has no children!");
                }
                int i6 = -1;
                while (firstChild7 != null) {
                    int[] iArr6 = iArr5;
                    if (!firstChild7.getNodeName().equals("sPLTEntry")) {
                        fatal(firstChild, "Only an sPLTEntry may be a child of an sPLT!");
                    }
                    int intAttribute3 = getIntAttribute(firstChild7, "index");
                    if (intAttribute3 < 0 || intAttribute3 > 255) {
                        fatal(firstChild, "Bad value for PLTEEntry attribute index!");
                    }
                    if (intAttribute3 > i6) {
                        i6 = intAttribute3;
                    }
                    iArr[intAttribute3] = getIntAttribute(firstChild7, "red");
                    iArr2[intAttribute3] = getIntAttribute(firstChild7, "green");
                    iArr3[intAttribute3] = getIntAttribute(firstChild7, "blue");
                    iArr4[intAttribute3] = getIntAttribute(firstChild7, "alpha");
                    iArr6[intAttribute3] = getIntAttribute(firstChild7, "frequency");
                    firstChild7 = firstChild7.getNextSibling();
                    iArr5 = iArr6;
                }
                int[] iArr7 = iArr5;
                int i7 = i6 + 1;
                int[] iArr8 = new int[i7];
                this.sPLT_red = iArr8;
                this.sPLT_green = new int[i7];
                this.sPLT_blue = new int[i7];
                this.sPLT_alpha = new int[i7];
                this.sPLT_frequency = new int[i7];
                System.arraycopy(iArr, 0, iArr8, 0, i7);
                System.arraycopy(iArr2, 0, this.sPLT_green, 0, i7);
                System.arraycopy(iArr3, 0, this.sPLT_blue, 0, i7);
                System.arraycopy(iArr4, 0, this.sPLT_alpha, 0, i7);
                System.arraycopy(iArr7, 0, this.sPLT_frequency, 0, i7);
                this.sPLT_present = true;
            } else if (nodeName.equals("sRGB")) {
                this.sRGB_renderingIntent = getEnumeratedAttribute(firstChild, "renderingIntent", renderingIntentNames);
                this.sRGB_present = true;
            } else if (nodeName.equals("tEXt")) {
                for (Node firstChild8 = firstChild.getFirstChild(); firstChild8 != null; firstChild8 = firstChild8.getNextSibling()) {
                    if (!firstChild8.getNodeName().equals("tEXtEntry")) {
                        fatal(firstChild, "Only an tEXtEntry may be a child of an tEXt!");
                    }
                    this.tEXt_keyword.add(getAttribute(firstChild8, Bixby2Constants.BIXBY_PARAM_KEYWORD));
                    this.tEXt_text.add(getAttribute(firstChild8, "value"));
                }
            } else if (nodeName.equals("tIME")) {
                this.tIME_year = getIntAttribute(firstChild, "year");
                this.tIME_month = getIntAttribute(firstChild, "month");
                this.tIME_day = getIntAttribute(firstChild, "day");
                this.tIME_hour = getIntAttribute(firstChild, "hour");
                this.tIME_minute = getIntAttribute(firstChild, "minute");
                this.tIME_second = getIntAttribute(firstChild, "second");
                this.tIME_present = true;
            } else if (nodeName.equals("tRNS")) {
                this.tRNS_present = false;
                Node firstChild9 = firstChild.getFirstChild();
                if (firstChild9 == null) {
                    fatal(firstChild, "tRNS node has no children!");
                }
                String nodeName4 = firstChild9.getNodeName();
                if (nodeName4.equals("tRNS_Palette")) {
                    byte[] bArr5 = new byte[256];
                    Node firstChild10 = firstChild9.getFirstChild();
                    if (firstChild10 == null) {
                        fatal(firstChild, "tRNS_Palette node has no children!");
                    }
                    int i8 = -1;
                    while (firstChild10 != null) {
                        if (!firstChild10.getNodeName().equals("tRNS_PaletteEntry")) {
                            fatal(firstChild, "Only a tRNS_PaletteEntry may be a child of a tRNS_Palette!");
                        }
                        int intAttribute4 = getIntAttribute(firstChild10, "index");
                        if (intAttribute4 < 0 || intAttribute4 > 255) {
                            fatal(firstChild, "Bad value for tRNS_PaletteEntry attribute index!");
                        }
                        if (intAttribute4 > i8) {
                            i8 = intAttribute4;
                        }
                        bArr5[intAttribute4] = (byte) getIntAttribute(firstChild10, "alpha");
                        firstChild10 = firstChild10.getNextSibling();
                    }
                    int i9 = i8 + 1;
                    byte[] bArr6 = new byte[i9];
                    this.tRNS_alpha = bArr6;
                    this.tRNS_colorType = 3;
                    System.arraycopy(bArr5, 0, bArr6, 0, i9);
                } else if (nodeName4.equals("tRNS_Grayscale")) {
                    this.tRNS_gray = getIntAttribute(firstChild9, "gray");
                    this.tRNS_colorType = 0;
                } else if (nodeName4.equals("tRNS_RGB")) {
                    this.tRNS_red = getIntAttribute(firstChild9, "red");
                    this.tRNS_green = getIntAttribute(firstChild9, "green");
                    this.tRNS_blue = getIntAttribute(firstChild9, "blue");
                    this.tRNS_colorType = 2;
                } else {
                    fatal(firstChild, "Bad child of a tRNS node!");
                }
                if (firstChild9.getNextSibling() != null) {
                    fatal(firstChild, "tRNS node has more than one child!");
                }
                this.tRNS_present = true;
            } else if (nodeName.equals("zTXt")) {
                for (Node firstChild11 = firstChild.getFirstChild(); firstChild11 != null; firstChild11 = firstChild11.getNextSibling()) {
                    if (!firstChild11.getNodeName().equals("zTXtEntry")) {
                        fatal(firstChild, "Only an zTXtEntry may be a child of an zTXt!");
                    }
                    this.zTXt_keyword.add(getAttribute(firstChild11, Bixby2Constants.BIXBY_PARAM_KEYWORD));
                    this.zTXt_compressionMethod.add(new Integer(getEnumeratedAttribute(firstChild11, "compressionMethod", zTXt_compressionMethodNames)));
                    this.zTXt_text.add(getAttribute(firstChild11, "text"));
                }
            } else if (nodeName.equals("UnknownChunks")) {
                for (Node firstChild12 = firstChild.getFirstChild(); firstChild12 != null; firstChild12 = firstChild12.getNextSibling()) {
                    if (!firstChild12.getNodeName().equals("UnknownChunk")) {
                        fatal(firstChild, "Only an UnknownChunk may be a child of an UnknownChunks!");
                    }
                    String attribute2 = getAttribute(firstChild12, "type");
                    Object userObject2 = ((IIOMetadataNode) firstChild12).getUserObject();
                    if (attribute2.length() != 4) {
                        fatal(firstChild12, "Chunk type must be 4 characters!");
                    }
                    if (userObject2 == null) {
                        fatal(firstChild12, "No chunk data present in user object!");
                    }
                    if (!(userObject2 instanceof byte[])) {
                        fatal(firstChild12, "User object not a byte array!");
                    }
                    this.unknownChunkType.add(attribute2);
                    this.unknownChunkData.add((byte[]) ((byte[]) userObject2).clone());
                }
            } else {
                fatal(firstChild, "Unknown child of root node!");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0333  */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v27, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void mergeStandardTree(Node node) throws IIOInvalidTreeException {
        Node node2;
        ?? r6;
        if (node.getNodeName().equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            node2 = node;
        } else {
            node2 = node;
            fatal(node2, "Root must be javax_imageio_1.0");
        }
        for (Node firstChild = node2.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            String nodeName = firstChild.getNodeName();
            boolean z = true;
            if (nodeName.equals("Chroma")) {
                Node firstChild2 = firstChild.getFirstChild();
                while (firstChild2 != null) {
                    String nodeName2 = firstChild2.getNodeName();
                    if (nodeName2.equals(ExifInterface.TAG_GAMMA)) {
                        float floatAttribute = getFloatAttribute(firstChild2, "value");
                        this.gAMA_present = z;
                        this.gAMA_gamma = (int) (((double) (floatAttribute * 100000.0f)) + 0.5d);
                    } else if (nodeName2.equals("Palette")) {
                        byte[] bArr = new byte[256];
                        byte[] bArr2 = new byte[256];
                        byte[] bArr3 = new byte[256];
                        int i = -1;
                        for (Node firstChild3 = firstChild2.getFirstChild(); firstChild3 != null; firstChild3 = firstChild3.getNextSibling()) {
                            int intAttribute = getIntAttribute(firstChild3, "index");
                            if (intAttribute >= 0 && intAttribute <= 255) {
                                bArr[intAttribute] = (byte) getIntAttribute(firstChild3, "red");
                                bArr2[intAttribute] = (byte) getIntAttribute(firstChild3, "green");
                                bArr3[intAttribute] = (byte) getIntAttribute(firstChild3, "blue");
                                if (intAttribute > i) {
                                    i = intAttribute;
                                }
                            }
                        }
                        int i2 = i + 1;
                        byte[] bArr4 = new byte[i2];
                        this.PLTE_red = bArr4;
                        this.PLTE_green = new byte[i2];
                        this.PLTE_blue = new byte[i2];
                        System.arraycopy(bArr, 0, bArr4, 0, i2);
                        System.arraycopy(bArr2, 0, this.PLTE_green, 0, i2);
                        System.arraycopy(bArr3, 0, this.PLTE_blue, 0, i2);
                        this.PLTE_present = true;
                    } else {
                        boolean z2 = z;
                        if (nodeName2.equals("BackgroundIndex")) {
                            this.bKGD_present = z2;
                            this.bKGD_colorType = 3;
                            this.bKGD_index = getIntAttribute(firstChild2, "value");
                        } else if (nodeName2.equals("BackgroundColor")) {
                            int intAttribute2 = getIntAttribute(firstChild2, "red");
                            int intAttribute3 = getIntAttribute(firstChild2, "green");
                            int intAttribute4 = getIntAttribute(firstChild2, "blue");
                            if (intAttribute2 == intAttribute3 && intAttribute2 == intAttribute4) {
                                this.bKGD_colorType = 0;
                                this.bKGD_gray = intAttribute2;
                            } else {
                                this.bKGD_red = intAttribute2;
                                this.bKGD_green = intAttribute3;
                                this.bKGD_blue = intAttribute4;
                            }
                            this.bKGD_present = true;
                        }
                    }
                    firstChild2 = firstChild2.getNextSibling();
                    z = true;
                }
            } else if (nodeName.equals(ExifInterface.TAG_COMPRESSION)) {
                for (Node firstChild4 = firstChild.getFirstChild(); firstChild4 != null; firstChild4 = firstChild4.getNextSibling()) {
                    if (firstChild4.getNodeName().equals("NumProgressiveScans")) {
                        this.IHDR_interlaceMethod = getIntAttribute(firstChild4, "value") > 1 ? 1 : 0;
                    }
                }
            } else if (nodeName.equals("Data")) {
                for (Node firstChild5 = firstChild.getFirstChild(); firstChild5 != null; firstChild5 = firstChild5.getNextSibling()) {
                    String nodeName3 = firstChild5.getNodeName();
                    if (nodeName3.equals(ExifInterface.TAG_BITS_PER_SAMPLE)) {
                        StringTokenizer stringTokenizer = new StringTokenizer(getAttribute(firstChild5, "value"));
                        int i4 = -1;
                        while (stringTokenizer.hasMoreTokens()) {
                            int i5 = Integer.parseInt(stringTokenizer.nextToken());
                            if (i5 > i4) {
                                i4 = i5;
                            }
                        }
                        if (i4 < 1) {
                            i4 = 1;
                        }
                        if (i4 == 3) {
                            i4 = 4;
                        }
                        if (i4 > 4 || i4 < 8) {
                            i4 = 8;
                        }
                        if (i4 > 8) {
                            i4 = 16;
                        }
                        this.IHDR_bitDepth = i4;
                    } else {
                        if (nodeName3.equals("SignificantBitsPerSample")) {
                            StringTokenizer stringTokenizer2 = new StringTokenizer(getAttribute(firstChild5, "value"));
                            int iCountTokens = stringTokenizer2.countTokens();
                            if (iCountTokens == 1) {
                                this.sBIT_colorType = 0;
                                this.sBIT_grayBits = Integer.parseInt(stringTokenizer2.nextToken());
                            } else if (iCountTokens == 2) {
                                this.sBIT_colorType = 4;
                                this.sBIT_grayBits = Integer.parseInt(stringTokenizer2.nextToken());
                                this.sBIT_alphaBits = Integer.parseInt(stringTokenizer2.nextToken());
                            } else {
                                if (iCountTokens == 3) {
                                    this.sBIT_colorType = 2;
                                    this.sBIT_redBits = Integer.parseInt(stringTokenizer2.nextToken());
                                    this.sBIT_greenBits = Integer.parseInt(stringTokenizer2.nextToken());
                                    this.sBIT_blueBits = Integer.parseInt(stringTokenizer2.nextToken());
                                } else if (iCountTokens == 4) {
                                    this.sBIT_colorType = 6;
                                    this.sBIT_redBits = Integer.parseInt(stringTokenizer2.nextToken());
                                    this.sBIT_greenBits = Integer.parseInt(stringTokenizer2.nextToken());
                                    this.sBIT_blueBits = Integer.parseInt(stringTokenizer2.nextToken());
                                    this.sBIT_alphaBits = Integer.parseInt(stringTokenizer2.nextToken());
                                }
                                r6 = 1;
                                if (iCountTokens < r6 && iCountTokens <= 4) {
                                    this.sBIT_present = r6;
                                }
                            }
                            r6 = 1;
                            if (iCountTokens < r6) {
                            }
                        }
                    }
                }
            } else if (nodeName.equals("Dimension")) {
                float floatAttribute2 = -1.0f;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                float floatAttribute3 = -1.0f;
                float floatAttribute4 = -1.0f;
                for (Node firstChild6 = firstChild.getFirstChild(); firstChild6 != null; firstChild6 = firstChild6.getNextSibling()) {
                    String nodeName4 = firstChild6.getNodeName();
                    if (nodeName4.equals("PixelAspectRatio")) {
                        floatAttribute4 = getFloatAttribute(firstChild6, "value");
                        z5 = true;
                    } else if (nodeName4.equals("HorizontalPixelSize")) {
                        floatAttribute2 = getFloatAttribute(firstChild6, "value");
                        z3 = true;
                    } else if (nodeName4.equals("VerticalPixelSize")) {
                        floatAttribute3 = getFloatAttribute(firstChild6, "value");
                        z4 = true;
                    }
                }
                if (z3 && z4) {
                    this.pHYs_present = true;
                    this.pHYs_unitSpecifier = 1;
                    this.pHYs_pixelsPerUnitXAxis = (int) ((floatAttribute2 * 1000.0f) + 0.5f);
                    this.pHYs_pixelsPerUnitYAxis = (int) ((floatAttribute3 * 1000.0f) + 0.5f);
                } else if (z5) {
                    this.pHYs_present = true;
                    this.pHYs_unitSpecifier = 0;
                    int i6 = 1;
                    while (i6 < 100 && Math.abs((((int) (i6 * floatAttribute4)) / i6) - floatAttribute4) >= 0.001d) {
                        i6++;
                    }
                    this.pHYs_pixelsPerUnitXAxis = (int) (floatAttribute4 * i6);
                    this.pHYs_pixelsPerUnitYAxis = i6;
                }
            } else if (nodeName.equals("Document")) {
                for (Node firstChild7 = firstChild.getFirstChild(); firstChild7 != null; firstChild7 = firstChild7.getNextSibling()) {
                    if (firstChild7.getNodeName().equals("ImageModificationTime")) {
                        this.tIME_present = true;
                        this.tIME_year = getIntAttribute(firstChild7, "year");
                        this.tIME_month = getIntAttribute(firstChild7, "month");
                        this.tIME_day = getIntAttribute(firstChild7, "day");
                        this.tIME_hour = getIntAttribute(firstChild7, "hour", 0, false);
                        this.tIME_minute = getIntAttribute(firstChild7, "minute", 0, false);
                        this.tIME_second = getIntAttribute(firstChild7, "second", 0, false);
                    }
                }
            } else if (nodeName.equals(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT)) {
                for (Node firstChild8 = firstChild.getFirstChild(); firstChild8 != null; firstChild8 = firstChild8.getNextSibling()) {
                    if (firstChild8.getNodeName().equals("TextEntry")) {
                        String attribute = getAttribute(firstChild8, Bixby2Constants.BIXBY_PARAM_KEYWORD, "", false);
                        String attribute2 = getAttribute(firstChild8, "value");
                        String attribute3 = getAttribute(firstChild8, "language", "", false);
                        String attribute4 = getAttribute(firstChild8, "compression", "none", false);
                        if (isValidKeyword(attribute)) {
                            if (!isISOLatin(attribute2, true)) {
                                this.iTXt_keyword.add(attribute);
                                this.iTXt_compressionFlag.add(Boolean.valueOf(attribute4.equals("zip")));
                                this.iTXt_compressionMethod.add(0);
                                this.iTXt_languageTag.add(attribute3);
                                this.iTXt_translatedKeyword.add(attribute);
                                this.iTXt_text.add(attribute2);
                            } else if (attribute4.equals("zip")) {
                                this.zTXt_keyword.add(attribute);
                                this.zTXt_text.add(attribute2);
                                this.zTXt_compressionMethod.add(0);
                            } else {
                                this.tEXt_keyword.add(attribute);
                                this.tEXt_text.add(attribute2);
                            }
                        }
                    }
                }
            }
        }
    }

    private String repeat(String str, int i) {
        if (i == 1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(((str.length() + 1) * i) - 1);
        stringBuffer.append(str);
        for (int i2 = 1; i2 < i; i2++) {
            stringBuffer.append(" ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            PNGMetadata pNGMetadata = (PNGMetadata) super.clone();
            pNGMetadata.unknownChunkData = cloneBytesArrayList(this.unknownChunkData);
            return pNGMetadata;
        } catch (CloneNotSupportedException unused) {
            return null;
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
        IIOMetadataNode iIOMetadataNode;
        int i;
        int i2;
        int i4;
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Chroma");
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("ColorSpaceType");
        iIOMetadataNode3.setAttribute("name", colorSpaceTypeNames[this.IHDR_colorType]);
        iIOMetadataNode2.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("NumChannels");
        iIOMetadataNode4.setAttribute("value", Integer.toString(getNumChannels()));
        iIOMetadataNode2.appendChild(iIOMetadataNode4);
        if (this.gAMA_present) {
            IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode(ExifInterface.TAG_GAMMA);
            iIOMetadataNode5.setAttribute("value", Float.toString(this.gAMA_gamma * 1.0E-5f));
            iIOMetadataNode2.appendChild(iIOMetadataNode5);
        }
        IIOMetadataNode iIOMetadataNode6 = new IIOMetadataNode("BlackIsZero");
        iIOMetadataNode6.setAttribute("value", "TRUE");
        iIOMetadataNode2.appendChild(iIOMetadataNode6);
        if (this.PLTE_present) {
            int i5 = 0;
            boolean z = this.tRNS_present && this.tRNS_colorType == 3;
            Node iIOMetadataNode7 = new IIOMetadataNode("Palette");
            while (i5 < this.PLTE_red.length) {
                IIOMetadataNode iIOMetadataNode8 = new IIOMetadataNode("PaletteEntry");
                iIOMetadataNode8.setAttribute("index", Integer.toString(i5));
                iIOMetadataNode8.setAttribute("red", Integer.toString(this.PLTE_red[i5] & 255));
                iIOMetadataNode8.setAttribute("green", Integer.toString(this.PLTE_green[i5] & 255));
                iIOMetadataNode8.setAttribute("blue", Integer.toString(this.PLTE_blue[i5] & 255));
                if (z) {
                    byte[] bArr = this.tRNS_alpha;
                    iIOMetadataNode8.setAttribute("alpha", Integer.toString(i5 < bArr.length ? 255 & bArr[i5] : 255));
                }
                iIOMetadataNode7.appendChild(iIOMetadataNode8);
                i5++;
            }
            iIOMetadataNode2.appendChild(iIOMetadataNode7);
        }
        if (this.bKGD_present) {
            if (this.bKGD_colorType == 3) {
                iIOMetadataNode = new IIOMetadataNode("BackgroundIndex");
                iIOMetadataNode.setAttribute("value", Integer.toString(this.bKGD_index));
            } else {
                iIOMetadataNode = new IIOMetadataNode("BackgroundColor");
                if (this.bKGD_colorType == 0) {
                    i = this.bKGD_gray;
                    i2 = i;
                    i4 = i2;
                } else {
                    i = this.bKGD_red;
                    i2 = this.bKGD_green;
                    i4 = this.bKGD_blue;
                }
                iIOMetadataNode.setAttribute("red", Integer.toString(i));
                iIOMetadataNode.setAttribute("green", Integer.toString(i2));
                iIOMetadataNode.setAttribute("blue", Integer.toString(i4));
            }
            iIOMetadataNode2.appendChild(iIOMetadataNode);
        }
        return iIOMetadataNode2;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardCompressionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(ExifInterface.TAG_COMPRESSION);
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("CompressionTypeName");
        iIOMetadataNode2.setAttribute("value", "deflate");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("Lossless");
        iIOMetadataNode3.setAttribute("value", "TRUE");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("NumProgressiveScans");
        iIOMetadataNode4.setAttribute("value", this.IHDR_interlaceMethod == 0 ? "1" : "7");
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDataNode() {
        String string;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Data");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode(ExifInterface.TAG_PLANAR_CONFIGURATION);
        iIOMetadataNode2.setAttribute("value", "PixelInterleaved");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("SampleFormat");
        iIOMetadataNode3.setAttribute("value", this.IHDR_colorType == 3 ? Bixby2Constants.BIXBY_PARAM_INDEX : "UnsignedIntegral");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        String string2 = Integer.toString(this.IHDR_bitDepth);
        IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode(ExifInterface.TAG_BITS_PER_SAMPLE);
        iIOMetadataNode4.setAttribute("value", repeat(string2, getNumChannels()));
        iIOMetadataNode.appendChild(iIOMetadataNode4);
        if (this.sBIT_present) {
            IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("SignificantBitsPerSample");
            int i = this.sBIT_colorType;
            if (i == 0 || i == 4) {
                string = Integer.toString(this.sBIT_grayBits);
            } else {
                string = Integer.toString(this.sBIT_redBits) + " " + Integer.toString(this.sBIT_greenBits) + " " + Integer.toString(this.sBIT_blueBits);
            }
            int i2 = this.sBIT_colorType;
            if (i2 == 4 || i2 == 6) {
                StringBuilder sbM781w = AbstractC0541b.m781w(string, " ");
                sbM781w.append(Integer.toString(this.sBIT_alphaBits));
                string = sbM781w.toString();
            }
            iIOMetadataNode5.setAttribute("value", string);
            iIOMetadataNode.appendChild(iIOMetadataNode5);
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDimensionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Dimension");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("PixelAspectRatio");
        iIOMetadataNode2.setAttribute("value", Float.toString(this.pHYs_present ? this.pHYs_pixelsPerUnitXAxis / this.pHYs_pixelsPerUnitYAxis : 1.0f));
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("ImageOrientation");
        iIOMetadataNode3.setAttribute("value", "Normal");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        if (this.pHYs_present && this.pHYs_unitSpecifier == 1) {
            IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("HorizontalPixelSize");
            iIOMetadataNode4.setAttribute("value", Float.toString(1000.0f / this.pHYs_pixelsPerUnitXAxis));
            iIOMetadataNode.appendChild(iIOMetadataNode4);
            IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("VerticalPixelSize");
            iIOMetadataNode5.setAttribute("value", Float.toString(1000.0f / this.pHYs_pixelsPerUnitYAxis));
            iIOMetadataNode.appendChild(iIOMetadataNode5);
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDocumentNode() {
        if (!this.tIME_present) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Document");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ImageModificationTime");
        iIOMetadataNode2.setAttribute("year", Integer.toString(this.tIME_year));
        iIOMetadataNode2.setAttribute("month", Integer.toString(this.tIME_month));
        iIOMetadataNode2.setAttribute("day", Integer.toString(this.tIME_day));
        iIOMetadataNode2.setAttribute("hour", Integer.toString(this.tIME_hour));
        iIOMetadataNode2.setAttribute("minute", Integer.toString(this.tIME_minute));
        iIOMetadataNode2.setAttribute("second", Integer.toString(this.tIME_second));
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTextNode() {
        if (this.zTXt_keyword.size() + this.iTXt_keyword.size() + this.tEXt_keyword.size() == 0) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT);
        for (int i = 0; i < this.tEXt_keyword.size(); i++) {
            IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("TextEntry");
            iIOMetadataNode2.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.tEXt_keyword.get(i));
            iIOMetadataNode2.setAttribute("value", this.tEXt_text.get(i));
            iIOMetadataNode2.setAttribute(XMLWriter.ENCODING, "ISO-8859-1");
            iIOMetadataNode2.setAttribute("compression", "none");
            iIOMetadataNode.appendChild(iIOMetadataNode2);
        }
        for (int i2 = 0; i2 < this.iTXt_keyword.size(); i2++) {
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("TextEntry");
            iIOMetadataNode3.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.iTXt_keyword.get(i2));
            iIOMetadataNode3.setAttribute("value", this.iTXt_text.get(i2));
            iIOMetadataNode3.setAttribute("language", this.iTXt_languageTag.get(i2));
            if (this.iTXt_compressionFlag.get(i2).booleanValue()) {
                iIOMetadataNode3.setAttribute("compression", "zip");
            } else {
                iIOMetadataNode3.setAttribute("compression", "none");
            }
            iIOMetadataNode.appendChild(iIOMetadataNode3);
        }
        for (int i4 = 0; i4 < this.zTXt_keyword.size(); i4++) {
            IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("TextEntry");
            iIOMetadataNode4.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, this.zTXt_keyword.get(i4));
            iIOMetadataNode4.setAttribute("value", this.zTXt_text.get(i4));
            iIOMetadataNode4.setAttribute("compression", "zip");
            iIOMetadataNode.appendChild(iIOMetadataNode4);
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTransparencyNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Transparency");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Alpha");
        int i = this.IHDR_colorType;
        iIOMetadataNode2.setAttribute("value", i == 6 || i == 4 || (i == 3 && this.tRNS_present && this.tRNS_colorType == i && this.tRNS_alpha != null) ? "nonpremultipled" : "none");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        if (this.tRNS_present) {
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("TransparentColor");
            int i2 = this.tRNS_colorType;
            if (i2 == 2) {
                iIOMetadataNode3.setAttribute("value", Integer.toString(this.tRNS_red) + " " + Integer.toString(this.tRNS_green) + " " + Integer.toString(this.tRNS_blue));
            } else if (i2 == 0) {
                iIOMetadataNode3.setAttribute("value", Integer.toString(this.tRNS_gray));
            }
            iIOMetadataNode.appendChild(iIOMetadataNode3);
        }
        return iIOMetadataNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initialize(ImageTypeSpecifier imageTypeSpecifier, int i) {
        boolean z;
        boolean zHasAlpha;
        byte[] bArr;
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        int[] sampleSize = imageTypeSpecifier.getSampleModel().getSampleSize();
        int i2 = sampleSize[0];
        for (int i4 = 1; i4 < sampleSize.length; i4++) {
            int i5 = sampleSize[i4];
            if (i5 > i2) {
                i2 = i5;
            }
        }
        if (sampleSize.length > 1 && i2 < 8) {
            i2 = 8;
        }
        if (i2 > 2 && i2 < 4) {
            i2 = 4;
        } else if (i2 > 4 && i2 < 8) {
            i2 = 8;
        } else if (i2 > 8 && i2 < 16) {
            i2 = 16;
        } else if (i2 > 16) {
            throw new RuntimeException("bitDepth > 16!");
        }
        this.IHDR_bitDepth = i2;
        if (colorModel instanceof IndexColorModel) {
            IndexColorModel indexColorModel = (IndexColorModel) colorModel;
            int mapSize = indexColorModel.getMapSize();
            byte[] bArr2 = new byte[mapSize];
            indexColorModel.getReds(bArr2);
            byte[] bArr3 = new byte[mapSize];
            indexColorModel.getGreens(bArr3);
            byte[] bArr4 = new byte[mapSize];
            indexColorModel.getBlues(bArr4);
            if (this.IHDR_present && this.IHDR_colorType == 3) {
                z = false;
                zHasAlpha = colorModel.hasAlpha();
                if (zHasAlpha) {
                }
                if (!z) {
                    if (z) {
                        this.IHDR_colorType = 3;
                        this.PLTE_present = true;
                        this.PLTE_order = null;
                        this.PLTE_red = (byte[]) bArr2.clone();
                        this.PLTE_green = (byte[]) bArr3.clone();
                        this.PLTE_blue = (byte[]) bArr4.clone();
                        if (zHasAlpha) {
                        }
                    }
                }
            } else {
                int i6 = 255 / ((1 << this.IHDR_bitDepth) - 1);
                for (int i7 = 0; i7 < mapSize; i7++) {
                    byte b = bArr2[i7];
                    if (b != ((byte) (i7 * i6)) || b != bArr3[i7] || b != bArr4[i7]) {
                        z = false;
                        break;
                    }
                }
                z = true;
                zHasAlpha = colorModel.hasAlpha();
                if (zHasAlpha) {
                    bArr = null;
                } else {
                    bArr = new byte[mapSize];
                    indexColorModel.getAlphas(bArr);
                }
                if (!z && zHasAlpha && (i2 == 8 || i2 == 16)) {
                    this.IHDR_colorType = 4;
                } else if (z || zHasAlpha) {
                    this.IHDR_colorType = 3;
                    this.PLTE_present = true;
                    this.PLTE_order = null;
                    this.PLTE_red = (byte[]) bArr2.clone();
                    this.PLTE_green = (byte[]) bArr3.clone();
                    this.PLTE_blue = (byte[]) bArr4.clone();
                    if (zHasAlpha) {
                        this.tRNS_present = true;
                        this.tRNS_colorType = 3;
                        this.PLTE_order = new int[bArr.length];
                        byte[] bArr5 = new byte[bArr.length];
                        int i8 = 0;
                        for (int i9 = 0; i9 < bArr.length; i9++) {
                            byte b5 = bArr[i9];
                            if (b5 != -1) {
                                this.PLTE_order[i9] = i8;
                                bArr5[i8] = b5;
                                i8++;
                            }
                        }
                        int i10 = i8;
                        for (int i11 = 0; i11 < bArr.length; i11++) {
                            if (bArr[i11] == -1) {
                                this.PLTE_order[i11] = i10;
                                i10++;
                            }
                        }
                        byte[] bArr6 = this.PLTE_red;
                        byte[] bArr7 = this.PLTE_green;
                        byte[] bArr8 = this.PLTE_blue;
                        int length = bArr6.length;
                        this.PLTE_red = new byte[length];
                        this.PLTE_green = new byte[length];
                        this.PLTE_blue = new byte[length];
                        for (int i12 = 0; i12 < length; i12++) {
                            byte[] bArr9 = this.PLTE_red;
                            int i13 = this.PLTE_order[i12];
                            bArr9[i13] = bArr6[i12];
                            this.PLTE_green[i13] = bArr7[i12];
                            this.PLTE_blue[i13] = bArr8[i12];
                        }
                        byte[] bArr10 = new byte[i8];
                        this.tRNS_alpha = bArr10;
                        System.arraycopy(bArr5, 0, bArr10, 0, i8);
                    }
                } else {
                    this.IHDR_colorType = 0;
                }
            }
        } else if (i == 1) {
            this.IHDR_colorType = 0;
        } else if (i == 2) {
            this.IHDR_colorType = 4;
        } else if (i == 3) {
            this.IHDR_colorType = 2;
        } else {
            if (i != 4) {
                throw new RuntimeException("Number of bands not 1-4!");
            }
            this.IHDR_colorType = 6;
        }
        this.IHDR_present = true;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) throws IIOInvalidTreeException {
        if (str.equals(nativeMetadataFormatName)) {
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

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        this.IHDR_present = false;
        this.PLTE_present = false;
        this.bKGD_present = false;
        this.cHRM_present = false;
        this.gAMA_present = false;
        this.hIST_present = false;
        this.iCCP_present = false;
        this.iTXt_keyword = new ArrayList<>();
        this.iTXt_compressionFlag = new ArrayList<>();
        this.iTXt_compressionMethod = new ArrayList<>();
        this.iTXt_languageTag = new ArrayList<>();
        this.iTXt_translatedKeyword = new ArrayList<>();
        this.iTXt_text = new ArrayList<>();
        this.pHYs_present = false;
        this.sBIT_present = false;
        this.sPLT_present = false;
        this.sRGB_present = false;
        this.tEXt_keyword = new ArrayList<>();
        this.tEXt_text = new ArrayList<>();
        this.tIME_present = false;
        this.tRNS_present = false;
        this.zTXt_keyword = new ArrayList<>();
        this.zTXt_compressionMethod = new ArrayList<>();
        this.zTXt_text = new ArrayList<>();
        this.unknownChunkType = new ArrayList<>();
        this.unknownChunkData = new ArrayList<>();
    }

    private float getFloatAttribute(Node node, String str) {
        return getFloatAttribute(node, str, -1.0f, true);
    }

    private int getIntAttribute(Node node, String str) {
        return getIntAttribute(node, str, -1, true);
    }

    private String getAttribute(Node node, String str) {
        return getAttribute(node, str, null, true);
    }

    public PNGMetadata(IIOMetadata iIOMetadata) {
        this.PLTE_order = null;
        this.iTXt_keyword = new ArrayList<>();
        this.iTXt_compressionFlag = new ArrayList<>();
        this.iTXt_compressionMethod = new ArrayList<>();
        this.iTXt_languageTag = new ArrayList<>();
        this.iTXt_translatedKeyword = new ArrayList<>();
        this.iTXt_text = new ArrayList<>();
        this.tEXt_keyword = new ArrayList<>();
        this.tEXt_text = new ArrayList<>();
        this.zTXt_keyword = new ArrayList<>();
        this.zTXt_compressionMethod = new ArrayList<>();
        this.zTXt_text = new ArrayList<>();
        this.unknownChunkType = new ArrayList<>();
        this.unknownChunkData = new ArrayList<>();
    }

    private boolean getBooleanAttribute(Node node, String str) {
        return getBooleanAttribute(node, str, false, true);
    }

    private int getEnumeratedAttribute(Node node, String str, String[] strArr) {
        return getEnumeratedAttribute(node, str, strArr, -1, true);
    }
}
