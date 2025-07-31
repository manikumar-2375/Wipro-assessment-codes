package wipro;

enum Currency {
    ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
}

public class Wipro_27 {

	public static void main(String[] args) {
		
        for (Currency note : Currency.values()) {
            System.out.println("Currency: " + note);

            switch (note) {
                case ONE:
                    System.out.println("→ ₹1 note - Rarely used now.");
                    break;
                case FIVE:
                    System.out.println("→ ₹5 note - Green in color.");
                    break;
                case TEN:
                    System.out.println("→ ₹10 note - Commonly used in orange or chocolate color.");
                    break;
                case TWENTY:
                    System.out.println("→ ₹20 note - Yellowish in color.");
                    break;
                case FIFTY:
                    System.out.println("→ ₹50 note - Blue in color with Mahatma Gandhi image.");
                    break;
                case HUNDRED:
                    System.out.println("→ ₹100 note - Lavender color, widely accepted.");
                    break;
                default:
                    System.out.println("→ Unknown currency.");
            }

            System.out.println(); 
        }

	}

}
/*Currency: ONE
→ ₹1 note - Rarely used now.

Currency: FIVE
→ ₹5 note - Green in color.

Currency: TEN
→ ₹10 note - Commonly used in orange or chocolate color.

Currency: TWENTY
→ ₹20 note - Yellowish in color.

Currency: FIFTY
→ ₹50 note - Blue in color with Mahatma Gandhi image.

Currency: HUNDRED
→ ₹100 note - Lavender color, widely accepted.

*/