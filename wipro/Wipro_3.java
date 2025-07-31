package wipro;

public class Wipro_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int total_students = 90;
		int total_boys = 45;
		int total_Grade_A = total_students /2;
		int grade_A_boys = 20;
		
		int grade_A_girls = total_Grade_A - grade_A_boys;
		
		System.out.println(grade_A_girls);
	}

}
//Output: Total number of girls who got grade A: 25
