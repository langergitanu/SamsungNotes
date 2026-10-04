package com.samsung.android.support.senl.p145cm.base.common.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/WebConstants;", "", "<init>", "()V", "IMAGE_PATTERN", "", "IMAGE_TAG_PATTERN", "ICON_TAG_PATTERN", "ICON_REV_TAG_PATTERN", "ITEMPROP_IMAGE_TAG_PATTERN", "ITEMPROP_IMAGE_REV_TAG_PATTERN", "TITLE_PATTERN", "SCRIPT_PATTERN", "METATAG_PATTERN", "METATAG_CONTENT_PATTERN", "URL_PATTERN_WITH_QUERY", "URL_ZAPPSHARE", "HTTP_PROTOCOL", "HTTPS_PROTOCOL", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WebConstants {

    @NotNull
    public static final String HTTPS_PROTOCOL = "https://";

    @NotNull
    public static final String HTTP_PROTOCOL = "http://";

    @NotNull
    public static final String ICON_REV_TAG_PATTERN = "<img(.*?)src=(\"|')(.+?)(gif|jpg|png|bmp)(\"|')(.*?)(/)?>(</img>)?";

    @NotNull
    public static final String ICON_TAG_PATTERN = "<img(.*?)src=(\"|')(.+?)(gif|jpg|png|bmp)(\"|')(.*?)(/)?>(</img>)?";

    @NotNull
    public static final String IMAGE_PATTERN = "(.+?)\\.(jpg|png|gif|bmp)$";

    @NotNull
    public static final String IMAGE_TAG_PATTERN = "<img(.*?)src=(\"|')(.+?)(gif|jpg|png|bmp)(\"|')(.*?)(/)?>(</img>)?";

    @NotNull
    public static final WebConstants INSTANCE = new WebConstants();

    @NotNull
    public static final String ITEMPROP_IMAGE_REV_TAG_PATTERN = "<img(.*?)src=(\"|')(.+?)(gif|jpg|png|bmp)(\"|')(.*?)(/)?>(</img>)?";

    @NotNull
    public static final String ITEMPROP_IMAGE_TAG_PATTERN = "<img(.*?)src=(\"|')(.+?)(gif|jpg|png|bmp)(\"|')(.*?)(/)?>(</img>)?";

    @NotNull
    public static final String METATAG_CONTENT_PATTERN = "content=\"(.*?)\"";

    @NotNull
    public static final String METATAG_PATTERN = "<meta(.*?)>";

    @NotNull
    public static final String SCRIPT_PATTERN = "<script(.*?)>(.*?)</script>";

    @NotNull
    public static final String TITLE_PATTERN = "<title(.*?)>(.*?)</title>";

    @NotNull
    public static final String URL_PATTERN_WITH_QUERY = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|!:,.;]";

    @NotNull
    public static final String URL_ZAPPSHARE = "https://goo.gl/l6ffgm";

    private WebConstants() {
    }
}
