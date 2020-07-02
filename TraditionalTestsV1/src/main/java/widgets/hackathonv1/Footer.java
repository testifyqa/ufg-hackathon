package widgets.hackathonv1;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Footer {

  // footer
  private final String footer = "FOOTER____417";

  // footer - quick links
  private final String quickLinksHeader = "H3____421";
  private final String aboutUsQuickLink = "A____425";
  private final String faqQuickLink = "A____427";
  private final String helpQuickLink = "A____429";
  private final String myAccountQuickLink = "A____431";
  private final String blogQuickLink = "A____433";
  private final String contactsQuickLink = "A____435";

  // footer - contacts
  private final String contactsHeader = "H3____437";
  private final String contactAddress = "LI____440";
  private final String contactEmailAddress = "LI____443";

  // footer - keep in touch
  private final String keepInTouchHeader = "H3____447";
  private final String yourEmailField = "email_newsletter";

  // footer - selectors
  private final String languageSelector = "DIV__styledsele__459";
  private final String currencySelector = "DIV__styledsele__466";

  // footer - legal
  private final String termsAndConditionsLink = "A____473";
  private final String privacyLink = "A____475";
  private final String copyrightInfo = "SPAN____477";

  public HashMap<String, String> getAllFooterElements() {
    HashMap<String, String> footerElements = new HashMap<>();
    for (Field field : getClass().getDeclaredFields()) {
      try {
        footerElements.put(field.getName(), (String) field.get(this));
      } catch (IllegalAccessException e) {
        Logger log = LoggerFactory.getLogger(Footer.class.getName());
        log.error(" :: Attempt to access field was illegal -> " + e.getMessage());
      }
    }
    return footerElements;
  }
}
