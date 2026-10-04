package com.samsung.android.support.senl.p148nt.model.assist.common;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.ByteStreamsKt;
import kotlin.p196io.CloseableKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/common/ImageContentExtractorUtils;", "", "<init>", "()V", "extractContentData", "", "filePath", "", "startsWith", "", "array", "prefix", "extractJpegContentData", "fileBytes", "extractPngContentData", "findMarkerIndex", "", "data", "marker", TextConst.KEY_START_INDEX, "getFileByteArray", "pngPath", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageContentExtractorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageContentExtractorUtils.kt\ncom/samsung/android/support/senl/nt/model/assist/common/ImageContentExtractorUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1#2:98\n1869#3,2:99\n*S KotlinDebug\n*F\n+ 1 ImageContentExtractorUtils.kt\ncom/samsung/android/support/senl/nt/model/assist/common/ImageContentExtractorUtils\n*L\n69#1:99,2\n*E\n"})
public final class ImageContentExtractorUtils {

    @NotNull
    public static final ImageContentExtractorUtils INSTANCE = new ImageContentExtractorUtils();

    private ImageContentExtractorUtils() {
    }

    private final byte[] extractJpegContentData(byte[] fileBytes) {
        int iFindMarkerIndex;
        int iFindMarkerIndex$default = findMarkerIndex$default(this, fileBytes, JPEG.SOS, 0, 4, null);
        if (iFindMarkerIndex$default == -1 || (iFindMarkerIndex = findMarkerIndex(fileBytes, JPEG.EOI, iFindMarkerIndex$default)) == -1) {
            return null;
        }
        return ArraysKt.copyOfRange(fileBytes, iFindMarkerIndex$default, iFindMarkerIndex);
    }

    private final byte[] extractPngContentData(byte[] fileBytes) {
        int i;
        ArrayList<byte[]> arrayList = new ArrayList();
        int i2 = 8;
        while (true) {
            int i4 = i2 + 8;
            try {
                if (i4 > fileBytes.length) {
                    break;
                }
                int i5 = ((fileBytes[i2] & 255) << 24) | ((fileBytes[i2 + 1] & 255) << 16) | ((fileBytes[i2 + 2] & 255) << 8) | (fileBytes[i2 + 3] & 255);
                if (Intrinsics.areEqual(new String(ArraysKt.copyOfRange(fileBytes, i2 + 4, i4), Charsets.UTF_8), "IDAT") && (i = i4 + i5) <= fileBytes.length) {
                    arrayList.add(ArraysKt.copyOfRange(fileBytes, i4, i));
                }
                i2 += i5 + 12;
            } catch (Exception unused) {
                return null;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (byte[] bArr2 : arrayList) {
            ArraysKt___ArraysJvmKt.copyInto$default(bArr2, bArr, length2, 0, 0, 12, (Object) null);
            length2 += bArr2.length;
        }
        return bArr;
    }

    private final int findMarkerIndex(byte[] data, int marker, int startIndex) {
        byte[] bArr = {-1, (byte) marker};
        int length = data.length - 1;
        while (startIndex < length) {
            if (data[startIndex] == bArr[0] && data[startIndex + 1] == bArr[1]) {
                return startIndex;
            }
            startIndex++;
        }
        return -1;
    }

    public static /* synthetic */ int findMarkerIndex$default(ImageContentExtractorUtils imageContentExtractorUtils, byte[] bArr, int i, int i2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        return imageContentExtractorUtils.findMarkerIndex(bArr, i, i2);
    }

    private final byte[] getFileByteArray(String pngPath) {
        FileInputStream fileInputStream = new FileInputStream(new File(pngPath));
        try {
            byte[] bytes = ByteStreamsKt.readBytes(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return bytes;
        } finally {
        }
    }

    private final boolean startsWith(byte[] array, byte[] prefix) {
        if (prefix.length > array.length) {
            return false;
        }
        int length = prefix.length;
        for (int i = 0; i < length; i++) {
            if (array[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final byte[] extractContentData(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        byte[] fileByteArray = getFileByteArray(filePath);
        byte[] bArr = {-1, -40, -1};
        if (startsWith(fileByteArray, new byte[]{-119, 80, 78, 71, 13, 10, 26, 10})) {
            return extractPngContentData(fileByteArray);
        }
        if (startsWith(fileByteArray, bArr)) {
            return extractJpegContentData(fileByteArray);
        }
        return null;
    }
}
