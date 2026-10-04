package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragNDropConstant;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CLIP_TYPE_UNSUPPORTED", "", "CLIP_TYPE_NONE", "CLIP_TYPE_MM_CONTENT", "CLIP_TYPE_TEXT", "DROP_AREA_GAP", "PAGE_DRAG_LABEL", "DRAG_START_FROM_APPS_EDGE", "showDropFailMessage", "", "context", "Landroid/content/Context;", "showCopyFailMessage", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragNDropConstant {
    public static final int CLIP_TYPE_MM_CONTENT = 1;
    public static final int CLIP_TYPE_NONE = 0;
    public static final int CLIP_TYPE_TEXT = 2;
    public static final int CLIP_TYPE_UNSUPPORTED = -1;

    @NotNull
    public static final String DRAG_START_FROM_APPS_EDGE = "from_apps_edge";
    public static final int DROP_AREA_GAP = 50;

    @NotNull
    public static final DragNDropConstant INSTANCE = new DragNDropConstant();

    @NotNull
    public static final String PAGE_DRAG_LABEL = "Page_Thumbnail";

    @NotNull
    public static final String TAG = "CPLog$DragAndDrop";

    private DragNDropConstant() {
    }

    @JvmStatic
    public static final void showDropFailMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHandler.show(context, C8875R.string.not_supported, 1);
    }

    public final void showCopyFailMessage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastHandler.show(context, C8875R.string.composer_failed_to_copy, 0);
    }
}
