package com.samsung.android.support.senl.docscan.rectify.constant;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/constant/RectifyConstant;", "", "<init>", "()V", "KEY_DOC_SCAN_DATA", "", "KEY_CALLER", "KEY_CURRENT_VERTEX_LIST", "TAG_INSIDE_RECTIFY_AREA", "", "TAG_OUTSIDE_RECTIFY_AREA", "NUM_OF_ANGLE", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifyConstant {

    @NotNull
    public static final RectifyConstant INSTANCE = new RectifyConstant();

    @NotNull
    public static final String KEY_CALLER = "key_caller";

    @NotNull
    public static final String KEY_CURRENT_VERTEX_LIST = "key_current_vertex_list";

    @NotNull
    public static final String KEY_DOC_SCAN_DATA = "key_doc_scan_data";
    public static final int NUM_OF_ANGLE = 4;
    public static final int TAG_INSIDE_RECTIFY_AREA = -1;
    public static final int TAG_OUTSIDE_RECTIFY_AREA = -2;

    private RectifyConstant() {
    }
}
