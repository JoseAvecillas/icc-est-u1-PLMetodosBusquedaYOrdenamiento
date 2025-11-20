import controllers.SearchMethods;
import controllers.SortingMethods;
import view.*;
import controllers.*;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Nombre: Jose Avecillas");

            View view = new View();
            SortingMethods sm = new SortingMethods();
            SearchMethods scm = new SearchMethods();

            Controller controller = new Controller(view, sm, scm);
            controller.start();

    }
}
