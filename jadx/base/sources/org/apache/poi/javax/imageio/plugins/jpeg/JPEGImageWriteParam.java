package org.apache.poi.javax.imageio.plugins.jpeg;

import java.util.Locale;
import org.apache.poi.javax.imageio.ImageWriteParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JPEGImageWriteParam extends ImageWriteParam {
    private JPEGHuffmanTable[] ACHuffmanTables;
    private JPEGHuffmanTable[] DCHuffmanTables;
    private String[] compressionNames;
    private boolean optimizeHuffman;
    private JPEGQTable[] qTables;
    private String[] qualityDescs;
    private float[] qualityVals;

    public JPEGImageWriteParam(Locale locale) {
        super(locale);
        this.qTables = null;
        this.DCHuffmanTables = null;
        this.ACHuffmanTables = null;
        this.optimizeHuffman = false;
        String[] strArr = {"JPEG"};
        this.compressionNames = strArr;
        this.qualityVals = new float[]{0.0f, 0.3f, 0.75f, 1.0f};
        this.qualityDescs = new String[]{"Low quality", "Medium quality", "Visually lossless"};
        this.canWriteProgressive = true;
        this.progressiveMode = 0;
        this.canWriteCompressed = true;
        this.compressionTypes = strArr;
        this.compressionType = strArr[0];
        this.compressionQuality = 0.75f;
    }

    public boolean areTablesSet() {
        return this.qTables != null;
    }

    public JPEGHuffmanTable[] getACHuffmanTables() {
        JPEGHuffmanTable[] jPEGHuffmanTableArr = this.ACHuffmanTables;
        if (jPEGHuffmanTableArr != null) {
            return (JPEGHuffmanTable[]) jPEGHuffmanTableArr.clone();
        }
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriteParam
    public String[] getCompressionQualityDescriptions() {
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return (String[]) this.qualityDescs.clone();
        }
        throw new IllegalStateException("No compression type set!");
    }

    @Override // org.apache.poi.javax.imageio.ImageWriteParam
    public float[] getCompressionQualityValues() {
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return (float[]) this.qualityVals.clone();
        }
        throw new IllegalStateException("No compression type set!");
    }

    public JPEGHuffmanTable[] getDCHuffmanTables() {
        JPEGHuffmanTable[] jPEGHuffmanTableArr = this.DCHuffmanTables;
        if (jPEGHuffmanTableArr != null) {
            return (JPEGHuffmanTable[]) jPEGHuffmanTableArr.clone();
        }
        return null;
    }

    public boolean getOptimizeHuffmanTables() {
        return this.optimizeHuffman;
    }

    public JPEGQTable[] getQTables() {
        JPEGQTable[] jPEGQTableArr = this.qTables;
        if (jPEGQTableArr != null) {
            return (JPEGQTable[]) jPEGQTableArr.clone();
        }
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriteParam
    public boolean isCompressionLossless() {
        if (getCompressionMode() == 2) {
            return false;
        }
        throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
    }

    public void setEncodeTables(JPEGQTable[] jPEGQTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2) {
        if (jPEGQTableArr == null || jPEGHuffmanTableArr == null || jPEGHuffmanTableArr2 == null || jPEGQTableArr.length > 4 || jPEGHuffmanTableArr.length > 4 || jPEGHuffmanTableArr2.length > 4 || jPEGHuffmanTableArr.length != jPEGHuffmanTableArr2.length) {
            throw new IllegalArgumentException("Invalid JPEG table arrays");
        }
        this.qTables = (JPEGQTable[]) jPEGQTableArr.clone();
        this.DCHuffmanTables = (JPEGHuffmanTable[]) jPEGHuffmanTableArr.clone();
        this.ACHuffmanTables = (JPEGHuffmanTable[]) jPEGHuffmanTableArr2.clone();
    }

    public void setOptimizeHuffmanTables(boolean z) {
        this.optimizeHuffman = z;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriteParam
    public void unsetCompression() {
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        this.compressionQuality = 0.75f;
    }

    public void unsetEncodeTables() {
        this.qTables = null;
        this.DCHuffmanTables = null;
        this.ACHuffmanTables = null;
    }
}
