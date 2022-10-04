public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Оксана")
                .setSurname("Романова")
                .setAge(35)
                .setAddress("Воронеж")
                .build();
        Person daughter = mom.newChildBuilder()
                .setName("Маргарита")
                .build();
        System.out.println("У " + mom + " есть дочка, " + daughter);

        //Демонстрация нехватки обязательных к заполнению полей
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //Демонстрация не корректно указанного возраста
        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-3).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}