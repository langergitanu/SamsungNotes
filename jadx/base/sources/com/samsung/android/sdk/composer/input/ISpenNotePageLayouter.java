package com.samsung.android.sdk.composer.input;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter;", "", "setPageLayoutAll", "", "column", "", "row", "fitScreen", "", "vertical", "requestPageLayout", "setPageLayoutMarginBottom", "marginBottom", "", "setNativeHandle", "nativeHandle", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISpenNotePageLayouter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PAGE_LAYOUT_HORIZONTAL = 1;
    public static final int PAGE_LAYOUT_VERTICAL = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/ISpenNotePageLayouter$Companion;", "", "<init>", "()V", "PAGE_LAYOUT_VERTICAL", "", "PAGE_LAYOUT_HORIZONTAL", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PAGE_LAYOUT_HORIZONTAL = 1;
        public static final int PAGE_LAYOUT_VERTICAL = 0;

        private Companion() {
        }
    }

    void requestPageLayout();

    void setNativeHandle(long nativeHandle);

    void setPageLayoutAll(int column, int row, boolean fitScreen, boolean vertical);

    @Deprecated(message = "This API is deprecated. Please use [com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller.contentMargin] instead.")
    void setPageLayoutMarginBottom(float marginBottom);
}
