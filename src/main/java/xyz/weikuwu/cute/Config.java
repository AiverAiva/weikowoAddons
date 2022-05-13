package xyz.weikuwu.cute;

import com.sun.jna.platform.win32.WinBase;
import gg.essential.universal.UChat;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ChatComponentText;
import xyz.weikuwu.cute.utils.ChatLib;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class Config extends Vigilant {
    public Config(File f){
        super(f);
    }

    //DungeonUtils
    @Property(
            type = PropertyType.SWITCH,
            name = "Auto Extra Stats",
            description = "do /showextrastats automatically after the dungeon ends.",
            category = "Dungeon",
            subcategory = "Utils"
    )
    public boolean showextrastats = true;

    //General Settings
    @Property(
            type = PropertyType.TEXT,
            name = "Your API key",
            description = "the API key is used to request player data from hypixel APIs",
            category = "Settings",
            subcategory = "API Key",
            placeholder = "< API Key >"
    )
    public String APIKey = "";

    @Property(
            type = PropertyType.BUTTON,
            name = "Get API Key",
            description = "This button will grab your API key for you when you press it.",
            placeholder = "Get API Key",
            category = "Settings",
            subcategory = "API Key"
    )
    public static void GetAPIKey() {
        ChatLib.Send("/api new");
        Minecraft.getMinecraft().thePlayer.closeScreen();
    }

    //owoKicker
    @Property(
            type = PropertyType.SWITCH,
            name = "Enable Autokick",
            category = "owoKicker - General",
            subcategory = "General Settings"
    )
    public boolean autokick = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Send Kick Reason in Party Chat",
            description = "When enabled, when Autokick kicks someone, it will send the kick reason in party chat.",
            category = "owoKicker - General",
            subcategory = "General Settings"
    )
    public boolean kickreason = true;

    @Property(
            type = PropertyType.NUMBER,
            name = "Secret Minimum",
            description = "If someone's secret count is below this number, they will be kicked from the party automatically.",
            category = "owoKicker - Personal",
            subcategory = "Personal Stats",
            min = 0,
            max = 100000,
            increment = 5000
    )
    int secretmin = 0;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Floor 7 Check",
            description = "Check if the user meet the requirment about f7 and the settings above.",
            category = "owoKicker - Personal",
            subcategory = "Personal Stats"
    )
    boolean Floor7Check = false;


    @Property(
            type = PropertyType.SELECTOR,
            name = "Floor 7 S+ Checker",
            description = "Check if the player are fast enough to join your party",
            category = "owoKicker - Personal",
            subcategory = "Personal Stats",
            options = {"None", "4:00", "5:00", "6:00", "7:00"}

    )
    int Floor7SPlus = 0;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Inventory Check",
            description = "Kick if the player has their api disabled.",
            category = "owoKicker - Personal",
            subcategory = "Equipment"
    )
    boolean APICloseKicking = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Require Necron Blade",
            description = "When enabled, if someone does not have a necron blade (Hyperion/Valkyrie/Scylla/Astraea), they will be kicked from the party.",
            category = "owoKicker - Personal",
            subcategory = "Equipment"
    )
    boolean requireNecronBlade = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Require Terminator",
            description = "When enabled, if someone does not have a Terminator they will be kicked from the party.",
            category = "owoKicker - Personal",
            subcategory = "Equipment"
    )
    boolean requireTerminator = false;

    @Property(
            type = PropertyType.SWITCH,
            name = "Require Terminator As Archer",
            description = "When enabled, if someone is playing archer and does not have a terminator, they will be kicked from the party. Independent from the setting 'Require Terminator'.",
            category = "owoKicker - Personal",
            subcategory = "Equipment"
    )
    boolean requireTerminatorasArcher = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Mage Allowed",
            category = "owoKicker - Class",
            subcategory = "Class"
    )
    boolean mageAllowed = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Berserk Allowed",
            category = "owoKicker - Class",
            subcategory = "Class"
    )
    boolean berserkAllowed = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Archer Allowed",
            category = "owoKicker - Class",
            subcategory = "Class"
    )
    boolean archerAllowed = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Tank Allowed",
            category = "owoKicker - Class",
            subcategory = "Class"
    )
    boolean tankAllowed = false;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Healer Allowed",
            category = "owoKicker - Class",
            subcategory = "Class"
    )
    boolean healerAllowed = false;

    @Property(
            type = PropertyType.BUTTON,
            name = "owo mode",
            description = "owo",
            category = "owo",
            subcategory = "owo"
    )
    public void owo(){
        if(Minecraft.getMinecraft().theWorld!=null)
        {
            Minecraft.getMinecraft().theWorld.sendQuittingDisconnectingPacket();
            Minecraft.getMinecraft().loadWorld(null);
            Minecraft.getMinecraft().displayGuiScreen(null);
        }
        ChatComponentText component = new ChatComponentText("\u00a7cYou are permanently banned from this server!");
        component.appendText("\n");
        component.appendText("\n\u00a77Reason: \u00a7rSuspicious account activity.");
        component.appendText("\n\u00a77Find out more: \u00a7b\u00a7nhttps://www.hypixel.net/appeal");
        component.appendText("\n");
        component.appendText("\n\u00a77Ban ID: \u00a7r#");
        component.appendText(Integer.toHexString(new Random().nextInt((int) (Math.pow(16,8)-1))).toUpperCase());
        component.appendText("\n\u00a77Sharing your Ban ID may affect the processing of your appeal!");
        weikowoAddons.INSTANCE.screen = new GuiDisconnected(new GuiMainMenu(),"",component);
    }

//
//    @Property(
//            type = PropertyType.PARAGRAPH,
//            name = "Paragraph",
//            description = "This is a paragraph property. It stores a multi-line piece of text, and expands as the user writes more text",
//            category = "Property Overview"
//    )
//    String demoParagraph = "";
//
//    @Property(
//            type = PropertyType.PERCENT_SLIDER,
//            name = "Percent Slider",
//            description = "This is a percent slider property. It stores a floating-point number between 0.0 and 1.0.",
//            category = "Property Overview"
//    )
//    float demoPercentSlider = 0f;
//
//    @Property(
//            type = PropertyType.DECIMAL_SLIDER,
//            name = "Decimal Slider",
//            description = "This is a decimal slider property. It stores a floating point number between a defined minimum and maximum.",
//            category = "Property Overview",
//            minF = 0f,
//            maxF = 12f,
//            decimalPlaces = 2
//    )
//    float decimalSlider = 1f;
//
//    @Property(
//            type = PropertyType.SLIDER,
//            name = "Slider",
//            description = "This is a slider property. It stores an integer between a defined minimum and maximum integer.",
//            category = "Property Overview",
//            min = 0,
//            max = 10
//    )
//    int demoSlider = 0;
//
//    @Property(
//            type = PropertyType.NUMBER,
//            name = "Number",
//            description = "This is a number property. It stores an integer between a defined minimum and maximum integer.",
//            category = "Property Overview",
//            min = 0,
//            max = 10
//    )
//    int demoNumber = 0;
//
//    @Property(
//            type = PropertyType.BUTTON,
//            name = "Button",
//            description = "This is a button property. It runs an action when clicked.",
//            category = "Property Overview"
//    )
//    public static void demoButton() {
//        UChat.chat("demoButton clicked!");
//    }
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Toggle Tom",
//            description = "",
//            category = "Property Overview"
//    )
//    boolean toggleTom = true;
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Property Pete",
//            description = "",
//            category = "Property Overview",
//            subcategory = "Subcategory Steve"
//    )
//    boolean propertyPete = true;
//
//    @Property(
//            type = PropertyType.CHECKBOX,
//            name = "Checkbox Chuck",
//            description = "",
//            category = "Property Overview",
//            subcategory = "Subcategory Steve"
//    )
//    boolean checkboxChuck = false;
//
////    @Property(
////            type = PropertyType.TEXT,
////            name = "Password",
////            description = "Anything you type here won't be visible unless the eye is clicked!",
////            category = "Property Overview",
////            placeholder = "HELLO",
////            protectedText = true
////    )
////    String password: String = "";
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Switch with dependants",
//            description = "When ticked, this switch will make another setting appear",
//            category = "Property Deep-Dive",
//            subcategory = "Dependencies"
//    )
//    boolean dependency = true;
//
////    @Property(
////            type = PropertyType.TEXT,
////            name = "Dependant",
////            description = "This setting depends on the above switch!",
////            category = "Property Deep-Dive",
////            subcategory = "Dependencies"
////    )
////    var dependant: String = "hey"
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Initially off switch",
//            description = "Switch that starts in the off position",
//            category = "Property Deep-Dive",
//            subcategory = "Switches"
//    )
//    boolean offSwitch = false;
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Initially on switch",
//            description = "Switch that starts in the on position",
//            category = "Property Deep-Dive",
//            subcategory = "Switches"
//    )
//    boolean onSwitch = true;
//
//    @Property(
//            type = PropertyType.TEXT,
//            name = "Empty text",
//            description = "A text property with no initial text or placeholder",
//            category = "Property Deep-Dive",
//            subcategory = "Texts"
//    )
//    String emptyText = "";
//
//    @Property(
//            type = PropertyType.TEXT,
//            name = "Text with initial value",
//            description = "A text property with some initial value but no placeholder",
//            category = "Property Deep-Dive",
//            subcategory = "Texts"
//    )
//    String textWithInitialValue = "I am a text property!";
//
//    @Property(
//            type = PropertyType.TEXT,
//            name = "Text with placeholder",
//            description = "A text property with a placeholder but no initial value",
//            category = "Property Deep-Dive",
//            subcategory = "Texts",
//            placeholder = "Type some text!"
//    )
//    String textWithPlaceholder = "";
//
//    @Property(
//            type = PropertyType.TEXT,
//            name = "Text with placeholder and initial value",
//            description = "A text property with a placeholder and initial value. The placeholder does not appear unless the text is deleted by the user.",
//            category = "Property Deep-Dive",
//            subcategory = "Texts",
//            placeholder = "Type some text!"
//    )
//    String textWithPlaceholderAndInitialValue = "I am a text property!";
//
//    @Property(
//            type = PropertyType.PARAGRAPH,
//            name = "Empty paragraph",
//            description = "A paragraph property with no initial text or placeholder",
//            category = "Property Deep-Dive",
//            subcategory = "Paragraphs"
//    )
//    String emptyParagraph = "";
//
//    @Property(
//            type = PropertyType.PARAGRAPH,
//            name = "Paragraph with initial value",
//            description = "A paragraph property with some initial value but no placeholder",
//            category = "Property Deep-Dive",
//            subcategory = "Paragraphs"
//    )
//    String paragraphWithInitialValue = "I am a paragraph! I can have text that is much, much longer than the regular text property. I also use Elementa's multiline text input component, which supports features like coyp paste, cursor navigation, click selection, and more :)";
//
//    @Property(
//            type = PropertyType.PARAGRAPH,
//            name = "Paragraph with placeholder",
//            description = "A paragraph property with a placeholder but no initial value",
//            category = "Property Deep-Dive",
//            subcategory = "Paragraphs",
//            placeholder = "Type some text!"
//    )
//    String paragraphWithPlaceholder = "";
//
//    @Property(
//            type = PropertyType.PARAGRAPH,
//            name = "Paragraph with placeholder and initial value",
//            description = "A paragraph property with a placeholder and initial value. The placeholder does not appear unless the text is deleted by the user.",
//            category = "Property Deep-Dive",
//            subcategory = "Paragraphs",
//            placeholder = "Type some text!"
//    )
//    String paragraphWithPlaceholderAndInitialValue = "I am a paragraph! I can have text that is much, much longer than the regular text property. I also use Elementa's multiline text input component, which supports features like coyp paste, cursor navigation, click selection, and more :)";
//
//    @Property(
//            type = PropertyType.PERCENT_SLIDER,
//            name = "Percent slider",
//            description = "A percent slider property with a starting value of 0.0 (0%).",
//            category = "Property Deep-Dive",
//            subcategory = "Percent Sliders"
//    )
//    float percentSliderAtZero = 0.0f;
//
//    @Property(
//            type = PropertyType.PERCENT_SLIDER,
//            name = "Percent slider at half",
//            description = "A percent slider property with a starting value of 0.5 (50%).",
//            category = "Property Deep-Dive",
//            subcategory = "Percent Sliders"
//    )
//    float percentSliderAtHalf = 0.5f;
//
//    @Property(
//            type = PropertyType.SLIDER,
//            name = "Slider starting in middle",
//            description = "A slider property initially in the middle.",
//            category = "Property Deep-Dive",
//            subcategory = "Sliders",
//            min = 0,
//            max = 10
//    )
//    int sliderMiddle = 5;
//
//    @Property(
//            type = PropertyType.SLIDER,
//            name = "Slider with negative values",
//            description = "A slider property with negative numbers in its range",
//            category = "Property Deep-Dive",
//            subcategory = "Sliders",
//            min = -10,
//            max = 10
//    )
//    int negativeSlider = 0;
//
//    @Property(
//            type = PropertyType.SLIDER,
//            name = "Slider with huge range",
//            description = "A slider property with a huge range (0 to 1,000,000)",
//            category = "Property Deep-Dive",
//            subcategory = "Sliders",
//            min = 0,
//            max = 1_000_000
//    )
//    int hugeSlider = 0;
//
//    @Property(
//            type = PropertyType.DECIMAL_SLIDER,
//            name = "Decimal Slider with small range",
//            description = "A decimal slider property with a small range (0 to 1)",
//            category = "Property Deep-Dive",
//            subcategory = "Decimal Sliders",
//            minF = 0f,
//            maxF = 1f,
//            decimalPlaces = 3
//    )
//    float smallRangeDecimalSlider = .5f;
//
////    @Property(
////            type = PropertyType.DECIMAL_SLIDER,
////            name = "Decimal Slider with many decimal places",
////            description = "A decimal slider property with ten decimal places. Note that the value is a floating point number so it will get trimmed.",
////            category = "Property Deep-Dive",
////            subcategory = "Decimal Sliders",
////            minF = 1f,
////            maxF = 5f,
////            decimalPlaces = 10
////    )
////    float tenDecimalPlacesSlider = PI.tofloat();
//
//    @Property(
//            type = PropertyType.NUMBER,
//            name = "Number with initial value",
//            description = "A number property with an initial value starting in the middle of its range.",
//            category = "Property Deep-Dive",
//            subcategory = "Numbers",
//            min = 0,
//            max = 10
//    )
//    int numberMiddle = 5;
//
//    @Property(
//            type = PropertyType.NUMBER,
//            name = "Number with increment",
//            description = "Number with an increment that is not 1. Hint: Try holding shift!",
//            category = "Property Deep-Dive",
//            subcategory = "Numbers",
//            min = -500,
//            max = 500,
//            increment = 25
//    )
//    int numberIncrement = 250;
//
//    @Property(
//            type = PropertyType.NUMBER,
//            name = "Number with huge range",
//            description = "A number property with a huge range (0 to 1,000,000).",
//            category = "Property Deep-Dive",
//            subcategory = "Numbers",
//            min = 0,
//            max = 1_000_000
//    )
//    int hugeNumber = 0;
//
//    @Property(
//            type = PropertyType.COLOR,
//            name = "Color with an initial, non-white value",
//            description = "A color property with an initial value of a non-white color.",
//            category = "Property Deep-Dive",
//            subcategory = "Colors",
//            allowAlpha = false
//    )
//    Color nonWhiteColor = new Color(20, 190, 240);
//
//    @Property(
//            type = PropertyType.COLOR,
//            name = "Color with alpha",
//            description = "A color property which allows the selection of alpha",
//            category = "Property Deep-Dive",
//            subcategory = "Colors",
//            allowAlpha = true
//    )
//    Color colorWithAlpha = new Color(20, 190, 240, 255 / 2);
//
//    @Property(
//            type = PropertyType.SELECTOR,
//            name = "Selector with initial non-zero value",
//            description = "A selector property whose initially-selected value is not the first item.",
//            category = "Property Deep-Dive",
//            subcategory = "Selectors",
//            options = {"Option 1", "Option 2", "Option 3", "Option 4"}
//    )
//    int selectorInitialValue = 2;
//
//    @Property(
//            type = PropertyType.SELECTOR,
//            name = "Selector with many options",
//            description = "A selector property which has a large number of options",
//            category = "Property Deep-Dive",
//            subcategory = "Selectors",
//            options = {
//                    "Option 1",
//                    "Option 2",
//                    "Option 3",
//                    "Option 4",
//                    "Option 5",
//                    "Option 6",
//                    "Option 7",
//                    "Option 8",
//                    "Option 9",
//                    "Option 10",
//                    "Option 11",
//                    "Option 12",
//                    "Option 13",
//                    "Option 14",
//                    "Option 15",
//                    "Option 16",
//                    "Option 17",
//                    "Option 18",
//                    "Option 19",
//                    "Option 20",
//                    "Option 21",
//                    "Option 22",
//                    "Option 23",
//                    "Option 24",
//                    "Option 25",
//                    "Option 26",
//                    "Option 27",
//                    "Option 28",
//                    "Option 29",
//                    "Option 30"
//            }
//    )
//    int largeSelector = 0;
//
//    @Property(
//            type = PropertyType.BUTTON,
//            name = "Normal button",
//            description = "A normal button. Buttons use the placeholder property for their text. If no placeholder is provided (or it is empty), it will be \"Activate\".",
//            category = "Property Deep-Dive",
//            subcategory = "Buttons"
//    )
//    public static void normalButtonAction() {
//        UChat.chat("normalButton clicked!");
//    }
//
//    @Property(
//            type = PropertyType.BUTTON,
//            name = "Button with text",
//            description = "A button that has a custom placeholder, giving it different text",
//            placeholder = "Click Me!",
//            category = "Property Deep-Dive",
//            subcategory = "Buttons"
//    )
//    public static void customButtonAction() {
//        UChat.chat("customButton clicked!");
//    }
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Conditional Property (W)",
//            description = "This property will only be visible if a condition is met! In this case, it will be visible if you are on Windows.",
//            category = "Property Deep-Dive",
//            subcategory = "Hidden (Conditional)"
//    )
//    boolean windowsOnlyProperty = false;
//
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Conditional Property (M)",
//            description = "This property will only be visible if a condition is met! In this case, it will be visible if you are on macOS.",
//            category = "Property Deep-Dive",
//            subcategory = "Hidden (Conditional)"
//    )
//    boolean  macOnlyProperty = false;
//
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Conditional Property (L)",
//            description = "This property will only be visible if a condition is met! In this case, it will be visible if you are on Linux.",
//            category = "Property Deep-Dive",
//            subcategory = "Hidden (Conditional)"
//    )
//    boolean  linuxOnlyProperty = false;
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "This is a switch property with a very long name. It is recommended to use the description for lengthy property text, however this is still supported",
//            category = "Meta"
//    )
//    boolean  switchWithLongName = false;
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Property with long description",
//            description = "This is a property with a very long description. As the above property says, the description is the preferred place for lengthy instruction text within a property. However, long text here is still not recommended -- try to keep descriptions as concise as possible!",
//            category = "Meta"
//    )
//    boolean switchWithLongDescription = false;
//
//    @Property(
//            type = PropertyType.SWITCH,
//            name = "Hidden switch",
//            description = "This is a hidden property. It will not appear in the in-game GUI, but will still be managed by Vigilance (i.e. saved to a file, and changeable via code).",
//            category = "Hidden",
//            hidden = true
//    )
//    boolean hiddenProperty = false;

}