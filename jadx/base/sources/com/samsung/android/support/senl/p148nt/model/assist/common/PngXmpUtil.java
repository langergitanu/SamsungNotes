package com.samsung.android.support.senl.p148nt.model.assist.common;

import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.options.SerializeOptions;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.FilesKt;
import kotlin.p196io.TextStreamsKt;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020\rH\u0002J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/common/PngXmpUtil;", "", "<init>", "()V", "AIGC_NS_BASE64", "", "AIGC_NS_PREFIX", "AIGC_KEY", "writeXmpToPngFile", "", DBSchema.DocumentThumbnail.IMAGE_PATH, "aigcJson", "insertXmpIntoPngUsingXmpCore", "", "originalBytes", "xmpData", "createOptimizedPngXmpChunk", "createUncompressedXmpChunk", Bixby2Constants.BIXBY_PARAM_KEYWORD, "createCompressedXmpChunk", "createPngChunk", "chunkType", "data", "insertChunkIntoPng", "chunkToInsert", "compressData", "calculatePngCrc", "extractXmpFromPngFile", "Lcom/adobe/internal/xmp/XMPMeta;", "extractXmpFromPngBytes", "pngBytes", "findNullByteFrom", "", "startPos", "extractXmpDataFromITXtChunk", "chunkData", "decompressData", "compressedData", "removeExistingXmpChunks", "isXmpITXtChunk", "", "insertXmpIntoPngBasic", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PngXmpUtil {

    @NotNull
    private static final String AIGC_KEY = "AIGC";

    @NotNull
    private static final String AIGC_NS_BASE64 = "aHR0cDovL3d3dy50YzI2MC5vcmcuY24vbnMvQUlHQy8xLjAvCg==";

    @NotNull
    private static final String AIGC_NS_PREFIX = "TC260";

    @NotNull
    public static final PngXmpUtil INSTANCE = new PngXmpUtil();

    private PngXmpUtil() {
    }

    private final byte[] calculatePngCrc(byte[] data) {
        CRC32 crc32 = new CRC32();
        crc32.update(data);
        int value = (int) crc32.getValue();
        return new byte[]{(byte) ((value >> 24) & 255), (byte) ((value >> 16) & 255), (byte) ((value >> 8) & 255), (byte) (value & 255)};
    }

    private final byte[] compressData(byte[] data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(data);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(deflaterOutputStream, null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } finally {
        }
    }

    private final byte[] createCompressedXmpChunk(String keyword, byte[] xmpData) throws IOException {
        byte[] bytes = keyword.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrCompressData = compressData(xmpData);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(bArrCompressData);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNull(byteArray);
        return createPngChunk("iTXt", byteArray);
    }

    private final byte[] createOptimizedPngXmpChunk(byte[] xmpData) {
        return xmpData.length > 65535 ? createCompressedXmpChunk("XML:com.adobe.xmp", xmpData) : createUncompressedXmpChunk("XML:com.adobe.xmp", xmpData);
    }

    private final byte[] createPngChunk(String chunkType, byte[] data) {
        byte[] bArr = {(byte) ((data.length >> 24) & 255), (byte) ((data.length >> 16) & 255), (byte) ((data.length >> 8) & 255), (byte) (data.length & 255)};
        byte[] bytes = chunkType.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(bArr, bytes), data), calculatePngCrc(ArraysKt.plus(bytes, data)));
    }

    private final byte[] createUncompressedXmpChunk(String keyword, byte[] xmpData) throws IOException {
        byte[] bytes = keyword.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(xmpData);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNull(byteArray);
        return createPngChunk("iTXt", byteArray);
    }

    private final String decompressData(byte[] compressedData) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(compressedData));
        try {
            String text = TextStreamsKt.readText(new InputStreamReader(inflaterInputStream, Charsets.UTF_8));
            CloseableKt.closeFinally(inflaterInputStream, null);
            return text;
        } finally {
        }
    }

    private final String extractXmpDataFromITXtChunk(byte[] chunkData) {
        int iFindNullByteFrom;
        int iFindNullByteFrom2;
        try {
            int iIndexOf = ArraysKt.indexOf(chunkData, (byte) 0);
            if (iIndexOf == -1) {
                return null;
            }
            byte[] bArrSliceArray = ArraysKt.sliceArray(chunkData, new IntRange(0, iIndexOf - 1));
            Charset charset = Charsets.UTF_8;
            String str = new String(bArrSliceArray, charset);
            int i = iIndexOf + 1;
            if (!Intrinsics.areEqual(str, "XML:com.adobe.xmp") || (iFindNullByteFrom = findNullByteFrom(chunkData, iIndexOf + 3)) == -1 || (iFindNullByteFrom2 = findNullByteFrom(chunkData, iFindNullByteFrom + 1)) == -1) {
                return null;
            }
            byte[] bArrSliceArray2 = ArraysKt.sliceArray(chunkData, new IntRange(iFindNullByteFrom2 + 1, chunkData.length - 1));
            return chunkData[i] == 1 ? decompressData(bArrSliceArray2) : new String(bArrSliceArray2, charset);
        } catch (Exception unused) {
            return null;
        }
    }

    private final XMPMeta extractXmpFromPngBytes(byte[] pngBytes) {
        String strExtractXmpDataFromITXtChunk;
        int i = 8;
        while (true) {
            int i2 = i + 8;
            try {
                if (i2 > pngBytes.length) {
                    break;
                }
                int i4 = ((pngBytes[i] & 255) << 24) | ((pngBytes[i + 1] & 255) << 16) | ((pngBytes[i + 2] & 255) << 8) | (pngBytes[i + 3] & 255);
                String str = new String(ArraysKt.sliceArray(pngBytes, new IntRange(i + 4, i + 7)), Charsets.UTF_8);
                int i5 = i4 + i2;
                i = i5 + 4;
                if (i > pngBytes.length) {
                    break;
                }
                if (Intrinsics.areEqual(str, "iTXt") && (strExtractXmpDataFromITXtChunk = extractXmpDataFromITXtChunk(ArraysKt.sliceArray(pngBytes, new IntRange(i2, i5 - 1)))) != null) {
                    return XMPMetaFactory.parseFromString(strExtractXmpDataFromITXtChunk);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private final XMPMeta extractXmpFromPngFile(String imagePath) {
        try {
            File file = new File(imagePath);
            if (file.exists()) {
                return extractXmpFromPngBytes(FilesKt.readBytes(file));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final int findNullByteFrom(byte[] data, int startPos) {
        int length = data.length;
        while (startPos < length) {
            if (data[startPos] == 0) {
                return startPos;
            }
            startPos++;
        }
        return -1;
    }

    private final byte[] insertChunkIntoPng(byte[] originalBytes, byte[] chunkToInsert) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        if (originalBytes.length >= 8) {
            byteArrayOutputStream.write(originalBytes, 0, 8);
        }
        int i = 8;
        while (true) {
            int i2 = i + 8;
            if (i2 > originalBytes.length) {
                break;
            }
            int i4 = ((originalBytes[i] & 255) << 24) | ((originalBytes[i + 1] & 255) << 16) | ((originalBytes[i + 2] & 255) << 8) | (originalBytes[i + 3] & 255);
            String str = new String(ArraysKt.sliceArray(originalBytes, new IntRange(i + 4, i + 7)), Charsets.UTF_8);
            int i5 = i2 + i4 + 4;
            if (i5 > originalBytes.length) {
                break;
            }
            byteArrayOutputStream.write(originalBytes, i, i5 - i);
            if ((Intrinsics.areEqual(str, "IHDR") || Intrinsics.areEqual(str, "IDAT")) && !z) {
                byteArrayOutputStream.write(chunkToInsert);
                z = true;
            }
            i = i5;
        }
        if (!z) {
            byteArrayOutputStream.write(chunkToInsert);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final byte[] insertXmpIntoPngBasic(byte[] originalBytes, byte[] xmpData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        if (originalBytes.length >= 8) {
            byteArrayOutputStream.write(originalBytes, 0, 8);
        }
        int i = 8;
        while (true) {
            int i2 = i + 8;
            if (i2 > originalBytes.length) {
                break;
            }
            int i4 = ((originalBytes[i] & 255) << 24) | ((originalBytes[i + 1] & 255) << 16) | ((originalBytes[i + 2] & 255) << 8) | (originalBytes[i + 3] & 255);
            String str = new String(ArraysKt.sliceArray(originalBytes, new IntRange(i + 4, i + 7)), Charsets.UTF_8);
            int i5 = i2 + i4 + 4;
            if (i5 > originalBytes.length) {
                break;
            }
            byteArrayOutputStream.write(originalBytes, i, i5 - i);
            if ((Intrinsics.areEqual(str, "IHDR") || Intrinsics.areEqual(str, "IDAT")) && !z) {
                byteArrayOutputStream.write(createUncompressedXmpChunk("XML:com.adobe.xmp", xmpData));
                z = true;
            }
            i = i5;
        }
        if (!z) {
            byteArrayOutputStream.write(createUncompressedXmpChunk("XML:com.adobe.xmp", xmpData));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    private final byte[] insertXmpIntoPngUsingXmpCore(byte[] originalBytes, byte[] xmpData) {
        try {
            return insertChunkIntoPng(originalBytes, createOptimizedPngXmpChunk(xmpData));
        } catch (Exception unused) {
            return insertXmpIntoPngBasic(originalBytes, xmpData);
        }
    }

    private final boolean isXmpITXtChunk(byte[] chunkData) {
        try {
            int iIndexOf = ArraysKt.indexOf(chunkData, (byte) 0);
            if (iIndexOf == -1) {
                return false;
            }
            return Intrinsics.areEqual(new String(ArraysKt.sliceArray(chunkData, new IntRange(0, iIndexOf - 1)), Charsets.UTF_8), "XML:com.adobe.xmp");
        } catch (Exception unused) {
            return false;
        }
    }

    private final byte[] removeExistingXmpChunks(byte[] originalBytes) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (originalBytes.length >= 8) {
                byteArrayOutputStream.write(originalBytes, 0, 8);
            }
            int i = 8;
            while (true) {
                int i2 = i + 8;
                if (i2 > originalBytes.length) {
                    break;
                }
                int i4 = ((originalBytes[i] & 255) << 24) | ((originalBytes[i + 1] & 255) << 16) | ((originalBytes[i + 2] & 255) << 8) | (originalBytes[i + 3] & 255);
                String str = new String(ArraysKt.sliceArray(originalBytes, new IntRange(i + 4, i + 7)), Charsets.UTF_8);
                int i5 = i4 + i2;
                int i6 = i5 + 4;
                if (i6 > originalBytes.length) {
                    break;
                }
                if (!Intrinsics.areEqual(str, "iTXt") || !isXmpITXtChunk(ArraysKt.sliceArray(originalBytes, new IntRange(i2, i5 - 1)))) {
                    byteArrayOutputStream.write(originalBytes, i, i6 - i);
                }
                i = i6;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNull(byteArray);
            return byteArray;
        } catch (Exception unused) {
            return originalBytes;
        }
    }

    public final void writeXmpToPngFile(@NotNull String imagePath, @NotNull String aigcJson) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(aigcJson, "aigcJson");
        String strDecodeBase64 = Base64Utils.decodeBase64(AIGC_NS_BASE64);
        XMPMeta xMPMetaExtractXmpFromPngFile = extractXmpFromPngFile(imagePath);
        if (xMPMetaExtractXmpFromPngFile == null) {
            xMPMetaExtractXmpFromPngFile = XMPMetaFactory.create();
        }
        XMPMetaFactory.getSchemaRegistry().registerNamespace(strDecodeBase64, AIGC_NS_PREFIX);
        xMPMetaExtractXmpFromPngFile.setProperty(strDecodeBase64, AIGC_KEY, aigcJson);
        String strSerializeToString = XMPMetaFactory.serializeToString(xMPMetaExtractXmpFromPngFile, new SerializeOptions().setUseCompactFormat(true));
        File file = new File(imagePath);
        byte[] bArrRemoveExistingXmpChunks = removeExistingXmpChunks(FilesKt.readBytes(file));
        Intrinsics.checkNotNull(strSerializeToString);
        byte[] bytes = strSerializeToString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        FilesKt.writeBytes(file, insertXmpIntoPngUsingXmpCore(bArrRemoveExistingXmpChunks, bytes));
    }
}
