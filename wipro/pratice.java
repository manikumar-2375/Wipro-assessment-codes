package wipro;

public class pratice {

	public static void main(String[] args) {
		
		if (12 > 2)
		{
			if (34 < 2) 
			{
				System.out.println("Inner If block is bigger!");
			} 
			else {
				System.out.println("Inner if..else block");
			}
		} else {
			System.out.println("Over!!");
		}

		// while loop=>ENTRY CONTROLLED LOOP
		int i = 1;
		while (i <= 6) {
			System.out.print(i + " ");
			i++;
		}

		//dowhile loop=>EXIT CONTROLLED LOOP
				int j=100;
				do
				{
					System.out.print("\n"+j);
					j++;
				}while(j>=150);

				System.out.println();// newline
				
				//for loop
				for(int k=0;k<=5;k++)
				{
					System.out.print(" "+k);
				}
				
				System.out.println("For Loop Without Increment::");
				int k=1;
				for(k=2;k<=5;)
				{
					System.out.print(k+ " ");
					k++;
				}

				System.out.println("\nFor Loop Contains SOP");
				//{} IS MISSING INSTEAD OF THAT ;
				for(int j1=1;j1<=5;System.out.print(" "+j1++));
				
				for(int y1=-1,y2=51;y1<=5&&y2>0;y1++,y2--)
				{
					System.out.println(y1+ " "+y2);
				}

				System.out.println("Break Keyword::");
				for(int u1=1;u1<=5;u1++)
				{
				if (u1==3)			
				{
					break;//terminate the current loop
				}
				System.out.print(u1 + " ");
				}
				System.out.println("Stop!");
				
				/*
				 * difference between break and continue is that the break exits a loop at once. 
				 * Once a break statement is executed, the loop will not run again. 
				 * However, after executing the continue statement, the following lines of code will be 
				 * skipped for the current iteration only. The loop will begin to execute again.
				 * 
				 */

				System.out.println("Continue Keyword::");
				for(int u1=1;u1<=5;u1++)
				{
				if (u1==3)			
				{
					continue;//skip the remaining part of the loop but continue the iteration
				}
				System.out.print(u1 + " ");
				}
				System.out.println("Done!");
				
				//conditional operator or ternary operator(?:)
				//alternative of if..else

				int r=40,y=20;
				String res=(r>y)?r+ " is bigger ":y+ " is smaller";
				System.out.println("Ternary:: "+res);


				//nested ternary operator
				int a4=78,b4=734,c4=400,largest;
				largest=a4>b4?(a4>c4?a4:c4):(b4>c4?b4:c4);
				System.out.println("Largest:"+largest);


				/*
				 * Switch case::
				 * --Menu based model
				 * --looks like if..else
				 * --byte,short,int,char,String supported
				 * --case value must be unique
				 * --float and double are not supported
				 * --default block is optional
				 */
				int no=20;
				String rating="";
				switch(no)
				{
				default:
					System.out.println("Invalid option!");
					break;
				case 8:
						rating="good";
						break;
				case 101:
						rating="Excellent";
						break;
						//2 case contains same logic
						//empty case!!!no break keyword
				
				case 10333:
					rating="Nice";
					break;
				case 20:
						//break;	
			}
			System.out.println("Rating:: "+rating);

	}

}
