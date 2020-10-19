import org.scalatest.matchers.should
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.concurrent.Eventually._
import org.scalatestplus.selenium._
//import org.scalatest.Suite

class FirefoxSpec extends AnyFlatSpec with should.Matchers with Firefox {

  "The driver" should "call Google" in {
    
    go to "http://www.google.com"
    click on "q"
    textField("q").value = "Cheese!"
    submit()
    // Google's search is rendered dynamically with JavaScript.
    eventually { pageTitle should be ("Cheese! - Google Search") } 
  }
}

class ChromeSpec extends AnyFlatSpec with should.Matchers with Chrome {
  "The driver" should "call Google" in {
  
    go to "http://www.google.com"
    click on "q"
    textField("q").value = "Cheese!"
    submit()
    // Google's search is rendered dynamically with JavaScript.
    eventually { pageTitle should be ("Cheese! - Google Search") } 
  }
}