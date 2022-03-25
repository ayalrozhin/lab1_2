import java.util.Scanner;
class Gora{
    String name;
    String place;
    double high;
}
public class lab1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите количество гор: ");
        int n = sc.nextInt();
        Gora mount[] = new Gora[n];
        System.out.println("Введите информацию о горах: ");
        for (int i = 0; i < mount.length; i++) {
            sc.nextLine();
            mount[i] = new Gora();
            System.out.print("Название " + (i + 1) + "-й горы ");
            mount[i].name = sc.nextLine();
            System.out.print("Местоположение " + (i + 1) + "-й горы ");
            mount[i].place = sc.nextLine();
            System.out.print("Высота " + (i + 1) + "-й горы ");
            mount[i].high = sc.nextDouble();
        }
        System.out.println("\nХарактеристики гор:");
        for (int i = 0; i < mount.length; i++) {
            System.out.println("" + mount[i].name + "\t" + mount[i].place + "\t" + mount[i].high
                    + " метров");
        }


        int nommax=0; //самая высокая гора
        double max=mount[nommax].high;
        for (int i = 0; i < mount.length; i++)
            if (mount[i].high>max) {
                max= mount[i].high;
                nommax=i;
            }
        System.out.println("\nСамая высокая гора :");
        System.out.println(""+mount[nommax].name+"\t"+mount[nommax].high
                +"метров");

        double km = 1000; //БОЛЬШЕ 1000 МЕТРОВ
        System.out.println("\n Горы больше 1000 метров");
        for (int i = 0; i < mount.length; i++)
            if (mount[i].high > km) {
                System.out.println(mount[i].name + "\t" + mount[i].high + " метров");
            }


        for (int i = 0; i < mount.length-1; i++) //СОРТИРОВКА ПО ВЫСОТЕ
            for (int j = 0; j < mount.length-1-i; j++)
                if (mount[j].high>mount[j+1].high){
                    Gora rab=mount[j];
                    mount[j]=mount[j+1];
                    mount[j+1]=rab;
                }
        System.out.println("\nОтсортированный список по возрастанию высот:");//
        for (int i = 0; i < mount.length; i++) {
            System.out.println(""+mount[i].name+"\t"+mount[i].high+" метров");
        }



        sc.nextLine(); //ПОИСК ПО НАЗВАНИЮ и РЕДАКТИРОВАНИЕ ВЫСОТЫ
        System.out.println("Введите название искомой горы: ");
        String name=sc.nextLine();
        int nom=-1;

        for (int i = 0; i < mount.length; i++)
            if (name.equalsIgnoreCase(mount[i].name))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такая гора есть в списке. Это "
                    +mount[nom].name+" "+mount[nom].high+" метров");
            System.out.println("Выберите редактировать :");
            System.out.println("1-name 2 - place, 3 - high");
            int indexR = sc.nextInt();
            sc.nextLine();
            switch (indexR){
                case 1:{
                    System.out.println("Введите новое название");
                    mount[nom].name = sc.nextLine();
                    break;
                }
                case 2:{
                    System.out.println("Введите новое местоположение");
                    mount[nom].place = sc.nextLine();
                    break;
                }
                case 3:{
                    System.out.println("Введите новую высоту");
                    mount[nom].high = sc.nextDouble();
                    break;
                }
                default:{
                    System.out.println("Нет такого поля");
                }
            }

            System.out.println("Гора "+mount[nom].name+" "+mount[nom].place+" "+mount[nom].high+" метров");
        }else System.out.println("Такой горы нет в списке");


    }
}

