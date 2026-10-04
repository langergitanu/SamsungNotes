package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageHelper;", "", "initLayout", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/widget/LinearLayout;", "invalidateLayout", "state", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/LayoutState;", "onConfigurationChanged", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslateLanguageListener;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface TranslateLanguageHelper {
    void initLayout(@NotNull LinearLayout layout);

    void invalidateLayout(@NotNull LayoutState state);

    void onConfigurationChanged();

    void setListener(@NotNull TranslateLanguageListener listener);
}
