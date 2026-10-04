package com.samsung.android.support.senl.p148nt.base.common.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/BaseComposerConstants;", "", "<init>", "()V", "PATTERN_FILE_NAME_INVALID_CHARS", "", "DEFAULT_PAGE_COUNT", "", "DOC_BASE_WIDTH", "", "PAGE_HORIZONTAL_MARGIN", "PAGE_VERTICAL_MARGIN", "TEXT_BOX_HORIZONTAL_MARGIN", "TEXT_BOX_VERTICAL_MARGIN", "INDENT_MAX_RATIO", "INDENT_VALUE", "INDENT_MAX", "TABLE_COLUMN_PER_PAGE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseComposerConstants {
    public static final int DEFAULT_PAGE_COUNT = 2;
    public static final float DOC_BASE_WIDTH = 360.0f;
    public static final int INDENT_MAX = 16;
    public static final float INDENT_MAX_RATIO = 0.8f;
    public static final int INDENT_VALUE = 16;

    @NotNull
    public static final BaseComposerConstants INSTANCE = new BaseComposerConstants();
    public static final int PAGE_HORIZONTAL_MARGIN = 16;
    public static final int PAGE_VERTICAL_MARGIN = 10;

    @NotNull
    public static final String PATTERN_FILE_NAME_INVALID_CHARS = "[*/\\\\?:<>.|\"\\v]+";
    public static final int TABLE_COLUMN_PER_PAGE = 2;
    public static final int TEXT_BOX_HORIZONTAL_MARGIN = 8;
    public static final int TEXT_BOX_VERTICAL_MARGIN = 4;

    private BaseComposerConstants() {
    }
}
