

import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   public void testManualTest()
   {
	   UrlValidator urlValidator = new UrlValidator();
	   
	   ResultPair testcase = new ResultPair("ftp:///////",false);
	   assertEquals(testcase.item, testcase.valid, urlValidator.isValid(testcase.item));
	   
	   assertEquals("ftp://foo.bar.com/", urlValidator.isValid("ftp://foo.bar.com/"),true);
	   assertEquals("https://google.com/&q=hi", urlValidator.isValid("https://google.com/&q=hi"),true);
	   assertEquals("http://example.com/test/hi.pdf", urlValidator.isValid("http://example.com/test/hi.pdf"),true);
	   assertEquals("http://example.com/~", urlValidator.isValid("http://example.com/~"),true);
	   assertEquals("http:/not/a/url", urlValidator.isValid("http:/not/a/url"),false);
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
	   // valid urls that use HTTPS and have a query
	   UrlValidator urlValidator = new UrlValidator();
	   assertEquals("https://google.com/&q=hi", urlValidator.isValid("https://google.com/&q=hi"),true);
	   
	   String testStr1 = "https://www.google.com/search?source=hp&ei=d26tWp_rKcqOjwPYt4qADA&q=test&oq=test&gs_l=psy-ab.3..0l10.1240.1493.0.1637.5.4.0.0.0.0.98.290.4.4.0....0...1c.1.64.psy-ab..1.4.289.0..0i131k1.0.nDAQTu2IcYQ";
	   assertEquals(testStr1, urlValidator.isValid(testStr1),true);
	   
	   String testStr2 ="https://www.google.com/search?biw=958&bih=929&tbm=nws&ei=qm6tWumOGOG4jAPs1auQBg&q=TEST&oq=TEST&gs_l=psy-ab.3..0l10.2807.3076.0.4085.4.4.0.0.0.0.109.273.3j1.4.0....0...1c.1.64.psy-ab..0.4.272....0.10BL2V2nNFE";
	   assertEquals(testStr2, urlValidator.isValid(testStr2),true);
	   
	   String testStr3 ="https://www.google.com/search?tbs=sbi:AMhZZiuHtjy_1IHIiZwy-R-FseTq7ivicrKgFgqbykgJICskYxqKdXaXZdxErUyYgl1TPA5bfRnDw_10xagvNXpY6oEbB3j4jUMY2qjOA_1RNqns1D17bWLHzRqyv3NzI24Bp3L1IxQrjt1-Pbm2bBI35J63tROZH3ZIzYbSOMLb7l0EzzSbM1KDMYNqauOq6hOuFAdoaxxBRV_195Egrus8mIFFujRp3d3UBLimDLt5uT4fiGyPeddVEI9pjr-NuNV-fl4XIb_1hC8UjtoRPkvDdebD7Os5MGx-0F4PePW72gNMRz488lakexOL-pahp9TcxTbnuwov6Xdqu&btnG=Search%20by%20image&hl=en";
	   assertEquals(testStr3, urlValidator.isValid(testStr3),true);
	   
	   String testStr4 = "https://www.google.com/search?q=reaction+-+test+your+reflexes+icon&hl=en&source=lnms&tbm=shop&sa=X&ved=0ahUKEwihqu6DjvTZAhUPyWMKHQt8A80Q_AUIDCgD&biw=958&bih=929";
	   
	   assertEquals(testStr4, urlValidator.isValid(testStr4),true);
	   
	   assertEquals("https://google.com/&q=hi&date=010223&date=1234", urlValidator.isValid("https://google.com/&q=hi&date=010223&date=1234"),true);
	   assertEquals("https://www.youtube.com/watch?v=HR3xNDEP7f8", urlValidator.isValid("https://www.youtube.com/watch?v=HR3xNDEP7f8"),true);
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
	   //valid urls that dont have a query, but link directly to a document such as a pdf or an html file and use http
	   UrlValidator urlValidator = new UrlValidator();
	   assertEquals("http://www.pdf995.com/samples/pdf.pdf", urlValidator.isValid("http://www.pdf995.com/samples/pdf.pdf"),true);
	   assertEquals("http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf", urlValidator.isValid("http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf"),true);
	   assertEquals("http://www.adobe.com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf", urlValidator.isValid("http://www.adobe.com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf"),true);
	   assertEquals("http://www.example.com/index.html", urlValidator.isValid("http://www.example.com/index.html"),true);
	   assertEquals("http://www.pdf995.com/samples/pdf.pdf", urlValidator.isValid("http://www.pdf995.com/samples/pdf.pdf"),true);
	   
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   UrlValidator urlValidator = new UrlValidator();
	   //You can use this function for programming based testing
	   String[] validDomains = {"www.google.com", "www.youtube.com", "youtu.be", "10.11.12.13"};
	   String[] invalidDomains = {"gworks.fjkles", "777@777edu", "JustABunChOfChars", "&#$(@)&*@@.com", "|xXP-SLAyER6969-Xx|"
	   };
	   
	   String[] validSuffixes = { "/Index.html", "/FAQ", "/?id=007", "/About"};
	   String[] invalidSuffixes = { "@", "~~~~~~~~~~~~~~~~~~~~~~~~~~~", "\\\\\\/\\\\", ":grimacing:", "|}-{|"  };
	   
	   for(String s : validDomains) {
		   for(String b : validSuffixes) {
			   assertEquals(s + b, urlValidator.isValid(s + b),true);
		   }
		   
		   for(String b : invalidSuffixes) {
			   assertEquals(s + b, urlValidator.isValid(s + b),false);
		   }
	   }
	   
	   for(String s : invalidDomains) {
		   for(String b : validSuffixes) {
			   assertEquals(s + b, urlValidator.isValid(s + b),false);
		   }
		   
		   for(String b : invalidSuffixes) {
			   assertEquals(s + b, urlValidator.isValid(s + b),false);
		   }
	   }

   }
   
   public void randomTestIsValid()
   {
	   UrlValidator urlValidator = new UrlValidator();
	   boolean pass =true;
	   for (int i = 0; i < 200; i++ ) {
		   ResultPair testcase = UrlValidatorRandomTestProvider.getRandTestCase();
		   boolean result = urlValidator.isValid(testcase.item);
		   if (result != testcase.valid) {
			   System.out.println("FAIL: " + testcase.item);
			   System.out.println("Expected: " + testcase.valid + "  Actual: " + result);
			   pass = false;
		   } else {
			   System.out.println("\n-PASS: " + testcase.item);
		   }
		}
	   	assertEquals("Test Failed", pass, true);
   }


}
