package service;

import util.TipoElemental;

public class CalculadoraElemental {

    public static double calcularMultiplicador(TipoElemental atacante, TipoElemental defensor) {
        if (atacante == null || defensor == null) {
            return 1.0;
        }

        switch (atacante) {
            case FOGO:
                if (defensor == TipoElemental.TERRA) return 2.0;
                if (defensor == TipoElemental.AGUA) return 0.5;
                break;
            case AGUA:
                if (defensor == TipoElemental.FOGO) return 2.0;
                if (defensor == TipoElemental.AR) return 0.5;
                break;
            case TERRA:
                if (defensor == TipoElemental.AR) return 2.0;
                if (defensor == TipoElemental.FOGO) return 0.5;
                break;
            case AR:
                if (defensor == TipoElemental.AGUA) return 2.0;
                if (defensor == TipoElemental.TERRA) return 0.5;
                break;
            case LUZ:
                if (defensor == TipoElemental.TREVAS) return 2.0;
                break;
            case TREVAS:
                if (defensor == TipoElemental.LUZ) return 2.0;
                break;
        }

        return 1.0;
    }
}
