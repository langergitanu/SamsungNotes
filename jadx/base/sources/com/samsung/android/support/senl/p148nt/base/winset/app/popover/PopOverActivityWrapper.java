package com.samsung.android.support.senl.p148nt.base.winset.app.popover;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.util.CaptionBarHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005$%&'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u0007H\u0007J.\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0003\u0010\u0014\u001a\u00020\u0007H\u0007J.\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0001\u0010\u0014\u001a\u00020\u0007H\u0007J.\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0001\u0010\u0014\u001a\u00020\u0007H\u0007J&\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0007H\u0007J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J#\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper;", "", "<init>", "()V", "KEY_ANCHOR_TYPE", "", "DEFAULT_WIDTH", "", "DEFAULT_HEIGHT", "HEIGHT_FOR_COEDIT_PICKER", "HEIGHT_FOR_SETTINGS", "WIDTH_FOR_SETTING_BOTTOM", "HEIGHT_FOR_COVER", "HEIGHT_FOR_NEW_COVER", "startActivity", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "anchorType", "startActivityForResult", "requestCode", "fragment", "Landroidx/fragment/app/Fragment;", "startChooserActivityForResult", "startChooserActivity", "isShownAsPopOverLayout", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isPopOverLayout", "configuration", "Landroid/content/res/Configuration;", "(Landroid/content/Intent;Landroid/content/res/Configuration;)Ljava/lang/Boolean;", "getCurrentLayoutAnchorType", "AnchorPosition", ExifInterface.TAG_ORIENTATION, "AnchorType", "Builder", "ChooserBuilder", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopOverActivityWrapper {
    public static final int DEFAULT_HEIGHT = 603;
    public static final int DEFAULT_WIDTH = 360;
    public static final int HEIGHT_FOR_COEDIT_PICKER = 476;
    public static final int HEIGHT_FOR_COVER = 731;
    public static final int HEIGHT_FOR_NEW_COVER = 598;
    public static final int HEIGHT_FOR_SETTINGS = 731;

    @NotNull
    public static final PopOverActivityWrapper INSTANCE = new PopOverActivityWrapper();

    @NotNull
    public static final String KEY_ANCHOR_TYPE = "key_anchor_type";
    public static final int WIDTH_FOR_SETTING_BOTTOM = 400;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0080\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorPosition;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnchorPosition {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int HORIZONTAL_CENTER = 64;
        public static final int HORIZONTAL_LEFT = 16;
        public static final int HORIZONTAL_RIGHT = 32;
        public static final int VERTICAL_BOTTOM = 2;
        public static final int VERTICAL_CENTER = 4;
        public static final int VERTICAL_TOP = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorPosition$Companion;", "", "<init>", "()V", "HORIZONTAL_LEFT", "", "HORIZONTAL_RIGHT", "HORIZONTAL_CENTER", "VERTICAL_BOTTOM", "VERTICAL_TOP", "VERTICAL_CENTER", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int HORIZONTAL_CENTER = 64;
            public static final int HORIZONTAL_LEFT = 16;
            public static final int HORIZONTAL_RIGHT = 32;
            public static final int VERTICAL_BOTTOM = 2;
            public static final int VERTICAL_CENTER = 4;
            public static final int VERTICAL_TOP = 1;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00032\u00020\u0001:\u0002\u0002\u0003B\u0000¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorType;", "", "CoeditPicker", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnchorType {
        public static final int ACTION_BAR = 0;
        public static final int BOTTOM_BAR = 3;
        public static final int CONTEXT_MENU = 2;
        public static final int COVER = 7;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FULL_SCREEN = -1;
        public static final int NEW_COVER = 8;
        public static final int NONE = -2;
        public static final int ONBOARDING = 9;
        public static final int PAGE_BAR = 6;
        public static final int SEARCH_BAR = 1;
        public static final int SETTING = 4;
        public static final int SETTING_BOTTOM = 5;
        public static final int UNDEFINED = -3;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorType$CoeditPicker;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface CoeditPicker {
            public static final int ACTION_BAR = 101;
            public static final int BOTTOM_BAR = 102;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = Companion.$$INSTANCE;
            public static final int NONE = 100;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorType$CoeditPicker$Companion;", "", "<init>", "()V", CoverStickerConstants.Category.NONE.NAME, "", "ACTION_BAR", "BOTTOM_BAR", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final int ACTION_BAR = 101;
                public static final int BOTTOM_BAR = 102;
                public static final int NONE = 100;

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$AnchorType$Companion;", "", "<init>", "()V", "UNDEFINED", "", CoverStickerConstants.Category.NONE.NAME, "FULL_SCREEN", "ACTION_BAR", "SEARCH_BAR", "CONTEXT_MENU", "BOTTOM_BAR", "SETTING", "SETTING_BOTTOM", "PAGE_BAR", "COVER", "NEW_COVER", "ONBOARDING", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ACTION_BAR = 0;
            public static final int BOTTOM_BAR = 3;
            public static final int CONTEXT_MENU = 2;
            public static final int COVER = 7;
            public static final int FULL_SCREEN = -1;
            public static final int NEW_COVER = 8;
            public static final int NONE = -2;
            public static final int ONBOARDING = 9;
            public static final int PAGE_BAR = 6;
            public static final int SEARCH_BAR = 1;
            public static final int SETTING = 4;
            public static final int SETTING_BOTTOM = 5;
            public static final int UNDEFINED = -3;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J \u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u001a\u0010\u001d\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$Builder;", "", "context", "Landroid/content/Context;", "opts", "Landroid/app/ActivityOptions;", "anchorType", "", "<init>", "(Landroid/content/Context;Landroid/app/ActivityOptions;I)V", "getOpts", "()Landroid/app/ActivityOptions;", "getAnchorType", "()I", "width", "", "height", "anchorPosition", "margin", "", "Landroid/graphics/Point;", "[Landroid/graphics/Point;", "initialize", "", "initSize", "initMargin", "initPosition", "setPopOverSize", "orientation", "setPopOverMargin", "setPopOverAnchor", "anchor", "flipLeftRight", "targetAnchor", "build", "Landroid/os/Bundle;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Builder {
        private final int anchorType;

        @Nullable
        private final ActivityOptions opts;

        @JvmField
        @NotNull
        public final int[] width = new int[2];

        @JvmField
        @NotNull
        public final int[] height = new int[2];

        @JvmField
        @NotNull
        public final int[] anchorPosition = new int[2];

        @JvmField
        @NotNull
        public final Point[] margin = new Point[2];

        public Builder(@Nullable Context context, @Nullable ActivityOptions activityOptions, int i) {
            this.opts = activityOptions;
            this.anchorType = i;
            initialize(context);
        }

        private final int flipLeftRight(int targetAnchor) {
            return (targetAnchor & 32) > 1 ? (targetAnchor & (-33)) | 16 : (targetAnchor & 16) > 1 ? (targetAnchor & (-17)) | 32 : targetAnchor;
        }

        private final void initMargin(Context context) {
            int captionBarHeight = CaptionBarHelper.getCaptionBarHeight(context);
            setPopOverMargin(new Point(0, captionBarHeight), 0);
            setPopOverMargin(new Point(0, captionBarHeight), 1);
        }

        private final void initPosition() {
            int i = this.anchorType;
            if (i != 101) {
                if (i == 102) {
                    setPopOverAnchor(34, 0);
                    setPopOverAnchor(34, 1);
                    return;
                }
                switch (i) {
                    case 0:
                    case 7:
                    case 8:
                        break;
                    case 1:
                        setPopOverAnchor(34, 0);
                        setPopOverAnchor(34, 1);
                        break;
                    case 2:
                        setPopOverAnchor(68, 0);
                        setPopOverAnchor(68, 1);
                        break;
                    case 3:
                        setPopOverAnchor(66, 0);
                        setPopOverAnchor(66, 1);
                        break;
                    case 4:
                        setPopOverAnchor(17, 0);
                        setPopOverAnchor(17, 1);
                        break;
                    case 5:
                        setPopOverAnchor(66, 0);
                        setPopOverAnchor(66, 1);
                        break;
                    case 6:
                        setPopOverAnchor(20, 0);
                        setPopOverAnchor(20, 1);
                        break;
                    case 9:
                        setPopOverAnchor(68, 0);
                        setPopOverAnchor(68, 1);
                        break;
                    default:
                        Unit unit = Unit.INSTANCE;
                        break;
                }
                return;
            }
            setPopOverAnchor(33, 0);
            setPopOverAnchor(33, 1);
        }

        private final void initSize() {
            int i = this.anchorType;
            int dimension = PopOverActivityWrapper.DEFAULT_WIDTH;
            if (i == 100) {
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, PopOverActivityWrapper.HEIGHT_FOR_COEDIT_PICKER, 0);
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, PopOverActivityWrapper.HEIGHT_FOR_COEDIT_PICKER, 1);
                return;
            }
            if (i == 7) {
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 731, 0);
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 731, 1);
                return;
            }
            if (i == 8) {
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, PopOverActivityWrapper.HEIGHT_FOR_NEW_COVER, 0);
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, PopOverActivityWrapper.HEIGHT_FOR_NEW_COVER, 1);
                return;
            }
            if (i == 4) {
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 731, 0);
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 731, 1);
                return;
            }
            if (i == 5) {
                setPopOverSize(400, 731, 0);
                setPopOverSize(400, 731, 1);
                return;
            }
            int dimension2 = 603;
            if (i != 9) {
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 603, 0);
                setPopOverSize(PopOverActivityWrapper.DEFAULT_WIDTH, 603, 1);
                return;
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                dimension = (int) applicationContext.getResources().getDimension(C8875R.dimen.vst_onboarding_popover_default_width);
                dimension2 = (int) applicationContext.getResources().getDimension(C8875R.dimen.vst_onboarding_popover_default_height);
            }
            setPopOverSize(dimension, dimension2, 0);
            setPopOverSize(dimension, dimension2, 1);
        }

        private final void initialize(Context context) {
            if (this.anchorType == -1) {
                return;
            }
            initSize();
            initMargin(context);
            initPosition();
        }

        @Nullable
        public final Bundle build() {
            if (this.opts == null) {
                return null;
            }
            if (PopOverUtils.canSupportSemSetAnchor()) {
                if (this.anchorType == -1) {
                    this.opts.semSetPopOverOptions(null, null, null, null);
                } else {
                    this.opts.semSetPopOverOptions(this.width, this.height, this.margin, this.anchorPosition);
                }
            }
            return this.opts.toBundle();
        }

        public final int getAnchorType() {
            return this.anchorType;
        }

        @Nullable
        public final ActivityOptions getOpts() {
            return this.opts;
        }

        @NotNull
        public final Builder setPopOverAnchor(int anchor, @Orientation int orientation) {
            if (LocaleUtils.isRTLMode()) {
                anchor = flipLeftRight(anchor);
            }
            this.anchorPosition[orientation] = anchor;
            return this;
        }

        @NotNull
        public final Builder setPopOverMargin(@Nullable Point margin, @Orientation int orientation) {
            this.margin[orientation] = margin;
            return this;
        }

        @NotNull
        public final Builder setPopOverSize(int width, int height, @Orientation int orientation) {
            this.width[orientation] = width;
            this.height[orientation] = height;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$ChooserBuilder;", "", "context", "Landroid/content/Context;", "opts", "Landroid/app/ActivityOptions;", "anchorType", "", "<init>", "(Landroid/content/Context;Landroid/app/ActivityOptions;I)V", "getOpts", "()Landroid/app/ActivityOptions;", "getAnchorType", "()I", "anchorPosition", "getAnchorPosition", "setAnchorPosition", "(I)V", "initPosition", "", "setPopOverAnchor", "anchor", "flipLeftRight", "targetAnchor", "build", "Landroid/os/Bundle;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ChooserBuilder {
        private int anchorPosition;
        private final int anchorType;

        @Nullable
        private final ActivityOptions opts;

        public ChooserBuilder(@Nullable Context context, @Nullable ActivityOptions activityOptions, int i) {
            i = DesktopModeCompat.INSTANCE.getInstance().isDexNewDexMode(context) ? 3 : i;
            this.opts = activityOptions;
            this.anchorType = i;
            initPosition();
        }

        private final int flipLeftRight(int targetAnchor) {
            return (targetAnchor & 32) > 1 ? (targetAnchor & (-33)) | 16 : (targetAnchor & 16) > 1 ? (targetAnchor & (-17)) | 32 : targetAnchor;
        }

        private final void initPosition() {
            int i = this.anchorType;
            if (i == 0) {
                setPopOverAnchor(33);
                return;
            }
            if (i == 6) {
                setPopOverAnchor(20);
                return;
            }
            if (i == 2) {
                setPopOverAnchor(68);
            } else if (i == 3) {
                setPopOverAnchor(66);
            } else {
                if (i != 4) {
                    return;
                }
                setPopOverAnchor(17);
            }
        }

        private final void setPopOverAnchor(int anchor) {
            if (LocaleUtils.isRTLMode()) {
                anchor = flipLeftRight(anchor);
            }
            this.anchorPosition = anchor;
        }

        @Nullable
        public final Bundle build() {
            if (this.opts == null) {
                return null;
            }
            if (PopOverUtils.canSupportSemSetAnchor()) {
                this.opts.semSetChooserPopOverPosition(this.anchorPosition);
            }
            return this.opts.toBundle();
        }

        public final int getAnchorPosition() {
            return this.anchorPosition;
        }

        public final int getAnchorType() {
            return this.anchorType;
        }

        @Nullable
        public final ActivityOptions getOpts() {
            return this.opts;
        }

        public final void setAnchorPosition(int i) {
            this.anchorPosition = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0080\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$Orientation;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Orientation {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int LANDSCAPE = 1;
        public static final int PORTRAIT = 0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverActivityWrapper$Orientation$Companion;", "", "<init>", "()V", "PORTRAIT", "", "LANDSCAPE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int LANDSCAPE = 1;
            public static final int PORTRAIT = 0;

            private Companion() {
            }
        }
    }

    private PopOverActivityWrapper() {
    }

    @JvmStatic
    public static final int getCurrentLayoutAnchorType(@Nullable Activity activity) {
        Intent intent;
        if (!PopOverUtils.canSupportSemSetAnchor() || activity == null || (intent = activity.getIntent()) == null) {
            return -2;
        }
        return intent.getIntExtra(KEY_ANCHOR_TYPE, -2);
    }

    @JvmStatic
    @Nullable
    public static final Boolean isPopOverLayout(@Nullable Intent intent, @Nullable Configuration configuration) {
        if (!PopOverUtils.canSupportSemSetAnchor() || intent == null || configuration == null || intent.getIntExtra(KEY_ANCHOR_TYPE, -2) == -2) {
            return null;
        }
        return Boolean.valueOf(configuration.screenWidthDp == 360);
    }

    @JvmStatic
    public static final boolean isShownAsPopOverLayout(@Nullable Activity activity) {
        if (activity == null) {
            return false;
        }
        Boolean boolIsPopOverLayout = isPopOverLayout(activity.getIntent(), activity.getResources().getConfiguration());
        return boolIsPopOverLayout != null ? boolIsPopOverLayout.booleanValue() : ResourceUtils.isTabletLayout(activity);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startActivity(@Nullable Context context, @Nullable Intent intent) {
        startActivity$default(context, intent, 0, 4, null);
    }

    public static /* synthetic */ void startActivity$default(Context context, Intent intent, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        startActivity(context, intent, i);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startActivityForResult(@Nullable Context context, @Nullable Intent intent, int i) {
        startActivityForResult$default(context, intent, i, 0, 8, null);
    }

    public static /* synthetic */ void startActivityForResult$default(Context context, Intent intent, int i, int i2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i2 = 3;
        }
        startActivityForResult(context, intent, i, i2);
    }

    @JvmStatic
    public static final void startChooserActivity(@Nullable Context context, @Nullable Intent intent, @AnchorType int anchorType) {
        if (context == null || intent == null) {
            return;
        }
        Bundle bundleBuild = new ChooserBuilder(context, ActivityOptions.makeBasic(), anchorType).build();
        intent.putExtra(KEY_ANCHOR_TYPE, anchorType);
        context.startActivity(intent, bundleBuild);
    }

    @JvmStatic
    public static final void startChooserActivityForResult(@Nullable Context context, @Nullable Intent intent, int requestCode, @AnchorType int anchorType) {
        if (context == null || intent == null) {
            return;
        }
        Bundle bundleBuild = new ChooserBuilder(context, ActivityOptions.makeBasic(), anchorType).build();
        intent.putExtra(KEY_ANCHOR_TYPE, anchorType);
        ((Activity) context).startActivityForResult(intent, requestCode, bundleBuild);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startActivity(@Nullable Context context, @Nullable Intent intent, @AnchorType int anchorType) {
        if (context == null || intent == null) {
            return;
        }
        Bundle bundleBuild = new Builder(context, ActivityOptions.makeBasic(), anchorType).build();
        intent.putExtra(KEY_ANCHOR_TYPE, anchorType);
        context.startActivity(intent, bundleBuild);
    }

    @JvmStatic
    @JvmOverloads
    public static final void startActivityForResult(@Nullable Context context, @Nullable Intent intent, int requestCode, @AnchorType int anchorType) {
        if (context == null || intent == null) {
            return;
        }
        Bundle bundleBuild = new Builder(context, ActivityOptions.makeBasic(), anchorType).build();
        intent.putExtra(KEY_ANCHOR_TYPE, anchorType);
        ((Activity) context).startActivityForResult(intent, requestCode, bundleBuild);
    }

    @JvmStatic
    public static final void startActivityForResult(@Nullable Fragment fragment, @Nullable Intent intent, int requestCode, @AnchorType int anchorType) {
        if (fragment == null || intent == null) {
            return;
        }
        Bundle bundleBuild = new Builder(fragment.getContext(), ActivityOptions.makeBasic(), anchorType).build();
        intent.putExtra(KEY_ANCHOR_TYPE, anchorType);
        fragment.startActivityForResult(intent, requestCode, bundleBuild);
    }
}
