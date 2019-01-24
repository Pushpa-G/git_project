import java.io.*;
import java.util.StringTokenizer;

class person
{
	static int SIZE = 100;
	String name;
	String Email;
	int emp_id;
	String[] marks = new String[SIZE];
	double total = 0;
} 

public class sample
{
	public static void main(String args[]) throws IOException
	{
		int n = args.length;
		String fname = "CR-24.txt";
		String infofile = "CR-24.inf";
		String htmfile = "CR-24.htm";	
			if (n == 2) {
				if (args[0].equals("-b"))
					fname = args[1];
				else if (args[0].equals("-l"))
					infofile = args[1];
				else if (args[0].equals("-o"))
					htmfile = args[1];
			}
			else if (n == 4) {
				if (args[0].equals("-b")) {
					fname = args[1];
					if (args[2].equals("-l"))
						infofile = args[3];
					else if (args[2].equals("-o"))
						htmfile = args[3];
				}
				else if (args[0].equals("-l")) {
					infofile = args[1];
					if (args[2].equals("-b"))
						fname = args[3];
					else if (args[2].equals("-o"))
						htmfile = args[3];
				}
				else if (args[0].equals("-o")) {
					htmfile = args[1];
					if (args[2].equals("-b"))
                                                fname = args[3];
                                        else if (args[2].equals("-l"))
                                                infofile = args[3];
				}
			}
			else if (n == 6) {
				if (args[0].equals("-b")) {
					fname = args[1];
					if (args[2].equals("-l")) {
						infofile = args[3];
						if (args[4].equals("-o")) 
							htmfile = args[5];
					}
					else if (args[2].equals("-o")) {
						htmfile = args[3];
						if (args[4].equals("-l"))
							infofile = args[5];
					}
				}
				else if(args[0].equals("-l")) {
					infofile = args[1];
					if (args[2].equals("-b")) {
						fname = args[3];
						if (args[4].equals("-o"))
							htmfile = args[5];
					}
					else if (args[2].equals("-o")) {
						htmfile = args[3];
						if (args[4].equals("-b"))
							fname = args[5];
					}
				}
				else if(args[0].equals("-o")) {
					htmfile = args[1];
					if (args[2].equals("-b")) {
						fname = args[3];
						if (args[4].equals("-l"))
							infofile = args[5];
					}
					else if (args[2].equals("-l")) {
						infofile = args[3];
						if (args[4].equals("-b"))
							fname = args[5];
					}
				}
			}
		FileReader fin = new FileReader(fname);
                BufferedReader buf = new BufferedReader(fin);
		FileReader fin2 = new FileReader(infofile);
		BufferedReader buf2 = new BufferedReader(fin2);
		FileWriter fout = new FileWriter(htmfile);
		performance ob1 = new performance();
		ob1.perform(buf, buf2, fout);
		fin.close();
		fin2.close();
                fout.close();

	}
}
class performance
{
	 int maxMarks = 0;
                int minMarks = 9999;
                int maxwho;
                int minwho;

	void perform(BufferedReader buf, BufferedReader buf2, FileWriter fout)throws IOException
	{	
		person[] p = new person[10];
           	int totalNumOfPerson = 0;
           	int numOfSubject = 0;
		
		int[] toper = new int[100];
		int[] lager = new int[50];
		int j = 0,k = 0,l;
		String c;
		String b;
                String tok;
		String[] s = new String[10];
                int i = 0;
		b = buf2.readLine();
		
		System.out.println(b);
		StringTokenizer sts = new StringTokenizer(b,",");
	   	while (sts.hasMoreTokens()) { 
				tok = sts.nextToken();
				if ( i >=3) {
					s[numOfSubject] =tok;
					System.out.println(tok);
					 numOfSubject++;
				}
					
				i++;
		}
		for( i =0; i < numOfSubject; i++) 
		System.out.println(s[i]);
		int[] max = new int[numOfSubject];
		b = buf2.readLine();
		System.out.println(b);
		 sts = new StringTokenizer(b,",");
	   	while (sts.hasMoreTokens()) {  
      			 	tok = sts.nextToken();
				if ( i > 2)
					 max[k++] = Integer.parseInt(tok);
				i++;
		}
		System.out.println(numOfSubject);
		for ( i = 0; i < numOfSubject;i++)
			System.out.println(max[i]);
		c = buf.readLine();
		System.out.println(c);
		
		fout.write(c);
		fout.write("<!DOCTYPE>\n<html>\n<head>\n\t<title>\n \t\tPerfomance\n\t</title>\n\t<style>\n\t\tbody");
		fout.write("\t{background-color:#abffe3;}\n \t\th1  \t {background-color:#cccccc;text-align:center;color:white}\n");
        	fout.write("\t\tp\t    {color: red;}\n\t\ttable, th, td \t{border: 1px solid black;align:center;}\n\t\tth \t{color:darkred;}\n\t</style>\n</head>");
		for ( i= 0; i < p.length; i++)
			p[i] = new person();	
		c = buf.readLine();
		for ( i = 0;c != null; i++) {
			StringTokenizer st = new StringTokenizer(c,",");
			j =0;
                        k = 0;
	   		while (st.hasMoreTokens()) {  
      			 	tok = st.nextToken();
				
				if ( j == 0) {
					p[i].emp_id = Integer.parseInt(tok);
				fout.write("\n\t<p><h3 style='color:blue;'><a href = '#"+p[i].emp_id+"'");
				fout.write(" name = '"+p[i].emp_id+"'>Employement Number  :"+p[i].emp_id+"</a></h3></p>\n");
				}
				else if( j == 1) {
					p[i].name = tok;
					 fout.write("\n\t<h3 style='color:blue;'>Employement Name  :"+p[i].name+"</h3>\n");
				}
				else if (j == 2) {
					p[i].Email = tok;
					fout.write("\n\t<h3 style='color:blue;'>Email id	:<a href='mailto:'>"+p[i].Email+"</a></h3>\n");
				}
				else if (j >=3) {
						p[i].marks[k++] = tok;
						 
	 			}
				j++;

    			 }
			 fout.write( "\t<table width='1200px'>\n\t\t<tr>\n");

                        for ( l = 0; l < numOfSubject; l++) /* used to print the header of the table as subject*/
                        fout.write( "\t\t\t<th>"+s[l]+"/"+max[l]+"</th>\n");
                        fout.write("\t\t\t<th> Total</th>\n\t\t</tr>\n\t\t<tr>");

                        for(l = 0; l < numOfSubject; l++) {/* used to print the indivisual marks*/
				if ( p[i].marks[l] == null || (p[i].marks[l].equalsIgnoreCase("A")) || p[i].marks[l].equalsIgnoreCase("-1")) 
                                	fout.write( "\n\t\t\t<td style='background-color:red;color:white;'> A </td>");
				else
				{
					System.out.println("marks"+p[i].marks[l]);
					double val = Double.parseDouble(p[i].marks[l]);
					if ( val <= max[l]) {
						double num = ((val/max[l])*100);
						p[i].total = p[i].total+Double.parseDouble(p[i].marks[l]);
						System.out.println("here"+num);
						if ( num <= 50.000000) {
							System.out.println(num);
                                			fout.write( "\n\t\t\t<td style='background-color:red;color:white;'>"+ p[i].marks[l]+"</td>");
						}
						else if ( num > 50.000000 && num <= 60.000000) {
					  	   System.out.println(num);
                               		  	   fout.write( "\n\t\t\t<td style='background-color:ORANGE;color:black;'>"+ p[i].marks[l]+"</td>");
						}
						else if ( num > 60.000000 && num <= 65.000000) {
					 	  System.out.println(num);
                                	 	  fout.write( "\n\t\t\t<td style='background-color:YELLOW;color:black;'>"+ p[i].marks[l]+"</td>");
						}
						else if ( num > 65.000000) {
					 	  System.out.println(num);
                                	 	  fout.write( "\n\t\t\t<td style='background-color:green;color:white;'>"+ p[i].marks[l]+"</td>");
						}
					}
					else
						 fout.write( "\n\t\t\t<td style='background-color:black;color:red;'>"+ p[i].marks[l]+" Error</td>");
				}
                        }
                        fout.write( "\n\t\t\t<td>"+p[i].total+"</td>\n\t\t</tr>\n\t</table>");/* used to print the total mark of the particular person*/

			c = buf.readLine();

		}  
		totalNumOfPerson = i;
	 	fout.write( "\n\t<br><hr><br>\n\t<table width='1200px'>\n\t\t<caption><h1><a href = '#summary' name = 'summary'>summary</a></h1></caption>\n\t\t<tr>\n\t\t\t<th>Particulars</th>\n");
    		for (j = 0; j < numOfSubject;j++)
        		fout.write("\t\t\t<th> "+s[j]+"/"+max[j]+"</th>\n");
        	fout.write("\t\t</tr>\n\t\t<tr style='color:green;'>\n\t\t\t<td>Toppers</td>\n");
       		 for (j = 0; j < numOfSubject;j++) {/* used to find the toper*/
                	for(i = 0; i < totalNumOfPerson; i++) {
			  if((p[i].marks[j].equalsIgnoreCase("-1")) || (p[i].marks[j].equalsIgnoreCase("A")) || (p[i].marks[j] == null)) {}
			  else{		
					int num = Integer.parseInt(p[i].marks[j]);
					if ( num <= max[j]) {
                        			if (maxMarks < num) {
                                			maxMarks = num;
                             		  		maxwho = i;
						}
					}
					
                       		 }
               		 }
           	 	toper[j] = maxwho;
                	fout.write( "\n\t\t\t<td>"+p[maxwho].name);
              		for(i = 0; i < numOfSubject; i++) {/* used to find more than one person has same marks*/
			if( (p[i].marks[j] != null)){
			    if((p[i].marks[j].equalsIgnoreCase("-1")) || (p[i].marks[j].equalsIgnoreCase("A"))) { }
                       	   else {
				if ((maxMarks == Integer.parseInt(p[i].marks[j]))  && (i != maxwho)) {
                                	fout.write( "<br>"+p[i].name);
                       		}
				}
			}
			
               		}
               		fout.write( "</td>");
               		maxMarks = 0;
    		}

        	fout.write("\n\t\t</tr>\n\t\t<tr style='color:red;'>\n\t\t\t<td>Lagers</td>\n");
        	for (j = 0; j < numOfSubject; j++) {/* used to find the lager*/
               		 for(i = 0;i < totalNumOfPerson; i++) {
			   if((p[i].marks[j].equalsIgnoreCase("-1")) || (p[i].marks[j].equalsIgnoreCase("A")) || (p[i].marks[j] == null)) {}
			   else{
					 int num = Integer.parseInt(p[i].marks[j]);
                       		 	 if (minMarks > num) {
                              		  	minMarks = num;
                               		 	 minwho = i;
                        		}
               			 }
			}
                	lager[j] = minwho;
                	fout.write("\n\t\t\t<td>"+p[minwho].name);
                	for(i = 0;i < totalNumOfPerson; i++) {/* used to find more than one person has same marks*/
			   if( (p[i].marks[j] != null)){
			   	if((p[i].marks[j].equalsIgnoreCase("-1")) || (p[i].marks[j].equalsIgnoreCase("A"))) { }
                       		else {
					 if (minMarks == Integer.parseInt(p[i].marks[j])  && i != minwho) {
                                	fout.write("<br>"+p[i].name);
                        	}
			}
			}
                	}
               		fout.write("</td>");
                	minMarks = 999;
       		 }
        	fout.write("\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>Max Score</td>\n");

       		for ( i = 0;i < numOfSubject; i++)/* used to find the highest marks in each subject*/
                	fout.write("\n\t\t\t<td>"+p[toper[i]].marks[i]+"</td>");

       		fout.write("\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td>Min Score</td>\n");
        	for ( i = 0;i < numOfSubject; i++)/* used to find the lowest marks in each subject*/
                	fout.write( "\n\t\t\t<td>"+p[lager[i]].marks[i]+"</td>");
       	 	fout.write( "\n\t\t\t</tr>\n\t</table>\n</body>\n</html>");

	}
}
