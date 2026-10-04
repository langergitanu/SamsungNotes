package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.view.MotionEventCompat;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.poi.java.awt.Graphics;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.GraphicsEnvironment;
import org.apache.poi.java.awt.Image;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.Transparency;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.sun.awt.image.ByteComponentRaster;
import org.apache.poi.sun.awt.image.IntegerComponentRaster;
import org.apache.poi.sun.awt.image.OffScreenImageSource;
import org.apache.poi.sun.awt.image.ShortComponentRaster;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BufferedImage extends Image implements WritableRenderedImage, Transparency {
    private static final int DCM_555_BLU_MASK = 31;
    private static final int DCM_555_GRN_MASK = 992;
    private static final int DCM_555_RED_MASK = 31744;
    private static final int DCM_565_BLU_MASK = 31;
    private static final int DCM_565_GRN_MASK = 2016;
    private static final int DCM_565_RED_MASK = 63488;
    private static final int DCM_ALPHA_MASK = -16777216;
    private static final int DCM_BGR_BLU_MASK = 16711680;
    private static final int DCM_BGR_GRN_MASK = 65280;
    private static final int DCM_BGR_RED_MASK = 255;
    private static final int DCM_BLUE_MASK = 255;
    private static final int DCM_GREEN_MASK = 65280;
    private static final int DCM_RED_MASK = 16711680;
    public static final int TYPE_3BYTE_BGR = 5;
    public static final int TYPE_4BYTE_ABGR = 6;
    public static final int TYPE_4BYTE_ABGR_PRE = 7;
    public static final int TYPE_BYTE_BINARY = 12;
    public static final int TYPE_BYTE_GRAY = 10;
    public static final int TYPE_BYTE_INDEXED = 13;
    public static final int TYPE_CUSTOM = 0;
    public static final int TYPE_INT_ARGB = 2;
    public static final int TYPE_INT_ARGB_PRE = 3;
    public static final int TYPE_INT_BGR = 4;
    public static final int TYPE_INT_RGB = 1;
    public static final int TYPE_USHORT_555_RGB = 9;
    public static final int TYPE_USHORT_565_RGB = 8;
    public static final int TYPE_USHORT_GRAY = 11;
    ColorModel colorModel;
    int imageType;
    boolean isAlphaPremultiplied;
    OffScreenImageSource osis;
    Hashtable properties;
    WritableRaster raster;

    static {
        ColorModel.loadLibraries();
    }

    public BufferedImage(int i, int i2, int i4) {
        this.imageType = 0;
        switch (i4) {
            case 1:
                DirectColorModel directColorModel = new DirectColorModel(24, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 0);
                this.colorModel = directColorModel;
                this.raster = directColorModel.createCompatibleWritableRaster(i, i2);
                break;
            case 2:
                ColorModel rGBdefault = ColorModel.getRGBdefault();
                this.colorModel = rGBdefault;
                this.raster = rGBdefault.createCompatibleWritableRaster(i, i2);
                break;
            case 3:
                DirectColorModel directColorModel2 = new DirectColorModel(ColorSpace.getInstance(1000), 32, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, -16777216, true, 3);
                this.colorModel = directColorModel2;
                this.raster = directColorModel2.createCompatibleWritableRaster(i, i2);
                break;
            case 4:
                DirectColorModel directColorModel3 = new DirectColorModel(24, 255, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 16711680);
                this.colorModel = directColorModel3;
                this.raster = directColorModel3.createCompatibleWritableRaster(i, i2);
                break;
            case 5:
                this.colorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8}, false, false, 1, 0);
                this.raster = Raster.createInterleavedRaster(0, i, i2, i * 3, 3, new int[]{2, 1, 0}, (Point) null);
                break;
            case 6:
                this.colorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, false, 3, 0);
                this.raster = Raster.createInterleavedRaster(0, i, i2, i * 4, 4, new int[]{3, 2, 1, 0}, (Point) null);
                break;
            case 7:
                this.colorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 8, 8, 8}, true, true, 3, 0);
                this.raster = Raster.createInterleavedRaster(0, i, i2, i * 4, 4, new int[]{3, 2, 1, 0}, (Point) null);
                break;
            case 8:
                DirectColorModel directColorModel4 = new DirectColorModel(16, 63488, 2016, 31);
                this.colorModel = directColorModel4;
                this.raster = directColorModel4.createCompatibleWritableRaster(i, i2);
                break;
            case 9:
                DirectColorModel directColorModel5 = new DirectColorModel(15, DCM_555_RED_MASK, DCM_555_GRN_MASK, 31);
                this.colorModel = directColorModel5;
                this.raster = directColorModel5.createCompatibleWritableRaster(i, i2);
                break;
            case 10:
                ComponentColorModel componentColorModel = new ComponentColorModel(ColorSpace.getInstance(1003), new int[]{8}, false, true, 1, 0);
                this.colorModel = componentColorModel;
                this.raster = componentColorModel.createCompatibleWritableRaster(i, i2);
                break;
            case 11:
                ComponentColorModel componentColorModel2 = new ComponentColorModel(ColorSpace.getInstance(1003), new int[]{16}, false, true, 1, 1);
                this.colorModel = componentColorModel2;
                this.raster = componentColorModel2.createCompatibleWritableRaster(i, i2);
                break;
            case 12:
                byte[] bArr = {0, -1};
                this.colorModel = new IndexColorModel(1, 2, bArr, bArr, bArr);
                this.raster = Raster.createPackedRaster(0, i, i2, 1, 1, (Point) null);
                break;
            case 13:
                int[] iArr = new int[256];
                int i5 = 0;
                for (int i6 = 0; i6 < 256; i6 += 51) {
                    for (int i7 = 0; i7 < 256; i7 += 51) {
                        int i8 = 0;
                        while (i8 < 256) {
                            iArr[i5] = (i6 << 16) | (i7 << 8) | i8;
                            i8 += 51;
                            i5++;
                        }
                    }
                }
                int i9 = 256 / (256 - i5);
                int i10 = i9 * 3;
                while (i5 < 256) {
                    iArr[i5] = (i10 << 16) | (i10 << 8) | i10;
                    i10 += i9;
                    i5++;
                }
                this.colorModel = new IndexColorModel(8, 256, iArr, 0, false, -1, 0);
                this.raster = Raster.createInterleavedRaster(0, i, i2, 1, null);
                break;
            default:
                throw new IllegalArgumentException(AbstractC0000a.m11h(i4, "Unknown image type "));
        }
        this.imageType = i4;
    }

    private static boolean isStandard(ColorModel colorModel, WritableRaster writableRaster) {
        final Class<?> cls = colorModel.getClass();
        final Class<?> cls2 = writableRaster.getClass();
        final Class<?> cls3 = writableRaster.getSampleModel().getClass();
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: org.apache.poi.java.awt.image.BufferedImage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                ClassLoader classLoader = System.class.getClassLoader();
                return Boolean.valueOf(cls.getClassLoader() == classLoader && cls3.getClassLoader() == classLoader && cls2.getClassLoader() == classLoader);
            }
        })).booleanValue();
    }

    public void coerceData(boolean z) {
        if (!this.colorModel.hasAlpha() || this.colorModel.isAlphaPremultiplied() == z) {
            return;
        }
        this.colorModel = this.colorModel.coerceData(this.raster, z);
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public WritableRaster copyData(WritableRaster writableRaster) {
        if (writableRaster == null) {
            return (WritableRaster) getData();
        }
        int width = writableRaster.getWidth();
        int height = writableRaster.getHeight();
        int minX = writableRaster.getMinX();
        int minY = writableRaster.getMinY();
        Object dataElements = null;
        for (int i = minY; i < minY + height; i++) {
            dataElements = this.raster.getDataElements(minX, i, width, 1, dataElements);
            writableRaster.setDataElements(minX, i, width, 1, dataElements);
        }
        return writableRaster;
    }

    public Graphics2D createGraphics() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().createGraphics(this);
    }

    public WritableRaster getAlphaRaster() {
        return this.colorModel.getAlphaRaster(this.raster);
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public ColorModel getColorModel() {
        return this.colorModel;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public Raster getData() {
        int width = this.raster.getWidth();
        int height = this.raster.getHeight();
        int minX = this.raster.getMinX();
        int minY = this.raster.getMinY();
        WritableRaster writableRasterCreateWritableRaster = Raster.createWritableRaster(this.raster.getSampleModel(), new Point(this.raster.getSampleModelTranslateX(), this.raster.getSampleModelTranslateY()));
        Object dataElements = null;
        for (int i = minY; i < minY + height; i++) {
            dataElements = this.raster.getDataElements(minX, i, width, 1, dataElements);
            writableRasterCreateWritableRaster.setDataElements(minX, i, width, 1, dataElements);
        }
        return writableRasterCreateWritableRaster;
    }

    @Override // org.apache.poi.java.awt.Image
    public Graphics getGraphics() {
        return createGraphics();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getHeight() {
        return this.raster.getHeight();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getMinTileX() {
        return 0;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getMinTileY() {
        return 0;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getMinX() {
        return this.raster.getMinX();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getMinY() {
        return this.raster.getMinY();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getNumXTiles() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getNumYTiles() {
        return 1;
    }

    @Override // org.apache.poi.java.awt.Image
    public Object getProperty(String str, ImageObserver imageObserver) {
        return getProperty(str);
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public String[] getPropertyNames() {
        return null;
    }

    public int getRGB(int i, int i2) {
        return this.colorModel.getRGB(this.raster.getDataElements(i, i2, null));
    }

    public WritableRaster getRaster() {
        return this.raster;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public SampleModel getSampleModel() {
        return this.raster.getSampleModel();
    }

    @Override // org.apache.poi.java.awt.Image
    public ImageProducer getSource() {
        if (this.osis == null) {
            if (this.properties == null) {
                this.properties = new Hashtable();
            }
            this.osis = new OffScreenImageSource(this, this.properties);
        }
        return this.osis;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public Vector<RenderedImage> getSources() {
        return null;
    }

    public BufferedImage getSubimage(int i, int i2, int i4, int i5) {
        return new BufferedImage(this.colorModel, this.raster.createWritableChild(i, i2, i4, i5, 0, 0, null), this.colorModel.isAlphaPremultiplied(), (Hashtable<?, ?>) this.properties);
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public Raster getTile(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this.raster;
        }
        throw new ArrayIndexOutOfBoundsException("BufferedImages only have one tile with index 0,0");
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getTileGridXOffset() {
        return this.raster.getSampleModelTranslateX();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getTileGridYOffset() {
        return this.raster.getSampleModelTranslateY();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getTileHeight() {
        return this.raster.getHeight();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getTileWidth() {
        return this.raster.getWidth();
    }

    @Override // org.apache.poi.java.awt.Transparency
    public int getTransparency() {
        return this.colorModel.getTransparency();
    }

    public int getType() {
        return this.imageType;
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public int getWidth() {
        return this.raster.getWidth();
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public WritableRaster getWritableTile(int i, int i2) {
        return this.raster;
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public Point[] getWritableTileIndices() {
        return new Point[]{new Point(0, 0)};
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public boolean hasTileWriters() {
        return true;
    }

    public boolean isAlphaPremultiplied() {
        return this.colorModel.isAlphaPremultiplied();
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public boolean isTileWritable(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        throw new IllegalArgumentException("Only 1 tile in image");
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public void setData(Raster raster) {
        Rectangle rectangle = new Rectangle(raster.getMinX(), raster.getMinY(), raster.getWidth(), raster.getHeight());
        WritableRaster writableRaster = this.raster;
        Rectangle rectangleIntersection = rectangle.intersection(new Rectangle(0, 0, writableRaster.width, writableRaster.height));
        if (rectangleIntersection.isEmpty()) {
            return;
        }
        int i = rectangleIntersection.width;
        int i2 = rectangleIntersection.height;
        int i4 = rectangleIntersection.f10094x;
        int i5 = rectangleIntersection.f10095y;
        int[] pixels = null;
        for (int i6 = i5; i6 < i5 + i2; i6++) {
            pixels = raster.getPixels(i4, i6, i, 1, pixels);
            this.raster.setPixels(i4, i6, i, 1, pixels);
        }
    }

    public synchronized void setRGB(int i, int i2, int i4) {
        this.raster.setDataElements(i, i2, this.colorModel.getDataElements(i4, null));
    }

    public String toString() {
        return "BufferedImage@" + Integer.toHexString(hashCode()) + ": type = " + this.imageType + " " + this.colorModel + " " + this.raster;
    }

    @Override // org.apache.poi.java.awt.Image
    public int getHeight(ImageObserver imageObserver) {
        return this.raster.getHeight();
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public Object getProperty(String str) {
        if (str == null) {
            throw new NullPointerException("null property name is not allowed");
        }
        Hashtable hashtable = this.properties;
        if (hashtable == null) {
            return Image.UndefinedProperty;
        }
        Object obj = hashtable.get(str);
        return obj == null ? Image.UndefinedProperty : obj;
    }

    public int[] getRGB(int i, int i2, int i4, int i5, int[] iArr, int i6, int i7) {
        Object obj;
        int numBands = this.raster.getNumBands();
        int dataType = this.raster.getDataBuffer().getDataType();
        if (dataType == 0) {
            obj = new byte[numBands];
        } else if (dataType == 1) {
            obj = new short[numBands];
        } else if (dataType == 3) {
            obj = new int[numBands];
        } else if (dataType == 4) {
            obj = new float[numBands];
        } else {
            if (dataType != 5) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(dataType, "Unknown data buffer type: "));
            }
            obj = new double[numBands];
        }
        if (iArr == null) {
            iArr = new int[(i5 * i7) + i6];
        }
        int i8 = i2;
        while (i8 < i2 + i5) {
            int i9 = i;
            int i10 = i6;
            while (i9 < i + i4) {
                iArr[i10] = this.colorModel.getRGB(this.raster.getDataElements(i9, i8, obj));
                i9++;
                i10++;
            }
            i8++;
            i6 += i7;
        }
        return iArr;
    }

    @Override // org.apache.poi.java.awt.Image
    public int getWidth(ImageObserver imageObserver) {
        return this.raster.getWidth();
    }

    public void setRGB(int i, int i2, int i4, int i5, int[] iArr, int i6, int i7) {
        Object dataElements = null;
        int i8 = i2;
        while (i8 < i2 + i5) {
            int i9 = i;
            int i10 = i6;
            while (i9 < i + i4) {
                dataElements = this.colorModel.getDataElements(iArr[i10], dataElements);
                this.raster.setDataElements(i9, i8, dataElements);
                i9++;
                i10++;
            }
            i8++;
            i6 += i7;
        }
    }

    @Override // org.apache.poi.java.awt.image.RenderedImage
    public Raster getData(Rectangle rectangle) {
        WritableRaster writableRasterCreateWritableRaster = Raster.createWritableRaster(this.raster.getSampleModel().createCompatibleSampleModel(rectangle.width, rectangle.height), rectangle.getLocation());
        int i = rectangle.width;
        int i2 = rectangle.height;
        int i4 = rectangle.f10094x;
        int i5 = rectangle.f10095y;
        int i6 = i5;
        Object obj = null;
        while (i6 < i5 + i2) {
            int i7 = i;
            int i8 = i6;
            int i9 = i4;
            Object dataElements = this.raster.getDataElements(i9, i8, i7, 1, obj);
            i4 = i9;
            writableRasterCreateWritableRaster.setDataElements(i4, i8, i7, 1, dataElements);
            int i10 = i8 + 1;
            i = i7;
            obj = dataElements;
            i6 = i10;
        }
        return writableRasterCreateWritableRaster;
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public void addTileObserver(TileObserver tileObserver) {
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public void removeTileObserver(TileObserver tileObserver) {
    }

    @Override // org.apache.poi.java.awt.image.WritableRenderedImage
    public void releaseWritableTile(int i, int i2) {
    }

    public BufferedImage(int i, int i2, int i4, IndexColorModel indexColorModel) {
        int i5;
        this.imageType = 0;
        if (indexColorModel.hasAlpha() && indexColorModel.isAlphaPremultiplied()) {
            throw new IllegalArgumentException("This image types do not have premultiplied alpha.");
        }
        int i6 = 1;
        if (i4 == 12) {
            int mapSize = indexColorModel.getMapSize();
            if (mapSize <= 2) {
                i5 = i6;
                this.raster = Raster.createPackedRaster(0, i, i2, 1, i5, (Point) null);
            } else {
                i6 = 4;
                if (mapSize <= 4) {
                    i5 = 2;
                    this.raster = Raster.createPackedRaster(0, i, i2, 1, i5, (Point) null);
                } else {
                    if (mapSize > 16) {
                        throw new IllegalArgumentException("Color map for TYPE_BYTE_BINARY must have no more than 16 entries");
                    }
                    i5 = i6;
                    this.raster = Raster.createPackedRaster(0, i, i2, 1, i5, (Point) null);
                }
            }
        } else if (i4 == 13) {
            this.raster = Raster.createInterleavedRaster(0, i, i2, 1, null);
        } else {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i4, "Invalid image type (", ").  Image type must be either TYPE_BYTE_BINARY or  TYPE_BYTE_INDEXED"));
        }
        if (indexColorModel.isCompatibleRaster(this.raster)) {
            this.colorModel = indexColorModel;
            this.imageType = i4;
            return;
        }
        throw new IllegalArgumentException("Incompatible image type and IndexColorModel");
    }

    public BufferedImage(ColorModel colorModel, WritableRaster writableRaster, boolean z, Hashtable<?, ?> hashtable) {
        this.imageType = 0;
        if (colorModel.isCompatibleRaster(writableRaster)) {
            if (writableRaster.minX == 0 && writableRaster.minY == 0) {
                this.colorModel = colorModel;
                this.raster = writableRaster;
                this.properties = hashtable;
                int numBands = writableRaster.getNumBands();
                boolean zIsAlphaPremultiplied = colorModel.isAlphaPremultiplied();
                boolean zIsStandard = isStandard(colorModel, writableRaster);
                coerceData(z);
                SampleModel sampleModel = writableRaster.getSampleModel();
                int type = colorModel.getColorSpace().getType();
                if (type != 5) {
                    if (type == 6 && zIsStandard && (colorModel instanceof ComponentColorModel)) {
                        if ((sampleModel instanceof ComponentSampleModel) && ((ComponentSampleModel) sampleModel).getPixelStride() != numBands) {
                            this.imageType = 0;
                            return;
                        }
                        if ((writableRaster instanceof ByteComponentRaster) && writableRaster.getNumBands() == 1 && colorModel.getComponentSize(0) == 8 && ((ByteComponentRaster) writableRaster).getPixelStride() == 1) {
                            this.imageType = 10;
                            return;
                        } else {
                            if ((writableRaster instanceof ShortComponentRaster) && writableRaster.getNumBands() == 1 && colorModel.getComponentSize(0) == 16 && ((ShortComponentRaster) writableRaster).getPixelStride() == 1) {
                                this.imageType = 11;
                                return;
                            }
                            return;
                        }
                    }
                    this.imageType = 0;
                    return;
                }
                if ((writableRaster instanceof IntegerComponentRaster) && (numBands == 3 || numBands == 4)) {
                    int pixelSize = colorModel.getPixelSize();
                    if (((IntegerComponentRaster) writableRaster).getPixelStride() == 1 && zIsStandard && (colorModel instanceof DirectColorModel)) {
                        if (pixelSize == 32 || pixelSize == 24) {
                            DirectColorModel directColorModel = (DirectColorModel) colorModel;
                            int redMask = directColorModel.getRedMask();
                            int greenMask = directColorModel.getGreenMask();
                            int blueMask = directColorModel.getBlueMask();
                            if (redMask == 16711680 && greenMask == 65280 && blueMask == 255) {
                                if (directColorModel.getAlphaMask() == -16777216) {
                                    this.imageType = zIsAlphaPremultiplied ? 3 : 2;
                                    return;
                                } else {
                                    if (directColorModel.hasAlpha()) {
                                        return;
                                    }
                                    this.imageType = 1;
                                    return;
                                }
                            }
                            if (redMask == 255 && greenMask == 65280 && blueMask == 16711680 && !directColorModel.hasAlpha()) {
                                this.imageType = 4;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ((colorModel instanceof IndexColorModel) && numBands == 1 && zIsStandard && (!colorModel.hasAlpha() || !zIsAlphaPremultiplied)) {
                    int pixelSize2 = ((IndexColorModel) colorModel).getPixelSize();
                    if ((writableRaster instanceof ByteComponentRaster) && ((ByteComponentRaster) writableRaster).getPixelStride() == 1 && pixelSize2 <= 8) {
                        this.imageType = 13;
                        return;
                    }
                    return;
                }
                if ((writableRaster instanceof ShortComponentRaster) && (colorModel instanceof DirectColorModel) && zIsStandard && numBands == 3 && !colorModel.hasAlpha()) {
                    DirectColorModel directColorModel2 = (DirectColorModel) colorModel;
                    if (directColorModel2.getRedMask() == 63488) {
                        if (directColorModel2.getGreenMask() == 2016 && directColorModel2.getBlueMask() == 31) {
                            this.imageType = 8;
                            return;
                        }
                        return;
                    }
                    if (directColorModel2.getRedMask() == DCM_555_RED_MASK && directColorModel2.getGreenMask() == DCM_555_GRN_MASK && directColorModel2.getBlueMask() == 31) {
                        this.imageType = 9;
                        return;
                    }
                    return;
                }
                if ((writableRaster instanceof ByteComponentRaster) && (colorModel instanceof ComponentColorModel) && zIsStandard && (writableRaster.getSampleModel() instanceof PixelInterleavedSampleModel)) {
                    if (numBands == 3 || numBands == 4) {
                        ComponentColorModel componentColorModel = (ComponentColorModel) colorModel;
                        PixelInterleavedSampleModel pixelInterleavedSampleModel = (PixelInterleavedSampleModel) writableRaster.getSampleModel();
                        ByteComponentRaster byteComponentRaster = (ByteComponentRaster) writableRaster;
                        int[] bandOffsets = pixelInterleavedSampleModel.getBandOffsets();
                        if (componentColorModel.getNumComponents() == numBands) {
                            int[] componentSize = componentColorModel.getComponentSize();
                            for (int i = 0; i < numBands; i++) {
                                if (componentSize[i] != 8) {
                                    return;
                                }
                            }
                            if (byteComponentRaster.getPixelStride() == numBands && bandOffsets[0] == numBands - 1 && bandOffsets[1] == numBands - 2 && bandOffsets[2] == numBands - 3) {
                                if (numBands == 3 && !componentColorModel.hasAlpha()) {
                                    this.imageType = 5;
                                    return;
                                } else {
                                    if (bandOffsets[3] == 0 && componentColorModel.hasAlpha()) {
                                        this.imageType = zIsAlphaPremultiplied ? 7 : 6;
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        throw new RasterFormatException("Number of components in ColorModel (" + componentColorModel.getNumComponents() + ") does not match # in  Raster (" + numBands + ")");
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Raster " + writableRaster + " has minX or minY not equal to zero: " + writableRaster.minX + " " + writableRaster.minY);
        }
        throw new IllegalArgumentException("Raster " + writableRaster + " is incompatible with ColorModel " + colorModel);
    }
}
