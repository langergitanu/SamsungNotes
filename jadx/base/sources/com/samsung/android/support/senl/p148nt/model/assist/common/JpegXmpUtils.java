package com.samsung.android.support.senl.p148nt.model.assist.common;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.options.SerializeOptions;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0014H\u0002J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J(\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/common/JpegXmpUtils;", "", "<init>", "()V", "XMP_HEADER_SIZE", "", "XMP_HEADER", "", "MAX_XMP_BUFFER_SIZE", "M_SOI", "M_APP1", "M_SOS", "AIGC_NS_BASE64", "AIGC_NS_PREFIX", "AIGC_KEY", "writeXmpToJpegFile", "", "jpegPath", "aigcJson", "extractJpegXMPMeta", "Lcom/adobe/internal/xmp/XMPMeta;", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "is", "Ljava/io/InputStream;", "getXMPContentEnd", "data", "", "hasXMPHeader", "parse", "", "Lcom/samsung/android/support/senl/nt/model/assist/common/JpegXmpUtils$Section;", "readMetaOnly", "writeJpegXMPMeta", "meta", "writeJpegFile", "", NetworkConfig.CLIENTS_OS, "Ljava/io/OutputStream;", "sections", "insertXMPSection", "Section", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nJpegXmpUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JpegXmpUtils.kt\ncom/samsung/android/support/senl/nt/model/assist/common/JpegXmpUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,278:1\n1#2:279\n*E\n"})
public final class JpegXmpUtils {

    @NotNull
    private static final String AIGC_KEY = "AIGC";

    @NotNull
    private static final String AIGC_NS_BASE64 = "aHR0cDovL3d3dy50YzI2MC5vcmcuY24vbnMvQUlHQy8xLjAvCg==";

    @NotNull
    private static final String AIGC_NS_PREFIX = "TC260";

    @NotNull
    public static final JpegXmpUtils INSTANCE = new JpegXmpUtils();
    private static final int MAX_XMP_BUFFER_SIZE = 65502;
    private static final int M_APP1 = 225;
    private static final int M_SOI = 216;
    private static final int M_SOS = 218;

    @NotNull
    private static final String XMP_HEADER = "http://ns.adobe.com/xap/1.0/\u0000";
    private static final int XMP_HEADER_SIZE = 29;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/common/JpegXmpUtils$Section;", "", "<init>", "()V", "marker", "", "getMarker", "()I", "setMarker", "(I)V", "length", "getLength", "setLength", "data", "", "getData", "()[B", "setData", "([B)V", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Section {
        public byte[] data;
        private int length;
        private int marker;

        @NotNull
        public final byte[] getData() {
            byte[] bArr = this.data;
            if (bArr != null) {
                return bArr;
            }
            Intrinsics.throwUninitializedPropertyAccessException("data");
            return null;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getMarker() {
            return this.marker;
        }

        public final void setData(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.data = bArr;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final void setMarker(int i) {
            this.marker = i;
        }
    }

    private JpegXmpUtils() {
    }

    private final XMPMeta extractJpegXMPMeta(String filename) {
        try {
            return extractJpegXMPMeta(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final int getXMPContentEnd(byte[] data) {
        for (int length = data.length - 1; length > 0; length--) {
            if (data[length] == 62 && data[length - 1] != 63) {
                return length + 1;
            }
        }
        return data.length;
    }

    private final boolean hasXMPHeader(byte[] data) {
        byte[] bArr;
        Charset charsetForName;
        if (data.length < 29) {
            return false;
        }
        try {
            bArr = new byte[29];
            System.arraycopy(data, 0, bArr, 0, 29);
            charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        } catch (UnsupportedEncodingException unused) {
        }
        return Intrinsics.areEqual(new String(bArr, charsetForName), XMP_HEADER);
    }

    private final List<Section> insertXMPSection(List<Section> sections, XMPMeta meta) {
        if (sections != null) {
            if (sections.size() > 1) {
                try {
                    SerializeOptions serializeOptions = new SerializeOptions();
                    serializeOptions.setUseCompactFormat(true);
                    serializeOptions.setOmitPacketWrapper(true);
                    byte[] bArrSerializeToBuffer = XMPMetaFactory.serializeToBuffer(meta, serializeOptions);
                    Intrinsics.checkNotNullExpressionValue(bArrSerializeToBuffer, "serializeToBuffer(...)");
                    if (bArrSerializeToBuffer.length > MAX_XMP_BUFFER_SIZE) {
                        return null;
                    }
                    int length = bArrSerializeToBuffer.length;
                    byte[] bArr = new byte[length + 29];
                    byte[] bytes = XMP_HEADER.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    System.arraycopy(bytes, 0, bArr, 0, 29);
                    System.arraycopy(bArrSerializeToBuffer, 0, bArr, 29, bArrSerializeToBuffer.length);
                    Section section = new Section();
                    section.setMarker(225);
                    section.setLength(length + 31);
                    section.setData(bArr);
                    int size = sections.size();
                    for (int i = 0; i < size; i++) {
                        if (sections.get(i).getMarker() == 225 && hasXMPHeader(sections.get(i).getData())) {
                            sections.set(i, section);
                            return sections;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    int i2 = sections.get(0).getMarker() != 225 ? 0 : 1;
                    arrayList.addAll(sections.subList(0, i2));
                    arrayList.add(section);
                    arrayList.addAll(sections.subList(i2, sections.size()));
                    return arrayList;
                } catch (XMPException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r11 != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r11 = new com.samsung.android.support.senl.nt.model.assist.common.JpegXmpUtils.Section();
        r11.setMarker(r4);
        r11.setLength(-1);
        r11.setData(new byte[r10.available()]);
        r10.read(r11.getData(), 0, r11.getData().length);
        r1.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<Section> parse(InputStream is, boolean readMetaOnly) {
        ArrayList arrayList;
        int i;
        if (is == null) {
            return null;
        }
        try {
            try {
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    is.close();
                } catch (IOException unused) {
                }
                return null;
            }
        } finally {
            try {
                is.close();
            } catch (IOException unused2) {
            }
        }
        if (is.read() == 255 && is.read() == 216) {
            arrayList = new ArrayList();
            Ref.IntRef intRef = new Ref.IntRef();
            while (true) {
                int i2 = is.read();
                intRef.element = i2;
                if (i2 == -1) {
                    try {
                        is.close();
                    } catch (IOException unused3) {
                    }
                    return arrayList;
                }
                if (i2 != 255) {
                    return null;
                }
                do {
                    i = is.read();
                    intRef.element = i;
                } while (i == 255);
                if (i == -1) {
                    try {
                        is.close();
                    } catch (IOException unused4) {
                    }
                    return null;
                }
                if (i == 218) {
                    break;
                }
                int i4 = is.read();
                int i5 = is.read();
                if (i4 != -1 && i5 != -1) {
                    int i6 = (i4 << 8) | i5;
                    if (!readMetaOnly || intRef.element == 225) {
                        Section section = new Section();
                        section.setMarker(i);
                        section.setLength(i6);
                        int i7 = i6 - 2;
                        section.setData(new byte[i7]);
                        is.read(section.getData(), 0, i7);
                        arrayList.add(section);
                    } else {
                        is.skip(i6 - 2);
                    }
                }
                is.close();
            }
            try {
                is.close();
            } catch (IOException unused5) {
            }
            return null;
        }
        try {
            is.close();
        } catch (IOException unused6) {
        }
        return null;
        return arrayList;
    }

    private final void writeJpegFile(OutputStream os, List<Section> sections) throws IOException {
        os.write(255);
        os.write(216);
        for (Section section : sections) {
            os.write(255);
            os.write(section.getMarker());
            if (section.getLength() > 0) {
                int length = section.getLength() >> 8;
                int length2 = section.getLength() & 255;
                os.write(length);
                os.write(length2);
            }
            os.write(section.getData());
        }
    }

    private final boolean writeJpegXMPMeta(String filename, XMPMeta meta) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            List<Section> listInsertXMPSection = insertXMPSection(parse(new FileInputStream(filename), false), meta);
            if (listInsertXMPSection == null) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(filename);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                writeJpegFile(fileOutputStream, listInsertXMPSection);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public final boolean writeXmpToJpegFile(@NotNull String jpegPath, @NotNull String aigcJson) {
        Intrinsics.checkNotNullParameter(jpegPath, "jpegPath");
        Intrinsics.checkNotNullParameter(aigcJson, "aigcJson");
        try {
            String string = StringsKt.trim((CharSequence) Base64Utils.decodeBase64(AIGC_NS_BASE64)).toString();
            XMPMetaFactory.getSchemaRegistry().registerNamespace(string, AIGC_NS_PREFIX);
            XMPMeta xMPMetaExtractJpegXMPMeta = extractJpegXMPMeta(jpegPath);
            if (xMPMetaExtractJpegXMPMeta == null) {
                xMPMetaExtractJpegXMPMeta = XMPMetaFactory.create();
            }
            xMPMetaExtractJpegXMPMeta.setProperty(string, AIGC_KEY, aigcJson);
            Intrinsics.checkNotNull(xMPMetaExtractJpegXMPMeta);
            return writeJpegXMPMeta(jpegPath, xMPMetaExtractJpegXMPMeta);
        } catch (Exception unused) {
            return false;
        }
    }

    private final XMPMeta extractJpegXMPMeta(InputStream is) {
        List<Section> list = parse(is, true);
        if (list != null) {
            Iterator<Section> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Section next = it.next();
                if (hasXMPHeader(next.getData())) {
                    int xMPContentEnd = getXMPContentEnd(next.getData()) - 29;
                    byte[] bArr = new byte[xMPContentEnd];
                    System.arraycopy(next.getData(), 29, bArr, 0, xMPContentEnd);
                    try {
                        return XMPMetaFactory.parseFromBuffer(bArr);
                    } catch (XMPException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }
}
