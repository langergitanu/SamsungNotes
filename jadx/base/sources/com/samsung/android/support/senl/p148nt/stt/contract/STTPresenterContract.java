package com.samsung.android.support.senl.p148nt.stt.contract;

import com.samsung.android.support.senl.p148nt.stt.base.model.AiParagraphInfo;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&JL\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH&J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0007H&J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000eH&J\u0018\u0010 \u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\u001c\u0010#\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0$H&J\u0018\u0010%\u001a\u00020\u00072\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H&J\b\u0010)\u001a\u00020*H&¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/contract/STTPresenterContract;", "", "isSTTSearchMode", "", "isSTTEditMode", "isShowSpeakerLabel", "onSTTDataChanged", "", "textDataList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/base/model/TextData;", "Lkotlin/collections/ArrayList;", "speakerNameMap", "", "", "", "speakerIDs", "", "startTimes", "", "endTimes", "onWordTouch", "touchedWordTimestamp", "onSTTItemConvertClick", "voiceItemIndex", "onSTTItemCheckedChange", "position", "isChecked", "onEditWordTouch", "onEditTextChanged", "string", "pos", "onTextDataListChanged", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "onSpeakerNameMapChanged", "", "onParagraphInfoChanged", "paragraphInfoList", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiParagraphInfo;", "getSTTPresenter", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface STTPresenterContract {
    @NotNull
    STTPresenter getSTTPresenter();

    boolean isSTTEditMode();

    boolean isSTTSearchMode();

    boolean isShowSpeakerLabel();

    void onEditTextChanged(@NotNull String string, int pos);

    void onEditWordTouch();

    void onParagraphInfoChanged(@Nullable List<AiParagraphInfo> paragraphInfoList);

    void onSTTDataChanged(@NotNull ArrayList<TextData> textDataList, @NotNull Map<Integer, String> speakerNameMap, @NotNull int[] speakerIDs, @NotNull long[] startTimes, @NotNull long[] endTimes);

    void onSTTItemCheckedChange(int position, boolean isChecked);

    void onSTTItemConvertClick(int voiceItemIndex);

    void onSpeakerNameMapChanged(@NotNull Map<Integer, String> speakerNameMap);

    void onTextDataListChanged(@Nullable List<AiTextData> textDataList);

    void onWordTouch(int touchedWordTimestamp);
}
