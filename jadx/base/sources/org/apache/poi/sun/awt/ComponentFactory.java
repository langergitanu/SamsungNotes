package org.apache.poi.sun.awt;

import org.apache.poi.java.awt.Button;
import org.apache.poi.java.awt.Canvas;
import org.apache.poi.java.awt.Checkbox;
import org.apache.poi.java.awt.CheckboxMenuItem;
import org.apache.poi.java.awt.Choice;
import org.apache.poi.java.awt.Dialog;
import org.apache.poi.java.awt.FileDialog;
import org.apache.poi.java.awt.Frame;
import org.apache.poi.java.awt.GraphicsDevice;
import org.apache.poi.java.awt.Label;
import org.apache.poi.java.awt.List;
import org.apache.poi.java.awt.Menu;
import org.apache.poi.java.awt.MenuBar;
import org.apache.poi.java.awt.MenuItem;
import org.apache.poi.java.awt.Panel;
import org.apache.poi.java.awt.PopupMenu;
import org.apache.poi.java.awt.Robot;
import org.apache.poi.java.awt.ScrollPane;
import org.apache.poi.java.awt.Scrollbar;
import org.apache.poi.java.awt.TextArea;
import org.apache.poi.java.awt.TextField;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.dnd.DragGestureEvent;
import org.apache.poi.java.awt.dnd.peer.DragSourceContextPeer;
import org.apache.poi.java.awt.peer.ButtonPeer;
import org.apache.poi.java.awt.peer.CanvasPeer;
import org.apache.poi.java.awt.peer.CheckboxMenuItemPeer;
import org.apache.poi.java.awt.peer.CheckboxPeer;
import org.apache.poi.java.awt.peer.ChoicePeer;
import org.apache.poi.java.awt.peer.DialogPeer;
import org.apache.poi.java.awt.peer.FileDialogPeer;
import org.apache.poi.java.awt.peer.FontPeer;
import org.apache.poi.java.awt.peer.FramePeer;
import org.apache.poi.java.awt.peer.LabelPeer;
import org.apache.poi.java.awt.peer.ListPeer;
import org.apache.poi.java.awt.peer.MenuBarPeer;
import org.apache.poi.java.awt.peer.MenuItemPeer;
import org.apache.poi.java.awt.peer.MenuPeer;
import org.apache.poi.java.awt.peer.PanelPeer;
import org.apache.poi.java.awt.peer.PopupMenuPeer;
import org.apache.poi.java.awt.peer.RobotPeer;
import org.apache.poi.java.awt.peer.ScrollPanePeer;
import org.apache.poi.java.awt.peer.ScrollbarPeer;
import org.apache.poi.java.awt.peer.TextAreaPeer;
import org.apache.poi.java.awt.peer.TextFieldPeer;
import org.apache.poi.java.awt.peer.WindowPeer;
import org.apache.poi.sun.awt.datatransfer.DataTransferer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ComponentFactory {
    ButtonPeer createButton(Button button);

    CanvasPeer createCanvas(Canvas canvas);

    CheckboxPeer createCheckbox(Checkbox checkbox);

    CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem checkboxMenuItem);

    ChoicePeer createChoice(Choice choice);

    DialogPeer createDialog(Dialog dialog);

    DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    FileDialogPeer createFileDialog(FileDialog fileDialog);

    FramePeer createFrame(Frame frame);

    LabelPeer createLabel(Label label);

    ListPeer createList(List list);

    MenuPeer createMenu(Menu menu);

    MenuBarPeer createMenuBar(MenuBar menuBar);

    MenuItemPeer createMenuItem(MenuItem menuItem);

    PanelPeer createPanel(Panel panel);

    PopupMenuPeer createPopupMenu(PopupMenu popupMenu);

    RobotPeer createRobot(Robot robot, GraphicsDevice graphicsDevice);

    ScrollPanePeer createScrollPane(ScrollPane scrollPane);

    ScrollbarPeer createScrollbar(Scrollbar scrollbar);

    TextAreaPeer createTextArea(TextArea textArea);

    TextFieldPeer createTextField(TextField textField);

    WindowPeer createWindow(Window window);

    DataTransferer getDataTransferer();

    FontPeer getFontPeer(String str, int i);
}
