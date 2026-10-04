package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenView;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mVoiceAssistantString", "", "mSizeLevel", "", "setSelected", "", "selected", "", "setPenInfo", "penName", "color", "sizeLevel", "particleSize", "", "isFixedWidth", "setPenSizeLevel", "getPenSizeLevel", "updateVoiceAssistant", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTPenView extends QTPenBaseView {

    @NotNull
    private static final String TAG = "QTPenView";
    private int mSizeLevel;

    @Nullable
    private final String mVoiceAssistantString;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTPenView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void updateVoiceAssistant() {
        setContentDescription(this.mVoiceAssistantString);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenBaseView
    /* JADX INFO: renamed from: getPenSizeLevel, reason: from getter */
    public int getMSizeLevel() {
        return this.mSizeLevel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenBaseView
    public boolean setPenInfo(@NotNull String penName, int color, int sizeLevel, float particleSize, boolean isFixedWidth) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (getTag() == null || !Intrinsics.areEqual(penName, getTag().toString())) {
            SpenSettingPenResource penSettingResource = QTPenResource.getPenSettingResource(getContext(), penName);
            if (penSettingResource == null) {
                Log.i(TAG, "Not support Pen.");
                return false;
            }
            setPenResourceInfo(penSettingResource);
        }
        return super.setPenInfo(penName, color, sizeLevel, particleSize, isFixedWidth);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenBaseView
    public void setPenSizeLevel(int sizeLevel) {
        this.mSizeLevel = sizeLevel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenBaseView, android.view.View
    public void setSelected(boolean selected) {
        updateVoiceAssistant();
        super.setSelected(selected);
    }
}
