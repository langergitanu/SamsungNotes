package com.samsung.android.support.senl.p148nt.stt.picker.view;

import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/AudioPickerListViewAdapterContract;", "", "onAudioSelected", "", "recordingItem", "Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "onUpdateSortItem", "sortType", "", "sortOrder", "onAudioPlay", "disableProgressBar", "updateNoResultView", "visible", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface AudioPickerListViewAdapterContract {
    void disableProgressBar();

    void onAudioPlay(@NotNull RecordingItem recordingItem);

    void onAudioSelected(@NotNull RecordingItem recordingItem);

    void onUpdateSortItem(int sortType, int sortOrder);

    void updateNoResultView(boolean visible);
}
