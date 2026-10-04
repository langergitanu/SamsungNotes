package com.samsung.android.support.senl.docscan.common;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/Constant;", "", "<init>", "()V", "DOC_SCAN_CACHE_FOLDER_NAME", "", "DOC_SCAN_CACHE_DIR", "getDOC_SCAN_CACHE_DIR", "()Ljava/lang/String;", "DOC_SCAN_THUMBNAIL_PATH", "DOC_SCAN_EDIT_PATH", "DOC_SCAN_FILE_PREFIX", "JPEG_EXTENSION", "BITMAP_SAMPLE_SIZE_THUMBNAIL", "", "BITMAP_SAMPLE_SIZE_RECTIFIED_IMAGE", "THUMBNAIL_COMPRESS_QUALITY", "DOC_SCAN_COMPRESS_QUALITY", Constant.INTENT_PATH_TO_SAVE, Constant.INTENT_SDOC_UUID, Constant.PREF_DOCUMENT_SCAN, "PREF_KEY_CAMERA_FLASH_MODE", "KEY_DOC_SCAN_DATA_LIST", "MAX_DOC_SCAN", "MENU_SELECT_SKIP_TIME", "FOCUSING_SKIP_TIME", "CAMERA_FRAGMENT", "RECTIFY_LIST_FRAGMENT", "PORTRAIT", "LANDSCAPE", "REVERSE_LANDSCAPE", "REVERSE_PORTRAIT", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constant {
    public static final int BITMAP_SAMPLE_SIZE_RECTIFIED_IMAGE = 1;
    public static final int BITMAP_SAMPLE_SIZE_THUMBNAIL = 4;

    @NotNull
    public static final String CAMERA_FRAGMENT = "CameraFragment";

    @NotNull
    public static final String DOC_SCAN_CACHE_FOLDER_NAME = "docScanCache";
    public static final int DOC_SCAN_COMPRESS_QUALITY = 100;

    @NotNull
    public static final String DOC_SCAN_EDIT_PATH = "edit";

    @NotNull
    public static final String DOC_SCAN_FILE_PREFIX = "scan_";

    @NotNull
    public static final String DOC_SCAN_THUMBNAIL_PATH = "thumbnail";
    public static final int FOCUSING_SKIP_TIME = 500;

    @NotNull
    public static final String INTENT_PATH_TO_SAVE = "INTENT_PATH_TO_SAVE";

    @NotNull
    public static final String INTENT_SDOC_UUID = "INTENT_SDOC_UUID";

    @NotNull
    public static final String JPEG_EXTENSION = ".jpg";

    @NotNull
    public static final String KEY_DOC_SCAN_DATA_LIST = "doc_scan_data_list";
    public static final int LANDSCAPE = 90;
    public static final int MAX_DOC_SCAN = 50;
    public static final int MENU_SELECT_SKIP_TIME = 1000;
    public static final int PORTRAIT = 0;

    @NotNull
    public static final String PREF_DOCUMENT_SCAN = "PREF_DOCUMENT_SCAN";

    @NotNull
    public static final String PREF_KEY_CAMERA_FLASH_MODE = "pref_camera_flash_mode";

    @NotNull
    public static final String RECTIFY_LIST_FRAGMENT = "RectifyListFragment";
    public static final int REVERSE_LANDSCAPE = -90;
    public static final int REVERSE_PORTRAIT = 180;
    public static final int THUMBNAIL_COMPRESS_QUALITY = 95;

    @NotNull
    public static final Constant INSTANCE = new Constant();

    @NotNull
    private static final String DOC_SCAN_CACHE_DIR = AbstractC0541b.m772n("docScanCache", File.separator);

    private Constant() {
    }

    @NotNull
    public final String getDOC_SCAN_CACHE_DIR() {
        return DOC_SCAN_CACHE_DIR;
    }
}
