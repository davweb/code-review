import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.StringTokenizer;

public class validateCsv {

    public validateCsv() {
        // TODO Auto-generated constructor stub
    }

    static public void main(String[] arg1) {

        CsvReader reader = new CsvReader();

        try {
            List csv = reader.parseCSV(arg1[0]);
            System.out.println("CSV " + arg1[0] + " contains " + csv.size() + " data records");
        } catch (Exception e) {
            System.out.println("Could not parse CSV file " + arg1[0]);
        }

    }

    static class CsvReader {

        //Contents of CSV file
        List content;

        public List parseCSV(String fileName) throws Exception {
            BufferedReader fios = new BufferedReader(new FileReader(fileName));

            String inputLine;

            //Read each line from the file
            while((inputLine = fios.readLine()) != null) {
                fios.readLine();
                StringTokenizer tokenizer = new StringTokenizer(inputLine, ",");
                Object[] lineItems = new String[tokenizer.countTokens()];
                int count = 0;

                int firstToken = Integer.parseInt(tokenizer.nextToken(","));

                boolean isComment = false;

                //Check the type of the record
                switch(firstToken) {
                    case 0:
                    //Indicates comment record
                        isComment = true;
                case 1:
                    //Indicates data record
                }

                if(!isComment) {
                    while(tokenizer.hasMoreTokens()) {
                        lineItems[count] = tokenizer.nextToken(",");
                    }
                }
                content.add(lineItems);
            }
            return content;
        }
    }
}