package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/DynamicTemplatePresenterUtil;", "", "<init>", "()V", "getTemplateTypeFromTemplateXml", "", "templateXmlPath", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DynamicTemplatePresenterUtil {

    @NotNull
    public static final DynamicTemplatePresenterUtil INSTANCE = new DynamicTemplatePresenterUtil();

    private DynamicTemplatePresenterUtil() {
    }

    @JvmStatic
    public static final int getTemplateTypeFromTemplateXml(@NotNull String templateXmlPath) {
        Intrinsics.checkNotNullParameter(templateXmlPath, "templateXmlPath");
        return 18;
    }
}
