package com.samsung.android.support.senl.p148nt.composer.main.base.appwidget;

import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/AppWidgetResolverConstructor;", "", "<init>", "()V", "appWidgetResolver", "Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetResolver;", "getAppWidgetResolver$annotations", "getAppWidgetResolver", "()Lcom/samsung/android/support/senl/nt/composer/main/base/appwidget/IAppWidgetResolver;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppWidgetResolverConstructor {

    @NotNull
    public static final AppWidgetResolverConstructor INSTANCE = new AppWidgetResolverConstructor();

    private AppWidgetResolverConstructor() {
    }

    @Nullable
    public static final IAppWidgetResolver getAppWidgetResolver() {
        WidgetAccessHandler widgetAccessHandler = WidgetAccessHandler.INSTANCE;
        if (widgetAccessHandler.getWidgetResolverClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            if (widgetAccessHandler.getWidgetResolverClass() == null) {
                return null;
            }
        }
        Class<?> widgetResolverClass = widgetAccessHandler.getWidgetResolverClass();
        Constructor<?> declaredConstructor = widgetResolverClass != null ? widgetResolverClass.getDeclaredConstructor(null) : null;
        Object objNewInstance = declaredConstructor != null ? declaredConstructor.newInstance(null) : null;
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.appwidget.IAppWidgetResolver");
        return (IAppWidgetResolver) objNewInstance;
    }

    @JvmStatic
    public static /* synthetic */ void getAppWidgetResolver$annotations() {
    }
}
