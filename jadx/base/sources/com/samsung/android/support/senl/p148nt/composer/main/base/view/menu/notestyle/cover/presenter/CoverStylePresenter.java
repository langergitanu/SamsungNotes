package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002HIB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001f\u001a\u00020\u0015J\u0010\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\"\u001a\u00020\u0015J\u0010\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0015J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020&J\u001e\u0010)\u001a\u00020\u000f2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,J\u0018\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0015J\u0010\u00101\u001a\u00020\u000f2\b\u00102\u001a\u0004\u0018\u00010\u0015J\u000e\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020&J\u0006\u00105\u001a\u00020/J\u000e\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020/J\u0006\u00108\u001a\u00020/J\u000e\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020/J\u000e\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020&J\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020&J\u000e\u0010?\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0015J\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00150+j\b\u0012\u0004\u0012\u00020\u0015`,J\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150C0BJ\u000e\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u0015J\b\u0010F\u001a\u00020\u000fH\u0002J\u0006\u0010G\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCoverData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverData;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter$Contract;", "getMContract", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter$Contract;", "setMContract", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter$Contract;)V", "setContract", "", "contract", "initialize", "coverData", "getCoverData", "getNoteUuid", "", "getSummary", "setSummary", DBSchema.DocumentCover.SUMMARY, DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "title", "getTemplateUuid", "setTemplateUuid", "templateUuid", "getColorUuid", "setColorId", "colorId", "getStickerUuid", "setStickerUuid", "stickerUuid", "getEnabled", "", "setEnabled", "enable", "setSelectedTemplateList", "selectedTemplateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setSelectedTemplateUuid", "templateTypeIndex", "", "selectedTemplateUuid", "setExtractStr", "extractStr", "setAvailableAutoCover", "available", "getGenerateState", "setGenerateState", "generateState", "getState", "setState", "state", "setIsGeneratedCover", "isGeneratedCover", "setIsGeneratedTitle", "isGeneratedTitle", "getTypeIndex", "createSelectedTemplateList", "createTemplateMap", "", "", "saveCoverData", "log", "updateDefaultUuid", "savePreviewJpgWithView", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStylePresenter {

    @NotNull
    public static final String TAG = "CoverStylePresenter";

    @NotNull
    private final Context mContext;
    public Contract mContract;

    @Nullable
    private CoverData mCoverData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter$Contract;", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
    }

    public CoverStylePresenter(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final void updateDefaultUuid() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        if (Intrinsics.areEqual(coverData.getTemplateUuid(), "DEFAULT:///")) {
            setTemplateUuid("BASIC_STYLE_1:///");
        }
        CoverData coverData2 = this.mCoverData;
        Intrinsics.checkNotNull(coverData2);
        if (Intrinsics.areEqual(coverData2.getColorId(), "DEFAULT:///")) {
            setColorId(CoverConstants.Color.SET_1);
        }
    }

    @NotNull
    public final ArrayList<String> createSelectedTemplateList() {
        return CollectionsKt.arrayListOf(CoverConstants.Template.PATTERN_1, CoverConstants.Template.ILLUST_1, "BASIC_STYLE_1:///");
    }

    @NotNull
    public final Map<Integer, List<String>> createTemplateMap() {
        return MapsKt.mapOf(TuplesKt.m13893to(Integer.valueOf(CoverStyleConstants.CoverType.PATTERN.ordinal()), CoverEditorUtils.createPatternList()), TuplesKt.m13893to(Integer.valueOf(CoverStyleConstants.CoverType.ILLUST.ordinal()), CoverEditorUtils.createIllustList()), TuplesKt.m13893to(Integer.valueOf(CoverStyleConstants.CoverType.TEXT.ordinal()), CoverEditorUtils.createTextList()));
    }

    @NotNull
    public final String getColorUuid() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        String colorId = coverData.getColorId();
        Intrinsics.checkNotNullExpressionValue(colorId, "getColorId(...)");
        return colorId;
    }

    @NotNull
    public final CoverData getCoverData() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        return coverData;
    }

    public final boolean getEnabled() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        return coverData.isEnabled();
    }

    public final int getGenerateState() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        return coverData.getGenerateState();
    }

    @NotNull
    public final Contract getMContract() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContract");
        return null;
    }

    @Nullable
    public final String getNoteUuid() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        return coverData.getNoteUuid();
    }

    public final int getState() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        return coverData.isAiGeneratedCover() ? 4 : 2;
    }

    @NotNull
    public final String getStickerUuid() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        String categoryUuid = coverData.getCategoryUuid();
        Intrinsics.checkNotNullExpressionValue(categoryUuid, "getCategoryUuid(...)");
        return categoryUuid;
    }

    @NotNull
    public final String getSummary() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        String summary = coverData.getSummary();
        Intrinsics.checkNotNullExpressionValue(summary, "getSummary(...)");
        return summary;
    }

    @NotNull
    public final String getTemplateUuid() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        String templateUuid = coverData.getTemplateUuid();
        Intrinsics.checkNotNullExpressionValue(templateUuid, "getTemplateUuid(...)");
        return templateUuid;
    }

    @NotNull
    public final String getTitle() {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        String title = coverData.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        return title;
    }

    public final int getTypeIndex(@NotNull String templateUuid) {
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        String coverType = CoverStyleUtils.INSTANCE.getCoverType(templateUuid);
        if (Intrinsics.areEqual(coverType, "DEFAULT:///")) {
            return CoverStyleConstants.CoverType.TEXT.ordinal();
        }
        CoverStyleConstants.CoverType coverTypeFromString = CoverStyleConstants.CoverType.INSTANCE.fromString(coverType);
        Integer numValueOf = coverTypeFromString != null ? Integer.valueOf(coverTypeFromString.ordinal()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final void initialize(@Nullable CoverData coverData) {
        this.mCoverData = coverData;
    }

    public final void saveCoverData(@NotNull String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        Logger.m10999d(TAG, "saveCoverData# log : " + log);
        long jCurrentTimeMillis = System.currentTimeMillis();
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        if (coverData.getCreatedAt() == 0) {
            CoverData coverData2 = this.mCoverData;
            Intrinsics.checkNotNull(coverData2);
            coverData2.setCreatedAt(jCurrentTimeMillis);
        }
        CoverData coverData3 = this.mCoverData;
        Intrinsics.checkNotNull(coverData3);
        coverData3.setLastModifiedAt(jCurrentTimeMillis);
        setState(getState());
        updateDefaultUuid();
    }

    public final void savePreviewJpgWithView() {
        Logger.m10999d(TAG, "savePreviewJpgWithView");
        CoverEditorUtils.savePreviewJpg(this.mContext, getSummary(), getStickerUuid(), getTemplateUuid(), getColorUuid(), AbstractC0541b.m772n(CoverThumbnailCreator.COVER_PATH_PREFIX, getNoteUuid()), getState());
    }

    public final void setAvailableAutoCover(boolean available) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setAvailableAutoCover(available);
    }

    public final void setColorId(@Nullable String colorId) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setColorId(colorId);
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        setMContract(contract);
    }

    public final void setEnabled(boolean enable) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setEnabled(enable);
    }

    public final void setExtractStr(@Nullable String extractStr) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setExtractStr(extractStr);
    }

    public final void setGenerateState(int generateState) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setGenerateState(generateState);
    }

    public final void setIsGeneratedCover(boolean isGeneratedCover) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setIsGeneratedCover(isGeneratedCover);
    }

    public final void setIsGeneratedTitle(boolean isGeneratedTitle) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setIsGeneratedTitle(isGeneratedTitle);
    }

    public final void setMContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "<set-?>");
        this.mContract = contract;
    }

    public final void setSelectedTemplateList(@NotNull ArrayList<String> selectedTemplateList) {
        Intrinsics.checkNotNullParameter(selectedTemplateList, "selectedTemplateList");
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setSelectedTemplateList(selectedTemplateList);
    }

    public final void setSelectedTemplateUuid(int templateTypeIndex, @Nullable String selectedTemplateUuid) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setSelectedTemplateUuid(templateTypeIndex, selectedTemplateUuid);
    }

    public final void setState(int state) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setState(state);
    }

    public final void setStickerUuid(@Nullable String stickerUuid) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setCategoryUuid(stickerUuid);
    }

    public final void setSummary(@Nullable String summary) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setSummary(summary);
    }

    public final void setTemplateUuid(@Nullable String templateUuid) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setTemplateUuid(templateUuid);
    }

    public final void setTitle(@Nullable String title) {
        CoverData coverData = this.mCoverData;
        Intrinsics.checkNotNull(coverData);
        coverData.setTitle(title);
    }
}
