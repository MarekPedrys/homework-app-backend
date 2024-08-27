package pl.marekpedrys.mathematicalproblems.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MathProblemDepartment {
    LICZBY_RZECZYWISTE("Liczby rzeczywiste"),
    WYRAZENIA_ALGEBRAICZNE("Wyrażenia algebraiczne"),
    ROWNANIA_I_NIEROWNOSCI("Równania i nierówności"),
    UKLADY_ROWNAN("Układy równań"),
    FUNKCJE("Funkcje"),
    CIAGI("Ciągi"),
    TRYGONOMETRIA("Trygonometria"),
    PLANIMETRIA("Planimetria"),
    GEOMETRIA_ANALITYCZNA("Geometria analityczna"),
    STEREOMETRIA("Stereometria"),
    KOMBINATORYKA("Kombinatoryka"),
    RACHUNEK_PRAWDOPODOBIENSTWA_I_STATYSTYKA("Rachunek prawdopodobieństwa i statystyka"),
    OPTYMALIZACJA_I_RACHUNEK_ROZNICZKOWY("Optymalizacja i rachunek różniczkowy");

    private final String label;
}
