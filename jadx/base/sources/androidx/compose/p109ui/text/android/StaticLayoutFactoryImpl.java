package androidx.compose.p109ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "", "create", "Landroid/text/StaticLayout;", ActionHandler.PARAMS, "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", DBSchema.DocumentThumbnail.LAYOUT, "useFallbackLineSpacing", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
interface StaticLayoutFactoryImpl {
    @DoNotInline
    @NotNull
    StaticLayout create(@NotNull StaticLayoutParams params);

    boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout layout, boolean useFallbackLineSpacing);
}
