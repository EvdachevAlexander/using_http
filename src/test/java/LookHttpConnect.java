
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import resources.InteractionsHttp;
import resources.ParseHttp;
import static org.junit.Assert.*;


public class LookHttpConnect {

    private static InteractionsHttp interactionsHttp = null;
    private static ParseHttp parseHttp = null;

    private String correct_url = "https://en.wikipedia.org/w/index.php?search=horse";
    private String uncorrect_url = "https://en.wikipedia.org/w/index.php?search=hores";

    @BeforeClass
    public static void Start(){
        interactionsHttp = new InteractionsHttp();
        parseHttp = new ParseHttp();
    }

    @Test
    public void goToThePageAboutThe_Horse() {
        interactionsHttp.execute_get_on_url(correct_url);

        assertEquals(interactionsHttp.get_status_code(), 200);

        parseHttp.get_html_on_response(interactionsHttp.getResponse());

        assertEquals("открыта неверная страница", parseHttp.get_values_on_elementById("firstHeading"), "Horse");
    }

    @Test
    public void goToThePageAboutThe_Hores() {
        interactionsHttp.execute_get_on_url(uncorrect_url);

        assertEquals(interactionsHttp.get_status_code(), 200);

        parseHttp.get_html_on_response(interactionsHttp.getResponse());

        assertEquals("открыта неверная страница", parseHttp.get_values_on_elementById("firstHeading"), "Search results");
    }

    @AfterClass
    public static void FinishEnd() {
        interactionsHttp.close_conect();
    }
}
