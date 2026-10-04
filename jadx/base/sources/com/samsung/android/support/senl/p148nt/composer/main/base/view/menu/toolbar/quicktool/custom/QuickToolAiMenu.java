package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.util.SeslShapeDrawable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.ViewOnHoverListenerC8950a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001:B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001eH\u0003J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0002J\u001a\u0010&\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010*\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010+\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010,\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010-\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010.\u001a\u00020\u000f2\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\"\u0010/\u001a\u0002002\b\b\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002J\u0018\u00107\u001a\u00020\u001a2\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u000209H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolAiMenu;", "", "context", "Landroid/content/Context;", "tool", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/quicktool/QuickToolPresenter;)V", SmpConstants.MARKETING_TYPE_POPUP, "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/view/AiMenuPopup;", "centerSize", "", "centerView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "centerText", "Landroid/widget/TextView;", "translateYAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "translateYRunnable", "Ljava/lang/Runnable;", "makeAiMenuForDocking", "makeAiMenuForFloating", "setupCenterViewAnimations", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout;", "animateCenterTextWhenSwitchingMode", Constants.IntentExtraValue.SHOW, "", "animateCenterTextInDockingZone", "inDockingZone", "makeBackground", "size", "hasCenter", "makeItems", "", "setupAutoFormat", "tint", "", "padding", "setupSummarize", "setupSpellingCorrection", "setupTranslate", "setupCreateImage", "setupTranscribe", "makeImageBtn", "Landroid/widget/ImageButton;", "description", "", "onNoteAssistClick", "view", "action", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolAiMenu$NoteAssistAction;", "log", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "NoteAssistAction", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQuickToolAiMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickToolAiMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolAiMenu\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,330:1\n1878#2,3:331\n1878#2,3:334\n1#3:337\n*S KotlinDebug\n*F\n+ 1 QuickToolAiMenu.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolAiMenu\n*L\n53#1:331,3\n76#1:334,3\n*E\n"})
public final class QuickToolAiMenu {
    private final float centerSize;
    private final TextView centerText;
    private final View centerView;

    @NotNull
    private final Context context;

    @NotNull
    private final AiMenuPopup popup;

    @NotNull
    private final QuickToolPresenter presenter;

    @NotNull
    private final QuickTool tool;

    @Nullable
    private SpringAnimation translateYAnimator;

    @NotNull
    private final Runnable translateYRunnable;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolAiMenu$NoteAssistAction;", "", "<init>", "(Ljava/lang/String;I)V", "AutoFormat", "Summarize", "SpellingCorrection", "Translate", "CreateImage", "Transcribe", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class NoteAssistAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NoteAssistAction[] $VALUES;
        public static final NoteAssistAction AutoFormat = new NoteAssistAction("AutoFormat", 0);
        public static final NoteAssistAction Summarize = new NoteAssistAction("Summarize", 1);
        public static final NoteAssistAction SpellingCorrection = new NoteAssistAction("SpellingCorrection", 2);
        public static final NoteAssistAction Translate = new NoteAssistAction("Translate", 3);
        public static final NoteAssistAction CreateImage = new NoteAssistAction("CreateImage", 4);
        public static final NoteAssistAction Transcribe = new NoteAssistAction("Transcribe", 5);

        private static final /* synthetic */ NoteAssistAction[] $values() {
            return new NoteAssistAction[]{AutoFormat, Summarize, SpellingCorrection, Translate, CreateImage, Transcribe};
        }

        static {
            NoteAssistAction[] noteAssistActionArr$values = $values();
            $VALUES = noteAssistActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(noteAssistActionArr$values);
        }

        private NoteAssistAction(String str, int i) {
        }

        @NotNull
        public static EnumEntries<NoteAssistAction> getEntries() {
            return $ENTRIES;
        }

        public static NoteAssistAction valueOf(String str) {
            return (NoteAssistAction) Enum.valueOf(NoteAssistAction.class, str);
        }

        public static NoteAssistAction[] values() {
            return (NoteAssistAction[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NoteAssistAction.values().length];
            try {
                iArr[NoteAssistAction.AutoFormat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoteAssistAction.Summarize.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoteAssistAction.SpellingCorrection.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NoteAssistAction.Translate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NoteAssistAction.CreateImage.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NoteAssistAction.Transcribe.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public QuickToolAiMenu(@NotNull Context context, @NotNull QuickTool tool, @NotNull QuickToolPresenter presenter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tool, "tool");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.context = context;
        this.tool = tool;
        this.presenter = presenter;
        this.popup = presenter.getAiContextMenuPopup();
        this.centerSize = context.getResources().getDimension(C9086R.dimen.composer_qt_circle_center_background_size);
        View viewInflate = LayoutInflater.from(context).inflate(C9086R.layout.qt_ai_menu_center_item, (ViewGroup) null, false);
        this.centerView = viewInflate;
        this.centerText = (TextView) viewInflate.findViewById(C9086R.id.qt_ai_menu_center_text);
        this.translateYRunnable = new RunnableC9767a(this, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateCenterTextInDockingZone(boolean inDockingZone) {
        this.centerText.setTranslationY(0.0f);
        if (inDockingZone) {
            this.centerText.setScaleX(1.0f);
            this.centerText.setScaleY(1.0f);
            this.centerText.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(QTAnimationKt.getOneEasing()).start();
        } else {
            this.centerText.setScaleX(0.0f);
            this.centerText.setScaleY(0.0f);
            this.centerText.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(QTAnimationKt.getOneEasing()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateCenterTextWhenSwitchingMode(boolean show) {
        this.centerText.removeCallbacks(this.translateYRunnable);
        SpringAnimation springAnimation = this.translateYAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.centerText.setScaleX(1.0f);
        this.centerText.setScaleY(1.0f);
        SpringAnimation spring = new SpringAnimation(this.centerText, DynamicAnimation.TRANSLATION_Y).setSpring(new SpringForce().setDampingRatio(0.75f).setStiffness(300.0f));
        this.translateYAnimator = spring;
        if (show) {
            this.centerText.setTranslationY(this.centerSize);
            this.centerText.postDelayed(this.translateYRunnable, 100L);
        } else {
            this.centerText.setTranslationY(0.0f);
            spring.animateToFinalPosition(this.centerSize);
        }
    }

    private final void log(NoteAssistAction action, SpenSettingQTPenContainer.RotationType type) {
        QuickToolSA quickToolSA = QuickToolSA.INSTANCE;
        quickToolSA.logFirstBehavior("7");
        switch (WhenMappings.$EnumSwitchMapping$0[action.ordinal()]) {
            case 1:
                quickToolSA.log(QuickToolSA.EVENT_QT_NOTE_ASSIST_AUTO_FORMAT, type);
                return;
            case 2:
                quickToolSA.log(QuickToolSA.EVENT_QT_NOTE_ASSIST_SUMMARIZE, type);
                return;
            case 3:
                return;
            case 4:
                quickToolSA.log(QuickToolSA.EVENT_QT_NOTE_ASSIST_TRANSLATE, type);
                return;
            case 5:
                quickToolSA.log(QuickToolSA.EVENT_QT_NOTE_ASSIST_DRAWING_ASSIST, type);
                return;
            case 6:
                quickToolSA.log(QuickToolSA.EVENT_QT_NOTE_ASSIST_TRANSCRIBE, type);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @RequiresApi(33)
    private final View makeBackground(float size, boolean hasCenter) {
        float f = size * 0.5f;
        FrameLayout frameLayout = new FrameLayout(this.context);
        View quickToolCustomBackground = new QuickToolCustomBackground(this.context, size, hasCenter);
        int i = (int) size;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        quickToolCustomBackground.setLayoutParams(layoutParams);
        SeslShapeDrawable seslShapeDrawable = new SeslShapeDrawable();
        seslShapeDrawable.setShape(1);
        quickToolCustomBackground.setBackground(seslShapeDrawable);
        frameLayout.addView(quickToolCustomBackground);
        List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(this.context.getColor(C9086R.color.qt_intelligence_sky_blue)), Integer.valueOf(this.context.getColor(C9086R.color.qt_intelligence_blue)), Integer.valueOf(this.context.getColor(C9086R.color.qt_Intelligence_green))});
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(this.context, quickToolCustomBackground, GuidingLightConfig.copy$default(GuidingLightConfig.DEFAULT_LIGHT, GuidingLightConfig.Shape.Circle, null, null, null, null, f, 0.47f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 60.0f, 0.0f, 0.0f, null, 0.0f, 0L, 132119454, null));
        guidingLightEffect.setLightColors(listListOf);
        guidingLightEffect.setCircleRadius(f);
        GuidingLightEffect.show$default(guidingLightEffect, null, 1, null);
        return frameLayout;
    }

    private final ImageButton makeImageBtn(@ColorInt int tint, int padding, String description) {
        ImageButton imageButton = new ImageButton(this.context);
        imageButton.setColorFilter(tint);
        imageButton.setBackgroundResource(C9086R.drawable.spen_round_ripple);
        imageButton.setPadding(padding, padding, padding, padding);
        imageButton.setContentDescription(description);
        imageButton.setOnHoverListener(new ViewOnHoverListenerC8950a(this, 1, description, imageButton));
        return imageButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean makeImageBtn$lambda$10(QuickToolAiMenu quickToolAiMenu, String str, ImageButton imageButton, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 9) {
            quickToolAiMenu.centerText.setText(str);
        } else if (action == 10) {
            quickToolAiMenu.centerText.setText(quickToolAiMenu.context.getString(C9086R.string.ai_notes_assist));
        }
        return imageButton.onHoverEvent(motionEvent);
    }

    private final List<View> makeItems() {
        Resources resources = this.context.getResources();
        int color = this.context.getColor(C9086R.color.ai_menu_top_icon_color);
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.qt_ai_menu_item_padding);
        LinkedList linkedList = new LinkedList();
        linkedList.add(setupAutoFormat(color, dimensionPixelSize));
        linkedList.add(setupSummarize(color, dimensionPixelSize));
        if (this.popup.canShowSpellingCorrection(true)) {
            linkedList.add(setupSpellingCorrection(color, dimensionPixelSize));
        }
        linkedList.add(setupTranslate(color, dimensionPixelSize));
        linkedList.add(setupCreateImage(color, dimensionPixelSize));
        linkedList.add(setupTranscribe(color, dimensionPixelSize));
        return linkedList;
    }

    private final void onNoteAssistClick(View view, NoteAssistAction action) {
        this.presenter.onNoteAssistClick(new RunnableC8928b(this, 19, action, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNoteAssistClick$lambda$11(QuickToolAiMenu quickToolAiMenu, NoteAssistAction noteAssistAction, View view) {
        SpenSettingQTPenContainer.RotationType rotationType = quickToolAiMenu.tool.getRotationType();
        Intrinsics.checkNotNull(rotationType);
        quickToolAiMenu.log(noteAssistAction, rotationType);
        quickToolAiMenu.presenter.clearSelectionNoteAssist();
        switch (WhenMappings.$EnumSwitchMapping$0[noteAssistAction.ordinal()]) {
            case 1:
                if (!quickToolAiMenu.popup.canShowAutoFormat(true)) {
                    quickToolAiMenu.popup.showFailToast(quickToolAiMenu.context);
                } else {
                    quickToolAiMenu.popup.showAutoFormatTypeListWindow(view);
                }
                break;
            case 2:
                quickToolAiMenu.popup.onSummarizeClick(view);
                break;
            case 3:
                quickToolAiMenu.popup.onSpellingCorrectionClick(view);
                break;
            case 4:
                quickToolAiMenu.popup.onTranslateClick(view);
                break;
            case 5:
                quickToolAiMenu.popup.onCreateImageClick(view);
                break;
            case 6:
                quickToolAiMenu.popup.onTranscribeClick(view);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        quickToolAiMenu.presenter.setRequestShowNoteAssist(false);
        quickToolAiMenu.tool.hide();
    }

    private final View setupAutoFormat(@ColorInt int tint, int padding) {
        String string = this.context.getString(C9086R.string.ai_auto_format_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_autoformat);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 0));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAutoFormat$lambda$4(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.AutoFormat);
    }

    private final void setupCenterViewAnimations(SpenSettingQTLayout spenSettingQTLayout) {
        spenSettingQTLayout.setDockingAnimationListener(new SpenSettingQTLayout.DockingAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu.setupCenterViewAnimations.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.DockingAnimationListener
            public void onAnimationEnd(boolean isDockingMode, boolean canceled) {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.DockingAnimationListener
            public void onAnimationStart(boolean isDockingMode) {
                QuickToolAiMenu.this.animateCenterTextInDockingZone(isDockingMode);
            }
        });
        spenSettingQTLayout.setToggleAnimationListener(new SpenSettingQTLayout.ToggleAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu.setupCenterViewAnimations.2
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.ToggleAnimationListener
            public void onAnimationEnd(boolean show, boolean canceled) {
            }

            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.ToggleAnimationListener
            public void onAnimationStart(boolean show) {
                QuickToolAiMenu.this.animateCenterTextWhenSwitchingMode(show);
            }
        });
    }

    private final View setupCreateImage(@ColorInt int tint, int padding) {
        String string = this.context.getString(this.popup.getCreateImageStringRes());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_sketch_to_image);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 5));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCreateImage$lambda$8(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.CreateImage);
    }

    private final View setupSpellingCorrection(@ColorInt int tint, int padding) {
        String string = this.context.getString(C9086R.string.ai_spelling_correction);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_spelling_correction);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 4));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSpellingCorrection$lambda$6(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.SpellingCorrection);
    }

    private final View setupSummarize(@ColorInt int tint, int padding) {
        String string = this.context.getString(C9086R.string.ai_summarize_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_summarize);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 2));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSummarize$lambda$5(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.Summarize);
    }

    private final View setupTranscribe(@ColorInt int tint, int padding) {
        String string = this.context.getString(C9086R.string.ai_result_transcribe_btn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_result_stt_title);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 1));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTranscribe$lambda$9(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.Transcribe);
    }

    private final View setupTranslate(@ColorInt int tint, int padding) {
        String string = this.context.getString(C9086R.string.ai_translate_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageButton imageButtonMakeImageBtn = makeImageBtn(tint, padding, string);
        imageButtonMakeImageBtn.setImageResource(C9086R.drawable.ic_ai_menu_translate);
        imageButtonMakeImageBtn.setOnClickListener(new ViewOnClickListenerC10743a(this, 3));
        return imageButtonMakeImageBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTranslate$lambda$7(QuickToolAiMenu quickToolAiMenu, View view) {
        Intrinsics.checkNotNull(view);
        quickToolAiMenu.onNoteAssistClick(view, NoteAssistAction.Translate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void translateYRunnable$lambda$0(QuickToolAiMenu quickToolAiMenu) {
        SpringAnimation springAnimation = quickToolAiMenu.translateYAnimator;
        if (springAnimation != null) {
            springAnimation.animateToFinalPosition(0.0f);
        }
    }

    @NotNull
    public final View makeAiMenuForDocking() {
        SettingQTLayout settingQTLayout = new SettingQTLayout(this.context);
        List<View> listMakeItems = makeItems();
        int size = 180 / (listMakeItems.size() + 1);
        int i = size - 90;
        int i2 = 0;
        for (Object obj : listMakeItems) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            settingQTLayout.addEdgeView(view, i, 1);
            settingQTLayout.setEdgeViewContainerAnimation(view, i2);
            i += size;
            i2 = i4;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            settingQTLayout.setBackgroundView(makeBackground(this.context.getResources().getDimension(C9086R.dimen.composer_qt_circle_layout_height), false));
        }
        return settingQTLayout;
    }

    @NotNull
    public final View makeAiMenuForFloating() {
        SpenSettingQTLayout spenSettingQTLayout = new SpenSettingQTLayout(this.context);
        View centerView = this.centerView;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        spenSettingQTLayout.addCenterView(centerView, -1, -1);
        setupCenterViewAnimations(spenSettingQTLayout);
        List<View> listMakeItems = makeItems();
        int i = 0;
        int size = listMakeItems.size() > 1 ? 180 / (listMakeItems.size() - 1) : 0;
        int i2 = listMakeItems.size() > 1 ? -180 : -90;
        for (Object obj : listMakeItems) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            spenSettingQTLayout.addEdgeView(view, i2, 1);
            i2 += size;
            spenSettingQTLayout.setEdgeViewContainerAnimation(view, i);
            i = i4;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            spenSettingQTLayout.setBackgroundView(makeBackground(this.context.getResources().getDimension(C9086R.dimen.qt_circle_layout_height), true));
        }
        return spenSettingQTLayout;
    }
}
