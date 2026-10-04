package com.samsung.android.app.notes.widget;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/AppWidgetConfiguration;", "", "<init>", "()V", "setup", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppWidgetConfiguration {
    public static final int $stable = 0;

    @NotNull
    public static final AppWidgetConfiguration INSTANCE = new AppWidgetConfiguration();

    private AppWidgetConfiguration() {
    }

    @JvmStatic
    public static final void setup() {
        WidgetAccessHandler.INSTANCE.setWidgetResolverClass(WidgetResolver.class);
        WidgetAccessHandler.setWidgetAccessContract(new WidgetAccessContractImpl());
        ProviderUtils.INSTANCE.setProviderClasses(WidgetProvider.class, WidgetImgShortCutProvider.class);
    }
}
