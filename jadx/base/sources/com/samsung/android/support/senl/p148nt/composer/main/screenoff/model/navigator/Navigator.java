package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator;

import android.content.Intent;
import android.net.Uri;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\tH\u0016J\u0012\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010!\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\"¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "", "onInitialized", "", "onStarted", "onSave", "onSaveNoteCache", "onSavePinCache", "uri", "", "onFinish", "requestRestart", "reserveRestart", "requestShowSaveNoteDialog", "requestShowSelectNoteDialog", "requestShowPinNoteDialog", "pinnedNoteUri", "Landroid/net/Uri;", "getWindow", "Landroid/view/Window;", "getIntent", "Landroid/content/Intent;", "resetIntent", "onPreHide", "onPreShow", "requestReadyToShow", "withAnimation", "", "requestResetZoomScaleToDefault", "onShowingAnimation", "onClosingAnimationPenAttach", "blockUserInput", "enable", "isEmptyNote", "()Z", "isEditedNote", "hasCachedNote", "setLoadedPinUuid", "uuid", "setLoadedPinNotePath", "notePath", "setCloseReason", "closeReason", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface Navigator {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void blockUserInput(@NotNull Navigator navigator, boolean z) {
        }

        public static boolean hasCachedNote(@NotNull Navigator navigator) {
            return false;
        }

        public static boolean isEditedNote(@NotNull Navigator navigator) {
            return false;
        }

        public static boolean isEmptyNote(@NotNull Navigator navigator) {
            return false;
        }

        public static void onClosingAnimationPenAttach(@NotNull Navigator navigator) {
        }

        public static void onInitialized(@NotNull Navigator navigator) {
        }

        public static void onPreHide(@NotNull Navigator navigator) {
        }

        public static void onPreShow(@NotNull Navigator navigator) {
        }

        public static void onSave(@NotNull Navigator navigator) {
        }

        public static void onSaveNoteCache(@NotNull Navigator navigator) {
        }

        public static void onSavePinCache(@NotNull Navigator navigator, @Nullable String str) {
        }

        public static void onShowingAnimation(@NotNull Navigator navigator) {
        }

        public static void onStarted(@NotNull Navigator navigator) {
        }

        public static void requestReadyToShow(@NotNull Navigator navigator, boolean z) {
        }

        public static void requestResetZoomScaleToDefault(@NotNull Navigator navigator) {
        }

        public static void requestRestart(@NotNull Navigator navigator) {
        }

        public static void requestShowPinNoteDialog(@NotNull Navigator navigator, @NotNull Uri pinnedNoteUri) {
            Intrinsics.checkNotNullParameter(pinnedNoteUri, "pinnedNoteUri");
        }

        public static void requestShowSaveNoteDialog(@NotNull Navigator navigator) {
        }

        public static void requestShowSelectNoteDialog(@NotNull Navigator navigator) {
        }

        public static void reserveRestart(@NotNull Navigator navigator) {
        }

        public static void resetIntent(@NotNull Navigator navigator) {
        }

        public static void setCloseReason(@NotNull Navigator navigator, int i) {
        }

        public static void setLoadedPinNotePath(@NotNull Navigator navigator, @Nullable String str) {
        }

        public static void setLoadedPinUuid(@NotNull Navigator navigator, @NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
        }
    }

    void blockUserInput(boolean enable);

    @NotNull
    Intent getIntent();

    @Nullable
    Window getWindow();

    boolean hasCachedNote();

    boolean isEditedNote();

    boolean isEmptyNote();

    void onClosingAnimationPenAttach();

    void onFinish();

    void onInitialized();

    void onPreHide();

    void onPreShow();

    void onSave();

    void onSaveNoteCache();

    void onSavePinCache(@Nullable String uri);

    void onShowingAnimation();

    void onStarted();

    void requestReadyToShow(boolean withAnimation);

    void requestResetZoomScaleToDefault();

    void requestRestart();

    void requestShowPinNoteDialog(@NotNull Uri pinnedNoteUri);

    void requestShowSaveNoteDialog();

    void requestShowSelectNoteDialog();

    void reserveRestart();

    void resetIntent();

    void setCloseReason(int closeReason);

    void setLoadedPinNotePath(@Nullable String notePath);

    void setLoadedPinUuid(@NotNull String uuid);
}
