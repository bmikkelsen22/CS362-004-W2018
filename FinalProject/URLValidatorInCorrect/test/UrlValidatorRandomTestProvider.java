import java.util.Random;


public class UrlValidatorRandomTestProvider {
	private static Random rand = new Random();
	
	public static ResultPair getRandTestCase(){
		ResultPair scheme = getRandomScheme();
		ResultPair url = getRandomURL();
		ResultPair port = getRandomPort();
		ResultPair path = getRandomPath();
		ResultPair optionPath = getRandomOptionPath();
		ResultPair query = getRandomQuery();
		String testcase = "";
	    boolean expectedResult;
	    if (rand.nextInt(2)==0) {
	    	testcase = scheme.item + url.item + port.item + path.item + query.item;
	    	expectedResult = scheme.valid && url.valid && port.valid && path.valid && query.valid;
	    }
	    else{
	    	testcase = scheme.item + url.item + port.item + optionPath.item + query.item;
	    	expectedResult = scheme.valid && url.valid && port.valid && optionPath.valid && query.valid;
	    }
	    return new ResultPair(testcase,expectedResult);
	  }
	  
	  public static ResultPair getRandomScheme(){
		  ResultPair[] testUrlScheme = {new ResultPair("http://", true),
	                               		new ResultPair("ftp://", true),
		                               new ResultPair("h3t://", true),
		                               new ResultPair("3ht://", false),
		                               new ResultPair("http:/", false),
		                               new ResultPair("http:", false),
		                               new ResultPair("http/", false),
		                               new ResultPair("://", false),
		                               new ResultPair("", true)
		  };  
	    return testUrlScheme[rand.nextInt(testUrlScheme.length)];                      
	  }

	  public static ResultPair getRandomURL(){
	      ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
	                                  new ResultPair("go.com", true),
	                                  new ResultPair("go.au", true),
	                                  new ResultPair("0.0.0.0", true),
	                                  new ResultPair("255.255.255.255", true),
	                                  new ResultPair("256.256.256.256", false),
	                                  new ResultPair("255.com", true),
	                                  new ResultPair("1.2.3.4.5", false),
	                                  new ResultPair("1.2.3.4.", false),
	                                  new ResultPair("1.2.3", false),
	                                  new ResultPair(".1.2.3.4", false),
	                                  new ResultPair("go.a", false),
	                                  new ResultPair("go.a1a", false),
	                                  new ResultPair("go.1aa", false),
	                                  new ResultPair("aaa.", false),
	                                  new ResultPair(".aaa", false),
	                                  new ResultPair("aaa", false),
	                                  new ResultPair("", false)
	    };                              
	    return testUrlAuthority[rand.nextInt(testUrlAuthority.length)];  
	  }   

	  public static ResultPair getRandomPort(){
	    ResultPair[] testUrlPort = {new ResultPair(":80", true),
	                             new ResultPair(":65535", true),
	                             new ResultPair(":0", true),
	                             new ResultPair("", true),
	                             new ResultPair(":-1", false),
	                            new ResultPair(":65636",false),
	                             new ResultPair(":65a", false)
	   };
	   return testUrlPort[rand.nextInt(testUrlPort.length)];  
	  }

	  public static ResultPair getRandomPath(){
	    ResultPair[] testPath = {new ResultPair("/test1", true),
	                          new ResultPair("/t123", true),
	                          new ResultPair("/$23", true),
	                          new ResultPair("/..", false),
	                          new ResultPair("/../", false),
	                          new ResultPair("/test1/", true),
	                          new ResultPair("", true),
	                          new ResultPair("/test1/file", true),
	                          new ResultPair("/..//file", false),
	                          new ResultPair("/test1//file", false)
	   };
	   return testPath[rand.nextInt(testPath.length)];  
	  }

	  public static ResultPair getRandomOptionPath(){
	    ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
	                                    new ResultPair("/t123", true),
	                                    new ResultPair("/$23", true),
	                                    new ResultPair("/..", false),
	                                    new ResultPair("/../", false),
	                                    new ResultPair("/test1/", true),
	                                    new ResultPair("/#", false),
	                                    new ResultPair("", true),
	                                    new ResultPair("/test1/file", true),
	                                    new ResultPair("/t123/file", true),
	                                    new ResultPair("/$23/file", true),
	                                    new ResultPair("/../file", false),
	                                    new ResultPair("/..//file", false),
	                                    new ResultPair("/test1//file", true),
	                                    new ResultPair("/#/file", false)
	   };
	   return testUrlPathOptions[rand.nextInt(testUrlPathOptions.length)];  
	  }

	  public static ResultPair getRandomQuery(){
	      ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
	                              new ResultPair("?action=edit&mode=up", true),
	                              new ResultPair("", true)
	      };
	      return testUrlQuery[rand.nextInt(testUrlQuery.length)];  
	  }
}
