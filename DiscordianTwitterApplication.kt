import javax.swing.*
import java.awt.Insets
import java.awt.event.*
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

class fen : JFrame {
	constructor () : super() {
		this.setSize(400, 400)
		this.setLocationRelativeTo(null)
		this.setDefaultCloseOperation(EXIT_ON_CLOSE)
		this.setLayout(null)
		this.setTitle("TwitterEris for Kotlin")
		this.setResizable(false)

		var consumerKey = JLabel()
		consumerKey.setBounds(10, 10, 150, 30)
		consumerKey.setText("ConsumerKey")
		this.add(consumerKey)
		
		var tfCK = JTextField()
		tfCK.setBounds(170, 10, 200, 30)
		this.add(tfCK)
		
		var consumerSecret = JLabel()
		consumerSecret.setBounds(10, 50, 150, 30)
		consumerSecret.setText("ConsumerSecret")
		this.add(consumerSecret)
		
		var tfCS = JTextField()
		tfCS.setBounds(170, 50, 200, 30)
		this.add(tfCS)
		
		var accessToken = JLabel()
		accessToken.setBounds(10, 90, 150, 30)
		accessToken.setText("AccessToken")
		this.add(accessToken)
		
		var tfAT = JTextField()
		tfAT.setBounds(170, 90, 200, 30)
		this.add(tfAT)
		
		var accessTokenSecret = JLabel()
		accessTokenSecret.setBounds(10, 130, 150, 30)
		accessTokenSecret.setText("AccessTokenSecret")
		this.add(accessTokenSecret)
		
		var tfATS = JTextField()
		tfATS.setBounds(170, 130, 200, 30)
		this.add(tfATS)
		
		var btnTwitter = JButton("twitter")
		btnTwitter.setBounds(170, 170, 100, 30)
		btnTwitter.setMargin(Insets(0, 0, 0, 0))
		btnTwitter.addActionListener {
			var config = ConfigurationBuilder()
			config.setOAuthConsumerKey(tfCK.getText()).setOAuthConsumerSecret(tfCS.getText()).setOAuthAccessToken(tfAT.getText()).setOAuthAccessTokenSecret(tfATS.getText())
			var tf = TwitterFactory(config.build())
			var twitter = tf.getInstance()
			var ddate = DiscordianDate.now()
			twitter?.updateStatus(String.format("Today is %s, %s %d, YOLD %d", ddate.dayName, ddate.seasonName, ddate.seasonDay, ddate.year))
		}
		this.add(btnTwitter)
		
		this.setVisible(true)
	}
}

fun main(args: Array<String>) {
	fen()
}