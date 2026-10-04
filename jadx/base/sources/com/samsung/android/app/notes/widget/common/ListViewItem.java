package com.samsung.android.app.notes.widget.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.theme.NoteListThemeManager;
import com.samsung.android.app.notes.widget.util.WidgetListUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J(\u0010!\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\"\u0010\"\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010&\u001a\u00020'8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/common/ListViewItem;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mMainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "mUuid", "", "mIsUnlock", "", "mIsDark", "<init>", "(Landroid/content/Context;ILcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;Ljava/lang/String;ZZ)V", "remoteViews", "Landroid/widget/RemoteViews;", "getRemoteViews", "()Landroid/widget/RemoteViews;", "setBackground", "", "isDark", "decorateTitle", "mainListDocumentData", "decorateTime", "lastModifiedAt", "", "decorateIcons", "isUnlock", "isFavorite", "hasVoiceRecording", "decorateThumbnail", "uuid", "decorateDefaultThumbnail", "decorateCoverCapturedImage", "coverStateTuple", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentCoverEntity;", "setOnClickFillInIntent", "coverThumbnailTypeValue", "Lcom/samsung/android/support/senl/nt/model/document/save/CoverThumbnailCreator$ThumbnailType;", "getCoverThumbnailTypeValue", "()Lcom/samsung/android/support/senl/nt/model/document/save/CoverThumbnailCreator$ThumbnailType;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ListViewItem {

    @NotNull
    private static final String TAG = "ListViewItem";
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

    public ListViewItem(@NotNull Context mContext, int i, @NotNull MainListDocumentData mMainListDocumentData, @NotNull String mUuid, boolean z, boolean z2) {
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

    private final void decorateCoverCapturedImage(MainListDocumentData mainListDocumentData, NotesDocumentCoverEntity coverStateTuple, RemoteViews remoteViews) {
        if (!CoverThumbnailCreator.isExistCoverFile(this.mContext, mainListDocumentData.getUuid(), getCoverThumbnailTypeValue())) {
            WidgetLogger.INSTANCE.m5157e(TAG, "decorateCoverCapturedImage# existFile null");
            return;
        }
        if (coverStateTuple == null) {
            NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentCoverRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
            if (notesDocumentCoverRepositoryCreateDocumentCoverRepository.getEntity(this.mUuid) == null) {
                WidgetLogger.INSTANCE.m5157e(TAG, "decorateCoverCapturedImage# coverStateTuple null");
                return;
            }
        }
        Context context = this.mContext;
        Drawable coverThumbnail = CoverThumbnailCreator.getCoverThumbnail(context, mainListDocumentData.getUuid(), getCoverThumbnailTypeValue());
        Intrinsics.checkNotNull(coverThumbnail, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap bitmap = ((BitmapDrawable) coverThumbnail).getBitmap();
        Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
        remoteViews.setImageViewBitmap(C11391R.id.thumbnail, WidgetListUtils.getRoundedRectBitmap(context, bitmap, mainListDocumentData.getBackgroundColor()));
    }

    private final void decorateDefaultThumbnail(RemoteViews remoteViews, String uuid, MainListDocumentData mainListDocumentData, boolean isDark) {
        Bitmap thumbnailBitmap = WidgetListUtils.getThumbnailBitmap(this.mContext, uuid, mainListDocumentData, isDark);
        if (thumbnailBitmap == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "decorateThumbnail# bitmap null");
        } else {
            remoteViews.setImageViewBitmap(C11391R.id.thumbnail, thumbnailBitmap);
        }
    }

    private final void decorateIcons(RemoteViews remoteViews, boolean isUnlock, boolean isFavorite, boolean hasVoiceRecording) {
        StringBuilder sbM2230u = AbstractC2821a.m2230u("decorateIcons# unlock: ", ", isFavorite: ", ", hasVoiceRecording: ", isUnlock, isFavorite);
        sbM2230u.append(hasVoiceRecording);
        WidgetLogger.m5154d(TAG, sbM2230u.toString());
        remoteViews.setViewVisibility(C11391R.id.voice, (hasVoiceRecording && isUnlock) ? 0 : 8);
        remoteViews.setViewVisibility(C11391R.id.favorite, isFavorite ? 0 : 8);
        new NoteListThemeManager().updateListItemIconColor(this.mContext, remoteViews, this.mAppWidgetId);
    }

    private final void decorateThumbnail(RemoteViews remoteViews, String uuid, MainListDocumentData mainListDocumentData, boolean isDark) {
        remoteViews.setInt(C11391R.id.thumbnail, BaseWidgetConstant.SET_BACKGROUND_RESOURCE, isDark ? C11391R.drawable.widget_list_item_thumbnail_rounded_corner_shape_dark : C11391R.drawable.widget_list_item_thumbnail_rounded_corner_shape);
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentCoverRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
        DocumentCoverStateTuple coverStateTuple = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getCoverStateTuple(mainListDocumentData.getUuid());
        boolean z = coverStateTuple != null && coverStateTuple.isEnabled();
        WidgetLogger.m5154d(TAG, "decorateThumbnail# coverStateTuple : " + z);
        if (!z) {
            decorateDefaultThumbnail(remoteViews, uuid, mainListDocumentData, isDark);
            return;
        }
        Integer numValueOf = coverStateTuple != null ? Integer.valueOf(coverStateTuple.state) : null;
        if ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == -2)))) {
            decorateCoverCapturedImage(mainListDocumentData, coverStateTuple, remoteViews);
        } else {
            decorateDefaultThumbnail(remoteViews, uuid, mainListDocumentData, isDark);
        }
    }

    private final void decorateTime(RemoteViews remoteViews, long lastModifiedAt) {
        WidgetLogger.m5154d(TAG, "decorateTime# " + lastModifiedAt);
        remoteViews.setTextViewText(C11391R.id.time, WidgetListUtils.getDate(this.mContext, lastModifiedAt));
        new NoteListThemeManager().updateListItemTimeColor(this.mContext, remoteViews, this.mAppWidgetId);
    }

    private final void decorateTitle(RemoteViews remoteViews, MainListDocumentData mainListDocumentData) {
        WidgetLogger.m5154d(TAG, "decorateTitle#");
        String title = mainListDocumentData.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        if (TextUtils.isEmpty(title)) {
            CharSequence recommendTitleText = WidgetUtils.INSTANCE.getRecommendTitleText(this.mContext, mainListDocumentData);
            Intrinsics.checkNotNull(recommendTitleText);
            remoteViews.setTextViewText(C11391R.id.content, recommendTitleText);
            remoteViews.setViewVisibility(C11391R.id.title, 8);
            remoteViews.setViewVisibility(C11391R.id.content, 0);
        } else {
            remoteViews.setTextViewText(C11391R.id.title, title);
            remoteViews.setViewVisibility(C11391R.id.title, 0);
            remoteViews.setViewVisibility(C11391R.id.content, 8);
        }
        new NoteListThemeManager().updateListItemColor(this.mContext, remoteViews, this.mAppWidgetId);
    }

    private final void setBackground(RemoteViews remoteViews, boolean isDark) {
        remoteViews.setInt(C11391R.id.widget_list_item_layout, BaseWidgetConstant.SET_BACKGROUND_RESOURCE, isDark ? C11391R.drawable.widget_list_item_dark_bg_ripple : C11391R.drawable.widget_list_item_light_bg_ripple);
    }

    private final void setOnClickFillInIntent(RemoteViews remoteViews, MainListDocumentData mainListDocumentData) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, this.mAppWidgetId);
        String uuid = mainListDocumentData.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        bundle.putString("sdoc_uuid", uuid);
        if (C0158a.m407a().m415h()) {
            MdeInfo mdeInfo = new MdeInfo(mainListDocumentData.getMdeSpaceId(), mainListDocumentData.getMdeGroupId(), mainListDocumentData.getMdeOwnerId(), "", AbstractC14517a.m15166z(this.mContext, uuid) ? 1 : 2);
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
        remoteViews.setOnClickFillInIntent(C11391R.id.widget_list_item_layout, intent);
    }

    @NotNull
    public final CoverThumbnailCreator.ThumbnailType getCoverThumbnailTypeValue() {
        return CoverThumbnailCreator.ThumbnailType.SQUARE;
    }

    @NotNull
    public final RemoteViews getRemoteViews() {
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_list_item);
        setBackground(remoteViews, this.mIsDark);
        decorateTitle(remoteViews, this.mMainListDocumentData);
        decorateTime(remoteViews, this.mMainListDocumentData.getLastModifiedAt());
        decorateIcons(remoteViews, this.mIsUnlock, this.mMainListDocumentData.getIsFavorite() == 1, true ^ TextUtils.isEmpty(this.mMainListDocumentData.getVrUuid()));
        decorateThumbnail(remoteViews, this.mUuid, this.mMainListDocumentData, this.mIsDark);
        setOnClickFillInIntent(remoteViews, this.mMainListDocumentData);
        return remoteViews;
    }
}
