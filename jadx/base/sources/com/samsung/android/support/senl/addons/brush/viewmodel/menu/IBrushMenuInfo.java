package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import android.graphics.Rect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "", "penRect", "Landroid/graphics/Rect;", "getPenRect", "()Landroid/graphics/Rect;", "colorRect", "getColorRect", "penAlign", "", "getPenAlign", "()I", "colorAlign", "getColorAlign", "isEquals", "", "info", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBrushMenuInfo {
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_END = 1;
    public static final int ALIGN_START = 2;
    public static final int ALIGN_TOP = 3;

    @NotNull
    public static final String BRUSH_MENU_SMART_TIP = "BrushMenuSmartTip";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo$Companion;", "", "<init>", "()V", "BRUSH_MENU_SMART_TIP", "", "ALIGN_TOP", "", "ALIGN_BOTTOM", "ALIGN_START", "ALIGN_END", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ALIGN_BOTTOM = 0;
        public static final int ALIGN_END = 1;
        public static final int ALIGN_START = 2;
        public static final int ALIGN_TOP = 3;

        @NotNull
        public static final String BRUSH_MENU_SMART_TIP = "BrushMenuSmartTip";

        private Companion() {
        }
    }

    int getColorAlign();

    @NotNull
    Rect getColorRect();

    int getPenAlign();

    @NotNull
    Rect getPenRect();

    boolean isEquals(@Nullable IBrushMenuInfo info);
}
