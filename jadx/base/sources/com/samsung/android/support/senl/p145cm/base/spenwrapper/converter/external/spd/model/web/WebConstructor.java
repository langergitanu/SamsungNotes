package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/WebConstructor;", "", "<init>", "()V", "getConnection", "Ljava/net/HttpURLConnection;", "urlStr", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WebConstructor {

    @NotNull
    public static final WebConstructor INSTANCE = new WebConstructor();

    private WebConstructor() {
    }

    @JvmStatic
    @Nullable
    public static final HttpURLConnection getConnection(@Nullable String urlStr) throws IOException {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(urlStr).openConnection();
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                return (HttpURLConnection) uRLConnectionOpenConnection;
            }
            return null;
        } catch (MalformedURLException e) {
            AbstractC0000a.m23t("getConnection() - Exception", e.getMessage(), LoggerBase.INSTANCE, "WebConstructor");
            return null;
        }
    }
}
