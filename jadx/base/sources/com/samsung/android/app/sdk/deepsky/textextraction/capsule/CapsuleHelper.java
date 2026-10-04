package com.samsung.android.app.sdk.deepsky.textextraction.capsule;

import android.net.Uri;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.CapsuleActionType;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.value.Capsule;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001.J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0011H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020$H&J\b\u0010%\u001a\u00020\u0003H&J;\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010(2\b\u0010,\u001a\u0004\u0018\u00010(H&¢\u0006\u0002\u0010-¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "", "addActionCapsule", "", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "data", "Lcom/google/gson/JsonObject;", "addCapsule", "icon", "text", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/SimpleCapsuleClickListener;", "addToggleCapsule", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/ToggleCapsuleListener;", "defaultValue", "", "getCapsuleList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/value/Capsule;", "initCapsuleLayout", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/view/ViewGroup;", "initTranslateCapsule", "invalidateCapsuleLayout", "onConfigurationChanged", "onStartTextSelection", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "isImageTranslationOn", "setCapsuleLayoutVisibility", "isVisible", "setCapsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;", "setTranslateCapsuleListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/TranslateCapsuleListener;", "turnOffTranslate", "updateCapsuleColor", "backgroundColor", "", "textColor", "pressedBackgroundColor", "pressedTextColor", "rippleColor", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "CapsuleListener", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface CapsuleHelper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper$CapsuleListener;", "", "onAdd", "", "capsuleActionType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/data/CapsuleActionType;", "onClick", "onMoreButtonAppear", "onMoreButtonClick", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public interface CapsuleListener {
        void onAdd(@NotNull CapsuleActionType capsuleActionType);

        void onClick(@NotNull CapsuleActionType capsuleActionType);

        void onMoreButtonAppear();

        void onMoreButtonClick();
    }

    void addActionCapsule(@NotNull Uri imageUri, @NotNull JsonObject data);

    void addCapsule(@NotNull Uri icon, @NotNull String text, @NotNull SimpleCapsuleClickListener listener);

    void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull ToggleCapsuleListener listener);

    void addToggleCapsule(@NotNull Uri icon, @NotNull String text, @NotNull ToggleCapsuleListener listener, boolean defaultValue);

    @Nullable
    List<Capsule> getCapsuleList();

    void initCapsuleLayout(@NotNull ViewGroup layout);

    void initTranslateCapsule();

    void invalidateCapsuleLayout();

    void onConfigurationChanged();

    void onStartTextSelection(@NotNull OcrResult ocrResult, boolean isImageTranslationOn);

    void setCapsuleLayoutVisibility(boolean isVisible);

    void setCapsuleListener(@NotNull CapsuleListener listener);

    void setTranslateCapsuleListener(@NotNull TranslateCapsuleListener listener);

    void turnOffTranslate();

    void updateCapsuleColor(int backgroundColor, int textColor, @Nullable Integer pressedBackgroundColor, @Nullable Integer pressedTextColor, @Nullable Integer rippleColor);
}
