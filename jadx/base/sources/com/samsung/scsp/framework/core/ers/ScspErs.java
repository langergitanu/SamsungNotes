package com.samsung.scsp.framework.core.ers;

import android.annotation.SuppressLint;
import android.content.Context;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.FeatureConfigurator;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.framework.core.BuildConfig;
import com.samsung.scsp.framework.core.SContext;
import com.samsung.scsp.framework.core.SContextHolder;
import com.samsung.scsp.framework.core.decorator.SdkConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspErs {
    private static final Holder<Boolean> IS_ONSTAGE_HOLDER = new Holder<>();
    private static final String STG_API = "https://stg-api.samsungcloud.com";
    private static final String STG_ODM = "https://stg-kc1z-api.samsungcloud.com";
    private static final String STG_PLAY = "https://stg-play.samsungcloud.com";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DefaultSContextHolder {
        private static final SContextHolder scontextHolder = new SContextHolder(BuildConfig.LIBRARY_PACKAGE_NAME, BuildConfig.VERSION_NAME, false, false, SdkConfig.Domain.play);

        private DefaultSContextHolder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final ErsImpl ers = new ErsImpl();

        private LazyHolder() {
        }
    }

    public static void clear(Context context) {
        ContextFactory.attachApplicationContext(context);
        ErsPreferences.get().clear();
    }

    public static String getBaseUrl(Context context, String str) {
        return getBaseUrl(context, DefaultSContextHolder.scontextHolder, str);
    }

    public static DomainVo getDomain() {
        return getDomain(DefaultSContextHolder.scontextHolder);
    }

    public static boolean isOnStage(Context context) {
        Holder<Boolean> holder = IS_ONSTAGE_HOLDER;
        if (holder.get() == null) {
            holder.hold(Boolean.valueOf(FeatureConfigurator.get(context, "ENABLE_STAGE_SERVER", false)));
        }
        return holder.get().booleanValue();
    }

    public static String getBaseUrl(Context context, SContextHolder sContextHolder, String str) {
        ContextFactory.attachApplicationContext(context);
        if (isOnStage(context)) {
            return STG_API;
        }
        ErsPreferences ersPreferences = ErsPreferences.get();
        if (ersPreferences.expiredTime.get().longValue() < System.currentTimeMillis()) {
            LazyHolder.ers.getDomain(context, sContextHolder, str);
        }
        return ersPreferences.defaultUrl.get();
    }

    public static DomainVo getDomain(SContextHolder sContextHolder) {
        Context applicationContext = ContextFactory.getApplicationContext();
        if (isOnStage(applicationContext)) {
            DomainVo domainVo = new DomainVo();
            domainVo.playUrl = STG_PLAY;
            domainVo.defaultUrl = STG_API;
            domainVo.odmUrl = STG_ODM;
            return domainVo;
        }
        ErsPreferences ersPreferences = ErsPreferences.get();
        if (ersPreferences.expiredTime.get().longValue() < System.currentTimeMillis()) {
            LazyHolder.ers.getDomain(applicationContext, sContextHolder, SContext.getInstance().getAppId());
        }
        DomainVo domainVo2 = new DomainVo();
        domainVo2.playUrl = ersPreferences.playUrl.get();
        domainVo2.defaultUrl = ersPreferences.defaultUrl.get();
        domainVo2.odmUrl = ersPreferences.odmUrl.get();
        return domainVo2;
    }
}
