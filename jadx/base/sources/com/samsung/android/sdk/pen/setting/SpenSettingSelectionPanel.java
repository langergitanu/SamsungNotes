package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionPanel;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSelectionInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionPanel$SelectionInfoChangedListener;", "mSelectionLayout", "Lcom/samsung/android/sdk/pen/setting/selection/SpenSelectionLayout;", "close", "", "settingSelectionInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;)V", "setSelectionInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initView", "notifyDataChanged", "Companion", "SelectionInfoChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingSelectionPanel extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenSettingSelectionPanel";

    @Nullable
    private SelectionInfoChangedListener mSelectionInfoChangedListener;

    @Nullable
    private SpenSelectionLayout mSelectionLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingSelectionPanel$SelectionInfoChangedListener;", "", "onSelectionInfoChanged", "", "selectionInfo", "Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SelectionInfoChangedListener {
        void onSelectionInfoChanged(@Nullable SpenSettingSelectionInfo selectionInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingSelectionPanel(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        View.inflate(context, C7932R.layout.setting_selection_panel, this);
        SpenSelectionLayout spenSelectionLayout = (SpenSelectionLayout) findViewById(C7932R.id.setting_selection_body_layout);
        this.mSelectionLayout = spenSelectionLayout;
        if (spenSelectionLayout != null) {
            spenSelectionLayout.setActionListener(new SpenSelectionLayout.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingSelectionPanel.initView.1
                @Override // com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout.OnActionListener
                public void onSelectionChanged(int type) {
                    SpenSettingSelectionPanel.this.notifyDataChanged();
                }

                @Override // com.samsung.android.sdk.pen.setting.selection.SpenSelectionLayout.OnActionListener
                public void onSelectionOptionChanged(boolean includePartiallySelected) {
                    SpenSettingSelectionPanel.this.notifyDataChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LongLogTag"})
    public final void notifyDataChanged() {
        Log.i(TAG, "notifyDataChanged() changedListener=".concat(this.mSelectionInfoChangedListener != null ? "NOT NULL" : "NULL"));
        SelectionInfoChangedListener selectionInfoChangedListener = this.mSelectionInfoChangedListener;
        if (selectionInfoChangedListener != null) {
            SpenSelectionLayout spenSelectionLayout = this.mSelectionLayout;
            selectionInfoChangedListener.onSelectionInfoChanged(spenSelectionLayout != null ? spenSelectionLayout.getInfo() : null);
        }
    }

    public final void close() {
        this.mSelectionInfoChangedListener = null;
        SpenSelectionLayout spenSelectionLayout = this.mSelectionLayout;
        if (spenSelectionLayout != null) {
            spenSelectionLayout.close();
        }
        this.mSelectionLayout = null;
    }

    @Nullable
    public final SpenSettingSelectionInfo getInfo() {
        SpenSelectionLayout spenSelectionLayout = this.mSelectionLayout;
        if (spenSelectionLayout != null) {
            return spenSelectionLayout.getInfo();
        }
        return null;
    }

    public final void setInfo(@Nullable SpenSettingSelectionInfo spenSettingSelectionInfo) {
        SpenSelectionLayout spenSelectionLayout;
        if (spenSettingSelectionInfo == null || (spenSelectionLayout = this.mSelectionLayout) == null) {
            return;
        }
        spenSelectionLayout.setInfo(spenSettingSelectionInfo);
    }

    public final void setSelectionInfoChangedListener(@Nullable SelectionInfoChangedListener listener) {
        this.mSelectionInfoChangedListener = listener;
    }
}
