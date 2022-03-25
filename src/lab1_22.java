import java.util.Scanner;


public class lab1_22 {
    public static Gora[] setMountArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Gora mount2[] = new Gora[k];
        System.out.println("Введите информацию о горах: ");
        for (int i = 0; i < mount2.length; i++) {
            mount2[i] = new Gora();
            System.out.println("Название " + (i + 1) + "-й горы ");
            mount2[i].name = sc.nextLine();
            System.out.println("Местоположение " + (i + 1) + "-й горы ");
            mount2[i].place = sc.nextLine();
            System.out.println("Высота " + (i + 1) + "-й горы ");
            mount2[i].high = sc.nextDouble();
        }
        return mount2;
    }

    public static void showArray(Gora[] cntr2) {// ИНФОРМАЦИЯ ОБ ОДНОЙ ГОРЕ
        for (int i = 0; i < cntr2.length; i++) {
            System.out.println("" + cntr2[i].name + cntr2[i].place + " \t" + cntr2[i].high + " метров");
        }
    }
    public static void showMount(Gora cntr2) {// ИНФОРМАЦИЯ ОБ ОДНОЙ ГОРЕ
        System.out.println("" + cntr2.name + cntr2.place + " \t" + cntr2.high + " метров");

    }


    public static int NomMax(Gora[] st) { //  САМАЯ ВЫСОКАЯ ГОРА
        int nommax = 0;
        double max = st[nommax].high;
        for (int i = 0; i < st.length; i++)
            if (st[i].high > max) {
                max = st[i].high;
                nommax = i;
            }
        return nommax;
    }

    public static void sortHigh(Gora[] cntr) { // СОРТИРОВКА ПО ВЫСОТЕ
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].high > cntr[j + 1].high) {
                    Gora rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество гор: ");
        int n = sc.nextInt();
        Gora mount2[] = setMountArr(n);
        System.out.println("\nХарактеристики гор:");
        showArray(mount2);

        int nommax = NomMax(mount2);
        System.out.println("\nСамая высокая гора");
        int nomMax = NomMax(mount2);
        showMount(mount2[nomMax]);
        sortHigh(mount2);

        System.out.println("\nОтсортированный список по возрастанию высот:");
        showArray(mount2);

    }
}