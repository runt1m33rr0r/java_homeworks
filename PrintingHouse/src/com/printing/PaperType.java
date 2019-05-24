package com.printing;

public enum PaperType {
    NORMAL, GLOSSY, NEWSPAPER;

    public static final double NORMAL_PRICE = 1.0;
    public static final double GLOSSY_PRICE = 4.0;
    public static final double NEWSPAPER_PRICE = 2.0;

    public static double getPriceByPaperType(PaperType type) {
        switch (type) {
            case GLOSSY: return GLOSSY_PRICE;
            case NORMAL: return NORMAL_PRICE;
            default: return NEWSPAPER_PRICE;
        }
    }
}
