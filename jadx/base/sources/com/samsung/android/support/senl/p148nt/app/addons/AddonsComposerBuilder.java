package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6700n;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.stub.StubUtil;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.composer.data.ArgMdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.converter.DocumentEntityConverter;
import com.samsung.android.support.senl.p148nt.data.repository.converter.HashtagDataConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u00011B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u001e\u001a\u00020\u00002\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0011J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0011J\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010+\u001a\u0004\u0018\u00010\tJ\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsComposerBuilder;", "", "mEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "mode", "", "<init>", "(Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;I)V", "mIntent", "Landroid/content/Intent;", "initComposerIntent", "", "buildAllEnabledRecycleBinComposer", "buildAllEnabledMDEComposer", "writer", "", "isLeader", "", "accountType", "setDocumentData", "setData", "item", "Landroid/net/Uri;", "setUuid", "uuid", "setPaths", "srcPath", "dstPath", "setHighLightText", "highLightText", "setHashTagData", "tagList", "", "Lcom/samsung/android/support/senl/nt/base/common/tag/HashTagData;", "setConvertingEnabled", "enabled", "setLockInfo", "isLocked", "setCategoryInfo", "categoryTreeEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesCategoryTreeEntity;", "getTranslatedCategoryName", "getCategoryColorForAddons", "build", "setGroupSharingUserName", "setSettingValues", "copySettingBooleanValue", "tag", "defaultValue", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AddonsComposerBuilder {

    @NotNull
    private static final String TAG = "AddonsComposerBuilder";

    @NotNull
    private final NotesDocumentEntity mEntity;

    @Nullable
    private Intent mIntent;

    public AddonsComposerBuilder(@NotNull NotesDocumentEntity mEntity, int i) {
        Intrinsics.checkNotNullParameter(mEntity, "mEntity");
        this.mEntity = mEntity;
        MainLogger.m7258i(TAG, "AddonsComposerBuilder, entity: " + mEntity);
        initComposerIntent(i);
        setDocumentData();
    }

    private final Intent buildAllEnabledMDEComposer(String writer, boolean isLeader) {
        return buildAllEnabledMDEComposer(writer, isLeader ? 1 : 2);
    }

    private final Intent buildAllEnabledRecycleBinComposer() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.samsung.android.app.notes.addons", AddonsConstants.ADDONS_RECYCLEBIN_CLASS_NAME));
        return intent;
    }

    private final void copySettingBooleanValue(String tag, boolean defaultValue) {
        boolean z = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(tag, defaultValue);
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(tag, z);
        }
    }

    private final int getCategoryColorForAddons(NotesCategoryTreeEntity categoryTreeEntity) {
        if (Intrinsics.areEqual("2", categoryTreeEntity.getUuid())) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                return applicationContext.getColor(C8003R.color.category_mark_color_screen_off_memo);
            }
            return 0;
        }
        if (Intrinsics.areEqual("1", categoryTreeEntity.getUuid())) {
            Context applicationContext2 = BaseUtils.getApplicationContext();
            if (applicationContext2 != null) {
                return applicationContext2.getColor(C8003R.color.category_mark_color_background_uncategorized);
            }
            return 0;
        }
        int displayNameColor = categoryTreeEntity.getDisplayNameColor();
        AbstractC6670b.m4736A(displayNameColor, "getCategoryColorForAddons prev color : ", TAG);
        if (displayNameColor != -2 && displayNameColor != -1) {
            return displayNameColor;
        }
        Context applicationContext3 = BaseUtils.getApplicationContext();
        if (applicationContext3 != null) {
            return applicationContext3.getColor(C8003R.color.category_mark_color_background_uncategorized);
        }
        return 0;
    }

    private final String getTranslatedCategoryName(NotesCategoryTreeEntity categoryTreeEntity) {
        if (Intrinsics.areEqual(categoryTreeEntity.getUuid(), "1")) {
            Context applicationContext = BaseUtils.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext);
            String string = applicationContext.getString(C8003R.string.uncategorised);
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (!Intrinsics.areEqual(categoryTreeEntity.getUuid(), "2")) {
            String displayName = categoryTreeEntity.getDisplayName();
            Intrinsics.checkNotNull(displayName);
            return displayName;
        }
        Context applicationContext2 = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext2);
        String string2 = applicationContext2.getString(C8003R.string.string_screen_off_memo);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    private final void initComposerIntent(int mode) {
        this.mIntent = mode != 1 ? mode != 3 ? mode != 4 ? buildAllEnabledMDEComposer("test", true) : buildAllEnabledRecycleBinComposer() : buildAllEnabledMDEComposer("test", false) : buildAllEnabledMDEComposer("test", true);
    }

    private final void setDocumentData() {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(AddonsConstants.ADDONS_DOCUMENT_DATA, new DocumentEntityConverter().convert(this.mEntity));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.samsung.android.support.senl.nt.base.common.sync.SesUiListener] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.samsung.android.app.notes.sync.contentsharing.sessession.n, com.samsung.android.app.notes.sync.contentsharing.sessession.p] */
    private final void setGroupSharingUserName() {
        ?? r02;
        ?? r12 = 0;
        r12 = 0;
        r12 = 0;
        r12 = 0;
        r12 = 0;
        if (!TextUtils.isEmpty(this.mEntity.getMdeGroupId()) && !TextUtils.isEmpty(this.mEntity.getMdeOwnerId())) {
            try {
                try {
                    C6716p.m4809q().m4796c(3);
                    String strM4858p = C6700n.m4785b().m4786a(this.mEntity.getMdeGroupId()).m4858p(this.mEntity.getMdeOwnerId());
                    C6716p.m4809q().m4797d(3, null);
                    r12 = strM4858p;
                } catch (Exception e) {
                    MainLogger.m7254d(TAG, e.getMessage());
                    C6716p.m4809q().m4797d(3, null);
                }
            } catch (Throwable th) {
                C6716p.m4809q().m4797d(3, r12);
                throw th;
            }
        }
        if (r12 == 0 || r12.length() == 0 || (r02 = this.mIntent) == 0) {
            return;
        }
        r02.putExtra(AddonsConstants.ADDONS_ARG_GROUP_SHARING_USER_NAME, r12);
    }

    private final void setSettingValues() {
        copySettingBooleanValue(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, true);
        copySettingBooleanValue(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false);
        copySettingBooleanValue(SettingsConstants.SETTINGS_ACTION_ICONS, true);
    }

    @Nullable
    public final Intent build() {
        setGroupSharingUserName();
        setSettingValues();
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.setAction("android.intent.action.VIEW");
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null) {
            intent2.setFlags(3);
        }
        Intent intent3 = this.mIntent;
        if (intent3 != null) {
            intent3.putExtra(AddonsConstants.ADDONS_ARG_CALLER_NEW_NOTES, true);
        }
        return this.mIntent;
    }

    @NotNull
    public final AddonsComposerBuilder setCategoryInfo(@Nullable NotesCategoryTreeEntity categoryTreeEntity) {
        if (categoryTreeEntity != null) {
            Intent intent = this.mIntent;
            if (intent != null) {
                intent.putExtra(AddonsConstants.ADDONS_DOCUMENT_CATEGORY_NAME, getTranslatedCategoryName(categoryTreeEntity));
            }
            Intent intent2 = this.mIntent;
            if (intent2 != null) {
                intent2.putExtra(AddonsConstants.ADDONS_DOCUMENT_CATEGORY_COLOR, getCategoryColorForAddons(categoryTreeEntity));
            }
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setConvertingEnabled(boolean enabled) {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(AddonsConstants.ADDONS_CONVERT_SDOCX, enabled);
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setData(@Nullable Uri item) {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.setDataAndType(item, Constants.MIME_SDOC);
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setHashTagData(@Nullable List<HashTagData> tagList) {
        if (tagList != null) {
            Intent intent = this.mIntent;
            Bundle bundleExtra = intent != null ? intent.getBundleExtra(AddonsConstants.ADDONS_DOCUMENT_DATA) : null;
            if (bundleExtra != null) {
                bundleExtra.putStringArrayList(HashtagDataConverter.ADDONS_DOCUMENT_DATA_HASHTAG, new ArrayList<>(new HashtagDataConverter().convert(tagList)));
            }
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setHighLightText(@Nullable String highLightText) {
        Intent intent;
        if (highLightText != null && (intent = this.mIntent) != null) {
            intent.putExtra("highlighttext", highLightText);
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setLockInfo(boolean isLocked) {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(AddonsConstants.ADDONS_IS_LOCKED, isLocked);
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setPaths(@Nullable String srcPath, @Nullable String dstPath) {
        Intent intent = this.mIntent;
        if (intent != null) {
            intent.putExtra(AddonsConstants.ADDONS_DOCUMENT_PATH, srcPath);
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null) {
            intent2.putExtra(AddonsConstants.ADDONS_COPIED_DOCUMENT_PATH, dstPath);
        }
        return this;
    }

    @NotNull
    public final AddonsComposerBuilder setUuid(@Nullable String uuid) {
        Intent intent = this.mIntent;
        Intrinsics.checkNotNull(intent);
        intent.putExtra(AddonsConstants.ADDONS_DOCUMENT_UUID, uuid);
        return this;
    }

    private final Intent buildAllEnabledMDEComposer(String writer, int accountType) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.samsung.android.app.notes.addons", AddonsConstants.ADDONS_COMPOSER_CLASS_NAME));
        if (PackageManagerCompat.compareVersionName$default(PackageManagerCompat.INSTANCE.getInstance(), StubUtil.getVersionName(), "2.1.1.2", 0, 4, null) < 0) {
            intent.putExtra(ComposerConstants.ARG_MDE_INFO, new ArgMdeInfo(this.mEntity.getMdeSpaceId(), this.mEntity.getMdeGroupId(), this.mEntity.getMdeOwnerId(), writer, accountType));
            return intent;
        }
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, this.mEntity.getMdeSpaceId());
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, this.mEntity.getMdeGroupId());
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, this.mEntity.getMdeOwnerId());
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, accountType);
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, writer);
        return intent;
    }
}
