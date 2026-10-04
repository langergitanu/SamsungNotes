package org.apache.poi.javax.imageio.plugins.jpeg;

import org.apache.poi.javax.imageio.ImageReadParam;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JPEGImageReadParam extends ImageReadParam {
    private JPEGQTable[] qTables = null;
    private JPEGHuffmanTable[] DCHuffmanTables = null;
    private JPEGHuffmanTable[] ACHuffmanTables = null;

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

    public JPEGHuffmanTable[] getDCHuffmanTables() {
        JPEGHuffmanTable[] jPEGHuffmanTableArr = this.DCHuffmanTables;
        if (jPEGHuffmanTableArr != null) {
            return (JPEGHuffmanTable[]) jPEGHuffmanTableArr.clone();
        }
        return null;
    }

    public JPEGQTable[] getQTables() {
        JPEGQTable[] jPEGQTableArr = this.qTables;
        if (jPEGQTableArr != null) {
            return (JPEGQTable[]) jPEGQTableArr.clone();
        }
        return null;
    }

    public void setDecodeTables(JPEGQTable[] jPEGQTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2) {
        if (jPEGQTableArr == null || jPEGHuffmanTableArr == null || jPEGHuffmanTableArr2 == null || jPEGQTableArr.length > 4 || jPEGHuffmanTableArr.length > 4 || jPEGHuffmanTableArr2.length > 4 || jPEGHuffmanTableArr.length != jPEGHuffmanTableArr2.length) {
            throw new IllegalArgumentException("Invalid JPEG table arrays");
        }
        this.qTables = (JPEGQTable[]) jPEGQTableArr.clone();
        this.DCHuffmanTables = (JPEGHuffmanTable[]) jPEGHuffmanTableArr.clone();
        this.ACHuffmanTables = (JPEGHuffmanTable[]) jPEGHuffmanTableArr2.clone();
    }

    public void unsetDecodeTables() {
        this.qTables = null;
        this.DCHuffmanTables = null;
        this.ACHuffmanTables = null;
    }
}
