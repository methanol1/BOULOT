package com.natixis.cco.upconnect.converter;

public enum COBOLDecimal {
    S9_11_V9_0(11, 0),
    S9_11_V9_2(11, 2),
    S9_1_V9_8(1, 8),
    S9_2_V9_7(2, 7),
    S9_5_V9_2(5, 2),
    S9_3_V9_2(3, 2),
    S9_2_V9_5(2, 5);

    private Integer s9;
    private Integer v9;

    private COBOLDecimal(final Integer longueurS9, final Integer longueurV9) {
        this.s9 = longueurS9;
        this.v9 = longueurV9;
    }

    public Integer getS9() {
        return s9;
    }

    public Integer getV9() {
        return v9;
    }
}
