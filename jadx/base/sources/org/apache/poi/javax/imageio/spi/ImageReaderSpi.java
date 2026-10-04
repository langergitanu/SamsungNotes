package org.apache.poi.javax.imageio.spi;

import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageReaderSpi extends ImageReaderWriterSpi {

    @Deprecated
    public static final Class[] STANDARD_INPUT_TYPE = {ImageInputStream.class};
    protected Class[] inputTypes;
    private Class readerClass;
    protected String[] writerSpiNames;

    public ImageReaderSpi() {
        this.inputTypes = null;
        this.writerSpiNames = null;
        this.readerClass = null;
    }

    public abstract boolean canDecodeInput(Object obj);

    public ImageReader createReaderInstance() {
        return createReaderInstance(null);
    }

    public abstract ImageReader createReaderInstance(Object obj);

    public String[] getImageWriterSpiNames() {
        String[] strArr = this.writerSpiNames;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public Class[] getInputTypes() {
        return (Class[]) this.inputTypes.clone();
    }

    public boolean isOwnReader(ImageReader imageReader) {
        if (imageReader != null) {
            return imageReader.getClass().getName().equals(this.pluginClassName);
        }
        throw new IllegalArgumentException("reader == null!");
    }

    public ImageReaderSpi(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String str3, Class[] clsArr, String[] strArr4, boolean z, String str4, String str5, String[] strArr5, String[] strArr6, boolean z2, String str6, String str7, String[] strArr7, String[] strArr8) {
        super(str, str2, strArr, strArr2, strArr3, str3, z, str4, str5, strArr5, strArr6, z2, str6, str7, strArr7, strArr8);
        this.inputTypes = null;
        this.writerSpiNames = null;
        this.readerClass = null;
        if (clsArr != null) {
            if (clsArr.length != 0) {
                this.inputTypes = clsArr == STANDARD_INPUT_TYPE ? new Class[]{ImageInputStream.class} : (Class[]) clsArr.clone();
                if (strArr4 == null || strArr4.length <= 0) {
                    return;
                }
                this.writerSpiNames = (String[]) strArr4.clone();
                return;
            }
            throw new IllegalArgumentException("inputTypes.length == 0!");
        }
        throw new IllegalArgumentException("inputTypes == null!");
    }
}
