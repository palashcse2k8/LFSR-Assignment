import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Struct;
import java.util.Scanner;

public class LFSRTestPatternGenerator {
	
	public static String fsimLocation = "C:/bin/";

	public static String command = "fsim.exe -t test_pattern.txt c17.bench";
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int optionChoser;
        int numberOfPattern;
        
        while (true) {
            System.out.println("\n\nSelect circuit to test\n");
            String [] files = showOptions();
        	optionChoser = sc.nextInt();
        	
        	String optionChosen = files[optionChoser-1];
        	
        	System.out.println("Enter number of pattern to generate for "+ optionChosen + " circuit: ");
        	numberOfPattern = sc.nextInt();
        	
            
            switch (optionChosen) {
      
    		case "c1355.bench":
    			int numberOfBits = 41;
    			//numberOfTest = 16, coverage = 
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {41,40,39,38}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    			
    		case "c17.bench":
    			numberOfBits = 5;
    			//numberOfTest = 14, coverage = 100
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {5,4,3,2}) , numberOfPattern);
    			executeCommand(optionChosen);
    			break;
    			
    		case "c1908.bench":
    			numberOfBits = 33;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {33,32,29,27}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    		case "c2670.bench":
    			numberOfBits = 233;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {233,232,229,224}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    			
    		case "c3540.bench":
    			numberOfBits = 50;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {50,48,47,46}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;

    		case "c432.bench":
    			numberOfBits = 36;
    			//numberOfTest = 450
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits,  new int [] {36,35,29,28}), numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    			
    		case "c499.bench":
    			numberOfBits = 41;
    			//numberOfTest = 450
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits,  new int [] {41,40,39,38}), numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    			
    		case "c5315.bench":
    			numberOfBits = 178;
    			//numberOfTest = 450
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits,  new int [] {178,176,171,170}), numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    			
    		case "c6288.bench":
    			numberOfBits = 32;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {32,30,26,25}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    		case "c7552.bench":
    			numberOfBits = 207;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {207,206,201,198}) , numberOfPattern);
    			executeCommand(optionChosen);
    			
    			break;
    		case "c880.bench":
    			
    			numberOfBits = 60;
    			//numberOfTest = 16
    	        System.out.println("\nGenerating test pattern... ");
    			generateTestPattern(numberOfBits, generateInitialStateString(numberOfBits), generatePolyBinary(numberOfBits, new int [] {60,58,56,55}) , numberOfPattern);
    			executeCommand(optionChosen);
    			break;
    			
    		default:
    			break;
    		} 
        }
        
        
    }
    
    public static String generateInitialStateString(int numDigits) {
        StringBuilder binaryString = new StringBuilder();

        // Append '1' numDigits times
        for (int i = 0; i < numDigits; i++) {
            binaryString.append('1');
        }
        
//        System.out.println("Initial State: " + binaryString.toString());

        return binaryString.toString();
    }

    public static String generatePolyBinary(int numberofBits, int [] tapbits) {
    	
    	System.out.print("Tapping bits are ->");
    	for (int i = 0; i < tapbits.length; i++) {
    		if(i == (tapbits.length-1))
    			System.out.print(" x^" + tapbits[i] + " + 1\n");
    		else
    			System.out.print(" x^" + tapbits[i] + " +");
		}
    	System.out.print("");
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("1");
    	
    	for (int i = 1; i <= numberofBits; i++) {
    		
    		boolean match = false;
    		
    		for (int j = 0; j < tapbits.length; j++) {
				if (i==tapbits[j]) {
					match = true;
					break;
				}
			}
    		if(match == true)
    			stringBuilder.append("1");
    		else
    			stringBuilder.append("0");
		}  
//    	
//    	System.out.println("primitivePoly > " + stringBuilder);
    	return stringBuilder.toString();
    
    }
    
    public static void executeCommand (String circuitName) {
    
        String command = fsimLocation + "fsim.exe -t test_pattern.txt " + circuitName;
        System.out.println("\nExecuting tests: " + command);
        
        ProcessBuilder builder = new ProcessBuilder(
        		fsimLocation+"fsim.exe", "-t", "test_pattern.txt", circuitName);
   
            builder.redirectErrorStream(true);
            
            // Set the working directory to fsimLocation
            builder.directory(new File(fsimLocation));
            Process p = null;
			try {
				p = builder.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                try {
					line = r.readLine();
	                if (line == null) { break; }
	                if(line.contains("Fault coverage")) {
	                	System.out.println(line);
	                }
	                
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
    }
    
    public static void generateTestPattern(int numberOfBit, String initialState, String primitivePoly, int numberOfTest) {
    	
        // Create an LFSR with the specified parameters
        LFSR lfsr = new LFSR(numberOfBit, primitivePoly, initialState);
        // Generate test patterns and write to a file
        System.out.println("Number of Bits: " + numberOfBit);
        System.out.println("Initial State: " + initialState);
       
        System.out.println("Primitive Polynomial: " + primitivePoly);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fsimLocation + "test_pattern.txt"));
            
            for (int i = 0; i < numberOfTest; i++) {  // Generate 100 test patterns
                String pattern = lfsr.generatePattern();
                while (pattern.length() < numberOfBit) {
                    pattern = "0" + pattern;  // Pad with leading zeros to ensure it's 8 bits
                }
                writer.write(i + 1 +": " + pattern + "\n");
            }
            
            writer.close();
            System.out.println( numberOfTest + " Test patterns written to the file test_pattern.txt");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String[] showOptions()
    {
    	File [] filesInDirectory = getNewTextFiles(fsimLocation);
    	String [] files = new String [filesInDirectory.length];
    	
    	for (int i = 0; i < filesInDirectory.length; i++) {
    		
    		files[i] = filesInDirectory[i].getName();
    		
			System.out.println((i+1) + " : " + files[i]);
		}
    	
    	return files;
    }
    
    private static File[] getNewTextFiles(String directoryName) {
    	File dir = new File(directoryName);
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".bench");
            }
        });
    }
}

class LFSR {
    private int numBits;
    private BigInteger state;
    private BigInteger primitivePoly;

    public LFSR(int numBits, String primitivePoly, String initialState) {
        this.numBits = numBits;
        this.state = new BigInteger(initialState, 2);
        this.primitivePoly = new BigInteger(primitivePoly, 2);
    }

    public String generatePattern() {
        StringBuilder pattern = new StringBuilder();

            // Get the rightmost bit as the output
            boolean outputBit = state.testBit(0);
            pattern.append(outputBit ? '1' : '0');

            // Calculate the feedback bit
            BigInteger feedback = BigInteger.ZERO;
            for (int bit = 0; bit < numBits; bit++) {
                if (primitivePoly.testBit(bit)) {
                    feedback = feedback.xor(state.shiftRight(bit).and(BigInteger.ONE));
                }
            }

            // Shift the state and set the feedback bit as the MSB
            state = state.shiftRight(1).or(feedback.shiftLeft(numBits - 1));

        return state.toString(2);
    }
}
