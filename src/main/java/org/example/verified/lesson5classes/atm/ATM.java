package org.example.verified.lesson5classes.atm;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/*Создать класс описывающий банкоматю Набор купюр, находящихся в банкомате, должен задаваться тремя св-вами:
 * кол-во купюр номиналом 20, 50, 100. Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги.
 * С клавиатуры передается сумма денег. На экран - булевское значение (операция удалась или нет).
 * При снятии денег метод должен выводить на экран каким количеством купюр и какого номинала выдается сумма.
 * Создать конструктор с тремя параметрами - количество купюр*/
public class ATM {
    private final InputController inputController;
    private final SortedMap<Cash, Integer> cash;

    public ATM(int denomination20, int denomination50, int denomination100) {
        if (denomination20 >= 0 && denomination50 >= 0 && denomination100 >= 0) {
            inputController = new InputController();
            cash = new TreeMap<>();
            cash.put(Cash.DENOMINATION_20, denomination20);
            cash.put(Cash.DENOMINATION_50, denomination50);
            cash.put(Cash.DENOMINATION_100, denomination100);
        } else {
            throw new IllegalArgumentException("Incorrect amount!");
        }
    }

    public boolean withdrawMoney() {
        int maxAmount = Arrays.stream(Cash.values()).map(c -> c.getValue() * cash.get(c)).reduce(Integer::sum).orElse(0);
        int withdrawalAmount = inputController.getWithdrawalAmount(maxAmount);
        SortedMap<Cash, Integer> denominations = new TreeMap<>();
        Arrays.stream(Cash.values()).forEach(e -> denominations.put(e, 0));
        int currentAmount = 0;

        int remainsAmount = withdrawalAmount;

        for (int i = 0; i < Cash.values().length; i++) {
            for (int j = Cash.values().length - 1; j >= i; j--) {

                int denomination = Cash.getDenominationByIndex(j).getValue();
                int denominationInATM = cash.get(Cash.getDenominationByIndex(j));

                while (denominationInATM != 0 && remainsAmount != 0 && ((remainsAmount / denomination) * denomination) != 0
            && ((remainsAmount / denomination) * denomination) % denomination == 0) {
                    denominations.put(Cash.values()[j], denominations.get(Cash.values()[j]) + 1);
                    currentAmount += denomination;
                    remainsAmount -= denomination;
                    cash.put(Cash.getDenominationByIndex(j), denominationInATM - 1);
                    denominationInATM = cash.get(Cash.getDenominationByIndex(j));
                }
            }
        }

        if (currentAmount == withdrawalAmount) {
            StringBuilder sb = new StringBuilder("Amount of money issued: ");
            denominations.keySet().forEach(k -> sb.append(k).append(": ").append(denominations.get(k)).append(", "));
            System.out.println("Amount issued: " + currentAmount);
            System.out.println(sb);
            return true;
        } else {
            System.out.println("No required denomination");
            return false;
        }
    }

    public void addMoney(Cash denomination, int amount) {
        if (amount >= 0) {
            cash.put(denomination, cash.get(denomination) + amount);
        } else {
            throw new IllegalArgumentException("Invalid amount!");
        }
    }

}
