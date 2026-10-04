package org.apache.poi.javax.imageio.spi;

import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageWriterSpi extends ImageReaderWriterSpi {

    @Deprecated
    public static final Class[] STANDARD_OUTPUT_TYPE = {ImageOutputStream.class};
    protected Class[] outputTypes;
    protected String[] readerSpiNames;
    private Class writerClass;

    public ImageWriterSpi() {
        this.outputTypes = null;
        this.readerSpiNames = null;
        this.writerClass = null;
    }

    public boolean canEncodeImage(RenderedImage renderedImage) {
        return canEncodeImage(ImageTypeSpecifier.createFromRenderedImage(renderedImage));
    }

    public abstract boolean canEncodeImage(ImageTypeSpecifier imageTypeSpecifier);

    public ImageWriter createWriterInstance() {
        return createWriterInstance(null);
    }

    public abstract ImageWriter createWriterInstance(Object obj);

    public String[] getImageReaderSpiNames() {
        String[] strArr = this.readerSpiNames;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public Class[] getOutputTypes() {
        return (Class[]) this.outputTypes.clone();
    }

    public boolean isFormatLossless() {
        return true;
    }

    public boolean isOwnWriter(ImageWriter imageWriter) {
        if (imageWriter != null) {
            return imageWriter.getClass().getName().equals(this.pluginClassName);
        }
        throw new IllegalArgumentException("writer == null!");
    }

    public ImageWriterSpi(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String str3, Class[] clsArr, String[] strArr4, boolean z, String str4, String str5, String[] strArr5, String[] strArr6, boolean z2, String str6, String str7, String[] strArr7, String[] strArr8) {
        super(str, str2, strArr, strArr2, strArr3, str3, z, str4, str5, strArr5, strArr6, z2, str6, str7, strArr7, strArr8);
        this.outputTypes = null;
        this.readerSpiNames = null;
        this.writerClass = null;
        if (clsArr != null) {
            if (clsArr.length != 0) {
                this.outputTypes = clsArr == STANDARD_OUTPUT_TYPE ? new Class[]{ImageOutputStream.class} : (Class[]) clsArr.clone();
                if (strArr4 == null || strArr4.length <= 0) {
                    return;
                }
                this.readerSpiNames = (String[]) strArr4.clone();
                return;
            }
            throw new IllegalArgumentException("outputTypes.length == 0!");
        }
        throw new IllegalArgumentException("outputTypes == null!");
    }
}
