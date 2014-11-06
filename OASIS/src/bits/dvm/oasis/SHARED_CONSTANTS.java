package bits.dvm.oasis;

public interface SHARED_CONSTANTS {
	
	public int WAIT_TIME_SPLASH_SCREEN = 2500;
	
	public int SPONSOR_EVENT_ID = 75; 
	
	public int[] mainScreenItemsList = {R.drawable.about,
										R.drawable.schedule,
										R.drawable.updates,
										R.drawable.favourites,
										R.drawable.sponsors,
										R.drawable.events,
										R.drawable.socialmedia,
										R.drawable.how_to_reach,
										R.drawable.contacts,
										R.drawable.developers};
	
	public int[] eventCategoryList =  {R.drawable.music,
									   R.drawable.art,
									   R.drawable.dance,
									   R.drawable.oratory,
									   R.drawable.event,
									   R.drawable.drama,
									   R.drawable.misc,
									   R.drawable.quizzing,
									   R.drawable.online};
	
	public int[] socialItemsList = {R.drawable.facebook,
									R.drawable.youtube,
									R.drawable.twitter,
									R.drawable.blog};
	
	
	public static final int ASCENDING = 0;
	public static final int DESCENDING = 1;
	public static final int FALSE = 0;
	public static final int TRUE = 1;
	
	public static final int DEVELOPER = FALSE;
	
	
	public static final String DATABASE_NAME = "oasis2014";
	public static final int DATABASE_VERSION = 1; 
	public static final String EVENT_CATEGORY = "event_category";
	public static final String EVENTS_EVENTNEW = "events_eventnew";
	public static final String EVENT_UPDATE = "event_update";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CATEGORY_ID = "category_id";
	public static final String CONTENT = "content";
	public static final String DATE = "date";
	public static final String TIME = "time";
	public static final String VENUE = "venue";
	public static final String ENDTIME = "endtime";
	public static final String DESCRIPTION = "description";
	public static final String ICON = "icon";
	public static final String UPDATE = "update_content";
	public static final String OPENREG = "openreg";
	public static final String SHOW_NOTIFICATION = "show_notification";
	public static final String FAVOURITE = "favourite";
	public static final String CREATE_TABLE_EVENTS_CATEGORY = "CREATE TABLE IF NOT EXISTS " +
															  EVENT_CATEGORY + "( " + 
															  ID + " int(11) NOT NULL, " +
															  NAME + " varchar(800) NOT NULL)";
	
	public static final String CREATE_TABLE_EVENTS_EVENTNEW = "CREATE TABLE IF NOT EXISTS " +
															  EVENTS_EVENTNEW + "( " +
															  ID + " int(11) NOT NULL, " + 
															  NAME + " varchar(100) NOT NULL, " + 
															  CATEGORY_ID + " int(11) NOT NULL, " + 
															  CONTENT + " varchar(2000000) NOT NULL, " +
															  DESCRIPTION + " varchar(140) NOT NULL, " + 
															  DATE + " varchar(100) NOT NULL, " + 
															  TIME + " varchar(100) NOT NULL, " + 
															  VENUE + " varchar(100) NOT NULL, " + 
															  ENDTIME + " varchar(100) NOT NULL, " + 
															  FAVOURITE + " int(1) NOT NULL)";
	
	public static final String CREATE_TABLE_UPDATES = "CREATE TABLE IF NOT EXISTS " +
													  EVENT_UPDATE + "( " + 
													  ID + " int(11) NOT NULL, " +
													  UPDATE + " varchar(80000) NOT NULL, " + 
													  SHOW_NOTIFICATION + " int(1) NOT NULL)";
													
	public static final String DROP_TABLE_EVENTS_CATEGORY = "DROP TABLE IF EXISTS " + EVENT_CATEGORY;
	public static final String DROP_TABLE_EVENTS_EVENTSNEW = "DROP TABLE IF EXISTS " + EVENTS_EVENTNEW;
	public static final String DROP_TABLE_UPDATES = "DROP TABLE IF EXISTS " + EVENT_UPDATE;
	
	
	//urls for database sync
	
	//to be removed before launching start
	
	//live
	public static final String liveUrlForEventCategoryTable = "http://bits-oasis.org/2014test/category/";
	public static final String liveUrlForEventNewTable = "http://bits-oasis.org/2014test/app/";
	public static final String liveUrlForEventUpdateTable = "http://bits-oasis.org/2014test/app/updates";
	
	//developer
	public static final String developerUrlForEventCategoryTable = "http://192.168.10.1/oasis2014/category.php";
	public static final String developerUrlForEventNewTable = "http://192.168.10.1/oasis2014/events.php";
	public static final String developerUrlForEventUpdateTable = "http://192.168.10.1/oasis2014/updates.php";
	
	public static final String urlForEventCategoryTable = "";
	public static final String urlForEventNewTable = "http://bits-oasis.org/2014test/app/";
	public static final String urlForEventUpdateTable = "http://bits-oasis.org/2014test/app/updates";
	
	//get fontpath
	public final String FONT_PATH_CORBERT = "fonts/corbert.otf";
	public final String FONT_PATH_MOJAVE = "fonts/mojave.ttf";
			
	
	public static final int NET_CONNECT_TIMEOUT_MILLIS = 15000; //15 seconds
	public static final int NET_READ_TIMEOUT_MILLIS = 10000; //10 seconds
	
    // The authority for the sync adapter's content provider
    public static final String AUTHORITY = "bits.dvm.oasis.datasync.provider";
    // An account type, in the form of a domain name
    public static final String ACCOUNT_TYPE = "www.bits-oasis.org";
    // The account name
    public static final String ACCOUNT = "dummyaccount";
    // Sync interval constants
    public static final long MILLISECONDS_PER_SECOND = 1000;
    public static final long SECONDS_PER_MINUTE = 60;
    public static final long SYNC_INTERVAL_IN_MINUTES = 5;
    public static final long SYNC_INTERVAL =SYNC_INTERVAL_IN_MINUTES * 
    		SECONDS_PER_MINUTE * MILLISECONDS_PER_SECOND;
    
    public final int notificationIcon = R.drawable.logo_icon;
    public final String notificationTitle = "Oasis 2014";
    
    //webviews
    public final String HTML_STARTER = "<html>" +
									   "<head>" +
									   "<style>" +
									   "@font-face {" +
									   "font-family: \"MyFont\";" +
									   "src: url('file:///android_asset/fonts/corbert.otf');" +
									   "}" +
									   "body{font-family:MyFont; color: #ffffff; background-color: #172E50;}" +
									   "</style>" +
									   "</head>" +
									   "<body>";
    
    public final String ABOUT_HTML = "<html>" +
    								 "<head>" +
    								 "<style>" +
    								 "@font-face {" +
    								 "font-family: \"MyFont\";" +
    								 "src: url('file:///android_asset/fonts/corbert.otf');" +
    								 "}" +
    								 "body{font-family:MyFont; color: #ffffff; background-color: #172E50;}" +
    								 "</style>" +
    								 "</head>" +
    								 "<body>" +
    								 "<center>" +
    								 "<font color=\"white\">" +
    								 "<p>How many times have you been told not to long for the past?" +
    								 "<br>How often have you been reminded to not dwell upon the " +
    								 "times that have passed?" +
    								 "<br>" +
    								 "Forget it." +
    								 "<br>" +
    								 "Move on." +
    								 "<br>" +
    								 "It's not coming back." +
    								 "<br>" +
    								 "<br>" +
    								 "That's what you hear, isn't it?" +
    								 "<br>" +
    								 "<br>" +
    								 "This year, let's prove them wrong. Let's go back to the 90s." +
    								 "<br>" +
    								 "Let nothing hold you back as you abandon all your " +
    								 "worries and revel in the glory of times long gone. Relive " +
    								 "all the colorful childhood memories of songs, shows, movies, " +
    								 "cartoons, comics and games as they fight for your attention." +
    								 "<br>" +
    								 "Gear up for 96 hours of reliving history." +
    								 "<br>" +
    								 "<br>" +
    								 "Oasis 2014" +
    								 "<br>That '90s Show" +
    								 "</p>" +
    								 "</center>" +
    								 "</font>" +
    								 "</body>" +
    								 "</html>";
    
    
    
    
    public final String EVENT_DETAILS = "<html>" +
    									"<head>" +
						 			  "<style>" +
						 			  "@font-face {" +
						 			  "font-family: \"MyFont\";" +
						 			  "src: url('file:///android_asset/fonts/corbert.otf');" +
						 			  "}" +
						 			  "body{font-family:MyFont; color: #ffffff; background-color: #172E50;}" +
						 			  "</style>" +
						 			  "</head>" +
						 			  "<body>" +
						 			  "<div id=\"oasisimg\">" +
			    					  "<img src=\"images/logo-oasis14.png\" /></div>" +
			    					  "<h1>CHOREO</h1>" +
			    					  "<div id=\"break\">&nbsp;</div>" +
			    					  "<h2>DETAILED DESCRIPTION</h2>" +
			    					  "<p><em>This not enough that ev&#39;rystander-by<br />" +
			    					  "No glaring errors in your steps can spy;<br />" +
			    					  "The dance and music must so nicely meet,<br />" +
			    					  "Each note must seem an echo to your feet;<br />" +
			    					  "A nameless grace must in each movement dwell,<br />" +
			    					  "Which words can ne&#39;er express, nor precepts tell...</em></p>" +
			    					  "<div id=\"oasisimg\">" +
			    					  "<img src=\"2014test/site_media/uploads/2014/09/19/dot2.jpeg\" /></div>" +
			    					  "<p>&nbsp;</p>" +
			    					  "<p>This year at Oasis, experience the full enigma of Choreo, " +
			    					  "where the bodily senses, mind, heart and soul all come together " +
			    					  "with utmost grace to give expression to a plethora of emotions t" +
			    					  "hat tell timeless tales as the participants cascade to the rhythm" +
			    					  " with their feather finish moves.</p>" +
			    					  "<h2>RULES</h2>" +
			    					  "<ul>" +
			    					  "	<li>Teams can have a maximum of 14 participants</li>" +
			    					  "	<li>One entry per college</li>" +
			    					  "	<li>Teams are expected to portray a theme through dance and choreography</li>" +
			    					  "	<li>Time limit of 10 minutes including write-up (curtain to curtain)." +
			    					  " Negative points for exceeding the time limit.</li>" +
			    					  "	<li>There will be an elimination round</li>" +
			    					  "<li>Folk and classical dances are not allowed</li>" +
			    					  "<li>Lyrics are not allowed in the sound track. However, a short write-" +
			    					  "up describing the theme may be read before the performance. The write-" +
			    					  "up should be in printed form.</li>" +
			    					  "<li>All props must be specified to the Coordinator of Department of Thea" +
			    					  "tre. Use of props is highly discouraged and may result in negative point" +
			    					  "s. (Any item that is not a part of clothing is a prop. Also, an item of c" +
			    					  "lothing will be considered a prop if it is moved from its initial positio" +
			    					  "n during the performance.)</li>" +
			    					  "<li>On-Stage rehearsal slots will be provided to the short listed teams. " +
			    					  "Teams are expected to use these slots for finalizing lights cues and so on.</li>" +
			    					  "	<li>Backstage helpers should not exceed 6. Two team members must be present to " +
			    					  "provide cues for music and lights.</li>" +
			    					  "	<li>Lighting of candles, matches or cigarettes on stage is no" +
			    					  "t allowed and will result in disqualification.</li>" +
			    					  "	<li>Teams are requested to have confirmed their participation i" +
			    					  "n advance via email.</li>	<li>Teams should report to the Depar" +
			    					  "tment of Theatre room immediately after registration at the Controlz booth.</li>" +
			    					  "	<li>Teams must bring 2 CDs and a pen-drive containing their sou" +
			    					  "nd track. One CD is to be submitted at the time of eliminations." +
			    					  " The soundtrack should be in .mp3 format.</li>	<li>Teams are a" +
			    					  "dvised to get their own music systems for practice</li>" +
			    					  "</ul>" +
			    					  "<h2>&nbsp;</h2>" +
			    					  "<h2>COLLABORATOR</h2>" +
			    					  "<p style=\"line-height: 20.7999992370605px;\">" +
			    					  "<strong>ELOQUENCE DANCE ACADEMY</strong></p>" +
			    					  "<p style=\"line-height: 20.7999992370605px;\">" +
			    					  "This year, Oasis ties up with the Eloquence Dance Academy, Delhi" +
			    					  " for adding spice and&nbsp;excitement to the dance events of the" +
			    					  " festival. Eloquence personnel will be joining us&nbsp;in Pilani f" +
			    					  "or judging the events Choreo and Street Dance as well to conduct t" +
			    					  "he much&nbsp;awaited Dance Workshops this time around. Eloquence p" +
			    					  "ersonnel will also be delivering a&nbsp;professional choreo perfor" +
			    					  "mance, which will surely leave the audience wanting for more.&nbsp;<br />" +
			    					  "<a href=\"http://www.sseloquence.com\" target=\"_blank\">www.sseloquence.com</a></p>" +
			    					  "<h2>REGISTRATION</h2>" +
			    					  "<p>Participants must be pre-registered.</p>" +
			    					  "<h2>CONTACT</h2>" +
			    					  "<p>Akshay Menon<br />" +
			    					  "Coordinator, Department of Theatre<br />" +
			    					  "<a href=\"mailto:amennx@gmail.com\">amennx@gmail.com</a><br />" +
			    					  "9660578919</p>" +
			    					  "</body>" +
			    					  "</html>";
    
    public final String CONTACTS_HTML = "<div id=\"oasisimg\">" +
    									"<img src=\"images/logo-oasis14.png\" /></div>" +
    									"<p> V.V. Sai Praneeth<br />" +
    									"President<br />" +
    									"Students&#39; Union<br />" +
    									"President@pilani.bits-pilani.ac.in</p>" +
    									"<p> Ashutosh Ajay Mundhada<br />" +
    									"General Secretary<br />" +
    									"Students&#39; Union<br />" +
    									"Gensec@pilani.bits-pilani.ac.in</p>" +
    									"<p> Ashfaque Ahmad Bari<br />" +
    									"Art, Design and Publicity<br />" +
    									"adp[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-8290294317</p>" +
    									"<p> Revant Gupta<br />" +
    									"Controls<br />" +
    									"controls[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-7891953382</p>" +
    									"<p> Shashvat Tripathi<br />" +
    									"Publications and Participation<br />" +
    									"pcr[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-7728807727</p>" +
    									"<p> Aishik Dhar<br />" +
    									"Sponsorship and Marketing<br />" +
    									"sponsorship[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-8058416504</p>" +
    									"<p> Himanish Ganjoo<br />" +
    									"Stage Controls<br />" +
    									"stagecontrols[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-9680901028</p>" +
    									"<p> Vinayak Krishnamurthy<br />" +
    									"Reception and Accommodation<br />" +
    									"recnacc[at]bits-oasis[dot]org<br />" +
    									"Ph : +91-9772050670</p>";
    
    public final String REACH_PILANI = "<h3>Travelling by road from Delhi</h3><div><p><div>" +
    								   "<p>Distance is 200 or 230 km depending " +
    								   "on route taken" +
    								   " and takes about 5.5 hours. There are three routes to get to " +
    								   "Pilani (in order of preference)" +
    								   " by road:</p> <p><ul><li>Delhi-Gurgaon-Dharuheda-Rewari-Mahendrag" +
    								   "arh-Loharu-Pilani " +
    								   "(220 Kms)</li><li>Delhi-Gurgaon-Dharuheda-Rewari-Narnaul-Singhana-C" +
    								   "hirawa-Pilani " +
    								   "(225 Kms)</li><li>Delhi-Rohtak-Bhiwani-Loharu-Pilani (220 Kms)</li>" +
    								   "</ul><p></p>" +
    								   "</div><p></p></div></li><li><h3 class=\"accHead\">Travelling by&nbs" +
    								   "p; Bus or Train from Delhi" +
    								   "</h3><div><p><div><p>In case you " +
    								   "prefer to travel by public transport, you need to catch a bus at th" +
    								   "e Inter State Bus " +
    								   "Terminal (ISBT), Kashmiri Gate, Delhi. There are frequent " +
    								   "buses to Pilani starting from " +
    								   "Delhi around 5:40 a.m. to 10:00 p.m. You can also take a train from " +
    								   "Sarai Rohilla Railway " +
    								   "Station in New Delhi to Loharu Station. The departure timings of trains " +
    								   "at Sarai Rohilla" +
    								   " Station are 4.50 A.M (Only on Wed/Fri/Sun)&nbsp; and 5.05 AM (Daily, " +
    								   "Starts from Delhi " +
    								   "Station at 4.50 AM). Loharu is 26 km away from Pilani. " +
    								   "Buses and jeeps are available " +
    								   "from Loharu to Pilani. The BITS campus is very close " +
    								   "to the Pilani bus stand.</p> <p>You" +
    								   " can contact the ISBT offices at the following numbers" +
    								   ":</p> <p>General Enquiry: 2968836 " +
    								   "&nbsp;</p><p>DTC Local Enquiry: 3371745 &nbsp;&nbsp" +
    								   ";<br><p>Haryana Roadways: 2961262" +
    								   " &nbsp;<br><p>Himachal Roadways: 2966725 &" +
    								   "nbsp;&nbsp;<br><p>Punjab Roadways: 2961246<br>" +
    								   "<p>Rajasthan Roadways: 22961246<br><p>U.P" +
    								   ". Roadways: 2968709</p><p></p><p></p><p></p><p>" +
    								   "</p><p></p></div><p></p></div></li" +
    								   "><li><h3>Travelling by bus from Jaipur" +
    								   "</h3><div><p><div><p>Jaipur-Chomu-" +
    								   "Ringus-Sikar-Nawalgarh-Chirawa-Pilani (220 Kms) (" +
    								   "most preferable)</p> <p>In case you " +
    								   "prefer to travel by public transport, you need to " +
    								   "catch a bus from the State Bus Terminal" +
    								   " (Sindhi Camp), Jaipur. There are frequent buses to " +
    								   "Pilani starting from Jaipur around " +
    								   "4:00 AM till mid-night.</p></div><p></p></div></li><li><h3>Travelling by " +
    								   "train from Jaipur</h3><div><p><div>" +
    								   "<p>Train are available from Jaipur to Chirawa " +
    								   "(16 km from Pilani) or Loharu (26 km from " +
    								   "Pilani).</p></div><p></p></div></li><li><" +
    								   "h3 class=\"accHead\">Private Transport (Car)</h3>" +
    								   "<div><p><div><p>The following " +
    								   "Tourist operators are familiar with the routes to " +
    								   "Pilani from either Delhi or Jaipur. " +
    								   "Interested persons may contact them directly</p> " +
    								   "<h4>From Delhi</h4> <p>Mr. Pradeep " +
    								   "Bali</p> <p>M/S Kohinoor Travels</p> <p>Mob. " +
    								   "09811166370</p> <h4>From Jaipur</h4> <p>Mr." +
    								   " Sunil</p> <p>M/S Namit Tours &amp; Travels</p> " +
    								   "<p>Mob. 09928869185&nbsp;</p></div><p></p>" +
    								   "</div></li><li><h3>How to reach Delhi/ Jaipur from Pilani</h3>" +
    								   "<div><p><div><h4>Pilani to " +
    								   "Delhi</h4><div>Buses are available almost once every hour " +
    								   "(5 AM to 5 PM) from Pilani to " +
    								   "Delhi ISBT. Night buses are also available " +
    								   "from Pilani at around 10:15 PM, 10.45 PM and " +
    								   "12:30 AM. Buses from Chirawa to Delhi (Dhaulakuan" +
    								   ", via Gurgaon) are also available almost" +
    								   " once every hour. Chirawa is 16 KM from Pilani. " +
    								   "You can also take a train from Loharu " +
    								   "station to Sarai Rohilla Railway Station in New Delhi. " +
    								   "The departure timings of trains " +
    								   "at Loharu are 02.55 PM (Runs only on Wed/Fri/Sun)&" +
    								   "nbsp; and 06.13 PM (Runs daily). Loharu " +
    								   "is 26 km away from Pilani. Buses and jeeps are " +
    								   "available from Pilani to Loharu.</div> " +
    								   "<h4>Pilani to Jaipur</h4><div>Buses are available almost " +
    								   "once every hour from either" +
    								   " Pilani or Chirawa</div></div><p></p></div></li></ul></div>";

    public final String DEVELOPER_INFORMATION = "<div id=\"oasisimg\">" +
												"<img src=\"images/logo-oasis14.png\" /></div>" +
												"<p> This application has been developed by<br />" +
												"Department of Visual Media, BITS Pilani.<br />" + 
												"All content belongs to Department of Visual Media, " +
												"BITS Pilani and usage of this content without permission may<br />" +
												" attract strict action.<br />" +
												"This is the Official mobile application for <br />" +
												"OASIS 2014 and any other application claiming this status " +
												"may <br /> attract strict action. "; 
			;
    
    
    
}
