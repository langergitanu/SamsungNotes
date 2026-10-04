package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenControlObjectListenerImpl;", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;)V", "onSelectedItemLongClicked", "", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenControlObjectListenerImpl extends SpenControlObjectListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SpenControlObjectListenerImpl");

    @NotNull
    private final SmControlManager smControlManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenControlObjectListenerImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SpenControlObjectListenerImpl.TAG;
        }

        private Companion() {
        }
    }

    public SpenControlObjectListenerImpl(@NotNull SmControlManager smControlManager) {
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        this.smControlManager = smControlManager;
    }

    @Override // com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onSelectedItemLongClicked(@Nullable SpenObjectBase obj) {
        String str = TAG;
        Intrinsics.checkNotNull(obj);
        SmLogger.m8661d(str, "onSelectedItemLongClicked# " + obj.getType());
        SmObjectManager objectManager = this.smControlManager.getObjectManager();
        if (objectManager.getSelectedObjectList() == null || !(!r2.isEmpty())) {
            SmLogger.m8662e(str, "onSelectedItemLongClicked# SelectedObjectList is empty");
            return false;
        }
        if (ObjectTypeHelper.INSTANCE.isTextType(obj.getType()) && objectManager.isFocusedTextBox()) {
            if (!(obj instanceof SpenObjectShape)) {
                return false;
            }
            int[] cursor = TextUtil.getCursor((SpenObjectShape) obj);
            Intrinsics.checkNotNullExpressionValue(cursor, "getCursor(...)");
            if (cursor[0] == cursor[1]) {
                SmLogger.m8662e(str, "onSelectedItemLongClicked# The text is not selected.");
                return false;
            }
        }
        return this.smControlManager.getDragNDropControl().startDrag();
    }
}
