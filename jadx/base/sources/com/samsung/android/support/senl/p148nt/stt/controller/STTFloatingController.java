package com.samsung.android.support.senl.p148nt.stt.controller;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListViewAdapter;
import com.samsung.android.support.senl.p148nt.stt.view.STTVoiceItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p209n4.RunnableC13543a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 >2\u00020\u0001:\u0001>B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u0017J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001aJ\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020\u001cJ\u0018\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0011J\u0016\u00109\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0011J\u000e\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0011\u0010'\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u001d\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0011068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010=\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b=\u0010\u0012¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/controller/STTFloatingController;", "", "mContext", "Landroid/content/Context;", "mSTTPresenterContract", "Lcom/samsung/android/support/senl/nt/stt/contract/STTPresenterContract;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/stt/contract/STTPresenterContract;)V", "sttContainer", "Landroid/view/View;", "sttListView", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "getSttListView", "()Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "setSttListView", "(Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;)V", "isShowingState", "", "()Z", "setShowingState", "(Z)V", "mIsInitializedFromTabletLayout", "mVoiceItemToShow", "Lcom/samsung/android/support/senl/nt/stt/view/STTVoiceItem;", "mSelectedItemMap", "", "", "init", "", "onToggleShowContainer", "showContainer", "hideContainer", "onModeChanged", "mode", "Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "onShowSpeakerLabelChanged", "saveSTTData", "isUpdated", "isFocusingSTTEditMode", "isDataChanged", "onVoiceItemInit", "item", "onItemChanged", "index", "onSTTReplayComplete", "onSTTReplay", "position", "onBackgroundColorChanged", "updateBackgroundColor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isOrientationChanged", "selectedItemMap", "", "getSelectedItemMap", "()Ljava/util/Map;", "onSTTItemCheckedChange", "isChecked", "toggleSTTSelectAllItem", "isSelectedAll", "isShowingSpeakerRenameDialog", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTFloatingController {

    @NotNull
    private static final String TAG = "STTFloatingController";
    private boolean isShowingState;

    @Nullable
    private final Context mContext;
    private boolean mIsInitializedFromTabletLayout;

    @NotNull
    private final STTPresenterContract mSTTPresenterContract;

    @NotNull
    private final Map<Integer, Boolean> mSelectedItemMap;

    @Nullable
    private STTVoiceItem mVoiceItemToShow;

    @JvmField
    @Nullable
    public View sttContainer;

    @Nullable
    private AiSTTListView sttListView;

    public STTFloatingController(@Nullable Context context, @NotNull STTPresenterContract mSTTPresenterContract) {
        Intrinsics.checkNotNullParameter(mSTTPresenterContract, "mSTTPresenterContract");
        this.mContext = context;
        this.mSTTPresenterContract = mSTTPresenterContract;
        this.mSelectedItemMap = new TreeMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideContainer$lambda$1(STTFloatingController sTTFloatingController) {
        View view = sTTFloatingController.sttContainer;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContainer$lambda$0(STTFloatingController sTTFloatingController) {
        View view = sTTFloatingController.sttContainer;
        Intrinsics.checkNotNull(view);
        View view2 = (View) view.getParent();
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = sTTFloatingController.sttContainer;
        Intrinsics.checkNotNull(view3);
        view3.setVisibility(0);
    }

    @NotNull
    public final Map<Integer, Boolean> getSelectedItemMap() {
        return this.mSelectedItemMap;
    }

    @Nullable
    public final AiSTTListView getSttListView() {
        return this.sttListView;
    }

    public final void hideContainer() {
        this.isShowingState = false;
        View view = this.sttContainer;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        view.post(new RunnableC13543a(this, 0));
    }

    public final void init(@NotNull View sttContainer) {
        Intrinsics.checkNotNullParameter(sttContainer, "sttContainer");
        this.sttContainer = sttContainer.findViewById(C11493R.id.stt_tablet_container);
        AiSTTListView aiSTTListView = (AiSTTListView) sttContainer.findViewById(C11493R.id.stt_list_view);
        this.sttListView = aiSTTListView;
        if (aiSTTListView != null) {
            aiSTTListView.setSTTPresenterContract(this.mSTTPresenterContract);
        }
        AiSTTListView aiSTTListView2 = this.sttListView;
        if (aiSTTListView2 != null) {
            aiSTTListView2.setSelectedItemMap(this.mSelectedItemMap);
        }
        this.mIsInitializedFromTabletLayout = true;
    }

    public final boolean isDataChanged() {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView == null) {
            return false;
        }
        Intrinsics.checkNotNull(aiSTTListView);
        return aiSTTListView.isDataChanged();
    }

    public final boolean isFocusingSTTEditMode() {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView == null) {
            return false;
        }
        Intrinsics.checkNotNull(aiSTTListView);
        return aiSTTListView.hasFocus();
    }

    public final boolean isShowingSpeakerRenameDialog() {
        AiSTTListViewAdapter mAiSTTListViewAdapter;
        AiSTTListView aiSTTListView = this.sttListView;
        return (aiSTTListView == null || (mAiSTTListViewAdapter = aiSTTListView.getMAiSTTListViewAdapter()) == null || !mAiSTTListViewAdapter.getIsShowingSpeakerRenameDialog()) ? false : true;
    }

    /* JADX INFO: renamed from: isShowingState, reason: from getter */
    public final boolean getIsShowingState() {
        return this.isShowingState;
    }

    public final void onBackgroundColorChanged() {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.initPainter();
        }
    }

    public final void onConfigurationChanged(@Nullable Configuration newConfig, boolean isOrientationChanged) {
        Logger.m12710d(TAG, "onConfigurationChanged: isOrientationChanged: " + isOrientationChanged + " newConfig: " + (newConfig != null ? Integer.valueOf(newConfig.orientation) : null));
    }

    public final void onItemChanged(int index) {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            STTVoiceItem sTTVoiceItem = this.mVoiceItemToShow;
            Intrinsics.checkNotNull(sTTVoiceItem);
            aiSTTListView.initSTTVoiceItems(sTTVoiceItem);
        }
    }

    public final void onModeChanged(@NotNull STTMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.onModeChanged(mode);
        }
    }

    public final void onSTTItemCheckedChange(int position, boolean isChecked) {
        if (isChecked) {
            this.mSelectedItemMap.put(Integer.valueOf(position), Boolean.TRUE);
        } else {
            this.mSelectedItemMap.remove(Integer.valueOf(position));
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = this.mSelectedItemMap.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next().intValue());
            sb.append(",");
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(position, this.mSelectedItemMap.size(), "onSTTItemCheckedChange ", " - size ", " [");
        sbM1173s.append((Object) sb);
        sbM1173s.append("]");
        Logger.m12710d(TAG, sbM1173s.toString());
    }

    public final void onSTTReplay(int position) {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.updateSTTReplay(position, false);
        }
    }

    public final void onSTTReplayComplete() {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.updateSTTReplay();
        }
    }

    public final void onShowSpeakerLabelChanged() {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.onShowSpeakerLabelChanged();
        }
    }

    public final void onToggleShowContainer() {
        if (this.isShowingState) {
            hideContainer();
        } else {
            showContainer();
        }
    }

    public final void onVoiceItemInit(@Nullable STTVoiceItem item) {
        AiSTTListView aiSTTListView;
        if (item == null || (aiSTTListView = this.sttListView) == null) {
            return;
        }
        this.mVoiceItemToShow = item;
        Intrinsics.checkNotNull(aiSTTListView);
        aiSTTListView.initSTTVoiceItems(item);
    }

    public final void saveSTTData(boolean isUpdated) {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            aiSTTListView.saveSTTData(isUpdated);
        }
    }

    public final void setShowingState(boolean z) {
        this.isShowingState = z;
    }

    public final void setSttListView(@Nullable AiSTTListView aiSTTListView) {
        this.sttListView = aiSTTListView;
    }

    public final void showContainer() {
        this.isShowingState = true;
        View view = this.sttContainer;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        view.post(new RunnableC13543a(this, 1));
    }

    public final void toggleSTTSelectAllItem(boolean isSelectedAll) {
        AiSTTListView aiSTTListView = this.sttListView;
        if (aiSTTListView != null) {
            Intrinsics.checkNotNull(aiSTTListView);
            if (aiSTTListView.getAiTextDataList() == null) {
                return;
            }
            if (isSelectedAll) {
                AiSTTListView aiSTTListView2 = this.sttListView;
                Intrinsics.checkNotNull(aiSTTListView2);
                List<AiTextData> aiTextDataList = aiSTTListView2.getAiTextDataList();
                Intrinsics.checkNotNull(aiTextDataList);
                int size = aiTextDataList.size();
                for (int i = 0; i < size; i++) {
                    this.mSelectedItemMap.put(Integer.valueOf(i), Boolean.TRUE);
                }
            } else {
                this.mSelectedItemMap.clear();
            }
            AiSTTListView aiSTTListView3 = this.sttListView;
            Intrinsics.checkNotNull(aiSTTListView3);
            aiSTTListView3.notifyDataSetChanged();
        }
    }

    public final void updateBackgroundColor() {
        Context context = this.mContext;
        if (context != null) {
            if (this.mIsInitializedFromTabletLayout) {
                View view = this.sttContainer;
                if (view != null) {
                    view.setBackground(AppCompatResources.getDrawable(context, C11493R.drawable.stt_floating_container_background));
                    return;
                }
                return;
            }
            View view2 = this.sttContainer;
            if (view2 != null) {
                view2.setBackground(AppCompatResources.getDrawable(context, C11493R.drawable.stt_phone_container_background));
            }
        }
    }
}
