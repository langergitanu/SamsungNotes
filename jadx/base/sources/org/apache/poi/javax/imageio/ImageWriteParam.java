package org.apache.poi.javax.imageio;

import java.util.Locale;
import org.apache.poi.java.awt.Dimension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ImageWriteParam extends IIOParam {
    private static final int MAX_MODE = 3;
    public static final int MODE_COPY_FROM_METADATA = 3;
    public static final int MODE_DEFAULT = 1;
    public static final int MODE_DISABLED = 0;
    public static final int MODE_EXPLICIT = 2;
    protected boolean canOffsetTiles;
    protected boolean canWriteCompressed;
    protected boolean canWriteProgressive;
    protected boolean canWriteTiles;
    protected int compressionMode;
    protected float compressionQuality;
    protected String compressionType;
    protected String[] compressionTypes;
    protected Locale locale;
    protected Dimension[] preferredTileSizes;
    protected int progressiveMode;
    protected int tileGridXOffset;
    protected int tileGridYOffset;
    protected int tileHeight;
    protected int tileWidth;
    protected int tilingMode;
    protected boolean tilingSet;

    public ImageWriteParam() {
        this.canWriteTiles = false;
        this.tilingMode = 3;
        this.preferredTileSizes = null;
        this.tilingSet = false;
        this.tileWidth = 0;
        this.tileHeight = 0;
        this.canOffsetTiles = false;
        this.tileGridXOffset = 0;
        this.tileGridYOffset = 0;
        this.canWriteProgressive = false;
        this.progressiveMode = 3;
        this.canWriteCompressed = false;
        this.compressionMode = 3;
        this.compressionTypes = null;
        this.compressionType = null;
        this.compressionQuality = 1.0f;
        this.locale = null;
    }

    private static Dimension[] clonePreferredTileSizes(Dimension[] dimensionArr) {
        if (dimensionArr == null) {
            return null;
        }
        Dimension[] dimensionArr2 = new Dimension[dimensionArr.length];
        for (int i = 0; i < dimensionArr.length; i++) {
            dimensionArr2[i] = new Dimension(dimensionArr[i]);
        }
        return dimensionArr2;
    }

    public boolean canOffsetTiles() {
        return this.canOffsetTiles;
    }

    public boolean canWriteCompressed() {
        return this.canWriteCompressed;
    }

    public boolean canWriteProgressive() {
        return this.canWriteProgressive;
    }

    public boolean canWriteTiles() {
        return this.canWriteTiles;
    }

    public float getBitRate(float f) {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() != null && getCompressionType() == null) {
            throw new IllegalStateException("No compression type set!");
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Quality out-of-bounds!");
        }
        return -1.0f;
    }

    public int getCompressionMode() {
        if (canWriteCompressed()) {
            return this.compressionMode;
        }
        throw new UnsupportedOperationException("Compression not supported.");
    }

    public float getCompressionQuality() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return this.compressionQuality;
        }
        throw new IllegalStateException("No compression type set!");
    }

    public String[] getCompressionQualityDescriptions() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return null;
        }
        throw new IllegalStateException("No compression type set!");
    }

    public float[] getCompressionQualityValues() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return null;
        }
        throw new IllegalStateException("No compression type set!");
    }

    public String getCompressionType() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() == 2) {
            return this.compressionType;
        }
        throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
    }

    public String[] getCompressionTypes() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported");
        }
        String[] strArr = this.compressionTypes;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getLocalizedCompressionTypeName() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionType() != null) {
            return getCompressionType();
        }
        throw new IllegalStateException("No compression type set!");
    }

    public Dimension[] getPreferredTileSizes() {
        if (canWriteTiles()) {
            return clonePreferredTileSizes(this.preferredTileSizes);
        }
        throw new UnsupportedOperationException("Tiling not supported");
    }

    public int getProgressiveMode() {
        if (canWriteProgressive()) {
            return this.progressiveMode;
        }
        throw new UnsupportedOperationException("Progressive output not supported");
    }

    public int getTileGridXOffset() {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        if (this.tilingSet) {
            return this.tileGridXOffset;
        }
        throw new IllegalStateException("Tiling parameters not set!");
    }

    public int getTileGridYOffset() {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        if (this.tilingSet) {
            return this.tileGridYOffset;
        }
        throw new IllegalStateException("Tiling parameters not set!");
    }

    public int getTileHeight() {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        if (this.tilingSet) {
            return this.tileHeight;
        }
        throw new IllegalStateException("Tiling parameters not set!");
    }

    public int getTileWidth() {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        if (this.tilingSet) {
            return this.tileWidth;
        }
        throw new IllegalStateException("Tiling parameters not set!");
    }

    public int getTilingMode() {
        if (canWriteTiles()) {
            return this.tilingMode;
        }
        throw new UnsupportedOperationException("Tiling not supported");
    }

    public boolean isCompressionLossless() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() == null || getCompressionType() != null) {
            return true;
        }
        throw new IllegalStateException("No compression type set!");
    }

    public void setCompressionMode(int i) {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported.");
        }
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Illegal value for mode!");
        }
        this.compressionMode = i;
        if (i == 2) {
            unsetCompression();
        }
    }

    public void setCompressionQuality(float f) {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        if (getCompressionTypes() != null && getCompressionType() == null) {
            throw new IllegalStateException("No compression type set!");
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Quality out-of-bounds!");
        }
        this.compressionQuality = f;
    }

    public void setCompressionType(String str) {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        String[] compressionTypes = getCompressionTypes();
        if (compressionTypes == null) {
            throw new UnsupportedOperationException("No settable compression types");
        }
        if (str != null) {
            for (String str2 : compressionTypes) {
                if (!str.equals(str2)) {
                }
            }
            throw new IllegalArgumentException("Unknown compression type!");
        }
        this.compressionType = str;
    }

    public void setProgressiveMode(int i) {
        if (!canWriteProgressive()) {
            throw new UnsupportedOperationException("Progressive output not supported");
        }
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Illegal value for mode!");
        }
        if (i == 2) {
            throw new IllegalArgumentException("MODE_EXPLICIT not supported for progressive output");
        }
        this.progressiveMode = i;
    }

    public void setTiling(int i, int i2, int i4, int i5) {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("tile dimensions are non-positive!");
        }
        int i6 = 0;
        boolean z = (i4 == 0 && i5 == 0) ? false : true;
        if (!canOffsetTiles() && z) {
            throw new UnsupportedOperationException("Can't offset tiles!");
        }
        if (this.preferredTileSizes != null) {
            while (true) {
                Dimension[] dimensionArr = this.preferredTileSizes;
                if (i6 >= dimensionArr.length) {
                    break;
                }
                Dimension dimension = dimensionArr[i6];
                Dimension dimension2 = dimensionArr[i6 + 1];
                if (i < dimension.width || i > dimension2.width || i2 < dimension.height || i2 > dimension2.height) {
                    break;
                } else {
                    i6 += 2;
                }
            }
            throw new IllegalArgumentException("Illegal tile size!");
        }
        this.tilingSet = true;
        this.tileWidth = i;
        this.tileHeight = i2;
        this.tileGridXOffset = i4;
        this.tileGridYOffset = i5;
    }

    public void setTilingMode(int i) {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Illegal value for mode!");
        }
        this.tilingMode = i;
        if (i == 2) {
            unsetTiling();
        }
    }

    public void unsetCompression() {
        if (!canWriteCompressed()) {
            throw new UnsupportedOperationException("Compression not supported");
        }
        if (getCompressionMode() != 2) {
            throw new IllegalStateException("Compression mode not MODE_EXPLICIT!");
        }
        this.compressionType = null;
        this.compressionQuality = 1.0f;
    }

    public void unsetTiling() {
        if (!canWriteTiles()) {
            throw new UnsupportedOperationException("Tiling not supported!");
        }
        if (getTilingMode() != 2) {
            throw new IllegalStateException("Tiling mode not MODE_EXPLICIT!");
        }
        this.tilingSet = false;
        this.tileWidth = 0;
        this.tileHeight = 0;
        this.tileGridXOffset = 0;
        this.tileGridYOffset = 0;
    }

    public ImageWriteParam(Locale locale) {
        this.canWriteTiles = false;
        this.tilingMode = 3;
        this.preferredTileSizes = null;
        this.tilingSet = false;
        this.tileWidth = 0;
        this.tileHeight = 0;
        this.canOffsetTiles = false;
        this.tileGridXOffset = 0;
        this.tileGridYOffset = 0;
        this.canWriteProgressive = false;
        this.progressiveMode = 3;
        this.canWriteCompressed = false;
        this.compressionMode = 3;
        this.compressionTypes = null;
        this.compressionType = null;
        this.compressionQuality = 1.0f;
        this.locale = locale;
    }
}
