package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.web;

import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/web/LinkSourceContentVer3;", "", "<init>", "()V", "isSuccess", "", "()Z", "setSuccess", "(Z)V", "htmlCode", "", "getHtmlCode", "()Ljava/lang/String;", "setHtmlCode", "(Ljava/lang/String;)V", "title", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "description", "getDescription", "setDescription", "url", "getUrl", "setUrl", "finalUrl", "getFinalUrl", "setFinalUrl", "images", "", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class LinkSourceContentVer3 {
    private boolean isSuccess;

    @NotNull
    private String htmlCode = "";

    @NotNull
    private String title = "";

    @NotNull
    private String description = "";

    @NotNull
    private String url = "";

    @NotNull
    private String finalUrl = "";

    @NotNull
    private List<String> images = new ArrayList();

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getFinalUrl() {
        return this.finalUrl;
    }

    @NotNull
    public final String getHtmlCode() {
        return this.htmlCode;
    }

    @NotNull
    public List<String> getImages() {
        return this.images;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setFinalUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.finalUrl = str;
    }

    public final void setHtmlCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.htmlCode = str;
    }

    public void setImages(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.images = list;
    }

    public final void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
