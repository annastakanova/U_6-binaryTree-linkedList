package by.epam;

public class Main {

    public static void main(String[] args) {
        LList list = new LList();

        list.addAtEnd(884);
        list.addAtEnd(66);
        list.addAtEnd(7);
        list.addAtEnd(22);
        list.addAtEnd(35);
        list.addAtEnd(567);
        list.addAtEnd(8766);
        list.addAtEnd(23);
        System.out.println("Исходные данные: " + list.getStringOfList());


        list.removeData(567);
        list.deleteByIndex(0);
        list.addByIndex(2,500);
        list.addAtEnd(5000);
        System.out.println("Данные после изменений: " + list.getStringOfList());
    }
}
