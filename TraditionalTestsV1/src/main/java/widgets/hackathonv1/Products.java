package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Products {

  // top banner
  private final String topBannerImage = "DIV__topbanner__187";

  // sort by
  private final String sortByContainer = "DIV__toolboxele__189";
  private final String sortByDropdown = "DIV__sortselect__193";

  // view by
  private final String gridViewIcon = "I__tiviewgrid__202";
  private final String listViewIcon = "I__tiviewlist__204";

  // listed products
  private final String product1Link = "product_1";
  private final String product1Image = "IMG__imgfluid__215";
  private final String product1Name = "A____217";
  private final String product1NewPrice = "SPAN__newprice__220";
  private final String product1OldPrice = "SPAN__oldprice__221";
  private final String product1AddToFavoritesIcon = "I__tiheart__225";
  private final String product1AddToCompareIcon = "I__ticontrols__229";
  private final String product1AddToCartIcon = "I__tishopping__233";

  private final String product2Link = "product_2";
  private final String product2Image = "IMG__imgfluid__375";
  private final String product2Name = "A____377";
  private final String product2NewPrice = "SPAN__newprice__380";
  private final String product2OldPrice = "SPAN__oldprice__381";
  private final String product2AddToFavoritesIcon = "I__tiheart__385";
  private final String product2AddToCompareIcon = "I__ticontrols__389";
  private final String product2AddToCartIcon = "I__tishopping__393";

  private final String product3Link = "product_3";
  private final String product3Image = "IMG__imgfluid__240";
  private final String product3Name = "A____242";
  private final String product3NewPrice = "SPAN__newprice__245";
  private final String product3OldPrice = "SPAN__oldprice__246";
  private final String product3AddToFavoritesIcon = "I__tiheart__250";
  private final String product3AddToCompareIcon = "I__ticontrols__254";
  private final String product3AddToCartIcon = "I__tishopping__258";

  private final String product4Link = "product_4";
  private final String product4Image = "IMG__imgfluid__264";
  private final String product4Name = "A____265";
  private final String product4NewPrice = "SPAN__newprice__268";
  private final String product4AddToFavoritesIcon = "I__tiheart__272";
  private final String product4AddToCompareIcon = "I__ticontrols__276";
  private final String product4AddToCartIcon = "I__tishopping__280";

  private final String product5Link = "product_5";
  private final String product5Image = "IMG__imgfluid__286";
  private final String product5Name = "A____287";
  private final String product5NewPrice = "SPAN__newprice__290";
  private final String product5AddToFavoritesIcon = "I__tiheart__294";
  private final String product5AddToCompareIcon = "I__ticontrols__298";
  private final String product5AddToCartIcon = "A__tooltip__301";

  private final String product6Link = "product_6";
  private final String product6Image = "IMG__imgfluid__308";
  private final String product6Name = "A____309";
  private final String product6NewPrice = "SPAN__newprice__312";
  private final String product6AddToFavoritesIcon = "I__tiheart__316";
  private final String product6AddToCompareIcon = "I__ticontrols__320";
  private final String product6AddToCartIcon = "I__tishopping__324";

  private final String product7Link = "product_7";
  private final String product7Image = "IMG__imgfluid__330";
  private final String product7Name = "A____331";
  private final String product7NewPrice = "SPAN__newprice__334";
  private final String product7AddToFavoritesIcon = "I__tiheart__338";
  private final String product7AddToCompareIcon = "I__ticontrols__342";
  private final String product7AddToCartIcon = "I__tishopping__346";

  private final String product8Link = "product_8";
  private final String product8Image = "IMG__imgfluid__352";
  private final String product8Name = "A____353";
  private final String product8NewPrice = "SPAN__newprice__356";
  private final String product8AddToFavoritesIcon = "I__tiheart__360";
  private final String product8AddToCompareIcon = "I__ticontrols__364";
  private final String product8AddToCartIcon = "I__tishopping__368";

  private final String product9Link = "product_9";
  private final String product9Image = "IMG__imgfluid__399";
  private final String product9Name = "A____400";
  private final String product9NewPrice = "SPAN__newprice__403";
  private final String product9AddToFavoritesIcon = "I__tiheart__407";
  private final String product9AddToCompareIcon = "I__ticontrols__411";
  private final String product9AddToCartIcon = "I__tishopping__415";

  public String getProduct1Link() {
    return product1Link;
  }

  public String getProduct1Image() {
    return product1Image;
  }

  public String getProduct1Name() {
    return product1Name;
  }

  public String getProduct1NewPrice() {
    return product1NewPrice;
  }

  public String getProduct1OldPrice() {
    return product1OldPrice;
  }

  public String getProduct1AddToFavoritesIcon() {
    return product1AddToFavoritesIcon;
  }

  public String getProduct1AddToCompareIcon() {
    return product1AddToCompareIcon;
  }

  public String getProduct1AddToCartIcon() {
    return product1AddToCartIcon;
  }

  public String getProduct8Link() {
    return product8Link;
  }

  public String getProduct8Image() {
    return product8Image;
  }

  public String getProduct8Name() {
    return product8Name;
  }

  public String getProduct8NewPrice() {
    return product8NewPrice;
  }

  public String getProduct8AddToFavoritesIcon() {
    return product8AddToFavoritesIcon;
  }

  public String getProduct8AddToCompareIcon() {
    return product8AddToCompareIcon;
  }

  public String getProduct8AddToCartIcon() {
    return product8AddToCartIcon;
  }

  public HashMap<String, String> getAllProductElements() {
    HashMap<String, String> productElements = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        productElements.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(Products.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return productElements;
  }
}
