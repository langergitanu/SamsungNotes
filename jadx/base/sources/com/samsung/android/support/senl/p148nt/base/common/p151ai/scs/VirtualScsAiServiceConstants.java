package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/VirtualScsAiServiceConstants;", "", "<init>", "()V", "SERVICE_PACKAGE", "", "SERVICE_CLASS", "SERVICE_CATEGORY", "SERVICE_ACTION", "CONTENT", "TEXT_INFO", "IMAGE_STYLE", "SAMPLE_COUNT", "HANDWRITING_TEXT_INFO", "RESULT", "EXTRACTED_KEYWORDS", "REQUESTED_KEYWORDS", "REQUEST_TYPE_EXTRACT_KEYWORDS", "", "REQUEST_TYPE_GENERATE_IMAGE_FROM_IMAGE_AND_KEYWORDS", "REQUEST_TYPE_GENERATE_IMAGE_FROM_KEYWORDS", "REQUEST_TYPE_GENERATE_IMAGE_FROM_TEXT_INFO", "REQUEST_TYPE_GENERATE_IMAGE_FROM_PROMPT_GENERATED_BY_TEXT_INFO", "REQUEST_TYPE_GENERATE_DESCRIPTION_FROM_NOTE", "REQUEST_TYPE_GENERATE_TRAVEL_TIP", "REQUEST_TYPE_GENERATE_TRAVEL_EXTRACT", "REQUEST_TYPE_GENERATE_TRAVEL_RESERVATION", "REQUEST_TYPE_GENERATE_JOURNAL_INFO", "ENABLE", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VirtualScsAiServiceConstants {

    @NotNull
    public static final String CONTENT = "content";
    public static final boolean ENABLE = true;

    @NotNull
    public static final String EXTRACTED_KEYWORDS = "extracted_keywords";

    @NotNull
    public static final String HANDWRITING_TEXT_INFO = "handwritingTextInfo";

    @NotNull
    public static final String IMAGE_STYLE = "imageStyle";

    @NotNull
    public static final VirtualScsAiServiceConstants INSTANCE = new VirtualScsAiServiceConstants();

    @NotNull
    public static final String REQUESTED_KEYWORDS = "requested_keywords";
    public static final int REQUEST_TYPE_EXTRACT_KEYWORDS = 0;
    public static final int REQUEST_TYPE_GENERATE_DESCRIPTION_FROM_NOTE = 5;
    public static final int REQUEST_TYPE_GENERATE_IMAGE_FROM_IMAGE_AND_KEYWORDS = 1;
    public static final int REQUEST_TYPE_GENERATE_IMAGE_FROM_KEYWORDS = 2;
    public static final int REQUEST_TYPE_GENERATE_IMAGE_FROM_PROMPT_GENERATED_BY_TEXT_INFO = 4;
    public static final int REQUEST_TYPE_GENERATE_IMAGE_FROM_TEXT_INFO = 3;
    public static final int REQUEST_TYPE_GENERATE_JOURNAL_INFO = 9;
    public static final int REQUEST_TYPE_GENERATE_TRAVEL_EXTRACT = 7;
    public static final int REQUEST_TYPE_GENERATE_TRAVEL_RESERVATION = 8;
    public static final int REQUEST_TYPE_GENERATE_TRAVEL_TIP = 6;

    @NotNull
    public static final String RESULT = "result";

    @NotNull
    public static final String SAMPLE_COUNT = "sampleCount";

    @NotNull
    public static final String SERVICE_ACTION = "com.samsung.android.VirtualScsAiService";

    @NotNull
    public static final String SERVICE_CATEGORY = "android.intent.category.VirtualScsAiModule";

    @NotNull
    public static final String SERVICE_CLASS = "com.samsung.android.virtualscsai.VirtualScsAiService";

    @NotNull
    public static final String SERVICE_PACKAGE = "com.samsung.android.virtualscsai";

    @NotNull
    public static final String TEXT_INFO = "textInfo";

    private VirtualScsAiServiceConstants() {
    }
}
