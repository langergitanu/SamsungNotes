package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0012\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants;", "", "<init>", "()V", "Preference", "DeliveryParcelableKey", "BooleanExtraKey", "StringExtraKey", "StringExtra", "IntentAction", "IntentExtraName", "IntentExtraValue", "InternalServiceName", "ExternalPackageName", "ExternalPackageMetaDataName", "ExternalProviderInformation", "ExternalClassName", "PackageNameSuffix", "PairedColorCode", "Document", "TimeDefinition", "CloseReason", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constants {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$BooleanExtraKey;", "", "<init>", "()V", "PRE_INITIALIZED_COM", "", "CONTROL_SERVICE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BooleanExtraKey {

        @NotNull
        public static final String CONTROL_SERVICE = "control_service";

        @NotNull
        public static final BooleanExtraKey INSTANCE = new BooleanExtraKey();

        @NotNull
        public static final String PRE_INITIALIZED_COM = "pre_initialized";

        private BooleanExtraKey() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$CloseReason;", "", "<init>", "()V", CoverStickerConstants.Category.NONE.NAME, "", "PEN_ATTACH", "KEY_BACK", "DIALOG_DISCARD", "DIALOG_SAVE", "BUTTON_SAVE", "PIN_APPLY", "HOME", "INTERRUPT", "FOLDED", "EXCEPTION", "toStringCloseReason", "", "closeReason", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CloseReason {
        public static final int BUTTON_SAVE = 4;
        public static final int DIALOG_DISCARD = 2;
        public static final int DIALOG_SAVE = 3;
        public static final int EXCEPTION = 9;
        public static final int FOLDED = 8;
        public static final int HOME = 6;

        @NotNull
        public static final CloseReason INSTANCE = new CloseReason();
        public static final int INTERRUPT = 7;
        public static final int KEY_BACK = 1;
        public static final int NONE = -1;
        public static final int PEN_ATTACH = 0;
        public static final int PIN_APPLY = 5;

        private CloseReason() {
        }

        @NotNull
        public final String toStringCloseReason(int closeReason) {
            switch (closeReason) {
                case 0:
                    return "PEN_ATTACH";
                case 1:
                    return "KEY_BACK";
                case 2:
                    return "DIALOG_DISCARD";
                case 3:
                default:
                    return CoverStickerConstants.Category.NONE.NAME;
                case 4:
                    return "BUTTON_SAVE";
                case 5:
                    return "PIN_APPLY";
                case 6:
                    return "HOME";
                case 7:
                    return "INTERRUPT";
                case 8:
                    return "FOLDED";
                case 9:
                    return "EXCEPTION";
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$DeliveryParcelableKey;", "", "<init>", "()V", "STATE", "", "LOADED_NOTE_TYPE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DeliveryParcelableKey {

        @NotNull
        public static final DeliveryParcelableKey INSTANCE = new DeliveryParcelableKey();

        @NotNull
        public static final String LOADED_NOTE_TYPE = "loaded_note_type";

        @NotNull
        public static final String STATE = "state";

        private DeliveryParcelableKey() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$Document;", "", "<init>", "()V", "PAGE_COUNT", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Document {

        @NotNull
        public static final Document INSTANCE = new Document();
        public static final int PAGE_COUNT = 100;

        private Document() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$ExternalClassName;", "", "<init>", "()V", "AOD_PINNED_PREVIEW_SERVICE", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ExternalClassName {

        @NotNull
        public static final String AOD_PINNED_PREVIEW_SERVICE = "com.samsung.android.app.aodservice.settings.AODPinnedPreviewService";

        @NotNull
        public static final ExternalClassName INSTANCE = new ExternalClassName();

        private ExternalClassName() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$ExternalPackageMetaDataName;", "", "<init>", "()V", "AOD_SERVICE_META_DATA", "", "AOD_PINNED_PREVIEW_VERSION_META_DATA", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ExternalPackageMetaDataName {

        @NotNull
        public static final String AOD_PINNED_PREVIEW_VERSION_META_DATA = "aod_pinned_preview_version";

        @NotNull
        public static final String AOD_SERVICE_META_DATA = "com.samsung.android.app.aodservice.settings.AODPinnedPreviewService";

        @NotNull
        public static final ExternalPackageMetaDataName INSTANCE = new ExternalPackageMetaDataName();

        private ExternalPackageMetaDataName() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$ExternalPackageName;", "", "<init>", "()V", "AOD_SERVICE", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ExternalPackageName {

        @NotNull
        public static final String AOD_SERVICE = "com.samsung.android.app.aodservice";

        @NotNull
        public static final ExternalPackageName INSTANCE = new ExternalPackageName();

        private ExternalPackageName() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$ExternalProviderInformation;", "", "<init>", "()V", "AOD_PINNED_CONTENT_INFO_URI", "", "SCREEN_OFF_PINNED_DATA_COLUMN_NAME", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ExternalProviderInformation {

        @NotNull
        public static final String AOD_PINNED_CONTENT_INFO_URI = "content://com.samsung.android.app.aodservice.provider/settings/aod_pinned_content_info";

        @NotNull
        public static final ExternalProviderInformation INSTANCE = new ExternalProviderInformation();

        @NotNull
        public static final String SCREEN_OFF_PINNED_DATA_COLUMN_NAME = "AOD_PINNED_CONTENT_INFO_STR_DATA";

        private ExternalProviderInformation() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$IntentAction;", "", "<init>", "()V", IntentAction.EXPOSE_SCREEN_OFF, "", IntentAction.SCREEN_OFF, IntentAction.PIN, "AOD_PINNED_PREVIEW_SERVICE", IntentAction.NOTIFY_EXECUTION, "BLACK_MEMO", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class IntentAction {

        @NotNull
        public static final String AOD_PINNED_PREVIEW_SERVICE = "com.samsung.android.app.aodservice.settings.AODPinnedPreviewService";

        @NotNull
        public static final String BLACK_MEMO = "com.sec.android.intent.action.BLACK_MEMO";

        @NotNull
        public static final String EXPOSE_SCREEN_OFF = "EXPOSE_SCREEN_OFF";

        @NotNull
        public static final IntentAction INSTANCE = new IntentAction();

        @NotNull
        public static final String NOTIFY_EXECUTION = "NOTIFY_EXECUTION";

        @NotNull
        public static final String PIN = "PIN";

        @NotNull
        public static final String SCREEN_OFF = "SCREEN_OFF";

        private IntentAction() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$IntentExtraName;", "", "<init>", "()V", "PIN_IMAGE_PATH", "", "PIN_URI", "IS_EDITED", "TARGET", CredentialProviderBaseController.TYPE_TAG, "URI", "EDITED", "VERSION", "AOD_CONTENT_VIEW_ACTION", "AOD_CONTENT_VIEW_DATA", "AOD_CONTENT_VIEW_PACKAGE_NAME", "AOD_CONTENT_VIEW_ACTIVITY_NAME", "STATE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class IntentExtraName {

        @NotNull
        public static final String AOD_CONTENT_VIEW_ACTION = "aod_content_view_action";

        @NotNull
        public static final String AOD_CONTENT_VIEW_ACTIVITY_NAME = "aod_content_view_activity_name";

        @NotNull
        public static final String AOD_CONTENT_VIEW_DATA = "aod_content_view_data";

        @NotNull
        public static final String AOD_CONTENT_VIEW_PACKAGE_NAME = "aod_content_view_package_name";

        @NotNull
        public static final String EDITED = "edited";

        @NotNull
        public static final IntentExtraName INSTANCE = new IntentExtraName();

        @NotNull
        public static final String IS_EDITED = "isEdited";

        @NotNull
        public static final String PIN_IMAGE_PATH = "pinImagePath";

        @NotNull
        public static final String PIN_URI = "pinUri";

        @NotNull
        public static final String STATE = "state";

        @NotNull
        public static final String TARGET = "target";

        @NotNull
        public static final String TYPE = "type";

        @NotNull
        public static final String URI = "uri";

        @NotNull
        public static final String VERSION = "version";

        private IntentExtraName() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$IntentExtraValue;", "", "<init>", "()V", "TARGET_VALUE_MEMO", "", "AOD_CONTENT_VIEW_ACTION_VALUE_PIN_COM_LOAD", CoverStickerConstants.Category.NONE.NAME, "SHOW", CoeditGrpcMethod.Caller.CLOSE, "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class IntentExtraValue {

        @NotNull
        public static final String AOD_CONTENT_VIEW_ACTION_VALUE_PIN_COM_LOAD = "pin_com_load";

        @NotNull
        public static final String CLOSE = "close";

        @NotNull
        public static final IntentExtraValue INSTANCE = new IntentExtraValue();

        @NotNull
        public static final String NONE = "none";

        @NotNull
        public static final String SHOW = "show";

        @NotNull
        public static final String TARGET_VALUE_MEMO = "memo";

        private IntentExtraValue() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$InternalServiceName;", "", "<init>", "()V", "SCREEN_OFF_MEMO_SERVICE", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class InternalServiceName {

        @NotNull
        public static final InternalServiceName INSTANCE = new InternalServiceName();

        @NotNull
        public static final String SCREEN_OFF_MEMO_SERVICE = "ScreenOffMemoService";

        private InternalServiceName() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$PackageNameSuffix;", "", "<init>", "()V", "SCREEN_OFF_MEMO", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PackageNameSuffix {

        @NotNull
        public static final PackageNameSuffix INSTANCE = new PackageNameSuffix();

        @NotNull
        public static final String SCREEN_OFF_MEMO = "screenoffmemo";

        private PackageNameSuffix() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$PairedColorCode;", "", "<init>", "()V", "DEFAULT", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PairedColorCode {

        @NotNull
        public static final String DEFAULT = "DEF";

        @NotNull
        public static final PairedColorCode INSTANCE = new PairedColorCode();

        private PairedColorCode() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$Preference;", "", "<init>", "()V", "SCREEN_OFF_COMMON_PREF", "", "PREF_KEY_SAVED_PAIRED_COLOR_CODE", "PREF_KEY_FIRST_EXECUTED", "PREF_KEY_ACTIVITY_STATE", "PREF_KEY_NOTIFY_EXECUTION_REFRESH", "SCREEN_OFF_SAVE_PREF", Preference.PREF_KEY_CACHED_NOTE_UUID, Preference.PREF_KEY_CACHED_NOTE_PATH, "PREF_KEY_PINNED_URI", "PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y", "SCREEN_OFF_SPEN_SETTINGS_PREF", "PREF_KEY_PEN_SIZE", "PREF_KEY_PEN_SIZE_LEVEL", "PREF_KEY_PEN_COLOR", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Preference {

        @NotNull
        public static final Preference INSTANCE = new Preference();

        @NotNull
        public static final String PREF_KEY_ACTIVITY_STATE = "ActivityState";

        @NotNull
        public static final String PREF_KEY_CACHED_NOTE_PATH = "PREF_KEY_CACHED_NOTE_PATH";

        @NotNull
        public static final String PREF_KEY_CACHED_NOTE_UUID = "PREF_KEY_CACHED_NOTE_UUID";

        @NotNull
        public static final String PREF_KEY_FIRST_EXECUTED = "FirstExecuted";

        @NotNull
        public static final String PREF_KEY_NOTIFY_EXECUTION_REFRESH = "Notify_Execution_Refresh";

        @NotNull
        public static final String PREF_KEY_PEN_COLOR = "KEY_SETTING_PEN_INFO_COLOR";

        @NotNull
        public static final String PREF_KEY_PEN_SIZE = "KEY_SETTING_PEN_INFO";

        @NotNull
        public static final String PREF_KEY_PEN_SIZE_LEVEL = "KEY_SETTING_PEN_INFO_SIZE_LEVEL";

        @NotNull
        public static final String PREF_KEY_PINNED_NOTE_SCROLL_PAN_Y = "pinned_note_scroll_pan_y";

        @NotNull
        public static final String PREF_KEY_PINNED_URI = "pinned_uri";

        @NotNull
        public static final String PREF_KEY_SAVED_PAIRED_COLOR_CODE = "SavedPairedColorCode";

        @NotNull
        public static final String SCREEN_OFF_COMMON_PREF = "ScreenOffMemoPref";

        @NotNull
        public static final String SCREEN_OFF_SAVE_PREF = "_save_screenoffmemo_v0";

        @NotNull
        public static final String SCREEN_OFF_SPEN_SETTINGS_PREF = "_spensettings_screenoffmemo_v0";

        private Preference() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$StringExtra;", "", "<init>", "()V", "EXECUTE_TYPE_ACTIVITY", "", "EXECUTE_TYPE_SERVICE", "PEN_ATTACH", "PEN_DETACH", "PEN_BUTTON_HOVER_TAP", "HOME_KEY", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StringExtra {

        @NotNull
        public static final String EXECUTE_TYPE_ACTIVITY = "activity";

        @NotNull
        public static final String EXECUTE_TYPE_SERVICE = "service";

        @NotNull
        public static final String HOME_KEY = "homekey";

        @NotNull
        public static final StringExtra INSTANCE = new StringExtra();

        @NotNull
        public static final String PEN_ATTACH = "pen_attach";

        @NotNull
        public static final String PEN_BUTTON_HOVER_TAP = "pen_doubletab";

        @NotNull
        public static final String PEN_DETACH = "pen_detach";

        private StringExtra() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$StringExtraKey;", "", "<init>", "()V", "EXECUTE_TYPE", "", "PEN_INTENT_COM", "AOD_INTENT_PIN_COM_LOAD", "AOD_INTENT_PIN_COM_DELETE", "AOD_INTENT_PIN_PRE_RESULT", "AOD_INTENT_PIN_RESULT_APPLY", "AOD_INTENT_PIN_RESULT_HOME", "AOD_INTENT_PIN_RESULT_BACK", "AOD_INTENT_PIN_RESULT_PAUSE", "AOD_INTENT_PIN_RESULT_LCD_OFF", "AOD_INTENT_PIN_RESULT_REJECT", "ACTION_CLOSE_SYSTEM_DIALOGS_REASON", "DO_NOT_UPDATE_WINDOW_FLAG", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StringExtraKey {

        @NotNull
        public static final String ACTION_CLOSE_SYSTEM_DIALOGS_REASON = "reason";

        @NotNull
        public static final String AOD_INTENT_PIN_COM_DELETE = "pin_com_delete";

        @NotNull
        public static final String AOD_INTENT_PIN_COM_LOAD = "pin_com_load";

        @NotNull
        public static final String AOD_INTENT_PIN_PRE_RESULT = "pin_pre_result";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_APPLY = "pin_result_apply";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_BACK = "pin_result_back";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_HOME = "pin_result_home";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_LCD_OFF = "pin_result_lcd_off";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_PAUSE = "pin_result_pause";

        @NotNull
        public static final String AOD_INTENT_PIN_RESULT_REJECT = "pin_result_reject";

        @NotNull
        public static final String DO_NOT_UPDATE_WINDOW_FLAG = "do_not_update_window_flag";

        @NotNull
        public static final String EXECUTE_TYPE = "execute_type";

        @NotNull
        public static final StringExtraKey INSTANCE = new StringExtraKey();

        @NotNull
        public static final String PEN_INTENT_COM = "pen_intent_com";

        private StringExtraKey() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/Constants$TimeDefinition;", "", "<init>", "()V", "DVFS_BOOST_TIMEOUT", "", "ACQUIRE_WAKE_LOCK_TIMEOUT", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TimeDefinition {
        public static final int ACQUIRE_WAKE_LOCK_TIMEOUT = 3000;
        public static final int DVFS_BOOST_TIMEOUT = 3000;

        @NotNull
        public static final TimeDefinition INSTANCE = new TimeDefinition();

        private TimeDefinition() {
        }
    }
}
