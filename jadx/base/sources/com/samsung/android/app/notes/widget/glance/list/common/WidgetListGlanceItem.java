package com.samsung.android.app.notes.widget.glance.list.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.ImageKt;
import androidx.glance.appwidget.animation.RemoteAnimation;
import androidx.glance.oneui.template.ImageData;
import androidx.glance.oneui.template.ImageType;
import androidx.glance.oneui.template.ImageWithBackgroundData;
import androidx.glance.oneui.template.TextType;
import androidx.glance.oneui.template.TypedTextData;
import androidx.glance.text.FontFamily;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.util.WidgetListUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/common/WidgetListGlanceItem;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mMainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "mUuid", "", "mIsUnlock", "", "mIsDark", "<init>", "(Landroid/content/Context;ILcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;Ljava/lang/String;ZZ)V", "uuid", "getUuid", "()Ljava/lang/String;", DynamicActionBarProvider.METHOD_GET_DATA, "Landroidx/glance/oneui/template/TypedTextData;", "getTime", "getIconVoiceAndFavorite", "", "Landroidx/glance/oneui/template/ImageData;", "iconVoiceColor", "Landroidx/glance/unit/ColorProvider;", "getIcon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getIconBitmap", "Landroid/graphics/Bitmap;", "getCoverBitmap", "mainListDocumentData", "coverStateTuple", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentCoverEntity;", "addIntentOpenNote", "Landroid/content/Intent;", "providerName", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceItem {

    @NotNull
    private static final String TAG = "ListItem";
    private final int mAppWidgetId;

    @NotNull
    private final Context mContext;
    private final boolean mIsDark;
    private final boolean mIsUnlock;

    @NotNull
    private final MainListDocumentData mMainListDocumentData;

    @NotNull
    private final String mUuid;
    public static final int $stable = 8;

    public WidgetListGlanceItem(@NotNull Context mContext, int i, @NotNull MainListDocumentData mMainListDocumentData, @NotNull String mUuid, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mMainListDocumentData, "mMainListDocumentData");
        Intrinsics.checkNotNullParameter(mUuid, "mUuid");
        this.mContext = mContext;
        this.mAppWidgetId = i;
        this.mMainListDocumentData = mMainListDocumentData;
        this.mUuid = mUuid;
        this.mIsUnlock = z;
        this.mIsDark = z2;
    }

    @NotNull
    public final Intent addIntentOpenNote(@NotNull String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intent intent = new Intent(this.mContext, WidgetListGlanceUtils.INSTANCE.getClassProvider(providerName));
        intent.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        Bundle bundle = new Bundle();
        bundle.putInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mAppWidgetId);
        String uuid = this.mMainListDocumentData.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        bundle.putString("sdoc_uuid", uuid);
        if (C0158a.m407a().m415h()) {
            MdeInfo mdeInfo = new MdeInfo(this.mMainListDocumentData.getMdeSpaceId(), this.mMainListDocumentData.getMdeGroupId(), this.mMainListDocumentData.getMdeOwnerId(), "", AbstractC14517a.m15166z(this.mContext, uuid) ? 1 : 2);
            if (!TextUtils.isEmpty(mdeInfo.getSpaceId())) {
                WidgetLogger.m5154d(TAG, "getFillInIntentForStartMemoList# this is mde file");
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
                bundle.putString(ComposerConstants.ARG_MDE_SPACE_ID, mdeInfo.getSpaceId());
                bundle.putString(ComposerConstants.ARG_MDE_GROUP_ID, mdeInfo.getGroupId());
                bundle.putString(ComposerConstants.ARG_MDE_OWNER_ID, mdeInfo.getOwnerId());
                bundle.putString(ComposerConstants.ARG_MDE_WRITER, mdeInfo.getCreatorName());
                bundle.putInt(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, mdeInfo.getAccountType());
            }
        }
        intent.putExtras(bundle);
        return intent;
    }

    @Nullable
    public final Bitmap getCoverBitmap(@NotNull MainListDocumentData mainListDocumentData, @Nullable NotesDocumentCoverEntity coverStateTuple) {
        Intrinsics.checkNotNullParameter(mainListDocumentData, "mainListDocumentData");
        CoverThumbnailCreator.ThumbnailType thumbnailType = CoverThumbnailCreator.ThumbnailType.SQUARE;
        if (!CoverThumbnailCreator.isExistCoverFile(this.mContext, this.mMainListDocumentData.getUuid(), thumbnailType)) {
            WidgetLogger.INSTANCE.m5157e(TAG, "getCoverBitmap# existFile null");
            return null;
        }
        if (coverStateTuple == null) {
            NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentCoverRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
            if (notesDocumentCoverRepositoryCreateDocumentCoverRepository.getEntity(this.mUuid) == null) {
                WidgetLogger.INSTANCE.m5157e(TAG, "getCoverBitmap# coverStateTuple null");
                return null;
            }
        }
        Drawable coverThumbnail = CoverThumbnailCreator.getCoverThumbnail(this.mContext, this.mMainListDocumentData.getUuid(), thumbnailType);
        Intrinsics.checkNotNull(coverThumbnail, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        return ((BitmapDrawable) coverThumbnail).getBitmap();
    }

    @Nullable
    public final ImageWithBackgroundData getIcon() {
        Bitmap thumbnailBitmap;
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentCoverRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
        DocumentCoverStateTuple coverStateTuple = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getCoverStateTuple(this.mMainListDocumentData.getUuid());
        if (coverStateTuple != null && coverStateTuple.isEnabled()) {
            Integer numValueOf = coverStateTuple != null ? Integer.valueOf(coverStateTuple.state) : null;
            if ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == -2))))) {
                Bitmap coverBitmap = getCoverBitmap(this.mMainListDocumentData, coverStateTuple);
                Intrinsics.checkNotNull(coverBitmap);
                return new ImageWithBackgroundData(ImageKt.ImageProvider(coverBitmap), "Image icon", ImageType.Icon, null, 0, null, null, false, 248, null);
            }
            thumbnailBitmap = WidgetListUtils.getThumbnailBitmap(this.mContext, this.mUuid, this.mMainListDocumentData, this.mIsDark);
        } else {
            thumbnailBitmap = WidgetListUtils.getThumbnailBitmap(this.mContext, this.mUuid, this.mMainListDocumentData, this.mIsDark);
        }
        if (thumbnailBitmap != null) {
            return new ImageWithBackgroundData(ImageKt.ImageProvider(thumbnailBitmap), "Image icon", ImageType.Icon, null, 0, null, null, false, 248, null);
        }
        return null;
    }

    @Nullable
    public final Bitmap getIconBitmap() {
        Bitmap thumbnailBitmap;
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentCoverRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
        DocumentCoverStateTuple coverStateTuple = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getCoverStateTuple(this.mMainListDocumentData.getUuid());
        if (coverStateTuple != null && coverStateTuple.isEnabled()) {
            Integer numValueOf = coverStateTuple != null ? Integer.valueOf(coverStateTuple.state) : null;
            if ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == -2))) {
                return getCoverBitmap(this.mMainListDocumentData, coverStateTuple);
            }
            thumbnailBitmap = WidgetListUtils.getThumbnailBitmap(this.mContext, this.mUuid, this.mMainListDocumentData, this.mIsDark);
        } else {
            thumbnailBitmap = WidgetListUtils.getThumbnailBitmap(this.mContext, this.mUuid, this.mMainListDocumentData, this.mIsDark);
        }
        if (thumbnailBitmap != null) {
            return thumbnailBitmap;
        }
        return null;
    }

    @NotNull
    public final List<ImageData> getIconVoiceAndFavorite(@NotNull ColorProvider iconVoiceColor) {
        Intrinsics.checkNotNullParameter(iconVoiceColor, "iconVoiceColor");
        ArrayList arrayList = new ArrayList();
        if (this.mMainListDocumentData.getIsFavorite() == 1) {
            arrayList.add(new ImageData(ImageKt.ImageProvider(C11391R.drawable.widget_ic_favorite), null, ImageType.Icon, null, null, false, 58, null));
        }
        if (!TextUtils.isEmpty(this.mMainListDocumentData.getVrUuid()) && this.mIsUnlock) {
            arrayList.add(new ImageData(ImageKt.ImageProvider(C11391R.drawable.widget_ic_voice), null, ImageType.Icon, iconVoiceColor, null, false, 50, null));
        }
        return arrayList;
    }

    @NotNull
    public final TypedTextData getTime() {
        return new TypedTextData(WidgetListUtils.getDate(this.mContext, this.mMainListDocumentData.getLastModifiedAt()), TextType.INSTANCE.m21689getBodygxbDmow(), ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(ContextCompat.getColor(this.mContext, C11391R.color.widget_white_theme_color))), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 65528, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TypedTextData getTitle() {
        String string = this.mMainListDocumentData.getTitle().toString();
        if (TextUtils.isEmpty(string)) {
            CharSequence recommendTitleText = WidgetUtils.INSTANCE.getRecommendTitleText(this.mContext, this.mMainListDocumentData);
            Intrinsics.checkNotNull(recommendTitleText);
            string = recommendTitleText.toString();
        }
        return new TypedTextData(string, TextType.INSTANCE.m21694getTitlegxbDmow(), ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(ContextCompat.getColor(this.mContext, C11391R.color.widget_list_glance_item_title_text_color_light))), 0, (TextDecoration) null, 0, (FontFamily) null, 0, false, false, (TextShadowStyle) null, (String) null, (RemoteAnimation) null, false, 0, 0, 65528, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* JADX INFO: renamed from: getUuid, reason: from getter */
    public final String getMUuid() {
        return this.mUuid;
    }
}
