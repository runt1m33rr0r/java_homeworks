package com.printing;

public enum PageSize {
    A1, A2, A3, A4, A5;

    public static final double A1_PRICE = 1.0;
    public static final double A2_PRICE = 2.0;
    public static final double A3_PRICE = 3.0;
    public static final double A4_PRICE = 4.0;
    public static final double A5_PRICE = 5.0;

    public static double getPriceBySize(PageSize size) {
        switch (size) {
            case A1: return A1_PRICE;
            case A2: return A2_PRICE;
            case A3: return A3_PRICE;
            case A4: return A4_PRICE;
            default: return A5_PRICE;
        }
    }
}