/*
 * Это свободная программа: вы можете перераспространять ее и/или изменять ее на условиях Стандартной общественной лицензии GNU в том виде, в каком она была опубликована Фондом свободного программного обеспечения; либоверсии 3 лицензии, либо (по вашему выбору) любой более поздней версии.
 *
 * Эта программа распространяется в надежде, что она будет полезной, но БЕЗО ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА или ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Стандартной общественной лицензии GNU.
 *
 * Вы должны были получить копию Стандартной общественной лицензии GNU вместе с этой программой. Если это не так, см. <http://www.gnu.org/licenses/>.
 */

package ru.davidlevy.lesson4;

/**
 * Класс Collaborator *
 *
 * @author David A. Lévy
 * @version 2.00 05.02.2017
 */
public class Collaborator {
    /* Константа. static. Форматирование вывыда в консоль */
    private static final String FORMAT_PRINTING = "%-4d%-25s%-20s%-30s%-20s%-13.2f%-10s\n";

    /* static. Общее поле для экземпляров данного класса. Создано для автонумерации */
    private static int uniqueIdentificator = 0;

    /* Поля класса */
    private int id;
    private String fullname;
    private String function;
    private String email;
    private String phonenumber;
    private double salary;
    private int age;

    /**
     * Конструктор
     *
     * @param fullname    String
     * @param function    String
     * @param email       String
     * @param phonenumber String
     * @param salary      double
     * @param age         int
     */
    Collaborator(String fullname, String function, String email, String phonenumber, double salary, int age) {
        this.id = uniqueIdentificator++;
        this.fullname = fullname;
        this.function = function;
        this.email = email;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Перегруженный конструктор
     *
     * @param obj Collaborator
     */
    Collaborator(Collaborator obj) {
        this.id = uniqueIdentificator++;
        this.fullname = obj.fullname;
        this.function = obj.function;
        this.email = obj.email;
        this.phonenumber = obj.phonenumber;
        this.salary = obj.salary;
        this.age = obj.age;
    }

    /**
     * @param fullname String
     */
    void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @param function String
     */
    void setFunction(String function) {
        this.function = function;
    }

    /**
     * @param email String
     */
    void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phonenumber String
     */
    void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @param salary double
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @param age int
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return String
     */
    public String getFullname() {
        return this.fullname;
    }

    /**
     * @return String
     */
    public String getFunction() {
        return this.function;
    }

    /**
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return String
     */
    public String getPhonenumber() {
        return this.phonenumber;
    }

    /**
     * @return double
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @return int
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Показывает сотрудника
     */
    void getCollaborator() {
        System.out.printf(FORMAT_PRINTING, this.id, this.fullname, this.function, this.email, this.phonenumber, this.salary, this.age);
    }

    /**
     * Показывает сотрудника при условии, что возраст больше int age
     *
     * @param age int
     */
    void getCollaborator(int age) {
        if (this.age > age)
            System.out.printf(FORMAT_PRINTING, this.id, this.fullname, this.function, this.email, this.phonenumber, this.salary, this.age);
    }

    /**
     * Увеличивает зарплату на значение raise при условии, что возраст больше int age
     *
     * @param raise double
     * @param age   int
     */
    void increaseSalary(double raise, int age) {
        if (this.age > age) {
            this.salary += raise;
        }
    }
}