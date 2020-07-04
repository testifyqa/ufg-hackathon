package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Filters {

  // filter sidebar
  private final String filtersSidebar = "sidebar_filters";
  public final String openFiltersSidebar = "A__openfilter__206";

  // type filters
  private final String typeFilterSection = "A__opened__75";
  private final String typeSoccerCheckbox = "type__Soccer";
  private final String typeBasketballCheckbox = "type__Basketball";
  private final String typeRunningCheckbox = "type__Running";
  private final String typeTrainingCheckbox = "type__Training";

  // color filters
  private final String colorFilterSection = "A__opened__100";
  public final String colorBlackCheckbox = "colors__Black";
  private final String colorWhiteCheckbox = "colors__White";
  private final String colorBlueCheckbox = "colors__Blue";
  private final String colorGreenCheckbox = "colors__Green";
  private final String colorYellowCheckbox = "colors__Yellow";

  // brand filters
  private final String brandFilterSection = "A__opened__130";
  private final String brandAdibasCheckbox = "brands__Adibas";
  private final String brandMykeyCheckbox = "brands__Mykey";
  private final String brandBansCheckbox = "brands__Bans";
  private final String brandOverArmourCheckbox = "brands__OverArmour";
  private final String brandImBalanceCheckbox = "brands__ImBalance";

  // price filters
  private final String priceFilterSection = "A__opened__160";
  private final String price0to50Checkbox = "price__$0-$50";
  private final String price50to100Checkbox = "price__$50-$100";
  private final String price100to150Checkbox = "price__$100-$150";
  private final String price150to500Checkbox = "price__$150-$500";

  // filter buttons
  public final String filterButton = "filterBtn";
  private final String resetButton = "resetBtn";

  public HashMap<String, String> getAllFilters() {
    HashMap<String, String> filterElements = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        filterElements.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(Filters.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return filterElements;
  }
}
