package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.quicknote;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.AbstractC7894a;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FrontTaskChecker {
    private static final int MAX_CELL_COUNT = 2;
    public static final String PKG_SEC_DESKTOP_LAUNCHER = "com.sec.android.app.desktoplauncher";
    public static final String PKG_SEC_LAUNCHER = "com.sec.android.app.launcher";
    private static final int SPLIT_WINDOW_COUNT = 2;
    private static final String TAG = Logger.createTag("FrontTaskChecker");
    public static final int WINDOWING_MODE_FREE_FORM = 5;
    public static final int WINDOWING_MODE_FULLSCREEN = 1;
    public static final int WINDOWING_MODE_MULTI_WINDOW = 6;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_CELL = 12;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_PRIMARY = 3;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_SECONDARY = 4;
    private final ForegroundWindowChecker mForegroundWindowChecker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ForegroundWindowChecker {
        public /* synthetic */ ForegroundWindowChecker(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkForegroundWindows(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground) {
            if (list.size() <= i) {
                return;
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = list.get(i);
            int windowMode = FrontTaskChecker.getWindowMode(runningTaskInfo);
            Logger.m10999d(FrontTaskChecker.TAG, "checkForegroundWindows# pkg: " + runningTaskInfo.topActivity.getPackageName() + " windowMode: " + windowMode);
            travelTask(list, i, windowsOnForeground, runningTaskInfo, windowMode);
        }

        public void checkFreeForm(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo) {
            windowsOnForeground.getFreeFormWindows().add(runningTaskInfo);
            checkForegroundWindows(list, i + 1, windowsOnForeground);
        }

        public void checkFullScreen(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo) {
            windowsOnForeground.getFrontWindows().add(runningTaskInfo);
            while (true) {
                i++;
                if (i >= list.size()) {
                    return;
                }
                ActivityManager.RunningTaskInfo runningTaskInfo2 = list.get(i);
                if (FrontTaskChecker.getWindowMode(runningTaskInfo2) == 5) {
                    windowsOnForeground.mFreeFormWindows.add(runningTaskInfo2);
                }
            }
        }

        public void checkNextSplitScreen(List<ActivityManager.RunningTaskInfo> list, int i, ActivityManager.RunningTaskInfo[] runningTaskInfoArr, WindowsOnForeground windowsOnForeground) {
            while (i < list.size()) {
                ActivityManager.RunningTaskInfo runningTaskInfo = list.get(i);
                int windowMode = FrontTaskChecker.getWindowMode(runningTaskInfo);
                if (windowMode == 3 || windowMode == 4) {
                    int frontTaskInfoArrayIndex = getFrontTaskInfoArrayIndex(windowMode);
                    if (runningTaskInfoArr[frontTaskInfoArrayIndex] == null) {
                        runningTaskInfoArr[frontTaskInfoArrayIndex] = runningTaskInfo;
                    }
                } else if (windowMode == 12) {
                    int frontTaskInfoArrayIndex2 = getFrontTaskInfoArrayIndex(4);
                    while (true) {
                        frontTaskInfoArrayIndex2++;
                        if (frontTaskInfoArrayIndex2 < runningTaskInfoArr.length) {
                            if (runningTaskInfoArr[frontTaskInfoArrayIndex2] == null) {
                                runningTaskInfoArr[frontTaskInfoArrayIndex2] = runningTaskInfo;
                            }
                        }
                    }
                } else if (windowMode == 5) {
                    windowsOnForeground.mFreeFormWindows.add(runningTaskInfo);
                }
                i++;
            }
        }

        public void checkSplitScreen(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo, int i2) {
            windowsOnForeground.getFrontWindows().add(runningTaskInfo);
            ActivityManager.RunningTaskInfo[] runningTaskInfoArr = new ActivityManager.RunningTaskInfo[4];
            if (i2 == 12) {
                runningTaskInfoArr[getFrontTaskInfoArrayIndex(4) + 1] = runningTaskInfo;
            } else {
                runningTaskInfoArr[getFrontTaskInfoArrayIndex(i2)] = runningTaskInfo;
            }
            checkNextSplitScreen(list, i + 1, runningTaskInfoArr, windowsOnForeground);
            for (int i4 = 0; i4 < 4; i4++) {
                ActivityManager.RunningTaskInfo runningTaskInfo2 = runningTaskInfoArr[i4];
                if (runningTaskInfo2 != null && !runningTaskInfo.equals(runningTaskInfo2)) {
                    windowsOnForeground.getFrontWindows().add(runningTaskInfo2);
                }
            }
        }

        public int getFrontTaskInfoArrayIndex(int i) {
            return i - 3;
        }

        public void travelTask(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo, int i2) {
            if (i2 == 1) {
                checkFullScreen(list, i, windowsOnForeground, runningTaskInfo);
                return;
            }
            if (i2 == 12 || i2 == 3 || i2 == 4) {
                checkSplitScreen(list, i, windowsOnForeground, runningTaskInfo, i2);
                return;
            }
            if (i2 == 5) {
                checkFreeForm(list, i, windowsOnForeground, runningTaskInfo);
                return;
            }
            Logger.m11000e(FrontTaskChecker.TAG, "isFrontTask# unexpected windowMode: " + i2 + " index: " + i);
        }

        private ForegroundWindowChecker() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ForegroundWindowCheckerTos extends ForegroundWindowChecker {
        private static final int SPLIT_BASE = 3;

        public /* synthetic */ ForegroundWindowCheckerTos(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.FrontTaskChecker.ForegroundWindowChecker
        @RequiresApi(api = 29)
        public void checkSplitScreen(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo, int i2) {
            int stagePosition = getStagePosition(runningTaskInfo);
            String str = FrontTaskChecker.TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "checkSplitScreen# i: ", " ");
            sbM778t.append(runningTaskInfo.topActivity.getPackageName());
            sbM778t.append(" pos: ");
            sbM778t.append(stagePosition);
            Logger.m11003i(str, sbM778t.toString());
            ActivityManager.RunningTaskInfo[] runningTaskInfoArr = new ActivityManager.RunningTaskInfo[4];
            if (stagePosition >= 0) {
                runningTaskInfoArr[stagePosition] = runningTaskInfo;
            }
            while (true) {
                i++;
                if (i >= list.size()) {
                    break;
                }
                ActivityManager.RunningTaskInfo runningTaskInfo2 = list.get(i);
                int windowMode = FrontTaskChecker.getWindowMode(runningTaskInfo2);
                if (windowMode == 6 && !isAlwaysOnTop(runningTaskInfo2)) {
                    int stagePosition2 = getStagePosition(runningTaskInfo2);
                    String str2 = FrontTaskChecker.TAG;
                    StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "checkSplitScreen# i: ", " ");
                    sbM778t2.append(runningTaskInfo2.topActivity.getPackageName());
                    sbM778t2.append(" pos: ");
                    sbM778t2.append(stagePosition2);
                    Logger.m11003i(str2, sbM778t2.toString());
                    if (stagePosition2 >= 0 && runningTaskInfoArr[stagePosition2] == null) {
                        runningTaskInfoArr[stagePosition2] = runningTaskInfo2;
                    }
                } else if (windowMode == 5) {
                    windowsOnForeground.mFreeFormWindows.add(runningTaskInfo2);
                }
            }
            for (int i4 = 0; i4 < 4; i4++) {
                ActivityManager.RunningTaskInfo runningTaskInfo3 = runningTaskInfoArr[i4];
                if (runningTaskInfo3 != null) {
                    windowsOnForeground.getFrontWindows().add(runningTaskInfo3);
                }
            }
        }

        @RequiresApi(api = 29)
        public int getStagePosition(ActivityManager.RunningTaskInfo runningTaskInfo) {
            try {
                Object windowConfiguration = getWindowConfiguration(runningTaskInfo);
                if (windowConfiguration == null) {
                    Logger.m11000e(FrontTaskChecker.TAG, "getStagePosition# windowConfiguration is null");
                    return -1;
                }
                Method declaredMethod = windowConfiguration.getClass().getDeclaredMethod("getStagePosition", null);
                declaredMethod.setAccessible(true);
                int iIntValue = ((Integer) declaredMethod.invoke(windowConfiguration, null)).intValue();
                int i = 0;
                while (iIntValue > 1) {
                    iIntValue >>= 1;
                    i++;
                }
                return i - 3;
            } catch (IllegalAccessException e) {
                e = e;
                Logger.m11000e(FrontTaskChecker.TAG, "getStagePosition# " + e.getMessage());
                return -1;
            } catch (NoSuchMethodException e2) {
                e = e2;
                Logger.m11000e(FrontTaskChecker.TAG, "getStagePosition# " + e.getMessage());
                return -1;
            } catch (InvocationTargetException e3) {
                e = e3;
                Logger.m11000e(FrontTaskChecker.TAG, "getStagePosition# " + e.getMessage());
                return -1;
            }
        }

        @RequiresApi(api = 29)
        public Object getWindowConfiguration(ActivityManager.RunningTaskInfo runningTaskInfo) {
            try {
                Method declaredMethod = AbstractC7894a.m6811l().getDeclaredMethod("getConfiguration", null);
                declaredMethod.setAccessible(true);
                Configuration configuration = (Configuration) declaredMethod.invoke(runningTaskInfo, null);
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                return declaredField.get(configuration);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                Logger.m11000e(FrontTaskChecker.TAG, "getWindowConfiguration# " + e.getMessage());
                return null;
            }
        }

        @RequiresApi(api = 29)
        public boolean isAlwaysOnTop(ActivityManager.RunningTaskInfo runningTaskInfo) {
            try {
                Object windowConfiguration = getWindowConfiguration(runningTaskInfo);
                if (windowConfiguration == null) {
                    Logger.m11000e(FrontTaskChecker.TAG, "isAlwaysOnTop# windowConfiguration is null");
                    return true;
                }
                Method declaredMethod = windowConfiguration.getClass().getDeclaredMethod("isAlwaysOnTop", null);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(windowConfiguration, null)).booleanValue();
            } catch (IllegalAccessException e) {
                e = e;
                Logger.m11000e(FrontTaskChecker.TAG, "isAlwaysOnTop# " + e.getMessage());
                return true;
            } catch (NoSuchMethodException e2) {
                e = e2;
                Logger.m11000e(FrontTaskChecker.TAG, "isAlwaysOnTop# " + e.getMessage());
                return true;
            } catch (InvocationTargetException e3) {
                e = e3;
                Logger.m11000e(FrontTaskChecker.TAG, "isAlwaysOnTop# " + e.getMessage());
                return true;
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.quicknote.FrontTaskChecker.ForegroundWindowChecker
        @RequiresApi(api = 29)
        public void travelTask(List<ActivityManager.RunningTaskInfo> list, int i, WindowsOnForeground windowsOnForeground, ActivityManager.RunningTaskInfo runningTaskInfo, int i2) {
            if (i2 == 1) {
                checkFullScreen(list, i, windowsOnForeground, runningTaskInfo);
                return;
            }
            if (i2 == 5) {
                checkFreeForm(list, i, windowsOnForeground, runningTaskInfo);
                return;
            }
            if (i2 == 6) {
                if (isAlwaysOnTop(runningTaskInfo)) {
                    checkFreeForm(list, i, windowsOnForeground, runningTaskInfo);
                    return;
                } else {
                    checkSplitScreen(list, i, windowsOnForeground, runningTaskInfo, i2);
                    return;
                }
            }
            Logger.m11000e(FrontTaskChecker.TAG, "isFrontTask# unexpected windowMode: " + i2 + " index: " + i);
        }

        private ForegroundWindowCheckerTos() {
            super(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WindowsOnForeground {
        private final List<ActivityManager.RunningTaskInfo> mFrontWindows = new ArrayList(5);
        private final List<ActivityManager.RunningTaskInfo> mFreeFormWindows = new ArrayList();

        public List<ActivityManager.RunningTaskInfo> getFreeFormWindows() {
            return this.mFreeFormWindows;
        }

        public List<ActivityManager.RunningTaskInfo> getFrontWindows() {
            return this.mFrontWindows;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("WindowsOnForeground{mFrontWindows=(");
            Iterator<ActivityManager.RunningTaskInfo> it = this.mFrontWindows.iterator();
            while (it.hasNext()) {
                sb.append(it.next().topActivity.getPackageName());
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(")mFreeFormWindows=(");
            Iterator<ActivityManager.RunningTaskInfo> it2 = this.mFreeFormWindows.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().topActivity.getPackageName());
                sb.append(SQLKeyword.COMMA);
            }
            sb.append(")}");
            return sb.toString();
        }
    }

    public FrontTaskChecker() {
        int i = 0;
        if (Build.VERSION.SDK_INT > 32) {
            this.mForegroundWindowChecker = new ForegroundWindowCheckerTos(i);
        } else {
            this.mForegroundWindowChecker = new ForegroundWindowChecker(i);
        }
    }

    private void checkFront(List<ActivityManager.RunningTaskInfo> list, int i, Map<String, Boolean> map) {
        WindowsOnForeground windowsOnForeground = new WindowsOnForeground();
        this.mForegroundWindowChecker.checkForegroundWindows(list, i, windowsOnForeground);
        Logger.m10999d(TAG, "checkFront# " + windowsOnForeground);
        Set<String> setKeySet = map.keySet();
        Iterator<ActivityManager.RunningTaskInfo> it = windowsOnForeground.getFrontWindows().iterator();
        while (it.hasNext()) {
            updateSamePackage(it.next(), setKeySet, map);
        }
        Iterator<ActivityManager.RunningTaskInfo> it2 = windowsOnForeground.getFreeFormWindows().iterator();
        while (it2.hasNext()) {
            updateSamePackage(it2.next(), setKeySet, map);
        }
    }

    public static int getWindowMode(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        try {
            Method declaredMethod = AbstractC7894a.m6811l().getDeclaredMethod("getWindowingMode", null);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(runningTaskInfo, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Logger.m11000e(TAG, "getWindowMode# " + e.getMessage());
            return -1;
        }
    }

    private boolean isChangedFromSplitToFreeForm(Activity activity, List<ActivityManager.RunningTaskInfo> list, int i, Map<String, Boolean> map) {
        if (i != 1 || list.size() <= 2 || !isLauncher(list.get(i))) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = list.get(i + 1);
        if (getWindowMode(runningTaskInfo) == 1) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (isSamePackage(runningTaskInfo, it.next())) {
                    Logger.m10999d(TAG, "isChangedFromSplitToFreeForm# ");
                    DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
                    if (!companion.getInstance().isDexMode(activity)) {
                        return true;
                    }
                    if (companion.getInstance().isDexDualModeConnected(activity)) {
                        return !companion.getInstance().isDexDualModeOnScreen(activity);
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private boolean isLauncher(ActivityManager.RunningTaskInfo runningTaskInfo) {
        return isSamePackage(runningTaskInfo, PKG_SEC_LAUNCHER) || isSamePackage(runningTaskInfo, PKG_SEC_DESKTOP_LAUNCHER);
    }

    private boolean isSamePackage(ActivityManager.RunningTaskInfo runningTaskInfo, String str) {
        return runningTaskInfo.topActivity.getPackageName().equals(str);
    }

    private void updateSamePackage(ActivityManager.RunningTaskInfo runningTaskInfo, Set<String> set, Map<String, Boolean> map) {
        for (String str : set) {
            if (isSamePackage(runningTaskInfo, str)) {
                map.put(str, Boolean.TRUE);
                return;
            }
        }
    }

    public void checkFrontTask(@NonNull Activity activity, @NonNull Map<String, Boolean> map) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY)).getRunningTasks(10);
        int i = 0;
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (isSamePackage(runningTaskInfo, activity.getPackageName())) {
            if (getWindowMode(runningTaskInfo) == 1) {
                Logger.m11000e(TAG, "checkFrontTask# notes is full screen");
                return;
            }
            String str = TAG;
            Logger.m11003i(str, "checkFrontTask# " + runningTaskInfo.topActivity.getPackageName());
            if (isChangedFromSplitToFreeForm(activity, runningTasks, 1, map)) {
                Logger.m11003i(str, "checkFrontTask# " + runningTaskInfo.topActivity.getPackageName());
                i = 2;
            }
        }
        checkFront(runningTasks, i, map);
    }

    public boolean isFrontTask(@NonNull Activity activity, @NonNull String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        return isFrontTask(activity, arrayList);
    }

    public List<String> removeNoFrontTask(@NonNull Activity activity, @NonNull List<SuggestionInfo> list) {
        HashMap map = new HashMap();
        Iterator<SuggestionInfo> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next().getPackageName(), Boolean.FALSE);
        }
        checkFrontTask(activity, map);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (!((Boolean) entry.getValue()).booleanValue()) {
                Iterator<SuggestionInfo> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        SuggestionInfo next = it2.next();
                        if (next.getPackageName().equals(entry.getKey())) {
                            it2.remove();
                            arrayList.add(next.getId());
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void removeNoFrontTaskWithPackageName(@NonNull Activity activity, @NonNull List<String> list) {
        HashMap map = new HashMap();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), Boolean.FALSE);
        }
        checkFrontTask(activity, map);
        for (Map.Entry entry : map.entrySet()) {
            if (!((Boolean) entry.getValue()).booleanValue()) {
                Iterator<String> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().equals(entry.getKey())) {
                            it2.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public boolean isFrontTask(@NonNull Activity activity, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        removeNoFrontTaskWithPackageName(activity, new ArrayList(list));
        return !r0.isEmpty();
    }
}
