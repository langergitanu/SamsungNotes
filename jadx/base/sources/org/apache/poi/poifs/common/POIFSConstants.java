package org.apache.poi.poifs.common;

import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface POIFSConstants {
    public static final int BIG_BLOCK_MINIMUM_DOCUMENT_SIZE = 4096;
    public static final int DIFAT_SECTOR_BLOCK = -4;
    public static final int END_OF_CHAIN = -2;
    public static final int FAT_SECTOR_BLOCK = -3;
    public static final int LARGER_BIG_BLOCK_SIZE = 4096;
    public static final int LARGEST_REGULAR_SECTOR_NUMBER = -5;
    public static final int PROPERTY_SIZE = 128;
    public static final int SMALLER_BIG_BLOCK_SIZE = 512;
    public static final int SMALL_BLOCK_SIZE = 64;
    public static final int UNUSED_BLOCK = -1;
    public static final POIFSBigBlockSize SMALLER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(512, 9);
    public static final POIFSBigBlockSize LARGER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(4096, 12);
    public static final byte[] OOXML_FILE_HEADER = {80, 75, 3, 4};
    public static final byte[] RAW_XML_FILE_HEADER = {60, Utf8.REPLACEMENT_BYTE, 120, 109, 108};
}
