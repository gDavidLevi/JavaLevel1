/*
 * Это свободная программа: вы можете перераспространять ее и/или изменять ее на условиях Стандартной общественной лицензии GNU в том виде, в каком она была опубликована Фондом свободного программного обеспечения; либоверсии 3 лицензии, либо (по вашему выбору) любой более поздней версии.
 *
 * Эта программа распространяется в надежде, что она будет полезной, но БЕЗО ВСЯКИХ ГАРАНТИЙ; даже без неявной гарантии ТОВАРНОГО ВИДА или ПРИГОДНОСТИ ДЛЯ ОПРЕДЕЛЕННЫХ ЦЕЛЕЙ. Подробнее см. в Стандартной общественной лицензии GNU.
 *
 * Вы должны были получить копию Стандартной общественной лицензии GNU вместе с этой программой. Если это не так, см. <http://www.gnu.org/licenses/>.
 */

package ru.davidlevy.lesson4;

/**
 * В данной программе эксплуатируется класс Collaborator *
 * Ключивые слова: class, private, public, static, static final, поле, конструктор, метод,
 * this., this(), инкапсуляция
 *
 * @author David A. Lévy
 * @version 2.00 05.02.2017
 */
public class HomeWork4 {
    /**
     *
     * @param array Collaborator[]
     */
    private static void initTable(Collaborator[] array) {
        array[0] = new Collaborator("David A. Levy", "engener", "gDavidLevy@gmail.com", "+79268271983", 90001.10, 35);
        array[1] = new Collaborator("Sarah A. Levy", "desiner", "gSarahLevy@gmail.com", "+79268272984", 95002.20, 25);
        array[2] = new Collaborator("Dvora A. Levy", "teacher", "gDvoraLevy@gmail.com", "+79268273985", 97003.25, 27);
        array[3] = new Collaborator("Jacob S. Levy", "mama", "gJacobLevy@gmail.com", "+75005041020", 80004.46, 65);
        array[4] = new Collaborator("Rachel K. Levy", "daddy", "gRachelLevy@gmail.com", "+75005051026", 70006.17, 61);
        array[5] = new Collaborator(array[0]);
        array[5].setFullname("Sarah O'Connor");
        array[5].setFunction("defender");
        array[5].setEmail("SarahConnor@SkyNet.com");
        array[5].setPhonenumber("+15005000001");
    }

    /**
     * Вывод в консоль
     *
     * @param array Collaborator[]
     */
    private static void showTable(Collaborator[] array) {
        System.out.printf("\nТаблица Collaborator\n%-4s%-25s%-20s%-30s%-20s%-13s%-10s\n", "ID", "Полное имя", "Должность", "E-mail", "Телефон", "Зарплата", "Возраст");
        for (Collaborator row : array)
            row.getCollaborator();
    }

    /**
     * Вывод в консоль при условии, что возраст > age
     *
     * @param array Collaborator[]
     * @param age   int
     */
    private static void showTable(Collaborator[] array, int age) {
        System.out.printf("\nВыборка по параметру (возраст > %-2d)\n%-4s%-25s%-20s%-30s%-20s%-13s%-10s\n", age, "ID", "Полное имя", "Должность", "E-mail", "Телефон", "Зарплата", "Возраст");
        for (Collaborator row : array)
            row.getCollaborator(age);
    }

    /**
     * Увеличить зарплату сотрудникам старше age на raise рублей
     *
     * @param array Collaborator[]
     * @param age   int
     * @param raise double
     */
    private static void raiseSalary(Collaborator[] array, int age, double raise) {
        System.out.printf("\nУвеличиваю зарплату сотрудникам старше %d лет на %.2f руб", age, raise);
        for (Collaborator row : array) {
            row.increaseSalary(raise, age);
        }
        System.out.println("... ВЫПОЛНЕНО.");
    }

    /**
     * Вернуть среднее значение элементов в массиве
     *
     * @param array int[]
     * @return float
     */
    private static float averageValue(int[] array) {
        float sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (sum / array.length);
    }

    /**
     * Вернуть среднее значение элементов в массиве (float)
     *
     * @param array double[]
     * @return double
     */
    private static double averageValue(double[] array) {
        double sum = 0;
        for (double i : array) {
            sum += i;
        }
        return (sum / array.length);
    }

    /**
     * Возвращает средний возраст
     *
     * @param array Collaborator[]
     */
    private static void showAverageAge(Collaborator[] array) {
        final int quantity = array.length;
        int[] a = new int[quantity];
        for (int i = 0; i < quantity; i++)
            a[i] = array[i].getAge();
        System.out.printf("\nСредний возраст сотрудников в таблице равен %.2f годам.", averageValue(a));
    }

    /**
     * Возвращает среднюю зарплату
     *
     * @param array Collaborator[]
     */
    private static void showAverageSalary(Collaborator[] array) {
        final int quantity = array.length;
        double[] a = new double[quantity];
        for (int i = 0; i < quantity; i++)
            a[i] = array[i].getSalary();
        System.out.printf("\nСредняя зарплата сотрудников в таблице равна %.2f рублей.", averageValue(a));
    }

    /* Точка входа */
    public static void main(String[] args) {
        /* Массив сотрудников */
        Collaborator[] array = new Collaborator[6];

        /* у нас будет массив по типу Collaborator (альтернатива) */
//        Collaborator[] array = {
//                new Collaborator("David A. Levy", "engener", "gDavidLevy@gmail.com", "+79268277983", 90001.10, 35),
//                new Collaborator("Sarah A. Levy", "desiner", "gSarahLevy@gmail.com", "+79268277984", 95002.20, 25),
//                new Collaborator("Dvora A. Levy", "teacher", "gDvoraLevy@gmail.com", "+79268277985", 97003.25, 27),
//                new Collaborator("Jacob S. Levy", "mama", "gJacobLevy@gmail.com", "+75005001020", 80004.46, 65),
//                new Collaborator("Rachel K. Levy", "daddy", "gRachelLevy@gmail.com", "+75005001026", 70006.17, 61),
//                new Collaborator("Sarah O'Connor", "defender", "SarahConnor@SkyNet.com", "+15005000001", 90001.10, 35)
//        };

        /* Инициализация массива значениями */
        initTable(array);

        /* Показать всю таблицу в консоле */
        showTable(array);

        /* Вывод в консоль при условии, что возраст больше 40 */
        showTable(array, 40);

        /* Увеличить зарплату сотрудникам старше 45 на 5000,00 рублей */
        raiseSalary(array, 45, 5000.00);
        showTable(array, 45);

        /* Показать всю таблицу в консоле */
        showTable(array);

        /* Средний возраст */
        showAverageAge(array);

        /* Средняя зарплата */
        showAverageSalary(array);
    }
}