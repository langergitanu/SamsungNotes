package androidx.window.layout;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m13886d2 = {"Landroidx/window/layout/ExtensionInterfaceCompat;", "", "onWindowLayoutChangeListenerAdded", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "onWindowLayoutChangeListenerRemoved", "setExtensionCallback", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "validateExtensionInterface", "", "ExtensionCallbackInterface", "window_release"}, m13887k = 1, m13888mv = {1, 6, 0}, m13890xi = 48)
public interface ExtensionInterfaceCompat {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "", "onWindowLayoutChanged", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, m13887k = 1, m13888mv = {1, 6, 0}, m13890xi = 48)
    public interface ExtensionCallbackInterface {
        void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo newLayout);
    }

    void onWindowLayoutChangeListenerAdded(@NotNull Activity activity);

    void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity);

    void setExtensionCallback(@NotNull ExtensionCallbackInterface extensionCallback);

    boolean validateExtensionInterface();
}
