package hw2;

import java.util.Arrays;

public enum MenuList {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS"),
    ELEMENTS_PACKS("ELEMENTS PACKS");

    private String displayedText;

    MenuList(String text) {
        displayedText = text;
    }

    public String getDisplayedText(){ return displayedText;}

    public boolean checkIsContains(String text) {
        return Arrays.stream(MenuList.values()).anyMatch(e->e.getDisplayedText().equals(text));
    }

}
