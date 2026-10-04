package com.samsung.android.support.senl.p148nt.base.composer.html.common;

import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/common/HtmlHelper;", "", "<init>", "()V", "FEATURE_ENABLED", "", SearchConstants.TargetContents.TAG, "", "ENABLED_LOG", "getENABLED_LOG", "()Z", "prettyPrintHtml", "doc", "Lorg/jsoup/nodes/Document;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HtmlHelper {
    private static final boolean ENABLED_LOG;
    public static final boolean FEATURE_ENABLED = true;

    @NotNull
    public static final HtmlHelper INSTANCE = new HtmlHelper();

    @NotNull
    public static final String TAG = "Html";

    static {
        ENABLED_LOG = DeviceInfo.isUserDebugMode() || DeviceInfo.isEngMode();
    }

    private HtmlHelper() {
    }

    public final boolean getENABLED_LOG() {
        return ENABLED_LOG;
    }

    @NotNull
    public final String prettyPrintHtml(@NotNull Document doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        Document.OutputSettings outputSettings = new Document.OutputSettings();
        outputSettings.prettyPrint(true);
        outputSettings.indentAmount(2);
        doc.outputSettings(outputSettings);
        String strOuterHtml = doc.outerHtml();
        Intrinsics.checkNotNullExpressionValue(strOuterHtml, "outerHtml(...)");
        return strOuterHtml;
    }
}
