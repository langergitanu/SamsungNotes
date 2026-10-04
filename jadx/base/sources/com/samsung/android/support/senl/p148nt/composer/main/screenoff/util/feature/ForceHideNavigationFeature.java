package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature;

import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/feature/ForceHideNavigationFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "FEATURE_MODELS", "", "needToHideNavigationForcibly", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ForceHideNavigationFeature {

    @NotNull
    public static final ForceHideNavigationFeature INSTANCE = new ForceHideNavigationFeature();

    @NotNull
    private static final String TAG = SOLogger.createTag("ForceHideNavigationFeature");

    @NotNull
    private static final List<String> FEATURE_MODELS = new ArrayList(CollectionsKt.mutableListOf("T63", "X30"));

    private ForceHideNavigationFeature() {
    }

    public final boolean needToHideNavigationForcibly() {
        boolean z = false;
        if (ConfigurationModel.INSTANCE.isTaskBarEnabled()) {
            for (String str : FEATURE_MODELS) {
                String modelName = DeviceInfo.getModelName();
                if (modelName != null && StringsKt.m14162r(modelName, str)) {
                    z = true;
                }
            }
            if (!ConfigurationModel.hasSWNavigation()) {
                z = true;
            }
        }
        AbstractC8014b.m7211m("needToHideNavigationForcibly# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }
}
