case class PhonemicString(strt: String):
	var xSampa = List(List("@","ə"),List("E","ɛ")) 
    	// List(List("A", "ɑ"), List("@", "ə"), List("E", "ɛ"), List("ae", "æ"), List("I", "ɪ"), List("i", "i"), List("O", "ɔ"), List("o", "o"), List("U", "ʊ"), List("u", "u"), List("3", "ɜ"), List("6", "ɐ"), List("7", "ɨ"), List("8", "ɵ"), List("9", "ɘ"), List("&", "æ"), List("@`", "ɚ"))
	def =~(newStr: PhonemicString) = (strt == newStr.strt)

given Conversion[String,PhonemicString] = n => PhonemicString(n)

//var d = \hE:loU\

var g = "he"

PhonemicString("he") =~ g


//in progress loop strucure
def loop_each_word (word: => String) (sentence: => String) (body: => Unit) =
	val arr = sentence.split("[ -]")
	for(word <- arr){
  		body
  	}

loop_each_word (w) ("hE:lo-hE:loU-hE:loU") {
	println(w)
}


//-------------------------------
// unorderedString -- the characters in the string are not ordered, per say. 


case class unorderedString(strt: String):

	var strArr = (strt.toCharArray()).sorted
	var strArrDist = strArr.distinct

	override def toString = strArr.mkString("")

	def ~~(newStr: unorderedString) = (strArr.sameElements(newStr.strArr))
	def ~~=(newStr: unorderedString) = (strArrDist.sameElements(newStr.strArrDist))

	def ⊆(newStr: unorderedString) = (strArrDist.diff(newStr.strArrDist).isEmpty)
	def ⊇(newStr: unorderedString) = ((newStr.strArrDist).diff(strArrDist).isEmpty)


given Conversion[String,unorderedString] = n => unorderedString(n)
given Conversion[unorderedString, String] = n => n.toString


var g2 = "i am lord voldemort"
var g3 = "i amd lordvv volodemort lloaer "
var us1 = "tom marvolo riddle "
var us2 = unorderedString("tik")

us1 ~~ g2
us1 ~~= g2
us1 ~~ g3
us1 ~~= g3

"tik" ⊆ "keith"
us1 ⊆ " qwertyuiopasdfghjklzxcvbnm"


us2 = us1 + us2
us2

us1.length()




var g2 = "i am lord voldemort"
var us1 = unorderedString("tom marvolo riddle ")
us1 ~~ g2


