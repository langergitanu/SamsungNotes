package androidx.compose.p109ui.text.platform;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"FontCacheManagementDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getFontCacheManagementDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DispatcherKt {

    @NotNull
    private static final CoroutineDispatcher FontCacheManagementDispatcher = Dispatchers.getMain();

    @NotNull
    public static final CoroutineDispatcher getFontCacheManagementDispatcher() {
        return FontCacheManagementDispatcher;
    }
}
