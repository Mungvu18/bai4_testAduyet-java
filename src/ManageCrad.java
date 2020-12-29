import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ManageCrad {
    Map<String, Card> cardMapLists = new TreeMap<>();
    Set<String> keyList = cardMapLists.keySet();
    public void addNew(String cardId, Card card) {
        cardMapLists.put(cardId, card);
    }
    public void showAll(){
        for (String key : keyList) {
            Card card = cardMapLists.get(key);
            System.out.println(card);
        }
    }
    public void displayById(String cardId) {
        for (String key : keyList) {
            boolean testCardId = key.equals(cardId);
            if (testCardId) {
                System.out.println(cardMapLists.get(key));
                return;
            }
        }
        System.out.println("Not exit");
    }
    public void testReturnDay(){
        boolean testDayOfMonth = false;
        for (String key: keyList) {
            Card card = cardMapLists.get(key);
            String returnDay = card.getReturnDay();
            String day = returnDay.substring(0,2);
            String lastDayOfMonth = takeLastDayOfMonth(returnDay);
            testDayOfMonth = day.equalsIgnoreCase(lastDayOfMonth);
            if(testDayOfMonth){
                System.out.println(card);
            }
        }
        if (!testDayOfMonth) System.out.println("Not exits");
    }
    public String takeLastDayOfMonth(String returnDay) {
        String month = returnDay.substring(3, 5);
        int year = Integer.parseInt(returnDay.substring(6, 10));
        String lastDayOfMonth = "";
        switch (month) {
            case "01":
            case "03":
            case "05":
            case "07":
            case "08":
            case "10":
            case "12":
                lastDayOfMonth = "31";
                break;
            case "04":
            case "06":
            case "09":
            case "11":
                lastDayOfMonth = "30";
                break;
            case "02":
                boolean isLeapYear = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
                if (isLeapYear) {
                    lastDayOfMonth = "29";
                } else lastDayOfMonth = "28";
                break;
        }
        return lastDayOfMonth;
    }
}
