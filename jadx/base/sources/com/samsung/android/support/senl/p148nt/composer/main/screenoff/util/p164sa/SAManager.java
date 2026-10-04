package com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa;

import android.annotation.SuppressLint;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001a\u0018\u0000 -2\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ8\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010+\u001a\u00020\u0014J\u0006\u0010,\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/sa/SAManager;", "", "<init>", "()V", "exitReason", "", "getExitReason", "()I", "setExitReason", "(I)V", "getPenSizeLevelDetailValue", "", "penSizeLevel", "getPenColorDetailValue", "pairedPenColorCode", "penWritingColorSwitchEnabled", "", "getSettingsSavedType", "savedType", "onShow", "", "reason", "onExit", "isEmpty", "pageLength", "onExitNoStroke", "onExitStroke", "onPenClicked", "onPenColorChanged", "color", "getColorDetail", "onPenSizeChanged", "onRemoverClicked", "onRemoverOpened", "onEraseAll", "onPinClicked", "onSaveClicked", "onScrollUpClicked", "onScrollDownClicked", "onSaveNoteDialogCancel", "onSaveNoteDialogDiscard", "onSaveNoteDialogSave", "onSelectNoteDialogCancel", "onSelectNoteDialogDiscard", "onSelectNoteDialogSave", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SAManager {
    private int exitReason = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("SAManager");

    @NotNull
    private static final HashMap<Integer, String> PEN_SIZE = new HashMap<Integer, String>() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.util.sa.SAManager$Companion$PEN_SIZE$1
        {
            put(5, "a");
            put(15, "b");
            put(30, "c");
            put(45, "d");
            put(60, "e");
        }

        public /* bridge */ boolean containsKey(Integer num) {
            return super.containsKey((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return containsValue((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Integer, String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Integer, String>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Integer> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Integer) ? obj2 : getOrDefault((Integer) obj, (String) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<String> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Integer> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return getValues();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Integer) {
                return containsKey((Integer) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(String str) {
            return super.containsValue((Object) str);
        }

        public /* bridge */ String get(Integer num) {
            return (String) super.get((Object) num);
        }

        public /* bridge */ String getOrDefault(Integer num, String str) {
            return (String) super.getOrDefault((Object) num, str);
        }

        public /* bridge */ String remove(Integer num) {
            return (String) super.remove((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        public final /* bridge */ String getOrDefault(Object obj, String str) {
            return !(obj instanceof Integer) ? str : getOrDefault((Integer) obj, str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Integer num, String str) {
            return super.remove((Object) num, (Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Integer) && (obj2 instanceof String)) {
                return remove((Integer) obj, (String) obj2);
            }
            return false;
        }
    };

    @NotNull
    private static final HashMap<Integer, String> PEN_SETTINGS_SAVED_TYPE = new HashMap<Integer, String>() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.util.sa.SAManager$Companion$PEN_SETTINGS_SAVED_TYPE$1
        {
            put(0, "a");
            put(1, "b");
            put(2, "c");
        }

        public /* bridge */ boolean containsKey(Integer num) {
            return super.containsKey((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return containsValue((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Integer, String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<Integer, String>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Integer> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof Integer) ? obj2 : getOrDefault((Integer) obj, (String) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<String> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Integer> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return getValues();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof Integer) {
                return containsKey((Integer) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(String str) {
            return super.containsValue((Object) str);
        }

        public /* bridge */ String get(Integer num) {
            return (String) super.get((Object) num);
        }

        public /* bridge */ String getOrDefault(Integer num, String str) {
            return (String) super.getOrDefault((Object) num, str);
        }

        public /* bridge */ String remove(Integer num) {
            return (String) super.remove((Object) num);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String get(Object obj) {
            if (obj instanceof Integer) {
                return get((Integer) obj);
            }
            return null;
        }

        public final /* bridge */ String getOrDefault(Object obj, String str) {
            return !(obj instanceof Integer) ? str : getOrDefault((Integer) obj, str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String remove(Object obj) {
            if (obj instanceof Integer) {
                return remove((Integer) obj);
            }
            return null;
        }

        public /* bridge */ boolean remove(Integer num, String str) {
            return super.remove((Object) num, (Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof Integer) && (obj2 instanceof String)) {
                return remove((Integer) obj, (String) obj2);
            }
            return false;
        }
    };

    @SuppressLint({"StaticFieldLeak"})
    @NotNull
    private static final SAManager INSTANCE = new SAManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/sa/SAManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PEN_SIZE", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "PEN_SETTINGS_SAVED_TYPE", "INSTANCE", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/sa/SAManager;", "getINSTANCE", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/util/sa/SAManager;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SAManager getINSTANCE() {
            return SAManager.INSTANCE;
        }

        private Companion() {
        }
    }

    private SAManager() {
    }

    private final int getColorDetail(int color) {
        switch (color) {
            case -9655832:
            case -9270785:
            case -7163678:
            case -3365142:
                return 4;
            case -9642609:
                return 3;
            case -9408400:
            case -2500135:
            case -2434342:
                return 5;
            case -1070377:
            case -1027480:
            case 4030619:
                return 2;
            case -269994:
            case -8898:
                return 1;
            default:
                return 0;
        }
    }

    private final String getPenColorDetailValue(String pairedPenColorCode, boolean penWritingColorSwitchEnabled) {
        return penWritingColorSwitchEnabled ? AbstractC0541b.m756B(pairedPenColorCode, "_ON") : AbstractC0541b.m756B(pairedPenColorCode, "_OFF");
    }

    private final String getPenSizeLevelDetailValue(int penSizeLevel) {
        HashMap<Integer, String> map = PEN_SIZE;
        String str = map.get(5);
        try {
            return map.get(Integer.valueOf(penSizeLevel));
        } catch (IndexOutOfBoundsException e) {
            SOLogger.INSTANCE.SOLoggerE(TAG, "getPenSizeLevelDetailValue# ", e);
            return str;
        }
    }

    private final String getSettingsSavedType(int savedType) {
        HashMap<Integer, String> map = PEN_SETTINGS_SAVED_TYPE;
        String str = map.get(0);
        try {
            return map.get(Integer.valueOf(savedType));
        } catch (IndexOutOfBoundsException e) {
            SOLogger.INSTANCE.SOLoggerE(TAG, "getSettingsSavedType# ", e);
            return str;
        }
    }

    private final void onExitNoStroke() {
        int i = this.exitReason;
        if (i == 0) {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_NO_STROKE, "1");
            return;
        }
        if (i == 1) {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_NO_STROKE, "2");
            return;
        }
        if (i == 5) {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_NO_STROKE, "3");
        } else if (i == 6) {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_NO_STROKE, "4");
        } else {
            if (i != 7) {
                return;
            }
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_NO_STROKE, "5");
        }
    }

    private final void onExitStroke(int savedType) {
        int i = this.exitReason;
        if (i != 0) {
            switch (i) {
                case 2:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "2");
                    break;
                case 3:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "3");
                    break;
                case 4:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "4");
                    break;
                case 5:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "5");
                    break;
                case 6:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "6");
                    break;
                case 7:
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "7");
                    break;
            }
        } else {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_EXIT_WITH_STROKE, "1");
        }
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.STATUS_SETTINGS_PEN_COLOR_FOR_SAVED_NOTES, getSettingsSavedType(savedType));
    }

    public final int getExitReason() {
        return this.exitReason;
    }

    public final void onEraseAll() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_ERASE_ALL);
    }

    public final void onExit(boolean isEmpty, int pageLength, int penSizeLevel, @Nullable String pairedPenColorCode, boolean penWritingColorSwitchEnabled, int savedType) {
        if (-1 == this.exitReason) {
            return;
        }
        if (isEmpty) {
            onExitNoStroke();
        } else {
            onExitStroke(savedType);
        }
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        companion.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PAGE_LENGTH, String.valueOf(pageLength));
        String penSizeLevelDetailValue = getPenSizeLevelDetailValue(penSizeLevel);
        String penColorDetailValue = getPenColorDetailValue(pairedPenColorCode, penWritingColorSwitchEnabled);
        companion.insertLog(SAConstants.SCREEN_ID, SAConstants.STATUS_PEN_SIZE, penSizeLevelDetailValue);
        companion.insertLog(SAConstants.SCREEN_ID, SAConstants.STATUS_PEN_COLOR, penColorDetailValue);
    }

    public final void onPenClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PEN);
    }

    public final void onPenColorChanged(int color) {
        int colorDetail = getColorDetail(color);
        if (colorDetail > 0) {
            NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PEN_COLOR_CHANGED, String.valueOf(colorDetail));
        }
    }

    public final void onPenSizeChanged(int penSizeLevel) {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PEN_SIZE, getPenSizeLevelDetailValue(penSizeLevel));
    }

    public final void onPinClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PIN);
    }

    public final void onRemoverClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_ERASER, "1");
    }

    public final void onRemoverOpened() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_ERASER, "2");
    }

    public final void onSaveClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SAVE);
    }

    public final void onSaveNoteDialogCancel() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SAVE_DIALOG_CANCEL);
    }

    public final void onSaveNoteDialogDiscard() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SAVE_DIALOG_DISCARD);
    }

    public final void onSaveNoteDialogSave() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SAVE_DIALOG_SAVE);
    }

    public final void onScrollDownClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_NEXT_MEMO);
    }

    public final void onScrollUpClicked() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_PREVIOUS_MEMO);
    }

    public final void onSelectNoteDialogCancel() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SELECT_DIALOG_CANCEL);
    }

    public final void onSelectNoteDialogDiscard() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SELECT_DIALOG_DISCARD);
    }

    public final void onSelectNoteDialogSave() {
        NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_SAVE_DIALOG_SAVE);
    }

    public final void onShow(@Nullable String reason) {
        if (reason != null) {
            int iHashCode = reason.hashCode();
            if (iHashCode == -2047484436) {
                if (reason.equals(SAConstants.REASON_SHOW_PEN_DETACH)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_OPEN, "1");
                }
            } else if (iHashCode == -2042708204) {
                if (reason.equals(SAConstants.REASON_SHOW_LOAD_SPD_BY_DOUBLE_TAP_ON_AOD)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_OPEN, "3");
                }
            } else if (iHashCode == -1734231182 && reason.equals(SAConstants.REASON_SHOW_PEN_BUTTON_HOVER_TAP)) {
                NotesSamsungAnalytics.INSTANCE.insertLog(SAConstants.SCREEN_ID, SAConstants.EVENT_OPEN, "2");
            }
        }
    }

    public final void setExitReason(int i) {
        this.exitReason = i;
    }
}
