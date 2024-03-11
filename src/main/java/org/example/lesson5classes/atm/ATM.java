package org.example.lesson5classes.atm;

import java.util.*;
import java.util.stream.Collectors;

/*Создать класс описывающий банкоматю Набор купюр, находящихся в банкомате, должен задаваться тремя св-вами:
 * кол-во купюр номиналом 20, 50, 100. Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги.
 * С клавиатуры передается сумма денег. На экран - булевское значение (операция удалась или нет).
 * При снятии денег метод должен выводить на экран каким количеством купюр и какого номинала выдается сумма.
 * Создать конструктор с тремя параметрами - количество купюр*/
public class ATM {
    private final InputController inputController;
    private SortedMap<Cash, Integer> cash = new TreeMap<>();
    private final SortedMap<Cash, Integer> withdraw = new TreeMap<>();
    private List<Map<Cash, Integer>> cashSums = new ArrayList<>();
    private int currentAmount = 0;
    private int denIteration = 0;
    private int nextDenIteration = 0;
    private int remainsAmount = 0;


    public ATM(int denomination20, int denomination50, int denomination100) {
        if (denomination20 >= 0 && denomination50 >= 0 && denomination100 >= 0) {
            inputController = new InputController();
            Arrays.stream(Cash.values()).forEach(c -> withdraw.put(c, 0));
            cash.put(Cash.DENOMINATION_20, denomination20);
            cash.put(Cash.DENOMINATION_50, denomination50);
            cash.put(Cash.DENOMINATION_100, denomination100);
        } else {
            throw new IllegalArgumentException("Incorrect amount!");
        }
    }

    public boolean withdrawMoney(int s) {
        int withdrawalAmount = s;

        StringBuilder sbBefore = new StringBuilder("\nAmount of money before: ");
        cash.keySet().forEach(k -> sbBefore.append(k).append(": ").append(cash.get(k)).append(", "));
        System.out.println(sbBefore);

        remainsAmount = withdrawalAmount;

        for (int i = 0; i < Cash.values().length; i++) {
            calculatePossibleAmounts(withdrawalAmount - Cash.getDenominationByIndex(i).getValue() * denIteration, Cash.getDenominationByIndex(i));
            while (!cashSums.isEmpty() && currentAmount != withdrawalAmount) {
                for (int j = 0; j < Cash.values().length; j++) {
                    Cash denomination = Cash.getDenominationByIndex(j);
                    calculatePossibleAmounts(remainsAmount, denomination);
                    if (cashSums.isEmpty()) continue;
                    addSum(denomination);
                    if (currentAmount != withdrawalAmount && (denIteration > 0 || nextDenIteration > 0)) {
                        while (!cashSums.isEmpty()) {
                            if (j != Cash.values().length - 1 && checkRemainingAmount(Cash.getDenominationByIndex(j + 1)))
                                break;
                            deleteSum(denomination);
                            cashSums.remove(0);
                            for (Map<Cash, Integer> cashSum : cashSums) {
                                addSum(denomination);
                                if (currentAmount == withdrawalAmount || (j != Cash.values().length - 1 && checkRemainingAmount(Cash.getDenominationByIndex(j + 1))))
                                    break;
                                deleteSum(denomination);
                            }
                            if (currentAmount == withdrawalAmount || (j != Cash.values().length - 1 && checkRemainingAmount(Cash.getDenominationByIndex(j + 1))))
                                break;
                        }
                    }

                    if (currentAmount == withdrawalAmount) {
                        break;
                    }
                }
                if (currentAmount != withdrawalAmount) {
                    Arrays.stream(Cash.values()).forEach(c -> withdraw.put(c, 0));
                    calculatePossibleAmounts(withdrawalAmount - Cash.getDenominationByIndex(i).getValue() * denIteration, Cash.getDenominationByIndex(i));
                    currentAmount = 0;
                    remainsAmount = withdrawalAmount;
                    if (cashSums.isEmpty()) break;
                    currentAmount = cashSums.get(0).get(Cash.getDenominationByIndex(i)) * Cash.getDenominationByIndex(i).getValue();
                    remainsAmount = withdrawalAmount - currentAmount;
                    withdraw.put(Cash.getDenominationByIndex(i), cashSums.get(0).get(Cash.getDenominationByIndex(i)));
                    if (cash.get(Cash.getDenominationByIndex(i)) * Cash.getDenominationByIndex(i).getValue() < remainsAmount)
                        break;
                }
                denIteration++;
            }
            denIteration = 0;
        }


        if (currentAmount == withdrawalAmount) {
            printResult(currentAmount);
            Arrays.stream(Cash.values()).forEach(c -> withdraw.put(c, 0));
            return true;
        } else {
            System.out.println("No required denomination");
            Arrays.stream(Cash.values()).forEach(c -> {
                withdraw.put(c, 0);
            });
            return false;
        }

    }

    private boolean checkRemainingAmount(Cash cash) {
        List<Cash> cashList = Arrays.asList(Cash.values());
        cashList = cashList.stream()
                .filter(c -> c.getValue() < cash.getValue())
                .collect(Collectors.toList());
        boolean isMultipleOfCurrency = false;
        if (!cashList.isEmpty()) {
            for (Cash value : cashList) {
                isMultipleOfCurrency = remainsAmount % value.getValue() == 0;
                if (isMultipleOfCurrency) break;
            }
        }
        return isMultipleOfCurrency;
    }

    private void addSum(Cash denomination) {
        currentAmount += cashSums.get(0).get(denomination) * denomination.getValue();
        remainsAmount -= cashSums.get(0).get(denomination) * denomination.getValue();
        withdraw.put(denomination, withdraw.get(denomination) + cashSums.get(0).get(denomination));
    }

    private void deleteSum(Cash denomination) {
        currentAmount -= cashSums.get(0).get(denomination) * denomination.getValue();
        remainsAmount += cashSums.get(0).get(denomination) * denomination.getValue();
        withdraw.put(denomination, withdraw.get(denomination) - cashSums.get(0).get(denomination));
    }

    private void printResult(int currentAmount) {
        withdraw.forEach((c, v) -> cash.put(c, cash.get(c) - withdraw.get(c)));
        StringBuilder sb = new StringBuilder("Amount of money issued: ");
        withdraw.keySet().forEach(k -> sb.append(k).append(": ").append(withdraw.get(k)).append(", "));
        System.out.println("Amount issued: " + currentAmount + "\n" + sb);
        StringBuilder sbAfter = new StringBuilder("Amount of money after: ");
        cash.keySet().forEach(k -> sbAfter.append(k).append(": ").append(cash.get(k)).append(", "));
        System.out.println(sbAfter);
    }

    private void calculatePossibleAmounts(int withdrawalAmount, Cash denomination) {
        cashSums.clear();
        int count = withdraw.containsKey(denomination) ? cash.get(denomination) - withdraw.get(denomination) : cash.get(denomination);
        int maxCount = Math.min(count, withdrawalAmount / denomination.getValue());

        while (maxCount != 0) {
            cashSums.add(Map.of(denomination, maxCount));
            maxCount--;
        }
    }

    public void addMoney(Cash denomination, int amount) {
        if (amount >= 0) {
            cash.put(denomination, cash.get(denomination) + amount);
        } else {
            throw new IllegalArgumentException("Invalid amount!");
        }
    }

    public void clean() {
        cash = new TreeMap<>();
        cash.put(Cash.DENOMINATION_20, 0);
        cash.put(Cash.DENOMINATION_50, 0);
        cash.put(Cash.DENOMINATION_100, 0);
    }

}