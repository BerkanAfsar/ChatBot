package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import twitter4j.*;
import twitter4j.Status;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter {
	
	private String Hashtag;
	private String TweetText;
	private Double Point;
	
	public String getHashtag() {
		return Hashtag;
	}

	public void setHashtag(String Hashtag) {
		this.Hashtag = Hashtag;
	}

	public String getTweetText() {
		return TweetText;
	}

	public void setTweetText(String TweetText) {
		this.TweetText = TweetText;
	}
	
	public double getPoint() {
		return Point;
	}
	
	public void setPprice(double Point) {
		this.Point = Point;
	}

	public String toString() {
		return " Hashtag=" + Hashtag + ", TweetText=" + TweetText + ", Point =" + Point;
	}
	
	public static void main(String[] args) throws TwitterException, IOException{
// TODO Auto-generated method stub
	}

	public void getTweet(String isim) throws IOException{	
	
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true)
		.setOAuthConsumerKey("dzgasy3EEnkdIEgwA1S9aQiZ5")
		.setOAuthConsumerSecret("lbRmPtFOO9w7iRhf0ANbowklqYpQDZWK8gQpJoswSEwjZuqyn1")
		.setOAuthAccessToken("631301237-0QdmgK7yBepZJ4iHJ3XwW6y9fqoJwe5Bble1kUjd")
		.setOAuthAccessTokenSecret("Yt3w2HW0zgawzLCdP58kQYtVN4mfIEfWLSziv7yeD1WWh");
		TwitterFactory tf = new TwitterFactory(cf.build());
		twitter4j.Twitter twitter = tf.getInstance();
		String gidenTweet ;
		
		File f = new File(isim+".txt");

		FileWriter fw =new FileWriter(f);

		BufferedWriter yaz = new BufferedWriter(fw);	
	
		try {
			Query query = new Query(isim);
			query.setCount(20);
			QueryResult result;
        
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();
			for (Status tweet : tweets) {
            if(tweet.getLang().equals("en") ) {
            	gidenTweet=tweet.getText();
            	yaz.append(gidenTweet);
            	yaz.newLine();
            	
            }
            }
            yaz.flush();
            yaz.close();
                 
       // System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
			}	
	}
}