package com.yubico.yubikit.core.util;

import com.yubico.yubikit.core.application.BadResponseException;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Tlvs {
    public static List<Tlv> decodeList(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ArrayList arrayList = new ArrayList();
        while (byteBufferWrap.hasRemaining()) {
            arrayList.add(Tlv.parseFrom(byteBufferWrap));
        }
        return arrayList;
    }

    public static Map<Integer, byte[]> decodeMap(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (byteBufferWrap.hasRemaining()) {
            Tlv from = Tlv.parseFrom(byteBufferWrap);
            linkedHashMap.put(Integer.valueOf(from.getTag()), from.getValue());
        }
        return linkedHashMap;
    }

    public static byte[] encodeList(Iterable<? extends Tlv> iterable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Iterator<? extends Tlv> it = iterable.iterator();
        while (it.hasNext()) {
            byte[] bytes = it.next().getBytes();
            byteArrayOutputStream.write(bytes, 0, bytes.length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] encodeMap(Map<Integer, byte[]> map) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
            byte[] bytes = new Tlv(entry.getKey().intValue(), entry.getValue()).getBytes();
            byteArrayOutputStream.write(bytes, 0, bytes.length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] unpackValue(int i, byte[] bArr) throws BadResponseException {
        Tlv tlv = Tlv.parse(bArr, 0, bArr.length);
        if (tlv.getTag() == i) {
            return tlv.getValue();
        }
        throw new BadResponseException(String.format("Expected tag: %02x, got %02x", Integer.valueOf(i), Integer.valueOf(tlv.getTag())));
    }
}
