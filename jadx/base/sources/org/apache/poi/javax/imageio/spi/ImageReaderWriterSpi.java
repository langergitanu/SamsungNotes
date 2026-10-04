package org.apache.poi.javax.imageio.spi;

import org.apache.poi.javax.imageio.metadata.IIOMetadataFormat;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageReaderWriterSpi extends IIOServiceProvider {
    protected String[] MIMETypes;
    protected String[] extraImageMetadataFormatClassNames;
    protected String[] extraImageMetadataFormatNames;
    protected String[] extraStreamMetadataFormatClassNames;
    protected String[] extraStreamMetadataFormatNames;
    protected String[] names;
    protected String nativeImageMetadataFormatClassName;
    protected String nativeImageMetadataFormatName;
    protected String nativeStreamMetadataFormatClassName;
    protected String nativeStreamMetadataFormatName;
    protected String pluginClassName;
    protected String[] suffixes;
    protected boolean supportsStandardImageMetadataFormat;
    protected boolean supportsStandardStreamMetadataFormat;

    public ImageReaderWriterSpi(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String str3, boolean z, String str4, String str5, String[] strArr4, String[] strArr5, boolean z2, String str6, String str7, String[] strArr6, String[] strArr7) {
        super(str, str2);
        this.names = null;
        this.suffixes = null;
        this.MIMETypes = null;
        this.pluginClassName = null;
        this.supportsStandardStreamMetadataFormat = false;
        this.nativeStreamMetadataFormatName = null;
        this.nativeStreamMetadataFormatClassName = null;
        this.extraStreamMetadataFormatNames = null;
        this.extraStreamMetadataFormatClassNames = null;
        this.supportsStandardImageMetadataFormat = false;
        this.nativeImageMetadataFormatName = null;
        this.nativeImageMetadataFormatClassName = null;
        this.extraImageMetadataFormatNames = null;
        this.extraImageMetadataFormatClassNames = null;
        if (strArr == null) {
            throw new IllegalArgumentException("names == null!");
        }
        if (strArr.length == 0) {
            throw new IllegalArgumentException("names.length == 0!");
        }
        if (str3 == null) {
            throw new IllegalArgumentException("pluginClassName == null!");
        }
        this.names = (String[]) strArr.clone();
        if (strArr2 != null && strArr2.length > 0) {
            this.suffixes = (String[]) strArr2.clone();
        }
        if (strArr3 != null && strArr3.length > 0) {
            this.MIMETypes = (String[]) strArr3.clone();
        }
        this.pluginClassName = str3;
        this.supportsStandardStreamMetadataFormat = z;
        this.nativeStreamMetadataFormatName = str4;
        this.nativeStreamMetadataFormatClassName = str5;
        if (strArr4 != null && strArr4.length > 0) {
            this.extraStreamMetadataFormatNames = (String[]) strArr4.clone();
        }
        if (strArr5 != null && strArr5.length > 0) {
            this.extraStreamMetadataFormatClassNames = (String[]) strArr5.clone();
        }
        this.supportsStandardImageMetadataFormat = z2;
        this.nativeImageMetadataFormatName = str6;
        this.nativeImageMetadataFormatClassName = str7;
        if (strArr6 != null && strArr6.length > 0) {
            this.extraImageMetadataFormatNames = (String[]) strArr6.clone();
        }
        if (strArr7 == null || strArr7.length <= 0) {
            return;
        }
        this.extraImageMetadataFormatClassNames = (String[]) strArr7.clone();
    }

    private IIOMetadataFormat getMetadataFormat(String str, boolean z, String str2, String str3, String[] strArr, String[] strArr2) {
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        if (z && str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            return IIOMetadataFormatImpl.getStandardFormatInstance();
        }
        if (!str.equals(str2)) {
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i++) {
                    if (str.equals(strArr[i])) {
                        str3 = strArr2[i];
                        break;
                    }
                }
                str3 = null;
            } else {
                str3 = null;
            }
        }
        if (str3 == null) {
            throw new IllegalArgumentException("Unsupported format name");
        }
        try {
            return (IIOMetadataFormat) Class.forName(str3, true, ClassLoader.getSystemClassLoader()).getMethod("getInstance", null).invoke(null, null);
        } catch (Exception e) {
            IllegalStateException illegalStateException = new IllegalStateException("Can't obtain format");
            illegalStateException.initCause(e);
            throw illegalStateException;
        }
    }

    public String[] getExtraImageMetadataFormatNames() {
        String[] strArr = this.extraImageMetadataFormatNames;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public String[] getExtraStreamMetadataFormatNames() {
        String[] strArr = this.extraStreamMetadataFormatNames;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public String[] getFileSuffixes() {
        String[] strArr = this.suffixes;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public String[] getFormatNames() {
        return (String[]) this.names.clone();
    }

    public IIOMetadataFormat getImageMetadataFormat(String str) {
        return getMetadataFormat(str, this.supportsStandardImageMetadataFormat, this.nativeImageMetadataFormatName, this.nativeImageMetadataFormatClassName, this.extraImageMetadataFormatNames, this.extraImageMetadataFormatClassNames);
    }

    public String[] getMIMETypes() {
        String[] strArr = this.MIMETypes;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public String getNativeImageMetadataFormatName() {
        return this.nativeImageMetadataFormatName;
    }

    public String getNativeStreamMetadataFormatName() {
        return this.nativeStreamMetadataFormatName;
    }

    public String getPluginClassName() {
        return this.pluginClassName;
    }

    public IIOMetadataFormat getStreamMetadataFormat(String str) {
        return getMetadataFormat(str, this.supportsStandardStreamMetadataFormat, this.nativeStreamMetadataFormatName, this.nativeStreamMetadataFormatClassName, this.extraStreamMetadataFormatNames, this.extraStreamMetadataFormatClassNames);
    }

    public boolean isStandardImageMetadataFormatSupported() {
        return this.supportsStandardImageMetadataFormat;
    }

    public boolean isStandardStreamMetadataFormatSupported() {
        return this.supportsStandardStreamMetadataFormat;
    }

    public ImageReaderWriterSpi() {
        this.names = null;
        this.suffixes = null;
        this.MIMETypes = null;
        this.pluginClassName = null;
        this.supportsStandardStreamMetadataFormat = false;
        this.nativeStreamMetadataFormatName = null;
        this.nativeStreamMetadataFormatClassName = null;
        this.extraStreamMetadataFormatNames = null;
        this.extraStreamMetadataFormatClassNames = null;
        this.supportsStandardImageMetadataFormat = false;
        this.nativeImageMetadataFormatName = null;
        this.nativeImageMetadataFormatClassName = null;
        this.extraImageMetadataFormatNames = null;
        this.extraImageMetadataFormatClassNames = null;
    }
}
