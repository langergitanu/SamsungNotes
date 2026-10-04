package com.samsung.android.support.senl.p148nt.base.common.access.notelist;

import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0015\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u0019\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u001d\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u001f\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010!\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u000e\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010#\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/notelist/NoteListAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "NOTELIST_CLASS", "Ljava/lang/Class;", "NOTELIST_BASE_CLASS", "NOTEPICKER_CLASS", "SETTINGS_CLASS", "SHARED_INVITATION_LIST_CLASS", "COEDIT_SPACE_PICKER_CLASS", "COEDIT_LAUNCH_SOCIAL_PICKER_CLASS", "LIVE_SHARING_CLASS", "NOTELIST_MULTI_INSTANCE_CLASS", "getNoteListClass", "setNoteListClass", "", "executor", "getNoteListBaseActivityClass", "setNoteListBaseActivityClass", "getNotePickerClass", "setNotePickerClass", "getSettingsActivity", "setSettingsActivity", "getSharedInvitationListClass", "setSharedInvitationListClass", "getCoeditSpacePickerClass", "setCoeditSpacePickerClass", "getSocialPickerClass", "setSocialPickerClass", "getLiveSharingActivityClass", "setLiveSharingActivityClass", "getNoteListMultiInstanceClass", "setNoteListMultiInstanceClass", "noteListMultiInstanceClass", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteListAccessHandler {

    @Nullable
    private static Class<?> COEDIT_LAUNCH_SOCIAL_PICKER_CLASS = null;

    @Nullable
    private static Class<?> COEDIT_SPACE_PICKER_CLASS = null;

    @NotNull
    public static final NoteListAccessHandler INSTANCE = new NoteListAccessHandler();

    @Nullable
    private static Class<?> LIVE_SHARING_CLASS = null;

    @Nullable
    private static Class<?> NOTELIST_BASE_CLASS = null;

    @Nullable
    private static Class<?> NOTELIST_CLASS = null;

    @Nullable
    private static Class<?> NOTELIST_MULTI_INSTANCE_CLASS = null;

    @Nullable
    private static Class<?> NOTEPICKER_CLASS = null;

    @Nullable
    private static Class<?> SETTINGS_CLASS = null;

    @Nullable
    private static Class<?> SHARED_INVITATION_LIST_CLASS = null;

    @NotNull
    private static final String TAG = "MemoListAccessHandler";

    private NoteListAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getCoeditSpacePickerClass() {
        return COEDIT_SPACE_PICKER_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getLiveSharingActivityClass() {
        return LIVE_SHARING_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getNoteListBaseActivityClass() {
        return NOTELIST_BASE_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getNoteListClass() {
        return NOTELIST_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getNoteListMultiInstanceClass() {
        return NOTELIST_MULTI_INSTANCE_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getNotePickerClass() {
        return NOTEPICKER_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getSettingsActivity() {
        return SETTINGS_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getSharedInvitationListClass() {
        return SHARED_INVITATION_LIST_CLASS;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getSocialPickerClass() {
        return COEDIT_LAUNCH_SOCIAL_PICKER_CLASS;
    }

    @JvmStatic
    public static final void setCoeditSpacePickerClass(@Nullable Class<?> executor) {
        if (COEDIT_SPACE_PICKER_CLASS == null) {
            COEDIT_SPACE_PICKER_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setCoeditSpacePickerClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setLiveSharingActivityClass(@Nullable Class<?> executor) {
        if (LIVE_SHARING_CLASS == null) {
            LIVE_SHARING_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setLiveSharingActivityClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setNoteListBaseActivityClass(@Nullable Class<?> executor) {
        if (NOTELIST_BASE_CLASS == null) {
            NOTELIST_BASE_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setNoteListBaseActivityClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setNoteListClass(@Nullable Class<?> executor) {
        if (NOTELIST_CLASS == null) {
            NOTELIST_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setNoteListClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setNoteListMultiInstanceClass(@Nullable Class<?> noteListMultiInstanceClass) {
        NOTELIST_MULTI_INSTANCE_CLASS = noteListMultiInstanceClass;
    }

    @JvmStatic
    public static final void setNotePickerClass(@Nullable Class<?> executor) {
        if (NOTEPICKER_CLASS == null) {
            NOTEPICKER_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setNotePickerClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setSettingsActivity(@Nullable Class<?> executor) {
        if (SETTINGS_CLASS == null) {
            SETTINGS_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setSettingsActivity, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setSharedInvitationListClass(@Nullable Class<?> executor) {
        if (SHARED_INVITATION_LIST_CLASS == null) {
            SHARED_INVITATION_LIST_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setSharedInvitationListClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setSocialPickerClass(@Nullable Class<?> executor) {
        if (COEDIT_LAUNCH_SOCIAL_PICKER_CLASS == null) {
            COEDIT_LAUNCH_SOCIAL_PICKER_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setSocialPickerClass, twice access! only first trial is accepted");
        }
    }
}
