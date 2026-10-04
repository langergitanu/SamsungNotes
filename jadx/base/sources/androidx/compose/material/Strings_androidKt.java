package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.p109ui.C2026R;
import androidx.compose.p109ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, m13886d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class Strings_androidKt {
    @Composable
    @NotNull
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m16870getString4foXLRw(int i, @Nullable Composer composer, int i2) {
        String string;
        composer.startReplaceableGroup(-726638443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.INSTANCE;
        if (Strings.m16859equalsimpl0(i, companion.m16867getNavigationMenuUdPEhr4())) {
            string = resources.getString(C2026R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16863getCloseDrawerUdPEhr4())) {
            string = resources.getString(C2026R.string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16864getCloseSheetUdPEhr4())) {
            string = resources.getString(C2026R.string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16865getDefaultErrorMessageUdPEhr4())) {
            string = resources.getString(C2026R.string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16866getExposedDropdownMenuUdPEhr4())) {
            string = resources.getString(C2026R.string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16869getSliderRangeStartUdPEhr4())) {
            string = resources.getString(C2026R.string.range_start);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.range_start)");
        } else if (Strings.m16859equalsimpl0(i, companion.m16868getSliderRangeEndUdPEhr4())) {
            string = resources.getString(C2026R.string.range_end);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.range_end)");
        } else {
            string = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return string;
    }
}
