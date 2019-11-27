package com.zhoucai;




import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class main {

	public static void main(String[] args) throws TwitterException, IOException  {
		// TODO Auto-generated method stub
		
	
		
		
		Properties p = new Properties();
		
		InputStream is = new FileInputStream("/Users/zhoucai/eclipse-workspace/api_files/twitter4j.properties");
		p.load(is);
		
		System.out.println(p.getProperty("oauth.consumerKey"));
		
		String consumer = p.getProperty("oauth.consumerKey");
		String consumerSecret = p.getProperty("oauth.consumerSecret");
		
		String access = p.getProperty("oauth.accessToken");
		String accessSecret = p.getProperty("oauth.accessTokenSecret");
		
		Twitter zucchiniMk1= new TwitterFactory().getInstance();
		zucchiniMk1.setOAuthConsumer(consumer, consumerSecret);
		zucchiniMk1.setOAuthAccessToken(new AccessToken(access, accessSecret));
		
		//Status status = zucchiniMk1.updateStatus("late night testing");
		//System.out.println(status.getText());
		
		//DirectMessage message = zucchiniMk1.sendDirectMessage("@", "are you seriously watching porn by yourself?");
		//System.out.println(message.getText());
		
				
		
		try {
            Query query = new Query("flu");  
            QueryResult result;
            result = zucchiniMk1.search(query);   
            List<Status> tweets = result.getTweets();  // arraylist of status
            for (Status tweet : tweets) {        // for loop
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
            
        }
		
	}
	
	
	
	

}
