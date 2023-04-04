case class PhonemicString(strt: String):
	var xSampa = List(List("@","ə"),List("E","ɛ")) 
    // List(List("A", "ɑ"), List("a", "æ"), List("@", "ə"), List("E", "ɛ"), List("I", "ɪ"), List("i", "i"), List("O", "ɔ"), List("o", "o"), List("U", "ʊ"), List("u", "u"), List("3", "ɜ"), List("6", "ɐ"), List("7", "ɨ"), List("8", "ɵ"), List("9", "ɘ"), List("&", "æ"), List("@`", "ɚ"))
	def =~(newStr: PhonemicString) = (strt == newStr.strt)

given Conversion[String,PhonemicString] = n => PhonemicString(n)

//var d = \hE:loU\

var g = "he"

PhonemicString("he") =~ g


//in progress loop strucure
def loop_each_word (sentence: => String) (body: => Unit) =
	val arr = sentence.split("[ -]")
	for(word <- arr){
  		body
  	}


//-------------------------------
// unorderedString -- the characters in the string are not ordered, per say. 
case class unorderedString(strt: String):
	var strArr = (strt.toCharArray()).sorted
	override def toString = strArr.mkString("")
	def ~~(newStr: unorderedString) = (strArr.sameElements(newStr.strArr))

given Conversion[String,unorderedString] = n => unorderedString(n)

var g2 = "i am lord voldemort"
var us1 = unorderedString("tom marvolo riddle ")
us1 ~~ g2
