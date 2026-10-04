package com.samsung.android.support.senl.p148nt.base.composer.action.copy;

import android.content.ClipData;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018R&\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/CopyResult;", "", "mimeType", "", "", ExternalDataConstants.Column.THUMBNAIL_URI, "Landroid/net/Uri;", "plainText", "htmlText", "<init>", "([Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "getMimeType", "()[Ljava/lang/String;", "setMimeType", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getThumbnailUri", "()Landroid/net/Uri;", "setThumbnailUri", "(Landroid/net/Uri;)V", "getPlainText", "()Ljava/lang/String;", "getHtmlText", "makeClipDataItem", "Landroid/content/ClipData$Item;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CopyResult {

    @NotNull
    private final String htmlText;

    @Nullable
    private String[] mimeType;

    @NotNull
    private final String plainText;

    @Nullable
    private Uri thumbnailUri;

    public CopyResult() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    public final String getHtmlText() {
        return this.htmlText;
    }

    @Nullable
    public final String[] getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final String getPlainText() {
        return this.plainText;
    }

    @Nullable
    public final Uri getThumbnailUri() {
        return this.thumbnailUri;
    }

    @NotNull
    public final ClipData.Item makeClipDataItem() {
        return new ClipData.Item(this.plainText, this.htmlText, null, this.thumbnailUri);
    }

    public final void setMimeType(@Nullable String[] strArr) {
        this.mimeType = strArr;
    }

    public final void setThumbnailUri(@Nullable Uri uri) {
        this.thumbnailUri = uri;
    }

    public CopyResult(@Nullable String[] strArr, @Nullable Uri uri, @NotNull String plainText, @NotNull String htmlText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Intrinsics.checkNotNullParameter(htmlText, "htmlText");
        this.mimeType = strArr;
        this.thumbnailUri = uri;
        this.plainText = plainText;
        this.htmlText = htmlText;
    }

    public /* synthetic */ CopyResult(String[] strArr, Uri uri, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new String[]{Constants.MIME_HTML} : strArr, (i & 2) != 0 ? null : uri, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2);
    }
}
