package com.sun.imageio.plugins.common;

import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PaletteBuilder {
    protected static final int MAXLEVEL = 8;
    protected int currLevel;
    protected int currSize;
    protected int maxNodes;
    protected int numNodes;
    protected ColorNode[] palette;
    protected ColorNode[] reduceList;
    protected int requiredSize;
    protected ColorNode root;
    protected RenderedImage src;
    protected ColorModel srcColorModel;
    protected Raster srcRaster;
    protected ColorNode transColor;
    protected int transparency;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ColorNode {
        public long blue;
        public int colorCount;
        public long green;
        ColorNode nextReducible;
        public int paletteIndex;
        public long red;
        public boolean isLeaf = false;
        public int level = 0;
        public int childCount = 0;
        ColorNode[] children = new ColorNode[8];

        public ColorNode() {
            for (int i = 0; i < 8; i++) {
                this.children[i] = null;
            }
            this.colorCount = 0;
            this.blue = 0L;
            this.green = 0L;
            this.red = 0L;
            this.paletteIndex = 0;
        }

        public int getLeafChildCount() {
            int i = 0;
            if (this.isLeaf) {
                return 0;
            }
            int leafChildCount = 0;
            while (true) {
                ColorNode[] colorNodeArr = this.children;
                if (i >= colorNodeArr.length) {
                    return leafChildCount;
                }
                ColorNode colorNode = colorNodeArr[i];
                if (colorNode != null) {
                    leafChildCount = colorNode.isLeaf ? leafChildCount + 1 : colorNode.getLeafChildCount() + leafChildCount;
                }
                i++;
            }
        }

        public int getRGB() {
            int i = (int) this.red;
            int i2 = this.colorCount;
            return (((i / i2) & 255) << 16) | (-16777216) | (((((int) this.green) / i2) & 255) << 8) | ((((int) this.blue) / i2) & 255);
        }
    }

    public PaletteBuilder(RenderedImage renderedImage) {
        this(renderedImage, 256);
    }

    public static boolean canCreatePalette(ImageTypeSpecifier imageTypeSpecifier) {
        if (imageTypeSpecifier != null) {
            return true;
        }
        throw new IllegalArgumentException("type == null");
    }

    public static IndexColorModel createIndexColorModel(RenderedImage renderedImage) {
        PaletteBuilder paletteBuilder = new PaletteBuilder(renderedImage);
        paletteBuilder.buildPalette();
        return paletteBuilder.getIndexColorModel();
    }

    public static RenderedImage createIndexedImage(RenderedImage renderedImage) {
        PaletteBuilder paletteBuilder = new PaletteBuilder(renderedImage);
        paletteBuilder.buildPalette();
        return paletteBuilder.getIndexedImage();
    }

    private Color getSrcColor(int i, int i2) {
        return new Color(this.srcColorModel.getRGB(this.srcRaster.getDataElements(i, i2, null)), this.transparency != 1);
    }

    public void buildPalette() {
        this.reduceList = new ColorNode[9];
        int i = 0;
        while (true) {
            ColorNode[] colorNodeArr = this.reduceList;
            if (i >= colorNodeArr.length) {
                break;
            }
            colorNodeArr[i] = null;
            i++;
        }
        this.numNodes = 0;
        this.maxNodes = 0;
        this.root = null;
        this.currSize = 0;
        this.currLevel = 8;
        int width = this.src.getWidth();
        int height = this.src.getHeight();
        for (int i2 = 0; i2 < height; i2++) {
            for (int i4 = 0; i4 < width; i4++) {
                Color srcColor = getSrcColor((width - i4) - 1, (height - i2) - 1);
                if (this.transparency == 1 || srcColor.getAlpha() == 255) {
                    this.root = insertNode(this.root, srcColor, 0);
                } else {
                    if (this.transColor == null) {
                        this.requiredSize--;
                        ColorNode colorNode = new ColorNode();
                        this.transColor = colorNode;
                        colorNode.isLeaf = true;
                    }
                    this.transColor = insertNode(this.transColor, srcColor, 0);
                }
                if (this.currSize > this.requiredSize) {
                    reduceTree();
                }
            }
        }
    }

    public int findColorIndex(ColorNode colorNode, Color color) {
        if (this.transparency != 1 && color.getAlpha() != 255) {
            return 0;
        }
        if (colorNode.isLeaf) {
            return colorNode.paletteIndex;
        }
        return findColorIndex(colorNode.children[getBranchIndex(color, colorNode.level)], color);
    }

    public int findPaletteEntry(ColorNode colorNode, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        if (colorNode.isLeaf) {
            long j = colorNode.red;
            int i2 = colorNode.colorCount;
            bArr[i] = (byte) (j / ((long) i2));
            bArr2[i] = (byte) (colorNode.green / ((long) i2));
            bArr3[i] = (byte) (colorNode.blue / ((long) i2));
            colorNode.paletteIndex = i;
            this.palette[i] = colorNode;
            return i + 1;
        }
        int i4 = 0;
        int iFindPaletteEntry = i;
        while (i4 < 8) {
            ColorNode colorNode2 = colorNode.children[i4];
            if (colorNode2 != null) {
                bArr4 = bArr;
                bArr5 = bArr2;
                bArr6 = bArr3;
                iFindPaletteEntry = findPaletteEntry(colorNode2, iFindPaletteEntry, bArr4, bArr5, bArr6);
            } else {
                bArr4 = bArr;
                bArr5 = bArr2;
                bArr6 = bArr3;
            }
            i4++;
            bArr = bArr4;
            bArr2 = bArr5;
            bArr3 = bArr6;
        }
        return iFindPaletteEntry;
    }

    public ColorNode freeTree(ColorNode colorNode) {
        if (colorNode == null) {
            return null;
        }
        for (int i = 0; i < 8; i++) {
            ColorNode[] colorNodeArr = colorNode.children;
            colorNodeArr[i] = freeTree(colorNodeArr[i]);
        }
        this.numNodes--;
        return null;
    }

    public int getBranchIndex(Color color, int i) {
        if (i > 8 || i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid octree node depth: "));
        }
        int i2 = 8 - i;
        return (((color.getBlue() & 255) >> i2) & 1) | ((((color.getRed() & 255) >> i2) & 1) << 2) | ((((color.getGreen() & 255) >> i2) & 1) << 1);
    }

    public IndexColorModel getIndexColorModel() {
        PaletteBuilder paletteBuilder;
        int i = this.currSize;
        ColorNode colorNode = this.transColor;
        if (colorNode != null) {
            i++;
        }
        int i2 = i;
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = new byte[i2];
        this.palette = new ColorNode[i2];
        int i4 = colorNode != null ? 1 : 0;
        ColorNode colorNode2 = this.root;
        if (colorNode2 != null) {
            findPaletteEntry(colorNode2, i4, bArr, bArr2, bArr3);
            paletteBuilder = this;
        } else {
            paletteBuilder = this;
        }
        return paletteBuilder.transColor != null ? new IndexColorModel(8, i2, bArr, bArr2, bArr3, 0) : new IndexColorModel(8, paletteBuilder.currSize, bArr, bArr2, bArr3);
    }

    public RenderedImage getIndexedImage() {
        BufferedImage bufferedImage = new BufferedImage(this.src.getWidth(), this.src.getHeight(), 13, getIndexColorModel());
        WritableRaster raster = bufferedImage.getRaster();
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int i2 = 0; i2 < bufferedImage.getWidth(); i2++) {
                raster.setSample(i2, i, 0, findColorIndex(this.root, getSrcColor(i2, i)));
            }
        }
        return bufferedImage;
    }

    public ColorNode insertNode(ColorNode colorNode, Color color, int i) {
        if (colorNode == null) {
            colorNode = new ColorNode();
            int i2 = this.numNodes + 1;
            this.numNodes = i2;
            if (i2 > this.maxNodes) {
                this.maxNodes = i2;
            }
            colorNode.level = i;
            boolean z = i > 8;
            colorNode.isLeaf = z;
            if (z) {
                this.currSize++;
            }
        }
        colorNode.colorCount++;
        colorNode.red += (long) color.getRed();
        colorNode.green += (long) color.getGreen();
        colorNode.blue += (long) color.getBlue();
        if (!colorNode.isLeaf) {
            int branchIndex = getBranchIndex(color, i);
            ColorNode[] colorNodeArr = colorNode.children;
            if (colorNodeArr[branchIndex] == null) {
                int i4 = colorNode.childCount + 1;
                colorNode.childCount = i4;
                if (i4 == 2) {
                    ColorNode[] colorNodeArr2 = this.reduceList;
                    colorNode.nextReducible = colorNodeArr2[i];
                    colorNodeArr2[i] = colorNode;
                }
            }
            colorNodeArr[branchIndex] = insertNode(colorNodeArr[branchIndex], color, i + 1);
        }
        return colorNode;
    }

    public void reduceTree() {
        ColorNode colorNode;
        int length = this.reduceList.length - 1;
        while (true) {
            colorNode = this.reduceList[length];
            if (colorNode != null || length < 0) {
                break;
            } else {
                length--;
            }
        }
        if (colorNode == null) {
            return;
        }
        int i = colorNode.colorCount;
        ColorNode colorNode2 = colorNode;
        while (true) {
            ColorNode colorNode3 = colorNode.nextReducible;
            if (colorNode3 == null) {
                break;
            }
            if (i > colorNode3.colorCount) {
                i = colorNode.colorCount;
                colorNode2 = colorNode;
            }
            colorNode = colorNode3;
        }
        ColorNode[] colorNodeArr = this.reduceList;
        if (colorNode2 == colorNodeArr[length]) {
            colorNodeArr[length] = colorNode2.nextReducible;
        } else {
            ColorNode colorNode4 = colorNode2.nextReducible;
            colorNode2.nextReducible = colorNode4.nextReducible;
            colorNode2 = colorNode4;
        }
        if (colorNode2.isLeaf) {
            return;
        }
        int leafChildCount = colorNode2.getLeafChildCount();
        colorNode2.isLeaf = true;
        this.currSize -= leafChildCount - 1;
        for (int i2 = 0; i2 < 8; i2++) {
            ColorNode[] colorNodeArr2 = colorNode2.children;
            colorNodeArr2[i2] = freeTree(colorNodeArr2[i2]);
        }
        colorNode2.childCount = 0;
    }

    public PaletteBuilder(RenderedImage renderedImage, int i) {
        this.src = renderedImage;
        this.srcColorModel = renderedImage.getColorModel();
        this.srcRaster = renderedImage.getData();
        this.transparency = this.srcColorModel.getTransparency();
        this.requiredSize = i;
    }

    public static boolean canCreatePalette(RenderedImage renderedImage) {
        if (renderedImage != null) {
            return canCreatePalette(new ImageTypeSpecifier(renderedImage));
        }
        throw new IllegalArgumentException("image == null");
    }
}
