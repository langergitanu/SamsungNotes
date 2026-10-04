package androidx.core.view;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.view.SeslPointerIconReflector;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Landroidx/core/view/SeslPointerIconCompat;", "", "()V", "TYPE_SEM_STYLUS_DEFAULT", "", "TYPE_SEM_STYLUS_MORE", "TYPE_SEM_STYLUS_PEN_SELECT", "TYPE_SEM_STYLUS_SCROLL_DOWN", "TYPE_SEM_STYLUS_SCROLL_LEFT", "TYPE_SEM_STYLUS_SCROLL_RIGHT", "TYPE_SEM_STYLUS_SCROLL_UP", "isSemStylusDefault", "", "iconId", "core_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class SeslPointerIconCompat {

    @NotNull
    public static final SeslPointerIconCompat INSTANCE = new SeslPointerIconCompat();

    @JvmField
    public static final int TYPE_SEM_STYLUS_DEFAULT = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT();

    @JvmField
    public static final int TYPE_SEM_STYLUS_SCROLL_UP = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_UP();

    @JvmField
    public static final int TYPE_SEM_STYLUS_SCROLL_DOWN = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_DOWN();

    @JvmField
    public static final int TYPE_SEM_STYLUS_SCROLL_LEFT = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_LEFT();

    @JvmField
    public static final int TYPE_SEM_STYLUS_SCROLL_RIGHT = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_RIGHT();

    @JvmField
    public static final int TYPE_SEM_STYLUS_PEN_SELECT = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_PEN_SELECT();

    @JvmField
    public static final int TYPE_SEM_STYLUS_MORE = SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_MORE();

    private SeslPointerIconCompat() {
    }

    @JvmStatic
    public static final boolean isSemStylusDefault(int iconId) {
        return iconId == TYPE_SEM_STYLUS_DEFAULT;
    }
}
